package d.s.a.l;

import android.database.sqlite.SQLiteProgram;
import d.s.a.i;

/* loaded from: classes.dex */
class d implements i {

    private final SQLiteProgram a;
    d(SQLiteProgram sQLiteProgram) {
        super();
        this.a = sQLiteProgram;
    }

    @Override // d.s.a.i
    public void B0(int i, byte[] b2Arr2) {
        this.a.bindBlob(i, b2Arr2);
    }

    @Override // d.s.a.i
    public void D(int i, String string2) {
        this.a.bindString(i, string2);
    }

    @Override // d.s.a.i
    public void W(int i, double d2) {
        this.a.bindDouble(i, d2);
    }

    @Override // d.s.a.i
    public void close() {
        this.a.close();
    }

    @Override // d.s.a.i
    public void k1(int i) {
        this.a.bindNull(i);
    }

    @Override // d.s.a.i
    public void u0(int i, long l2) {
        this.a.bindLong(i, l2);
    }
}
