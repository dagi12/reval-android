package pl.edu.amu.wmi.reval.common.grid;

import java.io.Serializable;

public class AbstractRevalItem implements Serializable {

    protected String name;
    private Integer id;

    public AbstractRevalItem() {
        // retrofit need
    }

    public AbstractRevalItem(String name) {
        this.name = name;
    }

    public AbstractRevalItem(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
