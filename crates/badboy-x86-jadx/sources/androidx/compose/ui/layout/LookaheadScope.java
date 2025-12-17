package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J2\u0010\u0007\u001a\u00020\u0008*\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u000c\u0010\u000f\u001a\u00020\u0003*\u00020\u0003H&R\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0010À\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/LookaheadScope;", "", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "toLookaheadCoordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LookaheadScope {
    public static long localLookaheadPositionOf-au-aQtc$default(androidx.compose.ui.layout.LookaheadScope lookaheadScope, androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates2, androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates3, long l4, boolean z5, int i6, Object object7) {
        long l;
        int i;
        long obj9;
        int obj11;
        if (obj13 != null) {
        } else {
            if (object7 & 2 != 0) {
                l = obj9;
            } else {
                l = l4;
            }
            i = object7 & 4 != 0 ? obj11 : i6;
            return lookaheadScope.localLookaheadPositionOf-au-aQtc(layoutCoordinates2, layoutCoordinates3, l, obj4);
        }
        UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localLookaheadPositionOf-au-aQtc");
        throw obj6;
    }

    public abstract androidx.compose.ui.layout.LayoutCoordinates getLookaheadScopeCoordinates(androidx.compose.ui.layout.Placeable.PlacementScope placeable$PlacementScope);

    public long localLookaheadPositionOf-au-aQtc(androidx.compose.ui.layout.LayoutCoordinates $this$localLookaheadPositionOf_u2dau_u2daQtc, androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        return LookaheadScopeKt.localLookaheadPositionOf-Fgt4K4Q(this, $this$localLookaheadPositionOf_u2dau_u2daQtc, sourceCoordinates, relativeToSource, includeMotionFrameOfReference);
    }

    public abstract androidx.compose.ui.layout.LayoutCoordinates toLookaheadCoordinates(androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates);
}
