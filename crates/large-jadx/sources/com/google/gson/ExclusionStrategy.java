package com.google.gson;

/* loaded from: classes2.dex */
public interface ExclusionStrategy {
    public abstract boolean shouldSkipClass(Class<?> class);

    public abstract boolean shouldSkipField(com.google.gson.FieldAttributes fieldAttributes);
}
