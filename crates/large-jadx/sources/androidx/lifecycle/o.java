package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.b0.g;
import kotlin.d0.d.n;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.s2;

/* loaded from: classes.dex */
public final class o {
    public static final androidx.lifecycle.l a(androidx.lifecycle.j j) {
        String lifecycleCoroutineScopeImpl;
        boolean compareAndSet;
        int i;
        j2 j2Var;
        n.f(j, "$this$coroutineScope");
        Object obj = j.a.get();
        while ((LifecycleCoroutineScopeImpl)obj != null) {
            i = 0;
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(j, s2.b(i, 1, i).plus(c1.c().M()));
            obj = j.a.get();
        }
        return (LifecycleCoroutineScopeImpl)(LifecycleCoroutineScopeImpl)obj;
    }
}
