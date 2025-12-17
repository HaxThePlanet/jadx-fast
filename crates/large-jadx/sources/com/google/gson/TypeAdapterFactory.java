package com.google.gson;

import com.google.gson.reflect.TypeToken;

/* loaded from: classes2.dex */
public interface TypeAdapterFactory {
    public abstract <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson gson, TypeToken<T> typeToken2);
}
