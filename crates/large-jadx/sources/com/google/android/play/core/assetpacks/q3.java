package com.google.android.play.core.assetpacks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.c;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.n1;
import com.google.android.play.core.splitinstall.s0;
import com.google.android.play.core.tasks.d;
import f.c.a.f.a.c.d;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class q3 {

    private static final h e;
    private final com.google.android.play.core.assetpacks.f0 a;
    private final n1<com.google.android.play.core.assetpacks.d4> b;
    private final com.google.android.play.core.assetpacks.z c;
    private final n1<Executor> d;
    static {
        h hVar = new h("AssetPackManager");
        q3.e = hVar;
    }

    q3(com.google.android.play.core.assetpacks.f0 f0, n1<com.google.android.play.core.assetpacks.d4> n12, com.google.android.play.core.assetpacks.z z3, s0 s04, com.google.android.play.core.assetpacks.z1 z15, com.google.android.play.core.assetpacks.k1 k16, com.google.android.play.core.assetpacks.s0 s07, n1<Executor> n18, c c9, com.google.android.play.core.assetpacks.u2 u210) {
        super();
        Handler obj4 = new Handler(Looper.getMainLooper());
        this.a = f0;
        this.b = n12;
        this.c = z3;
        this.d = n18;
    }

    static void a(Exception exception) {
        Object[] arr = new Object[1];
        final int i2 = 0;
        arr[i2] = exception;
        q3.e.e(String.format("Could not sync active asset packs. %s", arr), new Object[i2]);
    }

    private final void d() {
        p3 p3Var = new p3(this);
        (Executor)this.d.zza().execute(p3Var);
    }

    final void b() {
        d dVar = (d4)this.b.zza().f(this.a.G());
        com.google.android.play.core.assetpacks.f0 f0Var2 = this.a;
        f0Var2.getClass();
        o3 o3Var = new o3(f0Var2);
        dVar.e((Executor)this.d.zza(), o3Var);
        dVar.c((Executor)this.d.zza(), n3.a);
    }

    final void c(boolean z) {
        this.c.d(z);
        if (z && !this.c.g()) {
            if (!this.c.g()) {
                d();
            }
        }
    }
}
