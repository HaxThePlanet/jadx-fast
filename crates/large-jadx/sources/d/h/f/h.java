package d.h.f;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi28Impl.java */
/* loaded from: classes.dex */
public class h extends g {
    @Override // d.h.f.g
    protected Typeface l(Object object) {
        try {
            int i3 = 1;
            Object array = Array.newInstance(this.g, i3);
            int i5 = 0;
            Array.set(array, i5, object);
            Object[] arr = new Object[4];
            arr[i5] = array;
            arr[i3] = "sans-serif";
            int i4 = -1;
            arr[2] = Integer.valueOf(i4);
            arr[3] = Integer.valueOf(i4);
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
        } catch (java.lang.IllegalAccessException illegalAccess1) {
        }
        return (Typeface)this.m.invoke(null, arr);
    }

    @Override // d.h.f.g
    protected Method x(Class<?> cls) throws java.lang.NoSuchMethodException {
        final int i = 1;
        Class[] arr = new Class[4];
        arr[i] = String.class;
        Class tYPE2 = Integer.TYPE;
        arr[2] = tYPE2;
        arr[3] = tYPE2;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
