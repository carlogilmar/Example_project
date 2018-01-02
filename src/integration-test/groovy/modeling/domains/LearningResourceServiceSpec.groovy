package modeling.domains

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LearningResourceServiceSpec extends Specification {

    LearningResourceService learningResourceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new LearningResource(...).save(flush: true, failOnError: true)
        //new LearningResource(...).save(flush: true, failOnError: true)
        //LearningResource learningResource = new LearningResource(...).save(flush: true, failOnError: true)
        //new LearningResource(...).save(flush: true, failOnError: true)
        //new LearningResource(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //learningResource.id
    }

    void "test get"() {
        setupData()

        expect:
        learningResourceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<LearningResource> learningResourceList = learningResourceService.list(max: 2, offset: 2)

        then:
        learningResourceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        learningResourceService.count() == 5
    }

    void "test delete"() {
        Long learningResourceId = setupData()

        expect:
        learningResourceService.count() == 5

        when:
        learningResourceService.delete(learningResourceId)
        sessionFactory.currentSession.flush()

        then:
        learningResourceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        LearningResource learningResource = new LearningResource()
        learningResourceService.save(learningResource)

        then:
        learningResource.id != null
    }
}
