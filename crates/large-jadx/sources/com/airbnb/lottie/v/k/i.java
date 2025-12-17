package com.airbnb.lottie.v.k;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.n;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.l.a;

/* loaded from: classes.dex */
public class i implements com.airbnb.lottie.v.k.b {

    private final String a;
    private final com.airbnb.lottie.v.k.i.a b;
    private final b c;
    private final m<PointF, PointF> d;
    private final b e;
    private final b f;
    private final b g;
    private final b h;
    private final b i;
    private final boolean j;

    public static enum a {

        STAR(true),
        POLYGON(2);

        private final int value;
        public static com.airbnb.lottie.v.k.i.a forValue(int i) {
            int i2;
            com.airbnb.lottie.v.k.i.a aVar;
            int value;
            final com.airbnb.lottie.v.k.i.a[] values = i.a.values();
            i2 = 0;
            while (i2 < values.length) {
                aVar = values[i2];
                i2++;
            }
            return null;
        }
    }
    public i(String string, com.airbnb.lottie.v.k.i.a i$a2, b b3, m<PointF, PointF> m4, b b5, b b6, b b7, b b8, b b9, boolean z10) {
        super();
        this.a = string;
        this.b = a2;
        this.c = b3;
        this.d = m4;
        this.e = b5;
        this.f = b6;
        this.g = b7;
        this.h = b8;
        this.i = b9;
        this.j = z10;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        n nVar = new n(f, a2, this);
        return nVar;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b b() {
        return this.f;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b c() {
        return this.h;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String d() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b e() {
        return this.g;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b f() {
        return this.i;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b g() {
        return this.c;
    }

    public m<PointF, PointF> h() {
        return this.d;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b i() {
        return this.e;
    }

    @Override // com.airbnb.lottie.v.k.b
    public com.airbnb.lottie.v.k.i.a j() {
        return this.b;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean k() {
        return this.j;
    }
}
