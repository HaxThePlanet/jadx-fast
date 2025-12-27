package io.jsonwebtoken;

import java.security.Key;

/* compiled from: SigningKeyResolver.java */
/* loaded from: classes3.dex */
public interface SigningKeyResolver {
    Key resolveSigningKey(JwsHeader jwsHeader, Claims claims);

    Key resolveSigningKey(JwsHeader jwsHeader, String str);
}
