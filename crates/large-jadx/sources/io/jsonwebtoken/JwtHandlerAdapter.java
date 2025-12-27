package io.jsonwebtoken;

/* compiled from: JwtHandlerAdapter.java */
/* loaded from: classes3.dex */
public class JwtHandlerAdapter<T> implements JwtHandler<T> {
    public T onClaimsJws(Jws<Claims> jws) throws UnsupportedJwtException {
        throw new UnsupportedJwtException("Signed Claims JWSs are not supported.");
    }

    public T onClaimsJwt(Jwt<Header, Claims> jwt) throws UnsupportedJwtException {
        throw new UnsupportedJwtException("Unsigned Claims JWTs are not supported.");
    }

    public T onPlaintextJws(Jws<String> jws) throws UnsupportedJwtException {
        throw new UnsupportedJwtException("Signed plaintext JWSs are not supported.");
    }

    public T onPlaintextJwt(Jwt<Header, String> jwt) throws UnsupportedJwtException {
        throw new UnsupportedJwtException("Unsigned plaintext JWTs are not supported.");
    }
}
