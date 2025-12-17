package f.c.a.f.a.d;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
final class h implements f.c.a.f.a.d.k {

    final f.c.a.f.a.d.t a;
    final Set b;
    final AtomicBoolean c;
    final f.c.a.f.a.d.n d;
    h(f.c.a.f.a.d.n n, f.c.a.f.a.d.t t2, Set set3, AtomicBoolean atomicBoolean4) {
        this.d = n;
        this.a = t2;
        this.b = set3;
        this.c = atomicBoolean4;
        super();
    }

    public final void a(ZipFile zipFile, Set<f.c.a.f.a.d.m> set2) {
        g gVar = new g(this);
        n.d(this.d, this.a, set2, gVar);
    }
}
