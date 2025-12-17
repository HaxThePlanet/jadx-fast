package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00082\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0018", d2 = {"Landroidx/compose/ui/node/PlaceableResult;", "Landroidx/compose/ui/node/OwnerScope;", "result", "Landroidx/compose/ui/layout/MeasureResult;", "placeable", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "(Landroidx/compose/ui/layout/MeasureResult;Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "isValidOwnerScope", "", "()Z", "getPlaceable", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "getResult", "()Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PlaceableResult implements androidx.compose.ui.node.OwnerScope {

    private final androidx.compose.ui.node.LookaheadCapablePlaceable placeable;
    private final MeasureResult result;
    public PlaceableResult(MeasureResult result, androidx.compose.ui.node.LookaheadCapablePlaceable placeable) {
        super();
        this.result = result;
        this.placeable = placeable;
    }

    public static androidx.compose.ui.node.PlaceableResult copy$default(androidx.compose.ui.node.PlaceableResult placeableResult, MeasureResult measureResult2, androidx.compose.ui.node.LookaheadCapablePlaceable lookaheadCapablePlaceable3, int i4, Object object5) {
        MeasureResult obj1;
        androidx.compose.ui.node.LookaheadCapablePlaceable obj2;
        if (i4 & 1 != 0) {
            obj1 = placeableResult.result;
        }
        if (i4 &= 2 != 0) {
            obj2 = placeableResult.placeable;
        }
        return placeableResult.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final MeasureResult component1() {
        return this.result;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final androidx.compose.ui.node.LookaheadCapablePlaceable component2() {
        return this.placeable;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final androidx.compose.ui.node.PlaceableResult copy(MeasureResult measureResult, androidx.compose.ui.node.LookaheadCapablePlaceable lookaheadCapablePlaceable2) {
        PlaceableResult placeableResult = new PlaceableResult(measureResult, lookaheadCapablePlaceable2);
        return placeableResult;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof PlaceableResult == null) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.result, obj.result)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.placeable, obj.placeable)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final androidx.compose.ui.node.LookaheadCapablePlaceable getPlaceable() {
        return this.placeable;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final MeasureResult getResult() {
        return this.result;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.placeable.getCoordinates().isAttached();
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PlaceableResult(result=").append(this.result).append(", placeable=").append(this.placeable).append(')').toString();
    }
}
