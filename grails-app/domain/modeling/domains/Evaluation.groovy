package modeling.domains

class Evaluation {

    String title
    Date dateCreated
    static hasMany = [skillTests: SkillTest]

    static constraints = {
    }
}
