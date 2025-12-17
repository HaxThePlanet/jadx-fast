package androidx.compose.material3;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0008\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J6\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR+\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u000b\u001a\u0004\u0008\r\u0010\u0007\"\u0004\u0008\u000e\u0010\tR+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015¨\u0006!", d2 = {"Landroidx/compose/material3/DrawerPredictiveBackState;", "", "()V", "<set-?>", "", "scaleXDistance", "getScaleXDistance", "()F", "setScaleXDistance", "(F)V", "scaleXDistance$delegate", "Landroidx/compose/runtime/MutableFloatState;", "scaleYDistance", "getScaleYDistance", "setScaleYDistance", "scaleYDistance$delegate", "", "swipeEdgeMatchesDrawer", "getSwipeEdgeMatchesDrawer", "()Z", "setSwipeEdgeMatchesDrawer", "(Z)V", "swipeEdgeMatchesDrawer$delegate", "Landroidx/compose/runtime/MutableState;", "clear", "", "update", "progress", "swipeEdgeLeft", "isRtl", "maxScaleXDistanceGrow", "maxScaleXDistanceShrink", "maxScaleYDistance", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawerPredictiveBackState {

    public static final int $stable;
    private final MutableFloatState scaleXDistance$delegate;
    private final MutableFloatState scaleYDistance$delegate;
    private final MutableState swipeEdgeMatchesDrawer$delegate;
    static {
    }

    public DrawerPredictiveBackState() {
        super();
        int i3 = 0;
        this.swipeEdgeMatchesDrawer$delegate = SnapshotStateKt.mutableStateOf$default(true, i3, 2, i3);
        int i2 = 0;
        this.scaleXDistance$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i2);
        this.scaleYDistance$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i2);
    }

    public final void clear() {
        setSwipeEdgeMatchesDrawer(true);
        int i2 = 0;
        setScaleXDistance(i2);
        setScaleYDistance(i2);
    }

    public final float getScaleXDistance() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.scaleXDistance$delegate.getFloatValue();
    }

    public final float getScaleYDistance() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.scaleYDistance$delegate.getFloatValue();
    }

    public final boolean getSwipeEdgeMatchesDrawer() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.swipeEdgeMatchesDrawer$delegate.getValue().booleanValue();
    }

    public final void setScaleXDistance(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.scaleXDistance$delegate.setFloatValue(<set-?>);
    }

    public final void setScaleYDistance(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.scaleYDistance$delegate.setFloatValue(<set-?>);
    }

    public final void setSwipeEdgeMatchesDrawer(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.swipeEdgeMatchesDrawer$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void update(float progress, boolean swipeEdgeLeft, boolean isRtl, float maxScaleXDistanceGrow, float maxScaleXDistanceShrink, float maxScaleYDistance) {
        int i;
        float f;
        i = swipeEdgeLeft != isRtl ? 1 : 0;
        setSwipeEdgeMatchesDrawer(i);
        f = getSwipeEdgeMatchesDrawer() ? maxScaleXDistanceGrow : maxScaleXDistanceShrink;
        int i2 = 0;
        setScaleXDistance(MathHelpersKt.lerp(i2, f, progress));
        setScaleYDistance(MathHelpersKt.lerp(i2, maxScaleYDistance, progress));
    }
}
