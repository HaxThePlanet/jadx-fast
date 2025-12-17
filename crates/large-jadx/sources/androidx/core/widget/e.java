package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class e {

    private static Field a;
    private static boolean b;
    public static Drawable a(CompoundButton compoundButton) {
        boolean z;
        Field field;
        Field declaredField;
        String str;
        Object obj4;
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        String str3 = "CompoundButtonCompat";
        if (!e.b) {
            z = 1;
            declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
            e.a = declaredField;
            declaredField.setAccessible(z);
            e.b = z;
        }
        field = e.a;
        if (field != null) {
            return (Drawable)field.get(compoundButton);
        }
        return null;
    }

    public static ColorStateList b(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof l) {
            return (l)compoundButton.getSupportButtonTintList();
        }
        return null;
    }

    public static void c(CompoundButton compoundButton, ColorStateList colorStateList2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList2);
        } else {
            if (compoundButton instanceof l) {
                (l)compoundButton.setSupportButtonTintList(colorStateList2);
            }
        }
    }

    public static void d(CompoundButton compoundButton, PorterDuff.Mode porterDuff$Mode2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode2);
        } else {
            if (compoundButton instanceof l) {
                (l)compoundButton.setSupportButtonTintMode(mode2);
            }
        }
    }
}
