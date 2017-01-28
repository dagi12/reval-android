package pl.edu.amu.wmi.reval.task;

public class TaskRequest {
    private int topic;
    private int subject;
    private int maxPoints;
    private String question;

    public TaskRequest() {
    }

    public TaskRequest(int topic, int subject, int maxPoints, String question) {

        this.topic = topic;
        this.subject = subject;
        this.maxPoints = maxPoints;
        this.question = question;
    }
}
