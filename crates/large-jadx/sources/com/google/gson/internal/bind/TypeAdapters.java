package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes2.dex */
public final class TypeAdapters {

    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Currency> CURRENCY;
    public static final TypeAdapterFactory CURRENCY_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    private static final class EnumTypeAdapter extends TypeAdapter<T> {

        private final Map<T, String> constantToName;
        private final Map<String, T> nameToConstant;
        public EnumTypeAdapter(Class<T> class) {
            int i;
            Field constantToName;
            java.lang.annotation.Annotation annotation;
            boolean enumConstant;
            String value;
            Class<SerializedName> length;
            int i2;
            String str;
            Map nameToConstant;
            super();
            HashMap hashMap = new HashMap();
            this.nameToConstant = hashMap;
            HashMap hashMap2 = new HashMap();
            this.constantToName = hashMap2;
            final Field[] obj11 = class.getDeclaredFields();
            final int i3 = 0;
            i = i3;
            while (i < obj11.length) {
                constantToName = obj11[i];
                if (!constantToName.isEnumConstant()) {
                } else {
                }
                TypeAdapters.EnumTypeAdapter.1 anon = new TypeAdapters.EnumTypeAdapter.1(this, constantToName);
                AccessController.doPrivileged(anon);
                enumConstant = constantToName.get(0);
                value = (Enum)enumConstant.name();
                annotation = constantToName.getAnnotation(SerializedName.class);
                if ((SerializedName)annotation != null) {
                }
                this.nameToConstant.put(value, enumConstant);
                this.constantToName.put(enumConstant, value);
                i++;
                value = (SerializedName)annotation.value();
                annotation = annotation.alternate();
                i2 = i3;
                while (i2 < annotation.length) {
                    this.nameToConstant.put(annotation[i2], enumConstant);
                    i2++;
                }
                this.nameToConstant.put(annotation[i2], enumConstant);
                i2++;
            }
        }

        public T read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return 0;
            }
            return (Enum)this.nameToConstant.get(jsonReader.nextString());
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return read(jsonReader);
        }

        public void write(JsonWriter jsonWriter, T t2) {
            Map constantToName;
            int obj3;
            if (t2 == null) {
                obj3 = 0;
            } else {
                obj3 = this.constantToName.get(t2);
            }
            jsonWriter.value(obj3);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            write(jsonWriter, (Enum)object2);
        }
    }
    static {
        TypeAdapters.1 anon = new TypeAdapters.1();
        TypeAdapter nullSafe = anon.nullSafe();
        TypeAdapters.CLASS = nullSafe;
        TypeAdapters.CLASS_FACTORY = TypeAdapters.newFactory(Class.class, nullSafe);
        TypeAdapters.2 anon2 = new TypeAdapters.2();
        TypeAdapter nullSafe2 = anon2.nullSafe();
        TypeAdapters.BIT_SET = nullSafe2;
        TypeAdapters.BIT_SET_FACTORY = TypeAdapters.newFactory(BitSet.class, nullSafe2);
        TypeAdapters.3 anon3 = new TypeAdapters.3();
        TypeAdapters.BOOLEAN = anon3;
        TypeAdapters.4 anon28 = new TypeAdapters.4();
        TypeAdapters.BOOLEAN_AS_STRING = anon28;
        TypeAdapters.BOOLEAN_FACTORY = TypeAdapters.newFactory(Boolean.TYPE, Boolean.class, anon3);
        TypeAdapters.5 anon4 = new TypeAdapters.5();
        TypeAdapters.BYTE = anon4;
        TypeAdapters.BYTE_FACTORY = TypeAdapters.newFactory(Byte.TYPE, Byte.class, anon4);
        TypeAdapters.6 anon5 = new TypeAdapters.6();
        TypeAdapters.SHORT = anon5;
        TypeAdapters.SHORT_FACTORY = TypeAdapters.newFactory(Short.TYPE, Short.class, anon5);
        TypeAdapters.7 anon6 = new TypeAdapters.7();
        TypeAdapters.INTEGER = anon6;
        TypeAdapters.INTEGER_FACTORY = TypeAdapters.newFactory(Integer.TYPE, Integer.class, anon6);
        TypeAdapters.8 anon7 = new TypeAdapters.8();
        TypeAdapter nullSafe3 = anon7.nullSafe();
        TypeAdapters.ATOMIC_INTEGER = nullSafe3;
        TypeAdapters.ATOMIC_INTEGER_FACTORY = TypeAdapters.newFactory(AtomicInteger.class, nullSafe3);
        TypeAdapters.9 anon8 = new TypeAdapters.9();
        TypeAdapter nullSafe4 = anon8.nullSafe();
        TypeAdapters.ATOMIC_BOOLEAN = nullSafe4;
        TypeAdapters.ATOMIC_BOOLEAN_FACTORY = TypeAdapters.newFactory(AtomicBoolean.class, nullSafe4);
        TypeAdapters.10 anon9 = new TypeAdapters.10();
        TypeAdapter nullSafe5 = anon9.nullSafe();
        TypeAdapters.ATOMIC_INTEGER_ARRAY = nullSafe5;
        TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY = TypeAdapters.newFactory(AtomicIntegerArray.class, nullSafe5);
        TypeAdapters.11 anon10 = new TypeAdapters.11();
        TypeAdapters.LONG = anon10;
        TypeAdapters.12 anon11 = new TypeAdapters.12();
        TypeAdapters.FLOAT = anon11;
        TypeAdapters.13 anon12 = new TypeAdapters.13();
        TypeAdapters.DOUBLE = anon12;
        TypeAdapters.14 anon13 = new TypeAdapters.14();
        TypeAdapters.NUMBER = anon13;
        TypeAdapters.NUMBER_FACTORY = TypeAdapters.newFactory(Number.class, anon13);
        TypeAdapters.15 anon14 = new TypeAdapters.15();
        TypeAdapters.CHARACTER = anon14;
        TypeAdapters.CHARACTER_FACTORY = TypeAdapters.newFactory(Character.TYPE, Character.class, anon14);
        TypeAdapters.16 anon15 = new TypeAdapters.16();
        TypeAdapters.STRING = anon15;
        TypeAdapters.17 anon29 = new TypeAdapters.17();
        TypeAdapters.BIG_DECIMAL = anon29;
        TypeAdapters.18 anon30 = new TypeAdapters.18();
        TypeAdapters.BIG_INTEGER = anon30;
        TypeAdapters.STRING_FACTORY = TypeAdapters.newFactory(String.class, anon15);
        TypeAdapters.19 anon16 = new TypeAdapters.19();
        TypeAdapters.STRING_BUILDER = anon16;
        TypeAdapters.STRING_BUILDER_FACTORY = TypeAdapters.newFactory(StringBuilder.class, anon16);
        TypeAdapters.20 anon17 = new TypeAdapters.20();
        TypeAdapters.STRING_BUFFER = anon17;
        TypeAdapters.STRING_BUFFER_FACTORY = TypeAdapters.newFactory(StringBuffer.class, anon17);
        TypeAdapters.21 anon18 = new TypeAdapters.21();
        TypeAdapters.URL = anon18;
        TypeAdapters.URL_FACTORY = TypeAdapters.newFactory(URL.class, anon18);
        TypeAdapters.22 anon19 = new TypeAdapters.22();
        TypeAdapters.URI = anon19;
        TypeAdapters.URI_FACTORY = TypeAdapters.newFactory(URI.class, anon19);
        TypeAdapters.23 anon20 = new TypeAdapters.23();
        TypeAdapters.INET_ADDRESS = anon20;
        TypeAdapters.INET_ADDRESS_FACTORY = TypeAdapters.newTypeHierarchyFactory(InetAddress.class, anon20);
        TypeAdapters.24 anon21 = new TypeAdapters.24();
        TypeAdapters.UUID = anon21;
        TypeAdapters.UUID_FACTORY = TypeAdapters.newFactory(UUID.class, anon21);
        TypeAdapters.25 anon22 = new TypeAdapters.25();
        TypeAdapter nullSafe6 = anon22.nullSafe();
        TypeAdapters.CURRENCY = nullSafe6;
        TypeAdapters.CURRENCY_FACTORY = TypeAdapters.newFactory(Currency.class, nullSafe6);
        TypeAdapters.26 anon23 = new TypeAdapters.26();
        TypeAdapters.TIMESTAMP_FACTORY = anon23;
        TypeAdapters.27 anon24 = new TypeAdapters.27();
        TypeAdapters.CALENDAR = anon24;
        TypeAdapters.CALENDAR_FACTORY = TypeAdapters.newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, anon24);
        TypeAdapters.28 anon25 = new TypeAdapters.28();
        TypeAdapters.LOCALE = anon25;
        TypeAdapters.LOCALE_FACTORY = TypeAdapters.newFactory(Locale.class, anon25);
        TypeAdapters.29 anon26 = new TypeAdapters.29();
        TypeAdapters.JSON_ELEMENT = anon26;
        TypeAdapters.JSON_ELEMENT_FACTORY = TypeAdapters.newTypeHierarchyFactory(JsonElement.class, anon26);
        TypeAdapters.30 anon27 = new TypeAdapters.30();
        TypeAdapters.ENUM_FACTORY = anon27;
    }

    private TypeAdapters() {
        super();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public static <TT> TypeAdapterFactory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter2) {
        TypeAdapters.31 anon = new TypeAdapters.31(typeToken, typeAdapter2);
        return anon;
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> class, TypeAdapter<TT> typeAdapter2) {
        TypeAdapters.32 anon = new TypeAdapters.32(class, typeAdapter2);
        return anon;
    }

    public static <TT> TypeAdapterFactory newFactory(Class<TT> class, Class<TT> class2, TypeAdapter<? super TT> typeAdapter3) {
        TypeAdapters.33 anon = new TypeAdapters.33(class, class2, typeAdapter3);
        return anon;
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(Class<TT> class, Class<? extends TT> class2, TypeAdapter<? super TT> typeAdapter3) {
        TypeAdapters.34 anon = new TypeAdapters.34(class, class2, typeAdapter3);
        return anon;
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(Class<T1> class, TypeAdapter<T1> typeAdapter2) {
        TypeAdapters.35 anon = new TypeAdapters.35(class, typeAdapter2);
        return anon;
    }
}
