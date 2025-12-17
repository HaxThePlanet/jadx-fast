package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes5.dex */
public class DifferentialMotionFlingController {

    private final Context mContext;
    private final int[] mFlingVelocityThresholds;
    private float mLastFlingVelocity;
    private int mLastProcessedAxis;
    private int mLastProcessedDeviceId;
    private int mLastProcessedSource;
    private final androidx.core.view.DifferentialMotionFlingTarget mTarget;
    private final androidx.core.view.DifferentialMotionFlingController.DifferentialVelocityProvider mVelocityProvider;
    private final androidx.core.view.DifferentialMotionFlingController.FlingVelocityThresholdCalculator mVelocityThresholdCalculator;
    private VelocityTracker mVelocityTracker;

    interface FlingVelocityThresholdCalculator {
        public abstract void calculateFlingVelocityThresholds(Context context, int[] i2Arr2, MotionEvent motionEvent3, int i4);
    }

    interface DifferentialVelocityProvider {
        public abstract float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent2, int i3);
    }
    public static void $r8$lambda$lv23FpWloyumz6IvnMabmJR9BpE(Context context, int[] i2Arr2, MotionEvent motionEvent3, int i4) {
        DifferentialMotionFlingController.calculateFlingVelocityThresholds(context, i2Arr2, motionEvent3, i4);
    }

    public static float $r8$lambda$rCNQ1h5KBIaVcUXhwymI_1638W0(VelocityTracker velocityTracker, MotionEvent motionEvent2, int i3) {
        return DifferentialMotionFlingController.getCurrentVelocity(velocityTracker, motionEvent2, i3);
    }

    public DifferentialMotionFlingController(Context context, androidx.core.view.DifferentialMotionFlingTarget target) {
        DifferentialMotionFlingController$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new DifferentialMotionFlingController$$ExternalSyntheticLambda0();
        DifferentialMotionFlingController$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new DifferentialMotionFlingController$$ExternalSyntheticLambda1();
        super(context, target, externalSyntheticLambda0, externalSyntheticLambda1);
    }

    DifferentialMotionFlingController(Context context, androidx.core.view.DifferentialMotionFlingTarget target, androidx.core.view.DifferentialMotionFlingController.FlingVelocityThresholdCalculator velocityThresholdCalculator, androidx.core.view.DifferentialMotionFlingController.DifferentialVelocityProvider velocityProvider) {
        super();
        int i = -1;
        this.mLastProcessedAxis = i;
        this.mLastProcessedSource = i;
        this.mLastProcessedDeviceId = i;
        this.mFlingVelocityThresholds = /* result */;
        this.mContext = context;
        this.mTarget = target;
        this.mVelocityThresholdCalculator = velocityThresholdCalculator;
        this.mVelocityProvider = velocityProvider;
    }

    private static void calculateFlingVelocityThresholds(Context context, int[] buffer, MotionEvent event, int axis) {
        final ViewConfiguration view = ViewConfiguration.get(context);
        buffer[0] = ViewConfigurationCompat.getScaledMinimumFlingVelocity(context, view, event.getDeviceId(), axis, event.getSource());
        buffer[1] = ViewConfigurationCompat.getScaledMaximumFlingVelocity(context, view, event.getDeviceId(), axis, event.getSource());
    }

    private boolean calculateFlingVelocityThresholds(MotionEvent event, int axis) {
        int mLastProcessedSource;
        final int source = event.getSource();
        final int deviceId = event.getDeviceId();
        if (this.mLastProcessedSource == source && this.mLastProcessedDeviceId == deviceId && this.mLastProcessedAxis != axis) {
            if (this.mLastProcessedDeviceId == deviceId) {
                if (this.mLastProcessedAxis != axis) {
                }
                return 0;
            }
        }
        this.mVelocityThresholdCalculator.calculateFlingVelocityThresholds(this.mContext, this.mFlingVelocityThresholds, event, axis);
        this.mLastProcessedSource = source;
        this.mLastProcessedDeviceId = deviceId;
        this.mLastProcessedAxis = axis;
        return 1;
    }

    private float getCurrentVelocity(MotionEvent event, int axis) {
        VelocityTracker mVelocityTracker;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        return this.mVelocityProvider.getCurrentVelocity(this.mVelocityTracker, event, axis);
    }

    private static float getCurrentVelocity(VelocityTracker vt, MotionEvent event, int axis) {
        VelocityTrackerCompat.addMovement(vt, event);
        VelocityTrackerCompat.computeCurrentVelocity(vt, 1000);
        return VelocityTrackerCompat.getAxisVelocity(vt, axis);
    }

    public void onMotionEvent(MotionEvent event, int axis) {
        VelocityTracker mVelocityTracker;
        int i;
        int mTarget;
        int i4 = 0;
        if (this.mFlingVelocityThresholds[i4] == Integer.MAX_VALUE && this.mVelocityTracker != null) {
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = 0;
            }
        }
        currentVelocity *= scaledScrollFactor;
        float signum = Math.signum(i3);
        if (!calculateFlingVelocityThresholds(event, axis)) {
            if (Float.compare(signum, signum2) != 0 && Float.compare(signum, i) != 0) {
                if (Float.compare(signum, i) != 0) {
                    this.mTarget.stopDifferentialMotionFling();
                }
            }
        } else {
        }
        if (Float.compare(f3, f) < 0) {
        }
        int i9 = 1;
        float scaledVelocity = Math.max((float)i7, Math.min(i3, (float)i10));
        if (this.mTarget.startDifferentialMotionFling(scaledVelocity)) {
            i = scaledVelocity;
        }
        this.mLastFlingVelocity = i;
    }
}
