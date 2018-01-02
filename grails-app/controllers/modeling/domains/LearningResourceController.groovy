package modeling.domains

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LearningResourceController {

    LearningResourceService learningResourceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond learningResourceService.list(params), model:[learningResourceCount: learningResourceService.count()]
    }

    def show(Long id) {
        respond learningResourceService.get(id)
    }

    def create() {
        respond new LearningResource(params)
    }

    def save(LearningResource learningResource) {
        if (learningResource == null) {
            notFound()
            return
        }

        try {
            learningResourceService.save(learningResource)
        } catch (ValidationException e) {
            respond learningResource.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'learningResource.label', default: 'LearningResource'), learningResource.id])
                redirect learningResource
            }
            '*' { respond learningResource, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond learningResourceService.get(id)
    }

    def update(LearningResource learningResource) {
        if (learningResource == null) {
            notFound()
            return
        }

        try {
            learningResourceService.save(learningResource)
        } catch (ValidationException e) {
            respond learningResource.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'learningResource.label', default: 'LearningResource'), learningResource.id])
                redirect learningResource
            }
            '*'{ respond learningResource, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        learningResourceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'learningResource.label', default: 'LearningResource'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'learningResource.label', default: 'LearningResource'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
