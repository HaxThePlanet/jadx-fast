package m.a.c.k;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import m.a.c.a;
import m.a.c.h.a;
import m.a.c.j.a;
import m.a.c.j.b;
import m.a.c.j.c;
import m.a.c.l.a;
import m.a.f.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\"\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\u0008\u0019J\u0008\u0010\u001a\u001a\u00020\u0018H\u0002J(\u0010\u001b\u001a\u00020\r2\n\u0010\u001c\u001a\u00060\u000bj\u0002`\u000c2\u0006\u0010\u001d\u001a\u00020\u00072\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0001J\u0015\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\rH\u0000¢\u0006\u0002\u0008!J\u0019\u0010\u001f\u001a\u00020\u00182\n\u0010\u001c\u001a\u00060\u000bj\u0002`\u000cH\u0000¢\u0006\u0002\u0008!J\u0016\u0010\"\u001a\u0004\u0018\u00010\r2\n\u0010\u001c\u001a\u00060\u000bj\u0002`\u000cH\u0001J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010&\u001a\u00020\u00182\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020%0(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\u0008\u0012\u0004\u0012\u00020\u0007`\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0008\u0012\u00060\u000bj\u0002`\u000c\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00148F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006*", d2 = {"Lorg/koin/core/registry/ScopeRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "_scopeDefinitions", "Ljava/util/HashSet;", "Lorg/koin/core/qualifier/Qualifier;", "Lkotlin/collections/HashSet;", "_scopes", "", "", "Lorg/koin/core/scope/ScopeID;", "Lorg/koin/core/scope/Scope;", "rootScope", "getRootScope$annotations", "()V", "getRootScope", "()Lorg/koin/core/scope/Scope;", "scopeDefinitions", "", "getScopeDefinitions", "()Ljava/util/Set;", "close", "", "close$koin_core", "closeAllScopes", "createScope", "scopeId", "qualifier", "source", "deleteScope", "scope", "deleteScope$koin_core", "getScopeOrNull", "loadModule", "module", "Lorg/koin/core/module/Module;", "loadScopes", "modules", "", "Companion", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c {

    public static final m.a.c.k.c.a e;
    private static final c f;
    private final a a;
    private final HashSet<a> b;
    private final Map<String, a> c;
    private final a d;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0007\u0010\u0002\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lorg/koin/core/registry/ScopeRegistry$Companion;", "", "()V", "ROOT_SCOPE_ID", "", "rootScopeQualifier", "Lorg/koin/core/qualifier/StringQualifier;", "getRootScopeQualifier$annotations", "getRootScopeQualifier", "()Lorg/koin/core/qualifier/StringQualifier;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final c a() {
            return c.a();
        }
    }
    static {
        c.a aVar = new c.a(0);
        c.e = aVar;
        c.f = b.a("_");
    }

    public c(a a) {
        n.f(a, "_koin");
        super();
        this.a = a;
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        Map map = a.a.e();
        this.c = map;
        a aVar2 = new a(c.f, "_", 1, a);
        this.d = aVar2;
        hashSet.add(aVar2.f());
        map.put(aVar2.d(), aVar2);
    }

    public static final c a() {
        return c.f;
    }

    private final void c(a a) {
        this.b.addAll(a.d());
    }

    public final a b() {
        return this.d;
    }

    public final void d(List<a> list) {
        String next;
        n.f(list, "modules");
        final Iterator obj2 = list.iterator();
        for (a next : obj2) {
            c(next);
        }
    }
}
