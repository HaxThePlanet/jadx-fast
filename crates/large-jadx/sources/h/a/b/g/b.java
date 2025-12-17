package h.a.b.g;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;
import d.h.l.u;
import h.a.b.b;
import h.a.b.b.t;
import h.a.b.e;
import h.a.b.f.b;
import h.a.b.i.a;
import h.a.b.i.b;
import h.a.c.b;

/* loaded from: classes2.dex */
public final class b extends RecyclerView.u {

    private b a;
    private RecyclerView b;
    private ViewGroup c;
    private b d;
    private b.t e;
    private int f = -1;
    private boolean g = false;
    private float h;

    class a implements Animator.AnimatorListener {

        final h.a.b.g.b a;
        a(h.a.b.g.b b) {
            this.a = b;
            super();
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.b(this.a, true);
            b.c(this.a).setAlpha(0);
            b.d(this.a);
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.a(this.a, -1);
        }
    }
    public b(b b, b.t b$t2, ViewGroup viewGroup3) {
        super();
        int i = -1;
        int i2 = 0;
        this.a = b;
        this.e = t2;
        this.c = viewGroup3;
    }

    static int a(h.a.b.g.b b, int i2) {
        b.f = i2;
        return i2;
    }

    static boolean b(h.a.b.g.b b, boolean z2) {
        b.g = z2;
        return z2;
    }

    static ViewGroup c(h.a.b.g.b b) {
        return b.c;
    }

    static void d(h.a.b.g.b b) {
        b.h();
    }

    private static void e(ViewGroup viewGroup, View view2) {
        int obj0;
        View obj1;
        try {
            viewGroup.addView(view2);
            viewGroup = 0;
            viewGroup = new Object[viewGroup];
            view2 = "The specified child already has a parent! (but parent was removed!)";
            b.o(view2, viewGroup);
        }
    }

    private void f(View view) {
        int itemView;
        int obj3;
        android.view.ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = layoutParams2.width;
        layoutParams.height = obj3.height;
        if (layoutParams.leftMargin == 0) {
            layoutParams.leftMargin = this.b.getLayoutManager().x0(bVar4.itemView);
        }
        if (layoutParams.topMargin == 0) {
            layoutParams.topMargin = this.b.getLayoutManager().F0(bVar.itemView);
        }
        if (layoutParams.rightMargin == 0) {
            layoutParams.rightMargin = this.b.getLayoutManager().C0(bVar3.itemView);
        }
        if (layoutParams.bottomMargin == 0) {
            layoutParams.bottomMargin = this.b.getLayoutManager().e0(bVar2.itemView);
        }
    }

    private void h() {
        b bVar;
        int i;
        if (this.d != null) {
            b.b("clearHeader", new Object[0]);
            v(this.d);
            this.c.setAlpha(0);
            this.c.animate().cancel();
            int i4 = 0;
            this.c.animate().setListener(i4);
            this.d = i4;
            w();
            i = -1;
            this.f = i;
            t(i, this.f);
        }
    }

    private void j() {
        int cmp2;
        int cmp;
        int background;
        float f;
        float f2 = u.w(this.d.getContentView());
        this.h = f2;
        background = 0;
        if (Float.compare(f2, background) == 0) {
            this.h = density *= f;
        }
        if (Float.compare(f3, background) > 0) {
            u.o0(this.c, this.d.getContentView().getBackground());
        }
    }

    private FrameLayout k(int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.b.getContext());
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, i2);
        frameLayout.setLayoutParams(marginLayoutParams);
        return frameLayout;
    }

    private b n(int i) {
        RecyclerView.e0 viewHolder;
        int i3;
        int measureSpec;
        int measuredWidth;
        int measureSpec2;
        int measuredHeight;
        View contentView;
        int i2;
        int height;
        if ((b)this.b.a0(i) == null) {
            b bVar = this.a;
            viewHolder = bVar.createViewHolder(this.b, bVar.getItemViewType(i));
            i3 = 0;
            (b)viewHolder.setIsRecyclable(i3);
            this.a.bindViewHolder(viewHolder, i);
            int i4 = 1;
            viewHolder.setIsRecyclable(i4);
            int i6 = 1073741824;
            if (this.a.l().c() == i4) {
                measureSpec = View.MeasureSpec.makeMeasureSpec(this.b.getWidth(), i6);
                measureSpec2 = View.MeasureSpec.makeMeasureSpec(this.b.getHeight(), i3);
            } else {
                measureSpec = View.MeasureSpec.makeMeasureSpec(this.b.getWidth(), i3);
                measureSpec2 = View.MeasureSpec.makeMeasureSpec(this.b.getHeight(), i6);
            }
            contentView = viewHolder.getContentView();
            contentView.measure(ViewGroup.getChildMeasureSpec(measureSpec, paddingLeft += paddingRight, layoutParams.width), ViewGroup.getChildMeasureSpec(measureSpec2, paddingTop += paddingBottom, layoutParams2.height));
            contentView.layout(i3, i3, contentView.getMeasuredWidth(), contentView.getMeasuredHeight());
        }
        viewHolder.setBackupPosition(i);
        return viewHolder;
    }

    private ViewGroup o(View view) {
        return (ViewGroup)view.getParent();
    }

    private int q(int i) {
        boolean z;
        b bVar;
        int obj3;
        int i2 = -1;
        if (i == i2 && this.a.l().b() == 0 && !r(0)) {
            if (this.a.l().b() == 0) {
                if (!r(0)) {
                    return i2;
                }
            }
        }
        obj3 = this.a.T0(obj3);
        if (obj3 != null && this.a.j1(obj3) && !this.a.l1(obj3)) {
            if (this.a.j1(obj3)) {
                if (!this.a.l1(obj3)) {
                }
            }
            return this.a.M0(obj3);
        }
        return i2;
    }

    private boolean r(int i) {
        int cmp;
        int i2;
        RecyclerView.e0 obj3;
        obj3 = this.b.a0(i);
        if (obj3 != null) {
            i2 = 0;
            if (Float.compare(f, i2) >= 0) {
                obj3 = Float.compare(obj3, i2) < 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    private void s() {
        Object[] arr;
        String str;
        final int i2 = 0;
        if (this.c == null) {
            arr = o(this.b);
            if (arr != null) {
                int i3 = -2;
                FrameLayout frameLayout = k(i3, i3);
                this.c = frameLayout;
                arr.addView(frameLayout);
                b.f("Default StickyHolderLayout initialized", new Object[i2]);
            }
        } else {
            b.f("User defined StickyHolderLayout initialized", new Object[i2]);
        }
        this.g = true;
        A(i2);
    }

    private void t(int i, int i2) {
        final b.t tVar = this.e;
        if (tVar != null) {
            tVar.a(i, i2);
        }
    }

    private static void u(View view) {
        final android.view.ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            (ViewGroup)parent.removeView(view);
        }
    }

    private void v(b b) {
        boolean itemView;
        w();
        View contentView = b.getContentView();
        b.u(contentView);
        int i = 0;
        contentView.setTranslationX(i);
        contentView.setTranslationY(i);
        if (!b.itemView.equals(contentView)) {
            b.e((ViewGroup)b.itemView, contentView);
        }
        b.setIsRecyclable(true);
        layoutParams2.width = layoutParams3.width;
        obj4.height = layoutParams.height;
    }

    private void w() {
        int i;
        View childAt;
        boolean z;
        b bVar;
        if (this.b == null) {
        }
        int i2 = 0;
        i = i2;
        while (i < this.b.getChildCount()) {
            childAt = this.b.getChildAt(i);
            bVar = this.a;
            if (bVar.o1(bVar.O0(this.b.g0(childAt)))) {
            }
            i++;
            childAt.setVisibility(i2);
        }
    }

    private void x(b b, int i2) {
        b bVar;
        Object str;
        Object[] arr = new Object[1];
        final int i4 = 0;
        arr[i4] = Integer.valueOf(this.f);
        b.b("swapHeader newHeaderPosition=%s", arr);
        bVar = this.d;
        v(bVar);
        if (bVar != null && this.f > i2) {
            v(bVar);
            if (this.f > i2) {
                this.a.onViewRecycled(this.d);
            }
        }
        this.d = b;
        b.setIsRecyclable(i4);
        m();
        t(this.f, i2);
    }

    private void y() {
        float f;
        int i5;
        int i2;
        int i4;
        View childCount;
        int left;
        int i3;
        int i;
        f = this.h;
        int i6 = 0;
        i4 = i2;
        while (i5 < this.b.getChildCount()) {
            childCount = this.b.getChildAt(i5);
            if (childCount != null) {
                break;
            } else {
            }
            i5++;
            if (this.f != q(this.b.g0(childCount))) {
                break;
            } else {
            }
            i3 = 0;
            i = 5;
            i14 -= i10;
            if (left < i) {
            }
            f = i3;
            i16 -= i8;
            if (left < i) {
            }
            f = i3;
        }
        u.s0(this.c, f);
        this.c.setTranslationX((float)i2);
        this.c.setTranslationY((float)i4);
    }

    private void z(int i, boolean z2) {
        int i2;
        int i4;
        int i3;
        b obj5;
        int obj6;
        final int i5 = 0;
        if (this.f != i && this.c != null) {
            if (this.c != null) {
                i4 = 1065353216;
                if (this.g && this.f == -1 && i != this.a.l().b()) {
                    if (this.f == -1) {
                        if (i != this.a.l().b()) {
                            this.g = i5;
                            this.c.setAlpha(0);
                            this.c.animate().alpha(i4).start();
                        } else {
                            this.c.setAlpha(i4);
                        }
                    } else {
                    }
                } else {
                }
                this.f = i;
                x(n(i), this.f);
            } else {
                if (z2 != 0) {
                    if (this.d.getItemViewType() == this.a.getItemViewType(i)) {
                        this.a.onBindViewHolder(this.d, i);
                    } else {
                        obj6 = new Object[2];
                        obj6[i5] = a.a(this.d);
                        obj6[1] = a.a(n(i));
                        b.c("updateHeader Wrong itemViewType for StickyViewHolder=%s, PositionViewHolder=%s", obj6);
                    }
                    m();
                }
            }
        } else {
        }
        y();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void A(boolean z) {
        boolean itemCount;
        if (this.a.k0()) {
            if (this.a.getItemCount() == 0) {
            } else {
                int i2 = q(-1);
                if (i2 >= 0) {
                    z(i2, z);
                } else {
                    h();
                }
            }
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void g(RecyclerView recyclerView) {
        RecyclerView view = this.b;
        if (view != null) {
            view.h1(this);
            h();
        }
        if (recyclerView == null) {
        } else {
            this.b = recyclerView;
            recyclerView.l(this);
            s();
        }
        IllegalStateException obj2 = new IllegalStateException("Adapter is not attached to RecyclerView. Enable sticky headers after setting adapter to RecyclerView.");
        throw obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void i() {
        b alpha;
        int i;
        if (this.d != null && this.f != -1) {
            if (this.f != -1) {
                b.a aVar = new b.a(this);
                this.c.animate().setListener(aVar);
                this.c.animate().alpha(0).start();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void l() {
        this.b.h1(this);
        this.b = 0;
        i();
        b.b("StickyHolderLayout detached", new Object[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void m() {
        View contentView = this.d.getContentView();
        layoutParams.width = contentView.getMeasuredWidth();
        layoutParams2.height = contentView.getMeasuredHeight();
        bVar4.itemView.setVisibility(4);
        f(contentView);
        b.u(contentView);
        b.e(this.c, contentView);
        j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        int obj1;
        final int obj2 = 0;
        obj1 = this.b.getScrollState() == 0 ? 1 : obj2;
        this.g = obj1;
        A(obj2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public int p() {
        return this.f;
    }
}
