package org.mydotey.codec.json;

import org.mydotey.codec.AbstractCodec;

/**
 * @author koqizhao
 *
 * Nov 8, 2018
 */
public abstract class JsonCodec extends AbstractCodec {

    @Override
    public String getMimeType() {
        return "application/json";
    }

}
