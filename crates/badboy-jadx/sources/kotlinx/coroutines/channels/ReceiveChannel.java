package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008f\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0017J\u0014\u0010\u0014\u001a\u00020\u00042\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H'J\u001a\u0010\u0014\u001a\u00020\u00152\u0010\u0008\u0002\u0010\u0016\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019H&J\u000f\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bH¦\u0002J\u000f\u0010\u001c\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u001dJ\u0011\u0010\u001e\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\"\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000fH¦@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\u001fJ\u0013\u0010\"\u001a\u0004\u0018\u00018\u0000H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u001e\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000fH&ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u0008$\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0003\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\u00048&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u0006\u001a\u0004\u0008\u0008\u0010\u0007R\u0018\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR!\u0010\u000e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000f0\u000bX¦\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\rR\"\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\u0006\u001a\u0004\u0008\u0013\u0010\r\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006%", d2 = {"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isEmpty", "isEmpty$annotations", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveOrNull", "tryReceive", "tryReceive-PtdJZtk", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ReceiveChannel<E>  {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static void cancel(kotlinx.coroutines.channels.ReceiveChannel $this) {
            $this.cancel(0);
        }

        public static void cancel$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CancellationException cancellationException2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                receiveChannel.cancel(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            throw obj0;
        }

        public static boolean cancel$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Throwable throwable2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                return receiveChannel.cancel(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            throw obj0;
        }

        public static <E> SelectClause1<E> getOnReceiveOrNull(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this) {
            Intrinsics.checkNotNull($this, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel<E of kotlinx.coroutines.channels.ReceiveChannel>");
            return (BufferedChannel)$this.getOnReceiveOrNull();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of onReceiveCatching extension", replaceWith = @ReplaceWith(...))
        public static void getOnReceiveOrNull$annotations() {
        }

        public static void isClosedForReceive$annotations() {
        }

        public static void isEmpty$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(...))
        public static <E> E poll(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this) {
            final Object tryReceive-PtdJZtk = $this.tryReceive-PtdJZtk();
            if (ChannelResult.isSuccess-impl(tryReceive-PtdJZtk)) {
                return ChannelResult.getOrThrow-impl(tryReceive-PtdJZtk);
            }
            Throwable exceptionOrNull-impl = ChannelResult.exceptionOrNull-impl(tryReceive-PtdJZtk);
            if (exceptionOrNull-impl != null) {
            } else {
                return 0;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(exceptionOrNull-impl);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(...))
        public static <E> Object receiveOrNull(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation2) {
            boolean anon;
            int i2;
            int i;
            int label;
            Object obj3;
            Object obj4;
            anon = continuation2;
            i = Integer.MIN_VALUE;
            if (continuation2 instanceof ReceiveChannel.receiveOrNull.1 && label2 &= i != 0) {
                anon = continuation2;
                i = Integer.MIN_VALUE;
                if (label2 &= i != 0) {
                    anon.label = obj4 -= i;
                } else {
                    anon = new ReceiveChannel.receiveOrNull.1(continuation2);
                }
            } else {
            }
            obj4 = anon.result;
            Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (label) {
                case 0:
                    ResultKt.throwOnFailure(obj4);
                    anon.label = 1;
                    return cOROUTINE_SUSPENDED;
                case 1:
                    ResultKt.throwOnFailure(obj4);
                    obj3 = (ChannelResult)obj4.unbox-impl();
                    break;
                default:
                    obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj3;
            }
            return ChannelResult.getOrNull-impl(obj3);
        }
    }
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public abstract void cancel();

    public abstract void cancel(CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public abstract boolean cancel(Throwable throwable);

    public abstract SelectClause1<E> getOnReceive();

    public abstract SelectClause1<kotlinx.coroutines.channels.ChannelResult<E>> getOnReceiveCatching();

    public abstract SelectClause1<E> getOnReceiveOrNull();

    public abstract boolean isClosedForReceive();

    public abstract boolean isEmpty();

    public abstract kotlinx.coroutines.channels.ChannelIterator<E> iterator();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(...))
    public abstract E poll();

    public abstract Object receive(Continuation<? super E> continuation);

    public abstract Object receiveCatching-JP2dKIU(Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> continuation);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(...))
    public abstract Object receiveOrNull(Continuation<? super E> continuation);

    public abstract Object tryReceive-PtdJZtk();
}
