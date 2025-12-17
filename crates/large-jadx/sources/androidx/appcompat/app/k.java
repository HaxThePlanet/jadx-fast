package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes.dex */
class k {

    private static Field a;
    private static boolean b;
    private static Class<?> c;
    private static boolean d;
    private static Field e;
    private static boolean f;
    private static Field g;
    private static boolean h;
    static void a(Resources resources) {
        int i;
        final int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 28) {
        }
        if (sDK_INT >= 24) {
            k.d(resources);
        } else {
            if (sDK_INT >= 23) {
                k.c(resources);
            } else {
                if (sDK_INT >= 21) {
                    k.b(resources);
                }
            }
        }
    }

    private static void b(Resources resources) {
        boolean z;
        Field field;
        Field declaredField;
        String str;
        Object obj4;
        final String str3 = "ResourcesFlusher";
        if (!k.b) {
            z = 1;
            declaredField = Resources.class.getDeclaredField("mDrawableCache");
            k.a = declaredField;
            declaredField.setAccessible(z);
            k.b = z;
        }
        field = k.a;
        if (field != null) {
            int i = 0;
            declaredField = obj4;
            try {
                if (declaredField != null) {
                }
                declaredField.clear();
            } catch (java.lang.IllegalAccessException illegalAccess) {
            }
        }
    }

    private static void c(Resources resources) {
        boolean z;
        int i;
        Field declaredField;
        Field field;
        String str;
        Object obj4;
        final String str2 = "ResourcesFlusher";
        if (!k.b) {
            z = 1;
            declaredField = Resources.class.getDeclaredField("mDrawableCache");
            k.a = declaredField;
            declaredField.setAccessible(z);
            k.b = z;
        }
        i = 0;
        field = k.a;
        if (field != null) {
            i = field.get(resources);
        }
        try {
            if (i == 0) {
            }
            k.e(i);
        } catch (java.lang.IllegalAccessException illegalAccess) {
        }
    }

    private static void d(Resources resources) {
        Field declaredField2;
        Field field2;
        Field declaredField;
        Field field;
        String str;
        int i;
        String str2;
        Object obj5;
        final int i2 = 1;
        final String str4 = "ResourcesFlusher";
        if (!k.h) {
            declaredField2 = Resources.class.getDeclaredField("mResourcesImpl");
            k.g = declaredField2;
            declaredField2.setAccessible(i2);
            k.h = i2;
        }
        field2 = k.g;
        if (field2 == null) {
        }
        i = 0;
        obj5 = field2.get(resources);
        if (obj5 == null) {
        }
        if (!k.b) {
            declaredField = obj5.getClass().getDeclaredField("mDrawableCache");
            k.a = declaredField;
            declaredField.setAccessible(i2);
            k.b = i2;
        }
        field = k.a;
        if (field != null) {
            i = field.get(obj5);
        }
        if (i != 0) {
            k.e(i);
        }
    }

    private static void e(Object object) {
        Class forName;
        Field declaredField;
        Field field;
        String str;
        String str2;
        Object obj4;
        int i = 1;
        final String str5 = "ResourcesFlusher";
        if (!k.d) {
            k.c = Class.forName("android.content.res.ThemedResourceCache");
            k.d = i;
        }
        declaredField = k.c;
        if (declaredField == null) {
        }
        if (!k.f) {
            try {
                declaredField = declaredField.getDeclaredField("mUnthemedEntries");
                k.e = declaredField;
                declaredField.setAccessible(i);
                str = "Could not retrieve ThemedResourceCache#mUnthemedEntries field";
                Log.e(obj2, str, str3);
                k.f = i;
                field = k.e;
                if (field == null) {
                }
                int i2 = 0;
                Object obj = obj4;
                Throwable str3 = "Could not retrieve value from ThemedResourceCache#mUnthemedEntries";
                Log.e(obj2, str3, object);
            } catch (java.lang.NoSuchFieldException noSuchField) {
            }
            obj.clear();
        }
    }
}
