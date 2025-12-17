package io.jsonwebtoken.io;

/* loaded from: classes3.dex */
public final class Decoders {

    public static final io.jsonwebtoken.io.Decoder<String, byte[]> BASE64;
    public static final io.jsonwebtoken.io.Decoder<String, byte[]> BASE64URL;
    static {
        Base64Decoder base64Decoder = new Base64Decoder();
        ExceptionPropagatingDecoder exceptionPropagatingDecoder = new ExceptionPropagatingDecoder(base64Decoder);
        Decoders.BASE64 = exceptionPropagatingDecoder;
        Base64UrlDecoder base64UrlDecoder = new Base64UrlDecoder();
        ExceptionPropagatingDecoder exceptionPropagatingDecoder2 = new ExceptionPropagatingDecoder(base64UrlDecoder);
        Decoders.BASE64URL = exceptionPropagatingDecoder2;
    }
}
