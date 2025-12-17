package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.h0;
import d.a.d;
import d.a.g;
import d.h.l.u;

/* loaded from: classes.dex */
final class q extends androidx.appcompat.view.menu.k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, androidx.appcompat.view.menu.m, View.OnKeyListener {

    private static final int N;
    final h0 A;
    final ViewTreeObserver.OnGlobalLayoutListener B;
    private final View.OnAttachStateChangeListener C;
    private PopupWindow.OnDismissListener D;
    private View E;
    View F;
    private androidx.appcompat.view.menu.m.a G;
    ViewTreeObserver H;
    private boolean I;
    private boolean J;
    private int K;
    private int L = 0;
    private boolean M;
    private final Context b;
    private final androidx.appcompat.view.menu.g c;
    private final androidx.appcompat.view.menu.f v;
    private final boolean w;
    private final int x;
    private final int y;
    private final int z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        final androidx.appcompat.view.menu.q a;
        a(androidx.appcompat.view.menu.q q) {
            this.a = q;
            super();
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z;
            View shown;
            if (this.a.b() && !qVar2.A.B()) {
                if (!qVar2.A.B()) {
                    shown = qVar3.F;
                    if (shown != null) {
                        if (!shown.isShown()) {
                            this.a.dismiss();
                        } else {
                            qVar4.A.a();
                        }
                    } else {
                    }
                }
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {

        final androidx.appcompat.view.menu.q a;
        b(androidx.appcompat.view.menu.q q) {
            this.a = q;
            super();
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            boolean alive;
            Object view2;
            ViewTreeObserver viewTreeObserver;
            view2 = qVar.H;
            if (view2 != null && !view2.isAlive()) {
                if (!view2.isAlive()) {
                    alive.H = view.getViewTreeObserver();
                }
                androidx.appcompat.view.menu.q qVar2 = this.a;
                qVar2.H.removeGlobalOnLayoutListener(qVar2.B);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }
    static {
        q.N = g.m;
    }

    public q(Context context, androidx.appcompat.view.menu.g g2, View view3, int i4, int i5, boolean z6) {
        super();
        q.a aVar = new q.a(this);
        this.B = aVar;
        q.b bVar = new q.b(this);
        this.C = bVar;
        int i = 0;
        this.b = context;
        this.c = g2;
        this.w = z6;
        f fVar = new f(g2, LayoutInflater.from(context), z6, q.N);
        this.v = fVar;
        this.y = i4;
        this.z = i5;
        Resources obj9 = context.getResources();
        this.x = Math.max(widthPixels /= 2, obj9.getDimensionPixelSize(d.d));
        this.E = view3;
        h0 obj6 = new h0(context, 0, i4, i5);
        this.A = obj6;
        g2.c(this, context);
    }

    private boolean B() {
        boolean z2;
        boolean z;
        int i;
        Object viewTreeObserver;
        boolean inflate;
        int viewById;
        java.lang.CharSequence charSequence;
        final int i2 = 1;
        if (b()) {
            return i2;
        }
        int i3 = 0;
        if (!this.I) {
            z = this.E;
            if (z == null) {
            } else {
                this.F = z;
                this.A.K(this);
                this.A.L(this);
                this.A.J(i2);
                View view = this.F;
                i = this.H == null ? i2 : i3;
                viewTreeObserver = view.getViewTreeObserver();
                this.H = viewTreeObserver;
                if (i != 0) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.B);
                }
                view.addOnAttachStateChangeListener(this.C);
                this.A.D(view);
                this.A.G(this.L);
                int i5 = 0;
                if (!this.J) {
                    this.K = k.q(this.v, i5, this.b, this.x);
                    this.J = i2;
                }
                this.A.F(this.K);
                this.A.I(2);
                this.A.H(p());
                this.A.a();
                ListView list = this.A.k();
                list.setOnKeyListener(this);
                inflate = LayoutInflater.from(this.b).inflate(g.l, list, i3);
                viewById = (FrameLayout)inflate.findViewById(16908310);
                if (this.M && this.c.z() != null && (TextView)viewById != null) {
                    if (this.c.z() != null) {
                        inflate = LayoutInflater.from(this.b).inflate(g.l, list, i3);
                        viewById = (FrameLayout)inflate.findViewById(16908310);
                        if ((TextView)(TextView)viewById != null) {
                            (TextView)(TextView)viewById.setText(this.c.z());
                        }
                        inflate.setEnabled(i3);
                        list.addHeaderView(inflate, i5, i3);
                    }
                }
            }
            this.A.p(this.v);
            this.A.a();
            return i2;
        }
        return i3;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a() {
        if (!B()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        throw illegalStateException;
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean b() {
        boolean z;
        int i;
        if (!this.I && this.A.b()) {
            i = this.A.b() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(androidx.appcompat.view.menu.g g, boolean z2) {
        if (g != this.c) {
        }
        dismiss();
        androidx.appcompat.view.menu.m.a aVar = this.G;
        if (aVar != null) {
            aVar.c(g, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void d(boolean z) {
        this.J = false;
        androidx.appcompat.view.menu.f obj1 = this.v;
        if (obj1 != null) {
            obj1.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void dismiss() {
        boolean z;
        if (b()) {
            this.A.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean e() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.k
    public void h(androidx.appcompat.view.menu.m.a m$a) {
        this.G = a;
    }

    @Override // androidx.appcompat.view.menu.k
    public void j(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.k
    public ListView k() {
        return this.A.k();
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean l(androidx.appcompat.view.menu.r r) {
        boolean visibleItems;
        int i;
        int i4;
        int width;
        int i5;
        boolean z;
        int i3;
        int i2;
        final int i6 = 0;
        super(this.b, r, this.F, this.w, this.y, this.z);
        lVar.j(this.G);
        lVar.g(k.z(r));
        lVar.i(this.D);
        this.D = 0;
        this.c.e(i6);
        if (r.hasVisibleItems() && absoluteGravity &= 7 == 5) {
            super(this.b, r, this.F, this.w, this.y, this.z);
            lVar.j(this.G);
            lVar.g(k.z(r));
            lVar.i(this.D);
            this.D = 0;
            this.c.e(i6);
            if (absoluteGravity &= 7 == 5) {
                i += width;
            }
            androidx.appcompat.view.menu.m.a aVar = this.G;
            if (lVar.n(i, this.A.o()) && aVar != null) {
                aVar = this.G;
                if (aVar != null) {
                    aVar.d(r);
                }
                return 1;
            }
        }
        return i6;
    }

    @Override // androidx.appcompat.view.menu.k
    public Parcelable m() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.k
    public void n(androidx.appcompat.view.menu.g g) {
    }

    @Override // androidx.appcompat.view.menu.k
    public void onDismiss() {
        boolean viewTreeObserver;
        ViewTreeObserver view;
        ViewTreeObserver.OnGlobalLayoutListener list;
        this.I = true;
        this.c.close();
        view = this.H;
        if (view != null && !view.isAlive()) {
            if (!view.isAlive()) {
                this.H = this.F.getViewTreeObserver();
            }
            this.H.removeGlobalOnLayoutListener(this.B);
            this.H = 0;
        }
        this.F.removeOnAttachStateChangeListener(this.C);
        PopupWindow.OnDismissListener list2 = this.D;
        if (list2 != null) {
            list2.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean onKey(View view, int i2, KeyEvent keyEvent3) {
        int obj1;
        final int obj3 = 1;
        if (keyEvent3.getAction() == obj3 && i2 == 82) {
            if (i2 == 82) {
                dismiss();
                return obj3;
            }
        }
        return 0;
    }

    @Override // androidx.appcompat.view.menu.k
    public void r(View view) {
        this.E = view;
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(boolean z) {
        this.v.d(z);
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(int i) {
        this.L = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(int i) {
        this.A.f(i);
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(PopupWindow.OnDismissListener popupWindow$OnDismissListener) {
        this.D = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void x(boolean z) {
        this.M = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void y(int i) {
        this.A.l(i);
    }
}
