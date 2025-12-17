package com.google.protobuf;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class x1 {

    private static final com.google.protobuf.x1.b a;

    private static class a {
        static void a(byte b, byte b2, byte b3, byte b4, char[] c5Arr5, int i6) {
            x1.a.h(b, b2, b3, b4, c5Arr5, i6);
        }

        static boolean b(byte b) {
            return x1.a.n(b);
        }

        static void c(byte b, char[] c2Arr2, int i3) {
            x1.a.i(b, c2Arr2, i3);
        }

        static boolean d(byte b) {
            return x1.a.p(b);
        }

        static void e(byte b, byte b2, char[] c3Arr3, int i4) {
            x1.a.k(b, b2, c3Arr3, i4);
        }

        static boolean f(byte b) {
            return x1.a.o(b);
        }

        static void g(byte b, byte b2, byte b3, char[] c4Arr4, int i5) {
            x1.a.j(b, b2, b3, c4Arr4, i5);
        }

        private static void h(byte b, byte b2, byte b3, byte b4, char[] c5Arr5, int i6) {
            boolean z;
            int i;
            if (x1.a.m(b2)) {
            } else {
                if (i3 >>= 30 != 0) {
                } else {
                    if (x1.a.m(b3)) {
                    } else {
                        if (x1.a.m(b4)) {
                        } else {
                            obj2 |= obj3;
                            c5Arr5[i6] = x1.a.l(obj2);
                            c5Arr5[i6++] = x1.a.q(obj2);
                        }
                    }
                }
            }
            throw InvalidProtocolBufferException.d();
        }

        private static void i(byte b, char[] c2Arr2, int i3) {
            c2Arr2[i3] = (char)b;
        }

        private static void j(byte b, byte b2, byte b3, char[] c4Arr4, int i5) {
            boolean z;
            int i;
            if (x1.a.m(b2)) {
            } else {
                i = -96;
                if (b == -32 && b2 >= i) {
                    if (b2 < i) {
                    } else {
                        if (b == -19 && b2 < i) {
                            if (b2 >= i) {
                            } else {
                                if (x1.a.m(b3)) {
                                } else {
                                    c4Arr4[i5] = (char)obj2;
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
            throw InvalidProtocolBufferException.d();
        }

        private static void k(byte b, byte b2, char[] c3Arr3, int i4) {
            int i;
            if (b < -62) {
            } else {
                if (x1.a.m(b2)) {
                } else {
                    c3Arr3[i4] = (char)obj1;
                }
            }
            throw InvalidProtocolBufferException.d();
        }

        private static char l(int i) {
            return (char)obj1;
        }

        private static boolean m(byte b) {
            int obj1;
            obj1 = b > -65 ? 1 : 0;
            return obj1;
        }

        private static boolean n(byte b) {
            int obj0;
            obj0 = b >= 0 ? 1 : 0;
            return obj0;
        }

        private static boolean o(byte b) {
            int obj1;
            obj1 = b < -16 ? 1 : 0;
            return obj1;
        }

        private static boolean p(byte b) {
            int obj1;
            obj1 = b < -32 ? 1 : 0;
            return obj1;
        }

        private static char q(int i) {
            return (char)obj1;
        }

        private static int r(byte b) {
            return b &= 63;
        }
    }

    static abstract class b {
        private static int j(ByteBuffer byteBuffer, int i2, int i3) {
            int i;
            int i5;
            int i4;
            int i7;
            int i6;
            int i8;
            int obj7;
            i2 += i;
            while (obj7 >= i3) {
                i = obj7 + 1;
                obj7 = byteBuffer.get(obj7);
                obj7 = i;
                i5 = -32;
                i4 = -1;
                i7 = -65;
                i5 = i + 1;
                i = byteBuffer.get(i);
                obj7 = i5 + 1;
                i = obj7 + 1;
                int i11 = i + 1;
                i = byteBuffer.get(i);
                i8 = -96;
                obj7 = i6;
                i++;
            }
            return 0;
        }

        final String a(ByteBuffer byteBuffer, int i2, int i3) {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), arrayOffset += i2, i3);
            }
            if (byteBuffer.isDirect()) {
                return d(byteBuffer, i2, i3);
            }
            return c(byteBuffer, i2, i3);
        }

        abstract String b(byte[] bArr, int i2, int i3);

        final String c(ByteBuffer byteBuffer, int i2, int i3) {
            int i6;
            byte b;
            int i;
            int i5;
            char[] cArr;
            int i4;
            int i7;
            int i8;
            int obj13;
            int i14 = 0;
            final int i15 = 1;
            if (i9 |= i13 < 0) {
            } else {
                int i11 = i2 + i3;
                final char[] obj14 = new char[i3];
                i6 = i14;
                while (obj13 < i11) {
                    b = byteBuffer.get(obj13);
                    if (!x1.a.b(b)) {
                        break;
                    } else {
                    }
                    obj13++;
                    x1.a.c(b, obj14, i6);
                    i6 = i;
                }
                i4 = i6;
                while (obj13 < i11) {
                    i6 = obj13 + 1;
                    obj13 = byteBuffer.get(obj13);
                    int i21 = i6 + 1;
                    int i16 = i21 + 1;
                    x1.a.a(obj13, byteBuffer.get(i6), byteBuffer.get(i21), byteBuffer.get(i16), obj14, i4);
                    obj13 = i7;
                    i4 = i8;
                    int i19 = i6 + 1;
                    x1.a.g(obj13, byteBuffer.get(i6), byteBuffer.get(i19), obj14, i4);
                    obj13 = i;
                    i4 = i5;
                    x1.a.e(obj13, byteBuffer.get(i6), obj14, i4);
                    obj13 = b;
                    i4 = i;
                    b = i4 + 1;
                    x1.a.c(obj13, obj14, i4);
                    while (i6 < i11) {
                        obj13 = byteBuffer.get(i6);
                        if (!x1.a.b(obj13)) {
                            break loop_10;
                        } else {
                        }
                        i6++;
                        x1.a.c(obj13, obj14, b);
                        b = i;
                    }
                    obj13 = i6;
                    i4 = b;
                    obj13 = byteBuffer.get(i6);
                    if (!x1.a.b(obj13)) {
                    } else {
                    }
                    i6++;
                    x1.a.c(obj13, obj14, b);
                    b = i;
                }
                String obj12 = new String(obj14, i14, i4);
                return obj12;
            }
            Object[] arr = new Object[3];
            arr[i14] = Integer.valueOf(byteBuffer.limit());
            arr[i15] = Integer.valueOf(i2);
            arr[2] = Integer.valueOf(i3);
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", arr));
            throw arrayIndexOutOfBoundsException;
        }

        abstract String d(ByteBuffer byteBuffer, int i2, int i3);

        abstract int e(java.lang.CharSequence charSequence, byte[] b2Arr2, int i3, int i4);

        final boolean f(ByteBuffer byteBuffer, int i2, int i3) {
            int i;
            if (h(0, byteBuffer, i2, i3) == 0) {
                i = 1;
            }
            return i;
        }

        final boolean g(byte[] bArr, int i2, int i3) {
            int i;
            if (i(0, bArr, i2, i3) == 0) {
                i = 1;
            }
            return i;
        }

        final int h(int i, ByteBuffer byteBuffer2, int i3, int i4) {
            if (byteBuffer2.hasArray()) {
                int arrayOffset = byteBuffer2.arrayOffset();
                return i(i, byteBuffer2.array(), i3 += arrayOffset, arrayOffset += i4);
            }
            if (byteBuffer2.isDirect()) {
                return l(i, byteBuffer2, i3, i4);
            }
            return k(i, byteBuffer2, i3, i4);
        }

        abstract int i(int i, byte[] b2Arr2, int i3, int i4);

        final int k(int i, ByteBuffer byteBuffer2, int i3, int i4) {
            byte b2;
            byte i2;
            int i7;
            int i5;
            int i6;
            byte b;
            int obj7;
            int obj9;
            if (i != 0 && i3 >= i4) {
                if (i3 >= i4) {
                    return i;
                }
                b2 = (byte)i;
                i2 = -32;
                i7 = -1;
                i5 = -65;
                obj7 = i3 + 1;
                if (b2 < i2 && b2 >= -62 && byteBuffer2.get(i3) > i5) {
                    if (b2 >= -62) {
                        obj7 = i3 + 1;
                        if (byteBuffer2.get(i3) > i5) {
                        }
                        obj9 = obj7;
                    }
                    return i7;
                }
                if (b2 < -16) {
                }
                i6 = 0;
                if ((byte)i9 == 0) {
                    obj7 = i3 + 1;
                    if (obj7 >= i4) {
                        return x1.a(b2, byteBuffer2.get(i3));
                    }
                    obj9 = obj7;
                } else {
                    i6 = (byte)obj7;
                }
                obj7 = obj9 + 1;
                if (i6 == 0 && obj7 >= i4) {
                    obj7 = obj9 + 1;
                    if (obj7 >= i4) {
                        return x1.b(b2, i2, byteBuffer2.get(obj9));
                    }
                    obj9 = obj7;
                }
                if (i2 <= i5) {
                }
                return i7;
            }
            return x1.b.j(byteBuffer2, obj9, i4);
        }

        abstract int l(int i, ByteBuffer byteBuffer2, int i3, int i4);
    }

    static class d extends java.lang.IllegalArgumentException {
        d(int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unpaired surrogate at index ");
            stringBuilder.append(i);
            stringBuilder.append(" of ");
            stringBuilder.append(i2);
            super(stringBuilder.toString());
        }
    }

    static final class c extends com.google.protobuf.x1.b {
        private static int m(byte[] bArr, int i2, int i3) {
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
                obj1 = x1.c.n(bArr, i2, i3);
            }
            return obj1;
        }

        private static int n(byte[] bArr, int i2, int i3) {
            byte b;
            int i;
            int i6;
            int i4;
            int i5;
            int i7;
            int obj7;
            while (obj7 >= i3) {
                b = obj7 + 1;
                obj7 = bArr[obj7];
                obj7 = b;
                i = -32;
                i6 = -1;
                i4 = -65;
                i = b + 1;
                b = bArr[b];
                obj7 = i + 1;
                b = obj7 + 1;
                i5 = b + 1;
                b = bArr[b];
                i7 = -96;
                obj7 = i5 + 1;
                obj7 = b + 1;
            }
            return 0;
        }

        @Override // com.google.protobuf.x1$b
        String b(byte[] bArr, int i2, int i3) {
            int i;
            byte b;
            int i6;
            int i4;
            char[] cArr;
            int i7;
            int i8;
            int i5;
            int obj13;
            int i14 = 0;
            final int i15 = 1;
            if (i9 |= i13 < 0) {
            } else {
                int i11 = i2 + i3;
                final char[] obj14 = new char[i3];
                i = i14;
                while (obj13 < i11) {
                    b = bArr[obj13];
                    if (!x1.a.b(b)) {
                        break;
                    } else {
                    }
                    obj13++;
                    x1.a.c(b, obj14, i);
                    i = i6;
                }
                i7 = i;
                while (obj13 < i11) {
                    i = obj13 + 1;
                    obj13 = bArr[obj13];
                    int i21 = i + 1;
                    int i16 = i21 + 1;
                    x1.a.a(obj13, bArr[i], bArr[i21], bArr[i16], obj14, i7);
                    obj13 = i8;
                    i7 = i5;
                    int i19 = i + 1;
                    x1.a.g(obj13, bArr[i], bArr[i19], obj14, i7);
                    obj13 = i6;
                    i7 = i4;
                    x1.a.e(obj13, bArr[i], obj14, i7);
                    obj13 = b;
                    i7 = i6;
                    b = i7 + 1;
                    x1.a.c(obj13, obj14, i7);
                    while (i < i11) {
                        obj13 = bArr[i];
                        if (!x1.a.b(obj13)) {
                            break loop_10;
                        } else {
                        }
                        i++;
                        x1.a.c(obj13, obj14, b);
                        b = i6;
                    }
                    obj13 = i;
                    i7 = b;
                    obj13 = bArr[i];
                    if (!x1.a.b(obj13)) {
                    } else {
                    }
                    i++;
                    x1.a.c(obj13, obj14, b);
                    b = i6;
                }
                String obj12 = new String(obj14, i14, i7);
                return obj12;
            }
            Object[] arr = new Object[3];
            arr[i14] = Integer.valueOf(bArr.length);
            arr[i15] = Integer.valueOf(i2);
            arr[2] = Integer.valueOf(i3);
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", arr));
            throw arrayIndexOutOfBoundsException;
        }

        @Override // com.google.protobuf.x1$b
        String d(ByteBuffer byteBuffer, int i2, int i3) {
            return c(byteBuffer, i2, i3);
        }

        @Override // com.google.protobuf.x1$b
        int e(java.lang.CharSequence charSequence, byte[] b2Arr2, int i3, int i4) {
            int i6;
            byte b;
            int i2;
            char charAt;
            int i;
            byte b2;
            int surrogatePair;
            int i5;
            boolean obj8;
            byte[] obj9;
            int obj10;
            int obj11;
            final int length = charSequence.length();
            i4 += i3;
            i6 = 0;
            int i10 = 128;
            while (i6 < length) {
                i2 = i6 + i3;
                if (i2 < obj11) {
                }
                charAt = charSequence.charAt(i6);
                if (charAt < i10) {
                }
                b2Arr2[i2] = (byte)charAt;
                i6++;
                i10 = 128;
            }
            if (i6 == length) {
                return i3 += length;
            }
            i3 += i6;
            while (i6 < length) {
                char charAt3 = charSequence.charAt(i6);
                int i16 = 57343;
                int i20 = 55296;
                charAt = i6 + 1;
                char charAt2 = charSequence.charAt(charAt);
                int codePoint = Character.toCodePoint(charAt3, charAt2);
                int i15 = obj10 + 1;
                b2Arr2[obj10] = (byte)i27;
                obj10 = i15 + 1;
                b2Arr2[i15] = (byte)i30;
                i2 = obj10 + 1;
                b2Arr2[obj10] = (byte)i33;
                obj10 = i2 + 1;
                b2Arr2[i2] = (byte)i8;
                i6 = charAt;
                i6++;
                int i17 = obj10 + 1;
                b2Arr2[obj10] = (byte)i22;
                obj10 = i17 + 1;
                b2Arr2[i17] = (byte)i25;
                charAt = obj10 + 1;
                b2Arr2[obj10] = (byte)i14;
                obj10 = charAt;
                charAt = obj10 + 1;
                b2Arr2[obj10] = (byte)i19;
                obj10 = charAt + 1;
                b2Arr2[charAt] = (byte)i12;
                charAt = obj10 + 1;
                b2Arr2[obj10] = (byte)charAt3;
            }
            return obj10;
        }

        @Override // com.google.protobuf.x1$b
        int i(int i, byte[] b2Arr2, int i3, int i4) {
            byte b;
            byte i7;
            int i5;
            int i2;
            int i6;
            byte b2;
            int obj7;
            int obj9;
            if (i != 0 && i3 >= i4) {
                if (i3 >= i4) {
                    return i;
                }
                b = (byte)i;
                i7 = -32;
                i5 = -1;
                i2 = -65;
                obj7 = i3 + 1;
                if (b < i7 && b >= -62 && b2Arr2[i3] > i2) {
                    if (b >= -62) {
                        obj7 = i3 + 1;
                        if (b2Arr2[i3] > i2) {
                        }
                        obj9 = obj7;
                    }
                    return i5;
                }
                if (b < -16) {
                }
                i6 = 0;
                if ((byte)i9 == 0) {
                    obj7 = i3 + 1;
                    if (obj7 >= i4) {
                        return x1.a(b, b2Arr2[i3]);
                    }
                    obj9 = obj7;
                } else {
                    i6 = (byte)obj7;
                }
                obj7 = obj9 + 1;
                if (i6 == 0 && obj7 >= i4) {
                    obj7 = obj9 + 1;
                    if (obj7 >= i4) {
                        return x1.b(b, i7, b2Arr2[obj9]);
                    }
                    obj9 = obj7;
                }
                if (i7 <= i2) {
                }
                return i5;
            }
            return x1.c.m(b2Arr2, obj9, i4);
        }

        @Override // com.google.protobuf.x1$b
        int l(int i, ByteBuffer byteBuffer2, int i3, int i4) {
            return k(i, byteBuffer2, i3, i4);
        }
    }

    static final class e extends com.google.protobuf.x1.b {
        static boolean m() {
            boolean z;
            int i;
            if (w1.I() && w1.J()) {
                i = w1.J() ? 1 : 0;
            } else {
            }
            return i;
        }

        private static int n(long l, int i2) {
            int i;
            long l2;
            int i6;
            int i4;
            int i3;
            int i5;
            int obj8;
            long obj9;
            int obj10;
            i = x1.e.p(l, i2);
            l += l2;
            obj10 -= i;
            while (/* condition */) {
                i6 = 1;
                while (obj10 > 0) {
                    i4 = obj8 + i6;
                    if (w1.w(obj8) < 0) {
                        break loop_2;
                    } else {
                    }
                    obj10--;
                    obj8 = i4;
                    i6 = 1;
                }
                obj10--;
                i = -32;
                i4 = -65;
                i3 = -1;
                obj10 += -3;
                i5 = obj8 + i6;
                obj8 = w1.w(obj8);
                if (obj8 <= i4) {
                }
                obj9 += obj8;
                if (obj9 >> 30 == 0) {
                }
                obj8 = i5 + i6;
                if (w1.w(i5) <= i4) {
                }
                i6 += obj8;
                if (w1.w(obj8) <= i4) {
                }
                obj8 = i6;
                int i7 = 0;
                l2 = i7;
                obj10 += -2;
                i5 = obj8 + i6;
                obj8 = w1.w(obj8);
                if (obj8 <= i4) {
                }
                obj9 = -96L;
                i6 += i5;
                if (obj8 < obj9) {
                }
                if (obj8 >= obj9) {
                }
                obj10--;
                if (l2 >= -62) {
                    break;
                }
                i6 += obj8;
                i4 = obj8 + i6;
                if (w1.w(obj8) >= 0) {
                } else {
                }
                obj8 = i4;
                obj10--;
                obj8 = i4;
            }
            return i7;
        }

        private static int o(byte[] bArr, long l2, int i3) {
            long l;
            int i5;
            int i4;
            int i;
            int i6;
            int i2;
            int obj9;
            long obj10;
            int obj11;
            int i7 = x1.e.q(bArr, l2, i3);
            obj11 -= i7;
            l2 += l;
            while (/* condition */) {
                i4 = 1;
                while (obj11 > 0) {
                    i = obj9 + i4;
                    if (w1.x(bArr, obj9) < 0) {
                        break loop_2;
                    } else {
                    }
                    obj11--;
                    obj9 = i;
                    i4 = 1;
                }
                obj11--;
                l = -32;
                i = -65;
                i6 = -1;
                obj11 += -3;
                i2 = obj9 + i4;
                obj9 = w1.x(bArr, obj9);
                if (obj9 <= i) {
                }
                obj10 += obj9;
                if (obj10 >> 30 == 0) {
                }
                obj9 = i2 + i4;
                if (w1.x(bArr, i2) <= i) {
                }
                i4 += obj9;
                if (w1.x(bArr, obj9) <= i) {
                }
                obj9 = i4;
                int i8 = 0;
                i5 = i8;
                obj11 += -2;
                i2 = obj9 + i4;
                obj9 = w1.x(bArr, obj9);
                if (obj9 <= i) {
                }
                obj10 = -96L;
                i4 += i2;
                if (obj9 < obj10) {
                }
                if (obj9 >= obj10) {
                }
                obj11--;
                if (i5 >= -62) {
                    break;
                }
                i4 += obj9;
                i = obj9 + i4;
                if (w1.x(bArr, obj9) >= 0) {
                } else {
                }
                obj9 = i;
                obj11--;
                obj9 = i;
            }
            return i8;
        }

        private static int p(long l, int i2) {
            int i3;
            int cmp;
            int i;
            int i4;
            int obj6;
            if (obj8 < 16) {
                return 0;
            }
            int i8 = i7 - 8;
            cmp = i8;
            while (cmp > 0) {
                cmp--;
                obj6 = i;
            }
            i3 = obj8 - i8;
            while (i3 >= 8) {
                if (Long.compare(i11, i4) == 0) {
                }
                obj6 += cmp;
                i3 += -8;
            }
            return obj8 -= i3;
        }

        private static int q(byte[] bArr, long l2, int i3) {
            int i;
            int i2;
            int obj4;
            if (obj6 < 16) {
                return 0;
            }
            while (i < obj6) {
                i++;
                obj4 = i2;
            }
            return obj6;
        }

        private static int r(long l, int i2, int i3) {
            if (obj5 != null && obj5 != 1) {
                if (obj5 != 1) {
                    if (obj5 != 2) {
                    } else {
                        return x1.b(i3, w1.w(l), w1.w(l += i5));
                    }
                    AssertionError obj2 = new AssertionError();
                    throw obj2;
                }
                return x1.a(i3, w1.w(l));
            }
            return x1.d(i3);
        }

        private static int s(byte[] bArr, int i2, long l3, int i4) {
            if (obj6 != null && obj6 != 1) {
                if (obj6 != 1) {
                    if (obj6 != 2) {
                    } else {
                        return x1.b(i2, w1.x(bArr, l3), w1.x(bArr, l3 += i5));
                    }
                    AssertionError obj2 = new AssertionError();
                    throw obj2;
                }
                return x1.a(i2, w1.x(bArr, l3));
            }
            return x1.d(i2);
        }

        @Override // com.google.protobuf.x1$b
        String b(byte[] bArr, int i2, int i3) {
            int i4;
            byte b;
            long l3;
            long l2;
            long l;
            int i;
            int i5;
            int i6;
            int obj13;
            int i12 = 0;
            final int i13 = 1;
            if (i7 |= i11 < 0) {
            } else {
                int i9 = i2 + i3;
                final char[] obj14 = new char[i3];
                i4 = i12;
                while (obj13 < i9) {
                    b = w1.x(bArr, (long)obj13);
                    if (!x1.a.b(b)) {
                        break;
                    } else {
                    }
                    obj13++;
                    x1.a.c(b, obj14, i4);
                    i4 = l3;
                }
                i = i4;
                while (obj13 < i9) {
                    i4 = obj13 + 1;
                    obj13 = w1.x(bArr, (long)obj13);
                    int i19 = i4 + 1;
                    int i14 = i19 + 1;
                    x1.a.a(obj13, w1.x(bArr, (long)i4), w1.x(bArr, (long)i19), w1.x(bArr, (long)i14), obj14, i);
                    obj13 = i5;
                    i = i6;
                    int i17 = i4 + 1;
                    x1.a.g(obj13, w1.x(bArr, (long)i4), w1.x(bArr, (long)i17), obj14, i);
                    obj13 = l3;
                    i = l2;
                    x1.a.e(obj13, w1.x(bArr, (long)i4), obj14, i);
                    obj13 = b;
                    i = l3;
                    b = i + 1;
                    x1.a.c(obj13, obj14, i);
                    while (i4 < i9) {
                        obj13 = w1.x(bArr, (long)i4);
                        if (!x1.a.b(obj13)) {
                            break loop_10;
                        } else {
                        }
                        i4++;
                        x1.a.c(obj13, obj14, b);
                        b = l3;
                    }
                    obj13 = i4;
                    i = b;
                    obj13 = w1.x(bArr, (long)i4);
                    if (!x1.a.b(obj13)) {
                    } else {
                    }
                    i4++;
                    x1.a.c(obj13, obj14, b);
                    b = l3;
                }
                String obj12 = new String(obj14, i12, i);
                return obj12;
            }
            Object[] arr = new Object[3];
            arr[i12] = Integer.valueOf(bArr.length);
            arr[i13] = Integer.valueOf(i2);
            arr[2] = Integer.valueOf(i3);
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", arr));
            throw arrayIndexOutOfBoundsException;
        }

        @Override // com.google.protobuf.x1$b
        String d(ByteBuffer byteBuffer, int i2, int i3) {
            int i;
            int cmp2;
            int i8;
            int i6;
            long cmp;
            int i7;
            byte b;
            byte b3;
            byte b2;
            char[] cArr;
            int i4;
            int i5;
            int i9 = i2;
            int i11 = i3;
            int i17 = 0;
            final int i18 = 1;
            if (i14 |= i16 < 0) {
            } else {
                l3 += i8;
                char[] cArr2 = new char[i11];
                i = i17;
                i5 = 1;
                while (Long.compare(i8, i26) < 0) {
                    cmp2 = w1.w(i8);
                    if (!x1.a.b(cmp2)) {
                        break;
                    } else {
                    }
                    i8 += i5;
                    x1.a.c(cmp2, cArr2, i);
                    i = i7;
                    i5 = 1;
                }
                while (/* condition */) {
                    while (Long.compare(i8, i26) < 0) {
                        i = i8 + i5;
                        i7 = w1.w(i8);
                        int i20 = i + i5;
                        x1.a.g(i7, w1.w(i), w1.w(i20), cArr2, i4);
                        i4 = i21;
                        i8 = b;
                        i8 = i + i5;
                        x1.a.e(i7, w1.w(i), cArr2, i4);
                        i4 = cmp2;
                        i6 = i4 + 1;
                        x1.a.c(i7, cArr2, i4);
                        while (Long.compare(i, i26) < 0) {
                            cmp = w1.w(i);
                            if (!x1.a.b(cmp)) {
                                break loop_10;
                            } else {
                            }
                            i += i5;
                            x1.a.c(cmp, cArr2, i6);
                            i6 = i7;
                        }
                        i4 = i6;
                        i8 = i;
                        cmp = w1.w(i);
                        if (!x1.a.b(cmp)) {
                        } else {
                        }
                        i += i5;
                        x1.a.c(cmp, cArr2, i6);
                        i6 = i7;
                    }
                    i = i8 + i5;
                    i7 = w1.w(i8);
                    int i24 = i + i5;
                    int i12 = i24 + i5;
                    i8 = i12 + i5;
                    x1.a.a(i7, w1.w(i), w1.w(i24), w1.w(i12), cArr2, i4);
                    i13 += i18;
                    i4 = i;
                    i20 = i + i5;
                    x1.a.g(i7, w1.w(i), w1.w(i20), cArr2, i4);
                    i4 = i21;
                    i8 = b;
                    i8 = i + i5;
                    x1.a.e(i7, w1.w(i), cArr2, i4);
                    i4 = cmp2;
                    i6 = i4 + 1;
                    x1.a.c(i7, cArr2, i4);
                    while (Long.compare(i, i26) < 0) {
                        cmp = w1.w(i);
                        if (!x1.a.b(cmp)) {
                            break loop_10;
                        } else {
                        }
                        i += i5;
                        x1.a.c(cmp, cArr2, i6);
                        i6 = i7;
                    }
                    i4 = i6;
                    i8 = i;
                    cmp = w1.w(i);
                    if (!x1.a.b(cmp)) {
                    } else {
                    }
                    i += i5;
                    x1.a.c(cmp, cArr2, i6);
                    i6 = i7;
                }
                String string = new String(cArr2, i17, i4);
                return string;
            }
            Object[] arr = new Object[3];
            arr[i17] = Integer.valueOf(byteBuffer.limit());
            arr[i18] = Integer.valueOf(i2);
            arr[2] = Integer.valueOf(i3);
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", arr));
            throw arrayIndexOutOfBoundsException;
        }

        @Override // com.google.protobuf.x1$b
        int e(java.lang.CharSequence charSequence, byte[] b2Arr2, int i3, int i4) {
            boolean surrogatePair;
            int i;
            int i2;
            int i11;
            int i14;
            long l2;
            int i10;
            long l;
            int i8;
            int i12;
            int surrogatePair2;
            int i13;
            int i5;
            char charAt;
            int cmp2;
            int cmp;
            long cmp3;
            int i9;
            int i6;
            int i7;
            surrogatePair = charSequence;
            i = b2Arr2;
            int i18 = i3;
            i11 = i4;
            l3 += l2;
            int length = charSequence.length();
            final String str = " at index ";
            final String str2 = "Failed writing ";
            if (length > i11) {
            } else {
                if (length2 -= i11 < i18) {
                } else {
                    i2 = 0;
                    while (i2 < length) {
                        charAt = surrogatePair.charAt(i2);
                        if (charAt < 128) {
                        }
                        w1.O(i, l2, obj5);
                        i2++;
                        l2 = i8;
                    }
                    if (i2 == length) {
                        return (int)l2;
                    }
                    while (i2 < length) {
                        charAt = surrogatePair.charAt(i2);
                        int i22 = 57343;
                        int i45 = 55296;
                        cmp3 = Long.compare(l2, i50);
                        i14 = i2 + 1;
                        char charAt4 = surrogatePair.charAt(i14);
                        int codePoint = Character.toCodePoint(charAt, charAt4);
                        int i40 = 1;
                        charAt = l2 + i40;
                        w1.O(i, l2, l);
                        int i27 = charAt + i40;
                        i53 &= 63;
                        i13 = 128;
                        w1.O(i, charAt, i45);
                        cmp2 = i27 + i42;
                        w1.O(i, i27, l);
                        i5 = cmp2 + i10;
                        w1.O(i, cmp2, cmp3);
                        i2 = i14;
                        i2++;
                        i14 = i13;
                        l2 = i5;
                        i12 = i7;
                        int i46 = l2 + i12;
                        w1.O(i, l2, l);
                        i14 = i46 + i12;
                        int i37 = 128;
                        w1.O(i, i46, cmp3);
                        w1.O(i, i14, l2);
                        i5 = i6;
                        i10 = 1;
                        i13 = 128;
                        cmp2 = l2 + i12;
                        w1.O(i, l2, l);
                        w1.O(i, cmp2, cmp3);
                        i13 = 128;
                        i5 = i14;
                        i10 = i7;
                        w1.O(i, l2, l);
                        i10 = i12;
                        i5 = cmp2;
                        i13 = i14;
                    }
                    return (int)l2;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append(surrogatePair.charAt(length--));
            stringBuilder2.append(str);
            stringBuilder2.append(i18 + i11);
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            throw arrayIndexOutOfBoundsException2;
        }

        @Override // com.google.protobuf.x1$b
        int i(int i, byte[] b2Arr2, int i3, int i4) {
            int i8;
            int cmp;
            long i6;
            int i10;
            int i9;
            int i7;
            int i2;
            int i5;
            int obj12;
            if (i11 |= i13 < 0) {
            } else {
                i6 = (long)i3;
                long obj14 = (long)i4;
                if (i != 0 && Long.compare(i6, obj14) >= 0) {
                    if (Long.compare(i6, obj14) >= 0) {
                        return i;
                    }
                    i8 = (byte)i;
                    i10 = -32;
                    i9 = -1;
                    i7 = -65;
                    i2 = 1;
                    if (i8 < i10 && i8 >= -62 && w1.x(b2Arr2, i6) > i7) {
                        if (i8 >= -62) {
                            if (w1.x(b2Arr2, i6) > i7) {
                            }
                            i6 = i2;
                        }
                        return i9;
                    }
                    i5 = i6 + i2;
                    if (i8 < -16 && (byte)obj12 == 0 && Long.compare(i5, obj14) >= 0) {
                        if ((byte)obj12 == 0) {
                            i5 = i6 + i2;
                            if (Long.compare(i5, obj14) >= 0) {
                                return x1.a(i8, w1.x(b2Arr2, i6));
                            }
                            i6 = i5;
                        }
                        if (obj12 <= i7) {
                            cmp = -96;
                            if (i8 == i10) {
                                if (obj12 >= cmp) {
                                    if (i8 == -19) {
                                        i8 = i6 + i2;
                                        if (obj12 < cmp && w1.x(b2Arr2, i6) > i7) {
                                            i8 = i6 + i2;
                                            if (w1.x(b2Arr2, i6) > i7) {
                                            }
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                            i6 = i8;
                        }
                        return i9;
                    }
                    if ((byte)i15 == 0) {
                        i5 = i6 + i2;
                        if (Long.compare(i5, obj14) >= 0) {
                            return x1.a(i8, w1.x(b2Arr2, i6));
                        }
                        i6 = i5;
                    } else {
                        cmp = (byte)obj12;
                    }
                    i5 = i6 + i2;
                    if (cmp == 0 && Long.compare(i5, obj14) >= 0) {
                        i5 = i6 + i2;
                        if (Long.compare(i5, obj14) >= 0) {
                            return x1.b(i8, i10, w1.x(b2Arr2, i6));
                        }
                        i6 = i5;
                    }
                    if (i10 <= i7) {
                    }
                    return i9;
                }
                return x1.e.o(b2Arr2, i6, obj3);
            }
            Object[] arr = new Object[3];
            obj12 = new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(b2Arr2.length), Integer.valueOf(i3), Integer.valueOf(i4)));
            throw obj12;
        }

        @Override // com.google.protobuf.x1$b
        int l(int i, ByteBuffer byteBuffer2, int i3, int i4) {
            int i8;
            int cmp;
            int i9;
            long i2;
            int i7;
            int i5;
            int i6;
            int obj11;
            int obj14;
            if (i10 |= i14 < 0) {
            } else {
                l += i2;
                obj12 += i9;
                if (i != 0 && Long.compare(i9, obj12) >= 0) {
                    if (Long.compare(i9, obj12) >= 0) {
                        return i;
                    }
                    obj14 = (byte)i;
                    i8 = -32;
                    i2 = -1;
                    i7 = -65;
                    i5 = 1;
                    if (obj14 < i8 && obj14 >= -62 && w1.w(i9) > i7) {
                        if (obj14 >= -62) {
                            if (w1.w(i9) > i7) {
                            }
                            i9 = i5;
                        }
                        return i2;
                    }
                    i6 = i9 + i5;
                    if (obj14 < -16 && (byte)obj11 == 0 && Long.compare(i6, obj12) >= 0) {
                        if ((byte)obj11 == 0) {
                            i6 = i9 + i5;
                            if (Long.compare(i6, obj12) >= 0) {
                                return x1.a(obj14, w1.w(i9));
                            }
                            i9 = i6;
                        }
                        if (obj11 <= i7) {
                            cmp = -96;
                            if (obj14 == i8) {
                                if (obj11 >= cmp) {
                                    if (obj14 == -19) {
                                        i8 = i9 + i5;
                                        if (obj11 < cmp && w1.w(i9) > i7) {
                                            i8 = i9 + i5;
                                            if (w1.w(i9) > i7) {
                                            }
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                            i9 = i8;
                        }
                        return i2;
                    }
                    if ((byte)i13 == 0) {
                        i6 = i9 + i5;
                        if (Long.compare(i6, obj12) >= 0) {
                            return x1.a(obj14, w1.w(i9));
                        }
                        i9 = i6;
                    } else {
                        cmp = (byte)obj11;
                    }
                    i6 = i9 + i5;
                    if (cmp == 0 && Long.compare(i6, obj12) >= 0) {
                        i6 = i9 + i5;
                        if (Long.compare(i6, obj12) >= 0) {
                            return x1.b(obj14, i8, w1.w(i9));
                        }
                        i9 = i6;
                    }
                    if (i8 <= i7) {
                    }
                    return i2;
                }
                return x1.e.n(i9, obj3);
            }
            Object[] arr = new Object[3];
            obj11 = new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer2.limit()), Integer.valueOf(i3), Integer.valueOf(i4)));
            throw obj11;
        }
    }
    static {
        boolean z;
        com.google.protobuf.x1.b cVar;
        if (x1.e.m() && !d.c()) {
            if (!d.c()) {
                cVar = new x1.e();
            } else {
                cVar = new x1.c();
            }
        } else {
        }
        x1.a = cVar;
    }

    static int a(int i, int i2) {
        return x1.n(i, i2);
    }

    static int b(int i, int i2, int i3) {
        return x1.o(i, i2, i3);
    }

    static int c(byte[] bArr, int i2, int i3) {
        return x1.q(bArr, i2, i3);
    }

    static int d(int i) {
        return x1.m(i);
    }

    static int e(ByteBuffer byteBuffer, int i2, int i3) {
        return x1.l(byteBuffer, i2, i3);
    }

    static int f(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        return x1.p(byteBuffer, i2, i3, i4);
    }

    static String g(ByteBuffer byteBuffer, int i2, int i3) {
        return x1.a.a(byteBuffer, i2, i3);
    }

    static String h(byte[] bArr, int i2, int i3) {
        return x1.a.b(bArr, i2, i3);
    }

    static int i(java.lang.CharSequence charSequence, byte[] b2Arr2, int i3, int i4) {
        return x1.a.e(charSequence, b2Arr2, i3, i4);
    }

    static int j(java.lang.CharSequence charSequence) {
        int i3;
        char charAt2;
        int i;
        int charAt;
        int i2;
        java.lang.CharSequence obj5;
        int length = charSequence.length();
        i3 = 0;
        while (i3 < length) {
            if (charSequence.charAt(i3) < 128) {
            }
            i3++;
        }
        i = length;
        while (i3 < length) {
            charAt = charSequence.charAt(i3);
            if (charAt >= 2048) {
                break;
            } else {
            }
            i += charAt;
            i3++;
        }
        if (i < length) {
        } else {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UTF-8 length does not fit in int: ");
        stringBuilder.append(l += l2);
        obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    private static int k(java.lang.CharSequence charSequence, int i2) {
        int i;
        int codePointAt;
        int i3;
        int obj5;
        final int length = charSequence.length();
        i = 0;
        while (obj5 < length) {
            codePointAt = charSequence.charAt(obj5);
            i += 2;
            obj5++;
            obj5++;
            i += codePointAt;
        }
        return i;
    }

    private static int l(ByteBuffer byteBuffer, int i2, int i3) {
        int i4;
        int cmp;
        int i;
        i4 = i2;
        while (i4 < i3 += -7) {
            if (Long.compare(i6, i) == 0) {
            }
            i4 += 8;
        }
        return i4 -= i2;
    }

    private static int m(int i) {
        int obj1;
        if (i > -12) {
            obj1 = -1;
        }
        return obj1;
    }

    private static int n(int i, int i2) {
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

    private static int o(int i, int i2, int i3) {
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

    private static int p(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        final int i = 1;
        if (i4 != 0 && i4 != i) {
            i = 1;
            if (i4 != i) {
                if (i4 != 2) {
                } else {
                    return x1.o(i2, byteBuffer.get(i3), byteBuffer.get(i3 += i));
                }
                AssertionError obj2 = new AssertionError();
                throw obj2;
            }
            return x1.n(i2, byteBuffer.get(i3));
        }
        return x1.m(i2);
    }

    private static int q(byte[] bArr, int i2, int i3) {
        byte b = bArr[i2 + -1];
        i3 -= i2;
        final int i4 = 1;
        if (obj5 != null && obj5 != i4) {
            i4 = 1;
            if (obj5 != i4) {
                if (obj5 != 2) {
                } else {
                    return x1.o(b, bArr[i2], bArr[i2 += i4]);
                }
                AssertionError obj3 = new AssertionError();
                throw obj3;
            }
            return x1.n(b, bArr[i2]);
        }
        return x1.m(b);
    }

    static boolean r(ByteBuffer byteBuffer) {
        return x1.a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean s(byte[] bArr) {
        return x1.a.g(bArr, 0, bArr.length);
    }

    public static boolean t(byte[] bArr, int i2, int i3) {
        return x1.a.g(bArr, i2, i3);
    }

    static int u(int i, ByteBuffer byteBuffer2, int i3, int i4) {
        return x1.a.h(i, byteBuffer2, i3, i4);
    }

    public static int v(int i, byte[] b2Arr2, int i3, int i4) {
        return x1.a.i(i, b2Arr2, i3, i4);
    }
}
