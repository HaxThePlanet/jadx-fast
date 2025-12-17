package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0008\u0002\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006\u001b", d2 = {"Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation;", "Landroidx/compose/animation/tooling/ComposeAnimation;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "", "animationObject", "Landroidx/compose/animation/core/InfiniteTransition;", "(Landroidx/compose/ui/tooling/animation/ToolingState;Landroidx/compose/animation/core/InfiniteTransition;)V", "getAnimationObject", "()Landroidx/compose/animation/core/InfiniteTransition;", "label", "", "getLabel", "()Ljava/lang/String;", "states", "", "", "getStates", "()Ljava/util/Set;", "type", "Landroidx/compose/animation/tooling/ComposeAnimationType;", "getType", "()Landroidx/compose/animation/tooling/ComposeAnimationType;", "setTimeNanos", "", "playTimeNanos", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InfiniteTransitionComposeAnimation implements ComposeAnimation {

    public static final int $stable = 8;
    public static final androidx.compose.ui.tooling.animation.InfiniteTransitionComposeAnimation.Companion Companion;
    private static boolean apiAvailable;
    private final InfiniteTransition animationObject;
    private final String label;
    private final Set<Object> states;
    private final androidx.compose.ui.tooling.animation.ToolingState<Long> toolingState;
    private final ComposeAnimationType type;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u000c*\u00020\rH\u0000¢\u0006\u0002\u0008\u000eR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000f", d2 = {"Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation$Companion;", "", "()V", "<set-?>", "", "apiAvailable", "getApiAvailable", "()Z", "testOverrideAvailability", "", "override", "parse", "Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "parse$ui_tooling_release", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean getApiAvailable() {
            return InfiniteTransitionComposeAnimation.access$getApiAvailable$cp();
        }

        public final androidx.compose.ui.tooling.animation.InfiniteTransitionComposeAnimation parse$ui_tooling_release(androidx.compose.ui.tooling.animation.AnimationSearch.InfiniteTransitionSearchInfo $this$parse) {
            final int i = 0;
            if (!getApiAvailable()) {
                return i;
            }
            InfiniteTransitionComposeAnimation infiniteTransitionComposeAnimation = new InfiniteTransitionComposeAnimation($this$parse.getToolingState(), $this$parse.getInfiniteTransition(), i);
            return infiniteTransitionComposeAnimation;
        }

        public final void testOverrideAvailability(boolean override) {
            InfiniteTransitionComposeAnimation.access$setApiAvailable$cp(override);
        }
    }
    static {
        int i2;
        int i;
        ComposeAnimationType composeAnimationType;
        boolean it;
        int i3;
        String name;
        String str;
        InfiniteTransitionComposeAnimation.Companion companion = new InfiniteTransitionComposeAnimation.Companion(0);
        InfiniteTransitionComposeAnimation.Companion = companion;
        int i4 = 8;
        ComposeAnimationType[] values = ComposeAnimationType.values();
        int i6 = 0;
        i = i2;
        while (i < values.length) {
            i3 = 0;
            i++;
        }
        InfiniteTransitionComposeAnimation.apiAvailable = i2;
    }

    private InfiniteTransitionComposeAnimation(androidx.compose.ui.tooling.animation.ToolingState<Long> toolingState, InfiniteTransition animationObject) {
        super();
        this.toolingState = toolingState;
        this.animationObject = animationObject;
        this.type = ComposeAnimationType.INFINITE_TRANSITION;
        this.states = SetsKt.setOf(0);
        this.label = getAnimationObject().getLabel();
    }

    public InfiniteTransitionComposeAnimation(androidx.compose.ui.tooling.animation.ToolingState toolingState, InfiniteTransition infiniteTransition2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(toolingState, infiniteTransition2);
    }

    public static final boolean access$getApiAvailable$cp() {
        return InfiniteTransitionComposeAnimation.apiAvailable;
    }

    public static final void access$setApiAvailable$cp(boolean <set-?>) {
        InfiniteTransitionComposeAnimation.apiAvailable = <set-?>;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public InfiniteTransition getAnimationObject() {
        return this.animationObject;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public Object getAnimationObject() {
        return getAnimationObject();
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public String getLabel() {
        return this.label;
    }

    public Set<Object> getStates() {
        return this.states;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public ComposeAnimationType getType() {
        return this.type;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public final void setTimeNanos(long playTimeNanos) {
        this.toolingState.setValue(Long.valueOf(playTimeNanos));
    }
}
