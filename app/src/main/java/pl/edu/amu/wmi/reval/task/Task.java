package pl.edu.amu.wmi.reval.task;

import java.util.Date;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class Task extends AbstractRevalItem {

    private String questionText;
    private Date lastActivityDate;
    private int topic;

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

}
