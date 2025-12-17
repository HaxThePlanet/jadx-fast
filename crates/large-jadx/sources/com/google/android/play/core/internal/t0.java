package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* loaded from: classes2.dex */
final class t0 implements com.google.android.play.core.internal.z {
    @Override // com.google.android.play.core.internal.z
    public final boolean a(java.lang.ClassLoader classLoader, File file2, File file3, boolean z4) {
        i0 i0Var = new i0();
        s0 s0Var = new s0();
        return g0.e(classLoader, file2, file3, z4, i0Var, "path", s0Var);
    }

    public final void b(java.lang.ClassLoader classLoader, Set<File> set2) {
        q0.c(classLoader, set2);
    }
}
