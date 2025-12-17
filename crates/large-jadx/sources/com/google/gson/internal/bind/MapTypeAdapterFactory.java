package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    private final class Adapter extends TypeAdapter<Map<K, V>> {

        private final ObjectConstructor<? extends Map<K, V>> constructor;
        private final TypeAdapter<K> keyTypeAdapter;
        final com.google.gson.internal.bind.MapTypeAdapterFactory this$0;
        private final TypeAdapter<V> valueTypeAdapter;
        public Adapter(com.google.gson.internal.bind.MapTypeAdapterFactory mapTypeAdapterFactory, Gson gson2, Type type3, TypeAdapter typeAdapter4, Type type5, TypeAdapter typeAdapter6, ObjectConstructor objectConstructor7) {
            this.this$0 = mapTypeAdapterFactory;
            super();
            TypeAdapterRuntimeTypeWrapper obj1 = new TypeAdapterRuntimeTypeWrapper(gson2, typeAdapter4, type3);
            this.keyTypeAdapter = obj1;
            obj1 = new TypeAdapterRuntimeTypeWrapper(gson2, typeAdapter6, type5);
            this.valueTypeAdapter = obj1;
            this.constructor = objectConstructor7;
        }

        private String keyToString(JsonElement jsonElement) {
            JsonPrimitive obj2 = jsonElement.getAsJsonPrimitive();
            if (jsonElement.isJsonPrimitive() && obj2.isNumber()) {
                obj2 = jsonElement.getAsJsonPrimitive();
                if (obj2.isNumber()) {
                    return String.valueOf(obj2.getAsNumber());
                }
                if (obj2.isBoolean()) {
                    return Boolean.toString(obj2.getAsBoolean());
                }
                if (!obj2.isString()) {
                } else {
                    return obj2.getAsString();
                }
                obj2 = new AssertionError();
                throw obj2;
            }
            if (!jsonElement.isJsonNull()) {
            } else {
                return "null";
            }
            obj2 = new AssertionError();
            throw obj2;
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return read(jsonReader);
        }

        public Map<K, V> read(JsonReader jsonReader) {
            JsonToken peek;
            boolean next;
            JsonToken bEGIN_ARRAY;
            peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return 0;
            }
            Object construct = this.constructor.construct();
            final String str = "duplicate key: ";
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    peek = this.keyTypeAdapter.read(jsonReader);
                    jsonReader.endArray();
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                    peek = this.keyTypeAdapter.read(jsonReader);
                }
                jsonReader.endObject();
            }
            return construct;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            write(jsonWriter, (Map)object2);
        }

        public void write(JsonWriter jsonWriter, Map<K, V> map2) {
            boolean complexMapKeySerialization;
            TypeAdapter valueTypeAdapter2;
            int i;
            int valueTypeAdapter;
            int i2;
            boolean jsonObject;
            boolean next;
            JsonElement jsonTree;
            Object key;
            int obj9;
            if (map2 == null) {
                jsonWriter.nullValue();
            }
            if (!this$0.complexMapKeySerialization) {
                jsonWriter.beginObject();
                obj9 = map2.entrySet().iterator();
                for (Map.Entry next3 : obj9) {
                    jsonWriter.name(String.valueOf(next3.getKey()));
                    this.valueTypeAdapter.write(jsonWriter, next3.getValue());
                }
                jsonWriter.endObject();
            }
            ArrayList arrayList = new ArrayList(map2.size());
            ArrayList arrayList2 = new ArrayList(map2.size());
            obj9 = map2.entrySet().iterator();
            i = 0;
            valueTypeAdapter = i;
            while (obj9.hasNext()) {
                Object next4 = obj9.next();
                jsonTree = this.keyTypeAdapter.toJsonTree((Map.Entry)next4.getKey());
                arrayList.add(jsonTree);
                arrayList2.add(next4.getValue());
                if (!jsonTree.isJsonArray()) {
                } else {
                }
                i2 = 1;
                valueTypeAdapter |= i2;
                if (jsonTree.isJsonObject()) {
                } else {
                }
                i2 = i;
            }
            if (valueTypeAdapter != null) {
                jsonWriter.beginArray();
                while (i < arrayList.size()) {
                    jsonWriter.beginArray();
                    Streams.write((JsonElement)arrayList.get(i), jsonWriter);
                    this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                    jsonWriter.endArray();
                    i++;
                }
                jsonWriter.endArray();
            } else {
                jsonWriter.beginObject();
                while (i < arrayList.size()) {
                    jsonWriter.name(keyToString((JsonElement)arrayList.get(i)));
                    this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                    i++;
                }
                jsonWriter.endObject();
            }
        }
    }
    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean z2) {
        super();
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = z2;
    }

    private TypeAdapter<?> getKeyAdapter(Gson gson, Type type2) {
        Class<Boolean> tYPE;
        TypeAdapter obj2;
        Object obj3;
        if (type2 != Boolean.TYPE) {
            if (type2 == Boolean.class) {
                obj2 = TypeAdapters.BOOLEAN_AS_STRING;
            } else {
                obj2 = gson.getAdapter(TypeToken.get(type2));
            }
        } else {
        }
        return obj2;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
        Type type = typeToken2.getType();
        if (!Map.class.isAssignableFrom(typeToken2.getRawType())) {
            return 0;
        }
        Type[] mapKeyAndValueTypes = .Gson.Types.getMapKeyAndValueTypes(type, .Gson.Types.getRawType(type));
        int i = 0;
        int i2 = 1;
        super(this, gson, mapKeyAndValueTypes[i], getKeyAdapter(gson, mapKeyAndValueTypes[i]), mapKeyAndValueTypes[i2], gson.getAdapter(TypeToken.get(mapKeyAndValueTypes[i2])), this.constructorConstructor.get(typeToken2));
        return obj13;
    }
}
