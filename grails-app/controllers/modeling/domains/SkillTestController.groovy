package modeling.domains

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SkillTestController {

    SkillTestService skillTestService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond skillTestService.list(params), model:[skillTestCount: skillTestService.count()]
    }

    def show(Long id) {
        respond skillTestService.get(id)
    }

    def create() {
        respond new SkillTest(params)
    }

    def save(SkillTest skillTest) {
        if (skillTest == null) {
            notFound()
            return
        }

        try {
            skillTestService.save(skillTest)
        } catch (ValidationException e) {
            respond skillTest.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'skillTest.label', default: 'SkillTest'), skillTest.id])
                redirect skillTest
            }
            '*' { respond skillTest, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond skillTestService.get(id)
    }

    def update(SkillTest skillTest) {
        if (skillTest == null) {
            notFound()
            return
        }

        try {
            skillTestService.save(skillTest)
        } catch (ValidationException e) {
            respond skillTest.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'skillTest.label', default: 'SkillTest'), skillTest.id])
                redirect skillTest
            }
            '*'{ respond skillTest, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        skillTestService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'skillTest.label', default: 'SkillTest'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillTest.label', default: 'SkillTest'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
