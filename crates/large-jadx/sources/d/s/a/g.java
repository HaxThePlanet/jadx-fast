package d.s.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* compiled from: SupportSQLiteDatabase.java */
/* loaded from: classes.dex */
public interface g extends Closeable {
    void C(String str);

    boolean F1();

    Cursor H0(String str);

    k O(String str);

    long P0(String str, int i, ContentValues contentValues);

    void beginTransaction();

    void endTransaction();

    Cursor f0(j jVar, CancellationSignal cancellationSignal);

    String getPath();

    boolean isOpen();

    Cursor j1(j jVar);

    boolean q1();

    void setTransactionSuccessful();

    void setVersion(int i);

    void x0();

    int y0(String str, int i, ContentValues contentValues, String str2, Object[] objectArr);

    List<Pair<String, String>> z();
}
