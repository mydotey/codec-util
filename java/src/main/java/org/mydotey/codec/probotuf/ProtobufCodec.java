package org.mydotey.codec.probotuf;

import org.mydotey.codec.AbstractCodec;

/**
 * @author koqizhao
 *
 * Nov 8, 2018
 */
public abstract class ProtobufCodec extends AbstractCodec {

    @Override
    public String getMimeType() {
        return "application/x-protobuf";
    }

}
