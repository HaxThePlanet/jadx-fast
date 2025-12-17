package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0014\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\u0008\u0007\u0018\u00002\u00020\u0001:\u0001!B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0008\u0000\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0015R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "", "isDataDifferential", "", "(Z)V", "strategy", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "(ZLandroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;)V", "index", "", "()Z", "minSampleSize", "reusableDataPointsArray", "", "reusableTimeArray", "reusableVelocityCoefficients", "samples", "", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "[Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "addDataPoint", "", "timeMillis", "", "dataPoint", "", "calculateLeastSquaresVelocity", "dataPoints", "time", "sampleCount", "calculateVelocity", "maximumVelocity", "resetTracking", "Strategy", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VelocityTracker1D {

    public static final int $stable = 8;
    private int index;
    private final boolean isDataDifferential;
    private final int minSampleSize;
    private final float[] reusableDataPointsArray;
    private final float[] reusableTimeArray;
    private final float[] reusableVelocityCoefficients;
    private final androidx.compose.ui.input.pointer.util.DataPointAtTime[] samples;
    private final androidx.compose.ui.input.pointer.util.VelocityTracker1D.Strategy strategy;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0080\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "", "(Ljava/lang/String;I)V", "Lsq2", "Impulse", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum Strategy {

        Lsq2,
        Impulse;
        private static final androidx.compose.ui.input.pointer.util.VelocityTracker1D.Strategy[] $values() {
            return /* result */;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[VelocityTracker1D.Strategy.Impulse.ordinal()] = 1;
            iArr[VelocityTracker1D.Strategy.Lsq2.ordinal()] = 2;
            VelocityTracker1D.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 8;
    }

    public VelocityTracker1D() {
        final int i = 0;
        super(0, i, 3, i);
    }

    public VelocityTracker1D(boolean isDataDifferential) {
        super(isDataDifferential, VelocityTracker1D.Strategy.Impulse);
    }

    public VelocityTracker1D(boolean isDataDifferential, androidx.compose.ui.input.pointer.util.VelocityTracker1D.Strategy strategy) {
        boolean isDataDifferential2;
        int i;
        androidx.compose.ui.input.pointer.util.VelocityTracker1D.Strategy lsq2;
        super();
        this.isDataDifferential = isDataDifferential;
        this.strategy = strategy;
        if (this.isDataDifferential) {
            if (this.strategy.equals(VelocityTracker1D.Strategy.Lsq2)) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("Lsq2 not (yet) supported for differential axes");
            throw illegalStateException;
        }
        int i4 = 3;
        switch (i2) {
            case 1:
                i = 2;
                break;
            case 2:
                i = i4;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        this.minSampleSize = i;
        int i3 = 20;
        this.samples = new DataPointAtTime[i3];
        this.reusableDataPointsArray = new float[i3];
        this.reusableTimeArray = new float[i3];
        this.reusableVelocityCoefficients = new float[i4];
    }

    public VelocityTracker1D(boolean z, androidx.compose.ui.input.pointer.util.VelocityTracker1D.Strategy velocityTracker1D$Strategy2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        androidx.compose.ui.input.pointer.util.VelocityTracker1D.Strategy obj2;
        obj1 = i3 & 1 != 0 ? 0 : obj1;
        obj2 = i3 &= 2 != 0 ? VelocityTracker1D.Strategy.Lsq2 : obj2;
        super(obj1, obj2);
    }

    private final float calculateLeastSquaresVelocity(float[] dataPoints, float[] time, int sampleCount) {
        float f;
        int i;
        f = VelocityTrackerKt.polyFitLeastSquares(time, dataPoints, sampleCount, 2, this.reusableVelocityCoefficients)[1];
        return f;
    }

    public final void addDataPoint(long timeMillis, float dataPoint) {
        this.index = i %= 20;
        VelocityTrackerKt.access$set(this.samples, this.index, timeMillis, dataPoint);
    }

    public final float calculateVelocity() {
        int sampleCount;
        int index;
        float leastSquaresVelocity;
        androidx.compose.ui.input.pointer.util.DataPointAtTime previousSample;
        androidx.compose.ui.input.pointer.util.DataPointAtTime time;
        float f;
        float f2;
        int cmp;
        androidx.compose.ui.input.pointer.util.VelocityTracker1D.Strategy isDataDifferential;
        androidx.compose.ui.input.pointer.util.DataPointAtTime time2;
        int lsq2;
        final float[] reusableDataPointsArray = this.reusableDataPointsArray;
        final float[] reusableTimeArray = this.reusableTimeArray;
        sampleCount = 0;
        androidx.compose.ui.input.pointer.util.DataPointAtTime time3 = this.samples[this.index];
        int i = 0;
        if (time3 == null) {
            return i;
        }
        previousSample = time3;
        time = this.samples[index];
        while (time == null) {
            long time6 = time.getTime();
            f = (float)i5;
            if (this.strategy != VelocityTracker1D.Strategy.Lsq2) {
            } else {
            }
            time2 = time;
            previousSample = time2;
            reusableDataPointsArray[sampleCount] = time.getDataPoint();
            reusableTimeArray[sampleCount] = -f;
            cmp = 20;
            if (index == 0) {
            } else {
            }
            lsq2 = index;
            index = lsq2 + -1;
            time = this.samples[index];
            lsq2 = cmp;
            if (this.isDataDifferential) {
            } else {
            }
            time2 = time3;
        }
        if (sampleCount >= this.minSampleSize) {
            switch (i2) {
                case 1:
                    leastSquaresVelocity = VelocityTrackerKt.access$calculateImpulseVelocity(reusableDataPointsArray, reusableTimeArray, sampleCount, this.isDataDifferential);
                    break;
                case 2:
                    leastSquaresVelocity = calculateLeastSquaresVelocity(reusableDataPointsArray, reusableTimeArray, sampleCount);
                    break;
                default:
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
            }
            return leastSquaresVelocity *= f3;
        }
        return i;
    }

    public final float calculateVelocity(float maximumVelocity) {
        int coerceAtLeast;
        int i;
        int naN;
        String $i$a$CheckPreconditionVelocityTracker1D$calculateVelocity$1;
        StringBuilder append;
        String str;
        coerceAtLeast = 0;
        final int i3 = 0;
        i = Float.compare(maximumVelocity, coerceAtLeast) > 0 ? naN : i3;
        int i4 = 0;
        if (i == 0) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("maximumVelocity should be a positive value. You specified=").append(maximumVelocity).toString());
        }
        float velocity = calculateVelocity();
        if (Float.compare(velocity, coerceAtLeast) == 0) {
        } else {
            naN = i3;
        }
        if (naN == 0) {
            if (Float.isNaN(velocity)) {
            } else {
                if (Float.compare(velocity, coerceAtLeast) > 0) {
                    coerceAtLeast = RangesKt.coerceAtMost(velocity, maximumVelocity);
                } else {
                    coerceAtLeast = RangesKt.coerceAtLeast(velocity, -maximumVelocity);
                }
            }
        } else {
        }
        return coerceAtLeast;
    }

    public final boolean isDataDifferential() {
        return this.isDataDifferential;
    }

    public final void resetTracking() {
        ArraysKt.fill$default(this.samples, 0, 0, 0, 6, 0);
        this.index = 0;
    }
}
