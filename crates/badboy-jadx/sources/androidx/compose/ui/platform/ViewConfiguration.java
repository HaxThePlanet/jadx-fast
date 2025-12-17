package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u0014\u0010\u0008\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0005R\u0012\u0010\u0015\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u000bø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u0017À\u0006\u0003", d2 = {"Landroidx/compose/ui/platform/ViewConfiguration;", "", "doubleTapMinTimeMillis", "", "getDoubleTapMinTimeMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "handwritingGestureLineMargin", "", "getHandwritingGestureLineMargin", "()F", "handwritingSlop", "getHandwritingSlop", "longPressTimeoutMillis", "getLongPressTimeoutMillis", "maximumFlingVelocity", "getMaximumFlingVelocity", "minimumTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "getMinimumTouchTargetSize-MYxV2XQ", "touchSlop", "getTouchSlop", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ViewConfiguration {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static float getHandwritingGestureLineMargin(androidx.compose.ui.platform.ViewConfiguration $this) {
            return ViewConfiguration.access$getHandwritingGestureLineMargin$jd($this);
        }

        @Deprecated
        public static float getHandwritingSlop(androidx.compose.ui.platform.ViewConfiguration $this) {
            return ViewConfiguration.access$getHandwritingSlop$jd($this);
        }

        @Deprecated
        public static float getMaximumFlingVelocity(androidx.compose.ui.platform.ViewConfiguration $this) {
            return ViewConfiguration.access$getMaximumFlingVelocity$jd($this);
        }

        @Deprecated
        public static long getMinimumTouchTargetSize-MYxV2XQ(androidx.compose.ui.platform.ViewConfiguration $this) {
            return ViewConfiguration.access$getMinimumTouchTargetSize-MYxV2XQ$jd($this);
        }
    }
    public static float access$getHandwritingGestureLineMargin$jd(androidx.compose.ui.platform.ViewConfiguration $this) {
        return super.getHandwritingGestureLineMargin();
    }

    public static float access$getHandwritingSlop$jd(androidx.compose.ui.platform.ViewConfiguration $this) {
        return super.getHandwritingSlop();
    }

    public static float access$getMaximumFlingVelocity$jd(androidx.compose.ui.platform.ViewConfiguration $this) {
        return super.getMaximumFlingVelocity();
    }

    public static long access$getMinimumTouchTargetSize-MYxV2XQ$jd(androidx.compose.ui.platform.ViewConfiguration $this) {
        return super.getMinimumTouchTargetSize-MYxV2XQ();
    }

    public abstract long getDoubleTapMinTimeMillis();

    public abstract long getDoubleTapTimeoutMillis();

    public float getHandwritingGestureLineMargin() {
        return 1098907648;
    }

    public float getHandwritingSlop() {
        return 1073741824;
    }

    public abstract long getLongPressTimeoutMillis();

    public float getMaximumFlingVelocity() {
        return 2139095039;
    }

    public long getMinimumTouchTargetSize-MYxV2XQ() {
        int i2 = 0;
        int i3 = 0;
        return DpKt.DpSize-YgX7TsA(Dp.constructor-impl((float)i), Dp.constructor-impl((float)$i$f$getDp));
    }

    public abstract float getTouchSlop();
}
