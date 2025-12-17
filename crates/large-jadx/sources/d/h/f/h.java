package d.h.f;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class h extends d.h.f.g {
    @Override // d.h.f.g
    protected Typeface l(Object object) {
        try {
            int i3 = 1;
            Object instance = Array.newInstance(this.g, i3);
            int i5 = 0;
            Array.set(instance, i5, object);
            Object[] arr = new Object[4];
            arr[i5] = instance;
            arr[i3] = "sans-serif";
            int i4 = -1;
            arr[2] = Integer.valueOf(i4);
            arr[3] = Integer.valueOf(i4);
            return (Typeface)this.m.invoke(0, arr);
            RuntimeException runtimeException = new RuntimeException(object);
            throw runtimeException;
        }
    }

    protected Method x(Class<?> class) {
        final int i = 1;
        Class[] arr = new Class[4];
        arr[i] = String.class;
        Class obj5 = Integer.TYPE;
        arr[2] = obj5;
        arr[3] = obj5;
        obj5 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arr);
        obj5.setAccessible(i);
        return obj5;
    }
}
