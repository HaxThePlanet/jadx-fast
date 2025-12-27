package f.c.a.b.i.a0.j;

import android.content.Context;
import f.c.a.b.i.w.b.b;
import j.a.a;

/* compiled from: SchemaManager_Factory.java */
/* loaded from: classes.dex */
public final class t0 implements b<s0> {

    private final a<Context> a;
    private final a<String> b;
    private final a<Integer> c;
    public t0(a<Context> aVar, a<String> aVar2, a<Integer> aVar3) {
        super();
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
    }

    public static t0 a(a<Context> aVar, a<String> aVar2, a<Integer> aVar3) {
        return new t0(aVar, aVar2, aVar3);
    }

    public static s0 c(Context context, String str, int i) {
        return new s0(context, str, i);
    }

    public s0 b() {
        return t0.c((Context)this.a.get(), (String)this.b.get(), (Integer)this.c.get().intValue());
    }
}
