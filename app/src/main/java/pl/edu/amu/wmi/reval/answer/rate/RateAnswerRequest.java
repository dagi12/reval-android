package pl.edu.amu.wmi.reval.answer.rate;

public class RateAnswerRequest {
    private Integer id;
    private Integer points;

    public RateAnswerRequest() {
        // retrofit need
    }

    public RateAnswerRequest(Integer id, Integer points) {

        this.id = id;
        this.points = points;
    }
}
