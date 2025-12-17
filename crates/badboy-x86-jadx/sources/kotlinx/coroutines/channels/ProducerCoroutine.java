package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0005\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\u0008J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0014J\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0014¢\u0006\u0002\u0010\u0013R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000b¨\u0006\u0014", d2 = {"Lkotlinx/coroutines/channels/ProducerCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ProducerScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;)V", "isActive", "", "()Z", "onCancelled", "", "cause", "", "handled", "onCompleted", "value", "(Lkotlin/Unit;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ProducerCoroutine<E>  extends kotlinx.coroutines.channels.ChannelCoroutine<E> implements kotlinx.coroutines.channels.ProducerScope<E> {
    public ProducerCoroutine(CoroutineContext parentContext, kotlinx.coroutines.channels.Channel<E> channel) {
        final int i = 1;
        super(parentContext, channel, i, i);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine
    public kotlinx.coroutines.channels.SendChannel getChannel() {
        return (SendChannel)getChannel();
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine
    protected void onCancelled(Throwable cause, boolean handled) {
        CoroutineContext context;
        if (!get_channel().close(cause) && !handled) {
            if (!handled) {
                CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), cause);
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine
    public void onCompleted(Object value) {
        onCompleted((Unit)value);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine
    protected void onCompleted(Unit value) {
        final int i = 0;
        SendChannel.DefaultImpls.close$default((SendChannel)get_channel(), i, 1, i);
    }
}
