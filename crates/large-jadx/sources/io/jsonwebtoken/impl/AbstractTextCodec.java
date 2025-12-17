package io.jsonwebtoken.impl;

import io.jsonwebtoken.lang.Assert;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
@Deprecated
public abstract class AbstractTextCodec implements io.jsonwebtoken.impl.TextCodec {

    protected static final Charset US_ASCII;
    protected static final Charset UTF8;
    static {
        AbstractTextCodec.UTF8 = Charset.forName("UTF-8");
        AbstractTextCodec.US_ASCII = Charset.forName("US-ASCII");
    }

    @Override // io.jsonwebtoken.impl.TextCodec
    public String decodeToString(String string) {
        String string2 = new String(decode(string), AbstractTextCodec.UTF8);
        return string2;
    }

    @Override // io.jsonwebtoken.impl.TextCodec
    public String encode(String string) {
        Assert.hasText(string, "String argument to encode cannot be null or empty.");
        return encode(string.getBytes(AbstractTextCodec.UTF8));
    }
}
