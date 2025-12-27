package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.k.j;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.y.g;
import java.util.List;

/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
public class o implements a.b, k, m {

    private final Path a = new Path();
    private final RectF b = new RectF();
    private final String c;
    private final boolean d;
    private final f e;
    private final com.airbnb.lottie.t.c.a<?, PointF> f;
    private final com.airbnb.lottie.t.c.a<?, PointF> g;
    private final com.airbnb.lottie.t.c.a<?, Float> h;
    private b i = new b();
    private boolean j;
    public o(f fVar, com.airbnb.lottie.v.l.a aVar, j jVar) {
        super();
        Path path = new Path();
        RectF rectF = new RectF();
        com.airbnb.lottie.t.b.b bVar = new b();
        this.c = jVar.c();
        this.d = jVar.f();
        this.e = fVar;
        com.airbnb.lottie.t.c.a aVar3 = jVar.d().j();
        this.f = aVar3;
        com.airbnb.lottie.t.c.a aVar2 = jVar.e().j();
        this.g = aVar2;
        com.airbnb.lottie.t.c.a aVar4 = jVar.b().j();
        this.h = aVar4;
        aVar.i(aVar3);
        aVar.i(aVar2);
        aVar.i(aVar4);
        aVar3.a(this);
        aVar2.a(this);
        aVar4.a(this);
    }

    private void e() {
        this.j = false;
        this.e.invalidateSelf();
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

    public <T> void g(T t, com.airbnb.lottie.z.c<T> cVar) {
        if (t == k.j) {
            this.g.n(cVar);
        } else {
            if (this.g == k.l) {
                this.f.n(cVar);
            } else {
                if (this.g == k.k) {
                    this.h.n(cVar);
                }
            }
        }
    }

    public String getName() {
        return this.c;
    }

    public Path getPath() {
        float min;
        float f9;
        float f10;
        float f11;
        final Object obj2 = this;
        if (obj2.j) {
            return obj2.a;
        }
        obj2.a.reset();
        final boolean z3 = true;
        if (obj2.d) {
            obj2.j = z3;
            return obj2.a;
        }
        Object obj3 = obj2.g.h();
        float f3 = 2f;
        f2 = obj3.x / f3;
        f = obj3.y / f3;
        float f18 = 0.0f;
        if (obj2.h == null) {
            int i = f18;
        } else {
            min = aVar2.p();
        }
        min = Math.min(f2, f);
        if (min > min) {
        }
        Object obj = obj2.f.h();
        obj2.a.moveTo(obj.x + f2, (obj.y - f) + min);
        obj2.a.lineTo(obj.x + f2, (obj.y + f) - min);
        boolean z4 = false;
        float f32 = 90f;
        if (min > 0.0f) {
            float f58 = min * f3;
            f9 = (f51 + f2) - f58;
            f12 = f59 + f;
            f10 = f12 - f58;
            f11 = f59 + f;
            obj2.b.set(f9, f10, f51 + f2, f11);
            obj2.a.arcTo(obj2.b, 0.0f, f32, z4);
        }
        f4 = (obj.x - f2) + min;
        f7 = obj.y + f;
        obj2.a.lineTo(f4, f7);
        if (min > 0.0f) {
            f7 = f35 - f2;
            f11 = min * f3;
            f10 = (f53 + f) - f11;
            f9 = f53 + f;
            obj2.b.set(f7, f10, (f35 - f2) + f11, f9);
            obj2.a.arcTo(obj2.b, f32, f32, z4);
        }
        f5 = obj.x - f2;
        f8 = (obj.y - f) + min;
        obj2.a.lineTo(f5, f8);
        if (min > 0.0f) {
            f10 = f54 - f;
            f11 = min * f3;
            f9 = (f54 - f) + f11;
            obj2.b.set(f39 - f2, f10, (f39 - f2) + f11, f9);
            float f8 = 180f;
            obj2.a.arcTo(obj2.b, f8, f32, z4);
        }
        f6 = (obj.x + f2) - min;
        obj2.a.lineTo(f6, obj.y - f);
        if (min > 0.0f) {
            min = min * f3;
            f6 = (f20 + f2) - min;
            obj2.b.set(f6, f15 - f, f20 + f2, (f15 - f) + min);
            f3 = 270f;
            obj2.a.arcTo(obj2.b, f3, f32, z4);
        }
        obj2.a.close();
        obj2.i.b(obj2.a);
        obj2.j = z3;
        return obj2.a;
    }
}
