package modeling.domains

class EvaluationRecord {

    String user
    static belongsTo = [evaluation : Evaluation]
    static hasMany = [skillTestRecord : SkillTestRecord]

    static constraints = {
    }
}
