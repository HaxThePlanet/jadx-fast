package f.c.a.b.i;

import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.e;
import f.c.a.b.f;
import f.c.a.b.h;

/* compiled from: TransportImpl.java */
/* loaded from: classes.dex */
final class r<T> implements f<T> {

    private final p a;
    private final String b;
    private final b c;
    private final e<T, byte[]> d;
    private final s e;
    r(p pVar, String str, b bVar, e<T, byte[]> eVar, s sVar) {
        super();
        this.a = pVar;
        this.b = str;
        this.c = bVar;
        this.d = eVar;
        this.e = sVar;
    }

    public void a(c<T> cVar) {
        b(cVar, a.a);
    }

    public void b(c<T> cVar, h hVar) {
        final f.c.a.b.i.o.a aVar = o.a();
        aVar.e(this.a);
        aVar.c(cVar);
        aVar.f(this.b);
        aVar.d(this.d);
        aVar.b(this.c);
        this.e.a(aVar.a(), hVar);
    }

    static /* synthetic */ void c(Exception exc) {
    }
}
