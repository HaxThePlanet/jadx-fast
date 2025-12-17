package f.c.a.d.b.h;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class w implements EncoderConfig<f.c.a.d.b.h.w> {

    private static final ObjectEncoder<Object> d;
    public static final int e;
    private final Map<Class<?>, ObjectEncoder<?>> a;
    private final Map<Class<?>, ValueEncoder<?>> b;
    private final ObjectEncoder<Object> c;
    static {
        w.d = v.a;
    }

    public w() {
        super();
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.b = hashMap2;
        this.c = w.d;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public final f.c.a.d.b.h.x a() {
        HashMap hashMap = new HashMap(this.a);
        HashMap hashMap2 = new HashMap(this.b);
        x xVar = new x(hashMap, hashMap2, this.c);
        return xVar;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public final EncoderConfig registerEncoder(Class class, ObjectEncoder objectEncoder2) {
        this.a.put(class, objectEncoder2);
        this.b.remove(class);
        return this;
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public final EncoderConfig registerEncoder(Class class, ValueEncoder valueEncoder2) {
        this.b.put(class, valueEncoder2);
        this.a.remove(class);
        return this;
    }
}
