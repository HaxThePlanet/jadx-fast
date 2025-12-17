package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class oq extends com.google.android.gms.internal.firebase-auth-api.kq<Boolean> implements RandomAccess, com.google.android.gms.internal.firebase-auth-api.d, com.google.android.gms.internal.firebase-auth-api.g0 {

    private static final com.google.android.gms.internal.firebase-auth-api.oq v;
    private boolean[] b;
    private int c;
    static {
        final int i = 0;
        oq oqVar = new oq(new boolean[i], i);
        oq.v = oqVar;
        oqVar.zzb();
    }

    oq() {
        super(new boolean[10], 0);
    }

    private oq(boolean[] zArr, int i2) {
        super();
        this.b = zArr;
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

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final void add(int i, Object object2) {
        int zArr2;
        int i2;
        boolean[] zArr;
        int i3;
        int i4;
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
                this.b[i] = (Boolean)object2.booleanValue();
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(g(i));
        throw obj6;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final boolean add(Object object) {
        d((Boolean)object.booleanValue());
        return 1;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        boolean[] copyOf;
        b();
        e.e(collection);
        if (!collection instanceof oq) {
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
    public final void d(boolean z) {
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

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final boolean equals(Object object) {
        int i2;
        int i;
        boolean z;
        final int i3 = 1;
        if (this == object) {
            return i3;
        }
        if (!object instanceof oq) {
            return super.equals(object);
        }
        final int i6 = 0;
        if (this.c != object.c) {
            return i6;
        }
        i2 = i6;
        while (i2 < this.c) {
            i2++;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final com.google.android.gms.internal.firebase-auth-api.d f(int i) {
        if (i < this.c) {
        } else {
            oq oqVar = new oq(Arrays.copyOf(this.b, i), this.c);
            return oqVar;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object get(int i) {
        h(i);
        return Boolean.valueOf(this.b[i]);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final int hashCode() {
        int i3;
        int i;
        int i2;
        i3 = 1;
        i = 0;
        while (i < this.c) {
            i4 += i2;
            i++;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final int indexOf(Object object) {
        int i;
        boolean z;
        final int i3 = -1;
        if (!object instanceof Boolean) {
            return i3;
        }
        i = 0;
        while (i < this.c) {
            i++;
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object remove(int i) {
        int i2;
        int i3;
        b();
        h(i);
        final boolean[] zArr = this.b;
        i2 = this.c;
        if (i < i2 + -1) {
            System.arraycopy(zArr, i + 1, zArr, i, i4--);
        }
        this.c = obj5--;
        this.modCount = obj5++;
        return Boolean.valueOf(zArr[i]);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    protected final void removeRange(int i, int i2) {
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

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final Object set(int i, Object object2) {
        b();
        h(i);
        final boolean[] zArr = this.b;
        zArr[i] = (Boolean)object2.booleanValue();
        return Boolean.valueOf(zArr[i]);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.kq
    public final int size() {
        return this.c;
    }
}
