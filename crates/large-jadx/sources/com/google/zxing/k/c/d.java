package com.google.zxing.k.c;

/* loaded from: classes2.dex */
final class d {
    static int a(com.google.zxing.k.c.b b) {
        return i2 += obj2;
    }

    private static int b(com.google.zxing.k.c.b b, boolean z2) {
        int i7;
        int i2;
        int i5;
        int i8;
        int i6;
        int i;
        int i3;
        int i4;
        byte b2;
        if (z2) {
            i7 = b.d();
        } else {
            i7 = b.e();
        }
        if (z2) {
            i2 = b.e();
        } else {
            i2 = b.d();
        }
        final byte[][] obj10 = b.c();
        final int i9 = 0;
        i8 = i5;
        while (i5 < i7) {
            i6 = -1;
            i3 = i;
            i4 = 5;
            while (i < i2) {
                if (z2) {
                } else {
                }
                b2 = obj10[i][i5];
                if (b2 == i6) {
                } else {
                }
                if (i3 >= i4) {
                }
                i3 = i10;
                i6 = b2;
                i++;
                i4 = 5;
                i8 += i3;
                i3++;
                b2 = obj10[i5][i];
            }
            if (i3 >= i4) {
            }
            i5++;
            i8 += i3;
            if (z2) {
            } else {
            }
            b2 = obj10[i][i5];
            if (b2 == i6) {
            } else {
            }
            if (i3 >= i4) {
            }
            i3 = i10;
            i6 = b2;
            i++;
            i8 += i3;
            i3++;
            b2 = obj10[i5][i];
        }
        return i8;
    }

    static int c(com.google.zxing.k.c.b b) {
        int i3;
        int i;
        byte[] bArr2;
        int i2;
        int i4;
        int i5;
        byte b2;
        byte[] bArr;
        final byte[][] arr = b.c();
        final int i7 = 0;
        i = i3;
        while (i3 < obj11 + -1) {
            bArr2 = arr[i3];
            i2 = i7;
            while (i2 < i6 + -1) {
                i4 = bArr2[i2];
                i5 = i2 + 1;
                b2 = i3 + 1;
                if (i4 == bArr2[i5] && i4 == arr[b2][i2] && i4 == arr[b2][i5]) {
                }
                i2 = i5;
                b2 = i3 + 1;
                if (i4 == arr[b2][i2]) {
                }
                if (i4 == arr[b2][i5]) {
                }
                i++;
            }
            i3++;
            i4 = bArr2[i2];
            i5 = i2 + 1;
            b2 = i3 + 1;
            if (i4 == bArr2[i5] && i4 == arr[b2][i2] && i4 == arr[b2][i5]) {
            }
            i2 = i5;
            b2 = i3 + 1;
            if (i4 == arr[b2][i2]) {
            }
            if (i4 == arr[b2][i5]) {
            }
            i++;
        }
        return i *= 3;
    }

    static int d(com.google.zxing.k.c.b b) {
        int i6;
        int i;
        int i5;
        int i3;
        byte[] bArr;
        int i2;
        int i4;
        byte b2;
        final byte[][] arr = b.c();
        final int i7 = b.e();
        final int obj10 = b.d();
        final int i8 = 0;
        i = i6;
        while (i6 < obj10) {
            i5 = i8;
            while (i5 < i7) {
                bArr = arr[i6];
                i2 = i5 + 6;
                i4 = 1;
                if (i2 < i7 && bArr[i5] == i4 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == i4 && bArr[i5 + 3] == i4 && bArr[i5 + 4] == i4 && bArr[i5 + 5] == 0 && bArr[i2] == i4) {
                }
                i3 = i6 + 6;
                if (i3 < obj10 && arr[i6][i5] == i4 && arr[i6 + 1][i5] == 0 && arr[i6 + 2][i5] == i4 && arr[i6 + 3][i5] == i4 && arr[i6 + 4][i5] == i4 && arr[i6 + 5][i5] == 0 && arr[i3][i5] == i4) {
                }
                i5++;
                if (arr[i6][i5] == i4) {
                }
                if (arr[i6 + 1][i5] == 0) {
                }
                if (arr[i6 + 2][i5] == i4) {
                }
                if (arr[i6 + 3][i5] == i4) {
                }
                if (arr[i6 + 4][i5] == i4) {
                }
                if (arr[i6 + 5][i5] == 0) {
                }
                if (arr[i3][i5] == i4) {
                }
                if (!d.h(arr, i5, i6 + -4, i6)) {
                } else {
                }
                i++;
                if (d.h(arr, i5, i6 + 7, i6 + 11)) {
                }
                if (bArr[i5] == i4) {
                }
                if (bArr[i5 + 1] == 0) {
                }
                if (bArr[i5 + 2] == i4) {
                }
                if (bArr[i5 + 3] == i4) {
                }
                if (bArr[i5 + 4] == i4) {
                }
                if (bArr[i5 + 5] == 0) {
                }
                if (bArr[i2] == i4) {
                }
                if (!d.g(bArr, i5 + -4, i5)) {
                } else {
                }
                i++;
                if (d.g(bArr, i5 + 7, i5 + 11)) {
                }
            }
            i6++;
            bArr = arr[i6];
            i2 = i5 + 6;
            i4 = 1;
            if (i2 < i7 && bArr[i5] == i4 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == i4 && bArr[i5 + 3] == i4 && bArr[i5 + 4] == i4 && bArr[i5 + 5] == 0 && bArr[i2] == i4) {
            }
            i3 = i6 + 6;
            if (i3 < obj10 && arr[i6][i5] == i4 && arr[i6 + 1][i5] == 0 && arr[i6 + 2][i5] == i4 && arr[i6 + 3][i5] == i4 && arr[i6 + 4][i5] == i4 && arr[i6 + 5][i5] == 0 && arr[i3][i5] == i4) {
            }
            i5++;
            if (arr[i6][i5] == i4) {
            }
            if (arr[i6 + 1][i5] == 0) {
            }
            if (arr[i6 + 2][i5] == i4) {
            }
            if (arr[i6 + 3][i5] == i4) {
            }
            if (arr[i6 + 4][i5] == i4) {
            }
            if (arr[i6 + 5][i5] == 0) {
            }
            if (arr[i3][i5] == i4) {
            }
            if (!d.h(arr, i5, i6 + -4, i6)) {
            } else {
            }
            i++;
            if (d.h(arr, i5, i6 + 7, i6 + 11)) {
            }
            if (bArr[i5] == i4) {
            }
            if (bArr[i5 + 1] == 0) {
            }
            if (bArr[i5 + 2] == i4) {
            }
            if (bArr[i5 + 3] == i4) {
            }
            if (bArr[i5 + 4] == i4) {
            }
            if (bArr[i5 + 5] == 0) {
            }
            if (bArr[i2] == i4) {
            }
            if (!d.g(bArr, i5 + -4, i5)) {
            } else {
            }
            i++;
            if (d.g(bArr, i5 + 7, i5 + 11)) {
            }
        }
        return i *= 40;
    }

    static int e(com.google.zxing.k.c.b b) {
        int i;
        int i2;
        int i3;
        byte[] bArr;
        int i4;
        byte b2;
        final int i9 = 0;
        i2 = i;
        while (i < b.d()) {
            i4 = i9;
            while (i4 < b.e()) {
                if (b.c()[i][i4] == 1) {
                }
                i4++;
                i2++;
            }
            i++;
            if (bArr[i4] == 1) {
            }
            i4++;
            i2++;
        }
        i5 *= obj10;
        return obj10 *= 10;
    }

    static boolean f(int i, int i2, int i3) {
        int obj1;
        int obj2;
        int obj3;
        final int i5 = 1;
        switch (i) {
            case 0:
                obj1 = obj3 & 1;
                return i5;
                return 0;
            case 1:
                obj1 = i2 % 3;
                return i5;
                return 0;
            case 2:
                obj1 = obj3 % 3;
                return i5;
                return 0;
            case 3:
                i3 /= 2;
                i2 /= 3;
                obj1 = obj3 & 1;
                return i5;
                return 0;
            case 4:
                i3 *= i2;
                obj1 += obj3;
                return i5;
                return 0;
            case 5:
                i3 *= i2;
                obj1 += obj3;
                break;
            case 6:
                obj1 += obj2;
                break;
            default:
                obj2 = new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i)));
                throw obj2;
        }
        obj1 &= i5;
    }

    private static boolean g(byte[] bArr, int i2, int i3) {
        int length;
        byte b;
        int obj4;
        final int i = 0;
        obj4 = Math.max(i2, i);
        length = 1;
        while (obj4 < Math.min(i3, bArr.length)) {
            obj4++;
            length = 1;
        }
        return length;
    }

    private static boolean h(byte[][] bArrArr, int i2, int i3, int i4) {
        int length;
        byte b;
        int obj5;
        final int i = 0;
        obj5 = Math.max(i3, i);
        length = 1;
        while (obj5 < Math.min(i4, bArrArr.length)) {
            obj5++;
            length = 1;
        }
        return length;
    }
}
