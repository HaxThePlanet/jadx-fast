package com.google.zxing.common.reedsolomon;

/* loaded from: classes2.dex */
final class b {

    private final com.google.zxing.common.reedsolomon.a a;
    private final int[] b;
    b(com.google.zxing.common.reedsolomon.a a, int[] i2Arr2) {
        int i2;
        int i4;
        int i;
        int i3;
        super();
        if (i2Arr2.length == 0) {
        } else {
            this.a = a;
            int obj5 = i2Arr2.length;
            int i5 = 1;
            i2 = 0;
            if (obj5 > i5 && i2Arr2[i2] == 0) {
                i2 = 0;
                if (i2Arr2[i2] == 0) {
                    i = i5;
                    while (i < obj5) {
                        if (i2Arr2[i] == 0) {
                        }
                        i++;
                    }
                    if (i == obj5) {
                        obj5 = new int[i5];
                        obj5[i2] = i2;
                        this.b = obj5;
                    }
                    obj5 = new int[obj5 -= i];
                    this.b = obj5;
                    System.arraycopy(i2Arr2, i, obj5, i2, obj5.length);
                }
            }
            this.b = i2Arr2;
        }
        obj5 = new IllegalArgumentException();
        throw obj5;
    }

    com.google.zxing.common.reedsolomon.b a(com.google.zxing.common.reedsolomon.b b) {
        int[] iArr2;
        int i3;
        int i;
        int i2;
        int[] iArr;
        int[] obj8;
        if (!this.a.equals(b.a)) {
        } else {
            if (f()) {
                return b;
            }
            if (b.f()) {
                return this;
            }
            iArr2 = this.b;
            obj8 = b.b;
            if (iArr2.length > obj8.length) {
            } else {
                iArr2 = obj8;
                obj8 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            length4 -= length5;
            int i5 = 0;
            System.arraycopy(iArr2, i5, iArr3, i5, i4);
            i3 = i4;
            for (int i2 : obj0) {
                iArr3[i3] = a.a(obj8[i3 - i4], i2);
            }
            obj8 = new b(this.a, iArr3);
            return obj8;
        }
        obj8 = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        throw obj8;
    }

    com.google.zxing.common.reedsolomon.b[] b(com.google.zxing.common.reedsolomon.b b) {
        com.google.zxing.common.reedsolomon.b bVar2;
        Object obj;
        com.google.zxing.common.reedsolomon.b bVar;
        int i;
        int i2;
        com.google.zxing.common.reedsolomon.b bVar3;
        com.google.zxing.common.reedsolomon.a aVar;
        if (!this.a.equals(b.a)) {
        } else {
            if (b.f()) {
            } else {
                bVar2 = this.a.e();
                obj = this;
                while (obj.e() >= b.e()) {
                    if (!obj.f()) {
                    }
                    i8 -= i11;
                    i2 = this.a.h(obj.c(obj.e()), this.a.f(b.c(b.e())));
                    bVar2 = bVar2.a(this.a.b(i9, i2));
                    obj = obj.a(b.h(i9, i2));
                }
                com.google.zxing.common.reedsolomon.b[] obj8 = new b[2];
                return obj8;
            }
            obj8 = new IllegalArgumentException("Divide by 0");
            throw obj8;
        }
        obj8 = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        throw obj8;
    }

    int c(int i) {
        final int[] iArr = this.b;
        return iArr[i2 -= i];
    }

    int[] d() {
        return this.b;
    }

    int e() {
        return length--;
    }

    boolean f() {
        final int i3 = 0;
        if (this.b[i3] == 0) {
            return 1;
        }
        return i3;
    }

    com.google.zxing.common.reedsolomon.b g(com.google.zxing.common.reedsolomon.b b) {
        boolean z;
        int i6;
        int i4;
        int i7;
        int i5;
        int i3;
        int i2;
        int i;
        if (!this.a.equals(b.a)) {
        } else {
            if (!f()) {
                if (b.f()) {
                } else {
                    int[] iArr = this.b;
                    int length = iArr.length;
                    int[] obj13 = b.b;
                    final int length2 = obj13.length;
                    int[] iArr2 = new int[i8--];
                    final int i10 = 0;
                    i6 = i10;
                    while (i6 < length) {
                        i7 = i10;
                        while (i7 < length2) {
                            i5 = i6 + i7;
                            iArr2[i5] = a.a(iArr2[i5], this.a.h(iArr[i6], obj13[i7]));
                            i7++;
                        }
                        i6++;
                        i5 = i6 + i7;
                        iArr2[i5] = a.a(iArr2[i5], this.a.h(i4, obj13[i7]));
                        i7++;
                    }
                }
                obj13 = new b(this.a, iArr2);
                return obj13;
            }
            return this.a.e();
        }
        obj13 = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        throw obj13;
    }

    com.google.zxing.common.reedsolomon.b h(int i, int i2) {
        int i4;
        int i5;
        int i3;
        if (i < 0) {
        } else {
            if (i2 == 0) {
                return this.a.e();
            }
            int length = iArr.length;
            int[] obj5 = new int[i += length];
            i4 = 0;
            while (i4 < length) {
                obj5[i4] = this.a.h(this.b[i4], i2);
                i4++;
            }
            b obj6 = new b(this.a, obj5);
            return obj6;
        }
        obj5 = new IllegalArgumentException();
        throw obj5;
    }

    public String toString() {
        int i2;
        int str;
        int i;
        String length;
        com.google.zxing.common.reedsolomon.a str2;
        StringBuilder stringBuilder = new StringBuilder(i3 *= 8);
        i2 = e();
        while (i2 >= 0) {
            str = c(i2);
            if (str != null) {
            }
            i2--;
            if (str < 0) {
            } else {
            }
            if (stringBuilder.length() > 0) {
            }
            i = 1;
            if (i2 != 0) {
            } else {
            }
            str = this.a.g(str);
            if (str == null) {
            } else {
            }
            if (str == i) {
            } else {
            }
            stringBuilder.append("a^");
            stringBuilder.append(str);
            if (i2 != 0) {
            }
            if (i2 == i) {
            } else {
            }
            stringBuilder.append("x^");
            stringBuilder.append(i2);
            stringBuilder.append('x');
            stringBuilder.append('a');
            stringBuilder.append('1');
            if (str != i) {
            }
            stringBuilder.append(" + ");
            stringBuilder.append(" - ");
            str = -str;
        }
        return stringBuilder.toString();
    }
}
