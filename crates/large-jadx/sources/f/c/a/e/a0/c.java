package f.c.a.e.a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import androidx.appcompat.widget.t0;
import d.a.k.a.a;

/* compiled from: MaterialResources.java */
/* loaded from: classes2.dex */
public class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0 && colorStateList != null) {
                return colorStateList;
            }
        }
        int color = 15;
        if (Build.VERSION.SDK_INT <= 15) {
            int sDK_INT2 = -1;
            color = typedArray.getColor(i, sDK_INT2);
            if (color != sDK_INT2) {
                return ColorStateList.valueOf(color);
            }
        }
        return typedArray.getColorStateList(i);
    }

    public static ColorStateList b(Context context, t0 t0Var, int i) {
        if (t0Var.s(i)) {
            int i4 = t0Var.n(i, 0);
            if (i4 != 0 && colorStateList != null) {
                return colorStateList;
            }
        }
        i = 15;
        if (Build.VERSION.SDK_INT <= 15) {
            int sDK_INT2 = -1;
            i = t0Var.b(i, sDK_INT2);
            if (i != sDK_INT2) {
                return ColorStateList.valueOf(i);
            }
        }
        return t0Var.c(i);
    }

    public static int c(Context context, TypedArray typedArray, int i, int i2) throws android.content.res.Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i, typedValue)) {
            i = 2;
            int[] iArr = new int[1];
            i2 = 0;
            iArr[i2] = typedValue.data;
            TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(iArr);
            styledAttributes.recycle();
            return styledAttributes.getDimensionPixelSize(i2, i2);
        }
        return typedArray.getDimensionPixelSize(i, i2);
    }

    public static Drawable d(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0 && drawable != null) {
                return drawable;
            }
        }
        return typedArray.getDrawable(i);
    }

    static int e(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }

    public static d f(Context context, TypedArray typedArray, int i) {
        if (typedArray.hasValue(i)) {
            int resourceId = typedArray.getResourceId(i, 0);
            if (resourceId != 0) {
                return new d(context, resourceId);
            }
        }
        return null;
    }

    public static boolean g(Context context) {
        boolean z = true;
        context = fontScale2 >= 1067869798 ? 1 : 0;
        return (fontScale2 >= 1067869798 ? 1 : 0);
    }

    public static boolean h(Context context) {
        boolean z = true;
        context = fontScale2 >= 1073741824 ? 1 : 0;
        return (fontScale2 >= 1073741824 ? 1 : 0);
    }
}
