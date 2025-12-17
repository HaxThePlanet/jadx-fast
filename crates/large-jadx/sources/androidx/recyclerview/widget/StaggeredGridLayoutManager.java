package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends androidx.recyclerview.widget.RecyclerView.p implements androidx.recyclerview.widget.RecyclerView.a0.b {

    boolean A = false;
    private BitSet B;
    int C = -1;
    int D = Integer.MIN_VALUE;
    androidx.recyclerview.widget.StaggeredGridLayoutManager.d E;
    private int F = 2;
    private boolean G;
    private boolean H;
    private androidx.recyclerview.widget.StaggeredGridLayoutManager.e I;
    private int J;
    private final Rect K;
    private final androidx.recyclerview.widget.StaggeredGridLayoutManager.b L;
    private boolean M = false;
    private boolean N = true;
    private int[] O;
    private final Runnable P;
    private int s = -1;
    androidx.recyclerview.widget.StaggeredGridLayoutManager.f[] t;
    androidx.recyclerview.widget.t u;
    androidx.recyclerview.widget.t v;
    private int w;
    private int x;
    private final androidx.recyclerview.widget.o y;
    boolean z = false;

    class a implements Runnable {

        final androidx.recyclerview.widget.StaggeredGridLayoutManager a;
        a(androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.a = staggeredGridLayoutManager;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.o2();
        }
    }

    class b {

        int a;
        int b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;
        final androidx.recyclerview.widget.StaggeredGridLayoutManager g;
        b(androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.g = staggeredGridLayoutManager;
            super();
            c();
        }

        void a() {
            int i;
            if (this.c) {
                i = staggeredGridLayoutManager.u.i();
            } else {
                i = staggeredGridLayoutManager2.u.m();
            }
            this.b = i;
        }

        void b(int i) {
            int i2;
            if (this.c) {
                this.b = i3 -= i;
            } else {
                this.b = i4 += i;
            }
        }

        void c() {
            final int i = -1;
            this.a = i;
            this.b = Integer.MIN_VALUE;
            int i3 = 0;
            this.c = i3;
            this.d = i3;
            this.e = i3;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, i);
            }
        }

        void d(androidx.recyclerview.widget.StaggeredGridLayoutManager.f[] staggeredGridLayoutManager$fArr) {
            int iArr;
            int i3;
            int[] iArr2;
            int i2;
            int i;
            final int length = fArr.length;
            iArr = this.f;
            if (iArr != null) {
                if (iArr.length < length) {
                    this.f = new int[objArr.length];
                }
            } else {
            }
            i3 = 0;
            while (i3 < length) {
                this.f[i3] = fArr[i3].u(Integer.MIN_VALUE);
                i3++;
            }
        }
    }

    static class d {

        int[] a;
        List<androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a> b;
        private int i(int i) {
            List list;
            int i3;
            int i2;
            final int i4 = -1;
            if (this.b == null) {
                return i4;
            }
            androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a aVar = f(i);
            if (aVar != null) {
                this.b.remove(aVar);
            }
            i3 = 0;
            while (i3 < this.b.size()) {
                i3++;
            }
            i3 = i4;
            if (i3 != i4) {
                this.b.remove(i3);
                return obj5.a;
            }
            return i4;
        }

        private void l(int i, int i2) {
            int i4;
            Object obj;
            int i3;
            List list = this.b;
            if (list == null) {
            }
            size--;
            while (i4 >= 0) {
                obj = this.b.get(i4);
                i3 = obj.a;
                if (i3 < i) {
                } else {
                }
                obj.a = i3 += i2;
                i4--;
            }
        }

        private void m(int i, int i2) {
            int i3;
            List list;
            int i4;
            List list2 = this.b;
            if (list2 == null) {
            }
            size--;
            while (i3 >= 0) {
                list = this.b.get(i3);
                i4 = list.a;
                if (i4 < i) {
                } else {
                }
                if (i4 < i + i2) {
                } else {
                }
                list.a = i4 -= i2;
                i3--;
                this.b.remove(i3);
            }
        }

        public void a(androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a staggeredGridLayoutManager$d$a) {
            Object arrayList;
            int i2;
            int i3;
            int i4;
            int i5;
            int i;
            if (this.b == null) {
                arrayList = new ArrayList();
                this.b = arrayList;
            }
            i2 = 0;
            while (i2 < this.b.size()) {
                Object obj = this.b.get(i2);
                if (obj.a == a.a) {
                }
                i2++;
                this.b.remove(i2);
            }
            this.b.add(a);
        }

        void b() {
            int i;
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = 0;
        }

        void c(int i) {
            int length2;
            int length;
            int i2;
            int[] obj5;
            length2 = this.a;
            final int i3 = -1;
            if (length2 == null) {
                obj5 = new int[obj5++];
                this.a = obj5;
                Arrays.fill(obj5, i3);
            } else {
                if (i >= length2.length) {
                    obj5 = new int[o(i)];
                    this.a = obj5;
                    i2 = 0;
                    System.arraycopy(length2, i2, obj5, i2, length2.length);
                    obj5 = this.a;
                    Arrays.fill(obj5, length2.length, obj5.length, i3);
                }
            }
        }

        int d(int i) {
            int list;
            int i2;
            list = this.b;
            if (list != null) {
                size--;
                while (list >= 0) {
                    if (obj.a >= i) {
                    }
                    list--;
                    this.b.remove(list);
                }
            }
            return h(i);
        }

        public androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a e(int i, int i2, int i3, boolean z4) {
            int i5;
            Object obj;
            int i4;
            List list = this.b;
            final int i6 = 0;
            if (list == null) {
                return i6;
            }
            i5 = 0;
            while (i5 < list.size()) {
                obj = this.b.get(i5);
                i4 = obj.a;
                i5++;
            }
            return i6;
        }

        public androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a f(int i) {
            int i3;
            Object obj;
            int i2;
            List list = this.b;
            final int i4 = 0;
            if (list == null) {
                return i4;
            }
            size--;
            while (i3 >= 0) {
                obj = this.b.get(i3);
                i3--;
            }
            return i4;
        }

        int g(int i) {
            int length;
            final int[] iArr = this.a;
            if (iArr != null && i >= iArr.length) {
                if (i >= iArr.length) {
                }
                return iArr[i];
            }
            return -1;
        }

        int h(int i) {
            int[] iArr = this.a;
            final int i5 = -1;
            if (iArr == null) {
                return i5;
            }
            if (i >= iArr.length) {
                return i5;
            }
            int i2 = i(i);
            if (i2 == i5) {
                int[] iArr2 = this.a;
                Arrays.fill(iArr2, i, iArr2.length, i5);
                return obj4.length;
            }
            int i4 = Math.min(i2++, iArr3.length);
            Arrays.fill(this.a, i, i4, i5);
            return i4;
        }

        void j(int i, int i2) {
            int[] length;
            int[] iArr;
            int i3;
            length = this.a;
            if (length != null) {
                if (i >= length.length) {
                } else {
                    length = i + i2;
                    c(length);
                    int[] iArr2 = this.a;
                    System.arraycopy(iArr2, i, iArr2, length, i4 -= i2);
                    Arrays.fill(this.a, i, length, -1);
                    l(i, i2);
                }
            }
        }

        void k(int i, int i2) {
            int[] length2;
            int i4;
            int length;
            int i3;
            length2 = this.a;
            if (length2 != null) {
                if (i >= length2.length) {
                } else {
                    int i5 = i + i2;
                    c(i5);
                    int[] iArr = this.a;
                    System.arraycopy(iArr, i5, iArr, i, i6 -= i2);
                    length2 = this.a;
                    Arrays.fill(length2, length3 -= i2, length2.length, -1);
                    m(i, i2);
                }
            }
        }

        void n(int i, androidx.recyclerview.widget.StaggeredGridLayoutManager.f staggeredGridLayoutManager$f2) {
            c(i);
            this.a[i] = f2.e;
        }

        int o(int i) {
            int length;
            length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    public static class e implements Parcelable {

        public static final Parcelable.Creator<androidx.recyclerview.widget.StaggeredGridLayoutManager.e> CREATOR;
        boolean A;
        boolean B;
        int a;
        int b;
        int c;
        int[] v;
        int w;
        int[] x;
        List<androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a> y;
        boolean z;
        static {
            StaggeredGridLayoutManager.e.a aVar = new StaggeredGridLayoutManager.e.a();
            StaggeredGridLayoutManager.e.CREATOR = aVar;
        }

        e(Parcel parcel) {
            int iArr2;
            int iArr;
            int i;
            int i3;
            int i2;
            super();
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            iArr2 = parcel.readInt();
            this.c = iArr2;
            if (iArr2 > 0) {
                iArr2 = new int[iArr2];
                this.v = iArr2;
                parcel.readIntArray(iArr2);
            }
            iArr = parcel.readInt();
            this.w = iArr;
            if (iArr > 0) {
                iArr = new int[iArr];
                this.x = iArr;
                parcel.readIntArray(iArr);
            }
            i2 = 0;
            final int i4 = 1;
            i = parcel.readInt() == i4 ? i4 : i2;
            this.z = i;
            i3 = parcel.readInt() == i4 ? i4 : i2;
            this.A = i3;
            i2 = parcel.readInt() == i4 ? i4 : i2;
            this.B = i2;
            this.y = parcel.readArrayList(StaggeredGridLayoutManager.d.a.class.getClassLoader());
        }

        public e(androidx.recyclerview.widget.StaggeredGridLayoutManager.e staggeredGridLayoutManager$e) {
            super();
            this.c = e.c;
            this.a = e.a;
            this.b = e.b;
            this.v = e.v;
            this.w = e.w;
            this.x = e.x;
            this.z = e.z;
            this.A = e.A;
            this.B = e.B;
            this.y = e.y;
        }

        @Override // android.os.Parcelable
        void a() {
            this.v = 0;
            this.c = 0;
            int i3 = -1;
            this.a = i3;
            this.b = i3;
        }

        @Override // android.os.Parcelable
        void b() {
            final int i = 0;
            this.v = i;
            final int i2 = 0;
            this.c = i2;
            this.w = i2;
            this.x = i;
            this.y = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            int obj2;
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.v);
            }
            parcel.writeInt(this.w);
            if (this.w > 0) {
                parcel.writeIntArray(this.x);
            }
            parcel.writeInt(this.z);
            parcel.writeInt(this.A);
            parcel.writeInt(this.B);
            parcel.writeList(this.y);
        }
    }

    class f {

        ArrayList<View> a;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;
        final androidx.recyclerview.widget.StaggeredGridLayoutManager f;
        f(androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager, int i2) {
            this.f = staggeredGridLayoutManager;
            super();
            ArrayList obj1 = new ArrayList();
            this.a = obj1;
            obj1 = Integer.MIN_VALUE;
            obj1 = 0;
            this.e = i2;
        }

        void A(int i) {
            this.b = i;
            this.c = i;
        }

        void a(View view) {
            boolean cVar;
            boolean z;
            View obj5;
            cVar = s(view);
            cVar.w = this;
            this.a.add(view);
            int i2 = Integer.MIN_VALUE;
            this.c = i2;
            if (this.a.size() == 1) {
                this.b = i2;
            }
            if (!cVar.c()) {
                if (cVar.b()) {
                    this.d = i += obj5;
                }
            } else {
            }
        }

        void b(boolean z, int i2) {
            int i;
            int i3;
            int obj4;
            final int i4 = Integer.MIN_VALUE;
            if (z != 0) {
                i = q(i4);
            } else {
                i = u(i4);
            }
            e();
            if (i == i4) {
            }
            if (z != 0) {
                if (i >= staggeredGridLayoutManager.u.i() && z == 0 && i > obj4.u.m()) {
                    if (z == 0) {
                        if (i > obj4.u.m()) {
                        }
                    }
                }
            } else {
            }
            if (i2 != i4) {
                i += i2;
            }
            this.c = i;
            this.b = i;
        }

        void c() {
            boolean z;
            androidx.recyclerview.widget.StaggeredGridLayoutManager.c cVar;
            int i;
            ArrayList list = this.a;
            i = 1;
            Object obj = list.get(size -= i);
            cVar = s((View)obj);
            this.c = staggeredGridLayoutManager2.u.d(obj);
            z = staggeredGridLayoutManager.E.f(cVar.a());
            if (cVar.x && z != null && z.b == i) {
                z = staggeredGridLayoutManager.E.f(cVar.a());
                if (z != null) {
                    if (z.b == i) {
                        this.c = i4 += z;
                    }
                }
            }
        }

        void d() {
            boolean z;
            androidx.recyclerview.widget.StaggeredGridLayoutManager.c cVar;
            androidx.recyclerview.widget.t tVar;
            Object obj = this.a.get(0);
            cVar = s((View)obj);
            this.b = staggeredGridLayoutManager2.u.g(obj);
            z = staggeredGridLayoutManager.E.f(cVar.a());
            if (cVar.x && z != null && z.b == -1) {
                z = staggeredGridLayoutManager.E.f(cVar.a());
                if (z != null) {
                    if (z.b == -1) {
                        this.b = i3 -= z;
                    }
                }
            }
        }

        void e() {
            this.a.clear();
            v();
            this.d = 0;
        }

        public int f() {
            int i;
            int size;
            final int i4 = 1;
            if (staggeredGridLayoutManager.z) {
                i = n(size2 -= i4, -1, i4);
            } else {
                i = n(0, this.a.size(), i4);
            }
            return i;
        }

        public int g() {
            int i;
            int size;
            final int i4 = 1;
            if (staggeredGridLayoutManager.z) {
                i = m(size2 -= i4, -1, i4);
            } else {
                i = m(0, this.a.size(), i4);
            }
            return i;
        }

        public int h() {
            int i;
            int i2;
            final int i4 = 0;
            if (staggeredGridLayoutManager.z) {
                i = n(size--, -1, i4);
            } else {
                i = n(i4, this.a.size(), i4);
            }
            return i;
        }

        public int i() {
            int i;
            int size;
            final int i4 = 1;
            if (staggeredGridLayoutManager.z) {
                i = n(0, this.a.size(), i4);
            } else {
                i = n(size2 -= i4, -1, i4);
            }
            return i;
        }

        public int j() {
            int i;
            int size;
            final int i4 = 1;
            if (staggeredGridLayoutManager.z) {
                i = m(0, this.a.size(), i4);
            } else {
                i = m(size2 -= i4, -1, i4);
            }
            return i;
        }

        public int k() {
            int i;
            int i2;
            final int i4 = 0;
            if (staggeredGridLayoutManager.z) {
                i = n(i4, this.a.size(), i4);
            } else {
                i = n(size2--, -1, i4);
            }
            return i;
        }

        int l(int i, int i2, boolean z3, boolean z4, boolean z5) {
            int i6;
            Object obj;
            int i4;
            int i5;
            int i7;
            int i3;
            int obj11;
            int i8 = staggeredGridLayoutManager.u.m();
            int i9 = staggeredGridLayoutManager2.u.i();
            final int i10 = -1;
            final int i11 = 1;
            i6 = i2 > i ? i11 : i10;
            while (obj11 != i2) {
                obj = this.a.get(obj11);
                i4 = staggeredGridLayoutManager3.u.g((View)obj);
                i5 = staggeredGridLayoutManager4.u.d(obj);
                if (z5) {
                } else {
                }
                if (i4 < i9) {
                } else {
                }
                i3 = i7;
                if (z5) {
                } else {
                }
                if (i5 > i8) {
                }
                obj11 += i6;
                i7 = i11;
                if (i5 >= i8) {
                }
                i3 = i11;
                if (i4 <= i9) {
                } else {
                }
            }
            return i10;
        }

        int m(int i, int i2, boolean z3) {
            return this.l(i, i2, false, false, z3);
        }

        int n(int i, int i2, boolean z3) {
            return this.l(i, i2, z3, true, false);
        }

        public int o() {
            return this.d;
        }

        int p() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.c;
        }

        int q(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            c();
            return this.c;
        }

        public View r(int i, int i2) {
            int i3;
            int i4;
            Object focusable2;
            boolean focusable;
            boolean z;
            int obj7;
            i4 = 0;
            if (i2 == -1) {
                i3 = 0;
                while (i3 < this.a.size()) {
                    focusable2 = this.a.get(i3);
                    focusable = this.f;
                    focusable = this.f;
                    if (!focusable.z) {
                        break;
                    } else {
                    }
                    if ((View)focusable2.hasFocusable()) {
                        break;
                    }
                    i3++;
                    i4 = focusable2;
                    if (focusable.A0(focusable2) >= i) {
                        break;
                    } else {
                    }
                    if (focusable.A0(focusable2) > i) {
                        break;
                    }
                }
            } else {
                obj7--;
                while (obj7 >= 0) {
                    i3 = this.a.get(obj7);
                    focusable2 = this.f;
                    focusable2 = this.f;
                    if (!focusable2.z) {
                        break;
                    } else {
                    }
                    if ((View)i3.hasFocusable()) {
                        break;
                    }
                    obj7--;
                    i4 = i3;
                    if (focusable2.A0(i3) <= i) {
                        break;
                    } else {
                    }
                    if (focusable2.A0(i3) < i) {
                        break;
                    }
                }
            }
            return i4;
        }

        androidx.recyclerview.widget.StaggeredGridLayoutManager.c s(View view) {
            return (StaggeredGridLayoutManager.c)view.getLayoutParams();
        }

        int t() {
            int i = this.b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            d();
            return this.b;
        }

        int u(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.a.size() == 0) {
                return i;
            }
            d();
            return this.b;
        }

        void v() {
            final int i = Integer.MIN_VALUE;
            this.b = i;
            this.c = i;
        }

        void w(int i) {
            int i2;
            int i3;
            i2 = this.b;
            final int i4 = Integer.MIN_VALUE;
            if (i2 != i4) {
                this.b = i2 += i;
            }
            i3 = this.c;
            if (i3 != i4) {
                this.c = i3 += i;
            }
        }

        void x() {
            Object remove;
            boolean cVar;
            boolean z;
            int size = this.a.size();
            remove = this.a.remove(size + -1);
            cVar = s((View)remove);
            cVar.w = 0;
            if (!cVar.c()) {
                if (cVar.b()) {
                    this.d = i4 -= remove;
                }
            } else {
            }
            int i = Integer.MIN_VALUE;
            if (size == 1) {
                this.b = i;
            }
            this.c = i;
        }

        void y() {
            Object remove;
            boolean cVar;
            boolean z;
            remove = this.a.remove(0);
            cVar = s((View)remove);
            cVar.w = 0;
            final int i4 = Integer.MIN_VALUE;
            if (this.a.size() == 0) {
                this.c = i4;
            }
            if (!cVar.c()) {
                if (cVar.b()) {
                    this.d = i2 -= remove;
                }
            } else {
            }
            this.b = i4;
        }

        void z(View view) {
            boolean cVar;
            boolean z;
            View obj5;
            cVar = s(view);
            cVar.w = this;
            this.a.add(0, view);
            int i2 = Integer.MIN_VALUE;
            this.b = i2;
            if (this.a.size() == 1) {
                this.c = i2;
            }
            if (!cVar.c()) {
                if (cVar.b()) {
                    this.d = i += obj5;
                }
            } else {
            }
        }
    }

    public static class c extends androidx.recyclerview.widget.RecyclerView.q {

        androidx.recyclerview.widget.StaggeredGridLayoutManager.f w;
        boolean x;
        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
        }

        public c(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(marginLayoutParams);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public boolean e() {
            return this.x;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$q
        public void f(boolean z) {
            this.x = z;
        }
    }
    public StaggeredGridLayoutManager(int i, int i2) {
        super();
        int i3 = -1;
        final int i7 = 0;
        int i4 = Integer.MIN_VALUE;
        StaggeredGridLayoutManager.d dVar = new StaggeredGridLayoutManager.d();
        this.E = dVar;
        int i5 = 2;
        Rect rect = new Rect();
        this.K = rect;
        StaggeredGridLayoutManager.b bVar = new StaggeredGridLayoutManager.b(this);
        this.L = bVar;
        int i6 = 1;
        StaggeredGridLayoutManager.a aVar = new StaggeredGridLayoutManager.a(this);
        this.P = aVar;
        this.w = i2;
        l3(i);
        o obj3 = new o();
        this.y = obj3;
        w2();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super();
        int i = -1;
        final int i7 = 0;
        int i2 = Integer.MIN_VALUE;
        StaggeredGridLayoutManager.d dVar = new StaggeredGridLayoutManager.d();
        this.E = dVar;
        int i5 = 2;
        Rect rect = new Rect();
        this.K = rect;
        StaggeredGridLayoutManager.b bVar = new StaggeredGridLayoutManager.b(this);
        this.L = bVar;
        int i6 = 1;
        StaggeredGridLayoutManager.a aVar = new StaggeredGridLayoutManager.a(this);
        this.P = aVar;
        androidx.recyclerview.widget.RecyclerView.p.d obj3 = RecyclerView.p.B0(context, attributeSet2, i3, i4);
        j3(obj3.a);
        l3(obj3.b);
        k3(obj3.c);
        obj3 = new o();
        this.y = obj3;
        w2();
    }

    private int F2(int i) {
        int i3;
        int i2;
        i4--;
        while (i3 >= 0) {
            i2 = A0(f0(i3));
            i3--;
        }
        return 0;
    }

    private void H2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, boolean z3) {
        int i2;
        int i;
        androidx.recyclerview.widget.RecyclerView.w obj3;
        int i3 = Integer.MIN_VALUE;
        i = L2(i3);
        if (i == i3) {
        }
        i4 -= i;
        i2 -= obj3;
        if (i2 > 0 && z3 && i2 > 0) {
            i2 -= obj3;
            if (z3) {
                if (i2 > 0) {
                    this.u.r(i2);
                }
            }
        }
    }

    private void I2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, boolean z3) {
        int i;
        androidx.recyclerview.widget.RecyclerView.w obj3;
        androidx.recyclerview.widget.RecyclerView.b0 obj4;
        int i2 = Integer.MAX_VALUE;
        int i4 = O2(i2);
        if (i4 == i2) {
        }
        i4 -= i3;
        i -= obj3;
        if (i > 0 && z3 && i > 0) {
            i -= obj3;
            if (z3) {
                if (i > 0) {
                    this.u.r(-i);
                }
            }
        }
    }

    private int L2(int i) {
        int i3;
        int i4;
        int i2;
        i3 = this.t[0].q(i);
        i4 = 1;
        while (i4 < this.s) {
            i2 = this.t[i4].q(i);
            if (i2 > i3) {
            }
            i4++;
            i3 = i2;
        }
        return i3;
    }

    private int M2(int i) {
        int i4;
        int i2;
        int i3;
        i4 = this.t[0].u(i);
        i2 = 1;
        while (i2 < this.s) {
            i3 = this.t[i2].u(i);
            if (i3 > i4) {
            }
            i2++;
            i4 = i3;
        }
        return i4;
    }

    private int N2(int i) {
        int i3;
        int i4;
        int i2;
        i3 = this.t[0].q(i);
        i4 = 1;
        while (i4 < this.s) {
            i2 = this.t[i4].q(i);
            if (i2 < i3) {
            }
            i4++;
            i3 = i2;
        }
        return i3;
    }

    private int O2(int i) {
        int i2;
        int i3;
        int i4;
        i2 = this.t[0].u(i);
        i3 = 1;
        while (i3 < this.s) {
            i4 = this.t[i3].u(i);
            if (i4 < i2) {
            }
            i3++;
            i2 = i4;
        }
        return i2;
    }

    private androidx.recyclerview.widget.StaggeredGridLayoutManager.f P2(androidx.recyclerview.widget.o o) {
        int i2;
        int i;
        int i4;
        int i5;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar;
        int i3;
        int obj8;
        int i8 = 1;
        if (Z2(o.e)) {
            i7 -= i8;
            i4 = i;
        } else {
            i2 = 0;
            i = this.s;
            i4 = i8;
        }
        i5 = 0;
        if (o.e == i8) {
            obj8 = Integer.MAX_VALUE;
            while (i2 != i) {
                fVar = this.t[i2];
                i3 = fVar.q(this.u.m());
                if (i3 < obj8) {
                }
                i2 += i4;
                i5 = fVar;
                obj8 = i3;
            }
            return i5;
        }
        obj8 = Integer.MIN_VALUE;
        while (i2 != i) {
            fVar = this.t[i2];
            i3 = fVar.u(this.u.i());
            if (i3 > obj8) {
            }
            i2 += i4;
            i5 = fVar;
            obj8 = i3;
        }
        return i5;
    }

    private void S2(int i, int i2, int i3) {
        int i5;
        int i6;
        int i4;
        int i7;
        int obj7;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.d obj9;
        if (this.A) {
            i5 = K2();
        } else {
            i5 = J2();
        }
        final int i8 = 8;
        if (i3 == i8) {
            if (i < i2) {
                i6 = i2 + 1;
                i4 = i;
            } else {
                i6 = i + 1;
                i4 = i2;
            }
        } else {
            i6 = i + i2;
        }
        this.E.h(i4);
        int i9 = 1;
        if (i3 != i9) {
            if (i3 != 2) {
                if (i3 != i8) {
                } else {
                    this.E.k(i, i9);
                    this.E.j(i2, i9);
                }
            } else {
                this.E.k(i, i2);
            }
        } else {
            this.E.j(i, i2);
        }
        if (i6 <= i5) {
        }
        if (this.A) {
            obj7 = J2();
        } else {
            obj7 = K2();
        }
        if (i4 <= obj7) {
            O1();
        }
    }

    private void W2(View view, int i2, int i3, boolean z4) {
        boolean obj8;
        G(view, this.K);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Rect rect2 = this.K;
        final int obj6 = t3(i2, leftMargin += left, rightMargin += right);
        Rect rect3 = this.K;
        final int obj7 = t3(i3, topMargin += top, bottomMargin += bottom);
        if (z4) {
            obj8 = d2(view, obj6, obj7, (StaggeredGridLayoutManager.c)layoutParams);
        } else {
            obj8 = b2(view, obj6, obj7, layoutParams);
        }
        if (obj8 != null) {
            view.measure(obj6, obj7);
        }
    }

    private void X2(View view, androidx.recyclerview.widget.StaggeredGridLayoutManager.c staggeredGridLayoutManager$c2, boolean z3) {
        int i4;
        int i3;
        int i;
        int i2;
        int i5;
        int width;
        int obj8;
        i3 = 1;
        if (c2.x) {
            if (this.w == i3) {
                W2(view, this.J, RecyclerView.p.h0(t0(), u0(), i14 += width, c2.height, i3), z3);
            } else {
                W2(view, RecyclerView.p.h0(H0(), I0(), i11 += i5, c2.width, i3), this.J, z3);
            }
        } else {
            i = 0;
            if (this.w == i3) {
                W2(view, RecyclerView.p.h0(this.x, I0(), i, c2.width, i), RecyclerView.p.h0(t0(), u0(), i16 += width, c2.height, i3), z3);
            } else {
                W2(view, RecyclerView.p.h0(H0(), I0(), i15 += i17, c2.width, i3), RecyclerView.p.h0(this.x, u0(), i, c2.height, i), z3);
            }
        }
    }

    private void Y2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, boolean z3) {
        int eVar;
        int i2;
        int i4;
        androidx.recyclerview.widget.o oVar;
        int i;
        boolean z2;
        int i8;
        int i6;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.e eVar3;
        boolean eVar2;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.e i3;
        boolean z;
        int i7;
        boolean z4;
        int i5;
        boolean obj11;
        final androidx.recyclerview.widget.StaggeredGridLayoutManager.b bVar = this.L;
        int i11 = -1;
        if (this.I == null) {
            if (this.C != i11 && b02.c() == 0) {
                if (b02.c() == 0) {
                    F1(w);
                    bVar.c();
                }
            }
        } else {
        }
        final int i14 = 0;
        i6 = 1;
        if (bVar.e && this.C == i11) {
            if (this.C == i11) {
                if (this.I != null) {
                    i2 = i6;
                } else {
                    i2 = i14;
                }
            } else {
            }
        } else {
        }
        if (i2 != 0) {
            bVar.c();
            if (this.I != null) {
                j2(bVar);
            } else {
                g3();
                bVar.c = this.A;
            }
            p3(b02, bVar);
            bVar.e = i6;
        }
        if (this.I == null && this.C == i11) {
            if (this.C == i11) {
                if (bVar.c == this.G) {
                    if (V2() != this.H) {
                        this.E.b();
                        bVar.d = i6;
                    }
                } else {
                }
            }
        }
        if (g0() > 0) {
            i3 = this.I;
            if (i3 != null) {
                if (i3.c < i6) {
                    if (bVar.d) {
                        i2 = i14;
                        while (i2 < this.s) {
                            this.t[i2].e();
                            z = bVar.b;
                            if (z != Integer.MIN_VALUE) {
                            }
                            i2++;
                            this.t[i2].A(z);
                        }
                    } else {
                        if (i2 == 0) {
                            if (bVar2.f == null) {
                                i4 = i14;
                                while (i4 < this.s) {
                                    this.t[i4].b(this.A, bVar.b);
                                    i4++;
                                }
                                this.L.d(this.t);
                            } else {
                                i2 = i14;
                                while (i2 < this.s) {
                                    z = this.t[i2];
                                    z.e();
                                    z.A(bVar3.f[i2]);
                                    i2++;
                                }
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
        }
        T(w);
        oVar2.a = i14;
        this.M = i14;
        r3(this.v.n());
        q3(bVar.a, b02);
        if (bVar.c) {
            i3(i11);
            x2(w, this.y, b02);
            i3(i6);
            oVar = this.y;
            oVar.c = i13 += i7;
            x2(w, oVar, b02);
        } else {
            i3(i6);
            x2(w, this.y, b02);
            i3(i11);
            oVar = this.y;
            oVar.c = i12 += i7;
            x2(w, oVar, b02);
        }
        f3();
        if (g0() > 0) {
            if (this.A) {
                H2(w, b02, i6);
                I2(w, b02, i14);
            } else {
                I2(w, b02, i6);
                H2(w, b02, i14);
            }
        }
        if (z3 && !b02.f()) {
            if (!b02.f()) {
                if (this.F != 0 && g0() > 0) {
                    if (g0() > 0) {
                        if (!this.M) {
                            obj11 = T2() != null ? i6 : i14;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                J1(this.P);
                if (obj11 != null && o2()) {
                    J1(this.P);
                    if (o2()) {
                    } else {
                        i6 = i14;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (b02.f()) {
            this.L.c();
        }
        this.G = bVar.c;
        this.H = V2();
        if (i6 != 0) {
            this.L.c();
            Y2(w, b02, i14);
        }
    }

    private boolean Z2(int i) {
        int i2;
        int obj5;
        final int i4 = -1;
        i2 = 1;
        final int i5 = 0;
        if (this.w == 0) {
            obj5 = i == i4 ? i2 : i5;
            if (obj5 != this.A) {
            } else {
                i2 = i5;
            }
            return i2;
        }
        obj5 = i == i4 ? i2 : i5;
        obj5 = obj5 == this.A ? i2 : i5;
        if (obj5 == V2()) {
        } else {
            i2 = i5;
        }
        return i2;
    }

    private void b3(View view) {
        int i;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar;
        i2--;
        while (i >= 0) {
            this.t[i].z(view);
            i--;
        }
    }

    private void c3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.o o2) {
        boolean z;
        int i;
        int obj4;
        if (o2.a) {
            if (o2.i) {
            } else {
                i = -1;
                if (o2.b == 0) {
                    if (o2.e == i) {
                        d3(w, o2.g);
                    } else {
                        e3(w, o2.f);
                    }
                } else {
                    if (o2.e == i) {
                        int i6 = o2.f;
                        i6 -= i;
                        if (z < 0) {
                            obj4 = o2.g;
                        } else {
                            obj4 = i - obj4;
                        }
                        d3(w, obj4);
                    } else {
                        i5 -= i;
                        if (z < 0) {
                            obj4 = o2.f;
                        } else {
                            obj4 += i;
                        }
                        e3(w, obj4);
                    }
                }
            }
        }
    }

    private void d3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, int i2) {
        int i3;
        View view;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar;
        int size;
        int i;
        int size2;
        final int i5 = 1;
        i4 -= i5;
        while (i3 >= 0) {
            view = f0(i3);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.w.x();
            H1(view, w);
            i3--;
            i = fVar;
            while (i < this.s) {
                i++;
            }
            while (fVar < this.s) {
                this.t[fVar].x();
                fVar++;
            }
            this.t[fVar].x();
            fVar++;
            i++;
        }
    }

    private void e3(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, int i2) {
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f i4;
        View view;
        ViewGroup.LayoutParams layoutParams;
        int i3;
        int i;
        boolean size;
        while (g0() > 0) {
            i4 = 0;
            view = f0(i4);
            layoutParams = view.getLayoutParams();
            final int i5 = 1;
            layoutParams.w.y();
            H1(view, w);
            i3 = i4;
            while (i3 < this.s) {
                i3++;
            }
            while (i4 < this.s) {
                this.t[i4].y();
                i4++;
            }
            this.t[i4].y();
            i4++;
            i3++;
        }
    }

    private void f3() {
        int i5;
        int round;
        int i;
        int i2;
        int i3;
        boolean z2;
        int layoutParams;
        float f;
        int i4;
        boolean z;
        int cmp;
        int i6;
        int i7;
        if (this.v.k() == 1073741824) {
        }
        i5 = 0;
        int i11 = g0();
        i3 = i2;
        while (i3 < i11) {
            z2 = f0(i3);
            f = (float)i19;
            if (Float.compare(f, i5) < 0) {
            } else {
            }
            if ((StaggeredGridLayoutManager.c)z2.getLayoutParams().e()) {
            }
            i5 = Math.max(i5, f);
            i3++;
            i20 /= z2;
        }
        int i12 = this.x;
        if (this.v.k() == Integer.MIN_VALUE) {
            round = Math.min(Math.round(i5 *= f2), this.v.n());
        }
        r3(round);
        if (this.x == i12) {
        }
        while (i2 < i11) {
            i = f0(i2);
            layoutParams = i.getLayoutParams();
            if (layoutParams.x) {
            } else {
            }
            cmp = 1;
            if (V2() && this.w == cmp) {
            } else {
            }
            int i16 = fVar.e;
            i21 *= i16;
            i16 *= i12;
            if (this.w == cmp) {
            } else {
            }
            i.offsetTopAndBottom(i22 -= layoutParams);
            i2++;
            i.offsetLeftAndRight(i22 -= layoutParams);
            if (this.w == cmp) {
            } else {
            }
            int i23 = this.s;
            int i17 = fVar2.e;
            i.offsetLeftAndRight(i28 -= layoutParams);
        }
    }

    private void g3() {
        int i;
        int i2;
        final int i3 = 1;
        if (this.w != i3) {
            if (!V2()) {
                this.A = this.z;
            } else {
                this.A = z ^= i3;
            }
        } else {
        }
    }

    private void i2(View view) {
        int i;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar;
        i2--;
        while (i >= 0) {
            this.t[i].a(view);
            i--;
        }
    }

    private void i3(int i) {
        int i2;
        int obj5;
        final androidx.recyclerview.widget.o oVar = this.y;
        oVar.e = i;
        final int i3 = -1;
        obj5 = i == i3 ? i2 : 0;
        if (this.A == obj5) {
        } else {
            i2 = i3;
        }
        oVar.d = i2;
    }

    private void j2(androidx.recyclerview.widget.StaggeredGridLayoutManager.b staggeredGridLayoutManager$b) {
        androidx.recyclerview.widget.StaggeredGridLayoutManager.e eVar2;
        Object eVar;
        int i2;
        boolean z;
        int i;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.e eVar3;
        int i3;
        int i4;
        int obj5;
        eVar2 = this.I;
        i2 = eVar2.c;
        if (i2 > 0) {
            if (i2 == this.s) {
                eVar2 = 0;
                while (eVar2 < this.s) {
                    this.t[eVar2].e();
                    eVar3 = this.I;
                    i3 = eVar3.v[eVar2];
                    if (i3 != Integer.MIN_VALUE) {
                    }
                    this.t[eVar2].A(i3);
                    eVar2++;
                    if (eVar3.A) {
                    } else {
                    }
                    eVar3 = this.u.m();
                    i3 += eVar3;
                    eVar3 = this.u.i();
                }
            } else {
                eVar2.b();
                eVar2 = this.I;
                eVar2.a = eVar2.b;
            }
        }
        androidx.recyclerview.widget.StaggeredGridLayoutManager.e eVar4 = this.I;
        this.H = eVar4.B;
        k3(eVar4.z);
        g3();
        eVar = this.I;
        int i5 = eVar.a;
        if (i5 != -1) {
            this.C = i5;
            b.c = eVar.A;
        } else {
            b.c = this.A;
        }
        if (eVar.w > 1) {
            obj5 = this.E;
            obj5.a = eVar.x;
            obj5.b = eVar.y;
        }
    }

    private void m2(View view, androidx.recyclerview.widget.StaggeredGridLayoutManager.c staggeredGridLayoutManager$c2, androidx.recyclerview.widget.o o3) {
        Object obj3;
        boolean obj4;
        if (o3.e == 1) {
            if (c2.x) {
                i2(view);
            } else {
                c2.w.a(view);
            }
        } else {
            if (c2.x) {
                b3(view);
            } else {
                c2.w.z(view);
            }
        }
    }

    private void m3(int i, int i2) {
        int i3;
        boolean empty;
        i3 = 0;
        while (i3 < this.s) {
            if (fVar.a.isEmpty()) {
            } else {
            }
            s3(this.t[i3], i, i2);
            i3++;
        }
    }

    private int n2(int i) {
        int i2;
        int obj4;
        i2 = -1;
        final int i5 = 1;
        if (g0() == 0 && this.A) {
            if (this.A) {
                i2 = i5;
            }
            return i2;
        }
        obj4 = i < J2() ? i5 : 0;
        if (obj4 != this.A) {
        } else {
            i2 = i5;
        }
        return i2;
    }

    private boolean n3(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.StaggeredGridLayoutManager.b staggeredGridLayoutManager$b2) {
        int obj2;
        if (this.G) {
            obj2 = F2(b0.c());
        } else {
            obj2 = z2(b0.c());
        }
        b2.a = obj2;
        b2.b = Integer.MIN_VALUE;
        return 1;
    }

    private boolean p2(androidx.recyclerview.widget.StaggeredGridLayoutManager.f staggeredGridLayoutManager$f) {
        int i2;
        int i;
        int i3 = 0;
        if (this.A) {
            if (f.p() < this.u.i()) {
                ArrayList list2 = f.a;
                return obj4 ^= 1;
            }
        } else {
            if (f.t() > this.u.m()) {
                return obj4 ^= 1;
            }
        }
        return i3;
    }

    private int q2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (g0() == 0) {
            return 0;
        }
        return w.a(b0, this.u, B2(z ^= 1), A2(z2 ^= 1), this, this.N);
    }

    private void q3(int i, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
        boolean z;
        androidx.recyclerview.widget.o oVar;
        int i2;
        int i3;
        int obj5;
        int obj6;
        androidx.recyclerview.widget.o oVar2 = this.y;
        i2 = 0;
        oVar2.b = i2;
        oVar2.c = i;
        final int i5 = 1;
        obj6 = b02.d();
        if (R0() && obj6 != -1) {
            obj6 = b02.d();
            if (obj6 != -1) {
                obj5 = obj6 < i ? i5 : i2;
                if (this.A == obj5) {
                    obj5 = this.u.n();
                    obj6 = i2;
                } else {
                    obj6 = obj5;
                    obj5 = i2;
                }
            } else {
                obj6 = obj5;
            }
        } else {
        }
        if (j0()) {
            oVar3.f = i7 -= obj6;
            obj6.g = i4 += obj5;
        } else {
            oVar.g = i6 += obj5;
            obj5.f = -obj6;
        }
        obj5 = this.y;
        obj5.h = i2;
        obj5.a = i5;
        if (this.u.k() == 0 && this.u.h() == 0) {
            if (this.u.h() == 0) {
                i2 = i5;
            }
        }
        obj5.i = i2;
    }

    private int r2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (g0() == 0) {
            return 0;
        }
        return w.b(b0, this.u, B2(z ^= 1), A2(z2 ^= 1), this, this.N, this.A);
    }

    private int s2(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        if (g0() == 0) {
            return 0;
        }
        return w.c(b0, this.u, B2(z ^= 1), A2(z2 ^= 1), this, this.N);
    }

    private void s3(androidx.recyclerview.widget.StaggeredGridLayoutManager.f staggeredGridLayoutManager$f, int i2, int i3) {
        Object obj4;
        int obj5;
        final int i = f.o();
        final int i4 = 0;
        if (i2 == -1) {
            if (obj5 += i <= i3) {
                this.B.set(f.e, i4);
            }
        } else {
            if (obj5 -= i >= i3) {
                this.B.set(f.e, i4);
            }
        }
    }

    private int t2(int i) {
        int i3;
        int i2;
        i3 = -1;
        i2 = 1;
        final int i9 = Integer.MIN_VALUE;
        if (i != i2 && i != 2 && i != 17 && i != 33 && i != 66 && i != 130) {
            if (i != 2) {
                i9 = Integer.MIN_VALUE;
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                                return i9;
                            }
                            if (this.w == i2) {
                            } else {
                                i2 = i9;
                            }
                            return i2;
                        }
                        if (this.w == 0) {
                        } else {
                            i2 = i9;
                        }
                        return i2;
                    }
                    if (this.w == i2) {
                    } else {
                        i3 = i9;
                    }
                    return i3;
                }
                if (this.w == 0) {
                } else {
                    i3 = i9;
                }
                return i3;
            }
            if (this.w == i2) {
                return i2;
            }
            if (V2()) {
                return i3;
            }
            return i2;
        }
        if (this.w == i2) {
            return i3;
        }
        if (V2()) {
            return i2;
        }
        return i3;
    }

    private int t3(int i, int i2, int i3) {
        int i4;
        if (i2 == 0 && i3 == 0) {
            if (i3 == 0) {
                return i;
            }
        }
        final int mode = View.MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE && mode == 1073741824) {
            if (mode == 1073741824) {
            }
            return i;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, obj3 -= i3), mode);
    }

    private androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a u2(int i) {
        int i2;
        int[] iArr;
        int i3;
        StaggeredGridLayoutManager.d.a aVar = new StaggeredGridLayoutManager.d.a();
        aVar.c = new int[this.s];
        i2 = 0;
        while (i2 < this.s) {
            aVar.c[i2] = i - i6;
            i2++;
        }
        return aVar;
    }

    private androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a v2(int i) {
        int i2;
        int[] iArr;
        int i3;
        StaggeredGridLayoutManager.d.a aVar = new StaggeredGridLayoutManager.d.a();
        aVar.c = new int[this.s];
        i2 = 0;
        while (i2 < this.s) {
            aVar.c[i2] = i6 -= i;
            i2++;
        }
        return aVar;
    }

    private void w2() {
        this.u = t.b(this, this.w);
        this.v = t.b(this, i2 - 1);
    }

    private int x2(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.o o2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        int i3;
        int i9;
        int i15;
        int i19;
        int i6;
        int i21;
        Object obj;
        int i5;
        BitSet focusable;
        boolean z3;
        int i8;
        boolean empty;
        int i16;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar2;
        int i10;
        boolean z2;
        boolean z;
        int i20;
        int i2;
        int i17;
        int i22;
        int i18;
        int i;
        int i13;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.d dVar;
        int i12;
        int i4;
        int i11;
        int i7;
        int i14;
        View view;
        ViewGroup.LayoutParams view2;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar;
        final Object obj2 = this;
        final androidx.recyclerview.widget.RecyclerView.w view3 = w;
        final Object obj3 = o2;
        i11 = 0;
        final int i52 = 1;
        obj2.B.set(i11, obj2.s, i52);
        if (oVar.i) {
            i3 = obj3.e == i52 ? 0x7fffffff /* Unknown resource */ : -2147483648;
        } else {
            if (obj3.e == i52) {
                i25 += i8;
            } else {
                i24 -= i8;
            }
        }
        final int i53 = i3;
        obj2.m3(obj3.e, i53);
        if (obj2.A) {
            i9 = obj2.u.i();
        } else {
            i9 = obj2.u.m();
        }
        final int i54 = i9;
        i15 = i11;
        i17 = -1;
        while (o2.a(b03)) {
            if (!oVar7.i) {
            } else {
            }
            view = obj3.b(view3);
            view2 = layoutParams;
            i6 = (StaggeredGridLayoutManager.c)view2.a();
            int i37 = obj2.E.g(i6);
            if (i37 == i17) {
            } else {
            }
            i18 = i11;
            if (i18 != 0) {
            } else {
            }
            fVar2 = obj2.t[i37];
            fVar = fVar2;
            view2.w = fVar;
            if (obj3.e == i52) {
            } else {
            }
            obj2.B(view, i11);
            obj2.X2(view, view2, i11);
            if (obj3.e == i52) {
            } else {
            }
            if (view2.x) {
            } else {
            }
            i10 = fVar.u(i54);
            i12 = i10 - i49;
            if (i18 != 0 && view2.x) {
            }
            i4 = i10;
            if (view2.x && obj3.d == i17) {
            }
            obj2.m2(view, view2, obj3);
            if (V2() && obj2.w == i52) {
            } else {
            }
            if (view2.x) {
            } else {
            }
            i34 += z;
            i = i21;
            i14 = i20;
            if (obj2.w == i52) {
            } else {
            }
            this.T0(view, i12, i, i4, i14);
            if (view2.x) {
            } else {
            }
            obj2.s3(fVar, oVar5.e, i53);
            obj2.c3(view3, obj2.y);
            if (oVar4.h && view.hasFocusable()) {
            } else {
            }
            i22 = 0;
            i11 = i22;
            i15 = i52;
            i17 = -1;
            if (view.hasFocusable()) {
            } else {
            }
            if (view2.x) {
            } else {
            }
            obj2.B.set(fVar.e, false);
            obj2.B.clear();
            obj2.m3(oVar6.e, i53);
            this.T0(view, i, i12, i14, i4);
            i21 = obj2.v.m();
            if (obj2.w == i52) {
            } else {
            }
            if (view2.x) {
            } else {
            }
            i32 -= z;
            i14 = i21;
            i = i20;
            i21 = obj2.v.i();
            if (obj3.d == i17) {
            }
            if (i18 != 0) {
            } else {
            }
            if (obj3.e == i52) {
            } else {
            }
            z2 = l2();
            i6 = obj2.E.f(i6);
            if (z2 ^= i52 != 0 && i6 != null) {
            }
            i6 = obj2.E.f(i6);
            if (i6 != null) {
            }
            obj2.M = i52;
            i6.v = i52;
            z2 = k2();
            obj2.M = i52;
            if (view2.x) {
            }
            i4 = obj2.v2(i10);
            i4.b = i52;
            i4.a = i6;
            obj2.E.a(i4);
            i10 = obj2.O2(i54);
            if (view2.x) {
            } else {
            }
            i10 = fVar.q(i54);
            if (i18 != 0 && view2.x) {
            }
            i4 = i51;
            i12 = i10;
            if (view2.x) {
            }
            i4 = obj2.u2(i10);
            i4.b = i17;
            i4.a = i6;
            obj2.E.a(i4);
            i10 = obj2.L2(i54);
            obj2.A(view);
            if (view2.x) {
            } else {
            }
            fVar2 = obj2.P2(obj3);
            obj2.E.n(i6, fVar2);
            fVar2 = obj2.t[i11];
            i18 = i52;
            if (!obj2.B.isEmpty()) {
            }
        }
        if (i15 == 0) {
            obj2.c3(view3, obj2.y);
        }
        if (oVar2.e == i17) {
            i36 -= i19;
        } else {
            i16 = i19 - i35;
        }
        if (i16 > 0) {
            i7 = Math.min(obj3.b, i16);
        } else {
            i7 = i48;
        }
        return i7;
    }

    private int z2(int i) {
        int i2;
        int i3;
        final int i5 = 0;
        i2 = i5;
        while (i2 < g0()) {
            i3 = A0(f0(i2));
            i2++;
        }
        return i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    View A2(boolean z) {
        int i2;
        int i;
        View view;
        int i3;
        int i4;
        int i6 = this.u.i();
        i7--;
        i = 0;
        while (i2 >= 0) {
            view = f0(i2);
            i4 = this.u.d(view);
            i2--;
            if (i == 0) {
            }
            i = view;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    View B2(boolean z) {
        int i;
        int i3;
        View view;
        int i4;
        int i2;
        int i5 = this.u.m();
        i = 0;
        i3 = 0;
        while (i3 < g0()) {
            view = f0(i3);
            i4 = this.u.g(view);
            i3++;
            if (i == 0) {
            }
            i = view;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    int C2() {
        View view;
        int i;
        final int i2 = 1;
        if (this.A) {
            view = A2(i2);
        } else {
            view = B2(i2);
        }
        if (view == null) {
            i = -1;
        } else {
            i = A0(view);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void D(String string) {
        if (this.I == null) {
            super.D(string);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int[] D2(int[] iArr) {
        int length;
        int i;
        int i2;
        int[] obj4;
        if (iArr == null) {
            obj4 = new int[this.s];
            i = 0;
            while (i < this.s) {
                obj4[i] = this.t[i].h();
                i++;
            }
            return obj4;
        } else {
            if (iArr.length < this.s) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
        stringBuilder.append(this.s);
        stringBuilder.append(", array size:");
        stringBuilder.append(iArr.length);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int[] E2(int[] iArr) {
        int length;
        int i2;
        int i;
        int[] obj4;
        if (iArr == null) {
            obj4 = new int[this.s];
            i2 = 0;
            while (i2 < this.s) {
                obj4[i2] = this.t[i2].i();
                i2++;
            }
            return obj4;
        } else {
            if (iArr.length < this.s) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
        stringBuilder.append(this.s);
        stringBuilder.append(", array size:");
        stringBuilder.append(iArr.length);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int[] G2(int[] iArr) {
        int length;
        int i;
        int i2;
        int[] obj4;
        if (iArr == null) {
            obj4 = new int[this.s];
            i = 0;
            while (i < this.s) {
                obj4[i] = this.t[i].k();
                i++;
            }
            return obj4;
        } else {
            if (iArr.length < this.s) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
        stringBuilder.append(this.s);
        stringBuilder.append(", array size:");
        stringBuilder.append(iArr.length);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean H() {
        int i;
        i = this.w == 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean I() {
        int i;
        if (this.w == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean J(androidx.recyclerview.widget.RecyclerView.q recyclerView$q) {
        return q instanceof StaggeredGridLayoutManager.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    int J2() {
        int i2;
        int i;
        if (g0() == 0) {
        } else {
            i = A0(f0(0));
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    int K2() {
        int i;
        int i2 = g0();
        if (i2 == 0) {
            i = 0;
        } else {
            i = A0(f0(i2--));
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void L(int i, int i2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03, androidx.recyclerview.widget.RecyclerView.p.c recyclerView$p$c4) {
        int i6;
        int i3;
        int i4;
        int i5;
        int i7;
        int obj5;
        int obj6;
        if (this.w == 0) {
        } else {
            obj5 = i2;
        }
        if (g0() != 0) {
            if (obj5 == null) {
            } else {
                a3(obj5, b03);
                obj5 = this.O;
                if (obj5 != null) {
                    if (obj5.length < this.s) {
                        this.O = new int[this.s];
                    }
                } else {
                }
                obj5 = 0;
                i6 = obj6;
                while (obj6 < this.s) {
                    androidx.recyclerview.widget.o oVar = this.y;
                    if (oVar.d == -1) {
                    } else {
                    }
                    i4 = this.t[obj6].q(oVar.g);
                    i5 = oVar2.g;
                    i4 -= i5;
                    if (i3 >= 0) {
                    }
                    obj6++;
                    this.O[i6] = i3;
                    i6++;
                    i5 = this.t[obj6].u(oVar.f);
                }
                Arrays.sort(this.O, obj5, i6);
                while (obj5 < i6) {
                    if (this.y.a(b03)) {
                    }
                    c4.a(obj6.c, this.O[obj5]);
                    obj6 = this.y;
                    obj6.c = i10 += i5;
                    obj5++;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public boolean L0() {
        int i;
        i = this.F != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int N(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return q2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int O(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return r2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int P(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return s2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int Q(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return q2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int Q2() {
        return this.w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int R(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return r2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int R1(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        return h3(i, w2, b03);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int R2() {
        return this.s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int S(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        return s2(b0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void S1(int i) {
        int i2;
        final androidx.recyclerview.widget.StaggeredGridLayoutManager.e eVar = this.I;
        if (eVar != null && eVar.a != i) {
            if (eVar.a != i) {
                eVar.a();
            }
        }
        this.C = i;
        this.D = Integer.MIN_VALUE;
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int T1(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        return h3(i, w2, b03);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    View T2() {
        int i3;
        int i;
        int i7;
        int i4;
        int i5;
        View view;
        ViewGroup.LayoutParams layoutParams;
        boolean z2;
        boolean z;
        int i8;
        int i2;
        int i6;
        final int i12 = 1;
        BitSet bitSet = new BitSet(this.s);
        final int i15 = 0;
        bitSet.set(i15, this.s, i12);
        i4 = -1;
        if (this.w == i12 && V2()) {
            i7 = V2() ? i12 : i4;
        } else {
        }
        if (this.A) {
            i5 = i4;
        } else {
            i5 = i10;
            i3 = i15;
        }
        if (i3 < i5) {
            i4 = i12;
        }
        while (i3 != i5) {
            view = f0(i3);
            layoutParams = view.getLayoutParams();
            z2 = i3 + i4;
            i3 += i4;
            z2 = f0(z2);
            i2 = this.u.g(view);
            i6 = this.u.g(z2);
            if (i2 == i6) {
            } else {
            }
            i8 = i15;
            if (i16 -= i19 < 0) {
            } else {
            }
            layoutParams = i15;
            if (i7 < 0) {
            } else {
            }
            z2 = i15;
            z2 = i12;
            layoutParams = i12;
            i8 = i12;
            i2 = this.u.d(view);
            i6 = this.u.d(z2);
            if (i2 == i6) {
            } else {
            }
            bitSet.clear(fVar4.e);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void U2() {
        this.E.b();
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    boolean V2() {
        int i;
        if (w0() == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void W0(int i) {
        int i2;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar;
        super.W0(i);
        i2 = 0;
        while (i2 < this.s) {
            this.t[i2].w(i);
            i2++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void X0(int i) {
        int i2;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar;
        super.X0(i);
        i2 = 0;
        while (i2 < this.s) {
            this.t[i2].w(i);
            i2++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void Y0(androidx.recyclerview.widget.RecyclerView.h recyclerView$h, androidx.recyclerview.widget.RecyclerView.h recyclerView$h2) {
        int obj1;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f obj2;
        this.E.b();
        obj1 = 0;
        while (obj1 < this.s) {
            this.t[obj1].e();
            obj1++;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void Y1(Rect rect, int i2, int i3) {
        int i;
        int i4;
        int obj5;
        int obj6;
        int obj7;
        i5 += i9;
        i10 += i12;
        if (this.w == 1) {
            obj5 = RecyclerView.p.K(i3, obj5 += i4, y0());
            obj6 = RecyclerView.p.K(i2, obj7 += i6, z0());
        } else {
            obj6 = RecyclerView.p.K(i2, obj5 += i6, z0());
            obj5 = RecyclerView.p.K(i3, obj5 += i4, y0());
        }
        X1(obj6, obj5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public androidx.recyclerview.widget.RecyclerView.q a0() {
        final int i2 = -2;
        final int i3 = -1;
        if (this.w == 0) {
            StaggeredGridLayoutManager.c cVar = new StaggeredGridLayoutManager.c(i2, i3);
            return cVar;
        }
        StaggeredGridLayoutManager.c cVar2 = new StaggeredGridLayoutManager.c(i3, i2);
        return cVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    void a3(int i, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
        int i3;
        int i2;
        int i4;
        int i5 = 1;
        if (i > 0) {
            i3 = K2();
            i2 = i5;
        } else {
            i2 = i8;
            i3 = i4;
        }
        oVar.a = i5;
        q3(i3, b02);
        i3(i2);
        final androidx.recyclerview.widget.o obj7 = this.y;
        obj7.c = i3 += i6;
        obj7.b = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public androidx.recyclerview.widget.RecyclerView.q b0(Context context, AttributeSet attributeSet2) {
        StaggeredGridLayoutManager.c cVar = new StaggeredGridLayoutManager.c(context, attributeSet2);
        return cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public androidx.recyclerview.widget.RecyclerView.q c0(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            StaggeredGridLayoutManager.c cVar = new StaggeredGridLayoutManager.c((ViewGroup.MarginLayoutParams)layoutParams);
            return cVar;
        }
        StaggeredGridLayoutManager.c cVar2 = new StaggeredGridLayoutManager.c(layoutParams);
        return cVar2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void c1(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2) {
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar;
        int obj3;
        super.c1(recyclerView, w2);
        J1(this.P);
        obj3 = 0;
        while (obj3 < this.s) {
            this.t[obj3].e();
            obj3++;
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public PointF d(int i) {
        float obj4;
        obj4 = n2(i);
        PointF pointF = new PointF();
        if (obj4 == null) {
            return null;
        }
        final int i3 = 0;
        if (this.w == 0) {
            pointF.x = (float)obj4;
            pointF.y = i3;
        } else {
            pointF.x = i3;
            pointF.y = (float)obj4;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public View d1(View view, int i2, androidx.recyclerview.widget.RecyclerView.w recyclerView$w3, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b04) {
        int i3;
        int i;
        int obj10;
        boolean obj11;
        androidx.recyclerview.widget.RecyclerView.b0 obj12;
        final int i6 = 0;
        if (g0() == 0) {
            return i6;
        }
        final View obj9 = Y(view);
        if (obj9 == null) {
            return i6;
        }
        g3();
        obj10 = t2(i2);
        if (obj10 == Integer.MIN_VALUE) {
            return i6;
        }
        ViewGroup.LayoutParams layoutParams = obj9.getLayoutParams();
        final boolean z = layoutParams.x;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar = layoutParams.w;
        final int i7 = 1;
        if (obj10 == i7) {
            i3 = K2();
        } else {
            i3 = J2();
        }
        q3(i3, b04);
        i3(obj10);
        androidx.recyclerview.widget.o oVar = this.y;
        oVar.c = i8 += i3;
        oVar.b = (int)i13;
        androidx.recyclerview.widget.o oVar2 = this.y;
        oVar2.h = i7;
        i = 0;
        oVar2.a = i;
        x2(w3, oVar2, b04);
        this.G = this.A;
        obj11 = fVar.r(i3, obj10);
        if (!z && obj11 != null && obj11 != obj9) {
            obj11 = fVar.r(i3, obj10);
            if (obj11 != null) {
                if (obj11 != obj9) {
                    return obj11;
                }
            }
        }
        if (Z2(obj10)) {
            obj11 -= i7;
            while (obj11 >= 0) {
                obj12 = this.t[obj11].r(i3, obj10);
                obj11--;
            }
        } else {
            obj11 = i;
            while (obj11 < this.s) {
                obj12 = this.t[obj11].r(i3, obj10);
                obj11++;
            }
        }
        obj12 = obj10 == -1 ? i7 : i;
        obj11 = obj11 ^= i7 == obj12 ? i7 : i;
        if (!z) {
            if (obj11 != null) {
                obj12 = fVar.g();
            } else {
                obj12 = fVar.j();
            }
            obj12 = Z(obj12);
            if (obj12 != null && obj12 != obj9) {
                if (obj12 != obj9) {
                    return obj12;
                }
            }
        }
        if (Z2(obj10)) {
            obj10 -= i7;
            while (obj10 >= 0) {
                if (obj11 != null) {
                } else {
                }
                obj12 = this.t[obj10].j();
                obj12 = Z(obj12);
                obj10--;
                obj12 = this.t[obj10].g();
            }
        }
        return i6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void e1(AccessibilityEvent accessibilityEvent) {
        int i;
        View view;
        super.e1(accessibilityEvent);
        int i2 = 0;
        view = B2(i2);
        i = A2(i2);
        if (g0() > 0 && view != null) {
            i2 = 0;
            view = B2(i2);
            i = A2(i2);
            if (view != null) {
                if (i == null) {
                } else {
                    view = A0(view);
                    i = A0(i);
                    if (view < i) {
                        accessibilityEvent.setFromIndex(view);
                        accessibilityEvent.setToIndex(i);
                    } else {
                        accessibilityEvent.setFromIndex(i);
                        accessibilityEvent.setToIndex(view);
                    }
                }
            }
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
        int i;
        i = this.I == null ? 1 : 0;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    int h3(int i, androidx.recyclerview.widget.RecyclerView.w recyclerView$w2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        int obj3;
        final int i5 = 0;
        if (g0() != 0) {
            if (i == 0) {
            } else {
                a3(i, b03);
                int obj5 = x2(w2, this.y, b03);
                if (oVar2.b < obj5) {
                } else {
                    obj3 = i < 0 ? -obj5 : obj5;
                }
            }
            this.u.r(-obj3);
            this.G = this.A;
            obj5 = this.y;
            obj5.b = i5;
            c3(w2, obj5);
            return obj3;
        }
        return i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void j3(int i) {
        int i2;
        if (i != 0) {
            if (i != 1) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("invalid orientation.");
            throw obj2;
        }
        D(0);
        if (i == this.w) {
        }
        this.w = i;
        this.u = this.v;
        this.v = this.u;
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    boolean k2() {
        int i;
        int i2;
        final int i4 = 0;
        final int i5 = Integer.MIN_VALUE;
        final int i6 = 1;
        i = i6;
        while (i < this.s) {
            i++;
        }
        return i6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void k3(boolean z) {
        boolean z2;
        D(0);
        androidx.recyclerview.widget.StaggeredGridLayoutManager.e eVar = this.I;
        if (eVar != null && eVar.z != z) {
            if (eVar.z != z) {
                eVar.z = z;
            }
        }
        this.z = z;
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void l1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        S2(i2, i3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    boolean l2() {
        int i2;
        int i;
        final int i4 = 0;
        final int i5 = Integer.MIN_VALUE;
        final int i6 = 1;
        i2 = i6;
        while (i2 < this.s) {
            i2++;
        }
        return i6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void l3(int i) {
        int i2;
        int i3;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.f fVar;
        int obj3;
        D(0);
        if (i != this.s) {
            U2();
            this.s = i;
            obj3 = new BitSet(this.s);
            this.B = obj3;
            this.t = new StaggeredGridLayoutManager.f[this.s];
            obj3 = 0;
            while (obj3 < this.s) {
                fVar = new StaggeredGridLayoutManager.f(this, obj3);
                this.t[obj3] = fVar;
                obj3++;
            }
            O1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void m1(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.E.b();
        O1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void n1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3, int i4) {
        S2(i2, i3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void o1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        S2(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    boolean o2() {
        int i2;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.d dVar;
        int i;
        int i3;
        int i4;
        View view;
        int i5;
        int i7 = 0;
        if (g0() != 0 && this.F != 0) {
            if (this.F != 0) {
                if (!K0()) {
                } else {
                    if (this.A) {
                        i2 = K2();
                        i4 = J2();
                    } else {
                        i2 = J2();
                        i4 = K2();
                    }
                    final int i10 = 1;
                    if (i2 == 0 && T2() != null) {
                        if (T2() != null) {
                            this.E.b();
                            P1();
                            O1();
                            return i10;
                        }
                    }
                    if (!this.M) {
                        return i7;
                    }
                    final int i12 = -1;
                    i5 = this.A ? i12 : i10;
                    i4 += i10;
                    androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a aVar2 = this.E.e(i2, i8, i5, i10);
                    if (aVar2 == null) {
                        this.M = i7;
                        this.E.d(i8);
                        return i7;
                    }
                    androidx.recyclerview.widget.StaggeredGridLayoutManager.d.a aVar = this.E.e(i2, aVar2.a, i5 *= i12, i10);
                    if (aVar == null) {
                        this.E.d(aVar2.a);
                    } else {
                        this.E.d(i6 += i10);
                    }
                }
                P1();
                O1();
                return i10;
            }
        }
        return i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    boolean o3(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.StaggeredGridLayoutManager.b staggeredGridLayoutManager$b2) {
        boolean z;
        int i5;
        int i3;
        int i;
        androidx.recyclerview.widget.t tVar;
        androidx.recyclerview.widget.t i2;
        int i6;
        int i4;
        int obj6;
        if (!b0.f()) {
            z = this.C;
            i2 = -1;
            if (z == i2) {
            } else {
                i6 = Integer.MIN_VALUE;
                if (z >= 0) {
                    if (z >= b0.c()) {
                    } else {
                        obj6 = this.I;
                        int i7 = 1;
                        if (obj6 != null && obj6.a != i2) {
                            if (obj6.a != i2) {
                                if (obj6.c < i7) {
                                    obj6 = Z(this.C);
                                    if (obj6 != null) {
                                        if (this.A) {
                                            i5 = K2();
                                        } else {
                                            i5 = J2();
                                        }
                                        b2.a = i5;
                                        if (this.D != i6) {
                                            if (b2.c) {
                                                b2.b = i16 -= obj6;
                                            } else {
                                                b2.b = i14 -= obj6;
                                            }
                                            return i7;
                                        }
                                        if (this.u.e(obj6) > this.u.n()) {
                                            if (b2.c) {
                                                obj6 = this.u.i();
                                            } else {
                                                obj6 = this.u.m();
                                            }
                                            b2.b = obj6;
                                            return i7;
                                        }
                                        i10 -= i18;
                                        if (i11 < 0) {
                                            b2.b = -i11;
                                            return i7;
                                        }
                                        i12 -= obj6;
                                        if (i < 0) {
                                            b2.b = i;
                                            return i7;
                                        }
                                        b2.b = i6;
                                    } else {
                                        obj6 = this.C;
                                        b2.a = obj6;
                                        i2 = this.D;
                                        if (i2 == i6) {
                                            if (n2(obj6) == i7) {
                                                i = i7;
                                            }
                                            b2.c = i;
                                            b2.a();
                                        } else {
                                            b2.b(i2);
                                        }
                                        b2.d = i7;
                                    }
                                } else {
                                    b2.b = i6;
                                    b2.a = this.C;
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                    return i7;
                }
                this.C = i2;
                this.D = i6;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    void p3(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0, androidx.recyclerview.widget.StaggeredGridLayoutManager.b staggeredGridLayoutManager$b2) {
        if (o3(b0, b2)) {
        }
        if (n3(b0, b2)) {
        }
        b2.a();
        b2.a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void q1(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3, Object object4) {
        S2(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void r1(androidx.recyclerview.widget.RecyclerView.w recyclerView$w, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02) {
        Y2(w, b02, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    void r3(int i) {
        this.x = i / i2;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void s1(androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b0) {
        super.s1(b0);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = 0;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void w1(Parcelable parcelable) {
        boolean i;
        int i2;
        Object obj3;
        this.I = (StaggeredGridLayoutManager.e)parcelable;
        if (parcelable instanceof StaggeredGridLayoutManager.e && this.C != -1) {
            this.I = (StaggeredGridLayoutManager.e)parcelable;
            if (this.C != -1) {
                parcelable.a();
                this.I.b();
            }
            O1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public Parcelable x1() {
        Object dVar;
        int i2;
        int i4;
        int[] iArr;
        int i3;
        int length;
        int i;
        if (this.I != null) {
            StaggeredGridLayoutManager.e eVar2 = new StaggeredGridLayoutManager.e(this.I);
            return eVar2;
        }
        StaggeredGridLayoutManager.e eVar3 = new StaggeredGridLayoutManager.e();
        eVar3.z = this.z;
        eVar3.A = this.G;
        eVar3.B = this.H;
        dVar = this.E;
        i3 = 0;
        length = dVar.a;
        if (dVar != null && length != null) {
            length = dVar.a;
            if (length != null) {
                eVar3.x = length;
                eVar3.w = length.length;
                eVar3.y = dVar.b;
            } else {
                eVar3.w = i3;
            }
        } else {
        }
        if (g0() > 0) {
            if (this.G) {
                i4 = K2();
            } else {
                i4 = J2();
            }
            eVar3.a = i4;
            eVar3.b = C2();
            int i7 = this.s;
            eVar3.c = i7;
            eVar3.v = new int[i7];
            while (i3 < this.s) {
                i = Integer.MIN_VALUE;
                if (this.G) {
                } else {
                }
                if (this.t[i3].u(i) != i) {
                }
                eVar3.v[i3] = iArr;
                i3++;
                i = this.u.m();
                iArr -= i;
                if (this.t[i3].q(i) != i) {
                }
                i = this.u.i();
            }
        } else {
            i2 = -1;
            eVar3.a = i2;
            eVar3.b = i2;
            eVar3.c = i3;
        }
        return eVar3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public void y1(int i) {
        if (i == 0) {
            o2();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$p
    public int[] y2(int[] iArr) {
        int length;
        int i;
        int i2;
        int[] obj4;
        if (iArr == null) {
            obj4 = new int[this.s];
            i = 0;
            while (i < this.s) {
                obj4[i] = this.t[i].f();
                i++;
            }
            return obj4;
        } else {
            if (iArr.length < this.s) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
        stringBuilder.append(this.s);
        stringBuilder.append(", array size:");
        stringBuilder.append(iArr.length);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }
}
