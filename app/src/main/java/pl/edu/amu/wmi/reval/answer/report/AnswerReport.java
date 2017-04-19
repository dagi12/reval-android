package pl.edu.amu.wmi.reval.answer.report;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.answer.basic.Answer;
import pl.edu.amu.wmi.reval.question.Question;

public class AnswerReport extends Answer implements Serializable {

    private Answer answer;
    @SerializedName("similarAnswer")
    private Integer similarAnswer;
    @SerializedName("similarityPercentage")
    private Integer similarity;

    public AnswerReport() {
        // retrofit need
    }

    @Override
    public Integer getId() {
        return answer.getId();
    }

    @Override
    public void setId(Integer id) {
        answer.setId(id);
    }

    @Override
    public String getName() {
        return answer.getName();
    }

    @Override
    public void setName(String name) {
        answer.setName(name);
    }

    public Integer getSimilarity() {
        return similarity;
    }

    public Answer getAnswer() {
        return answer;
    }

    @Override
    public Question getQuestion() {
        return answer.getQuestion();
    }

    @Override
    public Integer getRate() {
        return answer.getRate();
    }

    @Override
    public void setRate(Integer rate) {
        answer.setRate(rate);
    }

    @Override
    public String getAnswerText() {
        return answer.getAnswerText();
    }

    @Override
    public void setAnswerText(String answerText) {
        answer.setAnswerText(answerText);
    }

    @Override
    public Date getPubDate() {
        return answer.getPubDate();
    }

    @Override
    public void setPubDate(Date pubDate) {
        answer.setPubDate(pubDate);
    }

    @Override
    public String getUser() {
        return answer.getUser();
    }

    @Override
    public void setUser(String user) {
        answer.setUser(user);
    }
}
