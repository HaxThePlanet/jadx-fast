package androidx.compose.animation;

import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0005", d2 = {"ModifierLocalSharedElementInternalState", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/animation/SharedElementInternalState;", "getModifierLocalSharedElementInternalState", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SharedContentNodeKt {

    private static final ProvidableModifierLocal<androidx.compose.animation.SharedElementInternalState> ModifierLocalSharedElementInternalState;
    static {
        SharedContentNodeKt.ModifierLocalSharedElementInternalState = ModifierLocalKt.modifierLocalOf((Function0)SharedContentNodeKt.ModifierLocalSharedElementInternalState.1.INSTANCE);
    }

    public static final ProvidableModifierLocal<androidx.compose.animation.SharedElementInternalState> getModifierLocalSharedElementInternalState() {
        return SharedContentNodeKt.ModifierLocalSharedElementInternalState;
    }
}
