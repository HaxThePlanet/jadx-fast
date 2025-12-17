package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class w1 implements Runnable {

    final com.google.android.gms.common.api.internal.LifecycleCallback a;
    final String b;
    final com.google.android.gms.common.api.internal.x1 c;
    w1(com.google.android.gms.common.api.internal.x1 x1, com.google.android.gms.common.api.internal.LifecycleCallback lifecycleCallback2, String string3) {
        this.c = x1;
        this.a = lifecycleCallback2;
        this.b = string3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i5;
        int i;
        int i3;
        int i4;
        int bundle;
        String str;
        if (x1.C1(this.c) > 0) {
            if (x1.D1(this.c) != null) {
                bundle = x1.D1(this.c).getBundle(this.b);
            } else {
                bundle = 0;
            }
            this.a.onCreate(bundle);
        }
        if (x1.C1(this.c) >= 2) {
            this.a.onStart();
        }
        if (x1.C1(this.c) >= 3) {
            this.a.onResume();
        }
        if (x1.C1(this.c) >= 4) {
            this.a.onStop();
        }
        if (x1.C1(this.c) >= 5) {
            this.a.onDestroy();
        }
    }
}
