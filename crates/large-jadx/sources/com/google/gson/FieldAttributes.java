package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class FieldAttributes {

    private final Field field;
    public FieldAttributes(Field field) {
        super();
        .Gson.Preconditions.checkNotNull(field);
        this.field = field;
    }

    Object get(Object object) {
        return this.field.get(object);
    }

    public <T extends Annotation> T getAnnotation(Class<T> class) {
        return this.field.getAnnotation(class);
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }

    public Class<?> getDeclaredClass() {
        return this.field.getType();
    }

    public Type getDeclaredType() {
        return this.field.getGenericType();
    }

    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public String getName() {
        return this.field.getName();
    }

    public boolean hasModifier(int i) {
        int obj2;
        obj2 = i &= modifiers != 0 ? 1 : 0;
        return obj2;
    }

    boolean isSynthetic() {
        return this.field.isSynthetic();
    }
}
