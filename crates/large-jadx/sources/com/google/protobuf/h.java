package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class h extends com.google.protobuf.c<Boolean> implements com.google.protobuf.c0.a, RandomAccess, com.google.protobuf.e1 {

    private static final com.google.protobuf.h v;
    private boolean[] b;
    private int c;
    static {
        final int i = 0;
        h hVar = new h(new boolean[i], i);
        h.v = hVar;
        hVar.F();
    }

    h() {
        super(new boolean[10], 0);
    }

    private h(boolean[] zArr, int i2) {
        super();
        this.b = zArr;
        this.c = i2;
    }

    private void h(int i, boolean z2) {
        int zArr2;
        int i2;
        boolean[] zArr;
        int i4;
        int i3;
        b();
        if (i < 0) {
        } else {
            i2 = this.c;
            if (i > i2) {
            } else {
                zArr = this.b;
                if (i2 < zArr.length) {
                    System.arraycopy(zArr, i, zArr, i + 1, i2 -= i);
                } else {
                    zArr2 = new boolean[i6++];
                    int i8 = 0;
                    System.arraycopy(zArr, i8, zArr2, i8, i);
                    System.arraycopy(this.b, i, zArr2, i + 1, i9 -= i);
                    this.b = zArr2;
                }
                this.b[i] = z2;
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(s(i));
        throw obj6;
    }

    public static com.google.protobuf.h l() {
        return h.v;
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
        d(i, (Boolean)object2);
    }

    @Override // com.google.protobuf.c
    public boolean add(Object object) {
        return g((Boolean)object);
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        boolean[] copyOf;
        b();
        c0.a(collection);
        if (!collection instanceof h) {
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
    public com.google.protobuf.c0.a c(int i) {
        if (i < this.c) {
        } else {
            h hVar = new h(Arrays.copyOf(this.b, i), this.c);
            return hVar;
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
    public void d(int i, Boolean boolean2) {
        h(i, boolean2.booleanValue());
    }

    @Override // com.google.protobuf.c
    public boolean equals(Object object) {
        int i;
        int i2;
        boolean z;
        final int i3 = 1;
        if (this == object) {
            return i3;
        }
        if (!object instanceof h) {
            return super.equals(object);
        }
        final int i6 = 0;
        if (this.c != object.c) {
            return i6;
        }
        i = i6;
        while (i < this.c) {
            i++;
        }
        return i3;
    }

    @Override // com.google.protobuf.c
    public boolean g(Boolean boolean) {
        i(boolean.booleanValue());
        return 1;
    }

    @Override // com.google.protobuf.c
    public Object get(int i) {
        return p(i);
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
    public void i(boolean z) {
        int zArr;
        int i;
        b();
        int i2 = this.c;
        boolean[] zArr3 = this.b;
        if (i2 == zArr3.length) {
            zArr = new boolean[i6++];
            i = 0;
            System.arraycopy(zArr3, i, zArr, i, i2);
            this.b = zArr;
        }
        int i3 = this.c;
        this.c = i3 + 1;
        this.b[i3] = z;
    }

    @Override // com.google.protobuf.c
    public int indexOf(Object object) {
        int i;
        boolean z;
        final int i2 = -1;
        if (!object instanceof Boolean) {
            return i2;
        }
        i = 0;
        while (i < size()) {
            i++;
        }
        return i2;
    }

    @Override // com.google.protobuf.c
    public Boolean p(int i) {
        return Boolean.valueOf(q(i));
    }

    @Override // com.google.protobuf.c
    public boolean q(int i) {
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
            boolean[] zArr = this.b;
            System.arraycopy(zArr, i2, zArr, i, i5 -= i2);
            this.c = i3 -= obj4;
            this.modCount = obj3++;
        }
        IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw obj3;
    }

    @Override // com.google.protobuf.c
    public Object set(int i, Object object2) {
        return u(i, (Boolean)object2);
    }

    @Override // com.google.protobuf.c
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.c
    public Boolean t(int i) {
        int i3;
        int i2;
        b();
        m(i);
        final boolean[] zArr = this.b;
        i3 = this.c;
        if (i < i3 + -1) {
            System.arraycopy(zArr, i + 1, zArr, i, i4--);
        }
        this.c = obj5--;
        this.modCount = obj5++;
        return Boolean.valueOf(zArr[i]);
    }

    @Override // com.google.protobuf.c
    public Boolean u(int i, Boolean boolean2) {
        return Boolean.valueOf(v(i, boolean2.booleanValue()));
    }

    @Override // com.google.protobuf.c
    public boolean v(int i, boolean z2) {
        b();
        m(i);
        final boolean[] zArr = this.b;
        zArr[i] = z2;
        return zArr[i];
    }
}
