package f.c.a.b.i.a0.j;

import android.content.Context;
import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;
import j.a.a;

/* loaded from: classes.dex */
public final class m0 implements b<String> {

    private final a<Context> a;
    public m0(a<Context> a) {
        super();
        this.a = a;
    }

    public static f.c.a.b.i.a0.j.m0 a(a<Context> a) {
        m0 m0Var = new m0(a);
        return m0Var;
    }

    public static String c(Context context) {
        final String obj1 = k0.b(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (String)obj1;
    }

    @Override // f.c.a.b.i.w.b.b
    public String b() {
        return m0.c((Context)this.a.get());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
