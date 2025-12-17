package d.u;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class l0 {

    private static Method a;
    private static boolean b;
    private static Field c;
    private static boolean d;
    private void b() {
        boolean z;
        Method declaredMethod;
        String str;
        Class[] str2;
        int i;
        Class tYPE;
        if (!l0.b) {
            z = 1;
            str2 = new Class[4];
            tYPE = Integer.TYPE;
            str2[z] = tYPE;
            str2[2] = tYPE;
            str2[3] = tYPE;
            declaredMethod = View.class.getDeclaredMethod("setFrame", str2);
            l0.a = declaredMethod;
            declaredMethod.setAccessible(z);
            l0.b = z;
        }
    }

    public void a(View view) {
        int visibility;
        int i;
        if (view.getVisibility() == 0) {
            view.setTag(j.a, 0);
        }
    }

    public float c(View view) {
        Object tag = view.getTag(j.a);
        if ((Float)tag != null) {
            return obj2 /= floatValue;
        }
        return view.getAlpha();
    }

    public void d(View view) {
        Object valueOf;
        final int i = j.a;
        if (view.getTag(i) == null) {
            view.setTag(i, Float.valueOf(view.getAlpha()));
        }
    }

    public void e(View view, int i2, int i3, int i4, int i5) {
        Object[] arr;
        int i;
        int obj5;
        int obj6;
        b();
        final Method method = l0.a;
        if (method != null) {
            arr = new Object[4];
            method.invoke(view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        }
    }

    public void f(View view, float f2) {
        int tag;
        tag = view.getTag(j.a);
        if ((Float)tag != null) {
            view.setAlpha(floatValue *= f2);
        } else {
            view.setAlpha(f2);
        }
    }

    public void g(View view, int i2) {
        boolean z;
        Field field;
        Field declaredField;
        String str;
        int obj5;
        if (!l0.d) {
            z = 1;
            declaredField = View.class.getDeclaredField("mViewFlags");
            l0.c = declaredField;
            declaredField.setAccessible(z);
            l0.d = z;
        }
        field = l0.c;
        if (field != null) {
            try {
                l0.c.setInt(view, i2 |= field);
            } catch (java.lang.IllegalAccessException illegalAccess) {
            }
        }
    }

    public void h(View view, Matrix matrix2) {
        android.view.ViewParent parent;
        boolean z;
        parent = view.getParent();
        if (parent instanceof View != null) {
            h((View)parent, matrix2);
            matrix2.preTranslate((float)i2, (float)i);
        }
        matrix2.preTranslate((float)left, (float)top);
        final Matrix obj3 = view.getMatrix();
        if (!obj3.isIdentity()) {
            matrix2.preConcat(obj3);
        }
    }

    public void i(View view, Matrix matrix2) {
        android.view.ViewParent parent;
        boolean identity;
        boolean z;
        Matrix obj3;
        parent = view.getParent();
        if (parent instanceof View != null) {
            i((View)parent, matrix2);
            matrix2.postTranslate((float)scrollX, (float)scrollY);
        }
        matrix2.postTranslate((float)i, (float)i2);
        obj3 = view.getMatrix();
        identity = new Matrix();
        if (!obj3.isIdentity() && obj3.invert(identity)) {
            identity = new Matrix();
            if (obj3.invert(identity)) {
                matrix2.postConcat(identity);
            }
        }
    }
}
