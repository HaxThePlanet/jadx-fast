package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    public static final TypeAdapterFactory FACTORY;
    private final Gson gson;
    static {
        ObjectTypeAdapter.1 anon = new ObjectTypeAdapter.1();
        ObjectTypeAdapter.FACTORY = anon;
    }

    ObjectTypeAdapter(Gson gson) {
        super();
        this.gson = gson;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) {
        int[] $SwitchMap$com$google$gson$stream$JsonToken;
        Object read;
        $SwitchMap$com$google$gson$stream$JsonToken = ObjectTypeAdapter.2.$SwitchMap$com$google$gson$stream$JsonToken;
        switch (i2) {
            case 1:
                ArrayList arrayList = new ArrayList();
                jsonReader.beginArray();
                arrayList.add(read(jsonReader));
                jsonReader.endArray();
                return arrayList;
            case 2:
                LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
                jsonReader.beginObject();
                linkedTreeMap.put(jsonReader.nextName(), read(jsonReader));
                jsonReader.endObject();
                return linkedTreeMap;
            case 3:
                return jsonReader.nextString();
            case 4:
                return Double.valueOf(jsonReader.nextDouble());
            case 5:
                return Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                IllegalStateException obj4 = new IllegalStateException();
                throw obj4;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object object2) {
        if (object2 == null) {
            jsonWriter.nullValue();
        }
        TypeAdapter adapter = this.gson.getAdapter(object2.getClass());
        if (adapter instanceof ObjectTypeAdapter != null) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        }
        adapter.write(jsonWriter, object2);
    }
}
