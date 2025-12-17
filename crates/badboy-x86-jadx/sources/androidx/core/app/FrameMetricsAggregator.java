package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.Window;
import android.view.Window.OnFrameMetricsAvailableListener;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class FrameMetricsAggregator {

    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX;
    private final androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl mInstance;

    private static class FrameMetricsBaseImpl {
        public void add(Activity activity) {
        }

        public SparseIntArray[] getMetrics() {
            return null;
        }

        public SparseIntArray[] remove(Activity activity) {
            return null;
        }

        public SparseIntArray[] reset() {
            return null;
        }

        public SparseIntArray[] stop() {
            return null;
        }
    }

    private static class FrameMetricsApi24Impl extends androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl {

        private static final int NANOS_PER_MS = 1000000;
        private static final int NANOS_ROUNDING_VALUE = 500000;
        private static Handler sHandler;
        private static HandlerThread sHandlerThread;
        private final ArrayList<WeakReference<Activity>> mActivities;
        Window.OnFrameMetricsAvailableListener mListener;
        SparseIntArray[] mMetrics;
        int mTrackingFlags;
        static {
            final int i = 0;
            FrameMetricsAggregator.FrameMetricsApi24Impl.sHandlerThread = i;
            FrameMetricsAggregator.FrameMetricsApi24Impl.sHandler = i;
        }

        FrameMetricsApi24Impl(int trackingFlags) {
            super();
            this.mMetrics = new SparseIntArray[9];
            ArrayList arrayList = new ArrayList();
            this.mActivities = arrayList;
            FrameMetricsAggregator.FrameMetricsApi24Impl.1 anon = new FrameMetricsAggregator.FrameMetricsApi24Impl.1(this);
            this.mListener = anon;
            this.mTrackingFlags = trackingFlags;
        }

        @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
        public void add(Activity activity) {
            Object sHandlerThread;
            int i;
            android.os.Looper mMetrics;
            int sparseIntArray;
            if (FrameMetricsAggregator.FrameMetricsApi24Impl.sHandlerThread == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                FrameMetricsAggregator.FrameMetricsApi24Impl.sHandlerThread = handlerThread;
                FrameMetricsAggregator.FrameMetricsApi24Impl.sHandlerThread.start();
                sHandlerThread = new Handler(FrameMetricsAggregator.FrameMetricsApi24Impl.sHandlerThread.getLooper());
                FrameMetricsAggregator.FrameMetricsApi24Impl.sHandler = sHandlerThread;
            }
            i = 0;
            while (i <= 8) {
                if (this.mMetrics[i] == null && mTrackingFlags &= sparseIntArray != null) {
                }
                i++;
                if (mTrackingFlags &= sparseIntArray != null) {
                }
                sparseIntArray = new SparseIntArray();
                this.mMetrics[i] = sparseIntArray;
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, FrameMetricsAggregator.FrameMetricsApi24Impl.sHandler);
            WeakReference weakReference = new WeakReference(activity);
            this.mActivities.add(weakReference);
        }

        @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
        void addDurationItem(SparseIntArray buckets, long duration) {
            int i2;
            int cmp;
            int i;
            i2 = (int)i5;
            if (buckets != null && Long.compare(duration, i6) >= 0) {
                i2 = (int)i5;
                if (Long.compare(duration, i6) >= 0) {
                    buckets.put(i2, cmp + 1);
                }
            }
        }

        @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity activity) {
            Object mActivities;
            Object next;
            Object obj;
            mActivities = this.mActivities.iterator();
            while (mActivities.hasNext()) {
                next = mActivities.next();
                if ((WeakReference)next.get() == activity) {
                    break;
                } else {
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            this.mMetrics = new SparseIntArray[9];
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl
        public SparseIntArray[] stop() {
            int i;
            Object obj2;
            Object obj;
            Object mActivities;
            Window.OnFrameMetricsAvailableListener mListener;
            i = size + -1;
            while (i >= 0) {
                obj2 = this.mActivities.get(i);
                if (obj2.get() != null) {
                }
                i--;
                (Activity)(WeakReference)obj2.get().getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
                this.mActivities.remove(i);
            }
            return this.mMetrics;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MetricType {
    }
    public FrameMetricsAggregator() {
        super(1);
    }

    public FrameMetricsAggregator(int metricTypeFlags) {
        super();
        FrameMetricsAggregator.FrameMetricsApi24Impl frameMetricsApi24Impl = new FrameMetricsAggregator.FrameMetricsApi24Impl(metricTypeFlags);
        this.mInstance = frameMetricsApi24Impl;
    }

    public void add(Activity activity) {
        this.mInstance.add(activity);
    }

    public SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    public SparseIntArray[] remove(Activity activity) {
        return this.mInstance.remove(activity);
    }

    public SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    public SparseIntArray[] stop() {
        return this.mInstance.stop();
    }
}
