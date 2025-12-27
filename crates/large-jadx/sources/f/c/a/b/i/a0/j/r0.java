package f.c.a.b.i.a0.j;

import f.c.a.b.i.w.b.b;

/* compiled from: SQLiteEventStore_Factory.java */
/* loaded from: classes.dex */
public final class r0 implements b<q0> {

    private final j.a.a<f.c.a.b.i.b0.a> a;
    private final j.a.a<f.c.a.b.i.b0.a> b;
    private final j.a.a<j0> c;
    private final j.a.a<s0> d;
    private final j.a.a<String> e;
    public r0(j.a.a<f.c.a.b.i.b0.a> aVar, j.a.a<f.c.a.b.i.b0.a> aVar2, j.a.a<j0> aVar3, j.a.a<s0> aVar4, j.a.a<String> aVar5) {
        super();
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    public static r0 a(j.a.a<f.c.a.b.i.b0.a> aVar, j.a.a<f.c.a.b.i.b0.a> aVar2, j.a.a<j0> aVar3, j.a.a<s0> aVar4, j.a.a<String> aVar5) {
        r0 r0Var = new r0(aVar, aVar2, aVar3, aVar4, aVar5);
        return r0Var;
    }

    public static q0 c(f.c.a.b.i.b0.a aVar, f.c.a.b.i.b0.a aVar2, Object object, Object object2, f.c.a.b.i.w.a<String> aVar3) {
        q0 q0Var = new q0(aVar, aVar2, (j0)object, (s0)object2, aVar3);
        return q0Var;
    }

    public q0 b() {
        return r0.c((a)this.a.get(), (a)this.b.get(), this.c.get(), this.d.get(), a.a(this.e));
    }
}
