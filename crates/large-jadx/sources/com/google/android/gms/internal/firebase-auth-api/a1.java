package com.google.android.gms.internal.firebase-auth-api;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a1 {

    private static final com.google.android.gms.internal.firebase-auth-api.a1 f;
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;
    static {
        final int i = 0;
        a1 a1Var = new a1(i, new int[i], new Object[i], i);
        a1.f = a1Var;
    }

    private a1() {
        int i = 8;
        super(0, new int[i], new Object[i], 1);
    }

    private a1(int i, int[] i2Arr2, Object[] object3Arr3, boolean z4) {
        super();
        this.d = -1;
        this.a = i;
        this.b = i2Arr2;
        this.c = object3Arr3;
        this.e = z4;
    }

    public static com.google.android.gms.internal.firebase-auth-api.a1 c() {
        return a1.f;
    }

    static com.google.android.gms.internal.firebase-auth-api.a1 d(com.google.android.gms.internal.firebase-auth-api.a1 a1, com.google.android.gms.internal.firebase-auth-api.a1 a12) {
        i += i3;
        int[] copyOf = Arrays.copyOf(a1.b, i2);
        final int i6 = 0;
        System.arraycopy(a12.b, i6, copyOf, a1.a, a12.a);
        Object[] copyOf2 = Arrays.copyOf(a1.c, i2);
        System.arraycopy(a12.c, i6, copyOf2, a1.a, a12.a);
        a1 obj6 = new a1(i2, copyOf, copyOf2, 1);
        return obj6;
    }

    static com.google.android.gms.internal.firebase-auth-api.a1 e() {
        int i = 8;
        a1 a1Var = new a1(0, new int[i], new Object[i], 1);
        return a1Var;
    }

    public final int a() {
        int i5;
        int i4;
        int i2;
        int i;
        int i3;
        int longValue;
        int i6 = this.d;
        if (i6 == -1) {
            i4 = i5;
            while (i5 < this.a) {
                int i9 = this.b[i5];
                i3 = i9 >>> 3;
                i9 &= 7;
                i = gr.f(i3 << 3);
                i3 = gr.g((Long)this.c[i5].longValue());
                i += i3;
                i4 += i2;
                i5++;
                (Long)this.c[i5].longValue();
                i12 += 8;
                i2 = (wq)this.c[i5].g();
                i4 += i3;
                int i15 = gr.e(i3);
                i15 += i15;
                i3 = (a1)this.c[i5].a();
                (Integer)this.c[i5].intValue();
                i14 += 4;
            }
            this.d = i4;
            return i4;
        }
        return i6;
    }

    public final int b() {
        int i5;
        int i;
        int i6;
        int i2;
        int i4;
        int i3;
        int i7 = this.d;
        if (i7 == -1) {
            i = i5;
            while (i5 < this.a) {
                int i16 = gr.f(8);
                i2 = (wq)this.c[i5].g();
                i += i4;
                i5++;
            }
            this.d = i;
            return i;
        }
        return i7;
    }

    public final boolean equals(Object object) {
        int i;
        int i4;
        int[] iArr;
        int equals;
        int i3;
        int i2;
        Object obj9;
        final int i5 = 1;
        if (this == object) {
            return i5;
        }
        final int i6 = 0;
        if (object == null) {
            return i6;
        }
        if (!object instanceof a1) {
            return i6;
        }
        i = this.a;
        if (i == object.a) {
            equals = i6;
            while (equals < i) {
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
            b0.b(stringBuilder, i2, String.valueOf(i4 >>>= 3), this.c[i]);
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
        int i5;
        int i4;
        int i;
        int i3;
        int i2;
        int i6 = this.a;
        i = i5;
        i3 = i4;
        while (i < i6) {
            i14 += i2;
            i++;
        }
        while (i5 < this.a) {
            i13 += i;
            i5++;
        }
        return i10 += i4;
    }

    public final void i(com.google.android.gms.internal.firebase-auth-api.hr hr) {
        int i;
        long longValue;
        Object obj;
        int i3;
        int i2;
        if (this.a != 0) {
            i = 0;
            while (i < this.a) {
                int i4 = this.b[i];
                obj = this.c[i];
                i3 = i4 >>> 3;
                i4 &= 7;
                hr.E(i3, (Long)obj.longValue());
                i++;
                hr.x(i3, (Long)obj.longValue());
                hr.o(i3, (wq)obj);
                hr.e(i3);
                (a1)obj.i(hr);
                hr.s(i3);
                hr.v(i3, (Integer)obj.intValue());
            }
        }
    }
}
