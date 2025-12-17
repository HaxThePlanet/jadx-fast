package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0001H\u0016J\u001a\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$¢\u0006\u0002\u0010\u0014J\u0008\u0010\u0015\u001a\u00020\rH\u0014J\u001b\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013¢\u0006\u0002\u0010\u0017J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u0005\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001a", d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseContinuationImpl implements Continuation<Object>, kotlin.coroutines.jvm.internal.CoroutineStackFrame, Serializable {

    private final Continuation<Object> completion;
    public BaseContinuationImpl(Continuation<Object> completion) {
        super();
        this.completion = completion;
    }

    public Continuation<Unit> create(Object value, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
        throw unsupportedOperationException;
    }

    public Continuation<Unit> create(Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("create(Continuation) has not been overridden");
        throw unsupportedOperationException;
    }

    @Override // kotlin.coroutines.Continuation
    public kotlin.coroutines.jvm.internal.CoroutineStackFrame getCallerFrame() {
        Continuation completion;
        if (completion instanceof CoroutineStackFrame) {
        } else {
            completion = 0;
        }
        return completion;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.Continuation
    public java.lang.StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.getStackTraceElement(this);
    }

    @Override // kotlin.coroutines.Continuation
    protected abstract Object invokeSuspend(Object object);

    @Override // kotlin.coroutines.Continuation
    protected void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object result) {
        Continuation current;
        Object param;
        Object obj;
        int i;
        Continuation completion;
        Throwable th;
        Object suspend;
        Object constructor-impl;
        int i2 = 0;
        current = this;
        int i3 = 0;
        param = result;
        DebugProbesKt.probeCoroutineResumed((Continuation)current);
        obj = current;
        i = 0;
        completion = obj.completion;
        Intrinsics.checkNotNull(completion);
        suspend = (BaseContinuationImpl)obj.invokeSuspend(param);
        while (suspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.Result.Companion companion = Result.Companion;
            constructor-impl = Result.constructor-impl(suspend);
            obj.releaseIntercepted();
            current = completion;
            param = constructor-impl;
            DebugProbesKt.probeCoroutineResumed((Continuation)current);
            obj = current;
            i = 0;
            completion = obj.completion;
            Intrinsics.checkNotNull(completion);
            suspend = (BaseContinuationImpl)obj.invokeSuspend(param);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public String toString() {
        Object stackTraceElement;
        StringBuilder stringBuilder = new StringBuilder();
        if (getStackTraceElement() != null) {
        } else {
            stackTraceElement = getClass().getName();
        }
        return stringBuilder.append("Continuation at ").append((Serializable)stackTraceElement).toString();
    }
}
