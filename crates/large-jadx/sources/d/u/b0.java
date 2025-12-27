package d.u;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi14.java */
/* loaded from: classes.dex */
class b0 {

    private static LayoutTransition a;
    private static Field b;
    private static boolean c;
    private static Method d;
    private static boolean e;

    static class a extends LayoutTransition {
        a() {
            super();
        }

        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }
    private static void a(LayoutTransition layoutTransition) throws java.lang.NoSuchMethodException {
        int i = 0;
        if (!b0.e) {
            boolean z = true;
            try {
                str = "cancel";
                Method declaredMethod = LayoutTransition.class.getDeclaredMethod(str, new Class[i]);
                b0.d = declaredMethod;
                declaredMethod.setAccessible(z);
            } catch (java.lang.reflect.InvocationTargetException unused) {
                layoutTransition = "Failed to invoke cancel method by reflection";
                Log.i(str4, layoutTransition);
            } catch (java.lang.IllegalAccessException unused) {
                Log.i(str4, str2);
            }
            b0.e = z;
        }
        Method method = b0.d;
        if (b0.d != null) {
            try {
                b0.d.invoke(layoutTransition, new Object[i]);
            } catch (java.lang.reflect.InvocationTargetException unused) {
                layoutTransition = "Failed to invoke cancel method by reflection";
                Log.i(str4, layoutTransition);
            } catch (java.lang.IllegalAccessException unused) {
                Log.i(str4, str2);
            }
        }
    }

    static void b(ViewGroup viewGroup, boolean z) throws java.lang.NoSuchFieldException {
        LayoutTransition layoutTransition;
        int i = 1;
        int i2 = 0;
        int i3 = 4;
        Field declaredField;
        i = 1;
        i2 = 0;
        final android.animation.Animator animator = null;
        if (b0.a == null) {
            d.u.b0.a aVar = new b0.a();
            b0.a = aVar;
            aVar.setAnimator(2, animator);
            b0.a.setAnimator(i2, animator);
            b0.a.setAnimator(i, animator);
            b0.a.setAnimator(3, animator);
            i3 = 4;
            b0.a.setAnimator(i3, animator);
        }
        if (z != null) {
            LayoutTransition layoutTransition6 = viewGroup.getLayoutTransition();
            if (layoutTransition6 != null && layoutTransition6.isRunning()) {
                b0.a(layoutTransition6);
                if (layoutTransition6 != b0.a) {
                    viewGroup.setTag(j.d, layoutTransition6);
                }
            }
            viewGroup.setLayoutTransition(b0.a);
        } else {
            viewGroup.setLayoutTransition(animator);
            if (!b0.c) {
                try {
                    declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                    b0.b = declaredField;
                    declaredField.setAccessible(true);
                } catch (java.lang.IllegalAccessException unused) {
                    z = "Failed to get mLayoutSuppressed field by reflection";
                    Log.i(str, z);
                }
                b0.c = true;
            }
            field = b0.b;
            if (b0.b != null) {
                try {
                    boolean z22 = b0.b.getBoolean(viewGroup);
                } catch (java.lang.IllegalAccessException unused) {
                    z = "Failed to get mLayoutSuppressed field by reflection";
                    Log.i(str, z);
                }
                if (b0.c) {
                    try {
                        b0.b.setBoolean(viewGroup, false);
                    } catch (java.lang.IllegalAccessException unused) {
                    }
                }
            }
            if (i2 != 0) {
                viewGroup.requestLayout();
            }
            int i7 = j.d;
            Object tag = viewGroup.getTag(i7);
            if (tag != null) {
                viewGroup.setTag(j.d, animator);
                viewGroup.setLayoutTransition(tag);
            }
        }
    }
}
