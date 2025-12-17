package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class a {

    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;
    public static void a(Drawable drawable, Resources.Theme resources$Theme2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme2);
        }
    }

    public static boolean b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return 0;
    }

    public static void c(Drawable drawable) {
        int sDK_INT;
        int childCount;
        Drawable child;
        Object obj3;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            drawable.clearColorFilter();
        } else {
            if (sDK_INT >= 21) {
                drawable.clearColorFilter();
                if (drawable instanceof InsetDrawable) {
                    a.c((InsetDrawable)drawable.getDrawable());
                } else {
                    if (drawable instanceof c) {
                        a.c((c)drawable.b());
                    } else {
                        obj3 = (DrawableContainer)drawable.getConstantState();
                        if (drawable instanceof DrawableContainer && (DrawableContainer.DrawableContainerState)obj3 != null) {
                            obj3 = (DrawableContainer)drawable.getConstantState();
                            if ((DrawableContainer.DrawableContainerState)(DrawableContainer.DrawableContainerState)obj3 != null) {
                                sDK_INT = 0;
                                while (sDK_INT < (DrawableContainer.DrawableContainerState)(DrawableContainer.DrawableContainerState)obj3.getChildCount()) {
                                    child = obj3.getChild(sDK_INT);
                                    if (child != null) {
                                    }
                                    sDK_INT++;
                                    a.c(child);
                                }
                            }
                        }
                    }
                }
            } else {
                drawable.clearColorFilter();
            }
        }
    }

    public static int d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static ColorFilter e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    public static int f(Drawable drawable) {
        boolean z;
        int sDK_INT;
        int str2;
        Object declaredMethod;
        String str;
        Class[] arr;
        Object obj6;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        final int i2 = 0;
        str2 = "DrawableCompat";
        if (sDK_INT >= 17 && !a.d) {
            str2 = "DrawableCompat";
            if (!a.d) {
                z = 1;
                declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[i2]);
                a.c = declaredMethod;
                declaredMethod.setAccessible(z);
                a.d = z;
            }
            sDK_INT = a.c;
            if (sDK_INT != null) {
                return (Integer)sDK_INT.invoke(drawable, new Object[i2]).intValue();
            }
        }
        return i2;
    }

    public static void g(Drawable drawable, Resources resources2, XmlPullParser xmlPullParser3, AttributeSet attributeSet4, Resources.Theme resources$Theme5) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources2, xmlPullParser3, attributeSet4, theme5);
        } else {
            drawable.inflate(resources2, xmlPullParser3, attributeSet4);
        }
    }

    public static boolean h(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return 0;
    }

    @Deprecated
    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z2) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z2);
        }
    }

    public static void k(Drawable drawable, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f2, f3);
        }
    }

    public static void l(Drawable drawable, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public static boolean m(Drawable drawable, int i2) {
        boolean declaredMethod;
        int sDK_INT;
        int str2;
        int i;
        String str;
        Class[] arr;
        Class tYPE;
        Object obj7;
        int obj8;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            return drawable.setLayoutDirection(i2);
        }
        final int i4 = 0;
        str2 = "DrawableCompat";
        i = 1;
        if (sDK_INT >= 17 && !a.b) {
            str2 = "DrawableCompat";
            i = 1;
            if (!a.b) {
                arr = new Class[i];
                arr[i4] = Integer.TYPE;
                declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", arr);
                a.a = declaredMethod;
                declaredMethod.setAccessible(i);
                a.b = i;
            }
            sDK_INT = a.a;
            if (sDK_INT != null) {
                Object[] arr2 = new Object[i];
                arr2[i4] = Integer.valueOf(i2);
                sDK_INT.invoke(drawable, arr2);
                return i;
            }
        }
        return i4;
    }

    public static void n(Drawable drawable, int i2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i2);
        } else {
            if (drawable instanceof b) {
                (b)drawable.setTint(i2);
            }
        }
    }

    public static void o(Drawable drawable, ColorStateList colorStateList2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList2);
        } else {
            if (drawable instanceof b) {
                (b)drawable.setTintList(colorStateList2);
            }
        }
    }

    public static void p(Drawable drawable, PorterDuff.Mode porterDuff$Mode2) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode2);
        } else {
            if (drawable instanceof b) {
                (b)drawable.setTintMode(mode2);
            }
        }
    }

    public static <T extends Drawable> T q(Drawable drawable) {
        Object obj1;
        if (drawable instanceof c) {
            obj1 = (c)drawable.b();
        }
        return obj1;
    }

    public static Drawable r(Drawable drawable) {
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            return drawable;
        }
        if (sDK_INT >= 21 && !drawable instanceof b) {
            if (!drawable instanceof b) {
                e eVar = new e(drawable);
                return eVar;
            }
            return drawable;
        }
        if (!drawable instanceof b) {
            d dVar = new d(drawable);
            return dVar;
        }
        return drawable;
    }
}
