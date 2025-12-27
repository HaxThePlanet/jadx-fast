package io.jsonwebtoken.impl;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;

/* compiled from: Base64UrlCodec.java */
@Deprecated
/* loaded from: classes3.dex */
public class Base64UrlCodec extends AbstractTextCodec {
    @Override // io.jsonwebtoken.impl.AbstractTextCodec
    public byte[] decode(String str) {
        return (byte[])Decoders.BASE64URL.decode(str);
    }

    @Override // io.jsonwebtoken.impl.AbstractTextCodec
    public String encode(byte[] bArr) {
        return (String)Encoders.BASE64URL.encode(bArr);
    }
}
