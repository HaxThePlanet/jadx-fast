package io.jsonwebtoken.impl;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;

/* compiled from: AndroidBase64Codec.java */
@Deprecated
/* loaded from: classes3.dex */
public class AndroidBase64Codec extends AbstractTextCodec {
    @Override // io.jsonwebtoken.impl.AbstractTextCodec
    public byte[] decode(String str) {
        return (byte[])Decoders.BASE64.decode(str);
    }

    @Override // io.jsonwebtoken.impl.AbstractTextCodec
    public String encode(byte[] bArr) {
        return (String)Encoders.BASE64.encode(bArr);
    }
}
