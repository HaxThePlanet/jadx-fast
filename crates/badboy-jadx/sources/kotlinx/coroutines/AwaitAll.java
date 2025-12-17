package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0004\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0002\r\u000eB\u001b\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000cR\u001e\u0010\u0003\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\t\u0010\u0008\u001a\u00020\tX\u0082\u0004\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"Lkotlinx/coroutines/AwaitAll;", "T", "", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;)V", "[Lkotlinx/coroutines/Deferred;", "notCompletedCount", "Lkotlinx/atomicfu/AtomicInt;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AwaitAll<T>  {

    private static final AtomicIntegerFieldUpdater notCompletedCount$FU;
    private final kotlinx.coroutines.Deferred<T>[] deferreds;
    @Volatile
    private volatile int notCompletedCount;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002R\u001b\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0018\u00010\u0008R\u0008\u0012\u0004\u0012\u00028\u00000\t0\u0007X\u0082\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R<\u0010\u000b\u001a\u000e\u0018\u00010\u0008R\u0008\u0012\u0004\u0012\u00028\u00000\t2\u0012\u0010\n\u001a\u000e\u0018\u00010\u0008R\u0008\u0012\u0004\u0012\u00028\u00000\t8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015¨\u0006\u001a", d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "_disposer", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "disposer", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class AwaitAllNode extends kotlinx.coroutines.JobNode {

        private static final AtomicReferenceFieldUpdater _disposer$FU;
        @Volatile
        private volatile Object _disposer;
        private final kotlinx.coroutines.CancellableContinuation<List<? extends T>> continuation;
        public kotlinx.coroutines.DisposableHandle handle;
        final kotlinx.coroutines.AwaitAll<T> this$0;
        static {
            AwaitAll.AwaitAllNode._disposer$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitAll.AwaitAllNode.class, Object.class, "_disposer");
        }

        public AwaitAllNode(kotlinx.coroutines.AwaitAll this$0, kotlinx.coroutines.CancellableContinuation continuation) {
            this.this$0 = this$0;
            super();
            this.continuation = continuation;
        }

        public final kotlinx.coroutines.AwaitAll.DisposeHandlersOnCancel<T> getDisposer() {
            return (AwaitAll.DisposeHandlersOnCancel)AwaitAll.AwaitAllNode._disposer$FU.get(this);
        }

        @Override // kotlinx.coroutines.JobNode
        public final kotlinx.coroutines.DisposableHandle getHandle() {
            kotlinx.coroutines.DisposableHandle handle = this.handle;
            if (handle != null) {
                return handle;
            }
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            return null;
        }

        @Override // kotlinx.coroutines.JobNode
        public Object invoke(Object p1) {
            invoke((Throwable)p1);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.JobNode
        public void invoke(Throwable cause) {
            Object tryResumeWithException;
            Object constructor-impl;
            int i3;
            ArrayList arrayList;
            kotlinx.coroutines.Deferred[] objArr;
            int i2;
            int length;
            int i4;
            kotlinx.coroutines.Deferred deferred;
            Object it;
            int i;
            if (cause != null) {
                tryResumeWithException = this.continuation.tryResumeWithException(cause);
                this.continuation.completeResume(tryResumeWithException);
                constructor-impl = getDisposer();
                if (tryResumeWithException != null && constructor-impl != null) {
                    this.continuation.completeResume(tryResumeWithException);
                    constructor-impl = getDisposer();
                    if (constructor-impl != null) {
                        constructor-impl.disposeAll();
                    }
                }
            } else {
                if (AwaitAll.access$getNotCompletedCount$FU$p().decrementAndGet(this.this$0) == 0) {
                    kotlinx.coroutines.Deferred[] objArr2 = AwaitAll.access$getDeferreds$p(this.this$0);
                    i3 = 0;
                    arrayList = new ArrayList(objArr2.length);
                    objArr = objArr2;
                    i2 = 0;
                    i4 = 0;
                    while (i4 < objArr.length) {
                        i = 0;
                        (Collection)arrayList.add(objArr[i4].getCompleted());
                        i4++;
                    }
                    kotlin.Result.Companion $this$map$iv = Result.Companion;
                    (Continuation)this.continuation.resumeWith(Result.constructor-impl((List)arrayList));
                }
            }
        }

        public final void setDisposer(kotlinx.coroutines.AwaitAll.DisposeHandlersOnCancel<T> value) {
            AwaitAll.AwaitAllNode._disposer$FU.set(this, value);
        }

        @Override // kotlinx.coroutines.JobNode
        public final void setHandle(kotlinx.coroutines.DisposableHandle <set-?>) {
            this.handle = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\u000c0\u0004R\u0008\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0008\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\t2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\u000c0\u0004R\u0008\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f", d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class DisposeHandlersOnCancel extends kotlinx.coroutines.CancelHandler {

        private final kotlinx.coroutines.AwaitAll.AwaitAllNode<T>[] nodes;
        final kotlinx.coroutines.AwaitAll<T> this$0;
        public DisposeHandlersOnCancel(kotlinx.coroutines.AwaitAll this$0, kotlinx.coroutines.AwaitAll.AwaitAllNode[] nodes) {
            this.this$0 = this$0;
            super();
            this.nodes = nodes;
        }

        @Override // kotlinx.coroutines.CancelHandler
        public final void disposeAll() {
            int i;
            kotlinx.coroutines.AwaitAll.AwaitAllNode awaitAllNode;
            kotlinx.coroutines.AwaitAll.AwaitAllNode awaitAllNode2;
            int i2;
            kotlinx.coroutines.DisposableHandle handle;
            final kotlinx.coroutines.AwaitAll.AwaitAllNode[] nodes = this.nodes;
            final int i3 = 0;
            i = 0;
            while (i < nodes.length) {
                i2 = 0;
                nodes[i].getHandle().dispose();
                i++;
            }
        }

        @Override // kotlinx.coroutines.CancelHandler
        public Object invoke(Object p1) {
            invoke((Throwable)p1);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancelHandler
        public void invoke(Throwable cause) {
            disposeAll();
        }

        @Override // kotlinx.coroutines.CancelHandler
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("DisposeHandlersOnCancel[").append(this.nodes).append(']').toString();
        }
    }
    static {
        AwaitAll.notCompletedCount$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    }

    public AwaitAll(kotlinx.coroutines.Deferred<? extends T>[] deferreds) {
        super();
        this.deferreds = deferreds;
        this.notCompletedCount = deferreds2.length;
    }

    public static final kotlinx.coroutines.Deferred[] access$getDeferreds$p(kotlinx.coroutines.AwaitAll $this) {
        return $this.deferreds;
    }

    public static final AtomicIntegerFieldUpdater access$getNotCompletedCount$FU$p() {
        return AwaitAll.notCompletedCount$FU;
    }

    public final Object await(Continuation<? super List<? extends T>> $completion) {
        int i4;
        boolean completed;
        int i;
        kotlinx.coroutines.AwaitAll.AwaitAllNode[] objArr;
        kotlinx.coroutines.Deferred deferred;
        kotlinx.coroutines.AwaitAll.AwaitAllNode awaitAllNode;
        Unit $this$await_u24lambda_u242_u24lambda_u240;
        int i2;
        kotlinx.coroutines.DisposableHandle onCompletion;
        int i3;
        final kotlinx.coroutines.AwaitAll awaitAll = this;
        final int i5 = 0;
        int i6 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i8 = 0;
        int length = objArr2.length;
        final kotlinx.coroutines.AwaitAll.AwaitAllNode[] arr = new AwaitAll.AwaitAllNode[length];
        i = i4;
        while (i < length) {
            deferred = AwaitAll.access$getDeferreds$p(awaitAll)[i];
            deferred.start();
            awaitAllNode = new AwaitAll.AwaitAllNode(awaitAll, (CancellableContinuation)cancellableContinuationImpl2);
            kotlinx.coroutines.AwaitAll.AwaitAllNode awaitAllNode2 = awaitAllNode;
            i2 = 0;
            i3 = 0;
            awaitAllNode2.setHandle(deferred.invokeOnCompletion((Function1)(CompletionHandlerBase)awaitAllNode2));
            $this$await_u24lambda_u242_u24lambda_u240 = Unit.INSTANCE;
            arr[i] = awaitAllNode;
            i++;
        }
        AwaitAll.DisposeHandlersOnCancel disposeHandlersOnCancel = new AwaitAll.DisposeHandlersOnCancel(awaitAll, arr);
        objArr = arr;
        int i9 = 0;
        while (i4 < objArr.length) {
            onCompletion = 0;
            objArr[i4].setDisposer(disposeHandlersOnCancel);
            i4++;
        }
        if (cancellableContinuationImpl2.isCompleted()) {
            disposeHandlersOnCancel.disposeAll();
        } else {
            objArr = 0;
            cancellableContinuationImpl2.invokeOnCancellation((Function1)(CancelHandlerBase)disposeHandlersOnCancel);
        }
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont$iv;
    }
}
