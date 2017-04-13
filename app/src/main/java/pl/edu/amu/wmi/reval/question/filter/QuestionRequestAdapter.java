package pl.edu.amu.wmi.reval.question.filter;

import pl.edu.amu.wmi.reval.topic.Topic;

public interface QuestionRequestAdapter {
    void populateFilter(Topic parameters);
}
