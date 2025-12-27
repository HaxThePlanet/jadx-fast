package f.c.a.d.b.h;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.FieldDescriptor.Builder;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
final class u implements ObjectEncoderContext {

    private static final Charset f;
    private static final FieldDescriptor g;
    private static final FieldDescriptor h;
    private static final ObjectEncoder<Map.Entry<Object, Object>> i;
    private OutputStream a;
    private final Map<Class<?>, ObjectEncoder<?>> b;
    private final Map<Class<?>, ValueEncoder<?>> c;
    private final ObjectEncoder<Object> d;
    private final y e = new y();
    static {
        u.f = Charset.forName("UTF-8");
        f.c.a.d.b.h.o oVar = new o();
        oVar.a(1);
        u.g = FieldDescriptor.builder("key").withProperty(oVar.b()).build();
        f.c.a.d.b.h.o oVar2 = new o();
        oVar2.a(2);
        u.h = FieldDescriptor.builder("value").withProperty(oVar2.b()).build();
        u.i = t.a;
    }

    u(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        super();
        final f.c.a.d.b.h.y yVar = new y(this);
        this.a = outputStream;
        this.b = map;
        this.c = map2;
        this.d = objectEncoder;
    }

    static /* synthetic */ void g(Map.Entry map, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(u.g, map.getKey());
        objectEncoderContext.add(u.h, map.getValue());
    }

    private static int h(FieldDescriptor fieldDescriptor) throws EncodingException {
        java.lang.annotation.Annotation property = fieldDescriptor.getProperty(s.class);
        if (property == null) {
            throw new EncodingException("Field has no @Protobuf config");
        } else {
            return property.zza();
        }
    }

    private final <T> long i(ObjectEncoder<T> objectEncoder, T t) {
        final f.c.a.d.b.h.p pVar = new p();
        try {
            this.a = pVar;
        } catch (Throwable th) {
        }
        try {
            th.encode(t, this);
        } catch (Throwable th) {
        }
        try {
            this.a = this.a;
        } catch (Throwable th) {
        }
        pVar.close();
        return pVar.a();
    }

    private static s j(FieldDescriptor fieldDescriptor) throws EncodingException {
        java.lang.annotation.Annotation property = fieldDescriptor.getProperty(s.class);
        if (property == null) {
            throw new EncodingException("Field has no @Protobuf config");
        } else {
            return property;
        }
    }

    private final <T> u k(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) {
        final long l2 = i(objectEncoder, t);
        if (z) {
            long l = 0L;
            if (l2 == l) {
                return this;
            }
        }
        n((u.h(fieldDescriptor) << 3) | 2);
        o(l2);
        objectEncoder.encode(t, this);
        return this;
    }

    private final <T> u l(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) {
        this.e.a(fieldDescriptor, z);
        valueEncoder.encode(t, this.e);
        return this;
    }

    private static ByteBuffer m(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void n(int i) throws java.io.IOException {
        long l = (long)(i & (-128));
        while (l != 0) {
            this.a.write((i & 127) | 128);
            l = (long)(i & -128);
        }
        this.a.write(i & 127);
    }

    private final void o(long j) throws java.io.IOException {
        long l = -128L & j;
        while (l != 0) {
            this.a.write((int)j & 127 | 128);
            l = -128L & j;
        }
        this.a.write((int)j & 127);
    }

    final ObjectEncoderContext a(FieldDescriptor fieldDescriptor, double d, boolean z) throws java.io.IOException {
        if (z) {
            d = 0.0d;
            if (d == 0.0d) {
                return this;
            }
        }
        n((u.h(fieldDescriptor) << 3) | 1);
        this.a.write(u.m(8).putDouble(d).array());
        return this;
    }

    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d) {
        a(fieldDescriptor, d, true);
        return this;
    }

    final ObjectEncoderContext b(FieldDescriptor fieldDescriptor, float f, boolean z) throws java.io.IOException {
        if (z) {
            if (f == 0) {
                return this;
            }
        }
        n((u.h(fieldDescriptor) << 3) | 5);
        this.a.write(u.m(4).putFloat(f).array());
        return this;
    }

    final ObjectEncoderContext c(FieldDescriptor fieldDescriptor, Object object, boolean z) throws java.io.IOException, java.io.UnsupportedEncodingException {
        if (object == null) {
            return this;
        }
        if (object instanceof CharSequence) {
            if (z && object.length() == 0) {
                return this;
            }
            n((u.h(fieldDescriptor) << 3) | 2);
            byte[] bytes = object.toString().getBytes(u.f);
            n(bytes.length);
            this.a.write(bytes);
            return this;
        }
        boolean z12 = false;
        if (object instanceof Collection) {
            Iterator it2 = object.iterator();
            while (it2.hasNext()) {
                c(fieldDescriptor, it2.next(), z12);
            }
            return this;
        }
        z = object instanceof Map;
        if (object instanceof Map) {
            Iterator it = object.entrySet().iterator();
            while (it.hasNext()) {
                k(u.i, fieldDescriptor, (Map.Entry)it.next(), z12);
            }
            return this;
        }
        if (object instanceof Double) {
            a(fieldDescriptor, object.doubleValue(), z);
            return this;
        }
        if (object instanceof Float) {
            b(fieldDescriptor, object.floatValue(), z);
            return this;
        }
        if (object instanceof Number) {
            e(fieldDescriptor, object.longValue(), z);
            return this;
        }
        if (object instanceof Boolean) {
            d(fieldDescriptor, object.booleanValue(), z);
            return this;
        }
        if (object instanceof byte[]) {
            if (z) {
                length2 = object.length;
                if (object.length == 0) {
                    return this;
                }
            }
            n((u.h(fieldDescriptor) << 3) | 2);
            n(object.length);
            this.a.write(object);
            return this;
        }
        Object value2 = this.b.get(object.getClass());
        if (value2 != null) {
            k(value2, fieldDescriptor, object, z);
            return this;
        }
        Object value3 = this.c.get(object.getClass());
        if (value3 != null) {
            l(value3, fieldDescriptor, object, z);
            return this;
        }
        boolean z13 = true;
        if (object instanceof q) {
            d(fieldDescriptor, object.getNumber(), z13);
            return this;
        }
        if (object instanceof Enum) {
            d(fieldDescriptor, object.ordinal(), z13);
            return this;
        }
        k(this.d, fieldDescriptor, object, z);
        return this;
    }

    final u d(FieldDescriptor fieldDescriptor, int i, boolean z) throws java.io.IOException {
        f.c.a.d.b.h.s sVar = u.j(fieldDescriptor);
        int ordinal = sVar.zzb().ordinal();
        if (ordinal == 0) {
            i3 = sVar.zza() << 3;
            n(i3);
            n(i);
        } else {
            i = 1;
            if (ordinal == 1) {
                n(sVar.zza() << 3);
                i3 = (i + i) ^ (i >> 31);
                n(i3);
            } else {
                i = 2;
                if (ordinal == 2) {
                    n((sVar.zza() << 3) | 5);
                    this.a.write(u.m(4).putInt(i).array());
                }
            }
        }
        return this;
    }

    final u e(FieldDescriptor fieldDescriptor, long j, boolean z) throws java.io.IOException {
        long l = 0;
        if (z) {
            l = 0L;
            return this;
        }
        f.c.a.d.b.h.s sVar = u.j(fieldDescriptor);
        int ordinal = sVar.zzb().ordinal();
        if (ordinal == 0) {
            i2 = sVar.zza() << 3;
            n(i2);
            o(j);
        } else {
            int i3 = 1;
            if (ordinal == i3) {
                n(sVar.zza() << 3);
                l = j + j;
                o((j >> 63L) ^ l);
            } else {
                int i = 2;
                if (ordinal == 2) {
                    n((sVar.zza() << 3) | i3);
                    this.a.write(u.m(8).putLong(j).array());
                }
            }
        }
        return this;
    }

    final u f(Object object) throws EncodingException {
        if (object == null) {
            return this;
        }
        Object value = this.b.get(object.getClass());
        if (value == null) {
            String str3 = String.valueOf(object.getClass());
            String.valueOf(str3).length();
            throw new EncodingException("No encoder for ".concat(String.valueOf(str3)));
        } else {
            value.encode(object, this);
            return this;
        }
    }

    public final ObjectEncoderContext inline(Object object) {
        f(object);
        return this;
    }

    public final ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) throws EncodingException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f) {
        b(fieldDescriptor, f, true);
        return this;
    }

    public final ObjectEncoderContext nested(String str) {
        nested(FieldDescriptor.of(str));
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) {
        d(fieldDescriptor, i, true);
        return this;
    }

    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) {
        e(fieldDescriptor, j, true);
        return this;
    }

    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object object) {
        c(fieldDescriptor, object, true);
        return this;
    }

    public final /* synthetic */ ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) {
        d(fieldDescriptor, z, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, double d) {
        a(FieldDescriptor.of(str), d, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, int i) {
        d(FieldDescriptor.of(str), i, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, long j) {
        e(FieldDescriptor.of(str), j, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, Object object) {
        c(FieldDescriptor.of(str), object, true);
        return this;
    }

    public final ObjectEncoderContext add(String str, boolean z) {
        d(FieldDescriptor.of(str), z, true);
        return this;
    }
}
