package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import androidx.core.graphics.drawable.a;
import d.a.h;
import d.a.k.a.a;
import d.h.g.a.b;
import d.h.l.b;
import d.h.l.b.b;

/* loaded from: classes.dex */
public final class i implements b {

    private View A;
    private b B;
    private MenuItem.OnActionExpandListener C;
    private boolean D = false;
    private ContextMenu.ContextMenuInfo E;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private java.lang.CharSequence e;
    private java.lang.CharSequence f;
    private Intent g;
    private char h;
    private int i = 4096;
    private char j;
    private int k = 4096;
    private Drawable l;
    private int m = 0;
    androidx.appcompat.view.menu.g n;
    private androidx.appcompat.view.menu.r o;
    private Runnable p;
    private MenuItem.OnMenuItemClickListener q;
    private java.lang.CharSequence r;
    private java.lang.CharSequence s;
    private ColorStateList t = null;
    private PorterDuff.Mode u = null;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private int y = 16;
    private int z = 0;

    class a implements b.b {

        final androidx.appcompat.view.menu.i a;
        a(androidx.appcompat.view.menu.i i) {
            this.a = i;
            super();
        }

        @Override // d.h.l.b$b
        public void onActionProviderVisibilityChanged(boolean z) {
            final androidx.appcompat.view.menu.i obj2 = this.a;
            obj2.n.L(obj2);
        }
    }
    i(androidx.appcompat.view.menu.g g, int i2, int i3, int i4, int i5, java.lang.CharSequence charSequence6, int i7) {
        super();
        int i = 4096;
        int i6 = 0;
        int i8 = 0;
        int i9 = 16;
        this.n = g;
        this.a = i3;
        this.b = i2;
        this.c = i4;
        this.d = i5;
        this.e = charSequence6;
        this.z = i7;
    }

    private static void d(StringBuilder stringBuilder, int i2, int i3, String string4) {
        if (i2 &= i3 == i3) {
            stringBuilder.append(string4);
        }
    }

    private Drawable e(Drawable drawable) {
        boolean z2;
        boolean z3;
        boolean z;
        Drawable obj2;
        if (drawable != null && this.x) {
            if (this.x) {
                if (!this.v) {
                    obj2 = a.r(drawable).mutate();
                    if (this.w && this.v) {
                        obj2 = a.r(drawable).mutate();
                        if (this.v) {
                            a.o(obj2, this.t);
                        }
                        if (this.w) {
                            a.p(obj2, this.u);
                        }
                        this.x = false;
                    }
                } else {
                }
            }
        }
        return obj2;
    }

    @Override // d.h.g.a.b
    boolean A() {
        boolean z;
        int i;
        if (this.n.J() && g() != 0) {
            i = g() != 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // d.h.g.a.b
    public boolean B() {
        int i;
        final int i4 = 4;
        i = i2 &= i4 == i4 ? 1 : 0;
        return i;
    }

    @Override // d.h.g.a.b
    public b a(b b) {
        int aVar;
        b bVar = this.B;
        if (bVar != null) {
            bVar.h();
        }
        this.A = 0;
        this.B = b;
        this.n.M(true);
        b obj2 = this.B;
        if (obj2 != null) {
            aVar = new i.a(this);
            obj2.j(aVar);
        }
        return this;
    }

    @Override // d.h.g.a.b
    public b b() {
        return this.B;
    }

    @Override // d.h.g.a.b
    public void c() {
        this.n.K(this);
    }

    @Override // d.h.g.a.b
    public boolean collapseActionView() {
        MenuItem.OnActionExpandListener onMenuItemActionCollapse;
        final int i4 = 0;
        if (i &= 8 == 0) {
            return i4;
        }
        if (this.A == null) {
            return 1;
        }
        onMenuItemActionCollapse = this.C;
        if (onMenuItemActionCollapse != null && onMenuItemActionCollapse.onMenuItemActionCollapse(this)) {
            if (onMenuItemActionCollapse.onMenuItemActionCollapse(this)) {
            }
            return i4;
        }
        return this.n.f(this);
    }

    @Override // d.h.g.a.b
    public boolean expandActionView() {
        MenuItem.OnActionExpandListener onMenuItemActionExpand;
        final int i = 0;
        if (!j()) {
            return i;
        }
        onMenuItemActionExpand = this.C;
        if (onMenuItemActionExpand != null && onMenuItemActionExpand.onMenuItemActionExpand(this)) {
            if (onMenuItemActionExpand.onMenuItemActionExpand(this)) {
            }
            return i;
        }
        return this.n.m(this);
    }

    @Override // d.h.g.a.b
    public int f() {
        return this.d;
    }

    @Override // d.h.g.a.b
    char g() {
        char c;
        c = this.n.I() ? this.j : this.h;
        return c;
    }

    @Override // d.h.g.a.b
    public ActionProvider getActionProvider() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
        throw unsupportedOperationException;
    }

    @Override // d.h.g.a.b
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        b bVar = this.B;
        if (bVar != null) {
            View view2 = bVar.d(this);
            this.A = view2;
            return view2;
        }
        return null;
    }

    @Override // d.h.g.a.b
    public int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // d.h.g.a.b
    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // d.h.g.a.b
    public java.lang.CharSequence getContentDescription() {
        return this.r;
    }

    @Override // d.h.g.a.b
    public int getGroupId() {
        return this.b;
    }

    @Override // d.h.g.a.b
    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.m != 0) {
            Drawable drawable3 = a.d(this.n.w(), this.m);
            this.m = 0;
            this.l = drawable3;
            return e(drawable3);
        }
        return null;
    }

    @Override // d.h.g.a.b
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // d.h.g.a.b
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    @Override // d.h.g.a.b
    public Intent getIntent() {
        return this.g;
    }

    @ViewDebug$CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    @Override // d.h.g.a.b
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // d.h.g.a.b
    public int getNumericModifiers() {
        return this.i;
    }

    @Override // d.h.g.a.b
    public char getNumericShortcut() {
        return this.h;
    }

    @Override // d.h.g.a.b
    public int getOrder() {
        return this.c;
    }

    @Override // d.h.g.a.b
    public SubMenu getSubMenu() {
        return this.o;
    }

    @ViewDebug$CapturedViewProperty
    public java.lang.CharSequence getTitle() {
        return this.e;
    }

    @Override // d.h.g.a.b
    public java.lang.CharSequence getTitleCondensed() {
        java.lang.CharSequence string;
        int sDK_INT;
        if (this.f != null) {
        } else {
            string = this.e;
        }
        if (Build.VERSION.SDK_INT < 18 && string != null && string instanceof String == null) {
            if (string != null) {
                if (string instanceof String == null) {
                    string = string.toString();
                }
            }
        }
        return string;
    }

    @Override // d.h.g.a.b
    public java.lang.CharSequence getTooltipText() {
        return this.s;
    }

    @Override // d.h.g.a.b
    String h() {
        String string;
        boolean permanentMenuKey;
        int i;
        string = g();
        if (string == 0) {
            return "";
        }
        Resources resources = this.n.w().getResources();
        StringBuilder stringBuilder = new StringBuilder();
        if (ViewConfiguration.get(this.n.w()).hasPermanentMenuKey()) {
            stringBuilder.append(resources.getString(h.k));
        }
        i = this.n.I() ? this.k : this.i;
        i.d(stringBuilder, i, 65536, resources.getString(h.g));
        i.d(stringBuilder, i, 4096, resources.getString(h.c));
        i.d(stringBuilder, i, 2, resources.getString(h.b));
        i.d(stringBuilder, i, 1, resources.getString(h.h));
        i.d(stringBuilder, i, 4, resources.getString(h.j));
        int i17 = 8;
        i.d(stringBuilder, i, i17, resources.getString(h.f));
        if (string != i17) {
            if (string != 10) {
                if (string != 32) {
                    stringBuilder.append(string);
                } else {
                    stringBuilder.append(resources.getString(h.i));
                }
            } else {
                stringBuilder.append(resources.getString(h.e));
            }
        } else {
            stringBuilder.append(resources.getString(h.d));
        }
        return stringBuilder.toString();
    }

    @Override // d.h.g.a.b
    public boolean hasSubMenu() {
        int i;
        i = this.o != null ? 1 : 0;
        return i;
    }

    @Override // d.h.g.a.b
    java.lang.CharSequence i(androidx.appcompat.view.menu.n.a n$a) {
        boolean obj1;
        if (a && a.g()) {
            if (a.g()) {
                obj1 = getTitleCondensed();
            } else {
                obj1 = getTitle();
            }
        } else {
        }
        return obj1;
    }

    @Override // d.h.g.a.b
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // d.h.g.a.b
    public boolean isCheckable() {
        int i;
        i = 1;
        if (i2 &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // d.h.g.a.b
    public boolean isChecked() {
        int i;
        final int i4 = 2;
        i = i2 &= i4 == i4 ? 1 : 0;
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
        b bVar;
        boolean i;
        int i2;
        bVar = this.B;
        i2 = 1;
        final int i6 = 0;
        if (bVar != null && bVar.g()) {
            if (bVar.g()) {
                if (i5 &= 8 == 0 && this.B.b()) {
                    if (this.B.b()) {
                    } else {
                        i2 = i6;
                    }
                } else {
                }
                return i2;
            }
        }
        if (i3 &= 8 == 0) {
        } else {
            i2 = i6;
        }
        return i2;
    }

    @Override // d.h.g.a.b
    public boolean j() {
        Object view;
        int i2;
        int i;
        i = 0;
        view = this.B;
        if (i3 &= 8 != 0 && this.A == null && view != null) {
            if (this.A == null) {
                view = this.B;
                if (view != null) {
                    this.A = view.d(this);
                }
            }
            if (this.A != null) {
                i = 1;
            }
        }
        return i;
    }

    @Override // d.h.g.a.b
    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClick;
        Intent intent;
        b bVar;
        String str;
        String str2;
        onMenuItemClick = this.q;
        final int i2 = 1;
        if (onMenuItemClick != null && onMenuItemClick.onMenuItemClick(this)) {
            if (onMenuItemClick.onMenuItemClick(this)) {
                return i2;
            }
        }
        androidx.appcompat.view.menu.g gVar = this.n;
        if (gVar.h(gVar, this)) {
            return i2;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
            return i2;
        }
        if (this.g != null) {
            this.n.w().startActivity(this.g);
            return i2;
        }
        bVar = this.B;
        if (bVar != null && bVar.e()) {
            if (bVar.e()) {
                return i2;
            }
        }
        return 0;
    }

    @Override // d.h.g.a.b
    public boolean l() {
        int i;
        final int i4 = 32;
        i = i2 &= i4 == i4 ? 1 : 0;
        return i;
    }

    @Override // d.h.g.a.b
    public boolean m() {
        int i;
        i = i2 &= 4 != 0 ? 1 : 0;
        return i;
    }

    @Override // d.h.g.a.b
    public boolean n() {
        int i;
        i = 1;
        if (i2 &= i == i) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // d.h.g.a.b
    public boolean o() {
        int i;
        final int i4 = 2;
        i = i2 &= i4 == i4 ? 1 : 0;
        return i;
    }

    @Override // d.h.g.a.b
    public b p(int i) {
        Context context = this.n.w();
        LinearLayout linearLayout = new LinearLayout(context);
        q(LayoutInflater.from(context).inflate(i, linearLayout, false));
        return this;
    }

    @Override // d.h.g.a.b
    public b q(View view) {
        int i2;
        int i;
        this.A = view;
        this.B = 0;
        i2 = this.a;
        if (view != null && view.getId() == -1 && i2 > 0) {
            if (view.getId() == -1) {
                i2 = this.a;
                if (i2 > 0) {
                    view.setId(i2);
                }
            }
        }
        this.n.K(this);
        return this;
    }

    @Override // d.h.g.a.b
    public void r(boolean z) {
        this.D = z;
        this.n.M(false);
    }

    @Override // d.h.g.a.b
    void s(boolean z) {
        int obj4;
        final int i = this.y;
        final int i3 = 0;
        obj4 = z ? 2 : i3;
        obj4 |= i2;
        this.y = obj4;
        if (i != obj4) {
            this.n.M(i3);
        }
    }

    @Override // d.h.g.a.b
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
        throw obj2;
    }

    @Override // d.h.g.a.b
    public MenuItem setActionView(int i) {
        p(i);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setActionView(View view) {
        q(view);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.j == c) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setAlphabeticShortcut(char c, int i2) {
        char c2;
        if (this.j == c && this.k == i2) {
            if (this.k == i2) {
                return this;
            }
        }
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(i2);
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setCheckable(boolean z) {
        int i;
        int obj3;
        i = this.y;
        z |= i2;
        this.y = obj3;
        if (i != obj3) {
            this.n.M(false);
        }
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setChecked(boolean z) {
        androidx.appcompat.view.menu.g obj2;
        if (i &= 4 != 0) {
            this.n.X(this);
        } else {
            s(z);
        }
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setContentDescription(java.lang.CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // d.h.g.a.b
    public b setContentDescription(java.lang.CharSequence charSequence) {
        this.r = charSequence;
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setEnabled(boolean z) {
        int obj2;
        if (z) {
            this.y = obj2 |= 16;
        } else {
            this.y = obj2 &= -17;
        }
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIcon(int i) {
        this.l = 0;
        this.m = i;
        this.x = true;
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIcon(Drawable drawable) {
        final int i = 0;
        this.m = i;
        this.l = drawable;
        this.x = true;
        this.n.M(i);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        int obj2 = 1;
        this.v = obj2;
        this.x = obj2;
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIconTintMode(PorterDuff.Mode porterDuff$Mode) {
        this.u = mode;
        int obj2 = 1;
        this.w = obj2;
        this.x = obj2;
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setNumericShortcut(char c) {
        if (this.h == c) {
            return this;
        }
        this.h = c;
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setNumericShortcut(char c, int i2) {
        char c2;
        if (this.h == c && this.i == i2) {
            if (this.i == i2) {
                return this;
            }
        }
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i2);
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener menuItem$OnActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItem$OnMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.j = Character.toLowerCase(c2);
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setShortcut(char c, char c2, int i3, int i4) {
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i3);
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i4);
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public void setShowAsAction(int i) {
        int i2;
        int i3 = i & 3;
        if (i3 != 0 && i3 != 1) {
            if (i3 != 1) {
                if (i3 != 2) {
                } else {
                }
                IllegalArgumentException obj3 = new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
                throw obj3;
            }
        }
        this.z = i;
        this.n.K(this);
    }

    @Override // d.h.g.a.b
    public MenuItem setShowAsActionFlags(int i) {
        w(i);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setTitle(int i) {
        setTitle(this.n.w().getString(i));
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setTitle(java.lang.CharSequence charSequence) {
        this.e = charSequence;
        this.n.M(false);
        androidx.appcompat.view.menu.r rVar = this.o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setTitleCondensed(java.lang.CharSequence charSequence) {
        this.f = charSequence;
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setTooltipText(java.lang.CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // d.h.g.a.b
    public b setTooltipText(java.lang.CharSequence charSequence) {
        this.s = charSequence;
        this.n.M(false);
        return this;
    }

    @Override // d.h.g.a.b
    public MenuItem setVisible(boolean z) {
        boolean obj1;
        if (y(z)) {
            this.n.L(this);
        }
        return this;
    }

    @Override // d.h.g.a.b
    public void t(boolean z) {
        int obj2;
        obj2 = z ? 4 : 0;
        this.y = obj2 |= i2;
    }

    @Override // d.h.g.a.b
    public String toString() {
        String string;
        java.lang.CharSequence charSequence = this.e;
        if (charSequence != null) {
            string = charSequence.toString();
        } else {
            string = 0;
        }
        return string;
    }

    @Override // d.h.g.a.b
    public void u(boolean z) {
        int obj1;
        if (z) {
            this.y = obj1 |= 32;
        } else {
            this.y = obj1 &= -33;
        }
    }

    @Override // d.h.g.a.b
    void v(ContextMenu.ContextMenuInfo contextMenu$ContextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // d.h.g.a.b
    public b w(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // d.h.g.a.b
    public void x(androidx.appcompat.view.menu.r r) {
        this.o = r;
        r.setHeaderTitle(getTitle());
    }

    @Override // d.h.g.a.b
    boolean y(boolean z) {
        int i;
        int obj4;
        final int i2 = this.y;
        obj4 = z ? i : 8;
        obj4 |= i3;
        this.y = obj4;
        if (i2 != obj4) {
            i = 1;
        }
        return i;
    }

    @Override // d.h.g.a.b
    public boolean z() {
        return this.n.C();
    }
}
