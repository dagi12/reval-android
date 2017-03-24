package pl.edu.amu.wmi.reval.question.filter;

public class QuestionRequestParameters {
    private Integer subjectId;
    private Integer topicId;

    public QuestionRequestParameters() {
        // retrofit need
    }

    public QuestionRequestParameters(int parameters) {
        this.topicId = parameters;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }
}
