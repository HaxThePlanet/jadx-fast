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

/* loaded from: classes.dex */
public abstract class a extends a {

    private static final Rect n;
    private static final d.j.b.b.a<c> o;
    private static final d.j.b.b.b<h<c>, c> p;
    private final Rect d;
    private final Rect e;
    private final Rect f;
    private final int[] g;
    private final AccessibilityManager h;
    private final View i;
    private d.j.b.a.c j;
    int k = Integer.MIN_VALUE;
    int l = Integer.MIN_VALUE;
    private int m = Integer.MIN_VALUE;

    class a implements d.j.b.b.a<c> {
        @Override // d.j.b.b$a
        public void a(Object object, Rect rect2) {
            b((c)object, rect2);
        }

        @Override // d.j.b.b$a
        public void b(c c, Rect rect2) {
            c.l(rect2);
        }
    }

    class b implements d.j.b.b.b<h<c>, c> {
        @Override // d.j.b.b$b
        public Object a(Object object, int i2) {
            return c((h)object, i2);
        }

        @Override // d.j.b.b$b
        public int b(Object object) {
            return d((h)object);
        }

        public c c(h<c> h, int i2) {
            return (c)h.l(i2);
        }

        public int d(h<c> h) {
            return h.k();
        }
    }

    private class c extends d {

        final d.j.b.a b;
        c(d.j.b.a a) {
            this.b = a;
            super();
        }

        @Override // d.h.l.e0.d
        public c b(int i) {
            return c.M(this.b.H(i));
        }

        @Override // d.h.l.e0.d
        public c d(int i) {
            int obj2;
            obj2 = i == 2 ? obj2.k : obj2.l;
            if (obj2 == Integer.MIN_VALUE) {
                return null;
            }
            return b(obj2);
        }

        @Override // d.h.l.e0.d
        public boolean f(int i, int i2, Bundle bundle3) {
            return this.b.P(i, i2, bundle3);
        }
    }
    static {
        final int i = Integer.MAX_VALUE;
        final int i2 = Integer.MIN_VALUE;
        Rect rect = new Rect(i, i, i2, i2);
        a.n = rect;
        a.a aVar = new a.a();
        a.o = aVar;
        a.b bVar = new a.b();
        a.p = bVar;
    }

    public a(View view) {
        super();
        Rect rect = new Rect();
        this.d = rect;
        Rect rect2 = new Rect();
        this.e = rect2;
        Rect rect3 = new Rect();
        this.f = rect3;
        this.g = new int[2];
        int i2 = Integer.MIN_VALUE;
        if (view == null) {
        } else {
            this.i = view;
            this.h = (AccessibilityManager)view.getContext().getSystemService("accessibility");
            int i3 = 1;
            view.setFocusable(i3);
            if (u.z(view) == 0) {
                u.v0(view, i3);
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("View may not be null");
        throw obj3;
    }

    private static Rect D(View view, int i2, Rect rect3) {
        int i;
        int i3;
        int obj4;
        final int width = view.getWidth();
        obj4 = view.getHeight();
        final int i4 = 0;
        if (i2 != 17) {
            if (i2 != 33) {
                i3 = -1;
                if (i2 != 66) {
                    if (i2 != 130) {
                    } else {
                        rect3.set(i4, i3, width, i3);
                    }
                    obj4 = new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    throw obj4;
                }
                rect3.set(i3, i4, i3, obj4);
            } else {
                rect3.set(i4, obj4, width, obj4);
            }
        } else {
            rect3.set(width, i4, width, obj4);
        }
        return rect3;
    }

    private boolean E(Rect rect) {
        int i;
        boolean visibility;
        int i2;
        ViewParent obj4;
        i = 0;
        if (rect != null) {
            if (rect.isEmpty()) {
            } else {
                if (this.i.getWindowVisibility() != 0) {
                    return i;
                }
                obj4 = this.i.getParent();
                while (obj4 instanceof View != null) {
                    obj4 = obj4.getParent();
                }
                if (obj4 != null) {
                    i = 1;
                }
            }
        }
        return i;
    }

    private static int F(int i) {
        if (i != 19 && i != 21 && i != 22) {
            if (i != 21) {
                if (i != 22) {
                    return 130;
                }
                return 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean G(int i, Rect rect2) {
        int i5;
        int i4;
        h hVar;
        int i3;
        d.j.b.b.b bVar;
        d.j.b.b.a aVar;
        int rect;
        int i6;
        int i2;
        int i7;
        Object obj10;
        int obj11;
        final h hVar2 = y();
        int i8 = this.l;
        i7 = Integer.MIN_VALUE;
        if (i8 == i7) {
            i5 = 0;
        } else {
            i5 = hVar2.e(i8);
        }
        final int i11 = i5;
        int i9 = 1;
        if (i != i9 && i != 2) {
            if (i != 2) {
                if (i != 17 && i != 33 && i != 66) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                            } else {
                            }
                            obj10 = new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                            throw obj10;
                        }
                    }
                }
                rect = new Rect();
                int i10 = this.l;
                if (i10 != i7) {
                    z(i10, rect);
                } else {
                    if (rect2 != null) {
                        rect.set(rect2);
                    } else {
                        a.D(this.i, i, rect);
                    }
                }
                obj10 = b.c(hVar2, a.p, a.o, i11, rect, i);
            } else {
                i6 = u.B(this.i) == i9 ? i9 : obj11;
                obj10 = b.d(hVar2, a.p, a.o, i11, i, i6, false);
            }
        } else {
        }
        if (obj10 == null) {
        } else {
            i7 = hVar2.h(hVar2.g(obj10));
        }
        return T(i7);
    }

    private boolean Q(int i, int i2, Bundle bundle3) {
        if (i2 != 1 && i2 != 2 && i2 != 64 && i2 != 128) {
            if (i2 != 2) {
                if (i2 != 64) {
                    if (i2 != 128) {
                        return J(i, i2, bundle3);
                    }
                    return n(i);
                }
                return S(i);
            }
            return o(i);
        }
        return T(i);
    }

    private boolean R(int i, Bundle bundle2) {
        return u.b0(this.i, i, bundle2);
    }

    private boolean S(int i) {
        boolean touchExplorationEnabled;
        if (this.h.isEnabled()) {
            if (!this.h.isTouchExplorationEnabled()) {
            } else {
                touchExplorationEnabled = this.k;
                if (touchExplorationEnabled != i && touchExplorationEnabled != Integer.MIN_VALUE) {
                    if (touchExplorationEnabled != Integer.MIN_VALUE) {
                        n(touchExplorationEnabled);
                    }
                    this.k = i;
                    this.i.invalidate();
                    U(i, 32768);
                    return 1;
                }
            }
        }
        return 0;
    }

    private void V(int i) {
        final int i2 = this.m;
        if (i2 == i) {
        }
        this.m = i;
        U(i, 128);
        U(i2, 256);
    }

    private boolean n(int i) {
        if (this.k == i) {
            this.k = Integer.MIN_VALUE;
            this.i.invalidate();
            U(i, 65536);
            return 1;
        }
        return 0;
    }

    private boolean p() {
        int i3;
        int i4;
        int i;
        int i2;
        i3 = this.l;
        if (i3 != Integer.MIN_VALUE && J(i3, 16, 0)) {
            i4 = J(i3, 16, 0) ? 1 : 0;
        } else {
        }
        return i4;
    }

    private AccessibilityEvent q(int i, int i2) {
        if (i != -1) {
            return r(i, i2);
        }
        return s(i2);
    }

    private AccessibilityEvent r(int i, int i2) {
        boolean contentDescription;
        AccessibilityEvent obj5 = AccessibilityEvent.obtain(i2);
        c cVar = H(i);
        obj5.getText().add(cVar.v());
        obj5.setContentDescription(cVar.q());
        obj5.setScrollable(cVar.H());
        obj5.setPassword(cVar.G());
        obj5.setEnabled(cVar.C());
        obj5.setChecked(cVar.A());
        L(i, obj5);
        if (obj5.getText().isEmpty()) {
            if (obj5.getContentDescription() == null) {
            } else {
            }
            RuntimeException obj4 = new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            throw obj4;
        }
        obj5.setClassName(cVar.o());
        e.c(obj5, this.i, i);
        obj5.setPackageName(this.i.getContext().getPackageName());
        return obj5;
    }

    private AccessibilityEvent s(int i) {
        final AccessibilityEvent obj2 = AccessibilityEvent.obtain(i);
        this.i.onInitializeAccessibilityEvent(obj2);
        return obj2;
    }

    private c t(int i) {
        Rect rect2;
        Rect rect;
        java.lang.CharSequence charSequence;
        int i2;
        boolean z;
        int[] iArr;
        int scrollY;
        int left;
        int obj8;
        c cVar = c.K();
        final int i3 = 1;
        cVar.d0(i3);
        cVar.f0(i3);
        cVar.X("android.view.View");
        rect2 = a.n;
        cVar.T(rect2);
        cVar.U(rect2);
        cVar.m0(this.i);
        N(i, cVar);
        if (cVar.v() == null) {
            if (cVar.q() == null) {
            } else {
            }
            obj8 = new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            throw obj8;
        }
        cVar.l(this.e);
        if (this.e.equals(rect2)) {
        } else {
            int i8 = cVar.j();
            if (i8 & 64 != 0) {
            } else {
                scrollY = 128;
                if (i8 &= scrollY != 0) {
                } else {
                    cVar.k0(this.i.getContext().getPackageName());
                    cVar.s0(this.i, i);
                    final int i14 = 0;
                    if (this.k == i) {
                        cVar.R(i3);
                        cVar.a(scrollY);
                    } else {
                        cVar.R(i14);
                        cVar.a(64);
                    }
                    obj8 = this.l == i ? i3 : i14;
                    if (obj8 != null) {
                        cVar.a(2);
                    } else {
                        if (cVar.D()) {
                            cVar.a(i3);
                        }
                    }
                    cVar.g0(obj8);
                    this.i.getLocationOnScreen(this.g);
                    cVar.m(this.d);
                    cVar.l(this.d);
                    int i4 = -1;
                    if (this.d.equals(rect2) && cVar.b != i4) {
                        cVar.l(this.d);
                        i4 = -1;
                        if (cVar.b != i4) {
                            obj8 = c.K();
                            iArr = cVar.b;
                            while (iArr != i4) {
                                obj8.n0(this.i, i4);
                                obj8.T(a.n);
                                N(iArr, obj8);
                                obj8.l(this.e);
                                Rect rect8 = this.e;
                                this.d.offset(rect8.left, rect8.top);
                                iArr = obj8.b;
                            }
                            obj8.O();
                        }
                        this.d.offset(i5 -= scrollX, i11 -= scrollY);
                    }
                    this.f.offset(i6 -= scrollX2, i12 -= scrollY);
                    cVar.U(this.d);
                    if (this.i.getLocalVisibleRect(this.f) && this.d.intersect(this.f) && E(this.d)) {
                        this.f.offset(i6 -= scrollX2, i12 -= scrollY);
                        if (this.d.intersect(this.f)) {
                            cVar.U(this.d);
                            if (E(this.d)) {
                                cVar.w0(i3);
                            }
                        }
                    }
                    return cVar;
                }
                obj8 = new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
                throw obj8;
            }
            obj8 = new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            throw obj8;
        }
        obj8 = new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        throw obj8;
    }

    private c u() {
        int size;
        int i;
        View view;
        int intValue;
        c cVar = c.L(this.i);
        u.Z(this.i, cVar);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (cVar.n() > 0) {
            if (arrayList.size() > 0) {
            } else {
            }
            RuntimeException runtimeException = new RuntimeException("Views cannot have both real and virtual children");
            throw runtimeException;
        }
        i = 0;
        while (i < arrayList.size()) {
            cVar.c(this.i, (Integer)arrayList.get(i).intValue());
            i++;
        }
        return cVar;
    }

    private h<c> y() {
        int i;
        c cVar;
        int intValue;
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h hVar = new h();
        i = 0;
        while (i < arrayList.size()) {
            hVar.j((Integer)arrayList.get(i).intValue(), t((Integer)arrayList.get(i).intValue()));
            i++;
        }
        return hVar;
    }

    private void z(int i, Rect rect2) {
        H(i).l(rect2);
    }

    @Override // d.h.l.a
    public final int A() {
        return this.l;
    }

    @Override // d.h.l.a
    protected abstract int B(float f, float f2);

    protected abstract void C(List<Integer> list);

    @Override // d.h.l.a
    c H(int i) {
        if (i == -1) {
            return u();
        }
        return t(i);
    }

    @Override // d.h.l.a
    public final void I(boolean z, int i2, Rect rect3) {
        final int i = this.l;
        if (i != Integer.MIN_VALUE) {
            o(i);
        }
        if (z) {
            G(i2, rect3);
        }
    }

    @Override // d.h.l.a
    protected abstract boolean J(int i, int i2, Bundle bundle3);

    @Override // d.h.l.a
    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    @Override // d.h.l.a
    protected void L(int i, AccessibilityEvent accessibilityEvent2) {
    }

    @Override // d.h.l.a
    protected abstract void M(c c);

    @Override // d.h.l.a
    protected abstract void N(int i, c c2);

    @Override // d.h.l.a
    protected abstract void O(int i, boolean z2);

    @Override // d.h.l.a
    boolean P(int i, int i2, Bundle bundle3) {
        if (i != -1) {
            return Q(i, i2, bundle3);
        }
        return R(i2, bundle3);
    }

    @Override // d.h.l.a
    public final boolean T(int i) {
        boolean requestFocus;
        int i4 = 0;
        if (!this.i.isFocused() && !this.i.requestFocus()) {
            if (!this.i.requestFocus()) {
                return i4;
            }
        }
        int i2 = this.l;
        if (i2 == i) {
            return i4;
        }
        final int i6 = Integer.MIN_VALUE;
        if (i2 != i6) {
            o(i2);
        }
        if (i == i6) {
            return i4;
        }
        this.l = i;
        int i3 = 1;
        O(i, i3);
        U(i, 8);
        return i3;
    }

    @Override // d.h.l.a
    public final boolean U(int i, int i2) {
        int enabled;
        final int i3 = 0;
        if (i != Integer.MIN_VALUE) {
            if (!this.h.isEnabled()) {
            } else {
                ViewParent parent = this.i.getParent();
                if (parent == null) {
                    return i3;
                }
            }
            return parent.requestSendAccessibilityEvent(this.i, q(i, i2));
        }
        return i3;
    }

    @Override // d.h.l.a
    public d b(View view) {
        d.j.b.a.c obj1;
        if (this.j == null) {
            obj1 = new a.c(this);
            this.j = obj1;
        }
        return this.j;
    }

    @Override // d.h.l.a
    public void f(View view, AccessibilityEvent accessibilityEvent2) {
        super.f(view, accessibilityEvent2);
        K(accessibilityEvent2);
    }

    @Override // d.h.l.a
    public void g(View view, c c2) {
        super.g(view, c2);
        M(c2);
    }

    @Override // d.h.l.a
    public final boolean o(int i) {
        final int i5 = 0;
        if (this.l != i) {
            return i5;
        }
        this.l = Integer.MIN_VALUE;
        O(i, i5);
        U(i, 8);
        return 1;
    }

    @Override // d.h.l.a
    public final boolean v(MotionEvent motionEvent) {
        boolean touchExplorationEnabled;
        int i4;
        int i2;
        int i;
        int i3;
        int obj6;
        i4 = 0;
        if (this.h.isEnabled()) {
            if (!this.h.isTouchExplorationEnabled()) {
            } else {
                int action = motionEvent.getAction();
                i = 1;
                i3 = Integer.MIN_VALUE;
                if (action != 7 && action != 9 && action != 10) {
                    if (action != 9) {
                        if (action != 10) {
                            return i4;
                        }
                        if (this.m != i3) {
                            V(i3);
                            return i;
                        }
                        return i4;
                    }
                }
                obj6 = B(motionEvent.getX(), motionEvent.getY());
                V(obj6);
                if (obj6 != i3) {
                    i4 = i;
                }
            }
        }
        return i4;
    }

    @Override // d.h.l.a
    public final boolean w(KeyEvent keyEvent) {
        int noModifiers;
        int i;
        int noModifiers2;
        int i2;
        boolean z;
        int obj7;
        final int i3 = 1;
        if (keyEvent.getAction() != i3) {
            noModifiers = keyEvent.getKeyCode();
            i2 = 0;
            if (noModifiers != 61) {
                if (noModifiers != 66) {
                    switch (noModifiers) {
                        case 19:
                            noModifiers2 = i;
                            i++;
                            noModifiers2 = i3;
                            i = noModifiers2;
                            break;
                        case 20:
                            p();
                            i = i3;
                            break;
                        default:
                    }
                } else {
                }
            } else {
                if (keyEvent.hasNoModifiers()) {
                    i = G(2, i2);
                } else {
                    if (keyEvent.hasModifiers(i3)) {
                        i = G(i3, i2);
                    }
                }
            }
        }
        return i;
    }

    @Override // d.h.l.a
    public final int x() {
        return this.k;
    }
}
