package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.m.a;
import androidx.appcompat.view.menu.r;
import d.a.a;
import d.a.j;
import d.a.k.a.a;
import d.a.o.c;
import d.a.o.g;
import d.h.l.e;
import d.h.l.h;
import d.h.l.u;
import d.j.a.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    View A;
    private Context B;
    private int C;
    private int D;
    private int E;
    int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private androidx.appcompat.widget.l0 L;
    private int M;
    private int N;
    private int O;
    private java.lang.CharSequence P;
    private java.lang.CharSequence Q;
    private ColorStateList R;
    private ColorStateList S;
    private boolean T;
    private boolean U;
    private final ArrayList<View> V;
    private final ArrayList<View> W;
    private androidx.appcompat.widget.ActionMenuView a;
    private final int[] a0;
    private TextView b;
    androidx.appcompat.widget.Toolbar.f b0;
    private TextView c;
    private final androidx.appcompat.widget.ActionMenuView.e c0;
    private androidx.appcompat.widget.u0 d0;
    private androidx.appcompat.widget.c e0;
    private androidx.appcompat.widget.Toolbar.d f0;
    private m.a g0;
    private g.a h0;
    private boolean i0;
    private final Runnable j0;
    private ImageButton v;
    private ImageView w;
    private Drawable x;
    private java.lang.CharSequence y;
    ImageButton z;

    class b implements Runnable {

        final androidx.appcompat.widget.Toolbar a;
        b(androidx.appcompat.widget.Toolbar toolbar) {
            this.a = toolbar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.O();
        }
    }

    class c implements View.OnClickListener {

        final androidx.appcompat.widget.Toolbar a;
        c(androidx.appcompat.widget.Toolbar toolbar) {
            this.a = toolbar;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            this.a.e();
        }
    }

    public interface f {
        public abstract boolean onMenuItemClick(MenuItem menuItem);
    }

    class a implements androidx.appcompat.widget.ActionMenuView.e {

        final androidx.appcompat.widget.Toolbar a;
        a(androidx.appcompat.widget.Toolbar toolbar) {
            this.a = toolbar;
            super();
        }

        @Override // androidx.appcompat.widget.ActionMenuView$e
        public boolean onMenuItemClick(MenuItem menuItem) {
            androidx.appcompat.widget.Toolbar.f fVar = toolbar.b0;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return 0;
        }
    }

    private class d implements m {

        g a;
        i b;
        final androidx.appcompat.widget.Toolbar c;
        d(androidx.appcompat.widget.Toolbar toolbar) {
            this.c = toolbar;
            super();
        }

        @Override // androidx.appcompat.view.menu.m
        public void c(g g, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.m
        public void d(boolean z) {
            int i2;
            int i;
            MenuItem item;
            i iVar;
            Object obj5;
            obj5 = this.a;
            if (this.b != null && obj5 != null) {
                obj5 = this.a;
                if (obj5 != null) {
                    i = i2;
                    while (i < obj5.size()) {
                        if (this.a.getItem(i) == this.b) {
                            break;
                        } else {
                        }
                        i++;
                    }
                }
                if (i2 == 0) {
                    f(this.a, this.b);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean e() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean f(g g, i i2) {
            View obj2 = obj2.A;
            if (obj2 instanceof c) {
                (c)obj2.onActionViewCollapsed();
            }
            obj2 = this.c;
            obj2.removeView(obj2.A);
            obj2 = this.c;
            obj2.removeView(obj2.z);
            obj2 = this.c;
            int i = 0;
            obj2.A = i;
            obj2.a();
            this.b = i;
            this.c.requestLayout();
            i2.r(false);
            return 1;
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean g(g g, i i2) {
            Object toolbar;
            Object toolbar2;
            boolean z;
            int i;
            Object obj4;
            this.c.g();
            obj4 = obj4.z.getParent();
            toolbar = this.c;
            if (obj4 != toolbar && obj4 instanceof ViewGroup) {
                if (obj4 instanceof ViewGroup) {
                    (ViewGroup)obj4.removeView(toolbar.z);
                }
                obj4 = this.c;
                obj4.addView(obj4.z);
            }
            obj4.A = i2.getActionView();
            this.b = i2;
            obj4 = obj4.A.getParent();
            toolbar2 = this.c;
            if (obj4 != toolbar2 && obj4 instanceof ViewGroup) {
                if (obj4 instanceof ViewGroup) {
                    (ViewGroup)obj4.removeView(toolbar2.A);
                }
                obj4 = this.c.m();
                z = this.c;
                obj4.a = i3 |= i;
                obj4.b = 2;
                z.A.setLayoutParams(obj4);
                obj4 = this.c;
                obj4.addView(obj4.A);
            }
            this.c.G();
            this.c.requestLayout();
            obj4 = 1;
            i2.r(obj4);
            View obj5 = obj5.A;
            if (obj5 instanceof c) {
                (c)obj5.onActionViewExpanded();
            }
            return obj4;
        }

        @Override // androidx.appcompat.view.menu.m
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.m
        public void i(Context context, g g2) {
            i iVar;
            final g obj2 = this.a;
            iVar = this.b;
            if (obj2 != null && iVar != null) {
                iVar = this.b;
                if (iVar != null) {
                    obj2.f(iVar);
                }
            }
            this.a = g2;
        }

        @Override // androidx.appcompat.view.menu.m
        public void j(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.m
        public boolean l(r r) {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.m
        public Parcelable m() {
            return null;
        }
    }

    public static class e extends a.a {

        int b = 0;
        public e(int i, int i2) {
            super(i, i2);
            int obj1 = 0;
            this.a = 8388627;
        }

        public e(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            final int obj1 = 0;
        }

        public e(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
            final int obj1 = 0;
        }

        public e(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams) {
            super(marginLayoutParams);
            final int i = 0;
            a(marginLayoutParams);
        }

        public e(a.a a$a) {
            super(a);
            final int obj1 = 0;
        }

        public e(androidx.appcompat.widget.Toolbar.e toolbar$e) {
            super(e);
            final int i = 0;
            this.b = e.b;
        }

        @Override // androidx.appcompat.app.a$a
        void a(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class g extends a {

        public static final Parcelable.Creator<androidx.appcompat.widget.Toolbar.g> CREATOR;
        int c;
        boolean v;
        static {
            Toolbar.g.a aVar = new Toolbar.g.a();
            Toolbar.g.CREATOR = aVar;
        }

        public g(Parcel parcel, java.lang.ClassLoader classLoader2) {
            int obj1;
            super(parcel, classLoader2);
            this.c = parcel.readInt();
            obj1 = parcel.readInt() != 0 ? 1 : 0;
            this.v = obj1;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
            parcel.writeInt(this.v);
        }
    }
    public Toolbar(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.P);
    }

    public Toolbar(Context context, AttributeSet attributeSet2, int i3) {
        androidx.appcompat.widget.l0 i;
        int obj10;
        super(context, attributeSet2, i3);
        this.O = 8388627;
        ArrayList arrayList = new ArrayList();
        this.V = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.W = arrayList2;
        this.a0 = new int[2];
        Toolbar.a aVar = new Toolbar.a(this);
        this.c0 = aVar;
        Toolbar.b bVar = new Toolbar.b(this);
        this.j0 = bVar;
        int[] w2 = j.W2;
        final int i10 = 0;
        androidx.appcompat.widget.t0 t0Var = t0.v(getContext(), attributeSet2, w2, i3, i10);
        u.j0(this, context, w2, attributeSet2, t0Var.r(), i3, 0);
        this.D = t0Var.n(j.y3, i10);
        this.E = t0Var.n(j.p3, i10);
        this.O = t0Var.l(j.X2, this.O);
        this.F = t0Var.l(j.Y2, 48);
        int obj11 = j.x3;
        if (t0Var.s(obj11)) {
            obj10 = t0Var.e(obj11, t0Var.e(j.s3, i10));
        }
        this.K = obj10;
        this.J = obj10;
        this.I = obj10;
        this.H = obj10;
        obj11 = -1;
        obj10 = t0Var.e(j.v3, obj11);
        if (obj10 >= 0) {
            this.H = obj10;
        }
        obj10 = t0Var.e(j.u3, obj11);
        if (obj10 >= 0) {
            this.I = obj10;
        }
        obj10 = t0Var.e(j.w3, obj11);
        if (obj10 >= 0) {
            this.J = obj10;
        }
        obj10 = t0Var.e(j.t3, obj11);
        if (obj10 >= 0) {
            this.K = obj10;
        }
        this.G = t0Var.f(j.j3, obj11);
        obj11 = Integer.MIN_VALUE;
        obj10 = t0Var.e(j.f3, obj11);
        int obj12 = t0Var.e(j.b3, obj11);
        h();
        this.L.e(t0Var.f(j.d3, i10), t0Var.f(j.e3, i10));
        if (obj10 == obj11) {
            if (obj12 != obj11) {
                this.L.g(obj10, obj12);
            }
        } else {
        }
        this.M = t0Var.e(j.g3, obj11);
        this.N = t0Var.e(j.c3, obj11);
        this.x = t0Var.g(j.a3);
        this.y = t0Var.p(j.Z2);
        obj10 = t0Var.p(j.r3);
        if (!TextUtils.isEmpty(obj10)) {
            setTitle(obj10);
        }
        obj10 = t0Var.p(j.o3);
        if (!TextUtils.isEmpty(obj10)) {
            setSubtitle(obj10);
        }
        this.B = getContext();
        setPopupTheme(t0Var.n(j.n3, i10));
        obj10 = t0Var.g(j.m3);
        if (obj10 != null) {
            setNavigationIcon(obj10);
        }
        obj10 = t0Var.p(j.l3);
        if (!TextUtils.isEmpty(obj10)) {
            setNavigationContentDescription(obj10);
        }
        obj10 = t0Var.g(j.h3);
        if (obj10 != null) {
            setLogo(obj10);
        }
        obj10 = t0Var.p(j.i3);
        if (!TextUtils.isEmpty(obj10)) {
            setLogoDescription(obj10);
        }
        obj10 = j.z3;
        if (t0Var.s(obj10)) {
            setTitleTextColor(t0Var.c(obj10));
        }
        obj10 = j.q3;
        if (t0Var.s(obj10)) {
            setSubtitleTextColor(t0Var.c(obj10));
        }
        obj10 = j.k3;
        if (t0Var.s(obj10)) {
            x(t0Var.n(obj10, i10));
        }
        t0Var.w();
    }

    private int B(View view, int i2, int[] i3Arr3, int i4) {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i7 = 0;
        leftMargin -= i9;
        i2 += i10;
        i3Arr3[i7] = Math.max(i7, -i);
        final int obj7 = q(view, i4);
        int obj8 = view.getMeasuredWidth();
        view.layout(obj6, obj7, obj6 + obj8, measuredHeight += obj7);
        return obj6 += obj8;
    }

    private int C(View view, int i2, int[] i3Arr3, int i4) {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i7 = 1;
        rightMargin -= i9;
        int i10 = 0;
        i2 -= i11;
        i3Arr3[i7] = Math.max(i10, -i);
        final int obj8 = q(view, i4);
        int obj9 = view.getMeasuredWidth();
        view.layout(obj7 - obj9, obj8, obj7, measuredHeight += obj8);
        return obj7 -= obj9;
    }

    private int D(View view, int i2, int i3, int i4, int i5, int[] i6Arr6) {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        final int i10 = 0;
        leftMargin -= i11;
        final int i13 = 1;
        rightMargin -= i14;
        i15 += i17;
        i6Arr6[i10] = Math.max(i10, -i);
        i6Arr6[i13] = Math.max(i10, -i12);
        view.measure(ViewGroup.getChildMeasureSpec(i2, obj13 += i3, layoutParams.width), ViewGroup.getChildMeasureSpec(i4, obj10 += i5, layoutParams.height));
        return obj8 += i16;
    }

    private void E(View view, int i2, int i3, int i4, int i5, int i6) {
        int obj6;
        int obj9;
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        obj6 = ViewGroup.getChildMeasureSpec(i4, obj6 += i5, layoutParams.height);
        final int obj7 = View.MeasureSpec.getMode(obj6);
        int obj8 = 1073741824;
        if (obj7 != obj8 && i6 >= 0 && obj7 != null) {
            if (i6 >= 0) {
                if (obj7 != null) {
                    obj9 = Math.min(View.MeasureSpec.getSize(obj6), i6);
                }
                obj6 = View.MeasureSpec.makeMeasureSpec(obj9, obj8);
            }
        }
        view.measure(ViewGroup.getChildMeasureSpec(i2, i8 += i3, layoutParams.width), obj6);
    }

    private void F() {
        removeCallbacks(this.j0);
        post(this.j0);
    }

    private boolean M() {
        int i;
        View measuredHeight;
        boolean measuredWidth;
        final int i3 = 0;
        if (!this.i0) {
            return i3;
        }
        i = i3;
        while (i < getChildCount()) {
            measuredHeight = getChildAt(i);
            i++;
        }
        return 1;
    }

    private boolean N(View view) {
        int parent;
        int obj2;
        if (view != null && view.getParent() == this && view.getVisibility() != 8) {
            if (view.getParent() == this) {
                obj2 = view.getVisibility() != 8 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    private void b(List<View> list, int i2) {
        int childAt;
        int layoutParams2;
        int layoutParams;
        int childCount;
        int i;
        layoutParams = 1;
        childAt = u.B(this) == layoutParams ? layoutParams : layoutParams2;
        childCount = getChildCount();
        final int obj7 = e.b(i2, u.B(this));
        list.clear();
        if (childAt != 0) {
            childCount -= layoutParams;
            while (childCount >= 0) {
                childAt = getChildAt(childCount);
                layoutParams2 = childAt.getLayoutParams();
                if (layoutParams2.b == 0 && N(childAt) && p(layoutParams2.a) == obj7) {
                }
                childCount--;
                if (N(childAt)) {
                }
                if (p(layoutParams2.a) == obj7) {
                }
                list.add(childAt);
            }
        }
    }

    private void c(View view, boolean z2) {
        Object layoutParams;
        boolean checkLayoutParams;
        Object obj4;
        layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = m();
        } else {
            if (!checkLayoutParams(layoutParams)) {
                layoutParams = o(layoutParams);
            } else {
            }
        }
        layoutParams.b = 1;
        if (z2 != null && this.A != null) {
            if (this.A != null) {
                view.setLayoutParams(layoutParams);
                this.W.add(view);
            } else {
                addView(view, layoutParams);
            }
        } else {
        }
    }

    private MenuInflater getMenuInflater() {
        g gVar = new g(getContext());
        return gVar;
    }

    private void h() {
        androidx.appcompat.widget.l0 l0Var;
        if (this.L == null) {
            l0Var = new l0();
            this.L = l0Var;
        }
    }

    private void i() {
        ImageView appCompatImageView;
        Context context;
        if (this.w == null) {
            appCompatImageView = new AppCompatImageView(getContext());
            this.w = appCompatImageView;
        }
    }

    private void j() {
        Menu menu;
        androidx.appcompat.widget.Toolbar.d dVar2;
        androidx.appcompat.widget.Toolbar.d dVar;
        Context context;
        k();
        if (this.a.q() == null && this.f0 == null) {
            if (this.f0 == null) {
                dVar2 = new Toolbar.d(this);
                this.f0 = dVar2;
            }
            this.a.setExpandedActionViewsExclusive(true);
            (g)this.a.getMenu().c(this.f0, this.B);
        }
    }

    private void k() {
        androidx.appcompat.widget.ActionMenuView view;
        int i2;
        int i;
        if (this.a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.a = actionMenuView;
            actionMenuView.setPopupTheme(this.C);
            this.a.setOnMenuItemClickListener(this.c0);
            this.a.r(this.g0, this.h0);
            androidx.appcompat.widget.Toolbar.e eVar = m();
            eVar.a = i4 |= i;
            this.a.setLayoutParams(eVar);
            c(this.a, false);
        }
    }

    private void l() {
        Object imageButton;
        ImageButton imageButton2;
        int i;
        int i2;
        if (this.v == null) {
            k kVar = new k(getContext(), 0, a.O);
            this.v = kVar;
            imageButton = m();
            imageButton.a = i3 |= i;
            this.v.setLayoutParams(imageButton);
        }
    }

    private int p(int i) {
        int i2;
        int i3;
        final int i4 = u.B(this);
        obj5 &= 7;
        final int i5 = 1;
        i3 = 5;
        if (obj5 != i5 && obj5 != 3 && obj5 != i3 && i4 == i5) {
            if (obj5 != 3) {
                i3 = 5;
                if (obj5 != i3) {
                    if (i4 == i5) {
                        i2 = i3;
                    }
                    return i2;
                }
            }
        }
        return obj5;
    }

    private int q(View view, int i2) {
        int height;
        int i;
        int obj7;
        int obj8;
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        obj7 = view.getMeasuredHeight();
        int i3 = 0;
        obj8 = i2 > 0 ? obj8 / 2 : i3;
        int i9 = r(layoutParams.a);
        if (i9 != 48 && i9 != 80) {
            if (i9 != 80) {
                obj8 = getPaddingTop();
                int paddingBottom2 = getPaddingBottom();
                height = getHeight();
                i17 /= 2;
                final int topMargin = layoutParams.topMargin;
                if (i < topMargin) {
                    i = topMargin;
                } else {
                    i14 -= obj8;
                    obj7 = layoutParams.bottomMargin;
                    if (height < obj7) {
                        i = Math.max(i3, i -= obj7);
                    }
                }
                return obj8 += i;
            }
            return i6 -= obj8;
        }
        return obj7 -= obj8;
    }

    private int r(int i) {
        int i2;
        int obj2;
        i &= 112;
        if (obj2 != 16 && obj2 != 48 && obj2 != 80) {
            if (obj2 != 48) {
                if (obj2 != 80) {
                    obj2 &= 112;
                }
            }
        }
        return obj2;
    }

    private int s(View view) {
        ViewGroup.LayoutParams obj2 = view.getLayoutParams();
        return i += obj2;
    }

    private int t(View view) {
        ViewGroup.LayoutParams obj2 = view.getLayoutParams();
        return topMargin += obj2;
    }

    private int u(List<View> list, int[] i2Arr2) {
        int i2;
        int i3;
        int i;
        int measuredWidth;
        int i4;
        int i5;
        int obj10;
        final int i6 = 0;
        i2 = i2Arr2[i6];
        obj10 = i2Arr2[1];
        i = i3;
        while (i3 < list.size()) {
            Object obj = list.get(i3);
            ViewGroup.LayoutParams layoutParams = (View)obj.getLayoutParams();
            leftMargin -= i2;
            rightMargin -= obj10;
            i += obj10;
            i3++;
            obj10 = i9;
            i2 = i5;
        }
        return i;
    }

    private boolean y(View view) {
        Object parent;
        int obj2;
        if (view.getParent() != this) {
            if (this.W.contains(view)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.view.ViewGroup
    public boolean A() {
        androidx.appcompat.widget.ActionMenuView view;
        int i;
        view = this.a;
        if (view != null && view.m()) {
            i = view.m() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    void G() {
        int i3;
        View childAt;
        int i;
        int i2;
        childCount--;
        while (i3 >= 0) {
            childAt = getChildAt(i3);
            if (layoutParams.b != 2 && childAt != this.a) {
            }
            i3--;
            if (childAt != this.a) {
            }
            removeViewAt(i3);
            this.W.add(childAt);
        }
    }

    @Override // android.view.ViewGroup
    public void H(int i, int i2) {
        h();
        this.L.g(i, i2);
    }

    @Override // android.view.ViewGroup
    public void I(g g, androidx.appcompat.widget.c c2) {
        androidx.appcompat.widget.ActionMenuView view;
        androidx.appcompat.widget.Toolbar.d dVar2;
        int i;
        androidx.appcompat.widget.Toolbar.d dVar;
        int i2;
        Context context;
        Object obj4;
        if (g == null && this.a == null) {
            if (this.a == null) {
            }
        }
        k();
        g gVar = this.a.q();
        if (gVar == g) {
        }
        if (gVar != null) {
            gVar.Q(this.e0);
            gVar.Q(this.f0);
        }
        if (this.f0 == null) {
            dVar2 = new Toolbar.d(this);
            this.f0 = dVar2;
        }
        i = 1;
        c2.I(i);
        if (g != null) {
            g.c(c2, this.B);
            g.c(this.f0, this.B);
        } else {
            i2 = 0;
            c2.i(this.B, i2);
            this.f0.i(this.B, i2);
            c2.d(i);
            this.f0.d(i);
        }
        this.a.setPopupTheme(this.C);
        this.a.setPresenter(c2);
        this.e0 = c2;
    }

    @Override // android.view.ViewGroup
    public void J(m.a m$a, g.a g$a2) {
        this.g0 = a;
        this.h0 = a2;
        final androidx.appcompat.widget.ActionMenuView view = this.a;
        if (view != null) {
            view.r(a, a2);
        }
    }

    @Override // android.view.ViewGroup
    public void K(Context context, int i2) {
        this.E = i2;
        final TextView view = this.c;
        if (view != null) {
            view.setTextAppearance(context, i2);
        }
    }

    @Override // android.view.ViewGroup
    public void L(Context context, int i2) {
        this.D = i2;
        final TextView view = this.b;
        if (view != null) {
            view.setTextAppearance(context, i2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean O() {
        androidx.appcompat.widget.ActionMenuView view;
        int i;
        view = this.a;
        if (view != null && view.s()) {
            i = view.s() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    void a() {
        int i;
        Object obj;
        size--;
        while (i >= 0) {
            addView((View)this.W.get(i));
            i--;
        }
        this.W.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        ViewGroup.LayoutParams obj2;
        if (super.checkLayoutParams(layoutParams) && layoutParams instanceof Toolbar.e) {
            obj2 = layoutParams instanceof Toolbar.e ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // android.view.ViewGroup
    public boolean d() {
        int i;
        int visibility;
        visibility = this.a;
        if (getVisibility() == 0 && visibility != null && visibility.n()) {
            visibility = this.a;
            if (visibility != null) {
                i = visibility.n() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public void e() {
        int i;
        androidx.appcompat.widget.Toolbar.d dVar = this.f0;
        i = dVar == null ? 0 : dVar.b;
        if (i != 0) {
            i.collapseActionView();
        }
    }

    @Override // android.view.ViewGroup
    public void f() {
        final androidx.appcompat.widget.ActionMenuView view = this.a;
        if (view != null) {
            view.c();
        }
    }

    @Override // android.view.ViewGroup
    void g() {
        ImageButton imageButton;
        androidx.appcompat.widget.Toolbar.c cVar;
        int i2;
        int i;
        if (this.z == null) {
            k kVar = new k(getContext(), 0, a.O);
            this.z = kVar;
            kVar.setImageDrawable(this.x);
            this.z.setContentDescription(this.y);
            androidx.appcompat.widget.Toolbar.e eVar = m();
            eVar.a = i3 |= i2;
            eVar.b = 2;
            this.z.setLayoutParams(eVar);
            cVar = new Toolbar.c(this);
            this.z.setOnClickListener(cVar);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return n(attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return o(layoutParams);
    }

    @Override // android.view.ViewGroup
    public java.lang.CharSequence getCollapseContentDescription() {
        java.lang.CharSequence contentDescription;
        ImageButton imageButton = this.z;
        if (imageButton != null) {
            contentDescription = imageButton.getContentDescription();
        } else {
            contentDescription = 0;
        }
        return contentDescription;
    }

    @Override // android.view.ViewGroup
    public Drawable getCollapseIcon() {
        Drawable drawable;
        ImageButton imageButton = this.z;
        if (imageButton != null) {
            drawable = imageButton.getDrawable();
        } else {
            drawable = 0;
        }
        return drawable;
    }

    @Override // android.view.ViewGroup
    public int getContentInsetEnd() {
        int i;
        androidx.appcompat.widget.l0 l0Var = this.L;
        if (l0Var != null) {
            i = l0Var.a();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int getContentInsetEndWithActions() {
        int contentInsetEnd;
        if (this.N != Integer.MIN_VALUE) {
        } else {
            contentInsetEnd = getContentInsetEnd();
        }
        return contentInsetEnd;
    }

    @Override // android.view.ViewGroup
    public int getContentInsetLeft() {
        int i;
        androidx.appcompat.widget.l0 l0Var = this.L;
        if (l0Var != null) {
            i = l0Var.b();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int getContentInsetRight() {
        int i;
        androidx.appcompat.widget.l0 l0Var = this.L;
        if (l0Var != null) {
            i = l0Var.c();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int getContentInsetStart() {
        int i;
        androidx.appcompat.widget.l0 l0Var = this.L;
        if (l0Var != null) {
            i = l0Var.d();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public int getContentInsetStartWithNavigation() {
        int contentInsetStart;
        if (this.M != Integer.MIN_VALUE) {
        } else {
            contentInsetStart = getContentInsetStart();
        }
        return contentInsetStart;
    }

    @Override // android.view.ViewGroup
    public int getCurrentContentInsetEnd() {
        int i;
        int contentInsetEnd;
        androidx.appcompat.widget.ActionMenuView visibleItems;
        int i2;
        int i3;
        visibleItems = this.a;
        i2 = 0;
        visibleItems = visibleItems.q();
        if (visibleItems != null && visibleItems != null && visibleItems.hasVisibleItems()) {
            visibleItems = visibleItems.q();
            if (visibleItems != null) {
                i = visibleItems.hasVisibleItems() ? 1 : i2;
            } else {
            }
        } else {
        }
        if (i != 0) {
            contentInsetEnd = Math.max(getContentInsetEnd(), Math.max(this.N, i2));
        } else {
            contentInsetEnd = getContentInsetEnd();
        }
        return contentInsetEnd;
    }

    @Override // android.view.ViewGroup
    public int getCurrentContentInsetLeft() {
        int currentContentInsetEnd;
        if (u.B(this) == 1) {
            currentContentInsetEnd = getCurrentContentInsetEnd();
        } else {
            currentContentInsetEnd = getCurrentContentInsetStart();
        }
        return currentContentInsetEnd;
    }

    @Override // android.view.ViewGroup
    public int getCurrentContentInsetRight() {
        int currentContentInsetStart;
        if (u.B(this) == 1) {
            currentContentInsetStart = getCurrentContentInsetStart();
        } else {
            currentContentInsetStart = getCurrentContentInsetEnd();
        }
        return currentContentInsetStart;
    }

    @Override // android.view.ViewGroup
    public int getCurrentContentInsetStart() {
        int contentInsetStart;
        int i2;
        int i;
        if (getNavigationIcon() != null) {
            contentInsetStart = Math.max(getContentInsetStart(), Math.max(this.M, 0));
        } else {
            contentInsetStart = getContentInsetStart();
        }
        return contentInsetStart;
    }

    @Override // android.view.ViewGroup
    public Drawable getLogo() {
        Drawable drawable;
        ImageView view = this.w;
        if (view != null) {
            drawable = view.getDrawable();
        } else {
            drawable = 0;
        }
        return drawable;
    }

    @Override // android.view.ViewGroup
    public java.lang.CharSequence getLogoDescription() {
        java.lang.CharSequence contentDescription;
        ImageView view = this.w;
        if (view != null) {
            contentDescription = view.getContentDescription();
        } else {
            contentDescription = 0;
        }
        return contentDescription;
    }

    @Override // android.view.ViewGroup
    public Menu getMenu() {
        j();
        return this.a.getMenu();
    }

    @Override // android.view.ViewGroup
    public java.lang.CharSequence getNavigationContentDescription() {
        java.lang.CharSequence contentDescription;
        ImageButton imageButton = this.v;
        if (imageButton != null) {
            contentDescription = imageButton.getContentDescription();
        } else {
            contentDescription = 0;
        }
        return contentDescription;
    }

    @Override // android.view.ViewGroup
    public Drawable getNavigationIcon() {
        Drawable drawable;
        ImageButton imageButton = this.v;
        if (imageButton != null) {
            drawable = imageButton.getDrawable();
        } else {
            drawable = 0;
        }
        return drawable;
    }

    @Override // android.view.ViewGroup
    androidx.appcompat.widget.c getOuterActionMenuPresenter() {
        return this.e0;
    }

    @Override // android.view.ViewGroup
    public Drawable getOverflowIcon() {
        j();
        return this.a.getOverflowIcon();
    }

    @Override // android.view.ViewGroup
    Context getPopupContext() {
        return this.B;
    }

    @Override // android.view.ViewGroup
    public int getPopupTheme() {
        return this.C;
    }

    @Override // android.view.ViewGroup
    public java.lang.CharSequence getSubtitle() {
        return this.Q;
    }

    @Override // android.view.ViewGroup
    final TextView getSubtitleTextView() {
        return this.c;
    }

    @Override // android.view.ViewGroup
    public java.lang.CharSequence getTitle() {
        return this.P;
    }

    @Override // android.view.ViewGroup
    public int getTitleMarginBottom() {
        return this.K;
    }

    @Override // android.view.ViewGroup
    public int getTitleMarginEnd() {
        return this.I;
    }

    @Override // android.view.ViewGroup
    public int getTitleMarginStart() {
        return this.H;
    }

    @Override // android.view.ViewGroup
    public int getTitleMarginTop() {
        return this.J;
    }

    @Override // android.view.ViewGroup
    final TextView getTitleTextView() {
        return this.b;
    }

    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.z getWrapper() {
        androidx.appcompat.widget.u0 u0Var;
        int i;
        if (this.d0 == null) {
            u0Var = new u0(this, 1);
            this.d0 = u0Var;
        }
        return this.d0;
    }

    @Override // android.view.ViewGroup
    protected androidx.appcompat.widget.Toolbar.e m() {
        final int i = -2;
        Toolbar.e eVar = new Toolbar.e(i, i);
        return eVar;
    }

    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.Toolbar.e n(AttributeSet attributeSet) {
        Toolbar.e eVar = new Toolbar.e(getContext(), attributeSet);
        return eVar;
    }

    @Override // android.view.ViewGroup
    protected androidx.appcompat.widget.Toolbar.e o(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        if (layoutParams instanceof Toolbar.e) {
            Toolbar.e eVar = new Toolbar.e((Toolbar.e)layoutParams);
            return eVar;
        }
        if (layoutParams instanceof a.a) {
            Toolbar.e eVar2 = new Toolbar.e((a.a)layoutParams);
            return eVar2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Toolbar.e eVar3 = new Toolbar.e((ViewGroup.MarginLayoutParams)layoutParams);
            return eVar3;
        }
        Toolbar.e eVar4 = new Toolbar.e(layoutParams);
        return eVar4;
    }

    @Override // android.view.ViewGroup
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.j0);
    }

    @Override // android.view.ViewGroup
    public boolean onHoverEvent(MotionEvent motionEvent) {
        MotionEvent obj6;
        final int actionMasked = motionEvent.getActionMasked();
        final int i = 0;
        final int i2 = 9;
        if (actionMasked == i2) {
            this.U = i;
        }
        final int i3 = 1;
        if (!this.U && actionMasked == i2 && !super.onHoverEvent(motionEvent)) {
            if (actionMasked == i2) {
                if (!super.onHoverEvent(motionEvent)) {
                    this.U = i3;
                }
            }
        }
        if (actionMasked != 10) {
            if (actionMasked == 3) {
                this.U = i;
            }
        } else {
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int bottomMargin;
        int i10;
        int i13;
        int i14;
        int i12;
        int i16;
        int bottomMargin2;
        int i25;
        int i6;
        int bottomMargin3;
        int i11;
        int i20;
        int i19;
        TextView view2;
        int height;
        int paddingLeft;
        int paddingRight;
        int i15;
        int i24;
        TextView view;
        int i;
        int paddingTop;
        int i8;
        int i22;
        int i23;
        int i17;
        boolean z2;
        boolean z3;
        int i21;
        boolean z5;
        boolean z4;
        int currentContentInsetLeft;
        int i7;
        int i9;
        int i18;
        int obj22;
        int obj23;
        int obj24;
        final Object obj = this;
        int i29 = 1;
        int i41 = 0;
        bottomMargin = u.B(this) == i29 ? i29 : i41;
        bottomMargin3 = getWidth();
        height = getHeight();
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();
        paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        int i67 = bottomMargin3 - paddingRight;
        final int[] iArr = obj.a0;
        iArr[i29] = i41;
        iArr[i41] = i41;
        int i69 = u.C(this);
        if (i69 >= 0) {
            i22 = Math.min(i69, i5 - i3);
        } else {
            i22 = i41;
        }
        if (obj.N(obj.v)) {
            if (bottomMargin != 0) {
                i21 = i71;
                i17 = paddingLeft;
            } else {
                i17 = obj.B(obj.v, paddingLeft, iArr, i22);
                i21 = i67;
            }
        } else {
            i17 = paddingLeft;
        }
        if (obj.N(obj.z)) {
            if (bottomMargin != 0) {
                i21 = obj.C(obj.z, i21, iArr, i22);
            } else {
                i17 = obj.B(obj.z, i17, iArr, i22);
            }
        }
        if (obj.N(obj.a)) {
            if (bottomMargin != 0) {
                i17 = obj.B(obj.a, i17, iArr, i22);
            } else {
                i21 = obj.C(obj.a, i21, iArr, i22);
            }
        }
        currentContentInsetLeft = getCurrentContentInsetLeft();
        int currentContentInsetRight = getCurrentContentInsetRight();
        iArr[i41] = Math.max(i41, currentContentInsetLeft - i17);
        iArr[1] = Math.max(i41, currentContentInsetRight - i32);
        if (obj.N(obj.A)) {
            if (bottomMargin != 0) {
                i8 = obj.C(obj.A, Math.min(i21, i67 -= currentContentInsetRight), iArr, i22);
            } else {
                i14 = obj.B(obj.A, Math.max(i17, currentContentInsetLeft), iArr, i22);
            }
        }
        if (obj.N(obj.w)) {
            if (bottomMargin != 0) {
                i8 = obj.C(obj.w, i8, iArr, i22);
            } else {
                i14 = obj.B(obj.w, i14, iArr, i22);
            }
        }
        boolean z7 = obj.N(obj.b);
        boolean z8 = obj.N(obj.c);
        if (z7) {
            currentContentInsetLeft = obj.b.getLayoutParams();
            obj23 = paddingRight;
            i48 += paddingRight;
        } else {
            obj23 = paddingRight;
            bottomMargin2 = 0;
        }
        if (z8) {
            paddingRight = obj.c.getLayoutParams();
            i7 = bottomMargin3;
            bottomMargin2 += currentContentInsetLeft;
        } else {
            i7 = bottomMargin3;
        }
        if (!z7) {
            if (z8) {
                view2 = z7 ? obj.b : obj.c;
                view = z8 ? obj.c : obj.b;
                ViewGroup.LayoutParams layoutParams5 = view2.getLayoutParams();
                paddingRight = view.getLayoutParams();
                if (z7) {
                    if (obj.b.getMeasuredWidth() <= 0) {
                        if (z8 && obj.c.getMeasuredWidth() > 0) {
                            i9 = obj.c.getMeasuredWidth() > 0 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                i72 &= 112;
                i18 = paddingLeft;
                if (currentContentInsetLeft != 48) {
                    if (currentContentInsetLeft != 80) {
                        i65 /= 2;
                        currentContentInsetLeft = layoutParams5.topMargin;
                        obj22 = i22;
                        i22 = obj.J;
                        obj24 = i14;
                        if (paddingLeft < currentContentInsetLeft + i22) {
                            paddingLeft = currentContentInsetLeft + i22;
                        } else {
                            i57 -= paddingTop;
                            bottomMargin2 = obj.K;
                            if (height < bottomMargin4 += bottomMargin2) {
                                paddingLeft = Math.max(0, paddingLeft -= i40);
                            }
                        }
                        paddingTop += paddingLeft;
                    } else {
                        obj24 = i14;
                        obj22 = i22;
                        paddingTop = height - bottomMargin2;
                    }
                } else {
                    obj24 = i14;
                    obj22 = i22;
                    paddingTop = i12 + bottomMargin2;
                }
                if (bottomMargin != 0) {
                    i10 = 0;
                } else {
                    if (i9 != 0) {
                        i = obj.H;
                        i10 = 0;
                    } else {
                        i10 = 0;
                        i = 0;
                    }
                    i -= i37;
                    i38 += obj24;
                    iArr[i10] = Math.max(i10, -paddingRight);
                    if (z7) {
                        measuredWidth3 += i14;
                        measuredHeight4 += paddingTop;
                        obj.b.layout(i14, paddingTop, i53, height);
                        i53 += paddingLeft;
                        paddingTop = height + bottomMargin2;
                    } else {
                        bottomMargin3 = i14;
                    }
                    if (z8) {
                        ViewGroup.LayoutParams layoutParams3 = obj.c.getLayoutParams();
                        paddingTop += topMargin4;
                        measuredWidth4 += i14;
                        obj.c.layout(i14, paddingTop, i54, measuredHeight5 += paddingTop);
                        i54 += paddingLeft;
                        bottomMargin2 = layoutParams3.bottomMargin;
                    } else {
                        height = i14;
                    }
                    if (i9 != 0) {
                        i14 = Math.max(bottomMargin3, height);
                    }
                }
            } else {
                i18 = paddingLeft;
                obj22 = i22;
            }
        } else {
        }
        obj.b(obj.V, 3);
        i15 = i10;
        while (i15 < obj.V.size()) {
            i14 = obj.B((View)obj.V.get(i15), i14, iArr, obj22);
            i15++;
        }
        int i70 = obj22;
        obj.b(obj.V, 5);
        i24 = i10;
        while (i24 < obj.V.size()) {
            i8 = obj.C((View)obj.V.get(i24), i8, iArr, i70);
            i24++;
        }
        obj.b(obj.V, 1);
        int i42 = obj.u(obj.V, iArr);
        i60 -= i19;
        i42 += i61;
        if (i61 < i14) {
        } else {
            i14 = i25 > i8 ? i61 - i25 : i61;
        }
        while (i10 < obj.V.size()) {
            i14 = obj.B((View)obj.V.get(i10), i14, iArr, i70);
            i10++;
        }
        obj.V.clear();
    }

    @Override // android.view.ViewGroup
    protected void onMeasure(int i, int i2) {
        int i16;
        int i17;
        boolean measuredState3;
        boolean measuredState6;
        boolean z;
        boolean measuredState4;
        int i11;
        boolean measuredState5;
        int measuredState;
        int combineMeasuredStates3;
        int i8;
        int combineMeasuredStates;
        int i12;
        int measuredState2;
        int i14;
        int i19;
        int i6;
        int i4;
        int combineMeasuredStates2;
        int i9;
        int i5;
        int i18;
        int i7;
        int i13;
        int i15;
        int combineMeasuredStates4;
        int i3;
        int i20;
        View childAt;
        int i10;
        final Object obj = this;
        final int[] iArr3 = obj.a0;
        i11 = 1;
        i9 = 0;
        if (z0.b(this)) {
            i5 = i11;
            i7 = i9;
        } else {
            i7 = i11;
            i5 = i9;
        }
        if (obj.N(obj.v)) {
            this.E(obj.v, i, 0, i2, 0, obj.G);
            measuredWidth4 += i46;
            i15 = i11;
            combineMeasuredStates4 = combineMeasuredStates;
        } else {
            combineMeasuredStates4 = i15;
        }
        if (obj.N(obj.z)) {
            this.E(obj.z, i, 0, i2, 0, obj.G);
            measuredWidth3 += i44;
            i15 = Math.max(i15, measuredHeight7 += combineMeasuredStates);
            combineMeasuredStates4 = View.combineMeasuredStates(combineMeasuredStates4, obj.z.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int i61 = i9 + i12;
        iArr3[i5] = Math.max(i9, currentContentInsetStart -= i16);
        if (obj.N(obj.a)) {
            this.E(obj.a, i, i61, i2, 0, obj.G);
            measuredWidth += i36;
            i15 = Math.max(i15, measuredHeight5 += i12);
            combineMeasuredStates4 = View.combineMeasuredStates(combineMeasuredStates4, obj.a.getMeasuredState());
        } else {
            i17 = i9;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        i61 += measuredState2;
        iArr3[i7] = Math.max(i9, currentContentInsetEnd -= i17);
        if (obj.N(obj.A)) {
            i20 += i23;
            i15 = Math.max(i15, measuredHeight += combineMeasuredStates3);
            combineMeasuredStates4 = View.combineMeasuredStates(combineMeasuredStates4, obj.A.getMeasuredState());
        }
        if (obj.N(obj.w)) {
            i20 += i34;
            i15 = Math.max(i15, measuredHeight4 += combineMeasuredStates3);
            combineMeasuredStates4 = View.combineMeasuredStates(combineMeasuredStates4, obj.w.getMeasuredState());
        }
        i13 = i9;
        while (i13 < getChildCount()) {
            childAt = obj.getChildAt(i13);
            if (layoutParams.b == 0) {
            }
            i13++;
            if (!obj.N(childAt)) {
            } else {
            }
            i20 += i32;
            i15 = measuredState6;
            combineMeasuredStates4 = combineMeasuredStates3;
        }
        int i59 = i25 + i38;
        int i60 = i26 + i8;
        if (obj.N(obj.b)) {
            this.D(obj.b, i, i20 + i60, i2, i59, iArr3);
            i10 = i8;
            combineMeasuredStates2 = combineMeasuredStates5;
            i3 = z;
        } else {
            combineMeasuredStates2 = combineMeasuredStates4;
            i3 = i10;
        }
        if (obj.N(obj.c)) {
            i3 = Math.max(i3, this.D(obj.c, i, i20 + i60, i2, i10 + i59, iArr3));
            i10 += i31;
            combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates2, obj.c.getMeasuredState());
        } else {
            i18 = combineMeasuredStates2;
        }
        if (M()) {
        } else {
            i9 = resolveSizeAndState;
        }
        obj.setMeasuredDimension(View.resolveSizeAndState(Math.max(i62 += i39, getSuggestedMinimumWidth()), i, i49 &= combineMeasuredStates2), i9);
    }

    @Override // android.view.ViewGroup
    protected void onRestoreInstanceState(Parcelable parcelable) {
        g item;
        androidx.appcompat.widget.Toolbar.d dVar;
        if (!parcelable instanceof Toolbar.g) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((Toolbar.g)parcelable.a());
        androidx.appcompat.widget.ActionMenuView view = this.a;
        if (view != null) {
            item = view.q();
        } else {
            item = 0;
        }
        final int i = parcelable.c;
        item = item.findItem(i);
        if (i != 0 && this.f0 != null && item != null && item != null) {
            if (this.f0 != null) {
                if (item != null) {
                    item = item.findItem(i);
                    if (item != null) {
                        item.expandActionView();
                    }
                }
            }
        }
        if (parcelable.v) {
            F();
        }
    }

    @Override // android.view.ViewGroup
    public void onRtlPropertiesChanged(int i) {
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        h();
        if (i == 1) {
        } else {
            i2 = 0;
        }
        this.L.f(i2);
    }

    @Override // android.view.ViewGroup
    protected Parcelable onSaveInstanceState() {
        androidx.appcompat.widget.Toolbar.d itemId;
        Toolbar.g gVar = new Toolbar.g(super.onSaveInstanceState());
        itemId = this.f0;
        itemId = itemId.b;
        if (itemId != null && itemId != null) {
            itemId = itemId.b;
            if (itemId != null) {
                gVar.c = itemId.getItemId();
            }
        }
        gVar.v = A();
        return gVar;
    }

    @Override // android.view.ViewGroup
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obj5;
        final int actionMasked = motionEvent.getActionMasked();
        final int i = 0;
        if (actionMasked == 0) {
            this.T = i;
        }
        final int i2 = 1;
        if (!this.T && actionMasked == 0 && !super.onTouchEvent(motionEvent)) {
            if (actionMasked == 0) {
                if (!super.onTouchEvent(motionEvent)) {
                    this.T = i2;
                }
            }
        }
        if (actionMasked != i2) {
            if (actionMasked == 3) {
                this.T = i;
            }
        } else {
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    public void setCollapseContentDescription(int i) {
        Context context;
        java.lang.CharSequence obj2;
        if (i != 0) {
            obj2 = getContext().getText(i);
        } else {
            obj2 = 0;
        }
        setCollapseContentDescription(obj2);
    }

    @Override // android.view.ViewGroup
    public void setCollapseContentDescription(java.lang.CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.z;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    @Override // android.view.ViewGroup
    public void setCollapseIcon(int i) {
        setCollapseIcon(a.d(getContext(), i));
    }

    @Override // android.view.ViewGroup
    public void setCollapseIcon(Drawable drawable) {
        Object imageButton;
        Object obj2;
        if (drawable != null) {
            g();
            this.z.setImageDrawable(drawable);
        } else {
            obj2 = this.z;
            if (obj2 != null) {
                obj2.setImageDrawable(this.x);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setCollapsible(boolean z) {
        this.i0 = z;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setContentInsetEndWithActions(int i) {
        int obj2;
        if (i < 0) {
            obj2 = Integer.MIN_VALUE;
        }
        this.N = obj2;
        if (obj2 != this.N && getNavigationIcon() != null) {
            this.N = obj2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setContentInsetStartWithNavigation(int i) {
        int obj2;
        if (i < 0) {
            obj2 = Integer.MIN_VALUE;
        }
        this.M = obj2;
        if (obj2 != this.M && getNavigationIcon() != null) {
            this.M = obj2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setLogo(int i) {
        setLogo(a.d(getContext(), i));
    }

    @Override // android.view.ViewGroup
    public void setLogo(Drawable drawable) {
        ImageView view2;
        ImageView view;
        if (drawable != null) {
            i();
            if (!y(this.w)) {
                c(this.w, true);
            }
        } else {
            view2 = this.w;
            if (view2 != null && y(view2)) {
                if (y(view2)) {
                    removeView(this.w);
                    this.W.remove(this.w);
                }
            }
        }
        ImageView view4 = this.w;
        if (view4 != null) {
            view4.setImageDrawable(drawable);
        }
    }

    @Override // android.view.ViewGroup
    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    @Override // android.view.ViewGroup
    public void setLogoDescription(java.lang.CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView view = this.w;
        if (view != null) {
            view.setContentDescription(charSequence);
        }
    }

    @Override // android.view.ViewGroup
    public void setNavigationContentDescription(int i) {
        Context context;
        java.lang.CharSequence obj2;
        if (i != 0) {
            obj2 = getContext().getText(i);
        } else {
            obj2 = 0;
        }
        setNavigationContentDescription(obj2);
    }

    @Override // android.view.ViewGroup
    public void setNavigationContentDescription(java.lang.CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.v;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    @Override // android.view.ViewGroup
    public void setNavigationIcon(int i) {
        setNavigationIcon(a.d(getContext(), i));
    }

    @Override // android.view.ViewGroup
    public void setNavigationIcon(Drawable drawable) {
        ImageButton imageButton2;
        ImageButton imageButton;
        if (drawable != null) {
            l();
            if (!y(this.v)) {
                c(this.v, true);
            }
        } else {
            imageButton2 = this.v;
            if (imageButton2 != null && y(imageButton2)) {
                if (y(imageButton2)) {
                    removeView(this.v);
                    this.W.remove(this.v);
                }
            }
        }
        ImageButton imageButton4 = this.v;
        if (imageButton4 != null) {
            imageButton4.setImageDrawable(drawable);
        }
    }

    @Override // android.view.ViewGroup
    public void setNavigationOnClickListener(View.OnClickListener view$OnClickListener) {
        l();
        this.v.setOnClickListener(onClickListener);
    }

    @Override // android.view.ViewGroup
    public void setOnMenuItemClickListener(androidx.appcompat.widget.Toolbar.f toolbar$f) {
        this.b0 = f;
    }

    @Override // android.view.ViewGroup
    public void setOverflowIcon(Drawable drawable) {
        j();
        this.a.setOverflowIcon(drawable);
    }

    @Override // android.view.ViewGroup
    public void setPopupTheme(int i) {
        int contextThemeWrapper;
        Context context;
        int obj3;
        if (this.C != i) {
            this.C = i;
            if (i == 0) {
                this.B = getContext();
            } else {
                contextThemeWrapper = new ContextThemeWrapper(getContext(), i);
                this.B = contextThemeWrapper;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    @Override // android.view.ViewGroup
    public void setSubtitle(java.lang.CharSequence charSequence) {
        boolean z;
        Object view;
        int i;
        Object eND;
        if (!TextUtils.isEmpty(charSequence)) {
            Context context = getContext();
            AppCompatTextView appCompatTextView = new AppCompatTextView(context);
            this.c = appCompatTextView;
            appCompatTextView.setSingleLine();
            this.c.setEllipsize(TextUtils.TruncateAt.END);
            i = this.E;
            if (this.c == null && i != 0) {
                context = getContext();
                appCompatTextView = new AppCompatTextView(context);
                this.c = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                i = this.E;
                if (i != 0) {
                    this.c.setTextAppearance(context, i);
                }
                view = this.S;
                if (view != null) {
                    this.c.setTextColor(view);
                }
            }
            if (!y(this.c)) {
                c(this.c, true);
            }
        } else {
            z = this.c;
            if (z != null && y(z)) {
                if (y(z)) {
                    removeView(this.c);
                    this.W.remove(this.c);
                }
            }
        }
        TextView view2 = this.c;
        if (view2 != null) {
            view2.setText(charSequence);
        }
        this.Q = charSequence;
    }

    @Override // android.view.ViewGroup
    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.ViewGroup
    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.S = colorStateList;
        final TextView view = this.c;
        if (view != null) {
            view.setTextColor(colorStateList);
        }
    }

    @Override // android.view.ViewGroup
    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    @Override // android.view.ViewGroup
    public void setTitle(java.lang.CharSequence charSequence) {
        boolean z;
        Object view;
        int i;
        Object eND;
        if (!TextUtils.isEmpty(charSequence)) {
            Context context = getContext();
            AppCompatTextView appCompatTextView = new AppCompatTextView(context);
            this.b = appCompatTextView;
            appCompatTextView.setSingleLine();
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            i = this.D;
            if (this.b == null && i != 0) {
                context = getContext();
                appCompatTextView = new AppCompatTextView(context);
                this.b = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.b.setEllipsize(TextUtils.TruncateAt.END);
                i = this.D;
                if (i != 0) {
                    this.b.setTextAppearance(context, i);
                }
                view = this.R;
                if (view != null) {
                    this.b.setTextColor(view);
                }
            }
            if (!y(this.b)) {
                c(this.b, true);
            }
        } else {
            z = this.b;
            if (z != null && y(z)) {
                if (y(z)) {
                    removeView(this.b);
                    this.W.remove(this.b);
                }
            }
        }
        TextView view2 = this.b;
        if (view2 != null) {
            view2.setText(charSequence);
        }
        this.P = charSequence;
    }

    @Override // android.view.ViewGroup
    public void setTitleMarginBottom(int i) {
        this.K = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setTitleMarginEnd(int i) {
        this.I = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setTitleMarginStart(int i) {
        this.H = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setTitleMarginTop(int i) {
        this.J = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.ViewGroup
    public void setTitleTextColor(ColorStateList colorStateList) {
        this.R = colorStateList;
        final TextView view = this.b;
        if (view != null) {
            view.setTextColor(colorStateList);
        }
    }

    @Override // android.view.ViewGroup
    public boolean v() {
        Object dVar;
        int i;
        dVar = this.f0;
        if (dVar != null && dVar.b != null) {
            i = dVar.b != null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public boolean w() {
        androidx.appcompat.widget.ActionMenuView view;
        int i;
        view = this.a;
        if (view != null && view.k()) {
            i = view.k() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public void x(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    @Override // android.view.ViewGroup
    public boolean z() {
        androidx.appcompat.widget.ActionMenuView view;
        int i;
        view = this.a;
        if (view != null && view.l()) {
            i = view.l() ? 1 : 0;
        } else {
        }
        return i;
    }
}
