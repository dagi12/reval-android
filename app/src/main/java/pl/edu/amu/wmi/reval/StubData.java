package pl.edu.amu.wmi.reval;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import pl.edu.amu.wmi.reval.answer.Answer;
import pl.edu.amu.wmi.reval.question.Question;
import pl.edu.amu.wmi.reval.subject.Subject;
import pl.edu.amu.wmi.reval.topic.Topic;
import pl.edu.amu.wmi.reval.user.model.User;

import static pl.edu.amu.wmi.reval.di.MyApplication.getContext;

public final class StubData {
    private StubData() {
    }

    public static User stubAdmin() {
        User user = new User();
        user.setId(0);
        user.setName("Eryk Mariankowski");
        user.setToken("token");
        user.setAdmin(true);
        return user;
    }

    public static User stubStudent() {
        User user = new User();
        user.setId(0);
        user.setIndex(getContext().getString(R.string.example_student));
        user.setName("Eryk Mariankowski");
        user.setToken("token");
        return user;
    }


    public static List<Question> stubQuestions() {
        List<Question> questions = new LinkedList<>();
        questions.add(new Question(0, "Zadanie 1", "Treść zadania 1", new Date(), stubTopic()));
        questions.add(new Question(0, "Zadanie 2", "Treść zadania 2", new Date(), stubTopic()));
        questions.add(new Question(0, "Zadanie 3", "Treść zadania 3", new Date(), stubTopic()));
        questions.add(new Question(0, "Zadanie 4", "Treść zadania 4", new Date(), stubTopic()));
        questions.add(new Question(0, "Zadanie 5", "Treść zadania 5", new Date(), stubTopic()));
        return questions;
    }

    public static Topic stubTopic() {
        return new Topic("topic", 0);
    }

    public static Answer stubAnswer() {
        Answer answer = new Answer();
        answer.setAnswerText("Treść odpowiedzi 1");
        answer.setPubDate(new Date());
        answer.setUser("s396374");
        answer.setSimilarity(53);
        return answer;
    }

    public static List<Answer> stubAnswers() {
        Answer answer = new Answer();
        answer.setAnswerText("Treść odpowiedzi 1");
        answer.setPubDate(new Date());
        answer.setUser("s396374");
        answer.setSimilarity(53);
        return Arrays.asList(answer, answer, answer, answer, answer, answer);
    }

    public static Question stubQuestion() {
        return new Question(0, "Zadanie 1", "Treść zadania 1", new Date(), stubTopic());
    }

    public static List<Subject> stubSubjects() {
        return Arrays.asList(
                new Subject("Temat 1", 0),
                new Subject("Temat 2"),
                new Subject("Temat 3"),
                new Subject("Temat 4")
        );
    }

    public static List<Topic> stubTopics() {
        return Arrays.asList(
                new Topic("Temat 1", 0),
                new Topic("Temat 2", 0),
                new Topic("Temat 3", 0),
                new Topic("Temat 4", 0)
        );
    }


}
