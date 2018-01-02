package modeling.domains

class SkillTestRecord {

    static belongsTo = [ answer : Answer ]
    Date dateCreated

    static constraints = {
    }
}
