package io.jsonwebtoken;

import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Serializer;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public interface JwtBuilder extends io.jsonwebtoken.ClaimsMutator<io.jsonwebtoken.JwtBuilder> {
    public abstract io.jsonwebtoken.JwtBuilder addClaims(Map<String, Object> map);

    public abstract io.jsonwebtoken.JwtBuilder base64UrlEncodeWith(Encoder<byte[], String> encoder);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder claim(String string, Object object2);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract String compact();

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder compressWith(io.jsonwebtoken.CompressionCodec compressionCodec);

    public abstract io.jsonwebtoken.JwtBuilder serializeToJsonWith(Serializer<Map<String, ?>> serializer);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setAudience(String string);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setClaims(io.jsonwebtoken.Claims claims);

    public abstract io.jsonwebtoken.JwtBuilder setClaims(Map<String, ?> map);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setExpiration(Date date);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setHeader(io.jsonwebtoken.Header header);

    public abstract io.jsonwebtoken.JwtBuilder setHeader(Map<String, Object> map);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setHeaderParam(String string, Object object2);

    public abstract io.jsonwebtoken.JwtBuilder setHeaderParams(Map<String, Object> map);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setId(String string);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setIssuedAt(Date date);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setIssuer(String string);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setNotBefore(Date date);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setPayload(String string);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder setSubject(String string);

    @Deprecated
    public abstract io.jsonwebtoken.JwtBuilder signWith(io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm, String string2);

    @Deprecated
    public abstract io.jsonwebtoken.JwtBuilder signWith(io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm, Key key2);

    @Deprecated
    public abstract io.jsonwebtoken.JwtBuilder signWith(io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm, byte[] b2Arr2);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder signWith(Key key);

    @Override // io.jsonwebtoken.ClaimsMutator
    public abstract io.jsonwebtoken.JwtBuilder signWith(Key key, io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm2);
}
