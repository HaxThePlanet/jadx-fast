package f.c.a.b.i;

import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.e;

/* compiled from: SendRequest.java */
/* loaded from: classes.dex */
abstract class o {

    public static abstract class a {
        public abstract o a();

        abstract o.a b(b bVar);

        abstract o.a c(c<?> cVar);

        abstract o.a d(e<?, byte[]> eVar);

        public abstract o.a e(p pVar);

        public abstract o.a f(String str);
    }
    o() {
        super();
    }

    public static o.a a() {
        return new d.b();
    }

    public byte[] d() {
        return (byte[])e().apply(c().b());
    }

    public abstract b b();

    abstract c<?> c();

    abstract e<?, byte[]> e();

    public abstract p f();

    public abstract String g();
}
