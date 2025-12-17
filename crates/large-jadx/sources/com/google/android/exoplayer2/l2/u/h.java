package com.google.android.exoplayer2.l2.u;

import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class h {

    private static class a {

        private final UUID a;
        private final int b;
        private final byte[] c;
        public a(UUID uUID, int i2, byte[] b3Arr3) {
            super();
            this.a = uUID;
            this.b = i2;
            this.c = b3Arr3;
        }

        static UUID a(com.google.android.exoplayer2.l2.u.h.a h$a) {
            return a.a;
        }

        static int b(com.google.android.exoplayer2.l2.u.h.a h$a) {
            return a.b;
        }

        static byte[] c(com.google.android.exoplayer2.l2.u.h.a h$a) {
            return a.c;
        }
    }
    public static byte[] a(UUID uUID, byte[] b2Arr2) {
        return h.b(uUID, 0, b2Arr2);
    }

    public static byte[] b(UUID uUID, UUID[] uUID2Arr2, byte[] b3Arr3) {
        int i3;
        int length;
        int i2;
        int i4;
        int i;
        long leastSignificantBits;
        int obj5;
        i3 = 0;
        length = b3Arr3 != null ? b3Arr3.length : i3;
        if (uUID2Arr2 != null) {
            i2 += i;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        allocate.putInt(i2);
        allocate.putInt(1886614376);
        i4 = uUID2Arr2 != null ? 0x01000000 /* Unknown resource */ : i3;
        allocate.putInt(i4);
        allocate.putLong(uUID.getMostSignificantBits());
        allocate.putLong(uUID.getLeastSignificantBits());
        if (uUID2Arr2 != null) {
            allocate.putInt(uUID2Arr2.length);
            while (i3 < uUID2Arr2.length) {
                i4 = uUID2Arr2[i3];
                allocate.putLong(i4.getMostSignificantBits());
                allocate.putLong(i4.getLeastSignificantBits());
                i3++;
            }
        }
        if (b3Arr3 != null && b3Arr3.length != 0) {
            if (b3Arr3.length != 0) {
                allocate.putInt(b3Arr3.length);
                allocate.put(b3Arr3);
            }
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr) {
        int obj0;
        obj0 = h.d(bArr) != null ? 1 : 0;
        return obj0;
    }

    private static com.google.android.exoplayer2.l2.u.h.a d(byte[] bArr) {
        int i;
        d0 d0Var = new d0(bArr);
        int i2 = 0;
        if (d0Var.f() < 32) {
            return i2;
        }
        int obj9 = 0;
        d0Var.I(obj9);
        if (d0Var.n() != i8 += 4) {
            return i2;
        }
        if (d0Var.n() != 1886614376) {
            return i2;
        }
        int i7 = c.c(d0Var.n());
        i = 1;
        if (i7 > i) {
            StringBuilder stringBuilder = new StringBuilder(37);
            stringBuilder.append("Unsupported pssh version: ");
            stringBuilder.append(i7);
            v.h("PsshAtomUtil", stringBuilder.toString());
            return i2;
        }
        UUID uuid = new UUID(d0Var.r(), obj6, d0Var.r(), obj8);
        if (i7 == i) {
            d0Var.J(i12 *= 16);
        }
        int i11 = d0Var.B();
        if (i11 != d0Var.a()) {
            return i2;
        }
        byte[] bArr2 = new byte[i11];
        d0Var.j(bArr2, obj9, i11);
        obj9 = new h.a(uuid, i7, bArr2);
        return obj9;
    }

    public static byte[] e(byte[] bArr, UUID uUID2) {
        com.google.android.exoplayer2.l2.u.h.a obj3 = h.d(bArr);
        final int i = 0;
        if (obj3 == null) {
            return i;
        }
        if (!uUID2.equals(h.a.a(obj3))) {
            String obj4 = String.valueOf(uUID2);
            obj3 = String.valueOf(h.a.a(obj3));
            StringBuilder stringBuilder = new StringBuilder(i2 += length2);
            stringBuilder.append("UUID mismatch. Expected: ");
            stringBuilder.append(obj4);
            stringBuilder.append(", got: ");
            stringBuilder.append(obj3);
            stringBuilder.append(".");
            v.h("PsshAtomUtil", stringBuilder.toString());
            return i;
        }
        return h.a.c(obj3);
    }

    public static UUID f(byte[] bArr) {
        com.google.android.exoplayer2.l2.u.h.a obj0 = h.d(bArr);
        if (obj0 == null) {
            return null;
        }
        return h.a.a(obj0);
    }

    public static int g(byte[] bArr) {
        com.google.android.exoplayer2.l2.u.h.a obj0 = h.d(bArr);
        if (obj0 == null) {
            return -1;
        }
        return h.a.b(obj0);
    }
}
