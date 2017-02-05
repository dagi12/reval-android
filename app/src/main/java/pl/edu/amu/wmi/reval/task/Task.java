package pl.edu.amu.wmi.reval.task;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.answer.Answer;
import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class Task extends AbstractRevalItem implements Serializable {

    private String questionText;
    private Date lastActivityDate;
    private int topic;
    private String title;
    private String taskContent;
    private String subjectName;
    private String topicName;
    private int taskTitle;
    private Answer answer;

    public Task(String title, String questionText, Date lastActivityDate) {
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
        return taskContent;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getTopicName() {
        return topicName;
    }

    public int getTaskTitle() {
        return taskTitle;
    }

    public Answer getAnswer() {
        return answer;
    }
}
