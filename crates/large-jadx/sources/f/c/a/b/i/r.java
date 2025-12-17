package f.c.a.b.i;

import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.e;
import f.c.a.b.f;
import f.c.a.b.h;

/* loaded from: classes.dex */
final class r<T>  implements f<T> {

    private final f.c.a.b.i.p a;
    private final String b;
    private final b c;
    private final e<T, byte[]> d;
    private final f.c.a.b.i.s e;
    r(f.c.a.b.i.p p, String string2, b b3, e<T, byte[]> e4, f.c.a.b.i.s s5) {
        super();
        this.a = p;
        this.b = string2;
        this.c = b3;
        this.d = e4;
        this.e = s5;
    }

    static void c(Exception exception) {
    }

    public void a(c<T> c) {
        b(c, a.a);
    }

    public void b(c<T> c, h h2) {
        final f.c.a.b.i.o.a aVar = o.a();
        aVar.e(this.a);
        aVar.c(c);
        aVar.f(this.b);
        aVar.d(this.d);
        aVar.b(this.c);
        this.e.a(aVar.a(), h2);
    }
}
