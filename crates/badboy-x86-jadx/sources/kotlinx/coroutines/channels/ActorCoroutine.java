package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0012\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u0011", d2 = {"Lkotlinx/coroutines/channels/ActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ActorScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "channel", "Lkotlinx/coroutines/channels/Channel;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Z)V", "handleJobException", "exception", "", "onCancelling", "", "cause", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
class ActorCoroutine<E>  extends kotlinx.coroutines.channels.ChannelCoroutine<E> implements kotlinx.coroutines.channels.ActorScope<E> {
    public ActorCoroutine(CoroutineContext parentContext, kotlinx.coroutines.channels.Channel<E> channel, boolean active) {
        super(parentContext, channel, 0, active);
        initParentJob((Job)parentContext.get((CoroutineContext.Key)Job.Key));
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine
    protected boolean handleJobException(Throwable exception) {
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), exception);
        return 1;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine
    protected void onCancelling(Throwable cause) {
        int i2;
        Object obj;
        int i;
        boolean str;
        i2 = 0;
        obj = cause;
        i = 0;
        if (cause != null && obj instanceof CancellationException != null) {
            obj = cause;
            i = 0;
            if (obj instanceof CancellationException != null) {
                i2 = obj;
            }
            if (i2 == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                i2 = ExceptionsKt.CancellationException(stringBuilder.append(DebugStringsKt.getClassSimpleName(this)).append(" was cancelled").toString(), obj);
            }
        }
        get_channel().cancel(i2);
    }
}
