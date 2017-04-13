package pl.edu.amu.wmi.reval.answer.rate;

import pl.edu.amu.wmi.reval.answer.basic.Answer;

public class RateResult {

    private static final String SUCCESS_STATUS = "updated";
    private Answer answer;
    private String status;

    public RateResult() {
        // retrofit need
    }

    public RateResult(Answer answer) {
        this.answer = answer;
        this.status = SUCCESS_STATUS;

    }

    public Answer getAnswer() {
        return answer;
    }

    public boolean isSuccess() {
        return SUCCESS_STATUS.equals(status);
    }

}
