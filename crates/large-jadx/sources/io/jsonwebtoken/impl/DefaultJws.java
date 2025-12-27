package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;

/* compiled from: DefaultJws.java */
/* loaded from: classes3.dex */
public class DefaultJws<B> implements Jws<B> {

    private final B body;
    private final JwsHeader header;
    private final String signature;
    public DefaultJws(JwsHeader jwsHeader, B b, String str) {
        super();
        this.header = jwsHeader;
        this.body = b;
        this.signature = str;
    }

    public B getBody() {
        return this.body;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "header=";
        String str3 = ",body=";
        String str4 = ",signature=";
        str = str2 + this.header + str3 + this.body + str4 + this.signature;
        return str;
    }

    public JwsHeader getHeader() {
        return this.header;
    }
}
