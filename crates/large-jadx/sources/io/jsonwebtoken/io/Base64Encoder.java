package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* compiled from: Base64Encoder.java */
/* loaded from: classes3.dex */
class Base64Encoder extends Base64Support implements Encoder<byte[], String> {
    Base64Encoder() {
        super(Base64.DEFAULT);
    }

    Base64Encoder(Base64 base64) {
        super(base64);
    }

    @Override // io.jsonwebtoken.io.Base64Support
    public String encode(byte[] bArr) {
        Assert.notNull(bArr, "byte array argument cannot be null");
        return this.base64.encodeToString(bArr, false);
    }
}
