package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.DefaultJwtSigner;
import io.jsonwebtoken.impl.crypto.JwtSigner;
import io.jsonwebtoken.impl.lang.LegacyServices;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import java.security.Key;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class DefaultJwtBuilder implements JwtBuilder {

    private SignatureAlgorithm algorithm;
    private Encoder<byte[], String> base64UrlEncoder;
    private Claims claims;
    private CompressionCodec compressionCodec;
    private Header header;
    private Key key;
    private String payload;
    private Serializer<Map<String, ?>> serializer;
    public DefaultJwtBuilder() {
        super();
        this.base64UrlEncoder = Encoders.BASE64URL;
    }

    public JwtBuilder addClaims(Map<String, Object> map) {
        ensureClaims().putAll(map);
        return this;
    }

    @Deprecated
    protected String base64UrlEncode(Object object, String string2) {
        Assert.isInstanceOf(Map.class, object, "object argument must be a map.");
        return (String)this.base64UrlEncoder.encode(toJson((Map)object));
    }

    public JwtBuilder base64UrlEncodeWith(Encoder<byte[], String> encoder) {
        Assert.notNull(encoder, "base64UrlEncoder cannot be null.");
        this.base64UrlEncoder = encoder;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder claim(String string, Object object2) {
        Claims ensureClaims;
        Assert.hasText(string, "Claim property name cannot be null or empty.");
        ensureClaims = this.claims;
        if (ensureClaims == null) {
            if (object2 != null) {
                ensureClaims().put(string, object2);
            }
        } else {
            if (object2 == null) {
                ensureClaims.remove(string);
            } else {
                ensureClaims.put(string, object2);
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public String compact() {
        Object serializer;
        String payload2;
        String payload;
        Header ensureHeader;
        String string2;
        io.jsonwebtoken.impl.DefaultJwsHeader defaultJwsHeader;
        String value;
        Object compressionCodec;
        byte[] compress;
        java.nio.charset.Charset string;
        Object stringBuilder2;
        StringBuilder stringBuilder;
        if (this.serializer == null) {
            this.serializer = (Serializer)LegacyServices.loadFirst(Serializer.class);
        }
        if (this.payload == null && Collections.isEmpty(this.claims)) {
            if (Collections.isEmpty(this.claims)) {
                this.payload = "";
            }
        }
        if (this.payload != null) {
            if (!Collections.isEmpty(this.claims)) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("Both 'payload' and 'claims' cannot both be specified. Choose either one.");
            throw illegalStateException;
        }
        ensureHeader = ensureHeader();
        if (ensureHeader instanceof JwsHeader) {
        } else {
            defaultJwsHeader = new DefaultJwsHeader((JwsHeader)ensureHeader);
            ensureHeader = defaultJwsHeader;
        }
        if (this.key != null) {
            ensureHeader.setAlgorithm(this.algorithm.getValue());
        } else {
            ensureHeader.setAlgorithm(SignatureAlgorithm.NONE.getValue());
        }
        compressionCodec = this.compressionCodec;
        if (compressionCodec != null) {
            ensureHeader.setCompressionAlgorithm(compressionCodec.getAlgorithmName());
        }
        String payload3 = this.payload;
        if (payload3 != null) {
            compress = payload3.getBytes(Strings.UTF_8);
        } else {
            compress = toJson(this.claims);
        }
        CompressionCodec compressionCodec2 = this.compressionCodec;
        if (compressionCodec2 != null) {
            compress = compressionCodec2.compress(compress);
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(base64UrlEncode(ensureHeader, "Unable to serialize header to json."));
        int i = 46;
        stringBuilder3.append(i);
        stringBuilder3.append((String)this.base64UrlEncoder.encode(compress));
        String string3 = stringBuilder3.toString();
        Key key2 = this.key;
        if (key2 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(i);
            stringBuilder.append(createSigner(this.algorithm, key2).sign(string3));
            string2 = stringBuilder.toString();
        } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string3);
            stringBuilder2.append(i);
            string2 = stringBuilder2.toString();
        }
        return string2;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder compressWith(CompressionCodec compressionCodec) {
        Assert.notNull(compressionCodec, "compressionCodec cannot be null");
        this.compressionCodec = compressionCodec;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    protected JwtSigner createSigner(SignatureAlgorithm signatureAlgorithm, Key key2) {
        DefaultJwtSigner defaultJwtSigner = new DefaultJwtSigner(signatureAlgorithm, key2, this.base64UrlEncoder);
        return defaultJwtSigner;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    protected Claims ensureClaims() {
        Claims defaultClaims;
        if (this.claims == null) {
            defaultClaims = new DefaultClaims();
            this.claims = defaultClaims;
        }
        return this.claims;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    protected Header ensureHeader() {
        Header defaultHeader;
        if (this.header == null) {
            defaultHeader = new DefaultHeader();
            this.header = defaultHeader;
        }
        return this.header;
    }

    public JwtBuilder serializeToJsonWith(Serializer<Map<String, ?>> serializer) {
        Assert.notNull(serializer, "Serializer cannot be null.");
        this.serializer = serializer;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public ClaimsMutator setAudience(String string) {
        return setAudience(string);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setAudience(String string) {
        Claims ensureClaims;
        if (Strings.hasText(string)) {
            ensureClaims().setAudience(string);
        } else {
            ensureClaims = this.claims;
            if (ensureClaims != null) {
                ensureClaims.setAudience(string);
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setClaims(Claims claims) {
        this.claims = claims;
        return this;
    }

    public JwtBuilder setClaims(Map<String, ?> map) {
        DefaultClaims defaultClaims = new DefaultClaims(map);
        this.claims = defaultClaims;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public ClaimsMutator setExpiration(Date date) {
        return setExpiration(date);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setExpiration(Date date) {
        Claims ensureClaims;
        if (date != null) {
            ensureClaims().setExpiration(date);
        } else {
            ensureClaims = this.claims;
            if (ensureClaims != null) {
                ensureClaims.setExpiration(date);
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setHeader(Header header) {
        this.header = header;
        return this;
    }

    public JwtBuilder setHeader(Map<String, Object> map) {
        DefaultHeader defaultHeader = new DefaultHeader(map);
        this.header = defaultHeader;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setHeaderParam(String string, Object object2) {
        ensureHeader().put(string, object2);
        return this;
    }

    public JwtBuilder setHeaderParams(Map<String, Object> map) {
        boolean ensureHeader;
        Object value;
        Object key;
        Object obj4;
        if (!Collections.isEmpty(map)) {
            obj4 = map.entrySet().iterator();
            for (Map.Entry next : obj4) {
                ensureHeader().put(next.getKey(), next.getValue());
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public ClaimsMutator setId(String string) {
        return setId(string);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setId(String string) {
        Claims ensureClaims;
        if (Strings.hasText(string)) {
            ensureClaims().setId(string);
        } else {
            ensureClaims = this.claims;
            if (ensureClaims != null) {
                ensureClaims.setId(string);
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public ClaimsMutator setIssuedAt(Date date) {
        return setIssuedAt(date);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setIssuedAt(Date date) {
        Claims ensureClaims;
        if (date != null) {
            ensureClaims().setIssuedAt(date);
        } else {
            ensureClaims = this.claims;
            if (ensureClaims != null) {
                ensureClaims.setIssuedAt(date);
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public ClaimsMutator setIssuer(String string) {
        return setIssuer(string);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setIssuer(String string) {
        Claims ensureClaims;
        if (Strings.hasText(string)) {
            ensureClaims().setIssuer(string);
        } else {
            ensureClaims = this.claims;
            if (ensureClaims != null) {
                ensureClaims.setIssuer(string);
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public ClaimsMutator setNotBefore(Date date) {
        return setNotBefore(date);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setNotBefore(Date date) {
        Claims ensureClaims;
        if (date != null) {
            ensureClaims().setNotBefore(date);
        } else {
            ensureClaims = this.claims;
            if (ensureClaims != null) {
                ensureClaims.setNotBefore(date);
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setPayload(String string) {
        this.payload = string;
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public ClaimsMutator setSubject(String string) {
        return setSubject(string);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder setSubject(String string) {
        Claims ensureClaims;
        if (Strings.hasText(string)) {
            ensureClaims().setSubject(string);
        } else {
            ensureClaims = this.claims;
            if (ensureClaims != null) {
                ensureClaims.setSubject(string);
            }
        }
        return this;
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, String string2) {
        Assert.hasText(string2, "base64-encoded secret key cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Base64-encoded key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith(signatureAlgorithm, (byte[])Decoders.BASE64.decode(string2));
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, Key key2) {
        return signWith(key2, signatureAlgorithm);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, byte[] b2Arr2) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notEmpty(b2Arr2, "secret key byte array cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        SecretKeySpec secretKeySpec = new SecretKeySpec(b2Arr2, signatureAlgorithm.getJcaName());
        return signWith(secretKeySpec, signatureAlgorithm);
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(Key key) {
        Assert.notNull(key, "Key argument cannot be null.");
        return signWith(key, SignatureAlgorithm.forSigningKey(key));
    }

    @Override // io.jsonwebtoken.JwtBuilder
    public JwtBuilder signWith(Key key, SignatureAlgorithm signatureAlgorithm2) {
        Assert.notNull(key, "Key argument cannot be null.");
        Assert.notNull(signatureAlgorithm2, "SignatureAlgorithm cannot be null.");
        signatureAlgorithm2.assertValidSigningKey(key);
        this.algorithm = signatureAlgorithm2;
        this.key = key;
        return this;
    }

    @Deprecated
    protected byte[] toJson(Object object) {
        Assert.isInstanceOf(Map.class, object, "object argument must be a map.");
        return this.serializer.serialize((Map)object);
    }
}
