package io.jsonwebtoken;

import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class SigningKeyResolverAdapter implements io.jsonwebtoken.SigningKeyResolver {
    @Override // io.jsonwebtoken.SigningKeyResolver
    public Key resolveSigningKey(io.jsonwebtoken.JwsHeader jwsHeader, io.jsonwebtoken.Claims claims2) {
        io.jsonwebtoken.SignatureAlgorithm forName = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The default resolveSigningKey(JwsHeader, Claims) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, Claims) method instead and return a Key instance appropriate for the ");
        stringBuilder.append(forName.name());
        stringBuilder.append(" algorithm.");
        Assert.isTrue(forName.isHmac(), stringBuilder.toString());
        SecretKeySpec obj6 = new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, claims2), forName.getJcaName());
        return obj6;
    }

    @Override // io.jsonwebtoken.SigningKeyResolver
    public Key resolveSigningKey(io.jsonwebtoken.JwsHeader jwsHeader, String string2) {
        io.jsonwebtoken.SignatureAlgorithm forName = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The default resolveSigningKey(JwsHeader, String) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, String) method instead and return a Key instance appropriate for the ");
        stringBuilder.append(forName.name());
        stringBuilder.append(" algorithm.");
        Assert.isTrue(forName.isHmac(), stringBuilder.toString());
        SecretKeySpec obj6 = new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, string2), forName.getJcaName());
        return obj6;
    }

    @Override // io.jsonwebtoken.SigningKeyResolver
    public byte[] resolveSigningKeyBytes(io.jsonwebtoken.JwsHeader jwsHeader, io.jsonwebtoken.Claims claims2) {
        UnsupportedJwtException obj1 = new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support Claims JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, Claims) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, Claims) method.");
        throw obj1;
    }

    @Override // io.jsonwebtoken.SigningKeyResolver
    public byte[] resolveSigningKeyBytes(io.jsonwebtoken.JwsHeader jwsHeader, String string2) {
        UnsupportedJwtException obj1 = new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support plaintext JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, String) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, String) method.");
        throw obj1;
    }
}
