package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class ya {

    private static final com.google.android.gms.internal.measurement.ya f;
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;
    static {
        final int i = 0;
        ya yaVar = new ya(i, new int[i], new Object[i], i);
        ya.f = yaVar;
    }

    private ya() {
        int i = 8;
        super(0, new int[i], new Object[i], 1);
    }

    private ya(int i, int[] i2Arr2, Object[] object3Arr3, boolean z4) {
        super();
        this.d = -1;
        this.a = i;
        this.b = i2Arr2;
        this.c = object3Arr3;
        this.e = z4;
    }

    public static com.google.android.gms.internal.measurement.ya c() {
        return ya.f;
    }

    static com.google.android.gms.internal.measurement.ya d(com.google.android.gms.internal.measurement.ya ya, com.google.android.gms.internal.measurement.ya ya2) {
        i += i3;
        int[] copyOf = Arrays.copyOf(ya.b, i2);
        final int i6 = 0;
        System.arraycopy(ya2.b, i6, copyOf, ya.a, ya2.a);
        Object[] copyOf2 = Arrays.copyOf(ya.c, i2);
        System.arraycopy(ya2.c, i6, copyOf2, ya.a, ya2.a);
        ya obj6 = new ya(i2, copyOf, copyOf2, 1);
        return obj6;
    }

    static com.google.android.gms.internal.measurement.ya e() {
        int i = 8;
        ya yaVar = new ya(0, new int[i], new Object[i], 1);
        return yaVar;
    }

    public final int a() {
        int i4;
        int i;
        int i5;
        int i2;
        int i3;
        int longValue;
        int i6 = this.d;
        if (i6 == -1) {
            i = i4;
            while (i4 < this.a) {
                int i9 = this.b[i4];
                i3 = i9 >>> 3;
                i9 &= 7;
                i2 = e8.a(i3 << 3);
                i3 = e8.b((Long)this.c[i4].longValue());
                i2 += i3;
                i += i5;
                i4++;
                (Long)this.c[i4].longValue();
                i12 += 8;
                i5 = (x7)this.c[i4].g();
                i += i3;
                int i15 = e8.D(i3);
                i15 += i15;
                i3 = (ya)this.c[i4].a();
                (Integer)this.c[i4].intValue();
                i14 += 4;
            }
            this.d = i;
            return i;
        }
        return i6;
    }

    public final int b() {
        int i3;
        int i5;
        int i2;
        int i;
        int i6;
        int i4;
        int i7 = this.d;
        if (i7 == -1) {
            i5 = i3;
            while (i3 < this.a) {
                int i16 = e8.a(8);
                i = (x7)this.c[i3].g();
                i5 += i6;
                i3++;
            }
            this.d = i5;
            return i5;
        }
        return i7;
    }

    public final boolean equals(Object object) {
        int i2;
        int i4;
        int[] iArr;
        int equals;
        int i3;
        int i;
        Object obj9;
        final int i5 = 1;
        if (this == object) {
            return i5;
        }
        final int i6 = 0;
        if (object == null) {
            return i6;
        }
        if (!object instanceof ya) {
            return i6;
        }
        i2 = this.a;
        if (i2 == object.a) {
            equals = i6;
            while (equals < i2) {
                equals++;
            }
            iArr = i6;
            while (iArr < this.a) {
                iArr++;
            }
            return i5;
        }
        return i6;
    }

    public final void f() {
        this.e = false;
    }

    final void g(StringBuilder stringBuilder, int i2) {
        int i;
        String valueOf;
        Object obj;
        i = 0;
        while (i < this.a) {
            aa.b(stringBuilder, i2, String.valueOf(i4 >>>= 3), this.c[i]);
            i++;
        }
    }

    final void h(int i, Object object2) {
        int copyOf;
        int[] iArr;
        int length;
        if (!this.e) {
        } else {
            copyOf = this.a;
            iArr = this.b;
            if (copyOf == iArr.length) {
                length = copyOf < 4 ? 8 : copyOf >> 1;
                copyOf += length;
                this.b = Arrays.copyOf(iArr, i2);
                this.c = Arrays.copyOf(this.c, i2);
            }
            int i3 = this.a;
            this.b[i3] = i;
            this.c[i3] = object2;
            this.a = i3++;
        }
        UnsupportedOperationException obj4 = new UnsupportedOperationException();
        throw obj4;
    }

    public final int hashCode() {
        int i3;
        int i5;
        int i2;
        int i;
        int i4;
        int i6 = this.a;
        i2 = i3;
        i = i5;
        while (i2 < i6) {
            i14 += i4;
            i2++;
        }
        while (i3 < this.a) {
            i13 += i2;
            i3++;
        }
        return i10 += i5;
    }

    public final void i(com.google.android.gms.internal.measurement.f8 f8) {
        int i3;
        long longValue;
        Object obj;
        int i;
        int i2;
        if (this.a != 0) {
            i3 = 0;
            while (i3 < this.a) {
                int i4 = this.b[i3];
                obj = this.c[i3];
                i = i4 >>> 3;
                i4 &= 7;
                f8.E(i, (Long)obj.longValue());
                i3++;
                f8.x(i, (Long)obj.longValue());
                f8.o(i, (x7)obj);
                f8.e(i);
                (ya)obj.i(f8);
                f8.s(i);
                f8.v(i, (Integer)obj.intValue());
            }
        }
    }
}
