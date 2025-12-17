package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/compose/ui/layout/LookaheadCapablePlacementScope;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "within", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "(Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentWidth", "", "getParentWidth", "()I", "current", "", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LookaheadCapablePlacementScope extends androidx.compose.ui.layout.Placeable.PlacementScope {

    private final LookaheadCapablePlaceable within;
    public LookaheadCapablePlacementScope(LookaheadCapablePlaceable within) {
        super();
        this.within = within;
    }

    @Override // androidx.compose.ui.layout.Placeable$PlacementScope
    public float current(androidx.compose.ui.layout.Ruler $this$current, float defaultValue) {
        return this.within.findRulerValue($this$current, defaultValue);
    }

    @Override // androidx.compose.ui.layout.Placeable$PlacementScope
    public androidx.compose.ui.layout.LayoutCoordinates getCoordinates() {
        int coordinates;
        LayoutNodeLayoutDelegate layoutDelegate$ui_release;
        if (this.within.isPlacingForAlignment$ui_release()) {
            coordinates = 0;
        } else {
            coordinates = this.within.getCoordinates();
        }
        if (coordinates == 0) {
            this.within.getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
        }
        return coordinates;
    }

    @Override // androidx.compose.ui.layout.Placeable$PlacementScope
    protected LayoutDirection getParentLayoutDirection() {
        return this.within.getLayoutDirection();
    }

    @Override // androidx.compose.ui.layout.Placeable$PlacementScope
    protected int getParentWidth() {
        return this.within.getMeasuredWidth();
    }
}
