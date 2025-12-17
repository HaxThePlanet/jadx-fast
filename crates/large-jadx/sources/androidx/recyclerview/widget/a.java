package androidx.recyclerview.widget;

import d.h.k.f;
import d.h.k.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class a implements androidx.recyclerview.widget.s.a {

    private f<androidx.recyclerview.widget.a.b> a;
    final ArrayList<androidx.recyclerview.widget.a.b> b;
    final ArrayList<androidx.recyclerview.widget.a.b> c;
    final androidx.recyclerview.widget.a.a d;
    Runnable e;
    final boolean f;
    final androidx.recyclerview.widget.s g;
    private int h;

    interface a {
        public abstract void a(int i, int i2);

        public abstract void b(androidx.recyclerview.widget.a.b a$b);

        public abstract void c(int i, int i2, Object object3);

        public abstract void d(androidx.recyclerview.widget.a.b a$b);

        public abstract androidx.recyclerview.widget.RecyclerView.e0 e(int i);

        public abstract void f(int i, int i2);

        public abstract void g(int i, int i2);

        public abstract void h(int i, int i2);
    }

    static final class b {

        int a;
        int b;
        Object c;
        int d;
        b(int i, int i2, int i3, Object object4) {
            super();
            this.a = i;
            this.b = i2;
            this.d = i3;
            this.c = object4;
        }

        String a() {
            int i = this.a;
            if (i != 1 && i != 2 && i != 4 && i != 8) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 8) {
                            return "??";
                        }
                        return "mv";
                    }
                    return "up";
                }
                return "rm";
            }
            return "add";
        }

        public boolean equals(Object object) {
            int i;
            int i2;
            Object obj5;
            final int i3 = 1;
            if (this == object) {
                return i3;
            }
            final int i8 = 0;
            if (!object instanceof a.b) {
                return i8;
            }
            i = this.a;
            if (i != object.a) {
                return i8;
            }
            if (i == 8 && Math.abs(i6 -= i2) == i3 && this.d == object.b && this.b == object.d) {
                if (Math.abs(i6 -= i2) == i3) {
                    if (this.d == object.b) {
                        if (this.b == object.d) {
                            return i3;
                        }
                    }
                }
            }
            if (this.d != object.d) {
                return i8;
            }
            if (this.b != object.b) {
                return i8;
            }
            Object obj = this.c;
            if (obj != null) {
                if (!obj.equals(object.c)) {
                    return i8;
                }
            } else {
                if (object.c != null) {
                    return i8;
                }
            }
            return i3;
        }

        public int hashCode() {
            return i4 += i7;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append("[");
            stringBuilder.append(a());
            stringBuilder.append(",s:");
            stringBuilder.append(this.b);
            stringBuilder.append("c:");
            stringBuilder.append(this.d);
            stringBuilder.append(",p:");
            stringBuilder.append(this.c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
    a(androidx.recyclerview.widget.a.a a$a) {
        super(a, 0);
    }

    a(androidx.recyclerview.widget.a.a a$a, boolean z2) {
        super();
        g gVar = new g(30);
        this.a = gVar;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.c = arrayList2;
        this.h = 0;
        this.d = a;
        this.f = z2;
        s obj3 = new s(this);
        this.g = obj3;
    }

    private void c(androidx.recyclerview.widget.a.b a$b) {
        v(b);
    }

    private void d(androidx.recyclerview.widget.a.b a$b) {
        v(b);
    }

    private void f(androidx.recyclerview.widget.a.b a$b) {
        int i8;
        int i4;
        int i3;
        int i2;
        int i7;
        int i5;
        int i6;
        boolean z;
        int i;
        Object obj11;
        final int i9 = b.b;
        i10 += i9;
        final int i12 = 0;
        i4 = -1;
        i2 = i9;
        i7 = i12;
        int i13 = 0;
        i6 = 2;
        while (i2 < i8) {
            i = 1;
            if (this.d.e(i2) == null) {
            } else {
            }
            if (i4 == 0) {
            } else {
            }
            i3 = i12;
            i5 = i;
            if (i3 != 0) {
            } else {
            }
            i7++;
            i2 += i;
            i4 = i5;
            i13 = 0;
            i6 = 2;
            i2 -= i7;
            i8 -= i7;
            i7 = i;
            k(b(i6, i9, i7, i13));
            i3 = i;
            if (h(i2)) {
            } else {
            }
            if (i4 == i) {
            } else {
            }
            i3 = i12;
            i5 = i12;
            v(b(i6, i9, i7, i13));
            i3 = i;
        }
        if (i7 != b.d) {
            a(b);
            obj11 = b(i6, i9, i7, i13);
        }
        if (i4 == 0) {
            k(obj11);
        } else {
            v(obj11);
        }
    }

    private void g(androidx.recyclerview.widget.a.b a$b) {
        int i6;
        int i5;
        int i;
        int i3;
        int i7;
        int i2;
        boolean z;
        int i4;
        Object obj10;
        i6 = b.b;
        final int i10 = 0;
        i7 = i10;
        i3 = i11;
        i = i6;
        i2 = 4;
        while (i6 < i8 += i6) {
            i4 = 1;
            if (this.d.e(i6) == null) {
            } else {
            }
            if (i3 == 0) {
            }
            i3 = i4;
            i7 += i4;
            i6++;
            i2 = 4;
            k(b(i2, i, i7, b.c));
            i = i6;
            i7 = i10;
            if (h(i6)) {
            } else {
            }
            if (i3 == i4) {
            }
            i3 = i10;
            v(b(i2, i, i7, b.c));
            i = i6;
            i7 = i10;
        }
        if (i7 != b.d) {
            a(b);
            obj10 = b(i2, i, i7, b.c);
        }
        if (i3 == 0) {
            k(obj10);
        } else {
            v(obj10);
        }
    }

    private boolean h(int i) {
        int i2;
        int i6;
        int i5;
        int i3;
        int i4;
        final int i7 = 0;
        i2 = i7;
        while (i2 < this.c.size()) {
            i6 = this.c.get(i2);
            i5 = i6.a;
            i4 = 1;
            i2++;
            while (i5 < i9 += i5) {
                i5++;
            }
            i5++;
        }
        return i7;
    }

    private void k(androidx.recyclerview.widget.a.b a$b) {
        int i9;
        int i3;
        int i7;
        int i2;
        int i8;
        int i5;
        int i6;
        int i4;
        int i;
        Object obj13;
        int i10 = b.a;
        int i12 = 1;
        if (i10 == i12) {
        } else {
            if (i10 == 8) {
            } else {
                i9 = z(b.b, i10);
                i7 = b.b;
                int i14 = b.a;
                final int i15 = 2;
                final int i16 = 4;
                final int i17 = 0;
                if (i14 != i15) {
                    if (i14 != i16) {
                    } else {
                        i2 = i12;
                        i5 = i8;
                        while (i8 < b.d) {
                            i6 = z(i19 += i21, b.a);
                            i4 = b.a;
                            if (i4 != i15 && i4 != i16) {
                            } else {
                            }
                            if (i6 == i9) {
                            } else {
                            }
                            i = i17;
                            if (i != 0) {
                            } else {
                            }
                            androidx.recyclerview.widget.a.b bVar = b(i4, i9, i5, b.c);
                            l(bVar, i7);
                            a(bVar);
                            if (b.a == i16) {
                            }
                            i5 = i12;
                            i9 = i6;
                            i8++;
                            i7 += i5;
                            i5++;
                            i = i12;
                            if (i4 != i16) {
                            } else {
                            }
                            if (i6 == i9 + 1) {
                            } else {
                            }
                        }
                        a(b);
                        if (i5 > 0) {
                            obj13 = b(b.a, i9, i5, b.c);
                            l(obj13, i7);
                            a(obj13);
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("op should be remove or update.");
                    stringBuilder.append(b);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
                i2 = i17;
            }
        }
        obj13 = new IllegalArgumentException("should not dispatch add or move for pre layout");
        throw obj13;
    }

    private void v(androidx.recyclerview.widget.a.b a$b) {
        androidx.recyclerview.widget.a.a aVar;
        int i;
        int i2;
        int obj4;
        this.c.add(b);
        int i3 = b.a;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                    } else {
                        this.d.a(b.b, b.d);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown update op type for ");
                    stringBuilder.append(b);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                    throw illegalArgumentException;
                }
                this.d.c(b.b, b.d, b.c);
            } else {
                this.d.f(b.b, b.d);
            }
        } else {
            this.d.g(b.b, b.d);
        }
    }

    private int z(int i, int i2) {
        int i7;
        int i8;
        int i4;
        Object obj;
        int i5;
        int i9;
        int i6;
        int i3;
        int obj9;
        int obj10;
        i8 = 1;
        size -= i8;
        int i11 = 8;
        while (i7 >= 0) {
            obj = this.c.get(i7);
            i5 = obj.a;
            i9 = 2;
            if (i5 == i11) {
            } else {
            }
            i4 = obj.b;
            if (i4 <= obj9) {
            } else {
            }
            if (i2 == i8) {
            } else {
            }
            if (i2 == i9) {
            }
            i7--;
            i11 = 8;
            obj.b = i4--;
            obj.b = i4++;
            if (i5 == i8) {
            } else {
            }
            if (i5 == i9) {
            }
            obj9 += i4;
            obj9 -= i4;
            i4 = obj.b;
            i5 = obj.d;
            if (i4 < i5) {
            } else {
            }
            i3 = i4;
            i6 = i5;
            if (obj9 >= i6 && obj9 <= i3) {
            } else {
            }
            if (obj9 < i4) {
            }
            if (i2 == i8) {
            } else {
            }
            if (i2 == i9) {
            }
            obj.b = i4--;
            obj.d = i5--;
            obj.b = i4++;
            obj.d = i5++;
            if (obj9 <= i3) {
            } else {
            }
            if (i6 == i4) {
            } else {
            }
            if (i2 == i8) {
            } else {
            }
            if (i2 == i9) {
            }
            obj9--;
            obj.b = i4--;
            obj.b = i4++;
            if (i2 == i8) {
            } else {
            }
            if (i2 == i9) {
            }
            obj9++;
            obj.d = i5--;
            obj.d = i5++;
            i6 = i4;
            i3 = i5;
        }
        obj10 -= i8;
        while (obj10 >= 0) {
            i7 = this.c.get(obj10);
            if (i7.a == i11) {
            } else {
            }
            if (i7.d <= 0) {
            }
            obj10--;
            this.c.remove(obj10);
            a((a.b)i7);
            i8 = i7.d;
            if (i8 != i7.b) {
            } else {
            }
            this.c.remove(obj10);
            a(i7);
            if (i8 < 0) {
            }
        }
        return obj9;
    }

    @Override // androidx.recyclerview.widget.s$a
    public void a(androidx.recyclerview.widget.a.b a$b) {
        boolean z;
        if (!this.f) {
            b.c = 0;
            this.a.a(b);
        }
    }

    @Override // androidx.recyclerview.widget.s$a
    public androidx.recyclerview.widget.a.b b(int i, int i2, int i3, Object object4) {
        Object bVar;
        bVar = this.a.b();
        if ((a.b)bVar == null) {
            bVar = new a.b(i, i2, i3, object4);
        } else {
            bVar.a = i;
            bVar.b = i2;
            bVar.d = i3;
            bVar.c = object4;
        }
        return bVar;
    }

    @Override // androidx.recyclerview.widget.s$a
    public int e(int i) {
        int i3;
        Object obj;
        int i4;
        int i2;
        int obj6;
        i3 = 0;
        while (i3 < this.b.size()) {
            obj = this.b.get(i3);
            i4 = obj.a;
            if (obj.b <= obj6) {
            }
            i3++;
            obj6 += obj;
            i4 = obj.b;
            obj = obj.d;
            obj6 -= obj;
            if (i4 != 8) {
            } else {
            }
            i4 = obj.b;
            if (i4 == obj6) {
            } else {
            }
            if (i4 < obj6) {
            }
            if (obj.d <= obj6) {
            }
            obj6++;
            obj6--;
            obj6 = obj.d;
        }
        return obj6;
    }

    @Override // androidx.recyclerview.widget.s$a
    void i() {
        int i;
        androidx.recyclerview.widget.a.a aVar;
        Object obj;
        final int i2 = 0;
        i = i2;
        while (i < this.c.size()) {
            this.d.d((a.b)this.c.get(i));
            i++;
        }
        x(this.c);
        this.h = i2;
    }

    @Override // androidx.recyclerview.widget.s$a
    void j() {
        int i2;
        Runnable runnable;
        int obj;
        androidx.recyclerview.widget.a.a aVar;
        int i3;
        int i;
        i();
        final int i4 = 0;
        i2 = i4;
        while (i2 < this.b.size()) {
            obj = this.b.get(i2);
            aVar = obj.a;
            if (aVar != 1) {
            } else {
            }
            this.d.d((a.b)obj);
            this.d.g(obj.b, obj.d);
            runnable = this.e;
            if (runnable != null) {
            }
            i2++;
            runnable.run();
            if (aVar != 2) {
            } else {
            }
            this.d.d(obj);
            this.d.h(obj.b, obj.d);
            if (aVar != 4) {
            } else {
            }
            this.d.d(obj);
            this.d.c(obj.b, obj.d, obj.c);
            if (aVar != 8) {
            } else {
            }
            this.d.d(obj);
            this.d.a(obj.b, obj.d);
        }
        x(this.b);
        this.h = i4;
    }

    @Override // androidx.recyclerview.widget.s$a
    void l(androidx.recyclerview.widget.a.b a$b, int i2) {
        androidx.recyclerview.widget.a.a aVar;
        int i;
        Object obj3;
        this.d.b(b);
        int i3 = b.a;
        if (i3 != 2) {
            if (i3 != 4) {
            } else {
                this.d.c(i2, b.d, b.c);
            }
            obj3 = new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            throw obj3;
        }
        this.d.h(i2, b.d);
    }

    @Override // androidx.recyclerview.widget.s$a
    int m(int i) {
        return n(i, 0);
    }

    @Override // androidx.recyclerview.widget.s$a
    int n(int i, int i2) {
        Object obj;
        int i3;
        int i4;
        int i5;
        int obj6;
        int obj7;
        while (obj7 < this.c.size()) {
            obj = this.c.get(obj7);
            i3 = obj.a;
            i4 = obj.b;
            obj7++;
            if (i3 == 1) {
            }
            obj6 += obj;
            obj = obj.d;
            obj6 -= obj;
            i3 = obj.b;
            if (i3 == obj6) {
            } else {
            }
            if (i3 < obj6) {
            }
            if (obj.d <= obj6) {
            }
            obj6++;
            obj6--;
            obj6 = obj.d;
        }
        return obj6;
    }

    @Override // androidx.recyclerview.widget.s$a
    boolean o(int i) {
        int obj2;
        obj2 = i &= i2 != 0 ? 1 : 0;
        return obj2;
    }

    @Override // androidx.recyclerview.widget.s$a
    boolean p() {
        int i;
        i = this.b.size() > 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.recyclerview.widget.s$a
    boolean q() {
        boolean empty;
        int i;
        if (!this.c.isEmpty() && !this.b.isEmpty()) {
            i = !this.b.isEmpty() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.s$a
    boolean r(int i, int i2, Object object3) {
        int i3;
        final int i4 = 1;
        if (i2 < i4) {
            return 0;
        }
        final int i5 = 4;
        this.b.add(b(i5, i, i2, object3));
        this.h = obj5 |= i5;
        if (this.b.size() == i4) {
            i3 = i4;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.s$a
    boolean s(int i, int i2) {
        int i3;
        final int i4 = 1;
        if (i2 < i4) {
            return 0;
        }
        this.b.add(b(i4, i, i2, 0));
        this.h = obj5 |= i4;
        if (this.b.size() == i4) {
            i3 = i4;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.s$a
    boolean t(int i, int i2, int i3) {
        int i4;
        if (i == i2) {
            return 0;
        }
        final int i5 = 1;
        if (i3 != i5) {
        } else {
            final int i7 = 8;
            this.b.add(b(i7, i, i2, 0));
            this.h = obj5 |= i7;
            if (this.b.size() == i5) {
                i4 = i5;
            }
            return i4;
        }
        IllegalArgumentException obj5 = new IllegalArgumentException("Moving more than 1 item is not supported yet");
        throw obj5;
    }

    @Override // androidx.recyclerview.widget.s$a
    boolean u(int i, int i2) {
        int i3;
        final int i4 = 1;
        if (i2 < i4) {
            return 0;
        }
        final int i6 = 2;
        this.b.add(b(i6, i, i2, 0));
        this.h = obj6 |= i6;
        if (this.b.size() == i4) {
            i3 = i4;
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.s$a
    void w() {
        int i;
        Runnable runnable;
        int i2;
        int i3;
        this.g.b(this.b);
        i = 0;
        while (i < this.b.size()) {
            Object obj = this.b.get(i);
            i2 = obj.a;
            if (i2 != 1) {
            } else {
            }
            c((a.b)obj);
            runnable = this.e;
            if (runnable != null) {
            }
            i++;
            runnable.run();
            if (i2 != 2) {
            } else {
            }
            f(obj);
            if (i2 != 4) {
            } else {
            }
            g(obj);
            if (i2 != 8) {
            } else {
            }
            d(obj);
        }
        this.b.clear();
    }

    void x(List<androidx.recyclerview.widget.a.b> list) {
        int i;
        Object obj;
        i = 0;
        while (i < list.size()) {
            a((a.b)list.get(i));
            i++;
        }
        list.clear();
    }

    @Override // androidx.recyclerview.widget.s$a
    void y() {
        x(this.b);
        x(this.c);
        this.h = 0;
    }
}
