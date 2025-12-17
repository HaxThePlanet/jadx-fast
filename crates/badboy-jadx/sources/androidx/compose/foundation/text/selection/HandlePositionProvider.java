package androidx.compose.foundation.text.selection;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J2\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u0008X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/text/selection/HandlePositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "(Landroidx/compose/ui/Alignment;Landroidx/compose/foundation/text/selection/OffsetProvider;)V", "prevPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HandlePositionProvider implements PopupPositionProvider {

    public static final int $stable;
    private final Alignment handleReferencePoint;
    private final androidx.compose.foundation.text.selection.OffsetProvider positionProvider;
    private long prevPosition;
    static {
    }

    public HandlePositionProvider(Alignment handleReferencePoint, androidx.compose.foundation.text.selection.OffsetProvider positionProvider) {
        super();
        this.handleReferencePoint = handleReferencePoint;
        this.positionProvider = positionProvider;
        this.prevPosition = Offset.Companion.getZero-F1C5BW0();
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long calculatePosition-llwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        long $this$takeOrElse_u2d3MmeM6k$iv;
        boolean $i$a$TakeOrElse3MmeM6kHandlePositionProvider$calculatePosition$position$1;
        int i = 0;
        if (OffsetKt.isSpecified-k-4lQ0M(this.positionProvider.provide-F1C5BW0())) {
        } else {
            int i2 = 0;
            $this$takeOrElse_u2d3MmeM6k$iv = $i$a$TakeOrElse3MmeM6kHandlePositionProvider$calculatePosition$position$1;
        }
        this.prevPosition = $this$takeOrElse_u2d3MmeM6k$iv;
        long l = obj14;
        return IntOffset.plus-qkQi6aY(IntOffset.plus-qkQi6aY(anchorBounds.getTopLeft-nOcc-ac(), l), l);
    }
}
