package f.c.a.d.b.h;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
@Encodable
public abstract class e {

    private static final f.c.a.d.b.h.x a;
    static {
        w wVar = new w();
        d.a.configure(wVar);
        e.a = wVar.a();
    }

    public static void b(Object object, OutputStream outputStream2) {
        e.a.a(object, outputStream2);
    }

    public static byte[] c(Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e.a.a(object, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public abstract MessagingClientEventExtension a();
}
