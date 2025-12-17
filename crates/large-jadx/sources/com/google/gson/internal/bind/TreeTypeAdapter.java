package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public final class TreeTypeAdapter<T>  extends TypeAdapter<T> {

    private final com.google.gson.internal.bind.TreeTypeAdapter.GsonContextImpl<T> context;
    private TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    private final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {

        final com.google.gson.internal.bind.TreeTypeAdapter this$0;
        private GsonContextImpl(com.google.gson.internal.bind.TreeTypeAdapter treeTypeAdapter) {
            this.this$0 = treeTypeAdapter;
            super();
        }

        GsonContextImpl(com.google.gson.internal.bind.TreeTypeAdapter treeTypeAdapter, com.google.gson.internal.bind.TreeTypeAdapter.1 treeTypeAdapter$12) {
            super(treeTypeAdapter);
        }

        public <R> R deserialize(JsonElement jsonElement, Type type2) {
            return this$0.gson.fromJson(jsonElement, type2);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object object) {
            return this$0.gson.toJsonTree(object);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object object, Type type2) {
            return this$0.gson.toJsonTree(object, type2);
        }
    }

    private static final class SingleTypeFactory implements TypeAdapterFactory {

        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer = null;
        SingleTypeFactory(Object object, TypeToken<?> typeToken2, boolean z3, Class<?> class4) {
            int i;
            int obj4;
            super();
            if (object instanceof JsonSerializer) {
                Object obj = object;
            }
            if (object instanceof JsonDeserializer) {
                i = object;
            }
            this.deserializer = i;
            if (0 == 0) {
                if (i != 0) {
                    obj4 = 1;
                } else {
                    obj4 = 0;
                }
            } else {
            }
            .Gson.Preconditions.checkArgument(obj4);
            this.exactType = typeToken2;
            this.matchRawType = z3;
            this.hierarchyType = class4;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
            boolean matchRawType;
            boolean assignableFrom;
            int treeTypeAdapter;
            Class rawType;
            JsonSerializer serializer;
            JsonDeserializer deserializer;
            Gson gson2;
            Object obj2;
            Object obj;
            TypeToken exactType = this.exactType;
            if (exactType != null) {
                if (!exactType.equals(typeToken2)) {
                    if (this.matchRawType && this.exactType.getType() == typeToken2.getRawType()) {
                        if (this.exactType.getType() == typeToken2.getRawType()) {
                            assignableFrom = 1;
                        } else {
                            assignableFrom = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
                assignableFrom = this.hierarchyType.isAssignableFrom(typeToken2.getRawType());
            }
            if (assignableFrom) {
                super(this.serializer, this.deserializer, gson, typeToken2, this);
            } else {
                treeTypeAdapter = 0;
            }
            return treeTypeAdapter;
        }
    }
    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer2, Gson gson3, TypeToken<T> typeToken4, TypeAdapterFactory typeAdapterFactory5) {
        super();
        TreeTypeAdapter.GsonContextImpl gsonContextImpl = new TreeTypeAdapter.GsonContextImpl(this, 0);
        this.context = gsonContextImpl;
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer2;
        this.gson = gson3;
        this.typeToken = typeToken4;
        this.skipPast = typeAdapterFactory5;
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter delegateAdapter;
        TypeAdapterFactory skipPast;
        TypeToken typeToken;
        if (this.delegate != null) {
        } else {
            this.delegate = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        }
        return delegateAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken, Object object2) {
        TreeTypeAdapter.SingleTypeFactory singleTypeFactory = new TreeTypeAdapter.SingleTypeFactory(object2, typeToken, 0, 0);
        return singleTypeFactory;
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> typeToken, Object object2) {
        int i;
        i = typeToken.getType() == typeToken.getRawType() ? 1 : 0;
        TreeTypeAdapter.SingleTypeFactory singleTypeFactory = new TreeTypeAdapter.SingleTypeFactory(object2, typeToken, i, 0);
        return singleTypeFactory;
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> class, Object object2) {
        TreeTypeAdapter.SingleTypeFactory singleTypeFactory = new TreeTypeAdapter.SingleTypeFactory(object2, 0, 0, class);
        return singleTypeFactory;
    }

    public T read(JsonReader jsonReader) {
        if (this.deserializer == null) {
            return delegate().read(jsonReader);
        }
        JsonElement obj4 = Streams.parse(jsonReader);
        if (obj4.isJsonNull()) {
            return 0;
        }
        return this.deserializer.deserialize(obj4, this.typeToken.getType(), this.context);
    }

    public void write(JsonWriter jsonWriter, T t2) {
        JsonSerializer serializer = this.serializer;
        if (serializer == null) {
            delegate().write(jsonWriter, t2);
        }
        if (t2 == null) {
            jsonWriter.nullValue();
        }
        Streams.write(serializer.serialize(t2, this.typeToken.getType(), this.context), jsonWriter);
    }
}
