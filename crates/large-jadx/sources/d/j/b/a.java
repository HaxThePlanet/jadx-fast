package d.j.b;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import d.e.h;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.e0.d;
import d.h.l.e0.e;
import d.h.l.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExploreByTouchHelper.java */
/* loaded from: classes.dex */
public abstract class a extends a {

    private static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final b.a<c> o = new a$a<>();
    private static final b.b<h<c>, c> p = new a$b<>();
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private final Rect f = new Rect();
    private final int[] g;
    private final AccessibilityManager h;
    private final View i;
    private a.c j;
    int k = Integer.MIN_VALUE;
    int l = Integer.MIN_VALUE;
    private int m = Integer.MIN_VALUE;

    class a implements b.a<c> {
        a() {
            super();
        }

        public void b(c cVar, Rect rect) {
            cVar.l(rect);
        }
    }

    class b implements b.b<h<c>, c> {
        b() {
            super();
        }

        public c c(h<c> hVar, int i) {
            return (c)hVar.l(i);
        }

        public int d(h<c> hVar) {
            return hVar.k();
        }
    }

    private class c extends d {

        final /* synthetic */ a b;
        c() {
            this.b = aVar;
            super();
        }

        @Override // d.h.l.e0.d
        public c b(int i) {
            return c.M(this.b.H(i));
        }

        @Override // d.h.l.e0.d
        public c d(int i) {
            int i2;
            i2 = i == 2 ? aVar.k : aVar2.l;
            if (i2 == -2147483648) {
                return null;
            }
            return b(i2);
        }

        @Override // d.h.l.e0.d
        public boolean f(int i, int i2, Bundle bundle) {
            return this.b.P(i, i2, bundle);
        }
    }

    public a(View view) {
        super();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        this.g = new int[2];
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        } else {
            this.i = view;
            this.h = (AccessibilityManager)view.getContext().getSystemService("accessibility");
            boolean z = true;
            view.setFocusable(z);
            if (u.z(view) == 0) {
                u.v0(view, z);
            }
            return;
        }
    }

    private static Rect D(View view, int i, Rect rect) {
        final int width = view.getWidth();
        int height = view.getHeight();
        i = 17;
        final int i4 = 0;
        if (i != 17) {
            i = 33;
            if (i != 33) {
                i = 66;
                int i3 = -1;
                if (i != 66) {
                    height = 130;
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    } else {
                        rect.set(i4, i3, width, i3);
                    }
                }
                rect.set(i3, i4, i3, height);
            } else {
                rect.set(i4, height, width, height);
            }
        } else {
            rect.set(width, i4, width, height);
        }
        return rect;
    }

    private boolean E(Rect rect) {
        boolean z = false;
        float f = 0;
        ViewParent parent;
        z = false;
        return z;
    }

    private boolean G(int i, Rect rect) {
        int i2 = 0;
        boolean z;
        int i7 = -2147483648;
        Object obj;
        int rect22 = 0;
        View view;
        final h hVar = y();
        i7 = Integer.MIN_VALUE;
        i2 = this.l == Integer.MIN_VALUE ? 0 : (c)obj2;
        final Object obj3 = i2;
        int i3 = 1;
        if (i == i3 || i == 2) {
            i3 = u.B(this.i) == i3 ? i3 : rect22;
            boolean z2 = false;
            obj = b.d(hVar, a.p, a.o, obj3, i, z, z2);
        } else {
            int i4 = 17;
            if (i != 17 && i != 33 && i != 66) {
                i4 = 130;
                if (i != 130) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }
            rect = new Rect();
            if (this.l != Integer.MIN_VALUE) {
                z(this.l, rect);
            } else {
                if (this.i != null) {
                    rect.set(rect);
                } else {
                    a.D(this.i, i, rect);
                }
            }
            obj = b.c(hVar, a.p, a.o, obj3, rect, i);
        }
        if (obj != null) {
            i7 = hVar.h(hVar.g(obj));
        }
        return T(i7);
    }

    private boolean Q(int i, int i2, Bundle bundle) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 64 && i2 != 128) {
                return J(i, i2, bundle);
            }
            return S(i);
        }
        return T(i);
    }

    private boolean R(int i, Bundle bundle) {
        return u.b0(this.i, i, bundle);
    }

    private boolean S(int i) {
        if (this.h.isEnabled()) {
            if (this.h.isTouchExplorationEnabled()) {
                if (this.k != i && this.k != -2147483648) {
                    n(this.k);
                    this.k = i;
                    this.i.invalidate();
                    U(i, 32768);
                    return true;
                }
            }
        }
        return false;
    }

    private void V(int i) {
        if (this.m == i) {
            return;
        }
        this.m = i;
        U(i, 128);
        U(this.m, 256);
    }

    private boolean n(int i) {
        if (this.k == i) {
            this.k = Integer.MIN_VALUE;
            this.i.invalidate();
            U(i, 65536);
            return true;
        }
        return false;
    }

    private boolean p() {
        boolean z2 = false;
        int i2 = -2147483648;
        Bundle bundle = null;
        i2 = Integer.MIN_VALUE;
        if (this.l != Integer.MIN_VALUE) {
            i2 = 16;
            bundle = null;
            int r0 = J(this.l, i2, bundle) ? 1 : 0;
        }
        return (J(this.l, i2, bundle) ? 1 : 0);
    }

    private AccessibilityEvent q(int i, int i2) {
        if (i != -1) {
            return r(i, i2);
        }
        return s(i2);
    }

    private AccessibilityEvent r(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        c cVar = H(i);
        obtain.getText().add(cVar.v());
        obtain.setContentDescription(cVar.q());
        obtain.setScrollable(cVar.H());
        obtain.setPassword(cVar.G());
        obtain.setEnabled(cVar.C());
        obtain.setChecked(cVar.A());
        L(i, obtain);
        obtain.setClassName(cVar.o());
        e.c(obtain, this.i, i);
        obtain.setPackageName(this.i.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent s(int i) {
        final AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private c t(int i) {
        int i3;
        int[] iArr;
        int scrollY = 128;
        int left2;
        boolean z;
        c cVar = c.K();
        z = true;
        cVar.d0(z);
        cVar.f0(z);
        cVar.X("android.view.View");
        rect = a.n;
        cVar.T(rect);
        cVar.U(rect);
        cVar.m0(this.i);
        N(i, cVar);
        if (cVar.v() == null) {
            if (cVar.q() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            }
        }
        cVar.l(this.e);
        if (this.e.equals(a.n)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        } else {
            int i10 = cVar.j();
            if (i10 & 64 != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else {
                scrollY = 128;
                if (i10 & scrollY != 0) {
                    throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
                } else {
                    cVar.k0(this.i.getContext().getPackageName());
                    cVar.s0(this.i, i);
                    z = false;
                    if (this.k == i) {
                        cVar.R(z);
                        cVar.a(scrollY);
                    } else {
                        cVar.R(z);
                        int i2 = 64;
                        cVar.a(i2);
                    }
                    i = z;
                    if (z) {
                        cVar.a(2);
                    } else {
                        if (cVar.D()) {
                            cVar.a(z);
                        }
                    }
                    cVar.g0(z);
                    this.i.getLocationOnScreen(this.g);
                    cVar.m(this.d);
                    if (this.d.equals(a.n)) {
                        cVar.l(this.d);
                        int i5 = -1;
                        if (cVar.b != i5) {
                            c cVar2 = c.K();
                            while (this.i != i5) {
                                cVar2.n0(this.i, i5);
                                cVar2.T(a.n);
                                N(i3, cVar2);
                                cVar2.l(this.e);
                                this.d.offset(rect8.left, rect8.top);
                            }
                            cVar2.O();
                        }
                        this.d.offset(this.g[z] - this.i.getScrollX(), this.g[z] - this.i.getScrollY());
                    }
                    if (this.i.getLocalVisibleRect(this.f)) {
                        this.f.offset(this.g[z] - this.i.getScrollX(), this.g[z] - this.i.getScrollY());
                        if (this.d.intersect(this.f)) {
                            cVar.U(this.d);
                            if (E(this.d)) {
                                cVar.w0(z);
                            }
                        }
                    }
                    return cVar;
                }
            }
        }
    }

    private c u() {
        int i = 0;
        c cVar = c.L(this.i);
        u.Z(this.i, cVar);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        i = 0;
        while (i < arrayList.size()) {
            cVar.c(this.i, (Integer)arrayList.get(i).intValue());
            i = i + 1;
        }
        return cVar;
    }

    private h<c> y() {
        int i = 0;
        final ArrayList arrayList = new ArrayList();
        C(arrayList);
        final h hVar = new h();
        i = 0;
        while (i < arrayList.size()) {
            hVar.j((Integer)arrayList.get(i).intValue(), t((Integer)arrayList.get(i).intValue()));
            i = i + 1;
        }
        return hVar;
    }

    private void z(int i, Rect rect) {
        H(i).l(rect);
    }

    @Override // d.h.l.a
    public final int A() {
        return this.l;
    }

    @Override // d.h.l.a
    c H(int i) {
        if (i == -1) {
            return u();
        }
        return t(i);
    }

    @Override // d.h.l.a
    public final void I(boolean z, int i, Rect rect) {
        if (this.l != -2147483648) {
            o(this.l);
        }
        if (z) {
            G(i, rect);
        }
    }

    @Override // d.h.l.a
    boolean P(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return Q(i, i2, bundle);
        }
        return R(i2, bundle);
    }

    @Override // d.h.l.a
    public final boolean T(int i) {
        boolean z2 = false;
        if (!this.i.isFocused() && !this.i.requestFocus()) {
            return false;
        }
        if (this.l == i) {
            return false;
        }
        final int i4 = Integer.MIN_VALUE;
        if (this.l != Integer.MIN_VALUE) {
            o(this.l);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.l = i;
        boolean z = true;
        O(i, z);
        U(i, 8);
        return true;
    }

    @Override // d.h.l.a
    public final boolean U(int i, int i2) {
        final boolean z = false;
        int i3 = Integer.MIN_VALUE;
        if (i != Integer.MIN_VALUE) {
            if (this.h.isEnabled()) {
                ViewParent parent = this.i.getParent();
                if (parent == null) {
                    return false;
                }
            }
            return parent.requestSendAccessibilityEvent(this.i, q(i, i2));
        }
        return false;
    }

    @Override // d.h.l.a
    public d b(View view) {
        if (this.j == null) {
            this.j = new a.c(this);
        }
        return this.j;
    }

    @Override // d.h.l.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // d.h.l.a
    public void g(View view, c cVar) {
        super.g(view, cVar);
        M(cVar);
    }

    @Override // d.h.l.a
    public final boolean o(int i) {
        final boolean z = false;
        if (this.l != i) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        O(i, z);
        U(i, 8);
        return true;
    }

    @Override // d.h.l.a
    public final boolean v(MotionEvent motionEvent) {
        boolean z = false;
        int i2 = 7;
        z = false;
        if (this.h.isEnabled()) {
            if (this.h.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                i2 = 7;
                int i = 1;
                int i3 = Integer.MIN_VALUE;
                if (action != 7 && action != 9 && action != 10) {
                    return false;
                }
                int i4 = B(motionEvent.getX(), motionEvent.getY());
                V(i4);
                if (i4 != Integer.MIN_VALUE) {
                }
            }
        }
        return z;
    }

    @Override // d.h.l.a
    public final boolean w(KeyEvent keyEvent) {
        int i = 0;
        boolean z = false;
        boolean z2;
        i = 1;
        if (keyEvent.getAction() != i) {
            int keyCode = keyEvent.getKeyCode();
            i = 61;
            Rect rect = null;
            if (keyCode != 61) {
                i = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                            repeatCount = keyEvent.getRepeatCount() + i;
                            i = i + 1;
                            break;
                        case 20:
                            p();
                            break;
                        default:
                    }
                }
            } else {
                if (keyEvent.hasNoModifiers()) {
                    int repeatCount = 2;
                    z = G(repeatCount, rect);
                } else {
                    if (keyEvent.hasModifiers(i)) {
                        z = G(i, rect);
                    }
                }
            }
        }
        return z;
    }

    @Override // d.h.l.a
    public final int x() {
        return this.k;
    }

    private static int F(int i) {
        if (i != 19 && i != 21) {
            if (i != 22) {
                return 130;
            }
            return 66;
        }
        return 33;
    }

    @Override // d.h.l.a
    protected abstract int B(float f, float f2);

    @Override // d.h.l.a
    protected abstract void C(List<Integer> list);

    @Override // d.h.l.a
    protected abstract boolean J(int i, int i2, Bundle bundle);

    @Override // d.h.l.a
    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    @Override // d.h.l.a
    protected void L(int i, AccessibilityEvent accessibilityEvent) {
    }

    @Override // d.h.l.a
    protected abstract void M(c cVar);

    @Override // d.h.l.a
    protected abstract void N(int i, c cVar);

    @Override // d.h.l.a
    protected abstract void O(int i, boolean z);
}
