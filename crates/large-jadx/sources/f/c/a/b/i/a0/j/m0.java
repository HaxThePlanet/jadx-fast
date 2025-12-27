package f.c.a.b.i.a0.j;

import android.content.Context;
import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;
import j.a.a;

/* compiled from: EventStoreModule_PackageNameFactory.java */
/* loaded from: classes.dex */
public final class m0 implements b<String> {

    private final a<Context> a;
    public m0(a<Context> aVar) {
        super();
        this.a = aVar;
    }

    public static m0 a(a<Context> aVar) {
        return new m0(aVar);
    }

    public static String c(Context context) {
        final String str2 = k0.b(context);
        d.c(str2, "Cannot return null from a non-@Nullable @Provides method");
        return str2;
    }

    public String b() {
        return m0.c((Context)this.a.get());
    }
}
