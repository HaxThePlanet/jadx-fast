package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class r extends androidx.appcompat.view.menu.g implements SubMenu {

    private androidx.appcompat.view.menu.g B;
    private androidx.appcompat.view.menu.i C;
    public r(Context context, androidx.appcompat.view.menu.g g2, androidx.appcompat.view.menu.i i3) {
        super(context);
        this.B = g2;
        this.C = i3;
    }

    @Override // androidx.appcompat.view.menu.g
    public androidx.appcompat.view.menu.g F() {
        return this.B.F();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean H() {
        return this.B.H();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean I() {
        return this.B.I();
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean J() {
        return this.B.J();
    }

    @Override // androidx.appcompat.view.menu.g
    public void V(androidx.appcompat.view.menu.g.a g$a) {
        this.B.V(a);
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean f(androidx.appcompat.view.menu.i i) {
        return this.B.f(i);
    }

    @Override // androidx.appcompat.view.menu.g
    public MenuItem getItem() {
        return this.C;
    }

    @Override // androidx.appcompat.view.menu.g
    boolean h(androidx.appcompat.view.menu.g g, MenuItem menuItem2) {
        androidx.appcompat.view.menu.g z;
        int obj2;
        if (!super.h(g, menuItem2)) {
            if (this.B.h(g, menuItem2)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // androidx.appcompat.view.menu.g
    public Menu i0() {
        return this.B;
    }

    @Override // androidx.appcompat.view.menu.g
    public boolean m(androidx.appcompat.view.menu.i i) {
        return this.B.m(i);
    }

    @Override // androidx.appcompat.view.menu.g
    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    @Override // androidx.appcompat.view.menu.g
    public SubMenu setHeaderIcon(int i) {
        super.Y(i);
        return (SubMenu)this;
    }

    @Override // androidx.appcompat.view.menu.g
    public SubMenu setHeaderIcon(Drawable drawable) {
        super.Z(drawable);
        return (SubMenu)this;
    }

    @Override // androidx.appcompat.view.menu.g
    public SubMenu setHeaderTitle(int i) {
        super.b0(i);
        return (SubMenu)this;
    }

    @Override // androidx.appcompat.view.menu.g
    public SubMenu setHeaderTitle(java.lang.CharSequence charSequence) {
        super.c0(charSequence);
        return (SubMenu)this;
    }

    @Override // androidx.appcompat.view.menu.g
    public SubMenu setHeaderView(View view) {
        super.d0(view);
        return (SubMenu)this;
    }

    @Override // androidx.appcompat.view.menu.g
    public SubMenu setIcon(int i) {
        this.C.setIcon(i);
        return this;
    }

    @Override // androidx.appcompat.view.menu.g
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.g
    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    @Override // androidx.appcompat.view.menu.g
    public String v() {
        int itemId;
        androidx.appcompat.view.menu.i iVar = this.C;
        if (iVar != null) {
            itemId = iVar.getItemId();
        } else {
            itemId = 0;
        }
        if (itemId == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.v());
        stringBuilder.append(":");
        stringBuilder.append(itemId);
        return stringBuilder.toString();
    }
}
