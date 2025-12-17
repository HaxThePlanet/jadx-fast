package f.c.a.d.b.h;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class m {

    static final Logger a;
    static {
        m.a = Logger.getLogger(m.class.getName());
    }

    public static void a(InputStream inputStream) {
        if (inputStream == null) {
        }
        inputStream.close();
    }
}
