package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\rH\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"DefaultConstraints", "Landroidx/compose/ui/unit/Constraints;", "J", "DefaultLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "PlacementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lookaheadCapablePlaceable", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "owner", "Landroidx/compose/ui/node/Owner;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlaceableKt {

    private static final long DefaultConstraints;
    private static final Function1<GraphicsLayerScope, Unit> DefaultLayerBlock;
    static {
        PlaceableKt.DefaultLayerBlock = (Function1)PlaceableKt.DefaultLayerBlock.1.INSTANCE;
        PlaceableKt.DefaultConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, 0);
    }

    public static final androidx.compose.ui.layout.Placeable.PlacementScope PlacementScope(LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        LookaheadCapablePlacementScope lookaheadCapablePlacementScope = new LookaheadCapablePlacementScope(lookaheadCapablePlaceable);
        return (Placeable.PlacementScope)lookaheadCapablePlacementScope;
    }

    public static final androidx.compose.ui.layout.Placeable.PlacementScope PlacementScope(Owner owner) {
        OuterPlacementScope outerPlacementScope = new OuterPlacementScope(owner);
        return (Placeable.PlacementScope)outerPlacementScope;
    }

    public static final long access$getDefaultConstraints$p() {
        return PlaceableKt.DefaultConstraints;
    }

    public static final Function1 access$getDefaultLayerBlock$p() {
        return PlaceableKt.DefaultLayerBlock;
    }
}
