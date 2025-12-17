package f.c.a.e.x;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import d.h.f.c;
import d.h.l.f0.b;
import f.c.a.e.a0.b;

/* loaded from: classes2.dex */
public class a {
    private static float a(String[] stringArr, int i2) {
        int obj3;
        float obj2 = Float.parseFloat(stringArr[i2]);
        if (Float.compare(obj2, obj3) < 0) {
        } else {
            if (Float.compare(obj2, obj3) > 0) {
            } else {
                return obj2;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Motion easing control point value must be between 0 and 1; instead got: ");
        stringBuilder.append(obj2);
        obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    private static String b(String string, String string2) {
        return string.substring(obj2++, length--);
    }

    private static boolean c(String string, String string2) {
        boolean obj1;
        boolean obj2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("(");
        if (string.startsWith(stringBuilder.toString()) && string.endsWith(")")) {
            obj1 = string.endsWith(")") ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static int d(Context context, int i2, int i3) {
        return b.c(context, i2, i3);
    }

    public static TimeInterpolator e(Context context, int i2, TimeInterpolator timeInterpolator3) {
        TypedValue typedValue = new TypedValue();
        int i3 = 1;
        if (context.getTheme().resolveAttribute(i2, typedValue, i3)) {
            int obj3 = 3;
            if (typedValue.type != obj3) {
            } else {
                String obj2 = String.valueOf(typedValue.string);
                String obj4 = "cubic-bezier";
                if (a.c(obj2, obj4)) {
                    obj2 = a.b(obj2, obj4).split(",");
                    if (obj2.length != 4) {
                    } else {
                        return b.a(a.a(obj2, 0), a.a(obj2, i3), a.a(obj2, 2), a.a(obj2, obj3));
                    }
                    obj4 = new StringBuilder();
                    obj4.append("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
                    obj4.append(obj2.length);
                    obj3 = new IllegalArgumentException(obj4.toString());
                    throw obj3;
                }
                obj3 = "path";
                if (!a.c(obj2, obj3)) {
                } else {
                    return b.b(c.e(a.b(obj2, obj3)));
                }
                obj4 = new StringBuilder();
                obj4.append("Invalid motion easing type: ");
                obj4.append(obj2);
                obj3 = new IllegalArgumentException(obj4.toString());
                throw obj3;
            }
            obj2 = new IllegalArgumentException("Motion easing theme attribute must be a string");
            throw obj2;
        }
        return timeInterpolator3;
    }
}
