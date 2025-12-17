package io.jsonwebtoken.io;

/* loaded from: classes3.dex */
public final class Encoders {

    public static final io.jsonwebtoken.io.Encoder<byte[], String> BASE64;
    public static final io.jsonwebtoken.io.Encoder<byte[], String> BASE64URL;
    static {
        Base64Encoder base64Encoder = new Base64Encoder();
        ExceptionPropagatingEncoder exceptionPropagatingEncoder = new ExceptionPropagatingEncoder(base64Encoder);
        Encoders.BASE64 = exceptionPropagatingEncoder;
        Base64UrlEncoder base64UrlEncoder = new Base64UrlEncoder();
        ExceptionPropagatingEncoder exceptionPropagatingEncoder2 = new ExceptionPropagatingEncoder(base64UrlEncoder);
        Encoders.BASE64URL = exceptionPropagatingEncoder2;
    }
}
