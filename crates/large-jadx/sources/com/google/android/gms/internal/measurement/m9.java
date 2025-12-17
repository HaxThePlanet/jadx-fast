package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class m9 extends com.google.android.gms.internal.measurement.l7<Long> implements RandomAccess, com.google.android.gms.internal.measurement.b9, com.google.android.gms.internal.measurement.fa {

    private static final com.google.android.gms.internal.measurement.m9 v;
    private long[] b;
    private int c;
    static {
        final int i = 0;
        m9 m9Var = new m9(new long[i], i);
        m9.v = m9Var;
        m9Var.zzb();
    }

    m9() {
        super(new long[10], 0);
    }

    private m9(long[] lArr, int i2) {
        super();
        this.b = lArr;
        this.c = i2;
    }

    public static com.google.android.gms.internal.measurement.m9 d() {
        return m9.v;
    }

    private final String h(int i) {
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    private final void i(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= this.c) {
            } else {
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(h(i));
        throw indexOutOfBoundsException;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final com.google.android.gms.internal.measurement.b9 K(int i) {
        if (i < this.c) {
        } else {
            m9 m9Var = new m9(Arrays.copyOf(this.b, i), this.c);
            return m9Var;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final void add(int i, Object object2) {
        long[] lArr;
        int i3;
        int i2;
        int obj7;
        b();
        if (i < 0) {
        } else {
            obj7 = this.c;
            if (i > obj7) {
            } else {
                lArr = this.b;
                if (obj7 < lArr.length) {
                    System.arraycopy(lArr, i, lArr, i + 1, obj7 -= i);
                } else {
                    obj7 = new long[obj7++];
                    int i4 = 0;
                    System.arraycopy(lArr, i4, obj7, i4, i);
                    System.arraycopy(this.b, i, obj7, i + 1, i5 -= i);
                    this.b = obj7;
                }
                this.b[i] = (Long)object2.longValue();
                this.c = obj6++;
                this.modCount = obj6++;
            }
        }
        obj7 = new IndexOutOfBoundsException(h(i));
        throw obj7;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final boolean add(Object object) {
        g((Long)object.longValue());
        return 1;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        long[] copyOf;
        b();
        d9.e(collection);
        if (!collection instanceof m9) {
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
    public final long e(int i) {
        i(i);
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final boolean equals(Object object) {
        int i;
        int cmp;
        long l;
        long l2;
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        if (!object instanceof m9) {
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
        return K(i);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final void g(long l) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object get(int i) {
        i(i);
        return Long.valueOf(this.b[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int hashCode() {
        int i;
        int i2;
        int i3;
        long l;
        i = 1;
        i2 = 0;
        while (i2 < this.c) {
            i4 += i3;
            i2++;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int indexOf(Object object) {
        int i;
        int cmp;
        long l;
        final int i2 = -1;
        if (!object instanceof Long) {
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
        int i3;
        int i2;
        b();
        i(i);
        final long[] lArr = this.b;
        i3 = this.c;
        if (i < i3 + -1) {
            System.arraycopy(lArr, i + 1, lArr, i, i4--);
        }
        this.c = obj6--;
        this.modCount = obj6++;
        return Long.valueOf(lArr[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    protected final void removeRange(int i, int i2) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object set(int i, Object object2) {
        b();
        i(i);
        final long[] obj6 = this.b;
        obj6[i] = (Long)object2.longValue();
        return Long.valueOf(obj6[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int size() {
        return this.c;
    }
}
