package f.c.a.d.b.h;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public final class l {
    static {
        j jVar = new j();
    }

    public static InputStream a(InputStream inputStream, long l2) {
        k obj3 = new k(inputStream, 1048577, obj1);
        return obj3;
    }

    public static byte[] b(InputStream inputStream) {
        int i3;
        int i2;
        int i;
        int i4;
        int bArr;
        int i5;
        int read;
        byte[] obj9;
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int i7 = 0;
        i3 = 8192;
        i2 = i7;
        int i8 = -1;
        i4 = 2147483639;
        while (i2 < i4) {
            i4 = Math.min(i3, i4 -= i2);
            bArr = new byte[i4];
            arrayDeque.add(bArr);
            i5 = i7;
            while (i5 < i4) {
                read = inputStream.read(bArr, i5, i4 - i5);
                i5 += read;
                i2 += read;
            }
            long l = (long)i3;
            l += l;
            if (Long.compare(i, bArr) > 0) {
            } else {
            }
            if (Long.compare(i, bArr) < 0) {
            } else {
            }
            i3 = (int)i;
            i8 = -1;
            i4 = 2147483639;
            i3 = Integer.MIN_VALUE;
            i3 = Integer.MAX_VALUE;
            read = inputStream.read(bArr, i5, i4 - i5);
            i5 += read;
            i2 += read;
        }
        if (inputStream.read() != i8) {
        } else {
            obj9 = l.c(arrayDeque, i4);
            return obj9;
        }
        obj9 = new OutOfMemoryError("input is too large to fit in a byte array");
        throw obj9;
    }

    private static byte[] c(Queue<byte[]> queue, int i2) {
        int i;
        Object remove;
        int i5;
        int i3;
        int i4;
        final byte[] bArr = new byte[i2];
        i = i2;
        while (i > 0) {
            remove = queue.remove();
            i5 = Math.min(i, remove.length);
            System.arraycopy((byte[])remove, 0, bArr, i2 - i, i5);
            i -= i5;
        }
        return bArr;
    }
}
