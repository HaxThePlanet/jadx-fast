package f.c.a.d.b.h;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import java.io.OutputStream;
import java.util.Map;

/* loaded from: classes2.dex */
public final class x {

    private final Map<Class<?>, ObjectEncoder<?>> a;
    private final Map<Class<?>, ValueEncoder<?>> b;
    private final ObjectEncoder<Object> c;
    x(Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder3) {
        super();
        this.a = map;
        this.b = map2;
        this.c = objectEncoder3;
    }

    public final void a(Object object, OutputStream outputStream2) {
        u uVar = new u(outputStream2, this.a, this.b, this.c);
        uVar.f(object);
    }
}
