package androidx.core.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.ReplaceWith;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes5.dex */
public final class VelocityTrackerCompat {

    private static Map<VelocityTracker, androidx.core.view.VelocityTrackerFallback> sFallbackTrackers;

    private static class Api34Impl {
        static float getAxisVelocity(VelocityTracker velocityTracker, int axis) {
            return velocityTracker.getAxisVelocity(axis);
        }

        static float getAxisVelocity(VelocityTracker velocityTracker, int axis, int id) {
            return velocityTracker.getAxisVelocity(axis, id);
        }

        static boolean isAxisSupported(VelocityTracker velocityTracker, int axis) {
            return velocityTracker.isAxisSupported(axis);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VelocityTrackableMotionEventAxis {
    }
    static {
        WeakHashMap weakHashMap = new WeakHashMap();
        VelocityTrackerCompat.sFallbackTrackers = Collections.synchronizedMap(weakHashMap);
    }

    public static void addMovement(VelocityTracker tracker, MotionEvent event) {
        boolean sFallbackTrackers;
        int source;
        int velocityTrackerFallback;
        tracker.addMovement(event);
        if (Build.VERSION.SDK_INT >= 34) {
        }
        if (event.getSource() == 4194304 && !VelocityTrackerCompat.sFallbackTrackers.containsKey(tracker)) {
            if (!VelocityTrackerCompat.sFallbackTrackers.containsKey(tracker)) {
                velocityTrackerFallback = new VelocityTrackerFallback();
                VelocityTrackerCompat.sFallbackTrackers.put(tracker, velocityTrackerFallback);
            }
            (VelocityTrackerFallback)VelocityTrackerCompat.sFallbackTrackers.get(tracker).addMovement(event);
        }
    }

    public static void clear(VelocityTracker tracker) {
        tracker.clear();
        VelocityTrackerCompat.removeFallbackForTracker(tracker);
    }

    public static void computeCurrentVelocity(VelocityTracker tracker, int units) {
        VelocityTrackerCompat.computeCurrentVelocity(tracker, units, 2139095039);
    }

    public static void computeCurrentVelocity(VelocityTracker tracker, int units, float maxVelocity) {
        tracker.computeCurrentVelocity(units, maxVelocity);
        final androidx.core.view.VelocityTrackerFallback fallbackTrackerOrNull = VelocityTrackerCompat.getFallbackTrackerOrNull(tracker);
        if (fallbackTrackerOrNull != null) {
            fallbackTrackerOrNull.computeCurrentVelocity(units, maxVelocity);
        }
    }

    public static float getAxisVelocity(VelocityTracker tracker, int axis) {
        if (Build.VERSION.SDK_INT >= 34) {
            return VelocityTrackerCompat.Api34Impl.getAxisVelocity(tracker, axis);
        }
        if (axis == 0) {
            return tracker.getXVelocity();
        }
        if (axis == 1) {
            return tracker.getYVelocity();
        }
        androidx.core.view.VelocityTrackerFallback fallbackTrackerOrNull = VelocityTrackerCompat.getFallbackTrackerOrNull(tracker);
        if (fallbackTrackerOrNull != null) {
            return fallbackTrackerOrNull.getAxisVelocity(axis);
        }
        return 0;
    }

    public static float getAxisVelocity(VelocityTracker tracker, int axis, int pointerId) {
        if (Build.VERSION.SDK_INT >= 34) {
            return VelocityTrackerCompat.Api34Impl.getAxisVelocity(tracker, axis, pointerId);
        }
        if (axis == 0) {
            return tracker.getXVelocity(pointerId);
        }
        if (axis == 1) {
            return tracker.getYVelocity(pointerId);
        }
        return 0;
    }

    private static androidx.core.view.VelocityTrackerFallback getFallbackTrackerOrNull(VelocityTracker tracker) {
        return (VelocityTrackerFallback)VelocityTrackerCompat.sFallbackTrackers.get(tracker);
    }

    @ReplaceWith(expression = "tracker.getXVelocity(pointerId)")
    @Deprecated
    public static float getXVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getXVelocity(pointerId);
    }

    @ReplaceWith(expression = "tracker.getYVelocity(pointerId)")
    @Deprecated
    public static float getYVelocity(VelocityTracker tracker, int pointerId) {
        return tracker.getYVelocity(pointerId);
    }

    public static boolean isAxisSupported(VelocityTracker tracker, int axis) {
        int i;
        if (Build.VERSION.SDK_INT >= 34) {
            return VelocityTrackerCompat.Api34Impl.isAxisSupported(tracker, axis);
        }
        if (axis != 26 && axis != 0) {
            if (axis != 0) {
                if (axis == 1) {
                } else {
                    i = 0;
                }
            }
        }
        return i;
    }

    public static void recycle(VelocityTracker tracker) {
        tracker.recycle();
        VelocityTrackerCompat.removeFallbackForTracker(tracker);
    }

    private static void removeFallbackForTracker(VelocityTracker tracker) {
        VelocityTrackerCompat.sFallbackTrackers.remove(tracker);
    }
}
