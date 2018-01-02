package modeling.domains

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EvaluationRecordController {

    EvaluationRecordService evaluationRecordService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond evaluationRecordService.list(params), model:[evaluationRecordCount: evaluationRecordService.count()]
    }

    def show(Long id) {
        respond evaluationRecordService.get(id)
    }

    def create() {
        respond new EvaluationRecord(params)
    }

    def save(EvaluationRecord evaluationRecord) {
        if (evaluationRecord == null) {
            notFound()
            return
        }

        try {
            evaluationRecordService.save(evaluationRecord)
        } catch (ValidationException e) {
            respond evaluationRecord.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'evaluationRecord.label', default: 'EvaluationRecord'), evaluationRecord.id])
                redirect evaluationRecord
            }
            '*' { respond evaluationRecord, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond evaluationRecordService.get(id)
    }

    def update(EvaluationRecord evaluationRecord) {
        if (evaluationRecord == null) {
            notFound()
            return
        }

        try {
            evaluationRecordService.save(evaluationRecord)
        } catch (ValidationException e) {
            respond evaluationRecord.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'evaluationRecord.label', default: 'EvaluationRecord'), evaluationRecord.id])
                redirect evaluationRecord
            }
            '*'{ respond evaluationRecord, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        evaluationRecordService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'evaluationRecord.label', default: 'EvaluationRecord'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'evaluationRecord.label', default: 'EvaluationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
