package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0010¢\u0006\u0002\u0008\t¨\u0006\n", d2 = {"Landroidx/compose/ui/layout/HorizontalRuler;", "Landroidx/compose/ui/layout/Ruler;", "()V", "calculateCoordinate", "", "coordinate", "sourceCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "targetCoordinates", "calculateCoordinate$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HorizontalRuler extends androidx.compose.ui.layout.Ruler {

    public static final int $stable;
    static {
    }

    public HorizontalRuler() {
        super(0);
    }

    @Override // androidx.compose.ui.layout.Ruler
    public float calculateCoordinate$ui_release(float coordinate, androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, androidx.compose.ui.layout.LayoutCoordinates targetCoordinates) {
        final int i2 = 1073741824;
        return Offset.getY-impl(targetCoordinates.localPositionOf-R5De75A(sourceCoordinates, OffsetKt.Offset(f /= i2, coordinate)));
    }
}
