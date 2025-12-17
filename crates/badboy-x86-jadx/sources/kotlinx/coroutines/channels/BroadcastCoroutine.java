package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0012\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u00042\u0008\u0012\u0004\u0012\u0002H\u00010\u0005B#\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0019\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00032\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J.\u0010 \u001a\u00020\u00032#\u0010!\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\u000c\u0008#\u0012\u0008\u0008$\u0012\u0004\u0008\u0008(\u001a\u0012\u0004\u0012\u00020\u00030\"H\u0096\u0001J\u0016\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\nH\u0014J\u0015\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0014¢\u0006\u0002\u0010,J\u000f\u0010-\u001a\u0008\u0012\u0004\u0012\u00028\u00000.H\u0096\u0001J\u0019\u0010/\u001a\u00020\u00032\u0006\u0010&\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u00100J'\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u0003022\u0006\u0010&\u001a\u00028\u0000H\u0096\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\u00083\u00104R\u001a\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0013R$\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000f0\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u00065", d2 = {"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "_channel", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Z)V", "get_channel", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "isActive", "()Z", "isClosedForSend", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "close", "invokeOnClose", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "offer", "element", "(Ljava/lang/Object;)Z", "onCancelled", "handled", "onCompleted", "value", "(Lkotlin/Unit;)V", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
class BroadcastCoroutine<E>  extends AbstractCoroutine<Unit> implements kotlinx.coroutines.channels.ProducerScope<E>, kotlinx.coroutines.channels.BroadcastChannel<E> {

    private final kotlinx.coroutines.channels.BroadcastChannel<E> _channel;
    public BroadcastCoroutine(CoroutineContext parentContext, kotlinx.coroutines.channels.BroadcastChannel<E> _channel, boolean active) {
        super(parentContext, 0, active);
        this._channel = _channel;
        initParentJob((Job)parentContext.get((CoroutineContext.Key)Job.Key));
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void cancel(CancellationException cause) {
        int i;
        int i2;
        int i3;
        JobCancellationException jobCancellationException;
        String str;
        Job job;
        if (cause == null) {
            i = 0;
            i3 = 0;
            jobCancellationException = new JobCancellationException(JobSupport.access$cancellationExceptionMessage((JobSupport)this), 0, (Job)(JobSupport)this);
        } else {
            jobCancellationException = cause;
        }
        cancelInternal((Throwable)jobCancellationException);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final boolean cancel(Throwable cause) {
        int i2;
        int i;
        int i3;
        JobCancellationException jobCancellationException;
        String str;
        Job job;
        if (cause == null) {
            i2 = 0;
            i3 = 0;
            jobCancellationException = new JobCancellationException(JobSupport.access$cancellationExceptionMessage((JobSupport)this), 0, (Job)(JobSupport)this);
        } else {
            jobCancellationException = cause;
        }
        cancelInternal(jobCancellationException);
        return 1;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void cancelInternal(Throwable cause) {
        int i = 0;
        CancellationException cancellationException$default = JobSupport.toCancellationException$default((JobSupport)this, cause, i, 1, i);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine((Throwable)cancellationException$default);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public boolean close(Throwable cause) {
        start();
        return this._channel.close(cause);
    }

    public kotlinx.coroutines.channels.SendChannel<E> getChannel() {
        return (SendChannel)this;
    }

    public SelectClause2<E, kotlinx.coroutines.channels.SendChannel<E>> getOnSend() {
        return this._channel.getOnSend();
    }

    protected final kotlinx.coroutines.channels.BroadcastChannel<E> get_channel() {
        return this._channel;
    }

    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        this._channel.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(...))
    public boolean offer(E e) {
        return this._channel.offer(e);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCancelled(Throwable cause, boolean handled) {
        CoroutineContext context;
        if (!this._channel.close(cause) && !handled) {
            if (!handled) {
                CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), cause);
            }
        }
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(Object value) {
        onCompleted((Unit)value);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void onCompleted(Unit value) {
        final int i = 0;
        SendChannel.DefaultImpls.close$default((SendChannel)this._channel, i, 1, i);
    }

    public kotlinx.coroutines.channels.ReceiveChannel<E> openSubscription() {
        return this._channel.openSubscription();
    }

    public Object send(E e, Continuation<? super Unit> continuation2) {
        return this._channel.send(e, continuation2);
    }

    public Object trySend-JP2dKIU(E e) {
        return this._channel.trySend-JP2dKIU(e);
    }
}
