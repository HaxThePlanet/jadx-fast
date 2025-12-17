package io.jsonwebtoken;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public interface JwtParser {

    public static final char SEPARATOR_CHAR = '.';
    @Deprecated
    public abstract io.jsonwebtoken.JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer);

    public abstract boolean isSigned(String string);

    public abstract io.jsonwebtoken.Jwt parse(String string);

    public abstract <T> T parse(String string, io.jsonwebtoken.JwtHandler<T> jwtHandler2);

    public abstract io.jsonwebtoken.Jws<io.jsonwebtoken.Claims> parseClaimsJws(String string);

    public abstract io.jsonwebtoken.Jwt<io.jsonwebtoken.Header, io.jsonwebtoken.Claims> parseClaimsJwt(String string);

    public abstract io.jsonwebtoken.Jws<String> parsePlaintextJws(String string);

    public abstract io.jsonwebtoken.Jwt<io.jsonwebtoken.Header, String> parsePlaintextJwt(String string);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser require(String string, Object object2);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser requireAudience(String string);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser requireExpiration(Date date);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser requireId(String string);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser requireIssuedAt(Date date);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser requireIssuer(String string);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser requireNotBefore(Date date);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser requireSubject(String string);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser setAllowedClockSkewSeconds(long l);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser setClock(io.jsonwebtoken.Clock clock);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser setCompressionCodecResolver(io.jsonwebtoken.CompressionCodecResolver compressionCodecResolver);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser setSigningKey(String string);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser setSigningKey(Key key);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser setSigningKey(byte[] bArr);

    @Deprecated
    public abstract io.jsonwebtoken.JwtParser setSigningKeyResolver(io.jsonwebtoken.SigningKeyResolver signingKeyResolver);
}
