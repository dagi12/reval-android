package pl.edu.amu.wmi.reval.answer;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class Answer extends AbstractRevalItem implements Serializable {
    private int question;
    private String user;
    private String answerText;
    private boolean attachment;
    private Date date;
    private int similarity;
    private int subjectName;
    private int taskName;
    private int index;
    private int answerContent;

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

    public int getIndex() {
        return index;
    }

    public int getAnswerContent() {
        return answerContent;
    }
}
