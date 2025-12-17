package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.DurationBasedAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.InfiniteTransitionComposeAnimation;
import androidx.compose.ui.tooling.animation.states.ComposeAnimationState;
import androidx.compose.ui.tooling.animation.states.TargetState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0008\u0010\u0014\u001a\u00020\u0008H\u0016J\u0008\u0010\u0015\u001a\u00020\u0008H\u0016J\u0016\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00122\u0006\u0010\u0018\u001a\u00020\u0008H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0008H\u0016J\u001a\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J,\u0010\u001f\u001a\u00020\u0008\"\u0004\u0008\u0000\u0010 \"\u0008\u0008\u0001\u0010!*\u00020\"*\u0012\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H!0#R\u00020$H\u0002R\u0014\u0010\u0005\u001a\u00020\u0002X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010¨\u0006%", d2 = {"Landroidx/compose/ui/tooling/animation/clock/InfiniteTransitionClock;", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation;", "Landroidx/compose/ui/tooling/animation/states/TargetState;", "", "animation", "maxDuration", "Lkotlin/Function0;", "", "(Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation;Lkotlin/jvm/functions/Function0;)V", "getAnimation", "()Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation;", "state", "getState", "()Landroidx/compose/ui/tooling/animation/states/TargetState;", "setState", "(Landroidx/compose/ui/tooling/animation/states/TargetState;)V", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getMaxDuration", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "setClockTime", "", "animationTimeNanos", "setStateParameters", "par1", "par2", "getIterationDuration", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "Landroidx/compose/animation/core/InfiniteTransition;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InfiniteTransitionClock implements androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock<InfiniteTransitionComposeAnimation, TargetState<Object>> {

    public static final int $stable = 8;
    private final InfiniteTransitionComposeAnimation animation;
    private final Function0<Long> maxDuration;
    private TargetState<Object> state;
    static {
        final int i = 8;
    }

    public InfiniteTransitionClock(InfiniteTransitionComposeAnimation animation, Function0<Long> maxDuration) {
        super();
        this.animation = animation;
        this.maxDuration = maxDuration;
        Integer valueOf = 0;
        TargetState targetState = new TargetState(valueOf, valueOf);
        this.state = targetState;
    }

    public InfiniteTransitionClock(InfiniteTransitionComposeAnimation infiniteTransitionComposeAnimation, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock.1 obj2;
        if (i3 &= 2 != 0) {
            obj2 = InfiniteTransitionClock.1.INSTANCE;
        }
        super(infiniteTransitionComposeAnimation, obj2);
    }

    private final <T, V extends androidx.compose.animation.core.AnimationVector> long getIterationDuration(InfiniteTransition.TransitionAnimationState<T, V> $this$getIterationDuration) {
        int i;
        final androidx.compose.animation.core.AnimationSpec animationSpec = $this$getIterationDuration.getAnimationSpec();
        Intrinsics.checkNotNull(animationSpec, "null cannot be cast to non-null type androidx.compose.animation.core.InfiniteRepeatableSpec<T of androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock.getIterationDuration>");
        i = (InfiniteRepeatableSpec)animationSpec.getRepeatMode() == RepeatMode.Reverse ? 2 : 1;
        VectorizedDurationBasedAnimationSpec vectorize = animationSpec.getAnimation().vectorize($this$getIterationDuration.getTypeConverter());
        return Utils_androidKt.millisToNanos(l += l2);
    }

    public List<ComposeAnimatedProperty> getAnimatedProperties() {
        int next2;
        Iterator iterator;
        Object next;
        boolean next3;
        Object contains;
        int label2;
        Object obj;
        int i;
        Object value;
        int composeAnimatedProperty;
        String label;
        int i3 = 0;
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        next2 = 0;
        iterator = (Iterable)getAnimation().getAnimationObject().getAnimations().iterator();
        while (iterator.hasNext()) {
            label2 = 0;
            obj = contains;
            i = 0;
            value = (InfiniteTransition.TransitionAnimationState)obj.getValue();
            if (value == null) {
            } else {
            }
            composeAnimatedProperty = new ComposeAnimatedProperty(obj.getLabel(), value);
            if (composeAnimatedProperty != 0) {
            }
            obj = 0;
            (Collection)arrayList2.add(composeAnimatedProperty);
            composeAnimatedProperty = 0;
        }
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        Iterator iterator2 = (Iterable)(List)arrayList2.iterator();
        while (iterator2.hasNext()) {
            next2 = iterator2.next();
            next3 = false;
            if (!Utils_androidKt.getIGNORE_TRANSITIONS().contains((ComposeAnimatedProperty)next2.getLabel())) {
            }
            (Collection)arrayList.add(next2);
        }
        return (List)arrayList;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public ComposeAnimation getAnimation() {
        return (ComposeAnimation)getAnimation();
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public InfiniteTransitionComposeAnimation getAnimation() {
        return this.animation;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDuration() {
        return Math.max(getMaxDurationPerIteration(), obj1);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDurationPerIteration() {
        Long num;
        int longValue;
        Long valueOf;
        boolean next;
        int valueOf2;
        int compareTo;
        Iterator iterator = (Iterable)getAnimation().getAnimationObject().getAnimations().iterator();
        if (!iterator.hasNext()) {
            num = 0;
        } else {
            valueOf = Long.valueOf(getIterationDuration((InfiniteTransition.TransitionAnimationState)iterator.next()));
            while (iterator.hasNext()) {
                valueOf2 = Long.valueOf(getIterationDuration((InfiniteTransition.TransitionAnimationState)iterator.next()));
                if (valueOf.compareTo((Comparable)valueOf2) < 0) {
                }
                valueOf = valueOf2;
            }
            num = valueOf;
        }
        if ((Long)num != null) {
            longValue = (Long)num.longValue();
        } else {
            longValue = 0;
        }
        return Utils_androidKt.nanosToMillis(longValue);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public ComposeAnimationState getState() {
        return (ComposeAnimationState)getState();
    }

    public TargetState<Object> getState() {
        return this.state;
    }

    public List<TransitionInfo> getTransitions(long stepMillis) {
        Object next2;
        boolean next;
        TransitionInfo it;
        int i;
        long maxDuration;
        String label;
        List animations = getAnimation().getAnimationObject().getAnimations();
        int i3 = 0;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)animations, 10));
        int i5 = 0;
        Iterator iterator = animations.iterator();
        for (Object next2 : iterator) {
            i = 0;
            (Collection)arrayList2.add(Utils_androidKt.createTransitionInfo((InfiniteTransition.TransitionAnimationState)next2, stepMillis, obj14));
        }
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        Iterator iterator2 = (Iterable)(List)arrayList2.iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            i = 0;
            if (!Utils_androidKt.getIGNORE_TRANSITIONS().contains((TransitionInfo)next.getLabel())) {
            }
            (Collection)arrayList.add(next);
        }
        return CollectionsKt.toList((Iterable)(List)arrayList);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setClockTime(long animationTimeNanos) {
        getAnimation().setTimeNanos(animationTimeNanos);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setState(ComposeAnimationState <set-?>) {
        setState((TargetState)<set-?>);
    }

    public void setState(TargetState<Object> <set-?>) {
        this.state = <set-?>;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setStateParameters(Object par1, Object par2) {
    }
}
