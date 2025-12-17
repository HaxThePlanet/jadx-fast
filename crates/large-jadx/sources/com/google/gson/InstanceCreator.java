package com.google.gson;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public interface InstanceCreator<T>  {
    public abstract T createInstance(Type type);
}
