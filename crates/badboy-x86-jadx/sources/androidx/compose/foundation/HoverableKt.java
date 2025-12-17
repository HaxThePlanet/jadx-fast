package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006", d2 = {"hoverable", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "enabled", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HoverableKt {
    public static final Modifier hoverable(Modifier $this$hoverable, MutableInteractionSource interactionSource, boolean enabled) {
        Object hoverableElement;
        if (enabled) {
            hoverableElement = new HoverableElement(interactionSource);
        } else {
            hoverableElement = Modifier.Companion;
        }
        return $this$hoverable.then((Modifier)hoverableElement);
    }

    public static Modifier hoverable$default(Modifier modifier, MutableInteractionSource mutableInteractionSource2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        return HoverableKt.hoverable(modifier, mutableInteractionSource2, obj2);
    }
}
