package pl.edu.amu.wmi.reval.common.exception;

public class PageItemNullException extends RuntimeException {
    private static final String MESSAGE = "Page item is null";

    public PageItemNullException() {
        super(MESSAGE);
    }
}


