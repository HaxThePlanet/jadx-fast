package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import d.h.l.e0.c;
import d.h.l.e0.c.c;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {

    boolean I = false;
    int J = -1;
    int[] K;
    View[] L;
    final SparseIntArray M;
    final SparseIntArray N;
    androidx.recyclerview.widget.GridLayoutManager.c O;
    final Rect P;
    private boolean Q;

    public static abstract class c {

        final SparseIntArray a;
        final SparseIntArray b;
        private boolean c = false;
        private boolean d = false;
        public c() {
            super();
            SparseIntArray sparseIntArray = new SparseIntArray();
            this.a = sparseIntArray;
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            this.b = sparseIntArray2;
            int i = 0;
        }

        static int a(SparseIntArray sparseIntArray, int i2) {
            int i;
            int i3;
            int i4;
            int keyAt;
            int obj5;
            size--;
            i3 = 0;
            while (i3 <= i) {
                i6 >>>= 1;
                if (sparseIntArray.keyAt(i7) < i2) {
                } else {
                }
                i = i4;
                i3 = i4;
            }
            i3--;
            if (i5 >= 0 && i5 < sparseIntArray.size()) {
                if (i5 < sparseIntArray.size()) {
                    return sparseIntArray.keyAt(i5);
                }
            }
            return -1;
        }

        int b(int i, int i2) {
            if (!this.d) {
                return d(i, i2);
            }
            final int i4 = -1;
            int i3 = this.b.get(i, i4);
            if (i3 != i4) {
                return i3;
            }
            final int obj4 = d(i, i2);
            this.b.put(i, obj4);
            return obj4;
        }

        int c(int i, int i2) {
            if (!this.c) {
                return e(i, i2);
            }
            final int i4 = -1;
            int i3 = this.a.get(i, i4);
            if (i3 != i4) {
                return i3;
            }
            final int obj4 = e(i, i2);
            this.a.put(i, obj4);
            return obj4;
        }

        public int d(int i, int i2) {
            boolean z;
            int i7;
            int i4;
            int i3;
            int i5;
            int i6;
            final int i9 = 0;
            z = GridLayoutManager.c.a(this.b, i);
            if (this.d && z != -1) {
                z = GridLayoutManager.c.a(this.b, i);
                if (z != -1) {
                    i3 = z + 1;
                    if (i10 += z == i2) {
                        i4++;
                        i5 = i9;
                    }
                } else {
                    i5 = i3;
                }
            } else {
            }
            while (i3 < i) {
                i6 = f(i3);
                i5 += i6;
                if (i5 == i2) {
                } else {
                }
                if (i5 > i2) {
                }
                i3++;
                i4++;
                i5 = i6;
                i4++;
                i5 = i9;
            }
            if (i5 += i8 > i2) {
                i4++;
            }
            return i4;
        }

        public abstract int e(int i, int i2);

        public abstract int f(int i);

        public void g() {
            this.b.clear();
        }

        public void h() {
            this.a.clear();
        }
    }

    public static final class a extends androidx.recyclerview.widget.GridLayoutManager.c {
        @Override // androidx.recyclerview.widget.GridLayoutManager$c
        public int e(int i, int i2) {
            return i %= i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager$c
        public int f(int i) {
            return 1;
        }
    }

    public static class b extends androidx.recyclerview.widget.RecyclerView.q {

        int w = -1;
        int x = 0;
        public b(int i, int i2) {
            super(i, i2);
            int obj1 = -1;
            obj1 = 0;
        }

        public b(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            int obj1 = -1;
            obj1 = 0;
        }

        public b(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
            int obj1 = -1;
            obj1 = 0;
        }

        public b(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(marginLayoutParams);
            int obj1 = -1;
            obj1 = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int e() {
            return this.w;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int f() {
            return this.x;
        }
    }
    public GridLayoutManager(Context context, int i2, int i3, boolean z4) {
        super(context, i3, z4);
        int obj1 = 0;
        obj1 = -1;
        obj1 = new SparseIntArray();
        this.M = obj1;
        obj1 = new SparseIntArray();
        this.N = obj1;
        obj1 = new GridLayoutManager.a();
        this.O = obj1;
        obj1 = new Rect();
        this.P = obj1;
        z3(i2);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        int i = 0;
        int i2 = -1;
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.M = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        this.N = sparseIntArray2;
        GridLayoutManager.a aVar = new GridLayoutManager.a();
        this.O = aVar;
        Rect rect = new Rect();
        this.P = rect;
        z3(obj2.b);
    }

    private void A3() {
        int i;
        int i2;
        if (J2() == 1) {
            i5 -= i8;
            i2 = v();
        } else {
            i6 -= i9;
            i2 = u();
        }
        k3(i -= i2);
    }

    private void i3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, int i3, boolean z4) {
        int i2;
        int i4;
        int i;
        ViewGroup.LayoutParams layoutParams;
        int obj7;
        int obj8;
        if (z4) {
            obj8 = i5;
            i4 = i3;
            obj7 = i2;
        } else {
            i3--;
            obj8 = i4;
        }
        while (obj7 != i4) {
            View view = this.L[obj7];
            layoutParams = view.getLayoutParams();
            i = v3(w, b02, A0(view));
            layoutParams.x = i;
            layoutParams.w = i2;
            i2 += i;
            obj7 += obj8;
        }
    }

    private void j3() {
        int i4;
        int i3;
        int i2;
        SparseIntArray sparseIntArray;
        int i;
        i4 = 0;
        while (i4 < g0()) {
            ViewGroup.LayoutParams layoutParams = f0(i4).getLayoutParams();
            i2 = (GridLayoutManager.b)layoutParams.a();
            this.M.put(i2, layoutParams.f());
            this.N.put(i2, layoutParams.e());
            i4++;
        }
    }

    private void k3(int i) {
        this.K = GridLayoutManager.l3(this.K, this.J, i);
    }

    static int[] l3(int[] iArr, int i2, int i3) {
        int i4;
        int length;
        int i;
        int i7;
        int i5;
        int i6;
        int[] obj5;
        if (iArr != null && iArr.length == i2 + 1) {
            if (iArr.length == i2 + 1) {
                if (iArr[length2 -= i4] != i3) {
                    obj5 = new int[i2 + 1];
                }
            } else {
            }
        } else {
        }
        i = 0;
        obj5[i] = i;
        int i9 = i3 / i2;
        i3 %= i2;
        i5 = i;
        while (i4 <= i2) {
            i += obj7;
            if (i > 0 && i2 - i < obj7) {
            } else {
            }
            i6 = i9;
            obj5[i4] = i5 += i6;
            i4++;
            if (i2 - i < obj7) {
            } else {
            }
            i6 = i9 + 1;
            i -= i2;
        }
        return obj5;
    }

    private void m3() {
        this.M.clear();
        this.N.clear();
    }

    private int n3(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        int i2;
        View view;
        int i;
        View view2;
        int obj10;
        int i9 = 0;
        if (g0() != 0) {
            if (b0.c() == 0) {
            } else {
                p2();
                i2 = L2();
                i = 1;
                view = u2(i2 ^ 1, i);
                view2 = t2(i2 ^ 1, i);
                if (view != null) {
                    if (view2 == null) {
                    } else {
                        int i19 = this.O.b(A0(view), this.J);
                        int i23 = this.O.b(A0(view2), this.J);
                        if (this.x) {
                            obj10 = Math.max(i9, obj10 -= i);
                        } else {
                            obj10 = Math.max(i9, Math.min(i19, i23));
                        }
                        if (!i2) {
                            return obj10;
                        }
                    }
                    return Math.round(obj10 += f2);
                }
            }
        }
        return i9;
    }

    private int o3(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        int i;
        int i2;
        View view;
        if (g0() != 0) {
            if (b0.c() == 0) {
            } else {
                p2();
                i2 = 1;
                i = u2(z ^= i2, i2);
                view = t2(z3 ^= i2, i2);
                if (i != null) {
                    if (view == null) {
                    } else {
                        if (!L2()) {
                            return obj7 += i2;
                        }
                    }
                    return (int)i7;
                }
            }
        }
        return 0;
    }

    private void p3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.LinearLayoutManager.a linearLayoutManager$a3, int i4) {
        int i3;
        int i5;
        int i2;
        int i;
        int obj8;
        i3 = 1;
        obj8 = i4 == i3 ? i3 : 0;
        i5 = u3(w, b02, a3.b);
        if (obj8 != null) {
        } else {
            i3 = a3.b;
            while (i3 < obj8 -= i3) {
                i2 = i3 + 1;
                i = u3(w, b02, i2);
                if (i > i5) {
                }
                i3 = i2;
                i5 = i;
            }
            a3.b = i3;
        }
    }

    private void q3() {
        int length;
        int i;
        length = this.L;
        if (length != null) {
            if (length.length != this.J) {
                this.L = new View[this.J];
            }
        } else {
        }
    }

    private int t3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, int i3) {
        if (!b02.f()) {
            return this.O.b(i3, this.J);
        }
        int obj1 = w.f(i3);
        if (obj1 == -1) {
            obj1 = new StringBuilder();
            obj1.append("Cannot find span size for pre layout position. ");
            obj1.append(i3);
            Log.w("GridLayoutManager", obj1.toString());
            return 0;
        }
        return this.O.b(obj1, this.J);
    }

    private int u3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, int i3) {
        if (!b02.f()) {
            return this.O.c(i3, this.J);
        }
        final int i = -1;
        int obj3 = this.N.get(i3, i);
        if (obj3 != i) {
            return obj3;
        }
        int obj2 = w.f(i3);
        if (obj2 == i) {
            obj2 = new StringBuilder();
            obj2.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            obj2.append(i3);
            Log.w("GridLayoutManager", obj2.toString());
            return 0;
        }
        return this.O.c(obj2, this.J);
    }

    private int v3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, int i3) {
        if (!b02.f()) {
            return this.O.f(i3);
        }
        final int i = -1;
        int obj3 = this.M.get(i3, i);
        if (obj3 != i) {
            return obj3;
        }
        int obj2 = w.f(i3);
        if (obj2 == i) {
            obj2 = new StringBuilder();
            obj2.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            obj2.append(i3);
            Log.w("GridLayoutManager", obj2.toString());
            return 1;
        }
        return this.O.f(obj2);
    }

    private void w3(float f, int i2) {
        k3(Math.max(Math.round(f *= f2), i2));
    }

    private void x3(View view, int i2, boolean z3) {
        int i3;
        int i4;
        int i5;
        int i;
        int height;
        int i6;
        int obj10;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Rect rect = layoutParams.b;
        i11 += bottomMargin;
        i13 += rightMargin;
        int i9 = r3(layoutParams.w, layoutParams.x);
        final int i16 = 0;
        final int i17 = 1;
        if (this.s == i17) {
            obj10 = RecyclerView.p.h0(i9, i2, i, layoutParams.width, i16);
            i3 = RecyclerView.p.h0(this.u.n(), u0(), i5, layoutParams.height, i17);
        } else {
            i3 = obj10;
            obj10 = i6;
        }
        y3(view, obj10, i3, z3);
    }

    private void y3(View view, int i2, int i3, boolean z4) {
        boolean obj5;
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (z4) {
            obj5 = d2(view, i2, i3, (RecyclerView.q)layoutParams);
        } else {
            obj5 = b2(view, i2, i3, layoutParams);
        }
        if (obj5 != null) {
            view.measure(i2, i3);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int D0(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
        if (this.s == 0) {
            return this.J;
        }
        final int i5 = 1;
        if (b02.c() < i5) {
            return 0;
        }
        return obj3 += i5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View D2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, boolean z3, boolean z4) {
        int i;
        int i2;
        int i5;
        int i3;
        View view;
        int i4;
        int obj11;
        int obj12;
        if (z4 != 0) {
            obj11 -= i2;
            i2 = i;
        } else {
            i = obj11;
            obj11 = obj12;
        }
        p2();
        i3 = i5;
        while (obj11 != i) {
            view = f0(obj11);
            i4 = A0(view);
            obj11 += i2;
            if (i5 == 0) {
            }
            i5 = view;
            if (i3 == 0) {
            }
            i3 = view;
        }
        if (i5 != 0) {
        } else {
            i5 = i3;
        }
        return i5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public boolean J(androidx.recyclerview.widget.RecyclerView.q recyclerView$q) {
        return q instanceof GridLayoutManager.b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void M2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.LinearLayoutManager.c linearLayoutManager$c3, androidx.recyclerview.widget.LinearLayoutManager.b linearLayoutManager$b4) {
        int i4;
        int i15;
        int i16;
        boolean z;
        int i14;
        int i19;
        int i6;
        int i17;
        int i18;
        int i12;
        int i20;
        int i2;
        int i11;
        int measureSpec;
        int i5;
        int measureSpec2;
        int i9;
        int i;
        int cmp;
        int i7;
        int i13;
        int i8;
        View[] objArr;
        int layoutParams;
        int i10;
        int i3;
        final Object obj3 = this;
        androidx.recyclerview.widget.RecyclerView.w view = w;
        androidx.recyclerview.widget.RecyclerView.b0 view2 = b02;
        Object obj2 = c3;
        final Object obj4 = b4;
        i18 = obj3.u.l();
        final int i53 = 1;
        measureSpec = 0;
        i5 = i18 != 1073741824 ? i53 : measureSpec;
        if (g0() > 0) {
            measureSpec2 = obj3.K[obj3.J];
        } else {
            measureSpec2 = measureSpec;
        }
        if (i5 != 0) {
            A3();
        }
        i = obj2.e == i53 ? i53 : measureSpec;
        cmp = obj3.J;
        if (i == 0) {
            i64 += i13;
        }
        i8 = measureSpec;
        while (i8 < obj3.J) {
            layoutParams = obj2.d;
            i10 = obj3.v3(view, view2, layoutParams);
            i20 = obj2.d(view);
            obj3.L[i8] = i20;
            i8++;
            i20 = 1073741824;
        }
        if (i8 == 0) {
            obj4.b = i53;
        }
        i2 = 0;
        obj3.i3(view, view2, i8, i);
        i14 = i4;
        while (i4 < i8) {
            View view4 = obj3.L[i4];
            if (obj2.l == null) {
            } else {
            }
            if (i != 0) {
            } else {
            }
            obj3.z(view4, measureSpec);
            obj3.G(view4, obj3.P);
            obj3.x3(view4, i18, measureSpec);
            int i67 = obj3.u.e(view4);
            if (i67 > i14) {
            }
            i48 /= f2;
            if (Float.compare(i49, i2) > 0) {
            }
            i4++;
            measureSpec = 0;
            i2 = i49;
            i14 = i67;
            obj3.y(view4);
            if (i != 0) {
            } else {
            }
            obj3.B(view4, measureSpec);
            obj3.A(view4);
        }
        if (i5 != 0) {
            obj3.w3(i2, measureSpec2);
            i4 = 0;
            i14 = 0;
            while (i4 < i8) {
                View view3 = obj3.L[i4];
                obj3.x3(view3, 1073741824, i53);
                i18 = obj3.u.e(view3);
                if (i18 > i14) {
                }
                i4++;
                i14 = i18;
            }
        }
        i15 = 0;
        while (i15 < i8) {
            i18 = obj3.L[i15];
            if (obj3.u.e(i18) != i14) {
            } else {
            }
            i = 1073741824;
            cmp = 0;
            i15++;
            ViewGroup.LayoutParams layoutParams3 = i18.getLayoutParams();
            Rect rect = layoutParams3.b;
            i55 += bottomMargin;
            i58 += rightMargin;
            int i51 = obj3.r3(layoutParams3.w, layoutParams3.x);
            if (obj3.s == i53) {
            } else {
            }
            i = 1073741824;
            measureSpec = RecyclerView.p.h0(i51, i, i5, layoutParams3.height, false);
            i2 = measureSpec2;
            obj3.y3(i18, i2, measureSpec, i53);
            i = 1073741824;
            i2 = RecyclerView.p.h0(i51, i, measureSpec2, layoutParams3.width, false);
            measureSpec = View.MeasureSpec.makeMeasureSpec(i14 - i5, i);
        }
        i7 = 0;
        obj4.a = i14;
        int i40 = -1;
        if (obj3.s == i53) {
            if (obj2.f == i40) {
                i12 = i19;
            } else {
                int i23 = obj2.b;
                i12 = i23;
                i16 = i19;
            }
            i17 = i6;
        } else {
            if (obj2.f == i40) {
                int i26 = obj2.b;
                i17 = i29;
                i6 = i26;
                i16 = i12;
            } else {
                int i25 = obj2.b;
                i14 += i25;
                i17 = i25;
                i12 = i16;
            }
        }
        while (i7 < i8) {
            i5 = obj3.L[i7];
            measureSpec2 = layoutParams2;
            if (obj3.s == i53) {
            } else {
            }
            i27 += i41;
            i3 = i16;
            layoutParams = i6;
            i10 = i17;
            i = i12;
            this.T0(i5, i10, i3, layoutParams, i);
            if (!(GridLayoutManager.b)measureSpec2.c()) {
            } else {
            }
            obj4.c = i53;
            obj4.d = z2 |= focusable;
            i7++;
            i16 = i;
            i6 = layoutParams;
            i17 = i10;
            i12 = i3;
            if (measureSpec2.b()) {
            }
            if (K2()) {
            } else {
            }
            i31 += i34;
            i = i16;
            i10 = i6;
            layoutParams = i17;
            i3 = i12;
            i32 += i36;
            i = i16;
            layoutParams = i6;
            i10 = i17;
        }
        Arrays.fill(obj3.L, 0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int O(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (this.Q) {
            return n3(b0);
        }
        return super.O(b0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void O2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.LinearLayoutManager.a linearLayoutManager$a3, int i4) {
        int i;
        super.O2(w, b02, a3, i4);
        A3();
        if (b02.c() > 0 && !b02.f()) {
            if (!b02.f()) {
                p3(w, b02, a3, i4);
            }
        }
        q3();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int P(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (this.Q) {
            return o3(b0);
        }
        return super.P(b0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int R(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (this.Q) {
            return n3(b0);
        }
        return super.R(b0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int R1(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        A3();
        q3();
        return super.R1(i, w2, b03);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int S(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (this.Q) {
            return o3(b0);
        }
        return super.S(b0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int T1(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        A3();
        q3();
        return super.T1(i, w2, b03);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void Y1(Rect rect, int i2, int i3) {
        int i;
        int i4;
        int obj5;
        int obj6;
        int obj7;
        if (this.K == null) {
            super.Y1(rect, i2, i3);
        }
        i5 += i9;
        i10 += i12;
        final int i14 = 1;
        if (this.s == i14) {
            obj5 = RecyclerView.p.K(i3, obj5 += i4, y0());
            obj7 = this.K;
            obj6 = RecyclerView.p.K(i2, obj7 += i6, z0());
        } else {
            obj6 = RecyclerView.p.K(i2, obj5 += i6, z0());
            obj5 = this.K;
            obj5 = RecyclerView.p.K(i3, obj5 += i4, y0());
        }
        X1(obj6, obj5);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void Z2(boolean z) {
        if (z) {
        } else {
            super.Z2(false);
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        throw obj2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public androidx.recyclerview.widget.RecyclerView.q a0() {
        final int i2 = -2;
        final int i3 = -1;
        if (this.s == 0) {
            GridLayoutManager.b bVar = new GridLayoutManager.b(i2, i3);
            return bVar;
        }
        GridLayoutManager.b bVar2 = new GridLayoutManager.b(i3, i2);
        return bVar2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public androidx.recyclerview.widget.RecyclerView.q b0(Context context, AttributeSet attributeSet2) {
        GridLayoutManager.b bVar = new GridLayoutManager.b(context, attributeSet2);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public androidx.recyclerview.widget.RecyclerView.q c0(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            GridLayoutManager.b bVar = new GridLayoutManager.b((ViewGroup.MarginLayoutParams)layoutParams);
            return bVar;
        }
        GridLayoutManager.b bVar2 = new GridLayoutManager.b(layoutParams);
        return bVar2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View d1(View view, int i2, androidx.recyclerview.widget.RecyclerView.w recyclerView$w3, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b04) {
        androidx.recyclerview.widget.RecyclerView.w view3;
        androidx.recyclerview.widget.RecyclerView.b0 view4;
        View view2;
        int i7;
        int i14;
        int i10;
        int i9;
        int i;
        int i12;
        int i3;
        int i5;
        int layoutParams;
        int i15;
        int focusable;
        int i6;
        int i13;
        int i18;
        int i19;
        int i4;
        int i17;
        boolean focusable2;
        int i8;
        boolean focusable3;
        int i16;
        int i11;
        boolean z;
        final Object obj = this;
        view2 = Y(view);
        i7 = 0;
        if (view2 == null) {
            return i7;
        }
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        final int i25 = layoutParams2.w;
        i23 += i25;
        if (super.d1(view, i2, w3, b04) == null) {
            return i7;
        }
        layoutParams = 1;
        i14 = obj.n2(i2) == layoutParams ? layoutParams : 0;
        i10 = i14 != obj.x ? layoutParams : 0;
        int i31 = -1;
        if (i10 != 0) {
            i29 -= layoutParams;
            i6 = focusable;
        } else {
            focusable = i28;
            i6 = layoutParams;
            i9 = 0;
        }
        if (obj.s == layoutParams && K2()) {
            i13 = K2() ? layoutParams : 0;
        } else {
        }
        i4 = i19;
        i3 = 0;
        i17 = 0;
        i15 = i9;
        i = i7;
        while (i15 != focusable) {
            view3 = obj.f0(i15);
            layoutParams = view3.getLayoutParams();
            view4 = layoutParams.w;
            focusable2 = view2;
            i21 += view4;
            if (view3.hasFocusable()) {
            } else {
            }
            if (!view3.hasFocusable() && i == 0) {
            } else {
            }
            i11 = i;
            i = i16 - i33;
            if (view3.hasFocusable()) {
            } else {
            }
            if (i7 == 0) {
            } else {
            }
            i8 = i3;
            i16 = focusable;
            i12 = i4;
            i5 = i17;
            focusable = 0;
            if (focusable != 0) {
            } else {
            }
            i4 = i12;
            i17 = i5;
            i3 = i8;
            i = i11;
            i15 += i6;
            view3 = w3;
            view4 = b04;
            view2 = focusable2;
            focusable = i16;
            layoutParams = 1;
            if (view3.hasFocusable()) {
            } else {
            }
            i17 = view2 - view4;
            i4 = i30;
            i3 = i8;
            i = view3;
            i19 = i22;
            i4 = i12;
            i17 = i5;
            i = i11;
            i7 = view3;
            i3 = view4;
            i8 = i3;
            i16 = focusable;
            if (obj.S0(view3, false, true)) {
            } else {
            }
            i5 = i17;
            if (i > i5) {
            } else {
            }
            if (i == i5) {
            } else {
            }
            i12 = i4;
            if (view4 > i4) {
            } else {
            }
            focusable = 0;
            if (i13 == focusable) {
            } else {
            }
            focusable = 1;
            i12 = i4;
            if (i > i3) {
            } else {
            }
            if (i == i3) {
            } else {
            }
            if (view4 > i19) {
            } else {
            }
            i = 0;
            if (i13 == i) {
            } else {
            }
            i8 = i3;
            i16 = focusable;
            i12 = i4;
            i5 = i17;
            i = 1;
            if (i == 0) {
            } else {
            }
            i11 = i;
            if (i7 != 0) {
            } else {
            }
            focusable2 = view2;
            i11 = i;
            i8 = i3;
            i16 = focusable;
            i12 = i4;
            i5 = i17;
        }
        if (i7 != 0) {
        } else {
            i7 = i34;
        }
        return i7;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public boolean h2() {
        androidx.recyclerview.widget.LinearLayoutManager.d dVar;
        int i;
        if (this.D == null && !this.I) {
            i = !this.I ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void j1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, View view3, c c4) {
        int i4;
        int i3;
        int i2;
        int i;
        int i5;
        int i6;
        c.c obj8;
        final ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (!layoutParams instanceof GridLayoutManager.b) {
            super.i1(view3, c4);
        }
        obj8 = t3(w, b02, (GridLayoutManager.b)layoutParams.a());
        if (this.s == 0) {
            c4.a0(c.c.a(layoutParams.e(), layoutParams.f(), obj8, 1, false, false));
        } else {
            c4.a0(c.c.a(obj8, 1, layoutParams.e(), layoutParams.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void j2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.LinearLayoutManager.c linearLayoutManager$c2, androidx.recyclerview.widget.RecyclerView.p.c recyclerView$p$c3) {
        int i5;
        int i;
        int i2;
        int i3;
        int i4;
        i5 = this.J;
        final int i6 = 0;
        i = i6;
        while (i < this.J) {
            if (c2.c(b0)) {
            }
            if (i5 > 0) {
            }
            int i7 = c2.d;
            c3.a(i7, Math.max(i6, c2.g));
            i5 -= i8;
            c2.d = i9 += i4;
            i++;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int k0(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
        final int i5 = 1;
        if (this.s == i5) {
            return this.J;
        }
        if (b02.c() < i5) {
            return 0;
        }
        return obj3 += i5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void l1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void m1(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void n1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3, int i4) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void o1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void q1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3, Object object4) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void r1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
        if (b02.f()) {
            j3();
        }
        super.r1(w, b02);
        m3();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    int r3(int i, int i2) {
        int i3;
        if (this.s == 1 && K2()) {
            if (K2()) {
                int[] iArr2 = this.K;
                int i5 = this.J;
                return i9 -= obj4;
            }
        }
        int[] iArr = this.K;
        return obj5 -= obj4;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void s1(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        super.s1(b0);
        this.I = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int s3() {
        return this.J;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void z3(int i) {
        if (i == this.J) {
        }
        int i3 = 1;
        this.I = i3;
        if (i < i3) {
        } else {
            this.J = i;
            this.O.h();
            O1();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Span count should be at least 1. Provided ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}
