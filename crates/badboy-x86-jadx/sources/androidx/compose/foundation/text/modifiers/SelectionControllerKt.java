package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¨\u0006\u0008", d2 = {"makeSelectionModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "selectableId", "", "layoutCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionControllerKt {
    public static final Modifier access$makeSelectionModifier(SelectionRegistrar $receiver, long selectableId, Function0 layoutCoordinates) {
        return SelectionControllerKt.makeSelectionModifier($receiver, selectableId, layoutCoordinates);
    }

    private static final Modifier makeSelectionModifier(SelectionRegistrar $this$makeSelectionModifier, long selectableId, Function0<? extends LayoutCoordinates> layoutCoordinates) {
        SelectionControllerKt.makeSelectionModifier.longPressDragObserver.1 anon = new SelectionControllerKt.makeSelectionModifier.longPressDragObserver.1(obj8, $this$makeSelectionModifier, selectableId, layoutCoordinates);
        SelectionControllerKt.makeSelectionModifier.mouseSelectionObserver.1 anon2 = new SelectionControllerKt.makeSelectionModifier.mouseSelectionObserver.1(obj8, $this$makeSelectionModifier, selectableId, layoutCoordinates);
        return SelectionGesturesKt.selectionGestureInput((Modifier)Modifier.Companion, (MouseSelectionObserver)anon2, (TextDragObserver)anon);
    }
}
