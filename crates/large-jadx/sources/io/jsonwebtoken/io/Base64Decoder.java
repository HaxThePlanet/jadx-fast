package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
class Base64Decoder extends io.jsonwebtoken.io.Base64Support implements io.jsonwebtoken.io.Decoder<String, byte[]> {
    Base64Decoder() {
        super(Base64.DEFAULT);
    }

    Base64Decoder(io.jsonwebtoken.io.Base64 base64) {
        super(base64);
    }

    @Override // io.jsonwebtoken.io.Base64Support
    public Object decode(Object object) {
        return decode((String)object);
    }

    @Override // io.jsonwebtoken.io.Base64Support
    public byte[] decode(String string) {
        Assert.notNull(string, "String argument cannot be null");
        return this.base64.decodeFast(string.toCharArray());
    }
}
