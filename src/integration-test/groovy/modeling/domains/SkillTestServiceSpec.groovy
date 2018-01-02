package modeling.domains

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SkillTestServiceSpec extends Specification {

    SkillTestService skillTestService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SkillTest(...).save(flush: true, failOnError: true)
        //new SkillTest(...).save(flush: true, failOnError: true)
        //SkillTest skillTest = new SkillTest(...).save(flush: true, failOnError: true)
        //new SkillTest(...).save(flush: true, failOnError: true)
        //new SkillTest(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //skillTest.id
    }

    void "test get"() {
        setupData()

        expect:
        skillTestService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SkillTest> skillTestList = skillTestService.list(max: 2, offset: 2)

        then:
        skillTestList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        skillTestService.count() == 5
    }

    void "test delete"() {
        Long skillTestId = setupData()

        expect:
        skillTestService.count() == 5

        when:
        skillTestService.delete(skillTestId)
        sessionFactory.currentSession.flush()

        then:
        skillTestService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SkillTest skillTest = new SkillTest()
        skillTestService.save(skillTest)

        then:
        skillTest.id != null
    }
}
