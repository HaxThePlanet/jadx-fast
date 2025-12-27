package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;

/* compiled from: DefaultJwt.java */
/* loaded from: classes3.dex */
public class DefaultJwt<B> implements Jwt<Header, B> {

    private final B body;
    private final Header header;
    public DefaultJwt(Header header, B b) {
        super();
        this.header = header;
        this.body = b;
    }

    public B getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "header=";
        String str3 = ",body=";
        str = str2 + this.header + str3 + this.body;
        return str;
    }
}
