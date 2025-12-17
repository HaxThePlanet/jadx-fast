package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionBarOverlayLayout.d;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.m0;
import androidx.appcompat.widget.z;
import d.a.a;
import d.a.f;
import d.a.j;
import d.a.o.a;
import d.a.o.b;
import d.a.o.b.a;
import d.a.o.g;
import d.a.o.h;
import d.h.l.a0;
import d.h.l.b0;
import d.h.l.c0;
import d.h.l.u;
import d.h.l.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class o extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {

    private static final Interpolator B;
    private static final Interpolator C;
    final c0 A;
    Context a;
    private Context b;
    ActionBarOverlayLayout c;
    ActionBarContainer d;
    z e;
    ActionBarContextView f;
    View g;
    m0 h;
    private boolean i;
    androidx.appcompat.app.o.d j;
    b k;
    b.a l;
    private boolean m;
    private ArrayList<androidx.appcompat.app.a.b> n;
    private boolean o;
    private int p = 0;
    boolean q = true;
    boolean r;
    boolean s;
    private boolean t;
    private boolean u = true;
    h v;
    private boolean w;
    boolean x;
    final a0 y;
    final a0 z;

    class c implements c0 {

        final androidx.appcompat.app.o a;
        c(androidx.appcompat.app.o o) {
            this.a = o;
            super();
        }

        @Override // d.h.l.c0
        public void a(View view) {
            (View)obj1.d.getParent().invalidate();
        }
    }

    public class d extends b implements g.a {

        private final Context c;
        private final g v;
        private b.a w;
        private WeakReference<View> x;
        final androidx.appcompat.app.o y;
        public d(androidx.appcompat.app.o o, Context context2, b.a b$a3) {
            this.y = o;
            super();
            this.c = context2;
            this.w = a3;
            g obj1 = new g(context2);
            obj1.W(1);
            this.v = obj1;
            obj1.V(this);
        }

        @Override // d.a.o.b
        public boolean a(g g, MenuItem menuItem2) {
            b.a obj1 = this.w;
            if (obj1 != null) {
                return obj1.d(this, menuItem2);
            }
            return 0;
        }

        @Override // d.a.o.b
        public void b(g g) {
            if (this.w == null) {
            }
            k();
            obj1.f.l();
        }

        @Override // d.a.o.b
        public void c() {
            Object oVar;
            b.a z;
            androidx.appcompat.app.o oVar2 = this.y;
            if (oVar2.j != this) {
            }
            int i2 = 0;
            if (!o.y(oVar2.r, oVar2.s, i2)) {
                oVar = this.y;
                oVar.k = this;
                oVar.l = this.w;
            } else {
                this.w.a(this);
            }
            int i = 0;
            this.w = i;
            this.y.x(i2);
            oVar4.f.g();
            oVar5.e.r().sendAccessibilityEvent(32);
            androidx.appcompat.app.o oVar6 = this.y;
            oVar6.c.setHideOnContentScrollEnabled(oVar6.x);
            oVar7.j = i;
        }

        @Override // d.a.o.b
        public View d() {
            Object obj;
            WeakReference weakReference = this.x;
            if (weakReference != null) {
                obj = weakReference.get();
            } else {
                obj = 0;
            }
            return obj;
        }

        @Override // d.a.o.b
        public Menu e() {
            return this.v;
        }

        @Override // d.a.o.b
        public MenuInflater f() {
            g gVar = new g(this.c);
            return gVar;
        }

        @Override // d.a.o.b
        public java.lang.CharSequence g() {
            return oVar.f.getSubtitle();
        }

        @Override // d.a.o.b
        public java.lang.CharSequence i() {
            return oVar.f.getTitle();
        }

        @Override // d.a.o.b
        public void k() {
            if (oVar.j != this) {
            }
            this.v.h0();
            this.w.c(this, this.v);
            this.v.g0();
        }

        @Override // d.a.o.b
        public boolean l() {
            return oVar.f.j();
        }

        @Override // d.a.o.b
        public void m(View view) {
            oVar.f.setCustomView(view);
            WeakReference weakReference = new WeakReference(view);
            this.x = weakReference;
        }

        @Override // d.a.o.b
        public void n(int i) {
            o(oVar.a.getResources().getString(i));
        }

        @Override // d.a.o.b
        public void o(java.lang.CharSequence charSequence) {
            oVar.f.setSubtitle(charSequence);
        }

        @Override // d.a.o.b
        public void q(int i) {
            r(oVar.a.getResources().getString(i));
        }

        @Override // d.a.o.b
        public void r(java.lang.CharSequence charSequence) {
            oVar.f.setTitle(charSequence);
        }

        @Override // d.a.o.b
        public void s(boolean z) {
            super.s(z);
            oVar.f.setTitleOptional(z);
        }

        @Override // d.a.o.b
        public boolean t() {
            this.v.h0();
            this.v.g0();
            return this.w.b(this, this.v);
        }
    }

    class a extends b0 {

        final androidx.appcompat.app.o a;
        a(androidx.appcompat.app.o o) {
            this.a = o;
            super();
        }

        @Override // d.h.l.b0
        public void b(View view) {
            boolean z;
            Object obj2;
            obj2 = this.a;
            obj2 = obj2.g;
            if (obj2.q && obj2 != null) {
                obj2 = obj2.g;
                if (obj2 != null) {
                    z = 0;
                    obj2.setTranslationY(z);
                    obj2.d.setTranslationY(z);
                }
            }
            obj2.d.setVisibility(8);
            obj2.d.setTransitioning(false);
            obj2 = this.a;
            obj2.v = 0;
            obj2.z();
            obj2 = obj2.c;
            if (obj2 != null) {
                u.i0(obj2);
            }
        }
    }

    class b extends b0 {

        final androidx.appcompat.app.o a;
        b(androidx.appcompat.app.o o) {
            this.a = o;
            super();
        }

        @Override // d.h.l.b0
        public void b(View view) {
            androidx.appcompat.app.o obj2 = this.a;
            obj2.v = 0;
            obj2.d.requestLayout();
        }
    }
    static {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        o.B = accelerateInterpolator;
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        o.C = decelerateInterpolator;
    }

    public o(Activity activity, boolean z2) {
        View obj2;
        int obj3;
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.n = arrayList2;
        int i = 0;
        int i2 = 1;
        o.a aVar = new o.a(this);
        this.y = aVar;
        o.b bVar = new o.b(this);
        this.z = bVar;
        o.c cVar = new o.c(this);
        this.A = cVar;
        obj2 = activity.getWindow().getDecorView();
        F(obj2);
        if (z2 == 0) {
            this.g = obj2.findViewById(16908290);
        }
    }

    public o(Dialog dialog) {
        super();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.n = arrayList2;
        int i = 0;
        int i2 = 1;
        o.a aVar = new o.a(this);
        this.y = aVar;
        o.b bVar = new o.b(this);
        this.z = bVar;
        o.c cVar = new o.c(this);
        this.A = cVar;
        F(dialog.getWindow().getDecorView());
    }

    private z C(View view) {
        String obj4;
        if (view instanceof z) {
            return (z)view;
        }
        if (view instanceof Toolbar) {
            return (Toolbar)view.getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        if (view != null) {
            obj4 = view.getClass().getSimpleName();
        } else {
            obj4 = "null";
        }
        stringBuilder.append(obj4);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    private void E() {
        boolean z;
        ActionBarOverlayLayout actionBarOverlayLayout;
        z = 0;
        this.t = z;
        actionBarOverlayLayout = this.c;
        if (this.t && actionBarOverlayLayout != null) {
            z = 0;
            this.t = z;
            actionBarOverlayLayout = this.c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(z);
            }
            N(z);
        }
    }

    private void F(View view) {
        int dimensionPixelSize;
        ActionBarContextView context;
        int obj6;
        View viewById = view.findViewById(f.p);
        this.c = (ActionBarOverlayLayout)viewById;
        if (viewById != null) {
            viewById.setActionBarVisibilityCallback(this);
        }
        this.e = C(view.findViewById(f.a));
        this.f = (ActionBarContextView)view.findViewById(f.f);
        obj6 = view.findViewById(f.c);
        this.d = (ActionBarContainer)obj6;
        z zVar2 = this.e;
        if (zVar2 == null) {
        } else {
            if (this.f == null) {
            } else {
                if (obj6 == null) {
                } else {
                    this.a = zVar2.getContext();
                    int i5 = 1;
                    int i7 = 0;
                    obj6 = obj6 &= 4 != 0 ? i5 : i7;
                    if (obj6 != null) {
                        this.i = i5;
                    }
                    a aVar = a.b(this.a);
                    if (!aVar.a()) {
                        if (obj6 != null) {
                            obj6 = i5;
                        } else {
                            obj6 = i7;
                        }
                    } else {
                    }
                    K(obj6);
                    I(aVar.g());
                    obj6 = this.a.obtainStyledAttributes(0, j.a, a.c, i7);
                    if (obj6.getBoolean(j.k, i7)) {
                        J(i5);
                    }
                    dimensionPixelSize = obj6.getDimensionPixelSize(j.i, i7);
                    if (dimensionPixelSize != 0) {
                        H((float)dimensionPixelSize);
                    }
                    obj6.recycle();
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o.class.getSimpleName());
        stringBuilder.append(" can only be used with a compatible window decor layout");
        obj6 = new IllegalStateException(stringBuilder.toString());
        throw obj6;
    }

    private void I(boolean z) {
        m0 m0Var;
        Object m0Var2;
        int i;
        int i2;
        int i3;
        Object obj5;
        this.o = z;
        int i4 = 0;
        if (!z) {
            this.e.i(i4);
            this.d.setTabContainer(this.h);
        } else {
            this.d.setTabContainer(i4);
            this.e.i(this.h);
        }
        i = 1;
        final int i6 = 0;
        obj5 = D() == 2 ? i : i6;
        m0Var2 = this.h;
        if (m0Var2 != null) {
            if (obj5 != null) {
                m0Var2.setVisibility(i6);
                m0Var2 = this.c;
                if (m0Var2 != null) {
                    u.i0(m0Var2);
                }
            } else {
                m0Var2.setVisibility(8);
            }
        }
        if (!this.o && obj5 != null) {
            i3 = obj5 != null ? i : i6;
        } else {
        }
        this.e.w(i3);
        if (!this.o && obj5 != null) {
            if (obj5 != null) {
            } else {
                i = i6;
            }
        } else {
        }
        this.c.setHasNonEmbeddedTabs(i);
    }

    private boolean L() {
        return u.R(this.d);
    }

    private void M() {
        boolean z;
        ActionBarOverlayLayout actionBarOverlayLayout;
        int i = 1;
        this.t = i;
        actionBarOverlayLayout = this.c;
        if (!this.t && actionBarOverlayLayout != null) {
            i = 1;
            this.t = i;
            actionBarOverlayLayout = this.c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(i);
            }
            N(false);
        }
    }

    private void N(boolean z) {
        boolean z2;
        if (o.y(this.r, this.s, this.t)) {
            if (!this.u) {
                this.u = true;
                B(z);
            }
        } else {
            if (this.u) {
                this.u = false;
                A(z);
            }
        }
    }

    static boolean y(boolean z, boolean z2, boolean z3) {
        final int i = 1;
        if (z3) {
            return i;
        }
        if (!z && z2) {
            if (z2) {
            }
            return i;
        }
        return 0;
    }

    @Override // androidx.appcompat.app.a
    public void A(boolean z) {
        int i2;
        int hVar;
        int i;
        float f;
        ActionBarContainer actionBarContainer;
        float obj5;
        h hVar2 = this.v;
        if (hVar2 != null) {
            hVar2.a();
        }
        if (this.p == 0) {
            if (!this.w) {
                if (z != 0) {
                    this.d.setAlpha(1065353216);
                    int i4 = 1;
                    this.d.setTransitioning(i4);
                    hVar = new h();
                    if (z != 0) {
                        obj5 = new int[2];
                        obj5 = new int[]{0, 0};
                        this.d.getLocationInWindow(obj5);
                        f -= obj5;
                    }
                    obj5 = u.d(this.d);
                    obj5.l(f);
                    obj5.j(this.A);
                    hVar.c(obj5);
                    obj5 = this.g;
                    if (this.q && obj5 != null) {
                        obj5 = this.g;
                        if (obj5 != null) {
                            obj5 = u.d(obj5);
                            obj5.l(f);
                            hVar.c(obj5);
                        }
                    }
                    hVar.f(o.B);
                    hVar.e(250);
                    hVar.g(this.y);
                    this.v = hVar;
                    hVar.h();
                } else {
                    this.y.b(0);
                }
            } else {
            }
        } else {
        }
    }

    @Override // androidx.appcompat.app.a
    public void B(boolean z) {
        int i3;
        float i2;
        int i;
        int i4;
        c0 c0Var;
        boolean obj5;
        h hVar = this.v;
        if (hVar != null) {
            hVar.a();
        }
        this.d.setVisibility(0);
        int i9 = 0;
        if (this.p == 0) {
            if (!this.w) {
                if (z != 0) {
                    this.d.setTranslationY(i9);
                    if (z != 0) {
                        obj5 = new int[2];
                        obj5 = new int[]{0, 0};
                        this.d.getLocationInWindow(obj5);
                        i2 -= obj5;
                    }
                    this.d.setTranslationY(i2);
                    obj5 = new h();
                    z zVar = u.d(this.d);
                    zVar.l(i9);
                    zVar.j(this.A);
                    obj5.c(zVar);
                    i4 = this.g;
                    if (this.q && i4 != null) {
                        i4 = this.g;
                        if (i4 != null) {
                            i4.setTranslationY(i2);
                            i2 = u.d(this.g);
                            i2.l(i9);
                            obj5.c(i2);
                        }
                    }
                    obj5.f(o.C);
                    obj5.e(250);
                    obj5.g(this.z);
                    this.v = obj5;
                    obj5.h();
                } else {
                    this.d.setAlpha(1065353216);
                    this.d.setTranslationY(i9);
                    obj5 = this.g;
                    if (this.q && obj5 != null) {
                        obj5 = this.g;
                        if (obj5 != null) {
                            obj5.setTranslationY(i9);
                        }
                    }
                    this.z.b(0);
                }
            } else {
            }
        } else {
        }
        obj5 = this.c;
        if (obj5 != null) {
            u.i0(obj5);
        }
    }

    @Override // androidx.appcompat.app.a
    public int D() {
        return this.e.n();
    }

    @Override // androidx.appcompat.app.a
    public void G(int i, int i2) {
        int i3;
        if (i2 & 4 != 0) {
            this.i = true;
        }
        this.e.k(obj3 |= obj4);
    }

    @Override // androidx.appcompat.app.a
    public void H(float f) {
        u.s0(this.d, f);
    }

    @Override // androidx.appcompat.app.a
    public void J(boolean z) {
        boolean z2;
        if (z) {
            if (!this.c.q()) {
            } else {
            }
            IllegalStateException obj2 = new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            throw obj2;
        }
        this.x = z;
        this.c.setHideOnContentScrollEnabled(z);
    }

    @Override // androidx.appcompat.app.a
    public void K(boolean z) {
        this.e.s(z);
    }

    @Override // androidx.appcompat.app.a
    public void a() {
        boolean z;
        if (this.s) {
            this.s = false;
            N(true);
        }
    }

    @Override // androidx.appcompat.app.a
    public void b() {
    }

    @Override // androidx.appcompat.app.a
    public void c(boolean z) {
        this.q = z;
    }

    @Override // androidx.appcompat.app.a
    public void d() {
        boolean z;
        if (!this.s) {
            z = 1;
            this.s = z;
            N(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public void e() {
        h hVar;
        hVar = this.v;
        if (hVar != null) {
            hVar.a();
            this.v = 0;
        }
    }

    @Override // androidx.appcompat.app.a
    public void f(int i) {
        this.p = i;
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        z zVar;
        zVar = this.e;
        if (zVar != null && zVar.j()) {
            if (zVar.j()) {
                this.e.collapseActionView();
                return 1;
            }
        }
        return 0;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        int i;
        Object obj;
        if (z == this.m) {
        }
        this.m = z;
        i = 0;
        while (i < this.n.size()) {
            (a.b)this.n.get(i).a(z);
            i++;
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.e.t();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        Context resourceId;
        Object contextThemeWrapper;
        int i2;
        int i;
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(a.g, typedValue, true);
            resourceId = typedValue.resourceId;
            if (resourceId != 0) {
                contextThemeWrapper = new ContextThemeWrapper(this.a, resourceId);
                this.b = contextThemeWrapper;
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        I(a.b(this.a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent2) {
        int deviceId;
        int i2;
        androidx.appcompat.app.o.d dVar = this.j;
        final int i3 = 0;
        if (dVar == null) {
            return i3;
        }
        Menu menu = dVar.e();
        if (menu != null) {
            if (keyEvent2 != null) {
                deviceId = keyEvent2.getDeviceId();
            } else {
                deviceId = -1;
            }
            if (KeyCharacterMap.load(deviceId).getKeyboardType() != 1) {
            } else {
                i2 = i3;
            }
            menu.setQwertyMode(i2);
            return menu.performShortcut(i, keyEvent2, i3);
        }
        return i3;
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
        if (!this.i) {
            s(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        int obj2;
        final int i = 4;
        obj2 = z ? i : 0;
        G(obj2, i);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z) {
        boolean obj1;
        this.w = z;
        obj1 = this.v;
        if (!z && obj1 != null) {
            obj1 = this.v;
            if (obj1 != null) {
                obj1.a();
            }
        }
    }

    @Override // androidx.appcompat.app.a
    public void u(java.lang.CharSequence charSequence) {
        this.e.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void v(java.lang.CharSequence charSequence) {
        this.e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public b w(b.a b$a) {
        androidx.appcompat.app.o.d dVar = this.j;
        if (dVar != null) {
            dVar.c();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f.k();
        o.d dVar2 = new o.d(this, this.f.getContext(), a);
        if (dVar2.t()) {
            this.j = dVar2;
            dVar2.k();
            this.f.h(dVar2);
            x(true);
            this.f.sendAccessibilityEvent(32);
            return dVar2;
        }
        return null;
    }

    @Override // androidx.appcompat.app.a
    public void x(boolean z) {
        boolean z2;
        int hVar;
        int i;
        int i2;
        Object obj9;
        if (z) {
            M();
        } else {
            E();
        }
        hVar = 4;
        final int i3 = 8;
        final int i4 = 0;
        if (L()) {
            i = 100;
            i2 = 200;
            if (z) {
                obj9 = this.e.o(hVar, i);
                z2 = this.f.f(i4, i2);
            } else {
                z2 = this.e.o(i4, i2);
                obj9 = this.f.f(i3, i);
            }
            hVar = new h();
            hVar.d(obj9, z2);
            hVar.h();
        } else {
            if (z) {
                this.e.q(hVar);
                this.f.setVisibility(i4);
            } else {
                this.e.q(i4);
                this.f.setVisibility(i3);
            }
        }
    }

    @Override // androidx.appcompat.app.a
    void z() {
        b.a aVar;
        b bVar;
        aVar = this.l;
        if (aVar != null) {
            aVar.a(this.k);
            aVar = 0;
            this.k = aVar;
            this.l = aVar;
        }
    }
}
