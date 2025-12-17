package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class TypefaceCompatApi28Impl extends androidx.core.graphics.TypefaceCompatApi26Impl {

    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    protected Typeface createFromFamiliesWithDefault(Object family) {
        try {
            Object instance = Array.newInstance(this.mFontFamily, 1);
            Array.set(instance, 0, family);
            int i3 = -1;
            return (Typeface)this.mCreateFromFamiliesWithDefault.invoke(0, /* result */);
            RuntimeException runtimeException = new RuntimeException(familyArray);
            throw runtimeException;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    Typeface createWeightStyle(Context context, Typeface base, int weight, boolean italic) {
        return Typeface.create(base, weight, italic);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> class) throws java.lang.NoSuchMethodException {
        final int i = 1;
        Class[] arr = new Class[4];
        arr[i] = String.class;
        arr[2] = Integer.TYPE;
        arr[3] = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arr);
        declaredMethod.setAccessible(i);
        return declaredMethod;
    }
}
