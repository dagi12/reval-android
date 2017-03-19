package pl.edu.amu.wmi.reval.question;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.answer.Answer;
import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;
import pl.edu.amu.wmi.reval.question.filter.QuestionRequestParameters;
import pl.edu.amu.wmi.reval.subject.Subject;
import pl.edu.amu.wmi.reval.topic.Topic;

public class Question extends AbstractRevalItem implements Serializable {

    private String questionText;
    private String title;

    @SerializedName("pub_date")
    private Date lastActivityDate;

    private Topic topic;
    private Subject subject;
    private Answer answer;
    private int maxPoints;

    public Question(QuestionRequestParameters parameters, String questionContent) {
        super();
        this.topic = new Topic(parameters.getTopicId());
        this.subject = new Subject(parameters.getSubjectId());
        this.questionText = questionContent;
    }

    public Question(int id, String title, String questionText, Date lastActivityDate) {
        super(id);
        this.title = title;
        this.questionText = questionText;
        this.lastActivityDate = lastActivityDate;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getQuestionContent() {
        return questionText;
    }

    public String getSubjectName() {
        return subject.getName();
    }

    public String getTopicName() {
        return topic.getName();
    }

    public String getQuestionTitle() {
        return title;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
