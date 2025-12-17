package androidx.room;

import d.s.a.h;
import d.s.a.h.b;
import d.s.a.h.c;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class q0 implements h.c {

    private final h.c a;
    private final androidx.room.u0.f b;
    private final Executor c;
    q0(h.c h$c, androidx.room.u0.f u0$f2, Executor executor3) {
        super();
        this.a = c;
        this.b = f2;
        this.c = executor3;
    }

    @Override // d.s.a.h$c
    public h a(h.b h$b) {
        p0 p0Var = new p0(this.a.a(b), this.b, this.c);
        return p0Var;
    }
}
