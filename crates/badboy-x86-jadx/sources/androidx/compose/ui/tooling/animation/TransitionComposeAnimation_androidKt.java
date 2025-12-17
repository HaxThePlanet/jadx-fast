package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0001*\u0006\u0012\u0002\u0008\u00030\u0002H\u0000¨\u0006\u0003", d2 = {"parse", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransitionComposeAnimation_androidKt {
    public static final androidx.compose.ui.tooling.animation.TransitionComposeAnimation<?> parse(Transition<?> $this$parse) {
        int i;
        Object[] enumConstants;
        int transitionComposeAnimation;
        String simpleName;
        final Object currentState = $this$parse.getCurrentState();
        if (currentState != null) {
            i = 0;
            enumConstants = currentState.getClass().getEnumConstants();
            if (enumConstants != null) {
                if (ArraysKt.toSet(enumConstants) == null) {
                    enumConstants = SetsKt.setOf(currentState);
                }
            } else {
            }
            if ($this$parse.getLabel() == null) {
                simpleName = Reflection.getOrCreateKotlinClass(currentState.getClass()).getSimpleName();
            }
            transitionComposeAnimation = new TransitionComposeAnimation($this$parse, enumConstants, simpleName);
        } else {
            transitionComposeAnimation = 0;
        }
        return transitionComposeAnimation;
    }
}
