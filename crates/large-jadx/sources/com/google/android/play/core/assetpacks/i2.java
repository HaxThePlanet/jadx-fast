package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.r1;
import java.io.File;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class i2 implements r1<com.google.android.play.core.assetpacks.h2> {

    private final r1<String> a;
    private final r1<com.google.android.play.core.assetpacks.z> b;
    private final r1<com.google.android.play.core.assetpacks.k1> c;
    private final r1<Context> d;
    private final r1<com.google.android.play.core.assetpacks.w2> e;
    private final r1<Executor> f;
    private final r1<com.google.android.play.core.assetpacks.u2> g;
    public i2(r1<String> r1, r1<com.google.android.play.core.assetpacks.z> r12, r1<com.google.android.play.core.assetpacks.k1> r13, r1<Context> r14, r1<com.google.android.play.core.assetpacks.w2> r15, r1<Executor> r16, r1<com.google.android.play.core.assetpacks.u2> r17) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        Object externalFilesDir;
        File externalFilesDir2;
        Object file;
        File file2;
        externalFilesDir = this.a.zza();
        final Context context = (z3)this.d.a();
        externalFilesDir2 = 0;
        if ((String)externalFilesDir != null) {
            file = new File(context.getExternalFilesDir(externalFilesDir2), (String)externalFilesDir);
            file2 = file;
        } else {
            file2 = externalFilesDir;
        }
        super(file2, (z)this.b.zza(), (k1)this.c.zza(), context, (w2)this.e.zza(), p1.a(this.f), (u2)this.g.zza());
        return h2Var2;
    }
}
