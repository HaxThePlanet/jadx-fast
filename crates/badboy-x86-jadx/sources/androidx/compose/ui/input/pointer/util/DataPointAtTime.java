package androidx.compose.ui.input.pointer.util;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006\u0019", d2 = {"Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "", "time", "", "dataPoint", "", "(JF)V", "getDataPoint", "()F", "setDataPoint", "(F)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DataPointAtTime {

    public static final int $stable = 8;
    private float dataPoint;
    private long time;
    static {
        final int i = 8;
    }

    public DataPointAtTime(long time, float dataPoint) {
        super();
        this.time = time;
        this.dataPoint = obj3;
    }

    public static androidx.compose.ui.input.pointer.util.DataPointAtTime copy$default(androidx.compose.ui.input.pointer.util.DataPointAtTime dataPointAtTime, long l2, float f3, int i4, Object object5) {
        long obj1;
        float obj3;
        if (object5 & 1 != 0) {
            obj1 = dataPointAtTime.time;
        }
        if (object5 &= 2 != 0) {
            obj3 = dataPointAtTime.dataPoint;
        }
        return dataPointAtTime.copy(obj1, f3);
    }

    public final long component1() {
        return this.time;
    }

    public final float component2() {
        return this.dataPoint;
    }

    public final androidx.compose.ui.input.pointer.util.DataPointAtTime copy(long l, float f2) {
        DataPointAtTime dataPointAtTime = new DataPointAtTime(l, f2, obj4);
        return dataPointAtTime;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DataPointAtTime) {
            return i2;
        }
        Object obj = object;
        if (Long.compare(time, time2) != 0) {
            return i2;
        }
        if (Float.compare(this.dataPoint, obj.dataPoint) != 0) {
            return i2;
        }
        return i;
    }

    public final float getDataPoint() {
        return this.dataPoint;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public final void setDataPoint(float <set-?>) {
        this.dataPoint = <set-?>;
    }

    public final void setTime(long <set-?>) {
        this.time = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DataPointAtTime(time=").append(this.time).append(", dataPoint=").append(this.dataPoint).append(')').toString();
    }
}
