package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import d.h.g.a.c;

/* loaded from: classes.dex */
class s extends androidx.appcompat.view.menu.o implements SubMenu {

    private final c e;
    s(Context context, c c2) {
        super(context, c2);
        this.e = c2;
    }

    @Override // androidx.appcompat.view.menu.o
    public void clearHeader() {
        this.e.clearHeader();
    }

    @Override // androidx.appcompat.view.menu.o
    public MenuItem getItem() {
        return c(this.e.getItem());
    }

    @Override // androidx.appcompat.view.menu.o
    public SubMenu setHeaderIcon(int i) {
        this.e.setHeaderIcon(i);
        return this;
    }

    @Override // androidx.appcompat.view.menu.o
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.e.setHeaderIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.o
    public SubMenu setHeaderTitle(int i) {
        this.e.setHeaderTitle(i);
        return this;
    }

    @Override // androidx.appcompat.view.menu.o
    public SubMenu setHeaderTitle(java.lang.CharSequence charSequence) {
        this.e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // androidx.appcompat.view.menu.o
    public SubMenu setHeaderView(View view) {
        this.e.setHeaderView(view);
        return this;
    }

    @Override // androidx.appcompat.view.menu.o
    public SubMenu setIcon(int i) {
        this.e.setIcon(i);
        return this;
    }

    @Override // androidx.appcompat.view.menu.o
    public SubMenu setIcon(Drawable drawable) {
        this.e.setIcon(drawable);
        return this;
    }
}
