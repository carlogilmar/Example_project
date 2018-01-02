package modeling.domains

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EvaluationServiceSpec extends Specification {

    EvaluationService evaluationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Evaluation(...).save(flush: true, failOnError: true)
        //new Evaluation(...).save(flush: true, failOnError: true)
        //Evaluation evaluation = new Evaluation(...).save(flush: true, failOnError: true)
        //new Evaluation(...).save(flush: true, failOnError: true)
        //new Evaluation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //evaluation.id
    }

    void "test get"() {
        setupData()

        expect:
        evaluationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Evaluation> evaluationList = evaluationService.list(max: 2, offset: 2)

        then:
        evaluationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        evaluationService.count() == 5
    }

    void "test delete"() {
        Long evaluationId = setupData()

        expect:
        evaluationService.count() == 5

        when:
        evaluationService.delete(evaluationId)
        sessionFactory.currentSession.flush()

        then:
        evaluationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Evaluation evaluation = new Evaluation()
        evaluationService.save(evaluation)

        then:
        evaluation.id != null
    }
}
