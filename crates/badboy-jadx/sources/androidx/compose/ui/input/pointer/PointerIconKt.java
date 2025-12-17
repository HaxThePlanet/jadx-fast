package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006", d2 = {"pointerHoverIcon", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointerIconKt {
    public static final Modifier pointerHoverIcon(Modifier $this$pointerHoverIcon, androidx.compose.ui.input.pointer.PointerIcon icon, boolean overrideDescendants) {
        PointerHoverIconModifierElement pointerHoverIconModifierElement = new PointerHoverIconModifierElement(icon, overrideDescendants);
        return $this$pointerHoverIcon.then((Modifier)pointerHoverIconModifierElement);
    }

    public static Modifier pointerHoverIcon$default(Modifier modifier, androidx.compose.ui.input.pointer.PointerIcon pointerIcon2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return PointerIconKt.pointerHoverIcon(modifier, pointerIcon2, obj2);
    }
}
