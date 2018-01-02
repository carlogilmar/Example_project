package modeling.domains

class SkillTest {

    String skill
    String description
    String scenario
    static hasMany= [answers: Answer]
    static belongsTo = [evaluation: Evaluation]

    static constraints = {
    }
}
