package com.google.android.play.core.splitinstall.g;

import android.content.Context;
import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.r1;
import com.google.android.play.core.splitinstall.l;
import com.google.android.play.core.splitinstall.s0;
import java.io.File;

/* loaded from: classes2.dex */
public final class p implements r1<com.google.android.play.core.splitinstall.g.a> {

    private final r1<Context> a;
    private final r1<File> b;
    private final r1<s0> c;
    private final r1<com.google.android.play.core.splitinstall.g.r> d;
    public p(r1<Context> r1, r1<File> r12, r1<s0> r13, r1<com.google.android.play.core.splitinstall.g.r> r14) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
        this.d = r14;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        a aVar = new a((l)this.a.a(), (File)this.b.zza(), (s0)this.c.zza(), p1.a(this.d));
        return aVar;
    }
}
