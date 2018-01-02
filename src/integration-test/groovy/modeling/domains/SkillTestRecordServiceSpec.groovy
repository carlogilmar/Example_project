package modeling.domains

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SkillTestRecordServiceSpec extends Specification {

    SkillTestRecordService skillTestRecordService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SkillTestRecord(...).save(flush: true, failOnError: true)
        //new SkillTestRecord(...).save(flush: true, failOnError: true)
        //SkillTestRecord skillTestRecord = new SkillTestRecord(...).save(flush: true, failOnError: true)
        //new SkillTestRecord(...).save(flush: true, failOnError: true)
        //new SkillTestRecord(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //skillTestRecord.id
    }

    void "test get"() {
        setupData()

        expect:
        skillTestRecordService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SkillTestRecord> skillTestRecordList = skillTestRecordService.list(max: 2, offset: 2)

        then:
        skillTestRecordList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        skillTestRecordService.count() == 5
    }

    void "test delete"() {
        Long skillTestRecordId = setupData()

        expect:
        skillTestRecordService.count() == 5

        when:
        skillTestRecordService.delete(skillTestRecordId)
        sessionFactory.currentSession.flush()

        then:
        skillTestRecordService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SkillTestRecord skillTestRecord = new SkillTestRecord()
        skillTestRecordService.save(skillTestRecord)

        then:
        skillTestRecord.id != null
    }
}
