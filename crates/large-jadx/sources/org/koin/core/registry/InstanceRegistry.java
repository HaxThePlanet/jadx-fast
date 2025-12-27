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

/* compiled from: InstanceRegistry.kt */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008\u0016J\r\u0010\u0017\u001a\u00020\u0015H\u0000¢\u0006\u0002\u0008\u0018J(\u0010\u0019\u001a\u00020\u00152\u001e\u0010\u000c\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e0\rj\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e`\u000fH\u0002JP\u0010\u001a\u001a\u00020\u0015\"\u0006\u0008\u0000\u0010\u001b\u0018\u00012\u0006\u0010\u001c\u001a\u0002H\u001b2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0012\u0008\u0002\u0010\u001f\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030!0 2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001eH\u0081\u0008¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\u0008)J-\u0010*\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0 \"\u0004\u0008\u0000\u0010\u001b2\n\u0010+\u001a\u0006\u0012\u0002\u0008\u00030!2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\u0008.J\u0018\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u0002012\u0006\u0010\"\u001a\u00020#H\u0002J#\u00102\u001a\u00020\u00152\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002010 2\u0006\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\u00084J=\u00105\u001a\u0004\u0018\u0001H\u001b\"\u0004\u0008\u0000\u0010\u001b2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\u0010+\u001a\u0006\u0012\u0002\u0008\u00030!2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0004\u00086\u00107J2\u00108\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\n\u00109\u001a\u00060\u0007j\u0002`\u00082\n\u0010:\u001a\u0006\u0012\u0002\u0008\u00030\t2\u0008\u0008\u0002\u0010;\u001a\u00020#H\u0007J\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0002J\u001b\u0010?\u001a\u00020\u00152\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u0002010 H\u0000¢\u0006\u0002\u0008@R\"\u0010\u0005\u001a\u0016\u0012\u0008\u0012\u00060\u0007j\u0002`\u0008\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR&\u0010\u000c\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e0\rj\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u0010\u001a\u0016\u0012\u0008\u0012\u00060\u0007j\u0002`\u0008\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006A", d2 = {"Lorg/koin/core/registry/InstanceRegistry;", "", "_koin", "Lorg/koin/core/Koin;", "(Lorg/koin/core/Koin;)V", "_instances", "", "", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "get_koin", "()Lorg/koin/core/Koin;", "eagerInstances", "Ljava/util/HashSet;", "Lorg/koin/core/instance/SingleInstanceFactory;", "Lkotlin/collections/HashSet;", "instances", "", "getInstances", "()Ljava/util/Map;", "close", "", "close$koin_core", "createAllEagerInstances", "createAllEagerInstances$koin_core", "createEagerInstances", "declareInstance", "T", "instance", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "allowOverride", "", "scopeQualifier", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;ZLorg/koin/core/qualifier/Qualifier;)V", "dropScopeInstances", "scope", "Lorg/koin/core/scope/Scope;", "dropScopeInstances$koin_core", "getAll", "clazz", "instanceContext", "Lorg/koin/core/instance/InstanceContext;", "getAll$koin_core", "loadModule", "module", "Lorg/koin/core/module/Module;", "loadModules", "modules", "loadModules$koin_core", "resolveInstance", "resolveInstance$koin_core", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "saveMapping", "mapping", "factory", "logWarning", "size", "", "unloadModule", "unloadModules", "unloadModules$koin_core", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class InstanceRegistry {

    /* renamed from: a, reason: from kotlin metadata */
    private final m.a.c.a eagerInstances;
    /* renamed from: b, reason: from kotlin metadata */
    private final Map<String, m.a.c.f.c<?>> instances;
    private final HashSet<m.a.c.f.d<?>> c = new HashSet<>();
    public a(m.a.c.a aVar) {
        n.f(aVar, "_koin");
        super();
        this.eagerInstances = aVar;
        this.instances = KoinPlatformTools.a.e();
        HashSet hashSet = new HashSet();
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final void createEagerInstances(HashSet<m.a.c.f.d<?>> eagerInstances) {
        i = !eagerInstances.isEmpty();
        if (!eagerInstances.isEmpty()) {
            if (this.eagerInstances.c().isAt(Level.DEBUG)) {
                this.eagerInstances.c().debug("Creating eager instances ...");
            }
            m.a.c.i.a aVar2 = null;
            int i2 = 4;
            kotlin.d0.d.g gVar = null;
            InstanceContext instanceContext = new InstanceContext(eagerInstances2, this.eagerInstances.d().b(), aVar2, i2, gVar);
            Iterator it = eagerInstances.iterator();
            while (it.hasNext()) {
                (SingleInstanceFactory)it.next().drop(instanceContext);
            }
        }
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final void getAll(m.a.c.h.a clazz, boolean instanceContext) {
        Iterator it = clazz.c().entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            boolean z = false;
            int i = 8;
            Object obj = null;
            InstanceRegistry.g(this, instanceContext, (String)item.getKey(), (InstanceFactory)item.getValue(), z, i, obj);
        }
    }

    public static /* synthetic */ void g(a aVar, boolean z, String str, m.a.c.f.c cVar, boolean z2, int i, Object object) {
        if (i & 8 != 0) {
            i = 1;
        }
        aVar.saveMapping(z, str, cVar, z);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final void close() {
        createEagerInstances(this.c);
        this.c.clear();
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final void loadModule(List<m.a.c.h.a> module, boolean allowOverride) {
        str = "modules";
        n.f(module, str);
        final Iterator it = module.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            getAll(item, allowOverride);
            this.c.addAll(item.b());
        }
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final <T> T resolveInstance(m.a.c.j.a qualifier, kotlin.i0.d<?> clazz, m.a.c.j.a scopeQualifier, m.a.c.f.b instanceContext) {
        int i = 0;
        n.f(clazz, "clazz");
        n.f(scopeQualifier, "scopeQualifier");
        n.f(instanceContext, "instanceContext");
        Object value = this.instances.get(org.koin.core.definition.b.a(clazz, qualifier, scopeQualifier));
        if (value == null) {
            i = 0;
        } else {
            Object drop = value.drop(instanceContext);
        }
        return i;
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final void saveMapping(boolean allowOverride, String mapping, m.a.c.f.c<?> factory, boolean logWarning) {
        n.f(mapping, "mapping");
        n.f(factory, "factory");
        if (this.instances.containsKey(mapping)) {
            if (!allowOverride) {
                org.koin.core.module.b.overrideError(factory, mapping);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                if (logWarning) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str7 = "Override Mapping '";
                    String str8 = "' with ";
                    m.a.c.e.a dropAll = factory.dropAll();
                    str6 = str7 + mapping + str8 + dropAll;
                    this.eagerInstances.c().info(str6);
                }
            }
        }
        if (this.eagerInstances.c().isAt(Level.DEBUG) && logWarning) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str4 = "add mapping '";
            String str5 = "' for ";
            m.a.c.e.a dropAll2 = factory.dropAll();
            str = str4 + mapping + str5 + dropAll2;
            this.eagerInstances.c().debug(str);
        }
        this.instances.put(mapping, factory);
    }

    public final int h() {
        return this.instances.size();
    }
}
