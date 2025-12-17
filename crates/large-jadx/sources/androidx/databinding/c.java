package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c<C, T, A>  implements java.lang.Cloneable {

    private List<C> a;
    private long b = 0;
    private long[] c;
    private int v;
    private final androidx.databinding.c.a<C, T, A> w;

    public static abstract class a {
        public abstract void a(C c, T t2, int i3, A a4);
    }
    public c(androidx.databinding.c.a<C, T, A> c$a) {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        int i = 0;
        this.w = a;
    }

    private boolean c(int i) {
        int i2;
        final int i3 = 0;
        int i4 = 1;
        final int i9 = 64;
        final int i10 = 0;
        if (i < i9) {
            if (Long.compare(i8, i3) != 0) {
            } else {
                i2 = i10;
            }
            return i2;
        }
        long[] lArr = this.c;
        if (lArr == null) {
            return i10;
        }
        i11 -= i2;
        if (i12 >= lArr.length) {
            return i10;
        }
        if (Long.compare(i6, i3) != 0) {
        } else {
            i2 = i10;
        }
        return i2;
    }

    private void e(T t, int i2, A a3, int i4, int i5, long l6) {
        int i;
        int i6;
        int cmp;
        Object obj;
        int i3;
        int obj10;
        i = 1;
        while (obj10 < i5) {
            if (Long.compare(i7, i3) == 0) {
            }
            i <<= i6;
            obj10++;
            this.w.a(this.a.get(obj10), t, i2, a3);
        }
    }

    private void f(T t, int i2, A a3) {
        this.e(t, i2, a3, 0, Math.min(64, this.a.size()), this.b);
    }

    private void g(T t, int i2, A a3) {
        int i;
        long[] lArr = this.c;
        i = lArr == null ? -1 : length + -1;
        h(t, i2, a3, i);
        this.e(t, i2, a3, i3 * 64, this.a.size(), 0);
    }

    private void h(T t, int i2, A a3, int i4) {
        int size;
        Object obj3;
        Object obj2;
        int i;
        Object obj;
        int i5;
        int i3;
        long l;
        int obj13;
        if (i4 < 0) {
            f(t, i2, a3);
        } else {
            i5 = i6 * 64;
            h(t, i2, a3, i4--);
            this.e(t, i2, a3, i5, Math.min(this.a.size(), i5 + 64), this.c[i4]);
        }
    }

    private void k(int i, long l2) {
        int i2;
        long l;
        int cmp;
        int i3;
        final int i5 = 1;
        i4 -= i5;
        l = Long.MIN_VALUE;
        while (i2 >= i) {
            if (Long.compare(i6, i3) != 0) {
            }
            l >>>= i5;
            i2--;
            this.a.remove(i2);
        }
    }

    private void l(int i) {
        int i3;
        int i2;
        int i5;
        long l;
        long[] lArr2;
        long[] lArr;
        int length;
        int i4;
        long[] obj9;
        int i6 = 1;
        i2 = 64;
        if (i < i2) {
            this.b = i8 |= i2;
        } else {
            i9--;
            long[] lArr3 = this.c;
            if (lArr3 == null) {
                this.c = new long[size /= i2];
            } else {
                if (lArr3.length <= i5) {
                    lArr2 = new long[size2 /= i2];
                    lArr = this.c;
                    i4 = 0;
                    System.arraycopy(lArr, i4, lArr2, i4, lArr.length);
                    this.c = lArr2;
                }
            }
            obj9 = this.c;
            obj9[i5] = i7 |= l;
        }
    }

    public void a(C c) {
        int lastIndexOf;
        synchronized (this) {
            lastIndexOf = this.a.lastIndexOf(c);
            if (lastIndexOf >= 0) {
                if (c(lastIndexOf)) {
                    try {
                        this.a.add(c);
                        IllegalArgumentException obj2 = new IllegalArgumentException("callback cannot be null");
                        throw obj2;
                        throw c;
                    }
                }
            } else {
            }
        }
    }

    public androidx.databinding.c<C, T, A> b() {
        int i;
        Throwable th3;
        Object clone;
        boolean z;
        Object obj;
        Throwable th;
        clone = super.clone();
        clone.b = 0;
        clone.c = 0;
        clone.v = 0;
        ArrayList arrayList = new ArrayList();
        clone.a = arrayList;
        synchronized (this) {
            while (i < this.a.size()) {
                if (!c(i)) {
                }
                i++;
                clone.a.add(this.a.get(i));
            }
            return clone;
        }
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return b();
    }

    public void d(T t, int i2, A a3) {
        int cmp;
        long l;
        int obj4;
        int obj5;
        this.v = i++;
        g(t, i2, a3);
        obj4--;
        this.v = obj4;
        synchronized (this) {
            try {
                obj4 = this.c;
                obj5 = 0;
                if (obj4 != null) {
                }
                obj4--;
                while (obj4 >= 0) {
                    l = this.c[obj4];
                    if (Long.compare(l, obj5) != 0) {
                    }
                    obj4--;
                    k(i3 *= 64, l);
                    this.c[obj4] = obj5;
                }
                l = this.c[obj4];
                if (Long.compare(l, obj5) != 0) {
                }
                k(i3 *= 64, l);
                this.c[obj4] = obj5;
                obj4--;
                cmp = this.b;
                if (Long.compare(cmp, obj5) != 0) {
                }
                k(0, cmp);
                this.b = obj5;
                throw t;
            }
        }
    }

    public void j(C c) {
        List list;
        Object obj2;
        synchronized (this) {
            try {
                this.a.remove(c);
                obj2 = this.a.lastIndexOf(c);
                if (obj2 >= 0) {
                }
                l(obj2);
                throw c;
            }
        }
    }
}
