package io.jsonwebtoken;

/* loaded from: classes3.dex */
public interface Jws<B>  extends io.jsonwebtoken.Jwt<io.jsonwebtoken.JwsHeader, B> {
    @Override // io.jsonwebtoken.Jwt
    public abstract String getSignature();
}
