package com.airbnb.lottie.v.k;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.r;
import com.airbnb.lottie.v.j.a;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.l.a;
import java.util.List;

/* loaded from: classes.dex */
public class p implements com.airbnb.lottie.v.k.b {

    private final String a;
    private final b b;
    private final List<b> c;
    private final a d;
    private final d e;
    private final b f;
    private final com.airbnb.lottie.v.k.p.b g;
    private final com.airbnb.lottie.v.k.p.c h;
    private final float i;
    private final boolean j;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            p.a.b = iArr;
            int i2 = 1;
            iArr[p.c.BEVEL.ordinal()] = i2;
            int i = 2;
            p.a.b[p.c.MITER.ordinal()] = i;
            int i3 = 3;
            p.a.b[p.c.ROUND.ordinal()] = i3;
            int[] iArr6 = new int[values2.length];
            p.a.a = iArr6;
            iArr6[p.b.BUTT.ordinal()] = i2;
            p.a.a[p.b.ROUND.ordinal()] = i;
            p.a.a[p.b.UNKNOWN.ordinal()] = i3;
        }
    }

    public static enum b {

        BUTT,
        ROUND,
        UNKNOWN;
        @Override // java.lang.Enum
        public Paint.Cap toPaintCap() {
            int i = p.a.a[ordinal()];
            if (i != 1 && i != 2) {
                if (i != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    public static enum c {

        MITER,
        ROUND,
        BEVEL;
        @Override // java.lang.Enum
        public Paint.Join toPaintJoin() {
            int i = p.a.b[ordinal()];
            if (i != 1 && i != 2 && i != 3) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }
    public p(String string, b b2, List<b> list3, a a4, d d5, b b6, com.airbnb.lottie.v.k.p.b p$b7, com.airbnb.lottie.v.k.p.c p$c8, float f9, boolean z10) {
        super();
        this.a = string;
        this.b = b2;
        this.c = list3;
        this.d = a4;
        this.e = d5;
        this.f = b6;
        this.g = b7;
        this.h = c8;
        this.i = f9;
        this.j = z10;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        r rVar = new r(f, a2, this);
        return rVar;
    }

    @Override // com.airbnb.lottie.v.k.b
    public com.airbnb.lottie.v.k.p.b b() {
        return this.g;
    }

    @Override // com.airbnb.lottie.v.k.b
    public a c() {
        return this.d;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b d() {
        return this.b;
    }

    @Override // com.airbnb.lottie.v.k.b
    public com.airbnb.lottie.v.k.p.c e() {
        return this.h;
    }

    public List<b> f() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public float g() {
        return this.i;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String h() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v.k.b
    public d i() {
        return this.e;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b j() {
        return this.f;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean k() {
        return this.j;
    }
}
