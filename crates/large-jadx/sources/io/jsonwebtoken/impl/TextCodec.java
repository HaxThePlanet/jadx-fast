package io.jsonwebtoken.impl;

/* loaded from: classes3.dex */
@Deprecated
public interface TextCodec {

    @Deprecated
    public static final io.jsonwebtoken.impl.TextCodec BASE64;
    @Deprecated
    public static final io.jsonwebtoken.impl.TextCodec BASE64URL;
    static {
        Base64Codec base64Codec = new Base64Codec();
        TextCodec.BASE64 = base64Codec;
        Base64UrlCodec base64UrlCodec = new Base64UrlCodec();
        TextCodec.BASE64URL = base64UrlCodec;
    }

    public abstract byte[] decode(String string);

    public abstract String decodeToString(String string);

    public abstract String encode(String string);

    public abstract String encode(byte[] bArr);
}
