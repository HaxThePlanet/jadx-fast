package m.a.c.k;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.i0.d;
import m.a.c.a;
import m.a.c.e.b;
import m.a.c.f.b;
import m.a.c.f.c;
import m.a.c.f.d;
import m.a.c.g.b;
import m.a.c.g.c;
import m.a.c.h.a;
import m.a.c.h.b;
import m.a.c.j.a;
import m.a.f.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008\u0016J\r\u0010\u0017\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008\u0018J(\u0010\u0019\u001a\u00020\u00152\u001e\u0010\u000c\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e0\rj\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e`\u000fH\u0002JP\u0010\u001a\u001a\u00020\u0015\"\u0006\u0008\u0000\u0010\u001b\u0018\u00012\u0006\u0010\u001c\u001a\u0002H\u001b2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0012\u0008\u0002\u0010\u001f\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030!0 2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\u0081\u0008¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\u0008)J-\u0010*\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0 \"\u0004\u0008\u0000\u0010\u001b2\n\u0010+\u001a\u0006\u0012\u0002\u0008\u00030!2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\u0008.J\u0018\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u0010\"\u001a\u00020#H\u0002J#\u00102\u001a\u00020\u00152\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002010 2\u0006\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\u00084J=\u00105\u001a\u0004\u0018\u0001H\u001b\"\u0004\u0008\u0000\u0010\u001b2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0010+\u001a\u0006\u0012\u0002\u0008\u00030!2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0004\u00086\u00107J2\u00108\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\n\u00109\u001a\u00060\u0007j\u0002`\u00082\n\u0010:\u001a\u0006\u0012\u0002\u0008\u00030\t2\u0008\u0008\u0002\u0010;\u001a\u00020#H\u0007J\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0002J\u001b\u0010?\u001a\u00020\u00152\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002010 H\u0000¢\u0006\u0002\u0008@R\"\u0010\u0005\u001a\u0016\u0012\u0008\u0012\u00060\u0007j\u0002`\u0008\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR&\u0010\u000c\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e0\rj\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u0010\u001a\u0016\u0012\u0008\u0012\u00060\u0007j\u0002`\u0008\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006A", d2 = {"Lorg/koin/core/registry/InstanceRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "_instances", "", "", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "get_koin", "()Lorg/koin/core/Koin;", "eagerInstances", "Ljava/util/HashSet;", "Lorg/koin/core/instance/SingleInstanceFactory;", "Lkotlin/collections/HashSet;", "instances", "", "getInstances", "()Ljava/util/Map;", "close", "", "close$koin_core", "createAllEagerInstances", "createAllEagerInstances$koin_core", "createEagerInstances", "declareInstance", "T", "instance", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "allowOverride", "", "scopeQualifier", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;ZLorg/koin/core/qualifier/Qualifier;)V", "dropScopeInstances", "scope", "Lorg/koin/core/scope/Scope;", "dropScopeInstances$koin_core", "getAll", "clazz", "instanceContext", "Lorg/koin/core/instance/InstanceContext;", "getAll$koin_core", "loadModule", "module", "Lorg/koin/core/module/Module;", "loadModules", "modules", "loadModules$koin_core", "resolveInstance", "resolveInstance$koin_core", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "saveMapping", "mapping", "factory", "logWarning", "size", "", "unloadModule", "unloadModules", "unloadModules$koin_core", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a {

    private final a a;
    private final Map<String, c<?>> b;
    private final HashSet<d<?>> c;
    public a(a a) {
        n.f(a, "_koin");
        super();
        this.a = a;
        this.b = a.a.e();
        HashSet obj2 = new HashSet();
        this.c = obj2;
    }

    private final void b(HashSet<d<?>> hashSet) {
        boolean z;
        int bVar;
        Object dEBUG;
        m.a.c.k.c next2;
        boolean next;
        b bVar2;
        a aVar2;
        m.a.c.l.a aVar;
        int i;
        int i2;
        int i3;
        Iterator obj9;
        if (empty ^= 1 != 0 && this.a.c().f(b.DEBUG)) {
            if (this.a.c().f(b.DEBUG)) {
                this.a.c().b("Creating eager instances ...");
            }
            aVar2 = this.a;
            super(aVar2, aVar2.d().b(), 0, 4, 0);
            obj9 = hashSet.iterator();
            for (d next2 : obj9) {
                next2.b(bVar);
            }
        }
    }

    private final void c(a a, boolean z2) {
        Object value;
        Object key;
        m.a.c.k.a aVar;
        boolean z;
        Object obj;
        Object obj2;
        int i2;
        int i3;
        int i;
        Iterator obj10 = a.c().entrySet().iterator();
        for (Map.Entry next2 : obj10) {
            a.g(this, z2, (String)next2.getKey(), (c)next2.getValue(), false, 8, 0);
        }
    }

    public static void g(m.a.c.k.a a, boolean z2, String string3, c c4, boolean z5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 1;
        }
        a.f(z2, string3, c4, obj4);
    }

    public final void a() {
        b(this.c);
        this.c.clear();
    }

    public final void d(List<a> list, boolean z2) {
        String str;
        HashSet set;
        n.f(list, "modules");
        final Iterator obj3 = list.iterator();
        for (a next2 : obj3) {
            c(next2, z2);
            this.c.addAll(next2.b());
        }
    }

    public final <T> T e(a a, d<?> d2, a a3, b b4) {
        int obj2;
        n.f(d2, "clazz");
        n.f(a3, "scopeQualifier");
        n.f(b4, "instanceContext");
        obj2 = this.b.get(b.a(d2, a, a3));
        if ((c)obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = (c)obj2.b(b4);
        }
        return obj2;
    }

    public final void f(boolean z, String string2, c<?> c3, boolean z4) {
        boolean string;
        Object dEBUG;
        m.a.c.e.a aVar;
        c obj3;
        String obj6;
        n.f(string2, "mapping");
        n.f(c3, "factory");
        if (this.b.containsKey(string2)) {
            if (z == null) {
            } else {
                if (z4 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Override Mapping '");
                    stringBuilder.append(string2);
                    stringBuilder.append("' with ");
                    stringBuilder.append(c3.c());
                    this.a.c().e(stringBuilder.toString());
                }
            }
            b.a(c3, string2);
            throw 0;
        }
        if (this.a.c().f(b.DEBUG) && z4 != null) {
            if (z4 != null) {
                obj6 = new StringBuilder();
                obj6.append("add mapping '");
                obj6.append(string2);
                obj6.append("' for ");
                obj6.append(c3.c());
                this.a.c().b(obj6.toString());
            }
        }
        this.b.put(string2, c3);
    }

    public final int h() {
        return this.b.size();
    }
}
