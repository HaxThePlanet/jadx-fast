package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* loaded from: classes2.dex */
final class q0 implements com.google.android.play.core.internal.z {
    static void c(java.lang.ClassLoader classLoader, Set<File> set2) {
        o0 o0Var = new o0();
        l0.c(classLoader, set2, o0Var);
    }

    static boolean d(java.lang.ClassLoader classLoader, File file2, File file3, boolean z4) {
        i0 i0Var = new i0();
        p0 p0Var = new p0();
        return g0.e(classLoader, file2, file3, z4, i0Var, "path", p0Var);
    }

    @Override // com.google.android.play.core.internal.z
    public final boolean a(java.lang.ClassLoader classLoader, File file2, File file3, boolean z4) {
        return q0.d(classLoader, file2, file3, z4);
    }

    public final void b(java.lang.ClassLoader classLoader, Set<File> set2) {
        q0.c(classLoader, set2);
    }
}
