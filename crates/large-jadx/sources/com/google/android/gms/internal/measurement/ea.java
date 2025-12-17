package com.google.android.gms.internal.measurement;

import java.lang.reflect.Constructor;

/* loaded from: classes2.dex */
final class ea {

    private static final com.google.android.gms.internal.measurement.da a = null;
    private static final com.google.android.gms.internal.measurement.da b;
    static {
        try {
            int i = 0;
            Object instance = Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
            int daVar = 0;
            daVar = new da();
            ea.b = daVar;
        }
    }

    static com.google.android.gms.internal.measurement.da a() {
        return ea.a;
    }

    static com.google.android.gms.internal.measurement.da b() {
        return ea.b;
    }
}
