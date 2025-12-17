package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

/* loaded from: classes5.dex */
public class ImageViewCompat {

    static class Api21Impl {
        static ColorStateList getImageTintList(ImageView imageView) {
            return imageView.getImageTintList();
        }

        static PorterDuff.Mode getImageTintMode(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        static void setImageTintList(ImageView imageView, ColorStateList tint) {
            imageView.setImageTintList(tint);
        }

        static void setImageTintMode(ImageView imageView, PorterDuff.Mode tintMode) {
            imageView.setImageTintMode(tintMode);
        }
    }
    public static ColorStateList getImageTintList(ImageView view) {
        return ImageViewCompat.Api21Impl.getImageTintList(view);
    }

    public static PorterDuff.Mode getImageTintMode(ImageView view) {
        return ImageViewCompat.Api21Impl.getImageTintMode(view);
    }

    public static void setImageTintList(ImageView view, ColorStateList tintList) {
        ImageViewCompat.Api21Impl.setImageTintList(view, tintList);
    }

    public static void setImageTintMode(ImageView view, PorterDuff.Mode mode) {
        ImageViewCompat.Api21Impl.setImageTintMode(view, mode);
    }
}
