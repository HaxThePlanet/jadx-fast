package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.ReplaceWith;

/* loaded from: classes5.dex */
public final class CheckedTextViewCompat {

    private static class Api21Impl {
        static ColorStateList getCheckMarkTintList(CheckedTextView textView) {
            return textView.getCheckMarkTintList();
        }

        static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView textView) {
            return textView.getCheckMarkTintMode();
        }

        static void setCheckMarkTintList(CheckedTextView textView, ColorStateList tint) {
            textView.setCheckMarkTintList(tint);
        }

        static void setCheckMarkTintMode(CheckedTextView textView, PorterDuff.Mode tintMode) {
            textView.setCheckMarkTintMode(tintMode);
        }
    }
    @ReplaceWith(expression = "textView.getCheckMarkDrawable()")
    @Deprecated
    public static Drawable getCheckMarkDrawable(CheckedTextView textView) {
        return textView.getCheckMarkDrawable();
    }

    public static ColorStateList getCheckMarkTintList(CheckedTextView textView) {
        return CheckedTextViewCompat.Api21Impl.getCheckMarkTintList(textView);
    }

    public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView textView) {
        return CheckedTextViewCompat.Api21Impl.getCheckMarkTintMode(textView);
    }

    public static void setCheckMarkTintList(CheckedTextView textView, ColorStateList tint) {
        CheckedTextViewCompat.Api21Impl.setCheckMarkTintList(textView, tint);
    }

    public static void setCheckMarkTintMode(CheckedTextView textView, PorterDuff.Mode tintMode) {
        CheckedTextViewCompat.Api21Impl.setCheckMarkTintMode(textView, tintMode);
    }
}
