package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

/* loaded from: classes2.dex */
public abstract class ReflectionAccessor {

    private static final com.google.gson.internal.reflect.ReflectionAccessor instance;
    static {
        com.google.gson.internal.reflect.ReflectionAccessor preJava9ReflectionAccessor;
        if (JavaVersion.getMajorJavaVersion() < 9) {
            preJava9ReflectionAccessor = new PreJava9ReflectionAccessor();
        } else {
            preJava9ReflectionAccessor = new UnsafeReflectionAccessor();
        }
        ReflectionAccessor.instance = preJava9ReflectionAccessor;
    }

    public static com.google.gson.internal.reflect.ReflectionAccessor getInstance() {
        return ReflectionAccessor.instance;
    }

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}
