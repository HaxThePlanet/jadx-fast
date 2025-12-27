package io.jsonwebtoken;

import java.util.Date;

/* compiled from: ClaimsMutator.java */
/* loaded from: classes3.dex */
public interface ClaimsMutator<T extends ClaimsMutator> {
    T setAudience(String str);

    T setExpiration(Date date);

    T setId(String str);

    T setIssuedAt(Date date);

    T setIssuer(String str);

    T setNotBefore(Date date);

    T setSubject(String str);
}
