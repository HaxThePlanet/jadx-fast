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

/* loaded from: classes.dex */
public class d0 {

    public static final d.h.l.d0 b;
    private final d.h.l.d0.l a;

    static class a {

        private static Field a;
        private static Field b;
        private static Field c;
        private static boolean d;
        static {
            Field declaredField;
            int i;
            String str;
            try {
                Field declaredField2 = View.class.getDeclaredField("mAttachInfo");
                d0.a.a = declaredField2;
                i = 1;
                declaredField2.setAccessible(i);
                Class forName = Class.forName("android.view.View$AttachInfo");
                Field declaredField3 = forName.getDeclaredField("mStableInsets");
                d0.a.b = declaredField3;
                declaredField3.setAccessible(i);
                declaredField = forName.getDeclaredField("mContentInsets");
                d0.a.c = declaredField;
                declaredField.setAccessible(i);
                d0.a.d = i;
                StringBuilder string = new StringBuilder();
                String str4 = "Failed to get visible insets from AttachInfo ";
                string.append(str4);
                str4 = th.getMessage();
                string.append(str4);
                string = string.toString();
                str4 = "WindowInsetsCompat";
                Log.w(str4, string, th);
            }
        }

        public static d.h.l.d0 a(View view) {
            boolean attachedToWindow;
            Object str;
            Field field;
            Throwable obj4;
            if (d0.a.d) {
                if (!view.isAttachedToWindow()) {
                } else {
                    attachedToWindow = d0.a.a.get(view.getRootView());
                    str = d0.a.b.get(attachedToWindow);
                    attachedToWindow = d0.a.c.get(attachedToWindow);
                    if (attachedToWindow != null && (Rect)str != null && (Rect)attachedToWindow != null) {
                        str = d0.a.b.get(attachedToWindow);
                        attachedToWindow = d0.a.c.get(attachedToWindow);
                        if ((Rect)(Rect)str != null) {
                            if ((Rect)(Rect)attachedToWindow != null) {
                                d0.b bVar3 = new d0.b();
                                bVar3.b(b.c((Rect)(Rect)str));
                                bVar3.c(b.c((Rect)(Rect)attachedToWindow));
                                d.h.l.d0 d0Var = bVar3.a();
                                d0Var.s(d0Var);
                                d0Var.d(view.getRootView());
                                return d0Var;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    public static final class b {

        private final d.h.l.d0.f a;
        public b() {
            d.h.l.d0.f dVar;
            int i;
            super();
            int sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 30) {
                dVar = new d0.e();
                this.a = dVar;
            } else {
                if (sDK_INT >= 29) {
                    dVar = new d0.d();
                    this.a = dVar;
                } else {
                    if (sDK_INT >= 20) {
                        dVar = new d0.c();
                        this.a = dVar;
                    } else {
                        dVar = new d0.f();
                        this.a = dVar;
                    }
                }
            }
        }

        public b(d.h.l.d0 d0) {
            d.h.l.d0.f dVar;
            int i;
            super();
            int sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 30) {
                dVar = new d0.e(d0);
                this.a = dVar;
            } else {
                if (sDK_INT >= 29) {
                    dVar = new d0.d(d0);
                    this.a = dVar;
                } else {
                    if (sDK_INT >= 20) {
                        dVar = new d0.c(d0);
                        this.a = dVar;
                    } else {
                        dVar = new d0.f(d0);
                        this.a = dVar;
                    }
                }
            }
        }

        public d.h.l.d0 a() {
            return this.a.b();
        }

        @Deprecated
        public d.h.l.d0.b b(b b) {
            this.a.d(b);
            return this;
        }

        @Deprecated
        public d.h.l.d0.b c(b b) {
            this.a.f(b);
            return this;
        }
    }

    private static class f {

        private final d.h.l.d0 a;
        b[] b;
        f() {
            d0 d0Var = new d0(0);
            super(d0Var);
        }

        f(d.h.l.d0 d0) {
            super();
            this.a = d0;
        }

        protected final void a() {
            b[] objArr;
            b bVar;
            int i3;
            b bVar2;
            int i;
            int i2;
            objArr = this.b;
            int i4 = 1;
            i = 2;
            if (objArr != null && this.b[d0.m.a(i)] == null) {
                i4 = 1;
                i = 2;
                if (this.b[d0.m.a(i)] == null) {
                    bVar2 = this.a.f(i);
                }
                if (objArr[d0.m.a(i4)] == null) {
                    bVar = this.a.f(i4);
                }
                f(b.a(bVar, bVar2));
                b bVar4 = this.b[d0.m.a(16)];
                if (bVar4 != null) {
                    e(bVar4);
                }
                b bVar5 = this.b[d0.m.a(32)];
                if (bVar5 != null) {
                    c(bVar5);
                }
                objArr = this.b[d0.m.a(64)];
                if (objArr != null) {
                    g(objArr);
                }
            }
        }

        d.h.l.d0 b() {
            a();
            return this.a;
        }

        void c(b b) {
        }

        void d(b b) {
        }

        void e(b b) {
        }

        void f(b b) {
        }

        void g(b b) {
        }
    }

    private static class l {

        static final d.h.l.d0 b;
        final d.h.l.d0 a;
        static {
            d0.b bVar = new d0.b();
            d0.l.b = bVar.a().a().b().c();
        }

        l(d.h.l.d0 d0) {
            super();
            this.a = d0;
        }

        d.h.l.d0 a() {
            return this.a;
        }

        d.h.l.d0 b() {
            return this.a;
        }

        d.h.l.d0 c() {
            return this.a;
        }

        void d(View view) {
        }

        void e(d.h.l.d0 d0) {
        }

        public boolean equals(Object object) {
            int i;
            boolean z;
            boolean z2;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof d0.l) {
                return i2;
            }
            if (o() == (d0.l)object.o() && n() == object.n() && c.a(k(), object.k()) && c.a(i(), object.i()) && c.a(f(), object.f())) {
                if (n() == object.n()) {
                    if (c.a(k(), object.k())) {
                        if (c.a(i(), object.i())) {
                            if (c.a(f(), object.f())) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        d.h.l.c f() {
            return null;
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

        d.h.l.d0 m(int i, int i2, int i3, int i4) {
            return d0.l.b;
        }

        boolean n() {
            return 0;
        }

        boolean o() {
            return 0;
        }

        public void p(b[] bArr) {
        }

        void q(b b) {
        }

        void r(d.h.l.d0 d0) {
        }

        public void s(b b) {
        }
    }

    public static final class m {
        static int a(int i) {
            int i2 = 1;
            int i8 = 2;
            int i3 = 4;
            int i9 = 8;
            if (i != i2 && i != i8 && i != i3 && i != i9 && i != 16 && i != 32 && i != 64 && i != 128) {
                i8 = 2;
                if (i != i8) {
                    i3 = 4;
                    if (i != i3) {
                        i9 = 8;
                        if (i != i9) {
                            if (i != 16) {
                                if (i != 32) {
                                    if (i != 64) {
                                        if (i != 128) {
                                            if (i != 256) {
                                            } else {
                                                return i9;
                                            }
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("type needs to be >= FIRST and <= LAST, type=");
                                            stringBuilder.append(i);
                                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                                            throw illegalArgumentException;
                                        }
                                        return 7;
                                    }
                                    return 6;
                                }
                                return 5;
                            }
                            return i3;
                        }
                        return 3;
                    }
                    return i8;
                }
                return i2;
            }
            return 0;
        }
    }

    private static final class n {
        static int a(int i) {
            int i2;
            int i3;
            int mandatorySystemGestures;
            final int i4 = 1;
            i2 = 0;
            i3 = i4;
            while (i3 <= 256) {
                if (i & i3 != 0) {
                }
                i3 <<= 1;
                if (i3 != i4) {
                } else {
                }
                mandatorySystemGestures = WindowInsets.Type.statusBars();
                i2 |= mandatorySystemGestures;
                if (i3 != 2) {
                } else {
                }
                mandatorySystemGestures = WindowInsets.Type.navigationBars();
                if (i3 != 4) {
                } else {
                }
                mandatorySystemGestures = WindowInsets.Type.captionBar();
                if (i3 != 8) {
                } else {
                }
                mandatorySystemGestures = WindowInsets.Type.ime();
                if (i3 != 16) {
                } else {
                }
                mandatorySystemGestures = WindowInsets.Type.systemGestures();
                if (i3 != 32) {
                } else {
                }
                mandatorySystemGestures = WindowInsets.Type.mandatorySystemGestures();
                if (i3 != 64) {
                } else {
                }
                mandatorySystemGestures = WindowInsets.Type.tappableElement();
                if (i3 != 128) {
                } else {
                }
                mandatorySystemGestures = WindowInsets.Type.displayCutout();
            }
            return i2;
        }
    }

    private static class c extends d.h.l.d0.f {

        private static Field e = null;
        private static boolean f = false;
        private static Constructor<WindowInsets> g = null;
        private static boolean h = false;
        private WindowInsets c;
        private b d;
        static {
        }

        c() {
            super();
            this.c = d0.c.h();
        }

        c(d.h.l.d0 d0) {
            super(d0);
            this.c = d0.u();
        }

        private static WindowInsets h() {
            Field declaredField;
            Object field;
            Constructor constructor;
            Constructor constructor2;
            int i;
            String str3;
            String str2;
            Class[] str;
            Class<Rect> obj;
            i = 1;
            final String str5 = "WindowInsetsCompat";
            if (!d0.c.f) {
                d0.c.e = WindowInsets.class.getDeclaredField("CONSUMED");
                d0.c.f = i;
            }
            field = d0.c.e;
            int i2 = 0;
            field = field.get(i2);
            if (field != null && (WindowInsets)field != null) {
                field = field.get(i2);
                if ((WindowInsets)(WindowInsets)field != null) {
                    WindowInsets windowInsets = new WindowInsets((WindowInsets)(WindowInsets)field);
                    return windowInsets;
                }
            }
            int i3 = 0;
            if (!d0.c.h) {
                str = new Class[i];
                str[i3] = Rect.class;
                d0.c.g = WindowInsets.class.getConstructor(str);
                d0.c.h = i;
            }
            constructor2 = d0.c.g;
            if (constructor2 != null) {
                Object[] arr = new Object[i];
                Rect rect = new Rect();
                arr[i3] = rect;
                return (WindowInsets)constructor2.newInstance(arr);
            }
            return i2;
        }

        @Override // d.h.l.d0$f
        d.h.l.d0 b() {
            a();
            d.h.l.d0 d0Var = d0.v(this.c);
            d0Var.q(this.b);
            d0Var.t(this.d);
            return d0Var;
        }

        @Override // d.h.l.d0$f
        void d(b b) {
            this.d = b;
        }

        @Override // d.h.l.d0$f
        void f(b b) {
            int i;
            int i3;
            int i2;
            Object obj5;
            final WindowInsets windowInsets = this.c;
            if (windowInsets != null) {
                this.c = windowInsets.replaceSystemWindowInsets(b.a, b.b, b.c, b.d);
            }
        }
    }

    private static class d extends d.h.l.d0.f {

        final WindowInsets.Builder c;
        d() {
            super();
            WindowInsets.Builder builder = new WindowInsets.Builder();
            this.c = builder;
        }

        d(d.h.l.d0 d0) {
            WindowInsets.Builder builder;
            super(d0);
            final WindowInsets obj2 = d0.u();
            if (obj2 != null) {
                builder = new WindowInsets.Builder(obj2);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.c = builder;
        }

        @Override // d.h.l.d0$f
        d.h.l.d0 b() {
            a();
            d.h.l.d0 d0Var = d0.v(this.c.build());
            d0Var.q(this.b);
            return d0Var;
        }

        @Override // d.h.l.d0$f
        void c(b b) {
            this.c.setMandatorySystemGestureInsets(b.e());
        }

        @Override // d.h.l.d0$f
        void d(b b) {
            this.c.setStableInsets(b.e());
        }

        @Override // d.h.l.d0$f
        void e(b b) {
            this.c.setSystemGestureInsets(b.e());
        }

        @Override // d.h.l.d0$f
        void f(b b) {
            this.c.setSystemWindowInsets(b.e());
        }

        @Override // d.h.l.d0$f
        void g(b b) {
            this.c.setTappableElementInsets(b.e());
        }
    }

    private static class g extends d.h.l.d0.l {

        private static boolean h = false;
        private static Method i;
        private static Class<?> j;
        private static Class<?> k;
        private static Field l;
        private static Field m;
        final WindowInsets c;
        private b[] d;
        private b e;
        private d.h.l.d0 f;
        b g;
        static {
        }

        g(d.h.l.d0 d0, WindowInsets windowInsets2) {
            super(d0);
            this.e = 0;
            this.c = windowInsets2;
        }

        g(d.h.l.d0 d0, d.h.l.d0.g d0$g2) {
            WindowInsets windowInsets = new WindowInsets(g2.c);
            super(d0, windowInsets);
        }

        private b t(int i, boolean z2) {
            b bVar;
            int i2;
            int i3;
            bVar = b.e;
            i2 = 1;
            while (i2 <= 256) {
                if (i & i2 == 0) {
                } else {
                }
                bVar = b.a(bVar, u(i2, z2));
                i2 <<= 1;
            }
            return bVar;
        }

        private b v() {
            d.h.l.d0 d0Var = this.f;
            if (d0Var != null) {
                return d0Var.h();
            }
            return b.e;
        }

        private b w(View view) {
            Method method;
            int i;
            Object message;
            Object obj5;
            if (Build.VERSION.SDK_INT >= 30) {
            } else {
                if (!d0.g.h) {
                    d0.g.x();
                }
                method = d0.g.i;
                i = 0;
                if (method != null && d0.g.k != null) {
                    if (d0.g.k != null) {
                        if (d0.g.l == null) {
                        } else {
                            obj5 = method.invoke(view, new Object[0]);
                            if (obj5 == null) {
                                NullPointerException nullPointerException = new NullPointerException();
                                Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", nullPointerException);
                                return i;
                            }
                            obj5 = d0.g.l.get(d0.g.m.get(obj5));
                            if ((Rect)obj5 != null) {
                                i = b.c((Rect)obj5);
                            }
                        }
                        return i;
                    }
                }
                return i;
            }
            obj5 = new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            throw obj5;
        }

        private static void x() {
            Field field;
            String str;
            Class[] arr;
            final int i = 1;
            d0.g.i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
            d0.g.j = Class.forName("android.view.ViewRootImpl");
            Class forName2 = Class.forName("android.view.View$AttachInfo");
            d0.g.k = forName2;
            d0.g.l = forName2.getDeclaredField("mVisibleInsets");
            d0.g.m = d0.g.j.getDeclaredField("mAttachInfo");
            d0.g.l.setAccessible(i);
            d0.g.m.setAccessible(i);
            d0.g.h = i;
        }

        @Override // d.h.l.d0$l
        void d(View view) {
            b obj1;
            if (w(view) == null) {
                obj1 = b.e;
            }
            q(obj1);
        }

        @Override // d.h.l.d0$l
        void e(d.h.l.d0 d0) {
            d0.s(this.f);
            d0.r(this.g);
        }

        @Override // d.h.l.d0$l
        public boolean equals(Object object) {
            if (!super.equals(object)) {
                return 0;
            }
            return Objects.equals(this.g, object.g);
        }

        @Override // d.h.l.d0$l
        public b g(int i) {
            return t(i, false);
        }

        @Override // d.h.l.d0$l
        final b k() {
            b bVar;
            int systemWindowInsetTop;
            int systemWindowInsetRight;
            int systemWindowInsetBottom;
            if (this.e == null) {
                this.e = b.b(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.e;
        }

        @Override // d.h.l.d0$l
        d.h.l.d0 m(int i, int i2, int i3, int i4) {
            d0.b bVar = new d0.b(d0.v(this.c));
            bVar.c(d0.n(k(), i, i2, i3, i4));
            bVar.b(d0.n(i(), i, i2, i3, i4));
            return bVar.a();
        }

        @Override // d.h.l.d0$l
        boolean o() {
            return this.c.isRound();
        }

        @Override // d.h.l.d0$l
        public void p(b[] bArr) {
            this.d = bArr;
        }

        @Override // d.h.l.d0$l
        void q(b b) {
            this.g = b;
        }

        @Override // d.h.l.d0$l
        void r(d.h.l.d0 d0) {
            this.f = d0;
        }

        @Override // d.h.l.d0$l
        protected b u(int i, boolean z2) {
            int i4;
            int i2;
            int i3;
            d.h.l.c obj5;
            int obj6;
            int i10 = 0;
            i3 = 0;
            obj6 = 8;
            if (i != 1 && i != 2 && i != obj6 && i != 16 && i != 32 && i != 64 && i != 128) {
                i3 = 0;
                if (i != 2) {
                    obj6 = 8;
                    if (i != obj6) {
                        if (i != 16) {
                            if (i != 32) {
                                if (i != 64) {
                                    if (i != 128) {
                                        return b.e;
                                    }
                                    obj5 = this.f;
                                    if (obj5 != null) {
                                        obj5 = obj5.e();
                                    } else {
                                        obj5 = f();
                                    }
                                    if (obj5 != null) {
                                        return b.b(obj5.b(), obj5.d(), obj5.c(), obj5.a());
                                    }
                                    return b.e;
                                }
                                return l();
                            }
                            return h();
                        }
                        return j();
                    }
                    obj5 = this.d;
                    if (obj5 != null) {
                        i3 = obj5[d0.m.a(obj6)];
                    }
                    if (i3 != 0) {
                        return i3;
                    }
                    obj6 = v();
                    obj5 = obj5.d;
                    if (obj5 > obj6.d) {
                        return b.b(i10, i10, i10, obj5);
                    }
                    obj5 = this.g;
                    obj5 = obj5.d;
                    if (obj5 != null && !obj5.equals(b.e) && obj5 > obj6.d) {
                        if (!obj5.equals(b.e)) {
                            obj5 = obj5.d;
                            if (obj5 > obj6.d) {
                                return b.b(i10, i10, i10, obj5);
                            }
                        }
                    }
                    return b.e;
                }
                if (z2) {
                    obj5 = v();
                    obj6 = i();
                    return b.b(Math.max(obj5.a, obj6.a), i10, Math.max(obj5.c, obj6.c), Math.max(obj5.d, obj6.d));
                }
                obj5 = k();
                obj6 = this.f;
                if (obj6 != null) {
                    i3 = obj6.h();
                }
                if (i3 != 0) {
                    obj6 = Math.min(obj5.d, i3.d);
                }
                return b.b(obj5.a, i10, obj5.c, obj6);
            }
            if (z2) {
                return b.b(i10, Math.max(obj5.b, obj6.b), i10, i10);
            }
            return b.b(i10, obj5.b, i10, i10);
        }
    }

    private static class e extends d.h.l.d0.d {
        e(d.h.l.d0 d0) {
            super(d0);
        }
    }

    private static class h extends d.h.l.d0.g {

        private b n;
        h(d.h.l.d0 d0, WindowInsets windowInsets2) {
            super(d0, windowInsets2);
            this.n = 0;
        }

        h(d.h.l.d0 d0, d.h.l.d0.h d0$h2) {
            super(d0, h2);
            this.n = 0;
            this.n = h2.n;
        }

        @Override // d.h.l.d0$g
        d.h.l.d0 b() {
            return d0.v(this.c.consumeStableInsets());
        }

        @Override // d.h.l.d0$g
        d.h.l.d0 c() {
            return d0.v(this.c.consumeSystemWindowInsets());
        }

        @Override // d.h.l.d0$g
        final b i() {
            b bVar;
            int stableInsetTop;
            int stableInsetRight;
            int stableInsetBottom;
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
        public void s(b b) {
            this.n = b;
        }
    }

    private static class i extends d.h.l.d0.h {
        i(d.h.l.d0 d0, WindowInsets windowInsets2) {
            super(d0, windowInsets2);
        }

        i(d.h.l.d0 d0, d.h.l.d0.i d0$i2) {
            super(d0, i2);
        }

        @Override // d.h.l.d0$h
        d.h.l.d0 a() {
            return d0.v(this.c.consumeDisplayCutout());
        }

        @Override // d.h.l.d0$h
        public boolean equals(Object object) {
            int i;
            boolean equals;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof d0.i) {
                return i2;
            }
            if (Objects.equals(this.c, object.c) && Objects.equals(this.g, object.g)) {
                if (Objects.equals(this.g, object.g)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        @Override // d.h.l.d0$h
        d.h.l.c f() {
            return c.e(this.c.getDisplayCutout());
        }

        @Override // d.h.l.d0$h
        public int hashCode() {
            return this.c.hashCode();
        }
    }

    private static class j extends d.h.l.d0.i {

        private b o = null;
        private b p = null;
        private b q = null;
        j(d.h.l.d0 d0, WindowInsets windowInsets2) {
            super(d0, windowInsets2);
            final int obj1 = 0;
        }

        j(d.h.l.d0 d0, d.h.l.d0.j d0$j2) {
            super(d0, j2);
            final int obj1 = 0;
        }

        @Override // d.h.l.d0$i
        b h() {
            b bVar;
            if (this.p == null) {
                this.p = b.d(this.c.getMandatorySystemGestureInsets());
            }
            return this.p;
        }

        @Override // d.h.l.d0$i
        b j() {
            b bVar;
            if (this.o == null) {
                this.o = b.d(this.c.getSystemGestureInsets());
            }
            return this.o;
        }

        @Override // d.h.l.d0$i
        b l() {
            b bVar;
            if (this.q == null) {
                this.q = b.d(this.c.getTappableElementInsets());
            }
            return this.q;
        }

        @Override // d.h.l.d0$i
        d.h.l.d0 m(int i, int i2, int i3, int i4) {
            return d0.v(this.c.inset(i, i2, i3, i4));
        }

        @Override // d.h.l.d0$i
        public void s(b b) {
        }
    }

    private static class k extends d.h.l.d0.j {

        static final d.h.l.d0 r;
        static {
            d0.k.r = d0.v(WindowInsets.CONSUMED);
        }

        k(d.h.l.d0 d0, WindowInsets windowInsets2) {
            super(d0, windowInsets2);
        }

        k(d.h.l.d0 d0, d.h.l.d0.k d0$k2) {
            super(d0, k2);
        }

        @Override // d.h.l.d0$j
        final void d(View view) {
        }

        @Override // d.h.l.d0$j
        public b g(int i) {
            return b.d(this.c.getInsets(d0.n.a(i)));
        }
    }
    static {
        d.h.l.d0 d0Var;
        if (Build.VERSION.SDK_INT >= 30) {
            d0.b = d0.k.r;
        } else {
            d0.b = d0.l.b;
        }
    }

    private d0(WindowInsets windowInsets) {
        d.h.l.d0.j sDK_INT;
        int i;
        Object obj3;
        super();
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 30) {
            sDK_INT = new d0.k(this, windowInsets);
            this.a = sDK_INT;
        } else {
            if (sDK_INT >= 29) {
                sDK_INT = new d0.j(this, windowInsets);
                this.a = sDK_INT;
            } else {
                if (sDK_INT >= 28) {
                    sDK_INT = new d0.i(this, windowInsets);
                    this.a = sDK_INT;
                } else {
                    if (sDK_INT >= 21) {
                        sDK_INT = new d0.h(this, windowInsets);
                        this.a = sDK_INT;
                    } else {
                        if (sDK_INT >= 20) {
                            sDK_INT = new d0.g(this, windowInsets);
                            this.a = sDK_INT;
                        } else {
                            obj3 = new d0.l(this);
                            this.a = obj3;
                        }
                    }
                }
            }
        }
    }

    public d0(d.h.l.d0 d0) {
        d.h.l.d0.l hVar;
        int sDK_INT;
        d.h.l.d0.l lVar;
        int i;
        int i2;
        int i3;
        int i4;
        d.h.l.d0.l obj3;
        super();
        if (d0 != null) {
            obj3 = d0.a;
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 30 && obj3 instanceof d0.k) {
                if (obj3 instanceof d0.k) {
                    hVar = new d0.k(this, (d0.k)obj3);
                    this.a = hVar;
                } else {
                    if (sDK_INT >= 29 && obj3 instanceof d0.j) {
                        if (obj3 instanceof d0.j) {
                            hVar = new d0.j(this, (d0.j)obj3);
                            this.a = hVar;
                        } else {
                            if (sDK_INT >= 28 && obj3 instanceof d0.i) {
                                if (obj3 instanceof d0.i) {
                                    hVar = new d0.i(this, (d0.i)obj3);
                                    this.a = hVar;
                                } else {
                                    if (sDK_INT >= 21 && obj3 instanceof d0.h) {
                                        if (obj3 instanceof d0.h) {
                                            hVar = new d0.h(this, (d0.h)obj3);
                                            this.a = hVar;
                                        } else {
                                            if (sDK_INT >= 20 && obj3 instanceof d0.g) {
                                                if (obj3 instanceof d0.g) {
                                                    hVar = new d0.g(this, (d0.g)obj3);
                                                    this.a = hVar;
                                                } else {
                                                    hVar = new d0.l(this);
                                                    this.a = hVar;
                                                }
                                            } else {
                                            }
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
            obj3.e(this);
        } else {
            obj3 = new d0.l(this);
            this.a = obj3;
        }
    }

    static b n(b b, int i2, int i3, int i4, int i5) {
        int i8 = 0;
        int i7 = Math.max(i8, i -= i2);
        int i12 = Math.max(i8, i10 -= i3);
        int i15 = Math.max(i8, i13 -= i4);
        int i9 = Math.max(i8, i16 -= i5);
        if (i7 == i2 && i12 == i3 && i15 == i4 && i9 == i5) {
            if (i12 == i3) {
                if (i15 == i4) {
                    if (i9 == i5) {
                        return b;
                    }
                }
            }
        }
        return b.b(i7, i12, i15, i9);
    }

    public static d.h.l.d0 v(WindowInsets windowInsets) {
        return d0.w(windowInsets, 0);
    }

    public static d.h.l.d0 w(WindowInsets windowInsets, View view2) {
        Object obj1;
        i.c(windowInsets);
        d0 d0Var = new d0((WindowInsets)windowInsets);
        if (view2 != null && view2.isAttachedToWindow()) {
            if (view2.isAttachedToWindow()) {
                d0Var.s(u.H(view2));
                d0Var.d(view2.getRootView());
            }
        }
        return d0Var;
    }

    @Deprecated
    public d.h.l.d0 a() {
        return this.a.a();
    }

    @Deprecated
    public d.h.l.d0 b() {
        return this.a.b();
    }

    @Deprecated
    public d.h.l.d0 c() {
        return this.a.c();
    }

    void d(View view) {
        this.a.d(view);
    }

    public d.h.l.c e() {
        return this.a.f();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof d0) {
            return 0;
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
        int i;
        d.h.l.d0.l lVar = this.a;
        if (lVar == null) {
            i = 0;
        } else {
            i = lVar.hashCode();
        }
        return i;
    }

    @Deprecated
    public int i() {
        return bVar.d;
    }

    @Deprecated
    public int j() {
        return bVar.a;
    }

    @Deprecated
    public int k() {
        return bVar.c;
    }

    @Deprecated
    public int l() {
        return bVar.b;
    }

    public d.h.l.d0 m(int i, int i2, int i3, int i4) {
        return this.a.m(i, i2, i3, i4);
    }

    public boolean o() {
        return this.a.n();
    }

    @Deprecated
    public d.h.l.d0 p(int i, int i2, int i3, int i4) {
        d0.b bVar = new d0.b(this);
        bVar.c(b.b(i, i2, i3, i4));
        return bVar.a();
    }

    void q(b[] bArr) {
        this.a.p(bArr);
    }

    void r(b b) {
        this.a.q(b);
    }

    void s(d.h.l.d0 d0) {
        this.a.r(d0);
    }

    void t(b b) {
        this.a.s(b);
    }

    public WindowInsets u() {
        WindowInsets windowInsets;
        d.h.l.d0.l lVar = this.a;
        windowInsets = lVar instanceof d0.g ? lVar.c : 0;
        return windowInsets;
    }
}
