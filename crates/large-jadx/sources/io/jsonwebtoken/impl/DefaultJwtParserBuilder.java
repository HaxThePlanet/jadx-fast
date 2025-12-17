package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.impl.compression.DefaultCompressionCodecResolver;
import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultJwtParserBuilder implements JwtParserBuilder {

    static final String MAX_CLOCK_SKEW_ILLEGAL_MSG = "Illegal allowedClockSkewMillis value: multiplying this value by 1000 to obtain the number of milliseconds would cause a numeric overflow.";
    static final long MAX_CLOCK_SKEW_MILLIS = 9223372036854775L;
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private long allowedClockSkewMillis = 0;
    private Decoder<String, byte[]> base64UrlDecoder;
    private Clock clock;
    private CompressionCodecResolver compressionCodecResolver;
    private Deserializer<Map<String, ?>> deserializer;
    private Claims expectedClaims;
    private Key key;
    private byte[] keyBytes;
    private SigningKeyResolver signingKeyResolver;
    public DefaultJwtParserBuilder() {
        super();
        DefaultCompressionCodecResolver defaultCompressionCodecResolver = new DefaultCompressionCodecResolver();
        this.compressionCodecResolver = defaultCompressionCodecResolver;
        this.base64UrlDecoder = Decoders.BASE64URL;
        DefaultClaims defaultClaims = new DefaultClaims();
        this.expectedClaims = defaultClaims;
        this.clock = DefaultClock.INSTANCE;
        int i = 0;
    }

    public JwtParserBuilder base64UrlDecodeWith(Decoder<String, byte[]> decoder) {
        Assert.notNull(decoder, "base64UrlDecoder cannot be null.");
        this.base64UrlDecoder = decoder;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParser build() {
        Object deserializer;
        if (this.deserializer == null) {
            this.deserializer = (Deserializer)Services.loadFirst(Deserializer.class);
        }
        super(this.signingKeyResolver, this.key, this.keyBytes, this.clock, this.allowedClockSkewMillis, obj7, this.expectedClaims, this.base64UrlDecoder, this.deserializer, this.compressionCodecResolver);
        ImmutableJwtParser immutableJwtParser = new ImmutableJwtParser(defaultJwtParser2);
        return immutableJwtParser;
    }

    public JwtParserBuilder deserializeJsonWith(Deserializer<Map<String, ?>> deserializer) {
        Assert.notNull(deserializer, "deserializer cannot be null.");
        this.deserializer = deserializer;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder require(String string, Object object2) {
        Assert.hasText(string, "claim name cannot be null or empty.");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The value cannot be null for claim name: ");
        stringBuilder.append(string);
        Assert.notNull(object2, stringBuilder.toString());
        this.expectedClaims.put(string, object2);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireAudience(String string) {
        this.expectedClaims.setAudience(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireExpiration(Date date) {
        this.expectedClaims.setExpiration(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireId(String string) {
        this.expectedClaims.setId(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireIssuedAt(Date date) {
        this.expectedClaims.setIssuedAt(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireIssuer(String string) {
        this.expectedClaims.setIssuer(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireNotBefore(Date date) {
        this.expectedClaims.setNotBefore(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder requireSubject(String string) {
        this.expectedClaims.setSubject(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setAllowedClockSkewSeconds(long l) {
        int i;
        i = Long.compare(l, l2) <= 0 ? 1 : 0;
        final String str = "Illegal allowedClockSkewMillis value: multiplying this value by 1000 to obtain the number of milliseconds would cause a numeric overflow.";
        Assert.isTrue(i, str);
        this.allowedClockSkewMillis = Math.max(0, str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setClock(Clock clock) {
        Assert.notNull(clock, "Clock instance cannot be null.");
        this.clock = clock;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver) {
        Assert.notNull(compressionCodecResolver, "compressionCodecResolver cannot be null.");
        this.compressionCodecResolver = compressionCodecResolver;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setSigningKey(String string) {
        Assert.hasText(string, "signing key cannot be null or empty.");
        this.keyBytes = (byte[])Decoders.BASE64.decode(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setSigningKey(Key key) {
        Assert.notNull(key, "signing key cannot be null.");
        this.key = key;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setSigningKey(byte[] bArr) {
        Assert.notEmpty(bArr, "signing key cannot be null or empty.");
        this.keyBytes = bArr;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParserBuilder
    public JwtParserBuilder setSigningKeyResolver(SigningKeyResolver signingKeyResolver) {
        Assert.notNull(signingKeyResolver, "SigningKeyResolver cannot be null.");
        this.signingKeyResolver = signingKeyResolver;
        return this;
    }
}
