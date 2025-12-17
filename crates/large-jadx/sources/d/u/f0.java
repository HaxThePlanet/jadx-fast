package d.u;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import d.h.l.u;

/* loaded from: classes.dex */
class f0 {

    private static final d.u.l0 a;
    static final Property<View, Float> b;

    static class a extends Property<View, Float> {
        a(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Float a(View view) {
            return Float.valueOf(f0.c(view));
        }

        @Override // android.util.Property
        public void b(View view, Float float2) {
            f0.g(view, float2.floatValue());
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((View)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((View)object, (Float)object2);
        }
    }

    static class b extends Property<View, Rect> {
        b(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Rect a(View view) {
            return u.u(view);
        }

        @Override // android.util.Property
        public void b(View view, Rect rect2) {
            u.r0(view, rect2);
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((View)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((View)object, (Rect)object2);
        }
    }
    static {
        d.u.l0 j0Var;
        int i;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 29) {
            j0Var = new k0();
            f0.a = j0Var;
        } else {
            if (sDK_INT >= 23) {
                j0Var = new j0();
                f0.a = j0Var;
            } else {
                if (sDK_INT >= 22) {
                    j0Var = new i0();
                    f0.a = j0Var;
                } else {
                    if (sDK_INT >= 21) {
                        j0Var = new h0();
                        f0.a = j0Var;
                    } else {
                        if (sDK_INT >= 19) {
                            j0Var = new g0();
                            f0.a = j0Var;
                        } else {
                            j0Var = new l0();
                            f0.a = j0Var;
                        }
                    }
                }
            }
        }
        f0.a aVar = new f0.a(Float.class, "translationAlpha");
        f0.b = aVar;
        f0.b bVar = new f0.b(Rect.class, "clipBounds");
    }

    static void a(View view) {
        f0.a.a(view);
    }

    static d.u.e0 b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            d0 d0Var = new d0(view);
            return d0Var;
        }
        return c0.e(view);
    }

    static float c(View view) {
        return f0.a.c(view);
    }

    static d.u.q0 d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            p0 p0Var = new p0(view);
            return p0Var;
        }
        o0 o0Var = new o0(view.getWindowToken());
        return o0Var;
    }

    static void e(View view) {
        f0.a.d(view);
    }

    static void f(View view, int i2, int i3, int i4, int i5) {
        f0.a.e(view, i2, i3, i4, i5);
    }

    static void g(View view, float f2) {
        f0.a.f(view, f2);
    }

    static void h(View view, int i2) {
        f0.a.g(view, i2);
    }

    static void i(View view, Matrix matrix2) {
        f0.a.h(view, matrix2);
    }

    static void j(View view, Matrix matrix2) {
        f0.a.i(view, matrix2);
    }
}
