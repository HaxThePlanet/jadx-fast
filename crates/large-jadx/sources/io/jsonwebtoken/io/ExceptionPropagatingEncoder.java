package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
class ExceptionPropagatingEncoder<T, R>  implements io.jsonwebtoken.io.Encoder<T, R> {

    private final io.jsonwebtoken.io.Encoder<T, R> encoder;
    ExceptionPropagatingEncoder(io.jsonwebtoken.io.Encoder<T, R> encoder) {
        super();
        Assert.notNull(encoder, "Encoder cannot be null.");
        this.encoder = encoder;
    }

    public R encode(T t) {
        Assert.notNull(t, "Encode argument cannot be null.");
        return this.encoder.encode(t);
    }
}
