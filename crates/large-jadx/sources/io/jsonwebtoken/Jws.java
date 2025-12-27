package io.jsonwebtoken;

/* compiled from: Jws.java */
/* loaded from: classes3.dex */
public interface Jws<B> extends Jwt<JwsHeader, B> {
    String getSignature();
}
