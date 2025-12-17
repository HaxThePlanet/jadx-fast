package f.b.a;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class g {
    static {
    }

    public static void a(ByteBuffer byteBuffer, double d2) {
        int obj3 = (int)obj3;
        byteBuffer.put((byte)obj4);
        byteBuffer.put((byte)obj4);
        byteBuffer.put((byte)obj4);
        byteBuffer.put((byte)obj3);
    }

    public static void b(ByteBuffer byteBuffer, double d2) {
        int obj3 = (int)obj3;
        byteBuffer.put((byte)obj4);
        byteBuffer.put((byte)obj4);
        byteBuffer.put((byte)obj4);
        byteBuffer.put((byte)obj3);
    }

    public static void c(ByteBuffer byteBuffer, double d2) {
        short obj3 = (short)obj3;
        byteBuffer.put((byte)obj4);
        byteBuffer.put((byte)obj3);
    }

    public static void d(ByteBuffer byteBuffer, String string2) {
        int i3;
        int i;
        int i4;
        int i2;
        int i5 = 3;
        if (bytes.length != i5) {
        } else {
            i = i3;
            while (i3 >= i5) {
                i += i4;
                i3++;
            }
            g.e(byteBuffer, i);
        }
        StringBuilder stringBuilder = new StringBuilder("\"");
        stringBuilder.append(string2);
        stringBuilder.append("\" language string isn't exactly 3 characters long!");
        IllegalArgumentException obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    public static void e(ByteBuffer byteBuffer, int i2) {
        i2 &= i;
        g.j(byteBuffer, obj2 >> 8);
        g.j(byteBuffer, obj2 &= 255);
    }

    public static void f(ByteBuffer byteBuffer, int i2) {
        i2 &= i;
        g.e(byteBuffer, obj2 >> 8);
        g.j(byteBuffer, obj2);
    }

    public static void g(ByteBuffer byteBuffer, long l2) {
        byteBuffer.putInt((int)l2);
    }

    public static void h(ByteBuffer byteBuffer, long l2) {
        l2 &= l;
        g.e(byteBuffer, (int)i2);
        g.g(byteBuffer, obj3 &= l3);
    }

    public static void i(ByteBuffer byteBuffer, long l2) {
        byteBuffer.putLong(l2);
    }

    public static void j(ByteBuffer byteBuffer, int i2) {
        byteBuffer.put((byte)obj1);
    }

    public static void k(ByteBuffer byteBuffer, String string2) {
        byteBuffer.put(j.b(string2));
        g.j(byteBuffer, 0);
    }

    public static void l(ByteBuffer byteBuffer, String string2) {
        byteBuffer.put(j.b(string2));
        g.j(byteBuffer, 0);
    }
}
