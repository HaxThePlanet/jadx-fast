package androidx.core.internal.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.ActionProvider;

/* loaded from: classes5.dex */
public interface SupportMenuItem extends MenuItem {

    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    @Override // android.view.MenuItem
    public abstract boolean collapseActionView();

    @Override // android.view.MenuItem
    public abstract boolean expandActionView();

    @Override // android.view.MenuItem
    public abstract View getActionView();

    @Override // android.view.MenuItem
    public abstract int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    public abstract java.lang.CharSequence getContentDescription();

    @Override // android.view.MenuItem
    public abstract ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    public abstract PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    public abstract int getNumericModifiers();

    @Override // android.view.MenuItem
    public abstract ActionProvider getSupportActionProvider();

    @Override // android.view.MenuItem
    public abstract java.lang.CharSequence getTooltipText();

    @Override // android.view.MenuItem
    public abstract boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    public abstract boolean requiresActionButton();

    @Override // android.view.MenuItem
    public abstract boolean requiresOverflow();

    @Override // android.view.MenuItem
    public abstract MenuItem setActionView(int i);

    @Override // android.view.MenuItem
    public abstract MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    public abstract MenuItem setAlphabeticShortcut(char c, int i2);

    public MenuItem setContentDescription(java.lang.CharSequence charSequence) {
        return setContentDescription(charSequence);
    }

    @Override // android.view.MenuItem
    public abstract androidx.core.internal.view.SupportMenuItem setContentDescription(java.lang.CharSequence charSequence);

    @Override // android.view.MenuItem
    public abstract MenuItem setIconTintList(ColorStateList colorStateList);

    @Override // android.view.MenuItem
    public abstract MenuItem setIconTintMode(PorterDuff.Mode porterDuff$Mode);

    @Override // android.view.MenuItem
    public abstract MenuItem setNumericShortcut(char c, int i2);

    @Override // android.view.MenuItem
    public abstract MenuItem setShortcut(char c, char c2, int i3, int i4);

    @Override // android.view.MenuItem
    public abstract void setShowAsAction(int i);

    @Override // android.view.MenuItem
    public abstract MenuItem setShowAsActionFlags(int i);

    @Override // android.view.MenuItem
    public abstract androidx.core.internal.view.SupportMenuItem setSupportActionProvider(ActionProvider actionProvider);

    public MenuItem setTooltipText(java.lang.CharSequence charSequence) {
        return setTooltipText(charSequence);
    }

    @Override // android.view.MenuItem
    public abstract androidx.core.internal.view.SupportMenuItem setTooltipText(java.lang.CharSequence charSequence);
}
