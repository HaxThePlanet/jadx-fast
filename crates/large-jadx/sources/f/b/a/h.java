package f.b.a;

import java.nio.ByteBuffer;

/* compiled from: IsoTypeWriterVariable.java */
/* loaded from: classes.dex */
public final class h {
    public static void a(long j, ByteBuffer byteBuffer, int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 8) {
                            String str = "I don't know how to read ";
                            StringBuilder stringBuilder = new StringBuilder(str);
                            String str2 = " bytes";
                            r3 = str + i + str2;
                            throw new RuntimeException(r3);
                        } else {
                            g.i(byteBuffer, j);
                        }
                    }
                    g.g(byteBuffer, j);
                } else {
                    long l = 16777215L;
                    i = (int)(j & l);
                    g.f(byteBuffer, i);
                }
            } else {
                l = 65535L;
                i = (int)(j & l);
                g.e(byteBuffer, i);
            }
        } else {
            l = 255L;
            i = (int)(j & l);
            g.j(byteBuffer, i);
        }
    }
}
