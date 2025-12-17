package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.view.Display;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class DisplayManagerCompat {

    static final String DISPLAY_CATEGORY_ALL = "android.hardware.display.category.ALL_INCLUDING_DISABLED";
    public static final String DISPLAY_CATEGORY_BUILT_IN_DISPLAYS = "android.hardware.display.category.BUILT_IN_DISPLAYS";
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    static final int DISPLAY_TYPE_INTERNAL = 1;
    private final Context mContext;
    private DisplayManagerCompat(Context context) {
        super();
        this.mContext = context;
    }

    private static Display[] computeBuiltInDisplays(DisplayManager displayManager) {
        Display[] displays;
        int builtInDisplayIndex;
        int i;
        Display display;
        int typeCompat;
        if (Build.VERSION.SDK_INT >= 32) {
            displays = displayManager.getDisplays("android.hardware.display.category.ALL_INCLUDING_DISABLED");
        } else {
            displays = displayManager.getDisplays();
        }
        int i3 = 1;
        final Display[] arr = new Display[DisplayManagerCompat.numberOfDisplaysByType(i3, displays)];
        builtInDisplayIndex = 0;
        i = 0;
        while (i < displays.length) {
            display = displays[i];
            if (i3 == DisplayManagerCompat.getTypeCompat(display)) {
            }
            i++;
            arr[builtInDisplayIndex] = display;
            builtInDisplayIndex++;
        }
        return arr;
    }

    public static androidx.core.hardware.display.DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat = new DisplayManagerCompat(context);
        return displayManagerCompat;
    }

    static int getTypeCompat(Display display) {
        int i = 0;
        return (Integer)Objects.requireNonNull(Display.class.getMethod("getType", new Class[i]).invoke(display, new Object[i])).intValue();
    }

    private static int numberOfDisplaysByType(int type, Display[] displays) {
        int count;
        int i;
        Object obj;
        int typeCompat;
        count = 0;
        i = 0;
        while (i < displays.length) {
            if (type == DisplayManagerCompat.getTypeCompat(displays[i])) {
            }
            i++;
            count++;
        }
        return count;
    }

    public Display getDisplay(int displayId) {
        return (DisplayManager)this.mContext.getSystemService("display").getDisplay(displayId);
    }

    public Display[] getDisplays() {
        return (DisplayManager)this.mContext.getSystemService("display").getDisplays();
    }

    public Display[] getDisplays(String category) {
        String str = "display";
        if ("android.hardware.display.category.BUILT_IN_DISPLAYS".equals(category)) {
            return DisplayManagerCompat.computeBuiltInDisplays((DisplayManager)this.mContext.getSystemService(str));
        }
        return (DisplayManager)this.mContext.getSystemService(str).getDisplays(category);
    }
}
