package androidx.core.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class e {

    static class a {

        private static Method a;
        private static boolean b;
        private static Method c;
        private static boolean d;
        public static IBinder a(Bundle bundle, String string2) {
            Method method;
            String str;
            Class[] arr;
            Class<String> obj;
            Object obj7;
            Object obj8;
            final int i = 0;
            final String str2 = "BundleCompatBaseImpl";
            int i2 = 1;
            if (!e.a.b) {
                arr = new Class[i2];
                arr[i] = String.class;
                method = Bundle.class.getMethod("getIBinder", arr);
                e.a.a = method;
                method.setAccessible(i2);
                e.a.b = i2;
            }
            Method method2 = e.a.a;
            if (method2 != null) {
                Object[] arr2 = new Object[i2];
                arr2[i] = string2;
                return (IBinder)method2.invoke(bundle, arr2);
            }
            return null;
        }

        public static void b(Bundle bundle, String string2, IBinder iBinder3) {
            Method method;
            int arr2;
            String str;
            Class[] arr;
            Class<IBinder> obj;
            Object obj8;
            Object obj9;
            final int i = 0;
            final String str2 = "BundleCompatBaseImpl";
            arr2 = 2;
            final int i2 = 1;
            if (!e.a.d) {
                arr = new Class[arr2];
                arr[i] = String.class;
                arr[i2] = IBinder.class;
                method = Bundle.class.getMethod("putIBinder", arr);
                e.a.c = method;
                method.setAccessible(i2);
                e.a.d = i2;
            }
            Method method2 = e.a.c;
            if (method2 != null) {
                arr2 = new Object[arr2];
                arr2[i] = string2;
                arr2[i2] = iBinder3;
                method2.invoke(bundle, arr2);
            }
        }
    }
    public static IBinder a(Bundle bundle, String string2) {
        if (Build.VERSION.SDK_INT >= 18) {
            return bundle.getBinder(string2);
        }
        return e.a.a(bundle, string2);
    }

    public static void b(Bundle bundle, String string2, IBinder iBinder3) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(string2, iBinder3);
        } else {
            e.a.b(bundle, string2, iBinder3);
        }
    }
}
