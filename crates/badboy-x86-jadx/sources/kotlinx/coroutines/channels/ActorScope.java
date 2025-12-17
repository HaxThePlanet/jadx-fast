package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.SelectClause1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008g\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003R\u0018\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lkotlinx/coroutines/channels/ActorScope;", "E", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "Lkotlinx/coroutines/channels/Channel;", "getChannel", "()Lkotlinx/coroutines/channels/Channel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ActorScope<E>  extends CoroutineScope, kotlinx.coroutines.channels.ReceiveChannel<E> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static void cancel(kotlinx.coroutines.channels.ActorScope $this) {
            ReceiveChannel.DefaultImpls.cancel((ReceiveChannel)$this);
        }

        public static <E> SelectClause1<E> getOnReceiveOrNull(kotlinx.coroutines.channels.ActorScope<E> $this) {
            return ReceiveChannel.DefaultImpls.getOnReceiveOrNull((ReceiveChannel)$this);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(...))
        public static <E> E poll(kotlinx.coroutines.channels.ActorScope<E> $this) {
            return ReceiveChannel.DefaultImpls.poll((ReceiveChannel)$this);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(...))
        public static <E> Object receiveOrNull(kotlinx.coroutines.channels.ActorScope<E> $this, Continuation<? super E> $completion) {
            return ReceiveChannel.DefaultImpls.receiveOrNull((ReceiveChannel)$this, $completion);
        }
    }
    public abstract kotlinx.coroutines.channels.Channel<E> getChannel();
}
