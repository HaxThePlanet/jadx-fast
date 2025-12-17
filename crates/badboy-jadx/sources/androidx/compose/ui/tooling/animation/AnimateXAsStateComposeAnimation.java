package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 \"*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001\"B7\u0008\u0002\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e¨\u0006#", d2 = {"Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/tooling/ComposeAnimation;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "animationObject", "Landroidx/compose/animation/core/Animatable;", "(Landroidx/compose/ui/tooling/animation/ToolingState;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/Animatable;)V", "getAnimationObject", "()Landroidx/compose/animation/core/Animatable;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "label", "", "getLabel", "()Ljava/lang/String;", "states", "", "", "getStates", "()Ljava/util/Set;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "type", "Landroidx/compose/animation/tooling/ComposeAnimationType;", "getType", "()Landroidx/compose/animation/tooling/ComposeAnimationType;", "setState", "", "value", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimateXAsStateComposeAnimation<T, V extends androidx.compose.animation.core.AnimationVector>  implements ComposeAnimation {

    public static final int $stable = 8;
    public static final androidx.compose.ui.tooling.animation.AnimateXAsStateComposeAnimation.Companion Companion;
    private static boolean apiAvailable;
    private final Animatable<T, V> animationObject;
    private final AnimationSpec<T> animationSpec;
    private final String label;
    private final Set<Object> states;
    private final androidx.compose.ui.tooling.animation.ToolingState<T> toolingState;
    private final ComposeAnimationType type;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J7\u0010\u000b\u001a\u000c\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u0003\u0018\u00010\u000c\"\u0004\u0008\u0002\u0010\r\"\u0008\u0008\u0003\u0010\u000e*\u00020\u000f*\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u0010H\u0000¢\u0006\u0002\u0008\u0011R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0012", d2 = {"Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation$Companion;", "", "()V", "<set-?>", "", "apiAvailable", "getApiAvailable", "()Z", "testOverrideAvailability", "", "override", "parse", "Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "parse$ui_tooling_release", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean getApiAvailable() {
            return AnimateXAsStateComposeAnimation.access$getApiAvailable$cp();
        }

        public final <T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.ui.tooling.animation.AnimateXAsStateComposeAnimation<?, ?> parse$ui_tooling_release(androidx.compose.ui.tooling.animation.AnimationSearch.AnimateXAsStateSearchInfo<T, V> $this$parse) {
            final int i = 0;
            if (!getApiAvailable()) {
                return i;
            }
            if ($this$parse.getAnimatable().getValue() == null) {
                return i;
            }
            AnimateXAsStateComposeAnimation animateXAsStateComposeAnimation = new AnimateXAsStateComposeAnimation($this$parse.getToolingState(), $this$parse.getAnimationSpec(), $this$parse.getAnimatable(), i);
            return animateXAsStateComposeAnimation;
        }

        public final void testOverrideAvailability(boolean override) {
            AnimateXAsStateComposeAnimation.access$setApiAvailable$cp(override);
        }
    }
    static {
        int i;
        int i3;
        ComposeAnimationType composeAnimationType;
        boolean it;
        int i2;
        String name;
        String str;
        AnimateXAsStateComposeAnimation.Companion companion = new AnimateXAsStateComposeAnimation.Companion(0);
        AnimateXAsStateComposeAnimation.Companion = companion;
        int i4 = 8;
        ComposeAnimationType[] values = ComposeAnimationType.values();
        int i6 = 0;
        i3 = i;
        while (i3 < values.length) {
            i2 = 0;
            i3++;
        }
        AnimateXAsStateComposeAnimation.apiAvailable = i;
    }

    private AnimateXAsStateComposeAnimation(androidx.compose.ui.tooling.animation.ToolingState<T> toolingState, AnimationSpec<T> animationSpec, Animatable<T, V> animationObject) {
        Set enumConstants;
        super();
        this.toolingState = toolingState;
        this.animationSpec = animationSpec;
        this.animationObject = animationObject;
        this.type = ComposeAnimationType.ANIMATE_X_AS_STATE;
        Object value = getAnimationObject().getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Any");
        int i = 0;
        enumConstants = value.getClass().getEnumConstants();
        if (enumConstants != null) {
            if (ArraysKt.toSet(enumConstants) == null) {
                enumConstants = SetsKt.setOf(value);
            }
        } else {
        }
        this.states = enumConstants;
        this.label = getAnimationObject().getLabel();
    }

    public AnimateXAsStateComposeAnimation(androidx.compose.ui.tooling.animation.ToolingState toolingState, AnimationSpec animationSpec2, Animatable animatable3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(toolingState, animationSpec2, animatable3);
    }

    public static final boolean access$getApiAvailable$cp() {
        return AnimateXAsStateComposeAnimation.apiAvailable;
    }

    public static final void access$setApiAvailable$cp(boolean <set-?>) {
        AnimateXAsStateComposeAnimation.apiAvailable = <set-?>;
    }

    public Animatable<T, V> getAnimationObject() {
        return this.animationObject;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public Object getAnimationObject() {
        return getAnimationObject();
    }

    public final AnimationSpec<T> getAnimationSpec() {
        return this.animationSpec;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public String getLabel() {
        return this.label;
    }

    public Set<Object> getStates() {
        return this.states;
    }

    public final androidx.compose.ui.tooling.animation.ToolingState<T> getToolingState() {
        return this.toolingState;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public ComposeAnimationType getType() {
        return this.type;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public final void setState(Object value) {
        this.toolingState.setValue(value);
    }
}
