package io.jsonwebtoken;

/* loaded from: classes3.dex */
public abstract class ClaimJwtException extends io.jsonwebtoken.JwtException {

    public static final String INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE = "Expected %s claim to be: %s, but was: %s.";
    public static final String MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE = "Expected %s claim to be: %s, but was not present in the JWT claims.";
    private final io.jsonwebtoken.Claims claims;
    private final io.jsonwebtoken.Header header;
    protected ClaimJwtException(io.jsonwebtoken.Header header, io.jsonwebtoken.Claims claims2, String string3) {
        super(string3);
        this.header = header;
        this.claims = claims2;
    }

    protected ClaimJwtException(io.jsonwebtoken.Header header, io.jsonwebtoken.Claims claims2, String string3, Throwable throwable4) {
        super(string3, throwable4);
        this.header = header;
        this.claims = claims2;
    }

    @Override // io.jsonwebtoken.JwtException
    public io.jsonwebtoken.Claims getClaims() {
        return this.claims;
    }

    @Override // io.jsonwebtoken.JwtException
    public io.jsonwebtoken.Header getHeader() {
        return this.header;
    }
}
