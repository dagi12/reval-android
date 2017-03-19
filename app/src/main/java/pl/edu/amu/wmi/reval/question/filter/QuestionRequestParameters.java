package pl.edu.amu.wmi.reval.question.filter;

public class QuestionRequestParameters {
    private int subjectId;
    private int topicId;

    public QuestionRequestParameters() {
        // retrofit need
    }

    public QuestionRequestParameters(int parameters) {
        this.topicId = parameters;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
