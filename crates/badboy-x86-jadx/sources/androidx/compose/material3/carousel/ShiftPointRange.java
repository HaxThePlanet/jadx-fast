package androidx.compose.material3.carousel;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u0017", d2 = {"Landroidx/compose/material3/carousel/ShiftPointRange;", "", "fromStepIndex", "", "toStepIndex", "steppedInterpolation", "", "(IIF)V", "getFromStepIndex", "()I", "getSteppedInterpolation", "()F", "getToStepIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ShiftPointRange {

    private final int fromStepIndex;
    private final float steppedInterpolation;
    private final int toStepIndex;
    public ShiftPointRange(int fromStepIndex, int toStepIndex, float steppedInterpolation) {
        super();
        this.fromStepIndex = fromStepIndex;
        this.toStepIndex = toStepIndex;
        this.steppedInterpolation = steppedInterpolation;
    }

    public static androidx.compose.material3.carousel.ShiftPointRange copy$default(androidx.compose.material3.carousel.ShiftPointRange shiftPointRange, int i2, int i3, float f4, int i5, Object object6) {
        int obj1;
        int obj2;
        float obj3;
        if (i5 & 1 != 0) {
            obj1 = shiftPointRange.fromStepIndex;
        }
        if (i5 & 2 != 0) {
            obj2 = shiftPointRange.toStepIndex;
        }
        if (i5 &= 4 != 0) {
            obj3 = shiftPointRange.steppedInterpolation;
        }
        return shiftPointRange.copy(obj1, obj2, obj3);
    }

    public final int component1() {
        return this.fromStepIndex;
    }

    public final int component2() {
        return this.toStepIndex;
    }

    public final float component3() {
        return this.steppedInterpolation;
    }

    public final androidx.compose.material3.carousel.ShiftPointRange copy(int i, int i2, float f3) {
        ShiftPointRange shiftPointRange = new ShiftPointRange(i, i2, f3);
        return shiftPointRange;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ShiftPointRange) {
            return i2;
        }
        Object obj = object;
        if (this.fromStepIndex != obj.fromStepIndex) {
            return i2;
        }
        if (this.toStepIndex != obj.toStepIndex) {
            return i2;
        }
        if (Float.compare(this.steppedInterpolation, obj.steppedInterpolation) != 0) {
            return i2;
        }
        return i;
    }

    public final int getFromStepIndex() {
        return this.fromStepIndex;
    }

    public final float getSteppedInterpolation() {
        return this.steppedInterpolation;
    }

    public final int getToStepIndex() {
        return this.toStepIndex;
    }

    public int hashCode() {
        return i2 += i7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ShiftPointRange(fromStepIndex=").append(this.fromStepIndex).append(", toStepIndex=").append(this.toStepIndex).append(", steppedInterpolation=").append(this.steppedInterpolation).append(')').toString();
    }
}
