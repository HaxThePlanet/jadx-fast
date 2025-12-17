package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u0014\u0010\u0008\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0005R\u0018\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006!À\u0006\u0003", d2 = {"Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "", "afterContentPadding", "", "getAfterContentPadding", "()I", "beforeContentPadding", "getBeforeContentPadding", "mainAxisItemSpacing", "getMainAxisItemSpacing", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "getReverseLayout", "()Z", "totalItemsCount", "getTotalItemsCount", "viewportEndOffset", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "viewportStartOffset", "getViewportStartOffset", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyListLayoutInfo {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static int getAfterContentPadding(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
            return LazyListLayoutInfo.access$getAfterContentPadding$jd($this);
        }

        @Deprecated
        public static int getBeforeContentPadding(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
            return LazyListLayoutInfo.access$getBeforeContentPadding$jd($this);
        }

        @Deprecated
        public static int getMainAxisItemSpacing(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
            return LazyListLayoutInfo.access$getMainAxisItemSpacing$jd($this);
        }

        @Deprecated
        public static Orientation getOrientation(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
            return LazyListLayoutInfo.access$getOrientation$jd($this);
        }

        @Deprecated
        public static boolean getReverseLayout(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
            return LazyListLayoutInfo.access$getReverseLayout$jd($this);
        }

        @Deprecated
        public static long getViewportSize-YbymL2g(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
            return LazyListLayoutInfo.access$getViewportSize-YbymL2g$jd($this);
        }
    }
    public static int access$getAfterContentPadding$jd(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
        return super.getAfterContentPadding();
    }

    public static int access$getBeforeContentPadding$jd(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
        return super.getBeforeContentPadding();
    }

    public static int access$getMainAxisItemSpacing$jd(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
        return super.getMainAxisItemSpacing();
    }

    public static Orientation access$getOrientation$jd(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
        return super.getOrientation();
    }

    public static boolean access$getReverseLayout$jd(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
        return super.getReverseLayout();
    }

    public static long access$getViewportSize-YbymL2g$jd(androidx.compose.foundation.lazy.LazyListLayoutInfo $this) {
        return super.getViewportSize-YbymL2g();
    }

    public int getAfterContentPadding() {
        return 0;
    }

    public int getBeforeContentPadding() {
        return 0;
    }

    public int getMainAxisItemSpacing() {
        return 0;
    }

    public Orientation getOrientation() {
        return Orientation.Vertical;
    }

    public boolean getReverseLayout() {
        return 0;
    }

    public abstract int getTotalItemsCount();

    public abstract int getViewportEndOffset();

    public long getViewportSize-YbymL2g() {
        return IntSize.Companion.getZero-YbymL2g();
    }

    public abstract int getViewportStartOffset();

    public abstract List<androidx.compose.foundation.lazy.LazyListItemInfo> getVisibleItemsInfo();
}
