package org.mydotey.codec;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author koqizhao
 *
 * Nov 8, 2018
 */
public abstract class CodecTest {

    @Test
    public void codecPojo() {
        Codec codec = getCodec();
        Object data = newObject();

        codecBytes(codec, data, data.getClass());

        codecStream(codec, data, data.getClass());
    }

    @Test
    public void codecString() {
        Codec codec = getCodec();
        Object data = "Hello world!";

        codecBytes(codec, data, data.getClass());

        codecStream(codec, data, data.getClass());
    }

    @Test
    public void codecPrimitive() {
        Codec codec = getCodec();
        Object[] dataList = new Object[] { 1, 99.9, true };
        for (Object data : dataList) {
            codecBytes(codec, data, data.getClass());

            codecStream(codec, data, data.getClass());
        }
    }

    protected void codecBytes(Codec codec, Object data, Class<?> clazz) {
        byte[] bytes = codec.encode(data);
        Assert.assertNotNull(bytes);
        Assert.assertTrue(bytes.length > 0);
        Object data2 = codec.decode(bytes, clazz);
        System.out.println("bytes codec expected: \n" + data2);
        Assert.assertEquals(data, data2);
    }

    protected void codecStream(Codec codec, Object data, Class<?> clazz) {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            codec.encode(os, data);
            try (ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray())) {
                Object data2 = codec.decode(is, clazz);
                System.out.println("stream codec expected: \n" + data2);
                Assert.assertEquals(data, data2);
            }
        } catch (IOException e) {
            Assert.fail("stream exception: " + e);
        }
    }

    protected Object newObject() {
        PojoHello obj = new PojoHello();
        obj.setHello("hello");
        obj.setWorld("world");
        return obj;
    }

    protected abstract Codec getCodec();

}
