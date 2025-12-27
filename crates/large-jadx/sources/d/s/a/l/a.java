package d.s.a.l;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import d.s.a.a;
import d.s.a.b;
import d.s.a.g;
import d.s.a.j;
import d.s.a.k;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: FrameworkSQLiteDatabase.java */
/* loaded from: classes.dex */
class a implements g {

    private static final String[] b;
    private static final String[] c;
    private final SQLiteDatabase a;

    class a implements SQLiteDatabase.CursorFactory {

        final /* synthetic */ j a;
        a(j jVar) {
            this.a = jVar;
            super();
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.c(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    class b implements SQLiteDatabase.CursorFactory {

        final /* synthetic */ j a;
        b(j jVar) {
            this.a = jVar;
            super();
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.c(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }
    static {
        a.b = new String[] { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
        a.c = new String[0];
    }

    a(SQLiteDatabase sQLiteDatabase) {
        super();
        this.a = sQLiteDatabase;
    }

    public void C(String str) throws android.database.SQLException {
        this.a.execSQL(str);
    }

    public boolean F1() {
        return b.d(this.a);
    }

    public Cursor H0(String str) {
        return j1(new a(str));
    }

    public k O(String str) throws android.database.SQLException {
        return new e(this.a.compileStatement(str));
    }

    public long P0(String str, int i, ContentValues contentValues) {
        return this.a.insertWithOnConflict(str, null, contentValues, i);
    }

    boolean a(SQLiteDatabase sQLiteDatabase) {
        boolean z = true;
        sQLiteDatabase = this.a == sQLiteDatabase ? 1 : 0;
        return (this.a == sQLiteDatabase ? 1 : 0);
    }

    public void beginTransaction() throws android.database.SQLException {
        this.a.beginTransaction();
    }

    public void close() {
        this.a.close();
    }

    public void endTransaction() {
        this.a.endTransaction();
    }

    public Cursor f0(j jVar, CancellationSignal cancellationSignal) {
        return b.e(this.a, jVar.a(), a.c, null, cancellationSignal, new a.b(this, jVar));
    }

    public String getPath() {
        return this.a.getPath();
    }

    public boolean isOpen() {
        return this.a.isOpen();
    }

    public Cursor j1(j jVar) {
        return this.a.rawQueryWithFactory(new a.a(this, jVar), jVar.a(), a.c, null);
    }

    public boolean q1() {
        return this.a.inTransaction();
    }

    public void setTransactionSuccessful() {
        this.a.setTransactionSuccessful();
    }

    public void setVersion(int i) {
        this.a.setVersion(i);
    }

    public void x0() {
        this.a.beginTransactionNonExclusive();
    }

    public int y0(String str, int i, ContentValues contentValues, String str2, Object[] objectArr) {
        int str3;
        if (contentValues == null) {
            throw new IllegalArgumentException("Empty values");
        } else {
            if (contentValues.size() != 0) {
                StringBuilder stringBuilder = new StringBuilder(120);
                stringBuilder.append("UPDATE ");
                stringBuilder.append(a.b[i]);
                stringBuilder.append(str);
                stringBuilder.append(" SET ");
                str3 = contentValues.size();
                str3 = objectArr == null ? str3 : length + str3;
                Object[] arr = new Object[str3];
                i = 0;
                Iterator it = contentValues.keySet().iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    String r5 = i > 0 ? "," : "";
                    stringBuilder.append((i > 0 ? "," : ""));
                    stringBuilder.append(item);
                    i = i + 1;
                    arr[i] = contentValues.get(item);
                    stringBuilder.append("=?");
                    i = (i > 0 ? "," : "");
                }
                if (objectArr != null) {
                    while (str3 < a.b[i]) {
                        arr[str3] = objectArr[str3 - str3];
                        str3 = str3 + 1;
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    stringBuilder.append(" WHERE ");
                    stringBuilder.append(str2);
                }
                k kVar = O(stringBuilder.toString());
                a.d(kVar, arr);
                return kVar.N();
            }
        }
    }

    public List<Pair<String, String>> z() {
        return this.a.getAttachedDbs();
    }
}
