package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 \u0016*\u0004\u0008\u0000\u0010\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0016B-\u0008\u0002\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006\u0017", d2 = {"Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation;", "T", "Landroidx/compose/animation/tooling/ComposeAnimation;", "Landroidx/compose/ui/tooling/animation/TransitionBasedAnimation;", "animationObject", "Landroidx/compose/animation/core/Transition;", "states", "", "", "label", "", "(Landroidx/compose/animation/core/Transition;Ljava/util/Set;Ljava/lang/String;)V", "getAnimationObject", "()Landroidx/compose/animation/core/Transition;", "getLabel", "()Ljava/lang/String;", "getStates", "()Ljava/util/Set;", "type", "Landroidx/compose/animation/tooling/ComposeAnimationType;", "getType", "()Landroidx/compose/animation/tooling/ComposeAnimationType;", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimatedContentComposeAnimation<T>  implements ComposeAnimation, androidx.compose.ui.tooling.animation.TransitionBasedAnimation<T> {

    public static final int $stable = 8;
    public static final androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation.Companion Companion;
    private static boolean apiAvailable;
    private final Transition<T> animationObject;
    private final String label;
    private final Set<Object> states;
    private final ComposeAnimationType type;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0014\u0010\u000b\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c*\u0006\u0012\u0002\u0008\u00030\rR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000e", d2 = {"Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation$Companion;", "", "()V", "<set-?>", "", "apiAvailable", "getApiAvailable", "()Z", "testOverrideAvailability", "", "override", "parseAnimatedContent", "Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean getApiAvailable() {
            return AnimatedContentComposeAnimation.access$getApiAvailable$cp();
        }

        public final androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation<?> parseAnimatedContent(Transition<?> $this$parseAnimatedContent) {
            int i;
            int i2;
            Set enumConstants;
            androidx.compose.ui.tooling.animation.AnimatedContentComposeAnimation animatedContentComposeAnimation;
            String simpleName;
            i = 0;
            if (!getApiAvailable()) {
                return i;
            }
            Object currentState = $this$parseAnimatedContent.getCurrentState();
            if (currentState != null) {
                i2 = 0;
                enumConstants = currentState.getClass().getEnumConstants();
                if (enumConstants != null) {
                    if (ArraysKt.toSet(enumConstants) == null) {
                        enumConstants = SetsKt.setOf(currentState);
                    }
                } else {
                }
                if ($this$parseAnimatedContent.getLabel() == null) {
                    simpleName = Reflection.getOrCreateKotlinClass(currentState.getClass()).getSimpleName();
                }
                animatedContentComposeAnimation = new AnimatedContentComposeAnimation($this$parseAnimatedContent, enumConstants, simpleName, i);
                i = animatedContentComposeAnimation;
            }
            return i;
        }

        public final void testOverrideAvailability(boolean override) {
            AnimatedContentComposeAnimation.access$setApiAvailable$cp(override);
        }
    }
    static {
        int i2;
        int i3;
        ComposeAnimationType composeAnimationType;
        boolean it;
        int i;
        String name;
        String str;
        AnimatedContentComposeAnimation.Companion companion = new AnimatedContentComposeAnimation.Companion(0);
        AnimatedContentComposeAnimation.Companion = companion;
        int i4 = 8;
        ComposeAnimationType[] values = ComposeAnimationType.values();
        int i6 = 0;
        i3 = i2;
        while (i3 < values.length) {
            i = 0;
            i3++;
        }
        AnimatedContentComposeAnimation.apiAvailable = i2;
    }

    private AnimatedContentComposeAnimation(Transition<T> animationObject, Set<? extends Object> states, String label) {
        super();
        this.animationObject = animationObject;
        this.states = states;
        this.label = label;
        this.type = ComposeAnimationType.ANIMATED_CONTENT;
    }

    public AnimatedContentComposeAnimation(Transition transition, Set set2, String string3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(transition, set2, string3);
    }

    public static final boolean access$getApiAvailable$cp() {
        return AnimatedContentComposeAnimation.apiAvailable;
    }

    public static final void access$setApiAvailable$cp(boolean <set-?>) {
        AnimatedContentComposeAnimation.apiAvailable = <set-?>;
    }

    public Transition<T> getAnimationObject() {
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
}
