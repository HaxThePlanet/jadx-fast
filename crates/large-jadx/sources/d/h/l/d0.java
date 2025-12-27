package d.h.l;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import android.view.WindowInsets.Type;
import d.h.f.b;
import d.h.k.c;
import d.h.k.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class d0 {

    public static final d0 b;
    private final d0.l a;

    static class a {

        private static Field a;
        private static Field b;
        private static Field c;
        private static boolean d;
        static {
            try {
                Field declaredField2 = View.class.getDeclaredField("mAttachInfo");
                d0.a.a = declaredField2;
                boolean z = true;
                declaredField2.setAccessible(z);
                Class cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField3 = cls.getDeclaredField("mStableInsets");
                d0.a.b = declaredField3;
                declaredField3.setAccessible(z);
                str = "mContentInsets";
                Field declaredField = cls.getDeclaredField(str);
                d0.a.c = declaredField;
                declaredField.setAccessible(z);
                d0.a.d = z;
            } catch (java.lang.ReflectiveOperationException reflectiveOperation) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Failed to get visible insets from AttachInfo ";
                str4 = reflectiveOperation.getMessage();
                stringBuilder = str4 + str4;
                str4 = "WindowInsetsCompat";
                Log.w(str4, stringBuilder, reflectiveOperation);
            }
        }

        public static d0 a(View view) {
            return null;
        }
    }

    public static final class b {

        private final d0.f a;
        public b() {
            super();
            int sDK_INT2 = Build.VERSION.SDK_INT;
            int i = 30;
            if (Build.VERSION.SDK_INT >= 30) {
                this.a = new d0.e();
            } else {
                i = 29;
                if (Build.VERSION.SDK_INT >= 29) {
                    this.a = new d0.d();
                } else {
                    i = 20;
                    if (Build.VERSION.SDK_INT >= 20) {
                        this.a = new d0.c();
                    } else {
                        this.a = new d0.f();
                    }
                }
            }
        }

        public d0 a() {
            return this.a.b();
        }

        @Deprecated
        public d0.b b(b bVar) {
            this.a.d(bVar);
            return this;
        }

        @Deprecated
        public d0.b c(b bVar) {
            this.a.f(bVar);
            return this;
        }

        public b() {
            super();
            int sDK_INT2 = Build.VERSION.SDK_INT;
            int i = 30;
            if (Build.VERSION.SDK_INT >= 30) {
                this.a = new d0.e(d0Var);
            } else {
                i = 29;
                if (Build.VERSION.SDK_INT >= 29) {
                    this.a = new d0.d(d0Var);
                } else {
                    i = 20;
                    if (Build.VERSION.SDK_INT >= 20) {
                        this.a = new d0.c(d0Var);
                    } else {
                        this.a = new d0.f(d0Var);
                    }
                }
            }
        }
    }

    private static class f {

        private final d0 a;
        b[] b;
        f() {
            this(new d0(null));
        }

        protected final void a() {
            b bVar;
            b bVar2;
            if (this.b != null) {
                int i4 = 1;
                int i2 = 2;
                if (this.b[d0.m.a(i2)] == null) {
                    bVar2 = this.a.f(i2);
                }
                if (objArr[d0.m.a(i4)] == null) {
                    bVar = this.a.f(i4);
                }
                f(b.a(bVar, bVar2));
                b bVar4 = this.b[d0.m.a(16)];
                if (this.b != null) {
                    e(bVar4);
                }
                b bVar5 = this.b[d0.m.a(32)];
                if (this.b != null) {
                    c(bVar5);
                }
                b bVar6 = this.b[d0.m.a(64)];
                if (this.b != null) {
                    g(bVar6);
                }
            }
        }

        d0 b() {
            a();
            return this.a;
        }

        f() {
            super();
            this.a = d0Var;
        }

        void c(b bVar) {
        }

        void d(b bVar) {
        }

        void e(b bVar) {
        }

        void f(b bVar) {
        }

        void g(b bVar) {
        }
    }

    private static class l {

        static final d0 b;
        final d0 a;
        static {
            d0.l.b = new d0.b().a().a().b().c();
        }

        l() {
            super();
            this.a = d0Var;
        }

        d0 a() {
            return this.a;
        }

        d0 b() {
            return this.a;
        }

        d0 c() {
            return this.a;
        }

        public boolean equals(Object object) {
            boolean z = true;
            boolean z2;
            boolean z3;
            boolean z4;
            z = true;
            if (this == object) {
                return true;
            }
            final int i = 0;
            if (!(object instanceof d0.l)) {
                return false;
            }
            if (o() == object.o()) {
                if (n() == object.n()) {
                    if (c.a(k(), object.k())) {
                        if (c.a(i(), object.i())) {
                            if (!(c.a(f(), object.f()))) {
                            }
                        }
                    }
                }
            }
            return z;
        }

        b g(int i) {
            return b.e;
        }

        b h() {
            return k();
        }

        public int hashCode() {
            Object[] arr = new Object[5];
            return c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        b i() {
            return b.e;
        }

        b j() {
            return k();
        }

        b k() {
            return b.e;
        }

        b l() {
            return k();
        }

        d0 m(int i, int i2, int i3, int i4) {
            return d0.l.b;
        }

        void d(View view) {
        }

        void e(d0 d0Var) {
        }

        c f() {
            return null;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(b[] bVarArr) {
        }

        void q(b bVar) {
        }

        void r(d0 d0Var) {
        }

        public void s(b bVar) {
        }
    }

    public static final class m {
        static int a(int i) {
            int i2 = 1;
            if (i != i2 && i != i8) {
                int i3 = 4;
                if (i != i3 && i != i9) {
                    if (i != 16 && i != 32) {
                        if (i != 64 && i != 128) {
                            if (i != 256) {
                                StringBuilder stringBuilder = new StringBuilder();
                                String str = "type needs to be >= FIRST and <= LAST, type=";
                                i = str + i;
                                throw new IllegalArgumentException(i);
                            } else {
                                return i9;
                            }
                        }
                        return 6;
                    }
                    return i3;
                }
                return i8;
            }
            return 0;
        }
    }

    private static final class n {
        static int a(int i) {
            int i3 = 0;
            int i2;
            int mandatorySystemGestures;
            i2 = 1;
            i3 = 0;
            while (i2 <= 256) {
                mandatorySystemGestures = i & i2;
                i2 = i2 << 1;
            }
            return i3;
        }
    }

    private static class c extends d0.f {

        private static Field e = null;
        private static boolean f = false;
        private static Constructor<WindowInsets> g = null;
        private static boolean h = false;
        private WindowInsets c;
        private b d;
        c() {
            super();
            this.c = d0.c.h();
        }

        private static WindowInsets h() throws java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.NoSuchFieldException, java.lang.IllegalAccessException {
            Field declaredField;
            Constructor constructor;
            String str;
            Class[] arr;
            boolean z3 = true;
            if (!d0.c.f) {
                try {
                    str = "CONSUMED";
                    d0.c.e = WindowInsets.class.getDeclaredField(str);
                } catch (java.lang.ReflectiveOperationException reflectiveOperation) {
                    Log.i(str3, "Could not get value from WindowInsets.CONSUMED field", reflectiveOperation);
                }
                d0.c.f = z3;
            }
            field = d0.c.e;
            Object obj5 = null;
            if (d0.c.e != null) {
                try {
                    Object obj3 = d0.c.e.get(obj5);
                } catch (java.lang.ReflectiveOperationException reflectiveOperation) {
                    Log.i(str3, "Could not get value from WindowInsets.CONSUMED field", reflectiveOperation);
                }
            }
            int i = 0;
            if (!d0.c.h) {
                try {
                    arr = new Class[z3];
                    obj = Rect.class;
                    arr[i] = obj;
                    d0.c.g = WindowInsets.class.getConstructor(arr);
                } catch (java.lang.ReflectiveOperationException reflectiveOperation) {
                    Log.i(str3, "Could not retrieve WindowInsets(Rect) constructor", reflectiveOperation);
                }
                d0.c.h = z3;
            }
            constructor2 = d0.c.g;
            if (d0.c.g != null) {
                try {
                    Object[] arr2 = new Object[z3];
                    arr2[i] = new Rect();
                } catch (java.lang.ReflectiveOperationException reflectiveOperation) {
                    Log.i(str3, "Could not invoke WindowInsets(Rect) constructor", reflectiveOperation);
                }
                return (WindowInsets)d0.c.g.newInstance(arr2);
            }
            return obj5;
        }

        @Override // d.h.l.d0$f
        d0 b() {
            a();
            d.h.l.d0 d0Var = d0.v(this.c);
            d0Var.q(this.b);
            d0Var.t(this.d);
            return d0Var;
        }

        @Override // d.h.l.d0$f
        void d(b bVar) {
            this.d = bVar;
        }

        @Override // d.h.l.d0$f
        void f(b bVar) {
            if (this.c != null) {
                this.c = this.c.replaceSystemWindowInsets(bVar.a, bVar.b, bVar.c, bVar.d);
            }
        }

        c() {
            super(d0Var);
            this.c = d0Var.u();
        }

    }

    private static class d extends d0.f {

        final WindowInsets.Builder c = new WindowInsets$Builder();
        d() {
            super();
            final WindowInsets.Builder builder = new WindowInsets.Builder();
        }

        @Override // d.h.l.d0$f
        d0 b() {
            a();
            d.h.l.d0 d0Var = d0.v(this.c.build());
            d0Var.q(this.b);
            return d0Var;
        }

        @Override // d.h.l.d0$f
        void c(b bVar) {
            this.c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // d.h.l.d0$f
        void d(b bVar) {
            this.c.setStableInsets(bVar.e());
        }

        @Override // d.h.l.d0$f
        void e(b bVar) {
            this.c.setSystemGestureInsets(bVar.e());
        }

        @Override // d.h.l.d0$f
        void f(b bVar) {
            this.c.setSystemWindowInsets(bVar.e());
        }

        @Override // d.h.l.d0$f
        void g(b bVar) {
            this.c.setTappableElementInsets(bVar.e());
        }

        d() {
            super(d0Var);
            final WindowInsets windowInsets = d0Var.u();
            if (windowInsets != null) {
                WindowInsets.Builder builder = new WindowInsets.Builder(windowInsets);
            }
            WindowInsets.Builder builder2 = new WindowInsets.Builder();
        }
    }

    private static class g extends d0.l {

        private static boolean h = false;
        private static Method i;
        private static Class<?> j;
        private static Class<?> k;
        private static Field l;
        private static Field m;
        final WindowInsets c;
        private b[] d;
        private b e;
        private d0 f;
        b g;
        g(WindowInsets windowInsets) {
            super(d0Var);
            this.e = null;
            this.c = windowInsets;
        }

        private b t(int i, boolean z) {
            b bVar;
            int i2 = 1;
            int i3;
            bVar = b.e;
            i2 = 1;
            while (i2 <= 256) {
                i3 = i & i2;
                i2 = i2 << 1;
            }
            return bVar;
        }

        private b v() {
            if (this.f != null) {
                return this.f.h();
            }
            return b.e;
        }

        private b w(View view) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            int i = 0;
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            } else {
                if (!d0.g.h) {
                    d0.g.x();
                }
                method = d0.g.i;
                i = 0;
                return null;
            }
        }

        private static void x() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException, java.lang.NoSuchFieldException {
            final boolean z = true;
            try {
                d0.g.i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                d0.g.j = Class.forName("android.view.ViewRootImpl");
                Class cls2 = Class.forName("android.view.View$AttachInfo");
                d0.g.k = cls2;
                d0.g.l = cls2.getDeclaredField("mVisibleInsets");
                str = "mAttachInfo";
                d0.g.m = d0.g.j.getDeclaredField(str);
                d0.g.l.setAccessible(z);
                d0.g.m.setAccessible(z);
            } catch (java.lang.ReflectiveOperationException reflectiveOperation) {
                StringBuilder stringBuilder = new StringBuilder();
                String str6 = "Failed to get visible insets. (Reflection error). ";
                str6 = reflectiveOperation.getMessage();
                stringBuilder = str6 + str6;
                str6 = "WindowInsetsCompat";
                Log.e(str6, stringBuilder, reflectiveOperation);
            }
            d0.g.h = z;
        }

        @Override // d.h.l.d0$l
        void d(View view) {
            b bVar;
            if (w(view) == null) {
                bVar = b.e;
            }
            q(bVar);
        }

        @Override // d.h.l.d0$l
        void e(d0 d0Var) {
            d0Var.s(this.f);
            d0Var.r(this.g);
        }

        @Override // d.h.l.d0$l
        public boolean equals(Object object) {
            if (!super.equals(object)) {
                return false;
            }
            return Objects.equals(this.g, object.g);
        }

        @Override // d.h.l.d0$l
        public b g(int i) {
            return t(i, false);
        }

        @Override // d.h.l.d0$l
        final b k() {
            if (this.e == null) {
                this.e = b.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // d.h.l.d0$l
        d0 m(int i, int i2, int i3, int i4) {
            final d.h.l.d0.b bVar = new d0.b(d0.v(this.c));
            bVar.c(d0.n(k(), i, i2, i3, i4));
            bVar.b(d0.n(i(), i, i2, i3, i4));
            return bVar.a();
        }

        @Override // d.h.l.d0$l
        boolean o() {
            return this.c.isRound();
        }

        @Override // d.h.l.d0$l
        public void p(b[] bVarArr) {
            this.d = bVarArr;
        }

        @Override // d.h.l.d0$l
        void q(b bVar) {
            this.g = bVar;
        }

        @Override // d.h.l.d0$l
        void r(d0 d0Var) {
            this.f = d0Var;
        }

        @Override // d.h.l.d0$l
        protected b u(int i, boolean z) {
            int i4 = 0;
            d.h.l.c cVar;
            int min;
            int i10 = 0;
            if (i != 1 && i != 2 && i != i5) {
                if (i != 16 && i != 32) {
                    if (i != 64 && i != 128) {
                        return b.e;
                    }
                    return l();
                }
                return j();
            }
            if (z) {
                return b.b(i10, Math.max(v().b, k().b), i10, i10);
            }
            return b.b(i10, k().b, i10, i10);
        }

        g(d0.g gVar) {
            this(d0Var, new WindowInsets(gVar.c));
        }

    }

    private static class e extends d0.d {
        e() {
            super();
        }

        e() {
            super(d0Var);
        }
    }

    private static class h extends d0.g {

        private b n = null;
        h(WindowInsets windowInsets) {
            super(d0Var, windowInsets);
        }

        @Override // d.h.l.d0$g
        d0 b() {
            return d0.v(this.c.consumeStableInsets());
        }

        @Override // d.h.l.d0$g
        d0 c() {
            return d0.v(this.c.consumeSystemWindowInsets());
        }

        @Override // d.h.l.d0$g
        final b i() {
            if (this.n == null) {
                this.n = b.b(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.n;
        }

        @Override // d.h.l.d0$g
        boolean n() {
            return this.c.isConsumed();
        }

        @Override // d.h.l.d0$g
        public void s(b bVar) {
            this.n = bVar;
        }

        h(d0.h hVar) {
            super(d0Var, hVar);
            this.n = hVar.n;
        }
    }

    private static class i extends d0.h {
        i(WindowInsets windowInsets) {
            super(d0Var, windowInsets);
        }

        @Override // d.h.l.d0$h
        d0 a() {
            return d0.v(this.c.consumeDisplayCutout());
        }

        @Override // d.h.l.d0$h
        public boolean equals(Object object) {
            boolean z = true;
            boolean equals;
            boolean equals2;
            z = true;
            if (this == object) {
                return true;
            }
            final int i = 0;
            if (!(object instanceof d0.i)) {
                return false;
            }
            if (Objects.equals(this.c, object.c)) {
                if (!(Objects.equals(this.g, object.g))) {
                }
            }
            return z;
        }

        @Override // d.h.l.d0$h
        c f() {
            return c.e(this.c.getDisplayCutout());
        }

        @Override // d.h.l.d0$h
        public int hashCode() {
            return this.c.hashCode();
        }

        i(d0.i iVar) {
            super(d0Var, iVar);
        }
    }

    private static class j extends d0.i {

        private b o = null;
        private b p = null;
        private b q = null;
        j(WindowInsets windowInsets) {
            super(d0Var, windowInsets);
        }

        @Override // d.h.l.d0$i
        b h() {
            if (this.p == null) {
                this.p = b.d(this.c.getMandatorySystemGestureInsets());
            }
            return this.p;
        }

        @Override // d.h.l.d0$i
        b j() {
            if (this.o == null) {
                this.o = b.d(this.c.getSystemGestureInsets());
            }
            return this.o;
        }

        @Override // d.h.l.d0$i
        b l() {
            if (this.q == null) {
                this.q = b.d(this.c.getTappableElementInsets());
            }
            return this.q;
        }

        @Override // d.h.l.d0$i
        d0 m(int i, int i2, int i3, int i4) {
            return d0.v(this.c.inset(i, i2, i3, i4));
        }

        j(d0.j jVar) {
            super(d0Var, jVar);
        }

        @Override // d.h.l.d0$i
        public void s(b bVar) {
        }
    }

    private static class k extends d0.j {

        static final d0 r;
        static {
            d0.k.r = d0.v(WindowInsets.CONSUMED);
        }

        k(WindowInsets windowInsets) {
            super(d0Var, windowInsets);
        }

        @Override // d.h.l.d0$j
        public b g(int i) {
            return b.d(this.c.getInsets(d0.n.a(i)));
        }

        k(d0.k kVar) {
            super(d0Var, kVar);
        }

        @Override // d.h.l.d0$j
        final void d(View view) {
        }
    }
    static {
        if (Build.VERSION.SDK_INT >= 30) {
            d0.b = d0.k.r;
        } else {
            d0.b = d0.l.b;
        }
    }

    private d0(WindowInsets windowInsets) {
        super();
        int sDK_INT2 = Build.VERSION.SDK_INT;
        int i = 30;
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new d0.k(this, windowInsets);
        } else {
            i = 29;
            if (Build.VERSION.SDK_INT >= 29) {
                this.a = new d0.j(this, windowInsets);
            } else {
                i = 28;
                if (Build.VERSION.SDK_INT >= 28) {
                    this.a = new d0.i(this, windowInsets);
                } else {
                    i = 21;
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.a = new d0.h(this, windowInsets);
                    } else {
                        i = 20;
                        if (Build.VERSION.SDK_INT >= 20) {
                            this.a = new d0.g(this, windowInsets);
                        } else {
                            this.a = new d0.l(this);
                        }
                    }
                }
            }
        }
    }

    static b n(b bVar, int i, int i2, int i3, int i4) {
        int i7 = 0;
        int max = Math.max(i7, bVar.a - i);
        int max3 = Math.max(i7, bVar.b - i2);
        int max4 = Math.max(i7, bVar.c - i3);
        int max2 = Math.max(i7, bVar.d - i4);
        if (max == i && max3 == i2 && max4 == i3 && max2 == i4) {
            return bVar;
        }
        return b.b(max, max3, max4, max2);
    }

    public static d0 v(WindowInsets windowInsets) {
        return d0.w(windowInsets, null);
    }

    public static d0 w(WindowInsets windowInsets, View view) {
        i.c(windowInsets);
        final d.h.l.d0 d0Var = new d0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            d0Var.s(u.H(view));
            d0Var.d(view.getRootView());
        }
        return d0Var;
    }

    @Deprecated
    public d0 a() {
        return this.a.a();
    }

    @Deprecated
    public d0 b() {
        return this.a.b();
    }

    @Deprecated
    public d0 c() {
        return this.a.c();
    }

    void d(View view) {
        this.a.d(view);
    }

    public c e() {
        return this.a.f();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof d0)) {
            return false;
        }
        return c.a(this.a, object.a);
    }

    public b f(int i) {
        return this.a.g(i);
    }

    @Deprecated
    public b g() {
        return this.a.h();
    }

    @Deprecated
    public b h() {
        return this.a.i();
    }

    public int hashCode() {
        int i = 0;
        if (this.a == null) {
            i = 0;
        } else {
            i = this.a.hashCode();
        }
        return i;
    }

    @Deprecated
    public int i() {
        return this.a.k().d;
    }

    @Deprecated
    public int j() {
        return this.a.k().a;
    }

    @Deprecated
    public int k() {
        return this.a.k().c;
    }

    @Deprecated
    public int l() {
        return this.a.k().b;
    }

    public d0 m(int i, int i2, int i3, int i4) {
        return this.a.m(i, i2, i3, i4);
    }

    public boolean o() {
        return this.a.n();
    }

    @Deprecated
    public d0 p(int i, int i2, int i3, int i4) {
        final d.h.l.d0.b bVar = new d0.b(this);
        bVar.c(b.b(i, i2, i3, i4));
        return bVar.a();
    }

    void q(b[] bVarArr) {
        this.a.p(bVarArr);
    }

    void r(b bVar) {
        this.a.q(bVar);
    }

    void s(d0 d0Var) {
        this.a.r(d0Var);
    }

    void t(b bVar) {
        this.a.s(bVar);
    }

    public WindowInsets u() {
        WindowInsets windowInsets = null;
        windowInsets = lVar instanceof d0.g ? lVar.c : 0;
        return windowInsets;
    }

    public d0(d0 d0Var) {
        d.h.l.d0.h hVar;
        d.h.l.d0.h d0Var2;
        super();
        if (d0Var != null) {
            sDK_INT2 = Build.VERSION.SDK_INT;
            int i = 30;
            if (Build.VERSION.SDK_INT >= 30) {
                if (lVar instanceof d0.k) {
                    this.a = new d0.k(this, (d0.k)lVar);
                } else {
                    int i2 = 29;
                    if (Build.VERSION.SDK_INT >= 29) {
                        if (lVar instanceof d0.j) {
                            this.a = new d0.j(this, (d0.j)lVar);
                        } else {
                            int i3 = 28;
                            if (Build.VERSION.SDK_INT >= 28) {
                                if (lVar instanceof d0.i) {
                                    this.a = new d0.i(this, (d0.i)lVar);
                                } else {
                                    int i4 = 21;
                                    if (Build.VERSION.SDK_INT >= 21) {
                                        if (lVar instanceof d0.h) {
                                            this.a = new d0.h(this, (d0.h)lVar);
                                        } else {
                                            if (Build.VERSION.SDK_INT >= 20) {
                                                if (lVar instanceof d0.g) {
                                                    this.a = new d0.g(this, (d0.g)lVar);
                                                } else {
                                                    this.a = new d0.l(this);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            d0Var.a.e(this);
        } else {
            this.a = new d0.l(this);
        }
    }
}
