package androidx.core.content.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import d.h.f.d;
import d.h.k.c;
import d.h.k.i;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f {

    private static final java.lang.ThreadLocal<TypedValue> a;
    private static final WeakHashMap<androidx.core.content.e.f.b, SparseArray<androidx.core.content.e.f.a>> b;
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

    private static final class b {

        final Resources a;
        final Resources.Theme b;
        b(Resources resources, Resources.Theme resources$Theme2) {
            super();
            this.a = resources;
            this.b = theme2;
        }

        public boolean equals(Object object) {
            int i;
            Resources.Theme equals;
            Class<androidx.core.content.e.f.b> obj;
            Class class;
            boolean obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (f.b.class != object.getClass()) {
                } else {
                    if (this.a.equals(object.a) && c.a(this.b, object.b)) {
                        if (c.a(this.b, object.b)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            Object[] arr = new Object[2];
            return c.b(this.a, this.b);
        }
    }

    public static abstract class c {
        public static Handler c(Handler handler) {
            Looper mainLooper;
            Handler obj1;
            if (handler == null) {
                obj1 = new Handler(Looper.getMainLooper());
            }
            return obj1;
        }

        public final void a(int i, Handler handler2) {
            f.c.b bVar = new f.c.b(this, i);
            f.c.c(handler2).post(bVar);
        }

        public final void b(Typeface typeface, Handler handler2) {
            f.c.a aVar = new f.c.a(this, typeface);
            f.c.c(handler2).post(aVar);
        }

        public abstract void d(int i);

        public abstract void e(Typeface typeface);
    }

    public static final class d {
        public static void a(Resources.Theme resources$Theme) {
            int i;
            final int sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 29) {
                f.d.b.a(theme);
            } else {
                if (sDK_INT >= 23) {
                    f.d.a.a(theme);
                }
            }
        }
    }
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        f.a = threadLocal;
        WeakHashMap weakHashMap = new WeakHashMap(0);
        f.b = weakHashMap;
        Object object = new Object();
        f.c = object;
    }

    private static void a(androidx.core.content.e.f.b f$b, int i2, ColorStateList colorStateList3) {
        Object sparseArray;
        final Object obj = f.c;
        WeakHashMap map = f.b;
        synchronized (obj) {
            sparseArray = new SparseArray();
            map.put(b, sparseArray);
            f.a aVar = new f.a(colorStateList3, b.a.getConfiguration());
            sparseArray.append(i2, aVar);
        }
    }

    private static ColorStateList b(androidx.core.content.e.f.b f$b, int i2) {
        int size;
        Configuration configuration;
        Object obj4;
        final Object obj = f.c;
        Object obj2 = f.b.get(b);
        synchronized (obj) {
            if ((SparseArray)obj2.size() > 0) {
                size = obj2.get(i2);
                if ((f.a)size != null) {
                    try {
                        if (size.b.equals(b.a.getConfiguration())) {
                        }
                        return size.a;
                        obj2.remove(i2);
                        return null;
                        throw b;
                    }
                }
            }
        }
    }

    public static Typeface c(Context context, int i2) {
        if (context.isRestricted()) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        return f.m(context, i2, typedValue, 0, 0, 0, false, true);
    }

    public static int d(Resources resources, int i2, Resources.Theme resources$Theme3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColor(i2, theme3);
        }
        return resources.getColor(i2);
    }

    public static ColorStateList e(Resources resources, int i2, Resources.Theme resources$Theme3) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i2, theme3);
        }
        f.b bVar = new f.b(resources, theme3);
        ColorStateList list = f.b(bVar, i2);
        if (list != null) {
            return list;
        }
        final ColorStateList obj4 = f.k(resources, i2, theme3);
        if (obj4 != null) {
            f.a(bVar, i2, obj4);
            return obj4;
        }
        return resources.getColorStateList(i2);
    }

    public static Drawable f(Resources resources, int i2, Resources.Theme resources$Theme3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i2, theme3);
        }
        return resources.getDrawable(i2);
    }

    public static Typeface g(Context context, int i2) {
        if (context.isRestricted()) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        return f.m(context, i2, typedValue, 0, 0, 0, false, false);
    }

    public static Typeface h(Context context, int i2, TypedValue typedValue3, int i4, androidx.core.content.e.f.c f$c5) {
        if (context.isRestricted()) {
            return null;
        }
        return f.m(context, i2, typedValue3, i4, c5, 0, true, false);
    }

    public static void i(Context context, int i2, androidx.core.content.e.f.c f$c3, Handler handler4) {
        i.c(c3);
        if (context.isRestricted()) {
            c3.a(-4, handler4);
        }
        TypedValue typedValue = new TypedValue();
        f.m(context, i2, typedValue, 0, c3, handler4, false, false);
    }

    private static TypedValue j() {
        Object typedValue;
        final java.lang.ThreadLocal threadLocal = f.a;
        if ((TypedValue)threadLocal.get() == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        return typedValue;
    }

    private static ColorStateList k(Resources resources, int i2, Resources.Theme resources$Theme3) {
        if (f.l(resources, i2)) {
            return null;
        }
        return a.a(resources, resources.getXml(i2), theme3);
    }

    private static boolean l(Resources resources, int i2) {
        int i;
        int obj3;
        final TypedValue typedValue = f.j();
        resources.getValue(i2, typedValue, true);
        final int obj2 = typedValue.type;
        if (obj2 >= 28 && obj2 <= 31) {
            if (obj2 <= 31) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static Typeface m(Context context, int i2, TypedValue typedValue3, int i4, androidx.core.content.e.f.c f$c5, Handler handler6, boolean z7, boolean z8) {
        Resources resources = context.getResources();
        final int i6 = i2;
        resources.getValue(i2, typedValue3, true);
        Typeface typeface = f.n(context, resources, typedValue3, i2, i4, c5, handler6, z7, z8);
        if (typeface == null && c5 == null) {
            if (c5 == null) {
                if (!z8) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Font resource ID #0x");
                stringBuilder.append(Integer.toHexString(i2));
                stringBuilder.append(" could not be retrieved.");
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
                throw notFoundException;
            }
        }
        return typeface;
    }

    private static Typeface n(Context context, Resources resources2, TypedValue typedValue3, int i4, int i5, androidx.core.content.e.f.c f$c6, Handler handler7, boolean z8, boolean z9) {
        StringBuilder string;
        String str;
        Resources resources = resources2;
        Object obj = typedValue3;
        int i = i4;
        int i3 = i5;
        final androidx.core.content.e.f.c cVar2 = c6;
        final Handler handler2 = handler7;
        java.lang.CharSequence string3 = obj.string;
        if (string3 == null) {
        } else {
            final String string4 = string3.toString();
            final int i7 = -3;
            final int i8 = 0;
            if (!string4.startsWith("res/") && cVar2 != null) {
                if (cVar2 != null) {
                    cVar2.a(i7, handler2);
                }
                return i8;
            }
            Typeface typeface3 = d.f(resources, i, i3);
            if (typeface3 != null && cVar2 != null) {
                if (cVar2 != null) {
                    cVar2.b(typeface3, handler2);
                }
                return typeface3;
            }
            if (z9) {
                return i8;
            }
            androidx.core.content.e.c.a aVar = c.b(resources.getXml(i), resources);
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (string4.toLowerCase().endsWith(".xml") && aVar == null && cVar2 != null) {
                aVar = c.b(resources.getXml(i), resources);
                if (aVar == null) {
                    Log.e(str8, "Failed to find font-family tag");
                    if (cVar2 != null) {
                        cVar2.a(i7, handler2);
                    }
                    return i8;
                }
                return d.c(context, aVar, resources2, i4, i5, c6, handler7, z8);
            }
            Context context2 = context;
            Typeface typeface = d.d(context, resources, i, string4, i3);
            if (cVar2 != null) {
                if (typeface != null) {
                    cVar2.b(typeface, handler2);
                } else {
                    cVar2.a(i7, handler2);
                }
            }
            return typeface;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resource \"");
        stringBuilder.append(resources.getResourceName(i));
        stringBuilder.append("\" (");
        stringBuilder.append(Integer.toHexString(i4));
        stringBuilder.append(") is not a Font: ");
        stringBuilder.append(obj);
        Resources.NotFoundException notFoundException = new Resources.NotFoundException(stringBuilder.toString());
        throw notFoundException;
    }
}
