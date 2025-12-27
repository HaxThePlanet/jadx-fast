package d.h.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;
import androidx.core.content.e.c.b;
import androidx.core.content.e.c.c;
import d.h.i.f.b;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi21Impl.java */
/* loaded from: classes.dex */
class e extends j {

    private static Class<?> b = null;
    private static Constructor<?> c = null;
    private static Method d = null;
    private static Method e = null;
    private static boolean f = false;
    e() {
        super();
    }

    private static boolean k(Object object, String str, int i, boolean z) {
        e.n();
        try {
            Object[] arr = new Object[3];
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
        } catch (java.lang.IllegalAccessException illegalAccess1) {
        }
        return (Boolean)e.d.invoke(object, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(z) }).booleanValue();
    }

    private static Typeface l(Object object) {
        e.n();
        try {
            int i = 1;
            Object array = Array.newInstance(e.b, i);
            final int i2 = 0;
            Array.set(array, i2, object);
            Object[] arr = new Object[i];
            arr[i2] = array;
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
        } catch (java.lang.IllegalAccessException illegalAccess1) {
        }
        return (Typeface)e.e.invoke(null, arr);
    }

    private File m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "/proc/self/fd/";
            int fd = parcelFileDescriptor.getFd();
            str2 = str + fd;
            String readlink = Os.readlink(str2);
        } catch (android.system.ErrnoException unused) {
            return null;
        }
        return new File(readlink);
    }

    private static void n() {
        Method method;
        Class cls;
        Method method2;
        if (e.f) {
            return;
        }
        boolean z2 = true;
        e.f = z2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            int i = 0;
            Class[] arr3 = new Class[3];
            arr3[i] = String.class;
            arr3[z2] = Integer.TYPE;
            arr3[2] = Boolean.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", arr3);
            Class[] arr = new Class[z2];
            arr[i] = Array.newInstance(cls, z2).getClass();
        } catch (java.lang.NoSuchMethodException noSuchMethod) {
        } catch (java.lang.ClassNotFoundException classNotFound1) {
        }
        e.c = constructor;
        e.b = cls;
        e.d = method2;
        e.e = method;
    }

    private static Object o() {
        e.n();
        try {
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
        } catch (java.lang.InstantiationException instantiation1) {
        } catch (java.lang.IllegalAccessException illegalAccess2) {
        }
        return e.c.newInstance(new Object[0]);
    }

    @Override // d.h.f.j
    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        final Object obj3 = e.o();
        final c.c[] objArr = bVar.a();
        i = 0;
        for (c.c cVar : objArr) {
            File file = k.e(context);
            try {
            } catch (RuntimeException unused) {
                obj.delete();
                return obj2;
            } finally {
                obj.delete();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) context;
            }
            try {
            } catch (RuntimeException unused) {
                obj.delete();
                return obj2;
            } finally {
                obj.delete();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) context;
            }
            if (e.k(obj3, file.getPath(), cVar.e(), cVar.f()) == null) {
                file.delete();
                return i2;
            }
        }
        return e.l(obj3);
    }

    @Override // d.h.f.j
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        i = 0;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            final ParcelFileDescriptor fileDescriptor = context.getContentResolver().openFileDescriptor(h(bVarArr, i).d(), "r", cancellationSignal);
            if (fileDescriptor != null) {
                fileDescriptor.close();
            }
        } catch (Throwable th) {
        }
        try {
            File file = m(fileDescriptor);
        } catch (Throwable th) {
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        } catch (Throwable th) {
        }
        try {
        } catch (Throwable th) {
        }
        try {
            fileInputStream.close();
        } catch (Throwable th) {
        }
        if (fileDescriptor != null) {
            try {
                fileDescriptor.close();
            } catch (Throwable th) {
            }
        }
        return super.d(th, fileInputStream);
    }

}
