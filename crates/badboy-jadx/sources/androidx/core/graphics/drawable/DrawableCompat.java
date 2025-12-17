package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ReplaceWith;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public final class DrawableCompat {

    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    static class Api21Impl {
        static void applyTheme(Drawable drawable, Resources.Theme t) {
            drawable.applyTheme(t);
        }

        static boolean canApplyTheme(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter getColorFilter(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void inflate(Drawable drawable, Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(r, parser, attrs, theme);
        }

        static void setHotspot(Drawable drawable, float x, float y) {
            drawable.setHotspot(x, y);
        }

        static void setHotspotBounds(Drawable drawable, int left, int top, int right, int bottom) {
            drawable.setHotspotBounds(left, top, right, bottom);
        }

        static void setTint(Drawable drawable, int tintColor) {
            drawable.setTint(tintColor);
        }

        static void setTintList(Drawable drawable, ColorStateList tint) {
            drawable.setTintList(tint);
        }

        static void setTintMode(Drawable drawable, PorterDuff.Mode tintMode) {
            drawable.setTintMode(tintMode);
        }
    }

    static class Api23Impl {
        static int getLayoutDirection(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean setLayoutDirection(Drawable drawable, int layoutDirection) {
            return drawable.setLayoutDirection(layoutDirection);
        }
    }
    public static void applyTheme(Drawable drawable, Resources.Theme theme) {
        DrawableCompat.Api21Impl.applyTheme(drawable, theme);
    }

    public static boolean canApplyTheme(Drawable drawable) {
        return DrawableCompat.Api21Impl.canApplyTheme(drawable);
    }

    public static void clearColorFilter(Drawable drawable) {
        drawable.clearColorFilter();
    }

    @ReplaceWith(expression = "drawable.getAlpha()")
    @Deprecated
    public static int getAlpha(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static ColorFilter getColorFilter(Drawable drawable) {
        return DrawableCompat.Api21Impl.getColorFilter(drawable);
    }

    public static int getLayoutDirection(Drawable drawable) {
        return DrawableCompat.Api23Impl.getLayoutDirection(drawable);
    }

    public static void inflate(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        DrawableCompat.Api21Impl.inflate(drawable, res, parser, attrs, theme);
    }

    @ReplaceWith(expression = "drawable.isAutoMirrored()")
    @Deprecated
    public static boolean isAutoMirrored(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @ReplaceWith(expression = "drawable.jumpToCurrentState()")
    @Deprecated
    public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    @ReplaceWith(expression = "drawable.setAutoMirrored(mirrored)")
    @Deprecated
    public static void setAutoMirrored(Drawable drawable, boolean mirrored) {
        drawable.setAutoMirrored(mirrored);
    }

    public static void setHotspot(Drawable drawable, float x, float y) {
        DrawableCompat.Api21Impl.setHotspot(drawable, x, y);
    }

    public static void setHotspotBounds(Drawable drawable, int left, int top, int right, int bottom) {
        DrawableCompat.Api21Impl.setHotspotBounds(drawable, left, top, right, bottom);
    }

    public static boolean setLayoutDirection(Drawable drawable, int layoutDirection) {
        return DrawableCompat.Api23Impl.setLayoutDirection(drawable, layoutDirection);
    }

    public static void setTint(Drawable drawable, int tint) {
        DrawableCompat.Api21Impl.setTint(drawable, tint);
    }

    public static void setTintList(Drawable drawable, ColorStateList tint) {
        DrawableCompat.Api21Impl.setTintList(drawable, tint);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode tintMode) {
        DrawableCompat.Api21Impl.setTintMode(drawable, tintMode);
    }

    public static <T extends Drawable> T unwrap(Drawable drawable) {
        if (drawable instanceof WrappedDrawable) {
            return (WrappedDrawable)drawable.getWrappedDrawable();
        }
        return drawable;
    }

    public static Drawable wrap(Drawable drawable) {
        return drawable;
    }
}
