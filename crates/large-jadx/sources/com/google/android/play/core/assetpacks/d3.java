package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.n1;
import java.io.File;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class d3 {

    private final com.google.android.play.core.assetpacks.f0 a;
    private final n1<com.google.android.play.core.assetpacks.d4> b;
    private final com.google.android.play.core.assetpacks.z1 c;
    private final n1<Executor> d;
    private final com.google.android.play.core.assetpacks.k1 e;
    d3(com.google.android.play.core.assetpacks.f0 f0, n1<com.google.android.play.core.assetpacks.d4> n12, com.google.android.play.core.assetpacks.z1 z13, n1<Executor> n14, com.google.android.play.core.assetpacks.k1 k15) {
        super();
        this.a = f0;
        this.b = n12;
        this.c = z13;
        this.d = n14;
        this.e = k15;
    }

    public final void a(com.google.android.play.core.assetpacks.b3 b3) {
        File file = this.a.u(b3.b, b3.c, b3.e);
        int i3 = 1;
        int i5 = 0;
        int i6 = 2;
        if (file.exists() == null) {
        } else {
            File file2 = this.a.u(b3.b, b3.d, b3.e);
            file2.mkdirs();
            if (file.renameTo(file2) == null) {
            } else {
                c3 c3Var = new c3(this, b3);
                (Executor)this.d.zza().execute(c3Var);
                this.c.i(b3.b, b3.d, b3.e);
                this.e.c(b3.b);
                (d4)this.b.zza().a(b3.a, b3.b);
            }
            Object[] arr2 = new Object[3];
            arr2[i5] = b3.b;
            arr2[i3] = file.getAbsolutePath();
            arr2[i6] = file2.getAbsolutePath();
            g1 g1Var2 = new g1(String.format("Cannot promote pack %s from %s to %s", arr2), b3.a);
            throw g1Var2;
        }
        Object[] arr = new Object[i6];
        arr[i5] = b3.b;
        arr[i3] = file.getAbsolutePath();
        g1 g1Var = new g1(String.format("Cannot find pack files to promote for pack %s at %s", arr), b3.a);
        throw g1Var;
    }

    final void b(com.google.android.play.core.assetpacks.b3 b3) {
        this.a.b(b3.b, b3.d, b3.e);
    }
}
