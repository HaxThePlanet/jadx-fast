package io.jsonwebtoken;

import java.security.Key;

/* loaded from: classes3.dex */
public interface SigningKeyResolver {
    public abstract Key resolveSigningKey(io.jsonwebtoken.JwsHeader jwsHeader, io.jsonwebtoken.Claims claims2);

    public abstract Key resolveSigningKey(io.jsonwebtoken.JwsHeader jwsHeader, String string2);
}
