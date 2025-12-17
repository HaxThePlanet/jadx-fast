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
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes.dex */
public class g extends d.h.f.e {

    protected final Class<?> g;
    protected final Constructor<?> h;
    protected final Method i;
    protected final Method j;
    protected final Method k;
    protected final Method l;
    protected final Method m;
    public g() {
        Throwable th;
        Method method4;
        Constructor constructor;
        Method method;
        Method method2;
        Method method3;
        Method method5;
        super();
        int i = 0;
        Class cls2 = y();
        constructor = z(cls2);
        method = v(cls2);
        method2 = w(cls2);
        method3 = A(cls2);
        method5 = u(cls2);
        method4 = method6;
        try {
            this.g = cls2;
            this.h = constructor;
            this.i = method;
            this.j = method2;
            this.k = method3;
            this.l = method5;
            this.m = method4;
        }
    }

    private Object o() {
        try {
            return this.h.newInstance(new Object[0]);
            return null;
        }
    }

    private void p(Object object) {
        try {
            this.l.invoke(object, new Object[0]);
        }
    }

    private boolean q(Context context, Object object2, String string3, int i4, int i5, int i6, FontVariationAxis[] fontVariationAxis7Arr7) {
        final int i = 0;
        Object[] arr = new Object[8];
        arr[i] = context.getAssets();
        arr[1] = string3;
        arr[2] = Integer.valueOf(i);
        arr[3] = Boolean.FALSE;
        arr[4] = Integer.valueOf(i4);
        arr[5] = Integer.valueOf(i5);
        arr[6] = Integer.valueOf(i6);
        arr[7] = fontVariationAxis7Arr7;
        return (Boolean)this.i.invoke(object2, arr).booleanValue();
    }

    private boolean r(Object object, ByteBuffer byteBuffer2, int i3, int i4, int i5) {
        Object[] arr = new Object[5];
        return (Boolean)this.j.invoke(object, byteBuffer2, Integer.valueOf(i3), 0, Integer.valueOf(i4), Integer.valueOf(i5)).booleanValue();
    }

    private boolean s(Object object) {
        return (Boolean)this.k.invoke(object, new Object[0]).booleanValue();
    }

    private boolean t() {
        Object str2;
        int i;
        String str;
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        i = this.i != null ? 1 : 0;
        return i;
    }

    protected Method A(Class<?> class) {
        return class.getMethod("freeze", new Class[0]);
    }

    @Override // d.h.f.e
    public Typeface b(Context context, c.b c$b2, Resources resources3, int i4) {
        int i5;
        Context context2;
        Object obj;
        String str;
        int i;
        int i3;
        boolean z;
        FontVariationAxis[] fontVariationSettings;
        int i2;
        if (!t()) {
            return super.b(context, b2, resources3, i4);
        }
        final Object obj13 = o();
        final int obj14 = 0;
        if (obj13 == null) {
            return obj14;
        }
        final c.c[] obj12 = b2.a();
        i2 = i5;
        while (i2 < obj12.length) {
            c.c cVar = obj12[i2];
            i2++;
        }
        if (!s(obj13)) {
            return obj14;
        }
        return l(obj13);
    }

    @Override // d.h.f.e
    public Typeface c(Context context, CancellationSignal cancellationSignal2, f.b[] f$b3Arr3, int i4) {
        int i;
        f.b bVar;
        Object obj;
        int i2;
        int i3;
        boolean z;
        int i5;
        final int i6 = 1;
        final int i7 = 0;
        if (b3Arr3.length < i6) {
            return i7;
        }
        f.b obj13 = h(b3Arr3, i4);
        ParcelFileDescriptor obj11 = context.getContentResolver().openFileDescriptor(obj13.d(), "r", cancellationSignal2);
        if (!t() && obj11 == null && obj11 != null) {
            obj13 = h(b3Arr3, i4);
            obj11 = context.getContentResolver().openFileDescriptor(obj13.d(), "r", cancellationSignal2);
            if (obj11 == null) {
                if (obj11 != null) {
                    obj11.close();
                }
                return i7;
            }
            Typeface.Builder obj12 = new Typeface.Builder(obj11.getFileDescriptor());
            if (obj11 != null) {
                obj11.close();
            }
            return obj12.setWeight(obj13.e()).setItalic(obj13.f()).build();
        }
        obj12 = o();
        if (obj12 == null) {
            return i7;
        }
        i5 = i;
        while (i5 < b3Arr3.length) {
            bVar = b3Arr3[i5];
            obj = k.h(context, b3Arr3, cancellationSignal2).get(bVar.d());
            i = i6;
            i5++;
        }
        if (i == 0) {
            p(obj12);
            return i7;
        }
        if (!s(obj12)) {
            return i7;
        }
        obj11 = l(obj12);
        if (obj11 == null) {
            return i7;
        }
        return Typeface.create(obj11, i4);
    }

    @Override // d.h.f.e
    public Typeface e(Context context, Resources resources2, int i3, String string4, int i5) {
        if (!t()) {
            return super.e(context, resources2, i3, string4, i5);
        }
        final Object obj10 = o();
        final int obj11 = 0;
        if (obj10 == null) {
            return obj11;
        }
        if (!this.q(context, obj10, string4, 0, -1, -1, 0)) {
            p(obj10);
            return obj11;
        }
        if (!s(obj10)) {
            return obj11;
        }
        return l(obj10);
    }

    @Override // d.h.f.e
    protected Typeface l(Object object) {
        int i3 = 1;
        Object instance = Array.newInstance(this.g, i3);
        int i5 = 0;
        Array.set(instance, i5, object);
        Object[] arr = new Object[3];
        arr[i5] = instance;
        int i2 = -1;
        arr[i3] = Integer.valueOf(i2);
        arr[2] = Integer.valueOf(i2);
        return (Typeface)this.m.invoke(0, arr);
    }

    protected Method u(Class<?> class) {
        return class.getMethod("abortCreation", new Class[0]);
    }

    protected Method v(Class<?> class) {
        Class[] arr = new Class[8];
        Class tYPE = Integer.TYPE;
        return class.getMethod("addFontFromAssetManager", AssetManager.class, String.class, tYPE, Boolean.TYPE, tYPE, tYPE, tYPE, FontVariationAxis[].class);
    }

    protected Method w(Class<?> class) {
        Class[] arr = new Class[5];
        Class tYPE = Integer.TYPE;
        return class.getMethod("addFontFromBuffer", ByteBuffer.class, tYPE, FontVariationAxis[].class, tYPE, tYPE);
    }

    protected Method x(Class<?> class) {
        final int i = 1;
        Class[] arr = new Class[3];
        Class obj5 = Integer.TYPE;
        arr[i] = obj5;
        arr[2] = obj5;
        obj5 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arr);
        obj5.setAccessible(i);
        return obj5;
    }

    protected Class<?> y() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> z(Class<?> class) {
        return class.getConstructor(new Class[0]);
    }
}
