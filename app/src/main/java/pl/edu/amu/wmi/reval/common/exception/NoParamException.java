package pl.edu.amu.wmi.reval.common.exception;

public class NoParamException extends RuntimeException {
    private static final String MESSAGE = "Intent nie posiada żadnych parametrów.";

    public NoParamException() {
        super(MESSAGE);
    }
}