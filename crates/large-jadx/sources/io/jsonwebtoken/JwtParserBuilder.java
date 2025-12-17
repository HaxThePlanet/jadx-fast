package io.jsonwebtoken;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public interface JwtParserBuilder {
    public abstract io.jsonwebtoken.JwtParserBuilder base64UrlDecodeWith(Decoder<String, byte[]> decoder);

    public abstract io.jsonwebtoken.JwtParser build();

    public abstract io.jsonwebtoken.JwtParserBuilder deserializeJsonWith(Deserializer<Map<String, ?>> deserializer);

    public abstract io.jsonwebtoken.JwtParserBuilder require(String string, Object object2);

    public abstract io.jsonwebtoken.JwtParserBuilder requireAudience(String string);

    public abstract io.jsonwebtoken.JwtParserBuilder requireExpiration(Date date);

    public abstract io.jsonwebtoken.JwtParserBuilder requireId(String string);

    public abstract io.jsonwebtoken.JwtParserBuilder requireIssuedAt(Date date);

    public abstract io.jsonwebtoken.JwtParserBuilder requireIssuer(String string);

    public abstract io.jsonwebtoken.JwtParserBuilder requireNotBefore(Date date);

    public abstract io.jsonwebtoken.JwtParserBuilder requireSubject(String string);

    public abstract io.jsonwebtoken.JwtParserBuilder setAllowedClockSkewSeconds(long l);

    public abstract io.jsonwebtoken.JwtParserBuilder setClock(io.jsonwebtoken.Clock clock);

    public abstract io.jsonwebtoken.JwtParserBuilder setCompressionCodecResolver(io.jsonwebtoken.CompressionCodecResolver compressionCodecResolver);

    public abstract io.jsonwebtoken.JwtParserBuilder setSigningKey(String string);

    public abstract io.jsonwebtoken.JwtParserBuilder setSigningKey(Key key);

    public abstract io.jsonwebtoken.JwtParserBuilder setSigningKey(byte[] bArr);

    public abstract io.jsonwebtoken.JwtParserBuilder setSigningKeyResolver(io.jsonwebtoken.SigningKeyResolver signingKeyResolver);
}
