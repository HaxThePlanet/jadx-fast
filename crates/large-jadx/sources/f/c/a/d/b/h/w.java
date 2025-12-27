package f.c.a.d.b.h;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
public final class w implements EncoderConfig<w> {

    private static final ObjectEncoder<Object> d;
    public static final /* synthetic */ int e = 0;
    private final Map<Class<?>, ObjectEncoder<?>> a = new HashMap<>();
    private final Map<Class<?>, ValueEncoder<?>> b = new HashMap<>();
    private final ObjectEncoder<Object> c;
    static {
        w.d = v.a;
    }

    public w() {
        super();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        this.c = w.d;
    }

    public final x a() {
        return new x(new HashMap(this.a), new HashMap(this.b), this.c);
    }
}
