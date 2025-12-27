package d.h.l;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* compiled from: LayoutInflaterCompat.java */
/* loaded from: classes.dex */
public final class g {

    private static Field a;
    private static boolean b;
    private static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) throws java.lang.NoSuchFieldException {
        Field declaredField;
        String str;
        String obj2;
        if (!g.b) {
            boolean z = true;
            try {
                str = "mFactory2";
                declaredField = LayoutInflater.class.getDeclaredField(str);
                g.a = declaredField;
                declaredField.setAccessible(z);
            } catch (java.lang.IllegalAccessException illegalAccess) {
                StringBuilder stringBuilder = new StringBuilder();
                Throwable str6 = "forceSetFactory2 could not set the Factory2 on LayoutInflater ";
                layoutInflater = str6 + layoutInflater + str2;
                Log.e(str4, layoutInflater, illegalAccess);
            }
            g.b = z;
        }
        field = g.a;
        if (g.a != null) {
            try {
                g.a.set(layoutInflater, illegalAccess);
            } catch (java.lang.IllegalAccessException illegalAccess) {
                stringBuilder = new StringBuilder();
                str6 = "forceSetFactory2 could not set the Factory2 on LayoutInflater ";
                layoutInflater = str6 + layoutInflater + str2;
                Log.e(str4, layoutInflater, illegalAccess);
            }
        }
    }

    public static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        int i = 21;
        if (Build.VERSION.SDK_INT < 21) {
            android.view.LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                g.a(layoutInflater, factory);
            } else {
                g.a(layoutInflater, factory2);
            }
        }
    }
}
