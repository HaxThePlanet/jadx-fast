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
import java.util.WeakHashMap;

/* compiled from: AppCompatResources.java */
/* loaded from: classes.dex */
public final class a {

    private static final java.lang.ThreadLocal<TypedValue> a = new ThreadLocal<>();
    private static final WeakHashMap<Context, SparseArray<a.a>> b = new WeakHashMap<>(0);
    private static final Object c = new Object();

    private static class a {

        final ColorStateList a;
        final Configuration b;
        a(ColorStateList list, Configuration configuration) {
            super();
            this.a = list;
            this.b = configuration;
        }
    }

    private static void a(Context context, int i, ColorStateList list) {
        Object value;
        final Object obj2 = a.c;
        synchronized (obj2) {
            try {
                WeakHashMap weakHashMap = a.b;
                if ((SparseArray)weakHashMap.get(context) == null) {
                    a.b.put(context, new SparseArray());
                }
                value.append(i, new a.a(list, context.getResources().getConfiguration()));
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    private static ColorStateList b(Context context, int i) {
        final Object obj2 = a.c;
        synchronized (obj2) {
            try {
                Object value = a.b.get(context);
                if (value != null && value.size() > 0) {
                    Object obj3 = value.get(i);
                    if (obj3 != null) {
                        if (obj3.b.equals(context.getResources().getConfiguration())) {
                            return obj3.a;
                        }
                        value.remove(i);
                    }
                }
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public static ColorStateList c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList colorStateList = a.b(context, i);
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList colorStateList2 = a.f(context, i);
        if (colorStateList2 != null) {
            a.a(context, i, colorStateList2);
            return colorStateList2;
        }
        return a.e(context, i);
    }

    public static Drawable d(Context context, int i) {
        return j0.h().j(context, i);
    }

    private static TypedValue e() {
        Object obj;
        final java.lang.ThreadLocal threadLocal = a.a;
        if ((TypedValue)threadLocal.get() == null) {
            a.a.set(new TypedValue());
        }
        return obj;
    }

    private static ColorStateList f(Context context, int i) throws android.content.res.Resources.NotFoundException {
        if (a.g(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
        } catch (Exception e) {
            i = "AppCompatResources";
            Log.e(i, "Failed to inflate ColorStateList, leaving it to the framework", e);
            return obj;
        }
        return a.a(resources, resources.getXml(i), context.getTheme());
    }

    private static boolean g(Context context, int i) throws android.content.res.Resources.NotFoundException {
        boolean z = false;
        final TypedValue typedValue = a.e();
        z = true;
        context.getResources().getValue(i, typedValue, z);
        i = 28;
        if (typedValue.type < 28 || typedValue.type > 31) {
            int i3 = 0;
        }
        return z;
    }
}
