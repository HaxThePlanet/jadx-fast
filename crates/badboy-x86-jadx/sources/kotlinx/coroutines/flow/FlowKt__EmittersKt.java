package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u0002H\u0000\u001as\u0010\u0003\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00022D\u0010\u0005\u001a@\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0006¢\u0006\u0002\u0008\r2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001aj\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0011\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00112D\u0010\u0005\u001a@\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0006¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aS\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0011\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00112-\u0010\u0005\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0014¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aS\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0011\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00112-\u0010\u0005\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0014¢\u0006\u0002\u0008\rø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001as\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0018*\u0008\u0012\u0004\u0012\u0002H\u00040\u00112D\u0008\u0005\u0010\u0017\u001a>\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00180\u0002\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0006¢\u0006\u0002\u0008\rH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001as\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0018*\u0008\u0012\u0004\u0012\u0002H\u00040\u00112D\u0008\u0005\u0010\u0017\u001a>\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00180\u0002\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u0006¢\u0006\u0002\u0008\rH\u0081\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"ensureActive", "", "Lkotlinx/coroutines/flow/FlowCollector;", "invokeSafely", "T", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCompletion", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "onEmpty", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "onStart", "transform", "R", "value", "unsafeTransform", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__EmittersKt {
    public static final Object access$invokeSafely$FlowKt__EmittersKt(kotlinx.coroutines.flow.FlowCollector $receiver, Function3 action, Throwable cause, Continuation $completion) {
        return FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt($receiver, action, cause, $completion);
    }

    public static final void ensureActive(kotlinx.coroutines.flow.FlowCollector<?> $this$ensureActive) {
        if ($this$ensureActive instanceof ThrowingCollector) {
        } else {
        }
        throw obj.e;
    }

    private static final <T> Object invokeSafely$FlowKt__EmittersKt(kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function32, Throwable throwable3, Continuation<? super Unit> continuation4) {
        boolean anon;
        int i;
        int i2;
        int invoke;
        Object obj3;
        Object obj6;
        anon = continuation4;
        i2 = Integer.MIN_VALUE;
        if (continuation4 instanceof FlowKt__EmittersKt.invokeSafely.1 && label &= i2 != 0) {
            anon = continuation4;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                anon.label = obj6 -= i2;
            } else {
                anon = new FlowKt__EmittersKt.invokeSafely.1(continuation4);
            }
        } else {
        }
        obj6 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (invoke) {
            case 0:
                ResultKt.throwOnFailure(obj6);
                anon.L$0 = throwable3;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj3 = throwable3;
                break;
            case 1:
                obj3 = anon.L$0;
                ResultKt.throwOnFailure(obj6);
                break;
            default:
                obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj3;
        }
        return Unit.INSTANCE;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> onCompletion(kotlinx.coroutines.flow.Flow<? extends T> $this$onCompletion, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> action) {
        final int i = 0;
        FlowKt__EmittersKt.onCompletion$$inlined.unsafeFlow.1 anon = new FlowKt__EmittersKt.onCompletion$$inlined.unsafeFlow.1($this$onCompletion, action);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> onEmpty(kotlinx.coroutines.flow.Flow<? extends T> $this$onEmpty, Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        final int i = 0;
        FlowKt__EmittersKt.onEmpty$$inlined.unsafeFlow.1 anon = new FlowKt__EmittersKt.onEmpty$$inlined.unsafeFlow.1($this$onEmpty, action);
        return (Flow)anon;
    }

    public static final <T> kotlinx.coroutines.flow.Flow<T> onStart(kotlinx.coroutines.flow.Flow<? extends T> $this$onStart, Function2<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> action) {
        final int i = 0;
        FlowKt__EmittersKt.onStart$$inlined.unsafeFlow.1 anon = new FlowKt__EmittersKt.onStart$$inlined.unsafeFlow.1(action, $this$onStart);
        return (Flow)anon;
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> transform(kotlinx.coroutines.flow.Flow<? extends T> $this$transform, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform) {
        final int i = 0;
        FlowKt__EmittersKt.transform.1 anon = new FlowKt__EmittersKt.transform.1($this$transform, transform, 0);
        return FlowKt.flow((Function2)anon);
    }

    public static final <T, R> kotlinx.coroutines.flow.Flow<R> unsafeTransform(kotlinx.coroutines.flow.Flow<? extends T> $this$unsafeTransform, Function3<? super kotlinx.coroutines.flow.FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> transform) {
        final int i = 0;
        final int i2 = 0;
        FlowKt__EmittersKt.unsafeTransform$$inlined.unsafeFlow.1 anon = new FlowKt__EmittersKt.unsafeTransform$$inlined.unsafeFlow.1($this$unsafeTransform, transform);
        return (Flow)anon;
    }
}
