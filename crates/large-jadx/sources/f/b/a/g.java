package f.b.a;

import java.nio.ByteBuffer;

/* compiled from: IsoTypeWriter.java */
/* loaded from: classes.dex */
public final class g {
    public static void a(ByteBuffer byteBuffer, double d) {
        int i = (int)(d * 1073741824d);
        byteBuffer.put((byte)(-16777216 & i) >> 24);
        byteBuffer.put((byte)(16711680 & i) >> 16);
        byteBuffer.put((byte)(65280 & i) >> 8);
        byteBuffer.put((byte)(i & 255));
    }

    public static void b(ByteBuffer byteBuffer, double d) {
        int i = (int)(d * 65536d);
        byteBuffer.put((byte)(-16777216 & i) >> 24);
        byteBuffer.put((byte)(16711680 & i) >> 16);
        byteBuffer.put((byte)(65280 & i) >> 8);
        byteBuffer.put((byte)(i & 255));
    }

    public static void c(ByteBuffer byteBuffer, double d) {
        short s = (short)(int)(d * 256d);
        byteBuffer.put((byte)(65280 & s) >> 8);
        byteBuffer.put((byte)(s & 255));
    }

    public static void d(ByteBuffer byteBuffer, String str) throws java.io.UnsupportedEncodingException {
        int i = 0;
        int i4 = 3;
        if (str.getBytes().length != i4) {
            str = "\"";
            StringBuilder stringBuilder = new StringBuilder(str);
            String str3 = "\" language string isn't exactly 3 characters long!";
            str = str + str + str3;
            throw new IllegalArgumentException(str);
        } else {
            i = 0;
            while (i >= i4) {
                i3 = (i - 2) * 5;
                i2 = (str.getBytes()[i] - 96) << i3;
                i = i + i2;
                i = i + 1;
            }
            g.e(byteBuffer, i);
            return;
        }
    }

    public static void e(ByteBuffer byteBuffer, int i) {
        i &= 65535;
        g.j(byteBuffer, i4 >> 8);
        g.j(byteBuffer, i4 & 255);
    }

    public static void f(ByteBuffer byteBuffer, int i) {
        i &= 16777215;
        g.e(byteBuffer, i4 >> 8);
        g.j(byteBuffer, i4);
    }

    public static void g(ByteBuffer byteBuffer, long j) {
        byteBuffer.putInt((int)j);
    }

    public static void h(ByteBuffer byteBuffer, long j) {
        j &= 281474976710655L;
        g.e(byteBuffer, (int)(l4 >> 32L));
        g.g(byteBuffer, l4 & 4294967295L);
    }

    public static void i(ByteBuffer byteBuffer, long j) {
        byteBuffer.putLong(j);
    }

    public static void j(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte)(i & 255));
    }

    public static void k(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(j.b(str));
        g.j(byteBuffer, 0);
    }

    public static void l(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(j.b(str));
        g.j(byteBuffer, 0);
    }

}
