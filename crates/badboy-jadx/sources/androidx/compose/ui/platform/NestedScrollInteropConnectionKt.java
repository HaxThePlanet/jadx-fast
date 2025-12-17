package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u0001H\u0000\u001a\u0017\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000cH\u0007¢\u0006\u0002\u0010\r\u001a\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a\u000c\u0010\u0014\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u000c\u0010\u0015\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\u0016\u0010\u0016\u001a\u00020\u0003*\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a\u000c\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"ScrollingAxesThreshold", "", "scrollAxes", "", "Landroidx/compose/ui/geometry/Offset;", "getScrollAxes-k-4lQ0M", "(J)I", "composeToViewOffset", "offset", "rememberNestedScrollInteropConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "hostView", "Landroid/view/View;", "(Landroid/view/View;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "toOffset", "consumed", "", "available", "toOffset-Uv8p0NA", "([IJ)J", "ceilAwayFromZero", "reverseAxis", "toViewType", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "toViewType-GyEprt8", "(I)I", "toViewVelocity", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NestedScrollInteropConnectionKt {

    private static final float ScrollingAxesThreshold = 0.5f;
    public static final int access$getScrollAxes-k-4lQ0M(long $receiver) {
        return NestedScrollInteropConnectionKt.getScrollAxes-k-4lQ0M($receiver);
    }

    public static final long access$toOffset-Uv8p0NA(int[] consumed, long available) {
        return NestedScrollInteropConnectionKt.toOffset-Uv8p0NA(consumed, available);
    }

    public static final int access$toViewType-GyEprt8(int $receiver) {
        return NestedScrollInteropConnectionKt.toViewType-GyEprt8($receiver);
    }

    public static final float access$toViewVelocity(float $receiver) {
        return NestedScrollInteropConnectionKt.toViewVelocity($receiver);
    }

    private static final float ceilAwayFromZero(float $this$ceilAwayFromZero) {
        double floor;
        if (Float.compare($this$ceilAwayFromZero, i) >= 0) {
            floor = Math.ceil((double)$this$ceilAwayFromZero);
        } else {
            floor = Math.floor((double)$this$ceilAwayFromZero);
        }
        return (float)floor;
    }

    public static final int composeToViewOffset(float offset) {
        return i *= -1;
    }

    private static final int getScrollAxes-k-4lQ0M(long $this$scrollAxes) {
        int axes;
        final int i = 1056964608;
        if (Float.compare(f, i) >= 0) {
            axes |= 1;
        }
        if (Float.compare(f2, i) >= 0) {
            axes |= 2;
        }
        return axes;
    }

    public static final NestedScrollConnection rememberNestedScrollInteropConnection(View hostView, Composer $composer, int $changed, int i4) {
        String str;
        int i;
        Object consume;
        String empty;
        Object nestedScrollInteropConnection;
        Object obj6;
        int obj9;
        int i2 = 1075877987;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberNestedScrollInteropConnection)234@8199L7,235@8235L66:NestedScrollInteropConnection.android.kt#itgzvw");
        if (i4 &= 1 != 0) {
            str = 6;
            i = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($composer);
            obj6 = consume;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.ui.platform.rememberNestedScrollInteropConnection (NestedScrollInteropConnection.android.kt:235)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -5563766, "CC(remember):NestedScrollInteropConnection.android.kt#9igjgp");
        Composer composer = $composer;
        int i3 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i5 = 0;
        if (!$composer.changed(obj6)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                nestedScrollInteropConnection = new NestedScrollInteropConnection(obj6);
                composer.updateRememberedValue(nestedScrollInteropConnection);
            } else {
                nestedScrollInteropConnection = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (NestedScrollConnection)(NestedScrollInteropConnection)nestedScrollInteropConnection;
    }

    private static final float reverseAxis(int $this$reverseAxis) {
        return f *= i2;
    }

    private static final long toOffset-Uv8p0NA(int[] consumed, long available) {
        float coerceAtLeast;
        float coerceAtLeast2;
        float x-impl;
        float y-impl;
        int i3 = 0;
        int i6 = 0;
        if (Float.compare(x-impl2, i3) >= 0) {
            coerceAtLeast = RangesKt.coerceAtMost(NestedScrollInteropConnectionKt.reverseAxis(consumed[i6]), Offset.getX-impl(available));
        } else {
            coerceAtLeast = RangesKt.coerceAtLeast(NestedScrollInteropConnectionKt.reverseAxis(consumed[i6]), Offset.getX-impl(available));
        }
        int i7 = 1;
        if (Float.compare(y-impl2, i3) >= 0) {
            coerceAtLeast2 = RangesKt.coerceAtMost(NestedScrollInteropConnectionKt.reverseAxis(consumed[i7]), Offset.getY-impl(available));
        } else {
            coerceAtLeast2 = RangesKt.coerceAtLeast(NestedScrollInteropConnectionKt.reverseAxis(consumed[i7]), Offset.getY-impl(available));
        }
        return OffsetKt.Offset(coerceAtLeast, coerceAtLeast2);
    }

    private static final int toViewType-GyEprt8(int $this$toViewType_u2dGyEprt8) {
        int i;
        i = NestedScrollSource.equals-impl0($this$toViewType_u2dGyEprt8, NestedScrollSource.Companion.getUserInput-WNlRxjI()) ? 0 : 1;
        return i;
    }

    private static final float toViewVelocity(float $this$toViewVelocity) {
        return i *= $this$toViewVelocity;
    }
}
