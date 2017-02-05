package pl.edu.amu.wmi.reval.answer;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class Answer extends AbstractRevalItem implements Serializable {
    private String user;
    private String answerText;
    private Date date;
    private int similarity;
    private int subjectName;
    private int taskName;

    public String getAnswerText() {
        return answerText;
    }

    public int getSimilarity() {
        return similarity;
    }

    public Date getDate() {
        return date;
    }

    public int getSubjectName() {
        return subjectName;
    }

    public int getTaskTitle() {
        return taskName;
    }

    public String getUser() {
        return user;
    }
}
