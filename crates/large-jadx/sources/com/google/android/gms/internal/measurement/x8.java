package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class x8 extends com.google.android.gms.internal.measurement.l7<Integer> implements RandomAccess, com.google.android.gms.internal.measurement.a9, com.google.android.gms.internal.measurement.fa {

    private static final com.google.android.gms.internal.measurement.x8 v;
    private int[] b;
    private int c;
    static {
        final int i = 0;
        x8 x8Var = new x8(new int[i], i);
        x8.v = x8Var;
        x8Var.zzb();
    }

    x8() {
        super(new int[10], 0);
    }

    private x8(int[] iArr, int i2) {
        super();
        this.b = iArr;
        this.c = i2;
    }

    public static com.google.android.gms.internal.measurement.x8 g() {
        return x8.v;
    }

    private final String i(int i) {
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append("Index:");
        stringBuilder.append(i);
        stringBuilder.append(", Size:");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    private final void l(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= this.c) {
            } else {
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(i(i));
        throw indexOutOfBoundsException;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final com.google.android.gms.internal.measurement.a9 M1(int i) {
        if (i < this.c) {
        } else {
            x8 x8Var = new x8(Arrays.copyOf(this.b, i), this.c);
            return x8Var;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final void add(int i, Object object2) {
        int iArr;
        int i3;
        int[] iArr2;
        int i4;
        int i2;
        b();
        if (i < 0) {
        } else {
            i3 = this.c;
            if (i > i3) {
            } else {
                iArr2 = this.b;
                if (i3 < iArr2.length) {
                    System.arraycopy(iArr2, i, iArr2, i + 1, i3 -= i);
                } else {
                    iArr = new int[i6++];
                    int i8 = 0;
                    System.arraycopy(iArr2, i8, iArr, i8, i);
                    System.arraycopy(this.b, i, iArr, i + 1, i9 -= i);
                    this.b = iArr;
                }
                this.b[i] = (Integer)object2.intValue();
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(i(i));
        throw obj6;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final boolean add(Object object) {
        h((Integer)object.intValue());
        return 1;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        int[] copyOf;
        b();
        d9.e(collection);
        if (!collection instanceof x8) {
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
    public final int d(int i) {
        l(i);
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final boolean equals(Object object) {
        int i3;
        int i;
        int i2;
        final int i4 = 1;
        if (this == object) {
            return i4;
        }
        if (!object instanceof x8) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    public final com.google.android.gms.internal.measurement.c9 f(int i) {
        return M1(i);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object get(int i) {
        l(i);
        return Integer.valueOf(this.b[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final void h(int i) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    public final int hashCode() {
        int i2;
        int i;
        int i3;
        i2 = 1;
        i = 0;
        while (i < this.c) {
            i4 += i3;
            i++;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int indexOf(Object object) {
        int i;
        int i2;
        final int i4 = -1;
        if (!object instanceof Integer) {
            return i4;
        }
        i = 0;
        while (i < this.c) {
            i++;
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object remove(int i) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    protected final void removeRange(int i, int i2) {
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

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object set(int i, Object object2) {
        b();
        l(i);
        final int[] iArr = this.b;
        iArr[i] = (Integer)object2.intValue();
        return Integer.valueOf(iArr[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int size() {
        return this.c;
    }
}
