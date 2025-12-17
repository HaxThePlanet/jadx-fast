package f.c.a.d.e;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.g;
import f.c.a.d.e.b.a;

/* loaded from: classes2.dex */
public final class f {

    public static final a.g<a> a;
    public static final a.g<a> b;
    public static final a.a<a, f.c.a.d.e.a> c;
    static final a.a<a, f.c.a.d.e.e> d;
    static {
        a.g gVar = new a.g();
        f.a = gVar;
        a.g gVar2 = new a.g();
        f.b = gVar2;
        c cVar = new c();
        f.c = cVar;
        d dVar = new d();
        f.d = dVar;
        Scope scope = new Scope("profile");
        Scope scope2 = new Scope("email");
        a aVar2 = new a("SignIn.API", cVar, gVar);
        a aVar = new a("SignIn.INTERNAL_API", dVar, gVar2);
    }
}
