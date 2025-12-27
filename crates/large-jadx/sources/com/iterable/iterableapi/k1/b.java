package com.iterable.iterableapi.k1;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: IOUtils.java */
/* loaded from: classes2.dex */
public final class b {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
                return;
            }
        }
    }
}
