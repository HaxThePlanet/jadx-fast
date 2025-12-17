package com.google.android.play.core.internal;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public final class x1 {
    public static long a(ByteBuffer byteBuffer) {
        x1.g(byteBuffer);
        return x1.e(byteBuffer, position += 16);
    }

    public static long b(ByteBuffer byteBuffer) {
        x1.g(byteBuffer);
        return x1.e(byteBuffer, position += 12);
    }

    static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) {
        if (Long.compare(length, i3) < 0) {
            return 0;
        }
        Pair pair = x1.f(randomAccessFile, 0);
        if (pair != null) {
            return pair;
        }
        return x1.f(randomAccessFile, 65535);
    }

    public static void d(ByteBuffer byteBuffer, long l2) {
        int cmp;
        x1.g(byteBuffer);
        if (Long.compare(l2, i2) < 0) {
        } else {
            if (Long.compare(l2, l) > 0) {
            } else {
                byteBuffer.putInt(position2 += i, (int)l2);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(47);
        stringBuilder.append("uint32 value of out range: ");
        stringBuilder.append(l2);
        IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    private static long e(ByteBuffer byteBuffer, int i2) {
        return obj2 &= l;
    }

    private static Pair<ByteBuffer, Long> f(RandomAccessFile randomAccessFile, int i2) {
        int i;
        int arrayOffset;
        int capacity;
        char int;
        int i3;
        int obj9;
        long length = randomAccessFile.length();
        final int i8 = 0;
        if (Long.compare(length, i6) < 0) {
            return i8;
        }
        i = 22;
        ByteBuffer obj10 = ByteBuffer.allocate(obj10 += i);
        obj10.order(ByteOrder.LITTLE_ENDIAN);
        length -= l4;
        randomAccessFile.seek(i4);
        randomAccessFile.readFully(obj10.array(), obj10.arrayOffset(), obj10.capacity());
        x1.g(obj10);
        obj9 = obj10.capacity();
        int i9 = -1;
        if (obj9 < i) {
            capacity = i9;
        } else {
            obj9 += -22;
            arrayOffset = 0;
            while (arrayOffset < Math.min(obj9, 65535)) {
                capacity = obj9 - arrayOffset;
                arrayOffset++;
            }
        }
        if (capacity == i9) {
            return i8;
        }
        obj10.position(capacity);
        obj9 = obj10.slice();
        obj9.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(obj9, Long.valueOf(i4 += l));
    }

    private static void g(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
        } else {
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("ByteBuffer byte order must be little endian");
        throw obj1;
    }
}
