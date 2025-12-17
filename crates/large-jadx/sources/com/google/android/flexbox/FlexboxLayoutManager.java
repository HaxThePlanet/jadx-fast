package com.google.android.flexbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a0;
import androidx.recyclerview.widget.RecyclerView.a0.b;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.q;
import androidx.recyclerview.widget.RecyclerView.w;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FlexboxLayoutManager extends RecyclerView.p implements com.google.android.flexbox.a, RecyclerView.a0.b {

    private static final Rect S;
    private final com.google.android.flexbox.d A;
    private RecyclerView.w B;
    private RecyclerView.b0 C;
    private com.google.android.flexbox.FlexboxLayoutManager.d D;
    private com.google.android.flexbox.FlexboxLayoutManager.b E;
    private t F;
    private t G;
    private com.google.android.flexbox.FlexboxLayoutManager.e H;
    private int I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private SparseArray<View> N;
    private final Context O;
    private View P;
    private int Q;
    private com.google.android.flexbox.d.a R;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private List<com.google.android.flexbox.c> z;

    static class a {
    }

    private class b {

        private int a;
        private int b;
        private int c;
        private int d;
        private boolean e;
        private boolean f;
        private boolean g;
        final com.google.android.flexbox.FlexboxLayoutManager h;
        static {
        }

        private b(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager) {
            this.h = flexboxLayoutManager;
            super();
            this.d = 0;
        }

        b(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager, com.google.android.flexbox.FlexboxLayoutManager.a flexboxLayoutManager$a2) {
            super(flexboxLayoutManager);
        }

        static int a(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b) {
            return b.a;
        }

        static int b(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, int i2) {
            b.a = i2;
            return i2;
        }

        static int c(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b) {
            return b.b;
        }

        static int d(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, int i2) {
            b.b = i2;
            return i2;
        }

        static void e(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b) {
            b.q();
        }

        static int f(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b) {
            return b.c;
        }

        static int g(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, int i2) {
            b.c = i2;
            return i2;
        }

        static boolean h(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, boolean z2) {
            b.g = z2;
            return z2;
        }

        static void i(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, View view2) {
            b.r(view2);
        }

        static int j(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b) {
            return b.d;
        }

        static int k(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, int i2) {
            b.d = i2;
            return i2;
        }

        static boolean l(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b) {
            return b.f;
        }

        static boolean m(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, boolean z2) {
            b.f = z2;
            return z2;
        }

        static void n(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b) {
            b.s();
        }

        static boolean o(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b) {
            return b.e;
        }

        static boolean p(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, boolean z2) {
            b.e = z2;
            return z2;
        }

        private void q() {
            int i;
            boolean z;
            int i2;
            if (!this.h.w() && FlexboxLayoutManager.k2(this.h)) {
                if (FlexboxLayoutManager.k2(this.h)) {
                    if (this.e) {
                        i = FlexboxLayoutManager.l2(this.h).i();
                    } else {
                        i3 -= i2;
                    }
                    this.c = i;
                } else {
                    if (this.e) {
                        i = FlexboxLayoutManager.l2(this.h).i();
                    } else {
                        i = FlexboxLayoutManager.l2(this.h).m();
                    }
                    this.c = i;
                }
            } else {
            }
        }

        private void r(View view) {
            t tVar;
            int i3;
            int i4;
            int i;
            int i2;
            boolean z;
            int obj4;
            if (FlexboxLayoutManager.i2(this.h) == 0) {
                tVar = FlexboxLayoutManager.m2(this.h);
            } else {
                tVar = FlexboxLayoutManager.l2(this.h);
            }
            if (!this.h.w() && FlexboxLayoutManager.k2(this.h)) {
                if (FlexboxLayoutManager.k2(this.h)) {
                    if (this.e) {
                        this.c = i7 += i3;
                    } else {
                        this.c = tVar.d(view);
                    }
                } else {
                    if (this.e) {
                        this.c = i8 += i3;
                    } else {
                        this.c = tVar.g(view);
                    }
                }
            } else {
            }
            this.a = this.h.A0(view);
            obj4 = 0;
            this.g = obj4;
            final int i9 = -1;
            if (this.a != i9) {
            } else {
                i2 = obj4;
            }
            int i6 = dVar.c[i2];
            if (i6 != i9) {
                obj4 = i6;
            }
            this.b = obj4;
            if (FlexboxLayoutManager.o2(this.h).size() > this.b) {
                this.a = obj4.k;
            }
        }

        private void s() {
            int i2;
            int i3;
            int i;
            int i4 = -1;
            this.a = i4;
            this.b = i4;
            this.c = Integer.MIN_VALUE;
            i2 = 0;
            this.f = i2;
            this.g = i2;
            i = 2;
            final int i8 = 1;
            if (this.h.w()) {
                if (FlexboxLayoutManager.i2(this.h) == 0) {
                    if (FlexboxLayoutManager.j2(this.h) == i8) {
                        i2 = i8;
                    }
                    this.e = i2;
                } else {
                    if (FlexboxLayoutManager.i2(this.h) == i) {
                        i2 = i8;
                    }
                    this.e = i2;
                }
            } else {
                if (FlexboxLayoutManager.i2(this.h) == 0) {
                    if (FlexboxLayoutManager.j2(this.h) == 3) {
                        i2 = i8;
                    }
                    this.e = i2;
                } else {
                    if (FlexboxLayoutManager.i2(this.h) == i) {
                        i2 = i8;
                    }
                    this.e = i2;
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AnchorInfo{mPosition=");
            stringBuilder.append(this.a);
            stringBuilder.append(", mFlexLinePosition=");
            stringBuilder.append(this.b);
            stringBuilder.append(", mCoordinate=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mPerpendicularCoordinate=");
            stringBuilder.append(this.d);
            stringBuilder.append(", mLayoutFromEnd=");
            stringBuilder.append(this.e);
            stringBuilder.append(", mValid=");
            stringBuilder.append(this.f);
            stringBuilder.append(", mAssignedFromSavedState=");
            stringBuilder.append(this.g);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class d {

        private int a;
        private boolean b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private boolean j;
        private d() {
            super();
            final int i = 1;
            this.h = i;
            this.i = i;
        }

        d(com.google.android.flexbox.FlexboxLayoutManager.a flexboxLayoutManager$a) {
            super();
        }

        static int a(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            return d.e;
        }

        static int b(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, int i2) {
            d.e = i2;
            return i2;
        }

        static boolean c(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            return d.b;
        }

        static boolean d(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, boolean z2) {
            d.b = z2;
            return z2;
        }

        static int e(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            return d.a;
        }

        static int f(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, int i2) {
            d.a = i2;
            return i2;
        }

        static int g(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            return d.c;
        }

        static int h(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, int i2) {
            d.c = i2;
            return i2;
        }

        static int i(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            final int i = d.c;
            d.c = i + 1;
            return i;
        }

        static int j(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            final int i = d.c;
            d.c = i + -1;
            return i;
        }

        static int k(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            return d.f;
        }

        static int l(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, int i2) {
            d.f = i2;
            return i2;
        }

        static boolean m(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, RecyclerView.b0 recyclerView$b02, List list3) {
            return d.w(b02, list3);
        }

        static int n(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            return d.d;
        }

        static int o(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, int i2) {
            d.d = i2;
            return i2;
        }

        static int p(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            return d.i;
        }

        static int q(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, int i2) {
            d.i = i2;
            return i2;
        }

        static int r(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            return d.h;
        }

        static int s(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, int i2) {
            d.h = i2;
            return i2;
        }

        static int t(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, int i2) {
            d.g = i2;
            return i2;
        }

        static boolean u(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d) {
            return d.j;
        }

        static boolean v(com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d, boolean z2) {
            d.j = z2;
            return z2;
        }

        private boolean w(RecyclerView.b0 recyclerView$b0, List<com.google.android.flexbox.c> list2) {
            int obj2;
            int obj3;
            final int i = this.d;
            obj2 = this.c;
            if (i >= 0 && i < b0.c() && obj2 >= 0 && obj2 < list2.size()) {
                if (i < b0.c()) {
                    obj2 = this.c;
                    if (obj2 >= 0) {
                        obj2 = obj2 < list2.size() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LayoutState{mAvailable=");
            stringBuilder.append(this.a);
            stringBuilder.append(", mFlexLinePosition=");
            stringBuilder.append(this.c);
            stringBuilder.append(", mPosition=");
            stringBuilder.append(this.d);
            stringBuilder.append(", mOffset=");
            stringBuilder.append(this.e);
            stringBuilder.append(", mScrollingOffset=");
            stringBuilder.append(this.f);
            stringBuilder.append(", mLastScrollDelta=");
            stringBuilder.append(this.g);
            stringBuilder.append(", mItemDirection=");
            stringBuilder.append(this.h);
            stringBuilder.append(", mLayoutDirection=");
            stringBuilder.append(this.i);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static class e implements Parcelable {

        public static final Parcelable.Creator<com.google.android.flexbox.FlexboxLayoutManager.e> CREATOR;
        private int a;
        private int b;
        static {
            FlexboxLayoutManager.e.a aVar = new FlexboxLayoutManager.e.a();
            FlexboxLayoutManager.e.CREATOR = aVar;
        }

        private e(Parcel parcel) {
            super();
            this.a = parcel.readInt();
            this.b = parcel.readInt();
        }

        e(Parcel parcel, com.google.android.flexbox.FlexboxLayoutManager.a flexboxLayoutManager$a2) {
            super(parcel);
        }

        private e(com.google.android.flexbox.FlexboxLayoutManager.e flexboxLayoutManager$e) {
            super();
            this.a = e.a;
            this.b = e.b;
        }

        e(com.google.android.flexbox.FlexboxLayoutManager.e flexboxLayoutManager$e, com.google.android.flexbox.FlexboxLayoutManager.a flexboxLayoutManager$a2) {
            super(e);
        }

        static int a(com.google.android.flexbox.FlexboxLayoutManager.e flexboxLayoutManager$e) {
            return e.a;
        }

        static int b(com.google.android.flexbox.FlexboxLayoutManager.e flexboxLayoutManager$e, int i2) {
            e.a = i2;
            return i2;
        }

        static int c(com.google.android.flexbox.FlexboxLayoutManager.e flexboxLayoutManager$e) {
            return e.b;
        }

        static int d(com.google.android.flexbox.FlexboxLayoutManager.e flexboxLayoutManager$e, int i2) {
            e.b = i2;
            return i2;
        }

        static void e(com.google.android.flexbox.FlexboxLayoutManager.e flexboxLayoutManager$e) {
            e.h();
        }

        static boolean f(com.google.android.flexbox.FlexboxLayoutManager.e flexboxLayoutManager$e, int i2) {
            return e.g(i2);
        }

        private boolean g(int i) {
            int obj2;
            final int i2 = this.a;
            if (i2 >= 0 && i2 < i) {
                obj2 = i2 < i ? 1 : 0;
            } else {
            }
            return obj2;
        }

        private void h() {
            this.a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SavedState{mAnchorPosition=");
            stringBuilder.append(this.a);
            stringBuilder.append(", mAnchorOffset=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
        }
    }

    public static class c extends RecyclerView.q implements com.google.android.flexbox.b {

        public static final Parcelable.Creator<com.google.android.flexbox.FlexboxLayoutManager.c> CREATOR;
        private int A;
        private int B;
        private int C = 16777215;
        private int D = 16777215;
        private boolean E;
        private float w = 0f;
        private float x = 1f;
        private int y = -1;
        private float z = -1f;
        static {
            FlexboxLayoutManager.c.a aVar = new FlexboxLayoutManager.c.a();
            FlexboxLayoutManager.c.CREATOR = aVar;
        }

        public c(int i, int i2) {
            super(i, i2);
            int obj1 = 0;
            obj1 = 1065353216;
            obj1 = -1;
            obj1 = -1082130432;
            obj1 = 16777215;
        }

        public c(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            int obj1 = 0;
            obj1 = 1065353216;
            obj1 = -1;
            obj1 = -1082130432;
            obj1 = 16777215;
        }

        protected c(Parcel parcel) {
            int i;
            int i2 = -2;
            super(i2, i2);
            int i3 = 0;
            int i4 = 1065353216;
            int i5 = -1;
            int i6 = -1082130432;
            int i7 = 16777215;
            this.w = parcel.readFloat();
            this.x = parcel.readFloat();
            this.y = parcel.readInt();
            this.z = parcel.readFloat();
            this.A = parcel.readInt();
            this.B = parcel.readInt();
            this.C = parcel.readInt();
            this.D = parcel.readInt();
            i = parcel.readByte() != 0 ? 1 : 0;
            this.E = i;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int A0() {
            return this.bottomMargin;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int A1() {
            return this.B;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int C0() {
            return this.leftMargin;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public boolean G1() {
            return this.E;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int J() {
            return this.height;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int N1() {
            return this.D;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int Q0() {
            return this.topMargin;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public void V0(int i) {
            this.B = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int Y() {
            return this.y;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public float a1() {
            return this.w;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int describeContents() {
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public float e0() {
            return this.x;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int e2() {
            return this.C;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public float i1() {
            return this.z;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int m0() {
            return this.A;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int v0() {
            return this.width;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeFloat(this.w);
            parcel.writeFloat(this.x);
            parcel.writeInt(this.y);
            parcel.writeFloat(this.z);
            parcel.writeInt(this.A);
            parcel.writeInt(this.B);
            parcel.writeInt(this.C);
            parcel.writeInt(this.D);
            parcel.writeByte(this.E);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public int x1() {
            return this.rightMargin;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public void z0(int i) {
            this.A = i;
        }
    }
    static {
        Rect rect = new Rect();
        FlexboxLayoutManager.S = rect;
    }

    public FlexboxLayoutManager(Context context, int i2) {
        super(context, i2, 1);
    }

    public FlexboxLayoutManager(Context context, int i2, int i3) {
        super();
        int i = -1;
        this.w = i;
        ArrayList arrayList = new ArrayList();
        this.z = arrayList;
        d dVar = new d(this);
        this.A = dVar;
        FlexboxLayoutManager.b bVar = new FlexboxLayoutManager.b(this, 0);
        this.E = bVar;
        this.I = i;
        int i4 = Integer.MIN_VALUE;
        this.J = i4;
        this.K = i4;
        this.L = i4;
        SparseArray sparseArray = new SparseArray();
        this.N = sparseArray;
        this.Q = i;
        d.a aVar = new d.a();
        this.R = aVar;
        e3(i2);
        f3(i3);
        d3(4);
        U1(true);
        this.O = context;
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet2, int i3, int i4) {
        boolean obj5;
        super();
        int i = -1;
        this.w = i;
        ArrayList arrayList = new ArrayList();
        this.z = arrayList;
        d dVar = new d(this);
        this.A = dVar;
        FlexboxLayoutManager.b bVar = new FlexboxLayoutManager.b(this, 0);
        this.E = bVar;
        this.I = i;
        int i2 = Integer.MIN_VALUE;
        this.J = i2;
        this.K = i2;
        this.L = i2;
        SparseArray sparseArray = new SparseArray();
        this.N = sparseArray;
        this.Q = i;
        d.a aVar = new d.a();
        this.R = aVar;
        obj5 = RecyclerView.p.B0(context, attributeSet2, i3, i4);
        final int obj6 = obj5.a;
        final int obj7 = 1;
        if (obj6 != null) {
            if (obj6 != obj7) {
            } else {
                if (obj5.c) {
                    e3(3);
                } else {
                    e3(2);
                }
            }
        } else {
            if (obj5.c) {
                e3(obj7);
            } else {
                e3(0);
            }
        }
        f3(obj7);
        d3(4);
        U1(obj7);
        this.O = context;
    }

    private View B2(int i) {
        View obj3 = F2(i2--, -1, i);
        if (obj3 == null) {
            return null;
        }
        return C2(obj3, (c)this.z.get(dVar.c[A0(obj3)]));
    }

    private View C2(View view, com.google.android.flexbox.c c2) {
        int i2;
        int visibility;
        int i;
        View obj6;
        int obj7;
        i3 += -2;
        while (i2 > i5--) {
            obj7 = f0(i2);
            if (obj7 != null) {
            }
            i2--;
            if (obj7.getVisibility() == 8) {
            } else {
            }
            if (this.x && !w()) {
            } else {
            }
            if (this.F.d(obj6) < this.F.d(obj7)) {
            }
            obj6 = obj7;
            if (!w()) {
            } else {
            }
            if (this.F.g(obj6) > this.F.g(obj7)) {
            }
        }
        return obj6;
    }

    private View E2(int i, int i2, boolean z3) {
        int i3;
        View view;
        boolean z;
        int obj4;
        i3 = i2 > i ? 1 : -1;
        while (obj4 != i2) {
            view = f0(obj4);
            obj4 += i3;
        }
        return null;
    }

    private View F2(int i, int i2, int i3) {
        int i5;
        int i6;
        int i4;
        View view;
        int i7;
        int obj8;
        w2();
        v2();
        i5 = i2 > i ? 1 : -1;
        i4 = i6;
        while (obj8 != i2) {
            view = f0(obj8);
            i7 = A0(view);
            obj8 += i5;
            if (i6 == 0) {
            }
            i6 = view;
            if (i4 == 0) {
            }
            i4 = view;
        }
        if (i6 != 0) {
        } else {
            i6 = i4;
        }
        return i6;
    }

    private int G2(int i, RecyclerView.w recyclerView$w2, RecyclerView.b0 recyclerView$b03, boolean z4) {
        boolean z;
        int i2;
        int i3;
        int obj4;
        RecyclerView.b0 obj5;
        final int i7 = 0;
        if (!w() && this.x) {
            i2 = this.x ? 1 : i7;
        } else {
        }
        i3 = i - i4;
        if (i2 != 0 && i3 > 0) {
            i3 = i - i4;
            if (i3 > 0) {
                obj4 = Q2(i3, w2, b03);
                obj5 -= obj3;
                if (z4 && obj5 > 0) {
                    obj5 -= obj3;
                    if (obj5 > 0) {
                        this.F.r(obj5);
                        return obj5 += obj4;
                    }
                }
                return obj4;
            }
            return i7;
        }
        i5 -= i;
        if (i6 > 0) {
            obj4 = -obj4;
        }
        return i7;
    }

    private int H2(int i, RecyclerView.w recyclerView$w2, RecyclerView.b0 recyclerView$b03, boolean z4) {
        int i2;
        boolean z;
        int obj3;
        int obj4;
        RecyclerView.b0 obj5;
        int obj6;
        final int i6 = 0;
        i4 -= i;
        if (!w() && this.x && i5 > 0) {
            if (this.x) {
                i4 -= i;
                if (i5 > 0) {
                    obj4 = Q2(-i5, w2, b03);
                    obj3 -= obj5;
                    if (z4 != 0 && obj3 > 0) {
                        obj3 -= obj5;
                        if (obj3 > 0) {
                            this.F.r(-obj3);
                            obj4 -= obj3;
                        }
                    }
                    return obj4;
                }
                return i6;
            }
        }
        i2 = i - i3;
        if (i2 > 0) {
            obj4 = -obj4;
        }
        return i6;
    }

    private int I2(View view) {
        return obj2 += bottomMargin;
    }

    private View J2() {
        return f0(0);
    }

    private int K2(View view) {
        return obj2 -= leftMargin;
    }

    private int L2(View view) {
        return obj2 += rightMargin;
    }

    private int M2(View view) {
        return obj2 -= topMargin;
    }

    private static boolean Q0(int i, int i2, int i3) {
        int i4;
        final int mode = View.MeasureSpec.getMode(i2);
        final int obj4 = View.MeasureSpec.getSize(i2);
        i4 = 0;
        if (i3 > 0 && i != i3) {
            if (i != i3) {
                return i4;
            }
        }
        final int i5 = 1;
        if (mode != Integer.MIN_VALUE && mode != 0 && mode != 1073741824) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    return i4;
                }
                if (obj4 == i) {
                    i4 = i5;
                }
                return i4;
            }
            return i5;
        }
        if (obj4 >= i) {
            i4 = i5;
        }
        return i4;
    }

    private int Q2(int i, RecyclerView.w recyclerView$w2, RecyclerView.b0 recyclerView$b03) {
        boolean z;
        int i3;
        int i2;
        int obj7;
        final int i5 = 0;
        if (g0() != 0) {
            if (i == 0) {
            } else {
                w2();
                i2 = 1;
                FlexboxLayoutManager.d.v(this.D, i2);
                if (!w() && this.x) {
                    i3 = this.x ? i2 : i5;
                } else {
                }
                if (i3 != 0 && i < 0) {
                    if (i < 0) {
                    } else {
                        i2 = i6;
                    }
                } else {
                }
                int i7 = Math.abs(i);
                m3(i2, i7);
                i8 += obj8;
                if (i9 < 0) {
                    return i5;
                }
                if (i3 != 0) {
                    if (i7 > i9) {
                        obj7 *= i9;
                    }
                } else {
                    if (i7 > i9) {
                        obj7 = i2 * i9;
                    }
                }
            }
            this.F.r(-obj7);
            FlexboxLayoutManager.d.t(this.D, obj7);
            return obj7;
        }
        return i5;
    }

    private int R2(int i) {
        int i4;
        int i3;
        int i2;
        int height;
        int obj6;
        if (g0() != 0) {
            if (i == 0) {
            } else {
                w2();
                boolean z = w();
                View view = this.P;
                if (z) {
                    height = view.getWidth();
                } else {
                    height = view.getHeight();
                }
                if (z) {
                    i4 = H0();
                } else {
                    i4 = t0();
                }
                final int i11 = 1;
                if (w0() == i11) {
                    i2 = i11;
                }
                if (i2 != 0) {
                    if (i < 0) {
                        obj6 = Math.min(i9 -= height, Math.abs(i));
                        obj6 = -obj6;
                    } else {
                        if (i8 += i > 0) {
                            obj6 = FlexboxLayoutManager.b.j(this.E);
                        }
                    }
                } else {
                }
            }
            return obj6;
        }
        return 0;
    }

    private boolean T2(View view, boolean z2) {
        int i4;
        int i3;
        int i;
        int i2;
        int obj11;
        int i5 = v();
        final int i6 = u();
        i7 -= i9;
        i10 -= i12;
        int i13 = K2(view);
        final int i14 = M2(view);
        final int i15 = L2(view);
        obj11 = I2(view);
        i = 1;
        final int i16 = 0;
        if (i5 <= i13 && i8 >= i15) {
            i2 = i8 >= i15 ? i : i16;
        } else {
        }
        if (i13 < i8) {
            if (i15 >= i5) {
                i4 = i;
            } else {
                i4 = i16;
            }
        } else {
        }
        if (i6 <= i14 && i11 >= obj11) {
            i3 = i11 >= obj11 ? i : i16;
        } else {
        }
        if (i14 < i11) {
            if (obj11 >= i6) {
                obj11 = i;
            } else {
                obj11 = i16;
            }
        } else {
        }
        if (z2) {
            if (i2 != 0 && i3 != 0) {
                if (i3 != 0) {
                } else {
                    i = i16;
                }
            } else {
            }
            return i;
        }
        if (i4 != 0 && obj11 != null) {
            if (obj11 != null) {
            } else {
                i = i16;
            }
        } else {
        }
        return i;
    }

    private int U2(com.google.android.flexbox.c c, com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d2) {
        if (w()) {
            return V2(c, d2);
        }
        return W2(c, d2);
    }

    private int V2(com.google.android.flexbox.c c, com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d2) {
        float f;
        int i14;
        com.google.android.flexbox.d dVar;
        float f2;
        int i7;
        View view;
        int i13;
        int i3;
        com.google.android.flexbox.c cVar;
        int i10;
        float round;
        int i8;
        Rect rect;
        int i12;
        int i;
        int round2;
        int i15;
        int i9;
        int i6;
        int i4;
        View view2;
        int i2;
        int i11;
        int i16;
        int i5;
        float f3;
        final Object obj = this;
        final Object obj2 = c;
        int i17 = v();
        int i29 = p();
        int i34 = H0();
        if (FlexboxLayoutManager.d.p(d2) == -1) {
            i10 -= i12;
        }
        final int i62 = FlexboxLayoutManager.d.n(d2);
        round = obj.u;
        i = 0;
        i6 = 1;
        if (round != 0) {
            if (round != i6) {
                i9 = 1073741824;
                if (round != 2) {
                    if (round != 3) {
                        if (round != 4) {
                            if (round != 5) {
                            } else {
                                round = obj2.d;
                                if (round != 0) {
                                    f20 /= round;
                                } else {
                                    round2 = i;
                                }
                                f6 += round2;
                                f13 -= round2;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid justifyContent is set: ");
                            stringBuilder.append(obj.u);
                            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                            throw illegalStateException;
                        }
                        i8 = obj2.d;
                        if (i8 != 0) {
                            f21 /= i8;
                        } else {
                            round2 = i;
                        }
                        round = round2 / i9;
                        f7 += round;
                        f14 -= round;
                    } else {
                        f = (float)i17;
                        int i45 = obj2.d;
                        round = i45 != i6 ? (float)i46 : 1065353216;
                        f22 /= round;
                        f2 = (float)i13;
                    }
                } else {
                    round = obj2.a;
                    f5 += i15;
                    f12 -= i13;
                    round2 = i;
                }
            } else {
                int i43 = obj2.a;
                round2 = i;
                f2 = f4;
                f = f3;
            }
        } else {
            f = (float)i17;
            f2 = (float)i13;
        }
        f -= f16;
        f2 -= f17;
        final float f23 = Math.max(round2, i);
        i3 = 0;
        i4 = i62;
        while (i4 < i62 + i63) {
            view2 = obj.N2(i4);
            if (view2 == null) {
            } else {
            }
            if (FlexboxLayoutManager.d.p(d2) == i6) {
            } else {
            }
            obj.G(view2, FlexboxLayoutManager.S);
            obj.B(view2, i3);
            i3++;
            com.google.android.flexbox.d dVar4 = obj.A;
            long l = dVar4.d[i4];
            int i40 = dVar4.r(l);
            int i48 = obj.A.q(l);
            android.view.ViewGroup.LayoutParams view3 = layoutParams;
            if (obj.b2(view2, i40, i48, (FlexboxLayoutManager.c)view3)) {
            }
            int i64 = i14 + f18;
            int i65 = i7 - f8;
            i = i61 + i19;
            if (obj.x) {
            } else {
            }
            i6 = view3;
            obj.A.I(view2, c, Math.round(i64), i, round3 + measuredWidth3, i + measuredHeight);
            i3 = i2;
            i14 = i11;
            i7 = i16;
            i4++;
            i6 = 1;
            i6 = view3;
            obj.A.I(view2, c, round4 - measuredWidth4, i, Math.round(i65), i + measuredHeight2);
            view2.measure(i40, i48);
            obj.G(view2, FlexboxLayoutManager.S);
            obj.A(view2);
        }
        FlexboxLayoutManager.d.h(d2, i26 += i33);
        return c.a();
    }

    private int W2(com.google.android.flexbox.c c, com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d2) {
        float f;
        int i17;
        Rect rect;
        com.google.android.flexbox.d dVar;
        float f4;
        int i;
        View view2;
        int i8;
        int i10;
        com.google.android.flexbox.c cVar;
        int i5;
        float i15;
        int i16;
        int i9;
        int i12;
        int i2;
        int round3;
        int i13;
        int round2;
        int i4;
        float f2;
        int i3;
        float f3;
        int i6;
        int i11;
        View view;
        int round;
        int i14;
        int i7;
        float f5;
        final Object obj = this;
        final Object obj2 = c;
        int i18 = u();
        int i32 = a();
        int i36 = t0();
        if (FlexboxLayoutManager.d.p(d2) == -1) {
            i2 = obj2.c;
            i5 -= i2;
            i9 += i2;
        }
        final int i66 = FlexboxLayoutManager.d.n(d2);
        i15 = obj.u;
        i12 = 0;
        i4 = 1;
        if (i15 != 0) {
            if (i15 != i4) {
                i13 = 1073741824;
                if (i15 != 2) {
                    if (i15 != 3) {
                        if (i15 != 4) {
                            if (i15 != 5) {
                            } else {
                                i15 = obj2.d;
                                if (i15 != 0) {
                                    f22 /= i15;
                                } else {
                                    round3 = i12;
                                }
                                f8 += round3;
                                f15 -= round3;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Invalid justifyContent is set: ");
                            stringBuilder.append(obj.u);
                            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                            throw illegalStateException;
                        }
                        i16 = obj2.d;
                        if (i16 != 0) {
                            f23 /= i16;
                        } else {
                            round3 = i12;
                        }
                        i15 = round3 / i13;
                        f9 += i15;
                        f16 -= i15;
                    } else {
                        f = (float)i18;
                        int i45 = obj2.d;
                        i15 = i45 != i4 ? (float)i46 : 1065353216;
                        f24 /= i15;
                        f4 = (float)i8;
                    }
                } else {
                    i15 = obj2.a;
                    f7 += i2;
                    f14 -= i8;
                    round3 = i12;
                }
            } else {
                int i43 = obj2.a;
                round3 = i12;
                f4 = f6;
                f = f5;
            }
        } else {
            f = (float)i18;
            f4 = (float)i8;
        }
        f -= f18;
        f4 -= f19;
        f2 = Math.max(round3, i12);
        i10 = 0;
        round2 = i66;
        while (round2 < i66 + i68) {
            i13 = obj.N2(round2);
            if (i13 == null) {
            } else {
            }
            com.google.android.flexbox.d dVar4 = obj.A;
            f3 = f2;
            long l = dVar4.d[round2];
            int i47 = dVar4.r(l);
            int i50 = obj.A.q(l);
            i4 = layoutParams;
            if (obj.b2(i13, i47, i50, (FlexboxLayoutManager.c)i4)) {
            }
            int i67 = i17 + f20;
            int i69 = i - f10;
            int i63 = 1;
            if (FlexboxLayoutManager.d.p(d2) == i63) {
            } else {
            }
            obj.G(i13, FlexboxLayoutManager.S);
            obj.B(i13, i10);
            i10++;
            i12 = i64 + i24;
            i11 = i65 - i25;
            i15 = obj.x;
            if (i15) {
            } else {
            }
            i14 = i63;
            view = i13;
            i7 = round2;
            if (obj.y) {
            } else {
            }
            obj.A.J(view, c, i15, i12, Math.round(i67), i12 + measuredWidth3, round6 + measuredHeight5);
            View view3 = view;
            i17 = f2;
            i10 = i3;
            i = i6;
            round2 = i7 + 1;
            f2 = f3;
            i4 = i14;
            obj.A.J(view, c, i15, i12, round7 - measuredHeight6, i12 + measuredWidth4, Math.round(i69));
            if (obj.y) {
            } else {
            }
            i14 = i63;
            view = i13;
            i7 = round2;
            obj.A.J(view, c, i15, i11 - measuredWidth, Math.round(i67), i11, round4 + measuredHeight3);
            i14 = i63;
            view = i13;
            i7 = round2;
            obj.A.J(i13, c, i15, i11 - measuredWidth2, round5 - measuredHeight4, i11, Math.round(i69));
            obj.G(i13, FlexboxLayoutManager.S);
            obj.A(i13);
            i13.measure(i47, i50);
            i7 = round2;
            i14 = i4;
            f3 = f2;
        }
        FlexboxLayoutManager.d.h(d2, i19 += i34);
        return c.a();
    }

    private void X2(RecyclerView.w recyclerView$w, com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d2) {
        if (!FlexboxLayoutManager.d.u(d2)) {
        }
        if (FlexboxLayoutManager.d.p(d2) == -1) {
            Z2(w, d2);
        } else {
            a3(w, d2);
        }
    }

    private void Y2(RecyclerView.w recyclerView$w, int i2, int i3) {
        while (i3 >= i2) {
            I1(i3, w);
            i3--;
        }
    }

    private void Z2(RecyclerView.w recyclerView$w, com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d2) {
        int i4;
        int i3;
        Object obj;
        int i;
        int i5;
        int i2;
        if (FlexboxLayoutManager.d.k(d2) < 0) {
        }
        this.F.h();
        FlexboxLayoutManager.d.k(d2);
        i4 = g0();
        if (i4 == 0) {
        }
        final int i8 = i4 + -1;
        i3 = dVar.c[A0(f0(i8))];
        if (i3 == -1) {
        }
        obj = this.z.get(i3);
        i = i8;
        while (i >= 0) {
            i5 = f0(i);
            if (p2(i5, FlexboxLayoutManager.d.k(d2))) {
                break;
            }
            if (obj.k == A0(i5)) {
                break;
            } else {
            }
            i--;
            if (i3 <= 0) {
                break;
            } else {
            }
            obj = obj2;
            i4 = i;
        }
        Y2(w, i4, i8);
    }

    private void a3(RecyclerView.w recyclerView$w, com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d2) {
        int i5;
        int i3;
        Object obj;
        int i2;
        int i;
        int i4;
        if (FlexboxLayoutManager.d.k(d2) < 0) {
        }
        int i7 = g0();
        if (i7 == 0) {
        }
        final int i8 = 0;
        i5 = dVar.c[A0(f0(i8))];
        if (i5 == -1) {
        }
        obj = this.z.get(i5);
        i2 = i8;
        while (i2 < i7) {
            i = f0(i2);
            if (q2(i, FlexboxLayoutManager.d.k(d2))) {
                break;
            }
            if (obj.l == A0(i)) {
                break;
            } else {
            }
            i2++;
            if (i5 >= size--) {
                break;
            } else {
            }
            obj = obj2;
            i3 = i2;
        }
        Y2(w, i8, i3);
    }

    private boolean b2(View view, int i2, int i3, RecyclerView.q recyclerView$q4) {
        boolean layoutRequested;
        int width;
        int obj3;
        int obj4;
        if (!view.isLayoutRequested() && P0() && FlexboxLayoutManager.Q0(view.getWidth(), i2, q4.width)) {
            if (P0()) {
                if (FlexboxLayoutManager.Q0(view.getWidth(), i2, q4.width)) {
                    if (!FlexboxLayoutManager.Q0(view.getHeight(), i3, q4.height)) {
                        obj3 = 1;
                    } else {
                        obj3 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private void b3() {
        int i3;
        int i;
        int i2;
        if (w()) {
            i3 = u0();
        } else {
            i3 = I0();
        }
        if (i3 != 0) {
            if (i3 == Integer.MIN_VALUE) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        FlexboxLayoutManager.d.d(this.D, i);
    }

    private void c3() {
        int i2;
        int i;
        int i3;
        int i4;
        int i5;
        int i6;
        i = w0();
        i4 = this.s;
        final int i7 = 2;
        i5 = 0;
        final int i8 = 1;
        if (i4 != 0) {
            if (i4 != i8) {
                if (i4 != i7) {
                    if (i4 != 3) {
                        this.x = i5;
                        this.y = i5;
                    } else {
                        if (i == i8) {
                            i5 = i8;
                        }
                        this.x = i5;
                        if (this.t == i7) {
                            this.x = i5 ^ 1;
                        }
                        this.y = i8;
                    }
                } else {
                    i = i == i8 ? i8 : i5;
                    this.x = i;
                    if (this.t == i7) {
                        this.x = i ^= i8;
                    }
                    this.y = i5;
                }
            } else {
                i3 = i != i8 ? i8 : i5;
                this.x = i3;
                if (this.t == i7) {
                    i5 = i8;
                }
                this.y = i5;
            }
        } else {
            i2 = i == i8 ? i8 : i5;
            this.x = i2;
            if (this.t == i7) {
                i5 = i8;
            }
            this.y = i5;
        }
    }

    private boolean h3(RecyclerView.b0 recyclerView$b0, com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b2) {
        View view;
        int i2;
        int i;
        int obj5;
        i2 = 0;
        if (g0() == 0) {
            return i2;
        }
        if (FlexboxLayoutManager.b.o(b2)) {
            view = B2(b0.c());
        } else {
            view = y2(b0.c());
        }
        FlexboxLayoutManager.b.i(b2, view);
        final int i6 = 1;
        if (view != null && !b0.f() && h2()) {
            FlexboxLayoutManager.b.i(b2, view);
            i6 = 1;
            if (!b0.f()) {
                if (h2()) {
                    if (this.F.g(view) < this.F.i()) {
                        if (this.F.d(view) < this.F.m()) {
                            i2 = i6;
                        }
                    } else {
                    }
                    if (i2 != 0) {
                        if (FlexboxLayoutManager.b.o(b2)) {
                            obj5 = this.F.i();
                        } else {
                            obj5 = this.F.m();
                        }
                        FlexboxLayoutManager.b.g(b2, obj5);
                    }
                }
            }
            return i6;
        }
        return i2;
    }

    static int i2(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.t;
    }

    private boolean i3(RecyclerView.b0 recyclerView$b0, com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b2, com.google.android.flexbox.FlexboxLayoutManager.e flexboxLayoutManager$e3) {
        boolean z;
        com.google.android.flexbox.FlexboxLayoutManager.e eVar;
        int i;
        int i4;
        int i2;
        int i3;
        boolean obj6;
        int obj8;
        i = 0;
        if (!b0.f()) {
            z = this.I;
            i4 = -1;
            if (z == i4) {
            } else {
                i2 = Integer.MIN_VALUE;
                if (z >= 0) {
                    if (z >= b0.c()) {
                    } else {
                        FlexboxLayoutManager.b.b(b2, this.I);
                        FlexboxLayoutManager.b.d(b2, dVar.c[FlexboxLayoutManager.b.a(b2)]);
                        eVar = this.H;
                        int i10 = 1;
                        if (eVar != null && FlexboxLayoutManager.e.f(eVar, b0.c())) {
                            if (FlexboxLayoutManager.e.f(eVar, b0.c())) {
                                FlexboxLayoutManager.b.g(b2, obj6 += obj8);
                                FlexboxLayoutManager.b.h(b2, i10);
                                FlexboxLayoutManager.b.d(b2, i4);
                                return i10;
                            }
                        }
                        if (this.J == i2) {
                            obj6 = Z(this.I);
                            if (obj6 != null) {
                                if (this.F.e(obj6) > this.F.n()) {
                                    FlexboxLayoutManager.b.e(b2);
                                    return i10;
                                }
                                if (obj8 -= i8 < 0) {
                                    FlexboxLayoutManager.b.g(b2, this.F.m());
                                    FlexboxLayoutManager.b.p(b2, i);
                                    return i10;
                                }
                                if (obj8 -= eVar < 0) {
                                    FlexboxLayoutManager.b.g(b2, this.F.i());
                                    FlexboxLayoutManager.b.p(b2, i10);
                                    return i10;
                                }
                                if (FlexboxLayoutManager.b.o(b2)) {
                                    obj6 += obj8;
                                } else {
                                    obj6 = this.F.g(obj6);
                                }
                                FlexboxLayoutManager.b.g(b2, obj6);
                            } else {
                                if (g0() > 0 && this.I < A0(f0(i))) {
                                    if (this.I < A0(f0(i))) {
                                        i = i10;
                                    }
                                    FlexboxLayoutManager.b.p(b2, i);
                                }
                                FlexboxLayoutManager.b.e(b2);
                            }
                            return i10;
                        }
                        if (!w() && this.x) {
                            if (this.x) {
                                FlexboxLayoutManager.b.g(b2, obj6 -= obj8);
                            } else {
                                FlexboxLayoutManager.b.g(b2, obj6 += obj8);
                            }
                        } else {
                        }
                    }
                    return i10;
                }
                this.I = i4;
                this.J = i2;
            }
        }
        return i;
    }

    static int j2(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.s;
    }

    private void j3(RecyclerView.b0 recyclerView$b0, com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b2) {
        if (i3(b0, b2, this.H)) {
        }
        if (h3(b0, b2)) {
        }
        FlexboxLayoutManager.b.e(b2);
        int obj2 = 0;
        FlexboxLayoutManager.b.b(b2, obj2);
        FlexboxLayoutManager.b.d(b2, obj2);
    }

    static boolean k2(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.x;
    }

    private void k3(int i) {
        int i2;
        boolean z;
        int obj3;
        if (i >= D2()) {
        }
        int i4 = g0();
        this.A.m(i4);
        this.A.n(i4);
        this.A.l(i4);
        if (i >= iArr.length) {
        }
        this.Q = i;
        obj3 = J2();
        if (obj3 == null) {
        }
        this.I = A0(obj3);
        if (!w() && this.x) {
            if (this.x) {
                this.J = obj3 += i2;
            } else {
                this.J = obj3 -= i2;
            }
        } else {
        }
    }

    static t l2(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.F;
    }

    private void l3(int i) {
        int measureSpec;
        int measureSpec2;
        int i4;
        com.google.android.flexbox.d dVar;
        int i7;
        com.google.android.flexbox.d.a aVar;
        int heightPixels;
        int i3;
        int i8;
        int i5;
        int i2;
        List list;
        List list2;
        int i6;
        int obj12;
        measureSpec = View.MeasureSpec.makeMeasureSpec(H0(), I0());
        measureSpec2 = View.MeasureSpec.makeMeasureSpec(t0(), u0());
        int i14 = H0();
        int i16 = t0();
        i8 = 1;
        int i19 = 0;
        int i21 = Integer.MIN_VALUE;
        if (w()) {
            int i18 = this.K;
            if (i18 != i21 && i18 != i14) {
                if (i18 != i14) {
                } else {
                    i8 = i19;
                }
            } else {
            }
            if (FlexboxLayoutManager.d.c(this.D)) {
                heightPixels = displayMetrics2.heightPixels;
            } else {
                heightPixels = FlexboxLayoutManager.d.e(this.D);
            }
        } else {
            int i17 = this.L;
            if (i17 != i21 && i17 != i16) {
                if (i17 != i16) {
                } else {
                    i8 = i19;
                }
            } else {
            }
            if (FlexboxLayoutManager.d.c(this.D)) {
                heightPixels = displayMetrics.widthPixels;
            } else {
                heightPixels = FlexboxLayoutManager.d.e(this.D);
            }
        }
        int i20 = heightPixels;
        this.K = i14;
        this.L = i16;
        int i15 = this.Q;
        i7 = -1;
        if (i15 == i7) {
            if (this.I == i7) {
                if (i8 != 0) {
                    if (FlexboxLayoutManager.b.o(this.E)) {
                    }
                    this.z.clear();
                    this.R.a();
                    if (w()) {
                        this.A.d(this.R, measureSpec, measureSpec2, i20, FlexboxLayoutManager.b.a(this.E), this.z);
                    } else {
                        this.A.f(this.R, measureSpec, measureSpec2, i20, FlexboxLayoutManager.b.a(this.E), this.z);
                    }
                    this.z = obj12.a;
                    this.A.i(measureSpec, measureSpec2);
                    this.A.O();
                    obj12 = this.E;
                    FlexboxLayoutManager.b.d(obj12, dVar2.c[FlexboxLayoutManager.b.a(obj12)]);
                    FlexboxLayoutManager.d.h(this.D, FlexboxLayoutManager.b.c(this.E));
                } else {
                    if (i15 != i7) {
                        i4 = Math.min(i15, FlexboxLayoutManager.b.a(this.E));
                    } else {
                        i4 = FlexboxLayoutManager.b.a(this.E);
                    }
                    i6 = i4;
                    this.R.a();
                    if (w()) {
                        if (this.z.size() > 0) {
                            this.A.h(this.z, i6);
                            this.A.b(this.R, measureSpec, measureSpec2, i20, i6, FlexboxLayoutManager.b.a(this.E), this.z);
                        } else {
                            this.A.l(i);
                            this.A.c(this.R, measureSpec, measureSpec2, i20, 0, this.z);
                        }
                    } else {
                        if (this.z.size() > 0) {
                            this.A.h(this.z, i6);
                            this.A.b(this.R, measureSpec2, measureSpec, i20, i6, FlexboxLayoutManager.b.a(this.E), this.z);
                        } else {
                            this.A.l(i);
                            this.A.e(this.R, measureSpec, measureSpec2, i20, 0, this.z);
                        }
                    }
                    this.z = obj12.a;
                    this.A.j(measureSpec, measureSpec2, i6);
                    this.A.P(i6);
                }
            } else {
            }
        } else {
        }
    }

    static t m2(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.G;
    }

    private void m3(int i, int i2) {
        int z2;
        com.google.android.flexbox.FlexboxLayoutManager.d dVar;
        int measureSpec2;
        int i10;
        int i4;
        List measureSpec;
        int i7;
        int i11;
        boolean z;
        int i3;
        int i5;
        int i6;
        int i8;
        int i9;
        com.google.android.flexbox.FlexboxLayoutManager.d obj11;
        FlexboxLayoutManager.d.q(this.D, i);
        z2 = w();
        measureSpec2 = View.MeasureSpec.makeMeasureSpec(H0(), I0());
        measureSpec = View.MeasureSpec.makeMeasureSpec(t0(), u0());
        i7 = 0;
        i11 = 1;
        if (!z2 && this.x) {
            i3 = this.x ? i11 : i7;
        } else {
        }
        i5 = -1;
        if (i == i11) {
            obj11 = f0(obj11 -= i11);
            FlexboxLayoutManager.d.b(this.D, this.F.d(obj11));
            int i25 = A0(obj11);
            obj11 = C2(obj11, (c)this.z.get(dVar19.c[i25]));
            FlexboxLayoutManager.d.s(this.D, i11);
            com.google.android.flexbox.FlexboxLayoutManager.d dVar21 = this.D;
            FlexboxLayoutManager.d.o(dVar21, i25 += i9);
            if (iArr3.length <= FlexboxLayoutManager.d.n(this.D)) {
                FlexboxLayoutManager.d.h(this.D, i5);
            } else {
                i6 = this.D;
                FlexboxLayoutManager.d.h(i6, dVar23.c[FlexboxLayoutManager.d.n(i6)]);
            }
            if (i3 != 0) {
                FlexboxLayoutManager.d.b(this.D, this.F.g(obj11));
                FlexboxLayoutManager.d.l(this.D, obj11 += i6);
                obj11 = this.D;
                if (FlexboxLayoutManager.d.k(obj11) >= 0) {
                    i7 = FlexboxLayoutManager.d.k(this.D);
                }
                FlexboxLayoutManager.d.l(obj11, i7);
            } else {
                FlexboxLayoutManager.d.b(this.D, this.F.d(obj11));
                FlexboxLayoutManager.d.l(this.D, obj11 -= i3);
            }
            if (FlexboxLayoutManager.d.g(this.D) != i5) {
                i6 = i2 - obj11;
                this.R.a();
                if (FlexboxLayoutManager.d.g(this.D) > size -= i11 && FlexboxLayoutManager.d.n(this.D) <= c() && i6 > 0) {
                    if (FlexboxLayoutManager.d.n(this.D) <= c()) {
                        i6 = i2 - obj11;
                        this.R.a();
                        if (i6 > 0) {
                            if (z2) {
                                this.A.c(this.R, measureSpec2, measureSpec, i6, FlexboxLayoutManager.d.n(this.D), this.z);
                            } else {
                                this.A.e(this.R, measureSpec2, measureSpec, i6, FlexboxLayoutManager.d.n(this.D), this.z);
                            }
                            this.A.j(measureSpec2, measureSpec, FlexboxLayoutManager.d.n(this.D));
                            this.A.P(FlexboxLayoutManager.d.n(this.D));
                        }
                    }
                }
            } else {
            }
        } else {
            obj11 = f0(i7);
            FlexboxLayoutManager.d.b(this.D, this.F.g(obj11));
            int i13 = A0(obj11);
            obj11 = z2(obj11, (c)this.z.get(dVar10.c[i13]));
            FlexboxLayoutManager.d.s(this.D, i11);
            if (dVar12.c[i13] == i5) {
                i10 = i7;
            }
            if (i10 > 0) {
                FlexboxLayoutManager.d.o(this.D, i13 -= measureSpec);
            } else {
                FlexboxLayoutManager.d.o(this.D, i5);
            }
            i4 = i10 > 0 ? i10 - i11 : i7;
            FlexboxLayoutManager.d.h(this.D, i4);
            if (i3 != 0) {
                FlexboxLayoutManager.d.b(this.D, this.F.d(obj11));
                FlexboxLayoutManager.d.l(this.D, obj11 -= measureSpec2);
                obj11 = this.D;
                if (FlexboxLayoutManager.d.k(obj11) >= 0) {
                    i7 = FlexboxLayoutManager.d.k(this.D);
                }
                FlexboxLayoutManager.d.l(obj11, i7);
            } else {
                FlexboxLayoutManager.d.b(this.D, this.F.g(obj11));
                FlexboxLayoutManager.d.l(this.D, obj11 += measureSpec2);
            }
        }
        obj11 = this.D;
        FlexboxLayoutManager.d.f(obj11, i2 -= i12);
    }

    static com.google.android.flexbox.d n2(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.A;
    }

    private void n3(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, boolean z2, boolean z3) {
        int i;
        int i2;
        int i3;
        com.google.android.flexbox.FlexboxLayoutManager.b obj3;
        int obj4;
        com.google.android.flexbox.FlexboxLayoutManager.d obj5;
        if (z3 != null) {
            b3();
        } else {
            FlexboxLayoutManager.d.d(this.D, false);
        }
        if (!w() && this.x) {
            if (this.x) {
                FlexboxLayoutManager.d.f(this.D, i7 -= i3);
            } else {
                FlexboxLayoutManager.d.f(this.D, i6 -= i3);
            }
        } else {
        }
        FlexboxLayoutManager.d.o(this.D, FlexboxLayoutManager.b.a(b));
        int i5 = 1;
        FlexboxLayoutManager.d.s(this.D, i5);
        FlexboxLayoutManager.d.q(this.D, i5);
        FlexboxLayoutManager.d.b(this.D, FlexboxLayoutManager.b.f(b));
        FlexboxLayoutManager.d.l(this.D, Integer.MIN_VALUE);
        FlexboxLayoutManager.d.h(this.D, FlexboxLayoutManager.b.c(b));
        if (z2 != 0 && this.z.size() > i5 && FlexboxLayoutManager.b.c(b) >= 0 && FlexboxLayoutManager.b.c(b) < obj5 -= i5) {
            if (this.z.size() > i5) {
                if (FlexboxLayoutManager.b.c(b) >= 0) {
                    if (FlexboxLayoutManager.b.c(b) < obj5 -= i5) {
                        FlexboxLayoutManager.d.i(this.D);
                        obj4 = this.D;
                        FlexboxLayoutManager.d.o(obj4, obj5 += obj3);
                    }
                }
            }
        }
    }

    static List o2(com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager) {
        return flexboxLayoutManager.z;
    }

    private void o3(com.google.android.flexbox.FlexboxLayoutManager.b flexboxLayoutManager$b, boolean z2, boolean z3) {
        int i2;
        int i3;
        int i;
        com.google.android.flexbox.FlexboxLayoutManager.b obj3;
        int obj4;
        com.google.android.flexbox.FlexboxLayoutManager.d obj5;
        if (z3 != null) {
            b3();
        } else {
            FlexboxLayoutManager.d.d(this.D, false);
        }
        if (!w() && this.x) {
            if (this.x) {
                FlexboxLayoutManager.d.f(this.D, i11 -= i);
            } else {
                FlexboxLayoutManager.d.f(this.D, i10 -= i);
            }
        } else {
        }
        FlexboxLayoutManager.d.o(this.D, FlexboxLayoutManager.b.a(b));
        FlexboxLayoutManager.d.s(this.D, 1);
        FlexboxLayoutManager.d.q(this.D, -1);
        FlexboxLayoutManager.d.b(this.D, FlexboxLayoutManager.b.f(b));
        FlexboxLayoutManager.d.l(this.D, Integer.MIN_VALUE);
        FlexboxLayoutManager.d.h(this.D, FlexboxLayoutManager.b.c(b));
        if (z2 != 0 && FlexboxLayoutManager.b.c(b) > 0 && this.z.size() > FlexboxLayoutManager.b.c(b)) {
            if (FlexboxLayoutManager.b.c(b) > 0) {
                if (this.z.size() > FlexboxLayoutManager.b.c(b)) {
                    FlexboxLayoutManager.d.j(this.D);
                    obj4 = this.D;
                    FlexboxLayoutManager.d.o(obj4, obj5 -= obj3);
                }
            }
        }
    }

    private boolean p2(View view, int i2) {
        boolean z;
        int i;
        i = 1;
        final int i5 = 0;
        if (!w() && this.x) {
            if (this.x) {
                if (this.F.d(view) <= i2) {
                } else {
                    i = i5;
                }
                return i;
            }
        }
        if (this.F.g(view) >= i3 -= i2) {
        } else {
            i = i5;
        }
        return i;
    }

    private boolean q2(View view, int i2) {
        boolean z;
        int i;
        i = 1;
        final int i5 = 0;
        if (!w() && this.x) {
            if (this.x) {
                if (i3 -= obj5 <= i2) {
                } else {
                    i = i5;
                }
                return i;
            }
        }
        if (this.F.d(view) <= i2) {
        } else {
            i = i5;
        }
        return i;
    }

    private void r2() {
        this.z.clear();
        FlexboxLayoutManager.b.n(this.E);
        FlexboxLayoutManager.b.k(this.E, 0);
    }

    private int s2(RecyclerView.b0 recyclerView$b0) {
        final int i5 = 0;
        if (g0() == 0) {
            return i5;
        }
        int i2 = b0.c();
        w2();
        final View view2 = y2(i2);
        View view = B2(i2);
        if (b0.c() != 0 && view2 != null && view == null) {
            if (view2 != null) {
                if (view == null) {
                }
                return Math.min(this.F.n(), obj4 -= i3);
            }
        }
        return i5;
    }

    private int t2(RecyclerView.b0 recyclerView$b0) {
        View view;
        int i2;
        int[] iArr;
        int i;
        int obj7;
        int i10 = 0;
        if (g0() == 0) {
            return i10;
        }
        int i4 = b0.c();
        final View view2 = y2(i4);
        view = B2(i4);
        if (b0.c() != 0 && view2 != null) {
            if (view2 != null) {
                if (view == null) {
                } else {
                    iArr = dVar.c;
                    obj7 = iArr[A0(view2)];
                    if (obj7 != null && obj7 == -1) {
                        if (obj7 == -1) {
                        }
                        return Math.round(obj7 += f2);
                    }
                }
            }
        }
        return i10;
    }

    private int u2(RecyclerView.b0 recyclerView$b0) {
        int i8 = 0;
        if (g0() == 0) {
            return i8;
        }
        int i2 = b0.c();
        View view2 = y2(i2);
        View view = B2(i2);
        if (b0.c() != 0 && view2 != null && view == null) {
            if (view2 != null) {
                if (view == null) {
                }
                return (int)i7;
            }
        }
        return i8;
    }

    private void v2() {
        com.google.android.flexbox.FlexboxLayoutManager.d dVar;
        int i;
        if (this.D == null) {
            dVar = new FlexboxLayoutManager.d(0);
            this.D = dVar;
        }
    }

    private void w2() {
        t tVar;
        if (this.F != null) {
        }
        if (w()) {
            if (this.t == 0) {
                this.F = t.a(this);
                this.G = t.c(this);
            } else {
                this.F = t.c(this);
                this.G = t.a(this);
            }
        } else {
            if (this.t == 0) {
                this.F = t.c(this);
                this.G = t.a(this);
            } else {
                this.F = t.a(this);
                this.G = t.c(this);
            }
        }
    }

    private int x2(RecyclerView.w recyclerView$w, RecyclerView.b0 recyclerView$b02, com.google.android.flexbox.FlexboxLayoutManager.d flexboxLayoutManager$d3) {
        int i4;
        int i9;
        int i10;
        int i;
        int i8;
        int i5;
        int i2;
        int i6;
        int i7;
        int i3;
        int obj11;
        i9 = Integer.MIN_VALUE;
        if (FlexboxLayoutManager.d.k(d3) != i9 && FlexboxLayoutManager.d.e(d3) < 0) {
            if (FlexboxLayoutManager.d.e(d3) < 0) {
                FlexboxLayoutManager.d.l(d3, i11 += i10);
            }
            X2(w, d3);
        }
        i = FlexboxLayoutManager.d.e(d3);
        i8 = 0;
        while (i <= 0) {
            if (FlexboxLayoutManager.d.c(this.D)) {
            }
            if (FlexboxLayoutManager.d.m(d3, b02, this.z)) {
            }
            Object obj = this.z.get(FlexboxLayoutManager.d.g(d3));
            FlexboxLayoutManager.d.o(d3, obj.k);
            i8 += i6;
            if (!w() && this.x) {
            } else {
            }
            FlexboxLayoutManager.d.b(d3, i16 += i7);
            i -= i5;
            if (this.x) {
            } else {
            }
            FlexboxLayoutManager.d.b(d3, i17 -= i7);
        }
        FlexboxLayoutManager.d.f(d3, obj11 -= i8);
        FlexboxLayoutManager.d.l(d3, obj11 += i8);
        if (FlexboxLayoutManager.d.k(d3) != i9 && FlexboxLayoutManager.d.e(d3) < 0) {
            FlexboxLayoutManager.d.l(d3, obj11 += i8);
            if (FlexboxLayoutManager.d.e(d3) < 0) {
                FlexboxLayoutManager.d.l(d3, obj11 += i9);
            }
            X2(w, d3);
        }
        return i12 -= obj10;
    }

    private View y2(int i) {
        View obj4 = F2(0, g0(), i);
        int i3 = 0;
        if (obj4 == null) {
            return i3;
        }
        int i6 = dVar.c[A0(obj4)];
        if (i6 == -1) {
            return i3;
        }
        return z2(obj4, (c)this.z.get(i6));
    }

    private View z2(View view, com.google.android.flexbox.c c2) {
        int i2;
        View view2;
        int visibility;
        int i;
        View obj6;
        i2 = 1;
        while (i2 < c2.d) {
            view2 = f0(i2);
            if (view2 != null) {
            }
            i2++;
            if (view2.getVisibility() == 8) {
            } else {
            }
            if (this.x && !w()) {
            } else {
            }
            if (this.F.g(obj6) > this.F.g(view2)) {
            }
            obj6 = view2;
            if (!w()) {
            } else {
            }
            if (this.F.d(obj6) < this.F.d(view2)) {
            }
        }
        return obj6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int A2() {
        int i;
        final int i3 = 0;
        View view = E2(i3, g0(), i3);
        if (view == null) {
            i = -1;
        } else {
            i = A0(view);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int D2() {
        int i;
        View view = E2(i2--, -1, false);
        if (view == null) {
        } else {
            i = A0(view);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean H() {
        boolean z;
        int i;
        int width;
        if (this.t == 0) {
            return w();
        }
        if (w()) {
            View view = this.P;
            if (view != null) {
                width = view.getWidth();
            } else {
                width = i;
            }
            if (H0() > width) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean I() {
        boolean z;
        int i;
        int height;
        if (this.t == 0) {
            return z2 ^= i;
        }
        final int i4 = 0;
        if (!w()) {
            View view = this.P;
            if (view != null) {
                height = view.getHeight();
            } else {
                height = i4;
            }
            if (t0() > height) {
            } else {
                i = i4;
            }
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean J(RecyclerView.q recyclerView$q) {
        return q instanceof FlexboxLayoutManager.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int N(RecyclerView.b0 recyclerView$b0) {
        return s2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public View N2(int i) {
        Object obj = this.N.get(i);
        if ((View)obj != null) {
            return (View)obj;
        }
        return this.B.o(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int O(RecyclerView.b0 recyclerView$b0) {
        return t2(b0);
    }

    public List<com.google.android.flexbox.c> O2() {
        int i2;
        Object obj;
        int i;
        ArrayList arrayList = new ArrayList(this.z.size());
        i2 = 0;
        while (i2 < this.z.size()) {
            obj = this.z.get(i2);
            if ((c)obj.b() == 0) {
            } else {
            }
            arrayList.add(obj);
            i2++;
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int P(RecyclerView.b0 recyclerView$b0) {
        return u2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    int P2(int i) {
        return dVar.c[i];
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int Q(RecyclerView.b0 recyclerView$b0) {
        return s2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int R(RecyclerView.b0 recyclerView$b0) {
        return t2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int R1(int i, RecyclerView.w recyclerView$w2, RecyclerView.b0 recyclerView$b03) {
        int z;
        if (w() && this.t == 0 && w()) {
            if (this.t == 0) {
                if (w()) {
                }
            }
            int obj2 = R2(i);
            com.google.android.flexbox.FlexboxLayoutManager.b obj3 = this.E;
            FlexboxLayoutManager.b.k(obj3, obj4 += obj2);
            this.G.r(-obj2);
            return obj2;
        }
        this.N.clear();
        return Q2(i, w2, b03);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int S(RecyclerView.b0 recyclerView$b0) {
        return u2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void S1(int i) {
        this.I = i;
        this.J = Integer.MIN_VALUE;
        com.google.android.flexbox.FlexboxLayoutManager.e obj1 = this.H;
        if (obj1 != null) {
            FlexboxLayoutManager.e.e(obj1);
        }
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    boolean S2() {
        return this.x;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int T1(int i, RecyclerView.w recyclerView$w2, RecyclerView.b0 recyclerView$b03) {
        int z;
        if (!w() && this.t == 0 && !w()) {
            if (this.t == 0) {
                if (!w()) {
                }
            }
            int obj2 = R2(i);
            com.google.android.flexbox.FlexboxLayoutManager.b obj3 = this.E;
            FlexboxLayoutManager.b.k(obj3, obj4 += obj2);
            this.G.r(-obj2);
            return obj2;
        }
        this.N.clear();
        return Q2(i, w2, b03);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void Y0(RecyclerView.h recyclerView$h, RecyclerView.h recyclerView$h2) {
        E1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public RecyclerView.q a0() {
        final int i = -2;
        FlexboxLayoutManager.c cVar = new FlexboxLayoutManager.c(i, i);
        return cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void a1(RecyclerView recyclerView) {
        super.a1(recyclerView);
        this.P = (View)recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public RecyclerView.q b0(Context context, AttributeSet attributeSet2) {
        FlexboxLayoutManager.c cVar = new FlexboxLayoutManager.c(context, attributeSet2);
        return cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int c() {
        return this.C.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void c1(RecyclerView recyclerView, RecyclerView.w recyclerView$w2) {
        super.c1(recyclerView, w2);
        if (this.M) {
            F1(w2);
            w2.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public PointF d(int i) {
        int obj3;
        if (g0() == 0) {
            return null;
        }
        obj3 = i < A0(f0(0)) ? -1 : 1;
        final int i5 = 0;
        if (w()) {
            PointF pointF2 = new PointF(i5, (float)obj3);
            return pointF2;
        }
        PointF pointF = new PointF((float)obj3, i5);
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void d3(int i) {
        int i2;
        final int i3 = this.v;
        if (i3 != i) {
            i2 = 4;
            if (i3 != i2) {
                if (i == i2) {
                    E1();
                    r2();
                }
            } else {
            }
            this.v = i;
            O1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void e(View view, int i2, int i3, com.google.android.flexbox.c c4) {
        int obj1;
        int obj2;
        G(view, FlexboxLayoutManager.S);
        if (w()) {
            obj2 += obj1;
            c4.a = obj1 += obj2;
            c4.b = obj1 += obj2;
        } else {
            obj2 += obj1;
            c4.a = obj1 += obj2;
            c4.b = obj1 += obj2;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void e2(RecyclerView recyclerView, RecyclerView.b0 recyclerView$b02, int i3) {
        p obj2 = new p(recyclerView.getContext());
        obj2.setTargetPosition(i3);
        f2(obj2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void e3(int i) {
        int obj2;
        if (this.s != i) {
            E1();
            this.s = i;
            obj2 = 0;
            this.F = obj2;
            this.G = obj2;
            r2();
            O1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int f() {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void f3(int i) {
        int obj2;
        if (i == 2) {
        } else {
            int i3 = this.t;
            if (i3 != i) {
                if (i3 != 0) {
                    if (i == 0) {
                        E1();
                        r2();
                    }
                } else {
                }
                this.t = i;
                obj2 = 0;
                this.F = obj2;
                this.G = obj2;
                O1();
            }
        }
        obj2 = new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        throw obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int g() {
        return this.w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void g3(int i) {
        if (this.u != i) {
            this.u = i;
            O1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int h() {
        int i3;
        int i2;
        int i;
        if (this.z.size() == 0) {
            return 0;
        }
        i3 = Integer.MIN_VALUE;
        while (i2 < this.z.size()) {
            i3 = Math.max(i3, obj.a);
            i2++;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int i() {
        return this.t;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void j(com.google.android.flexbox.c c) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public View k(int i) {
        return N2(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int l(int i, int i2, int i3) {
        return RecyclerView.p.h0(H0(), I0(), i2, i3, H());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void l1(RecyclerView recyclerView, int i2, int i3) {
        super.l1(recyclerView, i2, i3);
        k3(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int m() {
        return this.v;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void n(int i, View view2) {
        this.N.put(i, view2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void n1(RecyclerView recyclerView, int i2, int i3, int i4) {
        super.n1(recyclerView, i2, i3, i4);
        k3(Math.min(i2, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void o1(RecyclerView recyclerView, int i2, int i3) {
        super.o1(recyclerView, i2, i3);
        k3(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void p1(RecyclerView recyclerView, int i2, int i3) {
        super.p1(recyclerView, i2, i3);
        k3(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int q(View view, int i2, int i3) {
        int obj1;
        int obj2;
        if (w()) {
            obj2 = x0(view);
            obj1 = C0(view);
        } else {
            obj2 = F0(view);
            obj1 = e0(view);
        }
        return obj2 += obj1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void q1(RecyclerView recyclerView, int i2, int i3, Object object4) {
        super.q1(recyclerView, i2, i3, object4);
        k3(i2);
    }

    public List<com.google.android.flexbox.c> r() {
        return this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void r1(RecyclerView.w recyclerView$w, RecyclerView.b0 recyclerView$b02) {
        int i2;
        boolean z;
        com.google.android.flexbox.FlexboxLayoutManager.e eVar;
        boolean z2;
        com.google.android.flexbox.FlexboxLayoutManager.b bVar;
        int i4;
        int i3;
        int i;
        this.B = w;
        this.C = b02;
        int i5 = b02.c();
        if (i5 == 0 && b02.f()) {
            if (b02.f()) {
            }
        }
        c3();
        w2();
        v2();
        this.A.m(i5);
        this.A.n(i5);
        this.A.l(i5);
        final int i6 = 0;
        FlexboxLayoutManager.d.v(this.D, i6);
        eVar = this.H;
        if (eVar != null && FlexboxLayoutManager.e.f(eVar, i5)) {
            if (FlexboxLayoutManager.e.f(eVar, i5)) {
                this.I = FlexboxLayoutManager.e.a(this.H);
            }
        }
        final int i7 = 1;
        if (FlexboxLayoutManager.b.l(this.E) && this.I == -1) {
            if (this.I == -1) {
                if (this.H != null) {
                    FlexboxLayoutManager.b.n(this.E);
                    j3(b02, this.E);
                    FlexboxLayoutManager.b.m(this.E, i7);
                }
            } else {
            }
        } else {
        }
        T(w);
        if (FlexboxLayoutManager.b.o(this.E)) {
            o3(this.E, i6, i7);
        } else {
            n3(this.E, i6, i7);
        }
        l3(i5);
        if (FlexboxLayoutManager.b.o(this.E)) {
            x2(w, b02, this.D);
            i2 = FlexboxLayoutManager.d.a(this.D);
            n3(this.E, i7, i6);
            x2(w, b02, this.D);
            i4 = FlexboxLayoutManager.d.a(this.D);
        } else {
            x2(w, b02, this.D);
            i4 = FlexboxLayoutManager.d.a(this.D);
            o3(this.E, i7, i6);
            x2(w, b02, this.D);
            i2 = FlexboxLayoutManager.d.a(this.D);
        }
        if (g0() > 0) {
            if (FlexboxLayoutManager.b.o(this.E)) {
                H2(i2 += i4, w, b02, i6);
            } else {
                G2(i4 += i2, w, b02, i6);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int s(int i, int i2, int i3) {
        return RecyclerView.p.h0(t0(), u0(), i2, i3, I());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void s1(RecyclerView.b0 recyclerView$b0) {
        super.s1(b0);
        this.H = 0;
        int obj2 = -1;
        this.I = obj2;
        this.J = Integer.MIN_VALUE;
        this.Q = obj2;
        FlexboxLayoutManager.b.n(this.E);
        this.N.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean w() {
        int i;
        final int i2 = this.s;
        if (i2 != 0) {
            if (i2 == 1) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void w1(Parcelable parcelable) {
        if (parcelable instanceof FlexboxLayoutManager.e) {
            this.H = (FlexboxLayoutManager.e)parcelable;
            O1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int x(View view) {
        int i;
        int obj2;
        if (w()) {
            i = F0(view);
            obj2 = e0(view);
        } else {
            i = x0(view);
            obj2 = C0(view);
        }
        return i += obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public Parcelable x1() {
        int i;
        int i2;
        if (this.H != null) {
            FlexboxLayoutManager.e eVar2 = new FlexboxLayoutManager.e(this.H, 0);
            return eVar2;
        }
        FlexboxLayoutManager.e eVar3 = new FlexboxLayoutManager.e();
        if (g0() > 0) {
            View view = J2();
            FlexboxLayoutManager.e.b(eVar3, A0(view));
            FlexboxLayoutManager.e.d(eVar3, i3 -= i2);
        } else {
            FlexboxLayoutManager.e.e(eVar3);
        }
        return eVar3;
    }
}
