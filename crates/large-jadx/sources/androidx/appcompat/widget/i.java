package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import d.a.a;
import d.a.c;
import d.a.e;
import d.a.k.a.a;
import d.h.f.a;

/* loaded from: classes.dex */
public final class i {

    private static final PorterDuff.Mode b;
    private static androidx.appcompat.widget.i c;
    private androidx.appcompat.widget.j0 a;

    class a implements androidx.appcompat.widget.j0.e {

        private final int[] a;
        private final int[] b;
        private final int[] c;
        private final int[] d;
        private final int[] e;
        private final int[] f;
        a() {
            super();
            final int i = 3;
            int[] iArr = new int[i];
            final int i18 = 0;
            iArr[i18] = e.S;
            final int i19 = 1;
            iArr[i19] = e.Q;
            final int i20 = 2;
            iArr[i20] = e.a;
            this.a = iArr;
            int i2 = 7;
            int[] iArr5 = new int[i2];
            iArr5[i18] = e.o;
            iArr5[i19] = e.B;
            iArr5[i20] = e.t;
            iArr5[i] = e.p;
            final int i38 = 4;
            iArr5[i38] = e.q;
            final int i39 = 5;
            iArr5[i39] = e.s;
            final int i40 = 6;
            iArr5[i40] = e.r;
            this.b = iArr5;
            int[] iArr6 = new int[10];
            iArr6[i18] = e.P;
            iArr6[i19] = e.R;
            iArr6[i20] = e.k;
            iArr6[i] = e.I;
            iArr6[i38] = e.J;
            iArr6[i39] = e.L;
            iArr6[i40] = e.N;
            iArr6[i2] = e.K;
            iArr6[8] = e.M;
            iArr6[9] = e.O;
            this.c = iArr6;
            int[] iArr2 = new int[i];
            iArr2[i18] = e.w;
            iArr2[i19] = e.i;
            iArr2[i20] = e.v;
            this.d = iArr2;
            int[] iArr3 = new int[i20];
            iArr3[i18] = e.H;
            iArr3[i19] = e.T;
            this.e = iArr3;
            int[] iArr4 = new int[i38];
            iArr4[i18] = e.c;
            iArr4[i19] = e.g;
            iArr4[i20] = e.d;
            iArr4[i] = e.h;
            this.f = iArr4;
        }

        private boolean f(int[] iArr, int i2) {
            int i;
            int i3;
            final int i4 = 0;
            i = i4;
            while (i < iArr.length) {
                i++;
            }
            return i4;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i2) {
            int i = 4;
            final int[][] iArr2 = new int[i];
            int[] iArr = new int[i];
            int i4 = o0.c(context, a.v);
            final int i9 = 0;
            iArr2[i9] = o0.b;
            iArr[i9] = o0.b(context, a.t);
            int i7 = 1;
            iArr2[i7] = o0.d;
            iArr[i7] = a.f(i4, i2);
            int i8 = 2;
            iArr2[i8] = o0.c;
            iArr[i8] = a.f(i4, i2);
            int i5 = 3;
            iArr2[i5] = o0.f;
            iArr[i5] = i2;
            ColorStateList obj6 = new ColorStateList(iArr2, iArr);
            return obj6;
        }

        private ColorStateList i(Context context) {
            return h(context, o0.c(context, a.s));
        }

        private ColorStateList j(Context context) {
            return h(context, o0.c(context, a.t));
        }

        private ColorStateList k(Context context) {
            int i;
            int[] list;
            boolean stateful;
            int obj9;
            int i2 = 3;
            final int[][] iArr2 = new int[i2];
            int[] iArr = new int[i2];
            i = a.y;
            list = o0.e(context, i);
            final int i6 = 2;
            final int i7 = 1;
            final int i8 = 0;
            if (list != null && list.isStateful()) {
                if (list.isStateful()) {
                    iArr2[i8] = o0.b;
                    iArr[i8] = list.getColorForState(iArr2[i8], i8);
                    iArr2[i7] = o0.e;
                    iArr[i7] = o0.c(context, a.u);
                    iArr2[i6] = o0.f;
                    iArr[i6] = list.getDefaultColor();
                } else {
                    iArr2[i8] = o0.b;
                    iArr[i8] = o0.b(context, i);
                    iArr2[i7] = o0.e;
                    iArr[i7] = o0.c(context, a.u);
                    iArr2[i6] = o0.f;
                    iArr[i6] = o0.c(context, i);
                }
            } else {
            }
            obj9 = new ColorStateList(iArr2, iArr);
            return obj9;
        }

        private void l(Drawable drawable, int i2, PorterDuff.Mode porterDuff$Mode3) {
            Drawable obj2;
            PorterDuff.Mode obj4;
            if (a0.a(drawable)) {
                obj2 = drawable.mutate();
            }
            if (mode3 == null) {
                obj4 = i.a();
            }
            obj2.setColorFilter(i.e(i2, obj4));
        }

        @Override // androidx.appcompat.widget.j0$e
        public boolean a(Context context, int i2, Drawable drawable3) {
            PorterDuff.Mode mULTIPLY;
            boolean z;
            int i3;
            int i;
            int obj8;
            Drawable obj9;
            mULTIPLY = i.a();
            i = 16842801;
            final int i4 = -1;
            final int i5 = 0;
            final int i6 = 1;
            if (f(this.a, i2)) {
                i = a.w;
                obj8 = i4;
                i3 = i6;
            } else {
            }
            if (i3 != 0 && a0.a(drawable3)) {
                if (a0.a(drawable3)) {
                    obj9 = drawable3.mutate();
                }
                obj9.setColorFilter(i.e(o0.c(context, i), mULTIPLY));
                if (obj8 != i4) {
                    obj9.setAlpha(obj8);
                }
                return i6;
            }
            return i5;
        }

        @Override // androidx.appcompat.widget.j0$e
        public PorterDuff.Mode b(int i) {
            PorterDuff.Mode obj2;
            obj2 = i == e.F ? PorterDuff.Mode.MULTIPLY : 0;
            return obj2;
        }

        @Override // androidx.appcompat.widget.j0$e
        public Drawable c(androidx.appcompat.widget.j0 j0, Context context2, int i3) {
            if (i3 == e.j) {
                Drawable[] arr = new Drawable[2];
                LayerDrawable obj6 = new LayerDrawable(arr);
                return obj6;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.j0$e
        public ColorStateList d(Context context, int i2) {
            int i;
            if (i2 == e.m) {
                return a.c(context, c.e);
            }
            if (i2 == e.G) {
                return a.c(context, c.h);
            }
            if (i2 == e.F) {
                return k(context);
            }
            if (i2 == e.f) {
                return j(context);
            }
            if (i2 == e.b) {
                return g(context);
            }
            if (i2 == e.e) {
                return i(context);
            }
            if (i2 != e.D) {
                if (i2 == e.E) {
                } else {
                    if (f(this.b, i2)) {
                        return o0.e(context, a.w);
                    }
                    if (f(this.e, i2)) {
                        return a.c(context, c.d);
                    }
                    if (f(this.f, i2)) {
                        return a.c(context, c.c);
                    }
                    if (i2 == e.A) {
                        return a.c(context, c.f);
                    }
                }
                return null;
            }
            return a.c(context, c.g);
        }

        @Override // androidx.appcompat.widget.j0$e
        public boolean e(Context context, int i2, Drawable drawable3) {
            int i;
            final int i9 = 1;
            final int i10 = 16908301;
            int i11 = 16908303;
            int i13 = 16908288;
            if (i2 == e.C) {
                int i7 = a.w;
                l((LayerDrawable)drawable3.findDrawableByLayerId(i13), o0.c(context, i7), i.a());
                l(drawable3.findDrawableByLayerId(i11), o0.c(context, i7), i.a());
                l(drawable3.findDrawableByLayerId(i10), o0.c(context, a.u), i.a());
                return i9;
            }
            if (i2 != e.y && i2 != e.x && i2 == e.z) {
                if (i2 != e.x) {
                    if (i2 == e.z) {
                    }
                    return 0;
                }
            }
            l((LayerDrawable)drawable3.findDrawableByLayerId(i13), o0.b(context, a.w), i.a());
            int i6 = a.u;
            l(drawable3.findDrawableByLayerId(i11), o0.c(context, i6), i.a());
            l(drawable3.findDrawableByLayerId(i10), o0.c(context, i6), i.a());
            return i9;
        }
    }
    static {
        i.b = PorterDuff.Mode.SRC_IN;
    }

    static PorterDuff.Mode a() {
        return i.b;
    }

    public static androidx.appcompat.widget.i b() {
        final Class<androidx.appcompat.widget.i> obj = i.class;
        synchronized (obj) {
            i.h();
            return i.c;
        }
    }

    public static PorterDuffColorFilter e(int i, PorterDuff.Mode porterDuff$Mode2) {
        final Class<androidx.appcompat.widget.i> obj = i.class;
        return j0.l(i, mode2);
        synchronized (obj) {
            obj = i.class;
            return j0.l(i, mode2);
        }
    }

    public static void h() {
        Object iVar;
        androidx.appcompat.widget.i.a aVar;
        final Class<androidx.appcompat.widget.i> obj = i.class;
        synchronized (obj) {
            i iVar2 = new i();
            i.c = iVar2;
            iVar2.a = j0.h();
            aVar = new i.a();
            iVar3.a.u(aVar);
        }
    }

    static void i(Drawable drawable, androidx.appcompat.widget.r0 r02, int[] i3Arr3) {
        j0.w(drawable, r02, i3Arr3);
    }

    public Drawable c(Context context, int i2) {
        return this.a.j(context, i2);
        synchronized (this) {
            return this.a.j(context, i2);
        }
    }

    Drawable d(Context context, int i2, boolean z3) {
        return this.a.k(context, i2, z3);
        synchronized (this) {
            return this.a.k(context, i2, z3);
        }
    }

    ColorStateList f(Context context, int i2) {
        return this.a.m(context, i2);
        synchronized (this) {
            return this.a.m(context, i2);
        }
    }

    public void g(Context context) {
        this.a.s(context);
        return;
        synchronized (this) {
            this.a.s(context);
        }
    }
}
