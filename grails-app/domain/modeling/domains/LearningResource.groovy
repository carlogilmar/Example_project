package modeling.domains

class LearningResource {

    static belongsTo = [answer : Answer]
    String description
    String url
    String reference

    static constraints = {
    }
}
