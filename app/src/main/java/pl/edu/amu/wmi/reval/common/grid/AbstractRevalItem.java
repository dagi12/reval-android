package pl.edu.amu.wmi.reval.common.grid;

public class AbstractRevalItem {

    private Integer id;

    protected String name;

    public AbstractRevalItem() {
    }

    public AbstractRevalItem(String name) {
        this.name = name;
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
