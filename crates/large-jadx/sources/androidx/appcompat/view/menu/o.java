package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import d.h.g.a.a;

/* loaded from: classes.dex */
public class o extends androidx.appcompat.view.menu.c implements Menu {

    private final a d;
    public o(Context context, a a2) {
        super(context);
        if (a2 == null) {
        } else {
            this.d = a2;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Wrapped Object can not be null.");
        throw obj1;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem add(int i) {
        return c(this.d.add(i));
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem add(int i, int i2, int i3, int i4) {
        return c(this.d.add(i, i2, i3, i4));
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem add(int i, int i2, int i3, java.lang.CharSequence charSequence4) {
        return c(this.d.add(i, i2, i3, charSequence4));
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem add(java.lang.CharSequence charSequence) {
        return c(this.d.add(charSequence));
    }

    @Override // androidx.appcompat.view.menu.c
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName4, Intent[] intent5Arr5, Intent intent6, int i7, MenuItem[] menuItem8Arr8) {
        int arr;
        int i5;
        int length;
        int i4;
        final int[] iArr = menuItem8Arr8;
        arr = iArr != null ? new MenuItem[length2] : 0;
        if (arr != 0) {
            i5 = 0;
            while (i5 < arr.length) {
                iArr[i5] = c(arr[i5]);
                i5++;
            }
        }
        return obj.d.addIntentOptions(i, i2, i3, componentName4, intent5Arr5, intent6, i7, arr);
    }

    @Override // androidx.appcompat.view.menu.c
    public SubMenu addSubMenu(int i) {
        return d(this.d.addSubMenu(i));
    }

    @Override // androidx.appcompat.view.menu.c
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return d(this.d.addSubMenu(i, i2, i3, i4));
    }

    @Override // androidx.appcompat.view.menu.c
    public SubMenu addSubMenu(int i, int i2, int i3, java.lang.CharSequence charSequence4) {
        return d(this.d.addSubMenu(i, i2, i3, charSequence4));
    }

    @Override // androidx.appcompat.view.menu.c
    public SubMenu addSubMenu(java.lang.CharSequence charSequence) {
        return d(this.d.addSubMenu(charSequence));
    }

    @Override // androidx.appcompat.view.menu.c
    public void clear() {
        e();
        this.d.clear();
    }

    @Override // androidx.appcompat.view.menu.c
    public void close() {
        this.d.close();
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem findItem(int i) {
        return c(this.d.findItem(i));
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem getItem(int i) {
        return c(this.d.getItem(i));
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean hasVisibleItems() {
        return this.d.hasVisibleItems();
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean isShortcutKey(int i, KeyEvent keyEvent2) {
        return this.d.isShortcutKey(i, keyEvent2);
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean performIdentifierAction(int i, int i2) {
        return this.d.performIdentifierAction(i, i2);
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean performShortcut(int i, KeyEvent keyEvent2, int i3) {
        return this.d.performShortcut(i, keyEvent2, i3);
    }

    @Override // androidx.appcompat.view.menu.c
    public void removeGroup(int i) {
        f(i);
        this.d.removeGroup(i);
    }

    @Override // androidx.appcompat.view.menu.c
    public void removeItem(int i) {
        g(i);
        this.d.removeItem(i);
    }

    @Override // androidx.appcompat.view.menu.c
    public void setGroupCheckable(int i, boolean z2, boolean z3) {
        this.d.setGroupCheckable(i, z2, z3);
    }

    @Override // androidx.appcompat.view.menu.c
    public void setGroupEnabled(int i, boolean z2) {
        this.d.setGroupEnabled(i, z2);
    }

    @Override // androidx.appcompat.view.menu.c
    public void setGroupVisible(int i, boolean z2) {
        this.d.setGroupVisible(i, z2);
    }

    @Override // androidx.appcompat.view.menu.c
    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }

    @Override // androidx.appcompat.view.menu.c
    public int size() {
        return this.d.size();
    }
}
