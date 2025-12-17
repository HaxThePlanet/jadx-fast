package com.google.zxing.g;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b implements java.lang.Cloneable {

    private final int a;
    private final int b;
    private final int c;
    private final int[] v;
    public b(int i) {
        super(i, i);
    }

    public b(int i, int i2) {
        super();
        if (i <= 0) {
        } else {
            if (i2 <= 0) {
            } else {
                this.a = i;
                this.b = i2;
                obj1 /= 32;
                this.c = obj1;
                this.v = new int[obj1 *= i2];
            }
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Both dimensions must be greater than 0");
        throw obj1;
    }

    private b(int i, int i2, int i3, int[] i4Arr4) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.v = i4Arr4;
    }

    private String a(String string, String string2, String string3) {
        int i;
        int i2;
        int i3;
        StringBuilder stringBuilder = new StringBuilder(i4 *= i8);
        int i6 = 0;
        i = i6;
        while (i < this.b) {
            i2 = i6;
            while (i2 < this.a) {
                if (d(i2, i)) {
                } else {
                }
                i3 = string2;
                stringBuilder.append(i3);
                i2++;
                i3 = string;
            }
            stringBuilder.append(string3);
            i++;
            if (d(i2, i)) {
            } else {
            }
            i3 = string2;
            stringBuilder.append(i3);
            i2++;
            i3 = string;
        }
        return stringBuilder.toString();
    }

    @Override // java.lang.Cloneable
    public void b() {
        int i;
        int[] iArr;
        final int i2 = 0;
        i = i2;
        while (i < iArr2.length) {
            this.v[i] = i2;
            i++;
        }
    }

    @Override // java.lang.Cloneable
    public com.google.zxing.g.b c() {
        b bVar = new b(this.a, this.b, this.c, (int[])this.v.clone());
        return bVar;
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return c();
    }

    @Override // java.lang.Cloneable
    public boolean d(int i, int i2) {
        int obj3 = 1;
        if (obj2 &= obj3 != 0) {
            return obj3;
        }
        return 0;
    }

    @Override // java.lang.Cloneable
    public int e() {
        return this.b;
    }

    @Override // java.lang.Cloneable
    public boolean equals(Object object) {
        int i;
        int i2;
        Object obj4;
        final int i3 = 0;
        if (!object instanceof b) {
            return i3;
        }
        if (this.a == object.a && this.b == object.b && this.c == object.c && Arrays.equals(this.v, object.v)) {
            if (this.b == object.b) {
                if (this.c == object.c) {
                    if (Arrays.equals(this.v, object.v)) {
                        return 1;
                    }
                }
            }
        }
        return i3;
    }

    @Override // java.lang.Cloneable
    public int f() {
        return this.a;
    }

    @Override // java.lang.Cloneable
    public void g(int i, int i2) {
        obj5 += i4;
        int[] iArr = this.v;
        iArr[obj5] = obj4 |= i5;
    }

    @Override // java.lang.Cloneable
    public void h(int i, int i2, int i3, int i4) {
        int i9;
        int i7;
        int[] iArr;
        int i6;
        int i8;
        int i10;
        int i5;
        int obj9;
        if (i2 < 0) {
        } else {
            if (i < 0) {
            } else {
                if (i4 <= 0) {
                } else {
                    if (i3 <= 0) {
                    } else {
                        i3 += i;
                        i4 += i2;
                        if (obj11 > this.b) {
                        } else {
                            if (obj10 > this.a) {
                            }
                        }
                        IllegalArgumentException obj8 = new IllegalArgumentException("The region must fit inside the matrix");
                        throw obj8;
                    }
                }
                obj8 = new IllegalArgumentException("Height and width must be at least 1");
                throw obj8;
            }
        }
        obj8 = new IllegalArgumentException("Left and top must be nonnegative");
        throw obj8;
    }

    @Override // java.lang.Cloneable
    public int hashCode() {
        int i = this.a;
        return i11 += i4;
    }

    @Override // java.lang.Cloneable
    public String j(String string, String string2) {
        return a(string, string2, "\n");
    }

    @Override // java.lang.Cloneable
    public String toString() {
        return j("X ", "  ");
    }
}
