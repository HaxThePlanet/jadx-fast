package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0014J\u0006\u0010\u0011\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0013\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadLocalIsSet", "", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "", "afterResume", "", "state", "clearThreadContext", "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UndispatchedCoroutine<T>  extends ScopeCoroutine<T> {

    private volatile boolean threadLocalIsSet;
    private final java.lang.ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover;
    public UndispatchedCoroutine(CoroutineContext context, Continuation<? super T> uCont) {
        CoroutineContext plus;
        boolean threadContext;
        if (context.get((CoroutineContext.Key)UndispatchedMarker.INSTANCE) == null) {
            plus = context.plus((CoroutineContext)UndispatchedMarker.INSTANCE);
        } else {
            plus = context;
        }
        super(plus, uCont);
        ThreadLocal threadLocal = new ThreadLocal();
        this.threadStateToRecover = threadLocal;
        if (!context4 instanceof CoroutineDispatcher) {
            threadContext = ThreadContextKt.updateThreadContext(context, 0);
            ThreadContextKt.restoreThreadContext(context, threadContext);
            saveThreadContext(context, threadContext);
        }
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine
    protected void afterResume(Object state) {
        Object component2;
        boolean threadStateToRecover;
        int i;
        Object component1;
        int undispatchedCompletion;
        Throwable th;
        Unit $i$a$WithContinuationContextUndispatchedCoroutine$afterResume$2;
        boolean clearThreadContext;
        component2 = this.threadStateToRecover.get();
        if (this.threadLocalIsSet != null && (Pair)component2 != null) {
            component2 = this.threadStateToRecover.get();
            if ((Pair)(Pair)component2 != null) {
                i = 0;
                ThreadContextKt.restoreThreadContext((CoroutineContext)(Pair)(Pair)component2.component1(), component2.component2());
            }
            this.threadStateToRecover.remove();
        }
        Continuation uCont2 = this.uCont;
        final int i3 = 0;
        final CoroutineContext context = uCont2.getContext();
        final Object threadContext = ThreadContextKt.updateThreadContext(context, 0);
        if (threadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
            undispatchedCompletion = CoroutineContextKt.updateUndispatchedCompletion(uCont2, context, threadContext);
        } else {
            undispatchedCompletion = 0;
        }
        int i4 = 0;
        this.uCont.resumeWith(CompletionStateKt.recoverResult(state, this.uCont));
        $i$a$WithContinuationContextUndispatchedCoroutine$afterResume$2 = Unit.INSTANCE;
        if (undispatchedCompletion != 0) {
            if (undispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, threadContext);
            }
        } else {
        }
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine
    public final boolean clearThreadContext() {
        boolean threadLocalIsSet;
        int i;
        final int i3 = 1;
        if (this.threadLocalIsSet != null && this.threadStateToRecover.get() == null) {
            i = this.threadStateToRecover.get() == null ? i3 : 0;
        } else {
        }
        final int i4 = i;
        final int i5 = 0;
        this.threadStateToRecover.remove();
        return i ^= i3;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine
    public final void saveThreadContext(CoroutineContext context, Object oldValue) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(TuplesKt.to(context, oldValue));
    }
}
