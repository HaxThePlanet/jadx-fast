package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000f\u001a\u00020\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012H\u0096@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\u000cJ\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0017H\u0096\u0003R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0018\u0010\n\u001a\u00028\u0000X\u0096\u000f¢\u0006\u000c\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u0018", d2 = {"Landroidx/compose/runtime/ProduceStateScopeImpl;", "T", "Landroidx/compose/runtime/ProduceStateScope;", "Landroidx/compose/runtime/MutableState;", "state", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/MutableState;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "awaitDispose", "", "onDispose", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ProduceStateScopeImpl<T>  implements androidx.compose.runtime.ProduceStateScope<T>, androidx.compose.runtime.MutableState<T> {

    private final androidx.compose.runtime.MutableState<T> $$delegate_0;
    private final CoroutineContext coroutineContext;
    public ProduceStateScopeImpl(androidx.compose.runtime.MutableState<T> state, CoroutineContext coroutineContext) {
        super();
        this.coroutineContext = coroutineContext;
        this.$$delegate_0 = state;
    }

    public Object awaitDispose(Function0<Unit> function0, Continuation<?> continuation2) {
        boolean anon;
        Throwable th;
        Object l$0;
        int i2;
        int label;
        Object result;
        Object cOROUTINE_SUSPENDED;
        int i;
        CancellableContinuationImpl cancellableContinuationImpl;
        Continuation intercepted;
        Throwable th2;
        int obj10;
        Object obj11;
        anon = continuation2;
        i2 = Integer.MIN_VALUE;
        if (continuation2 instanceof ProduceStateScopeImpl.awaitDispose.1 && label2 &= i2 != 0) {
            anon = continuation2;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj11 -= i2;
            } else {
                anon = new ProduceStateScopeImpl.awaitDispose.1(this, continuation2);
            }
        } else {
        }
        obj11 = anon.result;
        Object cOROUTINE_SUSPENDED2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                anon.L$0 = function0;
                int i3 = 1;
                anon.label = i3;
                i = 0;
                cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)anon), i3);
                cancellableContinuationImpl.initCancellability();
                CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                int i4 = 0;
                result = cancellableContinuationImpl.getResult();
                DebugProbesKt.probeCoroutineSuspended((Continuation)anon);
                return cOROUTINE_SUSPENDED2;
                l$0 = function0;
                obj10 = label;
                break;
            case 1:
                obj10 = 0;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                break;
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        obj10 = new KotlinNothingValueException();
        throw obj10;
    }

    public T component1() {
        return this.$$delegate_0.component1();
    }

    public Function1<T, Unit> component2() {
        return this.$$delegate_0.component2();
    }

    @Override // androidx.compose.runtime.ProduceStateScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public T getValue() {
        return this.$$delegate_0.getValue();
    }

    public void setValue(T t) {
        this.$$delegate_0.setValue(t);
    }
}
