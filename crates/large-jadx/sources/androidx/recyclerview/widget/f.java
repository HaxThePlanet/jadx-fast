package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class f {

    final androidx.recyclerview.widget.f.b a;
    final androidx.recyclerview.widget.f.a b;
    final List<View> c;

    static class a {

        long a = 0;
        androidx.recyclerview.widget.f.a b;
        a() {
            super();
            final int i = 0;
        }

        private void c() {
            androidx.recyclerview.widget.f.a aVar;
            if (this.b == null) {
                aVar = new f.a();
                this.b = aVar;
            }
        }

        void a(int i) {
            int i3;
            androidx.recyclerview.widget.f.a aVar;
            int i2;
            int obj5;
            i3 = 64;
            if (i >= i3) {
                aVar = this.b;
                if (aVar != null) {
                    aVar.a(i -= i3);
                }
            } else {
                this.a = l &= i2;
            }
        }

        int b(int i) {
            androidx.recyclerview.widget.f.a aVar = this.b;
            final int i4 = 64;
            final int i5 = 1;
            if (aVar == null && i >= i4) {
                if (i >= i4) {
                    return Long.bitCount(this.a);
                }
                return Long.bitCount(l &= i7);
            }
            if (i < i4) {
                return Long.bitCount(l3 &= i9);
            }
            return obj7 += bitCount;
        }

        boolean d(int i) {
            int obj5;
            int i2 = 64;
            if (i >= i2) {
                c();
                return this.b.d(i -= i2);
            }
            obj5 = Long.compare(i3, i6) != 0 ? 1 : 0;
            return obj5;
        }

        void e(int i, boolean z2) {
            int i2;
            androidx.recyclerview.widget.f.a aVar;
            int i6;
            int i3;
            int i7;
            int i5;
            int i4;
            androidx.recyclerview.widget.f.a obj10;
            i2 = 64;
            if (i >= i2) {
                c();
                this.b.e(i -= i2, z2);
            } else {
                long l = this.a;
                i3 = 1;
                i7 = 0;
                i6 = Long.compare(i10, i11) != 0 ? i3 : i7;
                int i12 = 1;
                i13 -= i12;
                this.a = i9 |= i5;
                if (z2) {
                    h(i);
                } else {
                    a(i);
                }
                if (i6 == 0) {
                    if (this.b != null) {
                        c();
                        this.b.e(i7, i6);
                    }
                } else {
                }
            }
        }

        boolean f(int i) {
            boolean z;
            androidx.recyclerview.widget.f.a aVar;
            int obj11;
            int i2 = 64;
            if (i >= i2) {
                c();
                return this.b.f(i -= i2);
            }
            int i3 = 1;
            int i6 = i3 << i;
            long l = this.a;
            int i12 = 1;
            final int i13 = 0;
            obj11 = Long.compare(i11, i14) != 0 ? i12 : i13;
            l &= i15;
            this.a = i10;
            i6 -= i3;
            this.a = i4 |= rotateRight;
            aVar = this.b;
            if (aVar != null && aVar.d(i13)) {
                if (aVar.d(i13)) {
                    h(63);
                }
                this.b.f(i13);
            }
            return obj11;
        }

        void g() {
            this.a = 0;
            androidx.recyclerview.widget.f.a aVar = this.b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i) {
            int i2;
            androidx.recyclerview.widget.f.a aVar;
            int i3;
            int obj5;
            i2 = 64;
            if (i >= i2) {
                c();
                this.b.h(i -= i2);
            } else {
                this.a = l |= i3;
            }
        }

        public String toString() {
            String binaryString2;
            long binaryString;
            if (this.b == null) {
                binaryString2 = Long.toBinaryString(this.a);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b.toString());
                stringBuilder.append("xx");
                stringBuilder.append(Long.toBinaryString(this.a));
                binaryString2 = stringBuilder.toString();
            }
            return binaryString2;
        }
    }

    interface b {
        public abstract View a(int i);

        public abstract void b(View view);

        public abstract void c();

        public abstract int d(View view);

        public abstract androidx.recyclerview.widget.RecyclerView.e0 e(View view);

        public abstract void f(int i);

        public abstract void g(View view);

        public abstract int getChildCount();

        public abstract void h(View view, int i2);

        public abstract void i(int i);

        public abstract void j(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3);
    }
    f(androidx.recyclerview.widget.f.b f$b) {
        super();
        this.a = b;
        f.a obj1 = new f.a();
        this.b = obj1;
        obj1 = new ArrayList();
        this.c = obj1;
    }

    private int h(int i) {
        int i2;
        int i3;
        int obj5;
        final int i4 = -1;
        if (i < 0) {
            return i4;
        }
        i2 = i;
        while (i2 < this.a.getChildCount()) {
            i3 = i - i6;
            if (i3 == 0) {
            } else {
            }
            i2 += i3;
        }
        return i4;
    }

    private void l(View view) {
        this.c.add(view);
        this.a.b(view);
    }

    private boolean t(View view) {
        if (this.c.remove(view)) {
            this.a.g(view);
            return 1;
        }
        return 0;
    }

    void a(View view, int i2, boolean z3) {
        int obj3;
        if (i2 < 0) {
            obj3 = this.a.getChildCount();
        } else {
            obj3 = h(i2);
        }
        this.b.e(obj3, z3);
        if (z3) {
            l(view);
        }
        this.a.h(view, obj3);
    }

    void b(View view, boolean z2) {
        a(view, -1, z2);
    }

    void c(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3, boolean z4) {
        int obj3;
        if (i2 < 0) {
            obj3 = this.a.getChildCount();
        } else {
            obj3 = h(i2);
        }
        this.b.e(obj3, z4);
        if (z4) {
            l(view);
        }
        this.a.j(view, obj3, layoutParams3);
    }

    void d(int i) {
        final int obj2 = h(i);
        this.b.f(obj2);
        this.a.f(obj2);
    }

    View e(int i) {
        int i2;
        Object obj;
        androidx.recyclerview.widget.RecyclerView.e0 removed;
        int layoutPosition;
        i2 = 0;
        while (i2 < this.c.size()) {
            obj = this.c.get(i2);
            removed = this.a.e((View)obj);
            i2++;
        }
        return null;
    }

    View f(int i) {
        return this.a.a(h(i));
    }

    int g() {
        return childCount -= size;
    }

    View i(int i) {
        return this.a.a(i);
    }

    int j() {
        return this.a.getChildCount();
    }

    void k(View view) {
        int i = this.a.d(view);
        if (i < 0) {
        } else {
            this.b.h(i);
            l(view);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("view is not a child, cannot hide ");
        stringBuilder.append(view);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    int m(View view) {
        int obj3 = this.a.d(view);
        int i = -1;
        if (obj3 == i) {
            return i;
        }
        if (this.b.d(obj3)) {
            return i;
        }
        return obj3 -= i2;
    }

    boolean n(View view) {
        return this.c.contains(view);
    }

    void o() {
        int i;
        List list;
        Object obj;
        this.b.g();
        size--;
        while (i >= 0) {
            this.a.g((View)this.c.get(i));
            this.c.remove(i);
            i--;
        }
        this.a.c();
    }

    void p(View view) {
        int i = this.a.d(view);
        if (i < 0) {
        }
        if (this.b.f(i)) {
            t(view);
        }
        this.a.i(i);
    }

    void q(int i) {
        final int obj3 = h(i);
        View view = this.a.a(obj3);
        if (view == null) {
        }
        if (this.b.f(obj3)) {
            t(view);
        }
        this.a.i(obj3);
    }

    boolean r(View view) {
        int i = this.a.d(view);
        final int i2 = 1;
        if (i == -1) {
            t(view);
            return i2;
        }
        if (this.b.d(i)) {
            this.b.f(i);
            t(view);
            this.a.i(i);
            return i2;
        }
        return 0;
    }

    void s(View view) {
        int i = this.a.d(view);
        if (i < 0) {
        } else {
            if (!this.b.d(i)) {
            } else {
                this.b.a(i);
                t(view);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trying to unhide a view that was not hidden");
            stringBuilder.append(view);
            RuntimeException runtimeException = new RuntimeException(stringBuilder.toString());
            throw runtimeException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("view is not a child, cannot hide ");
        stringBuilder2.append(view);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
        throw illegalArgumentException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.toString());
        stringBuilder.append(", hidden list:");
        stringBuilder.append(this.c.size());
        return stringBuilder.toString();
    }
}
