package io.jsonwebtoken;

/* compiled from: Jwt.java */
/* loaded from: classes3.dex */
public interface Jwt<H extends Header, B> {
    B getBody();

    H getHeader();
}
