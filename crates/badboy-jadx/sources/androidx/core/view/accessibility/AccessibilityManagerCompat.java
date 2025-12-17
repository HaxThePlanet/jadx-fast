package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import androidx.annotation.ReplaceWith;
import java.util.List;

/* loaded from: classes5.dex */
public final class AccessibilityManagerCompat {

    @Deprecated
    public interface AccessibilityStateChangeListener {
        @Deprecated
        public abstract void onAccessibilityStateChanged(boolean z);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements androidx.core.view.accessibility.AccessibilityManagerCompat.AccessibilityStateChangeListener {
    }

    private static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {

        androidx.core.view.accessibility.AccessibilityManagerCompat.AccessibilityStateChangeListener mListener;
        AccessibilityStateChangeListenerWrapper(androidx.core.view.accessibility.AccessibilityManagerCompat.AccessibilityStateChangeListener listener) {
            super();
            this.mListener = listener;
        }

        @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
        public boolean equals(Object o) {
            if (this == o) {
                return 1;
            }
            if (!o instanceof AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper) {
                return 0;
            }
            return this.mListener.equals(obj.mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean enabled) {
            this.mListener.onAccessibilityStateChanged(enabled);
        }
    }

    static class Api34Impl {
        static boolean isRequestFromAccessibilityTool(AccessibilityManager accessibilityManager) {
            return accessibilityManager.isRequestFromAccessibilityTool();
        }
    }

    public interface TouchExplorationStateChangeListener {
        public abstract void onTouchExplorationStateChanged(boolean z);
    }

    private static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {

        final androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener mListener;
        TouchExplorationStateChangeListenerWrapper(androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener listener) {
            super();
            this.mListener = listener;
        }

        @Override // android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
        public boolean equals(Object o) {
            if (this == o) {
                return 1;
            }
            if (!o instanceof AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper) {
                return 0;
            }
            return this.mListener.equals(obj.mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
        public int hashCode() {
            return this.mListener.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean enabled) {
            this.mListener.onTouchExplorationStateChanged(enabled);
        }
    }
    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager manager, androidx.core.view.accessibility.AccessibilityManagerCompat.AccessibilityStateChangeListener listener) {
        if (listener == null) {
            return 0;
        }
        AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper accessibilityStateChangeListenerWrapper = new AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper(listener);
        return manager.addAccessibilityStateChangeListener(accessibilityStateChangeListenerWrapper);
    }

    @ReplaceWith(expression = "manager.addTouchExplorationStateChangeListener(listener)")
    @Deprecated
    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager manager, androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener listener) {
        AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper touchExplorationStateChangeListenerWrapper = new AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper(listener);
        return manager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListenerWrapper);
    }

    @ReplaceWith(expression = "manager.getEnabledAccessibilityServiceList(feedbackTypeFlags)")
    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager manager, int feedbackTypeFlags) {
        return manager.getEnabledAccessibilityServiceList(feedbackTypeFlags);
    }

    @ReplaceWith(expression = "manager.getInstalledAccessibilityServiceList()")
    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager manager) {
        return manager.getInstalledAccessibilityServiceList();
    }

    public static boolean isRequestFromAccessibilityTool(AccessibilityManager manager) {
        if (Build.VERSION.SDK_INT >= 34) {
            return AccessibilityManagerCompat.Api34Impl.isRequestFromAccessibilityTool(manager);
        }
        return 1;
    }

    @ReplaceWith(expression = "manager.isTouchExplorationEnabled()")
    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager manager) {
        return manager.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager manager, androidx.core.view.accessibility.AccessibilityManagerCompat.AccessibilityStateChangeListener listener) {
        if (listener == null) {
            return 0;
        }
        AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper accessibilityStateChangeListenerWrapper = new AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper(listener);
        return manager.removeAccessibilityStateChangeListener(accessibilityStateChangeListenerWrapper);
    }

    @ReplaceWith(expression = "manager.removeTouchExplorationStateChangeListener(listener)")
    @Deprecated
    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager manager, androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener listener) {
        AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper touchExplorationStateChangeListenerWrapper = new AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper(listener);
        return manager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListenerWrapper);
    }
}
