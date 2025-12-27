package io.jsonwebtoken.impl;

import io.jsonwebtoken.lang.Assert;
import java.nio.charset.Charset;

/* compiled from: AbstractTextCodec.java */
@Deprecated
/* loaded from: classes3.dex */
public abstract class AbstractTextCodec implements TextCodec {

    protected static final Charset US_ASCII;
    protected static final Charset UTF8;
    static {
        AbstractTextCodec.UTF8 = Charset.forName("UTF-8");
        AbstractTextCodec.US_ASCII = Charset.forName("US-ASCII");
    }

    public String decodeToString(String str) throws java.io.UnsupportedEncodingException {
        return new String(decode(str), AbstractTextCodec.UTF8);
    }

    public String encode(String str) throws java.io.UnsupportedEncodingException {
        Assert.hasText(str, "String argument to encode cannot be null or empty.");
        return encode(str.getBytes(AbstractTextCodec.UTF8));
    }
}
