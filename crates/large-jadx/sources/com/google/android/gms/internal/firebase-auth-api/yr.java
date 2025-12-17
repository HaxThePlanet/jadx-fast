package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class yr extends com.google.android.gms.internal.firebase-auth-api.kq<Integer> implements RandomAccess, com.google.android.gms.internal.firebase-auth-api.d, com.google.android.gms.internal.firebase-auth-api.g0 {

    private static final com.google.android.gms.internal.firebase-auth-api.yr v;
    private int[] b;
    private int c;
    static {
        final int i = 0;
        yr yrVar = new yr(new int[i], i);
        yr.v = yrVar;
        yrVar.zzb();
    }

    yr() {
        super(new int[10], 0);
    }

    private yr(int[] iArr, int i2) {
        super();
        this.b = iArr;
        this.c = i2;
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

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final void add(int i, Object object2) {
        int iArr2;
        int i4;
        int[] iArr;
        int i2;
        int i3;
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
                    iArr2 = new int[i6++];
                    int i8 = 0;
                    System.arraycopy(iArr, i8, iArr2, i8, i);
                    System.arraycopy(this.b, i, iArr2, i + 1, i9 -= i);
                    this.b = iArr2;
                }
                this.b[i] = (Integer)object2.intValue();
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(h(i));
        throw obj6;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final boolean add(Object object) {
        g((Integer)object.intValue());
        return 1;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        int[] copyOf;
        b();
        e.e(collection);
        if (!collection instanceof yr) {
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

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final boolean contains(Object object) {
        if (indexOf(object) != -1) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final int d(int i) {
        i(i);
        return this.b[i];
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final boolean equals(Object object) {
        int i;
        int i2;
        int i3;
        final int i4 = 1;
        if (this == object) {
            return i4;
        }
        if (!object instanceof yr) {
            return super.equals(object);
        }
        final int i7 = 0;
        if (this.c != object.c) {
            return i7;
        }
        i = i7;
        while (i < this.c) {
            i++;
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final com.google.android.gms.internal.firebase-auth-api.d f(int i) {
        if (i < this.c) {
        } else {
            yr yrVar = new yr(Arrays.copyOf(this.b, i), this.c);
            return yrVar;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final void g(int i) {
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

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object get(int i) {
        i(i);
        return Integer.valueOf(this.b[i]);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final int hashCode() {
        int i2;
        int i3;
        int i;
        i2 = 1;
        i3 = 0;
        while (i3 < this.c) {
            i4 += i;
            i3++;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
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

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object remove(int i) {
        int i2;
        int i3;
        b();
        i(i);
        final int[] iArr = this.b;
        i2 = this.c;
        if (i < i2 + -1) {
            System.arraycopy(iArr, i + 1, iArr, i, i5--);
        }
        this.c = obj5--;
        this.modCount = obj5++;
        return Integer.valueOf(iArr[i]);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
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

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object set(int i, Object object2) {
        b();
        i(i);
        final int[] iArr = this.b;
        iArr[i] = (Integer)object2.intValue();
        return Integer.valueOf(iArr[i]);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final int size() {
        return this.c;
    }
}
