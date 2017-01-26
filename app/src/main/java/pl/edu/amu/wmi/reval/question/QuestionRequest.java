package pl.edu.amu.wmi.reval.question;

public class QuestionRequest {
    private int topic;
    private int subject;
    private int maxPoints;
    private String question;

    public QuestionRequest() {
    }

    public QuestionRequest(int topic, int subject, int maxPoints, String question) {

        this.topic = topic;
        this.subject = subject;
        this.maxPoints = maxPoints;
        this.question = question;
    }
}
