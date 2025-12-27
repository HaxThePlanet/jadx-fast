package io.jsonwebtoken;

import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: SigningKeyResolverAdapter.java */
/* loaded from: classes3.dex */
public class SigningKeyResolverAdapter implements SigningKeyResolver {
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        io.jsonwebtoken.SignatureAlgorithm cls = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "The default resolveSigningKey(JwsHeader, Claims) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, Claims) method instead and return a Key instance appropriate for the ";
        String name = cls.name();
        String str3 = " algorithm.";
        str = str2 + name + str3;
        Assert.isTrue(cls.isHmac(), str);
        return new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, claims), cls.getJcaName());
    }

    public byte[] resolveSigningKeyBytes(JwsHeader jwsHeader, Claims claims) throws UnsupportedJwtException {
        throw new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support Claims JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, Claims) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, Claims) method.");
    }

    public byte[] resolveSigningKeyBytes(JwsHeader jwsHeader, String str) throws UnsupportedJwtException {
        throw new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support plaintext JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, String) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, String) method.");
    }

    public Key resolveSigningKey(JwsHeader jwsHeader, String str) {
        io.jsonwebtoken.SignatureAlgorithm cls = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "The default resolveSigningKey(JwsHeader, String) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, String) method instead and return a Key instance appropriate for the ";
        String name = cls.name();
        String str4 = " algorithm.";
        str = str3 + name + str4;
        Assert.isTrue(cls.isHmac(), str);
        return new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, str), cls.getJcaName());
    }
}
