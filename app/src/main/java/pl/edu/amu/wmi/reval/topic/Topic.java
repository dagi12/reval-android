package pl.edu.amu.wmi.reval.topic;

import com.google.gson.annotations.Expose;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;
import pl.edu.amu.wmi.reval.subject.Subject;

public class Topic extends AbstractRevalItem {

    @Expose(serialize = false)
    private Subject subject;

    public Topic(String name) {
        super(name);
    }

    public Topic(String name, int id) {
        super(name, id);
    }

    public Subject getSubject() {
        return subject;
    }

}
