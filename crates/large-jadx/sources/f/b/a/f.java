package f.b.a;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class f {
    public static long a(ByteBuffer byteBuffer, int i2) {
        int i;
        int obj2;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3 && i2 != 4) {
                    if (i2 != 4) {
                        if (i2 != 8) {
                        } else {
                            return e.m(byteBuffer);
                        }
                        StringBuilder stringBuilder = new StringBuilder("I don't know how to read ");
                        stringBuilder.append(i2);
                        stringBuilder.append(" bytes");
                        obj2 = new RuntimeException(stringBuilder.toString());
                        throw obj2;
                    }
                    return e.k(byteBuffer);
                }
                obj2 = e.j(byteBuffer);
            } else {
                obj2 = e.i(byteBuffer);
            }
        } else {
            obj2 = e.n(byteBuffer);
        }
        return (long)obj2;
    }
}
