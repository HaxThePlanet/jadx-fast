package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class n extends com.google.protobuf.c<Double> implements com.google.protobuf.c0.b, RandomAccess, com.google.protobuf.e1 {

    private static final com.google.protobuf.n v;
    private double[] b;
    private int c;
    static {
        final int i = 0;
        n nVar = new n(new double[i], i);
        n.v = nVar;
        nVar.F();
    }

    n() {
        super(new double[10], 0);
    }

    private n(double[] dArr, int i2) {
        super();
        this.b = dArr;
        this.c = i2;
    }

    private void i(int i, double d2) {
        int dArr;
        int i3;
        double[] dArr2;
        int i4;
        int i2;
        b();
        if (i < 0) {
        } else {
            i3 = this.c;
            if (i > i3) {
            } else {
                dArr2 = this.b;
                if (i3 < dArr2.length) {
                    System.arraycopy(dArr2, i, dArr2, i + 1, i3 -= i);
                } else {
                    dArr = new double[i6++];
                    int i8 = 0;
                    System.arraycopy(dArr2, i8, dArr, i8, i);
                    System.arraycopy(this.b, i, dArr, i + 1, i9 -= i);
                    this.b = dArr;
                }
                this.b[i] = d2;
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(s(i));
        throw obj6;
    }

    public static com.google.protobuf.n l() {
        return n.v;
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
        d(i, (Double)object2);
    }

    @Override // com.google.protobuf.c
    public boolean add(Object object) {
        return g((Double)object);
    }

    public boolean addAll(Collection<? extends Double> collection) {
        double[] copyOf;
        b();
        c0.a(collection);
        if (!collection instanceof n) {
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
    public com.google.protobuf.c0.b c(int i) {
        if (i < this.c) {
        } else {
            n nVar = new n(Arrays.copyOf(this.b, i), this.c);
            return nVar;
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
    public void d(int i, Double double2) {
        i(i, double2.doubleValue());
    }

    @Override // com.google.protobuf.c
    public boolean equals(Object object) {
        int i;
        int cmp;
        long doubleToLongBits;
        long doubleToLongBits2;
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        if (!object instanceof n) {
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
    public boolean g(Double double) {
        h(double.doubleValue());
        return 1;
    }

    @Override // com.google.protobuf.c
    public Object get(int i) {
        return p(i);
    }

    @Override // com.google.protobuf.c
    public void h(double d) {
        int dArr;
        int i;
        b();
        int i2 = this.c;
        double[] dArr3 = this.b;
        if (i2 == dArr3.length) {
            dArr = new double[i6++];
            i = 0;
            System.arraycopy(dArr3, i, dArr, i, i2);
            this.b = dArr;
        }
        int i3 = this.c;
        this.c = i3 + 1;
        this.b[i3] = d;
    }

    @Override // com.google.protobuf.c
    public int hashCode() {
        int i2;
        int i;
        int i3;
        double d;
        i2 = 1;
        i = 0;
        while (i < this.c) {
            d = this.b[i];
            i4 += i3;
            i++;
        }
        return i2;
    }

    @Override // com.google.protobuf.c
    public int indexOf(Object object) {
        int i;
        int cmp;
        double d;
        final int i2 = -1;
        if (!object instanceof Double) {
            return i2;
        }
        i = 0;
        while (i < size()) {
            i++;
        }
        return i2;
    }

    @Override // com.google.protobuf.c
    public Double p(int i) {
        return Double.valueOf(q(i));
    }

    @Override // com.google.protobuf.c
    public double q(int i) {
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
            double[] dArr = this.b;
            System.arraycopy(dArr, i2, dArr, i, i5 -= i2);
            this.c = i3 -= obj4;
            this.modCount = obj3++;
        }
        IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw obj3;
    }

    @Override // com.google.protobuf.c
    public Object set(int i, Object object2) {
        return u(i, (Double)object2);
    }

    @Override // com.google.protobuf.c
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.c
    public Double t(int i) {
        int i3;
        int i2;
        b();
        m(i);
        final double[] dArr = this.b;
        i3 = this.c;
        if (i < i3 + -1) {
            System.arraycopy(dArr, i + 1, dArr, i, i4--);
        }
        this.c = obj6--;
        this.modCount = obj6++;
        return Double.valueOf(dArr[i]);
    }

    @Override // com.google.protobuf.c
    public Double u(int i, Double double2) {
        return Double.valueOf(v(i, double2.doubleValue()));
    }

    @Override // com.google.protobuf.c
    public double v(int i, double d2) {
        b();
        m(i);
        final double[] dArr = this.b;
        dArr[i] = d2;
        return dArr[i];
    }
}
