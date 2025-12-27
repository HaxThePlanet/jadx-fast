package f.c.a.b.i;

import f.c.a.b.b;
import f.c.a.b.e;
import f.c.a.b.f;
import f.c.a.b.g;
import java.util.Set;

/* compiled from: TransportFactoryImpl.java */
/* loaded from: classes.dex */
final class q implements g {

    private final Set<b> a;
    private final p b;
    private final s c;
    q(Set<b> set, p pVar, s sVar) {
        super();
        this.a = set;
        this.b = pVar;
        this.c = sVar;
    }

    public <T> f<T> a(String str, Class<T> cls, e<T, byte[]> eVar) {
        return b(str, cls, b.b("proto"), eVar);
    }

    public <T> f<T> b(String str, Class<T> cls, b bVar, e<T, byte[]> eVar) {
        if (!this.a.contains(bVar)) {
            Object[] arr = new Object[2];
            throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", new Object[] { bVar, this.a }));
        } else {
            r cls22 = new r(this.b, str, bVar, eVar, this.c);
            return cls22;
        }
    }
}
