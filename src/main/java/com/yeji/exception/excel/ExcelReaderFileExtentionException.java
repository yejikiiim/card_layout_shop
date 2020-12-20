package com.yeji.exception.excel;

/**
 * 엑셀 파일 확장자 에러 예외처리
 */
public class ExcelReaderFileExtentionException extends RuntimeException {

    public ExcelReaderFileExtentionException() {
    }

    public ExcelReaderFileExtentionException(String message) {
        super(message);
    }

    public ExcelReaderFileExtentionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcelReaderFileExtentionException(Throwable cause) {
        super(cause);
    }

    public ExcelReaderFileExtentionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
