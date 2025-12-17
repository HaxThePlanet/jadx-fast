package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
final class n8 implements Runnable {

    final AtomicReference a;
    final String b;
    final String c;
    final com.google.android.gms.measurement.internal.na v;
    final com.google.android.gms.measurement.internal.w8 w;
    n8(com.google.android.gms.measurement.internal.w8 w8, AtomicReference atomicReference2, String string3, String string4, String string5, com.google.android.gms.measurement.internal.na na6) {
        this.w = w8;
        this.a = atomicReference2;
        this.b = string4;
        this.c = string5;
        this.v = na6;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        java.util.List list;
        com.google.android.gms.measurement.internal.w8 w8Var;
        AtomicReference atomicReference2;
        String str2;
        String str;
        com.google.android.gms.measurement.internal.na naVar;
        final AtomicReference atomicReference3 = this.a;
        int i = 0;
        com.google.android.gms.measurement.internal.g3 g3Var = w8.H(this.w);
        synchronized (atomicReference3) {
            w8Var3.a.b().r().d("(legacy) Failed to get conditional properties; not connected to service", i, this.b, this.c);
            this.a.set(Collections.emptyList());
            this.a.notify();
        }
    }
}
