package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.util.Log;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;
import androidx.annotation.ReplaceWith;
import androidx.core.internal.view.SupportMenuItem;

/* loaded from: classes5.dex */
public final class MenuItemCompat {

    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;
    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    static class Api26Impl {
        static int getAlphabeticModifiers(MenuItem menuItem) {
            return menuItem.getAlphabeticModifiers();
        }

        static java.lang.CharSequence getContentDescription(MenuItem menuItem) {
            return menuItem.getContentDescription();
        }

        static ColorStateList getIconTintList(MenuItem menuItem) {
            return menuItem.getIconTintList();
        }

        static PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
            return menuItem.getIconTintMode();
        }

        static int getNumericModifiers(MenuItem menuItem) {
            return menuItem.getNumericModifiers();
        }

        static java.lang.CharSequence getTooltipText(MenuItem menuItem) {
            return menuItem.getTooltipText();
        }

        static MenuItem setAlphabeticShortcut(MenuItem menuItem, char alphaChar, int alphaModifiers) {
            return menuItem.setAlphabeticShortcut(alphaChar, alphaModifiers);
        }

        static MenuItem setContentDescription(MenuItem menuItem, java.lang.CharSequence contentDescription) {
            return menuItem.setContentDescription(contentDescription);
        }

        static MenuItem setIconTintList(MenuItem menuItem, ColorStateList tint) {
            return menuItem.setIconTintList(tint);
        }

        static MenuItem setIconTintMode(MenuItem menuItem, PorterDuff.Mode tintMode) {
            return menuItem.setIconTintMode(tintMode);
        }

        static MenuItem setNumericShortcut(MenuItem menuItem, char numericChar, int numericModifiers) {
            return menuItem.setNumericShortcut(numericChar, numericModifiers);
        }

        static MenuItem setShortcut(MenuItem menuItem, char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
            return menuItem.setShortcut(numericChar, alphaChar, numericModifiers, alphaModifiers);
        }

        static MenuItem setTooltipText(MenuItem menuItem, java.lang.CharSequence tooltipText) {
            return menuItem.setTooltipText(tooltipText);
        }
    }

    @Deprecated
    public interface OnActionExpandListener {
        public abstract boolean onMenuItemActionCollapse(MenuItem menuItem);

        public abstract boolean onMenuItemActionExpand(MenuItem menuItem);
    }
    @ReplaceWith(expression = "item.collapseActionView()")
    @Deprecated
    public static boolean collapseActionView(MenuItem item) {
        return item.collapseActionView();
    }

    @ReplaceWith(expression = "item.expandActionView()")
    @Deprecated
    public static boolean expandActionView(MenuItem item) {
        return item.expandActionView();
    }

    public static androidx.core.view.ActionProvider getActionProvider(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return (SupportMenuItem)item.getSupportActionProvider();
        }
        Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    @ReplaceWith(expression = "item.getActionView()")
    @Deprecated
    public static View getActionView(MenuItem item) {
        return item.getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return (SupportMenuItem)item.getAlphabeticModifiers();
        }
        return MenuItemCompat.Api26Impl.getAlphabeticModifiers(item);
    }

    public static java.lang.CharSequence getContentDescription(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return (SupportMenuItem)item.getContentDescription();
        }
        return MenuItemCompat.Api26Impl.getContentDescription(item);
    }

    public static ColorStateList getIconTintList(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return (SupportMenuItem)item.getIconTintList();
        }
        return MenuItemCompat.Api26Impl.getIconTintList(item);
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return (SupportMenuItem)item.getIconTintMode();
        }
        return MenuItemCompat.Api26Impl.getIconTintMode(item);
    }

    public static int getNumericModifiers(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return (SupportMenuItem)item.getNumericModifiers();
        }
        return MenuItemCompat.Api26Impl.getNumericModifiers(item);
    }

    public static java.lang.CharSequence getTooltipText(MenuItem item) {
        if (item instanceof SupportMenuItem) {
            return (SupportMenuItem)item.getTooltipText();
        }
        return MenuItemCompat.Api26Impl.getTooltipText(item);
    }

    @ReplaceWith(expression = "item.isActionViewExpanded()")
    @Deprecated
    public static boolean isActionViewExpanded(MenuItem item) {
        return item.isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem item, androidx.core.view.ActionProvider provider) {
        if (item instanceof SupportMenuItem) {
            return (SupportMenuItem)item.setSupportActionProvider(provider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return item;
    }

    @ReplaceWith(expression = "item.setActionView(resId)")
    @Deprecated
    public static MenuItem setActionView(MenuItem item, int resId) {
        return item.setActionView(resId);
    }

    @ReplaceWith(expression = "item.setActionView(view)")
    @Deprecated
    public static MenuItem setActionView(MenuItem item, View view) {
        return item.setActionView(view);
    }

    public static void setAlphabeticShortcut(MenuItem item, char alphaChar, int alphaModifiers) {
        Object obj;
        if (item instanceof SupportMenuItem) {
            (SupportMenuItem)item.setAlphabeticShortcut(alphaChar, alphaModifiers);
        } else {
            MenuItemCompat.Api26Impl.setAlphabeticShortcut(item, alphaChar, alphaModifiers);
        }
    }

    public static void setContentDescription(MenuItem item, java.lang.CharSequence contentDescription) {
        Object obj;
        if (item instanceof SupportMenuItem) {
            (SupportMenuItem)item.setContentDescription(contentDescription);
        } else {
            MenuItemCompat.Api26Impl.setContentDescription(item, contentDescription);
        }
    }

    public static void setIconTintList(MenuItem item, ColorStateList tint) {
        Object obj;
        if (item instanceof SupportMenuItem) {
            (SupportMenuItem)item.setIconTintList(tint);
        } else {
            MenuItemCompat.Api26Impl.setIconTintList(item, tint);
        }
    }

    public static void setIconTintMode(MenuItem item, PorterDuff.Mode tintMode) {
        Object obj;
        if (item instanceof SupportMenuItem) {
            (SupportMenuItem)item.setIconTintMode(tintMode);
        } else {
            MenuItemCompat.Api26Impl.setIconTintMode(item, tintMode);
        }
    }

    public static void setNumericShortcut(MenuItem item, char numericChar, int numericModifiers) {
        Object obj;
        if (item instanceof SupportMenuItem) {
            (SupportMenuItem)item.setNumericShortcut(numericChar, numericModifiers);
        } else {
            MenuItemCompat.Api26Impl.setNumericShortcut(item, numericChar, numericModifiers);
        }
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem item, androidx.core.view.MenuItemCompat.OnActionExpandListener listener) {
        MenuItemCompat.1 anon = new MenuItemCompat.1(listener);
        return item.setOnActionExpandListener(anon);
    }

    public static void setShortcut(MenuItem item, char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        Object obj;
        if (item instanceof SupportMenuItem) {
            (SupportMenuItem)item.setShortcut(numericChar, alphaChar, numericModifiers, alphaModifiers);
        } else {
            MenuItemCompat.Api26Impl.setShortcut(item, numericChar, alphaChar, numericModifiers, alphaModifiers);
        }
    }

    @ReplaceWith(expression = "item.setShowAsAction(actionEnum)")
    @Deprecated
    public static void setShowAsAction(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    public static void setTooltipText(MenuItem item, java.lang.CharSequence tooltipText) {
        Object obj;
        if (item instanceof SupportMenuItem) {
            (SupportMenuItem)item.setTooltipText(tooltipText);
        } else {
            MenuItemCompat.Api26Impl.setTooltipText(item, tooltipText);
        }
    }
}
