package modeling.domains

import grails.gorm.services.Service

@Service(SkillTest)
interface SkillTestService {

    SkillTest get(Serializable id)

    List<SkillTest> list(Map args)

    Long count()

    void delete(Serializable id)

    SkillTest save(SkillTest skillTest)

}