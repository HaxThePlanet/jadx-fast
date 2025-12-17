package io.jsonwebtoken;

/* loaded from: classes3.dex */
public class MissingClaimException extends io.jsonwebtoken.InvalidClaimException {
    public MissingClaimException(io.jsonwebtoken.Header header, io.jsonwebtoken.Claims claims2, String string3) {
        super(header, claims2, string3);
    }

    public MissingClaimException(io.jsonwebtoken.Header header, io.jsonwebtoken.Claims claims2, String string3, Throwable throwable4) {
        super(header, claims2, string3, throwable4);
    }
}
