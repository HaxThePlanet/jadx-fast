package f.c.a.b.i;

import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.e;

/* loaded from: classes.dex */
abstract class o {

    public static abstract class a {
        public abstract f.c.a.b.i.o a();

        abstract f.c.a.b.i.o.a b(b b);

        abstract f.c.a.b.i.o.a c(c<?> c);

        abstract f.c.a.b.i.o.a d(e<?, byte[]> e);

        public abstract f.c.a.b.i.o.a e(f.c.a.b.i.p p);

        public abstract f.c.a.b.i.o.a f(String string);
    }
    public static f.c.a.b.i.o.a a() {
        d.b bVar = new d.b();
        return bVar;
    }

    public abstract b b();

    abstract c<?> c();

    public byte[] d() {
        return (byte[])e().apply(c().b());
    }

    abstract e<?, byte[]> e();

    public abstract f.c.a.b.i.p f();

    public abstract String g();
}
