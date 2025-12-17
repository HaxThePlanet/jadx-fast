package d.a.k.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.j0;
import androidx.core.content.a;
import androidx.core.content.e.a;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a {

    private static final java.lang.ThreadLocal<TypedValue> a;
    private static final WeakHashMap<Context, SparseArray<d.a.k.a.a.a>> b;
    private static final Object c;

    private static class a {

        final ColorStateList a;
        final Configuration b;
        a(ColorStateList colorStateList, Configuration configuration2) {
            super();
            this.a = colorStateList;
            this.b = configuration2;
        }
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        a.a = threadLocal;
        WeakHashMap weakHashMap = new WeakHashMap(0);
        a.b = weakHashMap;
        Object object = new Object();
        a.c = object;
    }

    private static void a(Context context, int i2, ColorStateList colorStateList3) {
        Object sparseArray;
        final Object obj = a.c;
        WeakHashMap map = a.b;
        synchronized (obj) {
            sparseArray = new SparseArray();
            map.put(context, sparseArray);
            a.a aVar = new a.a(colorStateList3, context.getResources().getConfiguration());
            sparseArray.append(i2, aVar);
        }
    }

    private static ColorStateList b(Context context, int i2) {
        int size;
        Configuration configuration;
        Object obj4;
        final Object obj = a.c;
        Object obj2 = a.b.get(context);
        synchronized (obj) {
            if ((SparseArray)obj2.size() > 0) {
                size = obj2.get(i2);
                if ((a.a)size != null) {
                    try {
                        if (size.b.equals(context.getResources().getConfiguration())) {
                        }
                        return size.a;
                        obj2.remove(i2);
                        return null;
                        throw context;
                    }
                }
            }
        }
    }

    public static ColorStateList c(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList list = a.b(context, i2);
        if (list != null) {
            return list;
        }
        ColorStateList list2 = a.f(context, i2);
        if (list2 != null) {
            a.a(context, i2, list2);
            return list2;
        }
        return a.e(context, i2);
    }

    public static Drawable d(Context context, int i2) {
        return j0.h().j(context, i2);
    }

    private static TypedValue e() {
        Object typedValue;
        final java.lang.ThreadLocal threadLocal = a.a;
        if ((TypedValue)threadLocal.get() == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        return typedValue;
    }

    private static ColorStateList f(Context context, int i2) {
        if (a.g(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        return a.a(resources, resources.getXml(i2), context.getTheme());
    }

    private static boolean g(Context context, int i2) {
        int i;
        int obj3;
        final TypedValue typedValue = a.e();
        context.getResources().getValue(i2, typedValue, true);
        int obj2 = typedValue.type;
        if (obj2 >= 28 && obj2 <= 31) {
            if (obj2 <= 31) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
