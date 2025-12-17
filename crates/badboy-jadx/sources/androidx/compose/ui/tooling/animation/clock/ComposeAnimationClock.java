package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.TransitionInfo;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0008`\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u000e\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fH&J\u0008\u0010\u0011\u001a\u00020\u0012H&J\u0008\u0010\u0013\u001a\u00020\u0012H&J\u0016\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u0010\u0016\u001a\u00020\u0012H&J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H&J\u001c\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00052\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005H&R\u0012\u0010\u0006\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0018\u0010\t\u001a\u00028\u0001X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u001dÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "T", "Landroidx/compose/animation/tooling/ComposeAnimation;", "TState", "Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;", "", "animation", "getAnimation", "()Landroidx/compose/animation/tooling/ComposeAnimation;", "state", "getState", "()Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;", "setState", "(Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;)V", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "setClockTime", "", "animationTimeNanos", "setStateParameters", "par1", "par2", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ComposeAnimationClock<T extends androidx.compose.animation.tooling.ComposeAnimation, TState extends androidx.compose.ui.tooling.animation.states.ComposeAnimationState>  {
    public static void setStateParameters$default(androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock composeAnimationClock, Object object2, Object object3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            composeAnimationClock.setStateParameters(object2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStateParameters");
        throw obj0;
    }

    public abstract List<ComposeAnimatedProperty> getAnimatedProperties();

    public abstract T getAnimation();

    public abstract long getMaxDuration();

    public abstract long getMaxDurationPerIteration();

    public abstract TState getState();

    public abstract List<TransitionInfo> getTransitions(long l);

    public abstract void setClockTime(long l);

    public abstract void setState(TState tstate);

    public abstract void setStateParameters(Object object, Object object2);
}
