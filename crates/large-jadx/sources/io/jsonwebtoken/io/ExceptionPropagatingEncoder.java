package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* compiled from: ExceptionPropagatingEncoder.java */
/* loaded from: classes3.dex */
class ExceptionPropagatingEncoder<T, R> implements Encoder<T, R> {

    private final Encoder<T, R> encoder;
    ExceptionPropagatingEncoder(Encoder<T, R> encoder) {
        super();
        Assert.notNull(encoder, "Encoder cannot be null.");
        this.encoder = encoder;
    }

    public R encode(T t) {
        Assert.notNull(t, "Encode argument cannot be null.");
        try {
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            String encodingException = "Unable to encode input: ";
            encodingException = e.getMessage();
            stringBuilder = encodingException + encodingException;
            encodingException = new EncodingException(stringBuilder, e);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) encodingException;
        } catch (io.jsonwebtoken.io.EncodingException encoding1) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) encoding1;
        }
        return this.encoder.encode(t);
    }
}
