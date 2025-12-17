package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0015R \u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "motionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/ui/MotionDurationScale;)V", "getFlingDecay", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "setFlingDecay", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "lastAnimationCycleCount", "", "getLastAnimationCycleCount", "()I", "setLastAnimationCycleCount", "(I)V", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultFlingBehavior implements androidx.compose.foundation.gestures.FlingBehavior {

    public static final int $stable;
    private DecayAnimationSpec<Float> flingDecay;
    private int lastAnimationCycleCount;
    private final MotionDurationScale motionDurationScale;
    static {
    }

    public DefaultFlingBehavior(DecayAnimationSpec<Float> flingDecay, MotionDurationScale motionDurationScale) {
        super();
        this.flingDecay = flingDecay;
        this.motionDurationScale = motionDurationScale;
    }

    public DefaultFlingBehavior(DecayAnimationSpec decayAnimationSpec, MotionDurationScale motionDurationScale2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        MotionDurationScale obj2;
        if (i3 &= 2 != 0) {
            obj2 = ScrollableKt.getDefaultScrollMotionDurationScale();
        }
        super(decayAnimationSpec, obj2);
    }

    public final DecayAnimationSpec<Float> getFlingDecay() {
        return this.flingDecay;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final int getLastAnimationCycleCount() {
        return this.lastAnimationCycleCount;
    }

    public Object performFling(androidx.compose.foundation.gestures.ScrollScope $this$performFling, float initialVelocity, Continuation<? super Float> $completion) {
        this.lastAnimationCycleCount = 0;
        DefaultFlingBehavior.performFling.2 anon = new DefaultFlingBehavior.performFling.2(initialVelocity, this, $this$performFling, 0);
        return BuildersKt.withContext((CoroutineContext)this.motionDurationScale, (Function2)anon, $completion);
    }

    public final void setFlingDecay(DecayAnimationSpec<Float> <set-?>) {
        this.flingDecay = <set-?>;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public final void setLastAnimationCycleCount(int <set-?>) {
        this.lastAnimationCycleCount = <set-?>;
    }
}
