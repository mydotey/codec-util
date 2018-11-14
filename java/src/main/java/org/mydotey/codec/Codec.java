package org.mydotey.codec;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Qiang Zhao on 10/05/2016.
 */
public interface Codec {

    String getMimeType();

    byte[] encode(Object obj);

    <T> T decode(byte[] is, Class<T> clazz);

    void encode(OutputStream os, Object obj);

    <T> T decode(InputStream is, Class<T> clazz);

}
