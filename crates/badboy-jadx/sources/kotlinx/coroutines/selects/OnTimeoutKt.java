package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aF\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u001c\u0010\u0006\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0007ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\n\u0082\u0002\u000b\n\u0002\u0008\u0019\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"onTimeout", "", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "timeMillis", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", "timeout", "Lkotlin/time/Duration;", "onTimeout-8Mi8wO0", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OnTimeoutKt {
    public static final <R> void onTimeout(kotlinx.coroutines.selects.SelectBuilder<? super R> $this$onTimeout, long timeMillis, Function1<? super Continuation<? super R>, ? extends Object> block) {
        OnTimeout onTimeout = new OnTimeout(timeMillis, block);
        $this$onTimeout.invoke(onTimeout.getSelectClause(), obj4);
    }

    public static final <R> void onTimeout-8Mi8wO0(kotlinx.coroutines.selects.SelectBuilder<? super R> $this$onTimeout_u2d8Mi8wO0, long timeout, Function1<? super Continuation<? super R>, ? extends Object> block) {
        OnTimeoutKt.onTimeout($this$onTimeout_u2d8Mi8wO0, DelayKt.toDelayMillis-LRDsOJo(timeout), obj1);
    }
}
