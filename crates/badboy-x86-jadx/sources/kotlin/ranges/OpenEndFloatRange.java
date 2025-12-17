package kotlin.ranges;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002J\u0013\u0010\u000e\u001a\u00020\u000c2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u000cH\u0016J\u0018\u0010\u0014\u001a\u00020\u000c2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\t¨\u0006\u0019", d2 = {"Lkotlin/ranges/OpenEndFloatRange;", "Lkotlin/ranges/OpenEndRange;", "", "start", "endExclusive", "(FF)V", "_endExclusive", "_start", "getEndExclusive", "()Ljava/lang/Float;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "lessThanOrEquals", "a", "b", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class OpenEndFloatRange implements kotlin.ranges.OpenEndRange<Float> {

    private final float _endExclusive;
    private final float _start;
    public OpenEndFloatRange(float start, float endExclusive) {
        super();
        this._start = start;
        this._endExclusive = endExclusive;
    }

    private final boolean lessThanOrEquals(float a, float b) {
        int i;
        i = Float.compare(a, b) <= 0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean contains(float value) {
        int cmp;
        int i;
        if (Float.compare(value, _start) >= 0 && Float.compare(value, _endExclusive) < 0) {
            i = Float.compare(value, _endExclusive) < 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean contains(Comparable value) {
        return contains((Number)value.floatValue());
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean equals(Object other) {
        int empty;
        int i;
        int i2;
        float _endExclusive;
        i = 0;
        if (other instanceof OpenEndFloatRange) {
            i2 = 1;
            if (isEmpty()) {
                if (!(OpenEndFloatRange)other.isEmpty()) {
                    empty = Float.compare(_start, _endExclusive) == 0 ? i2 : i;
                    if (empty != 0) {
                        empty = Float.compare(_endExclusive2, _endExclusive) == 0 ? i2 : i;
                        if (empty != 0) {
                            i = i2;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.ranges.OpenEndRange
    public Comparable getEndExclusive() {
        return (Comparable)getEndExclusive();
    }

    @Override // kotlin.ranges.OpenEndRange
    public Float getEndExclusive() {
        return Float.valueOf(this._endExclusive);
    }

    @Override // kotlin.ranges.OpenEndRange
    public Comparable getStart() {
        return (Comparable)getStart();
    }

    @Override // kotlin.ranges.OpenEndRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    @Override // kotlin.ranges.OpenEndRange
    public int hashCode() {
        int i;
        int i2;
        if (isEmpty()) {
            i = -1;
        } else {
            i4 += i2;
        }
        return i;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        int i;
        i = Float.compare(_start, _endExclusive) >= 0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.ranges.OpenEndRange
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this._start).append("..<").append(this._endExclusive).toString();
    }
}
