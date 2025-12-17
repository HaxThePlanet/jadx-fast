package d.u;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class b0 {

    private static LayoutTransition a;
    private static Field b;
    private static boolean c;
    private static Method d;
    private static boolean e;

    static class a extends LayoutTransition {
        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return 1;
        }
    }
    private static void a(LayoutTransition layoutTransition) {
        boolean z;
        int arr2;
        Method declaredMethod;
        String str;
        Class[] arr;
        Object obj7;
        final String str2 = "Failed to access cancel method by reflection";
        arr2 = 0;
        final String str3 = "ViewGroupUtilsApi14";
        if (!b0.e) {
            z = 1;
            declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[arr2]);
            b0.d = declaredMethod;
            declaredMethod.setAccessible(z);
            b0.e = z;
        }
        Method method = b0.d;
        if (method != null) {
            method.invoke(layoutTransition, new Object[arr2]);
        }
    }

    static void b(ViewGroup viewGroup, boolean z2) {
        LayoutTransition tag;
        int i2;
        int i;
        int str;
        Field obj6;
        i2 = 1;
        i = 0;
        final int i3 = 0;
        if (b0.a == null) {
            b0.a aVar = new b0.a();
            b0.a = aVar;
            aVar.setAnimator(2, i3);
            b0.a.setAnimator(i, i3);
            b0.a.setAnimator(i2, i3);
            b0.a.setAnimator(3, i3);
            b0.a.setAnimator(4, i3);
        }
        if (z2 != null) {
            obj6 = viewGroup.getLayoutTransition();
            if (obj6 != null && obj6.isRunning()) {
                if (obj6.isRunning()) {
                    b0.a(obj6);
                }
                if (obj6 != b0.a) {
                    viewGroup.setTag(j.d, obj6);
                }
            }
            viewGroup.setLayoutTransition(b0.a);
        } else {
            viewGroup.setLayoutTransition(i3);
            String str2 = "ViewGroupUtilsApi14";
            if (!b0.c) {
                obj6 = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                b0.b = obj6;
                obj6.setAccessible(i2);
                b0.c = i2;
            }
            obj6 = b0.b;
            obj6 = obj6.getBoolean(viewGroup);
            if (obj6 != null && obj6 != null) {
                obj6 = obj6.getBoolean(viewGroup);
                if (obj6 != null) {
                    b0.b.setBoolean(viewGroup, i);
                }
                i = obj6;
            }
            if (i != 0) {
                viewGroup.requestLayout();
            }
            obj6 = j.d;
            tag = viewGroup.getTag(obj6);
            if ((LayoutTransition)tag != null) {
                viewGroup.setTag(obj6, i3);
                viewGroup.setLayoutTransition((LayoutTransition)tag);
            }
        }
    }
}
