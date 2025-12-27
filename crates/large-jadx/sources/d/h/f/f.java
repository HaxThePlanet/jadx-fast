package d.h.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.e.c.b;
import androidx.core.content.e.c.c;
import d.e.g;
import d.h.i.f.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
class f extends j {

    private static final Class<?> b;
    private static final Constructor<?> c;
    private static final Method d;
    private static final Method e;
    static {
        Throwable th;
        Class cls;
        Method method;
        Method method2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            int i2 = 0;
            Class[] arr2 = new Class[5];
            arr2[i2] = ByteBuffer.class;
            Class tYPE2 = Integer.TYPE;
            int i5 = 1;
            arr2[i5] = tYPE2;
            arr2[2] = List.class;
            arr2[3] = tYPE2;
            arr2[4] = Boolean.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", arr2);
            Class[] arr3 = new Class[i5];
            arr3[i2] = Array.newInstance(cls, i5).getClass();
        } catch (java.lang.NoSuchMethodException noSuchMethod) {
        } catch (java.lang.ClassNotFoundException classNotFound1) {
        }
        f.c = constructor;
        f.b = cls;
        f.d = method2;
        f.e = method;
    }

    f() {
        super();
    }

    private static boolean k(Object object, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            Object[] arr = new Object[5];
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return z;
        }
        return (Boolean)f.d.invoke(object, new Object[] { byteBuffer, Integer.valueOf(i), 0, Integer.valueOf(i2), Boolean.valueOf(z) }).booleanValue();
    }

    private static Typeface l(Object object) {
        try {
            int i2 = 1;
            Object array = Array.newInstance(f.b, i2);
            final int i3 = 0;
            Array.set(array, i3, object);
            Object[] arr = new Object[i2];
            arr[i3] = array;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return obj;
        }
        return (Typeface)f.e.invoke(null, arr);
    }

    public static boolean m() {
        boolean z = true;
        Method method = f.d;
        if (f.d == null) {
            str = "TypefaceCompatApi24Impl";
            str2 = "Unable to collect necessary private methods.Fallback to legacy implementation.";
            Log.w(str, str2);
        }
        int r0 = f.d != null ? 1 : 0;
        return (f.d != null ? 1 : 0);
    }

    private static Object n() {
        try {
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
        return f.c.newInstance(new Object[0]);
    }

    @Override // d.h.f.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        final Object obj = f.n();
        final int i5 = 0;
        if (obj == null) {
            return null;
        }
        final c.c[] objArr = bVar.a();
        i = 0;
        for (c.c cVar : objArr) {
            ByteBuffer byteBuffer = k.b(context, resources, cVar.b());
            if (!f.k(obj, byteBuffer, cVar.c(), cVar.e(), cVar.f())) {
                return i5;
            }
        }
        return f.l(obj);
    }

    @Override // d.h.f.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        ByteBuffer byteBuffer;
        final Object obj = f.n();
        final int i5 = 0;
        if (obj == null) {
            return null;
        }
        final g gVar = new g();
        i = 0;
        for (Object obj2 : bVarArr) {
            android.net.Uri uri = obj2.d();
            if (!f.k(obj, byteBuffer, obj2.c(), obj2.e(), obj2.f())) {
                return i5;
            }
        }
        Typeface typeface = f.l(obj);
        if (typeface == null) {
            return i5;
        }
        return Typeface.create(typeface, i);
    }
}
