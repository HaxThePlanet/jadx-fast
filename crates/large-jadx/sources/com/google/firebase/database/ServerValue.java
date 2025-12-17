package com.google.firebase.database;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ServerValue {

    public static final Map<String, String> TIMESTAMP;
    static {
        ServerValue.TIMESTAMP = ServerValue.createScalarServerValuePlaceholder("timestamp");
    }

    private static Map<String, Map<String, Object>> createParameterizedServerValuePlaceholder(String string, Object object2) {
        HashMap hashMap = new HashMap();
        hashMap.put(string, object2);
        HashMap obj1 = new HashMap();
        obj1.put(".sv", Collections.unmodifiableMap(hashMap));
        return Collections.unmodifiableMap(obj1);
    }

    private static Map<String, String> createScalarServerValuePlaceholder(String string) {
        HashMap hashMap = new HashMap();
        hashMap.put(".sv", string);
        return Collections.unmodifiableMap(hashMap);
    }

    public static final Object increment(double d) {
        return ServerValue.createParameterizedServerValuePlaceholder("increment", Double.valueOf(d));
    }

    public static final Object increment(long l) {
        return ServerValue.createParameterizedServerValuePlaceholder("increment", Long.valueOf(l));
    }
}
