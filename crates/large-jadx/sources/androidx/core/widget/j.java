package androidx.core.widget;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import d.h.l.e;
import d.h.l.u;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class j {

    private static Method a;
    private static boolean b;
    private static Field c;
    private static boolean d;
    public static void a(PopupWindow popupWindow, boolean z2) {
        int sDK_INT;
        boolean z;
        int str2;
        Object declaredField;
        String str;
        Object obj4;
        boolean obj5;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z2);
        } else {
            str2 = "PopupWindowCompatApi21";
            if (sDK_INT >= 21 && !j.d) {
                str2 = "PopupWindowCompatApi21";
                if (!j.d) {
                    z = 1;
                    declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    j.c = declaredField;
                    declaredField.setAccessible(z);
                    j.d = z;
                }
                sDK_INT = j.c;
                if (sDK_INT != null) {
                    sDK_INT.set(popupWindow, Boolean.valueOf(z2));
                }
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i2) {
        boolean declaredMethod;
        int arr;
        String str;
        Class[] arr2;
        Class tYPE;
        int obj7;
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i2);
        }
        int i3 = 0;
        arr = 1;
        if (!j.b) {
            arr2 = new Class[arr];
            arr2[i3] = Integer.TYPE;
            declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", arr2);
            j.a = declaredMethod;
            declaredMethod.setAccessible(arr);
            j.b = arr;
        }
        Method method = j.a;
        if (method != null) {
            arr = new Object[arr];
            arr[i3] = Integer.valueOf(i2);
            method.invoke(popupWindow, arr);
        }
    }

    public static void c(PopupWindow popupWindow, View view2, int i3, int i4, int i5) {
        int sDK_INT;
        int obj4;
        int obj6;
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view2, i3, i4, i5);
        } else {
            if (obj6 &= 7 == 5) {
                i3 -= obj6;
            }
            popupWindow.showAsDropDown(view2, obj4, i4);
        }
    }
}
