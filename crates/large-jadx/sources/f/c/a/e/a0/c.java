package f.c.a.e.a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import androidx.appcompat.widget.t0;
import d.a.k.a.a;

/* loaded from: classes2.dex */
public class c {
    public static ColorStateList a(Context context, TypedArray typedArray2, int i3) {
        boolean resourceId;
        int color;
        Object obj1;
        resourceId = typedArray2.getResourceId(i3, 0);
        obj1 = a.c(context, resourceId);
        if (typedArray2.hasValue(i3) && resourceId != 0 && obj1 != null) {
            resourceId = typedArray2.getResourceId(i3, 0);
            if (resourceId != 0) {
                obj1 = a.c(context, resourceId);
                if (obj1 != null) {
                    return obj1;
                }
            }
        }
        obj1 = -1;
        color = typedArray2.getColor(i3, obj1);
        if (Build.VERSION.SDK_INT <= 15 && color != obj1) {
            obj1 = -1;
            color = typedArray2.getColor(i3, obj1);
            if (color != obj1) {
                return ColorStateList.valueOf(color);
            }
        }
        return typedArray2.getColorStateList(i3);
    }

    public static ColorStateList b(Context context, t0 t02, int i3) {
        boolean z;
        int i;
        Object obj1;
        z = t02.n(i3, 0);
        obj1 = a.c(context, z);
        if (t02.s(i3) && z != 0 && obj1 != null) {
            z = t02.n(i3, 0);
            if (z != 0) {
                obj1 = a.c(context, z);
                if (obj1 != null) {
                    return obj1;
                }
            }
        }
        obj1 = -1;
        i = t02.b(i3, obj1);
        if (Build.VERSION.SDK_INT <= 15 && i != obj1) {
            obj1 = -1;
            i = t02.b(i3, obj1);
            if (i != obj1) {
                return ColorStateList.valueOf(i);
            }
        }
        return t02.c(i3);
    }

    public static int c(Context context, TypedArray typedArray2, int i3, int i4) {
        boolean value;
        int i;
        TypedValue typedValue = new TypedValue();
        if (typedArray2.getValue(i3, typedValue) && typedValue.type != 2) {
            if (typedValue.type != 2) {
            }
            int[] obj4 = new int[1];
            int i2 = 0;
            obj4[i2] = typedValue.data;
            TypedArray obj3 = context.getTheme().obtainStyledAttributes(obj4);
            obj3.recycle();
            return obj3.getDimensionPixelSize(i2, i4);
        }
        return typedArray2.getDimensionPixelSize(i3, i4);
    }

    public static Drawable d(Context context, TypedArray typedArray2, int i3) {
        boolean resourceId;
        Object obj1;
        resourceId = typedArray2.getResourceId(i3, 0);
        obj1 = a.d(context, resourceId);
        if (typedArray2.hasValue(i3) && resourceId != 0 && obj1 != null) {
            resourceId = typedArray2.getResourceId(i3, 0);
            if (resourceId != 0) {
                obj1 = a.d(context, resourceId);
                if (obj1 != null) {
                    return obj1;
                }
            }
        }
        return typedArray2.getDrawable(i3);
    }

    static int e(TypedArray typedArray, int i2, int i3) {
        if (typedArray.hasValue(i2)) {
            return i2;
        }
        return i3;
    }

    public static f.c.a.e.a0.d f(Context context, TypedArray typedArray2, int i3) {
        boolean value;
        int obj2;
        obj2 = typedArray2.getResourceId(i3, 0);
        if (typedArray2.hasValue(i3) && obj2 != null) {
            obj2 = typedArray2.getResourceId(i3, 0);
            if (obj2 != null) {
                d obj3 = new d(context, obj2);
                return obj3;
            }
        }
        return null;
    }

    public static boolean g(Context context) {
        int obj1;
        obj1 = Float.compare(obj1, i) >= 0 ? 1 : 0;
        return obj1;
    }

    public static boolean h(Context context) {
        int obj1;
        obj1 = Float.compare(obj1, i) >= 0 ? 1 : 0;
        return obj1;
    }
}
