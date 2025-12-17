package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class ArrayTypeAdapter<E>  extends TypeAdapter<Object> {

    public static final TypeAdapterFactory FACTORY;
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;
    static {
        ArrayTypeAdapter.1 anon = new ArrayTypeAdapter.1();
        ArrayTypeAdapter.FACTORY = anon;
    }

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter2, Class<E> class3) {
        super();
        TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, class3);
        this.componentTypeAdapter = typeAdapterRuntimeTypeWrapper;
        this.componentType = class3;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) {
        JsonToken nULL;
        int i;
        Object obj;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.componentTypeAdapter.read(jsonReader));
        }
        jsonReader.endArray();
        int obj5 = arrayList.size();
        Object instance = Array.newInstance(this.componentType, obj5);
        i = 0;
        while (i < obj5) {
            Array.set(instance, i, arrayList.get(i));
            i++;
        }
        return instance;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object object2) {
        int i;
        Object obj;
        TypeAdapter componentTypeAdapter;
        if (object2 == null) {
            jsonWriter.nullValue();
        }
        jsonWriter.beginArray();
        i = 0;
        while (i < Array.getLength(object2)) {
            this.componentTypeAdapter.write(jsonWriter, Array.get(object2, i));
            i++;
        }
        jsonWriter.endArray();
    }
}
