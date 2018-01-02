package modeling.domains

import grails.gorm.services.Service

@Service(Evaluation)
interface EvaluationService {

    Evaluation get(Serializable id)

    List<Evaluation> list(Map args)

    Long count()

    void delete(Serializable id)

    Evaluation save(Evaluation evaluation)

}