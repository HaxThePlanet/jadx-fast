package androidx.core.view;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.Display.Mode;
import androidx.core.util.Preconditions;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public final class DisplayCompat {

    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    static class Api23Impl {
        static androidx.core.view.DisplayCompat.ModeCompat getMode(Context context, Display display) {
            androidx.core.view.DisplayCompat.ModeCompat modeCompat;
            boolean physicalSizeEquals;
            int i;
            final Display.Mode mode = display.getMode();
            final Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            if (currentDisplaySizeFromWorkarounds != null) {
                if (DisplayCompat.Api23Impl.physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
                    modeCompat = new DisplayCompat.ModeCompat(mode, 1);
                } else {
                    modeCompat = new DisplayCompat.ModeCompat(mode, currentDisplaySizeFromWorkarounds);
                }
            } else {
            }
            return modeCompat;
        }

        public static androidx.core.view.DisplayCompat.ModeCompat[] getSupportedModes(Context context, Display display) {
            boolean physicalSizeEquals2;
            int i2;
            boolean physicalSizeEquals;
            int length;
            Object modeCompat;
            int i;
            final Display.Mode[] supportedModes = display.getSupportedModes();
            androidx.core.view.DisplayCompat.ModeCompat[] arr = new DisplayCompat.ModeCompat[supportedModes.length];
            final Display.Mode mode = display.getMode();
            final Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            if (currentDisplaySizeFromWorkarounds != null) {
                if (DisplayCompat.Api23Impl.physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
                    i2 = 0;
                    for (Object i : obj0) {
                        modeCompat = new DisplayCompat.ModeCompat(i, DisplayCompat.Api23Impl.physicalSizeEquals(supportedModes[i2], mode));
                        arr[i2] = modeCompat;
                    }
                } else {
                    i2 = 0;
                    for (Object modeCompat : obj0) {
                        if (DisplayCompat.Api23Impl.physicalSizeEquals(supportedModes[i2], mode)) {
                        } else {
                        }
                        physicalSizeEquals = new DisplayCompat.ModeCompat(supportedModes[i2], 0);
                        arr[i2] = physicalSizeEquals;
                        physicalSizeEquals = new DisplayCompat.ModeCompat(modeCompat, currentDisplaySizeFromWorkarounds);
                    }
                }
            } else {
            }
            return arr;
        }

        static boolean isCurrentModeTheLargestMode(Display display) {
            int i;
            Display.Mode mode;
            int physicalHeight;
            int physicalHeight2;
            final Display.Mode mode2 = display.getMode();
            final Display.Mode[] supportedModes = display.getSupportedModes();
            final int i3 = 0;
            i = i3;
            while (i < supportedModes.length) {
                mode = supportedModes[i];
                i++;
            }
            return 1;
        }

        static boolean physicalSizeEquals(Display.Mode mode, Point size) {
            int i2;
            int physicalHeight;
            int i;
            if (mode.getPhysicalWidth() == size.x) {
                if (mode.getPhysicalHeight() != size.y) {
                    if (mode.getPhysicalWidth() == size.y && mode.getPhysicalHeight() == size.x) {
                        i2 = mode.getPhysicalHeight() == size.x ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i2;
        }

        static boolean physicalSizeEquals(Display.Mode mode, Display.Mode otherMode) {
            int physicalHeight;
            int i;
            int physicalHeight2;
            if (mode.getPhysicalWidth() == otherMode.getPhysicalWidth() && mode.getPhysicalHeight() == otherMode.getPhysicalHeight()) {
                i = mode.getPhysicalHeight() == otherMode.getPhysicalHeight() ? 1 : 0;
            } else {
            }
            return i;
        }
    }

    public static final class ModeCompat {

        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;
        ModeCompat(Point physicalSize) {
            super();
            Preconditions.checkNotNull(physicalSize, "physicalSize == null");
            this.mPhysicalSize = physicalSize;
            this.mMode = 0;
            this.mIsNative = true;
        }

        ModeCompat(Display.Mode mode, Point physicalSize) {
            super();
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(physicalSize, "physicalSize == null");
            this.mPhysicalSize = physicalSize;
            this.mMode = mode;
            this.mIsNative = true;
        }

        ModeCompat(Display.Mode mode, boolean isNative) {
            super();
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Point point = new Point(DisplayCompat.ModeCompat.Api23Impl.getPhysicalWidth(mode), DisplayCompat.ModeCompat.Api23Impl.getPhysicalHeight(mode));
            this.mPhysicalSize = point;
            this.mMode = mode;
            this.mIsNative = isNative;
        }

        public int getPhysicalHeight() {
            return mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return mPhysicalSize.x;
        }

        @Deprecated
        public boolean isNative() {
            return this.mIsNative;
        }

        public Display.Mode toMode() {
            return this.mMode;
        }
    }
    static Point getCurrentDisplaySizeFromWorkarounds(Context context, Display display) {
        boolean currentModeTheLargestMode;
        int point;
        int i;
        Point physicalDisplaySizeFromSystemProperties = DisplayCompat.parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        if (physicalDisplaySizeFromSystemProperties != null) {
            return physicalDisplaySizeFromSystemProperties;
        }
        if (DisplayCompat.isSonyBravia4kTv(context)) {
            if (DisplayCompat.isCurrentModeTheLargestMode(display)) {
                point = new Point(3840, 2160);
            } else {
            }
            return point;
        }
        return null;
    }

    private static Point getDisplaySize(Context context, Display display) {
        final Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
        if (currentDisplaySizeFromWorkarounds != null) {
            return currentDisplaySizeFromWorkarounds;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }

    public static androidx.core.view.DisplayCompat.ModeCompat getMode(Context context, Display display) {
        return DisplayCompat.Api23Impl.getMode(context, display);
    }

    public static androidx.core.view.DisplayCompat.ModeCompat[] getSupportedModes(Context context, Display display) {
        return DisplayCompat.Api23Impl.getSupportedModes(context, display);
    }

    private static String getSystemProperty(String name) {
        try {
            Class forName = Class.forName("android.os.SystemProperties");
            Class[] arr = new Class[1];
            return (String)forName.getMethod("get", String.class).invoke(forName, /* result */);
            return null;
        }
    }

    static boolean isCurrentModeTheLargestMode(Display display) {
        return DisplayCompat.Api23Impl.isCurrentModeTheLargestMode(display);
    }

    private static boolean isSonyBravia4kTv(Context context) {
        boolean systemFeature;
        int i;
        String str;
        if (DisplayCompat.isTv(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
            if ("Sony".equals(Build.MANUFACTURER)) {
                if (Build.MODEL.startsWith("BRAVIA")) {
                    i = context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd") ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static boolean isTv(Context context) {
        int currentModeType;
        int i;
        int i2;
        Object systemService = context.getSystemService("uimode");
        if (systemService != null && (UiModeManager)systemService.getCurrentModeType() == 4) {
            i = systemService.getCurrentModeType() == 4 ? 1 : 0;
        } else {
        }
        return i;
    }

    private static Point parseDisplaySize(String displaySize) throws java.lang.NumberFormatException {
        int length;
        int int;
        String[] split = displaySize.trim().split("x", -1);
        if (split.length != 2) {
        } else {
            length = Integer.parseInt(split[0]);
            int = Integer.parseInt(split[1]);
            if (length <= 0) {
            } else {
                if (int <= 0) {
                } else {
                    Point point = new Point(length, int);
                    return point;
                }
            }
        }
        NumberFormatException width = new NumberFormatException();
        throw width;
    }

    private static Point parsePhysicalDisplaySizeFromSystemProperties(String property, Display display) {
        int i = 0;
        if (display.getDisplayId() != 0) {
            return i;
        }
        String systemProperty = DisplayCompat.getSystemProperty(property);
        if (!TextUtils.isEmpty(systemProperty) && systemProperty == null) {
            if (systemProperty == null) {
            }
            return DisplayCompat.parseDisplaySize(systemProperty);
        }
        return i;
    }
}
