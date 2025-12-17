package m.a.c;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import m.a.c.g.a;
import m.a.c.g.b;
import m.a.c.g.c;
import m.a.c.h.a;
import m.a.c.k.a;
import m.a.c.k.b;
import m.a.c.k.c;
import m.a.c.m.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u001d\u0010\u001a\u001a\u00020\u001b\"\u0008\u0008\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u0002H\u001c¢\u0006\u0002\u0010\u001fJ#\u0010\u001a\u001a\u00020\u001b\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\u000c\u0008\u0002\u0010 \u001a\u00060!j\u0002`\"H\u0086\u0008J-\u0010\u001a\u001a\u00020\u001b\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0010 \u001a\u00060!j\u0002`\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010\u0001H\u0086\u0008J&\u0010\u001a\u001a\u00020\u001b2\n\u0010 \u001a\u00060!j\u0002`\"2\u0006\u0010$\u001a\u00020%2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010\u0001JH\u0010&\u001a\u00020\u0018\"\u0006\u0008\u0000\u0010\u001c\u0018\u00012\u0006\u0010'\u001a\u0002H\u001c2\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0012\u0008\u0002\u0010(\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030*0)2\u0008\u0008\u0002\u0010+\u001a\u00020,H\u0086\u0008¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020!J\u0012\u00100\u001a\u00020\u00182\n\u0010 \u001a\u00060!j\u0002`\"JA\u00101\u001a\u0002H\u001c\"\u0004\u0008\u0000\u0010\u001c2\n\u00102\u001a\u0006\u0012\u0002\u0008\u00030*2\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\u0008\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6¢\u0006\u0002\u00107JA\u00101\u001a\u0002H\u001c\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\u0008\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u00108J\u0017\u00109\u001a\u0008\u0012\u0004\u0012\u0002H\u001c0)\"\u0006\u0008\u0000\u0010\u001c\u0018\u0001H\u0086\u0008J!\u0010:\u001a\u00020\u001b\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0010 \u001a\u00060!j\u0002`\"H\u0086\u0008J&\u0010:\u001a\u00020\u001b2\n\u0010 \u001a\u00060!j\u0002`\"2\u0006\u0010$\u001a\u00020%2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010\u0001JC\u0010;\u001a\u0004\u0018\u0001H\u001c\"\u0004\u0008\u0000\u0010\u001c2\n\u00102\u001a\u0006\u0012\u0002\u0008\u00030*2\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\u0008\u0002\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6¢\u0006\u0002\u00107JC\u0010;\u001a\u0004\u0018\u0001H\u001c\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0016\u0008\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u00108J\u001f\u0010<\u001a\u0004\u0018\u0001H\u001c\"\u0008\u0008\u0000\u0010\u001c*\u00020\u00012\u0006\u0010/\u001a\u00020!¢\u0006\u0002\u0010=J%\u0010<\u001a\u0002H\u001c\"\u0008\u0008\u0000\u0010\u001c*\u00020\u00012\u0006\u0010/\u001a\u00020!2\u0006\u0010>\u001a\u0002H\u001c¢\u0006\u0002\u0010?J\u0012\u0010@\u001a\u00020\u001b2\n\u0010 \u001a\u00060!j\u0002`\"J\u0014\u0010A\u001a\u0004\u0018\u00010\u001b2\n\u0010 \u001a\u00060!j\u0002`\"JL\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H\u001c0C\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0008\u0002\u0010D\u001a\u00020E2\u0016\u0008\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\u0086\u0008ø\u0001\u0000JN\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0C\"\n\u0008\u0000\u0010\u001c\u0018\u0001*\u00020\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0008\u0002\u0010D\u001a\u00020E2\u0016\u0008\n\u00103\u001a\u0010\u0012\u0004\u0012\u000205\u0018\u000104j\u0004\u0018\u0001`6H\u0086\u0008ø\u0001\u0000J\u001e\u0010G\u001a\u00020\u00182\u000c\u0010H\u001a\u0008\u0012\u0004\u0012\u00020I0)2\u0008\u0008\u0002\u0010+\u001a\u00020,J\u0016\u0010J\u001a\u00020\u00182\u0006\u0010/\u001a\u00020!2\u0006\u0010K\u001a\u00020\u0001J\u0010\u0010L\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\tH\u0007J\u0014\u0010M\u001a\u00020\u00182\u000c\u0010H\u001a\u0008\u0012\u0004\u0012\u00020I0)R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u0002\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0014\u0010\u0002\u001a\u0004\u0008\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006N", d2 = {"Lorg/koin/core/Koin;", "", "()V", "instanceRegistry", "Lorg/koin/core/registry/InstanceRegistry;", "getInstanceRegistry$annotations", "getInstanceRegistry", "()Lorg/koin/core/registry/InstanceRegistry;", "<set-?>", "Lorg/koin/core/logger/Logger;", "logger", "getLogger", "()Lorg/koin/core/logger/Logger;", "propertyRegistry", "Lorg/koin/core/registry/PropertyRegistry;", "getPropertyRegistry$annotations", "getPropertyRegistry", "()Lorg/koin/core/registry/PropertyRegistry;", "scopeRegistry", "Lorg/koin/core/registry/ScopeRegistry;", "getScopeRegistry$annotations", "getScopeRegistry", "()Lorg/koin/core/registry/ScopeRegistry;", "close", "", "createEagerInstances", "createScope", "Lorg/koin/core/scope/Scope;", "T", "Lorg/koin/core/component/KoinScopeComponent;", "t", "(Lorg/koin/core/component/KoinScopeComponent;)Lorg/koin/core/scope/Scope;", "scopeId", "", "Lorg/koin/core/scope/ScopeID;", "source", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "declare", "instance", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "allowOverride", "", "(Ljava/lang/Object;Lorg/koin/core/qualifier/Qualifier;Ljava/util/List;Z)V", "deleteProperty", "key", "deleteScope", "get", "clazz", "parameters", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "(Lkotlin/reflect/KClass;Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lorg/koin/core/qualifier/Qualifier;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAll", "getOrCreateScope", "getOrNull", "getProperty", "(Ljava/lang/String;)Ljava/lang/Object;", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getScope", "getScopeOrNull", "inject", "Lkotlin/Lazy;", "mode", "Lkotlin/LazyThreadSafetyMode;", "injectOrNull", "loadModules", "modules", "Lorg/koin/core/module/Module;", "setProperty", "value", "setupLogger", "unloadModules", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a {

    private final c a;
    private final a b;
    private c c;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<w> {

        final m.a.c.a this$0;
        a(m.a.c.a a) {
            this.this$0 = a;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.this$0.b().a();
        }
    }
    public a() {
        super();
        c cVar = new c(this);
        this.a = cVar;
        a aVar = new a(this);
        this.b = aVar;
        b bVar = new b(this);
        a aVar2 = new a();
        this.c = aVar2;
    }

    public static void f(m.a.c.a a, List list2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        a.e(list2, obj2);
    }

    public final void a() {
        Object string;
        Object dEBUG;
        c cVar;
        StringBuilder stringBuilder;
        String str;
        if (this.c.f(b.DEBUG)) {
            dEBUG = "create eager instances ...";
            this.c.b(dEBUG);
            a.a aVar = new a.a(this);
            stringBuilder = new StringBuilder();
            stringBuilder.append("eager instances created in ");
            stringBuilder.append(a.a(aVar));
            stringBuilder.append(" ms");
            this.c.b(stringBuilder.toString());
        } else {
            this.b.a();
        }
    }

    public final a b() {
        return this.b;
    }

    public final c c() {
        return this.c;
    }

    public final c d() {
        return this.a;
    }

    public final void e(List<a> list, boolean z2) {
        n.f(list, "modules");
        this.b.d(list, z2);
        this.a.d(list);
        a();
    }
}
