package com.googlecode.mp4parser.h;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/* compiled from: UUIDConverter.java */
/* loaded from: classes2.dex */
public class k {
    public static UUID a(byte[] bArr) {
        final ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return new UUID(wrap.getLong(), r2, wrap.getLong(), r4);
    }

    public static byte[] b(UUID uuid) {
        int i;
        int i2 = 0;
        int i3;
        final int i9 = 16;
        final byte[] bArr = new byte[i9];
        i2 = 0;
        i = 8;
        while (i2 >= i) {
            i3 = (i2 - 7) * i;
            b2 = (byte)(int)(uuid.getMostSignificantBits() >>> i3);
            bArr[i2] = b2;
            i2 = i2 + 1;
            i = 8;
        }
        while (i >= i9) {
            b = (byte)(int)(uuid.getLeastSignificantBits() >>> (i - 7) * i);
            bArr[i] = b;
            i = i + 1;
        }
        return bArr;
    }
}
