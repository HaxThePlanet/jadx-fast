package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtHandler;
import io.jsonwebtoken.JwtHandlerAdapter;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.compression.DefaultCompressionCodecResolver;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import io.jsonwebtoken.impl.crypto.JwtSignatureValidator;
import io.jsonwebtoken.impl.lang.LegacyServices;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DeserializationException;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.DateFormats;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import java.security.Key;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: DefaultJwtParser.java */
/* loaded from: classes3.dex */
public class DefaultJwtParser implements JwtParser {

    private static final int MILLISECONDS_PER_SECOND = 1000;
    private long allowedClockSkewMillis = 0;
    private Decoder<String, byte[]> base64UrlDecoder;
    private Clock clock;
    private CompressionCodecResolver compressionCodecResolver = new DefaultCompressionCodecResolver();
    private Deserializer<Map<String, ?>> deserializer;
    private Claims expectedClaims = new DefaultClaims();
    private Key key;
    private byte[] keyBytes;
    private SigningKeyResolver signingKeyResolver;
    @Deprecated
    public DefaultJwtParser() {
        super();
        DefaultCompressionCodecResolver defaultCompressionCodecResolver = new DefaultCompressionCodecResolver();
        this.base64UrlDecoder = Decoders.BASE64URL;
        io.jsonwebtoken.impl.DefaultClaims defaultClaims = new DefaultClaims();
        this.clock = DefaultClock.INSTANCE;
    }

    private static Object normalize(Object object) {
        Long num;
        z = object instanceof Integer;
        if (object instanceof Integer) {
            num = Long.valueOf(object.longValue());
        }
        return num;
    }

    private void validateExpectedClaims(Header header, Claims claims) throws IncorrectClaimException {
        Object normalize2;
        String formatted;
        MissingClaimException missingClaimException = null;
        boolean equals;
        Iterator it = this.expectedClaims.keySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Object normalize = DefaultJwtParser.normalize(this.expectedClaims.get(item));
            normalize2 = DefaultJwtParser.normalize(claims.get(item));
            z = normalize instanceof Date;
            Object[] arr = new Object[i3];
            arr[i2] = item;
            arr[i] = normalize;
            missingClaimException = new MissingClaimException(header, claims, String.format("Expected %s claim to be: %s, but was not present in the JWT claims.", arr));
            if ("Expected %s claim to be: %s, but was not present in the JWT claims." != null) {
                missingClaimException.setClaimName(item);
                missingClaimException.setClaimValue(normalize);
                throw missingClaimException;
            }
        }
    }

    public JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder) {
        Assert.notNull(decoder, "base64UrlDecoder cannot be null.");
        this.base64UrlDecoder = decoder;
        return this;
    }

    protected JwtSignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        return new DefaultJwtSignatureValidator(signatureAlgorithm, key, this.base64UrlDecoder);
    }

    public JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer) {
        Assert.notNull(deserializer, "deserializer cannot be null.");
        this.deserializer = deserializer;
        return this;
    }

    public boolean isSigned(String str) {
        boolean z = false;
        int i;
        i = 0;
        if (str == null) {
            return false;
        }
        while (i < str.length()) {
            char charAt = str.charAt(i);
            int i2 = 2;
            char c = '.';
            if (i == 2) {
            }
        }
        return false;
    }

    public Jwt parse(String str) throws MalformedJwtException, SignatureException, ExpiredJwtException, UnsupportedJwtException, PrematureJwtException, java.io.UnsupportedEncodingException {
        String str3;
        String str4;
        int i;
        String string;
        Date date;
        io.jsonwebtoken.impl.DefaultHeader defaultHeader;
        SignatureAlgorithm cls = null;
        long l = 0;
        int i2;
        boolean empty;
        String str5;
        Key resolveSigningKey;
        byte[] decompress;
        io.jsonwebtoken.impl.DefaultClaims defaultClaims;
        Object obj2;
        long time;
        Object obj3;
        char c2;
        boolean text;
        SigningKeyResolver signingKeyResolver2;
        boolean empty2;
        Date expiration;
        final Object str7 = this;
        String str2 = str;
        if (str7.deserializer == null) {
            str7.deserializer = (Deserializer)LegacyServices.loadFirst(Deserializer.class);
        }
        Assert.hasText(str2, "JWT String argument cannot be null or empty.");
        if ("..".equals(str2)) {
            throw new MalformedJwtException("JWT string '..' is missing a header.");
        } else {
            StringBuilder stringBuilder2 = new StringBuilder(128);
            char[] charArray = str.toCharArray();
            i = 0;
            i2 = 0;
            char c = '.';
            i2 = 1;
            for (char c2 : charArray) {
            }
            if (i2 != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                String str11 = "JWT strings must contain exactly 2 period characters. Found: ";
                r0 = str11 + i2;
                throw new MalformedJwtException(r0);
            } else {
                if (stringBuilder2.length() > 0) {
                    str3 = stringBuilder2.toString();
                } else {
                }
                if (obj2 != null) {
                    Map value = str7.readValue(new String((byte[])str7.base64UrlDecoder.decode(obj2), Strings.UTF_8));
                    StringBuilder unsupportedJwtException = str3 != null ? new DefaultJwsHeader(value) : new DefaultHeader(value);
                    CompressionCodec resolveCompressionCodec = str7.compressionCodecResolver.resolveCompressionCodec((str3 != null ? new DefaultJwsHeader(value) : new DefaultHeader(value)));
                } else {
                }
                if (obj3 != null) {
                    if (".." != 0) {
                        decompress = i.decompress((byte[])str7.base64UrlDecoder.decode(obj3));
                    }
                    string = new String(decompress, Strings.UTF_8);
                } else {
                    string = "";
                }
                if (!string.isEmpty()) {
                    if (string.charAt(i2) == '{') {
                        if (string.charAt(string.length() - i2) == '}') {
                            defaultClaims = new DefaultClaims(str7.readValue(string));
                        } else {
                        }
                    }
                }
                if (str3 != null) {
                    obj = defaultHeader;
                    if (charArray.length != null && Strings.hasText(algorithm)) {
                        cls = SignatureAlgorithm.forName(algorithm);
                    }
                    if (cls == null) {
                        throw new MalformedJwtException("JWT string has a digest/signature, but the header does not reference a valid signature algorithm.");
                    } else {
                        if (cls != SignatureAlgorithm.NONE) {
                            if (str7.key != null) {
                                if (str7.keyBytes != null) {
                                    throw new IllegalStateException("A key object and key bytes cannot both be specified. Choose either.");
                                }
                            }
                            if (str7.key != null || str7.keyBytes != null) {
                                if (str7.signingKeyResolver != null) {
                                    Throwable th = str7.key != null ? "a key object" : "key bytes";
                                    StringBuilder stringBuilder4 = new StringBuilder();
                                    String str17 = "A signing key resolver and ";
                                    th = " cannot both be specified. Choose either.";
                                    r0 = str17 + th + th;
                                    throw new IllegalStateException(str17 + (str7.key != null ? "a key object" : "key bytes") + (str7.key != null ? "a key object" : "key bytes"));
                                }
                            }
                            if (str7.key == null) {
                                if (Objects.isEmpty(str7.keyBytes) && str7.signingKeyResolver != null) {
                                    if (defaultClaims != null) {
                                        resolveSigningKey = str7.signingKeyResolver.resolveSigningKey(obj, defaultClaims);
                                    } else {
                                        resolveSigningKey = str7.signingKeyResolver.resolveSigningKey(obj, string);
                                    }
                                }
                                if (!Objects.isEmpty(str7.keyBytes)) {
                                    Assert.isTrue(cls.isHmac(), "Key bytes can only be specified for HMAC signatures. Please specify a PublicKey or PrivateKey instance.");
                                    SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes23, cls.getJcaName());
                                }
                            }
                            Assert.notNull(resolveSigningKey, "A signing key must be specified if the specified JWT is digitally signed.");
                            StringBuilder stringBuilder6 = new StringBuilder();
                            str5 = obj2 + '.';
                            if (obj3 != null) {
                                StringBuilder stringBuilder7 = new StringBuilder();
                                str5 = str5 + obj3;
                            }
                            try {
                                cls.assertValidVerificationKey(resolveSigningKey);
                            } catch (java.lang.IllegalArgumentException iae) {
                            } catch (io.jsonwebtoken.security.InvalidKeyException invalidKey1) {
                            } catch (io.jsonwebtoken.security.WeakKeyException weakKey2) {
                                throw weakKey2;
                            }
                            if (!str7.createSignatureValidator(cls, resolveSigningKey).isValid(str5, str3)) {
                                throw new SignatureException("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                            }
                        }
                    }
                }
                long l2 = 0L;
                if (str7.allowedClockSkewMillis <= l2) {
                }
                if (defaultClaims != null) {
                    date = str7.clock.now();
                    time = date.getTime();
                    expiration = defaultClaims.getExpiration();
                    String str21 = " milliseconds.";
                    String str23 = " milliseconds.  Allowed clock skew: ";
                    String str24 = ", a difference of ";
                    String str25 = ". Current time: ";
                    if (expiration != null) {
                        l = time - str7.allowedClockSkewMillis;
                        String str8 = i2 != 0 ? new Date(l, expiration) : date;
                        if ((i2 != 0 ? new Date(l, expiration) : date).after(expiration)) {
                            boolean z = false;
                            String formatIso86012 = DateFormats.formatIso8601(expiration, z);
                            String formatIso86013 = DateFormats.formatIso8601(date, z);
                            l -= time3;
                            StringBuilder stringBuilder5 = new StringBuilder();
                            String str20 = "JWT expired at ";
                            r0 = str20 + formatIso86012 + ". Current time: " + formatIso86013 + str24 + l4 + " milliseconds.  Allowed clock skew: " + str7.allowedClockSkewMillis + " milliseconds.";
                            throw new ExpiredJwtException(defaultHeader, defaultClaims, r0);
                        } else {
                            Date notBefore = defaultClaims.getNotBefore();
                            if (notBefore != null) {
                                time = time + str7.allowedClockSkewMillis;
                                Date r5 = i2 != 0 ? new Date(time, obj3) : date;
                                if ((i2 != 0 ? new Date(time, obj3) : date).before(notBefore)) {
                                    boolean z2 = false;
                                    String formatIso8601 = DateFormats.formatIso8601(notBefore, z2);
                                    String formatIso86014 = DateFormats.formatIso8601(date, z2);
                                    long l3 = notBefore.getTime() - time;
                                    StringBuilder stringBuilder3 = new StringBuilder();
                                    String str19 = "JWT must not be accepted before ";
                                    r0 = str19 + formatIso8601 + ". Current time: " + formatIso86014 + str24 + l3 + " milliseconds.  Allowed clock skew: " + str7.allowedClockSkewMillis + " milliseconds.";
                                    throw new PrematureJwtException(defaultHeader, defaultClaims, r0);
                                }
                            }
                            str7.validateExpectedClaims(defaultHeader, defaultClaims);
                        }
                    }
                } else {
                }
                str8 = defaultClaims != null ? defaultClaims : string;
                if (str3 != null) {
                    return new DefaultJws(defaultHeader, string, str3);
                }
                return new DefaultJwt(defaultHeader, string);
            }
        }
    }

    public Jws<Claims> parseClaimsJws(String str) {
        return (Jws)parse(str, new DefaultJwtParser.AnonymousClass4(this));
    }

    public Jwt<Header, Claims> parseClaimsJwt(String str) throws UnsupportedJwtException {
        try {
        } catch (java.lang.IllegalArgumentException iae) {
            throw new UnsupportedJwtException("Signed JWSs are not supported.", iae);
        }
        return (Jwt)parse(str, new DefaultJwtParser.AnonymousClass2(this));
    }

    public Jws<String> parsePlaintextJws(String str) throws UnsupportedJwtException {
        try {
        } catch (java.lang.IllegalArgumentException iae) {
            throw new UnsupportedJwtException("Signed JWSs are not supported.", iae);
        }
        return (Jws)parse(str, new DefaultJwtParser.AnonymousClass3(this));
    }

    public Jwt<Header, String> parsePlaintextJwt(String str) {
        return (Jwt)parse(str, new DefaultJwtParser.AnonymousClass1(this));
    }

    protected Map<String, ?> readValue(String str) throws MalformedJwtException, java.io.UnsupportedEncodingException {
        try {
        } catch (io.jsonwebtoken.io.DeserializationException deserialization) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Unable to read JSON value: ";
            str = str2 + str;
            throw new MalformedJwtException(str, deserialization);
        }
        return (Map)this.deserializer.deserialize(str.getBytes(Strings.UTF_8));
    }

    public JwtParser require(String str, Object object) {
        Assert.hasText(str, "claim name cannot be null or empty.");
        StringBuilder stringBuilder = new StringBuilder();
        final String str4 = "The value cannot be null for claim name: ";
        str3 = str4 + str;
        Assert.notNull(object, str3);
        this.expectedClaims.put(str, object);
        return this;
    }

    public JwtParser requireAudience(String str) {
        this.expectedClaims.setAudience(str);
        return this;
    }

    public JwtParser requireExpiration(Date date) {
        this.expectedClaims.setExpiration(date);
        return this;
    }

    public JwtParser requireId(String str) {
        this.expectedClaims.setId(str);
        return this;
    }

    public JwtParser requireIssuedAt(Date date) {
        this.expectedClaims.setIssuedAt(date);
        return this;
    }

    public JwtParser requireIssuer(String str) {
        this.expectedClaims.setIssuer(str);
        return this;
    }

    public JwtParser requireNotBefore(Date date) {
        this.expectedClaims.setNotBefore(date);
        return this;
    }

    public JwtParser requireSubject(String str) {
        this.expectedClaims.setSubject(str);
        return this;
    }

    public JwtParser setAllowedClockSkewSeconds(long j) {
        boolean z = true;
        int r0 = j <= 9223372036854775L ? 1 : 0;
        final String str = "Illegal allowedClockSkewMillis value: multiplying this value by 1000 to obtain the number of milliseconds would cause a numeric overflow.";
        Assert.isTrue((j <= 9223372036854775L ? 1 : 0), "Illegal allowedClockSkewMillis value: multiplying this value by 1000 to obtain the number of milliseconds would cause a numeric overflow.");
        this.allowedClockSkewMillis = Math.max(0, "Illegal allowedClockSkewMillis value: multiplying this value by 1000 to obtain the number of milliseconds would cause a numeric overflow.", j * 1000, r6);
        return this;
    }

    public JwtParser setClock(Clock clock) {
        Assert.notNull(clock, "Clock instance cannot be null.");
        this.clock = clock;
        return this;
    }

    public JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver) {
        Assert.notNull(compressionCodecResolver, "compressionCodecResolver cannot be null.");
        this.compressionCodecResolver = compressionCodecResolver;
        return this;
    }

    public JwtParser setSigningKey(byte[] bArr) {
        Assert.notEmpty(bArr, "signing key cannot be null or empty.");
        this.keyBytes = bArr;
        return this;
    }

    public JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver) {
        Assert.notNull(signingKeyResolver, "SigningKeyResolver cannot be null.");
        this.signingKeyResolver = signingKeyResolver;
        return this;
    }

    public JwtParser setSigningKey(String str) {
        Assert.hasText(str, "signing key cannot be null or empty.");
        this.keyBytes = (byte[])Decoders.BASE64.decode(str);
        return this;
    }

    public JwtParser setSigningKey(Key key) {
        Assert.notNull(key, "signing key cannot be null.");
        this.key = key;
        return this;
    }

    DefaultJwtParser(SigningKeyResolver signingKeyResolver, Key key, byte[] bArr, Clock clock, long j, Claims claims, Decoder<String, byte[]> decoder, Deserializer<Map<String, ?>> deserializer, CompressionCodecResolver compressionCodecResolver) {
        super();
        DefaultCompressionCodecResolver defaultCompressionCodecResolver = new DefaultCompressionCodecResolver();
        this.base64UrlDecoder = Decoders.BASE64URL;
        io.jsonwebtoken.impl.DefaultClaims defaultClaims = new DefaultClaims();
        this.clock = DefaultClock.INSTANCE;
        this.signingKeyResolver = signingKeyResolver;
        this.key = key;
        this.keyBytes = bArr;
        this.clock = clock;
        this.allowedClockSkewMillis = j;
        this.expectedClaims = claims;
        this.base64UrlDecoder = decoder;
        this.deserializer = deserializer;
        this.compressionCodecResolver = compressionCodecResolver;
    }

    public <T> T parse(String str, JwtHandler<T> jwtHandler) {
        Assert.notNull(jwtHandler, "JwtHandler argument cannot be null.");
        Assert.hasText(str, "JWT String argument cannot be null or empty.");
        Jwt parse = parse(str);
        if (parse instanceof Jws) {
            if (parse.getBody() instanceof Claims) {
                return jwtHandler.onClaimsJws(parse);
            }
            return jwtHandler.onPlaintextJws(parse);
        }
        if (parse.getBody() instanceof Claims) {
            return jwtHandler.onClaimsJwt(parse);
        }
        return jwtHandler.onPlaintextJwt(parse);
    }
}
