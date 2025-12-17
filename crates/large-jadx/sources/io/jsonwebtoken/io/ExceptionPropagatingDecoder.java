package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
class ExceptionPropagatingDecoder<T, R>  implements io.jsonwebtoken.io.Decoder<T, R> {

    private final io.jsonwebtoken.io.Decoder<T, R> decoder;
    ExceptionPropagatingDecoder(io.jsonwebtoken.io.Decoder<T, R> decoder) {
        super();
        Assert.notNull(decoder, "Decoder cannot be null.");
        this.decoder = decoder;
    }

    public R decode(T t) {
        Assert.notNull(t, "Decode argument cannot be null.");
        return this.decoder.decode(t);
    }
}
