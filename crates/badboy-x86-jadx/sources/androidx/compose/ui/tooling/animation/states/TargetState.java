package androidx.compose.ui.tooling.animation.states;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u000e\u0010\n\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00028\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\t\u0010\u0007¨\u0006\u0016", d2 = {"Landroidx/compose/ui/tooling/animation/states/TargetState;", "T", "Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;", "initial", "target", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getInitial", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTarget", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/ui/tooling/animation/states/TargetState;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TargetState<T>  implements androidx.compose.ui.tooling.animation.states.ComposeAnimationState {

    public static final int $stable;
    private final T initial;
    private final T target;
    static {
    }

    public TargetState(T initial, T target) {
        super();
        this.initial = initial;
        this.target = target;
    }

    public static androidx.compose.ui.tooling.animation.states.TargetState copy$default(androidx.compose.ui.tooling.animation.states.TargetState targetState, Object object2, Object object3, int i4, Object object5) {
        Object obj1;
        Object obj2;
        if (i4 & 1 != 0) {
            obj1 = targetState.initial;
        }
        if (i4 &= 2 != 0) {
            obj2 = targetState.target;
        }
        return targetState.copy(obj1, obj2);
    }

    public final T component1() {
        return this.initial;
    }

    public final T component2() {
        return this.target;
    }

    public final androidx.compose.ui.tooling.animation.states.TargetState<T> copy(T t, T t2) {
        TargetState targetState = new TargetState(t, t2);
        return targetState;
    }

    @Override // androidx.compose.ui.tooling.animation.states.ComposeAnimationState
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TargetState) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.initial, obj.initial)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.target, obj.target)) {
            return i2;
        }
        return i;
    }

    public final T getInitial() {
        return this.initial;
    }

    public final T getTarget() {
        return this.target;
    }

    @Override // androidx.compose.ui.tooling.animation.states.ComposeAnimationState
    public int hashCode() {
        int i;
        int i2;
        if (this.initial == null) {
            i = i2;
        } else {
            i = this.initial.hashCode();
        }
        if (this.target == null) {
        } else {
            i2 = this.target.hashCode();
        }
        return i3 += i2;
    }

    @Override // androidx.compose.ui.tooling.animation.states.ComposeAnimationState
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TargetState(initial=").append(this.initial).append(", target=").append(this.target).append(')').toString();
    }
}
