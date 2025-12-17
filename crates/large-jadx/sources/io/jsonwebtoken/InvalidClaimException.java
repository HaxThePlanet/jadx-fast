package io.jsonwebtoken;

/* loaded from: classes3.dex */
public class InvalidClaimException extends io.jsonwebtoken.ClaimJwtException {

    private String claimName;
    private Object claimValue;
    protected InvalidClaimException(io.jsonwebtoken.Header header, io.jsonwebtoken.Claims claims2, String string3) {
        super(header, claims2, string3);
    }

    protected InvalidClaimException(io.jsonwebtoken.Header header, io.jsonwebtoken.Claims claims2, String string3, Throwable throwable4) {
        super(header, claims2, string3, throwable4);
    }

    @Override // io.jsonwebtoken.ClaimJwtException
    public String getClaimName() {
        return this.claimName;
    }

    @Override // io.jsonwebtoken.ClaimJwtException
    public Object getClaimValue() {
        return this.claimValue;
    }

    @Override // io.jsonwebtoken.ClaimJwtException
    public void setClaimName(String string) {
        this.claimName = string;
    }

    @Override // io.jsonwebtoken.ClaimJwtException
    public void setClaimValue(Object object) {
        this.claimValue = object;
    }
}
