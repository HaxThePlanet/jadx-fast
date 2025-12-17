package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import androidx.annotation.ReplaceWith;

/* loaded from: classes.dex */
public final class AccessibilityServiceInfoCompat {

    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    public static String capabilityToString(int capability) {
        switch (capability) {
            case 1:
                return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
            case 2:
                return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
            case 4:
                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 8:
                return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
            default:
                return "UNKNOWN";
        }
    }

    public static String feedbackTypeToString(int feedbackType) {
        String str2;
        String str;
        int length;
        int obj4;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (obj4 > 0) {
            str = 1;
            str2 = str << numberOfTrailingZeros;
            obj4 &= i;
            if (stringBuilder.length() > str) {
            }
            stringBuilder.append("FEEDBACK_GENERIC");
            stringBuilder.append("FEEDBACK_VISUAL");
            stringBuilder.append("FEEDBACK_AUDIBLE");
            stringBuilder.append("FEEDBACK_HAPTIC");
            stringBuilder.append("FEEDBACK_SPOKEN");
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String flagToString(int flag) {
        switch (flag) {
            case 1:
                return "DEFAULT";
            case 2:
                return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            case 4:
                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            case 8:
                return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 16:
                return "FLAG_REPORT_VIEW_IDS";
            case 32:
                return "FLAG_REQUEST_FILTER_KEY_EVENTS";
            default:
                return null;
        }
    }

    @ReplaceWith(expression = "info.getCapabilities()")
    @Deprecated
    public static int getCapabilities(AccessibilityServiceInfo info) {
        return info.getCapabilities();
    }

    @ReplaceWith(expression = "info.loadDescription(packageManager)")
    @Deprecated
    public static String loadDescription(AccessibilityServiceInfo info, PackageManager packageManager) {
        return info.loadDescription(packageManager);
    }
}
