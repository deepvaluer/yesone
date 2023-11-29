package io.deptron.yesone.exception;

public class ExportError extends Exception {

    private final int errorCode;

    public ExportError(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
