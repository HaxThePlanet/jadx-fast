package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class da {

    static final int[] AFInAppEventParameterName;
    static final int[] AFInAppEventType;
    static final byte[] AFKeystoreWrapper;
    private static int[] AFVersionDeclaration;
    private static byte[] getLevel;
    static final int[] valueOf;
    static final int[] values;
    static {
        int i3;
        int i13;
        int i7;
        int i;
        int i10;
        int i4;
        byte[] aFVersionDeclaration;
        int i8;
        int i2;
        int i11;
        int valueOf;
        int i5;
        byte b;
        int i14;
        int i12;
        int i6;
        int i9;
        final int i15 = 256;
        da.getLevel = new byte[i15];
        da.AFKeystoreWrapper = new byte[i15];
        da.values = new int[i15];
        da.AFInAppEventParameterName = new int[i15];
        da.AFInAppEventType = new int[i15];
        da.valueOf = new int[i15];
        int i16 = 10;
        da.AFVersionDeclaration = new int[i16];
        int i17 = 1;
        i10 = i3;
        i11 = 0;
        do {
            i11 = 0;
            i13 = i11;
            byte b2 = (byte)i21;
            byte b3 = (byte)i22;
            byte b4 = (byte)i23;
            if (b4 & 128 != 0) {
            } else {
            }
            i8 = i11;
            i10 = (byte)i24;
            aFVersionDeclaration = da.getLevel;
            valueOf = i3 & 255;
            int i50 = i10 & 255;
            aFVersionDeclaration[valueOf] = (byte)i45;
            if (valueOf != i17) {
            }
            i8 = 9;
            i13 = 27;
        } while (i3 &= 128 != 0);
        aFVersionDeclaration[i11] = 99;
        i7 = i11;
        while (i7 < i15) {
            b5 &= 255;
            da.AFKeystoreWrapper[i10] = (byte)i7;
            i2 = i7 << 1;
            if (i2 >= i15) {
            }
            i5 = i2 << 1;
            if (i5 >= i15) {
            }
            i14 = i5 << 1;
            if (i14 >= i15) {
            }
            int i52 = i14 ^ i7;
            i35 |= i6;
            da.values[i10] = i36;
            da.AFInAppEventParameterName[i10] = i46 |= i53;
            da.AFInAppEventType[i10] = i48 |= i12;
            da.valueOf[i10] = i37 |= b;
            i7++;
            i14 ^= 283;
            i5 ^= 283;
            i2 ^= 283;
        }
        da.AFVersionDeclaration[i11] = 16777216;
        i4 = i;
        while (i < i16) {
            i4 <<= i17;
            if (i4 >= i15) {
            }
            da.AFVersionDeclaration[i] = i4 << 24;
            i++;
            i4 ^= 283;
        }
    }

    private static int[] AFInAppEventType(byte[] bArr, int[] i2Arr2, int i3) {
        int i4;
        int i2;
        int i5;
        int i7;
        int i8;
        int i9;
        byte[] getLevel;
        int i6;
        int[] aFInAppEventParameterName;
        int[] aFInAppEventType;
        int[] valueOf;
        int i;
        if (bArr.length != 16) {
        } else {
            int[] obj12 = new int[obj12 *= i4];
            int i23 = i3 * 4;
            int i48 = i23 + 1;
            obj12[0] = i2Arr2[i23];
            int i25 = i48 + 1;
            obj12[1] = i2Arr2[i48];
            int i49 = i25 + 1;
            obj12[2] = i2Arr2[i25];
            obj12[3] = i2Arr2[i49];
            i49 += -7;
            while (i7 < i3) {
                int i27 = i8 + 1;
                int i39 = i2Arr2[i8];
                int i50 = i4 + 1;
                int[] values = da.values;
                getLevel = da.getLevel;
                aFInAppEventParameterName = da.AFInAppEventParameterName;
                aFInAppEventType = da.AFInAppEventType;
                valueOf = da.valueOf;
                obj12[i4] = i42 ^= i58;
                int i11 = i27 + 1;
                int i28 = i2Arr2[i27];
                int i44 = i50 + 1;
                obj12[i50] = i31 ^= i63;
                i2 = i11 + 1;
                int i12 = i2Arr2[i11];
                int i51 = i44 + 1;
                obj12[i44] = i15 ^= i68;
                int i17 = i2Arr2[i2];
                obj12[i51] = i20 ^= i9;
                i8 = i2 + -7;
                i7++;
                i4 = i5;
            }
            int obj14 = i4 + 1;
            int i33 = i8 + 1;
            obj12[i4] = i2Arr2[i8];
            int i22 = obj14 + 1;
            int i46 = i33 + 1;
            obj12[obj14] = i2Arr2[i33];
            obj12[i22] = i2Arr2[i46];
            obj12[i22 + 1] = i2Arr2[i46 + 1];
            return obj12;
        }
        obj12 = new IllegalArgumentException();
        throw obj12;
    }

    public static byte[][] AFInAppEventType(int i) {
        int i4;
        byte b;
        byte[] bArr;
        byte b2;
        int i3;
        int i2;
        final int i5 = 4;
        final byte[][] bArr2 = new byte[i5];
        final int i6 = 0;
        i4 = i6;
        while (i4 < i5) {
            int i8 = i >>> i7;
            bArr = new byte[i5];
            bArr[i6] = (byte)i11;
            i3 = 3;
            bArr[1] = (byte)i13;
            bArr[2] = (byte)i15;
            bArr[i3] = (byte)i10;
            bArr2[i4] = bArr;
            i4++;
        }
        return bArr2;
    }

    static int[] valueOf(byte[] bArr, int i2) {
        int i3;
        int i10;
        int i;
        int i9;
        int i6;
        int i5;
        int i7;
        int i8;
        int i4;
        final int i13 = 16;
        if (bArr.length != i13) {
        } else {
            final int i14 = 4;
            i11 *= i14;
            final int[] iArr = new int[i12];
            i3 = 0;
            i9 = i10;
            while (i10 < i14) {
                int i22 = i9 + 1;
                int i28 = i22 + 1;
                int i25 = i28 + 1;
                iArr[i10] = i20 |= i5;
                i10++;
                i9 = i8;
            }
            i6 = i14;
            i = i3;
            while (i6 < i12) {
                i7 = iArr[i6 + -1];
                if (i3 == 0) {
                }
                iArr[i6] = i7 ^= i8;
                i6++;
                i3--;
                byte[] getLevel = da.getLevel;
                i7 = i16 ^ i17;
                i3 = i14;
                i = i8;
            }
            return da.AFInAppEventType(bArr, iArr, i2);
        }
        IllegalArgumentException obj10 = new IllegalArgumentException();
        throw obj10;
    }
}
