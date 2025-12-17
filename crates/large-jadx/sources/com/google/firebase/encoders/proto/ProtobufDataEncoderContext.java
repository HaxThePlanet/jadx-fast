package com.google.firebase.encoders.proto;

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
final class ProtobufDataEncoderContext implements ObjectEncoderContext {

    private static final ObjectEncoder<Map.Entry<Object, Object>> DEFAULT_MAP_ENCODER;
    private static final FieldDescriptor MAP_KEY_DESC;
    private static final FieldDescriptor MAP_VALUE_DESC;
    private static final Charset UTF_8;
    private final ObjectEncoder<Object> fallbackEncoder;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private OutputStream output;
    private final com.google.firebase.encoders.proto.ProtobufValueEncoderContext valueEncoderContext;
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;
    static {
        ProtobufDataEncoderContext.UTF_8 = Charset.forName("UTF-8");
        ProtobufDataEncoderContext.MAP_KEY_DESC = FieldDescriptor.builder("key").withProperty(AtProtobuf.builder().tag(1).build()).build();
        ProtobufDataEncoderContext.MAP_VALUE_DESC = FieldDescriptor.builder("value").withProperty(AtProtobuf.builder().tag(2).build()).build();
        ProtobufDataEncoderContext.DEFAULT_MAP_ENCODER = a.a;
    }

    ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map2, Map<Class<?>, ValueEncoder<?>> map3, ObjectEncoder<Object> objectEncoder4) {
        super();
        ProtobufValueEncoderContext protobufValueEncoderContext = new ProtobufValueEncoderContext(this);
        this.valueEncoderContext = protobufValueEncoderContext;
        this.output = outputStream;
        this.objectEncoders = map2;
        this.valueEncoders = map3;
        this.fallbackEncoder = objectEncoder4;
    }

    static void a(Map.Entry map$Entry, ObjectEncoderContext objectEncoderContext2) {
        objectEncoderContext2.add(ProtobufDataEncoderContext.MAP_KEY_DESC, entry.getKey());
        objectEncoderContext2.add(ProtobufDataEncoderContext.MAP_VALUE_DESC, entry.getValue());
    }

    private static ByteBuffer allocateBuffer(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long determineSize(ObjectEncoder<T> objectEncoder, T t2) {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        this.output = lengthCountingOutputStream;
        objectEncoder.encode(t2, this);
        this.output = this.output;
        lengthCountingOutputStream.close();
        return lengthCountingOutputStream.getLength();
    }

    private <T> com.google.firebase.encoders.proto.ProtobufDataEncoderContext doEncode(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor2, T t3, boolean z4) {
        int i;
        int obj8;
        final long determineSize = determineSize(objectEncoder, t3);
        if (z4 != 0 && Long.compare(determineSize, i) == 0) {
            if (Long.compare(determineSize, i) == 0) {
                return this;
            }
        }
        writeVarInt32(obj6 |= 2);
        writeVarInt64(determineSize);
        objectEncoder.encode(t3, this);
        return this;
    }

    private <T> com.google.firebase.encoders.proto.ProtobufDataEncoderContext doEncode(ValueEncoder<T> valueEncoder, FieldDescriptor fieldDescriptor2, T t3, boolean z4) {
        this.valueEncoderContext.resetContext(fieldDescriptor2, z4);
        valueEncoder.encode(t3, this.valueEncoderContext);
        return this;
    }

    private static com.google.firebase.encoders.proto.Protobuf getProtobuf(FieldDescriptor fieldDescriptor) {
        java.lang.annotation.Annotation obj1 = fieldDescriptor.getProperty(Protobuf.class);
        if ((Protobuf)obj1 == null) {
        } else {
            return (Protobuf)obj1;
        }
        obj1 = new EncodingException("Field has no @Protobuf config");
        throw obj1;
    }

    private static int getTag(FieldDescriptor fieldDescriptor) {
        java.lang.annotation.Annotation obj1 = fieldDescriptor.getProperty(Protobuf.class);
        if ((Protobuf)obj1 == null) {
        } else {
            return (Protobuf)obj1.tag();
        }
        obj1 = new EncodingException("Field has no @Protobuf config");
        throw obj1;
    }

    private void writeVarInt32(int i) {
        while (Long.compare(l, i5) != 0) {
            this.output.write(i3 |= 128);
            i >>>= 7;
        }
        this.output.write(i &= 127);
    }

    private void writeVarInt64(long l) {
        while (Long.compare(i2, i7) != 0) {
            this.output.write(i5 |= 128);
            l >>>= i3;
        }
        this.output.write(obj5 &= 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d2) {
        return add(fieldDescriptor, d2, obj4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d2, boolean z3) {
        int i;
        int obj6;
        if (obj6 != null && Double.compare(d2, i) == 0) {
            if (Double.compare(d2, i) == 0) {
                return this;
            }
        }
        writeVarInt32(obj3 |= 1);
        this.output.write(ProtobufDataEncoderContext.allocateBuffer(8).putDouble(d2).array());
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f2) {
        return add(fieldDescriptor, f2, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f2, boolean z3) {
        int obj3;
        if (z3 != 0 && Float.compare(f2, obj3) == 0) {
            if (Float.compare(f2, obj3) == 0) {
                return this;
            }
        }
        writeVarInt32(obj1 |= 5);
        this.output.write(ProtobufDataEncoderContext.allocateBuffer(4).putFloat(f2).array());
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i2) {
        return add(fieldDescriptor, i2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long l2) {
        return add(fieldDescriptor, l2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object object2) {
        return add(fieldDescriptor, object2, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object object2, boolean z3) {
        boolean dEFAULT_MAP_ENCODER;
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
            writeVarInt32(obj3 |= 2);
            byte[] obj3 = object2.toString().getBytes(ProtobufDataEncoderContext.UTF_8);
            writeVarInt32(obj3.length);
            this.output.write(obj3);
            return this;
        }
        int i = 0;
        if (object2 instanceof Collection != null) {
            Iterator obj4 = (Collection)object2.iterator();
            for (Object obj5 : obj4) {
                add(fieldDescriptor, obj5, i);
            }
            return this;
        }
        if (object2 instanceof Map != null) {
            obj4 = (Map)object2.entrySet().iterator();
            for (Map.Entry obj5 : obj4) {
                doEncode(ProtobufDataEncoderContext.DEFAULT_MAP_ENCODER, fieldDescriptor, obj5, i);
            }
            return this;
        }
        if (object2 instanceof Double) {
            return add(fieldDescriptor, (Double)object2.doubleValue(), i);
        }
        if (object2 instanceof Float) {
            return add(fieldDescriptor, (Float)object2.floatValue(), z3);
        }
        if (object2 instanceof Number) {
            return add(fieldDescriptor, (Number)object2.longValue(), i);
        }
        if (object2 instanceof Boolean) {
            return add(fieldDescriptor, (Boolean)object2.booleanValue(), z3);
        }
        if (object2 instanceof byte[] && z3 && object2.length == 0) {
            if (z3) {
                if (object2.length == 0) {
                    return this;
                }
            }
            writeVarInt32(obj3 |= 2);
            writeVarInt32(object2.length);
            this.output.write((byte[])(byte[])object2);
            return this;
        }
        Object obj = this.objectEncoders.get(object2.getClass());
        if ((ObjectEncoder)obj != null) {
            return doEncode((ObjectEncoder)obj, fieldDescriptor, object2, z3);
        }
        Object obj2 = this.valueEncoders.get(object2.getClass());
        if ((ValueEncoder)obj2 != null) {
            return doEncode((ValueEncoder)obj2, fieldDescriptor, object2, z3);
        }
        if (object2 instanceof ProtoEnum) {
            return add(fieldDescriptor, (ProtoEnum)object2.getNumber());
        }
        if (object2 instanceof Enum) {
            return add(fieldDescriptor, (Enum)object2.ordinal());
        }
        return doEncode(this.fallbackEncoder, fieldDescriptor, object2, z3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z2) {
        return add(fieldDescriptor, z2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, double d2) {
        return add(FieldDescriptor.of(string), d2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, int i2) {
        return add(FieldDescriptor.of(string), i2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, long l2) {
        return add(FieldDescriptor.of(string), l2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, Object object2) {
        return add(FieldDescriptor.of(string), object2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, boolean z2) {
        return add(FieldDescriptor.of(string), z2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.proto.ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, int i2) {
        return add(fieldDescriptor, i2, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    com.google.firebase.encoders.proto.ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, int i2, boolean z3) {
        int i;
        int obj3;
        int obj4;
        int obj5;
        if (z3 && i2 == 0) {
            if (i2 == 0) {
                return this;
            }
        }
        obj3 = ProtobufDataEncoderContext.getProtobuf(fieldDescriptor);
        obj5 = ProtobufDataEncoderContext.1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[obj3.intEncoding().ordinal()];
        final int i3 = 3;
        if (obj5 != 1) {
            if (obj5 != 2) {
                if (obj5 != i3) {
                } else {
                    writeVarInt32(obj3 |= 5);
                    this.output.write(ProtobufDataEncoderContext.allocateBuffer(4).putInt(i2).array());
                }
            } else {
                writeVarInt32(obj3 <<= i3);
                writeVarInt32(obj3 ^= obj4);
            }
        } else {
            writeVarInt32(obj3 <<= i3);
            writeVarInt32(i2);
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.proto.ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, long l2) {
        return add(fieldDescriptor, l2, obj4);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    com.google.firebase.encoders.proto.ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, long l2, boolean z3) {
        int i3;
        int i2;
        int i;
        int obj4;
        int obj5;
        int obj7;
        if (obj7 != null && Long.compare(l2, i3) == 0) {
            if (Long.compare(l2, i3) == 0) {
                return this;
            }
        }
        obj4 = ProtobufDataEncoderContext.getProtobuf(fieldDescriptor);
        obj7 = ProtobufDataEncoderContext.1.$SwitchMap$com$google$firebase$encoders$proto$Protobuf$IntEncoding[obj4.intEncoding().ordinal()];
        i2 = 1;
        final int i4 = 3;
        if (obj7 != i2) {
            if (obj7 != 2) {
                if (obj7 != i4) {
                } else {
                    writeVarInt32(obj4 |= i2);
                    this.output.write(ProtobufDataEncoderContext.allocateBuffer(8).putLong(l2).array());
                }
            } else {
                writeVarInt32(obj4 <<= i4);
                writeVarInt64(obj4 ^= i2);
            }
        } else {
            writeVarInt32(obj4 <<= i4);
            writeVarInt64(l2);
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.proto.ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, boolean z2) {
        return add(fieldDescriptor, z2, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    com.google.firebase.encoders.proto.ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, boolean z2, boolean z3) {
        return add(fieldDescriptor, z2, z3);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    com.google.firebase.encoders.proto.ProtobufDataEncoderContext encode(Object object) {
        if (object == null) {
            return this;
        }
        Object obj = this.objectEncoders.get(object.getClass());
        if ((ObjectEncoder)obj == null) {
        } else {
            (ObjectEncoder)obj.encode(object, this);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No encoder for ");
        stringBuilder.append(object.getClass());
        EncodingException encodingException = new EncodingException(stringBuilder.toString());
        throw encodingException;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext inline(Object object) {
        return encode(object);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        EncodingException obj2 = new EncodingException("nested() is not implemented for protobuf encoding.");
        throw obj2;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(String string) {
        return nested(FieldDescriptor.of(string));
    }
}
