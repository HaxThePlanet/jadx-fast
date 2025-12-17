package kotlin.reflect.jvm.internal.impl.protobuf;

/* loaded from: classes3.dex */
final class v {
    private static int a(int i) {
        int obj1;
        if (i > -12) {
            obj1 = -1;
        }
        return obj1;
    }

    private static int b(int i, int i2) {
        int i3;
        int obj1;
        int obj2;
        if (i <= -12) {
            if (i2 > -65) {
                obj1 = -1;
            } else {
                i ^= obj2;
            }
        } else {
        }
        return obj1;
    }

    private static int c(int i, int i2, int i3) {
        int i4;
        int obj1;
        int obj2;
        i4 = -65;
        if (i <= -12 && i2 <= i4) {
            i4 = -65;
            if (i2 <= i4) {
                if (i3 > i4) {
                    obj1 = -1;
                } else {
                    obj1 ^= obj2;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static int d(byte[] bArr, int i2, int i3) {
        byte b = bArr[i2 + -1];
        i3 -= i2;
        final int i4 = 1;
        if (obj5 != null && obj5 != i4) {
            i4 = 1;
            if (obj5 != i4) {
                if (obj5 != 2) {
                } else {
                    return v.c(b, bArr[i2], bArr[i2 += i4]);
                }
                AssertionError obj3 = new AssertionError();
                throw obj3;
            }
            return v.b(b, bArr[i2]);
        }
        return v.a(b);
    }

    public static boolean e(byte[] bArr) {
        return v.f(bArr, 0, bArr.length);
    }

    public static boolean f(byte[] bArr, int i2, int i3) {
        int obj0;
        obj0 = v.h(bArr, i2, i3) == 0 ? 1 : 0;
        return obj0;
    }

    public static int g(int i, byte[] b2Arr2, int i3, int i4) {
        byte b;
        byte i5;
        int i7;
        int i2;
        int i6;
        byte b2;
        int obj6;
        int obj8;
        if (i != 0 && i3 >= i4) {
            if (i3 >= i4) {
                return i;
            }
            b = (byte)i;
            i5 = -32;
            i7 = -1;
            i2 = -65;
            obj6 = i3 + 1;
            if (b < i5 && b >= -62 && b2Arr2[i3] > i2) {
                if (b >= -62) {
                    obj6 = i3 + 1;
                    if (b2Arr2[i3] > i2) {
                    }
                    obj8 = obj6;
                }
                return i7;
            }
            if (b < -16) {
            }
            i6 = 0;
            if ((byte)i9 == 0) {
                obj6 = i3 + 1;
                if (obj6 >= i4) {
                    return v.b(b, b2Arr2[i3]);
                }
                obj8 = obj6;
            } else {
                i6 = (byte)obj6;
            }
            obj6 = obj8 + 1;
            if (i6 == 0 && obj6 >= i4) {
                obj6 = obj8 + 1;
                if (obj6 >= i4) {
                    return v.c(b, i5, b2Arr2[obj8]);
                }
                obj8 = obj6;
            }
            if (i5 <= i2) {
            }
            return i7;
        }
        return v.h(b2Arr2, obj8, i4);
    }

    public static int h(byte[] bArr, int i2, int i3) {
        byte b;
        int obj1;
        while (i2 < i3) {
            if (bArr[i2] >= 0) {
            }
            i2++;
        }
        if (i2 >= i3) {
            obj1 = 0;
        } else {
            obj1 = v.i(bArr, i2, i3);
        }
        return obj1;
    }

    private static int i(byte[] bArr, int i2, int i3) {
        byte b;
        int i5;
        int i4;
        int i7;
        int i;
        int i6;
        int obj7;
        while (obj7 >= i3) {
            b = obj7 + 1;
            obj7 = bArr[obj7];
            obj7 = b;
            i5 = -32;
            i4 = -1;
            i7 = -65;
            i5 = b + 1;
            b = bArr[b];
            obj7 = i5 + 1;
            b = obj7 + 1;
            i = b + 1;
            b = bArr[b];
            i6 = -96;
            obj7 = i + 1;
            obj7 = b + 1;
        }
        return 0;
    }
}
