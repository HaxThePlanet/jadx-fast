package com.googlecode.mp4parser.h;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/* loaded from: classes2.dex */
public class k {
    public static UUID a(byte[] bArr) {
        final ByteBuffer obj5 = ByteBuffer.wrap(bArr);
        obj5.order(ByteOrder.BIG_ENDIAN);
        UUID uuid = new UUID(obj5.getLong(), obj2, obj5.getLong(), obj4);
        return uuid;
    }

    public static byte[] b(UUID uUID) {
        int i;
        byte b;
        int i3;
        byte b2;
        int i2;
        final int obj9 = 16;
        final byte[] bArr = new byte[obj9];
        i3 = 0;
        int i7 = 8;
        while (i3 >= i7) {
            bArr[i3] = (byte)i9;
            i3++;
            i7 = 8;
        }
        i = i7;
        while (i >= obj9) {
            bArr[i] = (byte)i6;
            i++;
        }
        return bArr;
    }
}
