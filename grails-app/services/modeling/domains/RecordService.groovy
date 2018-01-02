package modeling.domains

import grails.gorm.services.Service

@Service(Record)
interface RecordService {

    Record get(Serializable id)

    List<Record> list(Map args)

    Long count()

    void delete(Serializable id)

    Record save(Record record)

}