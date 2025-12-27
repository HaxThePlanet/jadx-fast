package io.grpc.k1.r.j;

import android.app.ActivityManager.MemoryInfo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* compiled from: Huffman.java */
/* loaded from: classes3.dex */
class h {

    private static final int[] b;
    private static final byte[] c;
    private static final h d = new h();
    private final h.a a = new h$a();

    private static final class a {

        private final h.a[] a;
        private final int b;
        private final int c;
        a() {
            super();
            this.a = new h.a[256];
            int i2 = 0;
            this.b = i2;
            this.c = i2;
        }

        static /* synthetic */ h.a[] a(h.a aVar) {
            return aVar.a;
        }

        static /* synthetic */ int b(h.a aVar) {
            return aVar.b;
        }

        static /* synthetic */ int c(h.a aVar) {
            return aVar.c;
        }

        a(int i, int i2) {
            int i3 = 8;
            super();
            this.a = null;
            this.b = i;
            i3 = i2 & 7;
            i3 = i2 & 7 == 0 ? 8 : i3;
            this.c = i3;
        }
    }
    static {
        h.b = new int[] { 8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 0x01ffffec /* Unknown resource */, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 0x01ffffed /* Unknown resource */, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 0x01ffffee /* Unknown resource */, 0x01ffffef /* Unknown resource */, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846 };
        h.c = new byte[] { 13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26 };
    }

    private h() {
        super();
        final io.grpc.k1.r.j.h.a aVar = new h.a();
        b();
    }

    private void a(int i, int i2, byte b) {
        int i22;
        io.grpc.k1.r.j.h.a aVar;
        io.grpc.k1.r.j.h.a aVar2;
        io.grpc.k1.r.j.h.a aVar3;
        int i9;
        int i4 = 8;
        while (i9 > i4) {
            i3 = (i2 >>> (byte)(i9 - 8)) & 255;
            if (aVar3.a == null) {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        i4 -= i9;
        i22 = (i2 << i5) & 255;
        while (i22 < i22 + (1 << i5)) {
            aVar3.a[i22] = new h.a(i, b);
            i22 = i22 + 1;
        }
    }

    private void b() {
        int i = 0;
        i = 0;
        byte[] bArr = h.c;
        while (i < bArr.length) {
            a(i, h.b[i], h.c[i]);
            i = i + 1;
            bArr = h.c;
        }
    }

    public static h f() {
        return h.d;
    }

    byte[] c(byte[] bArr) {
        io.grpc.k1.r.j.h.a aVar;
        int i = 0;
        int i4;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i = 0;
        for (byte b : bArr) {
            i3 = b & 255;
            i = (i << 8) | i3;
            i = i + 8;
            int i2 = 8;
            while (i >= 8) {
                aVar = aVar.a[(i >>> (i - 8)) & 255];
            }
            aVar = h.a.a(this.a)[i >>> i - 8 & 255];
        }
        while (i > 0) {
            io.grpc.k1.r.j.h.a aVar2 = aVar.a[(i << (i - 8)) & 255];
            if (aVar2.c > i) {
                break;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    void d(byte[] bArr, OutputStream outputStream) throws java.io.IOException {
        int i = 0;
        int i2;
        i = 0;
        i2 = 0;
        int i7 = 255;
        for (byte b2 : bArr) {
            int i6 = b2 & i7;
            byte b = h.c[i6];
            l = (long)h.b[i6];
            i2 = (i2 << b) | l;
            i = i + b;
            int i3 = 8;
            while (i >= 8) {
                i = i - 8;
                b = (int)(i2 >> i);
                outputStream.write(b);
                i3 = 8;
            }
            i7 = 255;
            i = i - 8;
            b = (int)(i2 >> i);
            outputStream.write(b);
        }
        if (i > 0) {
            i4 = (int)(long)(i7 >>> i) | (i2 << (i - 8));
            outputStream.write(i4);
        }
    }

    int e(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        i = 0;
        i2 = 0;
        for (byte b : bArr) {
            l = (long)(h.c[b & 255]);
            i = i + l;
        }
        return (int)(i + 7L) >> 3L;
    }
}
