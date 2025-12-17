package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ActionMenuItemView.b;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m.a;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.n.a;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.r;
import androidx.core.graphics.drawable.a;
import d.a.a;
import d.a.g;
import d.a.o.a;
import d.h.l.b;
import d.h.l.b.a;
import java.util.ArrayList;

/* loaded from: classes.dex */
class c extends b implements b.a {

    androidx.appcompat.widget.c.d B;
    private Drawable C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private int I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private int N;
    private final SparseBooleanArray O;
    androidx.appcompat.widget.c.e P;
    androidx.appcompat.widget.c.a Q;
    androidx.appcompat.widget.c.c R;
    private androidx.appcompat.widget.c.b S;
    final androidx.appcompat.widget.c.f T;
    int U;

    private class c implements Runnable {

        private androidx.appcompat.widget.c.e a;
        final androidx.appcompat.widget.c b;
        public c(androidx.appcompat.widget.c c, androidx.appcompat.widget.c.e c$e2) {
            this.b = c;
            super();
            this.a = e2;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar;
            n windowToken;
            androidx.appcompat.widget.c.e eVar;
            if (c.x(this.b) != null) {
                c.y(this.b).d();
            }
            windowToken = c.z(this.b);
            if (windowToken != null && (View)windowToken.getWindowToken() != null && this.a.m()) {
                if (windowToken.getWindowToken() != null) {
                    if (this.a.m()) {
                        windowToken.P = this.a;
                    }
                }
            }
            cVar4.R = 0;
        }
    }

    private static class g implements Parcelable {

        public static final Parcelable.Creator<androidx.appcompat.widget.c.g> CREATOR;
        public int a;
        static {
            c.g.a aVar = new c.g.a();
            c.g.CREATOR = aVar;
        }

        g(Parcel parcel) {
            super();
            this.a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
        }
    }

    private class a extends l {

        final androidx.appcompat.widget.c m;
        public a(androidx.appcompat.widget.c c, Context context2, r r3, View view4) {
            Object obj8;
            this.m = c;
            super(context2, r3, view4, 0, a.l);
            if (!(i)r3.getItem().l() && c.B == null) {
                if (c.B == null) {
                    obj8 = c.v(c);
                }
                f(obj8);
            }
            j(c.T);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            final androidx.appcompat.widget.c cVar = this.m;
            cVar.Q = 0;
            cVar.U = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {

        final androidx.appcompat.widget.c a;
        b(androidx.appcompat.widget.c c) {
            this.a = c;
            super();
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView$b
        public p a() {
            androidx.appcompat.view.menu.k kVar;
            androidx.appcompat.widget.c.a aVar = cVar.Q;
            if (aVar != null) {
                kVar = aVar.c();
            } else {
                kVar = 0;
            }
            return kVar;
        }
    }

    private class e extends l {

        final androidx.appcompat.widget.c m;
        public e(androidx.appcompat.widget.c c, Context context2, g g3, View view4, boolean z5) {
            this.m = c;
            super(context2, g3, view4, z5, a.l);
            h(8388613);
            j(c.T);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            g gVar;
            if (c.t(this.m) != null) {
                c.u(this.m).close();
            }
            cVar2.P = 0;
            super.e();
        }
    }

    private class f implements m.a {

        final androidx.appcompat.widget.c a;
        f(androidx.appcompat.widget.c c) {
            this.a = c;
            super();
        }

        @Override // androidx.appcompat.view.menu.m$a
        public void c(g g, boolean z2) {
            boolean gVar;
            int i;
            if (g instanceof r) {
                g.F().e(false);
            }
            m.a aVar = this.a.o();
            if (aVar != null) {
                aVar.c(g, z2);
            }
        }

        @Override // androidx.appcompat.view.menu.m$a
        public boolean d(g g) {
            int i;
            if (g == c.w(this.a)) {
                return 0;
            }
            cVar2.U = (r)g.getItem().getItemId();
            m.a aVar = this.a.o();
            if (aVar != null) {
                i = aVar.d(g);
            }
            return i;
        }
    }

    private class d extends androidx.appcompat.widget.AppCompatImageView implements androidx.appcompat.widget.ActionMenuView.a {

        final androidx.appcompat.widget.c a;
        public d(androidx.appcompat.widget.c c, Context context2) {
            this.a = c;
            super(context2, 0, a.k);
            int obj4 = 1;
            setClickable(obj4);
            setFocusable(obj4);
            setVisibility(0);
            setEnabled(obj4);
            v0.a(this, getContentDescription());
            obj4 = new c.d.a(this, this, c);
            setOnTouchListener(obj4);
        }

        @Override // androidx.appcompat.widget.AppCompatImageView
        public boolean e() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatImageView
        public boolean f() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatImageView
        public boolean performClick() {
            final int i2 = 1;
            if (super.performClick()) {
                return i2;
            }
            playSoundEffect(0);
            this.a.M();
            return i2;
        }

        @Override // androidx.appcompat.widget.AppCompatImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            int i7;
            int i5;
            int i6;
            int paddingBottom;
            Drawable obj6;
            int obj8;
            final Drawable obj7 = getBackground();
            if (getDrawable() != null && obj7 != null) {
                if (obj7 != null) {
                    obj6 = getWidth();
                    obj8 = getHeight();
                    i8 /= 2;
                    obj6 /= 2;
                    obj8 /= 2;
                    a.l(obj7, obj6 - i7, obj8 - i7, obj6 += i7, obj8 += i7);
                }
            }
            return super.setFrame(i, i2, i3, i4);
        }
    }
    public c(Context context) {
        super(context, g.c, g.b);
        SparseBooleanArray obj3 = new SparseBooleanArray();
        this.O = obj3;
        obj3 = new c.f(this);
        this.T = obj3;
    }

    private View B(MenuItem menuItem) {
        int i;
        View childAt;
        boolean itemData;
        final n nVar = this.z;
        final int i2 = 0;
        if ((ViewGroup)nVar == null) {
            return i2;
        }
        i = 0;
        while (i < (ViewGroup)nVar.getChildCount()) {
            childAt = nVar.getChildAt(i);
            i++;
        }
        return i2;
    }

    static g t(androidx.appcompat.widget.c c) {
        return c.c;
    }

    static g u(androidx.appcompat.widget.c c) {
        return c.c;
    }

    static n v(androidx.appcompat.widget.c c) {
        return c.z;
    }

    static g w(androidx.appcompat.widget.c c) {
        return c.c;
    }

    static g x(androidx.appcompat.widget.c c) {
        return c.c;
    }

    static g y(androidx.appcompat.widget.c c) {
        return c.c;
    }

    static n z(androidx.appcompat.widget.c c) {
        return c.z;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean A() {
        return z |= z2;
    }

    @Override // androidx.appcompat.view.menu.b
    public Drawable C() {
        androidx.appcompat.widget.c.d dVar = this.B;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.D) {
            return this.C;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean D() {
        n nVar;
        androidx.appcompat.widget.c.c cVar = this.R;
        final int i3 = 1;
        nVar = this.z;
        if (cVar != null && nVar != null) {
            nVar = this.z;
            if (nVar != null) {
                (View)nVar.removeCallbacks(cVar);
                this.R = 0;
                return i3;
            }
        }
        androidx.appcompat.widget.c.e eVar = this.P;
        if (eVar != null) {
            eVar.b();
            return i3;
        }
        return 0;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean E() {
        androidx.appcompat.widget.c.a aVar = this.Q;
        if (aVar != null) {
            aVar.b();
            return 1;
        }
        return 0;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean F() {
        int i;
        androidx.appcompat.widget.c.c cVar;
        if (this.R == null) {
            if (G()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean G() {
        androidx.appcompat.widget.c.e eVar;
        int i;
        eVar = this.P;
        if (eVar != null && eVar.d()) {
            i = eVar.d() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.view.menu.b
    public void H(Configuration configuration) {
        int i;
        boolean obj2;
        if (!this.J) {
            this.I = a.b(this.b).d();
        }
        obj2 = this.c;
        if (obj2 != null) {
            obj2.M(true);
        }
    }

    @Override // androidx.appcompat.view.menu.b
    public void I(boolean z) {
        this.M = z;
    }

    @Override // androidx.appcompat.view.menu.b
    public void J(androidx.appcompat.widget.ActionMenuView actionMenuView) {
        this.z = actionMenuView;
        actionMenuView.b(this.c);
    }

    @Override // androidx.appcompat.view.menu.b
    public void K(Drawable drawable) {
        androidx.appcompat.widget.c.d dVar;
        dVar = this.B;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.D = true;
            this.C = drawable;
        }
    }

    @Override // androidx.appcompat.view.menu.b
    public void L(boolean z) {
        this.E = z;
        this.F = true;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean M() {
        boolean empty;
        Object obj;
        empty = this.c;
        if (this.E && !G() && empty != null && this.z != null && this.R == null && !empty.B().isEmpty()) {
            if (!G()) {
                empty = this.c;
                if (empty != null) {
                    if (this.z != null) {
                        if (this.R == null) {
                            if (!empty.B().isEmpty()) {
                                super(this, this.b, this.c, this.B, 1);
                                c.c cVar = new c.c(this, eVar);
                                this.R = cVar;
                                (View)this.z.post(cVar);
                                return 1;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override // androidx.appcompat.view.menu.b
    public void b(i i, n.a n$a2) {
        androidx.appcompat.widget.c.b obj2;
        a2.h(i, 0);
        (ActionMenuItemView)a2.setItemInvoker((ActionMenuView)this.z);
        if (this.S == null) {
            obj2 = new c.b(this);
            this.S = obj2;
        }
        a2.setPopupCallback(this.S);
    }

    @Override // androidx.appcompat.view.menu.b
    public void c(g g, boolean z2) {
        A();
        super.c(g, z2);
    }

    @Override // androidx.appcompat.view.menu.b
    public void d(boolean z) {
        int i2;
        int size;
        boolean size2;
        int i;
        b bVar;
        Object obj5;
        super.d(z);
        (View)this.z.requestLayout();
        obj5 = this.c;
        i2 = 0;
        if (obj5 != null) {
            obj5 = obj5.u();
            i = i2;
            while (i < obj5.size()) {
                bVar = (i)obj5.get(i).b();
                if (bVar != null) {
                }
                i++;
                bVar.i(this);
            }
        }
        obj5 = this.c;
        if (obj5 != null) {
            obj5 = obj5.B();
        } else {
            obj5 = 0;
        }
        if (this.E && obj5 != null) {
            if (obj5 != null) {
                size2 = obj5.size();
                i = 1;
                if (size2 == i) {
                    i2 = obj5 ^ 1;
                } else {
                    if (size2 > 0) {
                        i2 = i;
                    }
                }
            }
        }
        if (i2 != 0) {
            if (this.B == null) {
                obj5 = new c.d(this, this.a);
                this.B = obj5;
            }
            obj5 = this.B.getParent();
            if ((ViewGroup)obj5 != this.z && (ViewGroup)obj5 != null) {
                if ((ViewGroup)obj5 != null) {
                    (ViewGroup)obj5.removeView(this.B);
                }
                obj5 = this.z;
                obj5.addView(this.B, (ActionMenuView)obj5.i());
            }
        } else {
            obj5 = this.B;
            i2 = this.z;
            if (obj5 != null && obj5.getParent() == i2) {
                i2 = this.z;
                if (obj5.getParent() == i2) {
                    (ViewGroup)i2.removeView(this.B);
                }
            }
        }
        (ActionMenuView)this.z.setOverflowReserved(this.E);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean e() {
        Object obj;
        int i7;
        int groupId;
        int i8;
        int i2;
        int groupId2;
        int z5;
        int i6;
        boolean z2;
        int size;
        int z;
        int i11;
        int i18;
        int i12;
        int i13;
        int i14;
        int i10;
        int i9;
        int i;
        int i4;
        int i5;
        boolean actionViewExpanded;
        Object obj2;
        int i15;
        boolean z4;
        boolean z3;
        int i3;
        int i16;
        int i17;
        obj = this;
        g gVar = obj.c;
        i6 = 0;
        if (gVar != null) {
            size = gVar.G().size();
        } else {
            i8 = i2;
            size = i6;
        }
        i11 = obj.I;
        i12 = obj.H;
        final int measureSpec = View.MeasureSpec.makeMeasureSpec(i6, i6);
        final n nVar = obj.z;
        i4 = i9;
        while (i13 < size) {
            obj2 = i8.get(i13);
            if ((i)obj2.o()) {
            } else {
            }
            if (obj2.n()) {
            } else {
            }
            i14 = 1;
            if (obj.M && obj2.isActionViewExpanded()) {
            }
            i13++;
            if (obj2.isActionViewExpanded()) {
            }
            i11 = i6;
            i4++;
            i9++;
        }
        if (obj.E) {
            if (i14 == 0) {
                if (i4 += i9 > i11) {
                    i11--;
                }
            } else {
            }
        }
        i11 -= i9;
        SparseBooleanArray sparseBooleanArray = obj.O;
        sparseBooleanArray.clear();
        if (obj.K) {
            int i23 = obj.N;
            i23 += i4;
        } else {
            i = i10;
        }
        i15 = i5;
        while (i5 < size) {
            z4 = i8.get(i5);
            if ((i)z4.o()) {
            } else {
            }
            if (z4.n()) {
            } else {
            }
            i3 = size;
            z4.u(i6);
            i5++;
            i6 = i7;
            size = i3;
            i2 = 0;
            obj = this;
            groupId2 = z4.getGroupId();
            actionViewExpanded = sparseBooleanArray.get(groupId2);
            if (i18 <= 0) {
            } else {
            }
            if (i12 > 0) {
            } else {
            }
            i6 = 0;
            i16 = i6;
            i3 = size;
            if (i6 != 0) {
            }
            if (i6 != 0 && groupId2 != 0) {
            } else {
            }
            if (actionViewExpanded) {
            }
            if (i6 != 0) {
            }
            z4.u(i6);
            i7 = 0;
            i18--;
            sparseBooleanArray.put(groupId2, false);
            size = 0;
            while (size < i5) {
                actionViewExpanded = i8.get(size);
                if ((i)actionViewExpanded.getGroupId() == groupId2 && actionViewExpanded.l()) {
                }
                size++;
                obj = this;
                if (actionViewExpanded.l()) {
                }
                actionViewExpanded.u(false);
                i18++;
            }
            actionViewExpanded = i8.get(size);
            if ((i)actionViewExpanded.getGroupId() == groupId2 && actionViewExpanded.l()) {
            }
            size++;
            obj = this;
            if (actionViewExpanded.l()) {
            }
            actionViewExpanded.u(false);
            i18++;
            if (groupId2 != 0) {
            } else {
            }
            sparseBooleanArray.put(groupId2, true);
            View view = obj.p(z4, 0, (ViewGroup)nVar);
            if (obj.K) {
            } else {
            }
            view.measure(measureSpec, measureSpec);
            int measuredWidth2 = view.getMeasuredWidth();
            i12 -= measuredWidth2;
            if (i15 == 0) {
            }
            if (obj.K) {
            } else {
            }
            if (i12 + i15 > 0) {
            } else {
            }
            size = 0;
            i21 &= size;
            size = 1;
            if (i12 >= 0) {
            } else {
            }
            i15 = measuredWidth2;
            i17 = ActionMenuView.o(view, i10, i, measureSpec, 0);
            i -= i17;
            if (i17 == 0) {
            }
            i16 = 0;
            if (obj.K) {
            } else {
            }
            i6 = 1;
            if (i > 0) {
            } else {
            }
            if (actionViewExpanded && i12 > 0) {
            } else {
            }
            View view2 = obj.p(z4, i2, nVar);
            if (obj.K) {
            } else {
            }
            view2.measure(measureSpec, measureSpec);
            int measuredWidth = view2.getMeasuredWidth();
            i12 -= measuredWidth;
            if (i15 == 0) {
            }
            groupId2 = z4.getGroupId();
            actionViewExpanded = 1;
            if (groupId2 != 0) {
            }
            z4.u(actionViewExpanded);
            i7 = i6;
            i3 = size;
            sparseBooleanArray.put(groupId2, actionViewExpanded);
            i15 = measuredWidth;
            i -= z5;
        }
        return 1;
    }

    @Override // androidx.appcompat.view.menu.b
    public void i(Context context, g g2) {
        boolean z;
        boolean z3;
        androidx.appcompat.widget.c.d measureSpec;
        int measuredWidth;
        int i;
        boolean z2;
        int i2;
        a obj5;
        super.i(context, g2);
        obj5 = a.b(context);
        if (!this.F) {
            this.E = obj5.h();
        }
        if (!this.L) {
            this.G = obj5.c();
        }
        if (!this.J) {
            this.I = obj5.d();
        }
        i = 0;
        if (this.E) {
            c.d dVar2 = new c.d(this, this.a);
            this.B = dVar2;
            i2 = 0;
            if (this.B == null && this.D) {
                dVar2 = new c.d(this, this.a);
                this.B = dVar2;
                i2 = 0;
                if (this.D) {
                    dVar2.setImageDrawable(this.C);
                    this.C = i;
                    this.D = i2;
                }
                measureSpec = View.MeasureSpec.makeMeasureSpec(i2, i2);
                this.B.measure(measureSpec, measureSpec);
            }
            obj5 -= measuredWidth;
        } else {
            this.B = i;
        }
        this.H = obj5;
        this.N = (int)obj6;
    }

    @Override // androidx.appcompat.view.menu.b
    public void j(Parcelable parcelable) {
        boolean gVar;
        int obj2;
        if (!parcelable instanceof c.g) {
        }
        obj2 = parcelable.a;
        obj2 = this.c.findItem(obj2);
        if (obj2 > 0 && obj2 != null) {
            obj2 = this.c.findItem(obj2);
            if (obj2 != null) {
                l((r)obj2.getSubMenu());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean l(r r) {
        android.view.Menu rVar;
        int i2;
        android.view.Menu menu;
        g gVar;
        int i;
        int i3;
        MenuItem item;
        boolean visible;
        i2 = 0;
        if (!r.hasVisibleItems()) {
            return i2;
        }
        rVar = r;
        while (rVar.i0() != this.c) {
            rVar = rVar.i0();
        }
        View view = B(rVar.getItem());
        if (view == null) {
            return i2;
        }
        this.U = r.getItem().getItemId();
        i = i2;
        i3 = 1;
        while (i < r.size()) {
            item = r.getItem(i);
            if (item.isVisible()) {
                break;
            } else {
            }
            i++;
            i3 = 1;
            if (item.getIcon() != null) {
                break;
            } else {
            }
        }
        c.a aVar2 = new c.a(this, this.b, r, view);
        this.Q = aVar2;
        aVar2.g(i2);
        this.Q.k();
        super.l(r);
        return i3;
    }

    @Override // androidx.appcompat.view.menu.b
    public Parcelable m() {
        c.g gVar = new c.g();
        gVar.a = this.U;
        return gVar;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean n(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.B) {
            return 0;
        }
        return super.n(viewGroup, i2);
    }

    @Override // androidx.appcompat.view.menu.b
    public View p(i i, View view2, ViewGroup viewGroup3) {
        View actionView;
        boolean z;
        int obj3;
        if (i.getActionView() != null) {
            if (i.j()) {
                actionView = super.p(i, view2, viewGroup3);
            }
        } else {
        }
        obj3 = i.isActionViewExpanded() ? 8 : 0;
        actionView.setVisibility(obj3);
        obj3 = actionView.getLayoutParams();
        if (!(ActionMenuView)viewGroup3.checkLayoutParams(obj3)) {
            actionView.setLayoutParams(viewGroup3.f(obj3));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public n q(ViewGroup viewGroup) {
        n nVar;
        final n obj2 = super.q(viewGroup);
        if (this.z != obj2) {
            (ActionMenuView)obj2.setPresenter(this);
        }
        return obj2;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean s(int i, i i2) {
        return i2.l();
    }
}
