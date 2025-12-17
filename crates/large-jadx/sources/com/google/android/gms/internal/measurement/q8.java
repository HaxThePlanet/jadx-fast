package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class q8 extends com.google.android.gms.internal.measurement.l7<Float> implements RandomAccess, com.google.android.gms.internal.measurement.c9, com.google.android.gms.internal.measurement.fa {

    private static final com.google.android.gms.internal.measurement.q8 v;
    private float[] b;
    private int c;
    static {
        final int i = 0;
        q8 q8Var = new q8(new float[i], i);
        q8.v = q8Var;
        q8Var.zzb();
    }

    q8() {
        super(new float[10], 0);
    }

    private q8(float[] fArr, int i2) {
        super();
        this.b = fArr;
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
        int fArr2;
        int i2;
        float[] fArr;
        int i4;
        int i3;
        b();
        if (i < 0) {
        } else {
            i2 = this.c;
            if (i > i2) {
            } else {
                fArr = this.b;
                if (i2 < fArr.length) {
                    System.arraycopy(fArr, i, fArr, i + 1, i2 -= i);
                } else {
                    fArr2 = new float[i6++];
                    int i8 = 0;
                    System.arraycopy(fArr, i8, fArr2, i8, i);
                    System.arraycopy(this.b, i, fArr2, i + 1, i9 -= i);
                    this.b = fArr2;
                }
                this.b[i] = (Float)object2.floatValue();
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(g(i));
        throw obj6;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final boolean add(Object object) {
        d((Float)object.floatValue());
        return 1;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        float[] copyOf;
        b();
        d9.e(collection);
        if (!collection instanceof q8) {
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
    public final void d(float f) {
        int fArr;
        int i;
        b();
        int i2 = this.c;
        float[] fArr3 = this.b;
        if (i2 == fArr3.length) {
            fArr = new float[i6++];
            i = 0;
            System.arraycopy(fArr3, i, fArr, i, i2);
            this.b = fArr;
        }
        int i3 = this.c;
        this.c = i3 + 1;
        this.b[i3] = f;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final boolean equals(Object object) {
        int i;
        int floatToIntBits2;
        int floatToIntBits;
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        if (!object instanceof q8) {
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
            q8 q8Var = new q8(Arrays.copyOf(this.b, i), this.c);
            return q8Var;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object get(int i) {
        h(i);
        return Float.valueOf(this.b[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int hashCode() {
        int i;
        int i2;
        int floatToIntBits;
        i = 1;
        i2 = 0;
        while (i2 < this.c) {
            i3 += floatToIntBits;
            i2++;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int indexOf(Object object) {
        int i;
        int cmp;
        final int i3 = -1;
        if (!object instanceof Float) {
            return i3;
        }
        i = 0;
        while (i < this.c) {
            i++;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final Object remove(int i) {
        int i2;
        int i3;
        b();
        h(i);
        final float[] fArr = this.b;
        i2 = this.c;
        if (i < i2 + -1) {
            System.arraycopy(fArr, i + 1, fArr, i, i4--);
        }
        this.c = obj5--;
        this.modCount = obj5++;
        return Float.valueOf(fArr[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    protected final void removeRange(int i, int i2) {
        b();
        if (i2 < i) {
        } else {
            float[] fArr = this.b;
            System.arraycopy(fArr, i2, fArr, i, i5 -= i2);
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
        final float[] fArr = this.b;
        fArr[i] = (Float)object2.floatValue();
        return Float.valueOf(fArr[i]);
    }

    @Override // com.google.android.gms.internal.measurement.l7
    public final int size() {
        return this.c;
    }
}
