package androidx.compose.foundation.selection;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007¨\u0006\u0002", d2 = {"selectableGroup", "Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectableGroupKt {
    public static final Modifier selectableGroup(Modifier $this$selectableGroup) {
        return SemanticsModifierKt.semantics$default($this$selectableGroup, false, (Function1)SelectableGroupKt.selectableGroup.1.INSTANCE, 1, 0);
    }
}
