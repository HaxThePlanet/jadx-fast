package h.a.b.g;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;
import d.h.l.u;
import h.a.b.b.t;
import h.a.b.e;
import h.a.b.i.a;

/* compiled from: StickyHeaderHelper.java */
/* loaded from: classes2.dex */
public final class b extends RecyclerView.u {

    private h.a.b.b a;
    private RecyclerView b;
    private ViewGroup c;
    private h.a.c.b d;
    private b.t e;
    private int f = -1;
    private boolean g = false;
    private float h;

    class a implements Animator.AnimatorListener {

        final /* synthetic */ b a;
        a() {
            this.a = bVar;
            super();
        }

        public void onAnimationEnd(Animator animator) {
            this.a.g = 1;
            this.a.c.setAlpha(0.0f);
            this.a.h();
        }

        public void onAnimationStart(Animator animator) {
            this.a.f = -1;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }
    public b(h.a.b.b bVar, b.t tVar, ViewGroup viewGroup) {
        super();
        this.a = bVar;
        this.e = tVar;
        this.c = viewGroup;
    }

    static /* synthetic */ int a(b bVar, int i) {
        bVar.f = i;
        return i;
    }

    static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.g = z;
        return z;
    }

    static /* synthetic */ ViewGroup c(b bVar) {
        return bVar.c;
    }

    static /* synthetic */ void d(b bVar) {
        bVar.h();
    }

    private static void e(ViewGroup viewGroup, View view) {
        try {
            viewGroup.addView(view);
        } catch (java.lang.IllegalStateException unused) {
            viewGroup = 0;
            viewGroup = new Object[viewGroup];
            view = "The specified child already has a parent! (but parent was removed!)";
            b.o(view, viewGroup);
        }
    }

    private void f(View view) {
        int width2;
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        layoutParams.width = view.getLayoutParams().width;
        layoutParams.height = view.getLayoutParams().height;
        if (layoutParams.leftMargin == 0) {
            layoutParams.leftMargin = this.b.getLayoutManager().x0(this.d.itemView);
        }
        if (layoutParams.topMargin == 0) {
            layoutParams.topMargin = this.b.getLayoutManager().F0(this.d.itemView);
        }
        if (layoutParams.rightMargin == 0) {
            layoutParams.rightMargin = this.b.getLayoutManager().C0(this.d.itemView);
        }
        if (layoutParams.bottomMargin == 0) {
            layoutParams.bottomMargin = this.b.getLayoutManager().e0(this.d.itemView);
        }
    }

    private void h() {
        if (this.d != null) {
            b.b("clearHeader", new Object[0]);
            v(this.d);
            this.c.setAlpha(0.0f);
            this.c.animate().cancel();
            Animator.AnimatorListener animatorListener = null;
            this.c.animate().setListener(animatorListener);
            this.d = animatorListener;
            w();
            int i = -1;
            this.f = i;
            t(i, this.f);
        }
    }

    private void j() {
        float f3 = u.w(this.d.getContentView());
        this.h = f3;
        float f = 0.0f;
        if (f3 == 0.0f) {
            f2 = (float)this.a.V0();
            this.h = this.b.getContext().getResources().getDisplayMetrics().density * f2;
        }
        if (this.h > 0.0f) {
            u.o0(this.c, this.d.getContentView().getBackground());
        }
    }

    private FrameLayout k(int i, int i2) {
        final FrameLayout frameLayout = new FrameLayout(this.b.getContext());
        frameLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(i, i2));
        return frameLayout;
    }

    private h.a.c.b n(int i) {
        RecyclerView.e0 viewHolder;
        int measureSpec;
        int measureSpec2;
        if ((b)this.b.a0(i) == null) {
            viewHolder = this.a.createViewHolder(this.b, this.a.getItemViewType(i));
            boolean z = false;
            viewHolder.setIsRecyclable(z);
            this.a.bindViewHolder(viewHolder, i);
            boolean z2 = true;
            viewHolder.setIsRecyclable(z2);
            int i4 = 1073741824;
            if (this.a.l().c() == z2) {
                measureSpec = View.MeasureSpec.makeMeasureSpec(this.b.getWidth(), i4);
                measureSpec2 = View.MeasureSpec.makeMeasureSpec(this.b.getHeight(), z);
            } else {
                measureSpec = View.MeasureSpec.makeMeasureSpec(this.b.getWidth(), z);
                measureSpec2 = View.MeasureSpec.makeMeasureSpec(this.b.getHeight(), i4);
            }
            View contentView = viewHolder.getContentView();
            i2 = this.b.getPaddingTop() + this.b.getPaddingBottom();
            contentView.measure(ViewGroup.getChildMeasureSpec(measureSpec, this.b.getPaddingLeft() + this.b.getPaddingRight(), contentView.getLayoutParams().width), ViewGroup.getChildMeasureSpec(measureSpec2, i2, contentView.getLayoutParams().height));
            contentView.layout(z, z, contentView.getMeasuredWidth(), contentView.getMeasuredHeight());
        }
        viewHolder.setBackupPosition(i);
        return viewHolder;
    }

    private ViewGroup o(View view) {
        return (ViewGroup)view.getParent();
    }

    private int q(int i) {
        int i2;
        int i3 = -1;
        if (this.a == i3 && this.a.l().b() == 0 && !this.r(0)) {
            return i3;
        }
        h.a.b.h.g gVar = this.a.T0(i2);
        if (gVar != null) {
            return this.a.M0(gVar);
        }
        return i3;
    }

    private boolean r(int i) {
        RecyclerView recyclerView;
        float f = 0;
        boolean z = true;
        RecyclerView.e0 e0Var = this.b.a0(i);
        if (e0Var != null) {
            float f2 = e0Var.itemView.getX();
            f = 0.0f;
            if (f2 >= 0.0f) {
                float f3 = e0Var.itemView.getY();
                i = f3 < 0.0f ? 1 : 0;
            }
        }
        return (f3 < 0.0f ? 1 : 0);
    }

    private void s() {
        final int i2 = 0;
        if (this.c != null) {
            str = "User defined StickyHolderLayout initialized";
            b.f(str, new Object[i2]);
        } else {
            ViewGroup viewGroup2 = o(this.b);
            if (viewGroup2 != null) {
                int i3 = -2;
                FrameLayout frameLayout = k(i3, i3);
                this.c = frameLayout;
                viewGroup2.addView(frameLayout);
                str = "Default StickyHolderLayout initialized";
                b.f(str, new Object[i2]);
            }
        }
        this.g = true;
        A(false);
    }

    private void t(int i, int i2) {
        if (this.e != null) {
            this.e.a(i, i2);
        }
    }

    private static void u(View view) {
        final android.view.ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            parent.removeView(view);
        }
    }

    private void v(h.a.c.b bVar) {
        w();
        View contentView = bVar.getContentView();
        b.u(contentView);
        float f = 0.0f;
        contentView.setTranslationX(f);
        contentView.setTranslationY(f);
        if (!bVar.itemView.equals(contentView)) {
            b.e((ViewGroup)bVar.itemView, contentView);
        }
        bVar.setIsRecyclable(true);
        bVar.itemView.getLayoutParams().width = contentView.getLayoutParams().width;
        bVar.itemView.getLayoutParams().height = contentView.getLayoutParams().height;
    }

    private void w() {
        int i;
        if (this.b == null) {
            return;
        }
        i = 0;
        while (i < this.b.getChildCount()) {
            View childAt = this.b.getChildAt(i);
            i = i + 1;
        }
    }

    private void x(h.a.c.b bVar, int i) {
        Object[] arr = new Object[1];
        final int i5 = 0;
        arr[i5] = Integer.valueOf(this.f);
        str = "swapHeader newHeaderPosition=%s";
        b.b(str, arr);
        if (this.d != null) {
            v(this.d);
            if (this.f > i) {
                this.a.onViewRecycled(this.d);
            }
        }
        this.d = bVar;
        bVar.setIsRecyclable(false);
        m();
        t(this.f, i);
    }

    private void y() {
        float f;
        int min;
        int left;
        int i;
        int i2;
        min = 0;
        while (min < this.b.getChildCount()) {
            View childAt = this.b.getChildAt(min);
            if (childAt != null) {
                break;
            }
        }
        u.s0(this.c, f);
        this.c.setTranslationX((float)min);
        this.c.setTranslationY((float)min);
    }

    private void z(int i, boolean z) {
        float f = 0;
        int i2;
        int i3 = 1;
        int i4 = -1;
        String str;
        Object[] arr;
        final boolean z3 = false;
        if (this.f == i || this.c == null) {
            if (z) {
                if (this.d.getItemViewType() == this.a.getItemViewType(i)) {
                    this.a.onBindViewHolder(this.d, i);
                } else {
                    arr = new Object[2];
                    arr[z3] = a.a(this.d);
                    i3 = 1;
                    arr[i3] = a.a(n(i));
                    str = "updateHeader Wrong itemViewType for StickyViewHolder=%s, PositionViewHolder=%s";
                    b.c(str, arr);
                }
                m();
            }
        } else {
            float f2 = 1f;
            if (this.g) {
                i4 = -1;
                if (this.f != -1 || i == this.a.l().b()) {
                    this.c.setAlpha(f2);
                } else {
                    this.g = z3;
                    f = 0.0f;
                    this.c.setAlpha(f);
                    this.c.animate().alpha(f2).start();
                }
            }
            this.f = i;
            x(n(i), this.f);
        }
        y();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void A(boolean z) {
        if (this.a.k0()) {
            if (this.a.getItemCount() != 0) {
                int i2 = q(-1);
                if (i2 >= 0) {
                    z(i2, z);
                } else {
                    h();
                }
            }
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void g(RecyclerView recyclerView) {
        if (this.b != null) {
            this.b.h1(this);
            h();
        }
        if (recyclerView == null) {
            throw new IllegalStateException("Adapter is not attached to RecyclerView. Enable sticky headers after setting adapter to RecyclerView.");
        } else {
            this.b = recyclerView;
            recyclerView.l(this);
            s();
            return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void i() {
        if (this.d != null) {
            int i = -1;
            if (this.f != -1) {
                this.c.animate().setListener(new b.a(this));
                this.c.animate().alpha(0.0f).start();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void l() {
        this.b.h1(this);
        this.b = null;
        i();
        b.b("StickyHolderLayout detached", new Object[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void m() {
        View contentView = this.d.getContentView();
        this.d.itemView.getLayoutParams().width = contentView.getMeasuredWidth();
        this.d.itemView.getLayoutParams().height = contentView.getMeasuredHeight();
        this.d.itemView.setVisibility(4);
        f(contentView);
        b.u(contentView);
        b.e(this.c, contentView);
        j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int i22 = 1;
        final boolean z = false;
        recyclerView = this.b.getScrollState() == 0 ? 1 : z;
        this.g = (this.b.getScrollState() == 0 ? 1 : z);
        A(z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public int p() {
        return this.f;
    }
}
