package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import d.e.g;
import d.h.g.a.b;
import d.h.g.a.c;

/* loaded from: classes.dex */
abstract class c {

    final Context a;
    private g<b, MenuItem> b;
    private g<c, SubMenu> c;
    c(Context context) {
        super();
        this.a = context;
    }

    final MenuItem c(MenuItem menuItem) {
        boolean obj;
        g gVar;
        g gVar2;
        Object obj3;
        obj = menuItem;
        if (menuItem instanceof b && this.b == null) {
            obj = menuItem;
            if (this.b == null) {
                gVar = new g();
                this.b = gVar;
            }
            if ((MenuItem)this.b.get(menuItem) == null) {
                obj3 = new j(this.a, (b)(b)obj);
                this.b.put(obj, obj3);
            }
        }
        return obj3;
    }

    final SubMenu d(SubMenu subMenu) {
        g gVar2;
        Object sVar;
        g gVar;
        if (subMenu instanceof c && this.c == null) {
            if (this.c == null) {
                gVar2 = new g();
                this.c = gVar2;
            }
            if ((SubMenu)this.c.get((c)(c)subMenu) == null) {
                sVar = new s(this.a, subMenu);
                this.c.put(subMenu, sVar);
            }
            return sVar;
        }
        return subMenu;
    }

    final void e() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.clear();
        }
        g gVar2 = this.c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    final void f(int i) {
        int i2;
        int groupId;
        if (this.b == null) {
        }
        i2 = 0;
        while (i2 < this.b.size()) {
            if ((b)this.b.j(i2).getGroupId() == i) {
            }
            i2++;
            this.b.l(i2);
            i2--;
        }
    }

    final void g(int i) {
        int i2;
        int itemId;
        int obj3;
        if (this.b == null) {
        }
        i2 = 0;
        while (i2 < this.b.size()) {
            if ((b)this.b.j(i2).getItemId() == i) {
                break;
            } else {
            }
            i2++;
        }
    }
}
