package androidx.compose.ui.platform;

import androidx.compose.runtime.MonotonicFrameClockKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a7\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u0002H\u00010\u0003H\u0080@¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"withInfiniteAnimationFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InfiniteAnimationPolicyKt {
    public static final <R> Object withInfiniteAnimationFrameNanos(Function1<? super Long, ? extends R> onFrame, Continuation<? super R> $completion) {
        Object onInfiniteOperation;
        int i;
        kotlin.coroutines.CoroutineContext.Element context2 = $completion.getContext().get((CoroutineContext.Key)InfiniteAnimationPolicy.Key);
        if ((InfiniteAnimationPolicy)context2 == null) {
            onInfiniteOperation = MonotonicFrameClockKt.withFrameNanos(onFrame, $completion);
        } else {
            InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos.2 anon = new InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos.2(onFrame, 0);
            onInfiniteOperation = (InfiniteAnimationPolicy)context2.onInfiniteOperation((Function1)anon, $completion);
        }
        return onInfiniteOperation;
    }
}
