package com.google.firebase.perf;

import java.util.Map;

/* loaded from: classes2.dex */
public interface FirebasePerformanceAttributable {

    public static final int MAX_ATTRIBUTE_KEY_LENGTH = 40;
    public static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;
    public static final int MAX_TRACE_CUSTOM_ATTRIBUTES = 5;
    public static final int MAX_TRACE_NAME_LENGTH = 100;
    public abstract String getAttribute(String string);

    public abstract Map<String, String> getAttributes();

    public abstract void putAttribute(String string, String string2);

    public abstract void removeAttribute(String string);
}
