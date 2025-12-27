package m.a.d;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.i0.d;
import kotlin.o;
import kotlin.y.p;
import m.a.c.e.b;
import m.a.c.f.c;

/* compiled from: DefinitionBinding.kt */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0001\"\u0006\u0008\u0000\u0010\u0004\u0018\u0001*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0001H\u0086\u0008\u001a9\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0001*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0006H\u0086\u0004\u001aD\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u0001*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00030\u00012\u0010\u0010\u0008\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\tH\u0086\u0004¢\u0006\u0002\u0010\n\u001aW\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\u0004\u0008\u0000\u0010\u0004*\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u00030\u00012\u001e\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0004\u0012\u00020\r0\u000cj\u0008\u0012\u0004\u0012\u0002H\u0004`\u000eH\u0086\u0004¨\u0006\u000f", d2 = {"bind", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "T", "clazz", "Lkotlin/reflect/KClass;", "binds", "classes", "", "(Lkotlin/Pair;[Lkotlin/reflect/KClass;)Lkotlin/Pair;", "onClose", "Lkotlin/Function1;", "", "Lorg/koin/core/definition/OnCloseCallback;", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final o<m.a.c.h.a, c<?>> a(o<m.a.c.h.a, ? extends c<?>> oVar, d<?> dVar) {
        n.f(oVar, "<this>");
        n.f(dVar, "clazz");
        (InstanceFactory)oVar.d().dropAll().f(z.u0((InstanceFactory)oVar.d().dropAll().e(), dVar));
        (Module)oVar.c().factory(org.koin.core.definition.b.a(dVar, (InstanceFactory)oVar.d().dropAll().c(), (InstanceFactory)oVar.d().dropAll().d()), (InstanceFactory)oVar.d(), true);
        return oVar;
    }
}
