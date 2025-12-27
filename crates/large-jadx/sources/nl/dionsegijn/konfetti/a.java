package nl.dionsegijn.konfetti;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.g0.c.a;
import nl.dionsegijn.konfetti.e.b;
import nl.dionsegijn.konfetti.e.d;

/* compiled from: Confetti.kt */
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
    private final nl.dionsegijn.konfetti.e.c k;
    private final b l;
    private long m;
    private final boolean n;
    private d o;
    private d p;
    private final boolean q;
    private final boolean r;
    private final float s;
    private final float t;
    public a(d dVar, int i, nl.dionsegijn.konfetti.e.c cVar, b bVar, long j, boolean z, d dVar2, d dVar3, boolean z2, boolean z3, float f, float f2) {
        n.f(dVar, "location");
        n.f(cVar, "size");
        n.f(bVar, "shape");
        n.f(dVar2, "acceleration");
        n.f(dVar3, "velocity");
        super();
        this.i = dVar;
        this.j = i;
        this.k = cVar;
        this.l = bVar;
        this.m = j;
        this.n = z;
        this.o = dVar2;
        this.p = dVar3;
        this.q = z2;
        this.r = z3;
        this.s = f;
        this.t = f2;
        this.a = cVar.a();
        this.b = cVar.b();
        Paint paint = new Paint();
        this.c = paint;
        this.f = this.b;
        this.g = 60f;
        this.h = 255;
        Resources system = Resources.getSystem();
        n.e(system, "Resources.getSystem()");
        float f6 = system.getDisplayMetrics().density * 0.29f;
        f = (float)3 * f6;
        if (z2) {
            f = (float)3 * f6 * Random.b.c() + f6 * f2;
            this.d = f;
        }
        paint.setColor(i);
    }

    private final void b(Canvas canvas) {
        float f5 = this.i.f();
        float f15 = (float)canvas.getHeight();
        if (f5 > f15) {
            this.m = 0L;
            return;
        }
        float f6 = this.i.e();
        f = (float)canvas.getWidth();
        if (f6 <= f) {
            float f8 = this.i.e() + c();
            f = (float)0;
            if (this.i >= f) {
                float f10 = this.i.f() + c();
                if (this.i >= f) {
                    this.c.setAlpha(this.h);
                    float f18 = (float)2;
                    float f14 = (Math.abs((this.f / this.b) - 0.5f)) * f18;
                    float f21 = (this.b * f14) / f18;
                    canvas.translate(this.i.e() - f21, this.i.f());
                    f4 = this.b / f18;
                    canvas.rotate(this.e, f21, f4);
                    canvas.scale(f14, 1f);
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
        if (this.r) {
            float f3 = this.o.f();
            if (f3 >= this.s) {
                if (this.s == -1082130432) {
                    this.p.a(this.o);
                }
            }
        }
        final float f13 = 0.0f;
        d dVar5 = d.c(this.p, f13, f13, 3, null);
        dVar5.g(this.g * f);
        this.i.a(dVar5);
        long l2 = 0L;
        if (this.m <= l2) {
            g(f);
        } else {
            f2 = (float)1000 * f;
            l2 = (long)f2;
            this.m -= l2;
        }
        float f6 = (this.d * f) * this.g;
        this.e += f6;
        float f11 = (float)360;
        if (this.g >= this.i) {
            this.e = 0.0f;
        }
        this.f -= f6;
        float f7 = (float)0;
        if (this.g < this.r) {
            this.f = this.b;
        }
    }

    private final void g(float f) {
        final int i4 = 0;
        if (!this.n) {
            this.h = i4;
        } else {
            f2 = (float)5 * f;
            f3 = (float)i - (f2 * f8);
            float f6 = (float)i4;
            if (f3 < f6) {
                this.h = i4;
            } else {
                f2 = f2 * f8;
                i2 = (int)f2;
                this.h -= i2;
            }
        }
    }

    public final void a(d dVar) {
        n.f(dVar, "force");
        float f = 0.0f;
        final d dVar3 = d.c(dVar, f, f, 3, null);
        dVar3.d(this.a);
        this.o.a(dVar3);
    }

    public final boolean d() {
        boolean z = true;
        float f = (float)this.h;
        int r0 = this.h <= 0 ? 1 : 0;
        return (this.h <= 0 ? 1 : 0);
    }

    public final void e(Canvas canvas, float f) {
        n.f(canvas, "canvas");
        f(f);
        b(canvas);
    }

    public /* synthetic */ a(d dVar, int i, nl.dionsegijn.konfetti.e.c cVar, b bVar, long j, boolean z, d dVar2, d dVar3, boolean z2, boolean z3, float f, float f2, int i2, g gVar) {
        int j52;
        d dVar72;
        d dVar82;
        boolean z92;
        boolean z102;
        int i4;
        int i3;
        int i132;
        int gVar142 = i2;
        j52 = gVar142 & 16;
        j52 = gVar142 & 16 != 0 ? j52 : j;
        i4 = 1;
        int r10 = gVar142 & 32 != 0 ? i4 : z;
        f = 0.0f;
        d r11 = gVar142 & 64 != 0 ? new d(f, f) : dVar2;
        i = gVar142 & 128;
        if (gVar142 & 128 != 0) {
            int i5 = 3;
            gVar = null;
        } else {
            z92 = dVar3;
        }
        int r13 = gVar142 & 256 != 0 ? i4 : z2;
        int r14 = gVar142 & 512 != 0 ? i4 : z3;
        i3 = gVar142 & 1024;
        i3 = gVar142 & 1024 != 0 ? i3 : f;
        i132 = gVar142 & 2048;
        i132 = gVar142 & 2048 != 0 ? i132 : f2;
        this(dVar, i, cVar, bVar, j52, z, dVar72, dVar82, z92, z102, i4, i3, i132);
    }
}
