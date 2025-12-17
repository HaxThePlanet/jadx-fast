package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.core.os.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class k implements Runnable {

    static final java.lang.ThreadLocal<androidx.recyclerview.widget.k> w;
    static Comparator<androidx.recyclerview.widget.k.c> x;
    ArrayList<androidx.recyclerview.widget.RecyclerView> a;
    long b;
    long c;
    private ArrayList<androidx.recyclerview.widget.k.c> v;

    class a implements Comparator<androidx.recyclerview.widget.k.c> {
        @Override // java.util.Comparator
        public int a(androidx.recyclerview.widget.k.c k$c, androidx.recyclerview.widget.k.c k$c2) {
            int i2;
            int i;
            int i3;
            androidx.recyclerview.widget.RecyclerView view = c.d;
            final int i6 = 0;
            i2 = 1;
            i = view == null ? i2 : i6;
            i3 = c2.d == null ? i2 : i6;
            final int i8 = -1;
            if (i != i3) {
                if (view == null) {
                } else {
                    i2 = i8;
                }
                return i2;
            }
            boolean z = c.a;
            if (z != c2.a && z) {
                if (z) {
                    i2 = i8;
                }
                return i2;
            }
            i4 -= i7;
            if (i5 != 0) {
                return i5;
            }
            obj7 -= obj8;
            if (obj7 != null) {
                return obj7;
            }
            return i6;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((k.c)object, (k.c)object2);
        }
    }

    static class c {

        public boolean a;
        public int b;
        public int c;
        public androidx.recyclerview.widget.RecyclerView d;
        public int e;
        public void a() {
            final int i = 0;
            this.a = i;
            this.b = i;
            this.c = i;
            this.d = 0;
            this.e = i;
        }
    }

    static class b implements androidx.recyclerview.widget.RecyclerView.p.c {

        int a;
        int b;
        int[] c;
        int d;
        @Override // androidx.recyclerview.widget.RecyclerView$p$c
        public void a(int i, int i2) {
            int[] iArr;
            int iArr2;
            int length;
            int i3;
            if (i < 0) {
            } else {
                if (i2 < 0) {
                } else {
                    i4 *= 2;
                    iArr = this.c;
                    if (iArr == null) {
                        iArr = new int[4];
                        this.c = iArr;
                        Arrays.fill(iArr, -1);
                    } else {
                        if (i5 >= iArr.length) {
                            iArr2 = new int[i5 * 2];
                            this.c = iArr2;
                            i3 = 0;
                            System.arraycopy(iArr, i3, iArr2, i3, iArr.length);
                        }
                    }
                    int[] iArr3 = this.c;
                    iArr3[i5] = i;
                    iArr3[i5++] = i2;
                    this.d = obj6++;
                }
                IllegalArgumentException obj6 = new IllegalArgumentException("Pixel distance must be non-negative");
                throw obj6;
            }
            obj6 = new IllegalArgumentException("Layout positions must be non-negative");
            throw obj6;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$p$c
        void b() {
            int i;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$p$c
        void c(androidx.recyclerview.widget.RecyclerView recyclerView, boolean z2) {
            int i2;
            boolean itemCount;
            androidx.recyclerview.widget.RecyclerView.h view;
            int i;
            androidx.recyclerview.widget.RecyclerView.b0 view2;
            Object obj5;
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            androidx.recyclerview.widget.RecyclerView.p view3 = recyclerView.E;
            if (recyclerView.D != null && view3 != null && view3.N0()) {
                if (view3 != null) {
                    if (view3.N0()) {
                        if (z2) {
                            if (!recyclerView.v.p()) {
                                view3.M(recyclerView.D.getItemCount(), this);
                            }
                        } else {
                            if (!recyclerView.s0()) {
                                view3.L(this.a, this.b, recyclerView.A0, this);
                            }
                        }
                        view = this.d;
                        if (view > view3.m) {
                            view3.m = view;
                            view3.n = z2;
                            recyclerView.b.K();
                        }
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$p$c
        boolean d(int i) {
            int[] iArr;
            int i3;
            int i2;
            final int i5 = 0;
            if (this.c != null) {
                i3 = i5;
                while (i3 < i4 *= 2) {
                    i3 += 2;
                }
            }
            return i5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$p$c
        void e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        k.w = threadLocal;
        k.a aVar = new k.a();
        k.x = aVar;
    }

    k() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.v = arrayList2;
    }

    private void b() {
        int i4;
        int i8;
        int i;
        int i2;
        Object obj;
        int windowVisibility;
        int i5;
        int i3;
        int cVar;
        ArrayList list;
        int i6;
        int i7;
        int size = this.a.size();
        int i9 = 0;
        i = i4;
        while (i4 < size) {
            obj = this.a.get(i4);
            if ((RecyclerView)obj.getWindowVisibility() == 0) {
            }
            i4++;
            obj.z0.c(obj, i9);
            i += obj;
        }
        this.v.ensureCapacity(i);
        i2 = i8;
        while (i8 < size) {
            obj = this.a.get(i8);
            if ((RecyclerView)obj.getWindowVisibility() != 0) {
            } else {
            }
            windowVisibility = obj.z0;
            i11 += i13;
            i3 = i9;
            while (i3 < i14 *= 2) {
                if (i2 >= this.v.size()) {
                } else {
                }
                cVar = this.v.get(i2);
                int[] iArr = windowVisibility.c;
                i6 = iArr[i3 + 1];
                if (i6 <= i5) {
                } else {
                }
                i7 = i9;
                cVar.a = i7;
                cVar.b = i5;
                cVar.c = i6;
                cVar.d = obj;
                cVar.e = iArr[i3];
                i2++;
                i3 += 2;
                i7 = 1;
                cVar = new k.c();
                this.v.add(cVar);
            }
            i8++;
            if (i2 >= this.v.size()) {
            } else {
            }
            cVar = this.v.get(i2);
            iArr = windowVisibility.c;
            i6 = iArr[i3 + 1];
            if (i6 <= i5) {
            } else {
            }
            i7 = i9;
            cVar.a = i7;
            cVar.b = i5;
            cVar.c = i6;
            cVar.d = obj;
            cVar.e = iArr[i3];
            i2++;
            i3 += 2;
            i7 = 1;
            cVar = new k.c();
            this.v.add(cVar);
        }
        Collections.sort(this.v, k.x);
    }

    private void c(androidx.recyclerview.widget.k.c k$c, long l2) {
        long mNestedRecyclerView;
        Object obj4;
        mNestedRecyclerView = c.a ? 9223372036854775807L : l2;
        obj4 = i(c.d, c.e, mNestedRecyclerView);
        if (obj4 != null && obj4.mNestedRecyclerView != null && obj4.isBound() && !obj4.isInvalid()) {
            if (obj4.mNestedRecyclerView != null) {
                if (obj4.isBound()) {
                    if (!obj4.isInvalid()) {
                        h((RecyclerView)obj4.mNestedRecyclerView.get(), l2);
                    }
                }
            }
        }
    }

    private void d(long l) {
        int i;
        Object size;
        androidx.recyclerview.widget.RecyclerView view;
        i = 0;
        while (i < this.v.size()) {
            size = this.v.get(i);
            if (size.d == null) {
                break;
            } else {
            }
            c((k.c)size, l);
            size.a();
            i++;
        }
    }

    static boolean e(androidx.recyclerview.widget.RecyclerView recyclerView, int i2) {
        int i;
        androidx.recyclerview.widget.RecyclerView.e0 invalid;
        int mPosition;
        final int i4 = 0;
        i = i4;
        while (i < recyclerView.w.j()) {
            invalid = RecyclerView.k0(recyclerView.w.i(i));
            i++;
        }
        return i4;
    }

    private void h(androidx.recyclerview.widget.RecyclerView recyclerView, long l2) {
        boolean z;
        int i;
        int i2;
        androidx.recyclerview.widget.RecyclerView.h view;
        if (recyclerView == null) {
        }
        if (recyclerView.W && recyclerView.w.j() != 0) {
            if (recyclerView.w.j() != 0) {
                recyclerView.b1();
            }
        }
        androidx.recyclerview.widget.k.b bVar = recyclerView.z0;
        bVar.c(recyclerView, true);
        if (bVar.d != 0) {
            i.a("RV Nested Prefetch");
            recyclerView.A0.g(recyclerView.D);
            i = 0;
            while (i < i4 *= 2) {
                i(recyclerView, bVar.c[i], l2);
                i += 2;
            }
            i.b();
        }
    }

    private androidx.recyclerview.widget.RecyclerView.e0 i(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, long l3) {
        long obj5;
        if (k.e(recyclerView, i2)) {
            return null;
        }
        androidx.recyclerview.widget.RecyclerView.w view = recyclerView.b;
        final int i = 0;
        recyclerView.N0();
        final androidx.recyclerview.widget.RecyclerView.e0 obj4 = view.I(i2, i, l3);
        if (obj4 != null) {
            if (obj4.isBound() && !obj4.isInvalid()) {
                if (!obj4.isInvalid()) {
                    view.B(obj4.itemView);
                } else {
                    view.a(obj4, i);
                }
            } else {
            }
        }
        recyclerView.P0(i);
        return obj4;
    }

    @Override // java.lang.Runnable
    public void a(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.a.add(recyclerView);
    }

    @Override // java.lang.Runnable
    void f(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
        boolean attachedToWindow;
        int i;
        if (recyclerView.isAttachedToWindow() && Long.compare(l, i) == 0) {
            if (Long.compare(l, i) == 0) {
                this.b = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.z0.e(i2, i3);
    }

    @Override // java.lang.Runnable
    void g(long l) {
        b();
        d(l);
    }

    @Override // java.lang.Runnable
    public void j(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean empty;
        int i;
        int i2;
        Object drawingTime;
        int windowVisibility;
        final int i3 = 0;
        i.a("RV Prefetch");
        if (this.a.isEmpty()) {
            this.b = i3;
            i.b();
        } else {
            try {
                i = 0;
                i2 = i3;
                while (i < this.a.size()) {
                    drawingTime = this.a.get(i);
                    windowVisibility = (RecyclerView)drawingTime.getWindowVisibility();
                    if (windowVisibility == 0) {
                    }
                    i++;
                    i2 = Math.max(drawingTime.getDrawingTime(), windowVisibility);
                }
                drawingTime = this.a.get(i);
                windowVisibility = (RecyclerView)drawingTime.getWindowVisibility();
                if (windowVisibility == 0) {
                }
                i2 = Math.max(drawingTime.getDrawingTime(), windowVisibility);
                i++;
                g(nanos += l);
                this.b = i3;
                i.b();
                this.b = obj0;
                i.b();
                throw th;
            }
        }
    }
}
