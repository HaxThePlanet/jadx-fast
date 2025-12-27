package com.airbnb.lottie.v.k;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.r;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.d;
import java.util.List;

/* compiled from: ShapeStroke.java */
/* loaded from: classes.dex */
public class p implements b {

    private final String a;
    private final b b;
    private final List<b> c;
    private final com.airbnb.lottie.v.j.a d;
    private final d e;
    private final b f;
    private final p.b g;
    private final p.c h;
    private final float i;
    private final boolean j;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[p.c.values().length];
            p.a.b = iArr;
            int i2 = 1;
            try {
                iArr[p.c.BEVEL.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int[] iArr6 = new int[p.b.values().length];
                p.a.a = iArr6;
                return;
            }
            int i = 2;
            try {
                p.a.b[p.c.MITER.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum b {

        BUTT,
        ROUND,
        UNKNOWN;
        @Override // java.lang.Enum
        public Paint.Cap toPaintCap() {
            int i = p.a.a[ordinal()];
            if (p.a.a != 1 && p.a.a != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.BUTT;
        }
    }

    public enum c {

        BEVEL,
        MITER,
        ROUND;
        @Override // java.lang.Enum
        public Paint.Join toPaintJoin() {
            int i = p.a.b[ordinal()];
            if (p.a.b != 1 && p.a.b != 2) {
                if (p.a.b != 3) {
                    return null;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.BEVEL;
        }
    }
    public p(String str, b bVar, List<b> list, com.airbnb.lottie.v.j.a aVar, d dVar, b bVar2, p.b bVar3, p.c cVar, float f, boolean z) {
        super();
        this.a = str;
        this.b = bVar;
        this.c = list;
        this.d = aVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = bVar3;
        this.h = cVar;
        this.i = f;
        this.j = z;
    }

    public c a(f fVar, com.airbnb.lottie.v.l.a aVar) {
        return new r(fVar, aVar, this);
    }

    public p.b b() {
        return this.g;
    }

    public com.airbnb.lottie.v.j.a c() {
        return this.d;
    }

    public b d() {
        return this.b;
    }

    public p.c e() {
        return this.h;
    }

    public List<b> f() {
        return this.c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.a;
    }

    public d i() {
        return this.e;
    }

    public b j() {
        return this.f;
    }

    public boolean k() {
        return this.j;
    }
}
