package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;

/* loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    private final ConstructorConstructor constructorConstructor;
    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        super();
        this.constructorConstructor = constructorConstructor;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
        java.lang.annotation.Annotation annotation = typeToken2.getRawType().getAnnotation(JsonAdapter.class);
        if ((JsonAdapter)annotation == null) {
            return 0;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken2, (JsonAdapter)annotation);
    }

    TypeAdapter<?> getTypeAdapter(ConstructorConstructor constructorConstructor, Gson gson2, TypeToken<?> typeToken3, JsonAdapter jsonAdapter4) {
        boolean z;
        Object obj;
        int i3;
        com.google.gson.internal.bind.TreeTypeAdapter treeTypeAdapter;
        Object obj2;
        int i2;
        Gson gson;
        TypeToken typeToken;
        int i;
        Object obj9;
        Gson obj10;
        obj9 = constructorConstructor.get(TypeToken.get(jsonAdapter4.value())).construct();
        if (obj9 instanceof TypeAdapter != null) {
        } else {
            if (obj9 instanceof TypeAdapterFactory != null) {
                obj9 = (TypeAdapterFactory)(TypeAdapter)obj9.create(gson2, typeToken3);
            } else {
                obj = obj9 instanceof JsonSerializer;
                if (obj == null) {
                    if (!obj9 instanceof JsonDeserializer) {
                    } else {
                    }
                    StringBuilder obj12 = new StringBuilder();
                    obj12.append("Invalid attempt to bind an instance of ");
                    obj12.append(obj9.getClass().getName());
                    obj12.append(" as a @JsonAdapter for ");
                    obj12.append(typeToken3.toString());
                    obj12.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                    obj10 = new IllegalArgumentException(obj12.toString());
                    throw obj10;
                }
                if (obj != null) {
                    obj2 = obj;
                } else {
                    obj2 = i3;
                }
                if (obj9 instanceof JsonDeserializer) {
                    i3 = obj9;
                }
                super(obj2, i3, gson2, typeToken3, 0);
            }
        }
        if (obj9 != null && jsonAdapter4.nullSafe()) {
            if (jsonAdapter4.nullSafe()) {
                obj9 = obj9.nullSafe();
            }
        }
        return obj9;
    }
}
