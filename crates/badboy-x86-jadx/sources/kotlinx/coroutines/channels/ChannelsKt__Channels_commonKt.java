package kotlinx.coroutines.channels;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.selects.SelectClause1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\u0008\u00030\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0001\u001aC\u0010\u0007\u001a\u0002H\u0008\"\u0004\u0008\u0000\u0010\t\"\u0004\u0008\u0001\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\t0\n2\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\u00080\u000c¢\u0006\u0002\u0008\rH\u0087\u0008¢\u0006\u0002\u0010\u000e\u001aP\u0010\u0007\u001a\u0002H\u0008\"\u0004\u0008\u0000\u0010\t\"\u0004\u0008\u0001\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\t0\u00042\u001d\u0010\u000b\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\t0\u0004\u0012\u0004\u0012\u0002H\u00080\u000c¢\u0006\u0002\u0008\rH\u0086\u0008\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\t*\u0008\u0012\u0004\u0012\u0002H\t0\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\u000cH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a5\u0010\u0010\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\t*\u0008\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00030\u000cH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a$\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\t0\u0015\"\u0008\u0008\u0000\u0010\t*\u00020\u0016*\u0008\u0012\u0004\u0012\u0002H\t0\u0004H\u0007\u001a'\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\u0008\u0008\u0000\u0010\t*\u00020\u0016*\u0008\u0012\u0004\u0012\u0002H\t0\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a'\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u001a\"\u0004\u0008\u0000\u0010\t*\u0008\u0012\u0004\u0012\u0002H\t0\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"DEFAULT_CLOSE_MESSAGE", "", "cancelConsumed", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "cause", "", "consume", "R", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "", "receiveOrNull", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final class ChannelsKt__Channels_commonKt {
    public static final void cancelConsumed(kotlinx.coroutines.channels.ReceiveChannel<?> $this$cancelConsumed, Throwable cause) {
        int i;
        Object obj;
        int i2;
        boolean z;
        i = 0;
        obj = cause;
        i2 = 0;
        if (cause != null && obj instanceof CancellationException != null) {
            obj = cause;
            i2 = 0;
            if (obj instanceof CancellationException != null) {
                i = obj;
            }
            if (i == 0) {
                i = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", obj);
            }
        }
        $this$cancelConsumed.cancel(i);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E, R> R consume(kotlinx.coroutines.channels.BroadcastChannel<E> $this$consume, Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> block) {
        final int i = 0;
        final kotlinx.coroutines.channels.ReceiveChannel subscription = $this$consume.openSubscription();
        final int i3 = 0;
        ReceiveChannel.DefaultImpls.cancel$default(subscription, i3, 1, i3);
        return block.invoke(subscription);
    }

    public static final <E, R> R consume(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$consume, Function1<? super kotlinx.coroutines.channels.ReceiveChannel<? extends E>, ? extends R> block) {
        final int i = 0;
        ChannelsKt.cancelConsumed($this$consume, 0);
        return block.invoke($this$consume);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object consumeEach(kotlinx.coroutines.channels.BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function12, Continuation<? super Unit> continuation3) {
        boolean $result;
        Object $continuation2;
        Throwable $continuation;
        Object $continuation4;
        kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach.3 anon2;
        int i;
        int $i$f$consumeEach;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$42;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$4;
        int i2;
        Throwable th;
        Object subscription;
        Object channel$iv;
        Object channel$iv2;
        Object action;
        Object iterator;
        kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach.3 anon;
        int obj10;
        int obj11;
        Object obj12;
        $result = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__Channels_commonKt.consumeEach.3 && label &= i != 0) {
            $result = continuation3;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                $result.label = obj12 -= i;
            } else {
                $result = new ChannelsKt__Channels_commonKt.consumeEach.3(continuation3);
            }
        } else {
        }
        obj12 = $result.result;
        final int i5 = 1;
        final int i6 = 0;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                obj10 = i4;
                $i$f$consumeEach = i8;
                channel$iv2 = function12;
                obj11 = i7;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$4 = iterator;
                break;
            case 1:
                obj10 = 0;
                obj11 = 0;
                ResultKt.throwOnFailure(obj12);
                iterator = l$0;
                action = l$1;
                channel$iv = l$2;
                i2 = i3;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$42 = $continuation4;
                anon2 = $result;
                $continuation2 = obj12;
                iterator.invoke(channel$iv.next());
                obj12 = $continuation2;
                $result = anon2;
                $continuation4 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$42;
                $i$f$consumeEach = i2;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$4 = channel$iv;
                subscription = action;
                channel$iv2 = iterator;
                obj12 = Unit.INSTANCE;
                ReceiveChannel.DefaultImpls.cancel$default(action, i6, i5, i6);
                return Unit.INSTANCE;
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        $result.L$0 = channel$iv2;
        $result.L$1 = subscription;
        $result.L$2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$4;
        $result.label = i5;
        Object next = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$4.hasNext($result);
        if (next == $continuation4) {
            return $continuation4;
        } else {
            $continuation2 = obj12;
            obj12 = next;
            iterator = channel$iv2;
            action = subscription;
            channel$iv = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$4;
            i2 = $i$f$consumeEach;
            $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$42 = $continuation4;
            anon2 = anon;
        }
    }

    public static final <E> Object consumeEach(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function12, Continuation<? super Unit> continuation3) {
        boolean $result;
        Object $continuation;
        Throwable e$iv;
        Object $continuation3;
        kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach.1 anon2;
        int $i$f$consumeEach;
        int $i$f$consumeEach2;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$22;
        int i2;
        Throwable th;
        int i;
        Object cause$iv3;
        Throwable cause$iv2;
        Object cause$iv;
        int $this$consume$iv;
        Object $this$consume$iv2;
        Object action;
        Object iterator;
        kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.consumeEach.1 anon;
        int obj9;
        int obj10;
        Object obj11;
        $result = continuation3;
        $i$f$consumeEach = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__Channels_commonKt.consumeEach.1 && label &= $i$f$consumeEach != 0) {
            $result = continuation3;
            $i$f$consumeEach = Integer.MIN_VALUE;
            if (label &= $i$f$consumeEach != 0) {
                $result.label = obj11 -= $i$f$consumeEach;
            } else {
                $result = new ChannelsKt__Channels_commonKt.consumeEach.1(continuation3);
            }
        } else {
        }
        obj11 = $result.result;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                i = 0;
                obj10 = obj9;
                obj9 = i4;
                $i$f$consumeEach2 = i6;
                $this$consume$iv2 = $this$consumeEach_u24lambda_u241;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$22 = iterator;
                break;
            case 1:
                obj9 = 0;
                obj10 = 0;
                ResultKt.throwOnFailure(obj11);
                iterator = l$0;
                action = l$1;
                $this$consume$iv = i5;
                cause$iv3 = l$2;
                i2 = i3;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2 = $continuation3;
                anon2 = $result;
                $continuation = obj11;
                iterator.invoke(cause$iv3.next());
                obj11 = $continuation;
                $result = anon2;
                $continuation3 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2;
                $i$f$consumeEach2 = i2;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$22 = cause$iv3;
                i = $this$consume$iv;
                cause$iv = action;
                $this$consume$iv2 = iterator;
                obj11 = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(action, $this$consume$iv);
                return Unit.INSTANCE;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        $result.L$0 = $this$consume$iv2;
        $result.L$1 = cause$iv;
        $result.L$2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$22;
        $result.label = 1;
        Object next = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$22.hasNext($result);
        if (next == $continuation3) {
            return $continuation3;
        } else {
            $continuation = obj11;
            obj11 = next;
            iterator = $this$consume$iv2;
            action = cause$iv;
            $this$consume$iv = i;
            cause$iv3 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$22;
            i2 = $i$f$consumeEach2;
            $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2 = $continuation3;
            anon2 = anon;
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    private static final <E> Object consumeEach$$forInline(kotlinx.coroutines.channels.BroadcastChannel<E> $this$consumeEach, Function1<? super E, Unit> action, Continuation<? super Unit> $completion) {
        Object next;
        final int i = 0;
        final int i2 = 0;
        final kotlinx.coroutines.channels.ReceiveChannel subscription = $this$consumeEach.openSubscription();
        final int i4 = 0;
        final int i5 = 0;
        final kotlinx.coroutines.channels.ChannelIterator iterator = (ReceiveChannel)subscription.iterator();
        while ((Boolean)iterator.hasNext(i4).booleanValue()) {
            action.invoke(iterator.next());
        }
        Unit $this$consumeEach_u24lambda_u244 = Unit.INSTANCE;
        ReceiveChannel.DefaultImpls.cancel$default(subscription, i4, 1, i4);
        return Unit.INSTANCE;
    }

    private static final <E> Object consumeEach$$forInline(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$consumeEach, Function1<? super E, Unit> action, Continuation<? super Unit> $completion) {
        Object next;
        final int i = 0;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel = $this$consumeEach;
        final int i2 = 0;
        final int i4 = 0;
        final kotlinx.coroutines.channels.ChannelIterator iterator = (ReceiveChannel)receiveChannel.iterator();
        while ((Boolean)iterator.hasNext(0).booleanValue()) {
            action.invoke(iterator.next());
        }
        Unit $this$consumeEach_u24lambda_u241 = Unit.INSTANCE;
        ChannelsKt.cancelConsumed(receiveChannel, 0);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'onReceiveCatching'")
    public static final SelectClause1 onReceiveOrNull(kotlinx.coroutines.channels.ReceiveChannel $this$onReceiveOrNull) {
        Intrinsics.checkNotNull($this$onReceiveOrNull, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return $this$onReceiveOrNull.getOnReceiveOrNull();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'receiveCatching'", replaceWith = @ReplaceWith(...))
    public static final Object receiveOrNull(kotlinx.coroutines.channels.ReceiveChannel $this$receiveOrNull, Continuation $completion) {
        Intrinsics.checkNotNull($this$receiveOrNull, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return $this$receiveOrNull.receiveOrNull($completion);
    }

    public static final <E> Object toList(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation2) {
        boolean $result;
        Object $continuation3;
        Throwable e$iv$iv;
        Object $continuation2;
        kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.toList.1 list2;
        Throwable th2;
        int i2;
        Object $i$f$consumeEach2;
        Throwable th;
        int $i$f$consumeEach;
        int $i$f$consume2;
        int $i$f$consume;
        int $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        int i;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        int i4;
        Object cause$iv$iv3;
        kotlinx.coroutines.channels.ReceiveChannel cause$iv$iv2;
        Object cause$iv$iv;
        int $this$consume$iv$iv2;
        Object $this$consume$iv$iv;
        Object $this$toList_u24lambda_u243;
        Object $this$toList_u24lambda_u2432;
        Object obj2;
        Object iterator;
        Object obj;
        int i3;
        kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.toList.1 list;
        int obj14;
        Object obj15;
        $result = continuation2;
        th2 = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__Channels_commonKt.toList.1 && label &= th2 != 0) {
            $result = continuation2;
            th2 = Integer.MIN_VALUE;
            if (label &= th2 != 0) {
                $result.label = obj15 -= th2;
            } else {
                $result = new ChannelsKt__Channels_commonKt.toList.1(continuation2);
            }
        } else {
        }
        obj15 = $result.result;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                List listBuilder = CollectionsKt.createListBuilder();
                i4 = 0;
                $this$consume$iv$iv = list3;
                $i$f$consumeEach = obj14;
                obj14 = i8;
                $i$f$consume = i11;
                $this$toList_u24lambda_u2432 = listBuilder;
                i2 = i9;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = iterator;
                break;
            case 1:
                obj14 = 0;
                ResultKt.throwOnFailure(obj15);
                iterator = l$0;
                obj2 = l$1;
                $this$toList_u24lambda_u243 = l$2;
                $this$consume$iv$iv2 = i10;
                cause$iv$iv3 = l$3;
                i = i7;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = i6;
                $i$f$consume2 = i5;
                $i$f$consumeEach2 = $continuation2;
                list2 = $result;
                $continuation3 = obj15;
                i3 = 0;
                obj2.add(cause$iv$iv3.next());
                obj15 = $continuation3;
                $result = list2;
                $continuation2 = $i$f$consumeEach2;
                i2 = $i$f$consume2;
                $i$f$consumeEach = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
                $i$f$consume = i;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = cause$iv$iv3;
                i4 = $this$consume$iv$iv2;
                cause$iv$iv = $this$toList_u24lambda_u243;
                $this$consume$iv$iv = obj2;
                $this$toList_u24lambda_u2432 = iterator;
                obj15 = Unit.INSTANCE;
                ChannelsKt.cancelConsumed($this$toList_u24lambda_u243, $this$consume$iv$iv2);
                return CollectionsKt.build(iterator);
            default:
                obj14 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj14;
        }
        $result.L$0 = $this$toList_u24lambda_u2432;
        $result.L$1 = $this$consume$iv$iv;
        $result.L$2 = cause$iv$iv;
        $result.L$3 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        $result.label = 1;
        Object next = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2.hasNext($result);
        if (next == $continuation2) {
            return $continuation2;
        } else {
            $continuation3 = obj15;
            obj15 = next;
            iterator = $this$toList_u24lambda_u2432;
            obj2 = $this$consume$iv$iv;
            $this$toList_u24lambda_u243 = cause$iv$iv;
            $this$consume$iv$iv2 = i4;
            cause$iv$iv3 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
            i = $i$f$consume;
            $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = $i$f$consumeEach;
            $i$f$consume2 = i2;
            $i$f$consumeEach2 = $continuation2;
            list2 = list;
        }
    }
}
