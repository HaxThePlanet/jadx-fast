package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.view.menu.l;
import d.a.a;
import d.a.o.g;

/* loaded from: classes.dex */
public class i0 {

    private final Context a;
    private final g b;
    final l c;
    androidx.appcompat.widget.i0.d d;
    androidx.appcompat.widget.i0.c e;

    class b implements PopupWindow.OnDismissListener {

        final androidx.appcompat.widget.i0 a;
        b(androidx.appcompat.widget.i0 i0) {
            this.a = i0;
            super();
        }

        @Override // android.widget.PopupWindow$OnDismissListener
        public void onDismiss() {
            final androidx.appcompat.widget.i0 i0Var = this.a;
            final androidx.appcompat.widget.i0.c cVar = i0Var.e;
            if (cVar != null) {
                cVar.a(i0Var);
            }
        }
    }

    public interface c {
        public abstract void a(androidx.appcompat.widget.i0 i0);
    }

    public interface d {
        public abstract boolean onMenuItemClick(MenuItem menuItem);
    }

    class a implements g.a {

        final androidx.appcompat.widget.i0 a;
        a(androidx.appcompat.widget.i0 i0) {
            this.a = i0;
            super();
        }

        @Override // androidx.appcompat.view.menu.g$a
        public boolean a(g g, MenuItem menuItem2) {
            androidx.appcompat.widget.i0.d obj1 = obj1.d;
            if (obj1 != null) {
                return obj1.onMenuItemClick(menuItem2);
            }
            return 0;
        }

        @Override // androidx.appcompat.view.menu.g$a
        public void b(g g) {
        }
    }
    public i0(Context context, View view2) {
        super(context, view2, 0);
    }

    public i0(Context context, View view2, int i3) {
        super(context, view2, i3, a.G, 0);
    }

    public i0(Context context, View view2, int i3, int i4, int i5) {
        super();
        this.a = context;
        g gVar = new g(context);
        this.b = gVar;
        i0.a aVar = new i0.a(this);
        gVar.V(aVar);
        super(context, gVar, view2, 0, i4, i5);
        this.c = lVar2;
        lVar2.h(i3);
        i0.b obj9 = new i0.b(this);
        lVar2.i(obj9);
    }

    public Menu a() {
        return this.b;
    }

    public MenuInflater b() {
        g gVar = new g(this.a);
        return gVar;
    }

    public void c(int i) {
        b().inflate(i, this.b);
    }

    public void d(int i) {
        this.c.h(i);
    }

    public void e(androidx.appcompat.widget.i0.d i0$d) {
        this.d = d;
    }

    public void f() {
        this.c.k();
    }
}
