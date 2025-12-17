package com.google.firebase.inappmessaging.dagger.internal;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class Preconditions {
    public static <T> void checkBuilderRequirement(T t, Class<T> class2) {
        if (t == 0) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(class2.getCanonicalName());
        stringBuilder.append(" must be set");
        IllegalStateException obj1 = new IllegalStateException(stringBuilder.toString());
        throw obj1;
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static <T> T checkNotNull(T t, String string2) {
        Objects.requireNonNull(t, string2);
        return t;
    }

    public static <T> T checkNotNull(T t, String string2, Object object3) {
        String obj4;
        if (t == 0) {
            String obj2 = "%s";
            if (!string2.contains(obj2)) {
            } else {
                if (string2.indexOf(obj2) != string2.lastIndexOf(obj2)) {
                } else {
                    if (object3 instanceof Class) {
                        obj4 = (Class)object3.getCanonicalName();
                    } else {
                        obj4 = String.valueOf(object3);
                    }
                    NullPointerException nullPointerException = new NullPointerException(string2.replace(obj2, obj4));
                    throw nullPointerException;
                }
                obj2 = new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
                throw obj2;
            }
            obj2 = new IllegalArgumentException("errorMessageTemplate has no format specifiers");
            throw obj2;
        }
        return t;
    }
}
