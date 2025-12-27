package com.airbnb.lottie.v.l;

import com.airbnb.lottie.d;
import com.airbnb.lottie.v.j.j;
import com.airbnb.lottie.v.j.k;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.k.g;
import com.airbnb.lottie.z.a;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: Layer.java */
/* loaded from: classes.dex */
public class d {

    private final List<com.airbnb.lottie.v.k.b> a;
    private final d b;
    private final String c;
    private final long d;
    private final d.a e;
    private final long f;
    private final String g;
    private final List<g> h;
    private final l i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final j q;
    private final k r;
    private final com.airbnb.lottie.v.j.b s;
    private final List<a<Float>> t;
    private final d.b u;
    private final boolean v;

    public enum a {

        IMAGE,
        NULL,
        PRE_COMP,
        SHAPE,
        SOLID,
        TEXT,
        UNKNOWN;
    }

    public enum b {

        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        NONE,
        UNKNOWN;
    }
    public d(List<com.airbnb.lottie.v.k.b> list, d dVar, String str, long j, d.a aVar, long j2, String str2, List<g> list2, l lVar, int i, int i2, int i3, float f, float f2, int i4, int i5, j jVar, k kVar, List<a<Float>> list3, d.b bVar, com.airbnb.lottie.v.j.b bVar2, boolean z) {
        list3 = this;
        super();
        list3.a = list;
        list3.b = dVar;
        list3.c = str;
        list3.d = j;
        list3.e = aVar;
        list3.f = j2;
        list3.g = str2;
        list3.h = list2;
        list3.i = lVar;
        list3.j = i;
        list3.k = i2;
        list3.l = i3;
        list3.m = f;
        list3.n = f2;
        list3.o = i4;
        list3.p = i5;
        list3.q = jVar;
        list3.r = kVar;
        list3.t = list3;
        list3.u = bVar;
        list3.s = bVar2;
        list3.v = z;
    }

    d a() {
        return this.b;
    }

    public long b() {
        return this.d;
    }

    List<a<Float>> c() {
        return this.t;
    }

    public d.a d() {
        return this.e;
    }

    List<g> e() {
        return this.h;
    }

    d.b f() {
        return this.u;
    }

    String g() {
        return this.c;
    }

    long h() {
        return this.f;
    }

    int i() {
        return this.p;
    }

    int j() {
        return this.o;
    }

    String k() {
        return this.g;
    }

    List<com.airbnb.lottie.v.k.b> l() {
        return this.a;
    }

    int m() {
        return this.l;
    }

    int n() {
        return this.k;
    }

    int o() {
        return this.j;
    }

    float p() {
        return this.n / this.b.e();
    }

    j q() {
        return this.q;
    }

    k r() {
        return this.r;
    }

    com.airbnb.lottie.v.j.b s() {
        return this.s;
    }

    float t() {
        return this.m;
    }

    public String toString() {
        return w("");
    }

    l u() {
        return this.i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        com.airbnb.lottie.v.l.d dVar;
        d dVar2;
        long l;
        long l2;
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(g());
        String str3 = "\n";
        stringBuilder.append(str3);
        dVar = this.b.s(h());
        if (dVar != null) {
            stringBuilder.append("\t\tParents: ");
            stringBuilder.append(dVar.g());
            dVar = this.b.s(dVar.h());
            while (this.b != null) {
                stringBuilder.append("->");
                stringBuilder.append(dVar.g());
                dVar = this.b.s(dVar.h());
            }
            stringBuilder.append(str);
            stringBuilder.append(str3);
        }
        if (!e().isEmpty()) {
            stringBuilder.append(str);
            stringBuilder.append("\tMasks: ");
            stringBuilder.append(e().size());
            stringBuilder.append(str3);
        }
        if (o() != 0 && this.n() != 0) {
            stringBuilder.append(str);
            stringBuilder.append("\tBackground: ");
            Object[] arr = new Object[3];
            stringBuilder.append(String.format(Locale.US, "%dx%d %X\n", new Object[] { Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m()) }));
        }
        if (!this.a.isEmpty()) {
            stringBuilder.append(str);
            stringBuilder.append("\tShapes:\n");
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                stringBuilder.append(str);
                stringBuilder.append("\t\t");
                stringBuilder.append(it.next());
                stringBuilder.append(str3);
            }
        }
        return stringBuilder.toString();
    }
}
