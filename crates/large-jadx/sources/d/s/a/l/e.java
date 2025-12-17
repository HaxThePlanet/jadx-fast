package d.s.a.l;

import android.database.sqlite.SQLiteStatement;
import d.s.a.k;

/* loaded from: classes.dex */
class e extends d.s.a.l.d implements k {

    private final SQLiteStatement b;
    e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.b = sQLiteStatement;
    }

    @Override // d.s.a.l.d
    public int N() {
        return this.b.executeUpdateDelete();
    }

    @Override // d.s.a.l.d
    public long a2() {
        return this.b.executeInsert();
    }
}
