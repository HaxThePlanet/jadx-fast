package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;
import d.a.d;
import d.h.l.e;
import d.h.l.u;

/* loaded from: classes.dex */
public class l {

    private final Context a;
    private final androidx.appcompat.view.menu.g b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private androidx.appcompat.view.menu.m.a i;
    private androidx.appcompat.view.menu.k j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    class a implements PopupWindow.OnDismissListener {

        final androidx.appcompat.view.menu.l a;
        a(androidx.appcompat.view.menu.l l) {
            this.a = l;
            super();
        }

        @Override // android.widget.PopupWindow$OnDismissListener
        public void onDismiss() {
            this.a.e();
        }
    }
    public l(Context context, androidx.appcompat.view.menu.g g2, View view3, boolean z4, int i5) {
        super(context, g2, view3, z4, i5, 0);
    }

    public l(Context context, androidx.appcompat.view.menu.g g2, View view3, boolean z4, int i5, int i6) {
        super();
        this.g = 8388611;
        l.a aVar = new l.a(this);
        this.l = aVar;
        this.a = context;
        this.b = g2;
        this.f = view3;
        this.c = z4;
        this.d = i5;
        this.e = i6;
    }

    private androidx.appcompat.view.menu.k a() {
        int i;
        androidx.appcompat.view.menu.k dVar;
        androidx.appcompat.view.menu.d dimensionPixelSize;
        Context i4;
        View i2;
        int i7;
        int i6;
        boolean z2;
        androidx.appcompat.view.menu.q qVar;
        Context context;
        androidx.appcompat.view.menu.g gVar;
        View view;
        int i3;
        int i5;
        boolean z;
        Display defaultDisplay = (WindowManager)this.a.getSystemService("window").getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        i = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(d.c) ? 1 : 0;
        if (i != 0) {
            super(this.a, this.f, this.d, this.e, this.c);
        } else {
            super(this.a, this.b, this.f, this.d, this.e, this.c);
        }
        dVar.n(this.b);
        dVar.w(this.l);
        dVar.r(this.f);
        dVar.h(this.i);
        dVar.t(this.h);
        dVar.u(this.g);
        return dVar;
    }

    private void l(int i, int i2, boolean z3, boolean z4) {
        int i3;
        int i4;
        int obj4;
        int obj5;
        int obj6;
        boolean obj7;
        final androidx.appcompat.view.menu.k kVar = c();
        kVar.x(z4);
        if (z3 != 0 && obj6 &= 7 == 5) {
            if (obj6 &= 7 == 5) {
                i -= obj6;
            }
            kVar.v(obj4);
            kVar.y(i2);
            obj6 = (int)obj6;
            obj7 = new Rect(obj4 - obj6, i2 - obj6, obj4 += obj6, i2 += obj6);
            kVar.s(obj7);
        }
        kVar.a();
    }

    public void b() {
        boolean z;
        if (d()) {
            this.j.dismiss();
        }
    }

    public androidx.appcompat.view.menu.k c() {
        androidx.appcompat.view.menu.k kVar;
        if (this.j == null) {
            this.j = a();
        }
        return this.j;
    }

    public boolean d() {
        androidx.appcompat.view.menu.k kVar;
        int i;
        kVar = this.j;
        if (kVar != null && kVar.b()) {
            i = kVar.b() ? 1 : 0;
        } else {
        }
        return i;
    }

    protected void e() {
        this.j = 0;
        PopupWindow.OnDismissListener list = this.k;
        if (list != null) {
            list.onDismiss();
        }
    }

    public void f(View view) {
        this.f = view;
    }

    public void g(boolean z) {
        this.h = z;
        final androidx.appcompat.view.menu.k kVar = this.j;
        if (kVar != null) {
            kVar.t(z);
        }
    }

    public void h(int i) {
        this.g = i;
    }

    public void i(PopupWindow.OnDismissListener popupWindow$OnDismissListener) {
        this.k = onDismissListener;
    }

    public void j(androidx.appcompat.view.menu.m.a m$a) {
        this.i = a;
        final androidx.appcompat.view.menu.k kVar = this.j;
        if (kVar != null) {
            kVar.h(a);
        }
    }

    public void k() {
        if (!m()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        throw illegalStateException;
    }

    public boolean m() {
        final int i = 1;
        if (d()) {
            return i;
        }
        final int i2 = 0;
        if (this.f == null) {
            return i2;
        }
        l(i2, i2, i2, i2);
        return i;
    }

    public boolean n(int i, int i2) {
        final int i3 = 1;
        if (d()) {
            return i3;
        }
        if (this.f == null) {
            return 0;
        }
        l(i, i2, i3, i3);
        return i3;
    }
}
