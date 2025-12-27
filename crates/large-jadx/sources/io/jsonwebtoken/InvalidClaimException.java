package io.jsonwebtoken;

/* compiled from: InvalidClaimException.java */
/* loaded from: classes3.dex */
public class InvalidClaimException extends ClaimJwtException {

    private String claimName;
    private Object claimValue;
    protected InvalidClaimException(Header header, Claims claims, String str) {
        super(header, claims, str);
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
    public void setClaimName(String str) {
        this.claimName = str;
    }

    @Override // io.jsonwebtoken.ClaimJwtException
    public void setClaimValue(Object object) {
        this.claimValue = object;
    }

    protected InvalidClaimException(Header header, Claims claims, String str, Throwable th) {
        super(header, claims, str, th);
    }
}
