package f.c.a.f.a.d;

import java.util.Set;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
final class i implements f.c.a.f.a.d.k {

    final Set a;
    final f.c.a.f.a.d.t b;
    final f.c.a.f.a.d.n c;
    i(f.c.a.f.a.d.n n, Set set2, f.c.a.f.a.d.t t3) {
        this.c = n;
        this.a = set2;
        this.b = t3;
        super();
    }

    public final void a(ZipFile zipFile, Set<f.c.a.f.a.d.m> set2) {
        this.a.addAll(n.a(this.c, set2, this.b, zipFile));
    }
}
