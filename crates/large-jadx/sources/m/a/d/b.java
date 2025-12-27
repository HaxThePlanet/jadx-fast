package m.a.d;

import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;
import m.a.c.h.a;

/* compiled from: Module.kt */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a9\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u001b\u0010\u0005\u001a\u0017\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u0008¢\u0006\u0002\u0008\tH\u0007\u001a-\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0005\u001a\u0017\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u0008¢\u0006\u0002\u0008\t*,\u0010\n\"\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\t2\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\t¨\u0006\u000b", d2 = {"module", "Lorg/koin/core/module/Module;", "createdAtStart", "", "override", "moduleDeclaration", "Lkotlin/Function1;", "", "Lorg/koin/dsl/ModuleDeclaration;", "Lkotlin/ExtensionFunctionType;", "ModuleDeclaration", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* typealias ModuleDeclaration = kotlin.Function1<org.koin.core.module.Module, kotlin.Unit> */
public final class b {
    /* renamed from: a, reason: from kotlin metadata */
    public static final a module(boolean createdAtStart, l<? super a, w> moduleDeclaration) {
        n.f(moduleDeclaration, "moduleDeclaration");
        a module = new Module(createdAtStart);
        moduleDeclaration.invoke(module);
        return module;
    }

    public static /* synthetic */ a b(boolean z, l lVar, int i, Object object) {
        boolean z2 = false;
        if (i & 1 != 0) {
            i = 0;
        }
        return b.module(z2, lVar);
    }
}
