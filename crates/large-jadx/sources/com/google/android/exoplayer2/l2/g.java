package com.google.android.exoplayer2.l2;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class g implements com.google.android.exoplayer2.l2.m {
    static {
        boolean subclass;
        Object invoke;
        int tYPE;
        try {
            final int i2 = 0;
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[i2]).invoke(0, new Object[i2]))) {
            }
            invoke = new Class[1];
            invoke[i2] = Integer.TYPE;
            Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(i.class).getConstructor(invoke);
            RuntimeException runtimeException = new RuntimeException("Error instantiating FLAC extension", th);
            throw runtimeException;
        }
    }
}
