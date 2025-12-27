package d.s.a.l;

import android.database.sqlite.SQLiteProgram;
import d.s.a.i;

/* compiled from: FrameworkSQLiteProgram.java */
/* loaded from: classes.dex */
class d implements i {

    private final SQLiteProgram a;
    d(SQLiteProgram sQLiteProgram) {
        super();
        this.a = sQLiteProgram;
    }

    public void B0(int i, byte[] bArr) {
        this.a.bindBlob(i, bArr);
    }

    public void D(int i, String str) {
        this.a.bindString(i, str);
    }

    public void W(int i, double d) {
        this.a.bindDouble(i, d);
    }

    public void close() {
        this.a.close();
    }

    public void k1(int i) {
        this.a.bindNull(i);
    }

    public void u0(int i, long j) {
        this.a.bindLong(i, j);
    }
}
