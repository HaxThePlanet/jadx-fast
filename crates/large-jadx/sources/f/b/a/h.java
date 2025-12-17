package f.b.a;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class h {
    public static void a(long l, ByteBuffer byteBuffer2, int i3) {
        int i;
        int obj2;
        if (obj5 != 1) {
            if (obj5 != 2) {
                if (obj5 != 3) {
                    if (obj5 != 4) {
                        if (obj5 != 8) {
                        } else {
                            g.i(i3, l);
                        }
                        StringBuilder obj3 = new StringBuilder("I don't know how to read ");
                        obj3.append(obj5);
                        obj3.append(" bytes");
                        obj2 = new RuntimeException(obj3.toString());
                        throw obj2;
                    }
                    g.g(i3, l);
                } else {
                    g.f(i3, (int)obj2);
                }
            } else {
                g.e(i3, (int)obj2);
            }
        } else {
            g.j(i3, (int)obj2);
        }
    }
}
