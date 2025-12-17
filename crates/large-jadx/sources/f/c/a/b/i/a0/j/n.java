package f.c.a.b.i.a0.j;

import f.c.a.b.i.x.a.a.a;
import java.util.Map;

/* loaded from: classes.dex */
public final class n implements f.c.a.b.i.a0.j.q0.b {

    public final f.c.a.b.i.a0.j.q0 a;
    public final String b;
    public final Map c;
    public final a.a d;
    public n(f.c.a.b.i.a0.j.q0 q0, String string2, Map map3, a.a a$a4) {
        super();
        this.a = q0;
        this.b = string2;
        this.c = map3;
        this.d = a4;
    }

    @Override // f.c.a.b.i.a0.j.q0$b
    public final Object apply(Object object) {
        return this.a.I0(this.b, this.c, this.d, (SQLiteDatabase)object);
    }
}
