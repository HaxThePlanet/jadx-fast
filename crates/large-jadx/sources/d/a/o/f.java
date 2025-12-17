package d.a.o;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import d.e.g;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends ActionMode {

    final Context a;
    final d.a.o.b b;

    public static class a implements d.a.o.b.a {

        final ActionMode.Callback a;
        final Context b;
        final ArrayList<d.a.o.f> c;
        final g<Menu, Menu> d;
        public a(Context context, ActionMode.Callback actionMode$Callback2) {
            super();
            this.b = context;
            this.a = callback2;
            ArrayList obj1 = new ArrayList();
            this.c = obj1;
            obj1 = new g();
            this.d = obj1;
        }

        private Menu f(Menu menu) {
            Object oVar;
            g gVar;
            Object obj;
            if ((Menu)this.d.get(menu) == null) {
                oVar = new o(this.b, (a)menu);
                this.d.put(menu, oVar);
            }
            return oVar;
        }

        @Override // d.a.o.b$a
        public void a(d.a.o.b b) {
            this.a.onDestroyActionMode(e(b));
        }

        @Override // d.a.o.b$a
        public boolean b(d.a.o.b b, Menu menu2) {
            return this.a.onCreateActionMode(e(b), f(menu2));
        }

        @Override // d.a.o.b$a
        public boolean c(d.a.o.b b, Menu menu2) {
            return this.a.onPrepareActionMode(e(b), f(menu2));
        }

        @Override // d.a.o.b$a
        public boolean d(d.a.o.b b, MenuItem menuItem2) {
            j jVar = new j(this.b, (b)menuItem2);
            return this.a.onActionItemClicked(e(b), jVar);
        }

        @Override // d.a.o.b$a
        public ActionMode e(d.a.o.b b) {
            int i;
            Object obj;
            d.a.o.b bVar;
            i = 0;
            while (i < this.c.size()) {
                obj = this.c.get(i);
                i++;
            }
            f fVar = new f(this.b, b);
            this.c.add(fVar);
            return fVar;
        }
    }
    public f(Context context, d.a.o.b b2) {
        super();
        this.a = context;
        this.b = b2;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        o oVar = new o(this.a, (a)this.b.e());
        return oVar;
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.f();
    }

    @Override // android.view.ActionMode
    public java.lang.CharSequence getSubtitle() {
        return this.b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.h();
    }

    @Override // android.view.ActionMode
    public java.lang.CharSequence getTitle() {
        return this.b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.n(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(java.lang.CharSequence charSequence) {
        this.b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object object) {
        this.b.p(object);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.q(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(java.lang.CharSequence charSequence) {
        this.b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.b.s(z);
    }
}
