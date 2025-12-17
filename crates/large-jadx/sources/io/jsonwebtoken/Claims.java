package io.jsonwebtoken;

import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public interface Claims extends Map<String, Object>, io.jsonwebtoken.ClaimsMutator<io.jsonwebtoken.Claims> {

    public static final String AUDIENCE = "aud";
    public static final String EXPIRATION = "exp";
    public static final String ID = "jti";
    public static final String ISSUED_AT = "iat";
    public static final String ISSUER = "iss";
    public static final String NOT_BEFORE = "nbf";
    public static final String SUBJECT = "sub";
    public abstract <T> T get(String string, Class<T> class2);

    @Override // java.util.Map
    public abstract String getAudience();

    @Override // java.util.Map
    public abstract Date getExpiration();

    @Override // java.util.Map
    public abstract String getId();

    @Override // java.util.Map
    public abstract Date getIssuedAt();

    @Override // java.util.Map
    public abstract String getIssuer();

    @Override // java.util.Map
    public abstract Date getNotBefore();

    @Override // java.util.Map
    public abstract String getSubject();

    @Override // java.util.Map
    public abstract io.jsonwebtoken.Claims setAudience(String string);

    @Override // java.util.Map
    public abstract io.jsonwebtoken.Claims setExpiration(Date date);

    @Override // java.util.Map
    public abstract io.jsonwebtoken.Claims setId(String string);

    @Override // java.util.Map
    public abstract io.jsonwebtoken.Claims setIssuedAt(Date date);

    @Override // java.util.Map
    public abstract io.jsonwebtoken.Claims setIssuer(String string);

    @Override // java.util.Map
    public abstract io.jsonwebtoken.Claims setNotBefore(Date date);

    @Override // java.util.Map
    public abstract io.jsonwebtoken.Claims setSubject(String string);
}
