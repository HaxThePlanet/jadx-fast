package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.c;
import com.google.android.play.core.internal.n1;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class s2 {

    private final com.google.android.play.core.assetpacks.f0 a;
    private final n1<com.google.android.play.core.assetpacks.d4> b;
    private final com.google.android.play.core.assetpacks.z1 c;
    private final n1<Executor> d;
    private final com.google.android.play.core.assetpacks.k1 e;
    private final c f;
    private final com.google.android.play.core.assetpacks.u2 g;
    s2(com.google.android.play.core.assetpacks.f0 f0, n1<com.google.android.play.core.assetpacks.d4> n12, com.google.android.play.core.assetpacks.z1 z13, n1<Executor> n14, com.google.android.play.core.assetpacks.k1 k15, c c6, com.google.android.play.core.assetpacks.u2 u27) {
        super();
        this.a = f0;
        this.b = n12;
        this.c = z13;
        this.d = n14;
        this.e = k15;
        this.f = c6;
        this.g = u27;
    }

    public final void a(com.google.android.play.core.assetpacks.p2 p2) {
        Object obj;
        Object r2Var;
        boolean exists;
        Object q2Var;
        int i;
        long l;
        long l2;
        File file;
        String str;
        File file2 = this.a.w(p2.b, p2.c, p2.d);
        File file5 = this.a.y(p2.b, p2.c, p2.d);
        int i7 = 1;
        if (file2.exists() == null) {
        } else {
            if (file5.exists() == null) {
            } else {
                l2 = p2.d;
                File file6 = this.a.u(p2.b, p2.c, l2);
                file6.mkdirs();
                if (file2.renameTo(file6) == null) {
                } else {
                    file = new File(this.a.u(p2.b, p2.c, p2.d), "merge.tmp");
                    file.delete();
                    File file4 = this.a.v(p2.b, p2.c, p2.d);
                    file4.mkdirs();
                    if (file5.renameTo(file4) == null) {
                    } else {
                        if (this.f.a("assetOnlyUpdates")) {
                            this.g.b(p2.b, p2.c, p2.d, obj9);
                            r2Var = new r2(this, p2);
                            (Executor)this.d.zza().execute(r2Var);
                        } else {
                            r2Var = this.a;
                            r2Var.getClass();
                            q2Var = new q2(r2Var);
                            (Executor)this.d.zza().execute(q2Var);
                        }
                        this.c.i(p2.b, p2.c, p2.d);
                        this.e.c(p2.b);
                        (d4)this.b.zza().a(p2.a, p2.b);
                    }
                    g1 g1Var2 = new g1("Cannot move metadata files to final location.", p2.a);
                    throw g1Var2;
                }
                g1 g1Var3 = new g1("Cannot move merged pack files to final location.", p2.a);
                throw g1Var3;
            }
        }
        Object[] arr = new Object[i7];
        arr[0] = p2.b;
        g1 g1Var = new g1(String.format("Cannot find pack files to move for pack %s.", arr), p2.a);
        throw g1Var;
    }

    final void b(com.google.android.play.core.assetpacks.p2 p2) {
        this.a.b(p2.b, p2.c, p2.d);
    }
}
