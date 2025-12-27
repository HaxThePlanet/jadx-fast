package com.airbnb.lottie.v.k;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.n;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.l.a;

/* compiled from: PolystarShape.java */
/* loaded from: classes.dex */
public class i implements b {

    private final String a;
    private final i.a b;
    private final b c;
    private final m<PointF, PointF> d;
    private final b e;
    private final b f;
    private final b g;
    private final b h;
    private final b i;
    private final boolean j;

    public enum a {

        POLYGON,
        STAR;

        private final int value;
        public static i.a forValue(int i) {
            int i2 = 0;
            final com.airbnb.lottie.v.k.i.a[] values = i.a.values();
            i2 = 0;
            for (com.airbnb.lottie.v.k.i.a aVar : values) {
                if (aVar.value == i) {
                    return aVar;
                }
            }
            return null;
        }
    }
    public i(String str, i.a aVar, b bVar, m<PointF, PointF> mVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z) {
        super();
        this.a = str;
        this.b = aVar;
        this.c = bVar;
        this.d = mVar;
        this.e = bVar2;
        this.f = bVar3;
        this.g = bVar4;
        this.h = bVar5;
        this.i = bVar6;
        this.j = z;
    }

    public c a(f fVar, a aVar) {
        return new n(fVar, aVar, this);
    }

    public b b() {
        return this.f;
    }

    public b c() {
        return this.h;
    }

    public String d() {
        return this.a;
    }

    public b e() {
        return this.g;
    }

    public b f() {
        return this.i;
    }

    public b g() {
        return this.c;
    }

    public m<PointF, PointF> h() {
        return this.d;
    }

    public b i() {
        return this.e;
    }

    public i.a j() {
        return this.b;
    }

    public boolean k() {
        return this.j;
    }
}
