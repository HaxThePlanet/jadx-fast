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

/* loaded from: classes.dex */
class a implements g {

    private static final String[] b;
    private static final String[] c;
    private final SQLiteDatabase a;

    class a implements SQLiteDatabase.CursorFactory {

        final j a;
        a(d.s.a.l.a a, j j2) {
            this.a = j2;
            super();
        }

        @Override // android.database.sqlite.SQLiteDatabase$CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver2, String string3, SQLiteQuery sQLiteQuery4) {
            d dVar = new d(sQLiteQuery4);
            this.a.c(dVar);
            SQLiteCursor obj2 = new SQLiteCursor(sQLiteCursorDriver2, string3, sQLiteQuery4);
            return obj2;
        }
    }

    class b implements SQLiteDatabase.CursorFactory {

        final j a;
        b(d.s.a.l.a a, j j2) {
            this.a = j2;
            super();
        }

        @Override // android.database.sqlite.SQLiteDatabase$CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver2, String string3, SQLiteQuery sQLiteQuery4) {
            d dVar = new d(sQLiteQuery4);
            this.a.c(dVar);
            SQLiteCursor obj2 = new SQLiteCursor(sQLiteCursorDriver2, string3, sQLiteQuery4);
            return obj2;
        }
    }
    static {
        a.b = /* result */;
        a.c = new String[0];
    }

    a(SQLiteDatabase sQLiteDatabase) {
        super();
        this.a = sQLiteDatabase;
    }

    @Override // d.s.a.g
    public void C(String string) {
        this.a.execSQL(string);
    }

    @Override // d.s.a.g
    public boolean F1() {
        return b.d(this.a);
    }

    @Override // d.s.a.g
    public Cursor H0(String string) {
        a aVar = new a(string);
        return j1(aVar);
    }

    @Override // d.s.a.g
    public k O(String string) {
        e eVar = new e(this.a.compileStatement(string));
        return eVar;
    }

    @Override // d.s.a.g
    public long P0(String string, int i2, ContentValues contentValues3) {
        return this.a.insertWithOnConflict(string, 0, contentValues3, i2);
    }

    @Override // d.s.a.g
    boolean a(SQLiteDatabase sQLiteDatabase) {
        int obj2;
        obj2 = this.a == sQLiteDatabase ? 1 : 0;
        return obj2;
    }

    @Override // d.s.a.g
    public void beginTransaction() {
        this.a.beginTransaction();
    }

    @Override // d.s.a.g
    public void close() {
        this.a.close();
    }

    @Override // d.s.a.g
    public void endTransaction() {
        this.a.endTransaction();
    }

    @Override // d.s.a.g
    public Cursor f0(j j, CancellationSignal cancellationSignal2) {
        a.b bVar = new a.b(this, j);
        return b.e(this.a, j.a(), a.c, 0, cancellationSignal2, bVar);
    }

    @Override // d.s.a.g
    public String getPath() {
        return this.a.getPath();
    }

    @Override // d.s.a.g
    public boolean isOpen() {
        return this.a.isOpen();
    }

    @Override // d.s.a.g
    public Cursor j1(j j) {
        a.a aVar = new a.a(this, j);
        return this.a.rawQueryWithFactory(aVar, j.a(), a.c, 0);
    }

    @Override // d.s.a.g
    public boolean q1() {
        return this.a.inTransaction();
    }

    @Override // d.s.a.g
    public void setTransactionSuccessful() {
        this.a.setTransactionSuccessful();
    }

    @Override // d.s.a.g
    public void setVersion(int i) {
        this.a.setVersion(i);
    }

    @Override // d.s.a.g
    public void x0() {
        this.a.beginTransactionNonExclusive();
    }

    @Override // d.s.a.g
    public int y0(String string, int i2, ContentValues contentValues3, String string4, Object[] object5Arr5) {
        int size;
        int i3;
        Object obj;
        int i;
        String str;
        boolean obj7;
        int obj8;
        int obj9;
        if (contentValues3 == 0) {
        } else {
            if (contentValues3.size() == 0) {
            } else {
                StringBuilder stringBuilder = new StringBuilder(120);
                stringBuilder.append("UPDATE ");
                stringBuilder.append(a.b[i2]);
                stringBuilder.append(string);
                stringBuilder.append(" SET ");
                obj7 = contentValues3.size();
                obj8 = object5Arr5 == null ? obj7 : obj8 + obj7;
                Object[] arr = new Object[obj8];
                i3 = 0;
                Iterator iterator = contentValues3.keySet().iterator();
                while (iterator.hasNext()) {
                    Object next2 = iterator.next();
                    if (i3 > 0) {
                    } else {
                    }
                    str = "";
                    stringBuilder.append(str);
                    stringBuilder.append((String)next2);
                    arr[i3] = contentValues3.get(next2);
                    stringBuilder.append("=?");
                    i3 = i;
                    str = ",";
                }
                if (object5Arr5 != null) {
                    obj9 = obj7;
                    while (obj9 < obj8) {
                        arr[obj9] = object5Arr5[obj9 - obj7];
                        obj9++;
                    }
                }
                if (!TextUtils.isEmpty(string4)) {
                    stringBuilder.append(" WHERE ");
                    stringBuilder.append(string4);
                }
                obj7 = O(stringBuilder.toString());
                a.d(obj7, arr);
                return obj7.N();
            }
        }
        obj7 = new IllegalArgumentException("Empty values");
        throw obj7;
    }

    public List<Pair<String, String>> z() {
        return this.a.getAttachedDbs();
    }
}
