package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public interface JsonSerializationContext {
    public abstract com.google.gson.JsonElement serialize(Object object);

    public abstract com.google.gson.JsonElement serialize(Object object, Type type2);
}
