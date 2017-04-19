package pl.edu.amu.wmi.reval.answer.basic;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;
import pl.edu.amu.wmi.reval.question.Question;

public class Answer extends AbstractRevalItem implements Serializable {

    private String user;
    private String answerText;
    private Date pubDate;
    @SerializedName("points")
    private Integer rate;
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
