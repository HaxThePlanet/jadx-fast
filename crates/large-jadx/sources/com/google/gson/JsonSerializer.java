package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public interface JsonSerializer<T>  {
    public abstract com.google.gson.JsonElement serialize(T t, Type type2, com.google.gson.JsonSerializationContext jsonSerializationContext3);
}
