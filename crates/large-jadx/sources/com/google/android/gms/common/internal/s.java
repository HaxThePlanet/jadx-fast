package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;

/* loaded from: classes2.dex */
public final class s {

    private static com.google.android.gms.common.internal.s b;
    private static final com.google.android.gms.common.internal.t c;
    private com.google.android.gms.common.internal.t a;
    static {
        super(0, 0, 0, 0, 0);
        s.c = tVar2;
    }

    public static com.google.android.gms.common.internal.s b() {
        com.google.android.gms.common.internal.s sVar;
        final Class<com.google.android.gms.common.internal.s> obj = s.class;
        synchronized (obj) {
            sVar = new s();
            s.b = sVar;
            return s.b;
        }
    }

    public com.google.android.gms.common.internal.t a() {
        return this.a;
    }

    public final void c(com.google.android.gms.common.internal.t t) {
        com.google.android.gms.common.internal.t tVar;
        int i;
        synchronized (this) {
            this.a = s.c;
        }
    }
}
