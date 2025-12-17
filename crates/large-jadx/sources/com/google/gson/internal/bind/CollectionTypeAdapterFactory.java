package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    private final ConstructorConstructor constructorConstructor;

    private static final class Adapter extends TypeAdapter<Collection<E>> {

        private final ObjectConstructor<? extends Collection<E>> constructor;
        private final TypeAdapter<E> elementTypeAdapter;
        public Adapter(Gson gson, Type type2, TypeAdapter<E> typeAdapter3, ObjectConstructor<? extends Collection<E>> objectConstructor4) {
            super();
            TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter3, type2);
            this.elementTypeAdapter = typeAdapterRuntimeTypeWrapper;
            this.constructor = objectConstructor4;
        }

        @Override // com.google.gson.TypeAdapter
        public Object read(JsonReader jsonReader) {
            return read(jsonReader);
        }

        public Collection<E> read(JsonReader jsonReader) {
            JsonToken nULL;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return 0;
            }
            Object construct = this.constructor.construct();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                (Collection)construct.add(this.elementTypeAdapter.read(jsonReader));
            }
            jsonReader.endArray();
            return construct;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Object object2) {
            write(jsonWriter, (Collection)object2);
        }

        public void write(JsonWriter jsonWriter, Collection<E> collection2) {
            Object next;
            TypeAdapter elementTypeAdapter;
            if (collection2 == null) {
                jsonWriter.nullValue();
            }
            jsonWriter.beginArray();
            final Iterator obj4 = collection2.iterator();
            for (Object next : obj4) {
                this.elementTypeAdapter.write(jsonWriter, next);
            }
            jsonWriter.endArray();
        }
    }
    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        super();
        this.constructorConstructor = constructorConstructor;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
        Class rawType = typeToken2.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return 0;
        }
        Type collectionElementType = .Gson.Types.getCollectionElementType(typeToken2.getType(), rawType);
        CollectionTypeAdapterFactory.Adapter adapter2 = new CollectionTypeAdapterFactory.Adapter(gson, collectionElementType, gson.getAdapter(TypeToken.get(collectionElementType)), this.constructorConstructor.get(typeToken2));
        return adapter2;
    }
}
