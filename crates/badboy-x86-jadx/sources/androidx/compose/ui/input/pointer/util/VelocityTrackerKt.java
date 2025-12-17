package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\u001a(\u0010\u0013\u001a\u000c\u0012\u0008\u0012\u00060\u0015j\u0002`\u00160\u00142\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0082\u0008¢\u0006\u0002\u0010\u0019\u001a(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0082\u0008\u001a2\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00012\u0008\u0008\u0002\u0010%\u001a\u00020\u0015H\u0000\u001a\u0012\u0010&\u001a\u00020'*\u00020(2\u0006\u0010)\u001a\u00020*\u001a\u0014\u0010+\u001a\u00020'*\u00020(2\u0006\u0010)\u001a\u00020*H\u0002\u001a\u0014\u0010,\u001a\u00020'*\u00020(2\u0006\u0010)\u001a\u00020*H\u0002\u001a\u0014\u0010-\u001a\u00020\u0003*\u00020\u00152\u0006\u0010.\u001a\u00020\u0015H\u0002\u001a,\u0010/\u001a\u00020\u0003*\u000c\u0012\u0004\u0012\u00020\u00150\u0014j\u0002`02\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u0001H\u0082\n¢\u0006\u0002\u00103\u001a\r\u00104\u001a\u00020\u0003*\u00020\u0015H\u0082\u0008\u001a4\u00105\u001a\u00020'*\u000c\u0012\u0004\u0012\u00020\u00150\u0014j\u0002`02\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u0003H\u0082\n¢\u0006\u0002\u00107\u001a1\u00105\u001a\u00020'*\n\u0012\u0006\u0012\u0004\u0018\u0001080\u00142\u0006\u00109\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010<\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\",\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e\",\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0010\u0010\n\u001a\u0004\u0008\u0011\u0010\u000c\"\u0004\u0008\u0012\u0010\u000e*\u0018\u0008\u0002\u0010\u0013\"\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0008\u0012\u0004\u0012\u00020\u00150\u0014*\u000c\u0008\u0002\u0010=\"\u00020\u00152\u00020\u0015¨\u0006>", d2 = {"AssumePointerMoveStoppedMilliseconds", "", "DefaultWeight", "", "HistorySize", "HorizonMilliseconds", "<set-?>", "", "VelocityTrackerAddPointsFix", "getVelocityTrackerAddPointsFix$annotations", "()V", "getVelocityTrackerAddPointsFix", "()Z", "setVelocityTrackerAddPointsFix", "(Z)V", "VelocityTrackerStrategyUseImpulse", "getVelocityTrackerStrategyUseImpulse$annotations", "getVelocityTrackerStrategyUseImpulse", "setVelocityTrackerStrategyUseImpulse", "Matrix", "", "", "Landroidx/compose/ui/input/pointer/util/Vector;", "rows", "cols", "(II)[[F", "calculateImpulseVelocity", "dataPoints", "time", "sampleCount", "isDataDifferential", "kineticEnergyToVelocity", "kineticEnergy", "polyFitLeastSquares", "x", "y", "degree", "coefficients", "addPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "addPointerInputChangeLegacy", "addPointerInputChangeWithFix", "dot", "a", "get", "Landroidx/compose/ui/input/pointer/util/Matrix;", "row", "col", "([[FII)F", "norm", "set", "value", "([[FIIF)V", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "", "dataPoint", "([Landroidx/compose/ui/input/pointer/util/DataPointAtTime;IJF)V", "Vector", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VelocityTrackerKt {

    private static final int AssumePointerMoveStoppedMilliseconds = 40;
    private static final float DefaultWeight = 1f;
    private static final int HistorySize = 20;
    private static final int HorizonMilliseconds = 100;
    private static boolean VelocityTrackerAddPointsFix;
    private static boolean VelocityTrackerStrategyUseImpulse;
    static {
        VelocityTrackerKt.VelocityTrackerAddPointsFix = true;
    }

    private static final float[][] Matrix(int rows, int cols) {
        int i;
        float[] fArr;
        final int i2 = 0;
        final float[][] fArr2 = new float[rows];
        i = 0;
        while (i < rows) {
            fArr2[i] = new float[cols];
            i++;
        }
        return fArr2;
    }

    public static final float access$calculateImpulseVelocity(float[] dataPoints, float[] time, int sampleCount, boolean isDataDifferential) {
        return VelocityTrackerKt.calculateImpulseVelocity(dataPoints, time, sampleCount, isDataDifferential);
    }

    public static final void access$set(androidx.compose.ui.input.pointer.util.DataPointAtTime[] $receiver, int index, long time, float dataPoint) {
        VelocityTrackerKt.set($receiver, index, time, dataPoint);
    }

    public static final void addPointerInputChange(androidx.compose.ui.input.pointer.util.VelocityTracker $this$addPointerInputChange, PointerInputChange event) {
        if (VelocityTrackerKt.VelocityTrackerAddPointsFix) {
            VelocityTrackerKt.addPointerInputChangeWithFix($this$addPointerInputChange, event);
        } else {
            VelocityTrackerKt.addPointerInputChangeLegacy($this$addPointerInputChange, event);
        }
    }

    private static final void addPointerInputChangeLegacy(androidx.compose.ui.input.pointer.util.VelocityTracker $this$addPointerInputChangeLegacy, PointerInputChange event) {
        boolean changedToDownIgnoreConsumed;
        long previousPointerPosition;
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        long minus-MK-Hz9U;
        long uptimeMillis;
        long currentPointerPositionAccumulator-F1C5BW0$ui_release;
        final Object obj3 = $this$addPointerInputChangeLegacy;
        if (PointerEventKt.changedToDownIgnoreConsumed(event)) {
            obj3.setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release(event.getPosition-F1C5BW0());
            obj3.resetTracking();
        }
        int i2 = 0;
        previousPointerPosition = event.getPreviousPosition-F1C5BW0();
        List historical = event.getHistorical();
        final int i3 = 0;
        index$iv = 0;
        final int size = historical.size();
        while (index$iv < size) {
            obj2 = obj;
            i = 0;
            previousPointerPosition = obj2.getPosition-F1C5BW0();
            obj3.setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release(Offset.plus-MK-Hz9U(obj3.getCurrentPointerPositionAccumulator-F1C5BW0$ui_release(), obj13));
            obj3.addPosition-Uv8p0NA(obj2.getUptimeMillis(), obj13);
            index$iv++;
        }
        obj3.setCurrentPointerPositionAccumulator-k-4lQ0M$ui_release(Offset.plus-MK-Hz9U(obj3.getCurrentPointerPositionAccumulator-F1C5BW0$ui_release(), size));
        obj3.addPosition-Uv8p0NA(event.getUptimeMillis(), size);
    }

    private static final void addPointerInputChangeWithFix(androidx.compose.ui.input.pointer.util.VelocityTracker $this$addPointerInputChangeWithFix, PointerInputChange event) {
        boolean changedToUpIgnoreConsumed;
        boolean changedToUpIgnoreConsumed2;
        int i;
        long originalEventPosition-F1C5BW0$ui_release2;
        int index$iv;
        int size;
        Object obj;
        Object obj2;
        int i2;
        long uptimeMillis;
        long originalEventPosition-F1C5BW0$ui_release;
        if (PointerEventKt.changedToDownIgnoreConsumed(event)) {
            $this$addPointerInputChangeWithFix.resetTracking();
        }
        if (!PointerEventKt.changedToUpIgnoreConsumed(event)) {
            List historical = event.getHistorical();
            index$iv = 0;
            size = historical.size();
            while (index$iv < size) {
                obj2 = obj;
                i2 = 0;
                $this$addPointerInputChangeWithFix.addPosition-Uv8p0NA((HistoricalChange)obj2.getUptimeMillis(), obj8);
                index$iv++;
            }
            $this$addPointerInputChangeWithFix.addPosition-Uv8p0NA(event.getUptimeMillis(), 0);
        }
        if (PointerEventKt.changedToUpIgnoreConsumed(event) && Long.compare(i3, originalEventPosition-F1C5BW0$ui_release2) > 0) {
            if (Long.compare(i3, originalEventPosition-F1C5BW0$ui_release2) > 0) {
                $this$addPointerInputChangeWithFix.resetTracking();
            }
        }
        $this$addPointerInputChangeWithFix.setLastMoveEventTimeStamp$ui_release(event.getUptimeMillis());
    }

    private static final float calculateImpulseVelocity(float[] dataPoints, float[] time, int sampleCount, boolean isDataDifferential) {
        int work;
        int nextTime;
        int i;
        int i4;
        int i2;
        int i6;
        int i5;
        float f;
        int i3;
        double sqrt;
        work = 0;
        final int i7 = sampleCount + -1;
        nextTime = time[i7];
        i = i7;
        i4 = 2;
        while (i > 0) {
            i2 = nextTime;
            nextTime = time[i + -1];
            if (Float.compare(i2, nextTime) == 0) {
            } else {
            }
            i6 = 0;
            if (i6 != 0) {
            } else {
            }
            if (isDataDifferential) {
            } else {
            }
            i14 -= i5;
            i5 = i6 / i17;
            int i19 = 0;
            if (i == i7) {
            }
            i--;
            i4 = 2;
            work *= i4;
            i6 = -i16;
            i6 = 1;
        }
        int i8 = 0;
        return signum *= f5;
    }

    private static final float dot(float[] $this$dot, float[] a) {
        int result;
        int i3;
        int i2;
        int i;
        result = 0;
        i3 = 0;
        while (i3 < $this$dot.length) {
            result += i2;
            i3++;
        }
        return result;
    }

    private static final float get(float[][] $this$get, int row, int col) {
        final int i = 0;
        return $this$get[row][col];
    }

    public static final boolean getVelocityTrackerAddPointsFix() {
        return VelocityTrackerKt.VelocityTrackerAddPointsFix;
    }

    public static void getVelocityTrackerAddPointsFix$annotations() {
    }

    public static final boolean getVelocityTrackerStrategyUseImpulse() {
        return VelocityTrackerKt.VelocityTrackerStrategyUseImpulse;
    }

    public static void getVelocityTrackerStrategyUseImpulse$annotations() {
    }

    private static final float kineticEnergyToVelocity(float kineticEnergy) {
        final int i = 0;
        final float f3 = Math.abs(kineticEnergy);
        return signum *= f2;
    }

    private static final float norm(float[] $this$norm) {
        final int i = 0;
        return (float)sqrt;
    }

    public static final float[] polyFitLeastSquares(float[] x, float[] y, int sampleCount, int degree, float[] coefficients) {
        int str;
        int i5;
        int h3;
        int j;
        int i3;
        int row$iv;
        float[] fArr;
        int i4;
        float[][] fArr3;
        int c;
        int h;
        int i6;
        int $this$norm$iv;
        int h2;
        float[] fArr2;
        int j2;
        int i7;
        float f;
        int h4;
        int i2;
        int i;
        final int i8 = sampleCount;
        final int i9 = degree;
        if (i9 < 1) {
            InlineClassHelperKt.throwIllegalArgumentException("The degree must be at positive integer");
        }
        if (i8 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("At least one point must be provided");
        }
        i5 = i9 >= i8 ? i8 + -1 : i9;
        final int i10 = sampleCount;
        final int i11 = i5 + 1;
        int i12 = 0;
        final float[][] fArr4 = new float[i11];
        int i14 = 0;
        row$iv = i14;
        while (row$iv < i11) {
            fArr4[row$iv] = new float[i10];
            row$iv++;
        }
        h3 = 0;
        while (h3 < i10) {
            h = 0;
            fArr4[0][h3] = 1065353216;
            row$iv = 1;
            while (row$iv < i11) {
                int i18 = 0;
                h = 0;
                fArr4[row$iv][h3] = row$iv2 *= $this$get$iv;
                row$iv++;
            }
            h3++;
            i18 = 0;
            h = 0;
            fArr4[row$iv][h3] = row$iv2 *= $this$get$iv;
            row$iv++;
        }
        int h5 = 0;
        float[][] fArr5 = new float[i11];
        i4 = i14;
        while (i4 < i11) {
            fArr5[i4] = new float[i10];
            i4++;
        }
        int i13 = 0;
        float[][] fArr6 = new float[i11];
        c = i14;
        while (c < i11) {
            fArr6[c] = new float[i11];
            c++;
        }
        j = 0;
        while (j < i11) {
            c = fArr5[j];
            ArraysKt.copyInto(fArr4[j], c, i14, i14, i10);
            i6 = 0;
            while (i6 < j) {
                fArr2 = fArr5[i6];
                h4 = 0;
                while (h4 < i10) {
                    c[h4] = i23 -= i;
                    h4++;
                }
                i6++;
                c[h4] = i23 -= i;
                h4++;
            }
            int i19 = c;
            int i20 = 0;
            f = (float)sqrt;
            int i21 = 0;
            if (Float.compare(f, $this$norm$iv) < 0) {
            } else {
            }
            $this$norm$iv = f;
            h2 = 0;
            while (h2 < i10) {
                c[h2] = i22 *= fArr2;
                h2++;
            }
            i7 = 0;
            while (i7 < i11) {
                if (i7 < j) {
                } else {
                }
                h4 = VelocityTrackerKt.dot(c, fArr4[i7]);
                fArr6[j][i7] = h4;
                i7++;
                h4 = 0;
            }
            j++;
            if (i7 < j) {
            } else {
            }
            h4 = VelocityTrackerKt.dot(c, fArr4[i7]);
            h[i7] = h4;
            i7++;
            h4 = 0;
            c[h2] = i22 *= fArr2;
            h2++;
            fArr2 = fArr5[i6];
            h4 = 0;
            while (h4 < i10) {
                c[h4] = i23 -= i;
                h4++;
            }
            i6++;
            c[h4] = i23 -= i;
            h4++;
        }
        i3 = i11 + -1;
        while (-1 < i3) {
            c = VelocityTrackerKt.dot(fArr5[i3], y);
            h = fArr6[i3];
            i7 = i3 + 1;
            if (i7 <= i11 + -1) {
            }
            coefficients[i3] = c / j4;
            i3--;
            c -= h4;
            while (j2 != i7) {
                j2--;
                c -= h4;
            }
            j2--;
        }
        return coefficients;
    }

    public static float[] polyFitLeastSquares$default(float[] fArr, float[] f2Arr2, int i3, int i4, float[] f5Arr5, int i6, Object object7) {
        float[] obj4;
        int obj5;
        if (i6 &= 16 != 0) {
            obj4 = new float[RangesKt.coerceAtLeast(i4 + 1, 0)];
        }
        return VelocityTrackerKt.polyFitLeastSquares(fArr, f2Arr2, i3, i4, obj4);
    }

    private static final void set(androidx.compose.ui.input.pointer.util.DataPointAtTime[] $this$set, int index, long time, float dataPoint) {
        androidx.compose.ui.input.pointer.util.DataPointAtTime dataPointAtTime;
        final Object obj = $this$set[index];
        if (obj == null) {
            dataPointAtTime = new DataPointAtTime(time, dataPoint, obj6);
            $this$set[index] = dataPointAtTime;
        } else {
            obj.setTime(time);
            obj.setDataPoint(obj6);
        }
    }

    private static final void set(float[][] $this$set, int row, int col, float value) {
        final int i = 0;
        $this$set[row][col] = value;
    }

    public static final void setVelocityTrackerAddPointsFix(boolean <set-?>) {
        VelocityTrackerKt.VelocityTrackerAddPointsFix = <set-?>;
    }

    public static final void setVelocityTrackerStrategyUseImpulse(boolean <set-?>) {
        VelocityTrackerKt.VelocityTrackerStrategyUseImpulse = <set-?>;
    }
}
