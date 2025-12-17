package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class x extends com.google.protobuf.c<Float> implements com.google.protobuf.c0.f, RandomAccess, com.google.protobuf.e1 {

    private static final com.google.protobuf.x v;
    private float[] b;
    private int c;
    static {
        final int i = 0;
        x xVar = new x(new float[i], i);
        x.v = xVar;
        xVar.F();
    }

    x() {
        super(new float[10], 0);
    }

    private x(float[] fArr, int i2) {
        super();
        this.b = fArr;
        this.c = i2;
    }

    private void i(int i, float f2) {
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
                this.b[i] = f2;
                this.c = obj5++;
                this.modCount = obj5++;
            }
        }
        IndexOutOfBoundsException obj6 = new IndexOutOfBoundsException(s(i));
        throw obj6;
    }

    public static com.google.protobuf.x l() {
        return x.v;
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
        d(i, (Float)object2);
    }

    @Override // com.google.protobuf.c
    public boolean add(Object object) {
        return g((Float)object);
    }

    public boolean addAll(Collection<? extends Float> collection) {
        float[] copyOf;
        b();
        c0.a(collection);
        if (!collection instanceof x) {
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
    public com.google.protobuf.c0.f c(int i) {
        if (i < this.c) {
        } else {
            x xVar = new x(Arrays.copyOf(this.b, i), this.c);
            return xVar;
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
    public void d(int i, Float float2) {
        i(i, float2.floatValue());
    }

    @Override // com.google.protobuf.c
    public boolean equals(Object object) {
        int i;
        int floatToIntBits;
        int floatToIntBits2;
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        if (!object instanceof x) {
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
    public boolean g(Float float) {
        h(float.floatValue());
        return 1;
    }

    @Override // com.google.protobuf.c
    public Object get(int i) {
        return p(i);
    }

    @Override // com.google.protobuf.c
    public void h(float f) {
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

    @Override // com.google.protobuf.c
    public int hashCode() {
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

    @Override // com.google.protobuf.c
    public int indexOf(Object object) {
        int i;
        int cmp;
        final int i2 = -1;
        if (!object instanceof Float) {
            return i2;
        }
        i = 0;
        while (i < size()) {
            i++;
        }
        return i2;
    }

    @Override // com.google.protobuf.c
    public Float p(int i) {
        return Float.valueOf(q(i));
    }

    @Override // com.google.protobuf.c
    public float q(int i) {
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
            float[] fArr = this.b;
            System.arraycopy(fArr, i2, fArr, i, i5 -= i2);
            this.c = i3 -= obj4;
            this.modCount = obj3++;
        }
        IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw obj3;
    }

    @Override // com.google.protobuf.c
    public Object set(int i, Object object2) {
        return u(i, (Float)object2);
    }

    @Override // com.google.protobuf.c
    public int size() {
        return this.c;
    }

    @Override // com.google.protobuf.c
    public Float t(int i) {
        int i2;
        int i3;
        b();
        m(i);
        final float[] fArr = this.b;
        i2 = this.c;
        if (i < i2 + -1) {
            System.arraycopy(fArr, i + 1, fArr, i, i4--);
        }
        this.c = obj5--;
        this.modCount = obj5++;
        return Float.valueOf(fArr[i]);
    }

    @Override // com.google.protobuf.c
    public Float u(int i, Float float2) {
        return Float.valueOf(v(i, float2.floatValue()));
    }

    @Override // com.google.protobuf.c
    public float v(int i, float f2) {
        b();
        m(i);
        final float[] fArr = this.b;
        fArr[i] = f2;
        return fArr[i];
    }
}
