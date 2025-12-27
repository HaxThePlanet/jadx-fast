package io.jsonwebtoken;

import io.jsonwebtoken.security.SecurityException;

/* compiled from: SignatureException.java */
@Deprecated
/* loaded from: classes3.dex */
public class SignatureException extends SecurityException {
    public SignatureException(String str) {
        super(str);
    }

    public SignatureException(String str, Throwable th) {
        super(str, th);
    }
}
