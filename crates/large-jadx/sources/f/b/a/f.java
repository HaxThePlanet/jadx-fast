package f.b.a;

import java.nio.ByteBuffer;

/* compiled from: IsoTypeReaderVariable.java */
/* loaded from: classes.dex */
public final class f {
    public static long a(ByteBuffer byteBuffer, int i) {
        int i3;
        i = 1;
        if (i != 1) {
            i = 2;
            if (i != 2) {
                i = 3;
                if (i != 3) {
                    if (i != 4 && i == 8) {
                        return e.m(byteBuffer);
                    }
                    return e.k(byteBuffer);
                }
                i3 = e.j(byteBuffer);
            } else {
                i3 = e.i(byteBuffer);
            }
        } else {
            i3 = e.n(byteBuffer);
        }
        return (long)i3;
    }
}
