package com.google.android.play.core.internal;

import java.io.File;

/* loaded from: classes2.dex */
final class d0 implements com.google.android.play.core.internal.e0 {
    @Override // com.google.android.play.core.internal.e0
    public final boolean a(Object object, File file2, File file3) {
        File obj9 = new File((String)w0.g(object.getClass(), "optimizedPathFor", String.class, File.class, file2, File.class, file3));
        return obj9.exists();
    }
}
