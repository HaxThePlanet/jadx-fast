package kotlin.i0.z.e;

import kotlin.d0.d.c;
import kotlin.d0.d.d0;
import kotlin.d0.d.i;
import kotlin.d0.d.j;
import kotlin.d0.d.p;
import kotlin.d0.d.q;
import kotlin.d0.d.s;
import kotlin.d0.d.w;
import kotlin.i0.d;
import kotlin.i0.f;
import kotlin.i0.g;
import kotlin.i0.i;
import kotlin.i0.j;
import kotlin.i0.n;
import kotlin.i0.z.d;

/* loaded from: classes3.dex */
public class d0 extends d0 {
    private static kotlin.i0.z.e.j i(c c) {
        f obj1;
        if (obj1 instanceof j) {
        } else {
            obj1 = b.v;
        }
        return obj1;
    }

    @Override // kotlin.d0.d.d0
    public g a(j j) {
        k kVar = new k(d0.i(j), j.getName(), j.getSignature(), j.getBoundReceiver());
        return kVar;
    }

    @Override // kotlin.d0.d.d0
    public d b(Class class) {
        return g.a(class);
    }

    @Override // kotlin.d0.d.d0
    public f c(Class class, String string2) {
        o oVar = new o(class, string2);
        return oVar;
    }

    @Override // kotlin.d0.d.d0
    public i d(q q) {
        l lVar = new l(d0.i(q), q.getName(), q.getSignature(), q.getBoundReceiver());
        return lVar;
    }

    @Override // kotlin.d0.d.d0
    public j e(s s) {
        m mVar = new m(d0.i(s), s.getName(), s.getSignature(), s.getBoundReceiver());
        return mVar;
    }

    @Override // kotlin.d0.d.d0
    public n f(w w) {
        r rVar = new r(d0.i(w), w.getName(), w.getSignature(), w.getBoundReceiver());
        return rVar;
    }

    @Override // kotlin.d0.d.d0
    public String g(i i) {
        g gVar;
        gVar = d.a(i);
        gVar = j0.b(gVar);
        if (gVar != null && gVar != null) {
            gVar = j0.b(gVar);
            if (gVar != null) {
                return f0.b.e(gVar.L());
            }
        }
        return super.g(i);
    }

    @Override // kotlin.d0.d.d0
    public String h(p p) {
        return g(p);
    }
}
