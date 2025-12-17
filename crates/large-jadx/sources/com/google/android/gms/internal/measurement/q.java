package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public interface q {

    public static final com.google.android.gms.internal.measurement.q h;
    public static final com.google.android.gms.internal.measurement.q i;
    public static final com.google.android.gms.internal.measurement.q j;
    public static final com.google.android.gms.internal.measurement.q k;
    public static final com.google.android.gms.internal.measurement.q l;
    public static final com.google.android.gms.internal.measurement.q m;
    public static final com.google.android.gms.internal.measurement.q n;
    public static final com.google.android.gms.internal.measurement.q o;
    static {
        v vVar = new v();
        q.h = vVar;
        o oVar = new o();
        q.i = oVar;
        h hVar = new h("continue");
        q.j = hVar;
        h hVar2 = new h("break");
        q.k = hVar2;
        h hVar3 = new h("return");
        q.l = hVar3;
        g gVar = new g(Boolean.TRUE);
        q.m = gVar;
        g gVar2 = new g(Boolean.FALSE);
        q.n = gVar2;
        u uVar = new u("");
        q.o = uVar;
    }

    public abstract com.google.android.gms.internal.measurement.q b();

    public abstract Boolean d();

    public abstract Iterator<com.google.android.gms.internal.measurement.q> h();

    public abstract com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3);

    public abstract Double zzh();

    public abstract String zzi();
}
