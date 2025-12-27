package d.u;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import d.h.l.u;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
class f0 {

    private static final l0 a = new l0();
    static final Property<View, Float> b = new f0$a<>();

    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float a(View view) {
            return Float.valueOf(f0.c(view));
        }

        @Override // android.util.Property
        public void b(View view, Float float) {
            f0.g(view, float.floatValue());
        }
    }

    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Rect a(View view) {
            return u.u(view);
        }

        @Override // android.util.Property
        public void b(View view, Rect rect) {
            u.r0(view, rect);
        }
    }
    static {
        int sDK_INT2 = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 29) {
            f0.a = new k0();
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                f0.a = new j0();
            } else {
                if (Build.VERSION.SDK_INT >= 22) {
                    f0.a = new i0();
                } else {
                    if (Build.VERSION.SDK_INT >= 21) {
                        f0.a = new h0();
                    } else {
                        f0.a = new g0();
                    }
                }
            }
        }
    }

    static void a(View view) {
        f0.a.a(view);
    }

    static e0 b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new d0(view);
        }
        return c0.e(view);
    }

    static float c(View view) {
        return f0.a.c(view);
    }

    static q0 d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new p0(view);
        }
        return new o0(view.getWindowToken());
    }

    static void e(View view) {
        f0.a.d(view);
    }

    static void f(View view, int i, int i2, int i3, int i4) {
        f0.a.e(view, i, i2, i3, i4);
    }

    static void g(View view, float f) {
        f0.a.f(view, f);
    }

    static void h(View view, int i) {
        f0.a.g(view, i);
    }

    static void i(View view, Matrix matrix) {
        f0.a.h(view, matrix);
    }

    static void j(View view, Matrix matrix) {
        f0.a.i(view, matrix);
    }
}
