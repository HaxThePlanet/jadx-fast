package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u009c\u0001\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2-\u0008\u0002\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112-\u0010\u0012\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013¢\u0006\u0002\u0008\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0019", d2 = {"actor", "Lkotlinx/coroutines/channels/SendChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/SendChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActorKt {
    public static final <E> kotlinx.coroutines.channels.SendChannel<E> actor(CoroutineScope $this$actor, CoroutineContext context, int capacity, CoroutineStart start, Function1<? super Throwable, Unit> onCompletion, Function2<? super kotlinx.coroutines.channels.ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> block) {
        kotlinx.coroutines.channels.ActorCoroutine lazyActorCoroutine;
        int i;
        final CoroutineContext coroutineContext = CoroutineContextKt.newCoroutineContext($this$actor, context);
        int i2 = 0;
        kotlinx.coroutines.channels.Channel channel = ChannelKt.Channel$default(capacity, i2, i2, 6, i2);
        if (start.isLazy()) {
            lazyActorCoroutine = new LazyActorCoroutine(coroutineContext, channel, block);
        } else {
            lazyActorCoroutine = new ActorCoroutine(coroutineContext, channel, 1);
        }
        if (onCompletion != null) {
            lazyActorCoroutine.invokeOnCompletion(onCompletion);
        }
        lazyActorCoroutine.start(start, lazyActorCoroutine, block);
        return (SendChannel)lazyActorCoroutine;
    }

    public static kotlinx.coroutines.channels.SendChannel actor$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext2, int i3, CoroutineStart coroutineStart4, Function1 function15, Function2 function26, int i7, Object object8) {
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
        return ActorKt.actor(coroutineScope, obj1, obj2, obj3, obj6, function26);
    }
}
