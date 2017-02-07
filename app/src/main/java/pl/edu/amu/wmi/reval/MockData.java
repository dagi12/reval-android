package pl.edu.amu.wmi.reval;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import pl.edu.amu.wmi.reval.answer.Answer;
import pl.edu.amu.wmi.reval.task.Task;
import pl.edu.amu.wmi.reval.topic.Topic;
import pl.edu.amu.wmi.reval.user.User;

//TODO do usunięcia gdy gotowe API
public final class MockData {
    private MockData() {
    }

    public static User mockedAdmin() {
        User user = new User();
        user.setId(0);
        user.setName("Eryk Mariankowski");
        user.setToken("token");
        user.setAdmin(true);
        return user;
    }

    public static User mockedStudent() {
        User user = new User();
        user.setId(0);
        user.setName("Eryk Mariankowski");
        user.setToken("token");
        return user;
    }

    public static List<Task> mockedTasks() {
        List<Task> tasks = new LinkedList<>();
        tasks.add(new Task(0, "Zadanie 1", "Treść zadania 1", new Date()));
        tasks.add(new Task(0, "Zadanie 2", "Treść zadania 2", new Date()));
        tasks.add(new Task(0, "Zadanie 3", "Treść zadania 3", new Date()));
        tasks.add(new Task(0, "Zadanie 4", "Treść zadania 4", new Date()));
        tasks.add(new Task(0, "Zadanie 5", "Treść zadania 5", new Date()));
        return tasks;
    }

    public static List<Topic> mockedTopics() {
        List<Topic> topics = new LinkedList<>();
        topics.add(new Topic("Temat 1"));
        topics.add(new Topic("Temat 2"));
        topics.add(new Topic("Temat 3"));
        topics.add(new Topic("Temat 4"));
        topics.add(new Topic("Temat 5"));
        topics.add(new Topic("Temat 6"));
        return topics;
    }

    public static Answer mockedAnswer() {
        Answer answer = new Answer();
        answer.setAnswerText("Treść odpowiedzi 1");
        answer.setDate(new Date());
        answer.setUser("s396374");
        answer.setSimilarity(53);
        return answer;
    }

    public static List<Answer> mockedAnswers() {
        Answer answer = new Answer();
        answer.setAnswerText("Treść odpowiedzi 1");
        answer.setDate(new Date());
        answer.setUser("s396374");
        answer.setSimilarity(53);
        return Arrays.asList(answer, answer, answer, answer, answer, answer);
    }

    public static Task mockedTask() {
        return new Task(0, "Zadanie 1", "Treść zadania 1", new Date());
    }


}
