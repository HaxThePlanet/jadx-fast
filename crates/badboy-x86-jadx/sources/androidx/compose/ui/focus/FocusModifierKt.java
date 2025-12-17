package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0003", d2 = {"focusModifier", "Landroidx/compose/ui/Modifier;", "focusTarget", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusModifierKt {
    @Deprecated(message = "Replaced by focusTarget", replaceWith = @ReplaceWith(...))
    public static final Modifier focusModifier(Modifier $this$focusModifier) {
        return FocusModifierKt.focusTarget($this$focusModifier);
    }

    public static final Modifier focusTarget(Modifier $this$focusTarget) {
        return $this$focusTarget.then((Modifier)FocusTargetNode.FocusTargetElement.INSTANCE);
    }
}
