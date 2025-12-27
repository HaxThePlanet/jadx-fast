package d.h.l;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public class l {

    private ViewParent a;
    private ViewParent b;
    private final View c;
    private boolean d;
    private int[] e;
    public l(View view) {
        super();
        this.c = view;
    }

    private boolean g(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        int[] iArr72;
        final Object i9 = this;
        final int[] iArr52 = iArr;
        i5 = 0;
        if (l()) {
            ViewParent viewParent = h(i5);
            if (viewParent == null) {
                return false;
            }
            int i8 = 1;
            if (i != 0 || !(i2 != 0 && i3 != 0 && i4 == 0)) {
                if (iArr52 != null) {
                    i9.c.getLocationInWindow(iArr52);
                } else {
                }
                if (iArr2 == null) {
                    iArr72 = i();
                    iArr72[i5] = i5;
                    iArr72[i8] = i5;
                } else {
                    iArr72 = iArr2;
                }
                y.d(viewParent, i9.c, i, i2, i3, i4, i5, iArr72);
                if (iArr52 != null) {
                    i9.c.getLocationInWindow(iArr52);
                    iArr52[i5] = iArr52[i5] - i5;
                    i62 = iArr52[i8] - i5;
                    iArr52[i8] = i62;
                }
            }
            return true;
        }
        return false;
    }

    private ViewParent h(int i) {
        if (i != 0 && i != 1) {
            return null;
        }
        return this.a;
    }

    private int[] i() {
        if (this.e == null) {
            this.e = new int[2];
        }
        return this.e;
    }

    private void n(int i, ViewParent viewParent) {
        if (i == 0) {
            this.a = viewParent;
        } else {
            int i2 = 1;
            if (i == 1) {
                this.b = viewParent;
            }
        }
    }

    public boolean a(float f, float f2, boolean z) {
        int i = 0;
        if (l() && viewParent != null) {
            return y.a(viewParent, this.c, f, f2, z);
        }
        return false;
    }

    public boolean b(float f, float f2) {
        int i = 0;
        if (l() && viewParent != null) {
            return y.b(viewParent, this.c, f, f2);
        }
        return false;
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2) {
        return this.d(i, i2, iArr, iArr2, 0);
    }

    public boolean d(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        boolean z2 = false;
        int i4;
        int i8;
        int[] iArr32;
        i4 = 0;
        return l() && viewParent == null ? i4 : z2;
    }

    public void e(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        g(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean f(int i, int i2, int i3, int i4, int[] iArr) {
        return this.g(i, i2, i3, i4, iArr, 0, null);
    }

    public boolean j() {
        return k(0);
    }

    public boolean k(int i) {
        boolean z = true;
        i = h(i) != null ? 1 : 0;
        return (h(i) != null ? 1 : 0);
    }

    public boolean l() {
        return this.d;
    }

    public void m(boolean z) {
        if (this.d) {
            u.E0(this.c);
        }
        this.d = z;
    }

    public boolean o(int i) {
        return p(i, 0);
    }

    public boolean p(int i, int i2) {
        ViewParent parent;
        View view;
        boolean z2;
        final boolean z4 = true;
        if (k(i2)) {
            return true;
        }
        if (l()) {
            parent = this.c.getParent();
            while (this.c != null) {
                if (y.f(parent, view, this.c, i, i2)) {
                    n(i2, parent);
                    y.e(parent, view, this.c, i, i2);
                    return true;
                }
            }
        }
        return false;
    }

    public void q() {
        r(0);
    }

    public void r(int i) {
        ViewParent viewParent = h(i);
        if (viewParent != null) {
            y.g(viewParent, this.c, i);
            viewParent = null;
            n(i, viewParent);
        }
    }
}
