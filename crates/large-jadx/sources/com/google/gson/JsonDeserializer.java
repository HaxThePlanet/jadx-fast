package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public interface JsonDeserializer<T>  {
    public abstract T deserialize(com.google.gson.JsonElement jsonElement, Type type2, com.google.gson.JsonDeserializationContext jsonDeserializationContext3);
}
