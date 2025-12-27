package d.h.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.e.c.b;
import androidx.core.content.e.c.c;
import d.h.i.f.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class g extends e {

    protected final Class<?> g;
    protected final Constructor<?> h;
    protected final Method i;
    protected final Method j;
    protected final Method k;
    protected final Method l;
    protected final Method m;
    public g() {
        Throwable th;
        Method method;
        Constructor constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        super();
        try {
            Class cls = y();
            constructor = z(cls);
            method2 = v(cls);
            method3 = w(cls);
            method4 = A(cls);
            method5 = u(cls);
        } catch (java.lang.NoSuchMethodException noSuchMethod) {
        } catch (java.lang.ClassNotFoundException classNotFound1) {
        }
        this.g = cls;
        this.h = constructor;
        this.i = method2;
        this.j = method3;
        this.k = method4;
        this.l = method5;
        this.m = method;
    }

    private Object o() {
        try {
        } catch (java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
        return this.h.newInstance(new Object[0]);
    }

    private void p(Object object) {
        try {
            this.l.invoke(object, new Object[0]);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return;
        }
    }

    private boolean q(Context context, Object object, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        i = 0;
        try {
            Object[] arr = new Object[8];
            arr[i] = context.getAssets();
            arr[1] = str;
            arr[2] = Integer.valueOf(i);
            arr[3] = Boolean.FALSE;
            arr[4] = Integer.valueOf(i);
            arr[5] = Integer.valueOf(i2);
            arr[6] = Integer.valueOf(i3);
            arr[7] = fontVariationAxisArr;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return z;
        }
        return (Boolean)this.i.invoke(object, arr).booleanValue();
    }

    private boolean r(Object object, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            Object[] arr = new Object[5];
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return z;
        }
        return (Boolean)this.j.invoke(object, new Object[] { byteBuffer, Integer.valueOf(i), 0, Integer.valueOf(i2), Integer.valueOf(i3) }).booleanValue();
    }

    private boolean s(Object object) {
        try {
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return z;
        }
        return (Boolean)this.k.invoke(object, new Object[0]).booleanValue();
    }

    private boolean t() {
        boolean z = true;
        if (this.i == null) {
            str = "Unable to collect necessary private methods. Fallback to legacy implementation.";
            Log.w("TypefaceCompatApi26Impl", str);
        }
        int r0 = this.i != null ? 1 : 0;
        return (this.i != null ? 1 : 0);
    }

    @Override // d.h.f.e
    protected Method A(Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    @Override // d.h.f.e
    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        if (!t()) {
            return super.b(context, bVar, resources, i);
        }
        final Object resources32 = o();
        final int i5 = 0;
        if (resources32 == null) {
            return null;
        }
        final c.c[] objArr = bVar.a();
        i = 0;
        for (c.c cVar : objArr) {
            if (!this.q(context, resources32, cVar.a(), cVar.c(), cVar.e(), cVar.f(), FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                p(resources32);
                return i5;
            }
        }
        if (!s(resources32)) {
            return i5;
        }
        return l(resources32);
    }

    @Override // d.h.f.e
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        Object cancellationSignal22;
        int i2;
        int i3;
        boolean z;
        i = 1;
        final int i5 = 0;
        if (bVarArr.length < i) {
            return null;
        }
        if (!t()) {
            f.b bVar2 = h(bVarArr, i);
            try {
                ParcelFileDescriptor fileDescriptor = context.getContentResolver().openFileDescriptor(bVar2.d(), "r", cancellationSignal);
                if (fileDescriptor != null) {
                    fileDescriptor.close();
                }
            } catch (Throwable th) {
            }
            try {
            } catch (Throwable th) {
            }
            if (fileDescriptor != null) {
                try {
                    fileDescriptor.close();
                } catch (Throwable th) {
                }
            }
            return new Typeface.Builder(fileDescriptor.getFileDescriptor()).setWeight(bVar2.e()).setItalic(bVar2.f()).build();
        }
        cancellationSignal22 = o();
        if (cancellationSignal22 == null) {
            return i5;
        }
        i = 0;
        for (f.b bVar : bVarArr) {
            Object value = k.h(context, bVarArr, th).get(bVar.d());
            if (value != null) {
            }
        }
        if (i == 0) {
            p(cancellationSignal22);
            return i5;
        }
        if (!s(cancellationSignal22)) {
            return i5;
        }
        Typeface typeface = l(cancellationSignal22);
        if (typeface == null) {
            return i5;
        }
        return Typeface.create(typeface, i);
    }

    @Override // d.h.f.e
    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        if (!t()) {
            return super.e(context, resources, i, str, i2);
        }
        final Object resources22 = o();
        final int i7 = 0;
        if (resources22 == null) {
            return null;
        }
        if (!this.q(context, resources22, str, 0, -1, -1, null)) {
            p(resources22);
            return i7;
        }
        if (!s(resources22)) {
            return i7;
        }
        return l(resources22);
    }

    @Override // d.h.f.e
    protected Typeface l(Object object) {
        try {
            int i3 = 1;
            Object array = Array.newInstance(this.g, i3);
            int i5 = 0;
            Array.set(array, i5, object);
            Object[] arr = new Object[3];
            arr[i5] = array;
            int i2 = -1;
            arr[i3] = Integer.valueOf(i2);
            arr[2] = Integer.valueOf(i2);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            return obj;
        }
        return (Typeface)this.m.invoke(null, arr);
    }

    @Override // d.h.f.e
    protected Method u(Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    @Override // d.h.f.e
    protected Method v(Class<?> cls) throws java.lang.NoSuchMethodException {
        Class[] arr = new Class[8];
        Class tYPE2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, tYPE2, Boolean.TYPE, tYPE2, tYPE2, tYPE2, FontVariationAxis[].class });
    }

    @Override // d.h.f.e
    protected Method w(Class<?> cls) throws java.lang.NoSuchMethodException {
        Class[] arr = new Class[5];
        Class tYPE2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, tYPE2, FontVariationAxis[].class, tYPE2, tYPE2 });
    }

    @Override // d.h.f.e
    protected Method x(Class<?> cls) throws java.lang.NoSuchMethodException {
        final int i = 1;
        Class[] arr = new Class[3];
        Class tYPE2 = Integer.TYPE;
        arr[i] = tYPE2;
        arr[2] = tYPE2;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // d.h.f.e
    protected Class<?> y() throws java.lang.ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    @Override // d.h.f.e
    protected Constructor<?> z(Class<?> cls) throws java.lang.NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }
}
