package d.s.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
import java.io.File;

/* loaded from: classes.dex */
public final class b {
    public static void a(CancellationSignal cancellationSignal) {
        cancellationSignal.cancel();
    }

    public static CancellationSignal b() {
        CancellationSignal cancellationSignal = new CancellationSignal();
        return cancellationSignal;
    }

    public static boolean c(File file) {
        return SQLiteDatabase.deleteDatabase(file);
    }

    public static boolean d(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public static Cursor e(SQLiteDatabase sQLiteDatabase, String string2, String[] string3Arr3, String string4, CancellationSignal cancellationSignal5, SQLiteDatabase.CursorFactory sQLiteDatabase$CursorFactory6) {
        return sQLiteDatabase.rawQueryWithFactory(cursorFactory6, string2, string3Arr3, string4, cancellationSignal5);
    }

    public static void f(SQLiteOpenHelper sQLiteOpenHelper, boolean z2) {
        sQLiteOpenHelper.setWriteAheadLoggingEnabled(z2);
    }
}
