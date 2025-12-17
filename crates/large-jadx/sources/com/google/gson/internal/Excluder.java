package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class Excluder implements TypeAdapterFactory, java.lang.Cloneable {

    public static final com.google.gson.internal.Excluder DEFAULT = null;
    private static final double IGNORE_VERSIONS = -1d;
    private List<ExclusionStrategy> deserializationStrategies;
    private int modifiers = 136;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies;
    private boolean serializeInnerClasses = true;
    private double version = -1d;
    static {
        Excluder excluder = new Excluder();
        Excluder.DEFAULT = excluder;
    }

    public Excluder() {
        super();
        long l = -4616189618054758400L;
        int i = 136;
        int i2 = 1;
        this.serializationStrategies = Collections.emptyList();
        this.deserializationStrategies = Collections.emptyList();
    }

    private boolean excludeClassChecks(Class<?> class) {
        int validVersion;
        boolean serializeInnerClasses;
        long annotation;
        final int i = 1;
        if (Double.compare(version, annotation) != 0 && !isValidVersion((Since)class.getAnnotation(Since.class), (Until)class.getAnnotation(Until.class))) {
            if (!isValidVersion((Since)class.getAnnotation(Since.class), (Until)class.getAnnotation(Until.class))) {
                return i;
            }
        }
        if (!this.serializeInnerClasses && isInnerClass(class)) {
            if (isInnerClass(class)) {
                return i;
            }
        }
        if (isAnonymousOrLocal(class)) {
            return i;
        }
        return 0;
    }

    private boolean excludeClassInStrategy(Class<?> class, boolean z2) {
        boolean skipClass;
        List obj3;
        obj3 = z2 ? this.serializationStrategies : this.deserializationStrategies;
        obj3 = obj3.iterator();
        for (ExclusionStrategy next2 : obj3) {
        }
        return 0;
    }

    private boolean isAnonymousOrLocal(Class<?> class) {
        boolean assignableFrom;
        Class obj2;
        if (!Enum.class.isAssignableFrom(class)) {
            if (!class.isAnonymousClass()) {
                obj2 = class.isLocalClass() ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private boolean isInnerClass(Class<?> class) {
        Class obj2;
        if (class.isMemberClass() && !isStatic(class)) {
            obj2 = !isStatic(class) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private boolean isStatic(Class<?> class) {
        int obj1;
        obj1 = obj1 &= 8 != 0 ? 1 : 0;
        return obj1;
    }

    private boolean isValidSince(Since since) {
        double value;
        double version;
        int obj5;
        if (since != 0 && Double.compare(value, version) > 0) {
            if (Double.compare(value, version) > 0) {
                return 0;
            }
        }
        return 1;
    }

    private boolean isValidUntil(Until until) {
        double value;
        double version;
        int obj5;
        if (until != 0 && Double.compare(value, version) <= 0) {
            if (Double.compare(value, version) <= 0) {
                return 0;
            }
        }
        return 1;
    }

    private boolean isValidVersion(Since since, Until until2) {
        boolean obj1;
        if (isValidSince(since) && isValidUntil(until2)) {
            obj1 = isValidUntil(until2) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    @Override // com.google.gson.TypeAdapterFactory
    protected com.google.gson.internal.Excluder clone() {
        try {
            return (Excluder)super.clone();
            AssertionError assertionError = new AssertionError(th);
            throw assertionError;
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    protected Object clone() {
        return clone();
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken2) {
        boolean excludeClassInStrategy;
        boolean excludeClassInStrategy2;
        int i2;
        int i;
        excludeClassInStrategy = typeToken2.getRawType();
        final boolean excludeClassChecks = excludeClassChecks(excludeClassInStrategy);
        final int i3 = 0;
        final int i4 = 1;
        if (!excludeClassChecks) {
            if (excludeClassInStrategy(excludeClassInStrategy, i4)) {
                i = i4;
            } else {
                i = i3;
            }
        } else {
        }
        if (!excludeClassChecks) {
            if (excludeClassInStrategy(excludeClassInStrategy, i3)) {
                i2 = i4;
            } else {
                i2 = i3;
            }
        } else {
        }
        if (i == 0 && i2 == 0) {
            if (i2 == 0) {
                return 0;
            }
        }
        super(this, i2, i, gson, typeToken2);
        return anon;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public com.google.gson.internal.Excluder disableInnerClassSerialization() {
        final com.google.gson.internal.Excluder clone = clone();
        clone.serializeInnerClasses = false;
        return clone;
    }

    public boolean excludeClass(Class<?> class, boolean z2) {
        int obj2;
        if (!excludeClassChecks(class)) {
            if (excludeClassInStrategy(class, z2)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public boolean excludeField(Field field, boolean z2) {
        int validVersion;
        boolean requireExpose;
        boolean serializeInnerClasses;
        boolean fieldAttributes;
        double annotation;
        Object obj7;
        List obj8;
        int i2 = 1;
        if (modifiers &= modifiers2 != 0) {
            return i2;
        }
        if (Double.compare(annotation, l) != 0 && !isValidVersion((Since)field.getAnnotation(Since.class), (Until)field.getAnnotation(Until.class))) {
            if (!isValidVersion((Since)field.getAnnotation(Since.class), (Until)field.getAnnotation(Until.class))) {
                return i2;
            }
        }
        if (field.isSynthetic()) {
            return i2;
        }
        requireExpose = field.getAnnotation(Expose.class);
        if (this.requireExpose && (Expose)requireExpose != null) {
            requireExpose = field.getAnnotation(Expose.class);
            if ((Expose)(Expose)requireExpose != null) {
                if (z2) {
                    if (!(Expose)(Expose)requireExpose.serialize()) {
                    }
                } else {
                    if (!requireExpose.deserialize()) {
                    }
                }
            }
            return i2;
        }
        if (!this.serializeInnerClasses && isInnerClass(field.getType())) {
            if (isInnerClass(field.getType())) {
                return i2;
            }
        }
        if (isAnonymousOrLocal(field.getType())) {
            return i2;
        }
        obj8 = z2 ? this.serializationStrategies : this.deserializationStrategies;
        if (!obj8.isEmpty()) {
            fieldAttributes = new FieldAttributes(field);
            obj7 = obj8.iterator();
            for (ExclusionStrategy obj8 : obj7) {
            }
        }
        return 0;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public com.google.gson.internal.Excluder excludeFieldsWithoutExposeAnnotation() {
        final com.google.gson.internal.Excluder clone = clone();
        clone.requireExpose = true;
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public com.google.gson.internal.Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z2, boolean z3) {
        List serializationStrategies;
        ArrayList obj4;
        List obj5;
        final com.google.gson.internal.Excluder clone = clone();
        if (z2 != null) {
            obj4 = new ArrayList(this.serializationStrategies);
            clone.serializationStrategies = obj4;
            obj4.add(exclusionStrategy);
        }
        if (z3 != null) {
            obj4 = new ArrayList(this.deserializationStrategies);
            clone.deserializationStrategies = obj4;
            obj4.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public com.google.gson.internal.Excluder withModifiers(int... iArr) {
        int i2;
        int i;
        int modifiers;
        final com.google.gson.internal.Excluder clone = clone();
        clone.modifiers = 0;
        while (i2 < iArr.length) {
            clone.modifiers = i3 |= modifiers;
            i2++;
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public com.google.gson.internal.Excluder withVersion(double d) {
        final com.google.gson.internal.Excluder clone = clone();
        clone.version = d;
        return clone;
    }
}
