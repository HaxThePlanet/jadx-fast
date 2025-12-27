package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* compiled from: ExceptionPropagatingDecoder.java */
/* loaded from: classes3.dex */
class ExceptionPropagatingDecoder<T, R> implements Decoder<T, R> {

    private final Decoder<T, R> decoder;
    ExceptionPropagatingDecoder(Decoder<T, R> decoder) {
        super();
        Assert.notNull(decoder, "Decoder cannot be null.");
        this.decoder = decoder;
    }

    public R decode(T t) {
        Assert.notNull(t, "Decode argument cannot be null.");
        try {
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            String decodingException = "Unable to decode input: ";
            decodingException = e.getMessage();
            stringBuilder = decodingException + decodingException;
            decodingException = new DecodingException(stringBuilder, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) decodingException;
        } catch (io.jsonwebtoken.io.DecodingException decoding1) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) decoding1;
        }
        return this.decoder.decode(t);
    }
}
