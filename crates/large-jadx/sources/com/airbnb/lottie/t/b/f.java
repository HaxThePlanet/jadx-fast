package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import java.util.List;

/* compiled from: EllipseContent.java */
/* loaded from: classes.dex */
public class f implements m, a.b, k {

    private final Path a = new Path();
    private final String b;
    private final com.airbnb.lottie.f c;
    private final com.airbnb.lottie.t.c.a<?, PointF> d;
    private final com.airbnb.lottie.t.c.a<?, PointF> e;
    private final com.airbnb.lottie.v.k.a f;
    private b g = new b();
    private boolean h;
    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.v.l.a aVar, com.airbnb.lottie.v.k.a aVar2) {
        super();
        Path path = new Path();
        com.airbnb.lottie.t.b.b bVar = new b();
        this.b = aVar2.b();
        this.c = fVar;
        com.airbnb.lottie.t.c.a aVar4 = aVar2.d().j();
        this.d = aVar4;
        com.airbnb.lottie.t.c.a aVar3 = aVar2.c().j();
        this.e = aVar3;
        this.f = aVar2;
        aVar.i(aVar4);
        aVar.i(aVar3);
        aVar4.a(this);
        aVar3.a(this);
    }

    private void e() {
        this.h = false;
        this.c.invalidateSelf();
    }

    public void a() {
        e();
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
        if (t == k.i) {
            this.d.n(cVar);
        } else {
            if (this.d == k.l) {
                this.e.n(cVar);
            }
        }
    }

    public String getName() {
        return this.b;
    }

    public Path getPath() {
        final Object obj = this;
        if (obj.h) {
            return obj.a;
        }
        obj.a.reset();
        final boolean z3 = true;
        if (obj.f.e()) {
            obj.h = z3;
            return obj.a;
        }
        Object obj2 = obj.d.h();
        float f13 = 2f;
        float f2 = obj2.x / f13;
        float f = obj2.y / f13;
        float f14 = 0.55228f;
        f5 = f2 * f14;
        f14 *= f;
        obj.a.reset();
        final float f18 = 0.0f;
        if (obj.f.f()) {
            int i4 = -f;
            obj.a.moveTo(0.0f, i4);
            float f6 = f18 - f5;
            int i3 = -f2;
            f = f18 - f15;
            obj.a.cubicTo(f6, i4, i3, f, i3, 0.0f);
            f3 = f15 + f18;
            obj.a.cubicTo(i3, f3, f6, f, 0.0f, f);
            f5 = f5 + f18;
            obj.a.cubicTo(f5, f, f2, f3, f2, 0.0f);
            obj.a.cubicTo(f2, f, f5, i4, 0.0f, i4);
        } else {
            int i = -f;
            obj.a.moveTo(0.0f, i);
            float f4 = f5 + f18;
            f7 = f18 - f15;
            obj.a.cubicTo(f4, i, f2, f7, f2, 0.0f);
            f3 = f15 + f18;
            obj.a.cubicTo(f2, f3, f4, f, 0.0f, f);
            f2 = f18 - f5;
            i2 = -f2;
            float f8 = 0.0f;
            obj.a.cubicTo(f2, f, i2, f3, i2, f8);
            float f9 = 0.0f;
            obj.a.cubicTo(i2, f7, f2, i, f9, i);
        }
        Object obj3 = obj.e.h();
        obj.a.offset(obj3.x, obj3.y);
        obj.a.close();
        obj.g.b(obj.a);
        obj.h = z3;
        return obj.a;
    }
}
