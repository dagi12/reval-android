package pl.edu.amu.wmi.reval.topic;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class Topic extends AbstractRevalItem {

    private int subjectId;

    public Topic(String name) {
        super(name);
    }

    public Topic(String name, int subjectId) {
        this.name = name;
        this.subjectId = subjectId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
