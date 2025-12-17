package com.google.android.gms.internal.firebase-auth-api;

import javax.crypto.Mac;

/* loaded from: classes2.dex */
final class yc extends java.lang.ThreadLocal<Mac> {

    final com.google.android.gms.internal.firebase-auth-api.zc a;
    yc(com.google.android.gms.internal.firebase-auth-api.zc zc) {
        this.a = zc;
        super();
    }

    @Override // java.lang.ThreadLocal
    protected final Mac a() {
        try {
            Object obj = mc.f.a(zc.b(this.a));
            (Mac)obj.init(zc.c(this.a));
            return obj;
            IllegalStateException illegalStateException = new IllegalStateException(th);
            throw illegalStateException;
        }
    }

    @Override // java.lang.ThreadLocal
    protected final Object initialValue() {
        return a();
    }
}
