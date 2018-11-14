package org.mydotey.codec;

/**
 * Created by Qiang Zhao on 10/05/2016.
 */
public class CodecException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CodecException(Exception ex) {
        super(ex);
    }

    public CodecException(String message, Exception ex) {
        super(message, ex);
    }

}
