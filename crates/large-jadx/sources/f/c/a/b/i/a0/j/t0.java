package f.c.a.b.i.a0.j;

import android.content.Context;
import f.c.a.b.i.w.b.b;
import j.a.a;

/* loaded from: classes.dex */
public final class t0 implements b<f.c.a.b.i.a0.j.s0> {

    private final a<Context> a;
    private final a<String> b;
    private final a<Integer> c;
    public t0(a<Context> a, a<String> a2, a<Integer> a3) {
        super();
        this.a = a;
        this.b = a2;
        this.c = a3;
    }

    public static f.c.a.b.i.a0.j.t0 a(a<Context> a, a<String> a2, a<Integer> a3) {
        t0 t0Var = new t0(a, a2, a3);
        return t0Var;
    }

    public static f.c.a.b.i.a0.j.s0 c(Context context, String string2, int i3) {
        s0 s0Var = new s0(context, string2, i3);
        return s0Var;
    }

    @Override // f.c.a.b.i.w.b.b
    public f.c.a.b.i.a0.j.s0 b() {
        return t0.c((Context)this.a.get(), (String)this.b.get(), (Integer)this.c.get().intValue());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
