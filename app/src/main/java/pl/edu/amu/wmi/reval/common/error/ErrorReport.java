package pl.edu.amu.wmi.reval.common.error;

class ErrorReport {

    private String platform = "Android";

    private String stack;

    ErrorReport(String stack) {
        this.stack = stack;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getPlatform() {

        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
