package modeling.domains

class Answer {

    String level
    String feedback
    static hasMany = [learningResources : LearningResource]
    static belongsTo = [skillTest : SkillTest]

    static constraints = {
    }
}
