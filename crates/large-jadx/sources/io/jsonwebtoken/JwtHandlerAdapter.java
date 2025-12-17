package io.jsonwebtoken;

/* loaded from: classes3.dex */
public class JwtHandlerAdapter<T>  implements io.jsonwebtoken.JwtHandler<T> {
    public T onClaimsJws(io.jsonwebtoken.Jws<io.jsonwebtoken.Claims> jws) {
        UnsupportedJwtException obj2 = new UnsupportedJwtException("Signed Claims JWSs are not supported.");
        throw obj2;
    }

    public T onClaimsJwt(io.jsonwebtoken.Jwt<io.jsonwebtoken.Header, io.jsonwebtoken.Claims> jwt) {
        UnsupportedJwtException obj2 = new UnsupportedJwtException("Unsigned Claims JWTs are not supported.");
        throw obj2;
    }

    public T onPlaintextJws(io.jsonwebtoken.Jws<String> jws) {
        UnsupportedJwtException obj2 = new UnsupportedJwtException("Signed plaintext JWSs are not supported.");
        throw obj2;
    }

    public T onPlaintextJwt(io.jsonwebtoken.Jwt<io.jsonwebtoken.Header, String> jwt) {
        UnsupportedJwtException obj2 = new UnsupportedJwtException("Unsigned plaintext JWTs are not supported.");
        throw obj2;
    }
}
