package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class g {
    public static ColorStateList a(ImageView imageView) {
        ColorStateList obj2;
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (imageView instanceof n) {
            obj2 = (n)imageView.getSupportImageTintList();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public static PorterDuff.Mode b(ImageView imageView) {
        PorterDuff.Mode obj2;
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (imageView instanceof n) {
            obj2 = (n)imageView.getSupportImageTintMode();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public static void c(ImageView imageView, ColorStateList colorStateList2) {
        boolean imageTintList;
        Object obj3;
        imageTintList = Build.VERSION.SDK_INT;
        final int i = 21;
        if (imageTintList >= i) {
            imageView.setImageTintList(colorStateList2);
            obj3 = imageView.getDrawable();
            if (imageTintList == i && obj3 != null && imageView.getImageTintList() != null && obj3.isStateful()) {
                obj3 = imageView.getDrawable();
                if (obj3 != null) {
                    if (imageView.getImageTintList() != null) {
                        if (obj3.isStateful()) {
                            obj3.setState(imageView.getDrawableState());
                        }
                        imageView.setImageDrawable(obj3);
                    }
                }
            }
        } else {
            if (imageView instanceof n) {
                (n)imageView.setSupportImageTintList(colorStateList2);
            }
        }
    }

    public static void d(ImageView imageView, PorterDuff.Mode porterDuff$Mode2) {
        boolean imageTintList;
        Object obj3;
        imageTintList = Build.VERSION.SDK_INT;
        final int i = 21;
        if (imageTintList >= i) {
            imageView.setImageTintMode(mode2);
            obj3 = imageView.getDrawable();
            if (imageTintList == i && obj3 != null && imageView.getImageTintList() != null && obj3.isStateful()) {
                obj3 = imageView.getDrawable();
                if (obj3 != null) {
                    if (imageView.getImageTintList() != null) {
                        if (obj3.isStateful()) {
                            obj3.setState(imageView.getDrawableState());
                        }
                        imageView.setImageDrawable(obj3);
                    }
                }
            }
        } else {
            if (imageView instanceof n) {
                (n)imageView.setSupportImageTintMode(mode2);
            }
        }
    }
}
