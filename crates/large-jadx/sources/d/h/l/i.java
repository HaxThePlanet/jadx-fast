package d.h.l;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import d.h.g.a.b;

/* compiled from: MenuItemCompat.java */
/* loaded from: classes.dex */
public final class i {
    public static MenuItem a(MenuItem menuItem, b bVar) {
        if (menuItem instanceof b) {
            return menuItem.a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, char c, int i) {
        z = menuItem instanceof b;
        if (menuItem instanceof b) {
            menuItem.setAlphabeticShortcut(c, i);
        } else {
            i = 26;
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c, i);
            }
        }
    }

    public static void c(MenuItem menuItem, java.lang.CharSequence charSequence) {
        z = menuItem instanceof b;
        if (menuItem instanceof b) {
            menuItem.setContentDescription(charSequence);
        } else {
            int i = 26;
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
        }
    }

    public static void d(MenuItem menuItem, ColorStateList list) {
        z = menuItem instanceof b;
        if (menuItem instanceof b) {
            menuItem.setIconTintList(list);
        } else {
            int i = 26;
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintList(list);
            }
        }
    }

    public static void e(MenuItem menuItem, PorterDuff.Mode mode) {
        z = menuItem instanceof b;
        if (menuItem instanceof b) {
            menuItem.setIconTintMode(mode);
        } else {
            int i = 26;
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setIconTintMode(mode);
            }
        }
    }

    public static void f(MenuItem menuItem, char c, int i) {
        z = menuItem instanceof b;
        if (menuItem instanceof b) {
            menuItem.setNumericShortcut(c, i);
        } else {
            i = 26;
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c, i);
            }
        }
    }

    public static void g(MenuItem menuItem, java.lang.CharSequence charSequence) {
        z = menuItem instanceof b;
        if (menuItem instanceof b) {
            menuItem.setTooltipText(charSequence);
        } else {
            int i = 26;
            if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence);
            }
        }
    }
}
