package pl.edu.amu.wmi.reval.answer;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;
import pl.edu.amu.wmi.reval.question.Question;

public class Answer extends AbstractRevalItem implements Serializable {
    private String user;
    private String answerText;
    private Date pubDate;
    private int similarity;
    private Question question;

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

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getQuestionTitle() {
        return question.getTitle();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
