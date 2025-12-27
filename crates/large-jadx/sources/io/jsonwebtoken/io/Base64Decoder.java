package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* compiled from: Base64Decoder.java */
/* loaded from: classes3.dex */
class Base64Decoder extends Base64Support implements Decoder<String, byte[]> {
    Base64Decoder() {
        super(Base64.DEFAULT);
    }

    Base64Decoder(Base64 base64) {
        super(base64);
    }

    @Override // io.jsonwebtoken.io.Base64Support
    public byte[] decode(String str) {
        Assert.notNull(str, "String argument cannot be null");
        return this.base64.decodeFast(str.toCharArray());
    }
}
