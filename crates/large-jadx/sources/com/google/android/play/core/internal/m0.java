package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* loaded from: classes2.dex */
final class m0 implements com.google.android.play.core.internal.z {
    @Override // com.google.android.play.core.internal.z
    public final boolean a(java.lang.ClassLoader classLoader, File file2, File file3, boolean z4) {
        return l0.d(classLoader, file2, file3, z4, "zip");
    }

    public final void b(java.lang.ClassLoader classLoader, Set<File> set2) {
        j0 j0Var = new j0();
        l0.c(classLoader, set2, j0Var);
    }
}
