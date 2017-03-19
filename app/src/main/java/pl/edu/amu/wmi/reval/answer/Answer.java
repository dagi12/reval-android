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
    private String questionName;

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getSimilarity() {
        return similarity;
    }

    public void setSimilarity(int similarity) {
        this.similarity = similarity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSubjectName() {
        return subjectName;
    }

    public String getQuestionTitle() {
        return questionName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
