package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* loaded from: classes2.dex */
final class h0 implements com.google.android.play.core.internal.z {
    @Override // com.google.android.play.core.internal.z
    public final boolean a(java.lang.ClassLoader classLoader, File file2, File file3, boolean z4) {
        c0 c0Var = new c0();
        d0 d0Var = new d0();
        return g0.e(classLoader, file2, file3, z4, c0Var, "zip", d0Var);
    }

    public final void b(java.lang.ClassLoader classLoader, Set<File> set2) {
        g0.d(classLoader, set2);
    }
}
