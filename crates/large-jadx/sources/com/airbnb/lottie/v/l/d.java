package com.airbnb.lottie.v.l;

import com.airbnb.lottie.d;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.j;
import com.airbnb.lottie.v.j.k;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.k.b;
import com.airbnb.lottie.v.k.g;
import com.airbnb.lottie.z.a;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class d {

    private final List<b> a;
    private final d b;
    private final String c;
    private final long d;
    private final com.airbnb.lottie.v.l.d.a e;
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
    private final b s;
    private final List<a<Float>> t;
    private final com.airbnb.lottie.v.l.d.b u;
    private final boolean v;

    public static enum a {

        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN;
    }

    public static enum b {

        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN;
    }
    public d(List<b> list, d d2, String string3, long l4, com.airbnb.lottie.v.l.d.a d$a5, long l6, String string7, List<g> list8, l l9, int i10, int i11, int i12, float f13, float f14, int i15, int i16, j j17, k k18, List<a<Float>> list19, com.airbnb.lottie.v.l.d.b d$b20, b b21, boolean z22) {
        final Object obj = this;
        super();
        obj.a = list;
        obj.b = d2;
        obj.c = string3;
        obj.d = l4;
        obj.e = l6;
        obj.f = string7;
        obj.g = l9;
        obj.h = i10;
        obj.i = i11;
        obj.j = i12;
        obj.k = f13;
        obj.l = f14;
        obj.m = i15;
        obj.n = i16;
        obj.o = j17;
        obj.p = k18;
        obj.q = list19;
        obj.r = b20;
        obj.t = b21;
        obj.u = z22;
        obj.s = obj26;
        obj.v = obj27;
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

    public com.airbnb.lottie.v.l.d.a d() {
        return this.e;
    }

    List<g> e() {
        return this.h;
    }

    com.airbnb.lottie.v.l.d.b f() {
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

    List<b> l() {
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
        return f /= f2;
    }

    j q() {
        return this.q;
    }

    k r() {
        return this.r;
    }

    b s() {
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

    public String w(String string) {
        com.airbnb.lottie.v.l.d dVar;
        boolean empty;
        int format;
        boolean iterator;
        d next;
        long str;
        Integer valueOf;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(g());
        String str3 = "\n";
        stringBuilder.append(str3);
        dVar = this.b.s(h());
        if (dVar != null) {
            stringBuilder.append("\t\tParents: ");
            stringBuilder.append(dVar.g());
            dVar = this.b.s(dVar.h());
            while (dVar != null) {
                stringBuilder.append("->");
                stringBuilder.append(dVar.g());
                dVar = this.b.s(dVar.h());
            }
            stringBuilder.append(string);
            stringBuilder.append(str3);
        }
        if (!e().isEmpty()) {
            stringBuilder.append(string);
            stringBuilder.append("\tMasks: ");
            stringBuilder.append(e().size());
            stringBuilder.append(str3);
        }
        if (o() != 0 && n() != 0) {
            if (n() != 0) {
                stringBuilder.append(string);
                stringBuilder.append("\tBackground: ");
                next = new Object[3];
                stringBuilder.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
            }
        }
        if (!this.a.isEmpty()) {
            stringBuilder.append(string);
            stringBuilder.append("\tShapes:\n");
            iterator = this.a.iterator();
            for (Object next : iterator) {
                stringBuilder.append(string);
                stringBuilder.append("\t\t");
                stringBuilder.append(next);
                stringBuilder.append(str3);
            }
        }
        return stringBuilder.toString();
    }
}
