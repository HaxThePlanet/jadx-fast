package m.a.c.h;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import m.a.c.f.c;
import m.a.c.f.d;
import m.a.c.j.a;

/* compiled from: Module.kt */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J]\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H!0\u00150 \"\u0006\u0008\u0000\u0010!\u0018\u00012\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2)\u0008\u0008\u0010#\u001a#\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002H!0$j\u0008\u0012\u0004\u0012\u0002H!`'¢\u0006\u0002\u0008(H\u0086\u0008ø\u0001\u0000Je\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H!0\u00150 \"\u0006\u0008\u0000\u0010!\u0018\u00012\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2)\u0008\u0008\u0010#\u001a#\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002H!0$j\u0008\u0012\u0004\u0012\u0002H!`'¢\u0006\u0002\u0008(2\u0006\u0010)\u001a\u00020\u001cH\u0081\u0008ø\u0001\u0000J\u001d\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00000+2\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\u00000+H\u0086\u0002J\u0017\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00000+2\u0006\u0010-\u001a\u00020\u0000H\u0086\u0002J*\u0010.\u001a\u00020/2\n\u00100\u001a\u00060\u0013j\u0002`\u00142\n\u0010\u001f\u001a\u0006\u0012\u0002\u0008\u00030\u00152\u0008\u0008\u0002\u00101\u001a\u00020\u0003H\u0001J'\u00102\u001a\u00020/2\u0006\u0010\"\u001a\u00020\u001c2\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020/04¢\u0006\u0002\u0008(J-\u00102\u001a\u00020/\"\u0006\u0008\u0000\u0010!\u0018\u00012\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020/04¢\u0006\u0002\u0008(H\u0086\u0008ø\u0001\u0000Jg\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H!0\u00150 \"\u0006\u0008\u0000\u0010!\u0018\u00012\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c2\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032)\u0008\u0008\u0010#\u001a#\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u0002H!0$j\u0008\u0012\u0004\u0012\u0002H!`'¢\u0006\u0002\u0008(H\u0086\u0008ø\u0001\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006RT\u0010\u000b\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u0008j\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t`\n2\u001e\u0010\u0007\u001a\u001a\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u0008j\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t`\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0006RH\u0010\u0011\u001a.\u0012\u0008\u0012\u00060\u0013j\u0002`\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00150\u0012j\u0016\u0012\u0008\u0012\u00060\u0013j\u0002`\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0015`\u00168\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0019\u0010\u001aR,\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0008j\u0008\u0012\u0004\u0012\u00020\u001c`\n8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001d\u0010\u0018\u001a\u0004\u0008\u001e\u0010\r\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u00067", d2 = {"Lorg/koin/core/module/Module;", "", "createdAtStart", "", "(Z)V", "getCreatedAtStart", "()Z", "<set-?>", "Ljava/util/HashSet;", "Lorg/koin/core/instance/SingleInstanceFactory;", "Lkotlin/collections/HashSet;", "eagerInstances", "getEagerInstances", "()Ljava/util/HashSet;", "setEagerInstances$koin_core", "(Ljava/util/HashSet;)V", "isLoaded", "mappings", "Ljava/util/HashMap;", "", "Lorg/koin/core/definition/IndexKey;", "Lorg/koin/core/instance/InstanceFactory;", "Lkotlin/collections/HashMap;", "getMappings$annotations", "()V", "getMappings", "()Ljava/util/HashMap;", "scopes", "Lorg/koin/core/qualifier/Qualifier;", "getScopes$annotations", "getScopes", "factory", "Lkotlin/Pair;", "T", "qualifier", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "scopeQualifier", "plus", "", "modules", "module", "saveMapping", "", "mapping", "allowOverride", "scope", "scopeSet", "Lkotlin/Function1;", "Lorg/koin/dsl/ScopeDSL;", "single", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class Module {

    /* renamed from: a, reason: from kotlin metadata */
    private final boolean createdAtStart;
    /* renamed from: b, reason: from kotlin metadata */
    private HashSet<d<?>> eagerInstances;
    private final HashMap<String, c<?>> c;
    private final HashSet<a> d;
    public a(boolean z) {
        super();
        this.createdAtStart = z;
        this.eagerInstances = new HashSet();
        this.c = new HashMap();
        this.d = new HashSet();
    }

    public static /* synthetic */ void f(a aVar, String str, c cVar, boolean z, int i, Object object) {
        if (i & 4 != 0) {
            i = 0;
        }
        aVar.factory(str, cVar, z);
    }

    public final boolean a() {
        return this.createdAtStart;
    }

    public final HashSet<d<?>> b() {
        return this.eagerInstances;
    }

    public final HashMap<String, c<?>> c() {
        return this.c;
    }

    public final HashSet<a> d() {
        return this.d;
    }

    /* renamed from: e, reason: from kotlin metadata */
    /* inline */ public final void factory(String qualifier, c<?> definition, boolean scopeQualifier) {
        n.f(qualifier, "mapping");
        n.f(definition, "factory");
        if (!scopeQualifier) {
            if (this.c.containsKey(qualifier)) {
                org.koin.core.module.b.a(definition, qualifier);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            }
        }
        this.c.put(qualifier, definition);
    }

    public /* synthetic */ a(boolean z, int i, g gVar) {
        boolean z2 = false;
        i = i & 1 != 0 ? 0 : i;
        this(z2);
    }

    public a() {
        this(false, 1, null);
    }
}
