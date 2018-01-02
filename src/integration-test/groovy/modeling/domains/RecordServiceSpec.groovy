package modeling.domains

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RecordServiceSpec extends Specification {

    RecordService recordService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Record(...).save(flush: true, failOnError: true)
        //new Record(...).save(flush: true, failOnError: true)
        //Record record = new Record(...).save(flush: true, failOnError: true)
        //new Record(...).save(flush: true, failOnError: true)
        //new Record(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //record.id
    }

    void "test get"() {
        setupData()

        expect:
        recordService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Record> recordList = recordService.list(max: 2, offset: 2)

        then:
        recordList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        recordService.count() == 5
    }

    void "test delete"() {
        Long recordId = setupData()

        expect:
        recordService.count() == 5

        when:
        recordService.delete(recordId)
        sessionFactory.currentSession.flush()

        then:
        recordService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Record record = new Record()
        recordService.save(record)

        then:
        record.id != null
    }
}
