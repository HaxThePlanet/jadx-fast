package f.c.a.e.u;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import d.h.f.a;
import f.c.a.e.a0.b;
import f.c.a.e.b;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
public class a {

    private static final int f;
    private final boolean a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;
    static {
        a.f = (int)round;
    }

    public a(Context context) {
        final int i5 = 0;
        super(b.b(context, b.u, i5), a.b(context, b.t, i5), a.b(context, b.s, i5), a.b(context, b.q, i5), obj9.density);
    }

    public a(boolean z, int i2, int i3, int i4, float f5) {
        super();
        this.a = z;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = f5;
    }

    private boolean e(int i) {
        int obj2;
        obj2 = a.i(i, 255) == this.d ? 1 : 0;
        return obj2;
    }

    public float a(float f) {
        int cmp;
        float f2 = this.e;
        int i5 = 0;
        cmp = Float.compare(f, i5);
        if (Float.compare(f2, i5) > 0 && cmp <= 0) {
            cmp = Float.compare(f, i5);
            if (cmp <= 0) {
            }
            return Math.min(obj4 /= i3, 1065353216);
        }
        return i5;
    }

    public int b(int i, float f2) {
        int i2;
        int obj3;
        int obj4;
        obj4 = a(f2);
        obj4 = this.c;
        if (Float.compare(obj4, i2) > 0 && obj4 != null) {
            obj4 = this.c;
            if (obj4 != null) {
                obj3 = a.g(a.h(a.i(i, 255), this.b, obj4), a.i(obj4, a.f));
            }
        }
        return a.i(obj3, Color.alpha(i));
    }

    public int c(int i, float f2) {
        boolean z;
        int obj2;
        if (this.a && e(i)) {
            if (e(i)) {
                obj2 = b(i, f2);
            }
        }
        return obj2;
    }

    public boolean d() {
        return this.a;
    }
}
