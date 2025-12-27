package f.c.a.e.u;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;

/* compiled from: ElevationOverlayProvider.java */
/* loaded from: classes2.dex */
public class a {

    private static final int f = 0;
    private final boolean a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;
    static {
        a.f = (int)Math.round(5.1000000000000005d);
    }

    public a(Context context) {
        final boolean z = false;
        this(b.b(context, b.u, z), a.b(context, b.t, z), a.b(context, b.s, z), a.b(context, b.q, z), context.getResources().getDisplayMetrics().density);
    }

    private boolean e(int i) {
        boolean z = true;
        i = a.i(i, 255) == this.d ? 1 : 0;
        return (a.i(i, 255) == this.d ? 1 : 0);
    }

    public float a(float f) {
        float f3 = 0.0f;
        if (this.e > 0.0f) {
            cmp = (f > f3 ? 1 : (f == f3 ? 0 : -1));
            return Math.min((float)(Math.log1p((double)(f / f2))) * 4.5f + 2f / 100f, 1f);
        }
        return 0.0f;
    }

    public int b(int i, float f) {
        int i2;
        float f3 = a(f);
        f = 0.0f;
        if (f3 > 0.0f && this.c != 0) {
            i2 = a.g(a.h(a.i(i, 255), this.b, f3), a.i(this.c, a.f));
        }
        return a.i(i2, Color.alpha(i));
    }

    public int c(int i, float f) {
        int i2;
        if (this.a && this.e(i)) {
            i2 = b(i, f);
        }
        return i2;
    }

    public boolean d() {
        return this.a;
    }

    public a(boolean z, int i, int i2, int i3, float f) {
        super();
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }
}
