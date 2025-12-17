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
    private final f.c.a.d.b.h.y e;
    static {
        u.f = Charset.forName("UTF-8");
        o oVar = new o();
        oVar.a(1);
        u.g = FieldDescriptor.builder("key").withProperty(oVar.b()).build();
        o oVar2 = new o();
        oVar2.a(2);
        u.h = FieldDescriptor.builder("value").withProperty(oVar2.b()).build();
        u.i = t.a;
    }

    u(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map2, Map<Class<?>, ValueEncoder<?>> map3, ObjectEncoder<Object> objectEncoder4) {
        super();
        y yVar = new y(this);
        this.e = yVar;
        this.a = outputStream;
        this.b = map2;
        this.c = map3;
        this.d = objectEncoder4;
    }

    static void g(Map.Entry map$Entry, ObjectEncoderContext objectEncoderContext2) {
        objectEncoderContext2.add(u.g, entry.getKey());
        objectEncoderContext2.add(u.h, entry.getValue());
    }

    private static int h(FieldDescriptor fieldDescriptor) {
        java.lang.annotation.Annotation obj1 = fieldDescriptor.getProperty(s.class);
        if ((s)obj1 == null) {
        } else {
            return (s)obj1.zza();
        }
        obj1 = new EncodingException("Field has no @Protobuf config");
        throw obj1;
    }

    private final <T> long i(ObjectEncoder<T> objectEncoder, T t2) {
        p pVar = new p();
        this.a = pVar;
        objectEncoder.encode(t2, this);
        this.a = this.a;
        pVar.close();
        return pVar.a();
    }

    private static f.c.a.d.b.h.s j(FieldDescriptor fieldDescriptor) {
        java.lang.annotation.Annotation obj1 = fieldDescriptor.getProperty(s.class);
        if ((s)obj1 == null) {
        } else {
            return (s)obj1;
        }
        obj1 = new EncodingException("Field has no @Protobuf config");
        throw obj1;
    }

    private final <T> f.c.a.d.b.h.u k(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor2, T t3, boolean z4) {
        int i;
        int obj8;
        final long l = i(objectEncoder, t3);
        if (z4 != 0 && Long.compare(l, i) == 0) {
            if (Long.compare(l, i) == 0) {
                return this;
            }
        }
        n(obj6 |= 2);
        o(l);
        objectEncoder.encode(t3, this);
        return this;
    }

    private final <T> f.c.a.d.b.h.u l(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor2, T t3, boolean z4) {
        this.e.a(fieldDescriptor2, z4);
        valueEncoder.encode(t3, this.e);
        return this;
    }

    private static ByteBuffer m(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void n(int i) {
        while (Long.compare(l, i5) != 0) {
            this.a.write(i3 |= 128);
            i >>>= 7;
        }
        this.a.write(i &= 127);
    }

    private final void o(long l) {
        while (Long.compare(i2, i7) != 0) {
            this.a.write(i5 |= 128);
            l >>>= i3;
        }
        this.a.write(obj5 &= 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    final ObjectEncoderContext a(FieldDescriptor fieldDescriptor, double d2, boolean z3) {
        int i;
        int obj6;
        if (obj6 != null && Double.compare(d2, i) == 0) {
            if (Double.compare(d2, i) == 0) {
                return this;
            }
        }
        n(obj3 |= 1);
        this.a.write(u.m(8).putDouble(d2).array());
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d2) {
        a(fieldDescriptor, d2, obj4);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f2) {
        b(fieldDescriptor, f2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i2) {
        d(fieldDescriptor, i2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long l2) {
        e(fieldDescriptor, l2, obj4);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object object2) {
        c(fieldDescriptor, object2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z2) {
        d(fieldDescriptor, z2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String string, double d2) {
        a(FieldDescriptor.of(string), d2, obj4);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String string, int i2) {
        d(FieldDescriptor.of(string), i2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String string, long l2) {
        e(FieldDescriptor.of(string), l2, obj4);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String string, Object object2) {
        c(FieldDescriptor.of(string), object2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(String string, boolean z2) {
        d(FieldDescriptor.of(string), z2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    final ObjectEncoderContext b(FieldDescriptor fieldDescriptor, float f2, boolean z3) {
        int obj3;
        if (z3 != 0 && Float.compare(f2, obj3) == 0) {
            if (Float.compare(f2, obj3) == 0) {
                return this;
            }
        }
        n(obj1 |= 5);
        this.a.write(u.m(4).putFloat(f2).array());
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    final ObjectEncoderContext c(FieldDescriptor fieldDescriptor, Object object2, boolean z3) {
        boolean z;
        int obj5;
        if (object2 == null) {
            return this;
        }
        if (object2 instanceof CharSequence && z3 && (CharSequence)object2.length() == 0) {
            if (z3) {
                if ((CharSequence)object2.length() == 0) {
                    return this;
                }
            }
            n(obj3 |= 2);
            byte[] obj3 = object2.toString().getBytes(u.f);
            n(obj3.length);
            this.a.write(obj3);
            return this;
        }
        int i = 0;
        if (object2 instanceof Collection != null) {
            Iterator obj4 = (Collection)object2.iterator();
            for (Object obj5 : obj4) {
                c(fieldDescriptor, obj5, i);
            }
            return this;
        }
        if (object2 instanceof Map != null) {
            obj4 = (Map)object2.entrySet().iterator();
            for (Map.Entry obj5 : obj4) {
                k(u.i, fieldDescriptor, obj5, i);
            }
            return this;
        }
        if (object2 instanceof Double) {
            a(fieldDescriptor, (Double)object2.doubleValue(), i);
            return this;
        }
        if (object2 instanceof Float) {
            b(fieldDescriptor, (Float)object2.floatValue(), z3);
            return this;
        }
        if (object2 instanceof Number) {
            e(fieldDescriptor, (Number)object2.longValue(), i);
            return this;
        }
        if (object2 instanceof Boolean) {
            d(fieldDescriptor, (Boolean)object2.booleanValue(), z3);
            return this;
        }
        if (object2 instanceof byte[] && z3 && object2.length == 0) {
            if (z3) {
                if (object2.length == 0) {
                    return this;
                }
            }
            n(obj3 |= 2);
            n(object2.length);
            this.a.write((byte[])(byte[])object2);
            return this;
        }
        Object obj = this.b.get(object2.getClass());
        if ((ObjectEncoder)obj != null) {
            k((ObjectEncoder)obj, fieldDescriptor, object2, z3);
            return this;
        }
        Object obj2 = this.c.get(object2.getClass());
        if ((ValueEncoder)obj2 != null) {
            l((ValueEncoder)obj2, fieldDescriptor, object2, z3);
            return this;
        }
        int i2 = 1;
        if (object2 instanceof q) {
            d(fieldDescriptor, (q)object2.getNumber(), i2);
            return this;
        }
        if (object2 instanceof Enum) {
            d(fieldDescriptor, (Enum)object2.ordinal(), i2);
            return this;
        }
        k(this.d, fieldDescriptor, object2, z3);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    final f.c.a.d.b.h.u d(FieldDescriptor fieldDescriptor, int i2, boolean z3) {
        int i;
        int obj2;
        int obj3;
        int obj4;
        if (z3 && i2 != 0) {
            if (i2 != 0) {
            }
            return this;
        }
        obj2 = u.j(fieldDescriptor);
        obj4 = r.zza;
        obj4 = obj2.zzb().ordinal();
        if (obj4 != null) {
            if (obj4 != 1) {
                if (obj4 != 2) {
                } else {
                    n(obj2 |= 5);
                    this.a.write(u.m(4).putInt(i2).array());
                }
            } else {
                n(obj2 <<= 3);
                n(obj2 ^= obj3);
            }
        } else {
            n(obj2 <<= 3);
            n(i2);
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    final f.c.a.d.b.h.u e(FieldDescriptor fieldDescriptor, long l2, boolean z3) {
        int i;
        int i2;
        int obj3;
        int obj4;
        int obj6;
        if (obj6 != null && Long.compare(l2, i) != 0) {
            if (Long.compare(l2, i) != 0) {
            }
            return this;
        }
        obj3 = u.j(fieldDescriptor);
        obj6 = r.zza;
        obj6 = obj3.zzb().ordinal();
        if (obj6 != null) {
            i = 1;
            if (obj6 != i) {
                if (obj6 != 2) {
                } else {
                    n(obj3 |= i);
                    this.a.write(u.m(8).putLong(l2).array());
                }
            } else {
                n(obj3 <<= 3);
                o(obj3 ^= i);
            }
        } else {
            n(obj3 <<= 3);
            o(l2);
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    final f.c.a.d.b.h.u f(Object object) {
        if (object == null) {
            return this;
        }
        Object obj = this.b.get(object.getClass());
        if ((ObjectEncoder)obj == null) {
        } else {
            (ObjectEncoder)obj.encode(object, this);
            return this;
        }
        String obj3 = String.valueOf(object.getClass());
        String.valueOf(obj3).length();
        EncodingException encodingException = new EncodingException("No encoder for ".concat(String.valueOf(obj3)));
        throw encodingException;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext inline(Object object) {
        f(object);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        EncodingException obj2 = new EncodingException("nested() is not implemented for protobuf encoding.");
        throw obj2;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext nested(String string) {
        nested(FieldDescriptor.of(string));
        throw 0;
    }
}
