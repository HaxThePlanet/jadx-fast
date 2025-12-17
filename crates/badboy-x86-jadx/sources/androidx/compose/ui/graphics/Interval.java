package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0017\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0086\u0002J\u0013\u0010\u0011\u001a\u00020\u000f2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\u000f2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000c¨\u0006\u0018", d2 = {"Landroidx/compose/ui/graphics/Interval;", "T", "", "start", "", "end", "data", "(FFLjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getEnd", "()F", "getStart", "contains", "", "value", "equals", "other", "hashCode", "", "overlaps", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Interval<T>  {

    private final T data;
    private final float end;
    private final float start;
    public Interval(float start, float end, T data) {
        super();
        this.start = start;
        this.end = end;
        this.data = data;
    }

    public Interval(float f, float f2, Object object3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(f, f2, obj3);
    }

    public final boolean contains(float value) {
        float start;
        int i;
        i = 0;
        if (Float.compare(value, end) <= 0 && Float.compare(start, value) <= 0) {
            if (Float.compare(start, value) <= 0) {
                i = 1;
            }
        }
        return i;
    }

    public boolean equals(Object other) {
        int i;
        int i2;
        Class class;
        Class class2;
        final int i3 = 1;
        if (this == other) {
            return i3;
        }
        final int i4 = 0;
        if (other != null) {
            if (getClass() != other.getClass()) {
            } else {
                Object obj = other;
                i = Float.compare(start, start2) == 0 ? i3 : i4;
                if (i == 0) {
                    return i4;
                }
                i2 = Float.compare(end, end2) == 0 ? i3 : i4;
                if (i2 == 0) {
                    return i4;
                }
                if (!Intrinsics.areEqual(this.data, obj4.data)) {
                    return i4;
                }
            }
            return i3;
        }
        return i4;
    }

    public final T getData() {
        return this.data;
    }

    public final float getEnd() {
        return this.end;
    }

    public final float getStart() {
        return this.start;
    }

    public int hashCode() {
        int i;
        Object data = this.data;
        if (data != null) {
            i = data.hashCode();
        } else {
            i = 0;
        }
        return result += i;
    }

    public final boolean overlaps(float start, float end) {
        int cmp;
        int i;
        if (Float.compare(start2, end) <= 0 && Float.compare(end2, start) >= 0) {
            i = Float.compare(end2, start) >= 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public final boolean overlaps(androidx.compose.ui.graphics.Interval<T> other) {
        int cmp;
        int i;
        float start;
        if (Float.compare(start2, start) <= 0 && Float.compare(end, start) >= 0) {
            i = Float.compare(end, start) >= 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Interval(start=").append(this.start).append(", end=").append(this.end).append(", data=").append(this.data).append(')').toString();
    }
}
