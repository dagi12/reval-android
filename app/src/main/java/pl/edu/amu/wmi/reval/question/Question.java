package pl.edu.amu.wmi.reval.question;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;
import pl.edu.amu.wmi.reval.subject.Subject;
import pl.edu.amu.wmi.reval.topic.Topic;

public class Question extends AbstractRevalItem implements Serializable {

    private static final String SUCCESS_MESSAGE = "created";
    private String questionText;
    private String title;
    private Boolean answered;

    @Expose(serialize = false)
    private Integer questionId;

    @Expose(serialize = false)
    private String status;

    @SerializedName("pub_date")
    private Date lastActivityDate;

    @Expose(deserialize = false)
    private int topicId;

    @Expose(deserialize = false)
    private int subjectId;

    @Expose(serialize = false)
    private Topic topic;

    private int maxPoints;

    public Question(Topic parameters, String questionText) {
        super();
        this.topic = parameters;
        this.topicId = parameters.getId();
        this.subjectId = parameters.getSubjectId();
        this.questionText = questionText;
    }

    public Question(int id, String title, String questionText, Date lastActivityDate, Topic topic) {
        super(id);
        this.title = title;
        this.questionText = questionText;
        this.lastActivityDate = lastActivityDate;
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    int getMaxPoints() {
        return maxPoints;
    }

    Date getLastActivityDate() {
        return lastActivityDate;
    }

    void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getQuestionText() {
        return questionText;
    }

    String getSubjectName() {
        if (topic != null) {
            Subject subject = topic.getSubject();
            if (subject != null) {
                return subject.getName();
            }
        }
        return null;
    }

    String getTopicName() {
        return topic.getName();
    }

    boolean success() {
        return SUCCESS_MESSAGE.equals(status);
    }

    private Integer getQuestionId() {
        return questionId;
    }

    void addSuccess(Question question) {
        this.maxPoints = question.getMaxPoints();
        this.questionText = question.getQuestionText();
        this.setId(question.getQuestionId());
    }
}
