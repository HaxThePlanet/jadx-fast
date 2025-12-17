package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
final class TypeAdapterRuntimeTypeWrapper<T>  extends TypeAdapter<T> {

    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;
    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter2, Type type3) {
        super();
        this.context = gson;
        this.delegate = typeAdapter2;
        this.type = type3;
    }

    private Type getRuntimeTypeIfMoreSpecific(Type type, Object object2) {
        Class<Object> obj;
        Class<Object> obj2;
        if (object2 != null) {
            if (type != Object.class && !type instanceof TypeVariable) {
                if (!type instanceof TypeVariable) {
                    if (type instanceof Class) {
                        obj2 = object2.getClass();
                    }
                } else {
                }
            } else {
            }
        }
        return obj2;
    }

    public T read(JsonReader jsonReader) {
        return this.delegate.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, T t2) {
        TypeAdapter delegate;
        Type runtimeTypeIfMoreSpecific;
        Type type;
        delegate = this.delegate;
        runtimeTypeIfMoreSpecific = getRuntimeTypeIfMoreSpecific(this.type, t2);
        if (runtimeTypeIfMoreSpecific != this.type) {
            if (delegate instanceof ReflectiveTypeAdapterFactory.Adapter == null) {
            } else {
                runtimeTypeIfMoreSpecific = this.delegate;
                if (runtimeTypeIfMoreSpecific instanceof ReflectiveTypeAdapterFactory.Adapter == null) {
                    delegate = runtimeTypeIfMoreSpecific;
                }
            }
        }
        delegate.write(jsonWriter, t2);
    }
}
