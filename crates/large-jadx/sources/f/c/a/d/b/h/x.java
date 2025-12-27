package f.c.a.d.b.h;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import java.io.OutputStream;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
public final class x {

    private final Map<Class<?>, ObjectEncoder<?>> a;
    private final Map<Class<?>, ValueEncoder<?>> b;
    private final ObjectEncoder<Object> c;
    public final void a(Object object, OutputStream outputStream) {
        new u(outputStream, this.a, this.b, this.c).f(object);
    }

    x(Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        super();
        this.a = map;
        this.b = map2;
        this.c = objectEncoder;
    }
}
