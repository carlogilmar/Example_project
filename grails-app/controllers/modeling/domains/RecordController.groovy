package modeling.domains

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RecordController {

    RecordService recordService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond recordService.list(params), model:[recordCount: recordService.count()]
    }

    def show(Long id) {
        respond recordService.get(id)
    }

    def create() {
        respond new Record(params)
    }

    def save(Record record) {
        if (record == null) {
            notFound()
            return
        }

        try {
            recordService.save(record)
        } catch (ValidationException e) {
            respond record.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'record.label', default: 'Record'), record.id])
                redirect record
            }
            '*' { respond record, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond recordService.get(id)
    }

    def update(Record record) {
        if (record == null) {
            notFound()
            return
        }

        try {
            recordService.save(record)
        } catch (ValidationException e) {
            respond record.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'record.label', default: 'Record'), record.id])
                redirect record
            }
            '*'{ respond record, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        recordService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'record.label', default: 'Record'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'record.label', default: 'Record'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
