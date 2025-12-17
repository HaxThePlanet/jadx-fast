package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;

/* loaded from: classes3.dex */
public class DefaultJws<B>  implements Jws<B> {

    private final B body;
    private final JwsHeader header;
    private final String signature;
    public DefaultJws(JwsHeader jwsHeader, B b2, String string3) {
        super();
        this.header = jwsHeader;
        this.body = b2;
        this.signature = string3;
    }

    public B getBody() {
        return this.body;
    }

    @Override // io.jsonwebtoken.Jws
    public Header getHeader() {
        return getHeader();
    }

    @Override // io.jsonwebtoken.Jws
    public JwsHeader getHeader() {
        return this.header;
    }

    @Override // io.jsonwebtoken.Jws
    public String getSignature() {
        return this.signature;
    }

    @Override // io.jsonwebtoken.Jws
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("header=");
        stringBuilder.append(this.header);
        stringBuilder.append(",body=");
        stringBuilder.append(this.body);
        stringBuilder.append(",signature=");
        stringBuilder.append(this.signature);
        return stringBuilder.toString();
    }
}
