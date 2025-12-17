package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes5.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008g\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H'J\u001a\u0010\u0003\u001a\u00020\u00072\u0010\u0008\u0002\u0010\u0005\u001a\n\u0018\u00010\u0008j\u0004\u0018\u0001`\tH&J\u000e\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bH&¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "cancel", "", "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BroadcastChannel<E>  extends kotlinx.coroutines.channels.SendChannel<E> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void cancel$default(kotlinx.coroutines.channels.BroadcastChannel broadcastChannel, CancellationException cancellationException2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                broadcastChannel.cancel(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            throw obj0;
        }

        public static boolean cancel$default(kotlinx.coroutines.channels.BroadcastChannel broadcastChannel, Throwable throwable2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                return broadcastChannel.cancel(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            throw obj0;
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(...))
        public static <E> boolean offer(kotlinx.coroutines.channels.BroadcastChannel<E> $this, E element) {
            return SendChannel.DefaultImpls.offer((SendChannel)$this, element);
        }
    }
    @Override // kotlinx.coroutines.channels.SendChannel
    public abstract void cancel(CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    public abstract boolean cancel(Throwable throwable);

    public abstract kotlinx.coroutines.channels.ReceiveChannel<E> openSubscription();
}
