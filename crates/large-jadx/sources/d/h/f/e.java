package d.h.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.e.c.b;
import androidx.core.content.e.c.c;
import d.h.i.f.b;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class e extends d.h.f.j {

    private static Class<?> b = null;
    private static Constructor<?> c = null;
    private static Method d = null;
    private static Method e = null;
    private static boolean f = false;
    static {
    }

    private static boolean k(Object object, String string2, int i3, boolean z4) {
        e.n();
        Object[] arr = new Object[3];
        return (Boolean)e.d.invoke(object, string2, Integer.valueOf(i3), Boolean.valueOf(z4)).booleanValue();
    }

    private static Typeface l(Object object) {
        e.n();
        int i = 1;
        Object instance = Array.newInstance(e.b, i);
        final int i2 = 0;
        Array.set(instance, i2, object);
        Object[] arr = new Object[i];
        arr[i2] = instance;
        return (Typeface)e.e.invoke(0, arr);
    }

    private File m(ParcelFileDescriptor parcelFileDescriptor) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/proc/self/fd/");
        stringBuilder.append(parcelFileDescriptor.getFd());
        String obj4 = Os.readlink(stringBuilder.toString());
        if (OsConstants.S_ISREG(stat.st_mode)) {
            try {
                File file = new File(obj4);
                return file;
                return null;
            }
        }
    }

    private static void n() {
        Method method2;
        Class forName;
        int i;
        Method method;
        if (e.f) {
        }
        int i2 = 1;
        e.f = i2;
        int i3 = 0;
        forName = Class.forName("android.graphics.FontFamily");
        i = 0;
        Class[] arr3 = new Class[3];
        arr3[i] = String.class;
        arr3[i2] = Integer.TYPE;
        arr3[2] = Boolean.TYPE;
        method = forName.getMethod("addFontWeightStyle", arr3);
        Class[] arr = new Class[i2];
        arr[i] = Array.newInstance(forName, i2).getClass();
        method2 = method3;
        e.c = forName.getConstructor(new Class[i]);
        e.b = forName;
        e.d = method;
        e.e = method2;
    }

    private static Object o() {
        e.n();
        return e.c.newInstance(new Object[0]);
    }

    @Override // d.h.f.j
    public Typeface b(Context context, c.b c$b2, Resources resources3, int i4) {
        int i;
        boolean z;
        File file;
        int i3;
        String path;
        int i2;
        final Object obj11 = e.o();
        final c.c[] obj9 = b2.a();
        i = 0;
        while (i < obj9.length) {
            c.c cVar = obj9[i];
            file = k.e(context);
            i3 = 0;
            file.delete();
            i++;
        }
        return e.l(obj11);
    }

    @Override // d.h.f.j
    public Typeface c(Context context, CancellationSignal cancellationSignal2, f.b[] f$b3Arr3, int i4) {
        ContentResolver obj7;
        final int i = 0;
        if (b3Arr3.length < 1) {
            return i;
        }
        final ParcelFileDescriptor obj5 = context.getContentResolver().openFileDescriptor(h(b3Arr3, i4).d(), "r", cancellationSignal2);
        if (obj5 == null && obj5 != null) {
            if (obj5 != null) {
                obj5.close();
            }
            return i;
        }
        File obj6 = m(obj5);
        if (obj6 != null) {
            if (!obj6.canRead()) {
            } else {
                if (obj5 != null) {
                    obj5.close();
                }
            }
            return Typeface.createFromFile(obj6);
        }
        obj6 = new FileInputStream(obj5.getFileDescriptor());
        obj6.close();
        if (obj5 != null) {
            obj5.close();
        }
        try {
            return super.d(context, obj6);
            b3Arr3.close();
            context.addSuppressed(b3Arr3);
            throw context;
            if (cancellationSignal2 == null) {
            } else {
            }
            cancellationSignal2.close();
            context.addSuppressed(cancellationSignal2);
            throw context;
            return obj1;
        } catch (Throwable th) {
        }
    }
}
