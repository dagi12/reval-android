package pl.edu.amu.wmi.reval.question.filter;

import pl.edu.amu.wmi.reval.subject.Subject;
import pl.edu.amu.wmi.reval.topic.Topic;

public class QuestionRequestParameters {
    private Subject subject;
    private Topic topic;

    public QuestionRequestParameters() {
        // retrofit need
    }

    public Integer getTopicId() {
        return topic.getId();
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Integer getSubjectId() {

        return subject.getId();
    }
}
