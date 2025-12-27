package f.c.a.e.x;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import d.h.f.c;

/* compiled from: MotionUtils.java */
/* loaded from: classes2.dex */
public class a {
    private static float a(String[] strArr, int i) {
        float parsed = Float.parseFloat(strArr[i]);
        if (parsed < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Motion easing control point value must be between 0 and 1; instead got: ";
            strArr = str + parsed;
            throw new IllegalArgumentException(strArr);
        } else {
            if (parsed <= 1065353216) {
                return parsed;
            }
        }
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static boolean c(String str, String str2) {
        boolean z = false;
        boolean startsWith;
        final StringBuilder stringBuilder = new StringBuilder();
        String str3 = "(";
        str4 = str2 + str3;
        if (str.startsWith(str4)) {
            str = str.endsWith(")") ? 1 : 0;
        }
        return (str.endsWith(")") ? 1 : 0);
    }

    public static int d(Context context, int i, int i2) {
        return b.c(context, i, i2);
    }

    public static TimeInterpolator e(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        boolean z2 = true;
        if (context.getTheme().resolveAttribute(i, typedValue, z2)) {
            int i4 = 3;
            if (typedValue.type != i4) {
                throw new IllegalArgumentException("Motion easing theme attribute must be a string");
            } else {
                String str3 = String.valueOf(typedValue.string);
                String str8 = "cubic-bezier";
                if (a.c(str3, str8)) {
                    String[] parts = a.b(str3, str8).split(",");
                    if (parts.length != 4) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = "Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ";
                        int length = parts.length;
                        context = str + length;
                        throw new IllegalArgumentException(context);
                    } else {
                        return b.a(a.a(parts, 0), a.a(parts, z2), a.a(parts, 2), a.a(parts, i4));
                    }
                }
                String str6 = "path";
                if (!a.c(str3, str6)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str2 = "Invalid motion easing type: ";
                    context = str2 + str3;
                    throw new IllegalArgumentException(context);
                } else {
                    return b.b(c.e(a.b(str3, str6)));
                }
            }
        }
        return timeInterpolator;
    }
}
