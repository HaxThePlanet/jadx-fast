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
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.DateFormats;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class DefaultJwtParser implements JwtParser {

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
    @Deprecated
    public DefaultJwtParser() {
        super();
        DefaultCompressionCodecResolver defaultCompressionCodecResolver = new DefaultCompressionCodecResolver();
        this.compressionCodecResolver = defaultCompressionCodecResolver;
        this.base64UrlDecoder = Decoders.BASE64URL;
        DefaultClaims defaultClaims = new DefaultClaims();
        this.expectedClaims = defaultClaims;
        this.clock = DefaultClock.INSTANCE;
        int i = 0;
    }

    DefaultJwtParser(SigningKeyResolver signingKeyResolver, Key key2, byte[] b3Arr3, Clock clock4, long l5, Claims claims6, Decoder<String, byte[]> decoder7, Deserializer<Map<String, ?>> deserializer8, CompressionCodecResolver compressionCodecResolver9) {
        super();
        DefaultCompressionCodecResolver defaultCompressionCodecResolver = new DefaultCompressionCodecResolver();
        this.compressionCodecResolver = defaultCompressionCodecResolver;
        this.base64UrlDecoder = Decoders.BASE64URL;
        DefaultClaims defaultClaims = new DefaultClaims();
        this.expectedClaims = defaultClaims;
        this.clock = DefaultClock.INSTANCE;
        int i = 0;
        this.signingKeyResolver = signingKeyResolver;
        this.key = key2;
        this.keyBytes = b3Arr3;
        this.clock = clock4;
        this.allowedClockSkewMillis = l5;
        this.expectedClaims = decoder7;
        this.base64UrlDecoder = deserializer8;
        this.deserializer = compressionCodecResolver9;
        this.compressionCodecResolver = obj12;
    }

    private static Object normalize(Object object) {
        boolean longValue;
        Object obj2;
        if (object instanceof Integer) {
            obj2 = Long.valueOf((Integer)object.longValue());
        }
        return obj2;
    }

    private void validateExpectedClaims(Header header, Claims claims2) {
        Object incorrectClaimException2;
        Object normalize;
        Object normalize2;
        int incorrectClaimException;
        boolean obj;
        int i;
        int i3;
        int i2;
        boolean equals;
        Iterator iterator = this.expectedClaims.keySet().iterator();
        while (iterator.hasNext()) {
            incorrectClaimException2 = iterator.next();
            normalize = DefaultJwtParser.normalize(this.expectedClaims.get((String)incorrectClaimException2));
            normalize2 = DefaultJwtParser.normalize(claims2.get(incorrectClaimException2));
            if (normalize instanceof Date) {
            }
            incorrectClaimException = 0;
            i = 1;
            i3 = 0;
            i2 = 2;
            if (normalize2 == null) {
            } else {
            }
            if (!normalize.equals(normalize2)) {
            }
            Object[] arr2 = new Object[3];
            arr2[i3] = incorrectClaimException2;
            arr2[i] = normalize;
            arr2[i2] = normalize2;
            incorrectClaimException = new IncorrectClaimException(header, claims2, String.format("Expected %s claim to be: %s, but was: %s.", arr2));
            Object[] arr = new Object[i2];
            arr[i3] = incorrectClaimException2;
            arr[i] = normalize;
            incorrectClaimException = new MissingClaimException(header, claims2, String.format("Expected %s claim to be: %s, but was not present in the JWT claims.", arr));
            normalize2 = claims2.get(incorrectClaimException2, Date.class);
        }
    }

    public JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder) {
        Assert.notNull(decoder, "base64UrlDecoder cannot be null.");
        this.base64UrlDecoder = decoder;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    protected JwtSignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key2) {
        DefaultJwtSignatureValidator defaultJwtSignatureValidator = new DefaultJwtSignatureValidator(signatureAlgorithm, key2, this.base64UrlDecoder);
        return defaultJwtSignatureValidator;
    }

    public JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer) {
        Assert.notNull(deserializer, "deserializer cannot be null.");
        this.deserializer = deserializer;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public boolean isSigned(String string) {
        int i3;
        int i5;
        int i2;
        char charAt;
        int i4;
        int i;
        i3 = 0;
        if (string == null) {
            return i3;
        }
        i2 = i5;
        while (i5 < string.length()) {
            charAt = string.charAt(i5);
            i = 46;
            if (charAt == i) {
            }
            i5++;
            i2++;
        }
        return i3;
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt parse(String string) {
        String string3;
        String str;
        Object deserializer;
        int resolveCompressionCodec;
        String notBefore;
        int i;
        Date date;
        io.jsonwebtoken.impl.DefaultHeader defaultJwsHeader;
        int forName;
        int cmp;
        int before;
        Date date2;
        int decompress;
        boolean charAt;
        int resolveSigningKey;
        int uTF_8;
        int defaultClaims;
        int stringBuilder;
        long allowedClockSkewMillis;
        int i3;
        int string2;
        int i2;
        char secretKeySpec;
        int str3;
        boolean signingKeyResolver2;
        boolean signingKeyResolver;
        Date date3;
        String str2;
        final Object obj = this;
        String str4 = string;
        if (obj.deserializer == null) {
            obj.deserializer = (Deserializer)LegacyServices.loadFirst(Deserializer.class);
        }
        Assert.hasText(str4, "JWT String argument cannot be null or empty.");
        if ("..".equals(str4)) {
        } else {
            StringBuilder stringBuilder3 = new StringBuilder(128);
            char[] charArray = string.toCharArray();
            forName = 0;
            before = 0;
            i3 = stringBuilder;
            uTF_8 = decompress;
            string2 = 46;
            i2 = 1;
            while (decompress < charArray.length) {
                secretKeySpec = charArray[decompress];
                if (secretKeySpec == string2) {
                } else {
                }
                stringBuilder3.append(secretKeySpec);
                decompress++;
                string2 = 46;
                i2 = 1;
                java.lang.CharSequence clean = Strings.clean(stringBuilder3);
                if (clean != null) {
                } else {
                }
                string2 = forName;
                if (uTF_8 == 0) {
                } else {
                }
                if (uTF_8 == i2) {
                }
                uTF_8++;
                stringBuilder3.setLength(before);
                i3 = string2;
                stringBuilder = string2;
                string2 = clean.toString();
            }
            if (uTF_8 != 2) {
            } else {
                if (stringBuilder3.length() > 0) {
                    string3 = stringBuilder3.toString();
                } else {
                    string3 = forName;
                }
                if (stringBuilder != null) {
                    String string9 = new String((byte[])obj.base64UrlDecoder.decode(stringBuilder), Strings.UTF_8);
                    Map value = obj.readValue(string9);
                    if (string3 != null) {
                        defaultJwsHeader = new DefaultJwsHeader(value);
                    } else {
                        defaultJwsHeader = new DefaultHeader(value);
                    }
                    resolveCompressionCodec = obj.compressionCodecResolver.resolveCompressionCodec(defaultJwsHeader);
                } else {
                    defaultJwsHeader = resolveCompressionCodec;
                }
                if (i3 != 0) {
                    if (resolveCompressionCodec != 0) {
                        decompress = resolveCompressionCodec.decompress((byte[])obj.base64UrlDecoder.decode(i3));
                    }
                    notBefore = new String(decompress, Strings.UTF_8);
                } else {
                    notBefore = "";
                }
                if (!notBefore.isEmpty() && notBefore.charAt(before) == 123 && notBefore.charAt(length3 -= i2) == 125) {
                    if (notBefore.charAt(before) == 123) {
                        if (notBefore.charAt(length3 -= i2) == 125) {
                            defaultClaims = new DefaultClaims(obj.readValue(notBefore));
                        } else {
                            defaultClaims = forName;
                        }
                    } else {
                    }
                } else {
                }
                resolveSigningKey = defaultJwsHeader;
                secretKeySpec = (JwsHeader)resolveSigningKey.getAlgorithm();
                if (string3 != null && defaultJwsHeader != 0 && Strings.hasText(secretKeySpec)) {
                    resolveSigningKey = defaultJwsHeader;
                    if (defaultJwsHeader != 0) {
                        secretKeySpec = (JwsHeader)resolveSigningKey.getAlgorithm();
                        if (Strings.hasText(secretKeySpec)) {
                            forName = SignatureAlgorithm.forName(secretKeySpec);
                        }
                    }
                    if (forName == 0) {
                    } else {
                        if (forName == SignatureAlgorithm.NONE) {
                        } else {
                            secretKeySpec = obj.key;
                            if (secretKeySpec != null) {
                                if (obj.keyBytes != null) {
                                } else {
                                }
                                IllegalStateException illegalStateException = new IllegalStateException("A key object and key bytes cannot both be specified. Choose either.");
                                throw illegalStateException;
                            }
                            if (secretKeySpec == null) {
                                if (obj.keyBytes != null && obj.signingKeyResolver != null) {
                                    if (obj.signingKeyResolver != null) {
                                        str = secretKeySpec != null ? "a key object" : "key bytes";
                                        StringBuilder stringBuilder5 = new StringBuilder();
                                        stringBuilder5.append("A signing key resolver and ");
                                        stringBuilder5.append(str);
                                        stringBuilder5.append(" cannot both be specified. Choose either.");
                                        IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder5.toString());
                                        throw illegalStateException2;
                                    }
                                }
                            } else {
                            }
                            signingKeyResolver2 = obj.keyBytes;
                            signingKeyResolver = obj.signingKeyResolver;
                            if (secretKeySpec == null && Objects.isEmpty(signingKeyResolver2) && signingKeyResolver != null) {
                                signingKeyResolver2 = obj.keyBytes;
                                if (Objects.isEmpty(signingKeyResolver2)) {
                                    signingKeyResolver = obj.signingKeyResolver;
                                    if (signingKeyResolver != null) {
                                        if (defaultClaims != 0) {
                                            resolveSigningKey = signingKeyResolver.resolveSigningKey(resolveSigningKey, defaultClaims);
                                        } else {
                                            resolveSigningKey = signingKeyResolver.resolveSigningKey(resolveSigningKey, notBefore);
                                        }
                                        secretKeySpec = resolveSigningKey;
                                    }
                                }
                                if (!Objects.isEmpty(signingKeyResolver2)) {
                                    Assert.isTrue(forName.isHmac(), "Key bytes can only be specified for HMAC signatures. Please specify a PublicKey or PrivateKey instance.");
                                    secretKeySpec = new SecretKeySpec(signingKeyResolver2, forName.getJcaName());
                                }
                            }
                            Assert.notNull(secretKeySpec, "A signing key must be specified if the specified JWT is digitally signed.");
                            StringBuilder stringBuilder7 = new StringBuilder();
                            stringBuilder7.append(stringBuilder);
                            stringBuilder7.append(string2);
                            if (i3 != 0) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(stringBuilder7.toString());
                                stringBuilder.append(i3);
                                charAt = stringBuilder.toString();
                            }
                            forName.assertValidVerificationKey(secretKeySpec);
                            if (!obj.createSignatureValidator(forName, secretKeySpec).isValid(charAt, string3)) {
                            } else {
                            }
                            SignatureException signatureException = new SignatureException("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                            throw signatureException;
                        }
                    }
                    MalformedJwtException malformedJwtException2 = new MalformedJwtException("JWT string has a digest/signature, but the header does not reference a valid signature algorithm.");
                    throw malformedJwtException2;
                }
                if (Long.compare(allowedClockSkewMillis, str3) > 0) {
                } else {
                    i2 = before;
                }
                if (defaultClaims != 0) {
                    cmp = obj.clock.now();
                    allowedClockSkewMillis = cmp.getTime();
                    charAt = defaultClaims.getExpiration();
                    string2 = " milliseconds.";
                    str3 = " milliseconds.  Allowed clock skew: ";
                    signingKeyResolver2 = ", a difference of ";
                    signingKeyResolver = ". Current time: ";
                    if (charAt != null) {
                        date3 = charAt;
                        before = allowedClockSkewMillis - allowedClockSkewMillis4;
                        str2 = notBefore;
                        if (i2 != 0) {
                            date = new Date(before, charAt);
                        } else {
                            date = cmp;
                        }
                        if (date.after(date3)) {
                        } else {
                            notBefore = defaultClaims.getNotBefore();
                            if (notBefore != null) {
                                allowedClockSkewMillis += allowedClockSkewMillis3;
                                if (i2 != 0) {
                                    date2 = new Date(allowedClockSkewMillis, i3);
                                } else {
                                    date2 = cmp;
                                }
                                if (date2.before(notBefore)) {
                                } else {
                                }
                                int i7 = 0;
                                time -= allowedClockSkewMillis;
                                StringBuilder stringBuilder4 = new StringBuilder();
                                stringBuilder4.append("JWT must not be accepted before ");
                                stringBuilder4.append(DateFormats.formatIso8601(notBefore, i7));
                                stringBuilder4.append(signingKeyResolver);
                                stringBuilder4.append(DateFormats.formatIso8601(cmp, i7));
                                stringBuilder4.append(signingKeyResolver2);
                                stringBuilder4.append(i8);
                                stringBuilder4.append(str3);
                                stringBuilder4.append(obj.allowedClockSkewMillis);
                                stringBuilder4.append(string2);
                                PrematureJwtException prematureJwtException = new PrematureJwtException(defaultJwsHeader, defaultClaims, stringBuilder4.toString());
                                throw prematureJwtException;
                            }
                            obj.validateExpectedClaims(defaultJwsHeader, defaultClaims);
                        }
                        int i5 = 0;
                        StringBuilder stringBuilder6 = new StringBuilder();
                        stringBuilder6.append("JWT expired at ");
                        stringBuilder6.append(DateFormats.formatIso8601(date3, i5));
                        stringBuilder6.append(signingKeyResolver);
                        stringBuilder6.append(DateFormats.formatIso8601(cmp, i5));
                        stringBuilder6.append(signingKeyResolver2);
                        stringBuilder6.append(before -= time2);
                        stringBuilder6.append(str3);
                        stringBuilder6.append(obj.allowedClockSkewMillis);
                        stringBuilder6.append(string2);
                        ExpiredJwtException expiredJwtException = new ExpiredJwtException(defaultJwsHeader, defaultClaims, stringBuilder6.toString());
                        throw expiredJwtException;
                    }
                    str2 = notBefore;
                } else {
                    str2 = notBefore;
                }
                i = defaultClaims != 0 ? defaultClaims : str2;
                if (string3 != null) {
                    DefaultJws defaultJws = new DefaultJws((JwsHeader)defaultJwsHeader, i, string3);
                    return defaultJws;
                }
                DefaultJwt defaultJwt = new DefaultJwt(defaultJwsHeader, i);
                return defaultJwt;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("JWT strings must contain exactly 2 period characters. Found: ");
            stringBuilder2.append(uTF_8);
            MalformedJwtException malformedJwtException3 = new MalformedJwtException(stringBuilder2.toString());
            throw malformedJwtException3;
        }
        MalformedJwtException malformedJwtException = new MalformedJwtException("JWT string '..' is missing a header.");
        throw malformedJwtException;
    }

    public <T> T parse(String string, JwtHandler<T> jwtHandler2) {
        Assert.notNull(jwtHandler2, "JwtHandler argument cannot be null.");
        Assert.hasText(string, "JWT String argument cannot be null or empty.");
        Jwt obj2 = parse(string);
        if (obj2 instanceof Jws && body instanceof Claims) {
            if (body instanceof Claims) {
                return jwtHandler2.onClaimsJws(obj2);
            }
            return jwtHandler2.onPlaintextJws(obj2);
        }
        if (body2 instanceof Claims) {
            return jwtHandler2.onClaimsJwt(obj2);
        }
        return jwtHandler2.onPlaintextJwt(obj2);
    }

    public Jws<Claims> parseClaimsJws(String string) {
        DefaultJwtParser.4 anon = new DefaultJwtParser.4(this);
        return (Jws)parse(string, anon);
    }

    public Jwt<Header, Claims> parseClaimsJwt(String string) {
        try {
            DefaultJwtParser.2 anon = new DefaultJwtParser.2(this);
            return (Jwt)parse(string, anon);
            UnsupportedJwtException unsupportedJwtException = new UnsupportedJwtException("Signed JWSs are not supported.", string);
            throw unsupportedJwtException;
        }
    }

    public Jws<String> parsePlaintextJws(String string) {
        try {
            DefaultJwtParser.3 anon = new DefaultJwtParser.3(this);
            return (Jws)parse(string, anon);
            UnsupportedJwtException unsupportedJwtException = new UnsupportedJwtException("Signed JWSs are not supported.", string);
            throw unsupportedJwtException;
        }
    }

    public Jwt<Header, String> parsePlaintextJwt(String string) {
        DefaultJwtParser.1 anon = new DefaultJwtParser.1(this);
        return (Jwt)parse(string, anon);
    }

    protected Map<String, ?> readValue(String string) {
        try {
            return (Map)this.deserializer.deserialize(string.getBytes(Strings.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to read JSON value: ");
            stringBuilder.append(string);
            string = stringBuilder.toString();
            MalformedJwtException malformedJwtException = new MalformedJwtException(string, th);
            throw malformedJwtException;
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser require(String string, Object object2) {
        Assert.hasText(string, "claim name cannot be null or empty.");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The value cannot be null for claim name: ");
        stringBuilder.append(string);
        Assert.notNull(object2, stringBuilder.toString());
        this.expectedClaims.put(string, object2);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireAudience(String string) {
        this.expectedClaims.setAudience(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireExpiration(Date date) {
        this.expectedClaims.setExpiration(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireId(String string) {
        this.expectedClaims.setId(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireIssuedAt(Date date) {
        this.expectedClaims.setIssuedAt(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireIssuer(String string) {
        this.expectedClaims.setIssuer(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireNotBefore(Date date) {
        this.expectedClaims.setNotBefore(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireSubject(String string) {
        this.expectedClaims.setSubject(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setAllowedClockSkewSeconds(long l) {
        int i;
        i = Long.compare(l, l2) <= 0 ? 1 : 0;
        final String str = "Illegal allowedClockSkewMillis value: multiplying this value by 1000 to obtain the number of milliseconds would cause a numeric overflow.";
        Assert.isTrue(i, str);
        this.allowedClockSkewMillis = Math.max(0, str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setClock(Clock clock) {
        Assert.notNull(clock, "Clock instance cannot be null.");
        this.clock = clock;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver) {
        Assert.notNull(compressionCodecResolver, "compressionCodecResolver cannot be null.");
        this.compressionCodecResolver = compressionCodecResolver;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(String string) {
        Assert.hasText(string, "signing key cannot be null or empty.");
        this.keyBytes = (byte[])Decoders.BASE64.decode(string);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(Key key) {
        Assert.notNull(key, "signing key cannot be null.");
        this.key = key;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(byte[] bArr) {
        Assert.notEmpty(bArr, "signing key cannot be null or empty.");
        this.keyBytes = bArr;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver) {
        Assert.notNull(signingKeyResolver, "SigningKeyResolver cannot be null.");
        this.signingKeyResolver = signingKeyResolver;
        return this;
    }
}
