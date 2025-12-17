package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.view.menu.m.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.f;
import androidx.appcompat.widget.u0;
import androidx.appcompat.widget.z;
import d.a.o.i;
import d.h.l.u;
import java.util.ArrayList;

/* loaded from: classes.dex */
class l extends androidx.appcompat.app.a {

    z a;
    boolean b;
    Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<androidx.appcompat.app.a.b> f;
    private final Runnable g;
    private final Toolbar.f h;

    class a implements Runnable {

        final androidx.appcompat.app.l a;
        a(androidx.appcompat.app.l l) {
            this.a = l;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.z();
        }
    }

    class b implements Toolbar.f {

        final androidx.appcompat.app.l a;
        b(androidx.appcompat.app.l l) {
            this.a = l;
            super();
        }

        @Override // androidx.appcompat.widget.Toolbar$f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return lVar.c.onMenuItemSelected(0, menuItem);
        }
    }

    private final class c implements m.a {

        private boolean a;
        final androidx.appcompat.app.l b;
        c(androidx.appcompat.app.l l) {
            this.b = l;
            super();
        }

        @Override // androidx.appcompat.view.menu.m$a
        public void c(g g, boolean z2) {
            int i;
            if (this.a) {
            }
            this.a = true;
            obj3.a.h();
            Window.Callback obj3 = obj3.c;
            if (obj3 != null) {
                obj3.onPanelClosed(108, g);
            }
            this.a = false;
        }

        @Override // androidx.appcompat.view.menu.m$a
        public boolean d(g g) {
            Window.Callback callback = lVar.c;
            if (callback != null) {
                callback.onMenuOpened(108, g);
                return 1;
            }
            return 0;
        }
    }

    private final class d implements g.a {

        final androidx.appcompat.app.l a;
        d(androidx.appcompat.app.l l) {
            this.a = l;
            super();
        }

        @Override // androidx.appcompat.view.menu.g$a
        public boolean a(g g, MenuItem menuItem2) {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.g$a
        public void b(g g) {
            androidx.appcompat.app.l onPreparePanel;
            Window.Callback callback;
            int i2;
            int i;
            onPreparePanel = this.a;
            if (onPreparePanel.c != null) {
                callback = 108;
                if (onPreparePanel.a.b()) {
                    lVar3.c.onPanelClosed(callback, g);
                } else {
                    if (lVar.c.onPreparePanel(0, 0, g)) {
                        lVar2.c.onMenuOpened(callback, g);
                    }
                }
            }
        }
    }

    private class e extends i {

        final androidx.appcompat.app.l b;
        public e(androidx.appcompat.app.l l, Window.Callback window$Callback2) {
            this.b = l;
            super(callback2);
        }

        @Override // d.a.o.i
        public View onCreatePanelView(int i) {
            if (i == 0) {
                View obj2 = new View(lVar.a.getContext());
                return obj2;
            }
            return super.onCreatePanelView(i);
        }

        @Override // d.a.o.i
        public boolean onPreparePanel(int i, View view2, Menu menu3) {
            Object obj2;
            Menu obj3;
            final boolean obj1 = super.onPreparePanel(i, view2, menu3);
            obj2 = this.b;
            if (obj1 != null && !obj2.b) {
                obj2 = this.b;
                if (!obj2.b) {
                    obj2.a.c();
                    obj2.b = true;
                }
            }
            return obj1;
        }
    }
    l(Toolbar toolbar, java.lang.CharSequence charSequence2, Window.Callback window$Callback3) {
        super();
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        l.a aVar = new l.a(this);
        this.g = aVar;
        l.b bVar = new l.b(this);
        this.h = bVar;
        u0 u0Var = new u0(toolbar, 0);
        this.a = u0Var;
        l.e eVar = new l.e(this, callback3);
        this.c = eVar;
        this.a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.a.setWindowTitle(charSequence2);
    }

    private Menu x() {
        boolean z;
        androidx.appcompat.app.l.c cVar;
        androidx.appcompat.app.l.d dVar;
        if (!this.d) {
            cVar = new l.c(this);
            dVar = new l.d(this);
            this.a.p(cVar, dVar);
            this.d = true;
        }
        return this.a.l();
    }

    @Override // androidx.appcompat.app.a
    public void A(int i, int i2) {
        this.a.k(obj3 |= obj4);
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.a.f();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (this.a.j()) {
            this.a.collapseActionView();
            return 1;
        }
        return 0;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        int i;
        Object obj;
        if (z == this.e) {
        }
        this.e = z;
        i = 0;
        while (i < this.f.size()) {
            (a.b)this.f.get(i).a(z);
            i++;
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.a.t();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.a.r().removeCallbacks(this.g);
        u.d0(this.a.r(), this.g);
        return 1;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.a
    void n() {
        this.a.r().removeCallbacks(this.g);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent2) {
        int deviceId;
        int i2;
        final Menu menu = x();
        final int i3 = 0;
        if (menu != null) {
            if (keyEvent2 != null) {
                deviceId = keyEvent2.getDeviceId();
            } else {
                deviceId = -1;
            }
            if (KeyCharacterMap.load(deviceId).getKeyboardType() != 1) {
            } else {
                i2 = i3;
            }
            menu.setQwertyMode(i2);
            return menu.performShortcut(i, keyEvent2, i3);
        }
        return i3;
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        final int i = 1;
        if (keyEvent.getAction() == i) {
            q();
        }
        return i;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.a.g();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
        int obj2;
        final int i = 4;
        obj2 = z ? i : 0;
        A(obj2, i);
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void u(java.lang.CharSequence charSequence) {
        this.a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void v(java.lang.CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public Window.Callback y() {
        return this.c;
    }

    @Override // androidx.appcompat.app.a
    void z() {
        int i;
        int onPreparePanel;
        boolean onCreatePanelMenu;
        final Menu menu = x();
        onPreparePanel = 0;
        if (menu instanceof g) {
            i = menu;
        } else {
            i = onPreparePanel;
        }
        if (i != 0) {
            i.h0();
        }
        menu.clear();
        final int i2 = 0;
        if (this.c.onCreatePanelMenu(i2, menu)) {
            if (!this.c.onPreparePanel(i2, onPreparePanel, menu)) {
                menu.clear();
            }
        } else {
        }
        if (i != 0) {
            i.g0();
        }
    }
}
