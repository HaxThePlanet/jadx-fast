package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class h0 {

    private static final Comparator<com.google.android.exoplayer2.util.h0.b> h;
    private static final Comparator<com.google.android.exoplayer2.util.h0.b> i;
    private final int a;
    private final ArrayList<com.google.android.exoplayer2.util.h0.b> b;
    private final com.google.android.exoplayer2.util.h0.b[] c;
    private int d = -1;
    private int e;
    private int f;
    private int g;

    static class a {
    }

    private static class b {

        public int a;
        public int b;
        public float c;
        b(com.google.android.exoplayer2.util.h0.a h0$a) {
            super();
        }
    }
    static {
        h0.h = d.a;
        h0.i = e.a;
    }

    public h0(int i) {
        super();
        this.a = i;
        this.c = new h0.b[5];
        ArrayList obj1 = new ArrayList();
        this.b = obj1;
        obj1 = -1;
    }

    private void b() {
        int i;
        Comparator comparator;
        final int i2 = 1;
        if (this.d != i2) {
            Collections.sort(this.b, h0.h);
            this.d = i2;
        }
    }

    private void c() {
        int i;
        Comparator comparator;
        if (this.d != 0) {
            Collections.sort(this.b, h0.i);
            this.d = 0;
        }
    }

    static int e(com.google.android.exoplayer2.util.h0.b h0$b, com.google.android.exoplayer2.util.h0.b h0$b2) {
        return obj0 -= obj1;
    }

    static int f(com.google.android.exoplayer2.util.h0.b h0$b, com.google.android.exoplayer2.util.h0.b h0$b2) {
        return Float.compare(b.c, b2.c);
    }

    public void a(int i, float f2) {
        com.google.android.exoplayer2.util.h0.b bVar;
        int i3;
        int i2;
        int obj4;
        int obj5;
        b();
        int i4 = this.g;
        if (i4 > 0) {
            i4--;
            this.g = i5;
            bVar = this.c[i5];
        } else {
            bVar = new h0.b(0);
        }
        i2 = this.e;
        this.e = i2 + 1;
        bVar.a = i2;
        bVar.b = i;
        bVar.c = f2;
        this.b.add(bVar);
        this.f = obj5 += i;
        obj4 = this.f;
        obj5 = this.a;
        while (obj4 > obj5) {
            obj4 -= obj5;
            bVar = null;
            obj5 = this.b.get(bVar);
            i2 = obj5.b;
            if (i2 <= obj4) {
            } else {
            }
            obj5.b = i2 -= obj4;
            this.f = obj5 -= obj4;
            obj4 = this.f;
            obj5 = this.a;
            this.f = obj4 -= i2;
            this.b.remove(bVar);
            obj4 = this.g;
            if (obj4 < 5) {
            }
            this.g = obj4 + 1;
            this.c[obj4] = (h0.b)obj5;
        }
    }

    public float d(float f) {
        int i;
        int i2;
        Object obj;
        int cmp;
        float obj5;
        c();
        i2 = i;
        while (i < this.b.size()) {
            obj = this.b.get(i);
            i++;
        }
        if (this.b.isEmpty()) {
            obj5 = 2143289344;
        } else {
            obj5 = this.b;
            obj5 = obj5.c;
        }
        return obj5;
    }

    public void g() {
        this.b.clear();
        this.d = -1;
        int i2 = 0;
        this.e = i2;
        this.f = i2;
    }
}
