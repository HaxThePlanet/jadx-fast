package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtHandler;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/* compiled from: ImmutableJwtParser.java */
/* loaded from: classes3.dex */
class ImmutableJwtParser implements JwtParser {

    private final JwtParser jwtParser;
    ImmutableJwtParser(JwtParser jwtParser) {
        super();
        this.jwtParser = jwtParser;
    }

    private java.lang.IllegalStateException doNotMutate() {
        return new IllegalStateException("Cannot mutate a JwtParser created from JwtParserBuilder.build(), the mutable methods in JwtParser will be removed before version 1.0");
    }

    public JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder) {
        throw doNotMutate();
    }

    public JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer) {
        throw doNotMutate();
    }

    public boolean isSigned(String str) {
        return this.jwtParser.isSigned(str);
    }

    public Jwt parse(String str) {
        return this.jwtParser.parse(str);
    }

    public Jws<Claims> parseClaimsJws(String str) {
        return this.jwtParser.parseClaimsJws(str);
    }

    public Jwt<Header, Claims> parseClaimsJwt(String str) {
        return this.jwtParser.parseClaimsJwt(str);
    }

    public Jws<String> parsePlaintextJws(String str) {
        return this.jwtParser.parsePlaintextJws(str);
    }

    public Jwt<Header, String> parsePlaintextJwt(String str) {
        return this.jwtParser.parsePlaintextJwt(str);
    }

    public JwtParser require(String str, Object object) {
        throw doNotMutate();
    }

    public JwtParser requireAudience(String str) {
        throw doNotMutate();
    }

    public JwtParser requireExpiration(Date date) {
        throw doNotMutate();
    }

    public JwtParser requireId(String str) {
        throw doNotMutate();
    }

    public JwtParser requireIssuedAt(Date date) {
        throw doNotMutate();
    }

    public JwtParser requireIssuer(String str) {
        throw doNotMutate();
    }

    public JwtParser requireNotBefore(Date date) {
        throw doNotMutate();
    }

    public JwtParser requireSubject(String str) {
        throw doNotMutate();
    }

    public JwtParser setAllowedClockSkewSeconds(long j) {
        throw doNotMutate();
    }

    public JwtParser setClock(Clock clock) {
        throw doNotMutate();
    }

    public JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver) {
        throw doNotMutate();
    }

    public JwtParser setSigningKey(byte[] bArr) {
        throw doNotMutate();
    }

    public JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver) {
        throw doNotMutate();
    }

    public <T> T parse(String str, JwtHandler<T> jwtHandler) {
        return this.jwtParser.parse(str, jwtHandler);
    }

    public JwtParser setSigningKey(String str) {
        throw doNotMutate();
    }

    public JwtParser setSigningKey(Key key) {
        throw doNotMutate();
    }
}
