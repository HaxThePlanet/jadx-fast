package com.google.android.exoplayer2.util;

import android.media.MediaFormat;
import com.google.android.exoplayer2.video.n;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class y {
    public static void a(MediaFormat mediaFormat, String string2, byte[] b3Arr3) {
        byte[] obj2;
        if (b3Arr3 != null) {
            mediaFormat.setByteBuffer(string2, ByteBuffer.wrap(b3Arr3));
        }
    }

    public static void b(MediaFormat mediaFormat, n n2) {
        String str;
        String str2;
        Object obj3;
        if (n2 != null) {
            y.d(mediaFormat, "color-transfer", n2.c);
            y.d(mediaFormat, "color-standard", n2.a);
            y.d(mediaFormat, "color-range", n2.b);
            y.a(mediaFormat, "hdr-static-info", n2.v);
        }
    }

    public static void c(MediaFormat mediaFormat, String string2, float f3) {
        if (Float.compare(f3, i) != 0) {
            mediaFormat.setFloat(string2, f3);
        }
    }

    public static void d(MediaFormat mediaFormat, String string2, int i3) {
        if (i3 != -1) {
            mediaFormat.setInteger(string2, i3);
        }
    }

    public static void e(MediaFormat mediaFormat, List<byte[]> list2) {
        int i;
        String string;
        ByteBuffer wrap;
        i = 0;
        while (i < list2.size()) {
            StringBuilder stringBuilder = new StringBuilder(15);
            stringBuilder.append("csd-");
            stringBuilder.append(i);
            mediaFormat.setByteBuffer(stringBuilder.toString(), ByteBuffer.wrap((byte[])list2.get(i)));
            i++;
        }
    }
}
