package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u00020\u0002J\u0014\u0010\u000c\u001a\u00020\u00042\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J-\u0010\u000f\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u00100\u0012H&J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0017¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u001b2\u0006\u0010\u0016\u001a\u00028\u0000H&ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0003\u0010\u0007R$\u0010\u0008\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00000\tX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"Lkotlinx/coroutines/channels/SendChannel;", "E", "", "isClosedForSend", "", "isClosedForSend$annotations", "()V", "()Z", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "cause", "", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SendChannel<E>  {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean close$default(kotlinx.coroutines.channels.SendChannel sendChannel, Throwable throwable2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                return sendChannel.close(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            throw obj0;
        }

        public static void isClosedForSend$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(...))
        public static <E> boolean offer(kotlinx.coroutines.channels.SendChannel<? super E> $this, E element) {
            final Object trySend-JP2dKIU = $this.trySend-JP2dKIU(element);
            if (ChannelResult.isSuccess-impl(trySend-JP2dKIU)) {
                return 1;
            }
            Throwable exceptionOrNull-impl = ChannelResult.exceptionOrNull-impl(trySend-JP2dKIU);
            if (exceptionOrNull-impl != null) {
            } else {
                return 0;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(exceptionOrNull-impl);
        }
    }
    public abstract boolean close(Throwable throwable);

    public abstract SelectClause2<E, kotlinx.coroutines.channels.SendChannel<E>> getOnSend();

    public abstract void invokeOnClose(Function1<? super Throwable, Unit> function1);

    public abstract boolean isClosedForSend();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(...))
    public abstract boolean offer(E e);

    public abstract Object send(E e, Continuation<? super Unit> continuation2);

    public abstract Object trySend-JP2dKIU(E e);
}
