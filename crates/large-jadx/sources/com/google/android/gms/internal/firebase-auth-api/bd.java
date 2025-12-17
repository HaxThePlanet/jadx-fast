package com.google.android.gms.internal.firebase-auth-api;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
final class bd extends java.lang.ThreadLocal<SecureRandom> {
    @Override // java.lang.ThreadLocal
    protected final Object initialValue() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}
