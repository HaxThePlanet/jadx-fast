package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;

/* loaded from: classes3.dex */
public class DefaultJwt<B>  implements Jwt<Header, B> {

    private final B body;
    private final Header header;
    public DefaultJwt(Header header, B b2) {
        super();
        this.header = header;
        this.body = b2;
    }

    public B getBody() {
        return this.body;
    }

    @Override // io.jsonwebtoken.Jwt
    public Header getHeader() {
        return this.header;
    }

    @Override // io.jsonwebtoken.Jwt
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("header=");
        stringBuilder.append(this.header);
        stringBuilder.append(",body=");
        stringBuilder.append(this.body);
        return stringBuilder.toString();
    }
}
