package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes2.dex */
public final class Gson {

    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final TypeToken<?> NULL_KEY_SURROGATE;
    final List<com.google.gson.TypeAdapterFactory> builderFactories;
    final List<com.google.gson.TypeAdapterFactory> builderHierarchyFactories;
    private final java.lang.ThreadLocal<Map<TypeToken<?>, com.google.gson.Gson.FutureTypeAdapter<?>>> calls;
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<com.google.gson.TypeAdapterFactory> factories;
    final com.google.gson.FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, com.google.gson.InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final com.google.gson.LongSerializationPolicy longSerializationPolicy;
    final boolean prettyPrinting;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final int timeStyle;
    private final Map<TypeToken<?>, com.google.gson.TypeAdapter<?>> typeTokenCache;

    static class FutureTypeAdapter extends com.google.gson.TypeAdapter<T> {

        private com.google.gson.TypeAdapter<T> delegate;
        public T read(JsonReader jsonReader) {
            final com.google.gson.TypeAdapter delegate = this.delegate;
            if (delegate == null) {
            } else {
                return delegate.read(jsonReader);
            }
            IllegalStateException obj2 = new IllegalStateException();
            throw obj2;
        }

        public void setDelegate(com.google.gson.TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
            } else {
                this.delegate = typeAdapter;
            }
            AssertionError obj2 = new AssertionError();
            throw obj2;
        }

        public void write(JsonWriter jsonWriter, T t2) {
            final com.google.gson.TypeAdapter delegate = this.delegate;
            if (delegate == null) {
            } else {
                delegate.write(jsonWriter, t2);
            }
            IllegalStateException obj2 = new IllegalStateException();
            throw obj2;
        }
    }
    static {
        Gson.NULL_KEY_SURROGATE = TypeToken.get(Object.class);
    }

    public Gson() {
        super(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), 0, 0, 0, 1, 0, 0, 0, LongSerializationPolicy.DEFAULT, 0, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    Gson(Excluder excluder, com.google.gson.FieldNamingStrategy fieldNamingStrategy2, Map<Type, com.google.gson.InstanceCreator<?>> map3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, com.google.gson.LongSerializationPolicy longSerializationPolicy11, String string12, int i13, int i14, List<com.google.gson.TypeAdapterFactory> list15, List<com.google.gson.TypeAdapterFactory> list16, List<com.google.gson.TypeAdapterFactory> list17) {
        final Object obj = this;
        boolean z13 = z5;
        boolean z14 = z10;
        super();
        ThreadLocal threadLocal = new ThreadLocal();
        obj.calls = threadLocal;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        obj.typeTokenCache = concurrentHashMap;
        obj.excluder = excluder;
        obj.fieldNamingStrategy = fieldNamingStrategy2;
        obj.instanceCreators = map3;
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(map3);
        obj.constructorConstructor = constructorConstructor;
        obj.serializeNulls = z4;
        obj.complexMapKeySerialization = z13;
        obj.generateNonExecutableJson = z6;
        obj.htmlSafe = z7;
        obj.prettyPrinting = z8;
        obj.lenient = z9;
        obj.serializeSpecialFloatingPointValues = z14;
        obj.longSerializationPolicy = longSerializationPolicy11;
        obj.datePattern = string12;
        obj.dateStyle = i13;
        obj.timeStyle = i14;
        obj.builderFactories = list15;
        obj.builderHierarchyFactories = list16;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(ObjectTypeAdapter.FACTORY);
        arrayList.add(excluder);
        arrayList.addAll(list17);
        arrayList.add(TypeAdapters.STRING_FACTORY);
        arrayList.add(TypeAdapters.INTEGER_FACTORY);
        arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.BYTE_FACTORY);
        arrayList.add(TypeAdapters.SHORT_FACTORY);
        com.google.gson.TypeAdapter longAdapter = Gson.longAdapter(longSerializationPolicy11);
        arrayList.add(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter));
        arrayList.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(z14)));
        arrayList.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(z14)));
        arrayList.add(TypeAdapters.NUMBER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(TypeAdapters.newFactory(AtomicLong.class, Gson.atomicLongAdapter(longAdapter)));
        arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, Gson.atomicLongArrayAdapter(longAdapter)));
        arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        arrayList.add(TypeAdapters.URL_FACTORY);
        arrayList.add(TypeAdapters.URI_FACTORY);
        arrayList.add(TypeAdapters.UUID_FACTORY);
        arrayList.add(TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(TypeAdapters.LOCALE_FACTORY);
        arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(DateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CALENDAR_FACTORY);
        arrayList.add(TimeTypeAdapter.FACTORY);
        arrayList.add(SqlDateTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.TIMESTAMP_FACTORY);
        arrayList.add(ArrayTypeAdapter.FACTORY);
        arrayList.add(TypeAdapters.CLASS_FACTORY);
        CollectionTypeAdapterFactory collectionTypeAdapterFactory = new CollectionTypeAdapterFactory(constructorConstructor);
        arrayList.add(collectionTypeAdapterFactory);
        MapTypeAdapterFactory mapTypeAdapterFactory = new MapTypeAdapterFactory(constructorConstructor, z13);
        arrayList.add(mapTypeAdapterFactory);
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        obj.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.ENUM_FACTORY);
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = new ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingStrategy2, excluder, jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(reflectiveTypeAdapterFactory);
        obj.factories = Collections.unmodifiableList(arrayList);
    }

    private static void assertFullConsumption(Object object, JsonReader jsonReader2) {
        Object obj0;
        Object obj1;
        if (object != null) {
            if (jsonReader2.peek() != JsonToken.END_DOCUMENT) {
            } else {
                try {
                    obj0 = new JsonIOException("JSON document was not fully consumed.");
                    throw obj0;
                    jsonReader2 = new JsonIOException(object);
                    throw jsonReader2;
                    jsonReader2 = new JsonSyntaxException(object);
                    throw jsonReader2;
                }
            }
        }
    }

    private static com.google.gson.TypeAdapter<AtomicLong> atomicLongAdapter(com.google.gson.TypeAdapter<Number> typeAdapter) {
        Gson.4 anon = new Gson.4(typeAdapter);
        return anon.nullSafe();
    }

    private static com.google.gson.TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(com.google.gson.TypeAdapter<Number> typeAdapter) {
        Gson.5 anon = new Gson.5(typeAdapter);
        return anon.nullSafe();
    }

    static void checkValidFloatingPoint(double d) {
        boolean naN;
        if (Double.isNaN(d)) {
        } else {
            if (Double.isInfinite(d)) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private com.google.gson.TypeAdapter<Number> doubleAdapter(boolean z) {
        if (z) {
            return TypeAdapters.DOUBLE;
        }
        Gson.1 obj1 = new Gson.1(this);
        return obj1;
    }

    private com.google.gson.TypeAdapter<Number> floatAdapter(boolean z) {
        if (z) {
            return TypeAdapters.FLOAT;
        }
        Gson.2 obj1 = new Gson.2(this);
        return obj1;
    }

    private static com.google.gson.TypeAdapter<Number> longAdapter(com.google.gson.LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return TypeAdapters.LONG;
        }
        Gson.3 obj1 = new Gson.3();
        return obj1;
    }

    public Excluder excluder() {
        return this.excluder;
    }

    public com.google.gson.FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public <T> T fromJson(com.google.gson.JsonElement jsonElement, Class<T> class2) {
        return Primitives.wrap(class2).cast(fromJson(jsonElement, class2));
    }

    public <T> T fromJson(com.google.gson.JsonElement jsonElement, Type type2) {
        if (jsonElement == null) {
            return 0;
        }
        JsonTreeReader jsonTreeReader = new JsonTreeReader(jsonElement);
        return fromJson(jsonTreeReader, type2);
    }

    public <T> T fromJson(JsonReader jsonReader, Type type2) {
        jsonReader.setLenient(true);
        jsonReader.peek();
        int i2 = 0;
        jsonReader.setLenient(jsonReader.isLenient());
        return getAdapter(TypeToken.get(type2)).read(jsonReader);
    }

    public <T> T fromJson(Reader reader, Class<T> class2) {
        JsonReader obj2 = newJsonReader(reader);
        final Object json = fromJson(obj2, class2);
        Gson.assertFullConsumption(json, obj2);
        return Primitives.wrap(class2).cast(json);
    }

    public <T> T fromJson(Reader reader, Type type2) {
        final JsonReader obj1 = newJsonReader(reader);
        final Object obj2 = fromJson(obj1, type2);
        Gson.assertFullConsumption(obj2, obj1);
        return obj2;
    }

    public <T> T fromJson(String string, Class<T> class2) {
        return Primitives.wrap(class2).cast(fromJson(string, class2));
    }

    public <T> T fromJson(String string, Type type2) {
        if (string == null) {
            return 0;
        }
        StringReader stringReader = new StringReader(string);
        return fromJson(stringReader, type2);
    }

    public <T> com.google.gson.TypeAdapter<T> getAdapter(TypeToken<T> typeToken) {
        Object hashMap;
        TypeToken nULL_KEY_SURROGATE;
        int i;
        Throwable th;
        com.google.gson.TypeAdapter create;
        Object obj6;
        nULL_KEY_SURROGATE = typeToken == null ? Gson.NULL_KEY_SURROGATE : typeToken;
        Object obj = this.typeTokenCache.get(nULL_KEY_SURROGATE);
        if ((TypeAdapter)obj != null) {
            return (TypeAdapter)obj;
        }
        i = 0;
        if ((Map)this.calls.get() == null) {
            hashMap = new HashMap();
            this.calls.set(hashMap);
            i = 1;
        }
        Object obj2 = hashMap.get(typeToken);
        if ((Gson.FutureTypeAdapter)obj2 != null) {
            return (Gson.FutureTypeAdapter)obj2;
        }
        Gson.FutureTypeAdapter futureTypeAdapter = new Gson.FutureTypeAdapter();
        hashMap.put(typeToken, futureTypeAdapter);
        Iterator iterator = this.factories.iterator();
        for (TypeAdapterFactory next2 : iterator) {
            create = next2.create(this, typeToken);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GSON (2.8.8) cannot handle ");
        stringBuilder.append(typeToken);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public <T> com.google.gson.TypeAdapter<T> getAdapter(Class<T> class) {
        return getAdapter(TypeToken.get(class));
    }

    public <T> com.google.gson.TypeAdapter<T> getDelegateAdapter(com.google.gson.TypeAdapterFactory typeAdapterFactory, TypeToken<T> typeToken2) {
        int i;
        Object create;
        Object obj4;
        if (!this.factories.contains(typeAdapterFactory)) {
            obj4 = this.jsonAdapterFactory;
        }
        i = 0;
        Iterator iterator = this.factories.iterator();
        for (TypeAdapterFactory create : iterator) {
            create = create.create(this, typeToken2);
            if (create == obj4) {
            }
            i = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GSON cannot serialize ");
        stringBuilder.append(typeToken2);
        obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public com.google.gson.GsonBuilder newBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder(this);
        return gsonBuilder;
    }

    public JsonReader newJsonReader(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(this.lenient);
        return jsonReader;
    }

    public JsonWriter newJsonWriter(Writer writer) {
        boolean generateNonExecutableJson;
        boolean obj2;
        if (this.generateNonExecutableJson) {
            writer.write(")]}'\n");
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public String toJson(com.google.gson.JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, stringWriter);
        return stringWriter.toString();
    }

    public String toJson(Object object) {
        if (object == null) {
            return toJson(JsonNull.INSTANCE);
        }
        return toJson(object, object.getClass());
    }

    public String toJson(Object object, Type type2) {
        StringWriter stringWriter = new StringWriter();
        toJson(object, type2, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(com.google.gson.JsonElement jsonElement, JsonWriter jsonWriter2) {
        jsonWriter2.setLenient(true);
        jsonWriter2.setHtmlSafe(this.htmlSafe);
        jsonWriter2.setSerializeNulls(this.serializeNulls);
        Streams.write(jsonElement, jsonWriter2);
        jsonWriter2.setLenient(jsonWriter2.isLenient());
        jsonWriter2.setHtmlSafe(jsonWriter2.isHtmlSafe());
        jsonWriter2.setSerializeNulls(jsonWriter2.getSerializeNulls());
    }

    public void toJson(com.google.gson.JsonElement jsonElement, java.lang.Appendable appendable2) {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable2)));
            appendable2 = new JsonIOException(jsonElement);
            throw appendable2;
        }
    }

    public void toJson(Object object, java.lang.Appendable appendable2) {
        Class class;
        Object obj2;
        if (object != null) {
            toJson(object, object.getClass(), appendable2);
        } else {
            toJson(JsonNull.INSTANCE, appendable2);
        }
    }

    public void toJson(Object object, Type type2, JsonWriter jsonWriter3) {
        jsonWriter3.setLenient(true);
        jsonWriter3.setHtmlSafe(this.htmlSafe);
        jsonWriter3.setSerializeNulls(this.serializeNulls);
        getAdapter(TypeToken.get(type2)).write(jsonWriter3, object);
        jsonWriter3.setLenient(jsonWriter3.isLenient());
        jsonWriter3.setHtmlSafe(jsonWriter3.isHtmlSafe());
        jsonWriter3.setSerializeNulls(jsonWriter3.getSerializeNulls());
    }

    public void toJson(Object object, Type type2, java.lang.Appendable appendable3) {
        try {
            toJson(object, type2, newJsonWriter(Streams.writerForAppendable(appendable3)));
            type2 = new JsonIOException(object);
            throw type2;
        }
    }

    public com.google.gson.JsonElement toJsonTree(Object object) {
        if (object == null) {
            return JsonNull.INSTANCE;
        }
        return toJsonTree(object, object.getClass());
    }

    public com.google.gson.JsonElement toJsonTree(Object object, Type type2) {
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        toJson(object, type2, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{serializeNulls:");
        stringBuilder.append(this.serializeNulls);
        stringBuilder.append(",factories:");
        stringBuilder.append(this.factories);
        stringBuilder.append(",instanceCreators:");
        stringBuilder.append(this.constructorConstructor);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
