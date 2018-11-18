package se.wesource.fooartifact.exception;

public class CustomNotFoundException extends RuntimeException {
    public CustomNotFoundException(String msg) {
        super(msg);
    }
}
