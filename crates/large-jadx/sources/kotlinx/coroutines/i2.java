package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.d0.c.p;
import kotlin.w;
import kotlinx.coroutines.c3.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012'\u0010\u0004\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\u0008\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0008\u0010\r\u001a\u00020\u0008H\u0014R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/LazyStandaloneCoroutine;", "Lkotlinx/coroutines/StandaloneCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)V", "continuation", "onStart", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class i2 extends kotlinx.coroutines.q2 {

    private final d<w> c;
    public i2(g g, p<? super kotlinx.coroutines.m0, ? super d<? super w>, ? extends Object> p2) {
        super(g, 0);
        this.c = b.b(p2, this, this);
    }

    @Override // kotlinx.coroutines.q2
    protected void r0() {
        a.c(this.c, this);
    }
}
