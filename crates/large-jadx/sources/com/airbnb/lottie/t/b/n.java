package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.k.i;
import com.airbnb.lottie.v.k.i.a;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class n implements m, a.b, k {

    private final Path a = new Path();
    private final String b;
    private final f c;
    private final i.a d;
    private final boolean e;
    private final com.airbnb.lottie.t.c.a<?, Float> f;
    private final com.airbnb.lottie.t.c.a<?, PointF> g;
    private final com.airbnb.lottie.t.c.a<?, Float> h;
    private final com.airbnb.lottie.t.c.a<?, Float> i = null;
    private final com.airbnb.lottie.t.c.a<?, Float> j;
    private final com.airbnb.lottie.t.c.a<?, Float> k = null;
    private final com.airbnb.lottie.t.c.a<?, Float> l;
    private b m = new b();
    private boolean n;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[i.a.values().length];
            n.a.a = iArr;
            try {
                iArr[i.a.STAR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n.a.a[i.a.POLYGON.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public n(f fVar, com.airbnb.lottie.v.l.a aVar, i iVar) {
        int i = 0;
        super();
        Path path = new Path();
        com.airbnb.lottie.t.b.b bVar = new b();
        this.c = fVar;
        this.b = iVar.d();
        i.a aVar3 = iVar.j();
        this.d = aVar3;
        this.e = iVar.k();
        com.airbnb.lottie.t.c.a aVar4 = iVar.g().j();
        this.f = aVar4;
        com.airbnb.lottie.t.c.a aVar5 = iVar.h().j();
        this.g = aVar5;
        com.airbnb.lottie.t.c.a aVar6 = iVar.i().j();
        this.h = aVar6;
        com.airbnb.lottie.t.c.a aVar7 = iVar.e().j();
        this.j = aVar7;
        com.airbnb.lottie.t.c.a aVar8 = iVar.f().j();
        this.l = aVar8;
        final i.a sTAR2 = i.a.STAR;
        if (aVar3 == i.a.STAR) {
            this.i = iVar.b().j();
            this.k = iVar.c().j();
        } else {
            i = 0;
        }
        aVar.i(aVar4);
        aVar.i(aVar5);
        aVar.i(aVar6);
        aVar.i(aVar7);
        aVar.i(aVar8);
        if (aVar3 == i.a.STAR) {
            aVar.i(this.i);
            aVar.i(this.k);
        }
        aVar4.a(this);
        aVar5.a(this);
        aVar6.a(this);
        aVar7.a(this);
        aVar8.a(this);
        if (aVar3 == i.a.STAR) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    private void e() {
        int i = 0;
        double d2 = 0;
        double d3;
        double d4;
        double ceiled;
        int cmp;
        double d8;
        float f2;
        float f;
        double d5;
        Path path2;
        float f3;
        float f4;
        float f5;
        float f6;
        final Object obj = this;
        double floored = Math.floor((double)(Float)obj.f.h().floatValue());
        if (obj.h == null) {
            int i3 = 0;
        } else {
            d2 = (double)(Float)obj.h.h().floatValue();
        }
        double radians = Math.toRadians(d2 - 90d);
        d5 = 6.283185307179586d / floored;
        float f18 = (Float)obj.l.h().floatValue() / 100f;
        float value4 = (Float)obj.j.h().floatValue();
        d8 = (double)value4;
        f2 = (float)(Math.cos(radians) * d8);
        f = (float)(Math.sin(radians) * d8);
        obj.a.moveTo(f2, f);
        d3 = radians + d5;
        ceiled = Math.ceil(floored);
        i = 0;
        double d19 = (double)i;
        while (d19 < ceiled) {
            double d9 = Math.cos(d3) * d8;
            f2 = (float)d9;
            double d6 = d8 * Math.sin(d3);
            f = (float)d6;
            d3 = d3 + d5;
            i = i + 1;
        }
        Object obj3 = obj.g.h();
        obj.a.offset(obj3.x, obj3.y);
        obj.a.close();
    }

    private void h() {
        double d = 0;
        double radians;
        double d2;
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        float value2;
        double d6;
        int cmp;
        float f6;
        double d3;
        double d10;
        float f9;
        double cos;
        float f10;
        Path path2;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        final Object obj = this;
        float value = (Float)obj.f.h().floatValue();
        if (obj.h == null) {
            int i2 = 0;
        } else {
            d = (double)(Float)obj.h.h().floatValue();
        }
        d3 = (double)value;
        f = (float)(6.283185307179586d / d3);
        f2 = f / 2f;
        value -= value;
        f6 = 0.0f;
        cmp = (f16 > f6 ? 1 : (f16 == f6 ? 0 : -1));
        if (obj.f != 0.0f) {
            d9 = (double)(1f - f16) * f2;
            radians = (Math.toRadians(d - 90d)) + d9;
        }
        value2 = (Float)obj.j.h().floatValue();
        value2 = (Float)obj.i.h().floatValue();
        float f27 = 100f;
        if (obj.k != null) {
            f6 = (Float)obj.k.h().floatValue() / f27;
        } else {
        }
        if (obj.l != null) {
            f6 = (Float)obj.l.h().floatValue() / f27;
        } else {
        }
        if (obj.f != 0.0f) {
            value2 = (value2 - value2) * f16 + value2;
            double d21 = (double)value2;
            f3 = (float)(d21 * Math.cos(radians));
            f4 = (float)(d21 * Math.sin(radians));
            obj.a.moveTo(f3, f4);
            float f5 = 2f;
            d5 = (double)(f * f16) / f5;
            d2 = radians + d5;
        } else {
            double d18 = (double)value2;
            f3 = (float)(Math.cos(radians) * d18);
            f4 = (float)(d18 * Math.sin(radians));
            obj.a.moveTo(f3, f4);
            d2 = radians + (double)f2;
            int i6 = 0;
        }
        double d28 = 2d;
        d6 = Math.ceil(d3) * d28;
        i = 0;
        d10 = (double)i;
        while (obj.j < obj.a) {
            float r24 = value2;
            double d12 = 1d;
            double d25 = (double)value2;
            double d4 = d25 * Math.cos(d2);
            f3 = (float)d4;
            d25 *= sin2;
            f4 = (float)d7;
            float f21 = 0.0f;
            d2 = d2 + (double)f2;
            i = i ^ 1;
            i = i + 1;
        }
        Object obj3 = obj.g.h();
        obj.a.offset(obj3.x, obj3.y);
        obj.a.close();
    }

    private void i() {
        this.n = false;
        this.c.invalidateSelf();
    }

    public void a() {
        i();
    }

    public void b(List<c> list, List<c> list2) {
        boolean z;
        q.a sIMULTANEOUSLY2;
        int i = 0;
        i = 0;
        while (i < list.size()) {
            Object item = list.get(i);
            z = item instanceof s;
            i = i + 1;
        }
    }

    public void c(e eVar, int i, List<e> list, e eVar2) {
        g.m(eVar, i, list, eVar2, this);
    }

    public <T> void g(T t, c<T> cVar) {
        if (t == k.u) {
            this.f.n(cVar);
        } else {
            if (this.f == k.v) {
                this.h.n(cVar);
            } else {
                if (this.f == k.l) {
                    this.g.n(cVar);
                } else {
                    if (this.g != k.w || this.i == null) {
                        if (this.g == k.x) {
                            this.j.n(cVar);
                        } else {
                            if (this.g != k.y || this.k == null) {
                                if (this.g == k.z) {
                                    this.l.n(cVar);
                                }
                            } else {
                                this.k.n(cVar);
                            }
                        }
                    } else {
                        this.i.n(cVar);
                    }
                }
            }
        }
    }

    public String getName() {
        return this.b;
    }

    public Path getPath() {
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        final boolean z3 = true;
        if (this.e) {
            this.n = z3;
            return this.a;
        }
        int i = n.a.a[this.d.ordinal()];
        if (this.a == z3) {
            h();
        } else {
            int ordinal = 2;
            if (this.a == 2) {
                e();
            }
        }
        this.a.close();
        this.m.b(this.a);
        this.n = z3;
        return this.a;
    }
}
