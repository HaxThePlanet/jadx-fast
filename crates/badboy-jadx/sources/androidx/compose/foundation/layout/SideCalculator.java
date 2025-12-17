package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000b\u0008c\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H&ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000bJ\"\u0010\u000c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH&J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0003H&ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u001aÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/layout/SideCalculator;", "", "adjustInsets", "Landroid/graphics/Insets;", "oldInsets", "newValue", "", "consumedOffsets", "Landroidx/compose/ui/geometry/Offset;", "available", "consumedOffsets-MK-Hz9U", "(J)J", "consumedVelocity", "Landroidx/compose/ui/unit/Velocity;", "remaining", "", "consumedVelocity-QWom1Mo", "(JF)J", "hideMotion", "x", "y", "motionOf", "showMotion", "valueOf", "insets", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
interface SideCalculator {

    public static final androidx.compose.foundation.layout.SideCalculator.Companion Companion;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0004\u0004\u0007\n\r\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/layout/SideCalculator$Companion;", "", "()V", "BottomSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1;", "LeftSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1;", "RightSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1;", "TopSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1;", "chooseCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "chooseCalculator-ni1skBw", "(ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/foundation/layout/SideCalculator;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.foundation.layout.SideCalculator.Companion $$INSTANCE;
        private static final androidx.compose.foundation.layout.SideCalculator.Companion.BottomSideCalculator.1 BottomSideCalculator;
        private static final androidx.compose.foundation.layout.SideCalculator.Companion.LeftSideCalculator.1 LeftSideCalculator;
        private static final androidx.compose.foundation.layout.SideCalculator.Companion.RightSideCalculator.1 RightSideCalculator;
        private static final androidx.compose.foundation.layout.SideCalculator.Companion.TopSideCalculator.1 TopSideCalculator;
        static {
            SideCalculator.Companion companion = new SideCalculator.Companion();
            SideCalculator.Companion.$$INSTANCE = companion;
            SideCalculator.Companion.LeftSideCalculator.1 anon = new SideCalculator.Companion.LeftSideCalculator.1();
            SideCalculator.Companion.LeftSideCalculator = anon;
            SideCalculator.Companion.TopSideCalculator.1 anon2 = new SideCalculator.Companion.TopSideCalculator.1();
            SideCalculator.Companion.TopSideCalculator = anon2;
            SideCalculator.Companion.RightSideCalculator.1 anon3 = new SideCalculator.Companion.RightSideCalculator.1();
            SideCalculator.Companion.RightSideCalculator = anon3;
            SideCalculator.Companion.BottomSideCalculator.1 anon4 = new SideCalculator.Companion.BottomSideCalculator.1();
            SideCalculator.Companion.BottomSideCalculator = anon4;
        }

        public final androidx.compose.foundation.layout.SideCalculator chooseCalculator-ni1skBw(int side, LayoutDirection layoutDirection) {
            Object bottomSideCalculator;
            if (WindowInsetsSides.equals-impl0(side, WindowInsetsSides.Companion.getLeft-JoeWqyM())) {
                bottomSideCalculator = SideCalculator.Companion.LeftSideCalculator;
                return bottomSideCalculator;
            } else {
                if (WindowInsetsSides.equals-impl0(side, WindowInsetsSides.Companion.getTop-JoeWqyM())) {
                    bottomSideCalculator = SideCalculator.Companion.TopSideCalculator;
                } else {
                    if (WindowInsetsSides.equals-impl0(side, WindowInsetsSides.Companion.getRight-JoeWqyM())) {
                        bottomSideCalculator = SideCalculator.Companion.RightSideCalculator;
                    } else {
                        if (WindowInsetsSides.equals-impl0(side, WindowInsetsSides.Companion.getBottom-JoeWqyM())) {
                            bottomSideCalculator = SideCalculator.Companion.BottomSideCalculator;
                        } else {
                            if (WindowInsetsSides.equals-impl0(side, WindowInsetsSides.Companion.getStart-JoeWqyM())) {
                                if (layoutDirection == LayoutDirection.Ltr) {
                                    bottomSideCalculator = SideCalculator.Companion.LeftSideCalculator;
                                } else {
                                    bottomSideCalculator = SideCalculator.Companion.RightSideCalculator;
                                }
                            } else {
                                if (!WindowInsetsSides.equals-impl0(side, WindowInsetsSides.Companion.getEnd-JoeWqyM())) {
                                } else {
                                    if (layoutDirection == LayoutDirection.Ltr) {
                                        bottomSideCalculator = SideCalculator.Companion.RightSideCalculator;
                                    } else {
                                        bottomSideCalculator = SideCalculator.Companion.LeftSideCalculator;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Only Left, Top, Right, Bottom, Start and End are allowed".toString());
            throw illegalStateException;
        }
    }
    static {
        SideCalculator.Companion = SideCalculator.Companion.$$INSTANCE;
    }

    public abstract Insets adjustInsets(Insets insets, int i2);

    public abstract long consumedOffsets-MK-Hz9U(long l);

    public abstract long consumedVelocity-QWom1Mo(long l, float f2);

    public float hideMotion(float x, float y) {
        return RangesKt.coerceAtMost(motionOf(x, y), 0);
    }

    public abstract float motionOf(float f, float f2);

    public float showMotion(float x, float y) {
        return RangesKt.coerceAtLeast(motionOf(x, y), 0);
    }

    public abstract int valueOf(Insets insets);
}
