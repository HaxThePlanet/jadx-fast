package io.jsonwebtoken.io;

/* compiled from: Encoders.java */
/* loaded from: classes3.dex */
public final class Encoders {

    public static final Encoder<byte[], String> BASE64 = new ExceptionPropagatingEncoder<>();
    public static final Encoder<byte[], String> BASE64URL = new ExceptionPropagatingEncoder<>();
    static {
        io.jsonwebtoken.io.Base64Encoder base64Encoder = new Base64Encoder();
        io.jsonwebtoken.io.Base64UrlEncoder base64UrlEncoder = new Base64UrlEncoder();
    }

    private Encoders() {
        super();
    }
}
