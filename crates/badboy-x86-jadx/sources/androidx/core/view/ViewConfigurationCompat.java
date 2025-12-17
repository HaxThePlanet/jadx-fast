package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.annotation.ReplaceWith;
import androidx.core.util.Supplier;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class ViewConfigurationCompat {

    private static final int NO_FLING_MAX_VELOCITY = Integer.MIN_VALUE;
    private static final int NO_FLING_MIN_VELOCITY = Integer.MAX_VALUE;
    private static final int RESOURCE_ID_NOT_SUPPORTED = -1;
    private static final int RESOURCE_ID_SUPPORTED_BUT_NOT_FOUND = 0;
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    static class Api26Impl {
        static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    static class Api28Impl {
        static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static class Api34Impl {
        static int getScaledMaximumFlingVelocity(ViewConfiguration viewConfiguration, int inputDeviceId, int axis, int source) {
            return viewConfiguration.getScaledMaximumFlingVelocity(inputDeviceId, axis, source);
        }

        static int getScaledMinimumFlingVelocity(ViewConfiguration viewConfiguration, int inputDeviceId, int axis, int source) {
            return viewConfiguration.getScaledMinimumFlingVelocity(inputDeviceId, axis, source);
        }
    }
    public static int $r8$lambda$DUnOdzWd_GMixRu8Q8mhfglZyiM(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledMinimumFlingVelocity();
    }

    public static int $r8$lambda$u_xUdJpIAAO3758SdHprtx7JUP0(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledMaximumFlingVelocity();
    }

    static {
    }

    private static int getCompatFlingVelocityThreshold(Resources res, int platformResId, Supplier<Integer> supplier3, int noFlingThreshold) {
        int i;
        switch (platformResId) {
            case -1:
                return (Integer)supplier3.get().intValue();
            case 0:
                return noFlingThreshold;
            default:
                int dimensionPixelSize = res.getDimensionPixelSize(platformResId);
                i = dimensionPixelSize;
                return i;
        }
        i = noFlingThreshold;
    }

    private static float getLegacyScrollFactor(ViewConfiguration config, Context context) {
        Method sGetScaledScrollFactorMethod;
        String str;
        String str2;
        if (ViewConfigurationCompat.sGetScaledScrollFactorMethod != null) {
            return (float)intValue;
        }
        TypedValue e = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, e, true)) {
            try {
                return e.getDimension(context.getResources().getDisplayMetrics());
                return 0;
            }
        }
    }

    private static int getPlatformResId(Resources res, String name, String defType) {
        return res.getIdentifier(name, defType, "android");
    }

    private static int getPreApi34MaximumFlingVelocityResId(Resources res, int source, int axis) {
        int i;
        if (source == 4194304 && axis == 26) {
            if (axis == 26) {
                return ViewConfigurationCompat.getPlatformResId(res, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
            }
        }
        return -1;
    }

    private static int getPreApi34MinimumFlingVelocityResId(Resources res, int source, int axis) {
        int i;
        if (source == 4194304 && axis == 26) {
            if (axis == 26) {
                return ViewConfigurationCompat.getPlatformResId(res, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
            }
        }
        return -1;
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration config, Context context) {
        return ViewConfigurationCompat.Api26Impl.getScaledHorizontalScrollFactor(config);
    }

    public static int getScaledHoverSlop(ViewConfiguration config) {
        return ViewConfigurationCompat.Api28Impl.getScaledHoverSlop(config);
    }

    public static int getScaledMaximumFlingVelocity(Context context, ViewConfiguration config, int inputDeviceId, int axis, int source) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ViewConfigurationCompat.Api34Impl.getScaledMaximumFlingVelocity(config, inputDeviceId, axis, source);
        }
        int i2 = Integer.MIN_VALUE;
        if (!ViewConfigurationCompat.isInputDeviceInfoValid(inputDeviceId, axis, source)) {
            return i2;
        }
        Resources resources = context.getResources();
        Objects.requireNonNull(config);
        ViewConfigurationCompat$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ViewConfigurationCompat$$ExternalSyntheticLambda0(config);
        return ViewConfigurationCompat.getCompatFlingVelocityThreshold(resources, ViewConfigurationCompat.getPreApi34MaximumFlingVelocityResId(resources, source, axis), externalSyntheticLambda0, i2);
    }

    public static int getScaledMinimumFlingVelocity(Context context, ViewConfiguration config, int inputDeviceId, int axis, int source) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ViewConfigurationCompat.Api34Impl.getScaledMinimumFlingVelocity(config, inputDeviceId, axis, source);
        }
        int i2 = Integer.MAX_VALUE;
        if (!ViewConfigurationCompat.isInputDeviceInfoValid(inputDeviceId, axis, source)) {
            return i2;
        }
        Resources resources = context.getResources();
        Objects.requireNonNull(config);
        ViewConfigurationCompat$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ViewConfigurationCompat$$ExternalSyntheticLambda1(config);
        return ViewConfigurationCompat.getCompatFlingVelocityThreshold(resources, ViewConfigurationCompat.getPreApi34MinimumFlingVelocityResId(resources, source, axis), externalSyntheticLambda1, i2);
    }

    @ReplaceWith(expression = "config.getScaledPagingTouchSlop()")
    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration config) {
        return config.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration config, Context context) {
        return ViewConfigurationCompat.Api26Impl.getScaledVerticalScrollFactor(config);
    }

    @ReplaceWith(expression = "config.hasPermanentMenuKey()")
    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration config) {
        return config.hasPermanentMenuKey();
    }

    private static boolean isInputDeviceInfoValid(int id, int axis, int source) {
        android.view.InputDevice.MotionRange motionRange;
        int i;
        final InputDevice device = InputDevice.getDevice(id);
        if (device != null && device.getMotionRange(axis, source) != null) {
            i = device.getMotionRange(axis, source) != null ? 1 : 0;
        } else {
        }
        return i;
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration config, Context context) {
        return ViewConfigurationCompat.Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(config);
    }
}
