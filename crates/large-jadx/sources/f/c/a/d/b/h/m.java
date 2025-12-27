package f.c.a.d.b.h;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
public final class m {

    static final Logger a;
    static {
        m.a = Logger.getLogger(m.class.getName());
    }

    public static void a(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (java.io.IOException ioException) {
            Logger assertionError = new AssertionError(ioException);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) assertionError;
        }
    }

    private m() {
        super();
    }
}
