package pl.edu.amu.wmi.reval.task.filter;

public class TaskRequestParameters {
    private int subjectId;
    private int topicId;

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
}
