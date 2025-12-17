package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u00022\u000e\u0008\u0002\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u009e\u0001\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008*\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2-\u0008\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\u0008\u0001\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a¨\u0001\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008*\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2-\u0008\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\u0008\u0001\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\u0008\u001aH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001ae\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0008*\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2/\u0008\u0001\u0010\u0003\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00080\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006 ", d2 = {"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProduceKt {
    public static final Object awaitClose(kotlinx.coroutines.channels.ProducerScope<?> producerScope, Function0<Unit> function02, Continuation<? super Unit> continuation3) {
        boolean anon2;
        int i3;
        Object cOROUTINE_SUSPENDED;
        int i4;
        int label;
        int i;
        Object cOROUTINE_SUSPENDED2;
        kotlinx.coroutines.channels.ProduceKt.awaitClose.1 anon3;
        int i5;
        CancellableContinuationImpl cancellableContinuationImpl;
        int i2;
        kotlinx.coroutines.channels.ProduceKt.awaitClose.4.1 anon;
        int obj9;
        Object obj10;
        Object obj11;
        anon2 = continuation3;
        i4 = Integer.MIN_VALUE;
        if (continuation3 instanceof ProduceKt.awaitClose.1 && label2 &= i4 != 0) {
            anon2 = continuation3;
            i4 = Integer.MIN_VALUE;
            if (label2 &= i4 != 0) {
                anon2.label = obj11 -= i4;
            } else {
                anon2 = new ProduceKt.awaitClose.1(continuation3);
            }
        } else {
        }
        obj11 = anon2.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                int i6 = 1;
                i = i6;
                i = 0;
                anon2.L$0 = producerScope;
                anon2.L$1 = function02;
                anon2.label = i6;
                i5 = 0;
                cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)anon2), i6);
                cancellableContinuationImpl.initCancellability();
                i2 = 0;
                anon = new ProduceKt.awaitClose.4.1((CancellableContinuation)cancellableContinuationImpl);
                producerScope.invokeOnClose((Function1)anon);
                obj9 = cancellableContinuationImpl.getResult();
                DebugProbesKt.probeCoroutineSuspended((Continuation)anon2);
                return cOROUTINE_SUSPENDED;
                obj9 = label;
                obj9 = 0;
                obj9 = new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                throw obj9;
            case 1:
                obj9 = 0;
                obj10 = anon2.L$1;
                cOROUTINE_SUSPENDED = anon2.L$0;
                ResultKt.throwOnFailure(obj11);
                break;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        obj10.invoke();
        return Unit.INSTANCE;
    }

    public static Object awaitClose$default(kotlinx.coroutines.channels.ProducerScope producerScope, Function0 function02, Continuation continuation3, int i4, Object object5) {
        kotlinx.coroutines.channels.ProduceKt.awaitClose.2 obj1;
        if (i4 &= 1 != 0) {
            obj1 = ProduceKt.awaitClose.2.INSTANCE;
        }
        return ProduceKt.awaitClose(producerScope, obj1, continuation3);
    }

    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> produce(CoroutineScope $this$produce, CoroutineContext context, int capacity, Function2<? super kotlinx.coroutines.channels.ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return ProduceKt.produce($this$produce, context, capacity, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, 0, block);
    }

    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> produce(CoroutineScope $this$produce, CoroutineContext context, int capacity, CoroutineStart start, Function1<? super Throwable, Unit> onCompletion, Function2<? super kotlinx.coroutines.channels.ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        return ProduceKt.produce($this$produce, context, capacity, BufferOverflow.SUSPEND, start, onCompletion, block);
    }

    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> produce(CoroutineScope $this$produce, CoroutineContext context, int capacity, kotlinx.coroutines.channels.BufferOverflow onBufferOverflow, CoroutineStart start, Function1<? super Throwable, Unit> onCompletion, Function2<? super kotlinx.coroutines.channels.ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        int i = 0;
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext($this$produce, context), ChannelKt.Channel$default(capacity, onBufferOverflow, i, 4, i));
        if (onCompletion != null) {
            producerCoroutine.invokeOnCompletion(onCompletion);
        }
        producerCoroutine.start(start, producerCoroutine, block);
        return (ReceiveChannel)producerCoroutine;
    }

    public static kotlinx.coroutines.channels.ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext2, int i3, Function2 function24, int i5, Object object6) {
        EmptyCoroutineContext obj1;
        int obj2;
        if (i5 & 1 != 0) {
            obj1 = EmptyCoroutineContext.INSTANCE;
        }
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return ProduceKt.produce(coroutineScope, obj1, obj2, function24);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext2, int i3, CoroutineStart coroutineStart4, Function1 function15, Function2 function26, int i7, Object object8) {
        EmptyCoroutineContext obj1;
        int obj2;
        CoroutineStart obj3;
        int obj4;
        int obj6;
        if (i7 & 1 != 0) {
            obj1 = EmptyCoroutineContext.INSTANCE;
        }
        if (i7 & 2 != 0) {
            obj2 = 0;
        }
        if (i7 & 4 != 0) {
            obj3 = CoroutineStart.DEFAULT;
        }
        obj6 = i7 &= 8 != 0 ? obj4 : function15;
        return ProduceKt.produce(coroutineScope, obj1, obj2, obj3, obj6, function26);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext2, int i3, kotlinx.coroutines.channels.BufferOverflow bufferOverflow4, CoroutineStart coroutineStart5, Function1 function16, Function2 function27, int i8, Object object9) {
        EmptyCoroutineContext obj1;
        int obj2;
        kotlinx.coroutines.channels.BufferOverflow obj3;
        CoroutineStart obj4;
        int obj5;
        int obj7;
        if (i8 & 1 != 0) {
            obj1 = EmptyCoroutineContext.INSTANCE;
        }
        if (i8 & 2 != 0) {
            obj2 = 0;
        }
        if (i8 & 4 != 0) {
            obj3 = BufferOverflow.SUSPEND;
        }
        if (i8 & 8 != 0) {
            obj4 = CoroutineStart.DEFAULT;
        }
        obj7 = i8 &= 16 != 0 ? obj5 : function16;
        return ProduceKt.produce(coroutineScope, obj1, obj2, obj3, obj4, obj7, function27);
    }
}
