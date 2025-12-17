package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import android.view.DisplayCutout.Builder;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import java.util.List;

/* loaded from: classes5.dex */
public final class DisplayCutoutCompat {

    private final DisplayCutout mDisplayCutout;

    static class Api28Impl {
        static DisplayCutout createDisplayCutout(Rect safeInsets, List<Rect> list2) {
            DisplayCutout displayCutout = new DisplayCutout(safeInsets, list2);
            return displayCutout;
        }

        static List<Rect> getBoundingRects(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        static int getSafeInsetBottom(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        static int getSafeInsetLeft(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        static int getSafeInsetRight(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        static int getSafeInsetTop(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    static class Api29Impl {
        static DisplayCutout createDisplayCutout(Insets safeInsets, Rect boundLeft, Rect boundTop, Rect boundRight, Rect boundBottom) {
            DisplayCutout displayCutout = new DisplayCutout(safeInsets, boundLeft, boundTop, boundRight, boundBottom);
            return displayCutout;
        }
    }

    static class Api30Impl {
        static DisplayCutout createDisplayCutout(Insets safeInsets, Rect boundLeft, Rect boundTop, Rect boundRight, Rect boundBottom, Insets waterfallInsets) {
            DisplayCutout displayCutout = new DisplayCutout(safeInsets, boundLeft, boundTop, boundRight, boundBottom, waterfallInsets);
            return displayCutout;
        }

        static Insets getWaterfallInsets(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }
    }

    static class Api31Impl {
        static Path getCutoutPath(DisplayCutout displayCutout) {
            return displayCutout.getCutoutPath();
        }
    }

    static class Api33Impl {
        static DisplayCutout createDisplayCutout(Insets safeInsets, Rect boundLeft, Rect boundTop, Rect boundRight, Rect boundBottom, Insets waterfallInsets, Path cutoutPath) {
            DisplayCutout.Builder builder = new DisplayCutout.Builder();
            DisplayCutout.Builder waterfallInsets2 = builder.setSafeInsets(safeInsets).setWaterfallInsets(waterfallInsets);
            if (boundLeft != null) {
                waterfallInsets2.setBoundingRectLeft(boundLeft);
            }
            if (boundTop != null) {
                waterfallInsets2.setBoundingRectTop(boundTop);
            }
            if (boundRight != null) {
                waterfallInsets2.setBoundingRectRight(boundRight);
            }
            if (boundBottom != null) {
                waterfallInsets2.setBoundingRectBottom(boundBottom);
            }
            if (cutoutPath != null) {
                waterfallInsets2.setCutoutPath(cutoutPath);
            }
            return waterfallInsets2.build();
        }
    }
    public DisplayCutoutCompat(Rect safeInsets, List<Rect> list2) {
        super(DisplayCutoutCompat.Api28Impl.createDisplayCutout(safeInsets, list2));
    }

    private DisplayCutoutCompat(DisplayCutout displayCutout) {
        super();
        this.mDisplayCutout = displayCutout;
    }

    public DisplayCutoutCompat(Insets safeInsets, Rect boundLeft, Rect boundTop, Rect boundRight, Rect boundBottom, Insets waterfallInsets) {
        super(DisplayCutoutCompat.constructDisplayCutout(safeInsets, boundLeft, boundTop, boundRight, boundBottom, waterfallInsets, 0));
    }

    public DisplayCutoutCompat(Insets safeInsets, Rect boundLeft, Rect boundTop, Rect boundRight, Rect boundBottom, Insets waterfallInsets, Path cutoutPath) {
        super(DisplayCutoutCompat.constructDisplayCutout(safeInsets, boundLeft, boundTop, boundRight, boundBottom, waterfallInsets, cutoutPath));
    }

    private static DisplayCutout constructDisplayCutout(Insets safeInsets, Rect boundLeft, Rect boundTop, Rect boundRight, Rect boundBottom, Insets waterfallInsets, Path cutoutPath) {
        if (Build.VERSION.SDK_INT >= 33) {
            Rect rect4 = boundLeft;
            Rect rect6 = boundTop;
            Rect rect8 = boundRight;
            final Rect rect9 = boundBottom;
            Rect rect = rect4;
            Rect rect2 = rect6;
            Rect boundLeft3 = rect8;
            Rect boundTop2 = rect9;
            return DisplayCutoutCompat.Api33Impl.createDisplayCutout(safeInsets.toPlatformInsets(), rect4, rect6, rect8, rect9, waterfallInsets.toPlatformInsets(), cutoutPath);
        }
        Rect boundLeft2 = boundLeft;
        Rect rect3 = boundTop;
        Rect rect5 = boundRight;
        Rect rect7 = boundBottom;
        Path path2 = cutoutPath;
        if (Build.VERSION.SDK_INT >= 30) {
            return DisplayCutoutCompat.Api30Impl.createDisplayCutout(safeInsets.toPlatformInsets(), boundLeft2, rect3, rect5, rect7, waterfallInsets.toPlatformInsets());
        }
        return DisplayCutoutCompat.Api29Impl.createDisplayCutout(safeInsets.toPlatformInsets(), boundLeft2, rect3, rect5, rect7);
    }

    static androidx.core.view.DisplayCutoutCompat wrap(DisplayCutout displayCutout) {
        int displayCutoutCompat;
        if (displayCutout == null) {
            displayCutoutCompat = 0;
        } else {
            displayCutoutCompat = new DisplayCutoutCompat(displayCutout);
        }
        return displayCutoutCompat;
    }

    public boolean equals(Object o) {
        Class class;
        Class class2;
        if (this == o) {
            return 1;
        }
        if (o != null && getClass() != o.getClass()) {
            if (getClass() != o.getClass()) {
            }
            return ObjectsCompat.equals(this.mDisplayCutout, obj.mDisplayCutout);
        }
        return 0;
    }

    public List<Rect> getBoundingRects() {
        return DisplayCutoutCompat.Api28Impl.getBoundingRects(this.mDisplayCutout);
    }

    public Path getCutoutPath() {
        if (Build.VERSION.SDK_INT >= 31) {
            return DisplayCutoutCompat.Api31Impl.getCutoutPath(this.mDisplayCutout);
        }
        return null;
    }

    public int getSafeInsetBottom() {
        return DisplayCutoutCompat.Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
    }

    public int getSafeInsetLeft() {
        return DisplayCutoutCompat.Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
    }

    public int getSafeInsetRight() {
        return DisplayCutoutCompat.Api28Impl.getSafeInsetRight(this.mDisplayCutout);
    }

    public int getSafeInsetTop() {
        return DisplayCutoutCompat.Api28Impl.getSafeInsetTop(this.mDisplayCutout);
    }

    public Insets getWaterfallInsets() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Insets.toCompatInsets(DisplayCutoutCompat.Api30Impl.getWaterfallInsets(this.mDisplayCutout));
        }
        return Insets.NONE;
    }

    public int hashCode() {
        int i;
        if (this.mDisplayCutout == null) {
            i = 0;
        } else {
            i = this.mDisplayCutout.hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DisplayCutoutCompat{").append(this.mDisplayCutout).append("}").toString();
    }

    DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }
}
