package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class p8 implements Runnable {

    final AtomicReference a;
    final String b;
    final String c;
    final com.google.android.gms.measurement.internal.na v;
    final boolean w;
    final com.google.android.gms.measurement.internal.w8 x;
    p8(com.google.android.gms.measurement.internal.w8 w8, AtomicReference atomicReference2, String string3, String string4, String string5, com.google.android.gms.measurement.internal.na na6, boolean z7) {
        this.x = w8;
        this.a = atomicReference2;
        this.b = string4;
        this.c = string5;
        this.v = na6;
        this.w = z7;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference2;
        java.util.List list;
        com.google.android.gms.measurement.internal.w8 w8Var;
        AtomicReference atomicReference;
        String str2;
        String str;
        boolean z;
        com.google.android.gms.measurement.internal.na naVar;
        final AtomicReference atomicReference3 = this.a;
        int i = 0;
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.x);
        synchronized (atomicReference3) {
            w8Var3.a.b().r().d("(legacy) Failed to get user properties; not connected to service", i, this.b, this.c);
            this.a.set(Collections.emptyList());
            this.a.notify();
        }
    }
}
