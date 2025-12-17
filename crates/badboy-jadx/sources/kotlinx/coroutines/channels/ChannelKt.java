package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u001a\u001e\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0007\u001a>\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0016\u0008\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008\u001aX\u0010\n\u001a\u0002H\u000b\"\u0004\u0008\u0000\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u000c2#\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u0002H\u000b0\u0008H\u0086\u0008ø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a^\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u000c\"\u0004\u0008\u0000\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u000c2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u00020\t0\u0008H\u0086\u0008ø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\u0008\u0016\u0010\u0013\u001a^\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u000c\"\u0004\u0008\u0000\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u000c2#\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u00020\t0\u0008H\u0086\u0008ø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\u0008\u0017\u0010\u0013\u001a\\\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u000c\"\u0004\u0008\u0000\u0010\u000b*\u0008\u0012\u0004\u0012\u0002H\u000b0\u000c2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u000b¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\t0\u0008H\u0086\u0008ø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\u0008\u001a\u0010\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"Channel", "Lkotlinx/coroutines/channels/Channel;", "E", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "getOrElse", "T", "Lkotlinx/coroutines/channels/ChannelResult;", "onFailure", "", "Lkotlin/ParameterName;", "name", "exception", "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onClosed", "action", "onClosed-WpGqRn0", "onFailure-WpGqRn0", "onSuccess", "value", "onSuccess-WpGqRn0", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ChannelKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.0, binary compatibility with earlier versions")
    public static final kotlinx.coroutines.channels.Channel Channel(int capacity) {
        int i = 0;
        return ChannelKt.Channel$default(capacity, i, i, 6, i);
    }

    public static final <E> kotlinx.coroutines.channels.Channel<E> Channel(int capacity, kotlinx.coroutines.channels.BufferOverflow onBufferOverflow, Function1<? super E, Unit> onUndeliveredElement) {
        kotlinx.coroutines.channels.BufferedChannel conflatedBufferedChannel2;
        kotlinx.coroutines.channels.ConflatedBufferedChannel conflatedBufferedChannel;
        kotlinx.coroutines.channels.BufferedChannel cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core;
        kotlinx.coroutines.channels.BufferOverflow dROP_OLDEST;
        cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core = 1;
        switch (capacity) {
            case -2:
                conflatedBufferedChannel2 = new BufferedChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), onUndeliveredElement);
                conflatedBufferedChannel2 = new ConflatedBufferedChannel(cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core, onBufferOverflow, onUndeliveredElement);
                break;
            case -1:
                conflatedBufferedChannel = cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core;
                conflatedBufferedChannel2 = new ConflatedBufferedChannel(cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core, BufferOverflow.DROP_OLDEST, onUndeliveredElement);
                int i2 = 0;
                IllegalArgumentException $i$a$RequireChannelKt$Channel$1 = new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
                throw $i$a$RequireChannelKt$Channel$1;
            case 0:
                cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core = new BufferedChannel(0, onUndeliveredElement);
                conflatedBufferedChannel = new ConflatedBufferedChannel(cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core, onBufferOverflow, onUndeliveredElement);
                cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core = conflatedBufferedChannel;
                conflatedBufferedChannel2 = cHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core;
                break;
            case 2147483647:
                conflatedBufferedChannel2 = new BufferedChannel(Integer.MAX_VALUE, onUndeliveredElement);
                break;
            default:
                conflatedBufferedChannel2 = new BufferedChannel(capacity, onUndeliveredElement);
                conflatedBufferedChannel2 = new ConflatedBufferedChannel(capacity, onBufferOverflow, onUndeliveredElement);
        }
        return conflatedBufferedChannel2;
    }

    public static kotlinx.coroutines.channels.Channel Channel$default(int i, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return ChannelKt.Channel(obj0);
    }

    public static kotlinx.coroutines.channels.Channel Channel$default(int i, kotlinx.coroutines.channels.BufferOverflow bufferOverflow2, Function1 function13, int i4, Object object5) {
        int obj0;
        kotlinx.coroutines.channels.BufferOverflow obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj0 = 0;
        }
        if (i4 & 2 != 0) {
            obj1 = BufferOverflow.SUSPEND;
        }
        if (i4 &= 4 != 0) {
            obj2 = 0;
        }
        return ChannelKt.Channel(obj0, obj1, obj2);
    }

    public static final <T> T getOrElse-WpGqRn0(Object $this$getOrElse_u2dWpGqRn0, Function1<? super Throwable, ? extends T> onFailure) {
        Object invoke;
        final int i = 0;
        if ($this$getOrElse_u2dWpGqRn0 instanceof ChannelResult.Failed) {
            invoke = onFailure.invoke(ChannelResult.exceptionOrNull-impl($this$getOrElse_u2dWpGqRn0));
        } else {
            invoke = $this$getOrElse_u2dWpGqRn0;
        }
        return invoke;
    }

    public static final <T> Object onClosed-WpGqRn0(Object $this$onClosed_u2dWpGqRn0, Function1<? super Throwable, Unit> action) {
        boolean exceptionOrNull-impl;
        final int i = 0;
        if ($this$onClosed_u2dWpGqRn0 instanceof ChannelResult.Closed) {
            action.invoke(ChannelResult.exceptionOrNull-impl($this$onClosed_u2dWpGqRn0));
        }
        return $this$onClosed_u2dWpGqRn0;
    }

    public static final <T> Object onFailure-WpGqRn0(Object $this$onFailure_u2dWpGqRn0, Function1<? super Throwable, Unit> action) {
        boolean exceptionOrNull-impl;
        final int i = 0;
        if ($this$onFailure_u2dWpGqRn0 instanceof ChannelResult.Failed) {
            action.invoke(ChannelResult.exceptionOrNull-impl($this$onFailure_u2dWpGqRn0));
        }
        return $this$onFailure_u2dWpGqRn0;
    }

    public static final <T> Object onSuccess-WpGqRn0(Object $this$onSuccess_u2dWpGqRn0, Function1<? super T, Unit> action) {
        final int i = 0;
        if (!$this$onSuccess_u2dWpGqRn0 instanceof ChannelResult.Failed) {
            action.invoke($this$onSuccess_u2dWpGqRn0);
        }
        return $this$onSuccess_u2dWpGqRn0;
    }
}
