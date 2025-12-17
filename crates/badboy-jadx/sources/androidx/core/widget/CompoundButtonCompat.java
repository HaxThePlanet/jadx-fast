package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public final class CompoundButtonCompat {

    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    static class Api21Impl {
        static ColorStateList getButtonTintList(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        static PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        static void setButtonTintList(CompoundButton compoundButton, ColorStateList tint) {
            compoundButton.setButtonTintList(tint);
        }

        static void setButtonTintMode(CompoundButton compoundButton, PorterDuff.Mode tintMode) {
            compoundButton.setButtonTintMode(tintMode);
        }
    }

    static class Api23Impl {
        static Drawable getButtonDrawable(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }
    public static Drawable getButtonDrawable(CompoundButton button) {
        return CompoundButtonCompat.Api23Impl.getButtonDrawable(button);
    }

    public static ColorStateList getButtonTintList(CompoundButton button) {
        return CompoundButtonCompat.Api21Impl.getButtonTintList(button);
    }

    public static PorterDuff.Mode getButtonTintMode(CompoundButton button) {
        return CompoundButtonCompat.Api21Impl.getButtonTintMode(button);
    }

    public static void setButtonTintList(CompoundButton button, ColorStateList tint) {
        CompoundButtonCompat.Api21Impl.setButtonTintList(button, tint);
    }

    public static void setButtonTintMode(CompoundButton button, PorterDuff.Mode tintMode) {
        CompoundButtonCompat.Api21Impl.setButtonTintMode(button, tintMode);
    }
}
