package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public interface JsonDeserializationContext {
    public abstract <T> T deserialize(com.google.gson.JsonElement jsonElement, Type type2);
}
