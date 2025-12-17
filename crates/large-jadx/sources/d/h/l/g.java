package d.h.l;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class g {

    private static Field a;
    private static boolean b;
    private static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 layoutInflater$Factory22) {
        boolean z;
        Field field;
        Field declaredField;
        String string;
        String name;
        Object obj6;
        Object obj7;
        final String str = "; inflation may have unexpected results.";
        final String str2 = "LayoutInflaterCompatHC";
        if (!g.b) {
            z = 1;
            declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
            g.a = declaredField;
            declaredField.setAccessible(z);
            g.b = z;
        }
        field = g.a;
        if (field != null) {
            field.set(layoutInflater, factory22);
        }
    }

    public static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 layoutInflater$Factory22) {
        int sDK_INT;
        int i;
        layoutInflater.setFactory2(factory22);
        if (Build.VERSION.SDK_INT < 21) {
            sDK_INT = layoutInflater.getFactory();
            if (sDK_INT instanceof LayoutInflater.Factory2) {
                g.a(layoutInflater, (LayoutInflater.Factory2)sDK_INT);
            } else {
                g.a(layoutInflater, factory22);
            }
        }
    }
}
