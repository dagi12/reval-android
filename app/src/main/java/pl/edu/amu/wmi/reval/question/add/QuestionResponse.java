package pl.edu.amu.wmi.reval.question.add;

import pl.edu.amu.wmi.reval.question.Question;

public class QuestionResponse {

    private static final String SUCCESS = "created";
    private Question question;

    private String status;

    public Question getQuestion() {
        return question;
    }

    public boolean isSuccess() {
        return SUCCESS.equals(status);
    }

}
