package d.h.l;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import d.h.g.a.b;

/* loaded from: classes.dex */
public final class i {
    public static MenuItem a(MenuItem menuItem, d.h.l.b b2) {
        if (menuItem instanceof b) {
            return (b)menuItem.a(b2);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, char c2, int i3) {
        boolean sDK_INT;
        int i;
        if (menuItem instanceof b) {
            (b)menuItem.setAlphabeticShortcut(c2, i3);
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c2, i3);
            }
        }
    }

    public static void c(MenuItem menuItem, java.lang.CharSequence charSequence2) {
        boolean sDK_INT;
        int i;
        if (menuItem instanceof b) {
            (b)menuItem.setContentDescription(charSequence2);
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence2);
            }
        }
    }

    public static void d(MenuItem menuItem, ColorStateList colorStateList2) {
        boolean sDK_INT;
        int i;
        if (menuItem instanceof b) {
            (b)menuItem.setIconTintList(colorStateList2);
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintList(colorStateList2);
            }
        }
    }

    public static void e(MenuItem menuItem, PorterDuff.Mode porterDuff$Mode2) {
        boolean sDK_INT;
        int i;
        if (menuItem instanceof b) {
            (b)menuItem.setIconTintMode(mode2);
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintMode(mode2);
            }
        }
    }

    public static void f(MenuItem menuItem, char c2, int i3) {
        boolean sDK_INT;
        int i;
        if (menuItem instanceof b) {
            (b)menuItem.setNumericShortcut(c2, i3);
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c2, i3);
            }
        }
    }

    public static void g(MenuItem menuItem, java.lang.CharSequence charSequence2) {
        boolean sDK_INT;
        int i;
        if (menuItem instanceof b) {
            (b)menuItem.setTooltipText(charSequence2);
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
        }
    }
}
