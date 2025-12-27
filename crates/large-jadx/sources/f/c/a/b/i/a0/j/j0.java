package f.c.a.b.i.a0.j;

/* compiled from: EventStoreConfig.java */
/* loaded from: classes.dex */
abstract class j0 {

    static final j0 a;

    static abstract class a {
        a() {
            super();
        }

        abstract j0 a();

        abstract j0.a b(int i);

        abstract j0.a c(long j);

        abstract j0.a d(int i);

        abstract j0.a e(int i);

        abstract j0.a f(long j);
    }
    static {
        f.c.a.b.i.a0.j.j0.a aVar = j0.a();
        aVar.f(10485760L);
        aVar.d(200);
        aVar.b(10000);
        aVar.c(604800000L);
        aVar.e(81920);
        j0.a = aVar.a();
    }

    j0() {
        super();
    }

    static j0.a a() {
        return new f0.b();
    }

    abstract int b();

    abstract long c();

    abstract int d();

    abstract int e();

    abstract long f();
}
