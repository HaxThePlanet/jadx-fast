package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes5.dex */
class VelocityTrackerFallback {

    private static final long ASSUME_POINTER_STOPPED_MS = 40L;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100L;
    private int mDataPointsBufferLastUsedIndex = 0;
    private int mDataPointsBufferSize = 0;
    private final long[] mEventTimes;
    private float mLastComputedVelocity = 0f;
    private final float[] mMovements;
    VelocityTrackerFallback() {
        super();
        int i = 20;
        this.mMovements = new float[i];
        this.mEventTimes = new long[i];
        int i2 = 0;
        int i3 = 0;
    }

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0;
    }

    private float getCurrentVelocity() {
        int firstValidIndex;
        int work;
        int numDataPointsProcessed;
        long[] mEventTimes;
        int i3;
        int i4;
        long l;
        int i6;
        int i5;
        int kineticEnergyToVelocity;
        float f2;
        int i;
        int i2;
        float f;
        final Object obj = this;
        int i9 = 0;
        int i11 = 2;
        if (obj.mDataPointsBufferSize < i11) {
            return i9;
        }
        final int i17 = 1;
        i8 %= 20;
        while (Long.compare(i4, i6) > 0) {
            obj.mDataPointsBufferSize = mDataPointsBufferSize3 -= i17;
            firstValidIndex = mEventTimes % 20;
        }
        if (obj.mDataPointsBufferSize < i11) {
            return i9;
        }
        i12 %= 20;
        if (obj.mDataPointsBufferSize == i11 && Long.compare(l2, l6) == 0) {
            i12 %= 20;
            if (Long.compare(l2, l6) == 0) {
                return i9;
            }
            return f3 /= f4;
        }
        work = 0;
        numDataPointsProcessed = 0;
        i3 = 0;
        while (i3 < mDataPointsBufferSize6 -= i17) {
            i4 = i3 + firstValidIndex;
            l = obj.mEventTimes[i4 % 20];
            i19 %= 20;
            if (Long.compare(l8, l) == 0) {
            } else {
            }
            i = f2 / f5;
            if (numDataPointsProcessed++ == i17) {
            }
            i3++;
            work *= i2;
        }
        return VelocityTrackerFallback.kineticEnergyToVelocity(work);
    }

    private static float kineticEnergyToVelocity(float work) {
        int i;
        i = Float.compare(work, i2) < 0 ? -1082130432 : 1065353216;
        f2 *= i4;
        return i *= f;
    }

    void addMovement(MotionEvent event) {
        int mDataPointsBufferSize;
        int mDataPointsBufferSize2;
        int mDataPointsBufferLastUsedIndex;
        int i;
        final long eventTime = event.getEventTime();
        if (this.mDataPointsBufferSize != 0 && Long.compare(i4, i) > 0) {
            if (Long.compare(i4, i) > 0) {
                clear();
            }
        }
        int i5 = 20;
        this.mDataPointsBufferLastUsedIndex = i2 %= i5;
        if (this.mDataPointsBufferSize != i5) {
            this.mDataPointsBufferSize = mDataPointsBufferSize3++;
        }
        this.mMovements[this.mDataPointsBufferLastUsedIndex] = event.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    void computeCurrentVelocity(int units) {
        computeCurrentVelocity(units, 2139095039);
    }

    void computeCurrentVelocity(int units, float maxVelocity) {
        int cmp;
        int i;
        this.mLastComputedVelocity = currentVelocity *= f2;
        if (Float.compare(mLastComputedVelocity, i) < 0) {
            this.mLastComputedVelocity = -f;
        } else {
            if (Float.compare(mLastComputedVelocity2, i) > 0) {
                this.mLastComputedVelocity = Math.abs(maxVelocity);
            }
        }
    }

    float getAxisVelocity(int axis) {
        if (axis != 26) {
            return 0;
        }
        return this.mLastComputedVelocity;
    }
}
