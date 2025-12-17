package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class b0 extends com.google.protobuf.c<Integer> implements com.google.protobuf.c0.g, RandomAccess, com.google.protobuf.e1 {

    private static final com.google.protobuf.b0 v;
    private int[] b;
    private int c;
    static {
        final int i = 0;
        b0 b0Var = new b0(new int[i], i);
        b0.v = b0Var;
        b0Var.F();
    }

    b0() {
        super(new int[10], 0);
    }

    private b0(int[] iArr, int i2) {
        super();
        this.b = iArr;
        this.c = i2;
    }

    private void h(int i, int i2) {
        int iArr2;
        int i4;
        int[] iArr;
        int i3;
        int i5;
        b();
        if (i < 0) {
        } else {
            i4 = this.c;
            if (i > i4) {
            } else {
                iArr = this.b;
                if (i4 < iArr.length) {
                    System.arraycopy(iArr, i, iArr, i + 1, i4 -= i);
                } else {
                    iArr2 = new int[i7++];
                    int i9 = 0;
                    System.arraycopy(iArr, i9, iArr2, i9, i);
                    System.arraycopy(this.b, i, iArr2, i + 1, i10 -= i);
                    this.b = iArr2;
                }
                this.b[i] = i2;
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(p(i));
        throw obj6;
    }

    public static com.google.protobuf.b0 i() {
        return b0.v;
    }

    private void l(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= this.c) {
            } else {
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(p(i));
        throw indexOutOfBoundsException;
    }

    private String p(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    @Override // com.google.protobuf.c
    public int M(int i, int i2) {
        b();
        l(i);
        final int[] iArr = this.b;
        iArr[i] = i2;
        return iArr[i];
    }

    @Override // com.google.protobuf.c
    public void V(int i) {
        int iArr;
        int i2;
        b();
        int i3 = this.c;
        int[] iArr3 = this.b;
        if (i3 == iArr3.length) {
            iArr = new int[i7++];
            i2 = 0;
            System.arraycopy(iArr3, i2, iArr, i2, i3);
            this.b = iArr;
        }
        int i4 = this.c;
        this.c = i4 + 1;
        this.b[i4] = i;
    }

    @Override // com.google.protobuf.c
    public void add(int i, Object object2) {
        d(i, (Integer)object2);
    }

    @Override // com.google.protobuf.c
    public boolean add(Object object) {
        return g((Integer)object);
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        int[] copyOf;
        b();
        c0.a(collection);
        if (!collection instanceof b0) {
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
    public com.google.protobuf.c0.g c(int i) {
        if (i < this.c) {
        } else {
            b0 b0Var = new b0(Arrays.copyOf(this.b, i), this.c);
            return b0Var;
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
    public void d(int i, Integer integer2) {
        h(i, integer2.intValue());
    }

    @Override // com.google.protobuf.c
    public boolean equals(Object object) {
        int i3;
        int i2;
        int i;
        final int i4 = 1;
        if (this == object) {
            return i4;
        }
        if (!object instanceof b0) {
            return super.equals(object);
        }
        final int i7 = 0;
        if (this.c != object.c) {
            return i7;
        }
        i3 = i7;
        while (i3 < this.c) {
            i3++;
        }
        return i4;
    }

    @Override // com.google.protobuf.c
    public boolean g(Integer integer) {
        V(integer.intValue());
        return 1;
    }

    @Override // com.google.protobuf.c
    public Object get(int i) {
        return m(i);
    }

    @Override // com.google.protobuf.c
    public int getInt(int i) {
        l(i);
        return this.b[i];
    }

    @Override // com.google.protobuf.c
    public int hashCode() {
        int i;
        int i2;
        int i3;
        i = 1;
        i2 = 0;
        while (i2 < this.c) {
            i4 += i3;
            i2++;
        }
        return i;
    }

    @Override // com.google.protobuf.c
    public int indexOf(Object object) {
        int i;
        int i2;
        final int i3 = -1;
        if (!object instanceof Integer) {
            return i3;
        }
        i = 0;
        while (i < size()) {
            i++;
        }
        return i3;
    }

    @Override // com.google.protobuf.c
    public Integer m(int i) {
        return Integer.valueOf(getInt(i));
    }

    @Override // com.google.protobuf.c
    public Integer q(int i) {
        int i2;
        int i3;
        b();
        l(i);
        final int[] iArr = this.b;
        i2 = this.c;
        if (i < i2 + -1) {
            System.arraycopy(iArr, i + 1, iArr, i, i5--);
        }
        this.c = obj5--;
        this.modCount = obj5++;
        return Integer.valueOf(iArr[i]);
    }

    @Override // com.google.protobuf.c
    public Object remove(int i) {
        return q(i);
    }

    @Override // com.google.protobuf.c
    protected void removeRange(int i, int i2) {
        b();
        if (i2 < i) {
        } else {
            int[] iArr = this.b;
            System.arraycopy(iArr, i2, iArr, i, i5 -= i2);
            this.c = i3 -= obj4;
            this.modCount = obj3++;
        }
        IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw obj3;
    }

    @Override // com.google.protobuf.c
    public Integer s(int i, Integer integer2) {
        return Integer.valueOf(M(i, integer2.intValue()));
    }

    @Override // com.google.protobuf.c
    public Object set(int i, Object object2) {
        return s(i, (Integer)object2);
    }

    @Override // com.google.protobuf.c
    public int size() {
        return this.c;
    }
}
