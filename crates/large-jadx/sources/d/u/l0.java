package d.u;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsBase.java */
/* loaded from: classes.dex */
class l0 {

    private static Method a;
    private static boolean b;
    private static Field c;
    private static boolean d;
    l0() {
        super();
    }

    private void b() {
        Method declaredMethod;
        String str;
        Class[] arr;
        if (!l0.b) {
            int i2 = 1;
            try {
                str = "setFrame";
                arr = new Class[4];
                tYPE2 = Integer.TYPE;
                arr[i2] = tYPE2;
                arr[2] = tYPE2;
                int i = 3;
                arr[i] = tYPE2;
                declaredMethod = View.class.getDeclaredMethod(str, arr);
                l0.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (java.lang.NoSuchMethodException noSuchMethod) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", noSuchMethod);
            }
            l0.b = true;
        }
    }

    public void a(View view) {
        if (view.getVisibility() == 0) {
            Object obj = null;
            view.setTag(j.a, obj);
        }
    }

    public float c(View view) {
        Object tag = view.getTag(j.a);
        if (tag != null) {
            return view.getAlpha() / tag.floatValue();
        }
        return view.getAlpha();
    }

    public void d(View view) {
        final int i = j.a;
        if (view.getTag(i) == null) {
            view.setTag(j.a, Float.valueOf(view.getAlpha()));
        }
    }

    public void e(View view, int i, int i2, int i3, int i4) {
        b();
        final Method method = l0.a;
        if (l0.a != null) {
            try {
                Object[] arr = new Object[4];
                l0.a.invoke(view, new Object[] { Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) });
            } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
                invocationTarget = invocationTarget.getCause();
                i = new RuntimeException(invocationTarget);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } catch (java.lang.IllegalAccessException unused) {
                return;
            }
        }
    }

    public void f(View view, float f) {
        Object tag = view.getTag(j.a);
        if (tag != null) {
            f = tag.floatValue() * f;
            view.setAlpha(f);
        } else {
            view.setAlpha(f);
        }
    }

    public void g(View view, int i) throws java.lang.NoSuchFieldException {
        Field declaredField;
        String str;
        if (!l0.d) {
            boolean z = true;
            try {
                str = "mViewFlags";
                declaredField = View.class.getDeclaredField(str);
                l0.c = declaredField;
                declaredField.setAccessible(z);
            } catch (java.lang.IllegalAccessException unused) {
                return;
            }
            l0.d = z;
        }
        Field field = l0.c;
        if (l0.c != null) {
            try {
                l0.c.setInt(view, i | (l0.c.getInt(view) & (-13)));
            } catch (java.lang.IllegalAccessException unused) {
                return;
            }
        }
    }

    public void h(View view, Matrix matrix) {
        android.view.ViewParent parent = view.getParent();
        z = parent instanceof View;
        if (parent instanceof View) {
            h(parent, matrix);
            matrix.preTranslate((float)-parent.getScrollX(), (float)-parent.getScrollY());
        }
        matrix.preTranslate((float)view.getLeft(), (float)view.getTop());
        matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.preConcat(matrix);
        }
    }

    public void i(View view, Matrix matrix) {
        android.view.ViewParent parent = view.getParent();
        z = parent instanceof View;
        if (parent instanceof View) {
            i(parent, matrix);
            matrix.postTranslate((float)parent.getScrollX(), (float)parent.getScrollY());
        }
        matrix.postTranslate((float)-view.getLeft(), (float)-view.getTop());
        matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}
