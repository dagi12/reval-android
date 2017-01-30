package pl.edu.amu.wmi.reval.task;

import java.io.Serializable;
import java.util.Date;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class Task extends AbstractRevalItem implements Serializable{

    private String questionText;
    private Date lastActivityDate;
    private int topic;
    private String title;

    public Task(String title, String questionText, Date lastActivityDate) {
        this.title = title;
        this.questionText = questionText;
        this.lastActivityDate = lastActivityDate;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }
}
