package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u000c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u0013", d2 = {"Landroidx/compose/ui/layout/OuterPlacementScope;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroidx/compose/ui/node/Owner;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getOwner", "()Landroidx/compose/ui/node/Owner;", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentWidth", "", "getParentWidth", "()I", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class OuterPlacementScope extends androidx.compose.ui.layout.Placeable.PlacementScope {

    private final Owner owner;
    public OuterPlacementScope(Owner owner) {
        super();
        this.owner = owner;
    }

    @Override // androidx.compose.ui.layout.Placeable$PlacementScope
    public androidx.compose.ui.layout.LayoutCoordinates getCoordinates() {
        return (LayoutCoordinates)this.owner.getRoot().getOuterCoordinator$ui_release();
    }

    @Override // androidx.compose.ui.layout.Placeable$PlacementScope
    public final Owner getOwner() {
        return this.owner;
    }

    @Override // androidx.compose.ui.layout.Placeable$PlacementScope
    protected LayoutDirection getParentLayoutDirection() {
        return this.owner.getLayoutDirection();
    }

    @Override // androidx.compose.ui.layout.Placeable$PlacementScope
    protected int getParentWidth() {
        return this.owner.getRoot().getWidth();
    }
}
