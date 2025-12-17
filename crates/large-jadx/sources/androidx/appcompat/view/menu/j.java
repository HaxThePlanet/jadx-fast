package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import d.a.o.c;
import d.h.g.a.b;
import d.h.l.b;
import d.h.l.b.b;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class j extends androidx.appcompat.view.menu.c implements MenuItem {

    private final b d;
    private Method e;

    private class d implements MenuItem.OnActionExpandListener {

        private final MenuItem.OnActionExpandListener a;
        final androidx.appcompat.view.menu.j b;
        d(androidx.appcompat.view.menu.j j, MenuItem.OnActionExpandListener menuItem$OnActionExpandListener2) {
            this.b = j;
            super();
            this.a = onActionExpandListener2;
        }

        @Override // android.view.MenuItem$OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.a.onMenuItemActionCollapse(this.b.c(menuItem));
        }

        @Override // android.view.MenuItem$OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.a.onMenuItemActionExpand(this.b.c(menuItem));
        }
    }

    private class e implements MenuItem.OnMenuItemClickListener {

        private final MenuItem.OnMenuItemClickListener a;
        final androidx.appcompat.view.menu.j b;
        e(androidx.appcompat.view.menu.j j, MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener2) {
            this.b = j;
            super();
            this.a = onMenuItemClickListener2;
        }

        @Override // android.view.MenuItem$OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.a.onMenuItemClick(this.b.c(menuItem));
        }
    }

    private class a extends b {

        final ActionProvider b;
        final androidx.appcompat.view.menu.j c;
        a(androidx.appcompat.view.menu.j j, Context context2, ActionProvider actionProvider3) {
            this.c = j;
            super(context2);
            this.b = actionProvider3;
        }

        @Override // d.h.l.b
        public boolean a() {
            return this.b.hasSubMenu();
        }

        @Override // d.h.l.b
        public View c() {
            return this.b.onCreateActionView();
        }

        @Override // d.h.l.b
        public boolean e() {
            return this.b.onPerformDefaultAction();
        }

        @Override // d.h.l.b
        public void f(SubMenu subMenu) {
            this.b.onPrepareSubMenu(this.c.d(subMenu));
        }
    }

    static class c extends FrameLayout implements c {

        final CollapsibleActionView a;
        c(View view) {
            super(view.getContext());
            this.a = (CollapsibleActionView)view;
            addView(view);
        }

        @Override // android.widget.FrameLayout
        View a() {
            return (View)this.a;
        }

        @Override // android.widget.FrameLayout
        public void onActionViewCollapsed() {
            this.a.onActionViewCollapsed();
        }

        @Override // android.widget.FrameLayout
        public void onActionViewExpanded() {
            this.a.onActionViewExpanded();
        }
    }

    private class b extends androidx.appcompat.view.menu.j.a implements ActionProvider.VisibilityListener {

        private b.b d;
        b(androidx.appcompat.view.menu.j j, Context context2, ActionProvider actionProvider3) {
            super(j, context2, actionProvider3);
        }

        @Override // androidx.appcompat.view.menu.j$a
        public boolean b() {
            return this.b.isVisible();
        }

        @Override // androidx.appcompat.view.menu.j$a
        public View d(MenuItem menuItem) {
            return this.b.onCreateActionView(menuItem);
        }

        @Override // androidx.appcompat.view.menu.j$a
        public boolean g() {
            return this.b.overridesItemVisibility();
        }

        @Override // androidx.appcompat.view.menu.j$a
        public void j(b.b b$b) {
            Object obj2;
            this.d = b;
            obj2 = b != null ? this : 0;
            this.b.setVisibilityListener(obj2);
        }

        @Override // androidx.appcompat.view.menu.j$a
        public void onActionProviderVisibilityChanged(boolean z) {
            final b.b bVar = this.d;
            if (bVar != null) {
                bVar.onActionProviderVisibilityChanged(z);
            }
        }
    }
    public j(Context context, b b2) {
        super(context);
        if (b2 == null) {
        } else {
            this.d = b2;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Wrapped Object can not be null.");
        throw obj1;
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean collapseActionView() {
        return this.d.collapseActionView();
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean expandActionView() {
        return this.d.expandActionView();
    }

    @Override // androidx.appcompat.view.menu.c
    public ActionProvider getActionProvider() {
        b bVar2 = this.d.b();
        if (bVar2 instanceof j.a) {
            return bVar2.b;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.c
    public View getActionView() {
        View actionView;
        actionView = this.d.getActionView();
        if (actionView instanceof j.c) {
            actionView = (j.c)actionView.a();
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.c
    public int getAlphabeticModifiers() {
        return this.d.getAlphabeticModifiers();
    }

    @Override // androidx.appcompat.view.menu.c
    public char getAlphabeticShortcut() {
        return this.d.getAlphabeticShortcut();
    }

    @Override // androidx.appcompat.view.menu.c
    public java.lang.CharSequence getContentDescription() {
        return this.d.getContentDescription();
    }

    @Override // androidx.appcompat.view.menu.c
    public int getGroupId() {
        return this.d.getGroupId();
    }

    @Override // androidx.appcompat.view.menu.c
    public Drawable getIcon() {
        return this.d.getIcon();
    }

    @Override // androidx.appcompat.view.menu.c
    public ColorStateList getIconTintList() {
        return this.d.getIconTintList();
    }

    @Override // androidx.appcompat.view.menu.c
    public PorterDuff.Mode getIconTintMode() {
        return this.d.getIconTintMode();
    }

    @Override // androidx.appcompat.view.menu.c
    public Intent getIntent() {
        return this.d.getIntent();
    }

    @Override // androidx.appcompat.view.menu.c
    public int getItemId() {
        return this.d.getItemId();
    }

    @Override // androidx.appcompat.view.menu.c
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.d.getMenuInfo();
    }

    @Override // androidx.appcompat.view.menu.c
    public int getNumericModifiers() {
        return this.d.getNumericModifiers();
    }

    @Override // androidx.appcompat.view.menu.c
    public char getNumericShortcut() {
        return this.d.getNumericShortcut();
    }

    @Override // androidx.appcompat.view.menu.c
    public int getOrder() {
        return this.d.getOrder();
    }

    @Override // androidx.appcompat.view.menu.c
    public SubMenu getSubMenu() {
        return d(this.d.getSubMenu());
    }

    @Override // androidx.appcompat.view.menu.c
    public java.lang.CharSequence getTitle() {
        return this.d.getTitle();
    }

    @Override // androidx.appcompat.view.menu.c
    public java.lang.CharSequence getTitleCondensed() {
        return this.d.getTitleCondensed();
    }

    @Override // androidx.appcompat.view.menu.c
    public java.lang.CharSequence getTooltipText() {
        return this.d.getTooltipText();
    }

    @Override // androidx.appcompat.view.menu.c
    public void h(boolean z) {
        Method declaredMethod;
        Method method;
        int i;
        String str;
        Class[] arr;
        Class tYPE;
        Boolean obj7;
        try {
            i = 0;
            int i2 = 1;
            if (this.e == null) {
            }
            arr = new Class[i2];
            arr[i] = Boolean.TYPE;
            this.e = this.d.getClass().getDeclaredMethod("setExclusiveCheckable", arr);
            Object[] arr2 = new Object[i2];
            arr2[i] = Boolean.valueOf(z);
            this.e.invoke(this.d, arr2);
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", z);
        }
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean hasSubMenu() {
        return this.d.hasSubMenu();
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean isActionViewExpanded() {
        return this.d.isActionViewExpanded();
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean isCheckable() {
        return this.d.isCheckable();
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean isChecked() {
        return this.d.isChecked();
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean isEnabled() {
        return this.d.isEnabled();
    }

    @Override // androidx.appcompat.view.menu.c
    public boolean isVisible() {
        return this.d.isVisible();
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        androidx.appcompat.view.menu.j.a bVar;
        Context context;
        if (Build.VERSION.SDK_INT >= 16) {
            bVar = new j.b(this, this.a, actionProvider);
        } else {
            bVar = new j.a(this, this.a, actionProvider);
        }
        if (actionProvider != null) {
        } else {
            bVar = 0;
        }
        this.d.a(bVar);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setActionView(int i) {
        boolean z;
        androidx.appcompat.view.menu.j.c cVar;
        this.d.setActionView(i);
        View obj3 = this.d.getActionView();
        if (obj3 instanceof CollapsibleActionView != null) {
            cVar = new j.c(obj3);
            this.d.setActionView(cVar);
        }
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setActionView(View view) {
        boolean cVar;
        Object obj2;
        if (view instanceof CollapsibleActionView != null) {
            cVar = new j.c(view);
            obj2 = cVar;
        }
        this.d.setActionView(obj2);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setAlphabeticShortcut(char c) {
        this.d.setAlphabeticShortcut(c);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setAlphabeticShortcut(char c, int i2) {
        this.d.setAlphabeticShortcut(c, i2);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setCheckable(boolean z) {
        this.d.setCheckable(z);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setChecked(boolean z) {
        this.d.setChecked(z);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setContentDescription(java.lang.CharSequence charSequence) {
        this.d.setContentDescription(charSequence);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setEnabled(boolean z) {
        this.d.setEnabled(z);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setIcon(int i) {
        this.d.setIcon(i);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setIcon(Drawable drawable) {
        this.d.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.d.setIconTintList(colorStateList);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setIconTintMode(PorterDuff.Mode porterDuff$Mode) {
        this.d.setIconTintMode(mode);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setIntent(Intent intent) {
        this.d.setIntent(intent);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setNumericShortcut(char c) {
        this.d.setNumericShortcut(c);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setNumericShortcut(char c, int i2) {
        this.d.setNumericShortcut(c, i2);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener menuItem$OnActionExpandListener) {
        androidx.appcompat.view.menu.j.d dVar;
        if (onActionExpandListener != null) {
            dVar = new j.d(this, onActionExpandListener);
        } else {
            dVar = 0;
        }
        this.d.setOnActionExpandListener(dVar);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener) {
        androidx.appcompat.view.menu.j.e eVar;
        if (onMenuItemClickListener != null) {
            eVar = new j.e(this, onMenuItemClickListener);
        } else {
            eVar = 0;
        }
        this.d.setOnMenuItemClickListener(eVar);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setShortcut(char c, char c2) {
        this.d.setShortcut(c, c2);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setShortcut(char c, char c2, int i3, int i4) {
        this.d.setShortcut(c, c2, i3, i4);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public void setShowAsAction(int i) {
        this.d.setShowAsAction(i);
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setShowAsActionFlags(int i) {
        this.d.setShowAsActionFlags(i);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setTitle(int i) {
        this.d.setTitle(i);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setTitle(java.lang.CharSequence charSequence) {
        this.d.setTitle(charSequence);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setTitleCondensed(java.lang.CharSequence charSequence) {
        this.d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setTooltipText(java.lang.CharSequence charSequence) {
        this.d.setTooltipText(charSequence);
        return this;
    }

    @Override // androidx.appcompat.view.menu.c
    public MenuItem setVisible(boolean z) {
        return this.d.setVisible(z);
    }
}
