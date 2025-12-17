package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.b;
import kotlin.b0.d;
import kotlin.b0.e;
import kotlin.b0.e.a;
import kotlin.b0.g;
import kotlin.b0.g.c;
import kotlin.d0.d.g;
import kotlinx.coroutines.internal.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008&\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u0008\u001a\u00060\tj\u0002`\nH&J\u001c\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\u0008\u001a\u00060\tj\u0002`\nH\u0017J \u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\u0008\u0000\u0010\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0087\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\rJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0018", d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "isDispatchNeeded", "", "plus", "other", "releaseInterceptedContinuation", "toString", "", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class h0 extends a implements e {

    public static final kotlinx.coroutines.h0.a a;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b<e, kotlinx.coroutines.h0> {
        private a() {
            super(e.p, h0.a.a.a);
        }

        public a(g g) {
            super();
        }
    }
    static {
        h0.a aVar = new h0.a(0);
        h0.a = aVar;
    }

    public h0() {
        super(e.p);
    }

    @Override // kotlin.b0.a
    public abstract void K(g g, Runnable runnable2);

    @Override // kotlin.b0.a
    public boolean L(g g) {
        return 1;
    }

    public final void e(d<?> d) {
        (g)d.s();
    }

    public <E extends kotlin.b0.g.b> E get(g.c<E> g$c) {
        return e.a.a(this, c);
    }

    public final <T> d<T> i(d<? super T> d) {
        g gVar = new g(this, d);
        return gVar;
    }

    public g minusKey(g.c<?> g$c) {
        return e.a.b(this, c);
    }

    @Override // kotlin.b0.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r0.a(this));
        stringBuilder.append('@');
        stringBuilder.append(r0.b(this));
        return stringBuilder.toString();
    }
}
