package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.r1;
import com.google.android.play.core.splitinstall.g.a;
import com.google.android.play.core.splitinstall.g.p;
import com.google.android.play.core.splitinstall.g.r;
import java.io.File;

/* loaded from: classes2.dex */
public final class e0 implements com.google.android.play.core.splitinstall.p0 {

    private final r1<Context> a;
    private final r1<com.google.android.play.core.splitinstall.x> b;
    private final r1<com.google.android.play.core.splitinstall.x0> c;
    private final r1<com.google.android.play.core.splitinstall.s0> d;
    private final r1<com.google.android.play.core.splitinstall.z> e;
    private final r1<com.google.android.play.core.splitinstall.i> f;
    private final r1<File> g;
    private final r1<r> h;
    private final r1<a> i;
    private final r1<com.google.android.play.core.splitinstall.l0> j;
    private final r1<com.google.android.play.core.splitinstall.a> k;
    e0(com.google.android.play.core.splitinstall.k k, com.google.android.play.core.splitinstall.d0 d02) {
        super();
        l obj7 = new l(k);
        this.a = obj7;
        y yVar = new y(obj7);
        r1 r1Var = p1.b(yVar);
        this.b = r1Var;
        o oVar = new o(k);
        r1 r1Var3 = p1.b(oVar);
        this.c = r1Var3;
        t0 t0Var = new t0(obj7);
        r1 r1Var5 = p1.b(t0Var);
        this.d = r1Var5;
        a0 a0Var = new a0(obj7);
        r1 r1Var6 = p1.b(a0Var);
        this.e = r1Var6;
        j jVar = new j(r1Var, r1Var3, r1Var5, r1Var6);
        r1 r1Var2 = p1.b(jVar);
        this.f = r1Var2;
        n nVar = new n(obj7);
        r1 r1Var4 = p1.b(nVar);
        this.g = r1Var4;
        m mVar = new m(r1Var4);
        this.h = mVar;
        p pVar2 = new p(obj7, r1Var4, r1Var5, mVar);
        obj7 = p1.b(pVar2);
        this.i = obj7;
        m0 m0Var = new m0(r1Var2, obj7, r1Var4);
        obj7 = p1.b(m0Var);
        this.j = obj7;
        p pVar = new p(k, obj7);
        this.k = p1.b(pVar);
    }

    @Override // com.google.android.play.core.splitinstall.p0
    public final com.google.android.play.core.splitinstall.a zza() {
        return (a)this.k.zza();
    }
}
