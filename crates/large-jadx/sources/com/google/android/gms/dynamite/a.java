package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

/* loaded from: classes2.dex */
final class a extends PathClassLoader {
    a(String string, java.lang.ClassLoader classLoader2) {
        super(string, classLoader2);
    }

    protected final Class<?> loadClass(String string, boolean z2) {
        boolean startsWith;
        if (!string.startsWith("java.") && !string.startsWith("android.")) {
            if (!string.startsWith("android.")) {
                return findClass(string);
            }
        }
        return super.loadClass(string, z2);
    }
}
