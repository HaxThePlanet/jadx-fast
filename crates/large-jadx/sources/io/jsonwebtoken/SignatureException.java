package io.jsonwebtoken;

import io.jsonwebtoken.security.SecurityException;

/* loaded from: classes3.dex */
@Deprecated
public class SignatureException extends SecurityException {
    public SignatureException(String string) {
        super(string);
    }

    public SignatureException(String string, Throwable throwable2) {
        super(string, throwable2);
    }
}
