package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.TransitionAnimationState;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState.Companion;
import androidx.compose.ui.tooling.animation.states.ComposeAnimationState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00102\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 *\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R,\u0010\t\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0003@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/ui/tooling/animation/clock/AnimatedVisibilityClock;", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "animation", "(Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;)V", "getAnimation", "()Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "value", "state", "getState-jXw82LU", "()Ljava/lang/String;", "setState-7IW2chM", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "setClockTime", "", "animationTimeNanos", "setStateParameters", "par1", "", "par2", "toCurrentTargetPair", "Lkotlin/Pair;", "", "toCurrentTargetPair-7IW2chM", "(Ljava/lang/String;)Lkotlin/Pair;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimatedVisibilityClock implements androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock<AnimatedVisibilityComposeAnimation, AnimatedVisibilityState> {

    public static final int $stable = 8;
    private final AnimatedVisibilityComposeAnimation animation;
    private String state;
    static {
        final int i = 8;
    }

    public AnimatedVisibilityClock(AnimatedVisibilityComposeAnimation animation) {
        String enter-jXw82LU;
        super();
        this.animation = animation;
        if ((Boolean)getAnimation().getAnimationObject().getCurrentState().booleanValue()) {
            enter-jXw82LU = AnimatedVisibilityState.Companion.getExit-jXw82LU();
        } else {
            enter-jXw82LU = AnimatedVisibilityState.Companion.getEnter-jXw82LU();
        }
        this.state = enter-jXw82LU;
    }

    private final Pair<Boolean, Boolean> toCurrentTargetPair-7IW2chM(String $this$toCurrentTargetPair_u2d7IW2chM) {
        Pair pair;
        Boolean valueOf = false;
        Boolean valueOf2 = true;
        if (AnimatedVisibilityState.equals-impl0($this$toCurrentTargetPair_u2d7IW2chM, AnimatedVisibilityState.Companion.getEnter-jXw82LU())) {
            pair = TuplesKt.to(valueOf, valueOf2);
        } else {
            pair = TuplesKt.to(valueOf2, valueOf);
        }
        return pair;
    }

    public List<ComposeAnimatedProperty> getAnimatedProperties() {
        Transition it$iv$iv;
        int i4;
        int composeAnimatedProperty;
        int next2;
        List list;
        int i;
        Iterator iterator;
        Object next;
        boolean label;
        Object obj2;
        int i3;
        Object obj;
        int i2;
        String label2;
        Transition transition;
        int i5;
        it$iv$iv = getAnimation().getChildTransition();
        if (it$iv$iv != null) {
            composeAnimatedProperty = 0;
            int i8 = 0;
            ArrayList arrayList2 = new ArrayList();
            next2 = 0;
            i = 0;
            iterator = (Iterable)Utils_androidKt.allAnimations(it$iv$iv).iterator();
            while (iterator.hasNext()) {
                i3 = 0;
                obj = obj2;
                i2 = 0;
                Object value = obj.getValue();
                if (value == null) {
                } else {
                }
                i5 = composeAnimatedProperty;
                composeAnimatedProperty = new ComposeAnimatedProperty((Transition.TransitionAnimationState)obj.getLabel(), value);
                i4 = composeAnimatedProperty;
                if (i4 != 0) {
                }
                it$iv$iv = transition;
                composeAnimatedProperty = i5;
                composeAnimatedProperty = 0;
                (Collection)arrayList2.add(i4);
                i4 = 0;
                i5 = composeAnimatedProperty;
            }
            Transition child = it$iv$iv;
            int i10 = composeAnimatedProperty;
            int i6 = 0;
            AnimatedVisibilityClock.getAnimatedProperties.lambda.8$$inlined.sortedBy.1 anon = new AnimatedVisibilityClock.getAnimatedProperties.lambda.8$$inlined.sortedBy.1();
            int i7 = 0;
            ArrayList arrayList = new ArrayList();
            int i9 = 0;
            Iterator iterator2 = (Iterable)CollectionsKt.sortedWith((Iterable)(List)arrayList2, (Comparator)anon).iterator();
            while (iterator2.hasNext()) {
                next2 = iterator2.next();
                i = 0;
                if (Utils_androidKt.getIGNORE_TRANSITIONS().contains((ComposeAnimatedProperty)next2.getLabel()) == null) {
                }
                (Collection)arrayList.add(next2);
            }
            return (List)arrayList;
        }
        return CollectionsKt.emptyList();
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public ComposeAnimation getAnimation() {
        return (ComposeAnimation)getAnimation();
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public AnimatedVisibilityComposeAnimation getAnimation() {
        return this.animation;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDuration() {
        Transition childTransition = getAnimation().getChildTransition();
        if (childTransition != null) {
            return Utils_androidKt.nanosToMillis(childTransition.getTotalDurationNanos());
        }
        return 0;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDurationPerIteration() {
        Transition childTransition = getAnimation().getChildTransition();
        if (childTransition != null) {
            return Utils_androidKt.nanosToMillis(childTransition.getTotalDurationNanos());
        }
        return 0;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public ComposeAnimationState getState() {
        return AnimatedVisibilityState.box-impl(getState-jXw82LU());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public String getState-jXw82LU() {
        return this.state;
    }

    public List<TransitionInfo> getTransitions(long stepMillis) {
        Object next;
        boolean next2;
        TransitionInfo it;
        int i;
        boolean contains;
        String label;
        Transition childTransition = getAnimation().getChildTransition();
        if (childTransition != null) {
            final int i2 = 0;
            List allAnimations = Utils_androidKt.allAnimations(childTransition);
            int i4 = 0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)allAnimations, 10));
            int i7 = 0;
            Iterator iterator = allAnimations.iterator();
            for (Object next : iterator) {
                i = 0;
                (Collection)arrayList.add(Utils_androidKt.createTransitionInfo((Transition.TransitionAnimationState)next, stepMillis));
            }
            int i3 = 0;
            AnimatedVisibilityClock.getTransitions.lambda.4$$inlined.sortedBy.1 anon = new AnimatedVisibilityClock.getTransitions.lambda.4$$inlined.sortedBy.1();
            int i5 = 0;
            ArrayList arrayList2 = new ArrayList();
            int i8 = 0;
            Iterator iterator2 = (Iterable)CollectionsKt.sortedWith((Iterable)(List)arrayList, (Comparator)anon).iterator();
            while (iterator2.hasNext()) {
                next2 = iterator2.next();
                i = 0;
                if (!Utils_androidKt.getIGNORE_TRANSITIONS().contains((TransitionInfo)next2.getLabel())) {
                }
                (Collection)arrayList2.add(next2);
            }
            return (List)arrayList2;
        }
        return CollectionsKt.emptyList();
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setClockTime(long animationTimeNanos) {
        final int i = 0;
        Pair currentTargetPair-7IW2chM = toCurrentTargetPair-7IW2chM(getState-jXw82LU());
        getAnimation().getAnimationObject().seek(Boolean.valueOf((Boolean)currentTargetPair-7IW2chM.component1().booleanValue()), Boolean.valueOf((Boolean)currentTargetPair-7IW2chM.component2().booleanValue()), animationTimeNanos);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setState(ComposeAnimationState <set-?>) {
        setState-7IW2chM((AnimatedVisibilityState)<set-?>.unbox-impl());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setState-7IW2chM(String value) {
        this.state = value;
        setClockTime(0);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setStateParameters(Object par1, Object par2) {
        Intrinsics.checkNotNull(par1, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState");
        setState-7IW2chM((AnimatedVisibilityState)par1.unbox-impl());
    }
}
