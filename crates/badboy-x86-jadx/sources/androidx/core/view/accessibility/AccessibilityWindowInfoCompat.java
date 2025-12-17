package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.os.LocaleListCompat;

/* loaded from: classes5.dex */
public class AccessibilityWindowInfoCompat {

    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_MAGNIFICATION_OVERLAY = 6;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    private static class Api21Impl {
        static void getBoundsInScreen(AccessibilityWindowInfo info, Rect outBounds) {
            info.getBoundsInScreen(outBounds);
        }

        static AccessibilityWindowInfo getChild(AccessibilityWindowInfo info, int index) {
            return info.getChild(index);
        }

        static int getChildCount(AccessibilityWindowInfo info) {
            return info.getChildCount();
        }

        static int getId(AccessibilityWindowInfo info) {
            return info.getId();
        }

        static int getLayer(AccessibilityWindowInfo info) {
            return info.getLayer();
        }

        static AccessibilityWindowInfo getParent(AccessibilityWindowInfo info) {
            return info.getParent();
        }

        static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo info) {
            return info.getRoot();
        }

        static int getType(AccessibilityWindowInfo info) {
            return info.getType();
        }

        static boolean isAccessibilityFocused(AccessibilityWindowInfo info) {
            return info.isAccessibilityFocused();
        }

        static boolean isActive(AccessibilityWindowInfo info) {
            return info.isActive();
        }

        static boolean isFocused(AccessibilityWindowInfo info) {
            return info.isFocused();
        }

        static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        static AccessibilityWindowInfo obtain(AccessibilityWindowInfo info) {
            return AccessibilityWindowInfo.obtain(info);
        }
    }

    private static class Api24Impl {
        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo info) {
            return info.getAnchor();
        }

        static java.lang.CharSequence getTitle(AccessibilityWindowInfo info) {
            return info.getTitle();
        }
    }

    private static class Api26Impl {
        static boolean isInPictureInPictureMode(AccessibilityWindowInfo info) {
            return info.isInPictureInPictureMode();
        }
    }

    private static class Api30Impl {
        static AccessibilityWindowInfo instantiateAccessibilityWindowInfo() {
            AccessibilityWindowInfo accessibilityWindowInfo = new AccessibilityWindowInfo();
            return accessibilityWindowInfo;
        }
    }

    private static class Api33Impl {
        static int getDisplayId(AccessibilityWindowInfo info) {
            return info.getDisplayId();
        }

        static void getRegionInScreen(AccessibilityWindowInfo info, Region outRegion) {
            info.getRegionInScreen(outRegion);
        }

        public static androidx.core.view.accessibility.AccessibilityNodeInfoCompat getRoot(Object info, int prefetchingStrategy) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance((AccessibilityWindowInfo)info.getRoot(prefetchingStrategy));
        }
    }

    private static class Api34Impl {
        static LocaleList getLocales(AccessibilityWindowInfo info) {
            return info.getLocales();
        }

        public static long getTransitionTimeMillis(AccessibilityWindowInfo info) {
            return info.getTransitionTimeMillis();
        }
    }
    public AccessibilityWindowInfoCompat() {
        AccessibilityWindowInfo instantiateAccessibilityWindowInfo;
        super();
        if (Build.VERSION.SDK_INT >= 30) {
            this.mInfo = AccessibilityWindowInfoCompat.Api30Impl.instantiateAccessibilityWindowInfo();
        } else {
            this.mInfo = 0;
        }
    }

    private AccessibilityWindowInfoCompat(Object info) {
        super();
        this.mInfo = info;
    }

    public static androidx.core.view.accessibility.AccessibilityWindowInfoCompat obtain() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.Api21Impl.obtain());
    }

    public static androidx.core.view.accessibility.AccessibilityWindowInfoCompat obtain(androidx.core.view.accessibility.AccessibilityWindowInfoCompat info) {
        int wrapNonNullInstance;
        if (info == null) {
            wrapNonNullInstance = 0;
        } else {
            wrapNonNullInstance = AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.Api21Impl.obtain((AccessibilityWindowInfo)info.mInfo));
        }
        return wrapNonNullInstance;
    }

    private static String typeToString(int type) {
        switch (type) {
            case 1:
                return "TYPE_APPLICATION";
            case 2:
                return "TYPE_INPUT_METHOD";
            case 3:
                return "TYPE_SYSTEM";
            case 4:
                return "TYPE_ACCESSIBILITY_OVERLAY";
            default:
                return "<UNKNOWN>";
        }
    }

    static androidx.core.view.accessibility.AccessibilityWindowInfoCompat wrapNonNullInstance(Object object) {
        if (object != null) {
            AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = new AccessibilityWindowInfoCompat(object);
            return accessibilityWindowInfoCompat;
        }
        return null;
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return 1;
        }
        int i2 = 0;
        if (obj == null) {
            return i2;
        }
        if (!obj instanceof AccessibilityWindowInfoCompat) {
            return i2;
        }
        Object obj2 = obj;
        if (this.mInfo == null) {
            if (obj2.mInfo == null) {
            } else {
                i = i2;
            }
            return i;
        }
        return this.mInfo.equals(obj2.mInfo);
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getAnchor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.Api24Impl.getAnchor((AccessibilityWindowInfo)this.mInfo));
    }

    public void getBoundsInScreen(Rect outBounds) {
        AccessibilityWindowInfoCompat.Api21Impl.getBoundsInScreen((AccessibilityWindowInfo)this.mInfo, outBounds);
    }

    public androidx.core.view.accessibility.AccessibilityWindowInfoCompat getChild(int index) {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.Api21Impl.getChild((AccessibilityWindowInfo)this.mInfo, index));
    }

    public int getChildCount() {
        return AccessibilityWindowInfoCompat.Api21Impl.getChildCount((AccessibilityWindowInfo)this.mInfo);
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) {
            return AccessibilityWindowInfoCompat.Api33Impl.getDisplayId((AccessibilityWindowInfo)this.mInfo);
        }
        return 0;
    }

    public int getId() {
        return AccessibilityWindowInfoCompat.Api21Impl.getId((AccessibilityWindowInfo)this.mInfo);
    }

    public int getLayer() {
        return AccessibilityWindowInfoCompat.Api21Impl.getLayer((AccessibilityWindowInfo)this.mInfo);
    }

    public LocaleListCompat getLocales() {
        if (Build.VERSION.SDK_INT >= 34) {
            return LocaleListCompat.wrap(AccessibilityWindowInfoCompat.Api34Impl.getLocales((AccessibilityWindowInfo)this.mInfo));
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    public androidx.core.view.accessibility.AccessibilityWindowInfoCompat getParent() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.Api21Impl.getParent((AccessibilityWindowInfo)this.mInfo));
    }

    public void getRegionInScreen(Region outRegion) {
        Object mInfo2;
        int mInfo;
        if (Build.VERSION.SDK_INT >= 33) {
            AccessibilityWindowInfoCompat.Api33Impl.getRegionInScreen((AccessibilityWindowInfo)this.mInfo, outRegion);
        } else {
            mInfo2 = new Rect();
            AccessibilityWindowInfoCompat.Api21Impl.getBoundsInScreen((AccessibilityWindowInfo)this.mInfo, mInfo2);
            outRegion.set(mInfo2);
        }
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityWindowInfoCompat.Api21Impl.getRoot((AccessibilityWindowInfo)this.mInfo));
    }

    public androidx.core.view.accessibility.AccessibilityNodeInfoCompat getRoot(int prefetchingStrategy) {
        if (Build.VERSION.SDK_INT >= 33) {
            return AccessibilityWindowInfoCompat.Api33Impl.getRoot(this.mInfo, prefetchingStrategy);
        }
        return getRoot();
    }

    public java.lang.CharSequence getTitle() {
        return AccessibilityWindowInfoCompat.Api24Impl.getTitle((AccessibilityWindowInfo)this.mInfo);
    }

    public long getTransitionTimeMillis() {
        if (Build.VERSION.SDK_INT >= 34) {
            return AccessibilityWindowInfoCompat.Api34Impl.getTransitionTimeMillis((AccessibilityWindowInfo)this.mInfo);
        }
        return 0;
    }

    public int getType() {
        return AccessibilityWindowInfoCompat.Api21Impl.getType((AccessibilityWindowInfo)this.mInfo);
    }

    public int hashCode() {
        int i;
        if (this.mInfo == null) {
            i = 0;
        } else {
            i = this.mInfo.hashCode();
        }
        return i;
    }

    public boolean isAccessibilityFocused() {
        return AccessibilityWindowInfoCompat.Api21Impl.isAccessibilityFocused((AccessibilityWindowInfo)this.mInfo);
    }

    public boolean isActive() {
        return AccessibilityWindowInfoCompat.Api21Impl.isActive((AccessibilityWindowInfo)this.mInfo);
    }

    public boolean isFocused() {
        return AccessibilityWindowInfoCompat.Api21Impl.isFocused((AccessibilityWindowInfo)this.mInfo);
    }

    public boolean isInPictureInPictureMode() {
        return AccessibilityWindowInfoCompat.Api26Impl.isInPictureInPictureMode((AccessibilityWindowInfo)this.mInfo);
    }

    @Deprecated
    public void recycle() {
    }

    public String toString() {
        int i;
        int i2;
        StringBuilder stringBuilder = new StringBuilder();
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        stringBuilder.append("AccessibilityWindowInfo[");
        stringBuilder.append("id=").append(getId());
        stringBuilder.append(", type=").append(AccessibilityWindowInfoCompat.typeToString(getType()));
        stringBuilder.append(", layer=").append(getLayer());
        stringBuilder.append(", bounds=").append(rect);
        stringBuilder.append(", focused=").append(isFocused());
        stringBuilder.append(", active=").append(isActive());
        final int i4 = 0;
        i = getParent() != null ? i2 : i4;
        stringBuilder.append(", hasParent=").append(i);
        if (getChildCount() > 0) {
        } else {
            i2 = i4;
        }
        stringBuilder.append(", hasChildren=").append(i2);
        stringBuilder.append(", transitionTime=").append(getTransitionTimeMillis());
        stringBuilder.append(", locales=").append(getLocales());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public AccessibilityWindowInfo unwrap() {
        return (AccessibilityWindowInfo)this.mInfo;
    }
}
