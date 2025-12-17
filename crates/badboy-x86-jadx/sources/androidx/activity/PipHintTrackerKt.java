package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"trackPipAnimationHintView", "", "Landroid/app/Activity;", "view", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PipHintTrackerKt {
    public static final Rect access$trackPipAnimationHintView$positionInWindow(View $receiver) {
        return PipHintTrackerKt.trackPipAnimationHintView$positionInWindow($receiver);
    }

    public static final Object trackPipAnimationHintView(Activity $this$trackPipAnimationHintView, View view, Continuation<? super Unit> $completion) {
        PipHintTrackerKt.trackPipAnimationHintView.flow.1 anon = new PipHintTrackerKt.trackPipAnimationHintView.flow.1(view, 0);
        PipHintTrackerKt.trackPipAnimationHintView.2 anon2 = new PipHintTrackerKt.trackPipAnimationHintView.2($this$trackPipAnimationHintView);
        Object collect = FlowKt.callbackFlow((Function2)anon).collect((FlowCollector)anon2, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    private static final Rect trackPipAnimationHintView$positionInWindow(View $this$trackPipAnimationHintView_u24positionInWindow) {
        Rect rect = new Rect();
        $this$trackPipAnimationHintView_u24positionInWindow.getGlobalVisibleRect(rect);
        return rect;
    }
}
