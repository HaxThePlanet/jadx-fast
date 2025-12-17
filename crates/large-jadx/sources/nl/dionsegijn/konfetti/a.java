package nl.dionsegijn.konfetti;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.g0.c;
import kotlin.g0.c.a;
import nl.dionsegijn.konfetti.e.b;
import nl.dionsegijn.konfetti.e.c;
import nl.dionsegijn.konfetti.e.d;

/* loaded from: classes3.dex */
public final class a {

    private final float a;
    private float b;
    private final Paint c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private d i;
    private final int j;
    private final c k;
    private final b l;
    private long m;
    private final boolean n;
    private d o;
    private d p;
    private final boolean q;
    private final boolean r;
    private final float s;
    private final float t;
    public a(d d, int i2, c c3, b b4, long l5, boolean z6, d d7, d d8, boolean z9, boolean z10, float f11, float f12) {
        int obj5;
        long obj6;
        n.f(d, "location");
        n.f(c3, "size");
        n.f(b4, "shape");
        n.f(d8, "acceleration");
        n.f(z9, "velocity");
        super();
        this.i = d;
        this.j = i2;
        this.k = c3;
        this.l = b4;
        this.m = l5;
        this.n = d7;
        this.o = d8;
        this.p = z9;
        this.q = z10;
        this.r = f11;
        this.s = f12;
        this.t = obj14;
        this.a = c3.a();
        this.b = c3.b();
        Paint obj2 = new Paint();
        this.c = obj2;
        this.f = this.b;
        this.g = 1114636288;
        this.h = 255;
        Resources obj4 = Resources.getSystem();
        n.e(obj4, "Resources.getSystem()");
        obj4 *= obj5;
        if (z10) {
            this.d = obj5 *= obj14;
        }
        obj2.setColor(i2);
    }

    public a(d d, int i2, c c3, b b4, long l5, boolean z6, d d7, d d8, boolean z9, boolean z10, float f11, float f12, int i13, g g14) {
        int i7;
        int i8;
        d dVar2;
        int dVar;
        int i6;
        int i11;
        int i4;
        int i;
        int i9;
        d dVar4;
        d dVar3;
        int i5;
        int i3;
        int i10;
        int i12;
        int i14 = g14;
        i = i14 & 16 != 0 ? i8 : l5;
        final int i18 = 1;
        i9 = i14 & 32 != 0 ? i18 : d7;
        int i19 = 0;
        if (i14 & 64 != 0) {
            dVar2 = new d(i19, i19);
            dVar4 = dVar2;
        } else {
            dVar4 = d8;
        }
        if (i14 & 128 != 0) {
            dVar = new d(i19, i19, 3, 0);
            dVar3 = dVar;
        } else {
            dVar3 = z9;
        }
        i5 = i14 & 256 != 0 ? i18 : z10;
        i3 = i14 & 512 != 0 ? i18 : f11;
        i10 = i14 & 1024 != 0 ? i6 : f12;
        i12 = i14 &= 2048 != 0 ? i7 : i13;
        super(d, i2, c3, b4, i, obj9, i9, dVar4, dVar3, i5, i3, i10, i12);
    }

    private final void b(Canvas canvas) {
        int cmp;
        float f3;
        float f;
        int save;
        float f2;
        int i;
        if (Float.compare(f4, f10) > 0) {
            this.m = 0;
        }
        f3 = (float)i8;
        if (Float.compare(f5, f3) <= 0 && Float.compare(i2, f3) >= 0) {
            f3 = (float)i8;
            if (Float.compare(i2, f3) >= 0) {
                if (Float.compare(i3, f3) < 0) {
                } else {
                    this.c.setAlpha(this.h);
                    float f13 = (float)i11;
                    f9 *= f13;
                    i13 /= f13;
                    canvas.translate(f15 -= i14, this.i.f());
                    canvas.rotate(this.e, i14, f17 /= f13);
                    canvas.scale(i6, 1065353216);
                    this.l.a(canvas, this.c, this.b);
                    canvas.restoreToCount(canvas.save());
                }
            }
        }
    }

    private final float c() {
        return this.b;
    }

    private final void f(float f) {
        int cmp;
        int l;
        d f2;
        int cmp2;
        long i;
        int obj7;
        if (this.r) {
            f2 = this.s;
            if (Float.compare(f3, f2) >= 0) {
                if (Float.compare(f2, i2) == 0) {
                    this.p.a(this.o);
                }
            } else {
            }
        }
        final int i11 = 0;
        d dVar3 = d.c(this.p, i11, i11, 3, 0);
        dVar3.g(f6 *= f);
        this.i.a(dVar3);
        l = this.m;
        if (Long.compare(l, i) <= 0) {
            g(f);
        } else {
            this.m = l -= i;
        }
        i3 *= obj7;
        obj7 += i4;
        this.e = obj7;
        if (Float.compare(obj7, f7) >= 0) {
            this.e = i11;
        }
        obj7 -= i4;
        this.f = obj7;
        if (Float.compare(obj7, f5) < 0) {
            this.f = this.b;
        }
    }

    private final void g(float f) {
        int z;
        int cmp;
        int i;
        int i2;
        int obj6;
        final int i4 = 0;
        if (this.n) {
            f2 *= f;
            obj6 = this.g;
            i = this.h;
            if (Float.compare(i2, f3) < 0) {
                this.h = i4;
            } else {
                this.h = i -= obj6;
            }
        } else {
            this.h = i4;
        }
    }

    public final void a(d d) {
        n.f(d, "force");
        int i = 0;
        final d obj4 = d.c(d, i, i, 3, 0);
        obj4.d(this.a);
        this.o.a(obj4);
    }

    public final boolean d() {
        int i;
        i = Float.compare(f, i3) <= 0 ? 1 : 0;
        return i;
    }

    public final void e(Canvas canvas, float f2) {
        n.f(canvas, "canvas");
        f(f2);
        b(canvas);
    }
}
