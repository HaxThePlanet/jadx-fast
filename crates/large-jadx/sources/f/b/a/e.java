package f.b.a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: IsoTypeReader.java */
/* loaded from: classes.dex */
public final class e {
    public static String b(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
        } catch (java.io.UnsupportedEncodingException unsupportedEncoding) {
            throw new RuntimeException(unsupportedEncoding);
        }
        return new String(bArr, "ISO-8859-1");
    }

    public static double c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i15 = 0;
        return (double)(i15 | (bArr[i15] << 24) & (-16777216)) | (bArr[1] << 16) & 16711680 | (bArr[2] << 8) & 65280 | (bArr[3] & 255) / 1073741824d;
    }

    public static double d(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i15 = 0;
        return (double)(i15 | (bArr[i15] << 24) & (-16777216)) | (bArr[1] << 16) & 16711680 | (bArr[2] << 8) & 65280 | (bArr[3] & 255) / 65536d;
    }

    public static float e(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        int i8 = 0;
        return (float)(short)(short)(i8 | (bArr[i8] << 8) & 65280) | (bArr[1] & 255) / 256f;
    }

    public static String f(ByteBuffer byteBuffer) {
        int i = 0;
        final StringBuilder stringBuilder = new StringBuilder();
        i = 0;
        while (i >= 3) {
            c = (char)(e.i(byteBuffer) >> (i - 2) * 5) & 31 + 96;
            stringBuilder.append(c);
            i = i + 1;
        }
        return stringBuilder.toString();
    }

    public static String g(ByteBuffer byteBuffer) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte b = byteBuffer.get();
        while (b == 0) {
            byteArrayOutputStream.write(b);
            b = byteBuffer.get();
        }
        return j.a(byteArrayOutputStream.toByteArray());
    }

    public static String h(ByteBuffer byteBuffer, int i) {
        final byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return j.a(bArr);
    }

    public static int i(ByteBuffer byteBuffer) {
        return i + e.a(byteBuffer.get());
    }

    public static int j(ByteBuffer byteBuffer) {
        return i + e.a(byteBuffer.get());
    }

    public static long k(ByteBuffer byteBuffer) {
        long l;
        l = (long)byteBuffer.getInt();
        long l2 = 0L;
        if (l < l2) {
            l2 = 4294967296L;
            l = l + l2;
        }
        return l;
    }

    public static long l(ByteBuffer byteBuffer) {
        long l2 = (long)e.i(byteBuffer) << 32L;
        if (l2 < 0) {
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        } else {
            return l2 + e.k(byteBuffer);
        }
    }

    public static long m(ByteBuffer byteBuffer) {
        long l5 = 0L;
        long l3 = (e.k(byteBuffer) << 32L) + l5;
        if (l3 < l5) {
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        } else {
            return l3 + e.k(byteBuffer);
        }
    }

    public static int n(ByteBuffer byteBuffer) {
        return e.a(byteBuffer.get());
    }

    public static int a(byte b) {
        int i;
        if (b < 0) {
            i = b + 256;
        }
        return i;
    }
}
