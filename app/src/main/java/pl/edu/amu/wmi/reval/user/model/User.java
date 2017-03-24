package pl.edu.amu.wmi.reval.user.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import pl.edu.amu.wmi.reval.common.grid.AbstractRevalItem;

public class User extends AbstractRevalItem implements Serializable {

    private String token;

    private String index;

    private String fullName;

    @SerializedName("super_user")
    private boolean admin;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

}
