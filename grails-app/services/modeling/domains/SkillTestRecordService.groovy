package modeling.domains

import grails.gorm.services.Service

@Service(SkillTestRecord)
interface SkillTestRecordService {

    SkillTestRecord get(Serializable id)

    List<SkillTestRecord> list(Map args)

    Long count()

    void delete(Serializable id)

    SkillTestRecord save(SkillTestRecord skillTestRecord)

}