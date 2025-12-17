package io.jsonwebtoken.security;

import io.jsonwebtoken.JwtException;

/* loaded from: classes3.dex */
public class SecurityException extends JwtException {
    public SecurityException(String string) {
        super(string);
    }

    public SecurityException(String string, Throwable throwable2) {
        super(string, throwable2);
    }
}
