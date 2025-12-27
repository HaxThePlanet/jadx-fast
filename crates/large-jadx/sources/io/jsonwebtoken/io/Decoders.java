package io.jsonwebtoken.io;

/* compiled from: Decoders.java */
/* loaded from: classes3.dex */
public final class Decoders {

    public static final Decoder<String, byte[]> BASE64 = new ExceptionPropagatingDecoder<>();
    public static final Decoder<String, byte[]> BASE64URL = new ExceptionPropagatingDecoder<>();
    static {
        io.jsonwebtoken.io.Base64Decoder base64Decoder = new Base64Decoder();
        io.jsonwebtoken.io.Base64UrlDecoder base64UrlDecoder = new Base64UrlDecoder();
    }

    private Decoders() {
        super();
    }
}
