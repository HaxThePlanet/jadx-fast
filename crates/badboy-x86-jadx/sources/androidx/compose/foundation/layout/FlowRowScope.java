package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* loaded from: classes.dex */
@LayoutScopeMarker
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0008g\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0008\u0008\u0003\u0010\u0004\u001a\u00020\u0005H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0006À\u0006\u0001", d2 = {"Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/foundation/layout/RowScope;", "fillMaxRowHeight", "Landroidx/compose/ui/Modifier;", "fraction", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FlowRowScope extends androidx.compose.foundation.layout.RowScope {
    public static Modifier fillMaxRowHeight$default(androidx.compose.foundation.layout.FlowRowScope flowRowScope, Modifier modifier2, float f3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = 1065353216;
            }
            return flowRowScope.fillMaxRowHeight(modifier2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillMaxRowHeight");
        throw obj0;
    }

    @Override // androidx.compose.foundation.layout.RowScope
    public abstract Modifier fillMaxRowHeight(Modifier modifier, float f2);
}
