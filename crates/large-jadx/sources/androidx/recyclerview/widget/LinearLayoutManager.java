package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends androidx.recyclerview.widget.RecyclerView.p implements androidx.recyclerview.widget.l.j, androidx.recyclerview.widget.RecyclerView.a0.b {

    int A;
    int B;
    private boolean C;
    androidx.recyclerview.widget.LinearLayoutManager.d D;
    final androidx.recyclerview.widget.LinearLayoutManager.a E;
    private final androidx.recyclerview.widget.LinearLayoutManager.b F;
    private int G;
    private int[] H;
    int s;
    private androidx.recyclerview.widget.LinearLayoutManager.c t;
    androidx.recyclerview.widget.t u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    static class a {

        androidx.recyclerview.widget.t a;
        int b;
        int c;
        boolean d;
        boolean e;
        a() {
            super();
            e();
        }

        void a() {
            int i;
            if (this.d) {
                i = this.a.i();
            } else {
                i = this.a.m();
            }
            this.c = i;
        }

        public void b(View view, int i2) {
            int i;
            int obj2;
            if (this.d) {
                this.c = obj2 += i;
            } else {
                this.c = this.a.g(view);
            }
            this.b = i2;
        }

        public void c(View view, int i2) {
            int i3;
            int i;
            androidx.recyclerview.widget.t tVar;
            View obj5;
            int obj6;
            i3 = this.a.o();
            if (i3 >= 0) {
                b(view, i2);
            }
            this.b = i2;
            final int i8 = 0;
            if (this.d) {
                obj6 -= i4;
                this.c = i5 -= obj6;
                int i7 = this.a.m();
                i10 -= i3;
                if (obj6 > 0 && i < 0) {
                    i7 = this.a.m();
                    i10 -= i3;
                    if (i < 0) {
                        this.c = obj5 += obj6;
                    }
                }
            } else {
                obj6 = this.a.g(view);
                i = obj6 - i11;
                this.c = obj6;
                obj5 -= obj6;
                if (i > 0 && obj5 < 0) {
                    obj5 -= obj6;
                    if (obj5 < 0) {
                        this.c = obj6 -= obj5;
                    }
                }
            }
        }

        boolean d(View view, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
            int z;
            int obj2;
            int obj3;
            obj2 = view.getLayoutParams();
            if (!(RecyclerView.q)obj2.c() && obj2.a() >= 0 && obj2.a() < b02.c()) {
                if (obj2.a() >= 0) {
                    obj2 = obj2.a() < b02.c() ? 1 : 0;
                } else {
                }
            } else {
            }
            return obj2;
        }

        void e() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            int i3 = 0;
            this.d = i3;
            this.e = i3;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AnchorInfo{mPosition=");
            stringBuilder.append(this.b);
            stringBuilder.append(", mCoordinate=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mLayoutFromEnd=");
            stringBuilder.append(this.d);
            stringBuilder.append(", mValid=");
            stringBuilder.append(this.e);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    protected static class b {

        public int a;
        public boolean b;
        public boolean c;
        public boolean d;
        void a() {
            final int i = 0;
            this.a = i;
            this.b = i;
            this.c = i;
            this.d = i;
        }
    }

    static class c {

        boolean a = true;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        int i = 0;
        boolean j;
        int k;
        List<androidx.recyclerview.widget.RecyclerView.e0> l = null;
        boolean m;
        c() {
            super();
            int i = 1;
            int i2 = 0;
            int i3 = 0;
        }

        private View e() {
            int i;
            View itemView;
            android.view.ViewGroup.LayoutParams layoutParams;
            boolean z;
            i = 0;
            while (i < this.l.size()) {
                itemView = obj.itemView;
                layoutParams = itemView.getLayoutParams();
                i++;
            }
            return null;
        }

        public void a() {
            b(0);
        }

        public void b(View view) {
            int obj1;
            obj1 = f(view);
            if (obj1 == null) {
                this.d = -1;
            } else {
                this.d = (RecyclerView.q)obj1.getLayoutParams().a();
            }
        }

        boolean c(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
            int obj2;
            final int i = this.d;
            if (i >= 0 && i < b0.c()) {
                obj2 = i < b0.c() ? 1 : 0;
            } else {
            }
            return obj2;
        }

        View d(androidx.recyclerview.widget.RecyclerView.w recyclerView$w) {
            if (this.l != null) {
                return e();
            }
            this.d = i2 += i4;
            return w.o(this.d);
        }

        public View f(View view) {
            int i4;
            int i2;
            int i3;
            View itemView;
            android.view.ViewGroup.LayoutParams layoutParams;
            int i;
            i4 = 0;
            i2 = Integer.MAX_VALUE;
            i3 = 0;
            while (i3 < this.l.size()) {
                itemView = obj.itemView;
                layoutParams = itemView.getLayoutParams();
                if (itemView != view) {
                    break;
                } else {
                }
                i3++;
                if (!(RecyclerView.q)layoutParams.c()) {
                    break;
                } else {
                }
                i6 *= i;
                if (layoutParams >= 0) {
                    break;
                } else {
                }
                if (layoutParams < i2) {
                    break;
                } else {
                }
                i4 = itemView;
                if (layoutParams == 0) {
                    break;
                } else {
                }
                i2 = layoutParams;
            }
            return i4;
        }
    }

    public static class d implements Parcelable {

        public static final Parcelable.Creator<androidx.recyclerview.widget.LinearLayoutManager.d> CREATOR;
        int a;
        int b;
        boolean c;
        static {
            LinearLayoutManager.d.a aVar = new LinearLayoutManager.d.a();
            LinearLayoutManager.d.CREATOR = aVar;
        }

        d(Parcel parcel) {
            int i;
            super();
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            if (parcel.readInt() == 1) {
            } else {
                i = 0;
            }
            this.c = i;
        }

        public d(androidx.recyclerview.widget.LinearLayoutManager.d linearLayoutManager$d) {
            super();
            this.a = d.a;
            this.b = d.b;
            this.c = d.c;
        }

        @Override // android.os.Parcelable
        boolean a() {
            int i;
            i = this.a >= 0 ? 1 : 0;
            return i;
        }

        @Override // android.os.Parcelable
        void b() {
            this.a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
        }
    }
    public LinearLayoutManager(Context context) {
        super(context, 1, 0);
    }

    public LinearLayoutManager(Context context, int i2, boolean z3) {
        super();
        int obj2 = 1;
        this.s = obj2;
        final int i = 0;
        this.w = i;
        this.x = i;
        this.y = i;
        this.z = obj2;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = 0;
        obj2 = new LinearLayoutManager.a();
        this.E = obj2;
        obj2 = new LinearLayoutManager.b();
        this.F = obj2;
        obj2 = 2;
        this.G = obj2;
        this.H = new int[obj2];
        X2(i2);
        Y2(z3);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super();
        int i = 1;
        this.s = i;
        final int i8 = 0;
        this.w = i8;
        this.x = i8;
        this.y = i8;
        this.z = i;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = 0;
        LinearLayoutManager.a aVar = new LinearLayoutManager.a();
        this.E = aVar;
        LinearLayoutManager.b bVar = new LinearLayoutManager.b();
        this.F = bVar;
        int i7 = 2;
        this.G = i7;
        this.H = new int[i7];
        androidx.recyclerview.widget.RecyclerView.p.d obj3 = RecyclerView.p.B0(context, attributeSet2, i3, i4);
        X2(obj3.a);
        Y2(obj3.c);
        Z2(obj3.d);
    }

    private View B2() {
        View view;
        if (this.x) {
            view = s2();
        } else {
            view = x2();
        }
        return view;
    }

    private View C2() {
        View view;
        if (this.x) {
            view = x2();
        } else {
            view = s2();
        }
        return view;
    }

    private int E2(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03, boolean z4) {
        androidx.recyclerview.widget.RecyclerView.b0 obj4;
        i2 -= i;
        int obj3 = -obj3;
        obj4 -= obj2;
        if (i3 > 0 && z4 && obj4 > 0) {
            obj3 = -obj3;
            if (z4) {
                obj4 -= obj2;
                if (obj4 > 0) {
                    this.u.r(obj4);
                    return obj4 += obj3;
                }
            }
            return obj3;
        }
        return 0;
    }

    private int F2(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03, boolean z4) {
        int obj2;
        int obj3;
        androidx.recyclerview.widget.RecyclerView.b0 obj4;
        int obj5;
        int i3 = i - i2;
        obj3 = -obj3;
        obj2 -= obj4;
        if (i3 > 0 && z4 != 0 && obj2 > 0) {
            obj3 = -obj3;
            if (z4 != 0) {
                obj2 -= obj4;
                if (obj2 > 0) {
                    this.u.r(-obj2);
                    obj3 -= obj2;
                }
            }
            return obj3;
        }
        return 0;
    }

    private View G2() {
        int i;
        if (this.x) {
            i = 0;
        } else {
            i2--;
        }
        return f0(i);
    }

    private View H2() {
        int i;
        if (this.x) {
            i2--;
        } else {
            i = 0;
        }
        return f0(i);
    }

    private void N2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, int i3, int i4) {
        Object view;
        androidx.recyclerview.widget.RecyclerView.b0 view2;
        Object z2;
        androidx.recyclerview.widget.LinearLayoutManager.c cVar;
        int i2;
        int i9;
        int i7;
        int i;
        int i8;
        int i11;
        androidx.recyclerview.widget.t removed;
        int i5;
        int i6;
        boolean z;
        int i10;
        final Object obj = this;
        view = w;
        view2 = b02;
        if (b02.h() && g0() != 0 && !b02.f()) {
            if (g0() != 0) {
                if (!b02.f()) {
                    if (!h2()) {
                    } else {
                        z2 = w.k();
                        i2 = 0;
                        i8 = i;
                        while (i7 < z2.size()) {
                            i11 = z2.get(i7);
                            if ((RecyclerView.e0)i11.isRemoved()) {
                            } else {
                            }
                            if (i11.getLayoutPosition() < A0(f0(i2))) {
                            } else {
                            }
                            i5 = i2;
                            i10 = -1;
                            if (i5 != obj.x) {
                            }
                            if (i6 == i10) {
                            } else {
                            }
                            i8 += i11;
                            i7++;
                            i += i11;
                            i6 = i10;
                            i5 = i6;
                        }
                        cVar.l = z2;
                        if (i > 0) {
                            g3(A0(H2()), i3);
                            androidx.recyclerview.widget.LinearLayoutManager.c cVar3 = obj.t;
                            cVar3.h = i;
                            cVar3.c = i2;
                            cVar3.a();
                            q2(view, obj.t, view2, i2);
                        }
                        if (i8 > 0) {
                            e3(A0(G2()), i4);
                            androidx.recyclerview.widget.LinearLayoutManager.c cVar2 = obj.t;
                            cVar2.h = i8;
                            cVar2.c = i2;
                            cVar2.a();
                            q2(view, obj.t, view2, i2);
                        }
                        view.l = 0;
                    }
                }
            }
        }
    }

    private void P2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.LinearLayoutManager.c linearLayoutManager$c2) {
        boolean z;
        int i2;
        int i;
        Object obj5;
        if (c2.a) {
            if (c2.m) {
            } else {
                z = c2.g;
                i2 = c2.i;
                if (c2.f == -1) {
                    R2(w, z, i2);
                } else {
                    S2(w, z, i2);
                }
            }
        }
    }

    private void Q2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, int i2, int i3) {
        int obj2;
        int obj3;
        if (i2 == i3) {
        }
        if (i3 > i2) {
            i3--;
            while (obj3 >= i2) {
                I1(obj3, w);
                obj3--;
            }
        }
    }

    private void R2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, int i2, int i3) {
        int i;
        int i4;
        androidx.recyclerview.widget.t tVar;
        int obj6;
        int obj7;
        i = g0();
        if (i2 < 0) {
        }
        i6 += i3;
        if (this.x) {
            obj6 = 0;
            obj7 = obj6;
            while (obj7 < i) {
                i4 = f0(obj7);
                obj7++;
            }
        } else {
            i--;
            obj6 = i;
            while (obj6 >= 0) {
                obj7 = f0(obj6);
                obj6--;
            }
        }
    }

    private void S2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, int i2, int i3) {
        int i5;
        int i;
        androidx.recyclerview.widget.t tVar;
        int i4;
        int obj7;
        if (i2 < 0) {
        }
        i2 -= i3;
        obj7 = g0();
        if (this.x) {
            obj7--;
            i5 = obj7;
            while (i5 >= 0) {
                i = f0(i5);
                i5--;
            }
        } else {
            i5 = 0;
            i = i5;
            while (i < obj7) {
                tVar = f0(i);
                i++;
            }
        }
    }

    private void U2() {
        int i2;
        int i;
        final int i3 = 1;
        if (this.s != i3) {
            if (!K2()) {
                this.x = this.w;
            } else {
                this.x = z ^= i3;
            }
        } else {
        }
    }

    private boolean a3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.LinearLayoutManager.a linearLayoutManager$a3) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        View obj6;
        boolean obj7;
        i2 = 0;
        if (g0() == 0) {
            return i2;
        }
        View view = s0();
        final int i5 = 1;
        if (view != null && a3.d(view, b02)) {
            if (a3.d(view, b02)) {
                a3.c(view, A0(view));
                return i5;
            }
        }
        z2 = this.y;
        if (this.v != z2) {
            return i2;
        }
        obj6 = D2(w, b02, a3.d, z2);
        a3.b(obj6, A0(obj6));
        if (obj6 != null && !b02.f() && h2()) {
            a3.b(obj6, A0(obj6));
            if (!b02.f()) {
                if (h2()) {
                    obj7 = this.u.g(obj6);
                    obj6 = this.u.d(obj6);
                    i = this.u.m();
                    z2 = this.u.i();
                    if (obj6 <= i && obj7 < i) {
                        i3 = obj7 < i ? i5 : i2;
                    } else {
                    }
                    if (obj7 >= z2 && obj6 > z2) {
                        if (obj6 > z2) {
                            i2 = i5;
                        }
                    }
                    if (i3 == 0) {
                        if (i2 != 0 && a3.d) {
                            if (a3.d) {
                                i = z2;
                            }
                            a3.c = i;
                        }
                    } else {
                    }
                }
            }
            return i5;
        }
        return i2;
    }

    private boolean b3(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.LinearLayoutManager.a linearLayoutManager$a2) {
        boolean z;
        int i5;
        int i;
        int i2;
        int i3;
        int i4;
        int obj5;
        i = 0;
        if (!b0.f()) {
            z = this.A;
            i3 = -1;
            if (z == i3) {
            } else {
                i4 = Integer.MIN_VALUE;
                if (z >= 0) {
                    if (z >= b0.c()) {
                    } else {
                        a2.b = this.A;
                        obj5 = this.D;
                        int i6 = 1;
                        if (obj5 != null && obj5.a()) {
                            if (obj5.a()) {
                                obj5 = obj5.c;
                                a2.d = obj5;
                                if (obj5 != null) {
                                    a2.c = obj5 -= i2;
                                } else {
                                    a2.c = obj5 += i2;
                                }
                                return i6;
                            }
                        }
                        if (this.B == i4) {
                            obj5 = Z(this.A);
                            if (obj5 != null) {
                                if (this.u.e(obj5) > this.u.n()) {
                                    a2.a();
                                    return i6;
                                }
                                if (i11 -= i4 < 0) {
                                    a2.c = this.u.m();
                                    a2.d = i;
                                    return i6;
                                }
                                if (i7 -= i3 < 0) {
                                    a2.c = this.u.i();
                                    a2.d = i6;
                                    return i6;
                                }
                                if (a2.d) {
                                    obj5 += i;
                                } else {
                                    obj5 = this.u.g(obj5);
                                }
                                a2.c = obj5;
                            } else {
                                if (g0() > 0) {
                                    obj5 = this.A < A0(f0(i)) ? i6 : i;
                                    if (obj5 == this.x) {
                                        i = i6;
                                    }
                                    a2.d = i;
                                }
                                a2.a();
                            }
                            return i6;
                        }
                        obj5 = this.x;
                        a2.d = obj5;
                        if (obj5 != null) {
                            a2.c = obj5 -= i5;
                        } else {
                            a2.c = obj5 += i5;
                        }
                    }
                    return i6;
                }
                this.A = i3;
                this.B = i4;
            }
        }
        return i;
    }

    private void c3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.LinearLayoutManager.a linearLayoutManager$a3) {
        int obj2;
        if (b3(b02, a3)) {
        }
        if (a3(w, b02, a3)) {
        }
        a3.a();
        if (this.y) {
            obj2--;
        } else {
            obj2 = 0;
        }
        a3.b = obj2;
    }

    private void d3(int i, int i2, boolean z3, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b04) {
        androidx.recyclerview.widget.LinearLayoutManager.c cVar2;
        int i3;
        androidx.recyclerview.widget.LinearLayoutManager.c cVar;
        int i4;
        int i5;
        int i7;
        int i6;
        int obj5;
        int obj6;
        int obj8;
        cVar3.m = T2();
        cVar4.f = i;
        int[] iArr = this.H;
        i3 = 0;
        iArr[i3] = i3;
        i4 = 1;
        iArr[i4] = i3;
        i2(b04, iArr);
        int i9 = Math.max(i3, this.H[i4]);
        if (i == i4) {
            i3 = i4;
        }
        obj5 = this.t;
        i7 = i3 != 0 ? i9 : obj8;
        obj5.h = i7;
        if (i3 != 0) {
        } else {
            obj8 = i9;
        }
        obj5.i = obj8;
        obj8 = -1;
        if (i3 != 0) {
            obj5.h = i7 += i10;
            obj5 = G2();
            cVar2 = this.t;
            if (this.x) {
                i4 = obj8;
            }
            cVar2.e = i4;
            cVar = this.t;
            cVar2.d = obj8 += i5;
            cVar.b = this.u.d(obj5);
            obj5 -= obj8;
        } else {
            obj5 = H2();
            androidx.recyclerview.widget.LinearLayoutManager.c cVar5 = this.t;
            cVar5.h = i11 += i6;
            cVar2 = this.t;
            if (this.x) {
            } else {
                i4 = obj8;
            }
            cVar2.e = i4;
            cVar = this.t;
            cVar2.d = obj8 += i5;
            cVar.b = this.u.g(obj5);
            obj5 += obj8;
        }
        obj8 = this.t;
        obj8.c = i2;
        if (z3) {
            obj8.c = i2 -= obj5;
        }
        obj8.g = obj5;
    }

    private void e3(int i, int i2) {
        int i3;
        cVar.c = i4 -= i2;
        androidx.recyclerview.widget.LinearLayoutManager.c cVar2 = this.t;
        final int i6 = 1;
        i3 = this.x ? -1 : i6;
        cVar2.e = i3;
        cVar2.d = i;
        cVar2.f = i6;
        cVar2.b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    private void f3(androidx.recyclerview.widget.LinearLayoutManager.a linearLayoutManager$a) {
        e3(a.b, a.c);
    }

    private void g3(int i, int i2) {
        int obj3;
        cVar.c = i2 - i3;
        androidx.recyclerview.widget.LinearLayoutManager.c cVar2 = this.t;
        cVar2.d = i;
        int i5 = -1;
        obj3 = this.x ? 1 : i5;
        cVar2.e = obj3;
        cVar2.f = i5;
        cVar2.b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    private void h3(androidx.recyclerview.widget.LinearLayoutManager.a linearLayoutManager$a) {
        g3(a.b, a.c);
    }

    private int k2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (g0() == 0) {
            return 0;
        }
        p2();
        int i4 = 1;
        return w.a(b0, this.u, u2(z ^= i4, i4), t2(z2 ^= i4, i4), this, this.z);
    }

    private int l2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (g0() == 0) {
            return 0;
        }
        p2();
        int i4 = 1;
        return w.b(b0, this.u, u2(z ^= i4, i4), t2(z2 ^= i4, i4), this, this.z, this.x);
    }

    private int m2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (g0() == 0) {
            return 0;
        }
        p2();
        int i4 = 1;
        return w.c(b0, this.u, u2(z ^= i4, i4), t2(z2 ^= i4, i4), this, this.z);
    }

    private View s2() {
        return z2(0, g0());
    }

    private View x2() {
        return z2(i--, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    View A2(int i, int i2, boolean z3, boolean z4) {
        int i3;
        View obj2;
        int obj4;
        androidx.recyclerview.widget.a0 obj5;
        p2();
        obj4 = z3 ? 24579 : i3;
        if (z4) {
        } else {
            i3 = 0;
        }
        if (this.s == 0) {
            obj2 = this.e.a(i, i2, obj4, i3);
        } else {
            obj2 = this.f.a(i, i2, obj4, i3);
        }
        return obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void D(String string) {
        if (this.D == null) {
            super.D(string);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    View D2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, boolean z3, boolean z4) {
        int i9;
        int i2;
        int i5;
        int i;
        int i3;
        int i7;
        View view;
        int i6;
        int i4;
        int i8;
        final Object obj = this;
        p2();
        final int i12 = 0;
        final int i13 = 1;
        if (z4) {
            i11 -= i13;
            i5 = i2;
        } else {
            i2 = i10;
            i9 = i12;
            i5 = i13;
        }
        int i15 = obj.u.m();
        int i16 = obj.u.i();
        i7 = i3;
        while (i9 != i2) {
            view = obj.f0(i9);
            i6 = obj.A0(view);
            i4 = obj.u.g(view);
            i8 = obj.u.d(view);
            i9 += i5;
            if (i8 <= i15 && i4 < i15) {
            } else {
            }
            i6 = i12;
            if (i4 >= i16 && i8 > i16) {
            } else {
            }
            i4 = i12;
            if (z3) {
            } else {
            }
            if (i6 != 0) {
            } else {
            }
            if (i == 0) {
            }
            i = view;
            i3 = view;
            if (i4 != 0) {
            } else {
            }
            if (i == 0) {
            }
            if (i8 > i16) {
            } else {
            }
            i4 = i13;
            if (i4 < i15) {
            } else {
            }
            i6 = i13;
            if (i7 == 0) {
            }
            i7 = view;
        }
        if (i != 0) {
        } else {
            i = i3 != 0 ? i3 : i7;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean H() {
        int i;
        i = this.s == 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean I() {
        int i;
        if (this.s == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Deprecated
    protected int I2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (b0.e()) {
            return this.u.n();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int J2() {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    protected boolean K2() {
        int i;
        if (w0() == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void L(int i, int i2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03, androidx.recyclerview.widget.RecyclerView.p.c recyclerView$p$c4) {
        int i3;
        int obj2;
        int obj3;
        if (this.s == 0) {
        } else {
            obj2 = i2;
        }
        if (g0() != 0) {
            if (obj2 == null) {
            } else {
                p2();
                obj3 = 1;
                i3 = obj2 > 0 ? obj3 : -1;
                d3(i3, Math.abs(obj2), obj3, b03);
                j2(b03, this.t, c4);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean L0() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean L2() {
        return this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void M(int i, androidx.recyclerview.widget.RecyclerView.p.c recyclerView$p$c2) {
        androidx.recyclerview.widget.LinearLayoutManager.d dVar;
        int i4;
        int i3;
        boolean z;
        int i5;
        int i2;
        dVar = this.D;
        final int i6 = 0;
        if (dVar != null && dVar.a()) {
            if (dVar.a()) {
                androidx.recyclerview.widget.LinearLayoutManager.d dVar2 = this.D;
                z = dVar2.c;
                i4 = dVar2.a;
            } else {
                U2();
                if (this.A == -1) {
                    i4 = this.x ? i + -1 : i6;
                }
            }
        } else {
        }
        if (z) {
        } else {
            i3 = 1;
        }
        i5 = i6;
        while (i5 < this.G) {
            if (i4 >= 0) {
            }
            if (i4 < i) {
            }
            c2.a(i4, i6);
            i4 += i3;
            i5++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    void M2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.LinearLayoutManager.c linearLayoutManager$c3, androidx.recyclerview.widget.LinearLayoutManager.b linearLayoutManager$b4) {
        boolean z;
        int i2;
        int i5;
        int i;
        int i6;
        int i4;
        int i3;
        int i7;
        int obj10;
        View obj8 = c3.d(w);
        final int obj9 = 1;
        if (obj8 == null) {
            b4.b = obj9;
        }
        final android.view.ViewGroup.LayoutParams view2 = layoutParams;
        int i12 = -1;
        int i17 = 0;
        if (c3.l == null) {
            i6 = c3.f == i12 ? obj9 : i17;
            if (this.x == i6) {
                A(obj8);
            } else {
                B(obj8, i17);
            }
        } else {
            i6 = c3.f == i12 ? obj9 : i17;
            if (this.x == i6) {
                y(obj8);
            } else {
                z(obj8, i17);
            }
        }
        U0(obj8, i17, i17);
        b4.a = this.u.e(obj8);
        if (this.s == obj9) {
            if (K2()) {
                i = i2 - i21;
            } else {
                i10 += i;
            }
            if (c3.f == i12) {
                obj10 = c3.b;
                i7 = obj10;
                i3 = i2;
                i4 = i5;
            } else {
                obj10 = c3.b;
                i4 = obj10;
                i3 = i2;
                i7 = i5;
            }
        } else {
            i2 = u();
            i18 += i2;
            if (c3.f == i12) {
                obj10 = c3.b;
                i3 = obj10;
                i4 = i2;
                i7 = i19;
                i = i5;
            } else {
                obj10 = c3.b;
                i4 = i2;
                i3 = i5;
                i7 = i19;
                i = obj10;
            }
        }
        this.T0(obj8, i, i4, i3, i7);
        if (!(RecyclerView.q)view2.c()) {
            if (view2.b()) {
                b4.c = obj9;
            }
        } else {
        }
        b4.d = obj8.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int N(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return k2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int O(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return l2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    void O2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.LinearLayoutManager.a linearLayoutManager$a3, int i4) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int P(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return m2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int Q(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return k2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int R(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return l2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int R1(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        if (this.s == 1) {
            return 0;
        }
        return V2(i, w2, b03);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int S(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return m2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void S1(int i) {
        this.A = i;
        this.B = Integer.MIN_VALUE;
        androidx.recyclerview.widget.LinearLayoutManager.d obj1 = this.D;
        if (obj1 != null) {
            obj1.b();
        }
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int T1(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        if (this.s == 0) {
            return 0;
        }
        return V2(i, w2, b03);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    boolean T2() {
        int i;
        int i2;
        if (this.u.k() == 0 && this.u.h() == 0) {
            i2 = this.u.h() == 0 ? 1 : 0;
        } else {
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    int V2(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        int i2;
        int obj6;
        final int i4 = 0;
        if (g0() != 0) {
            if (i == 0) {
            } else {
                p2();
                int i5 = 1;
                cVar.a = i5;
                i2 = i > 0 ? i5 : -1;
                final int i6 = Math.abs(i);
                d3(i2, i6, i5, b03);
                androidx.recyclerview.widget.LinearLayoutManager.c cVar2 = this.t;
                i7 += obj7;
                if (i8 < 0) {
                    return i4;
                }
                if (i6 > i8) {
                    obj6 = i2 * i8;
                }
            }
            this.u.r(-obj6);
            obj7.k = obj6;
            return obj6;
        }
        return i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void W2(int i, int i2) {
        this.A = i;
        this.B = i2;
        final androidx.recyclerview.widget.LinearLayoutManager.d obj1 = this.D;
        if (obj1 != null) {
            obj1.b();
        }
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void X2(int i) {
        int i3;
        androidx.recyclerview.widget.t i2;
        androidx.recyclerview.widget.LinearLayoutManager.a aVar;
        if (i != 0) {
            if (i != 1) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid orientation:");
            stringBuilder.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        D(0);
        if (i == this.s) {
            if (this.u == null) {
                i2 = t.b(this, i);
                this.u = i2;
                aVar.a = i2;
                this.s = i;
                O1();
            }
        } else {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void Y2(boolean z) {
        D(0);
        if (z == this.w) {
        }
        this.w = z;
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public View Z(int i) {
        int i2;
        int i3;
        i2 = g0();
        if (i2 == 0) {
            return null;
        }
        i3 = i - i5;
        i2 = f0(i3);
        if (i3 >= 0 && i3 < i2 && A0(i2) == i) {
            if (i3 < i2) {
                i2 = f0(i3);
                if (A0(i2) == i) {
                    return i2;
                }
            }
        }
        return super.Z(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void Z2(boolean z) {
        D(0);
        if (this.y == z) {
        }
        this.y = z;
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public androidx.recyclerview.widget.RecyclerView.q a0() {
        final int i = -2;
        RecyclerView.q qVar = new RecyclerView.q(i, i);
        return qVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void c1(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2) {
        super.c1(recyclerView, w2);
        if (this.C) {
            F1(w2);
            w2.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    boolean c2() {
        int i;
        int i2;
        final int i3 = 1073741824;
        if (u0() != i3 && I0() != i3 && J0()) {
            if (I0() != i3) {
                i = J0() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public PointF d(int i) {
        int i2;
        int i3;
        if (g0() == 0) {
            return null;
        }
        if (i < A0(f0(0))) {
            i2 = i3;
        }
        if (i2 != this.x) {
            i3 = -1;
        }
        int i5 = 0;
        if (this.s == 0) {
            PointF obj4 = new PointF((float)i3, i5);
            return obj4;
        }
        obj4 = new PointF(i5, (float)i3);
        return obj4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public View d1(View view, int i2, androidx.recyclerview.widget.RecyclerView.w recyclerView$w3, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b04) {
        View obj4;
        View obj6;
        U2();
        final int i = 0;
        if (g0() == 0) {
            return i;
        }
        obj4 = n2(i2);
        int obj5 = Integer.MIN_VALUE;
        if (obj4 == obj5) {
            return i;
        }
        p2();
        int i7 = 0;
        d3(obj4, (int)i6, i7, b04);
        androidx.recyclerview.widget.LinearLayoutManager.c cVar = this.t;
        cVar.g = obj5;
        cVar.a = i7;
        q2(w3, cVar, b04, true);
        obj5 = -1;
        if (obj4 == obj5) {
            obj6 = C2();
        } else {
            obj6 = B2();
        }
        if (obj4 == obj5) {
            obj4 = H2();
        } else {
            obj4 = G2();
        }
        if (obj4.hasFocusable() && obj6 == null) {
            if (obj6 == null) {
                return i;
            }
            return obj4;
        }
        return obj6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void e1(AccessibilityEvent accessibilityEvent) {
        int i;
        super.e1(accessibilityEvent);
        if (g0() > 0) {
            accessibilityEvent.setFromIndex(v2());
            accessibilityEvent.setToIndex(y2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void e2(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, int i3) {
        p obj2 = new p(recyclerView.getContext());
        obj2.setTargetPosition(i3);
        f2(obj2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean h2() {
        androidx.recyclerview.widget.LinearLayoutManager.d dVar;
        int i;
        boolean z;
        if (this.D == null && this.v == this.y) {
            i = this.v == this.y ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    protected void i2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, int[] i2Arr2) {
        int i;
        int obj4;
        final int i3 = 0;
        if (cVar.f == -1) {
            i = i3;
        } else {
            i = obj4;
            obj4 = i3;
        }
        i2Arr2[i3] = obj4;
        i2Arr2[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    void j2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.LinearLayoutManager.c linearLayoutManager$c2, androidx.recyclerview.widget.RecyclerView.p.c recyclerView$p$c3) {
        int obj2;
        Object obj3;
        final int i = c2.d;
        if (i >= 0 && i < b0.c()) {
            if (i < b0.c()) {
                c3.a(i, Math.max(0, c2.g));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    int n2(int i) {
        int i2;
        int i3;
        i2 = -1;
        i3 = 1;
        final int i9 = Integer.MIN_VALUE;
        if (i != i3 && i != 2 && i != 17 && i != 33 && i != 66 && i != 130) {
            if (i != 2) {
                i9 = Integer.MIN_VALUE;
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                                return i9;
                            }
                            if (this.s == i3) {
                            } else {
                                i3 = i9;
                            }
                            return i3;
                        }
                        if (this.s == 0) {
                        } else {
                            i3 = i9;
                        }
                        return i3;
                    }
                    if (this.s == i3) {
                    } else {
                        i2 = i9;
                    }
                    return i2;
                }
                if (this.s == 0) {
                } else {
                    i2 = i9;
                }
                return i2;
            }
            if (this.s == i3) {
                return i3;
            }
            if (K2()) {
                return i2;
            }
            return i3;
        }
        if (this.s == i3) {
            return i2;
        }
        if (K2()) {
            return i3;
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void o(View view, View view2, int i3, int i4) {
        int i;
        int obj4;
        int obj5;
        int obj6;
        D("Cannot drop a view during a scroll or layout calculation");
        p2();
        U2();
        final int obj7 = A0(view2);
        i = 1;
        final int i2 = -1;
        obj6 = A0(view) < obj7 ? i : i2;
        if (this.x) {
            if (obj6 == i) {
                W2(obj7, obj6 -= obj5);
            } else {
                W2(obj7, obj4 -= obj5);
            }
        } else {
            if (obj6 == i2) {
                W2(obj7, this.u.g(view2));
            } else {
                W2(obj7, obj5 -= obj4);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    androidx.recyclerview.widget.LinearLayoutManager.c o2() {
        LinearLayoutManager.c cVar = new LinearLayoutManager.c();
        return cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    void p2() {
        androidx.recyclerview.widget.LinearLayoutManager.c cVar;
        if (this.t == null) {
            this.t = o2();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    int q2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.LinearLayoutManager.c linearLayoutManager$c2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03, boolean z4) {
        int i2;
        int i3;
        int i5;
        boolean z;
        int i4;
        int i;
        int i6 = c2.c;
        i2 = c2.g;
        final int i9 = Integer.MIN_VALUE;
        if (i2 != i9 && i6 < 0) {
            if (i6 < 0) {
                c2.g = i2 += i6;
            }
            P2(w, c2);
        }
        i8 += i10;
        androidx.recyclerview.widget.LinearLayoutManager.b bVar = this.F;
        while (!c2.m) {
            if (i3 > 0) {
                break;
            }
            if (c2.c(b03)) {
                break;
            }
            bVar.a();
            M2(w, b03, c2, bVar);
            if (bVar.b) {
                break;
            } else {
            }
            c2.b = i11 += i4;
            if (bVar.c && c2.l == null) {
            } else {
            }
            i4 = bVar.a;
            c2.c = i13 -= i4;
            i3 -= i4;
            i5 = c2.g;
            i5 += i15;
            c2.g = i5;
            i4 = c2.c;
            if (i5 != i9 && i4 < 0) {
            }
            if (!bVar.d) {
                break;
            }
            i5 += i15;
            c2.g = i5;
            i4 = c2.c;
            if (i4 < 0) {
            }
            P2(w, c2);
            c2.g = i5 += i4;
            if (c2.l == null) {
            } else {
            }
            if (!b03.f()) {
            }
        }
        return i6 -= obj8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void r1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
        androidx.recyclerview.widget.LinearLayoutManager.d dVar2;
        androidx.recyclerview.widget.LinearLayoutManager.d dVar;
        Object view;
        int i6;
        int i2;
        int i11;
        int i4;
        int i7;
        int i8;
        int aVar;
        int i9;
        int i5;
        int i13;
        int i12;
        boolean z3;
        int z2;
        int i3;
        int i10;
        int i15;
        boolean z;
        int i14;
        int i;
        Object obj9;
        i4 = -1;
        if (this.D == null) {
            if (this.A != i4 && b02.c() == 0) {
                if (b02.c() == 0) {
                    F1(w);
                }
            }
        } else {
        }
        dVar = this.D;
        if (dVar != null && dVar.a()) {
            if (dVar.a()) {
                this.A = dVar3.a;
            }
        }
        p2();
        final int i25 = 0;
        cVar.a = i25;
        U2();
        view = s0();
        aVar = this.E;
        final int i35 = 1;
        if (aVar.e && this.A == i4) {
            if (this.A == i4) {
                if (this.D != null) {
                    aVar.e();
                    androidx.recyclerview.widget.LinearLayoutManager.a aVar2 = this.E;
                    aVar2.d = z5 ^= z3;
                    c3(w, b02, aVar2);
                    view.e = i35;
                } else {
                    if (view != null) {
                        if (this.u.g(view) < this.u.i()) {
                            if (this.u.d(view) <= this.u.m()) {
                                this.E.c(view, A0(view));
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
        } else {
        }
        androidx.recyclerview.widget.LinearLayoutManager.c cVar2 = this.t;
        i9 = cVar2.k >= 0 ? i35 : i4;
        cVar2.f = i9;
        int[] iArr = this.H;
        iArr[i25] = i25;
        iArr[i35] = i25;
        i2(b02, iArr);
        z2 = this.A;
        z2 = Z(z2);
        if (b02.f() && z2 != i4 && this.B != Integer.MIN_VALUE && z2 != null) {
            z2 = this.A;
            if (z2 != i4) {
                if (this.B != Integer.MIN_VALUE) {
                    z2 = Z(z2);
                    if (z2 != null) {
                        if (this.x) {
                            i37 -= i34;
                            z2 = this.B;
                        } else {
                            i33 -= i36;
                            i10 = this.B;
                        }
                        i10 -= z2;
                        if (i15 > 0) {
                            i6 += i15;
                        } else {
                            i5 -= i15;
                        }
                    }
                }
            }
        }
        androidx.recyclerview.widget.LinearLayoutManager.a aVar6 = this.E;
        if (aVar6.d) {
            if (this.x) {
                i4 = i35;
            }
        } else {
        }
        O2(w, b02, aVar6, i4);
        T(w);
        cVar7.m = T2();
        cVar8.j = b02.f();
        cVar9.i = i25;
        androidx.recyclerview.widget.LinearLayoutManager.a aVar4 = this.E;
        if (aVar4.d) {
            h3(aVar4);
            androidx.recyclerview.widget.LinearLayoutManager.c cVar10 = this.t;
            cVar10.h = i6;
            q2(w, cVar10, b02, i25);
            androidx.recyclerview.widget.LinearLayoutManager.c cVar3 = this.t;
            int i18 = cVar3.c;
            if (i18 > 0) {
                i5 += i18;
            }
            f3(this.E);
            androidx.recyclerview.widget.LinearLayoutManager.c cVar4 = this.t;
            cVar4.h = i5;
            cVar4.d = i30 += i14;
            q2(w, cVar4, b02, i25);
            androidx.recyclerview.widget.LinearLayoutManager.c cVar5 = this.t;
            i13 = cVar5.b;
            i2 = cVar5.c;
            if (i2 > 0) {
                g3(cVar3.d, cVar3.b);
                androidx.recyclerview.widget.LinearLayoutManager.c cVar11 = this.t;
                cVar11.h = i2;
                q2(w, cVar11, b02, i25);
                i7 = i2.b;
            }
        } else {
            f3(aVar4);
            androidx.recyclerview.widget.LinearLayoutManager.c cVar12 = this.t;
            cVar12.h = i5;
            q2(w, cVar12, b02, i25);
            androidx.recyclerview.widget.LinearLayoutManager.c cVar13 = this.t;
            int i24 = cVar13.c;
            if (i24 > 0) {
                i6 += i24;
            }
            h3(this.E);
            androidx.recyclerview.widget.LinearLayoutManager.c cVar14 = this.t;
            cVar14.h = i6;
            cVar14.d = i22 += i14;
            q2(w, cVar14, b02, i25);
            androidx.recyclerview.widget.LinearLayoutManager.c cVar6 = this.t;
            i7 = cVar6.b;
            i2 = cVar6.c;
            if (i2 > 0) {
                e3(cVar13.d, cVar13.b);
                androidx.recyclerview.widget.LinearLayoutManager.c cVar15 = this.t;
                cVar15.h = i2;
                q2(w, cVar15, b02, i25);
                i13 = i2.b;
            }
        }
        if (g0() > 0) {
            if (z4 ^= i3 != 0) {
                int i20 = E2(i13, w, b02, i35);
                i13 += i20;
                i11 = F2(i7 += i20, w, b02, i25);
            } else {
                int i21 = F2(i7, w, b02, i35);
                i7 += i21;
                i11 = E2(i13 += i21, w, b02, i25);
            }
            i8 += i11;
            i12 += i11;
        }
        N2(w, b02, i7, i13);
        if (!b02.f()) {
            this.u.s();
        } else {
            this.E.e();
        }
        this.v = this.y;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int r2() {
        int i;
        final int i3 = 0;
        View view = A2(i3, g0(), true, i3);
        if (view == null) {
            i = -1;
        } else {
            i = A0(view);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void s1(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        super.s1(b0);
        this.D = 0;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    View t2(boolean z, boolean z2) {
        if (this.x) {
            return A2(0, g0(), z, z2);
        }
        return A2(i2--, -1, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    View u2(boolean z, boolean z2) {
        if (this.x) {
            return A2(i--, -1, z, z2);
        }
        return A2(0, g0(), z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int v2() {
        int i;
        final int i3 = 0;
        View view = A2(i3, g0(), i3, true);
        if (view == null) {
            i = -1;
        } else {
            i = A0(view);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void w1(Parcelable parcelable) {
        boolean i;
        int i2;
        this.D = (LinearLayoutManager.d)parcelable;
        if (parcelable instanceof LinearLayoutManager.d && this.A != -1) {
            this.D = (LinearLayoutManager.d)parcelable;
            if (this.A != -1) {
                parcelable.b();
            }
            O1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int w2() {
        int i;
        final int i4 = 1;
        View view = A2(i2 -= i4, -1, i4, false);
        if (view == null) {
        } else {
            i = A0(view);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public Parcelable x1() {
        int i;
        int i3;
        int i2;
        if (this.D != null) {
            LinearLayoutManager.d dVar3 = new LinearLayoutManager.d(this.D);
            return dVar3;
        }
        LinearLayoutManager.d dVar2 = new LinearLayoutManager.d();
        if (g0() > 0) {
            p2();
            z ^= z2;
            dVar2.c = i4;
            if (i4 != 0) {
                View view2 = G2();
                dVar2.b = i7 -= i2;
                dVar2.a = A0(view2);
            } else {
                View view = H2();
                dVar2.a = A0(view);
                dVar2.b = i5 -= i3;
            }
        } else {
            dVar2.b();
        }
        return dVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int y2() {
        int i;
        final int i4 = 1;
        View view = A2(i2 -= i4, -1, false, i4);
        if (view == null) {
        } else {
            i = A0(view);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    View z2(int i, int i2) {
        int i4;
        int i3;
        int i5;
        androidx.recyclerview.widget.a0 a0Var;
        View obj4;
        p2();
        i4 = i2 > i ? 1 : i2 < i ? -1 : 0;
        if (i4 == 0) {
            return f0(i);
        }
        i5 = this.u.g(f0(i)) < this.u.m() ? 16388 : 4097;
        if (this.s == 0) {
            obj4 = this.e.a(i, i2, i3, i5);
        } else {
            obj4 = this.f.a(i, i2, i3, i5);
        }
        return obj4;
    }
}
