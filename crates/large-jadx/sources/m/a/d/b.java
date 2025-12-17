package m.a.d;

import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;
import m.a.c.h.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a9\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u001b\u0010\u0005\u001a\u0017\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u0008¢\u0006\u0002\u0008\tH\u0007\u001a-\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0005\u001a\u0017\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u0008¢\u0006\u0002\u0008\t*,\u0010\n\"\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\t2\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\t¨\u0006\u000b", d2 = {"module", "Lorg/koin/core/module/Module;", "createdAtStart", "", "override", "moduleDeclaration", "Lkotlin/Function1;", "", "Lorg/koin/dsl/ModuleDeclaration;", "Lkotlin/ExtensionFunctionType;", "ModuleDeclaration", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class b {
    public static final a a(boolean z, l<? super a, w> l2) {
        n.f(l2, "moduleDeclaration");
        a aVar = new a(z);
        l2.invoke(aVar);
        return aVar;
    }

    public static a b(boolean z, l l2, int i3, Object object4) {
        int obj0;
        if (i3 &= 1 != 0) {
            obj0 = 0;
        }
        return b.a(obj0, l2);
    }
}
