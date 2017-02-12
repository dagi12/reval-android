package pl.edu.amu.wmi.reval.task;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.answer.Answer;
import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;
import pl.edu.amu.wmi.reval.task.filter.TaskRequestParameters;

public class Task extends AbstractRevalItem implements Serializable {

    private String questionText;
    private String title;

    private Date lastActivityDate;
    private String subjectName;
    private String topicName;
    private Answer answer;

    // TODO do ustalenia z API
    private int topic;
    private int subject;
    private int maxPoints;


    public Task(TaskRequestParameters parameters, String taskContent) {
        super();
        this.topic = parameters.getTopicId();
        this.subject = parameters.getSubjectId();
        this.questionText = taskContent;
    }

    public Task(int id, String title, String questionText, Date lastActivityDate) {
        super(id);
        this.title = title;
        this.questionText = questionText;
        this.lastActivityDate = lastActivityDate;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getTaskContent() {
        return questionText;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getTaskTitle() {
        return title;
    }

    public Answer getAnswer() {
        return answer;
    }
}
