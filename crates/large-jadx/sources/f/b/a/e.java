package f.b.a;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class e {
    public static int a(byte b) {
        int obj0;
        if (b < 0) {
            b += 256;
        }
        return obj0;
    }

    public static String b(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        String obj2 = new String(bArr, "ISO-8859-1");
        return obj2;
    }

    public static double c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int obj4 = 0;
        return d /= l;
    }

    public static double d(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int obj4 = 0;
        return d /= l;
    }

    public static float e(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        int obj3 = 0;
        return obj3 /= i3;
    }

    public static String f(ByteBuffer byteBuffer) {
        int i;
        char c;
        StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i >= 3) {
            stringBuilder.append((char)i7);
            i++;
        }
        return stringBuilder.toString();
    }

    public static String g(ByteBuffer byteBuffer) {
        byte b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b = byteBuffer.get();
        while (b == 0) {
            byteArrayOutputStream.write(b);
            b = byteBuffer.get();
        }
        return j.a(byteArrayOutputStream.toByteArray());
    }

    public static String h(ByteBuffer byteBuffer, int i2) {
        final byte[] obj1 = new byte[i2];
        byteBuffer.get(obj1);
        return j.a(obj1);
    }

    public static int i(ByteBuffer byteBuffer) {
        return i3 += obj1;
    }

    public static int j(ByteBuffer byteBuffer) {
        return i3 += obj1;
    }

    public static long k(ByteBuffer byteBuffer) {
        long l;
        int i;
        l = (long)obj4;
        if (Long.compare(l, i) < 0) {
            l += i;
        }
        return l;
    }

    public static long l(ByteBuffer byteBuffer) {
        l <<= i4;
        if (Long.compare(i2, i5) < 0) {
        } else {
            return i2 += l2;
        }
        RuntimeException obj4 = new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        throw obj4;
    }

    public static long m(ByteBuffer byteBuffer) {
        int i5 = 0;
        i += i5;
        if (Long.compare(i2, i5) < 0) {
        } else {
            return i2 += l2;
        }
        RuntimeException obj4 = new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        throw obj4;
    }

    public static int n(ByteBuffer byteBuffer) {
        return e.a(byteBuffer.get());
    }
}
