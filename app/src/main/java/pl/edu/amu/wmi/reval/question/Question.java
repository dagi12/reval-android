package pl.edu.amu.wmi.reval.question;

import com.google.gson.annotations.Expose;
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
    private Answer answer;

    @SerializedName("pub_date")
    private Date lastActivityDate;

    @Expose(deserialize = false)
    private int topicId;

    @Expose(deserialize = false)
    private int subjectId;

    @Expose(serialize = false)
    private Topic topic;

    private int maxPoints;

    public Question(QuestionRequestParameters parameters, String questionContent) {
        super();
        this.topicId = parameters.getTopicId();
        this.subjectId = parameters.getSubjectId();
        this.questionText = questionContent;
    }

    public Question(int id, String title, String questionText, Date lastActivityDate, Topic topic) {
        super(id);
        this.title = title;
        this.questionText = questionText;
        this.lastActivityDate = lastActivityDate;
        this.topic = topic;
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
        if (topic != null) {
            Subject subject = topic.getSubject();
            if (subject != null) {
                return subject.getName();
            }
        }
        return null;
    }

    public String getTopicName() {
        return topic.getName();
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
