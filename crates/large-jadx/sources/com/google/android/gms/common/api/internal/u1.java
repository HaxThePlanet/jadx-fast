package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class u1 implements Runnable {

    final com.google.android.gms.common.api.internal.LifecycleCallback a;
    final String b;
    final com.google.android.gms.common.api.internal.v1 c;
    u1(com.google.android.gms.common.api.internal.v1 v1, com.google.android.gms.common.api.internal.LifecycleCallback lifecycleCallback2, String string3) {
        this.c = v1;
        this.a = lifecycleCallback2;
        this.b = string3;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        int i4;
        int i2;
        int i;
        int i5;
        int bundle;
        String str;
        if (v1.b(this.c) > 0) {
            if (v1.c(this.c) != null) {
                bundle = v1.c(this.c).getBundle(this.b);
            } else {
                bundle = 0;
            }
            this.a.onCreate(bundle);
        }
        if (v1.b(this.c) >= 2) {
            this.a.onStart();
        }
        if (v1.b(this.c) >= 3) {
            this.a.onResume();
        }
        if (v1.b(this.c) >= 4) {
            this.a.onStop();
        }
        if (v1.b(this.c) >= 5) {
            this.a.onDestroy();
        }
    }
}
