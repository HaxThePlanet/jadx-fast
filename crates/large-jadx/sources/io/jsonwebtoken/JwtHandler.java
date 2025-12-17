package io.jsonwebtoken;

/* loaded from: classes3.dex */
public interface JwtHandler<T>  {
    public abstract T onClaimsJws(io.jsonwebtoken.Jws<io.jsonwebtoken.Claims> jws);

    public abstract T onClaimsJwt(io.jsonwebtoken.Jwt<io.jsonwebtoken.Header, io.jsonwebtoken.Claims> jwt);

    public abstract T onPlaintextJws(io.jsonwebtoken.Jws<String> jws);

    public abstract T onPlaintextJwt(io.jsonwebtoken.Jwt<io.jsonwebtoken.Header, String> jwt);
}
