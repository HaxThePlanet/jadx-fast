package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import d.h.g.a.b;
import d.h.l.b;

/* loaded from: classes.dex */
public class a implements b {

    private final int a;
    private final int b;
    private final int c;
    private java.lang.CharSequence d;
    private java.lang.CharSequence e;
    private Intent f;
    private char g;
    private int h = 4096;
    private char i;
    private int j = 4096;
    private Drawable k;
    private Context l;
    private java.lang.CharSequence m;
    private java.lang.CharSequence n;
    private ColorStateList o = null;
    private PorterDuff.Mode p = null;
    private boolean q = false;
    private boolean r = false;
    private int s = 16;
    public a(Context context, int i2, int i3, int i4, int i5, java.lang.CharSequence charSequence6) {
        super();
        int obj4 = 4096;
        obj4 = 0;
        obj4 = 0;
        obj4 = 16;
        this.l = context;
        this.a = i3;
        this.b = i2;
        this.c = i5;
        this.d = charSequence6;
    }

    private void c() {
        Drawable drawable;
        boolean z;
        drawable = this.k;
        if (drawable != null) {
            if (!this.q) {
                Drawable drawable2 = a.r(drawable);
                this.k = drawable2;
                Drawable mutate = drawable2.mutate();
                this.k = mutate;
                if (this.r && this.q) {
                    drawable2 = a.r(drawable);
                    this.k = drawable2;
                    mutate = drawable2.mutate();
                    this.k = mutate;
                    if (this.q) {
                        a.o(mutate, this.o);
                    }
                    if (this.r) {
                        a.p(this.k, this.p);
                    }
                }
            } else {
            }
        }
    }

    @Override // d.h.g.a.b
    public b a(b b) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // d.h.g.a.b
    public b b() {
        return null;
    }

    @Override // d.h.g.a.b
    public boolean collapseActionView() {
        return 0;
    }

    @Override // d.h.g.a.b
    public b d(int i) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // d.h.g.a.b
    public b e(View view) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // d.h.g.a.b
    public boolean expandActionView() {
        return 0;
    }

    @Override // d.h.g.a.b
    public b f(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // d.h.g.a.b
    public ActionProvider getActionProvider() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // d.h.g.a.b
    public View getActionView() {
        return null;
    }

    @Override // d.h.g.a.b
    public int getAlphabeticModifiers() {
        return this.j;
    }

    @Override // d.h.g.a.b
    public char getAlphabeticShortcut() {
        return this.i;
    }

    @Override // d.h.g.a.b
    public java.lang.CharSequence getContentDescription() {
        return this.m;
    }

    @Override // d.h.g.a.b
    public int getGroupId() {
        return this.b;
    }

    @Override // d.h.g.a.b
    public Drawable getIcon() {
        return this.k;
    }

    @Override // d.h.g.a.b
    public ColorStateList getIconTintList() {
        return this.o;
    }

    @Override // d.h.g.a.b
    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    @Override // d.h.g.a.b
    public Intent getIntent() {
        return this.f;
    }

    @Override // d.h.g.a.b
    public int getItemId() {
        return this.a;
    }

    @Override // d.h.g.a.b
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // d.h.g.a.b
    public int getNumericModifiers() {
        return this.h;
    }

    @Override // d.h.g.a.b
    public char getNumericShortcut() {
        return this.g;
    }

    @Override // d.h.g.a.b
    public int getOrder() {
        return this.c;
    }

    @Override // d.h.g.a.b
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // d.h.g.a.b
    public java.lang.CharSequence getTitle() {
        return this.d;
    }

    @Override // d.h.g.a.b
    public java.lang.CharSequence getTitleCondensed() {
        java.lang.CharSequence charSequence;
        if (this.e != null) {
        } else {
            charSequence = this.d;
        }
        return charSequence;
    }

    @Override // d.h.g.a.b
    public java.lang.CharSequence getTooltipText() {
        return this.n;
    }

    @Override // d.h.g.a.b
    public boolean hasSubMenu() {
        return 0;
    }

    @Override // d.h.g.a.b
    public boolean isActionViewExpanded() {
        return 0;
    }

    @Override // d.h.g.a.b
    public boolean isCheckable() {
        int i;
        if (i2 &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // d.h.g.a.b
    public boolean isChecked() {
        int i;
        i = i2 &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // d.h.g.a.b
    public boolean isEnabled() {
        int i;
        i = i2 &= 16 != 0 ? 1 : 0;
        return i;
    }

    @Override // d.h.g.a.b
    public boolean isVisible() {
        int i;
        i = i2 &= 8 == 0 ? 1 : 0;
        return i;
    }

    @Override // d.h.g.a.b
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // d.h.g.a.b
    public MenuItem setActionView(int i) {
        d(i);
        throw 0;
    }

    @Override // d.h.g.a.b
    public MenuItem setActionView(View view) {
        e(view);
        throw 0;
    }

    @Override // d.h.g.a.b
    public MenuItem setAlphabeticShortcut(char c) {
        this.i = Character.toLowerCase(c);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setAlphabeticShortcut(char c, int i2) {
        this.i = Character.toLowerCase(c);
        this.j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setCheckable(boolean z) {
        this.s = z |= i2;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setChecked(boolean z) {
        int obj2;
        obj2 = z ? 2 : 0;
        this.s = obj2 |= i2;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setContentDescription(java.lang.CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // d.h.g.a.b
    public b setContentDescription(java.lang.CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setEnabled(boolean z) {
        int obj2;
        obj2 = z ? 16 : 0;
        this.s = obj2 |= i2;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIcon(int i) {
        this.k = a.f(this.l, i);
        c();
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        c();
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        this.q = true;
        c();
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIconTintMode(PorterDuff.Mode porterDuff$Mode) {
        this.p = mode;
        this.r = true;
        c();
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setNumericShortcut(char c) {
        this.g = c;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setNumericShortcut(char c, int i2) {
        this.g = c;
        this.h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener menuItem$OnActionExpandListener) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // d.h.g.a.b
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener) {
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setShortcut(char c, char c2) {
        this.g = c;
        this.i = Character.toLowerCase(c2);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setShortcut(char c, char c2, int i3, int i4) {
        this.g = c;
        this.h = KeyEvent.normalizeMetaState(i3);
        this.i = Character.toLowerCase(c2);
        this.j = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // d.h.g.a.b
    public void setShowAsAction(int i) {
    }

    @Override // d.h.g.a.b
    public MenuItem setShowAsActionFlags(int i) {
        f(i);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setTitle(int i) {
        this.d = this.l.getResources().getString(i);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setTitle(java.lang.CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setTitleCondensed(java.lang.CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setTooltipText(java.lang.CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // d.h.g.a.b
    public b setTooltipText(java.lang.CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setVisible(boolean z) {
        int i;
        if (z) {
            i = 0;
        }
        this.s = i3 | i;
        return this;
    }
}
