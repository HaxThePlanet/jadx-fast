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

/* loaded from: classes3.dex */
class ImmutableJwtParser implements JwtParser {

    private final JwtParser jwtParser;
    ImmutableJwtParser(JwtParser jwtParser) {
        super();
        this.jwtParser = jwtParser;
    }

    private java.lang.IllegalStateException doNotMutate() {
        IllegalStateException illegalStateException = new IllegalStateException("Cannot mutate a JwtParser created from JwtParserBuilder.build(), the mutable methods in JwtParser will be removed before version 1.0");
        return illegalStateException;
    }

    public JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder) {
        throw doNotMutate();
    }

    public JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public boolean isSigned(String string) {
        return this.jwtParser.isSigned(string);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt parse(String string) {
        return this.jwtParser.parse(string);
    }

    public <T> T parse(String string, JwtHandler<T> jwtHandler2) {
        return this.jwtParser.parse(string, jwtHandler2);
    }

    public Jws<Claims> parseClaimsJws(String string) {
        return this.jwtParser.parseClaimsJws(string);
    }

    public Jwt<Header, Claims> parseClaimsJwt(String string) {
        return this.jwtParser.parseClaimsJwt(string);
    }

    public Jws<String> parsePlaintextJws(String string) {
        return this.jwtParser.parsePlaintextJws(string);
    }

    public Jwt<Header, String> parsePlaintextJwt(String string) {
        return this.jwtParser.parsePlaintextJwt(string);
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser require(String string, Object object2) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireAudience(String string) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireExpiration(Date date) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireId(String string) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireIssuedAt(Date date) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireIssuer(String string) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireNotBefore(Date date) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireSubject(String string) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setAllowedClockSkewSeconds(long l) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setClock(Clock clock) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(String string) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(Key key) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(byte[] bArr) {
        throw doNotMutate();
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver) {
        throw doNotMutate();
    }
}
