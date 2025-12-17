package com.google.android.gms.internal.firebase-auth-api;

import javax.crypto.Cipher;

/* loaded from: classes2.dex */
final class rb extends java.lang.ThreadLocal<Cipher> {
    protected static final Cipher a() {
        try {
            return (Cipher)mc.e.a("AES/CTR/NoPadding");
            IllegalStateException illegalStateException = new IllegalStateException(th);
            throw illegalStateException;
        }
    }

    @Override // java.lang.ThreadLocal
    protected final Object initialValue() {
        return rb.a();
    }
}
