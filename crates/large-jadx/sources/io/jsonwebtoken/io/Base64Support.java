package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* compiled from: Base64Support.java */
/* loaded from: classes3.dex */
class Base64Support {

    protected final Base64 base64;
    Base64Support(Base64 base64) {
        super();
        Assert.notNull(base64, "Base64 argument cannot be null");
        this.base64 = base64;
    }
}
