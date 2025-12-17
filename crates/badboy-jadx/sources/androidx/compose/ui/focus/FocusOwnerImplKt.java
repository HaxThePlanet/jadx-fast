package androidx.compose.ui.focus;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0005", d2 = {"is1dFocusSearch", "", "Landroidx/compose/ui/focus/FocusDirection;", "is1dFocusSearch-3ESFkO8", "(I)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusOwnerImplKt {
    public static final boolean is1dFocusSearch-3ESFkO8(int $this$is1dFocusSearch_u2d3ESFkO8) {
        int equals-impl0;
        int i;
        if (FocusDirection.equals-impl0($this$is1dFocusSearch_u2d3ESFkO8, FocusDirection.Companion.getNext-dhqQ-8s())) {
            equals-impl0 = i;
        } else {
            equals-impl0 = FocusDirection.equals-impl0($this$is1dFocusSearch_u2d3ESFkO8, FocusDirection.Companion.getPrevious-dhqQ-8s());
        }
        if (equals-impl0 != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
