package modeling.domains

import grails.gorm.services.Service

@Service(LearningResource)
interface LearningResourceService {

    LearningResource get(Serializable id)

    List<LearningResource> list(Map args)

    Long count()

    void delete(Serializable id)

    LearningResource save(LearningResource learningResource)

}