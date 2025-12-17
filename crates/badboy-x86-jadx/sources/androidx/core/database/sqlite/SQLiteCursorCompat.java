package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;

/* loaded from: classes5.dex */
public final class SQLiteCursorCompat {

    static class Api28Impl {
        static void setFillWindowForwardOnly(SQLiteCursor cursor, boolean fillWindowForwardOnly) {
            cursor.setFillWindowForwardOnly(fillWindowForwardOnly);
        }
    }
    public static void setFillWindowForwardOnly(SQLiteCursor cursor, boolean fillWindowForwardOnly) {
        SQLiteCursorCompat.Api28Impl.setFillWindowForwardOnly(cursor, fillWindowForwardOnly);
    }
}
