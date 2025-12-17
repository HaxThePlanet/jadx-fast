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
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
class f extends d.h.f.j {

    private static final Class<?> b;
    private static final Constructor<?> c;
    private static final Method d;
    private static final Method e;
    static {
        Throwable th;
        Class forName;
        Method method2;
        Constructor constructor;
        Method method;
        int i = 0;
        forName = Class.forName("android.graphics.FontFamily");
        int i2 = 0;
        Class[] arr2 = new Class[5];
        arr2[i2] = ByteBuffer.class;
        Class tYPE = Integer.TYPE;
        int i5 = 1;
        arr2[i5] = tYPE;
        arr2[2] = List.class;
        arr2[3] = tYPE;
        arr2[4] = Boolean.TYPE;
        method = forName.getMethod("addFontWeightStyle", arr2);
        Class[] arr3 = new Class[i5];
        arr3[i2] = Array.newInstance(forName, i5).getClass();
        method2 = method3;
        f.c = forName.getConstructor(new Class[i2]);
        f.b = forName;
        f.d = method;
        f.e = method2;
    }

    private static boolean k(Object object, ByteBuffer byteBuffer2, int i3, int i4, boolean z5) {
        Object[] arr = new Object[5];
        return (Boolean)f.d.invoke(object, byteBuffer2, Integer.valueOf(i3), 0, Integer.valueOf(i4), Boolean.valueOf(z5)).booleanValue();
    }

    private static Typeface l(Object object) {
        int i2 = 1;
        Object instance = Array.newInstance(f.b, i2);
        final int i3 = 0;
        Array.set(instance, i3, object);
        Object[] arr = new Object[i2];
        arr[i3] = instance;
        return (Typeface)f.e.invoke(0, arr);
    }

    public static boolean m() {
        int i;
        String str2;
        String str;
        Method method = f.d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        i = method != null ? 1 : 0;
        return i;
    }

    private static Object n() {
        try {
            return f.c.newInstance(new Object[0]);
            return null;
        }
    }

    @Override // d.h.f.j
    public Typeface b(Context context, c.b c$b2, Resources resources3, int i4) {
        int i3;
        boolean z;
        ByteBuffer byteBuffer;
        int i;
        int i2;
        final Object obj11 = f.n();
        final int i5 = 0;
        if (obj11 == null) {
            return i5;
        }
        final c.c[] obj9 = b2.a();
        i3 = 0;
        while (i3 < obj9.length) {
            c.c cVar = obj9[i3];
            byteBuffer = k.b(context, resources3, cVar.b());
            i3++;
        }
        return f.l(obj11);
    }

    @Override // d.h.f.j
    public Typeface c(Context context, CancellationSignal cancellationSignal2, f.b[] f$b3Arr3, int i4) {
        int i;
        boolean z;
        int i2;
        Object obj;
        int i3;
        final Object obj2 = f.n();
        final int i5 = 0;
        if (obj2 == null) {
            return i5;
        }
        g gVar = new g();
        i = 0;
        while (i < b3Arr3.length) {
            Object obj3 = b3Arr3[i];
            android.net.Uri uri = obj3.d();
            if ((ByteBuffer)gVar.get(uri) == null) {
            }
            i++;
            gVar.put(uri, k.f(context, cancellationSignal2, uri));
        }
        Typeface obj10 = f.l(obj2);
        if (obj10 == null) {
            return i5;
        }
        return Typeface.create(obj10, i4);
    }
}
