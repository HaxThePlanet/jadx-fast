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
import io.jsonwebtoken.io.SerializationException;
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

/* compiled from: DefaultJwtBuilder.java */
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
    protected String base64UrlEncode(Object object, String str) {
        Assert.isInstanceOf(Map.class, object, "object argument must be a map.");
        try {
        } catch (io.jsonwebtoken.io.SerializationException serialization) {
            throw new IllegalStateException(str, serialization);
        }
        return (String)this.base64UrlEncoder.encode(toJson(object));
    }

    public JwtBuilder base64UrlEncodeWith(Encoder<byte[], String> encoder) {
        Assert.notNull(encoder, "base64UrlEncoder cannot be null.");
        this.base64UrlEncoder = encoder;
        return this;
    }

    public JwtBuilder claim(String str, Object object) {
        Assert.hasText(str, "Claim property name cannot be null or empty.");
        if (this.claims == null) {
            if (object != null) {
                ensureClaims().put(str, object);
            }
        } else {
            if (object == null) {
                this.claims.remove(str);
            } else {
                this.claims.put(str, object);
            }
        }
        return this;
    }

    public String compact() throws java.io.UnsupportedEncodingException {
        io.jsonwebtoken.impl.DefaultJwsHeader defaultJwsHeader;
        String str2;
        byte[] compress;
        if (this.serializer == null) {
            this.serializer = (Serializer)LegacyServices.loadFirst(Serializer.class);
        }
        if (this.payload == null && Collections.isEmpty(this.claims)) {
            str = "";
            this.payload = str;
        }
        if (this.payload != null) {
            if (!Collections.isEmpty(this.claims)) {
                throw new IllegalStateException("Both 'payload' and 'claims' cannot both be specified. Choose either one.");
            }
        }
        Header ensureHeader = ensureHeader();
        Throwable th = ensureHeader instanceof JwsHeader ? (JwsHeader)ensureHeader : new DefaultJwsHeader(ensureHeader);
        if (this.key != null) {
            defaultJwsHeader.setAlgorithm(this.algorithm.getValue());
        } else {
            defaultJwsHeader.setAlgorithm(SignatureAlgorithm.NONE.getValue());
        }
        if (this.compressionCodec != null) {
            defaultJwsHeader.setCompressionAlgorithm(this.compressionCodec.getAlgorithmName());
        }
        String base64UrlEncode = base64UrlEncode(defaultJwsHeader, "Unable to serialize header to json.");
        try {
            if (this.payload != null) {
                compress = this.payload.getBytes(Strings.UTF_8);
            } else {
                compress = toJson(this.claims);
            }
        } catch (io.jsonwebtoken.io.SerializationException serialization) {
            StringBuilder stringBuilder3 = new StringBuilder();
            String message = "Unable to serialize claims object to json: ";
            message = serialization.getMessage();
            stringBuilder3 = message + message;
            throw new IllegalArgumentException(stringBuilder3, (ensureHeader instanceof JwsHeader ? (JwsHeader)ensureHeader : new DefaultJwsHeader(ensureHeader)));
        }
        if (this.compressionCodec != null) {
            compress = this.compressionCodec.compress(compress);
        }
        Object encode = this.base64UrlEncoder.encode(compress);
        StringBuilder stringBuilder4 = new StringBuilder();
        char c = '.';
        str5 = base64UrlEncode + c + encode;
        if (this.key != null) {
            String sign = createSigner(this.algorithm, this.key).sign(str5);
            StringBuilder stringBuilder2 = new StringBuilder();
            str2 = str5 + '.' + sign;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            str2 = str5 + '.';
        }
        return str2;
    }

    public JwtBuilder compressWith(CompressionCodec compressionCodec) {
        Assert.notNull(compressionCodec, "compressionCodec cannot be null");
        this.compressionCodec = compressionCodec;
        return this;
    }

    protected JwtSigner createSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        return new DefaultJwtSigner(signatureAlgorithm, key, this.base64UrlEncoder);
    }

    protected Claims ensureClaims() {
        if (this.claims == null) {
            this.claims = new DefaultClaims();
        }
        return this.claims;
    }

    protected Header ensureHeader() {
        if (this.header == null) {
            this.header = new DefaultHeader();
        }
        return this.header;
    }

    public JwtBuilder serializeToJsonWith(Serializer<Map<String, ?>> serializer) {
        Assert.notNull(serializer, "Serializer cannot be null.");
        this.serializer = serializer;
        return this;
    }

    public JwtBuilder setClaims(Claims claims) {
        this.claims = claims;
        return this;
    }

    public JwtBuilder setHeader(Header header) {
        this.header = header;
        return this;
    }

    public JwtBuilder setHeaderParam(String str, Object object) {
        ensureHeader().put(str, object);
        return this;
    }

    public JwtBuilder setHeaderParams(Map<String, Object> map) {
        Object key;
        if (!Collections.isEmpty(map)) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                ensureHeader().put(item.getKey(), item.getValue());
            }
        }
        return this;
    }

    public JwtBuilder setPayload(String str) {
        this.payload = str;
        return this;
    }

    public JwtBuilder signWith(Key key) {
        Assert.notNull(key, "Key argument cannot be null.");
        return signWith(key, SignatureAlgorithm.forSigningKey(key));
    }

    @Deprecated
    protected byte[] toJson(Object object) {
        Assert.isInstanceOf(Map.class, object, "object argument must be a map.");
        return this.serializer.serialize(object);
    }

    public JwtBuilder setAudience(String str) {
        if (Strings.hasText(str)) {
            ensureClaims().setAudience(str);
        } else {
            if (this.claims != null) {
                this.claims.setAudience(str);
            }
        }
        return this;
    }

    public JwtBuilder setClaims(Map<String, ?> map) {
        this.claims = new DefaultClaims(map);
        return this;
    }

    public JwtBuilder setExpiration(Date date) {
        if (date != null) {
            ensureClaims().setExpiration(date);
        } else {
            if (this.claims != null) {
                this.claims.setExpiration(date);
            }
        }
        return this;
    }

    public JwtBuilder setHeader(Map<String, Object> map) {
        this.header = new DefaultHeader(map);
        return this;
    }

    public JwtBuilder setId(String str) {
        if (Strings.hasText(str)) {
            ensureClaims().setId(str);
        } else {
            if (this.claims != null) {
                this.claims.setId(str);
            }
        }
        return this;
    }

    public JwtBuilder setIssuedAt(Date date) {
        if (date != null) {
            ensureClaims().setIssuedAt(date);
        } else {
            if (this.claims != null) {
                this.claims.setIssuedAt(date);
            }
        }
        return this;
    }

    public JwtBuilder setIssuer(String str) {
        if (Strings.hasText(str)) {
            ensureClaims().setIssuer(str);
        } else {
            if (this.claims != null) {
                this.claims.setIssuer(str);
            }
        }
        return this;
    }

    public JwtBuilder setNotBefore(Date date) {
        if (date != null) {
            ensureClaims().setNotBefore(date);
        } else {
            if (this.claims != null) {
                this.claims.setNotBefore(date);
            }
        }
        return this;
    }

    public JwtBuilder setSubject(String str) {
        if (Strings.hasText(str)) {
            ensureClaims().setSubject(str);
        } else {
            if (this.claims != null) {
                this.claims.setSubject(str);
            }
        }
        return this;
    }

    public JwtBuilder signWith(Key key, SignatureAlgorithm signatureAlgorithm) {
        Assert.notNull(key, "Key argument cannot be null.");
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        signatureAlgorithm.assertValidSigningKey(key);
        this.algorithm = signatureAlgorithm;
        this.key = key;
        return this;
    }

    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notEmpty(bArr, "secret key byte array cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith(new SecretKeySpec(bArr, signatureAlgorithm.getJcaName()), signatureAlgorithm);
    }

    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, String str) {
        Assert.hasText(str, "base64-encoded secret key cannot be null or empty.");
        Assert.isTrue(signatureAlgorithm.isHmac(), "Base64-encoded key bytes may only be specified for HMAC signatures.  If using RSA or Elliptic Curve, use the signWith(SignatureAlgorithm, Key) method instead.");
        return signWith(signatureAlgorithm, (byte[])Decoders.BASE64.decode(str));
    }

    public JwtBuilder signWith(SignatureAlgorithm signatureAlgorithm, Key key) {
        return signWith(key, signatureAlgorithm);
    }
}
