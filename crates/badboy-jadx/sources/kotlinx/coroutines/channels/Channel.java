package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.selects.SelectClause1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u0000 \u0004*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0004¨\u0006\u0005", d2 = {"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Channel<E>  extends kotlinx.coroutines.channels.SendChannel<E>, kotlinx.coroutines.channels.ReceiveChannel<E> {

    public static final int BUFFERED = -2;
    public static final int CONFLATED = -1;
    public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";
    public static final kotlinx.coroutines.channels.Channel.Factory Factory = null;
    public static final int OPTIONAL_CHANNEL = -3;
    public static final int RENDEZVOUS = 0;
    public static final int UNLIMITED = Integer.MAX_VALUE;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static void cancel(kotlinx.coroutines.channels.Channel $this) {
            ReceiveChannel.DefaultImpls.cancel((ReceiveChannel)$this);
        }

        public static <E> SelectClause1<E> getOnReceiveOrNull(kotlinx.coroutines.channels.Channel<E> $this) {
            return ReceiveChannel.DefaultImpls.getOnReceiveOrNull((ReceiveChannel)$this);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(...))
        public static <E> boolean offer(kotlinx.coroutines.channels.Channel<E> $this, E element) {
            return SendChannel.DefaultImpls.offer((SendChannel)$this, element);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(...))
        public static <E> E poll(kotlinx.coroutines.channels.Channel<E> $this) {
            return ReceiveChannel.DefaultImpls.poll((ReceiveChannel)$this);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(...))
        public static <E> Object receiveOrNull(kotlinx.coroutines.channels.Channel<E> $this, Continuation<? super E> $completion) {
            return ReceiveChannel.DefaultImpls.receiveOrNull((ReceiveChannel)$this, $completion);
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/channels/Channel$Factory;", "", "()V", "BUFFERED", "", "CHANNEL_DEFAULT_CAPACITY", "getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core", "()I", "CONFLATED", "DEFAULT_BUFFER_PROPERTY_NAME", "", "OPTIONAL_CHANNEL", "RENDEZVOUS", "UNLIMITED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory {

        static final kotlinx.coroutines.channels.Channel.Factory $$INSTANCE = null;
        public static final int BUFFERED = -2;
        private static final int CHANNEL_DEFAULT_CAPACITY = 0;
        public static final int CONFLATED = -1;
        public static final String DEFAULT_BUFFER_PROPERTY_NAME = "kotlinx.coroutines.channels.defaultBuffer";
        public static final int OPTIONAL_CHANNEL = -3;
        public static final int RENDEZVOUS = 0;
        public static final int UNLIMITED = Integer.MAX_VALUE;
        static {
            Channel.Factory factory = new Channel.Factory();
            Channel.Factory.$$INSTANCE = factory;
            Channel.Factory.CHANNEL_DEFAULT_CAPACITY = SystemPropsKt.systemProp("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
        }

        public final int getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() {
            return Channel.Factory.CHANNEL_DEFAULT_CAPACITY;
        }
    }
    static {
        Channel.Factory = Channel.Factory.$$INSTANCE;
    }
}
