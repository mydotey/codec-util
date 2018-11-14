package org.mydotey.codec;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/**
 * @author koqizhao
 *
 * Nov 12, 2018
 */
public abstract class AbstractCodec implements Codec {

    @Override
    public byte[] encode(Object obj) {
        Objects.requireNonNull(obj, "obj is null");

        return doEncode(obj);
    }

    @Override
    public <T> T decode(byte[] is, Class<T> clazz) {
        Objects.requireNonNull(is, "is is null");
        Objects.requireNonNull(clazz, "clazz is null");

        return doDecode(is, clazz);
    }

    @Override
    public void encode(OutputStream os, Object obj) {
        Objects.requireNonNull(os, "os is null");
        Objects.requireNonNull(obj, "obj is null");

        doEncode(os, obj);
    }

    @Override
    public <T> T decode(InputStream is, Class<T> clazz) {
        Objects.requireNonNull(is, "is is null");
        Objects.requireNonNull(clazz, "clazz is null");

        return doDecode(is, clazz);
    }

    protected abstract byte[] doEncode(Object obj);

    protected abstract <T> T doDecode(byte[] is, Class<T> clazz);

    protected abstract void doEncode(OutputStream os, Object obj);

    protected abstract <T> T doDecode(InputStream is, Class<T> clazz);

}
