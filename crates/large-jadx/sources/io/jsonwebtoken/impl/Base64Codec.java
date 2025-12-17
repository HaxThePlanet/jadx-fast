package io.jsonwebtoken.impl;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;

/* loaded from: classes3.dex */
@Deprecated
public class Base64Codec extends io.jsonwebtoken.impl.AbstractTextCodec {
    @Override // io.jsonwebtoken.impl.AbstractTextCodec
    public byte[] decode(String string) {
        return (byte[])Decoders.BASE64.decode(string);
    }

    @Override // io.jsonwebtoken.impl.AbstractTextCodec
    public String encode(byte[] bArr) {
        return (String)Encoders.BASE64.encode(bArr);
    }
}
