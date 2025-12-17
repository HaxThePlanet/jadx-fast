package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0008H\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\t", d2 = {"LocalSelectionRegistrar", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "getLocalSelectionRegistrar", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "hasSelection", "", "selectableId", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionRegistrarKt {

    private static final ProvidableCompositionLocal<androidx.compose.foundation.text.selection.SelectionRegistrar> LocalSelectionRegistrar;
    static {
        final int i2 = 0;
        SelectionRegistrarKt.LocalSelectionRegistrar = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)SelectionRegistrarKt.LocalSelectionRegistrar.1.INSTANCE, 1, i2);
    }

    public static final ProvidableCompositionLocal<androidx.compose.foundation.text.selection.SelectionRegistrar> getLocalSelectionRegistrar() {
        return SelectionRegistrarKt.LocalSelectionRegistrar;
    }

    public static final boolean hasSelection(androidx.compose.foundation.text.selection.SelectionRegistrar $this$hasSelection, long selectableId) {
        LongObjectMap subselections;
        int key;
        subselections = $this$hasSelection.getSubselections();
        if ($this$hasSelection != null && subselections != null) {
            subselections = $this$hasSelection.getSubselections();
            if (subselections != null) {
                key = subselections.containsKey(selectableId);
            } else {
                key = 0;
            }
        } else {
        }
        return key;
    }
}
