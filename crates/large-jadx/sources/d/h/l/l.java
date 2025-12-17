package d.h.l;

import android.view.View;
import android.view.ViewParent;

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

    private boolean g(int i, int i2, int i3, int i4, int[] i5Arr5, int i6, int[] i7Arr7) {
        int z;
        ViewParent view;
        int i7;
        int i5;
        int[] iArr;
        int i8;
        int i10;
        int i9;
        final Object obj = this;
        final int[] iArr2 = i5Arr5;
        final int i14 = 0;
        view = h(i6);
        if (l() && view == null) {
            view = h(i6);
            if (view == null) {
                return i14;
            }
            i8 = 1;
            if (i == 0 && i2 == 0 && i3 == 0) {
                if (i2 == 0) {
                    if (i3 == 0) {
                        if (i4 != 0) {
                            if (iArr2 != null) {
                                obj.c.getLocationInWindow(iArr2);
                                i10 = i7;
                                i9 = i5;
                            } else {
                                i9 = i10;
                            }
                            if (i7Arr7 == null) {
                                i7 = i();
                                i7[i14] = i14;
                                i7[i8] = i14;
                                iArr = i7;
                            } else {
                                iArr = i7Arr7;
                            }
                            y.d(view, obj.c, i, i2, i3, i4, i6, iArr);
                            if (iArr2 != null) {
                                obj.c.getLocationInWindow(iArr2);
                                iArr2[i14] = i11 -= i10;
                                iArr2[i8] = i13 -= i9;
                            }
                        }
                        if (iArr2 != null) {
                            iArr2[i14] = i14;
                            iArr2[i8] = i14;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i8;
        }
        return i14;
    }

    private ViewParent h(int i) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return null;
            }
            return this.b;
        }
        return this.a;
    }

    private int[] i() {
        int[] iArr;
        if (this.e == null) {
            this.e = new int[2];
        }
        return this.e;
    }

    private void n(int i, ViewParent viewParent2) {
        int i2;
        if (i != 0) {
            if (i != 1) {
            } else {
                this.b = viewParent2;
            }
        } else {
            this.a = viewParent2;
        }
    }

    public boolean a(float f, float f2, boolean z3) {
        boolean z;
        int i = 0;
        z = h(i);
        if (l() && z != null) {
            z = h(i);
            if (z != null) {
                return y.a(z, this.c, f, f2, z3);
            }
        }
        return i;
    }

    public boolean b(float f, float f2) {
        boolean z;
        int i = 0;
        z = h(i);
        if (l() && z != null) {
            z = h(i);
            if (z != null) {
                return y.b(z, this.c, f, f2);
            }
        }
        return i;
    }

    public boolean c(int i, int i2, int[] i3Arr3, int[] i4Arr4) {
        return this.d(i, i2, i3Arr3, i4Arr4, 0);
    }

    public boolean d(int i, int i2, int[] i3Arr3, int[] i4Arr4, int i5) {
        boolean z;
        int i4;
        ViewParent view;
        int i8;
        int i9;
        int i6;
        int[] iArr;
        int i7;
        int i3;
        int i10;
        int obj11;
        int[] obj13;
        i4 = 0;
        view = h(i5);
        if (l() && view == null) {
            view = h(i5);
            if (view == null) {
                return i4;
            }
            z = 1;
            if (i == 0) {
                if (i2 != 0) {
                    if (i4Arr4 != null) {
                        this.c.getLocationInWindow(i4Arr4);
                        i3 = i8;
                        i10 = i9;
                    } else {
                        i10 = i3;
                    }
                    if (i3Arr3 == null) {
                        obj13 = i();
                    }
                    obj13[i4] = i4;
                    obj13[z] = i4;
                    y.c(view, this.c, i, i2, obj13, i5);
                    if (i4Arr4 != null) {
                        this.c.getLocationInWindow(i4Arr4);
                        i4Arr4[i4] = obj11 -= i3;
                        i4Arr4[z] = obj11 -= i10;
                    }
                    if (obj13[i4] == 0) {
                        if (obj13[z] != 0) {
                            i4 = z;
                        }
                    } else {
                    }
                } else {
                    if (i4Arr4 != null) {
                        i4Arr4[i4] = i4;
                        i4Arr4[z] = i4;
                    }
                }
            } else {
            }
        }
        return i4;
    }

    public void e(int i, int i2, int i3, int i4, int[] i5Arr5, int i6, int[] i7Arr7) {
        g(i, i2, i3, i4, i5Arr5, i6, i7Arr7);
    }

    public boolean f(int i, int i2, int i3, int i4, int[] i5Arr5) {
        return this.g(i, i2, i3, i4, i5Arr5, 0, 0);
    }

    public boolean j() {
        return k(0);
    }

    public boolean k(int i) {
        int obj1;
        obj1 = h(i) != null ? 1 : 0;
        return obj1;
    }

    public boolean l() {
        return this.d;
    }

    public void m(boolean z) {
        boolean z2;
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
        boolean z;
        final int i3 = 1;
        if (k(i2)) {
            return i3;
        }
        if (l()) {
            parent = this.c.getParent();
            view = this.c;
            while (parent != null) {
                if (parent instanceof View != null) {
                }
                parent = parent.getParent();
                view = parent;
            }
        }
        return 0;
    }

    public void q() {
        r(0);
    }

    public void r(int i) {
        ViewParent view;
        View view2;
        view = h(i);
        if (view != null) {
            y.g(view, this.c, i);
            n(i, 0);
        }
    }
}
