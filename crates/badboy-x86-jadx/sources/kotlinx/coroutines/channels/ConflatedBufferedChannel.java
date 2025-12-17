package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\"\u0008\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0019\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0090@ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\rH\u0010¢\u0006\u0002\u0008\u0019J&\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ.\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J&\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u0008#\u0010\u001dJ.\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u0008%\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\r8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006&", d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "isConflatedDropOldest", "", "()Z", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "element", "", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropLatest", "isSendOp", "trySendDropLatest-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "trySendImpl", "trySendImpl-Mj0NB7M", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ConflatedBufferedChannel<E>  extends kotlinx.coroutines.channels.BufferedChannel<E> {

    private final int capacity;
    private final kotlinx.coroutines.channels.BufferOverflow onBufferOverflow;
    public ConflatedBufferedChannel(int capacity, kotlinx.coroutines.channels.BufferOverflow onBufferOverflow, Function1<? super E, Unit> onUndeliveredElement) {
        int i;
        int i2;
        super(capacity, onUndeliveredElement);
        this.capacity = capacity;
        this.onBufferOverflow = onBufferOverflow;
        final int i5 = 1;
        i = this.onBufferOverflow != BufferOverflow.SUSPEND ? i5 : i2;
        if (i == 0) {
        } else {
            i2 = this.capacity >= i5 ? i5 : i2;
            if (i2 == 0) {
            } else {
            }
            int i4 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Buffered channel capacity must be at least 1, but ").append(this.capacity).append(" was specified").toString().toString());
            throw illegalArgumentException2;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("This implementation does not support suspension for senders, use ").append(Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName()).append(" instead").toString().toString());
        throw illegalArgumentException;
    }

    public ConflatedBufferedChannel(int i, kotlinx.coroutines.channels.BufferOverflow bufferOverflow2, Function1 function13, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(i, bufferOverflow2, obj3);
    }

    static <E> Object send$suspendImpl(kotlinx.coroutines.channels.ConflatedBufferedChannel<E> $this, E element, Continuation<? super Unit> $completion) {
        Object onUndeliveredElement;
        int i;
        int i2;
        Object trySendImpl-Mj0NB7M = $this.trySendImpl-Mj0NB7M(element, true);
        final int i4 = 0;
        if (trySendImpl-Mj0NB7M instanceof ChannelResult.Closed) {
            Throwable exceptionOrNull-impl = ChannelResult.exceptionOrNull-impl(trySendImpl-Mj0NB7M);
            final int i5 = 0;
            onUndeliveredElement = $this.onUndeliveredElement;
            if (onUndeliveredElement == null) {
            } else {
                i2 = 0;
                onUndeliveredElement = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(onUndeliveredElement, element, i2, 2, i2);
                if (onUndeliveredElement != null) {
                    int i6 = 0;
                    ExceptionsKt.addSuppressed((Throwable)onUndeliveredElement, $this.getSendException());
                    throw onUndeliveredElement;
                }
            }
            throw $this.getSendException();
        }
        return Unit.INSTANCE;
    }

    static <E> Object sendBroadcast$suspendImpl(kotlinx.coroutines.channels.ConflatedBufferedChannel<E> $this, E element, Continuation<? super Boolean> $completion) {
        int i = 1;
        final Object trySendImpl-Mj0NB7M = $this.trySendImpl-Mj0NB7M(element, i);
        final int i3 = 0;
        if (!trySendImpl-Mj0NB7M instanceof ChannelResult.Failed) {
            Object obj = trySendImpl-Mj0NB7M;
            final int i4 = 0;
            return Boxing.boxBoolean(i);
        }
        return Boxing.boxBoolean(false);
    }

    private final Object trySendDropLatest-Mj0NB7M(E element, boolean isSendOp) {
        boolean onUndeliveredElement;
        int i;
        int i2;
        final Object trySend-JP2dKIU = super.trySend-JP2dKIU(element);
        if (!ChannelResult.isSuccess-impl(trySend-JP2dKIU)) {
            if (ChannelResult.isClosed-impl(trySend-JP2dKIU)) {
            } else {
                onUndeliveredElement = this.onUndeliveredElement;
                if (isSendOp && onUndeliveredElement != null) {
                    onUndeliveredElement = this.onUndeliveredElement;
                    if (onUndeliveredElement != null) {
                        i2 = 0;
                        onUndeliveredElement = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(onUndeliveredElement, element, i2, 2, i2);
                        if (onUndeliveredElement != null) {
                        } else {
                        }
                        int i3 = 0;
                        throw onUndeliveredElement;
                    }
                }
            }
            return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
        }
        return trySend-JP2dKIU;
    }

    private final Object trySendDropOldest-JP2dKIU(E element) {
        int $i$f$sendImpl;
        int $i$f$sendImpl2;
        Object segment$iv;
        kotlinx.coroutines.internal.Symbol symbol;
        Object obj3;
        int i4;
        int i6;
        int i7;
        boolean z;
        long andIncrement;
        int i2;
        long l;
        Object obj;
        Object obj2;
        int i3;
        int i5;
        int i;
        int $i$f$sendImpl3;
        final Object obj4 = this;
        final kotlinx.coroutines.internal.Symbol symbol2 = bUFFERED;
        $i$f$sendImpl = 0;
        segment$iv = BufferedChannel.access$getSendSegment$FU$p().get((BufferedChannel)obj4);
        andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement((BufferedChannel)obj4);
        i6 = 0;
        l8 &= l5;
        z = BufferedChannel.access$isClosedForSend0((BufferedChannel)obj4, andIncrement);
        i2 = i7 / l6;
        i4 = (int)i11;
        while (Long.compare(l, i2) != 0) {
            obj3 = BufferedChannel.access$findSegmentSend((BufferedChannel)obj4, i2, obj13);
            segment$iv = obj3;
            i = $i$f$sendImpl;
            obj = obj3;
            i3 = i4;
            segment$iv = obj;
            $i$f$sendImpl = i;
            andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement((BufferedChannel)obj4);
            i6 = 0;
            l8 &= l5;
            z = BufferedChannel.access$isClosedForSend0((BufferedChannel)obj4, andIncrement);
            i2 = i7 / l6;
            i4 = (int)i11;
            obj3 = segment$iv;
            obj3.cleanPrev();
            i = $i$f$sendImpl;
            obj = obj3;
        }
        int i12 = 0;
        return ChannelResult.Companion.closed-JP2dKIU(obj4.getSendException());
    }

    private final Object trySendImpl-Mj0NB7M(E element, boolean isSendOp) {
        Object trySendDropLatest-Mj0NB7M;
        if (this.onBufferOverflow == BufferOverflow.DROP_LATEST) {
            trySendDropLatest-Mj0NB7M = trySendDropLatest-Mj0NB7M(element, isSendOp);
        } else {
            trySendDropLatest-Mj0NB7M = trySendDropOldest-JP2dKIU(element);
        }
        return trySendDropLatest-Mj0NB7M;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean isConflatedDropOldest() {
        int i;
        i = this.onBufferOverflow == BufferOverflow.DROP_OLDEST ? 1 : 0;
        return i;
    }

    protected void registerSelectForSend(SelectInstance<?> select, Object element) {
        int i = 0;
        final Object obj = trySend-JP2dKIU;
        int i2 = 0;
        if (!obj instanceof ChannelResult.Failed) {
            Object obj2 = obj;
            int i4 = 0;
            select.selectInRegistrationPhase(Unit.INSTANCE);
        }
        int i3 = 0;
        if (!obj instanceof ChannelResult.Closed) {
        } else {
            Throwable exceptionOrNull-impl = ChannelResult.exceptionOrNull-impl(obj);
            int i5 = 0;
            select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
        }
        IllegalStateException it = new IllegalStateException("unreachable".toString());
        throw it;
    }

    public Object send(E e, Continuation<? super Unit> continuation2) {
        return ConflatedBufferedChannel.send$suspendImpl(this, e, continuation2);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation2) {
        return ConflatedBufferedChannel.sendBroadcast$suspendImpl(this, e, continuation2);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return 0;
    }

    public Object trySend-JP2dKIU(E element) {
        return trySendImpl-Mj0NB7M(element, false);
    }
}
