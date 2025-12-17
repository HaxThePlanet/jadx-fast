package f.c.a.b.i.a0.j;

import android.database.Cursor;

/* loaded from: classes.dex */
public final class d0 implements f.c.a.b.i.a0.j.q0.b {

    public static final f.c.a.b.i.a0.j.d0 a;
    static {
        d0 d0Var = new d0();
        d0.a = d0Var;
    }

    @Override // f.c.a.b.i.a0.j.q0$b
    public final Object apply(Object object) {
        return Boolean.valueOf((Cursor)object.moveToNext());
    }
}
