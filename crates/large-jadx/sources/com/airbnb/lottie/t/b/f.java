package com.airbnb.lottie.t.b;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.t.c.a;
import com.airbnb.lottie.t.c.a.b;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.j.f;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.k.a;
import com.airbnb.lottie.v.k.q.a;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import java.util.List;

/* loaded from: classes.dex */
public class f implements com.airbnb.lottie.t.b.m, a.b, com.airbnb.lottie.t.b.k {

    private final Path a;
    private final String b;
    private final f c;
    private final a<?, PointF> d;
    private final a<?, PointF> e;
    private final a f;
    private com.airbnb.lottie.t.b.b g;
    private boolean h;
    public f(f f, a a2, a a3) {
        super();
        Path path = new Path();
        this.a = path;
        b bVar = new b();
        this.g = bVar;
        this.b = a3.b();
        this.c = f;
        a obj2 = a3.d().j();
        this.d = obj2;
        a aVar = a3.c().j();
        this.e = aVar;
        this.f = a3;
        a2.i(obj2);
        a2.i(aVar);
        obj2.a(this);
        aVar.a(this);
    }

    private void e() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.t.b.m
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
            this.g.a(obj);
            obj.c(this);
        }
    }

    public void c(e e, int i2, List<e> list3, e e4) {
        g.m(e, i2, list3, e4, this);
    }

    public <T> void g(T t, c<T> c2) {
        PointF pointF;
        Object obj2;
        if (t == k.i) {
            this.d.n(c2);
        } else {
            if (t == k.l) {
                this.e.n(c2);
            }
        }
    }

    @Override // com.airbnb.lottie.t.b.m
    public String getName() {
        return this.b;
    }

    @Override // com.airbnb.lottie.t.b.m
    public Path getPath() {
        int i13;
        int i5;
        int i9;
        Path path2;
        int i3;
        int i;
        int i6;
        int i8;
        int i4;
        int i15;
        int i16;
        Path path;
        int i12;
        int i14;
        int i7;
        int i2;
        int i17;
        int i10;
        int i11;
        final Object obj = this;
        if (obj.h) {
            return obj.a;
        }
        obj.a.reset();
        final int i18 = 1;
        if (obj.f.e()) {
            obj.h = i18;
            return obj.a;
        }
        Object obj2 = obj.d.h();
        int i19 = 1073741824;
        f3 /= i19;
        f /= i19;
        int i20 = 1057841721;
        i16 = i5 * i20;
        i20 *= i13;
        obj.a.reset();
        final int i47 = 0;
        if (obj.f.f()) {
            int i44 = -i13;
            obj.a.moveTo(i47, i44);
            int i32 = i47 - i16;
            int i24 = -i5;
            i11 = i47 - i21;
            obj.a.cubicTo(i32, i44, i24, i11, i24, 0);
            i21 += i47;
            path = i44;
            obj.a.cubicTo(i24, i9, i32, i13, 0, i13);
            i16 += i47;
            obj.a.cubicTo(i16, i13, i5, i9, i5, 0);
            obj.a.cubicTo(i5, i11, i16, path, 0, path);
        } else {
            int i49 = -i13;
            obj.a.moveTo(i47, i49);
            int i48 = i16 + i47;
            i14 = i47 - i21;
            obj.a.cubicTo(i48, i49, i5, i14, i5, 0);
            i21 += i47;
            obj.a.cubicTo(i5, i9, i48, i13, 0, i13);
            i7 = i47 - i16;
            i5 = -i5;
            obj.a.cubicTo(i7, i13, i5, i9, i5, 0);
            i13 = i49;
            obj.a.cubicTo(i5, i14, i7, i13, 0, i13);
        }
        Object obj3 = obj.e.h();
        obj.a.offset(obj3.x, obj3.y);
        obj.a.close();
        obj.g.b(obj.a);
        obj.h = i18;
        return obj.a;
    }
}
