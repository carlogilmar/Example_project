package modeling.domains

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SkillTestRecordController {

    SkillTestRecordService skillTestRecordService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond skillTestRecordService.list(params), model:[skillTestRecordCount: skillTestRecordService.count()]
    }

    def show(Long id) {
        respond skillTestRecordService.get(id)
    }

    def create() {
        respond new SkillTestRecord(params)
    }

    def save(SkillTestRecord skillTestRecord) {
        if (skillTestRecord == null) {
            notFound()
            return
        }

        try {
            skillTestRecordService.save(skillTestRecord)
        } catch (ValidationException e) {
            respond skillTestRecord.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'skillTestRecord.label', default: 'SkillTestRecord'), skillTestRecord.id])
                redirect skillTestRecord
            }
            '*' { respond skillTestRecord, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond skillTestRecordService.get(id)
    }

    def update(SkillTestRecord skillTestRecord) {
        if (skillTestRecord == null) {
            notFound()
            return
        }

        try {
            skillTestRecordService.save(skillTestRecord)
        } catch (ValidationException e) {
            respond skillTestRecord.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'skillTestRecord.label', default: 'SkillTestRecord'), skillTestRecord.id])
                redirect skillTestRecord
            }
            '*'{ respond skillTestRecord, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        skillTestRecordService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'skillTestRecord.label', default: 'SkillTestRecord'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'skillTestRecord.label', default: 'SkillTestRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
