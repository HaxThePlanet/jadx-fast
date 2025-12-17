package d.h.g.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.MenuItem;
import android.view.View;
import d.h.l.b;

/* loaded from: classes.dex */
public interface b extends MenuItem {
    @Override // android.view.MenuItem
    public abstract d.h.g.a.b a(b b);

    @Override // android.view.MenuItem
    public abstract b b();

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
    public abstract java.lang.CharSequence getTooltipText();

    @Override // android.view.MenuItem
    public abstract boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    public abstract MenuItem setActionView(int i);

    @Override // android.view.MenuItem
    public abstract MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    public abstract MenuItem setAlphabeticShortcut(char c, int i2);

    @Override // android.view.MenuItem
    public abstract d.h.g.a.b setContentDescription(java.lang.CharSequence charSequence);

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
    public abstract d.h.g.a.b setTooltipText(java.lang.CharSequence charSequence);
}
