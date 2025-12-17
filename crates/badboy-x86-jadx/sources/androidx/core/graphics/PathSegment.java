package androidx.core.graphics;

import android.graphics.PointF;
import androidx.core.util.Preconditions;

/* loaded from: classes5.dex */
public final class PathSegment {

    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;
    public PathSegment(PointF start, float startFraction, PointF end, float endFraction) {
        super();
        this.mStart = (PointF)Preconditions.checkNotNull(start, "start == null");
        this.mStartFraction = startFraction;
        this.mEnd = (PointF)Preconditions.checkNotNull(end, "end == null");
        this.mEndFraction = endFraction;
    }

    public boolean equals(Object o) {
        int i;
        int compare;
        float mStartFraction;
        if (this == o) {
            return 1;
        }
        final int i2 = 0;
        if (!o instanceof PathSegment) {
            return i2;
        }
        Object obj = o;
        if (Float.compare(this.mStartFraction, obj.mStartFraction) == 0 && Float.compare(this.mEndFraction, obj.mEndFraction) == 0 && this.mStart.equals(obj.mStart) && this.mEnd.equals(obj.mEnd)) {
            if (Float.compare(this.mEndFraction, obj.mEndFraction) == 0) {
                if (this.mStart.equals(obj.mStart)) {
                    if (this.mEnd.equals(obj.mEnd)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        int floatToIntBits2;
        int mEndFraction;
        int floatToIntBits;
        final int i7 = 0;
        if (Float.compare(mStartFraction, i7) != 0) {
            floatToIntBits2 = Float.floatToIntBits(this.mStartFraction);
        } else {
            floatToIntBits2 = floatToIntBits;
        }
        if (Float.compare(mEndFraction2, i7) != 0) {
            floatToIntBits = Float.floatToIntBits(this.mEndFraction);
        }
        return result2 += floatToIntBits;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PathSegment{start=").append(this.mStart).append(", startFraction=").append(this.mStartFraction).append(", end=").append(this.mEnd).append(", endFraction=").append(this.mEndFraction).append('}').toString();
    }
}
