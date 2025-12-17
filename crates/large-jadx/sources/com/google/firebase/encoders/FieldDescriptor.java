package com.google.firebase.encoders;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class FieldDescriptor {

    private final String name;
    private final Map<Class<?>, Object> properties;

    public static final class Builder {

        private final String name;
        private Map<Class<?>, Object> properties = null;
        Builder(String string) {
            super();
            final int i = 0;
            this.name = string;
        }

        public com.google.firebase.encoders.FieldDescriptor build() {
            Map unmodifiableMap;
            Map properties;
            if (this.properties == null) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                HashMap hashMap = new HashMap(this.properties);
                unmodifiableMap = Collections.unmodifiableMap(hashMap);
            }
            FieldDescriptor fieldDescriptor = new FieldDescriptor(this.name, unmodifiableMap, 0);
            return fieldDescriptor;
        }

        public <T extends Annotation> com.google.firebase.encoders.FieldDescriptor.Builder withProperty(T t) {
            Object hashMap;
            if (this.properties == null) {
                hashMap = new HashMap();
                this.properties = hashMap;
            }
            this.properties.put(t.annotationType(), t);
            return this;
        }
    }
    private FieldDescriptor(String string, Map<Class<?>, Object> map2) {
        super();
        this.name = string;
        this.properties = map2;
    }

    FieldDescriptor(String string, Map map2, com.google.firebase.encoders.FieldDescriptor.1 fieldDescriptor$13) {
        super(string, map2);
    }

    public static com.google.firebase.encoders.FieldDescriptor.Builder builder(String string) {
        FieldDescriptor.Builder builder = new FieldDescriptor.Builder(string);
        return builder;
    }

    public static com.google.firebase.encoders.FieldDescriptor of(String string) {
        FieldDescriptor fieldDescriptor = new FieldDescriptor(string, Collections.emptyMap());
        return fieldDescriptor;
    }

    public boolean equals(Object object) {
        int i;
        boolean properties;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof FieldDescriptor) {
            return i2;
        }
        if (this.name.equals(object.name) && this.properties.equals(object.properties)) {
            if (this.properties.equals(object.properties)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public String getName() {
        return this.name;
    }

    public <T extends Annotation> T getProperty(Class<T> class) {
        return (Annotation)this.properties.get(class);
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FieldDescriptor{name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", properties=");
        stringBuilder.append(this.properties.values());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
