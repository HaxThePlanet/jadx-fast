package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.r1;
import com.google.android.play.core.splitinstall.g.a;
import java.io.File;

/* loaded from: classes2.dex */
public final class m0 implements r1<com.google.android.play.core.splitinstall.l0> {

    private final r1<com.google.android.play.core.splitinstall.i> a;
    private final r1<a> b;
    private final r1<File> c;
    public m0(r1<com.google.android.play.core.splitinstall.i> r1, r1<a> r12, r1<File> r13) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        l0 l0Var = new l0(p1.a(this.a), p1.a(this.b), p1.a(this.c));
        return l0Var;
    }
}
