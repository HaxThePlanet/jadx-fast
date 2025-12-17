package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import d.h.l.u;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class z0 {

    private static Method a;
    static {
        int sDK_INT;
        int str;
        Class[] arr;
        Class<Rect> obj;
        int i;
        arr = new Class[2];
        i = 1;
        arr[i] = Rect.class;
        Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", arr);
        z0.a = declaredMethod;
        if (Build.VERSION.SDK_INT >= 18 && !declaredMethod.isAccessible()) {
            arr = new Class[2];
            i = 1;
            arr[i] = Rect.class;
            declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", arr);
            z0.a = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                z0.a.setAccessible(i);
            }
        }
    }

    public static void a(View view, Rect rect2, Rect rect3) {
        Object[] arr;
        int i;
        Object obj3;
        Object obj4;
        Object obj5;
        final Method method = z0.a;
        if (method != null) {
            arr = new Object[2];
            method.invoke(view, rect2, rect3);
        }
    }

    public static boolean b(View view) {
        int i;
        if (u.B(view) == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    public static void c(View view) {
        int sDK_INT;
        int arr2;
        boolean accessible;
        int i;
        Class[] arr;
        Object obj6;
        final String str = "Could not invoke makeOptionalFitsSystemWindows";
        final String str2 = "ViewUtils";
        i = 0;
        sDK_INT = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[i]);
        if (Build.VERSION.SDK_INT >= 16 && !sDK_INT.isAccessible()) {
            i = 0;
            sDK_INT = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[i]);
            if (!sDK_INT.isAccessible()) {
                sDK_INT.setAccessible(true);
            }
            sDK_INT.invoke(view, new Object[i]);
        }
    }
}
