package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u0012\u0010\u0008\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0005R\u001a\u0010\u0012\u001a\u00020\u00138fX¦\u0004¢\u0006\u000c\u0012\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0005R\u0018\u0010\u001e\u001a\u00020\u001fX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010\u0005R\u0018\u0010$\u001a\u0008\u0012\u0004\u0012\u00020&0%X¦\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010(\u0082\u0001\u0001)ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006*À\u0006\u0001", d2 = {"Landroidx/compose/foundation/pager/PagerLayoutInfo;", "", "afterContentPadding", "", "getAfterContentPadding", "()I", "beforeContentPadding", "getBeforeContentPadding", "beyondViewportPageCount", "getBeyondViewportPageCount", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "pageSize", "getPageSize", "pageSpacing", "getPageSpacing", "reverseLayout", "", "getReverseLayout$annotations", "()V", "getReverseLayout", "()Z", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "getSnapPosition", "()Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "viewportEndOffset", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "viewportStartOffset", "getViewportStartOffset", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/PageInfo;", "getVisiblePagesInfo", "()Ljava/util/List;", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PagerLayoutInfo {
    public static void getReverseLayout$annotations() {
    }

    public abstract int getAfterContentPadding();

    public abstract int getBeforeContentPadding();

    public abstract int getBeyondViewportPageCount();

    public abstract Orientation getOrientation();

    public abstract int getPageSize();

    public abstract int getPageSpacing();

    public abstract boolean getReverseLayout();

    public abstract SnapPosition getSnapPosition();

    public abstract int getViewportEndOffset();

    public abstract long getViewportSize-YbymL2g();

    public abstract int getViewportStartOffset();

    public abstract List<androidx.compose.foundation.pager.PageInfo> getVisiblePagesInfo();
}
