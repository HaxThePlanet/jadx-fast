package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a%\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0005\u001a,\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0008\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\t", d2 = {"sendBlocking", "", "E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)V", "trySendBlocking", "Lkotlinx/coroutines/channels/ChannelResult;", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final class ChannelsKt__ChannelsKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in the favour of 'trySendBlocking'. Consider handling the result of 'trySendBlocking' explicitly and rethrow exception if necessary", replaceWith = @ReplaceWith(...))
    public static final void sendBlocking(kotlinx.coroutines.channels.SendChannel $this$sendBlocking, Object element) {
        if (ChannelResult.isSuccess-impl($this$sendBlocking.trySend-JP2dKIU(element))) {
        }
        final int i = 0;
        ChannelsKt__ChannelsKt.sendBlocking.1 anon = new ChannelsKt__ChannelsKt.sendBlocking.1($this$sendBlocking, element, i);
        BuildersKt.runBlocking$default(i, (Function2)anon, 1, i);
    }

    public static final <E> Object trySendBlocking(kotlinx.coroutines.channels.SendChannel<? super E> $this$trySendBlocking, E element) {
        Object trySend-JP2dKIU = $this$trySendBlocking.trySend-JP2dKIU(element);
        int i = 0;
        if (!trySend-JP2dKIU instanceof ChannelResult.Failed) {
            Object obj = trySend-JP2dKIU;
            final int i4 = 0;
            return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
        }
        int i2 = 0;
        ChannelsKt__ChannelsKt.trySendBlocking.2 $this$onSuccess_u2dWpGqRn0$iv = new ChannelsKt__ChannelsKt.trySendBlocking.2($this$trySendBlocking, element, i2);
        return (ChannelResult)BuildersKt.runBlocking$default(i2, (Function2)$this$onSuccess_u2dWpGqRn0$iv, 1, i2).unbox-impl();
    }
}
