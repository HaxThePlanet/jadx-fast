package androidx.appcompat.widget;

import android.animation.AnimatorSet;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.core.graphics.drawable.a;
import androidx.core.graphics.drawable.c;
import d.a.l.a.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class a0 {

    private static final int[] a;
    private static final int[] b;
    public static final Rect c;
    private static Class<?> d;
    static {
        int sDK_INT;
        int[] iArr = new int[1];
        final int i4 = 0;
        iArr[i4] = 16842912;
        a0.a = iArr;
        a0.b = new int[i4];
        Rect rect = new Rect();
        a0.c = rect;
        if (Build.VERSION.SDK_INT >= 18) {
            a0.d = Class.forName("android.graphics.Insets");
        }
    }

    public static boolean a(Drawable drawable) {
        int sDK_INT;
        boolean length;
        int i2;
        int i;
        boolean z;
        Object obj4;
        sDK_INT = Build.VERSION.SDK_INT;
        i2 = 15;
        final int i3 = 0;
        if (sDK_INT < i2 && drawable instanceof InsetDrawable) {
            if (drawable instanceof InsetDrawable) {
                return i3;
            }
        }
        if (sDK_INT < i2 && drawable instanceof GradientDrawable) {
            if (drawable instanceof GradientDrawable) {
                return i3;
            }
        }
        if (sDK_INT < 17 && drawable instanceof LayerDrawable) {
            if (drawable instanceof LayerDrawable) {
                return i3;
            }
        }
        if (drawable instanceof DrawableContainer) {
            obj4 = drawable.getConstantState();
            if (obj4 instanceof DrawableContainer.DrawableContainerState) {
                obj4 = (DrawableContainer.DrawableContainerState)obj4.getChildren();
                i = i3;
                while (i < obj4.length) {
                    i++;
                }
            }
        } else {
            if (drawable instanceof c) {
                return a0.a((c)drawable.b());
            }
            if (drawable instanceof c) {
                return a0.a((c)drawable.a());
            }
            if (drawable instanceof ScaleDrawable) {
                return a0.a((ScaleDrawable)drawable.getDrawable());
            }
        }
        return 1;
    }

    static void b(Drawable drawable) {
        int sDK_INT;
        int name;
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            if ("android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
                a0.c(drawable);
            }
        }
    }

    private static void c(Drawable drawable) {
        int[] iArr;
        int length;
        final int[] state = drawable.getState();
        if (state != null) {
            if (state.length == 0) {
                drawable.setState(a0.a);
            } else {
                drawable.setState(a0.b);
            }
        } else {
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        Object method;
        int arr;
        int i5;
        Class[] arr2;
        int i4;
        int int;
        boolean equals;
        int i;
        String str2;
        int i2;
        String str;
        int i3;
        Object obj12;
        if (Build.VERSION.SDK_INT >= 29) {
            obj12 = drawable.getOpticalInsets();
            Rect rect = new Rect();
            rect.left = obj12.left;
            rect.right = obj12.right;
            rect.top = obj12.top;
            rect.bottom = obj12.bottom;
            return rect;
        }
        obj12 = a.q(drawable);
        i5 = 0;
        obj12 = obj12.getClass().getMethod("getOpticalInsets", new Class[i5]).invoke(obj12, new Object[i5]);
        if (a0.d != null && obj12 != null) {
            obj12 = a.q(drawable);
            i5 = 0;
            obj12 = obj12.getClass().getMethod("getOpticalInsets", new Class[i5]).invoke(obj12, new Object[i5]);
            if (obj12 != null) {
                Rect rect2 = new Rect();
                Field[] fields = a0.d.getFields();
                i4 = i5;
                while (i4 < fields.length) {
                    int = fields[i4];
                    equals = int.getName();
                    i = -1;
                    i2 = 3;
                    str = 2;
                    i3 = 1;
                    if (i != 0) {
                    } else {
                    }
                    rect2.left = int.getInt(obj12);
                    i4++;
                    if (i != i3) {
                    } else {
                    }
                    rect2.top = int.getInt(obj12);
                    if (i != str) {
                    } else {
                    }
                    rect2.right = int.getInt(obj12);
                    if (i != i2) {
                    } else {
                    }
                    rect2.bottom = int.getInt(obj12);
                    if (equals.equals("right")) {
                    }
                    i = str;
                    if (equals.equals("left")) {
                    }
                    i = i5;
                    if (equals.equals("top")) {
                    }
                    i = i3;
                    if (equals.equals("bottom")) {
                    }
                    i = i2;
                }
                return rect2;
            }
        }
        return a0.c;
    }

    public static PorterDuff.Mode e(int i, PorterDuff.Mode porterDuff$Mode2) {
        if (i != 3 && i != 5 && i != 9) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode2;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
