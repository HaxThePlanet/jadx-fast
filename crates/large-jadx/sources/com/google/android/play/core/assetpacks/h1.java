package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.n1;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class h1 {

    private static final h k;
    private final com.google.android.play.core.assetpacks.z1 a;
    private final com.google.android.play.core.assetpacks.b1 b;
    private final com.google.android.play.core.assetpacks.k3 c;
    private final com.google.android.play.core.assetpacks.n2 d;
    private final com.google.android.play.core.assetpacks.s2 e;
    private final com.google.android.play.core.assetpacks.z2 f;
    private final com.google.android.play.core.assetpacks.d3 g;
    private final n1<com.google.android.play.core.assetpacks.d4> h;
    private final com.google.android.play.core.assetpacks.c2 i;
    private final AtomicBoolean j;
    static {
        h hVar = new h("ExtractorLooper");
        h1.k = hVar;
    }

    h1(com.google.android.play.core.assetpacks.z1 z1, n1<com.google.android.play.core.assetpacks.d4> n12, com.google.android.play.core.assetpacks.b1 b13, com.google.android.play.core.assetpacks.k3 k34, com.google.android.play.core.assetpacks.n2 n25, com.google.android.play.core.assetpacks.s2 s26, com.google.android.play.core.assetpacks.z2 z27, com.google.android.play.core.assetpacks.d3 d38, com.google.android.play.core.assetpacks.c2 c29) {
        super();
        this.a = z1;
        this.h = n12;
        this.b = b13;
        this.c = k34;
        this.d = n25;
        this.e = s26;
        this.f = z27;
        this.g = d38;
        this.i = c29;
        AtomicBoolean obj1 = new AtomicBoolean(0);
        this.j = obj1;
    }

    private final void b(int i, Exception exception2) {
        try {
            this.a.k(i, 5);
            this.a.l(i);
            i = h1.k;
            int arr = 1;
            arr = new Object[arr];
            exception2 = exception2.getMessage();
            arr[0] = exception2;
            exception2 = "Error during error handling: %s";
            i.b(exception2, arr);
        }
    }

    final void a() {
        h hVar;
        boolean compareAndSet;
        com.google.android.play.core.assetpacks.c2 c2Var;
        h arr;
        Object[] str;
        String str2;
        hVar = h1.k;
        int i2 = 0;
        hVar.a("Run extractor loop", new Object[i2]);
        int i3 = 1;
        if (this.j.compareAndSet(i2, i3)) {
        }
        try {
            hVar.e("runLoop already looping; return", new Object[i2]);
        } catch (Exception e) {
        }
    }
}
