package io.jsonwebtoken;

/* compiled from: PrematureJwtException.java */
/* loaded from: classes3.dex */
public class PrematureJwtException extends ClaimJwtException {
    public PrematureJwtException(Header header, Claims claims, String str) {
        super(header, claims, str);
    }

    public PrematureJwtException(Header header, Claims claims, String str, Throwable th) {
        super(header, claims, str, th);
    }
}
