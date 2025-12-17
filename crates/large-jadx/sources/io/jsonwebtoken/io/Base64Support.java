package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
class Base64Support {

    protected final io.jsonwebtoken.io.Base64 base64;
    Base64Support(io.jsonwebtoken.io.Base64 base64) {
        super();
        Assert.notNull(base64, "Base64 argument cannot be null");
        this.base64 = base64;
    }
}
