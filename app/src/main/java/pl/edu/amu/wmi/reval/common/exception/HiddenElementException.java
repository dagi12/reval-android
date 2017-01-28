package pl.edu.amu.wmi.reval.common.exception;

public class HiddenElementException extends RuntimeException {

    private static final String MESSAGE = "Przycisk oferujący tą funkcjonalność jest ukryty";

    public HiddenElementException() {
        super(MESSAGE);
    }
}
