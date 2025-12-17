package com.google.android.exoplayer2.audio;

import android.accounts.Account;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.util.c0;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class y {

    private static final int[] a;
    private static final int[] b;
    private static final int[] c;
    static {
        int i2 = 16;
        final int[] iArr3 = new int[i2];
        iArr3 = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        y.a = iArr3;
        int[] iArr = new int[i2];
        iArr = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
        y.b = iArr;
        int[] iArr2 = new int[29];
        iArr2 = new int[]{
            64, 112, 128, 192, 224, 256, 384, 448, 512, 640,
            768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560,
            2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680
        };
        y.c = iArr2;
    }

    public static int a(byte[] bArr) {
        int i3;
        int i2;
        int i;
        int i4;
        int obj7;
        byte b3 = bArr[0];
        final int i21 = 6;
        final int i22 = 7;
        final int i23 = 1;
        final int i24 = 4;
        if (b3 != -2) {
            if (b3 != -1) {
                if (b3 != 31) {
                    i13 |= i4;
                    obj7 = bArr[i22];
                    obj7 += i23;
                } else {
                    i6 |= i15;
                    obj7 = bArr[8];
                    obj7 += i23;
                    i3 = i23;
                }
            } else {
                i8 |= i17;
                obj7 = bArr[9];
            }
        } else {
            i10 |= i4;
            obj7 = bArr[i21];
        }
        if (i3 != 0) {
            obj7 /= 14;
        }
        return obj7;
    }

    private static c0 b(byte[] bArr) {
        byte c0Var;
        int z;
        int i;
        int i3;
        int i2;
        byte b;
        int i4 = 0;
        if (bArr[i4] == 127) {
            c0 c0Var2 = new c0(bArr);
            return c0Var2;
        }
        final byte[] obj5 = Arrays.copyOf(bArr, bArr.length);
        if (y.c(obj5)) {
            z = i4;
            while (z < length2--) {
                i2 = z + 1;
                obj5[z] = obj5[i2];
                obj5[i2] = obj5[z];
                z += 2;
            }
        }
        c0 c0Var3 = new c0(obj5);
        if (obj5[i4] == 31) {
            c0Var = new c0(obj5);
            while (c0Var.b() >= 16) {
                c0Var.q(2);
                i3 = 14;
                c0Var3.f(c0Var.h(i3), i3);
            }
        }
        c0Var3.m(obj5);
        return c0Var3;
    }

    private static boolean c(byte[] bArr) {
        int i;
        int b;
        byte obj3;
        i = 0;
        if (bArr[i] != -2) {
            if (bArr[i] == -1) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    public static boolean d(int i) {
        int i2;
        int obj1;
        if (i != 2147385345 && i != -25230976 && i != 536864768) {
            if (i != -25230976) {
                if (i != 536864768) {
                    if (i == -14745368) {
                        obj1 = 1;
                    } else {
                        obj1 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    public static int e(ByteBuffer byteBuffer) {
        int i2;
        int i;
        int i3;
        int obj3;
        int position = byteBuffer.position();
        byte b = byteBuffer.get(position);
        if (b != -2) {
            if (b != -1) {
                if (b != 31) {
                    i7 <<= 6;
                    obj3 = byteBuffer.get(position += 5);
                    obj3 &= 252;
                } else {
                    i9 <<= 4;
                    obj3 = byteBuffer.get(position += 6);
                    obj3 &= 60;
                }
            } else {
                i11 <<= 4;
                obj3 = byteBuffer.get(position += 7);
            }
        } else {
            i5 <<= 6;
            obj3 = byteBuffer.get(position += 4);
        }
        return obj3 *= 32;
    }

    public static int f(byte[] bArr) {
        int i3;
        int i;
        int i2;
        int obj6;
        byte b = bArr[0];
        final int i9 = 6;
        final int i10 = 5;
        final int i11 = 4;
        if (b != -2) {
            i2 = 7;
            if (b != -1) {
                if (b != 31) {
                    i6 <<= i9;
                    obj6 = bArr[i10];
                    obj6 &= 252;
                } else {
                    i7 <<= i11;
                    obj6 = bArr[i9];
                    obj6 &= 60;
                }
            } else {
                i8 <<= i11;
                obj6 = bArr[i2];
            }
        } else {
            i5 <<= i9;
            obj6 = bArr[i11];
        }
        return obj6 *= 32;
    }

    public static i1 g(byte[] bArr, String string2, String string3, t t4) {
        int i;
        int obj6;
        obj6 = y.b(bArr);
        obj6.q(60);
        int i11 = obj6.h(5);
        int[] iArr3 = y.c;
        final int i15 = 2;
        if (i11 >= iArr3.length) {
            i = -1;
        } else {
            i13 /= i15;
        }
        obj6.q(10);
        obj6 = obj6.h(i15) > 0 ? 1 : 0;
        obj6 = new i1.b();
        obj6.S(string2);
        obj6.e0("audio/vnd.dts");
        obj6.G(i);
        obj6.H(i5 += obj6);
        obj6.f0(y.b[obj6.h(4)]);
        obj6.L(t4);
        obj6.V(string3);
        return obj6.E();
    }
}
