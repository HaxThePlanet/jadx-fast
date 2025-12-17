package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
class Base64Encoder extends io.jsonwebtoken.io.Base64Support implements io.jsonwebtoken.io.Encoder<byte[], String> {
    Base64Encoder() {
        super(Base64.DEFAULT);
    }

    Base64Encoder(io.jsonwebtoken.io.Base64 base64) {
        super(base64);
    }

    @Override // io.jsonwebtoken.io.Base64Support
    public Object encode(Object object) {
        return encode((byte[])object);
    }

    @Override // io.jsonwebtoken.io.Base64Support
    public String encode(byte[] bArr) {
        Assert.notNull(bArr, "byte array argument cannot be null");
        return this.base64.encodeToString(bArr, false);
    }
}
