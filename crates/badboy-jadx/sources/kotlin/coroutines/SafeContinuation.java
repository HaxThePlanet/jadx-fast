package kotlin.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0001\u0018\u0000 \u001a*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\u0008\u0011\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005B\u001f\u0008\u0000\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001b\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SafeContinuation<T>  implements kotlin.coroutines.Continuation<T>, CoroutineStackFrame {

    private static final kotlin.coroutines.SafeContinuation.Companion Companion;
    private static final AtomicReferenceFieldUpdater<kotlin.coroutines.SafeContinuation<?>, Object> RESULT;
    private final kotlin.coroutines.Continuation<T> delegate;
    private volatile Object result;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002Rd\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\u0008\u0003 \u0006*\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00050\u0005\u0012\u000c\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\u0008\u0003 \u0006*\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00050\u0005\u0012\u000c\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0007\u0010\u0002¨\u0006\u0008", d2 = {"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "getRESULT$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private static void getRESULT$annotations() {
        }
    }
    static {
        SafeContinuation.Companion companion = new SafeContinuation.Companion(0);
        SafeContinuation.Companion = companion;
        SafeContinuation.RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    }

    public SafeContinuation(kotlin.coroutines.Continuation<? super T> delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        super(delegate, CoroutineSingletons.UNDECIDED);
    }

    public SafeContinuation(kotlin.coroutines.Continuation<? super T> delegate, Object initialResult) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        super();
        this.delegate = delegate;
        this.result = initialResult;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineStackFrame getCallerFrame() {
        kotlin.coroutines.Continuation delegate;
        if (delegate instanceof CoroutineStackFrame) {
        } else {
            delegate = 0;
        }
        return delegate;
    }

    @Override // kotlin.coroutines.Continuation
    public kotlin.coroutines.CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    @Override // kotlin.coroutines.Continuation
    public final Object getOrThrow() {
        Object result;
        CoroutineSingletons uNDECIDED;
        Object cOROUTINE_SUSPENDED2;
        CoroutineSingletons uNDECIDED2;
        Object cOROUTINE_SUSPENDED;
        if (this.result == CoroutineSingletons.UNDECIDED && AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SafeContinuation.RESULT, this, CoroutineSingletons.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
            if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SafeContinuation.RESULT, this, CoroutineSingletons.UNDECIDED, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            result = this.result;
        }
        if (result == CoroutineSingletons.RESUMED) {
            cOROUTINE_SUSPENDED2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return cOROUTINE_SUSPENDED2;
        } else {
            if (result instanceof Result.Failure) {
            } else {
                cOROUTINE_SUSPENDED2 = result;
            }
        }
        throw obj.exception;
    }

    @Override // kotlin.coroutines.Continuation
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        Object result2;
        boolean z;
        Object cOROUTINE_SUSPENDED;
        CoroutineSingletons rESUMED;
        result2 = this.result;
        while (result2 == CoroutineSingletons.UNDECIDED) {
            result2 = this.result;
        }
    }

    @Override // kotlin.coroutines.Continuation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SafeContinuation for ").append(this.delegate).toString();
    }
}
