package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.t.c.c;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.k.j;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import java.util.List;

/* loaded from: classes.dex */
public class o implements a.b, com.airbnb.lottie.t.b.k, com.airbnb.lottie.t.b.m {

    private final Path a;
    private final RectF b;
    private final String c;
    private final boolean d;
    private final f e;
    private final a<?, PointF> f;
    private final a<?, PointF> g;
    private final a<?, Float> h;
    private com.airbnb.lottie.t.b.b i;
    private boolean j;
    public o(f f, a a2, j j3) {
        super();
        Path path = new Path();
        this.a = path;
        RectF rectF = new RectF();
        this.b = rectF;
        b bVar = new b();
        this.i = bVar;
        this.c = j3.c();
        this.d = j3.f();
        this.e = f;
        a obj2 = j3.d().j();
        this.f = obj2;
        a aVar = j3.e().j();
        this.g = aVar;
        a obj4 = j3.b().j();
        this.h = obj4;
        a2.i(obj2);
        a2.i(aVar);
        a2.i(obj4);
        obj2.a(this);
        aVar.a(this);
        obj4.a(this);
    }

    private void e() {
        this.j = false;
        this.e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.c.a$b
    public void a() {
        e();
    }

    public void b(List<com.airbnb.lottie.t.b.c> list, List<com.airbnb.lottie.t.b.c> list2) {
        Object obj;
        boolean z;
        q.a sIMULTANEOUSLY;
        int obj5;
        obj5 = 0;
        while (obj5 < list.size()) {
            obj = list.get(obj5);
            if (obj instanceof s && (s)(c)obj.i() == q.a.SIMULTANEOUSLY) {
            }
            obj5++;
            if ((s)obj.i() == q.a.SIMULTANEOUSLY) {
            }
            this.i.a(obj);
            obj.c(this);
        }
    }

    public void c(e e, int i2, List<e> list3, e e4) {
        g.m(e, i2, list3, e4, this);
    }

    public <T> void g(T t, c<T> c2) {
        Object pointF;
        Object obj2;
        if (t == k.j) {
            this.g.n(c2);
        } else {
            if (t == k.l) {
                this.f.n(c2);
            } else {
                if (t == k.k) {
                    this.h.n(c2);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.t.c.a$b
    public String getName() {
        return this.c;
    }

    @Override // com.airbnb.lottie.t.c.a$b
    public Path getPath() {
        int i12;
        int i3;
        int i9;
        float f;
        Path path4;
        Path path2;
        Object path3;
        Object obj;
        int cmp;
        Path path;
        int i6;
        int i;
        int i10;
        RectF rectF;
        int i2;
        int i8;
        int i4;
        int i5;
        int i11;
        int i7;
        final Object obj2 = this;
        if (obj2.j) {
            return obj2.a;
        }
        obj2.a.reset();
        final int i13 = 1;
        if (obj2.d) {
            obj2.j = i13;
            return obj2.a;
        }
        Object obj3 = obj2.g.h();
        i9 = 1073741824;
        f3 /= i9;
        f2 /= i9;
        a aVar2 = obj2.h;
        int i16 = 0;
        if (aVar2 == null) {
            f = i16;
        } else {
            f = (c)aVar2.p();
        }
        float f5 = Math.min(i3, i12);
        if (Float.compare(f, f5) > 0) {
            f = f5;
        }
        obj = obj2.f.h();
        obj2.a.moveTo(f7 += i3, i20 += f);
        obj2.a.lineTo(f8 += i3, i22 -= f);
        cmp = Float.compare(f, i16);
        int i19 = 0;
        int i24 = 1119092736;
        if (cmp > 0) {
            float f19 = obj.x;
            int i39 = f * i9;
            float f22 = obj.y;
            obj2.b.set(i37 -= i39, i7 - i39, f19 += i3, f22 += i12);
            obj2.a.arcTo(obj2.b, i16, i24, i19);
        }
        obj2.a.lineTo(i25 += f, f16 += i12);
        if (cmp > 0) {
            float f12 = obj.x;
            float f20 = obj.y;
            i11 = f * i9;
            obj2.b.set(f12 - i3, i38 -= i11, i26 += i11, f20 += i12);
            obj2.a.arcTo(obj2.b, i24, i24, i19);
        }
        obj2.a.lineTo(f13 -= i3, i32 += f);
        if (cmp > 0) {
            float f14 = obj.x;
            float f21 = obj.y;
            i11 = f * i9;
            obj2.b.set(f14 - i3, f21 - i12, i28 += i11, i36 += i11);
            obj2.a.arcTo(obj2.b, 1127481344, i24, i19);
        }
        obj2.a.lineTo(i30 -= f, f18 -= i12);
        if (cmp > 0) {
            float f6 = obj.x;
            f *= i9;
            float f4 = obj.y;
            obj2.b.set(i31 -= f, f4 - i12, f6 += i3, i14 += f);
            obj2.a.arcTo(obj2.b, 1132920832, i24, i19);
        }
        obj2.a.close();
        obj2.i.b(obj2.a);
        obj2.j = i13;
        return obj2.a;
    }
}
