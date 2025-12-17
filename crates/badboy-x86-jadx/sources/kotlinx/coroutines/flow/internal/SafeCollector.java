package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J'\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001a\u001a\u0004\u0018\u00010\u001c2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J \u0010$\u001a\u00020\u001c2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0&H\u0016ø\u0001\u0000¢\u0006\u0002\u0010'J\u0008\u0010(\u001a\u00020\u0010H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006)", d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collectContextSize", "", "completion", "Lkotlin/coroutines/Continuation;", "", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEmissionContext", "checkContext", "currentContext", "previousContext", "value", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SafeCollector<T>  extends ContinuationImpl implements FlowCollector<T>, CoroutineStackFrame {

    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final FlowCollector<T> collector;
    private Continuation<? super Unit> completion;
    private CoroutineContext lastEmissionContext;
    public SafeCollector(FlowCollector<? super T> collector, CoroutineContext collectContext) {
        super((Continuation)NoOpContinuation.INSTANCE, (CoroutineContext)EmptyCoroutineContext.INSTANCE);
        this.collector = collector;
        this.collectContext = collectContext;
        this.collectContextSize = (Number)this.collectContext.fold(0, (Function2)SafeCollector.collectContextSize.1.INSTANCE).intValue();
    }

    private final void checkContext(CoroutineContext currentContext, CoroutineContext previousContext, T value) {
        boolean z;
        if (previousContext instanceof DownstreamExceptionContext != null) {
            exceptionTransparencyViolated((DownstreamExceptionContext)previousContext, value);
        }
        SafeCollector_commonKt.checkContext(this, currentContext);
    }

    private final Object emit(Continuation<? super Unit> uCont, T value) {
        boolean equal;
        final CoroutineContext context = uCont.getContext();
        JobKt.ensureActive(context);
        final CoroutineContext lastEmissionContext = this.lastEmissionContext;
        if (lastEmissionContext != context) {
            checkContext(context, lastEmissionContext, value);
            this.lastEmissionContext = context;
        }
        this.completion = uCont;
        FlowCollector collector = this.collector;
        Intrinsics.checkNotNull(collector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object invoke = SafeCollectorKt.access$getEmitFun$p().invoke(collector, value, (Continuation)this);
        if (!Intrinsics.areEqual(invoke, IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
            this.completion = 0;
        }
        return invoke;
    }

    private final void exceptionTransparencyViolated(kotlinx.coroutines.flow.internal.DownstreamExceptionContext exception, Object value) {
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(StringsKt.trimIndent(stringBuilder.append("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ").append(exception.e).append(", but then emission attempt of value '").append(value).append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString()).toString());
        throw illegalStateException;
    }

    public Object emit(T value, Continuation<? super Unit> $completion) {
        final int i = 0;
        final Object emit = emit($completion, value);
        if (emit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (emit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            try {
                return emit;
                return Unit.INSTANCE;
                DownstreamExceptionContext downstreamExceptionContext = new DownstreamExceptionContext(th, obj0.getContext());
                this.lastEmissionContext = (CoroutineContext)downstreamExceptionContext;
                throw th;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public CoroutineStackFrame getCallerFrame() {
        Continuation completion;
        if (completion instanceof CoroutineStackFrame) {
        } else {
            completion = 0;
        }
        return completion;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public CoroutineContext getContext() {
        CoroutineContext lastEmissionContext;
        if (this.lastEmissionContext == null) {
            lastEmissionContext = EmptyCoroutineContext.INSTANCE;
        }
        return lastEmissionContext;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public Object invokeSuspend(Object result) {
        int i;
        kotlinx.coroutines.flow.internal.DownstreamExceptionContext downstreamExceptionContext;
        CoroutineContext context;
        Throwable exceptionOrNull-impl = Result.exceptionOrNull-impl(result);
        if (exceptionOrNull-impl != null) {
            i = 0;
            downstreamExceptionContext = new DownstreamExceptionContext(exceptionOrNull-impl, getContext());
            this.lastEmissionContext = (CoroutineContext)downstreamExceptionContext;
        }
        Continuation it = this.completion;
        if (it != null) {
            it.resumeWith(result);
        }
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
