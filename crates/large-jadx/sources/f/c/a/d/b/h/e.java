package f.c.a.d.b.h;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
@Encodable
/* loaded from: classes2.dex */
public abstract class e {

    private static final x a;
    static {
        f.c.a.d.b.h.w wVar = new w();
        d.a.configure(wVar);
        e.a = wVar.a();
    }

    public static void b(Object object, OutputStream outputStream) {
        e.a.a(object, outputStream);
    }

    public static byte[] c(Object object) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e.a.a(object, byteArrayOutputStream);
        } catch (java.io.IOException unused) {
            return byteArrayOutputStream.toByteArray();
        }
    }

    private e() {
        super();
    }

    public abstract MessagingClientEventExtension a();
}
