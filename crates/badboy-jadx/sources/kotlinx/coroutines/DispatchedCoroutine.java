package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0001\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0014J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0002\u0008\u0010J\u0008\u0010\u0011\u001a\u00020\u0012H\u0002J\u0008\u0010\u0013\u001a\u00020\u0012H\u0002R\u000b\u0010\u0008\u001a\u00020\t8\u0006X\u0087\u0004¨\u0006\u0014", d2 = {"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "_decision", "Lkotlinx/atomicfu/AtomicInt;", "afterCompletion", "", "state", "", "afterResume", "getResult", "getResult$kotlinx_coroutines_core", "tryResume", "", "trySuspend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DispatchedCoroutine<T>  extends ScopeCoroutine<T> {

    private static final AtomicIntegerFieldUpdater _decision$FU;
    @Volatile
    private volatile int _decision;
    static {
        DispatchedCoroutine._decision$FU = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    }

    public DispatchedCoroutine(CoroutineContext context, Continuation<? super T> uCont) {
        super(context, uCont);
    }

    public static final AtomicIntegerFieldUpdater get_decision$FU() {
        return DispatchedCoroutine._decision$FU;
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function12, Object object3) {
        Integer valueOf;
        final int i = 0;
        while (true) {
            function12.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(object3)));
        }
    }

    private final boolean tryResume() {
        int i3;
        int i2;
        boolean compareAndSet;
        AtomicIntegerFieldUpdater _decision$FU;
        int i;
        final Object obj = this;
        final int i4 = 0;
        while (/* condition */) {
            i2 = 0;
            int i5 = 0;
        }
        return i5;
    }

    private final boolean trySuspend() {
        int i2;
        int i3;
        boolean compareAndSet;
        AtomicIntegerFieldUpdater _decision$FU;
        int i;
        final Object obj = this;
        final int i4 = 0;
        while (/* condition */) {
            i = 1;
            i3 = 0;
            int i5 = 0;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Already suspended".toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine
    protected void afterCompletion(Object state) {
        afterResume(state);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine
    protected void afterResume(Object state) {
        if (tryResume()) {
        }
        final int i2 = 0;
        DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt.intercepted(this.uCont), CompletionStateKt.recoverResult(state, this.uCont), i2, 2, i2);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine
    public final Object getResult$kotlinx_coroutines_core() {
        if (trySuspend()) {
            return IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object unboxState = JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
        if (unboxState instanceof CompletedExceptionally) {
        } else {
            return unboxState;
        }
        throw obj.cause;
    }
}
