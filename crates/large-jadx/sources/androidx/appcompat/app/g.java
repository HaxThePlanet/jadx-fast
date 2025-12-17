package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.view.menu.m.a;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ContentFrameLayout.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.c0.a;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.t0;
import androidx.appcompat.widget.y;
import androidx.appcompat.widget.y0;
import androidx.appcompat.widget.z0;
import androidx.core.app.a;
import androidx.core.app.h;
import androidx.core.content.a;
import androidx.core.content.e.f.d;
import androidx.core.widget.j;
import androidx.lifecycle.j;
import androidx.lifecycle.j.c;
import androidx.lifecycle.q;
import d.a.a;
import d.a.c;
import d.a.f;
import d.a.g;
import d.a.i;
import d.a.j;
import d.a.k.a.a;
import d.a.o.b;
import d.a.o.b.a;
import d.a.o.d;
import d.a.o.e;
import d.a.o.f.a;
import d.a.o.g;
import d.a.o.i;
import d.e.g;
import d.h.k.c;
import d.h.l.b0;
import d.h.l.d0;
import d.h.l.f;
import d.h.l.g;
import d.h.l.q;
import d.h.l.u;
import d.h.l.z;
import java.lang.reflect.Constructor;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class g extends androidx.appcompat.app.f implements g.a, LayoutInflater.Factory2 {

    private static final g<String, Integer> s0;
    private static final boolean t0 = false;
    private static final int[] u0;
    private static final boolean v0;
    private static final boolean w0 = true;
    private static boolean x0;
    androidx.appcompat.app.a A;
    MenuInflater B;
    private java.lang.CharSequence C;
    private y D;
    private androidx.appcompat.app.g.i E;
    private androidx.appcompat.app.g.u F;
    b G;
    ActionBarContextView H;
    PopupWindow I;
    Runnable J;
    z K;
    private boolean L;
    private boolean M;
    ViewGroup N;
    private TextView O;
    private View P;
    private boolean Q;
    private boolean R;
    boolean S;
    boolean T;
    boolean U;
    boolean V;
    boolean W;
    private boolean X;
    private androidx.appcompat.app.g.t[] Y;
    private androidx.appcompat.app.g.t Z;
    private boolean a0;
    private boolean b0;
    private boolean c0;
    private boolean d0;
    boolean e0;
    private int f0;
    private int g0;
    private boolean h0;
    private boolean i0;
    private androidx.appcompat.app.g.m j0;
    private androidx.appcompat.app.g.m k0;
    boolean l0;
    int m0;
    private final Runnable n0;
    private boolean o0;
    private Rect p0;
    private Rect q0;
    private androidx.appcompat.app.j r0;
    final Object v;
    final Context w;
    Window x;
    private androidx.appcompat.app.g.k y;
    final androidx.appcompat.app.e z;

    class a implements java.lang.Thread.UncaughtExceptionHandler {

        final java.lang.Thread.UncaughtExceptionHandler a;
        a(java.lang.Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler) {
            this.a = uncaughtExceptionHandler;
            super();
        }

        private boolean a(Throwable throwable) {
            boolean contains;
            int i;
            String obj3;
            i = 0;
            obj3 = throwable.getMessage();
            if (throwable instanceof Resources.NotFoundException != null && obj3 != null) {
                obj3 = throwable.getMessage();
                if (obj3 != null) {
                    if (!obj3.contains("drawable")) {
                        if (obj3.contains("Drawable")) {
                            i = 1;
                        }
                    } else {
                    }
                }
            }
            return i;
        }

        @Override // java.lang.Thread$UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable throwable2) {
            Object notFoundException;
            Throwable cause;
            String str;
            Object obj5;
            if (a(throwable2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(throwable2.getMessage());
                stringBuilder.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException = new Resources.NotFoundException(stringBuilder.toString());
                notFoundException.initCause(throwable2.getCause());
                notFoundException.setStackTrace(throwable2.getStackTrace());
                this.a.uncaughtException(thread, notFoundException);
            } else {
                this.a.uncaughtException(thread, throwable2);
            }
        }
    }

    class b implements Runnable {

        final androidx.appcompat.app.g a;
        b(androidx.appcompat.app.g g) {
            this.a = g;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            androidx.appcompat.app.g gVar = this.a;
            final int i5 = 0;
            if (i2 &= 1 != 0) {
                gVar.Z(i5);
            }
            androidx.appcompat.app.g gVar2 = this.a;
            if (i4 &= 4096 != 0) {
                gVar2.Z(108);
            }
            androidx.appcompat.app.g gVar3 = this.a;
            gVar3.l0 = i5;
            gVar3.m0 = i5;
        }
    }

    class f implements Runnable {

        final androidx.appcompat.app.g a;
        f(androidx.appcompat.app.g g) {
            this.a = g;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            androidx.appcompat.app.g.f.a aVar;
            z i;
            androidx.appcompat.app.g gVar = this.a;
            final int i3 = 0;
            gVar.I.showAtLocation(gVar.H, 55, i3, i3);
            this.a.a0();
            aVar = 1065353216;
            if (this.a.I0()) {
                gVar4.H.setAlpha(0);
                androidx.appcompat.app.g gVar5 = this.a;
                i = u.d(gVar5.H);
                i.a(aVar);
                gVar5.K = i;
                aVar = new g.f.a(this);
                gVar6.K.g(aVar);
            } else {
                gVar7.H.setAlpha(aVar);
                gVar8.H.setVisibility(i3);
            }
        }
    }

    abstract class m {

        private BroadcastReceiver a;
        final androidx.appcompat.app.g b;
        m(androidx.appcompat.app.g g) {
            this.b = g;
            super();
        }

        void a() {
            BroadcastReceiver broadcastReceiver;
            Context context;
            broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                gVar.w.unregisterReceiver(broadcastReceiver);
                this.a = 0;
            }
        }

        abstract IntentFilter b();

        abstract int c();

        abstract void d();

        void e() {
            BroadcastReceiver aVar;
            Context countActions;
            BroadcastReceiver broadcastReceiver;
            a();
            final IntentFilter intent = b();
            if (intent != null) {
                if (intent.countActions() == 0) {
                } else {
                    if (this.a == null) {
                        aVar = new g.m.a(this);
                        this.a = aVar;
                    }
                    gVar.w.registerReceiver(this.a, intent);
                }
            }
        }
    }

    static class o {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            final int obj1 = configuration2.densityDpi;
            if (configuration.densityDpi != obj1) {
                configuration3.densityDpi = obj1;
            }
        }
    }

    static class p {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            boolean obj1;
            final LocaleList locales = configuration2.getLocales();
            if (!configuration.getLocales().equals(locales)) {
                configuration3.setLocales(locales);
                configuration3.locale = configuration2.locale;
            }
        }
    }

    static class q {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i;
            int colorMode;
            int obj3;
            int obj4;
            colorMode = configuration2.colorMode;
            if (colorMode2 &= 3 != colorMode & 3) {
                configuration3.colorMode = colorMode3 |= colorMode;
            }
            obj4 = configuration2.colorMode;
            if (obj3 &= 12 != obj4 & 12) {
                configuration3.colorMode = obj3 |= obj4;
            }
        }
    }

    private static class r {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration2) {
            contextThemeWrapper.applyOverrideConfiguration(configuration2);
        }
    }

    protected static final class t {

        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        g j;
        e k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;
        t(int i) {
            super();
            this.a = i;
            final int obj1 = 0;
        }

        n a(m.a m$a) {
            e eVar;
            Context context;
            int i;
            Object obj4;
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                e eVar2 = new e(this.l, g.j);
                this.k = eVar2;
                eVar2.h(a);
                this.j.b(this.k);
            }
            return this.k.b(this.g);
        }

        public boolean b() {
            int i;
            if (this.h == null) {
                return 0;
            }
            final int i2 = 1;
            if (this.i != null) {
                return i2;
            }
            if (this.k.a().getCount() > 0) {
                i = i2;
            }
            return i;
        }

        void c(g g) {
            Object gVar;
            e eVar;
            gVar = this.j;
            if (g == gVar) {
            }
            if (gVar != null) {
                gVar.Q(this.k);
            }
            this.j = g;
            gVar = this.k;
            if (g != null && gVar != null) {
                gVar = this.k;
                if (gVar != null) {
                    g.b(gVar);
                }
            }
        }

        void d(Context context) {
            int resourceId;
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getResources().newTheme();
            theme.setTo(context.getTheme());
            final int i6 = 1;
            theme.resolveAttribute(a.a, typedValue, i6);
            int resourceId4 = typedValue.resourceId;
            if (resourceId4 != 0) {
                theme.applyStyle(resourceId4, i6);
            }
            theme.resolveAttribute(a.F, typedValue, i6);
            resourceId = typedValue.resourceId;
            if (resourceId != 0) {
                theme.applyStyle(resourceId, i6);
            } else {
                theme.applyStyle(i.b, i6);
            }
            int i5 = 0;
            d dVar = new d(context, i5);
            dVar.getTheme().setTo(theme);
            this.l = dVar;
            TypedArray obj5 = dVar.obtainStyledAttributes(j.u0);
            this.b = obj5.getResourceId(j.x0, i5);
            this.f = obj5.getResourceId(j.w0, i5);
            obj5.recycle();
        }
    }

    class c implements q {

        final androidx.appcompat.app.g a;
        c(androidx.appcompat.app.g g) {
            this.a = g;
            super();
        }

        @Override // d.h.l.q
        public d0 a(View view, d0 d02) {
            int i3;
            int i2;
            int i;
            d0 obj6;
            int i4 = this.a.P0(d02, 0);
            if (d02.l() != i4) {
                obj6 = d02.p(d02.j(), i4, d02.k(), d02.i());
            }
            return u.Y(view, obj6);
        }
    }

    class d implements c0.a {

        final androidx.appcompat.app.g a;
        d(androidx.appcompat.app.g g) {
            this.a = g;
            super();
        }

        @Override // androidx.appcompat.widget.c0$a
        public void a(Rect rect) {
            rect.top = this.a.P0(0, rect);
        }
    }

    class e implements ContentFrameLayout.a {

        final androidx.appcompat.app.g a;
        e(androidx.appcompat.app.g g) {
            this.a = g;
            super();
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout$a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout$a
        public void onDetachedFromWindow() {
            this.a.X();
        }
    }

    private class h implements androidx.appcompat.app.b {
        h(androidx.appcompat.app.g g) {
            super();
        }
    }

    private final class i implements m.a {

        final androidx.appcompat.app.g a;
        i(androidx.appcompat.app.g g) {
            this.a = g;
            super();
        }

        @Override // androidx.appcompat.view.menu.m$a
        public void c(g g, boolean z2) {
            this.a.Q(g);
        }

        @Override // androidx.appcompat.view.menu.m$a
        public boolean d(g g) {
            int i;
            Window.Callback callback = this.a.k0();
            if (callback != null) {
                callback.onMenuOpened(108, g);
            }
            return 1;
        }
    }

    class j implements b.a {

        private b.a a;
        final androidx.appcompat.app.g b;
        public j(androidx.appcompat.app.g g, b.a b$a2) {
            this.b = g;
            super();
            this.a = a2;
        }

        @Override // d.a.o.b$a
        public void a(b b) {
            Object popupWindow;
            Object aVar;
            int i;
            Object obj3;
            this.a.a(b);
            obj3 = this.b;
            if (obj3.I != null) {
                obj3.x.getDecorView().removeCallbacks(gVar.J);
            }
            obj3 = this.b;
            if (obj3.H != null) {
                obj3.a0();
                obj3 = this.b;
                z zVar = u.d(obj3.H);
                zVar.a(0);
                obj3.K = zVar;
                aVar = new g.j.a(this);
                obj3.K.g(aVar);
            }
            obj3 = this.b;
            androidx.appcompat.app.e eVar = obj3.z;
            if (eVar != null) {
                eVar.onSupportActionModeFinished(obj3.G);
            }
            obj3 = this.b;
            obj3.G = 0;
            u.i0(obj3.N);
        }

        @Override // d.a.o.b$a
        public boolean b(b b, Menu menu2) {
            return this.a.b(b, menu2);
        }

        @Override // d.a.o.b$a
        public boolean c(b b, Menu menu2) {
            u.i0(gVar.N);
            return this.a.c(b, menu2);
        }

        @Override // d.a.o.b$a
        public boolean d(b b, MenuItem menuItem2) {
            return this.a.d(b, menuItem2);
        }
    }

    class k extends i {

        final androidx.appcompat.app.g b;
        k(androidx.appcompat.app.g g, Window.Callback window$Callback2) {
            this.b = g;
            super(callback2);
        }

        @Override // d.a.o.i
        final ActionMode b(ActionMode.Callback actionMode$Callback) {
            f.a aVar = new f.a(gVar.w, callback);
            b obj3 = this.b.J(aVar);
            if (obj3 != null) {
                return aVar.e(obj3);
            }
            return null;
        }

        @Override // d.a.o.i
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            int obj2;
            if (!this.b.Y(keyEvent)) {
                if (super.dispatchKeyEvent(keyEvent)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }

        @Override // d.a.o.i
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            androidx.appcompat.app.g dispatchKeyShortcutEvent;
            int keyCode;
            int obj3;
            if (!super.dispatchKeyShortcutEvent(keyEvent)) {
                if (this.b.w0(keyEvent.getKeyCode(), keyEvent)) {
                    obj3 = 1;
                } else {
                    obj3 = 0;
                }
            } else {
            }
            return obj3;
        }

        @Override // d.a.o.i
        public void onContentChanged() {
        }

        @Override // d.a.o.i
        public boolean onCreatePanelMenu(int i, Menu menu2) {
            boolean z;
            if (i == 0 && !menu2 instanceof g) {
                if (!menu2 instanceof g) {
                    return 0;
                }
            }
            return super.onCreatePanelMenu(i, menu2);
        }

        @Override // d.a.o.i
        public boolean onMenuOpened(int i, Menu menu2) {
            super.onMenuOpened(i, menu2);
            this.b.z0(i);
            return 1;
        }

        @Override // d.a.o.i
        public void onPanelClosed(int i, Menu menu2) {
            super.onPanelClosed(i, menu2);
            this.b.A0(i);
        }

        @Override // d.a.o.i
        public boolean onPreparePanel(int i, View view2, Menu menu3) {
            int i2;
            int i3;
            if (menu3 instanceof g) {
                i2 = menu3;
            } else {
                i2 = 0;
            }
            final int i4 = 0;
            if (i == 0 && i2 == 0) {
                if (i2 == 0) {
                    return i4;
                }
            }
            if (i2 != 0) {
                i2.e0(true);
            }
            if (i2 != 0) {
                i2.e0(i4);
            }
            return super.onPreparePanel(i, view2, menu3);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu2, int i3) {
            Object tVar;
            tVar = this.b.i0(0, true);
            tVar = tVar.j;
            if (tVar != null && tVar != null) {
                tVar = tVar.j;
                if (tVar != null) {
                    super.onProvideKeyboardShortcuts(list, tVar, i3);
                } else {
                    super.onProvideKeyboardShortcuts(list, menu2, i3);
                }
            } else {
            }
        }

        @Override // d.a.o.i
        public ActionMode onWindowStartingActionMode(ActionMode.Callback actionMode$Callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (this.b.r0()) {
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        @Override // d.a.o.i
        public ActionMode onWindowStartingActionMode(ActionMode.Callback actionMode$Callback, int i2) {
            if (this.b.r0() && i2 != 0) {
                if (i2 != 0) {
                }
                return b(callback);
            }
            return super.onWindowStartingActionMode(callback, i2);
        }
    }

    private class l extends androidx.appcompat.app.g.m {

        private final PowerManager c;
        final androidx.appcompat.app.g d;
        l(androidx.appcompat.app.g g, Context context2) {
            this.d = g;
            super(g);
            this.c = (PowerManager)context2.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.g$m
        IntentFilter b() {
            if (Build.VERSION.SDK_INT >= 21) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            }
            return null;
        }

        @Override // androidx.appcompat.app.g$m
        public int c() {
            int powerSaveMode;
            int i;
            i = 1;
            if (Build.VERSION.SDK_INT >= 21 && this.c.isPowerSaveMode()) {
                if (this.c.isPowerSaveMode()) {
                    i = 2;
                }
            }
            return i;
        }

        @Override // androidx.appcompat.app.g$m
        public void d() {
            this.d.K();
        }
    }

    private class n extends androidx.appcompat.app.g.m {

        private final androidx.appcompat.app.n c;
        final androidx.appcompat.app.g d;
        n(androidx.appcompat.app.g g, androidx.appcompat.app.n n2) {
            this.d = g;
            super(g);
            this.c = n2;
        }

        @Override // androidx.appcompat.app.g$m
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.g$m
        public int c() {
            int i;
            i = this.c.d() ? 2 : 1;
            return i;
        }

        @Override // androidx.appcompat.app.g$m
        public void d() {
            this.d.K();
        }
    }

    private class s extends ContentFrameLayout {

        final androidx.appcompat.app.g A;
        public s(androidx.appcompat.app.g g, Context context2) {
            this.A = g;
            super(context2);
        }

        private boolean c(int i, int i2) {
            int i3;
            int obj2;
            i3 = -5;
            if (i >= i3 && i2 >= i3 && i <= width += 5) {
                if (i2 >= i3) {
                    if (i <= width += 5) {
                        if (i2 > obj2 += 5) {
                            obj2 = 1;
                        } else {
                            obj2 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            int obj2;
            if (!this.A.Y(keyEvent)) {
                if (super.dispatchKeyEvent(keyEvent)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            int action;
            int i;
            if (motionEvent.getAction() == 0 && c((int)f, (int)f2)) {
                if (c((int)f, (int)f2)) {
                    this.A.S(0);
                    return 1;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(a.d(getContext(), i));
        }
    }

    private final class u implements m.a {

        final androidx.appcompat.app.g a;
        u(androidx.appcompat.app.g g) {
            this.a = g;
            super();
        }

        @Override // androidx.appcompat.view.menu.m$a
        public void c(g g, boolean z2) {
            Object gVar;
            int i;
            g obj5;
            boolean obj6;
            gVar = g.F();
            final int i2 = 1;
            i = gVar != g ? i2 : 0;
            if (i != 0) {
                obj5 = gVar;
            }
            obj5 = this.a.d0(obj5);
            if (obj5 != null) {
                if (i != 0) {
                    this.a.P(obj5.a, obj5, gVar);
                    this.a.T(obj5, i2);
                } else {
                    this.a.T(obj5, z2);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m$a
        public boolean d(g g) {
            Object gVar;
            boolean z;
            gVar = this.a;
            gVar = gVar.k0();
            if (g == g.F() && gVar.S && gVar != null && !gVar2.e0) {
                gVar = this.a;
                if (gVar.S) {
                    gVar = gVar.k0();
                    if (gVar != null) {
                        if (!gVar2.e0) {
                            gVar.onMenuOpened(108, g);
                        }
                    }
                }
            }
            return 1;
        }
    }

    class g extends b0 {

        final androidx.appcompat.app.g a;
        g(androidx.appcompat.app.g g) {
            this.a = g;
            super();
        }

        @Override // d.h.l.b0
        public void b(View view) {
            obj2.H.setAlpha(1065353216);
            int i2 = 0;
            obj2.K.g(i2);
            obj2.K = i2;
        }

        @Override // d.h.l.b0
        public void c(View view) {
            boolean obj2;
            obj2.H.setVisibility(0);
            obj2.H.sendAccessibilityEvent(32);
            if (obj2 instanceof View != null) {
                u.i0((View)obj2.H.getParent());
            }
        }
    }
    static {
        int defaultUncaughtExceptionHandler;
        int aVar;
        g gVar = new g();
        g.s0 = gVar;
        defaultUncaughtExceptionHandler = Build.VERSION.SDK_INT;
        int i = 0;
        final int i2 = 1;
        if (defaultUncaughtExceptionHandler < 21) {
            int i4 = i2;
        }
        int[] iArr = new int[i2];
        iArr[i] = 16842836;
        g.u0 = iArr;
        g.v0 = equals ^= i2;
        aVar = i2;
        if (i != 0 && !g.x0) {
            if (!g.x0) {
                aVar = new g.a(Thread.getDefaultUncaughtExceptionHandler());
                Thread.setDefaultUncaughtExceptionHandler(aVar);
                g.x0 = i2;
            }
        }
    }

    g(Activity activity, androidx.appcompat.app.e e2) {
        super(activity, 0, e2, activity);
    }

    g(Dialog dialog, androidx.appcompat.app.e e2) {
        super(dialog.getContext(), dialog.getWindow(), e2, dialog);
    }

    private g(Context context, Window window2, androidx.appcompat.app.e e3, Object object4) {
        boolean obj3;
        Object obj5;
        super();
        this.K = 0;
        this.L = true;
        int i3 = -100;
        this.f0 = i3;
        g.b bVar = new g.b(this);
        this.n0 = bVar;
        this.w = context;
        this.z = e3;
        this.v = object4;
        obj3 = M0();
        if (object4 instanceof Dialog && obj3 != null) {
            obj3 = M0();
            if (obj3 != null) {
                this.f0 = obj3.getDelegate().l();
            }
        }
        obj3 = g.s0;
        obj5 = obj3.get(object4.getClass().getName());
        if (this.f0 == i3 && (Integer)obj5 != null) {
            obj3 = g.s0;
            obj5 = obj3.get(object4.getClass().getName());
            if ((Integer)(Integer)obj5 != null) {
                this.f0 = (Integer)(Integer)obj5.intValue();
                obj3.remove(object4.getClass().getName());
            }
        }
        if (window2 != null) {
            N(window2);
        }
        i.h();
    }

    private void C0(androidx.appcompat.app.g.t g$t, KeyEvent keyEvent2) {
        boolean systemService;
        int i;
        Window.Callback onMenuOpened;
        int i6;
        int i3;
        int i4;
        int i5;
        boolean z2;
        boolean z;
        int i2;
        KeyEvent obj15;
        if (!t.o) {
            if (this.e0) {
            } else {
                i6 = 0;
                i3 = 1;
                if (t.a == 0) {
                    i = screenLayout &= 15 == 4 ? i3 : i6;
                    if (i != 0) {
                    }
                }
                onMenuOpened = k0();
                if (onMenuOpened != null && !onMenuOpened.onMenuOpened(t.a, t.j)) {
                    if (!onMenuOpened.onMenuOpened(t.a, t.j)) {
                        T(t, i3);
                    }
                }
                systemService = this.w.getSystemService("window");
                if ((WindowManager)systemService == null) {
                }
                if (!F0(t, keyEvent2)) {
                }
                obj15 = t.g;
                i4 = -1;
                i5 = -2;
                if (obj15 != null) {
                    if (t.q) {
                        if (obj15 == null && n0(t) && t.g == null) {
                            if (n0(t)) {
                                if (t.g == null) {
                                }
                                if (m0(t)) {
                                    if (!t.b()) {
                                    } else {
                                        if (t.h.getLayoutParams() == null) {
                                            obj15 = new ViewGroup.LayoutParams(i5, i5);
                                        }
                                        t.g.setBackgroundResource(t.b);
                                        ViewParent parent = t.h.getParent();
                                        if (parent instanceof ViewGroup) {
                                            (ViewGroup)parent.removeView(t.h);
                                        }
                                        t.g.addView(t.h, obj15);
                                        if (!t.h.hasFocus()) {
                                            t.h.requestFocus();
                                        }
                                        i2 = i5;
                                    }
                                }
                            }
                        }
                        if (t.q && obj15.getChildCount() > 0) {
                            if (obj15.getChildCount() > 0) {
                                t.g.removeAllViews();
                            }
                        }
                    } else {
                        obj15 = t.i;
                        obj15 = obj15.getLayoutParams();
                        if (obj15 != null && obj15 != null && obj15.width == i4) {
                            obj15 = obj15.getLayoutParams();
                            if (obj15 != null) {
                                if (obj15.width == i4) {
                                    i2 = i4;
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                    t.n = i6;
                    super(i2, -2, t.d, t.e, 1002, 8519680, -3);
                    obj15.gravity = t.c;
                    obj15.windowAnimations = t.f;
                    (WindowManager)systemService.addView(t.g, obj15);
                    t.o = i3;
                } else {
                }
                t.q = i3;
            }
        }
    }

    private boolean E0(androidx.appcompat.app.g.t g$t, int i2, KeyEvent keyEvent3, int i4) {
        boolean z;
        int shortcut;
        int obj4;
        KeyEvent obj5;
        if (keyEvent3.isSystem()) {
            return 0;
        }
        if (!t.m) {
            z = t.j;
            if (F0(t, keyEvent3) && z != null) {
                z = t.j;
                if (z != null) {
                    shortcut = z.performShortcut(i2, keyEvent3, i4);
                }
            }
        } else {
        }
        if (shortcut != 0 && i4 & 1 == 0 && this.D == null) {
            if (i4 & 1 == 0) {
                if (this.D == null) {
                    T(t, true);
                }
            }
        }
        return shortcut;
    }

    private boolean F0(androidx.appcompat.app.g.t g$t, KeyEvent keyEvent2) {
        boolean onPreparePanel;
        Object callback;
        View onCreatePanelView;
        int i;
        int i2;
        View view;
        boolean onCreatePanelMenu;
        int i3;
        boolean z;
        androidx.appcompat.app.g.i iVar;
        androidx.appcompat.app.g.i iVar2;
        Object obj9;
        Object obj10;
        final int i4 = 0;
        if (this.e0) {
            return i4;
        }
        final int i5 = 1;
        if (t.m) {
            return i5;
        }
        androidx.appcompat.app.g.t tVar = this.Z;
        if (tVar != null && tVar != t) {
            if (tVar != t) {
                T(tVar, i4);
            }
        }
        callback = k0();
        if (callback != null) {
            t.i = callback.onCreatePanelView(t.a);
        }
        int i6 = t.a;
        if (i6 != 0) {
            if (i6 == 108) {
                i = i5;
            } else {
                i = i4;
            }
        } else {
        }
        i2 = this.D;
        if (i != 0 && i2 != null) {
            i2 = this.D;
            if (i2 != null) {
                i2.c();
            }
        }
        if (t.i == null) {
            if (i != 0) {
                if (!aVar instanceof l) {
                    onCreatePanelMenu = t.j;
                    i3 = 0;
                    if (onCreatePanelMenu != null) {
                        if (t.r && onCreatePanelMenu == null && o0(t) && t.j == null) {
                            if (onCreatePanelMenu == null) {
                                if (o0(t)) {
                                    if (t.j == null) {
                                    }
                                }
                                return i4;
                            }
                            onCreatePanelMenu = this.D;
                            if (i != 0 && onCreatePanelMenu != null && this.E == null) {
                                onCreatePanelMenu = this.D;
                                if (onCreatePanelMenu != null) {
                                    if (this.E == null) {
                                        iVar = new g.i(this);
                                        this.E = iVar;
                                    }
                                    onCreatePanelMenu.a(t.j, this.E);
                                }
                            }
                            t.j.h0();
                            t.c(i3);
                            obj9 = this.D;
                            if (!callback.onCreatePanelMenu(t.a, t.j) && i != 0 && obj9 != null) {
                                t.c(i3);
                                if (i != 0) {
                                    obj9 = this.D;
                                    if (obj9 != null) {
                                        obj9.a(i3, this.E);
                                    }
                                }
                                return i4;
                            }
                            t.r = i4;
                        }
                    } else {
                    }
                    t.j.h0();
                    Bundle bundle = t.s;
                    if (bundle != null) {
                        t.j.R(bundle);
                        t.s = i3;
                    }
                    obj10 = this.D;
                    if (!callback.onPreparePanel(i4, t.i, t.j) && i != 0 && obj10 != null) {
                        if (i != 0) {
                            obj10 = this.D;
                            if (obj10 != null) {
                                obj10.a(i3, this.E);
                            }
                        }
                        t.j.g0();
                        return i4;
                    }
                    if (keyEvent2 != null) {
                        obj10 = keyEvent2.getDeviceId();
                    } else {
                        obj10 = -1;
                    }
                    obj10 = KeyCharacterMap.load(obj10).getKeyboardType() != i5 ? i5 : i4;
                    t.p = obj10;
                    t.j.setQwertyMode(obj10);
                    t.j.g0();
                }
            } else {
            }
        }
        t.m = i5;
        t.n = i4;
        this.Z = t;
        return i5;
    }

    private void G0(boolean z) {
        boolean permanentMenuKey;
        int onPreparePanel;
        boolean z2;
        boolean obj6;
        permanentMenuKey = this.D;
        onPreparePanel = 1;
        final int i2 = 0;
        if (permanentMenuKey != null && permanentMenuKey.d()) {
            if (permanentMenuKey.d()) {
                if (ViewConfiguration.get(this.w).hasPermanentMenuKey()) {
                    if (this.D.e()) {
                        Window.Callback callback = k0();
                        final int i3 = 108;
                        if (this.D.b()) {
                            if (!z) {
                                if (callback != null && !this.e0 && this.l0 && obj6 &= onPreparePanel != 0) {
                                    if (!this.e0) {
                                        if (this.l0) {
                                            if (obj6 &= onPreparePanel != 0) {
                                                this.x.getDecorView().removeCallbacks(this.n0);
                                                this.n0.run();
                                            }
                                        }
                                        obj6 = i0(i2, onPreparePanel);
                                        onPreparePanel = obj6.j;
                                        if (onPreparePanel != null && !obj6.r && callback.onPreparePanel(i2, obj6.i, onPreparePanel)) {
                                            if (!obj6.r) {
                                                if (callback.onPreparePanel(i2, obj6.i, onPreparePanel)) {
                                                    callback.onMenuOpened(i3, obj6.j);
                                                    this.D.g();
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                this.D.f();
                                if (!this.e0) {
                                    callback.onPanelClosed(i3, obj6.j);
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        }
        obj6 = i0(i2, onPreparePanel);
        obj6.q = onPreparePanel;
        T(obj6, i2);
        C0(obj6, 0);
    }

    private int H0(int i) {
        int obj3;
        final String str = "AppCompatDelegate";
        if (i == 8) {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i == 9) {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            obj3 = 109;
        }
        return obj3;
    }

    private boolean J0(ViewParent viewParent) {
        boolean z;
        Object obj4;
        final int i = 0;
        if (viewParent == null) {
            return i;
        }
        while (obj4 == null) {
            obj4 = obj4.getParent();
        }
        return 1;
    }

    private boolean L(boolean z) {
        androidx.appcompat.app.g.m mVar2;
        androidx.appcompat.app.g.m mVar;
        if (this.e0) {
            return 0;
        }
        int i = O();
        if (i == 0) {
            h0(this.w).e();
        } else {
            mVar = this.j0;
            if (mVar != null) {
                mVar.a();
            }
        }
        if (i == 3) {
            g0(this.w).e();
        } else {
            mVar2 = this.k0;
            if (mVar2 != null) {
                mVar2.a();
            }
        }
        return N0(s0(this.w, i), z);
    }

    private void L0() {
        if (this.M) {
        } else {
        }
        AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("Window feature must be requested before adding content");
        throw androidRuntimeException;
    }

    private void M() {
        boolean fixedWidthMajor;
        boolean fixedWidthMinor;
        boolean fixedHeightMajor;
        boolean fixedHeightMinor;
        View viewById = this.N.findViewById(16908290);
        View decorView = this.x.getDecorView();
        (ContentFrameLayout)viewById.b(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray styledAttributes = this.w.obtainStyledAttributes(j.u0);
        styledAttributes.getValue(j.G0, viewById.getMinWidthMajor());
        styledAttributes.getValue(j.H0, viewById.getMinWidthMinor());
        int e0 = j.E0;
        if (styledAttributes.hasValue(e0)) {
            styledAttributes.getValue(e0, viewById.getFixedWidthMajor());
        }
        int f0 = j.F0;
        if (styledAttributes.hasValue(f0)) {
            styledAttributes.getValue(f0, viewById.getFixedWidthMinor());
        }
        int c0 = j.C0;
        if (styledAttributes.hasValue(c0)) {
            styledAttributes.getValue(c0, viewById.getFixedHeightMajor());
        }
        int d0 = j.D0;
        if (styledAttributes.hasValue(d0)) {
            styledAttributes.getValue(d0, viewById.getFixedHeightMinor());
        }
        styledAttributes.recycle();
        viewById.requestLayout();
    }

    private androidx.appcompat.app.d M0() {
        Context baseContext;
        int i;
        boolean z;
        baseContext = this.w;
        while (baseContext != null) {
            baseContext = (ContextWrapper)baseContext.getBaseContext();
        }
        return null;
    }

    private void N(Window window) {
        String str = "AppCompat has already installed itself into the Window";
        if (this.x != null) {
        } else {
            Window.Callback callback = window.getCallback();
            if (callback instanceof g.k) {
            } else {
                g.k kVar = new g.k(this, callback);
                this.y = kVar;
                window.setCallback(kVar);
                t0 t0Var = t0.u(this.w, 0, g.u0);
                android.graphics.drawable.Drawable drawable = t0Var.h(0);
                if (drawable != null) {
                    window.setBackgroundDrawable(drawable);
                }
                t0Var.w();
                this.x = window;
            }
            IllegalStateException obj4 = new IllegalStateException(str);
            throw obj4;
        }
        obj4 = new IllegalStateException(str);
        throw obj4;
    }

    private boolean N0(int i, boolean z2) {
        int i2;
        int i3;
        boolean z;
        boolean obj8;
        final int i4 = 0;
        final boolean z3 = q0();
        uiMode2 &= 48;
        uiMode &= 48;
        if (i5 != i2 && z2 && !z3 && this.b0) {
            if (z2) {
                if (!z3) {
                    if (this.b0) {
                        if (!g.v0) {
                            obj8 = this.v;
                            if (this.c0 && obj8 instanceof Activity != null && !(Activity)obj8.isChild()) {
                                obj8 = this.v;
                                if (obj8 instanceof Activity != null) {
                                    if (!(Activity)obj8.isChild()) {
                                        a.r((Activity)this.v);
                                        obj8 = i3;
                                    } else {
                                        obj8 = 0;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (obj8 == null && i5 != i2) {
            if (i5 != i2) {
                O0(i2, z3, i4);
            } else {
                i3 = obj8;
            }
        } else {
        }
        obj8 = this.v;
        if (i3 != 0 && obj8 instanceof d) {
            obj8 = this.v;
            if (obj8 instanceof d) {
                (d)obj8.onNightModeChanged(i);
            }
        }
        return i3;
    }

    private int O() {
        int i;
        if (this.f0 != -100) {
        } else {
            i = f.j();
        }
        return i;
    }

    private void O0(int i, boolean z2, Configuration configuration3) {
        Resources resources;
        int obj4;
        boolean obj5;
        int obj6;
        resources = this.w.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if (configuration3 != null) {
            configuration.updateFrom(configuration3);
        }
        configuration.uiMode = i |= obj6;
        resources.updateConfiguration(configuration, 0);
        obj4 = Build.VERSION.SDK_INT;
        if (obj4 < 26) {
            k.a(resources);
        }
        obj6 = this.g0;
        this.w.setTheme(obj6);
        if (obj6 != null && obj4 >= 23) {
            this.w.setTheme(obj6);
            if (obj4 >= 23) {
                this.w.getTheme().applyStyle(this.g0, true);
            }
        }
        obj4 = this.v;
        if (z2 && obj4 instanceof Activity != null) {
            obj4 = this.v;
            if (obj4 instanceof Activity != null) {
                if (obj4 instanceof q) {
                    if ((q)(Activity)obj4.getLifecycle().b().isAtLeast(j.c.STARTED)) {
                        obj4.onConfigurationChanged(configuration);
                    }
                } else {
                    if (this.d0) {
                        obj4.onConfigurationChanged(configuration);
                    }
                }
            }
        }
    }

    private void Q0(View view) {
        int i3;
        int i2;
        int i;
        i3 = i4 &= 8192 != 0 ? 1 : 0;
        if (i3 != 0) {
            i2 = a.d(this.w, c.b);
        } else {
            i2 = a.d(this.w, c.a);
        }
        view.setBackgroundColor(i2);
    }

    private void R() {
        androidx.appcompat.app.g.m mVar = this.j0;
        if (mVar != null) {
            mVar.a();
        }
        androidx.appcompat.app.g.m mVar2 = this.k0;
        if (mVar2 != null) {
            mVar2.a();
        }
    }

    private Configuration U(Context context, int i2, Configuration configuration3) {
        int i;
        int obj2;
        if (i2 != 1) {
            if (i2 != 2) {
                obj2 &= 48;
            } else {
                obj2 = 32;
            }
        } else {
            obj2 = 16;
        }
        Configuration obj3 = new Configuration();
        obj3.fontScale = 0;
        if (configuration3 != null) {
            obj3.setTo(configuration3);
        }
        obj3.uiMode = obj2 |= obj4;
        return obj3;
    }

    private ViewGroup V() {
        View inflate;
        TypedValue typedValue;
        boolean boolean2;
        boolean boolean;
        int i2;
        androidx.appcompat.app.g.c cVar;
        Object viewById;
        Object dVar2;
        boolean z;
        boolean z2;
        int i;
        int dVar;
        int i3;
        int i4;
        int childCount;
        TypedArray styledAttributes = this.w.obtainStyledAttributes(j.u0);
        boolean2 = j.z0;
        if (!styledAttributes.hasValue(boolean2)) {
        } else {
            i3 = 0;
            i4 = 1;
            if (styledAttributes.getBoolean(j.I0, i3)) {
                B(i4);
            } else {
                if (styledAttributes.getBoolean(boolean2, i3)) {
                    B(108);
                }
            }
            i = 109;
            if (styledAttributes.getBoolean(j.A0, i3)) {
                B(i);
            }
            if (styledAttributes.getBoolean(j.B0, i3)) {
                B(10);
            }
            this.V = styledAttributes.getBoolean(j.v0, i3);
            styledAttributes.recycle();
            c0();
            this.x.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.w);
            final int i12 = 0;
            if (!this.W) {
                if (this.V) {
                    inflate = from.inflate(g.f, i12);
                    this.T = i3;
                    this.S = i3;
                } else {
                    if (this.S) {
                        typedValue = new TypedValue();
                        this.w.getTheme().resolveAttribute(a.f, typedValue, i4);
                        if (typedValue.resourceId != 0) {
                            dVar2 = new d(this.w, typedValue.resourceId);
                        } else {
                            dVar2 = this.w;
                        }
                        View viewById3 = (ViewGroup)LayoutInflater.from(dVar2).inflate(g.p, i12).findViewById(f.p);
                        this.D = (y)viewById3;
                        viewById3.setWindowCallback(k0());
                        if (this.T) {
                            this.D.h(i);
                        }
                        if (this.Q) {
                            this.D.h(2);
                        }
                        if (this.R) {
                            this.D.h(5);
                        }
                    } else {
                        inflate = i12;
                    }
                }
            } else {
                if (this.U) {
                    inflate = from.inflate(g.o, i12);
                } else {
                    inflate = from.inflate(g.n, i12);
                }
            }
            if (inflate == null) {
            } else {
                if (Build.VERSION.SDK_INT >= 21) {
                    cVar = new g.c(this);
                    u.x0(inflate, cVar);
                } else {
                    if (inflate instanceof c0) {
                        dVar = new g.d(this);
                        (c0)inflate.setOnFitSystemWindowsListener(dVar);
                    }
                }
                if (this.D == null) {
                    this.O = (TextView)inflate.findViewById(f.M);
                }
                z0.c(inflate);
                View viewById2 = inflate.findViewById(f.b);
                int i11 = 16908290;
                View viewById4 = this.x.findViewById(i11);
                if ((ViewGroup)viewById4 != null) {
                }
                this.x.setContentView(inflate);
                g.e eVar = new g.e(this);
                (ContentFrameLayout)viewById2.setAttachListener(eVar);
                return inflate;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AppCompat does not support the current theme features: { windowActionBar: ");
            stringBuilder.append(this.S);
            stringBuilder.append(", windowActionBarOverlay: ");
            stringBuilder.append(this.T);
            stringBuilder.append(", android:windowIsFloating: ");
            stringBuilder.append(this.V);
            stringBuilder.append(", windowActionModeOverlay: ");
            stringBuilder.append(this.U);
            stringBuilder.append(", windowNoTitle: ");
            stringBuilder.append(this.W);
            stringBuilder.append(" }");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        styledAttributes.recycle();
        IllegalStateException illegalStateException = new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        throw illegalStateException;
    }

    private void b0() {
        Object z;
        boolean empty;
        boolean z2;
        this.N = V();
        java.lang.CharSequence charSequence = j0();
        if (!this.M && !TextUtils.isEmpty(charSequence)) {
            this.N = V();
            charSequence = j0();
            if (!TextUtils.isEmpty(charSequence)) {
                empty = this.D;
                if (empty != null) {
                    empty.setWindowTitle(charSequence);
                } else {
                    if (D0() != null) {
                        D0().v(charSequence);
                    } else {
                        empty = this.O;
                        if (empty != null) {
                            empty.setText(charSequence);
                        }
                    }
                }
            }
            M();
            B0(this.N);
            this.M = true;
            int i2 = 0;
            z = i0(i2, i2);
            if (!this.e0) {
                if (z != null) {
                    if (z.j == null) {
                        p0(108);
                    }
                } else {
                }
            }
        }
    }

    private void c0() {
        Object window;
        boolean z;
        window = this.v;
        if (this.x == null && window instanceof Activity != null) {
            window = this.v;
            if (window instanceof Activity != null) {
                N((Activity)window.getWindow());
            }
        }
        if (this.x == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("We have not been given a Window");
        throw illegalStateException;
    }

    private static Configuration e0(Configuration configuration, Configuration configuration2) {
        int sDK_INT;
        int i7;
        boolean locale;
        int i8;
        int i4;
        int i5;
        int i6;
        int i;
        int i2;
        java.util.Locale smallestScreenWidthDp;
        int screenLayout2;
        int screenLayout3;
        int screenLayout4;
        int screenLayout;
        int uiMode2;
        int uiMode;
        int i3;
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0;
        if (configuration2 != null) {
            if (configuration.diff(configuration2) == 0) {
            } else {
                float fontScale2 = configuration2.fontScale;
                if (Float.compare(fontScale, fontScale2) != 0) {
                    configuration3.fontScale = fontScale2;
                }
                int mcc2 = configuration2.mcc;
                if (configuration.mcc != mcc2) {
                    configuration3.mcc = mcc2;
                }
                int mnc2 = configuration2.mnc;
                if (configuration.mnc != mnc2) {
                    configuration3.mnc = mnc2;
                }
                sDK_INT = Build.VERSION.SDK_INT;
                if (sDK_INT >= 24) {
                    g.p.a(configuration, configuration2, configuration3);
                } else {
                    if (!c.a(configuration.locale, configuration2.locale)) {
                        configuration3.locale = configuration2.locale;
                    }
                }
                int touchscreen2 = configuration2.touchscreen;
                if (configuration.touchscreen != touchscreen2) {
                    configuration3.touchscreen = touchscreen2;
                }
                int keyboard2 = configuration2.keyboard;
                if (configuration.keyboard != keyboard2) {
                    configuration3.keyboard = keyboard2;
                }
                int keyboardHidden2 = configuration2.keyboardHidden;
                if (configuration.keyboardHidden != keyboardHidden2) {
                    configuration3.keyboardHidden = keyboardHidden2;
                }
                int navigation2 = configuration2.navigation;
                if (configuration.navigation != navigation2) {
                    configuration3.navigation = navigation2;
                }
                int navigationHidden2 = configuration2.navigationHidden;
                if (configuration.navigationHidden != navigationHidden2) {
                    configuration3.navigationHidden = navigationHidden2;
                }
                int orientation2 = configuration2.orientation;
                if (configuration.orientation != orientation2) {
                    configuration3.orientation = orientation2;
                }
                screenLayout2 = configuration2.screenLayout;
                if (screenLayout5 &= 15 != screenLayout2 & 15) {
                    configuration3.screenLayout = screenLayout12 |= screenLayout2;
                }
                screenLayout3 = configuration2.screenLayout;
                if (screenLayout6 &= 192 != screenLayout3 & 192) {
                    configuration3.screenLayout = screenLayout7 |= screenLayout3;
                }
                screenLayout4 = configuration2.screenLayout;
                if (screenLayout8 &= 48 != screenLayout4 & 48) {
                    configuration3.screenLayout = screenLayout11 |= screenLayout4;
                }
                screenLayout = configuration2.screenLayout;
                if (screenLayout9 &= 768 != screenLayout & 768) {
                    configuration3.screenLayout = screenLayout10 |= screenLayout;
                }
                if (sDK_INT >= 26) {
                    g.q.a(configuration, configuration2, configuration3);
                }
                uiMode2 = configuration2.uiMode;
                if (uiMode3 &= 15 != uiMode2 & 15) {
                    configuration3.uiMode = uiMode6 |= uiMode2;
                }
                uiMode = configuration2.uiMode;
                if (uiMode4 &= 48 != uiMode & 48) {
                    configuration3.uiMode = uiMode5 |= uiMode;
                }
                int screenWidthDp2 = configuration2.screenWidthDp;
                if (configuration.screenWidthDp != screenWidthDp2) {
                    configuration3.screenWidthDp = screenWidthDp2;
                }
                int screenHeightDp2 = configuration2.screenHeightDp;
                if (configuration.screenHeightDp != screenHeightDp2) {
                    configuration3.screenHeightDp = screenHeightDp2;
                }
                smallestScreenWidthDp = configuration2.smallestScreenWidthDp;
                if (configuration.smallestScreenWidthDp != smallestScreenWidthDp) {
                    configuration3.smallestScreenWidthDp = smallestScreenWidthDp;
                }
                if (sDK_INT >= 17) {
                    g.o.a(configuration, configuration2, configuration3);
                }
            }
        }
        return configuration3;
    }

    private androidx.appcompat.app.g.m g0(Context context) {
        androidx.appcompat.app.g.m lVar;
        if (this.k0 == null) {
            lVar = new g.l(this, context);
            this.k0 = lVar;
        }
        return this.k0;
    }

    private androidx.appcompat.app.g.m h0(Context context) {
        androidx.appcompat.app.g.m nVar;
        Object obj2;
        if (this.j0 == null) {
            nVar = new g.n(this, n.a(context));
            this.j0 = nVar;
        }
        return this.j0;
    }

    private void l0() {
        boolean z3;
        boolean oVar;
        boolean z2;
        boolean z;
        b0();
        if (this.S) {
            if (this.A != null) {
            } else {
                Object obj = this.v;
                if (obj instanceof Activity != null) {
                    oVar = new o((Activity)this.v, this.T);
                    this.A = oVar;
                } else {
                    if (obj instanceof Dialog) {
                        oVar = new o((Dialog)this.v);
                        this.A = oVar;
                    }
                }
                z3 = this.A;
                if (z3 != null) {
                    z3.r(this.o0);
                }
            }
        }
    }

    private boolean m0(androidx.appcompat.app.g.t g$t) {
        androidx.appcompat.app.g.u uVar;
        int i;
        View view = t.i;
        if (view != null) {
            t.h = view;
            return 1;
        }
        final int i2 = 0;
        if (t.j == null) {
            return i2;
        }
        if (this.F == null) {
            uVar = new g.u(this);
            this.F = uVar;
        }
        n nVar = t.a(this.F);
        t.h = (View)nVar;
        if (nVar != null) {
        } else {
            i = i2;
        }
        return i;
    }

    private boolean n0(androidx.appcompat.app.g.t g$t) {
        t.d(f0());
        g.s sVar = new g.s(this, t.l);
        t.g = sVar;
        t.c = 81;
        return 1;
    }

    private boolean o0(androidx.appcompat.app.g.t g$t) {
        Object context;
        TypedValue typedValue;
        int theme2;
        int theme;
        int i;
        int resourceId;
        context = this.w;
        typedValue = t.a;
        final int i2 = 1;
        if (typedValue != 0) {
            if (typedValue == 108 && this.D != null) {
                if (this.D != null) {
                    typedValue = new TypedValue();
                    theme2 = context.getTheme();
                    theme2.resolveAttribute(a.f, typedValue, i2);
                    theme = 0;
                    if (typedValue.resourceId != 0) {
                        theme = context.getResources().newTheme();
                        theme.setTo(theme2);
                        theme.applyStyle(typedValue.resourceId, i2);
                        theme.resolveAttribute(a.g, typedValue, i2);
                    } else {
                        theme2.resolveAttribute(a.g, typedValue, i2);
                    }
                    if (typedValue.resourceId != 0 && theme == 0) {
                        if (theme == 0) {
                            context.getResources().newTheme().setTo(theme2);
                        }
                        theme.applyStyle(typedValue.resourceId, i2);
                    }
                    if (theme != 0) {
                        typedValue = new d(context, 0);
                        typedValue.getTheme().setTo(theme);
                        context = typedValue;
                    }
                }
            }
        } else {
        }
        g gVar = new g(context);
        gVar.V(this);
        t.c(gVar);
        return i2;
    }

    private void p0(int i) {
        int i2;
        boolean obj3;
        final int i3 = 1;
        this.m0 = obj3 |= i2;
        if (!this.l0) {
            u.d0(this.x.getDecorView(), this.n0);
            this.l0 = i3;
        }
    }

    private boolean q0() {
        android.content.pm.ActivityInfo activityInfo;
        int z;
        boolean i;
        int str;
        int i2;
        Object componentName;
        Context context;
        Class class;
        final int i3 = 1;
        PackageManager packageManager = this.w.getPackageManager();
        i = 0;
        if (!this.i0 && obj instanceof Activity != null && packageManager == null) {
            if (obj instanceof Activity != null) {
                packageManager = this.w.getPackageManager();
                i = 0;
                if (packageManager == null) {
                    return i;
                }
                int sDK_INT = Build.VERSION.SDK_INT;
                str = sDK_INT >= 29 ? 269221888 : sDK_INT >= i2 ? 786432 : i;
                componentName = new ComponentName(this.w, this.v.getClass());
                activityInfo = packageManager.getActivityInfo(componentName, str);
                if (activityInfo != null && configChanges &= 512 != 0) {
                    z = configChanges &= 512 != 0 ? i3 : i;
                } else {
                }
                this.h0 = z;
            }
        }
        this.i0 = i3;
        return this.h0;
    }

    private boolean v0(int i, KeyEvent keyEvent2) {
        int repeatCount;
        int obj2;
        obj2 = i0(i, true);
        if (keyEvent2.getRepeatCount() == 0 && !obj2.o) {
            obj2 = i0(i, true);
            if (!obj2.o) {
                return F0(obj2, keyEvent2);
            }
        }
        return 0;
    }

    private boolean y0(int i, KeyEvent keyEvent2) {
        int i2;
        boolean z;
        int obj5;
        Object obj6;
        final int i3 = 0;
        if (this.G != null) {
            return i3;
        }
        i2 = 1;
        final androidx.appcompat.app.g.t tVar = i0(i, i2);
        obj5 = this.D;
        if (i == 0 && obj5 != null && obj5.d() && !ViewConfiguration.get(this.w).hasPermanentMenuKey()) {
            obj5 = this.D;
            if (obj5 != null) {
                if (obj5.d()) {
                    if (!ViewConfiguration.get(this.w).hasPermanentMenuKey()) {
                        if (!this.D.b()) {
                            if (!this.e0 && F0(tVar, keyEvent2)) {
                                if (F0(tVar, keyEvent2)) {
                                    i2 = this.D.g();
                                } else {
                                    i2 = i3;
                                }
                            } else {
                            }
                        } else {
                            i2 = this.D.f();
                        }
                    } else {
                        obj5 = tVar.o;
                        if (obj5 == null) {
                            if (tVar.n) {
                                T(tVar, i2);
                                i2 = obj5;
                            } else {
                                if (tVar.m) {
                                    if (tVar.r) {
                                        tVar.m = i3;
                                        obj5 = F0(tVar, keyEvent2);
                                    } else {
                                        obj5 = i2;
                                    }
                                    if (obj5 != null) {
                                        C0(tVar, keyEvent2);
                                    } else {
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i2 != 0) {
            obj5 = this.w.getApplicationContext().getSystemService("audio");
            if ((AudioManager)obj5 != null) {
                (AudioManager)obj5.playSoundEffect(i3);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return i2;
    }

    @Override // androidx.appcompat.app.f
    void A0(int i) {
        int i2;
        int obj3;
        final int i3 = 0;
        if (i == 108) {
            obj3 = n();
            if (obj3 != null) {
                obj3.i(i3);
            }
        } else {
            obj3 = i0(i, true);
            if (i == 0 && obj3.o) {
                obj3 = i0(i, true);
                if (obj3.o) {
                    T(obj3, i3);
                }
            }
        }
    }

    @Override // androidx.appcompat.app.f
    public boolean B(int i) {
        int obj5 = H0(i);
        final int i6 = 0;
        final int i7 = 108;
        if (this.W && obj5 == i7) {
            if (obj5 == i7) {
                return i6;
            }
        }
        final int i8 = 1;
        if (this.S && obj5 == i8) {
            if (obj5 == i8) {
                this.S = i6;
            }
        }
        if (obj5 != i8 && obj5 != 2 && obj5 != 5 && obj5 != 10 && obj5 != i7 && obj5 != 109) {
            if (obj5 != 2) {
                if (obj5 != 5) {
                    if (obj5 != 10) {
                        if (obj5 != i7) {
                            if (obj5 != 109) {
                                return this.x.requestFeature(obj5);
                            }
                            L0();
                            this.T = i8;
                            return i8;
                        }
                        L0();
                        this.S = i8;
                        return i8;
                    }
                    L0();
                    this.U = i8;
                    return i8;
                }
                L0();
                this.R = i8;
                return i8;
            }
            L0();
            this.Q = i8;
            return i8;
        }
        L0();
        this.W = i8;
        return i8;
    }

    @Override // androidx.appcompat.app.f
    void B0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.f
    public void D(int i) {
        b0();
        View viewById = this.N.findViewById(16908290);
        (ViewGroup)viewById.removeAllViews();
        LayoutInflater.from(this.w).inflate(i, viewById);
        this.y.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    final androidx.appcompat.app.a D0() {
        return this.A;
    }

    @Override // androidx.appcompat.app.f
    public void E(View view) {
        b0();
        View viewById = this.N.findViewById(16908290);
        (ViewGroup)viewById.removeAllViews();
        viewById.addView(view);
        this.y.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void F(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        b0();
        View viewById = this.N.findViewById(16908290);
        (ViewGroup)viewById.removeAllViews();
        viewById.addView(view, layoutParams2);
        this.y.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    public void G(Toolbar toolbar) {
        Window.Callback kVar;
        int i;
        androidx.appcompat.app.g.k kVar2;
        Window obj4;
        if (obj instanceof Activity == null) {
        }
        androidx.appcompat.app.a aVar = n();
        if (aVar instanceof o) {
        } else {
            i = 0;
            this.B = i;
            if (aVar != null) {
                aVar.n();
            }
            if (toolbar != null) {
                l lVar = new l(toolbar, j0(), this.y);
                this.A = lVar;
                this.x.setCallback(lVar.y());
            } else {
                this.A = i;
                this.x.setCallback(this.y);
            }
            p();
        }
        obj4 = new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        throw obj4;
    }

    @Override // androidx.appcompat.app.f
    public void H(int i) {
        this.g0 = i;
    }

    @Override // androidx.appcompat.app.f
    public final void I(java.lang.CharSequence charSequence) {
        Object yVar;
        this.C = charSequence;
        yVar = this.D;
        if (yVar != null) {
            yVar.setWindowTitle(charSequence);
        } else {
            if (D0() != null) {
                D0().v(charSequence);
            } else {
                yVar = this.O;
                if (yVar != null) {
                    yVar.setText(charSequence);
                }
            }
        }
    }

    @Override // androidx.appcompat.app.f
    final boolean I0() {
        int i;
        boolean z;
        z = this.N;
        if (this.M && z != null && u.R(z)) {
            z = this.N;
            if (z != null) {
                i = u.R(z) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.app.f
    public b J(b.a b$a) {
        androidx.appcompat.app.e eVar;
        Object obj3;
        if (a == null) {
        } else {
            b bVar = this.G;
            if (bVar != null) {
                bVar.c();
            }
            g.j jVar = new g.j(this, a);
            obj3 = n();
            obj3 = obj3.w(jVar);
            this.G = obj3;
            eVar = this.z;
            if (obj3 != null && obj3 != null && eVar != null) {
                obj3 = obj3.w(jVar);
                this.G = obj3;
                if (obj3 != null) {
                    eVar = this.z;
                    if (eVar != null) {
                        eVar.onSupportActionModeStarted(obj3);
                    }
                }
            }
            if (this.G == null) {
                this.G = K0(jVar);
            }
            return this.G;
        }
        obj3 = new IllegalArgumentException("ActionMode callback can not be null.");
        throw obj3;
    }

    @Override // androidx.appcompat.app.f
    public boolean K() {
        return L(true);
    }

    @Override // androidx.appcompat.app.f
    b K0(b.a b$a) {
        boolean jVar;
        b onWindowStartingSupportActionMode;
        Object viewById;
        int i2;
        boolean z;
        int i;
        int context;
        Object dVar;
        Object theme;
        int resourceId;
        int theme2;
        Object obj8;
        a0();
        b bVar = this.G;
        if (bVar != null) {
            bVar.c();
        }
        if (!a instanceof g.j) {
            jVar = new g.j(this, a);
            obj8 = jVar;
        }
        androidx.appcompat.app.e eVar = this.z;
        i2 = 0;
        if (eVar != null && !this.e0) {
            if (!this.e0) {
                onWindowStartingSupportActionMode = eVar.onWindowStartingSupportActionMode(obj8);
            } else {
                onWindowStartingSupportActionMode = i2;
            }
        } else {
        }
        if (onWindowStartingSupportActionMode != null) {
            this.G = onWindowStartingSupportActionMode;
        } else {
            z = 0;
            i = 1;
            if (this.H == null) {
                if (this.V) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme3 = this.w.getTheme();
                    theme3.resolveAttribute(a.f, typedValue, i);
                    if (typedValue.resourceId != 0) {
                        resourceId = this.w.getResources().newTheme();
                        resourceId.setTo(theme3);
                        resourceId.applyStyle(typedValue.resourceId, i);
                        dVar = new d(this.w, z);
                        dVar.getTheme().setTo(resourceId);
                    } else {
                        dVar = this.w;
                    }
                    ActionBarContextView actionBarContextView = new ActionBarContextView(dVar);
                    this.H = actionBarContextView;
                    PopupWindow popupWindow2 = new PopupWindow(dVar, i2, a.i);
                    this.I = popupWindow2;
                    j.b(popupWindow2, 2);
                    this.I.setContentView(this.H);
                    this.I.setWidth(-1);
                    dVar.getTheme().resolveAttribute(a.b, typedValue, i);
                    this.H.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.I.setHeight(-2);
                    viewById = new g.f(this);
                    this.J = viewById;
                } else {
                    viewById = this.N.findViewById(f.h);
                    if ((ViewStubCompat)viewById != null) {
                        (ViewStubCompat)viewById.setLayoutInflater(LayoutInflater.from(f0()));
                        this.H = (ActionBarContextView)viewById.a();
                    }
                }
            }
            if (this.H != null) {
                a0();
                this.H.k();
                if (this.I == null) {
                } else {
                    i = z;
                }
                onWindowStartingSupportActionMode = new e(this.H.getContext(), this.H, obj8, i);
                if (obj8.b(onWindowStartingSupportActionMode, onWindowStartingSupportActionMode.e())) {
                    onWindowStartingSupportActionMode.k();
                    this.H.h(onWindowStartingSupportActionMode);
                    this.G = onWindowStartingSupportActionMode;
                    int i3 = 1065353216;
                    if (I0()) {
                        this.H.setAlpha(0);
                        obj8 = u.d(this.H);
                        obj8.a(i3);
                        this.K = obj8;
                        onWindowStartingSupportActionMode = new g.g(this);
                        obj8.g(onWindowStartingSupportActionMode);
                    } else {
                        this.H.setAlpha(i3);
                        this.H.setVisibility(z);
                        this.H.sendAccessibilityEvent(32);
                        if (obj8 instanceof View != null) {
                            u.i0((View)this.H.getParent());
                        }
                    }
                    if (this.I != null) {
                        this.x.getDecorView().post(this.J);
                    }
                } else {
                    try {
                        this.G = i2;
                        obj8 = this.G;
                        onWindowStartingSupportActionMode = this.z;
                        if (obj8 != null && onWindowStartingSupportActionMode != null) {
                        }
                        onWindowStartingSupportActionMode = this.z;
                        if (onWindowStartingSupportActionMode != null) {
                        }
                        onWindowStartingSupportActionMode.onSupportActionModeStarted(obj8);
                    }
                    return this.G;
                }
            }
        }
    }

    @Override // androidx.appcompat.app.f
    void P(int i, androidx.appcompat.app.g.t g$t2, Menu menu3) {
        androidx.appcompat.app.g.t[] objArr;
        int length;
        androidx.appcompat.app.g.t obj4;
        g obj5;
        objArr = this.Y;
        if (menu3 == null && t2 == null && i >= 0 && i < objArr.length) {
            if (t2 == null) {
                if (i >= 0) {
                    objArr = this.Y;
                    if (i < objArr.length) {
                        obj4 = objArr[i];
                    }
                }
            }
            if (obj4 != null) {
                obj5 = obj4.j;
            }
        }
        if (obj4 != null && !obj4.o) {
            if (!obj4.o) {
            }
        }
        if (!this.e0) {
            this.y.a().onPanelClosed(i, obj5);
        }
    }

    @Override // androidx.appcompat.app.f
    final int P0(d0 d0, Rect rect2) {
        int i5;
        int top;
        Object layoutParams;
        boolean rightMargin;
        Rect rect;
        int i4;
        int i2;
        int i;
        int rightMargin2;
        int i3;
        int obj11;
        Object obj12;
        i5 = 0;
        if (d0 != 0) {
            top = d0.l();
        } else {
            top = rect2 != null ? rect2.top : i5;
        }
        layoutParams = this.H;
        final int i6 = 8;
        if (layoutParams != null && layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams = this.H.getLayoutParams();
                if (this.H.isShown()) {
                    if (this.p0 == null) {
                        Rect rect3 = new Rect();
                        this.p0 = rect3;
                        rect = new Rect();
                        this.q0 = rect;
                    }
                    Rect rect4 = this.p0;
                    if (d0 == 0) {
                        rect4.set(rect2);
                    } else {
                        rect4.set(d0.j(), d0.l(), d0.k(), d0.i());
                    }
                    z0.a(this.N, rect4, this.q0);
                    obj11 = rect4.top;
                    obj12 = rect4.left;
                    rightMargin = rect4.right;
                    d0 d0Var = u.H(this.N);
                    if (d0Var == null) {
                        i = i5;
                    } else {
                        i = d0Var.j();
                    }
                    if (d0Var == null) {
                        i2 = i5;
                    } else {
                        i2 = d0Var.k();
                    }
                    if (layoutParams.topMargin == obj11 && layoutParams.leftMargin == obj12) {
                        if (layoutParams.leftMargin == obj12) {
                            if (layoutParams.rightMargin != rightMargin) {
                                layoutParams.topMargin = obj11;
                                layoutParams.leftMargin = obj12;
                                layoutParams.rightMargin = rightMargin;
                                obj12 = i4;
                            } else {
                                obj12 = i5;
                            }
                        } else {
                        }
                    } else {
                    }
                    if (obj11 > 0 && this.P == null) {
                        if (this.P == null) {
                            obj11 = new View(this.w);
                            this.P = obj11;
                            obj11.setVisibility(i6);
                            i3 = -1;
                            obj11 = new FrameLayout.LayoutParams(i3, layoutParams.topMargin, 51);
                            obj11.leftMargin = i;
                            obj11.rightMargin = i2;
                            this.N.addView(this.P, i3, obj11);
                        } else {
                            obj11 = this.P;
                            if (obj11 != null) {
                                obj11 = obj11.getLayoutParams();
                                rightMargin2 = layoutParams.topMargin;
                                if (obj11.height == rightMargin2 && obj11.leftMargin == i) {
                                    if (obj11.leftMargin == i) {
                                        if (obj11.rightMargin != i2) {
                                            obj11.height = rightMargin2;
                                            obj11.leftMargin = i;
                                            obj11.rightMargin = i2;
                                            this.P.setLayoutParams((ViewGroup.MarginLayoutParams)obj11);
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            }
                        }
                    } else {
                    }
                    obj11 = this.P;
                    if (obj11 != null) {
                    } else {
                        i4 = i5;
                    }
                    if (i4 != 0 && obj11.getVisibility() != 0) {
                        if (obj11.getVisibility() != 0) {
                            Q0(this.P);
                        }
                    }
                    if (!this.U && i4 != 0) {
                        if (i4 != 0) {
                            top = i5;
                        }
                    }
                    obj11 = i4;
                    i4 = obj12;
                } else {
                    if (layoutParams.topMargin != 0) {
                        layoutParams.topMargin = i5;
                        obj11 = i5;
                    } else {
                        i4 = obj11;
                    }
                }
                if (i4 != 0) {
                    this.H.setLayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
                }
            } else {
                obj11 = i5;
            }
        } else {
        }
        obj12 = this.P;
        if (obj12 != null) {
            if (obj11 != null) {
            } else {
                i5 = i6;
            }
            obj12.setVisibility(i5);
        }
        return top;
    }

    @Override // androidx.appcompat.app.f
    void Q(g g) {
        boolean z;
        if (this.X) {
        }
        this.X = true;
        this.D.i();
        Window.Callback callback = k0();
        if (callback != null && !this.e0) {
            if (!this.e0) {
                callback.onPanelClosed(108, g);
            }
        }
        this.X = false;
    }

    @Override // androidx.appcompat.app.f
    void S(int i) {
        final int i2 = 1;
        T(i0(i, i2), i2);
    }

    @Override // androidx.appcompat.app.f
    void T(androidx.appcompat.app.g.t g$t, boolean z2) {
        int i;
        boolean z;
        int obj5;
        i = this.D;
        if (z2 != 0 && t.a == 0 && i != null && i.b()) {
            if (t.a == 0) {
                i = this.D;
                if (i != null) {
                    if (i.b()) {
                        Q(t.j);
                    }
                }
            }
        }
        Object systemService = this.w.getSystemService("window");
        int i2 = 0;
        z = t.g;
        (WindowManager)systemService.removeView(z);
        if (systemService != null && t.o && z != null && z2 != 0) {
            if (t.o) {
                z = t.g;
                if (z != null) {
                    systemService.removeView(z);
                    if (z2 != 0) {
                        P(t.a, t, i2);
                    }
                }
            }
        }
        obj5 = 0;
        t.m = obj5;
        t.n = obj5;
        t.o = obj5;
        t.h = i2;
        t.q = true;
        if (this.Z == t) {
            this.Z = i2;
        }
    }

    @Override // androidx.appcompat.app.f
    public View W(View view, String string2, Context context3, AttributeSet attributeSet4) {
        Object jVar;
        int i;
        Throwable instance;
        StringBuilder str2;
        String str;
        i = 0;
        if (this.r0 == null) {
            jVar = this.w.obtainStyledAttributes(j.u0).getString(j.y0);
            if (jVar == null) {
                jVar = new j();
                this.r0 = jVar;
            } else {
                this.r0 = (j)Class.forName(jVar).getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
            }
        }
        final boolean z2 = g.t0;
        if (z2) {
            instance = 1;
            if (attributeSet4 instanceof XmlPullParser) {
                if ((XmlPullParser)attributeSet4.getDepth() > instance) {
                    i = instance;
                }
            } else {
                i = jVar;
            }
        }
        return this.r0.q(view, string2, context3, attributeSet4, i, z2, true, y0.c());
    }

    @Override // androidx.appcompat.app.f
    void X() {
        boolean showing;
        PopupWindow popupWindow;
        Object tVar;
        Runnable runnable;
        y yVar = this.D;
        if (yVar != null) {
            yVar.i();
        }
        this.x.getDecorView().removeCallbacks(this.J);
        if (this.I != null && this.I.isShowing()) {
            this.x.getDecorView().removeCallbacks(this.J);
            if (this.I.isShowing()) {
                this.I.dismiss();
            }
            this.I = 0;
        }
        a0();
        int i = 0;
        tVar = i0(i, i);
        tVar = tVar.j;
        if (tVar != null && tVar != null) {
            tVar = tVar.j;
            if (tVar != null) {
                tVar.close();
            }
        }
    }

    @Override // androidx.appcompat.app.f
    boolean Y(KeyEvent keyEvent) {
        Object decorView;
        int dispatchKeyEvent;
        int i;
        boolean obj4;
        decorView = this.v;
        i = 1;
        if (!decorView instanceof f.a) {
            decorView = this.x.getDecorView();
            if (decorView instanceof h && decorView != null && f.d(decorView, keyEvent)) {
                decorView = this.x.getDecorView();
                if (decorView != null) {
                    if (f.d(decorView, keyEvent)) {
                        return i;
                    }
                }
            }
        } else {
        }
        if (keyEvent.getKeyCode() == 82 && this.y.a().dispatchKeyEvent(keyEvent)) {
            if (this.y.a().dispatchKeyEvent(keyEvent)) {
                return i;
            }
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
        } else {
            i = 0;
        }
        if (i != 0) {
            obj4 = u0(keyCode, keyEvent);
        } else {
            obj4 = x0(keyCode, keyEvent);
        }
        return obj4;
    }

    @Override // androidx.appcompat.app.f
    void Z(int i) {
        int i2;
        g gVar;
        int size;
        y obj5;
        int i3 = 1;
        final androidx.appcompat.app.g.t tVar = i0(i, i3);
        Bundle bundle = new Bundle();
        tVar.j.T(bundle);
        if (tVar.j != null && bundle.size() > 0) {
            bundle = new Bundle();
            tVar.j.T(bundle);
            if (bundle.size() > 0) {
                tVar.s = bundle;
            }
            tVar.j.h0();
            tVar.j.clear();
        }
        tVar.r = i3;
        tVar.q = i3;
        if (i != 108) {
            obj5 = 0;
            i2 = i0(obj5, obj5);
            if (i == 0 && this.D != null && i2 != null) {
                if (this.D != null) {
                    obj5 = 0;
                    i2 = i0(obj5, obj5);
                    if (i2 != null) {
                        i2.m = obj5;
                        F0(i2, 0);
                    }
                }
            }
        } else {
        }
    }

    @Override // androidx.appcompat.app.f
    public boolean a(g g, MenuItem menuItem2) {
        boolean z;
        androidx.appcompat.app.g.t obj3;
        final Window.Callback callback = k0();
        obj3 = d0(g.F());
        if (callback != null && !this.e0 && obj3 != null) {
            if (!this.e0) {
                obj3 = d0(g.F());
                if (obj3 != null) {
                    return callback.onMenuItemSelected(obj3.a, menuItem2);
                }
            }
        }
        return 0;
    }

    @Override // androidx.appcompat.app.f
    void a0() {
        final z zVar = this.K;
        if (zVar != null) {
            zVar.b();
        }
    }

    @Override // androidx.appcompat.app.f
    public void b(g g) {
        G0(true);
    }

    @Override // androidx.appcompat.app.f
    public void d(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        b0();
        (ViewGroup)this.N.findViewById(16908290).addView(view, layoutParams2);
        this.y.a().onContentChanged();
    }

    @Override // androidx.appcompat.app.f
    androidx.appcompat.app.g.t d0(Menu menu) {
        int i;
        int length;
        androidx.appcompat.app.g.t tVar;
        g gVar;
        final androidx.appcompat.app.g.t[] objArr = this.Y;
        length = objArr != null ? objArr.length : i;
        while (i < length) {
            tVar = objArr[i];
            i++;
        }
        return null;
    }

    @Override // androidx.appcompat.app.f
    public Context f(Context context) {
        int i2;
        boolean z;
        int i;
        Resources.Theme obj7;
        this.b0 = true;
        int i4 = s0(context, O());
        i = 0;
        if (g.w0 && context instanceof ContextThemeWrapper) {
            if (context instanceof ContextThemeWrapper) {
                g.r.a((ContextThemeWrapper)context, U(context, i4, i));
                return context;
            }
        }
        if (context instanceof d) {
            (d)context.a(U(context, i4, i));
            return context;
        }
        if (!g.v0) {
            super.f(context);
            return context;
        }
        Configuration configuration3 = context.getPackageManager().getResourcesForApplication(context.getApplicationInfo()).getConfiguration();
        Configuration configuration5 = context.getResources().getConfiguration();
        if (!configuration3.equals(configuration5)) {
            i = g.e0(configuration3, configuration5);
        }
        d dVar = new d(context, i.c);
        dVar.a(U(context, i4, i));
        if (context.getTheme() != null) {
        } else {
            i2 = i5;
        }
        if (i2 != 0) {
            f.d.a(dVar.getTheme());
        }
        super.f(dVar);
        return dVar;
    }

    @Override // androidx.appcompat.app.f
    final Context f0() {
        Context context;
        androidx.appcompat.app.a aVar = n();
        if (aVar != null) {
            context = aVar.k();
        } else {
            context = 0;
        }
        if (context == null) {
            context = this.w;
        }
        return context;
    }

    public <T extends View> T i(int i) {
        b0();
        return this.x.findViewById(i);
    }

    @Override // androidx.appcompat.app.f
    protected androidx.appcompat.app.g.t i0(int i, boolean z2) {
        int length2;
        androidx.appcompat.app.g.t tVar;
        int length;
        int i2;
        androidx.appcompat.app.g.t[] obj5;
        obj5 = this.Y;
        if (obj5 != null) {
            length2 = new g.t[i + 1];
            if (obj5.length <= i && obj5 != null) {
                length2 = new g.t[i + 1];
                if (obj5 != null) {
                    i2 = 0;
                    System.arraycopy(obj5, i2, length2, i2, obj5.length);
                }
                this.Y = length2;
                obj5 = length2;
            }
        } else {
        }
        if (obj5[i] == null) {
            tVar = new g.t(i);
            obj5[i] = tVar;
        }
        return tVar;
    }

    @Override // androidx.appcompat.app.f
    final java.lang.CharSequence j0() {
        Object obj = this.v;
        if (obj instanceof Activity != null) {
            return (Activity)obj.getTitle();
        }
        return this.C;
    }

    @Override // androidx.appcompat.app.f
    public final androidx.appcompat.app.b k() {
        g.h hVar = new g.h(this);
        return hVar;
    }

    @Override // androidx.appcompat.app.f
    final Window.Callback k0() {
        return this.x.getCallback();
    }

    @Override // androidx.appcompat.app.f
    public int l() {
        return this.f0;
    }

    @Override // androidx.appcompat.app.f
    public MenuInflater m() {
        MenuInflater gVar;
        Context context;
        if (this.B == null) {
            l0();
            androidx.appcompat.app.a aVar = this.A;
            if (aVar != null) {
                context = aVar.k();
            } else {
                context = this.w;
            }
            gVar = new g(context);
            this.B = gVar;
        }
        return this.B;
    }

    @Override // androidx.appcompat.app.f
    public androidx.appcompat.app.a n() {
        l0();
        return this.A;
    }

    @Override // androidx.appcompat.app.f
    public void o() {
        LayoutInflater from;
        Object factory;
        from = LayoutInflater.from(this.w);
        if (from.getFactory() == null) {
            g.b(from, this);
        } else {
            if (!factory2 instanceof g) {
                Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
            }
        }
    }

    @Override // androidx.appcompat.app.f
    public final View onCreateView(View view, String string2, Context context3, AttributeSet attributeSet4) {
        return W(view, string2, context3, attributeSet4);
    }

    @Override // androidx.appcompat.app.f
    public View onCreateView(String string, Context context2, AttributeSet attributeSet3) {
        return onCreateView(0, string, context2, attributeSet3);
    }

    @Override // androidx.appcompat.app.f
    public void p() {
        androidx.appcompat.app.a aVar;
        aVar = n();
        if (aVar != null && aVar.l()) {
            if (aVar.l()) {
            }
        }
        p0(0);
    }

    @Override // androidx.appcompat.app.f
    public void r(Configuration configuration) {
        boolean z;
        z = n();
        if (this.S && this.M && z != null) {
            if (this.M) {
                z = n();
                if (z != null) {
                    z.m(configuration);
                }
            }
        }
        i.b().g(this.w);
        L(false);
    }

    @Override // androidx.appcompat.app.f
    public boolean r0() {
        return this.L;
    }

    @Override // androidx.appcompat.app.f
    public void s(Bundle bundle) {
        Object obj;
        boolean str;
        final int obj3 = 1;
        this.b0 = obj3;
        L(false);
        c0();
        obj = this.v;
        int i2 = 0;
        if (obj instanceof Activity != null && h.c((Activity)obj) != null) {
            i2 = 0;
            if (h.c((Activity)obj) != null) {
                obj = D0();
                if (obj == null) {
                    this.o0 = obj3;
                } else {
                    obj.r(obj3);
                }
            }
            f.c(this);
        }
        this.c0 = obj3;
    }

    @Override // androidx.appcompat.app.f
    int s0(Context context, int i2) {
        int i;
        int i3;
        int obj4;
        final int i5 = -1;
        if (i2 != -100 && i2 != i5) {
            if (i2 != i5) {
                if (i2 != 0) {
                    if (i2 != 1 && i2 != 2) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                            } else {
                                return g0(context).c();
                            }
                            IllegalStateException obj3 = new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                            throw obj3;
                        }
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= 23 && (UiModeManager)context.getApplicationContext().getSystemService(UiModeManager.class).getNightMode() == 0) {
                        if ((UiModeManager)context.getApplicationContext().getSystemService(UiModeManager.class).getNightMode() == 0) {
                            return i5;
                        }
                    }
                }
                return h0(context).c();
            }
            return i2;
        }
        return i5;
    }

    @Override // androidx.appcompat.app.f
    public void t() {
        boolean decorView;
        g gVar;
        int changingConfigurations;
        Runnable runnable;
        String name;
        int i;
        Integer valueOf;
        if (obj instanceof Activity != null) {
            f.z(this);
        }
        if (this.l0) {
            this.x.getDecorView().removeCallbacks(this.n0);
        }
        this.d0 = false;
        this.e0 = true;
        changingConfigurations = this.v;
        if (this.f0 != -100 && changingConfigurations instanceof Activity != null && (Activity)changingConfigurations.isChangingConfigurations()) {
            changingConfigurations = this.v;
            if (changingConfigurations instanceof Activity != null) {
                if ((Activity)changingConfigurations.isChangingConfigurations()) {
                    g.s0.put(this.v.getClass().getName(), Integer.valueOf(this.f0));
                } else {
                    g.s0.remove(this.v.getClass().getName());
                }
            } else {
            }
        } else {
        }
        androidx.appcompat.app.a aVar = this.A;
        if (aVar != null) {
            aVar.n();
        }
        R();
    }

    @Override // androidx.appcompat.app.f
    boolean t0() {
        androidx.appcompat.app.a aVar;
        b bVar = this.G;
        final int i2 = 1;
        if (bVar != null) {
            bVar.c();
            return i2;
        }
        aVar = n();
        if (aVar != null && aVar.h()) {
            if (aVar.h()) {
                return i2;
            }
        }
        return 0;
    }

    @Override // androidx.appcompat.app.f
    public void u(Bundle bundle) {
        b0();
    }

    @Override // androidx.appcompat.app.f
    boolean u0(int i, KeyEvent keyEvent2) {
        int i2;
        int i3;
        int obj4;
        final int i4 = 0;
        if (i != 4 && i != 82) {
            if (i != 82) {
                return i4;
            }
            v0(i4, keyEvent2);
            return 1;
        }
        if (obj4 &= 128 != 0) {
        } else {
            i3 = i4;
        }
        this.a0 = i3;
    }

    @Override // androidx.appcompat.app.f
    public void v() {
        int i;
        final androidx.appcompat.app.a aVar = n();
        if (aVar != null) {
            aVar.t(true);
        }
    }

    @Override // androidx.appcompat.app.f
    public void w(Bundle bundle) {
    }

    @Override // androidx.appcompat.app.f
    boolean w0(int i, KeyEvent keyEvent2) {
        androidx.appcompat.app.a keyCode2;
        int keyCode;
        int obj4;
        KeyEvent obj5;
        keyCode2 = n();
        final int i3 = 1;
        if (keyCode2 != null && keyCode2.o(i, keyEvent2)) {
            if (keyCode2.o(i, keyEvent2)) {
                return i3;
            }
        }
        obj4 = this.Z;
        obj4 = this.Z;
        if (obj4 != null && E0(obj4, keyEvent2.getKeyCode(), keyEvent2, i3) && obj4 != null) {
            if (E0(obj4, keyEvent2.getKeyCode(), keyEvent2, i3)) {
                obj4 = this.Z;
                if (obj4 != null) {
                    obj4.n = i3;
                }
                return i3;
            }
        }
        int i2 = 0;
        obj4 = i0(i2, i3);
        F0(obj4, keyEvent2);
        obj4.m = i2;
        if (this.Z == null && E0(obj4, keyEvent2.getKeyCode(), keyEvent2, i3)) {
            obj4 = i0(i2, i3);
            F0(obj4, keyEvent2);
            obj4.m = i2;
            if (E0(obj4, keyEvent2.getKeyCode(), keyEvent2, i3)) {
                return i3;
            }
        }
        return i2;
    }

    @Override // androidx.appcompat.app.f
    public void x() {
        this.d0 = true;
        K();
    }

    @Override // androidx.appcompat.app.f
    boolean x0(int i, KeyEvent keyEvent2) {
        int i2;
        int obj4;
        Object obj5;
        final int i3 = 1;
        final int i4 = 0;
        if (i != 4 && i != 82) {
            if (i != 82) {
                return i4;
            }
            y0(i4, keyEvent2);
            return i3;
        }
        this.a0 = i4;
        obj5 = i0(i4, i4);
        if (obj5 != null && obj5.o && !this.a0) {
            if (obj5.o) {
                if (!this.a0) {
                    T(obj5, i3);
                }
                return i3;
            }
        }
        if (t0()) {
            return i3;
        }
    }

    @Override // androidx.appcompat.app.f
    public void y() {
        final int i = 0;
        this.d0 = i;
        final androidx.appcompat.app.a aVar = n();
        if (aVar != null) {
            aVar.t(i);
        }
    }

    @Override // androidx.appcompat.app.f
    void z0(int i) {
        int i2;
        int obj2;
        obj2 = n();
        if (i == 108 && obj2 != null) {
            obj2 = n();
            if (obj2 != null) {
                obj2.i(true);
            }
        }
    }
}
