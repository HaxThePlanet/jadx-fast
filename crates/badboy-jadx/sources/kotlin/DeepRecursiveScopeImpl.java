package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00020\u0004BH\u00129\u0010\u0005\u001a5\u0008\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0008\u0008\u0012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0016\u0010\u0015\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0016J`\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000429\u0010\u0018\u001a5\u0008\u0001\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0008\u00082\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0002¢\u0006\u0002\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u001b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016¢\u0006\u0002\u0010\u001cJ\u000b\u0010\u001d\u001a\u00028\u0001¢\u0006\u0002\u0010\u001eJ2\u0010\u0015\u001a\u0002H\u001f\"\u0004\u0008\u0002\u0010 \"\u0004\u0008\u0003\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u001f0!2\u0006\u0010\t\u001a\u0002H H\u0096@¢\u0006\u0002\u0010\"R\u0018\u0010\u000b\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fRC\u0010\u0010\u001a5\u0008\u0001\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\u0008\u0008X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u001b\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013X\u0082\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006#", d2 = {"Lkotlin/DeepRecursiveScopeImpl;", "T", "R", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "value", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)V", "cont", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "function", "Lkotlin/jvm/functions/Function3;", "result", "Lkotlin/Result;", "Ljava/lang/Object;", "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crossFunctionCompletion", "currentFunction", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resumeWith", "", "(Ljava/lang/Object;)V", "runCallLoop", "()Ljava/lang/Object;", "S", "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class DeepRecursiveScopeImpl<T, R>  extends kotlin.DeepRecursiveScope<T, R> implements Continuation<R> {

    private Continuation<Object> cont;
    private Function3<? super kotlin.DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function;
    private Object result;
    private Object value;
    public DeepRecursiveScopeImpl(Function3<? super kotlin.DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> block, T value) {
        Intrinsics.checkNotNullParameter(block, "block");
        super(0);
        this.function = block;
        this.value = value;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = (Continuation)this;
        this.result = DeepRecursiveKt.access$getUNDEFINED_RESULT$p();
    }

    public static final void access$setCont$p(kotlin.DeepRecursiveScopeImpl $this, Continuation <set-?>) {
        $this.cont = <set-?>;
    }

    public static final void access$setFunction$p(kotlin.DeepRecursiveScopeImpl $this, Function3 <set-?>) {
        $this.function = <set-?>;
    }

    public static final void access$setResult$p(kotlin.DeepRecursiveScopeImpl $this, Object <set-?>) {
        $this.result = <set-?>;
    }

    private final Continuation<Object> crossFunctionCompletion(Function3<? super kotlin.DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> currentFunction, Continuation<Object> cont) {
        DeepRecursiveScopeImpl.crossFunctionCompletion$$inlined.Continuation.1 anon = new DeepRecursiveScopeImpl.crossFunctionCompletion$$inlined.Continuation.1((CoroutineContext)EmptyCoroutineContext.INSTANCE, this, currentFunction, cont);
        return (Continuation)anon;
    }

    public Object callRecursive(T value, Continuation<? super R> $completion) {
        Object obj = $completion;
        int i = 0;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = obj;
        this.value = value;
        Object cont = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (cont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return cont;
    }

    public <U, S> Object callRecursive(kotlin.DeepRecursiveFunction<U, S> $this$callRecursive, U value, Continuation<? super S> $completion) {
        Object crossFunctionCompletion;
        Object obj = $completion;
        int i = 0;
        final Function3 block$kotlin_stdlib = $this$callRecursive.getBlock$kotlin_stdlib();
        Intrinsics.checkNotNull(block$kotlin_stdlib, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>{ kotlin.DeepRecursiveKt.DeepRecursiveFunctionBlock }");
        Object obj2 = this;
        final int i2 = 0;
        final Function3 function = obj2.function;
        crossFunctionCompletion = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>";
        if (block$kotlin_stdlib != function) {
            obj2.function = block$kotlin_stdlib;
            Intrinsics.checkNotNull(obj, crossFunctionCompletion);
            obj2.cont = (DeepRecursiveScopeImpl)obj2.crossFunctionCompletion(function, obj);
        } else {
            Intrinsics.checkNotNull(obj, crossFunctionCompletion);
            obj2.cont = obj;
        }
        obj2.value = value;
        Object cont = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (cont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return cont;
    }

    @Override // kotlin.DeepRecursiveScope
    public CoroutineContext getContext() {
        return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.DeepRecursiveScope
    public void resumeWith(Object result) {
        this.cont = 0;
        this.result = result;
    }

    public final R runCallLoop() {
        Object result;
        Continuation cont;
        Object wrapWithContinuationImpl;
        Object cOROUTINE_SUSPENDED;
        int i;
        result = this.result;
        cont = this.cont;
        while (cont == null) {
            if (Result.equals-impl0(DeepRecursiveKt.access$getUNDEFINED_RESULT$p(), result)) {
            } else {
            }
            this.result = DeepRecursiveKt.access$getUNDEFINED_RESULT$p();
            cont.resumeWith(result);
            result = this.result;
            cont = this.cont;
            Function3 function = this.function;
            Object value = this.value;
            if (!function instanceof BaseContinuationImpl) {
            } else {
            }
            wrapWithContinuationImpl = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function, 3).invoke(this, value, cont);
            if (wrapWithContinuationImpl != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            kotlin.Result.Companion companion = Result.Companion;
            cont.resumeWith(Result.constructor-impl(wrapWithContinuationImpl));
            wrapWithContinuationImpl = IntrinsicsKt.wrapWithContinuationImpl(function, this, value, cont);
        }
        ResultKt.throwOnFailure(result);
        return result;
    }
}
