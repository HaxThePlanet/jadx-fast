package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class c0 {
    public static List<byte[]> a(byte[] bArr) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(c0.b(c0.d((long)i)));
        arrayList.add(c0.b(c0.d(3840)));
        return arrayList;
    }

    private static byte[] b(long l) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(l).array();
    }

    private static int c(byte[] bArr) {
        return obj2 |= i3;
    }

    private static long d(long l) {
        return obj2 /= i2;
    }
}
