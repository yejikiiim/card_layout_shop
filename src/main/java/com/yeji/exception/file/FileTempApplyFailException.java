package com.yeji.exception.file;

/**
 * 임시 파일 적용 실패 에외처리
 */
public class FileTempApplyFailException extends RuntimeException {

    private static final long serialVersionUID = -2592192186426689314L;

    public FileTempApplyFailException() {
    }

    public FileTempApplyFailException(String message) {
        super(message);
    }

    public FileTempApplyFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTempApplyFailException(Throwable cause) {
        super(cause);
    }

    public FileTempApplyFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
