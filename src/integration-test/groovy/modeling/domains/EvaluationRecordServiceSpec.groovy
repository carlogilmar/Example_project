package modeling.domains

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EvaluationRecordServiceSpec extends Specification {

    EvaluationRecordService evaluationRecordService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new EvaluationRecord(...).save(flush: true, failOnError: true)
        //new EvaluationRecord(...).save(flush: true, failOnError: true)
        //EvaluationRecord evaluationRecord = new EvaluationRecord(...).save(flush: true, failOnError: true)
        //new EvaluationRecord(...).save(flush: true, failOnError: true)
        //new EvaluationRecord(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //evaluationRecord.id
    }

    void "test get"() {
        setupData()

        expect:
        evaluationRecordService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<EvaluationRecord> evaluationRecordList = evaluationRecordService.list(max: 2, offset: 2)

        then:
        evaluationRecordList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        evaluationRecordService.count() == 5
    }

    void "test delete"() {
        Long evaluationRecordId = setupData()

        expect:
        evaluationRecordService.count() == 5

        when:
        evaluationRecordService.delete(evaluationRecordId)
        sessionFactory.currentSession.flush()

        then:
        evaluationRecordService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        EvaluationRecord evaluationRecord = new EvaluationRecord()
        evaluationRecordService.save(evaluationRecord)

        then:
        evaluationRecord.id != null
    }
}
