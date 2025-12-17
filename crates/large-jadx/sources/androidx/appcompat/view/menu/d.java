package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.h0;
import d.a.d;
import d.a.g;
import d.h.l.e;
import d.h.l.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class d extends androidx.appcompat.view.menu.k implements androidx.appcompat.view.menu.m, View.OnKeyListener, PopupWindow.OnDismissListener {

    private static final int T;
    final List<androidx.appcompat.view.menu.d.d> A;
    final ViewTreeObserver.OnGlobalLayoutListener B;
    private final View.OnAttachStateChangeListener C;
    private final g0 D;
    private int E = 0;
    private int F = 0;
    private View G;
    View H;
    private int I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private boolean N = false;
    private boolean O;
    private androidx.appcompat.view.menu.m.a P;
    ViewTreeObserver Q;
    private PopupWindow.OnDismissListener R;
    boolean S;
    private final Context b;
    private final int c;
    private final int v;
    private final int w;
    private final boolean x;
    final Handler y;
    private final List<androidx.appcompat.view.menu.g> z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        final androidx.appcompat.view.menu.d a;
        a(androidx.appcompat.view.menu.d d) {
            this.a = d;
            super();
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean iterator;
            View shown;
            int next;
            if (this.a.b() && dVar2.A.size() > 0 && !obj.a.B()) {
                if (dVar2.A.size() > 0) {
                    if (!obj.a.B()) {
                        shown = dVar4.H;
                        if (shown != null) {
                            if (!shown.isShown()) {
                                this.a.dismiss();
                            } else {
                                iterator = dVar5.A.iterator();
                                for (d.d next2 : iterator) {
                                    next2.a.a();
                                }
                            }
                        } else {
                        }
                    }
                }
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {

        final androidx.appcompat.view.menu.d a;
        b(androidx.appcompat.view.menu.d d) {
            this.a = d;
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
            view2 = dVar.Q;
            if (view2 != null && !view2.isAlive()) {
                if (!view2.isAlive()) {
                    alive.Q = view.getViewTreeObserver();
                }
                androidx.appcompat.view.menu.d dVar2 = this.a;
                dVar2.Q.removeGlobalOnLayoutListener(dVar2.B);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    private static class d {

        public final h0 a;
        public final androidx.appcompat.view.menu.g b;
        public final int c;
        public d(h0 h0, androidx.appcompat.view.menu.g g2, int i3) {
            super();
            this.a = h0;
            this.b = g2;
            this.c = i3;
        }

        public ListView a() {
            return this.a.k();
        }
    }

    class c implements g0 {

        final androidx.appcompat.view.menu.d a;
        c(androidx.appcompat.view.menu.d d) {
            this.a = d;
            super();
        }

        @Override // androidx.appcompat.widget.g0
        public void e(androidx.appcompat.view.menu.g g, MenuItem menuItem2) {
            int size;
            int i;
            int i2;
            int i3;
            androidx.appcompat.view.menu.g gVar;
            dVar.y.removeCallbacksAndMessages(0);
            i2 = 0;
            i3 = -1;
            while (i2 < dVar2.A.size()) {
                i2++;
                i3 = -1;
            }
            i2 = i3;
            if (i2 == i3) {
            }
            i2++;
            if (i5 < dVar3.A.size()) {
                i = size;
            }
            d.c.a aVar = new d.c.a(this, i, menuItem2, g);
            obj7.y.postAtTime(aVar, g, uptimeMillis += i6);
        }

        @Override // androidx.appcompat.widget.g0
        public void h(androidx.appcompat.view.menu.g g, MenuItem menuItem2) {
            obj2.y.removeCallbacksAndMessages(g);
        }
    }
    static {
        d.T = g.e;
    }

    public d(Context context, View view2, int i3, int i4, boolean z5) {
        super();
        ArrayList arrayList = new ArrayList();
        this.z = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.A = arrayList2;
        d.a aVar = new d.a(this);
        this.B = aVar;
        d.b bVar = new d.b(this);
        this.C = bVar;
        d.c cVar = new d.c(this);
        this.D = cVar;
        int i = 0;
        this.b = context;
        this.G = view2;
        this.v = i3;
        this.w = i4;
        this.x = z5;
        this.I = F();
        Resources obj2 = context.getResources();
        this.c = Math.max(obj3 /= 2, obj2.getDimensionPixelSize(d.d));
        obj2 = new Handler();
        this.y = obj2;
    }

    private h0 B() {
        h0 h0Var = new h0(this.b, 0, this.v, this.w);
        h0Var.T(this.D);
        h0Var.L(this);
        h0Var.K(this);
        h0Var.D(this.G);
        h0Var.G(this.F);
        h0Var.J(true);
        h0Var.I(2);
        return h0Var;
    }

    private int C(androidx.appcompat.view.menu.g g) {
        int i;
        androidx.appcompat.view.menu.g gVar;
        i = 0;
        while (i < this.A.size()) {
            i++;
        }
        return -1;
    }

    private MenuItem D(androidx.appcompat.view.menu.g g, androidx.appcompat.view.menu.g g2) {
        int i;
        MenuItem item;
        boolean subMenu;
        i = 0;
        while (i < g.size()) {
            item = g.getItem(i);
            i++;
        }
        return null;
    }

    private View E(androidx.appcompat.view.menu.d.d d$d, androidx.appcompat.view.menu.g g2) {
        android.widget.ListAdapter wrappedAdapter;
        int headersCount;
        int i2;
        int i;
        androidx.appcompat.view.menu.i iVar;
        int obj9;
        obj9 = D(d.b, g2);
        int i3 = 0;
        if (obj9 == null) {
            return i3;
        }
        ListView obj8 = d.a();
        wrappedAdapter = obj8.getAdapter();
        if (wrappedAdapter instanceof HeaderViewListAdapter != null) {
            headersCount = (HeaderViewListAdapter)wrappedAdapter.getHeadersCount();
            wrappedAdapter = wrappedAdapter.getWrappedAdapter();
        } else {
            headersCount = i2;
        }
        i = -1;
        while (i2 < wrappedAdapter.getCount()) {
            i2++;
            i = -1;
        }
        i2 = i;
        if (i2 == i) {
            return i3;
        }
        i4 -= obj9;
        if (i5 >= 0 && i5 >= obj8.getChildCount()) {
            if (i5 >= obj8.getChildCount()) {
            }
            return obj8.getChildAt(i5);
        }
        return i3;
    }

    private int F() {
        int i;
        if (u.B(this.G) == 1) {
            i = 0;
        }
        return i;
    }

    private int G(int i) {
        List list = this.A;
        final int i9 = 1;
        ListView list2 = (d.d)list.get(size -= i9).a();
        int[] iArr = new int[2];
        list2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.H.getWindowVisibleDisplayFrame(rect);
        final int i11 = 0;
        if (this.I == i9 && i7 += i > rect.right) {
            if (i7 += i > rect.right) {
                return i11;
            }
            return i9;
        }
        if (i2 -= i < 0) {
            return i9;
        }
        return i11;
    }

    private void H(androidx.appcompat.view.menu.g g) {
        Object inflate;
        Object viewById;
        boolean z2;
        int width2;
        boolean z;
        boolean z3;
        View view;
        int i;
        int i6;
        int i3;
        int i4;
        int i8;
        int i5;
        int i7;
        int i2;
        int width;
        Object obj15;
        inflate = LayoutInflater.from(this.b);
        f fVar = new f(g, inflate, this.x, d.T);
        int i13 = 1;
        if (!b() && this.N) {
            if (this.N) {
                fVar.d(i13);
            } else {
                if (b()) {
                    fVar.d(k.z(g));
                }
            }
        } else {
        }
        final int i16 = 0;
        width2 = k.q(fVar, i16, this.b, this.c);
        h0 h0Var = B();
        h0Var.p(fVar);
        h0Var.F(width2);
        h0Var.G(this.F);
        if (this.A.size() > 0) {
            List list2 = this.A;
            view = E((d.d)list2.get(size2 -= i13), g);
        } else {
            view = viewById;
        }
        final int i18 = 0;
        if (view != null) {
            h0Var.U(i18);
            h0Var.R(i16);
            int i19 = G(width2);
            i6 = i19 == i13 ? i13 : i18;
            this.I = i19;
            i8 = 5;
            if (Build.VERSION.SDK_INT >= 26) {
                h0Var.D(view);
                i7 = i;
            } else {
                int i20 = 2;
                int[] iArr2 = new int[i20];
                this.G.getLocationOnScreen(iArr2);
                int[] iArr = new int[i20];
                view.getLocationOnScreen(iArr);
                if (i23 &= 7 == i8) {
                    iArr2[i18] = i24 += width3;
                    iArr[i18] = i26 += width;
                }
                i27 -= width;
                i21 -= i3;
            }
            if (i22 &= i8 == i8) {
                if (i6 != 0) {
                    i7 += width2;
                } else {
                    width2 = view.getWidth();
                    i7 -= width2;
                }
            } else {
                if (i6 != 0) {
                    width2 = view.getWidth();
                } else {
                }
            }
            h0Var.f(i2);
            h0Var.M(i13);
            h0Var.l(i);
        } else {
            if (this.J) {
                h0Var.f(this.L);
            }
            if (this.K) {
                h0Var.l(this.M);
            }
            h0Var.H(p());
        }
        d.d dVar = new d.d(h0Var, g, this.I);
        this.A.add(dVar);
        h0Var.a();
        ListView list3 = h0Var.k();
        list3.setOnKeyListener(this);
        if (viewById == null && this.O && g.z() != null) {
            if (this.O) {
                if (g.z() != null) {
                    inflate = inflate.inflate(g.l, list3, i18);
                    inflate.setEnabled(i18);
                    (TextView)(FrameLayout)inflate.findViewById(16908310).setText(g.z());
                    list3.addHeaderView(inflate, i16, i18);
                    h0Var.a();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a() {
        View view;
        Object next;
        int i;
        boolean next2;
        if (b()) {
        }
        Iterator iterator = this.z.iterator();
        for (g next : iterator) {
            H(next);
        }
        this.z.clear();
        view = this.G;
        this.H = view;
        if (view != null) {
            i = this.Q == null ? 1 : 0;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.Q = viewTreeObserver;
            if (i != 0) {
                viewTreeObserver.addOnGlobalLayoutListener(this.B);
            }
            this.H.addOnAttachStateChangeListener(this.C);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean b() {
        int size;
        int i;
        if (this.A.size() > 0 && obj.a.b()) {
            if (obj.a.b()) {
                i = 1;
            }
        }
        return i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(androidx.appcompat.view.menu.g g, boolean z2) {
        int size2;
        int i2;
        boolean z;
        int i;
        int size;
        int i3;
        boolean obj6;
        Object obj7;
        int i4 = C(g);
        if (i4 < 0) {
        }
        i2 = i4 + 1;
        final int i6 = 0;
        if (i2 < this.A.size()) {
            obj.b.e(i6);
        }
        Object remove = this.A.remove(i4);
        remove.b.Q(this);
        int i5 = 0;
        if (this.S) {
            remove.a.S(i5);
            remove.a.E(i6);
        }
        remove.a.dismiss();
        size2 = this.A.size();
        if (size2 > 0) {
            this.I = obj2.c;
        } else {
            this.I = F();
        }
        if (size2 == 0) {
            dismiss();
            obj7 = this.P;
            if (obj7 != null) {
                obj7.c(g, true);
            }
            obj6 = this.Q;
            if (obj6 != null && obj6.isAlive()) {
                if (obj6.isAlive()) {
                    this.Q.removeGlobalOnLayoutListener(this.B);
                }
                this.Q = i5;
            }
            this.H.removeOnAttachStateChangeListener(this.C);
            this.R.onDismiss();
        } else {
            if (z2 != null) {
                obj6.b.e(i6);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void d(boolean z) {
        androidx.appcompat.view.menu.f fVar;
        Iterator obj2 = this.A.iterator();
        for (d.d next2 : obj2) {
            k.A(next2.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void dismiss() {
        int size;
        Object[] array;
        androidx.appcompat.view.menu.d.d[] arr;
        boolean z;
        size = this.A.size();
        if (size > 0) {
            size--;
            while (size >= 0) {
                arr = (d.d[])this.A.toArray(new d.d[size])[size];
                if (arr.a.b()) {
                }
                size--;
                arr.a.dismiss();
            }
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean e() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.k
    public void h(androidx.appcompat.view.menu.m.a m$a) {
        this.P = a;
    }

    @Override // androidx.appcompat.view.menu.k
    public void j(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.k
    public ListView k() {
        int i2;
        int i;
        if (this.A.isEmpty()) {
            i2 = 0;
        } else {
            List list2 = this.A;
            i2 = (d.d)list2.get(size--).a();
        }
        return i2;
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean l(androidx.appcompat.view.menu.r r) {
        Object next;
        int i;
        androidx.appcompat.view.menu.g gVar;
        Iterator iterator = this.A.iterator();
        i = 1;
        for (d.d next : iterator) {
            i = 1;
        }
        n(r);
        androidx.appcompat.view.menu.m.a aVar = this.P;
        if (r.hasVisibleItems() && aVar != null) {
            n(r);
            aVar = this.P;
            if (aVar != null) {
                aVar.d(r);
            }
            return i;
        }
        return 0;
    }

    @Override // androidx.appcompat.view.menu.k
    public Parcelable m() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.k
    public void n(androidx.appcompat.view.menu.g g) {
        boolean z;
        g.c(this, this.b);
        if (b()) {
            H(g);
        } else {
            this.z.add(g);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    protected boolean o() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.k
    public void onDismiss() {
        int size;
        int i;
        Object obj;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < this.A.size()) {
            i++;
        }
        obj = 0;
        if (obj != null) {
            obj.b.e(i2);
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
        View view2;
        View obj2;
        if (this.G != view) {
            this.G = view;
            this.F = e.b(this.E, u.B(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(boolean z) {
        this.N = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(int i) {
        int i2;
        int obj2;
        if (this.E != i) {
            this.E = i;
            this.F = e.b(i, u.B(this.G));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(int i) {
        this.J = true;
        this.L = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(PopupWindow.OnDismissListener popupWindow$OnDismissListener) {
        this.R = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void x(boolean z) {
        this.O = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void y(int i) {
        this.K = true;
        this.M = i;
    }
}
