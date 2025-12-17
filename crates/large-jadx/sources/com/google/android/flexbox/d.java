package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.CompoundButton;
import androidx.core.widget.e;
import d.h.l.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class d {

    private final com.google.android.flexbox.a a;
    private boolean[] b;
    int[] c;
    long[] d;
    private long[] e;

    static class a {

        List<com.google.android.flexbox.c> a;
        int b;
        void a() {
            this.a = 0;
        }
    }
    static {
    }

    d(com.google.android.flexbox.a a) {
        super();
        this.a = a;
    }

    private int A(boolean z) {
        if (z) {
            return this.a.a();
        }
        return this.a.b();
    }

    private int B(boolean z) {
        if (z) {
            return this.a.b();
        }
        return this.a.a();
    }

    private int C(boolean z) {
        if (z) {
            return this.a.u();
        }
        return this.a.t();
    }

    private int D(boolean z) {
        if (z) {
            return this.a.t();
        }
        return this.a.u();
    }

    private int E(View view, boolean z2) {
        if (z2) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int F(View view, boolean z2) {
        if (z2) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private boolean G(int i, int i2, com.google.android.flexbox.c c3) {
        int i3;
        int obj2;
        if (i == i2 -= i3 && c3.c() != 0) {
            if (c3.c() != 0) {
            } else {
                i3 = 0;
            }
        } else {
        }
        return i3;
    }

    private boolean H(View view, int i2, int i3, int i4, int i5, com.google.android.flexbox.b b6, int i7, int i8, int i9) {
        int i;
        int obj7;
        int obj11;
        i = 0;
        if (this.a.i() == 0) {
            return i;
        }
        int i10 = 1;
        if (b6.G1()) {
            return i10;
        }
        if (i2 == 0) {
            return i;
        }
        int obj4 = this.a.g();
        if (obj4 != -1 && obj4 <= i9 += i10) {
            if (obj4 <= i9 += i10) {
                return i;
            }
        }
        final int obj3 = this.a.q(view, i7, i8);
        if (obj3 > 0) {
            i5 += obj3;
        }
        if (i3 < i4 += obj7) {
            i = i10;
        }
        return i;
    }

    private void L(int i, int i2, com.google.android.flexbox.c c3, int i4, int i5, boolean z6) {
        int cmp3;
        int measuredWidth;
        int i9;
        int cmp2;
        float f;
        int i16;
        int i6;
        int measuredHeight3;
        int round;
        int i18;
        int i7;
        Object obj;
        int i8;
        int cmp;
        int i20;
        int i10;
        int i14;
        int i19;
        int i13;
        View view;
        android.view.ViewGroup.LayoutParams layoutParams;
        int i11;
        boolean cmp5;
        double i3;
        int measuredHeight;
        int cmp4;
        int measuredWidth3;
        int measuredWidth2;
        int round2;
        int i12;
        boolean cmp6;
        long measuredHeight2;
        long l;
        int i17;
        int i15;
        final Object obj2 = this;
        obj = c3;
        i8 = i4;
        cmp3 = obj.a;
        f = obj.g;
        i18 = 0;
        if (Float.compare(f, i18) > 0) {
            if (i8 > cmp3) {
            } else {
                f7 /= f;
                obj.a = i31 += i5;
                if (!z6) {
                    obj.c = Integer.MIN_VALUE;
                }
                i10 = i20;
                i19 = i18;
                while (f < obj.d) {
                    i45 += f;
                    view = obj2.a.k(i13);
                    if (view != null) {
                    } else {
                    }
                    i11 = i2;
                    i7 = cmp3;
                    i12 = f;
                    f = i12 + 1;
                    cmp3 = i7;
                    i18 = 0;
                    if (view.getVisibility() == 8) {
                    } else {
                    }
                    layoutParams = view.getLayoutParams();
                    int i51 = obj2.a.f();
                    l = 4607182418800017408L;
                    i17 = 1065353216;
                    if (i51 != 0) {
                    } else {
                    }
                    i7 = cmp3;
                    int i63 = f;
                    measuredWidth = view.getMeasuredWidth();
                    long[] lArr = obj2.e;
                    if (lArr != null) {
                    }
                    measuredHeight3 = view.getMeasuredHeight();
                    long[] lArr2 = obj2.e;
                    i15 = i63;
                    if (lArr2 != null) {
                    }
                    measuredWidth3 = 0;
                    if (!obj2.b[i13] && Float.compare(f10, measuredWidth3) > 0) {
                    } else {
                    }
                    i11 = i2;
                    i12 = i15;
                    obj.a = i43 += i22;
                    cmp3 = i6;
                    obj.c = Math.max(obj.c, cmp3);
                    i10 = cmp3;
                    measuredWidth3 = 0;
                    if (Float.compare(f10, measuredWidth3) > 0) {
                    } else {
                    }
                    i3 = 1;
                    if (i15 == i38 -= i3) {
                    }
                    round = Math.round(i9);
                    if (round < layoutParams.m0()) {
                    } else {
                    }
                    i19 += i25;
                    i3 = (double)i19;
                    if (Double.compare(i3, l) > 0) {
                    } else {
                    }
                    if (Double.compare(i3, measuredHeight2) < 0) {
                    }
                    int i24 = obj2.s(i2, layoutParams, obj.i);
                    int measureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                    view.measure(measureSpec, i24);
                    obj2.Q(i13, measureSpec, i24, view);
                    obj2.a.n(i13, view);
                    measuredWidth = measuredWidth3;
                    measuredHeight3 = measuredHeight2;
                    round--;
                    i19 += i17;
                    round++;
                    i19 -= i17;
                    round = layoutParams.m0();
                    obj2.b[i13] = i3;
                    obj.g = f3 -= f8;
                    i20 = i3;
                    i9 += i19;
                    i19 = measuredWidth3;
                    measuredHeight3 = obj2.q(lArr2[i13]);
                    measuredWidth = obj2.r(lArr[i13]);
                    if (i51 == 1) {
                    } else {
                    }
                    measuredHeight = view.getMeasuredHeight();
                    long[] lArr3 = obj2.e;
                    if (lArr3 != null) {
                    }
                    measuredWidth2 = view.getMeasuredWidth();
                    long[] lArr4 = obj2.e;
                    if (lArr4 != null) {
                    }
                    if (!obj2.b[i13] && Float.compare(f14, i18) > 0) {
                    } else {
                    }
                    i7 = cmp3;
                    i12 = f;
                    i6 = i;
                    cmp3 = Math.max(i10, i62 += i30);
                    obj.a = i44 += i55;
                    i11 = i2;
                    if (Float.compare(f14, i18) > 0) {
                    } else {
                    }
                    int i64 = 1;
                    if (f == i59 -= i64) {
                    }
                    round2 = Math.round(cmp4);
                    if (round2 < layoutParams.A1()) {
                    } else {
                    }
                    i19 += i53;
                    i7 = cmp3;
                    i12 = f;
                    cmp3 = (double)i19;
                    if (Double.compare(cmp3, l) > 0) {
                    } else {
                    }
                    if (Double.compare(cmp3, measuredHeight2) < 0) {
                    }
                    int i27 = obj2.t(i, layoutParams, obj.i);
                    int measureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                    view.measure(i27, measureSpec2);
                    measuredWidth2 = view.getMeasuredWidth();
                    obj2.Q(i13, i27, measureSpec2, view);
                    obj2.a.n(i13, view);
                    measuredHeight = measuredHeight2;
                    round2--;
                    i19 += i17;
                    round2++;
                    i19 -= i17;
                    round2 = layoutParams.A1();
                    obj2.b[i13] = i64;
                    obj.g = f5 -= f9;
                    i7 = cmp3;
                    i12 = f;
                    i20 = 1;
                    cmp4 += i19;
                    i19 = i18;
                    measuredWidth2 = obj2.r(lArr4[i13]);
                    measuredHeight = obj2.q(lArr3[i13]);
                }
                i11 = i2;
                if (i20 != 0 && cmp3 != obj.a) {
                    if (cmp3 != obj.a) {
                        this.L(i, i2, c3, i4, i5, true);
                    }
                }
            }
        }
    }

    private void M(View view, int i2, int i3) {
        int measuredHeight;
        long i;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        long[] lArr = this.e;
        if (lArr != null) {
            measuredHeight = q(lArr[i3]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int i8 = 1073741824;
        int measureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, i8);
        int obj5 = View.MeasureSpec.makeMeasureSpec(Math.min(Math.max(obj5 -= i7, layoutParams.m0()), layoutParams.e2()), i8);
        view.measure(obj5, measureSpec);
        Q(i3, obj5, measureSpec, view);
        this.a.n(i3, view);
    }

    private void N(View view, int i2, int i3) {
        int measuredWidth;
        long i;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        long[] lArr = this.e;
        if (lArr != null) {
            measuredWidth = r(lArr[i3]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int i8 = 1073741824;
        int measureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, i8);
        int obj5 = View.MeasureSpec.makeMeasureSpec(Math.min(Math.max(obj5 -= i7, layoutParams.A1()), layoutParams.N1()), i8);
        view.measure(measureSpec, obj5);
        Q(i3, measureSpec, obj5, view);
        this.a.n(i3, view);
    }

    private void Q(int i, int i2, int i3, View view4) {
        int obj3;
        int obj4;
        int obj5;
        final long[] lArr = this.d;
        if (lArr != null) {
            lArr[i] = K(i2, i3);
        }
        obj3 = this.e;
        if (obj3 != null) {
            obj3[i] = K(view4.getMeasuredWidth(), view4.getMeasuredHeight());
        }
    }

    private void a(List<com.google.android.flexbox.c> list, com.google.android.flexbox.c c2, int i3, int i4) {
        c2.i = i4;
        this.a.j(c2);
        c2.l = i3;
        list.add(c2);
    }

    private void g(View view, int i2) {
        Object layoutParams;
        int measuredWidth;
        int measuredHeight;
        int i5;
        int i4;
        int i3;
        int i;
        layoutParams = view.getLayoutParams();
        measuredWidth = view.getMeasuredWidth();
        measuredHeight = view.getMeasuredHeight();
        if (measuredWidth < (b)layoutParams.m0()) {
            measuredWidth = layoutParams.m0();
            i5 = i3;
        } else {
        }
        if (measuredHeight < layoutParams.A1()) {
            measuredHeight = layoutParams.A1();
        } else {
            if (measuredHeight > layoutParams.N1()) {
                measuredHeight = layoutParams.N1();
            } else {
                i3 = i5;
            }
        }
        if (i3 != 0) {
            int i6 = 1073741824;
            measuredWidth = View.MeasureSpec.makeMeasureSpec(measuredWidth, i6);
            int measureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, i6);
            view.measure(measuredWidth, measureSpec);
            Q(i2, measuredWidth, measureSpec, view);
            this.a.n(i2, view);
        }
    }

    private void k(int i) {
        int zArr;
        int length;
        boolean[] obj3;
        zArr = this.b;
        if (zArr == null) {
            zArr = 10;
            if (i < zArr) {
                obj3 = zArr;
            }
            this.b = new boolean[obj3];
        } else {
            if (zArr.length < i) {
                length2 *= 2;
                if (zArr >= i) {
                    obj3 = zArr;
                }
                this.b = new boolean[obj3];
            } else {
                Arrays.fill(zArr, false);
            }
        }
    }

    private void o(CompoundButton compoundButton) {
        int i;
        int i2;
        int minimumHeight;
        int minimumWidth;
        final android.view.ViewGroup.LayoutParams layoutParams = compoundButton.getLayoutParams();
        Drawable obj6 = e.a(compoundButton);
        if (obj6 == null) {
            minimumWidth = minimumHeight;
        } else {
            minimumWidth = obj6.getMinimumWidth();
        }
        if (obj6 == null) {
        } else {
            minimumHeight = obj6.getMinimumHeight();
        }
        obj6 = -1;
        if ((b)layoutParams.m0() == obj6) {
            i = minimumWidth;
        }
        layoutParams.z0(i);
        if (layoutParams.A1() == obj6) {
            i2 = minimumHeight;
        }
        layoutParams.V0(i2);
    }

    private void p(int i, int i2, com.google.android.flexbox.c c3, int i4, int i5, boolean z6) {
        float f;
        int i11;
        int i8;
        int measuredWidth;
        int i20;
        int cmp2;
        int i9;
        int i15;
        int cmp4;
        int measuredHeight;
        int round2;
        int i19;
        Object obj;
        int i7;
        int i3;
        int i12;
        int i13;
        int i6;
        int i16;
        int i17;
        View view;
        int layoutParams;
        int i18;
        boolean cmp5;
        int i10;
        int measuredHeight4;
        int cmp;
        int measuredWidth2;
        int measuredWidth3;
        int round;
        int measuredHeight2;
        boolean cmp3;
        int measuredHeight3;
        long l;
        long l2;
        int i14;
        final Object obj2 = this;
        obj = c3;
        i7 = i4;
        f = obj.f;
        i8 = 0;
        if (Float.compare(f, i8) > 0) {
            cmp4 = obj.a;
            if (i7 < cmp4) {
            } else {
                f7 /= f;
                obj.a = i21 += i5;
                if (!z6) {
                    obj.c = Integer.MIN_VALUE;
                }
                i13 = i12;
                i16 = i8;
                while (f < obj.d) {
                    i44 += f;
                    view = obj2.a.k(i17);
                    if (view != null) {
                    } else {
                    }
                    i18 = i2;
                    i14 = cmp4;
                    f++;
                    cmp4 = i14;
                    i8 = 0;
                    if (view.getVisibility() == 8) {
                    } else {
                    }
                    layoutParams = view.getLayoutParams();
                    int i50 = obj2.a.f();
                    l = 4607182418800017408L;
                    if (i50 != 0) {
                    } else {
                    }
                    measuredHeight2 = cmp4;
                    measuredWidth = view.getMeasuredWidth();
                    long[] lArr = obj2.e;
                    if (lArr != null) {
                    }
                    measuredHeight = view.getMeasuredHeight();
                    long[] lArr2 = obj2.e;
                    i14 = measuredHeight2;
                    if (lArr2 != null) {
                    }
                    measuredWidth2 = 0;
                    if (!obj2.b[i17] && Float.compare(f10, measuredWidth2) > 0) {
                    } else {
                    }
                    i18 = i2;
                    obj.a = i42 += i26;
                    i8 = i19;
                    obj.c = Math.max(obj.c, i8);
                    i13 = i8;
                    measuredWidth2 = 0;
                    if (Float.compare(f10, measuredWidth2) > 0) {
                    } else {
                    }
                    i10 = 1;
                    if (f == i35 -= i10) {
                    }
                    round2 = Math.round(i20);
                    if (round2 > layoutParams.e2()) {
                    } else {
                    }
                    measuredWidth2 = (double)i16;
                    if (Double.compare(measuredWidth2, l) > 0) {
                    } else {
                    }
                    if (Double.compare(measuredWidth2, l2) < 0) {
                    }
                    int i23 = obj2.s(i2, layoutParams, obj.i);
                    int measureSpec = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                    view.measure(measureSpec, i23);
                    obj2.Q(i17, measureSpec, i23, view);
                    obj2.a.n(i17, view);
                    measuredWidth = measuredWidth2;
                    measuredHeight = measuredHeight2;
                    round2--;
                    measuredWidth2 += l;
                    i16 = cmp2;
                    round2++;
                    measuredWidth2 -= l;
                    round2 = layoutParams.e2();
                    obj2.b[i17] = i10;
                    obj.f = f3 -= f8;
                    i12 = i10;
                    i20 += i16;
                    i16 = measuredWidth2;
                    measuredHeight = obj2.q(lArr2[i17]);
                    measuredWidth = obj2.r(lArr[i17]);
                    if (i50 == 1) {
                    } else {
                    }
                    measuredHeight4 = view.getMeasuredHeight();
                    long[] lArr3 = obj2.e;
                    if (lArr3 != null) {
                    }
                    measuredWidth3 = view.getMeasuredWidth();
                    long[] lArr4 = obj2.e;
                    if (lArr4 != null) {
                    }
                    if (!obj2.b[i17] && Float.compare(f13, i8) > 0) {
                    } else {
                    }
                    measuredHeight2 = cmp4;
                    i19 = i;
                    i8 = Math.max(i13, i60 += i32);
                    obj.a = i43 += i54;
                    i18 = i2;
                    i14 = measuredHeight2;
                    if (Float.compare(f13, i8) > 0) {
                    } else {
                    }
                    int i62 = 1;
                    if (f == i57 -= i62) {
                    }
                    round = Math.round(cmp);
                    if (round > layoutParams.N1()) {
                    } else {
                    }
                    measuredHeight2 = cmp4;
                    i9 = (double)i16;
                    if (Double.compare(i9, l) > 0) {
                    } else {
                    }
                    if (Double.compare(i9, l2) < 0) {
                    }
                    int i29 = obj2.t(i, layoutParams, obj.i);
                    int measureSpec2 = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                    view.measure(i29, measureSpec2);
                    measuredWidth3 = view.getMeasuredWidth();
                    obj2.Q(i17, i29, measureSpec2, view);
                    obj2.a.n(i17, view);
                    measuredHeight4 = measuredHeight3;
                    round--;
                    i9 += l;
                    i16 = i9;
                    round++;
                    i9 -= l;
                    round = layoutParams.N1();
                    obj2.b[i17] = i62;
                    obj.f = f4 -= f9;
                    measuredHeight2 = cmp4;
                    i12 = 1;
                    cmp += i16;
                    i16 = i8;
                    measuredWidth3 = obj2.r(lArr4[i17]);
                    measuredHeight4 = obj2.q(lArr3[i17]);
                }
                i18 = i2;
                if (i12 != 0 && cmp4 != obj.a) {
                    if (i14 != obj.a) {
                        this.p(i, i2, c3, i4, i5, true);
                    }
                }
            }
        }
    }

    private int s(int i, com.google.android.flexbox.b b2, int i3) {
        int i2;
        int obj4;
        int obj5;
        com.google.android.flexbox.a aVar = this.a;
        obj4 = aVar.s(i, i7 += i3, b2.J());
        int obj6 = View.MeasureSpec.getSize(obj4);
        if (obj6 > b2.N1()) {
            obj4 = View.MeasureSpec.makeMeasureSpec(b2.N1(), View.MeasureSpec.getMode(obj4));
        } else {
            if (obj6 < b2.A1()) {
                obj4 = View.MeasureSpec.makeMeasureSpec(b2.A1(), View.MeasureSpec.getMode(obj4));
            }
        }
        return obj4;
    }

    private int t(int i, com.google.android.flexbox.b b2, int i3) {
        int i2;
        int obj4;
        int obj5;
        com.google.android.flexbox.a aVar = this.a;
        obj4 = aVar.l(i, i7 += i3, b2.v0());
        int obj6 = View.MeasureSpec.getSize(obj4);
        if (obj6 > b2.e2()) {
            obj4 = View.MeasureSpec.makeMeasureSpec(b2.e2(), View.MeasureSpec.getMode(obj4));
        } else {
            if (obj6 < b2.m0()) {
                obj4 = View.MeasureSpec.makeMeasureSpec(b2.m0(), View.MeasureSpec.getMode(obj4));
            }
        }
        return obj4;
    }

    private int u(com.google.android.flexbox.b b, boolean z2) {
        if (z2) {
            return b.A0();
        }
        return b.x1();
    }

    private int v(com.google.android.flexbox.b b, boolean z2) {
        if (z2) {
            return b.x1();
        }
        return b.A0();
    }

    private int w(com.google.android.flexbox.b b, boolean z2) {
        if (z2) {
            return b.Q0();
        }
        return b.C0();
    }

    private int x(com.google.android.flexbox.b b, boolean z2) {
        if (z2) {
            return b.C0();
        }
        return b.Q0();
    }

    private int y(com.google.android.flexbox.b b, boolean z2) {
        if (z2) {
            return b.J();
        }
        return b.v0();
    }

    private int z(com.google.android.flexbox.b b, boolean z2) {
        if (z2) {
            return b.v0();
        }
        return b.J();
    }

    void I(View view, com.google.android.flexbox.c c2, int i3, int i4, int i5, int i6) {
        android.view.ViewGroup.LayoutParams layoutParams;
        int baseline;
        int i2;
        int i;
        Object obj7;
        int obj9;
        int obj11;
        layoutParams = view.getLayoutParams();
        baseline = this.a.m();
        if ((b)layoutParams.Y() != -1) {
            baseline = layoutParams.Y();
        }
        i2 = c2.c;
        int i13 = 2;
        if (baseline != 0) {
            if (baseline != 1) {
                if (baseline != i13) {
                    if (baseline != 3) {
                        if (baseline != 4) {
                        } else {
                            if (this.a.i() != i13) {
                                view.layout(i3, i4 += obj7, i5, i6 += obj7);
                            } else {
                                view.layout(i3, i4 -= obj7, i5, i6 -= obj7);
                            }
                        }
                    } else {
                        if (this.a.i() != i13) {
                            obj7 = Math.max(obj7 -= baseline, layoutParams.Q0());
                            view.layout(i3, i4 += obj7, i5, i6 += obj7);
                        } else {
                            obj7 = Math.max(obj7 += baseline, layoutParams.A0());
                            view.layout(i3, i4 -= obj7, i5, i6 -= obj7);
                        }
                    }
                } else {
                    i11 /= i13;
                    if (this.a.i() != i13) {
                        i4 += i2;
                        view.layout(i3, obj9, i5, obj7 += obj9);
                    } else {
                        i4 -= i2;
                        view.layout(i3, obj9, i5, obj7 += obj9);
                    }
                }
            } else {
                if (this.a.i() != i13) {
                    i4 += i2;
                    view.layout(i3, obj7 -= obj11, i5, obj9 -= obj11);
                } else {
                    view.layout(i3, obj9 += obj7, i5, obj11 += obj7);
                }
            }
        } else {
        }
    }

    void J(View view, com.google.android.flexbox.c c2, boolean z3, int i4, int i5, int i6, int i7) {
        android.view.ViewGroup.LayoutParams layoutParams;
        int i2;
        int i;
        int obj6;
        int obj7;
        int obj8;
        int obj10;
        layoutParams = view.getLayoutParams();
        i2 = this.a.m();
        if ((b)layoutParams.Y() != -1) {
            i2 = layoutParams.Y();
        }
        obj6 = c2.c;
        if (i2 != 0) {
            if (i2 != 1) {
                i = 2;
                if (i2 != i) {
                    if (i2 != 3 && i2 != 4) {
                        if (i2 != 4) {
                        } else {
                            if (z3 == 0) {
                                view.layout(i4 += obj6, i5, i6 += obj6, i7);
                            } else {
                                view.layout(i4 -= obj6, i5, i6 -= obj6, i7);
                            }
                        }
                    } else {
                    }
                } else {
                    android.view.ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    obj6 /= i;
                    if (z3 == 0) {
                        view.layout(i4 += obj6, i5, i6 += obj6, i7);
                    } else {
                        view.layout(i4 -= obj6, i5, i6 -= obj6, i7);
                    }
                }
            } else {
                if (z3 == 0) {
                    view.layout(obj8 -= obj7, i5, obj10 -= obj6, i7);
                } else {
                    view.layout(obj8 += obj7, i5, obj10 += obj6, i7);
                }
            }
        } else {
        }
    }

    long K(int i, int i2) {
        return obj5 |= i3;
    }

    void O() {
        P(0);
    }

    void P(int i) {
        int iterator;
        int next2;
        List next;
        int layoutParams;
        int i6;
        int intValue;
        int i4;
        int visibility;
        int size;
        Object obj;
        int i5;
        int i2;
        int i3;
        View view;
        final Object obj2 = this;
        int i7 = i;
        if (i7 >= obj2.a.c()) {
        }
        int i9 = obj2.a.f();
        final String str = "Invalid flex direction: ";
        i4 = 4;
        final int i10 = 1;
        if (obj2.a.m() == i4) {
            int[] iArr = obj2.c;
            iterator = iArr != null ? iArr[i7] : 0;
            next = obj2.a.r();
            while (iterator < next.size()) {
                obj = next.get(iterator);
                i2 = 0;
                while (i2 < obj.d) {
                    i11 += i2;
                    view = obj2.a.k(i3);
                    i2++;
                    layoutParams = view.getLayoutParams();
                    obj2.N(view, obj.c, i3);
                    obj2.M(view, obj.c, i3);
                }
                iterator++;
                i11 += i2;
                view = obj2.a.k(i3);
                i2++;
                layoutParams = view.getLayoutParams();
                obj2.N(view, obj.c, i3);
                obj2.M(view, obj.c, i3);
            }
        } else {
            iterator = obj2.a.r().iterator();
            for (c next2 : iterator) {
                layoutParams = next2.j.iterator();
                for (Integer next3 : layoutParams) {
                    i4 = obj2.a.k(next3.intValue());
                    visibility = 2;
                    size = 3;
                    obj2.N(i4, next2.c, next3.intValue());
                    obj2.M(i4, next2.c, next3.intValue());
                }
                Object next3 = layoutParams.next();
                i4 = obj2.a.k((Integer)next3.intValue());
                visibility = 2;
                size = 3;
                obj2.N(i4, next2.c, next3.intValue());
                obj2.M(i4, next2.c, next3.intValue());
            }
        }
    }

    void b(com.google.android.flexbox.d.a d$a, int i2, int i3, int i4, int i5, int i6, List<com.google.android.flexbox.c> list7) {
        Object arrayList;
        int i28;
        int i10;
        Object obj;
        int i27;
        int i8;
        int round;
        int i19;
        int i35;
        int i16;
        View view;
        com.google.android.flexbox.c cVar2;
        int i36;
        boolean z2;
        int i23;
        boolean z3;
        int valueOf;
        int cmp;
        int i20;
        int i12;
        int i26;
        int i39;
        int i34;
        int i24;
        int i32;
        ArrayList list;
        int i15;
        int size3;
        com.google.android.flexbox.a aVar;
        int i31;
        boolean z;
        int mode;
        int i17;
        int i18;
        int size4;
        int i11;
        Object obj2;
        int size;
        int i33;
        int i29;
        int i30;
        int i14;
        int i22;
        int combineMeasuredStates;
        int i25;
        int i;
        int size2;
        int i37;
        int i7;
        int i38;
        int i13;
        com.google.android.flexbox.c cVar;
        int i9;
        int i21;
        View obj38;
        final Object obj4 = this;
        i33 = i2;
        i29 = i3;
        final boolean z7 = obj4.a.w();
        mode = View.MeasureSpec.getMode(i2);
        size3 = View.MeasureSpec.getSize(i2);
        if (list7 == null) {
            arrayList = new ArrayList();
            list = arrayList;
        } else {
            list = list7;
        }
        obj2.a = list;
        i28 = i6 == -1 ? 1 : 0;
        final int i130 = obj4.C(z7);
        final int i131 = obj4.A(z7);
        cVar2 = new c();
        cVar2.k = i5;
        cVar2.a = i53 += i46;
        i27 = obj4.a.c();
        final int i132 = Integer.MIN_VALUE;
        i22 = i28;
        i = i132;
        i10 = 0;
        combineMeasuredStates = 0;
        i25 = 0;
        while (i32 < i27) {
            View view3 = obj4.a.k(i32);
            if (view3 instanceof CompoundButton) {
            }
            size = layoutParams;
            i7 = i27;
            if ((b)size.Y() == 4) {
            }
            round = obj4.z(size, z7);
            if (Float.compare(f2, i137) != 0 && mode == 1073741824) {
            }
            if (z7) {
            } else {
            }
            i37 = size3;
            i38 = mode;
            int i97 = 1;
            i14 = 0;
            i20 = obj4.a.l(i29, i109 += i10, obj4.y(size, i14));
            i19 = obj4.a.s(i33, i112 += size2, round);
            view3.measure(i20, i19);
            obj4.Q(i32, i20, i19, view3);
            i17 = i19;
            obj4.a.n(i32, view3);
            obj4.g(view3, i32);
            int i116 = i49;
            int i120 = i7;
            cVar = cVar2;
            i9 = i121;
            int i122 = 1;
            i13 = 0;
            int i83 = i32;
            obj38 = view5;
            int i123 = -1;
            i30 = list;
            i29 = i83;
            i21 = i17;
            if (this.H(view3, i38, i37, cVar2.a, i81 += i48, size, i83, i25, list.size())) {
            } else {
            }
            i39 = i3;
            view = obj38;
            i32 = i29;
            cVar2 = cVar;
            list = i9;
            cVar2.d = i41 += i50;
            i27 = i43;
            i10 = i116;
            i12 = i;
            int i117 = 0;
            if (Float.compare(f5, i117) != 0) {
            } else {
            }
            i18 = i13;
            cVar2.m = z5 |= i18;
            if (Float.compare(f6, i117) != 0) {
            } else {
            }
            size4 = i13;
            cVar2.n = z6 |= size4;
            int[] iArr = obj4.c;
            if (iArr != null) {
            }
            cVar2.a = i87 += i102;
            cVar2.f = f3 += f7;
            cVar2.g = f4 += f8;
            obj4.a.e(view, i32, i27, cVar2);
            z2 = Math.max(i12, i93 += i11);
            cVar2.c = Math.max(cVar2.c, z2);
            if (z7) {
            }
            if (obj4.G(i32, i7, cVar2)) {
            }
            size3 = i6;
            if (size3 != -1 && i30.size() > 0) {
            } else {
            }
            i33 = 1;
            obj2 = i4;
            i25 = i27;
            i = z2;
            i32++;
            obj2 = a;
            i33 = i2;
            i27 = i16;
            i29 = i39;
            i16 = list;
            list = i30;
            mode = i38;
            i30 = size3;
            size3 = i37;
            if (i30.size() > 0) {
            } else {
            }
            i33 = 1;
            if (obj5.l >= size3 && i32 >= size3 && i22 == 0) {
            } else {
            }
            if (i32 >= size3) {
            } else {
            }
            if (i22 == 0) {
            } else {
            }
            i10 = -i40;
            obj2 = i4;
            i22 = i33;
            obj4.a(i30, cVar2, i32, i10);
            i10 += z;
            if (obj4.a.i() != 2) {
            } else {
            }
            cVar2.h = Math.max(cVar2.h, i106 += i56);
            cVar2.h = Math.max(cVar2.h, baseline += i11);
            iArr[i32] = i30.size();
            size4 = 1;
            i18 = 1;
            if (cVar.c() > 0) {
            } else {
            }
            i10 = i116;
            if (z7) {
            } else {
            }
            view = obj38;
            if (size.v0() == -1) {
            }
            cVar2 = new c();
            cVar2.d = 1;
            cVar2.a = i9;
            cVar2.k = i32;
            i12 = i132;
            i27 = i13;
            com.google.android.flexbox.a aVar4 = obj4.a;
            view.measure(aVar4.l(i3, i75 += i10, size.v0()), i21);
            obj4.g(view, i29);
            if (size.J() == -1) {
            } else {
            }
            i39 = i3;
            view = obj38;
            i32 = i29;
            com.google.android.flexbox.a aVar5 = obj4.a;
            view = obj38;
            view.measure(i21, aVar5.s(i3, i61 += i10, size.J()));
            obj4.g(view, i29);
            if (i29 > 0) {
            } else {
            }
            i34 = i13;
            i36 = cVar;
            obj4.a(i30, i36, i34, i116);
            i45 += i116;
            i34 = i29 + -1;
            int i124 = 1;
            i19 = obj4.a.l(i33, i136 + i138, round);
            i37 = size3;
            aVar = 1;
            i38 = mode;
            i20 = obj4.a.s(i29, i128 += i10, obj4.y(size, aVar));
            view3.measure(i19, i20);
            obj4.Q(i32, i19, i20, view3);
            i17 = i19;
            i14 = 0;
            if (mode == 1073741824) {
            }
            round = Math.round(f *= cmp);
            cVar2.j.add(Integer.valueOf(i32));
            obj4.o((CompoundButton)view3);
            i24 = 1;
            cVar2.e = i67 += i24;
            cVar2.d = i69 += i24;
            if (obj4.G(i32, i27, cVar2)) {
            }
            obj2 = i4;
            i37 = size3;
            i38 = mode;
            i39 = i29;
            size3 = i30;
            mode = -1;
            i33 = 1;
            i13 = 0;
            i30 = list;
            list = i16;
            i16 = i27;
            obj4.a(list, cVar2, i32, i10);
            if (obj4.G(i32, i27, cVar2)) {
            }
            obj4.a(list, cVar2, i32, i10);
        }
        i23 = combineMeasuredStates;
        obj = a;
        obj.b = i23;
    }

    void c(com.google.android.flexbox.d.a d$a, int i2, int i3, int i4, int i5, List<com.google.android.flexbox.c> list6) {
        this.b(a, i2, i3, i4, i5, -1, list6);
    }

    void d(com.google.android.flexbox.d.a d$a, int i2, int i3, int i4, int i5, List<com.google.android.flexbox.c> list6) {
        this.b(a, i2, i3, i4, 0, i5, list6);
    }

    void e(com.google.android.flexbox.d.a d$a, int i2, int i3, int i4, int i5, List<com.google.android.flexbox.c> list6) {
        this.b(a, i3, i2, i4, i5, -1, list6);
    }

    void f(com.google.android.flexbox.d.a d$a, int i2, int i3, int i4, int i5, List<com.google.android.flexbox.c> list6) {
        this.b(a, i3, i2, i4, 0, i5, list6);
    }

    void h(List<com.google.android.flexbox.c> list, int i2) {
        int i3;
        int i;
        int i6 = -1;
        if (this.c[i2] == i6) {
            i3 = 0;
        }
        size--;
        while (i >= i3) {
            list.remove(i);
            i--;
        }
        int[] obj4 = this.c;
        length--;
        if (i2 > i4) {
            Arrays.fill(obj4, i6);
        } else {
            Arrays.fill(obj4, i2, i4, i6);
        }
        obj4 = this.d;
        length2--;
        int i7 = 0;
        if (i2 > i5) {
            Arrays.fill(obj4, i7);
        } else {
            Arrays.fill(obj4, i2, i5, i7);
        }
    }

    void i(int i, int i2) {
        j(i, i2, 0);
    }

    void j(int i, int i2, int i3) {
        int mode;
        int i4;
        int size;
        int i10;
        int i6;
        int i7;
        int i9;
        int[] iArr;
        int i11;
        Object obj;
        int i13;
        int i8;
        int i12;
        int i5;
        k(this.a.c());
        if (i3 >= this.a.c()) {
        }
        int i18 = this.a.f();
        int i19 = 1073741824;
        if (i18 != 0 && i18 != 1) {
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 != 3) {
                    } else {
                    }
                    StringBuilder obj13 = new StringBuilder();
                    obj13.append("Invalid flex direction: ");
                    obj13.append(this.a.f());
                    IllegalArgumentException obj12 = new IllegalArgumentException(obj13.toString());
                    throw obj12;
                }
                size = View.MeasureSpec.getSize(i2);
                if (View.MeasureSpec.getMode(i2) == i19) {
                } else {
                    size = this.a.h();
                }
                i4 = this.a.u();
                i10 = this.a.a();
            } else {
                i7 = this.a.h();
                if (View.MeasureSpec.getMode(i) == i19) {
                } else {
                    if (i7 > View.MeasureSpec.getSize(i)) {
                    } else {
                        size = i7;
                    }
                }
                i4 = this.a.v();
                i10 = this.a.p();
            }
        } else {
        }
        i4 += i10;
        i6 = 0;
        iArr = this.c;
        if (iArr != null) {
            i6 = iArr[i3];
        }
        List obj14 = this.a.r();
        i5 = i6;
        while (i5 < obj14.size()) {
            obj = obj2;
            i6 = obj.a;
            if (i6 < size && obj.m) {
            } else {
            }
            if (i6 > size && obj.n) {
            }
            i5++;
            if (obj.n) {
            }
            this.L(i, i2, (c)obj, size, i17, false);
            if (obj.m) {
            } else {
            }
            this.p(i, i2, obj, size, i17, false);
        }
    }

    void l(int i) {
        int iArr;
        int length;
        int obj3;
        iArr = this.c;
        if (iArr == null) {
            iArr = 10;
            if (i < iArr) {
                obj3 = iArr;
            }
            this.c = new int[obj3];
        } else {
            length2 *= 2;
            if (iArr.length < i && length >= i) {
                length2 *= 2;
                if (length >= i) {
                    obj3 = length;
                }
                this.c = Arrays.copyOf(iArr, obj3);
            }
        }
    }

    void m(int i) {
        int lArr;
        int length;
        int obj3;
        lArr = this.d;
        if (lArr == null) {
            lArr = 10;
            if (i < lArr) {
                obj3 = lArr;
            }
            this.d = new long[obj3];
        } else {
            length2 *= 2;
            if (lArr.length < i && length >= i) {
                length2 *= 2;
                if (length >= i) {
                    obj3 = length;
                }
                this.d = Arrays.copyOf(lArr, obj3);
            }
        }
    }

    void n(int i) {
        int lArr;
        int length;
        int obj3;
        lArr = this.e;
        if (lArr == null) {
            lArr = 10;
            if (i < lArr) {
                obj3 = lArr;
            }
            this.e = new long[obj3];
        } else {
            length2 *= 2;
            if (lArr.length < i && length >= i) {
                length2 *= 2;
                if (length >= i) {
                    obj3 = length;
                }
                this.e = Arrays.copyOf(lArr, obj3);
            }
        }
    }

    int q(long l) {
        return (int)obj2;
    }

    int r(long l) {
        return (int)l;
    }
}
