package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u009e\u0001\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2-\u0008\u0002\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112/\u0008\u0001\u0010\u0012\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013¢\u0006\u0002\u0008\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a2\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00192\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tH\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001a", d2 = {"broadcast", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BroadcastKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> kotlinx.coroutines.channels.BroadcastChannel<E> broadcast(CoroutineScope $this$broadcast, CoroutineContext context, int capacity, CoroutineStart start, Function1<? super Throwable, Unit> onCompletion, Function2<? super kotlinx.coroutines.channels.ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        kotlinx.coroutines.channels.BroadcastCoroutine lazyBroadcastCoroutine;
        int i;
        final CoroutineContext coroutineContext = CoroutineContextKt.newCoroutineContext($this$broadcast, context);
        final kotlinx.coroutines.channels.BroadcastChannel broadcastChannel = BroadcastChannelKt.BroadcastChannel(capacity);
        if (start.isLazy()) {
            lazyBroadcastCoroutine = new LazyBroadcastCoroutine(coroutineContext, broadcastChannel, block);
        } else {
            lazyBroadcastCoroutine = new BroadcastCoroutine(coroutineContext, broadcastChannel, 1);
        }
        if (onCompletion != null) {
            lazyBroadcastCoroutine.invokeOnCompletion(onCompletion);
        }
        lazyBroadcastCoroutine.start(start, lazyBroadcastCoroutine, block);
        return (BroadcastChannel)lazyBroadcastCoroutine;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> kotlinx.coroutines.channels.BroadcastChannel<E> broadcast(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$broadcast, int capacity, CoroutineStart start) {
        int i = 0;
        BroadcastKt.broadcast$$inlined.CoroutineExceptionHandler.1 anon3 = new BroadcastKt.broadcast$$inlined.CoroutineExceptionHandler.1(CoroutineExceptionHandler.Key);
        BroadcastKt.broadcast.1 anon = new BroadcastKt.broadcast.1($this$broadcast);
        BroadcastKt.broadcast.2 anon2 = new BroadcastKt.broadcast.2($this$broadcast, 0);
        return BroadcastKt.broadcast$default(CoroutineScopeKt.plus(CoroutineScopeKt.plus((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)Dispatchers.getUnconfined()), (CoroutineContext)(CoroutineExceptionHandler)anon3), 0, capacity, start, (Function1)anon, (Function2)anon2, 1, 0);
    }

    public static kotlinx.coroutines.channels.BroadcastChannel broadcast$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext2, int i3, CoroutineStart coroutineStart4, Function1 function15, Function2 function26, int i7, Object object8) {
        EmptyCoroutineContext obj1;
        int obj2;
        CoroutineStart obj3;
        int obj4;
        int obj6;
        if (i7 & 1 != 0) {
            obj1 = EmptyCoroutineContext.INSTANCE;
        }
        if (i7 & 2 != 0) {
            obj2 = 1;
        }
        if (i7 & 4 != 0) {
            obj3 = CoroutineStart.LAZY;
        }
        obj6 = i7 &= 8 != 0 ? obj4 : function15;
        return BroadcastKt.broadcast(coroutineScope, obj1, obj2, obj3, obj6, function26);
    }

    public static kotlinx.coroutines.channels.BroadcastChannel broadcast$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i2, CoroutineStart coroutineStart3, int i4, Object object5) {
        int obj1;
        CoroutineStart obj2;
        if (i4 & 1 != 0) {
            obj1 = 1;
        }
        if (i4 &= 2 != 0) {
            obj2 = CoroutineStart.LAZY;
        }
        return BroadcastKt.broadcast(receiveChannel, obj1, obj2);
    }
}
