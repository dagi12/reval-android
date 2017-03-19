package pl.edu.amu.wmi.reval.subject;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class Subject extends AbstractRevalItem {

    public Subject() {
        super();
    }

    public Subject(String name) {
        super(name);
    }

    public Subject(int subjectId) {
        setId(subjectId);
    }
}