package f.c.a.d.b.h;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
public final class l {
    static {
        final f.c.a.d.b.h.j jVar = new j();
    }

    public static InputStream a(InputStream inputStream, long j) {
        return new k(inputStream, 1048577L, r1);
    }

    public static byte[] b(InputStream inputStream) throws java.io.IOException {
        int i2 = 8192;
        int i;
        long l2 = -2147483648;
        int bytesRead;
        byte[] bArr2;
        ArrayDeque arrayDeque = new ArrayDeque(20);
        i = 0;
        i2 = 8192;
        int i4 = -1;
        int min = 2147483639;
        while (i < min) {
            min = Math.min(i2, min - i);
            byte[] bArr = new byte[min];
            arrayDeque.add(bArr);
            while (i < min) {
                bytesRead = inputStream.read(bArr, i, min - i);
                if (bytesRead == i4) {
                    bArr2 = l.c(arrayDeque, i);
                }
            }
            long l3 = (long)i2;
            l = l3 + l3;
            l2 = 2147483647L;
            bytesRead = inputStream.read(bArr, i, min - i);
            if (bytesRead == i4) {
                bArr2 = l.c(arrayDeque, i);
            }
        }
        if (inputStream.read() != i4) {
            throw new OutOfMemoryError("input is too large to fit in a byte array");
        } else {
            bArr2 = l.c(arrayDeque, min);
            return bArr2;
        }
    }

    private static byte[] c(Queue<byte[]> queue, int i) {
        int i22;
        final byte[] bArr = new byte[i];
        i22 = i;
        while (i22 > 0) {
            Object remove = queue.remove();
            int min = Math.min(i22, remove.length);
            i = 0;
            i3 = i - i22;
            System.arraycopy(remove, i, bArr, i3, min);
            i22 = i22 - min;
        }
        return bArr;
    }
}
