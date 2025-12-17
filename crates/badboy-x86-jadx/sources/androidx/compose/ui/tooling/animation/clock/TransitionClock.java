package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.TransitionAnimationState;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.TransitionBasedAnimation;
import androidx.compose.ui.tooling.animation.states.ComposeAnimationState;
import androidx.compose.ui.tooling.animation.states.TargetState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u00040\u0002B\u0013\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00102\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u001a\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R0\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00042\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u001f", d2 = {"Landroidx/compose/ui/tooling/animation/clock/TransitionClock;", "T", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "Landroidx/compose/ui/tooling/animation/TransitionBasedAnimation;", "Landroidx/compose/ui/tooling/animation/states/TargetState;", "animation", "(Landroidx/compose/ui/tooling/animation/TransitionBasedAnimation;)V", "getAnimation", "()Landroidx/compose/ui/tooling/animation/TransitionBasedAnimation;", "value", "state", "getState", "()Landroidx/compose/ui/tooling/animation/states/TargetState;", "setState", "(Landroidx/compose/ui/tooling/animation/states/TargetState;)V", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "setClockTime", "", "animationTimeNanos", "setStateParameters", "par1", "", "par2", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransitionClock<T>  implements androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock<TransitionBasedAnimation<T>, TargetState<T>> {

    public static final int $stable = 8;
    private final TransitionBasedAnimation<T> animation;
    private TargetState<T> state;
    static {
        final int i = 8;
    }

    public TransitionClock(TransitionBasedAnimation<T> animation) {
        super();
        this.animation = animation;
        TargetState targetState = new TargetState(getAnimation().getAnimationObject().getCurrentState(), getAnimation().getAnimationObject().getTargetState());
        this.state = targetState;
    }

    public List<ComposeAnimatedProperty> getAnimatedProperties() {
        int next3;
        Iterator iterator;
        Object next2;
        boolean next;
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
        next3 = 0;
        iterator = (Iterable)Utils_androidKt.allAnimations(getAnimation().getAnimationObject()).iterator();
        while (iterator.hasNext()) {
            label2 = 0;
            obj = contains;
            i = 0;
            value = (Transition.TransitionAnimationState)obj.getValue();
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
            next3 = iterator2.next();
            next = false;
            if (!Utils_androidKt.getIGNORE_TRANSITIONS().contains((ComposeAnimatedProperty)next3.getLabel())) {
            }
            (Collection)arrayList.add(next3);
        }
        return (List)arrayList;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public ComposeAnimation getAnimation() {
        return (ComposeAnimation)getAnimation();
    }

    public TransitionBasedAnimation<T> getAnimation() {
        return this.animation;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDuration() {
        return Utils_androidKt.nanosToMillis(getAnimation().getAnimationObject().getTotalDurationNanos());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDurationPerIteration() {
        return Utils_androidKt.nanosToMillis(getAnimation().getAnimationObject().getTotalDurationNanos());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public ComposeAnimationState getState() {
        return (ComposeAnimationState)getState();
    }

    public TargetState<T> getState() {
        return this.state;
    }

    public List<TransitionInfo> getTransitions(long stepMillis) {
        Object next;
        boolean next2;
        TransitionInfo it;
        int i;
        boolean contains;
        String label;
        List allAnimations = Utils_androidKt.allAnimations(getAnimation().getAnimationObject());
        int i3 = 0;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)allAnimations, 10));
        int i5 = 0;
        Iterator iterator = allAnimations.iterator();
        for (Object next : iterator) {
            i = 0;
            (Collection)arrayList2.add(Utils_androidKt.createTransitionInfo((Transition.TransitionAnimationState)next, stepMillis));
        }
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        Iterator iterator2 = (Iterable)(List)arrayList2.iterator();
        while (iterator2.hasNext()) {
            next2 = iterator2.next();
            i = 0;
            if (!Utils_androidKt.getIGNORE_TRANSITIONS().contains((TransitionInfo)next2.getLabel())) {
            }
            (Collection)arrayList.add(next2);
        }
        return (List)arrayList;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setClockTime(long animationTimeNanos) {
        getAnimation().getAnimationObject().seek(getState().getInitial(), getState().getTarget(), animationTimeNanos);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setState(ComposeAnimationState <set-?>) {
        setState((TargetState)<set-?>);
    }

    public void setState(TargetState<T> value) {
        this.state = value;
        setClockTime(0);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setStateParameters(Object par1, Object par2) {
        int i;
        TargetState parametersToValue = Utils_androidKt.parseParametersToValue(getState().getInitial(), par1, par2);
        if (parametersToValue != null) {
            i = 0;
            setState(parametersToValue);
        }
    }
}
