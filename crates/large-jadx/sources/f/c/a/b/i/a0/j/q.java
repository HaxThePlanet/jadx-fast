package f.c.a.b.i.a0.j;

/* loaded from: classes.dex */
public final class q implements f.c.a.b.i.a0.j.q0.b {

    public final f.c.a.b.i.a0.j.q0 a;
    public final String b;
    public final String c;
    public q(f.c.a.b.i.a0.j.q0 q0, String string2, String string3) {
        super();
        this.a = q0;
        this.b = string2;
        this.c = string3;
    }

    @Override // f.c.a.b.i.a0.j.q0$b
    public final Object apply(Object object) {
        return this.a.i1(this.b, this.c, (SQLiteDatabase)object);
    }
}
