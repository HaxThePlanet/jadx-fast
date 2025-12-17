package io.jsonwebtoken;

import java.util.Date;

/* loaded from: classes3.dex */
public interface ClaimsMutator<T extends io.jsonwebtoken.ClaimsMutator>  {
    public abstract T setAudience(String string);

    public abstract T setExpiration(Date date);

    public abstract T setId(String string);

    public abstract T setIssuedAt(Date date);

    public abstract T setIssuer(String string);

    public abstract T setNotBefore(Date date);

    public abstract T setSubject(String string);
}
