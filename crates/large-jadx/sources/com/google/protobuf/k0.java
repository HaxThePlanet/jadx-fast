package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class k0 extends com.google.protobuf.c<Long> implements com.google.protobuf.c0.i, RandomAccess, com.google.protobuf.e1 {

    private static final com.google.protobuf.k0 v;
    private long[] b;
    private int c;
    static {
        final int i = 0;
        k0 k0Var = new k0(new long[i], i);
        k0.v = k0Var;
        k0Var.F();
    }

    k0() {
        super(new long[10], 0);
    }

    private k0(long[] lArr, int i2) {
        super();
        this.b = lArr;
        this.c = i2;
    }

    private void h(int i, long l2) {
        int lArr;
        int i2;
        long[] lArr2;
        int i3;
        int i4;
        b();
        if (i < 0) {
        } else {
            i2 = this.c;
            if (i > i2) {
            } else {
                lArr2 = this.b;
                if (i2 < lArr2.length) {
                    System.arraycopy(lArr2, i, lArr2, i + 1, i2 -= i);
                } else {
                    lArr = new long[i6++];
                    int i8 = 0;
                    System.arraycopy(lArr2, i8, lArr, i8, i);
                    System.arraycopy(this.b, i, lArr, i + 1, i9 -= i);
                    this.b = lArr;
                }
                this.b[i] = l2;
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(s(i));
        throw obj6;
    }

    public static com.google.protobuf.k0 l() {
        return k0.v;
    }

    private void m(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= this.c) {
            } else {
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(s(i));
        throw indexOutOfBoundsException;
    }

    private String s(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    @Override // com.google.protobuf.c
    public void add(int i, Object object2) {
        d(i, (Long)object2);
    }

    @Override // com.google.protobuf.c
    public boolean add(Object object) {
        return g((Long)object);
    }

    public boolean addAll(Collection<? extends Long> collection) {
        long[] copyOf;
        b();
        c0.a(collection);
        if (!collection instanceof k0) {
            return super.addAll(collection);
        }
        int i = collection.c;
        final int i3 = 0;
        if (i == 0) {
            return i3;
        }
        int i6 = this.c;
        if (i4 -= i6 < i) {
        } else {
            i6 += i;
            copyOf = this.b;
            if (i7 > copyOf.length) {
                this.b = Arrays.copyOf(copyOf, i7);
            }
            System.arraycopy(collection.b, i3, this.b, this.c, collection.c);
            this.c = i7;
            int i2 = 1;
            this.modCount = obj6 += i2;
            return i2;
        }
        OutOfMemoryError obj6 = new OutOfMemoryError();
        throw obj6;
    }

    @Override // com.google.protobuf.c
    public com.google.protobuf.c0.i c(int i) {
        if (i < this.c) {
        } else {
            k0 k0Var = new k0(Arrays.copyOf(this.b, i), this.c);
            return k0Var;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Override // com.google.protobuf.c
    public com.google.protobuf.c0.j c(int i) {
        return c(i);
    }

    @Override // com.google.protobuf.c
    public boolean contains(Object object) {
        int obj2;
        obj2 = indexOf(object) != -1 ? 1 : 0;
        return obj2;
    }

    @Override // com.google.protobuf.c
    public void d(int i, Long long2) {
        h(i, long2.longValue());
    }

    @Override // com.google.protobuf.c
    public boolean equals(Object object) {
        int i;
        int cmp;
        long l;
        long l2;
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        if (!object instanceof k0) {
            return super.equals(object);
        }
        final int i5 = 0;
        if (this.c != object.c) {
            return i5;
        }
        i = i5;
        while (i < this.c) {
            i++;
        }
        return i2;
    }

    @Override // com.google.protobuf.c
    public boolean g(Long long) {
        i(long.longValue());
        return 1;
    }

    @Override // com.google.protobuf.c
    public Object get(int i) {
        return p(i);
    }

    @Override // com.google.protobuf.c
    public int hashCode() {
        int i;
        int i3;
        int i2;
        long l;
        i = 1;
        i3 = 0;
        while (i3 < this.c) {
            i4 += i2;
            i3++;
        }
        return i;
    }

    @Override // com.google.protobuf.c
    public void i(long l) {
        int lArr;
        int i;
        b();
        int i2 = this.c;
        long[] lArr3 = this.b;
        if (i2 == lArr3.length) {
            lArr = new long[i6++];
            i = 0;
            System.arraycopy(lArr3, i, lArr, i, i2);
            this.b = lArr;
        }
        int i3 = this.c;
        this.c = i3 + 1;
        this.b[i3] = l;
    }

    @Override // com.google.protobuf.c
    public int indexOf(Object object) {
        int i;
        int cmp;
        long l;
        final int i2 = -1;
        if (!object instanceof Long) {
            return i2;
        }
        i = 0;
        while (i < size()) {
            i++;
        }
        return i2;
    }

    @Override // com.google.protobuf.c
    public Long p(int i) {
        return Long.valueOf(q(i));
    }

    @Override // com.google.protobuf.c
    public long q(int i) {
        m(i);
        return this.b[i];
    }

    @Override // com.google.protobuf.c
    public Object remove(int i) {
        return t(i);
    }

    @Override // com.google.protobuf.c
    protected void removeRange(int i, int i2) {
        b();
        if (i2 < i) {
        } else {
            long[] lArr = this.b;
            System.arraycopy(lArr, i2, lArr, i, i5 -= i2);
            this.c = i3 -= obj4;
            this.modCount = obj3++;
        }
        IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw obj3;
    }

    @Override // com.google.protobuf.c
    public Object set(int i, Object object2) {
        return u(i, (Long)object2);
    }

    @Override // com.google.protobuf.c
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.c
    public Long t(int i) {
        int i2;
        int i3;
        b();
        m(i);
        final long[] lArr = this.b;
        i2 = this.c;
        if (i < i2 + -1) {
            System.arraycopy(lArr, i + 1, lArr, i, i4--);
        }
        this.c = obj6--;
        this.modCount = obj6++;
        return Long.valueOf(lArr[i]);
    }

    @Override // com.google.protobuf.c
    public Long u(int i, Long long2) {
        return Long.valueOf(v(i, long2.longValue()));
    }

    @Override // com.google.protobuf.c
    public long v(int i, long l2) {
        b();
        m(i);
        final long[] lArr = this.b;
        lArr[i] = l2;
        return lArr[i];
    }
}
