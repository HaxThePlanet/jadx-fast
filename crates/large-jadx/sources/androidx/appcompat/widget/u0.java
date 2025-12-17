package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.a;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.view.menu.m.a;
import d.a.a;
import d.a.e;
import d.a.f;
import d.a.h;
import d.a.j;
import d.a.k.a.a;
import d.h.l.b0;
import d.h.l.u;
import d.h.l.z;

/* loaded from: classes.dex */
public class u0 implements androidx.appcompat.widget.z {

    androidx.appcompat.widget.Toolbar a;
    private int b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    java.lang.CharSequence i;
    private java.lang.CharSequence j;
    private java.lang.CharSequence k;
    Window.Callback l;
    boolean m;
    private androidx.appcompat.widget.c n;
    private int o;
    private int p;
    private Drawable q;

    class a implements View.OnClickListener {

        final a a;
        final androidx.appcompat.widget.u0 b;
        a(androidx.appcompat.widget.u0 u0) {
            this.b = u0;
            super();
            super(u0.a.getContext(), 0, 16908332, 0, 0, u0.i);
            this.a = aVar2;
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            a aVar;
            androidx.appcompat.widget.u0 obj3;
            obj3 = this.b;
            final Window.Callback callback = obj3.l;
            if (callback != null && obj3.m) {
                if (obj3.m) {
                    callback.onMenuItemSelected(0, this.a);
                }
            }
        }
    }

    class b extends b0 {

        private boolean a = false;
        final int b;
        final androidx.appcompat.widget.u0 c;
        b(androidx.appcompat.widget.u0 u0, int i2) {
            this.c = u0;
            this.b = i2;
            super();
            final int obj1 = 0;
        }

        @Override // d.h.l.b0
        public void a(View view) {
            this.a = true;
        }

        @Override // d.h.l.b0
        public void b(View view) {
            int i;
            boolean obj2;
            if (!this.a) {
                obj2.a.setVisibility(this.b);
            }
        }

        @Override // d.h.l.b0
        public void c(View view) {
            obj2.a.setVisibility(0);
        }
    }
    public u0(androidx.appcompat.widget.Toolbar toolbar, boolean z2) {
        super(toolbar, z2, h.a, e.n);
    }

    public u0(androidx.appcompat.widget.Toolbar toolbar, boolean z2, int i3, int i4) {
        int i;
        boolean layoutParams;
        int drawable;
        int[] context;
        Drawable obj5;
        int obj7;
        super();
        obj7 = 0;
        this.o = obj7;
        this.p = obj7;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        i = this.i != null ? 1 : obj7;
        this.h = i;
        this.g = toolbar.getNavigationIcon();
        androidx.appcompat.widget.t0 obj4 = t0.v(toolbar.getContext(), 0, j.a, a.c, obj7);
        this.q = obj4.g(j.l);
        if (z2) {
            obj5 = obj4.p(j.r);
            if (!TextUtils.isEmpty(obj5)) {
                setTitle(obj5);
            }
            obj5 = obj4.p(j.p);
            if (!TextUtils.isEmpty(obj5)) {
                E(obj5);
            }
            obj5 = obj4.g(j.n);
            if (obj5 != null) {
                A(obj5);
            }
            obj5 = obj4.g(j.m);
            if (obj5 != null) {
                setIcon(obj5);
            }
            obj5 = this.q;
            if (this.g == null && obj5 != null) {
                obj5 = this.q;
                if (obj5 != null) {
                    D(obj5);
                }
            }
            k(obj4.k(j.h, obj7));
            obj5 = obj4.n(j.g, obj7);
            if (obj5 != null) {
                y(LayoutInflater.from(this.a.getContext()).inflate(obj5, this.a, obj7));
                k(obj5 |= 16);
            }
            obj5 = obj4.m(j.j, obj7);
            if (obj5 > 0) {
                layoutParams = this.a.getLayoutParams();
                layoutParams.height = obj5;
                this.a.setLayoutParams(layoutParams);
            }
            int i6 = -1;
            obj5 = obj4.e(j.f, i6);
            drawable = obj4.e(j.e, i6);
            if (obj5 < 0) {
                if (drawable >= 0) {
                    this.a.H(Math.max(obj5, obj7), Math.max(drawable, obj7));
                }
            } else {
            }
            obj5 = obj4.n(j.s, obj7);
            if (obj5 != null) {
                drawable = this.a;
                drawable.L(drawable.getContext(), obj5);
            }
            obj5 = obj4.n(j.q, obj7);
            if (obj5 != null) {
                drawable = this.a;
                drawable.K(drawable.getContext(), obj5);
            }
            obj5 = obj4.n(j.o, obj7);
            if (obj5 != null) {
                this.a.setPopupTheme(obj5);
            }
        } else {
            this.b = x();
        }
        obj4.w();
        z(i3);
        this.k = this.a.getNavigationContentDescription();
        obj5 = new u0.a(this);
        this.a.setNavigationOnClickListener(obj5);
    }

    private void F(java.lang.CharSequence charSequence) {
        int i;
        this.i = charSequence;
        if (i2 &= 8 != 0) {
            this.a.setTitle(charSequence);
        }
    }

    private void G() {
        int i;
        java.lang.CharSequence charSequence;
        if (i2 &= 4 != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.k);
            }
        }
    }

    private void H() {
        androidx.appcompat.widget.Toolbar toolbar;
        Drawable i;
        if (i2 &= 4 != 0) {
            if (this.g != null) {
            } else {
                i = this.q;
            }
            this.a.setNavigationIcon(i);
        } else {
            this.a.setNavigationIcon(0);
        }
    }

    private void I() {
        int i;
        int i2 = this.b;
        if (i2 & 2 != 0) {
            if (i2 &= 1 != 0) {
                if (this.f != null) {
                } else {
                    i = this.e;
                }
            } else {
                i = this.e;
            }
        } else {
            i = 0;
        }
        this.a.setLogo(i);
    }

    private int x() {
        int i;
        Drawable navigationIcon;
        if (this.a.getNavigationIcon() != null) {
            i = 15;
            this.q = this.a.getNavigationIcon();
        } else {
            i = 11;
        }
        return i;
    }

    @Override // androidx.appcompat.widget.z
    public void A(Drawable drawable) {
        this.f = drawable;
        I();
    }

    @Override // androidx.appcompat.widget.z
    public void B(int i) {
        Context context;
        int obj2;
        if (i == 0) {
            obj2 = 0;
        } else {
            obj2 = getContext().getString(i);
        }
        C(obj2);
    }

    @Override // androidx.appcompat.widget.z
    public void C(java.lang.CharSequence charSequence) {
        this.k = charSequence;
        G();
    }

    @Override // androidx.appcompat.widget.z
    public void D(Drawable drawable) {
        this.g = drawable;
        H();
    }

    @Override // androidx.appcompat.widget.z
    public void E(java.lang.CharSequence charSequence) {
        int i;
        this.j = charSequence;
        if (i2 &= 8 != 0) {
            this.a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.z
    public void a(Menu menu, m.a m$a2) {
        androidx.appcompat.widget.c cVar;
        int i;
        if (this.n == null) {
            cVar = new c(this.a.getContext());
            this.n = cVar;
            cVar.r(f.g);
        }
        this.n.h(a2);
        this.a.I((g)menu, this.n);
    }

    @Override // androidx.appcompat.widget.z
    public boolean b() {
        return this.a.A();
    }

    @Override // androidx.appcompat.widget.z
    public void c() {
        this.m = true;
    }

    @Override // androidx.appcompat.widget.z
    public void collapseActionView() {
        this.a.e();
    }

    @Override // androidx.appcompat.widget.z
    public boolean d() {
        return this.a.d();
    }

    @Override // androidx.appcompat.widget.z
    public boolean e() {
        return this.a.z();
    }

    @Override // androidx.appcompat.widget.z
    public boolean f() {
        return this.a.w();
    }

    @Override // androidx.appcompat.widget.z
    public boolean g() {
        return this.a.O();
    }

    @Override // androidx.appcompat.widget.z
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.widget.z
    public java.lang.CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // androidx.appcompat.widget.z
    public void h() {
        this.a.f();
    }

    @Override // androidx.appcompat.widget.z
    public void i(androidx.appcompat.widget.m0 m0) {
        Object parent;
        androidx.appcompat.widget.Toolbar toolbar;
        parent = this.c;
        toolbar = this.a;
        if (parent != null && parent.getParent() == toolbar) {
            toolbar = this.a;
            if (parent.getParent() == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = m0;
        if (m0 != null && this.o == 2) {
            if (this.o == 2) {
                this.a.addView(m0, 0);
                android.view.ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                int i2 = -2;
                layoutParams.width = i2;
                layoutParams.height = i2;
                layoutParams.a = 8388691;
                m0.setAllowCollapse(true);
            }
        }
    }

    @Override // androidx.appcompat.widget.z
    public boolean j() {
        return this.a.v();
    }

    @Override // androidx.appcompat.widget.z
    public void k(int i) {
        int i3;
        int i4;
        int i2;
        java.lang.CharSequence charSequence;
        int obj4;
        i5 ^= i;
        this.b = i;
        if (i3 != 0 && i3 & 4 != 0 && i & 4 != 0) {
            if (i3 & 4 != 0) {
                if (i & 4 != 0) {
                    G();
                }
                H();
            }
            if (i3 & 3 != 0) {
                I();
            }
            if (i3 & 8 != 0) {
                if (i & 8 != 0) {
                    this.a.setTitle(this.i);
                    this.a.setSubtitle(this.j);
                } else {
                    charSequence = 0;
                    this.a.setTitle(charSequence);
                    this.a.setSubtitle(charSequence);
                }
            }
            i3 = this.d;
            if (i3 &= 16 != 0 && i3 != null) {
                i3 = this.d;
                if (i3 != null) {
                    if (i &= 16 != 0) {
                        this.a.addView(i3);
                    } else {
                        this.a.removeView(i3);
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.z
    public Menu l() {
        return this.a.getMenu();
    }

    @Override // androidx.appcompat.widget.z
    public void m(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            obj2 = a.d(getContext(), i);
        } else {
            obj2 = 0;
        }
        A(obj2);
    }

    @Override // androidx.appcompat.widget.z
    public int n() {
        return this.o;
    }

    @Override // androidx.appcompat.widget.z
    public z o(int i, long l2) {
        int i2;
        z zVar = u.d(this.a);
        i2 = i == 0 ? 1065353216 : 0;
        zVar.a(i2);
        zVar.e(l2);
        u0.b obj4 = new u0.b(this, i);
        zVar.g(obj4);
        return zVar;
    }

    @Override // androidx.appcompat.widget.z
    public void p(m.a m$a, g.a g$a2) {
        this.a.J(a, a2);
    }

    @Override // androidx.appcompat.widget.z
    public void q(int i) {
        this.a.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.z
    public ViewGroup r() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.z
    public void s(boolean z) {
    }

    @Override // androidx.appcompat.widget.z
    public void setIcon(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            obj2 = a.d(getContext(), i);
        } else {
            obj2 = 0;
        }
        setIcon(obj2);
    }

    @Override // androidx.appcompat.widget.z
    public void setIcon(Drawable drawable) {
        this.e = drawable;
        I();
    }

    @Override // androidx.appcompat.widget.z
    public void setTitle(java.lang.CharSequence charSequence) {
        this.h = true;
        F(charSequence);
    }

    @Override // androidx.appcompat.widget.z
    public void setWindowCallback(Window.Callback window$Callback) {
        this.l = callback;
    }

    @Override // androidx.appcompat.widget.z
    public void setWindowTitle(java.lang.CharSequence charSequence) {
        if (!this.h) {
            F(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.z
    public int t() {
        return this.b;
    }

    @Override // androidx.appcompat.widget.z
    public void u() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.z
    public void v() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.z
    public void w(boolean z) {
        this.a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.z
    public void y(View view) {
        View view2;
        int i;
        view2 = this.d;
        if (view2 != null && i3 &= 16 != 0) {
            if (i3 &= 16 != 0) {
                this.a.removeView(view2);
            }
        }
        this.d = view;
        if (view != null && i2 &= 16 != 0) {
            if (i2 &= 16 != 0) {
                this.a.addView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.z
    public void z(int i) {
        boolean obj2;
        if (i == this.p) {
        }
        this.p = i;
        if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
            B(this.p);
        }
    }
}
