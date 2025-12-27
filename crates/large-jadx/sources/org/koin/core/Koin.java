package m.a.c;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: Koin.kt */
@Metadata(d1 = "\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u001d\u0010\u001a\u001a\u00020\u001b\"\u0008\u0008\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u0002H\u001c¢\u0006\u0002\u0010\u001fJ#\u0010\u001a\u001a\u00020\u001b\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\u000c\u0008\u0002\u0010 \u001a\u00060!j\u0002`\"H\u0086\u0008J-\u0010\u001a\u001a\u00020\u001b\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0010 \u001a\u00060!j\u0002`\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010\u0001H\u0086\u0008J&\u0010\u001a\u001a\u00020\u001b2\n\u0010 \u001a\u00060!j\u0002`\"2\u0006\u0010$\u001a\u00020%2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010\u0001JH\u0010&\u001a\u00020\u0018\"\u0006\u0008\u0000\u0010\u001c\u0018\u00012\u0006\u0010'\u001a\u0002H\u001c2\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0012\u0008\u0002\u0010(\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030*0)2\u0008\u0008\u0002\u0010+\u001a\u00020,H\u0086\u0008¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020!J\u0012\u00100\u001a\u00020\u00182\n\u0010 \u001a\u00060!j\u0002`\"JA\u00101\u001a\u0002H\u001c\"\u0004\u0008\u0000\u0010\u001c2\n\u00102\u001a\u0006\u0012\u0002\u0008\u00030*2\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\u0008\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6¢\u0006\u0002\u00107JA\u00101\u001a\u0002H\u001c\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\u0008\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u00108J\u0017\u00109\u001a\u0008\u0012\u0004\u0012\u0002H\u001c0)\"\u0006\u0008\u0000\u0010\u001c\u0018\u0001H\u0086\u0008J!\u0010:\u001a\u00020\u001b\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0010 \u001a\u00060!j\u0002`\"H\u0086\u0008J&\u0010:\u001a\u00020\u001b2\n\u0010 \u001a\u00060!j\u0002`\"2\u0006\u0010$\u001a\u00020%2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010\u0001JC\u0010;\u001a\u0004\u0018\u0001H\u001c\"\u0004\u0008\u0000\u0010\u001c2\n\u00102\u001a\u0006\u0012\u0002\u0008\u00030*2\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\u0008\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6¢\u0006\u0002\u00107JC\u0010;\u001a\u0004\u0018\u0001H\u001c\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\u0008\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u00108J\u001f\u0010<\u001a\u0004\u0018\u0001H\u001c\"\u0008\u0008\u0000\u0010\u001c*\u00020\u00012\u0006\u0010/\u001a\u00020!¢\u0006\u0002\u0010=J%\u0010<\u001a\u0002H\u001c\"\u0008\u0008\u0000\u0010\u001c*\u00020\u00012\u0006\u0010/\u001a\u00020!2\u0006\u0010>\u001a\u0002H\u001c¢\u0006\u0002\u0010?J\u0012\u0010@\u001a\u00020\u001b2\n\u0010 \u001a\u00060!j\u0002`\"J\u0014\u0010A\u001a\u0004\u0018\u00010\u001b2\n\u0010 \u001a\u00060!j\u0002`\"JL\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H\u001c0C\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0008\u0002\u0010D\u001a\u00020E2\u0016\u0008\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\u0086\u0008ø\u0001\u0000JN\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0C\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0008\u0002\u0010D\u001a\u00020E2\u0016\u0008\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\u0086\u0008ø\u0001\u0000J\u001e\u0010G\u001a\u00020\u00182\u000c\u0010H\u001a\u0008\u0012\u0004\u0012\u00020I0)2\u0008\u0008\u0002\u0010+\u001a\u00020,J\u0016\u0010J\u001a\u00020\u00182\u0006\u0010/\u001a\u00020!2\u0006\u0010K\u001a\u00020\u0001J\u0010\u0010L\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\tH\u0007J\u0014\u0010M\u001a\u00020\u00182\u000c\u0010H\u001a\u0008\u0012\u0004\u0012\u00020I0)R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u0002\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0014\u0010\u0002\u001a\u0004\u0008\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006N", d2 = {"Lorg/koin/core/Koin;", "", "()V", "instanceRegistry", "Lorg/koin/core/registry/InstanceRegistry;", "getInstanceRegistry$annotations", "getInstanceRegistry", "()Lorg/koin/core/registry/InstanceRegistry;", "<set-?>", "Lorg/koin/core/logger/Logger;", "logger", "getLogger", "()Lorg/koin/core/logger/Logger;", "propertyRegistry", "Lorg/koin/core/registry/PropertyRegistry;", "getPropertyRegistry$annotations", "getPropertyRegistry", "()Lorg/koin/core/registry/PropertyRegistry;", "scopeRegistry", "Lorg/koin/core/registry/ScopeRegistry;", "getScopeRegistry$annotations", "getScopeRegistry", "()Lorg/koin/core/registry/ScopeRegistry;", "close", "", "createEagerInstances", "createScope", "Lorg/koin/core/scope/Scope;", "T", "Lorg/koin/core/component/KoinScopeComponent;", "t", "(Lorg/koin/core/component/KoinScopeComponent;)Lorg/koin/core/scope/Scope;", "scopeId", "", "Lorg/koin/core/scope/ScopeID;", "source", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "declare", "instance", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "allowOverride", "", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "deleteProperty", "key", "deleteScope", "get", "clazz", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getOrCreateScope", "getOrNull", "getProperty", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getScope", "getScopeOrNull", "inject", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "injectOrNull", "loadModules", "modules", "Lorg/koin/core/module/Module;", "setProperty", "value", "setupLogger", "unloadModules", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class Koin {

    private final m.a.c.k.c a = new c();
    private final m.a.c.k.a b = new a();
    private m.a.c.g.c c = new a();

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            a.this.b().close();
        }

        a() {
            super(0);
        }
    }
    public a() {
        super();
        m.a.c.k.c scopeRegistry = new ScopeRegistry(this);
        m.a.c.k.a instanceRegistry = new InstanceRegistry(this);
        m.a.c.k.b propertyRegistry = new PropertyRegistry(this);
        m.a.c.g.a emptyLogger = new EmptyLogger();
    }

    public static /* synthetic */ void f(a aVar, List list, boolean z, int i, Object object) {
        if (i & 2 != 0) {
            i = 1;
        }
        aVar.createScope(list, z);
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* inline */ public final void close() {
        if (this.c.isAt(Level.DEBUG)) {
            str2 = "create eager instances ...";
            this.c.debug(str2);
            double measureDuration = a.measureDuration(new org.koin.core.a.a(this));
            StringBuilder stringBuilder = new StringBuilder();
            str3 = "eager instances created in ";
            String str4 = " ms";
            str = str3 + measureDuration + str4;
            this.c.debug(str);
        } else {
            this.b.close();
        }
    }

    public final m.a.c.k.a b() {
        return this.b;
    }

    public final m.a.c.g.c c() {
        return this.c;
    }

    public final m.a.c.k.c d() {
        return this.a;
    }

    /* renamed from: e, reason: from kotlin metadata */
    /* inline */ public final void createScope(List<m.a.c.h.a> scopeId, boolean source) {
        n.f(scopeId, "modules");
        this.b.loadModule(scopeId, source);
        this.a.deleteScope(scopeId);
        close();
    }
}
