package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    private final ReflectionAccessor accessor;
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    static abstract class BoundField {

        final boolean deserialized;
        final String name;
        final boolean serialized;
        protected BoundField(String string, boolean z2, boolean z3) {
            super();
            this.name = string;
            this.serialized = z2;
            this.deserialized = z3;
        }

        abstract void read(JsonReader jsonReader, Object object2);

        abstract void write(JsonWriter jsonWriter, Object object2);

        abstract boolean writeField(Object object);
    }

    public static final class Adapter extends TypeAdapter<T> {

        private final Map<String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> boundFields;
        private final ObjectConstructor<T> constructor;
        Adapter(ObjectConstructor<T> objectConstructor, Map<String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> map2) {
            super();
            this.constructor = objectConstructor;
            this.boundFields = map2;
        }

        public T read(JsonReader jsonReader) {
            JsonToken nULL;
            boolean boundFields;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return 0;
            }
            Object construct = this.constructor.construct();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                nULL = this.boundFields.get(jsonReader.nextName());
                if ((ReflectiveTypeAdapterFactory.BoundField)nULL != null) {
                } else {
                }
                jsonReader.skipValue();
                if (!nULL.deserialized) {
                } else {
                }
                (ReflectiveTypeAdapterFactory.BoundField)nULL.read(jsonReader, construct);
            }
            jsonReader.endObject();
            return construct;
        }

        public void write(JsonWriter jsonWriter, T t2) {
            Object next;
            boolean field;
            if (t2 == null) {
                jsonWriter.nullValue();
            }
            jsonWriter.beginObject();
            Iterator iterator = this.boundFields.values().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((ReflectiveTypeAdapterFactory.BoundField)next.writeField(t2)) {
                }
                jsonWriter.name(next.name);
                next.write(jsonWriter, t2);
            }
            jsonWriter.endObject();
        }
    }
    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy2, Excluder excluder3, com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory4) {
        super();
        this.accessor = ReflectionAccessor.getInstance();
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy2;
        this.excluder = excluder3;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory4;
    }

    private com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField createBoundField(Gson gson, Field field2, String string3, TypeToken<?> typeToken4, boolean z5, boolean z6) {
        int typeAdapter;
        com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
        int i;
        ConstructorConstructor constructorConstructor;
        final Object obj2 = this;
        Gson gson2 = gson;
        TypeToken typeToken = typeToken4;
        Field field = field2;
        java.lang.annotation.Annotation annotation = field2.getAnnotation(JsonAdapter.class);
        if ((JsonAdapter)annotation != null) {
            typeAdapter = obj2.jsonAdapterFactory.getTypeAdapter(obj2.constructorConstructor, gson, typeToken, (JsonAdapter)annotation);
        } else {
            typeAdapter = 0;
        }
        i = typeAdapter != null ? 1 : 0;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        super(this, string3, z5, z6, field2, i, typeAdapter, gson, typeToken4, Primitives.isPrimitive(typeToken4.getRawType()));
        return anon;
    }

    static boolean excludeField(Field field, boolean z2, Excluder excluder3) {
        Field obj1;
        if (!excluder3.excludeClass(field.getType(), z2) && !excluder3.excludeField(field, z2)) {
            obj1 = !excluder3.excludeField(field, z2) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private Map<String, com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken2, Class<?> class3) {
        boolean interface;
        Class<Object> excludeField2;
        java.lang.reflect.Type genericSuperclass;
        int i5;
        int i;
        int size;
        List fieldNames;
        Field field2;
        TypeToken typeToken;
        Class<Object> rawType;
        Field[] declaredFields;
        int length;
        int i4;
        int i2;
        boolean excludeField;
        java.lang.reflect.Type resolve;
        int i6;
        List list;
        int i3;
        int i7;
        Field field;
        Object obj25;
        final Object obj5 = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (class3.isInterface()) {
            return linkedHashMap;
        }
        typeToken = typeToken2;
        rawType = class3;
        while (rawType != Object.class) {
            declaredFields = rawType.getDeclaredFields();
            i2 = i4;
            while (i2 < declaredFields.length) {
                field2 = declaredFields[i2];
                excludeField = obj5.excludeField(field2, i4);
                obj5.accessor.makeAccessible(field2);
                size = obj5.getFieldNames(field2).size();
                i = genericSuperclass;
                i5 = i4;
                while (i5 < size) {
                    if (i5 != 0) {
                    } else {
                    }
                    i6 = excludeField2;
                    obj25 = obj3;
                    int i10 = i;
                    if (i10 == 0) {
                    } else {
                    }
                    i = i10;
                    i5 = i3 + 1;
                    excludeField2 = i6;
                    fieldNames = list;
                    size = i7;
                    field2 = field;
                    i4 = 0;
                    i = obj2;
                    i6 = i4;
                }
                i4 = i;
                i2++;
                i4 = 0;
                if (i5 != 0) {
                } else {
                }
                i6 = excludeField2;
                obj25 = obj3;
                i10 = i;
                if (i10 == 0) {
                } else {
                }
                i = i10;
                i5 = i3 + 1;
                excludeField2 = i6;
                fieldNames = list;
                size = i7;
                field2 = field;
                i4 = 0;
                i = obj2;
                i6 = i4;
            }
            rawType = TypeToken.get(.Gson.Types.resolve(typeToken.getType(), rawType, rawType.getGenericSuperclass())).getRawType();
            field2 = declaredFields[i2];
            excludeField = obj5.excludeField(field2, i4);
            obj5.accessor.makeAccessible(field2);
            size = obj5.getFieldNames(field2).size();
            i = genericSuperclass;
            i5 = i4;
            while (i5 < size) {
                if (i5 != 0) {
                } else {
                }
                i6 = excludeField2;
                obj25 = obj3;
                i10 = i;
                if (i10 == 0) {
                } else {
                }
                i = i10;
                i5 = i3 + 1;
                excludeField2 = i6;
                fieldNames = list;
                size = i7;
                field2 = field;
                i4 = 0;
                i = obj2;
                i6 = i4;
            }
            i4 = i;
            i2++;
            i4 = 0;
            if (i5 != 0) {
            } else {
            }
            i6 = excludeField2;
            obj25 = obj3;
            i10 = i;
            if (i10 == 0) {
            } else {
            }
            i = i10;
            i5 = i3 + 1;
            excludeField2 = i6;
            fieldNames = list;
            size = i7;
            field2 = field;
            i4 = 0;
            i = obj2;
            i6 = i4;
        }
        return linkedHashMap;
    }

    private List<String> getFieldNames(Field field) {
        int i;
        String str;
        java.lang.annotation.Annotation annotation = field.getAnnotation(SerializedName.class);
        if ((SerializedName)annotation == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String obj5 = (SerializedName)annotation.value();
        String[] alternate = annotation.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(obj5);
        }
        ArrayList arrayList = new ArrayList(length2++);
        arrayList.add(obj5);
        i = 0;
        while (i < alternate.length) {
            arrayList.add(alternate[i]);
            i++;
        }
        return arrayList;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
        final Class rawType = typeToken2.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return 0;
        }
        ReflectiveTypeAdapterFactory.Adapter adapter = new ReflectiveTypeAdapterFactory.Adapter(this.constructorConstructor.get(typeToken2), getBoundFields(gson, typeToken2, rawType));
        return adapter;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public boolean excludeField(Field field, boolean z2) {
        return ReflectiveTypeAdapterFactory.excludeField(field, z2, this.excluder);
    }
}
