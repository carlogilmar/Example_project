package modeling.domains

import grails.gorm.services.Service

@Service(EvaluationRecord)
interface EvaluationRecordService {

    EvaluationRecord get(Serializable id)

    List<EvaluationRecord> list(Map args)

    Long count()

    void delete(Serializable id)

    EvaluationRecord save(EvaluationRecord evaluationRecord)

}