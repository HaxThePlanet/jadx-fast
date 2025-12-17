package com.google.android.gms.internal.firebase-auth-api;

import javax.crypto.Cipher;

/* loaded from: classes2.dex */
final class tb extends java.lang.ThreadLocal<Cipher> {
    protected static final Cipher a() {
        try {
            return (Cipher)mc.e.a("AES/ECB/NOPADDING");
            IllegalStateException illegalStateException = new IllegalStateException(th);
            throw illegalStateException;
        }
    }

    @Override // java.lang.ThreadLocal
    protected final Object initialValue() {
        return tb.a();
    }
}
