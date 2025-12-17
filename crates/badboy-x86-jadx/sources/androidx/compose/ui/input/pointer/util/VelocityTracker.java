package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u0006J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0015R\"\u0010\u0003\u001a\u00020\u0004X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006\"\u0004\u0008\r\u0010\u0008R\u0014\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0010\u0010\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006!", d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "()V", "currentPointerPositionAccumulator", "Landroidx/compose/ui/geometry/Offset;", "getCurrentPointerPositionAccumulator-F1C5BW0$ui_release", "()J", "setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release", "(J)V", "J", "lastMoveEventTimeStamp", "", "getLastMoveEventTimeStamp$ui_release", "setLastMoveEventTimeStamp$ui_release", "strategy", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "getStrategy$annotations", "xVelocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "yVelocityTracker", "addPosition", "", "timeMillis", "position", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "maximumVelocity", "calculateVelocity-AH228Gc", "(J)J", "resetTracking", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VelocityTracker {

    public static final int $stable = 8;
    private long currentPointerPositionAccumulator;
    private long lastMoveEventTimeStamp;
    private final androidx.compose.ui.input.pointer.util.VelocityTracker1D.Strategy strategy;
    private final androidx.compose.ui.input.pointer.util.VelocityTracker1D xVelocityTracker;
    private final androidx.compose.ui.input.pointer.util.VelocityTracker1D yVelocityTracker;
    static {
        final int i = 8;
    }

    public VelocityTracker() {
        androidx.compose.ui.input.pointer.util.VelocityTracker1D.Strategy impulse;
        super();
        impulse = VelocityTrackerKt.getVelocityTrackerStrategyUseImpulse() ? VelocityTracker1D.Strategy.Impulse : VelocityTracker1D.Strategy.Lsq2;
        this.strategy = impulse;
        final int i = 0;
        final int i2 = 1;
        final int i3 = 0;
        VelocityTracker1D velocityTracker1D = new VelocityTracker1D(i, this.strategy, i2, i3);
        this.xVelocityTracker = velocityTracker1D;
        VelocityTracker1D velocityTracker1D2 = new VelocityTracker1D(i, this.strategy, i2, i3);
        this.yVelocityTracker = velocityTracker1D2;
        this.currentPointerPositionAccumulator = Offset.Companion.getZero-F1C5BW0();
    }

    private static void getStrategy$annotations() {
    }

    public final void addPosition-Uv8p0NA(long timeMillis, long position) {
        this.xVelocityTracker.addDataPoint(timeMillis, position);
        this.yVelocityTracker.addDataPoint(timeMillis, position);
    }

    public final long calculateVelocity-9UxMQ8M() {
        int i = 2139095039;
        return calculateVelocity-AH228Gc(VelocityKt.Velocity(i, i));
    }

    public final long calculateVelocity-AH228Gc(long maximumVelocity) {
        int cmp;
        int i;
        String string;
        StringBuilder append;
        String string-impl;
        int i2 = 0;
        if (Float.compare(x-impl, i2) > 0 && Float.compare(y-impl, i2) > 0) {
            i = Float.compare(y-impl, i2) > 0 ? 1 : 0;
        } else {
        }
        int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("maximumVelocity should be a positive value. You specified=").append(Velocity.toString-impl(maximumVelocity)).toString());
        }
        return VelocityKt.Velocity(this.xVelocityTracker.calculateVelocity(Velocity.getX-impl(maximumVelocity)), this.yVelocityTracker.calculateVelocity(Velocity.getY-impl(maximumVelocity)));
    }

    public final long getCurrentPointerPositionAccumulator-F1C5BW0$ui_release() {
        return this.currentPointerPositionAccumulator;
    }

    public final long getLastMoveEventTimeStamp$ui_release() {
        return this.lastMoveEventTimeStamp;
    }

    public final void resetTracking() {
        this.xVelocityTracker.resetTracking();
        this.yVelocityTracker.resetTracking();
        this.lastMoveEventTimeStamp = 0;
    }

    public final void setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release(long <set-?>) {
        this.currentPointerPositionAccumulator = <set-?>;
    }

    public final void setLastMoveEventTimeStamp$ui_release(long <set-?>) {
        this.lastMoveEventTimeStamp = <set-?>;
    }
}
