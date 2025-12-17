package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class g8 extends com.google.android.gms.internal.measurement.l7<Double> implements RandomAccess, com.google.android.gms.internal.measurement.c9, com.google.android.gms.internal.measurement.fa {

    private static final com.google.android.gms.internal.measurement.g8 v;
    private double[] b;
    private int c;
    static {
        final int i = 0;
        g8 g8Var = new g8(new double[i], i);
        g8.v = g8Var;
        g8Var.zzb();
    }

    g8() {
        super(new double[10], 0);
    }

    private g8(double[] dArr, int i2) {
        super();
        this.b = dArr;
        this.c = i2;
    }

    private final String g(int i) {
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    private final void h(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= this.c) {
            } else {
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(g(i));
        throw indexOutOfBoundsException;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final void add(int i, Object object2) {
        double[] dArr;
        int i2;
        int i3;
        int obj7;
        b();
        if (i < 0) {
        } else {
            obj7 = this.c;
            if (i > obj7) {
            } else {
                dArr = this.b;
                if (obj7 < dArr.length) {
                    System.arraycopy(dArr, i, dArr, i + 1, obj7 -= i);
                } else {
                    obj7 = new double[obj7++];
                    int i4 = 0;
                    System.arraycopy(dArr, i4, obj7, i4, i);
                    System.arraycopy(this.b, i, obj7, i + 1, i5 -= i);
                    this.b = obj7;
                }
                this.b[i] = (Double)object2.doubleValue();
                this.c = obj6++;
                this.modCount = obj6++;
            }
        }
        obj7 = new IndexOutOfBoundsException(g(i));
        throw obj7;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final boolean add(Object object) {
        d((Double)object.doubleValue());
        return 1;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        double[] copyOf;
        b();
        d9.e(collection);
        if (!collection instanceof g8) {
            return super.addAll(collection);
        }
        int i = collection.c;
        final int i3 = 0;
        if (i == 0) {
            return i3;
        }
        int i4 = this.c;
        if (i6 -= i4 < i) {
        } else {
            i4 += i;
            copyOf = this.b;
            if (i5 > copyOf.length) {
                this.b = Arrays.copyOf(copyOf, i5);
            }
            System.arraycopy(collection.b, i3, this.b, this.c, collection.c);
            this.c = i5;
            int i2 = 1;
            this.modCount = obj6 += i2;
            return i2;
        }
        OutOfMemoryError obj6 = new OutOfMemoryError();
        throw obj6;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final boolean contains(Object object) {
        if (indexOf(object) != -1) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final void d(double d) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    public final boolean equals(Object object) {
        int i;
        int cmp;
        long doubleToLongBits;
        long doubleToLongBits2;
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        if (!object instanceof g8) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    public final com.google.android.gms.internal.measurement.c9 f(int i) {
        if (i < this.c) {
        } else {
            g8 g8Var = new g8(Arrays.copyOf(this.b, i), this.c);
            return g8Var;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object get(int i) {
        h(i);
        return Double.valueOf(this.b[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int hashCode() {
        int i;
        int i3;
        int i2;
        double d;
        i = 1;
        i3 = 0;
        while (i3 < this.c) {
            d = this.b[i3];
            i4 += i2;
            i3++;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int indexOf(Object object) {
        int i;
        int cmp;
        double d;
        final int i2 = -1;
        if (!object instanceof Double) {
            return i2;
        }
        i = 0;
        while (i < this.c) {
            i++;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object remove(int i) {
        int i2;
        int i3;
        b();
        h(i);
        final double[] dArr = this.b;
        i2 = this.c;
        if (i < i2 + -1) {
            System.arraycopy(dArr, i + 1, dArr, i, i4--);
        }
        this.c = obj6--;
        this.modCount = obj6++;
        return Double.valueOf(dArr[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    protected final void removeRange(int i, int i2) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object set(int i, Object object2) {
        b();
        h(i);
        final double[] obj6 = this.b;
        obj6[i] = (Double)object2.doubleValue();
        return Double.valueOf(obj6[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int size() {
        return this.c;
    }
}
