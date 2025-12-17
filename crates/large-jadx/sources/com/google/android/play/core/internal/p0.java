package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;

/* loaded from: classes2.dex */
final class p0 implements com.google.android.play.core.internal.e0 {
    @Override // com.google.android.play.core.internal.e0
    public final boolean a(Object object, File file2, File file3) {
        int obj4;
        obj4 = 0;
        if ((Boolean)w0.f(Class.forName("dalvik.system.DexFile"), "isDexOptNeeded", Boolean.class, String.class, file2.getPath()).booleanValue() == null) {
            try {
                obj4 = 1;
                return obj4;
                file2 = "SplitCompat";
                file3 = "Unexpected missing dalvik.system.DexFile.";
                Log.e(file2, file3);
                return object;
            }
        }
    }
}
