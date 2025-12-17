package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {

    private boolean active = true;
    private com.google.firebase.encoders.json.JsonValueObjectEncoderContext childContext = null;
    private final ObjectEncoder<Object> fallbackEncoder;
    private final boolean ignoreNullValues;
    private final JsonWriter jsonWriter;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;
    private JsonValueObjectEncoderContext(com.google.firebase.encoders.json.JsonValueObjectEncoderContext jsonValueObjectEncoderContext) {
        super();
        int i = 0;
        int i2 = 1;
        this.jsonWriter = jsonValueObjectEncoderContext.jsonWriter;
        this.objectEncoders = jsonValueObjectEncoderContext.objectEncoders;
        this.valueEncoders = jsonValueObjectEncoderContext.valueEncoders;
        this.fallbackEncoder = jsonValueObjectEncoderContext.fallbackEncoder;
        this.ignoreNullValues = jsonValueObjectEncoderContext.ignoreNullValues;
    }

    JsonValueObjectEncoderContext(Writer writer, Map<Class<?>, ObjectEncoder<?>> map2, Map<Class<?>, ValueEncoder<?>> map3, ObjectEncoder<Object> objectEncoder4, boolean z5) {
        super();
        int i = 0;
        int i2 = 1;
        JsonWriter jsonWriter = new JsonWriter(writer);
        this.jsonWriter = jsonWriter;
        this.objectEncoders = map2;
        this.valueEncoders = map3;
        this.fallbackEncoder = objectEncoder4;
        this.ignoreNullValues = z5;
    }

    private boolean cannotBeInline(Object object) {
        boolean array;
        int obj2;
        if (object != null && !object.getClass().isArray() && object instanceof Collection == null && !object instanceof Date && !object instanceof Enum) {
            if (!object.getClass().isArray()) {
                if (object instanceof Collection == null) {
                    if (!object instanceof Date) {
                        if (!object instanceof Enum) {
                            if (object instanceof Number) {
                                obj2 = 1;
                            } else {
                                obj2 = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private com.google.firebase.encoders.json.JsonValueObjectEncoderContext internalAdd(String string, Object object2) {
        maybeUnNest();
        this.jsonWriter.name(string);
        if (object2 == null) {
            this.jsonWriter.nullValue();
            return this;
        }
        return add(object2, false);
    }

    private com.google.firebase.encoders.json.JsonValueObjectEncoderContext internalAddIgnoreNullValues(String string, Object object2) {
        if (object2 == null) {
            return this;
        }
        maybeUnNest();
        this.jsonWriter.name(string);
        return add(object2, false);
    }

    private void maybeUnNest() {
        Object childContext;
        int i;
        if (!this.active) {
        } else {
            childContext = this.childContext;
            if (childContext != null) {
                childContext.maybeUnNest();
                childContext2.active = false;
                this.childContext = 0;
                this.jsonWriter.endObject();
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        throw illegalStateException;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d2) {
        return add(fieldDescriptor.getName(), d2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f2) {
        return add(fieldDescriptor.getName(), (double)f2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i2) {
        return add(fieldDescriptor.getName(), i2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long l2) {
        return add(fieldDescriptor.getName(), l2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object object2) {
        return add(fieldDescriptor.getName(), object2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z2) {
        return add(fieldDescriptor.getName(), z2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, double d2) {
        return add(string, d2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, int i2) {
        return add(string, i2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, long l2) {
        return add(string, l2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, Object object2) {
        return add(string, object2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext add(String string, boolean z2) {
        return add(string, z2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ValueEncoderContext add(double d) {
        return add(d);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ValueEncoderContext add(float f) {
        return add(f);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ValueEncoderContext add(int i) {
        return add(i);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ValueEncoderContext add(long l) {
        return add(l);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ValueEncoderContext add(String string) {
        return add(string);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ValueEncoderContext add(boolean z) {
        return add(z);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ValueEncoderContext add(byte[] bArr) {
        return add(bArr);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(double d) {
        maybeUnNest();
        this.jsonWriter.value(d);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(float f) {
        maybeUnNest();
        this.jsonWriter.value((double)f);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(int i) {
        maybeUnNest();
        this.jsonWriter.value((long)i);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(long l) {
        maybeUnNest();
        this.jsonWriter.value(l);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(Object object, boolean z2) {
        int jsonWriter2;
        int i;
        boolean cannotBeInline;
        boolean key;
        boolean jsonWriter;
        int arr;
        int obj6;
        JsonWriter obj7;
        i = 0;
        if (z2 != null && cannotBeInline(object)) {
            if (cannotBeInline(object)) {
                Object[] arr2 = new Object[1];
                if (object == null) {
                    obj6 = 0;
                } else {
                    obj6 = object.getClass();
                }
                arr2[i] = obj6;
                obj7 = new EncodingException(String.format("%s cannot be encoded inline", arr2));
                throw obj7;
            }
        }
        if (object == null) {
            this.jsonWriter.nullValue();
            return this;
        }
        if (object instanceof Number) {
            this.jsonWriter.value((Number)object);
            return this;
        }
        if (object.getClass().isArray() && object instanceof byte[]) {
            if (object instanceof byte[]) {
                return add((byte[])object);
            }
            this.jsonWriter.beginArray();
            if (object instanceof int[]) {
                while (i < object.length) {
                    this.jsonWriter.value((long)jsonWriter2);
                    i++;
                }
            } else {
                if (object instanceof long[]) {
                    while (i < object.length) {
                        add((long[])object[i]);
                        i++;
                    }
                } else {
                    if (object instanceof double[]) {
                        while (i < object.length) {
                            this.jsonWriter.value((double[])object[i]);
                            i++;
                        }
                    } else {
                        if (object instanceof boolean[]) {
                            while (i < object.length) {
                                this.jsonWriter.value((boolean[])object[i]);
                                i++;
                            }
                        } else {
                            if (object instanceof Number[]) {
                                jsonWriter2 = i;
                                while (jsonWriter2 < object.length) {
                                    add((Number[])object[jsonWriter2], i);
                                    jsonWriter2++;
                                }
                            } else {
                                jsonWriter2 = i;
                                while (jsonWriter2 < object.length) {
                                    add((Object[])object[jsonWriter2], i);
                                    jsonWriter2++;
                                }
                            }
                        }
                    }
                }
            }
            this.jsonWriter.endArray();
            return this;
        }
        if (object instanceof Collection != null) {
            this.jsonWriter.beginArray();
            obj6 = (Collection)object.iterator();
            for (Object obj7 : obj6) {
                add(obj7, i);
            }
            this.jsonWriter.endArray();
            return this;
        }
        if (object instanceof Map != null) {
            this.jsonWriter.beginObject();
            obj6 = (Map)object.entrySet().iterator();
            for (Map.Entry obj7 : obj6) {
                add((String)obj7.getKey(), obj7.getValue());
            }
            this.jsonWriter.endObject();
            return this;
        }
        Object obj = this.objectEncoders.get(object.getClass());
        if ((ObjectEncoder)obj != null) {
            return doEncode((ObjectEncoder)obj, object, z2);
        }
        Object obj2 = this.valueEncoders.get(object.getClass());
        if ((ValueEncoder)obj2 != null) {
            (ValueEncoder)obj2.encode(object, this);
            return this;
        }
        if (object instanceof Enum) {
            add((Enum)object.name());
            return this;
        }
        return doEncode(this.fallbackEncoder, object, z2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(String string) {
        maybeUnNest();
        this.jsonWriter.value(string);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(String string, double d2) {
        maybeUnNest();
        this.jsonWriter.name(string);
        return add(d2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(String string, int i2) {
        maybeUnNest();
        this.jsonWriter.name(string);
        return add(i2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(String string, long l2) {
        maybeUnNest();
        this.jsonWriter.name(string);
        return add(l2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(String string, Object object2) {
        if (this.ignoreNullValues) {
            return internalAddIgnoreNullValues(string, object2);
        }
        return internalAdd(string, object2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(String string, boolean z2) {
        maybeUnNest();
        this.jsonWriter.name(string);
        return add(z2);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(boolean z) {
        maybeUnNest();
        this.jsonWriter.value(z);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public com.google.firebase.encoders.json.JsonValueObjectEncoderContext add(byte[] bArr) {
        JsonWriter jsonWriter;
        int i;
        Object obj3;
        maybeUnNest();
        if (bArr == null) {
            this.jsonWriter.nullValue();
        } else {
            this.jsonWriter.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    void close() {
        maybeUnNest();
        this.jsonWriter.flush();
    }

    com.google.firebase.encoders.json.JsonValueObjectEncoderContext doEncode(ObjectEncoder<Object> objectEncoder, Object object2, boolean z3) {
        JsonWriter jsonWriter;
        JsonWriter obj2;
        if (!z3) {
            this.jsonWriter.beginObject();
        }
        objectEncoder.encode(object2, this);
        if (!z3) {
            this.jsonWriter.endObject();
        }
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext inline(Object object) {
        return add(object, true);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        return nested(fieldDescriptor.getName());
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public ObjectEncoderContext nested(String string) {
        maybeUnNest();
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(this);
        this.childContext = jsonValueObjectEncoderContext;
        this.jsonWriter.name(string);
        this.jsonWriter.beginObject();
        return this.childContext;
    }
}
