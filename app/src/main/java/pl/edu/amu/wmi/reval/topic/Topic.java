package pl.edu.amu.wmi.reval.topic;

import com.google.gson.annotations.Expose;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;
import pl.edu.amu.wmi.reval.subject.Subject;

public class Topic extends AbstractRevalItem {

    private int subjectId;

    @Expose(serialize = false)
    private Subject subject;

    public Topic(String name) {
        super(name);
    }

    public Topic(String name, int subjectId) {
        this.name = name;
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
