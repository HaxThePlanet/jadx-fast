package i.b.r0;

import i.b.l0.f;
import kotlin.d0.c.l;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
final class c implements f {

    private final l a;
    c(l l) {
        super();
        this.a = l;
    }

    @Override // i.b.l0.f
    public final void accept(Object object) {
        n.c(this.a.invoke(object), "invoke(...)");
    }
}
