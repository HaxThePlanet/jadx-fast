package io.jsonwebtoken;

/* loaded from: classes3.dex */
public class ExpiredJwtException extends io.jsonwebtoken.ClaimJwtException {
    public ExpiredJwtException(io.jsonwebtoken.Header header, io.jsonwebtoken.Claims claims2, String string3) {
        super(header, claims2, string3);
    }

    public ExpiredJwtException(io.jsonwebtoken.Header header, io.jsonwebtoken.Claims claims2, String string3, Throwable throwable4) {
        super(header, claims2, string3, throwable4);
    }
}
