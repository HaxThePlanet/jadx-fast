package androidx.core.database;

import android.database.CursorWindow;

/* loaded from: classes5.dex */
public final class CursorWindowCompat {

    static class Api28Impl {
        static CursorWindow createCursorWindow(String name, long windowSizeBytes) {
            CursorWindow cursorWindow = new CursorWindow(name, windowSizeBytes, obj3);
            return cursorWindow;
        }
    }
    public static CursorWindow create(String name, long windowSizeBytes) {
        return CursorWindowCompat.Api28Impl.createCursorWindow(name, windowSizeBytes);
    }
}
