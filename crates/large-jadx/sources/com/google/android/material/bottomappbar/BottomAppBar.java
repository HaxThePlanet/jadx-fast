package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.core.graphics.drawable.a;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton.b;
import com.google.android.material.internal.n;
import d.h.l.u;
import d.j.a.a;
import f.c.a.e.a;
import f.c.a.e.d0.g;
import f.c.a.e.d0.h;
import f.c.a.e.d0.k;
import f.c.a.e.m.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    private int A0;
    AnimatorListenerAdapter B0;
    k<FloatingActionButton> C0;
    private Integer k0;
    private final int l0;
    private final g m0;
    private Animator n0;
    private Animator o0;
    private int p0;
    private int q0;
    private boolean r0;
    private int s0;
    private ArrayList<com.google.android.material.bottomappbar.BottomAppBar.g> t0;
    private int u0;
    private boolean v0;
    private boolean w0;
    private com.google.android.material.bottomappbar.BottomAppBar.Behavior x0;
    private int y0;
    private int z0;

    class a extends AnimatorListenerAdapter {

        final com.google.android.material.bottomappbar.BottomAppBar a;
        a(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
            this.a = bottomAppBar;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.S(this.a);
            BottomAppBar.T(this.a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            BottomAppBar.R(this.a);
        }
    }

    class c extends AnimatorListenerAdapter {

        final com.google.android.material.bottomappbar.BottomAppBar a;
        c(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
            this.a = bottomAppBar;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.S(this.a);
            BottomAppBar.P(this.a, false);
            BottomAppBar.V(this.a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            BottomAppBar.R(this.a);
        }
    }

    class d extends AnimatorListenerAdapter {

        public boolean a;
        final ActionMenuView b;
        final int c;
        final boolean d;
        final com.google.android.material.bottomappbar.BottomAppBar e;
        d(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, ActionMenuView actionMenuView2, int i3, boolean z4) {
            this.e = bottomAppBar;
            this.b = actionMenuView2;
            this.c = i3;
            this.d = z4;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            com.google.android.material.bottomappbar.BottomAppBar bottomAppBar;
            ActionMenuView view;
            int i;
            boolean z;
            int obj5;
            if (!this.a) {
                obj5 = BottomAppBar.W(this.e) != 0 ? 1 : 0;
                com.google.android.material.bottomappbar.BottomAppBar bottomAppBar2 = this.e;
                bottomAppBar2.v0(BottomAppBar.W(bottomAppBar2));
                BottomAppBar.X(this.e, this.b, this.c, this.d, obj5);
            }
        }
    }

    class e implements Runnable {

        final ActionMenuView a;
        final int b;
        final boolean c;
        final com.google.android.material.bottomappbar.BottomAppBar v;
        e(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, ActionMenuView actionMenuView2, int i3, boolean z4) {
            this.v = bottomAppBar;
            this.a = actionMenuView2;
            this.b = i3;
            this.c = z4;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            final ActionMenuView view = this.a;
            view.setTranslationX((float)i);
        }
    }

    class f extends AnimatorListenerAdapter {

        final com.google.android.material.bottomappbar.BottomAppBar a;
        f(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
            this.a = bottomAppBar;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            AnimatorListenerAdapter list;
            bottomAppBar.B0.onAnimationStart(animator);
            FloatingActionButton obj2 = BottomAppBar.Y(this.a);
            if (obj2 != null) {
                obj2.setTranslationX(BottomAppBar.Z(this.a));
            }
        }
    }

    interface g {
        public abstract void a(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar);

        public abstract void b(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar);
    }

    class b extends FloatingActionButton.b {

        final int a;
        final com.google.android.material.bottomappbar.BottomAppBar b;
        b(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, int i2) {
            this.b = bottomAppBar;
            this.a = i2;
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.U(this.b, this.a));
            BottomAppBar.b.a aVar = new BottomAppBar.b.a(this);
            floatingActionButton.u(aVar);
        }
    }

    static class h extends a {

        public static final Parcelable.Creator<com.google.android.material.bottomappbar.BottomAppBar.h> CREATOR;
        int c;
        boolean v;
        static {
            BottomAppBar.h.a aVar = new BottomAppBar.h.a();
            BottomAppBar.h.CREATOR = aVar;
        }

        public h(Parcel parcel, java.lang.ClassLoader classLoader2) {
            int obj1;
            super(parcel, classLoader2);
            this.c = parcel.readInt();
            obj1 = parcel.readInt() != 0 ? 1 : 0;
            this.v = obj1;
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
            parcel.writeInt(this.v);
        }
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<com.google.android.material.bottomappbar.BottomAppBar> {

        private final Rect e;
        private WeakReference<com.google.android.material.bottomappbar.BottomAppBar> f;
        private int g;
        private final View.OnLayoutChangeListener h;
        public Behavior() {
            super();
            BottomAppBar.Behavior.a aVar = new BottomAppBar.Behavior.a(this);
            this.h = aVar;
            Rect rect = new Rect();
            this.e = rect;
        }

        public Behavior(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            BottomAppBar.Behavior.a obj1 = new BottomAppBar.Behavior.a(this);
            this.h = obj1;
            obj1 = new Rect();
            this.e = obj1;
        }

        static WeakReference j(com.google.android.material.bottomappbar.BottomAppBar.Behavior bottomAppBar$Behavior) {
            return behavior.f;
        }

        static Rect k(com.google.android.material.bottomappbar.BottomAppBar.Behavior bottomAppBar$Behavior) {
            return behavior.e;
        }

        static int l(com.google.android.material.bottomappbar.BottomAppBar.Behavior bottomAppBar$Behavior) {
            return behavior.g;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public boolean m(CoordinatorLayout coordinatorLayout, com.google.android.material.bottomappbar.BottomAppBar bottomAppBar2, int i3) {
            boolean z;
            f.c.a.e.m.h showMotionSpec;
            f.c.a.e.m.h hideMotionSpec;
            int i;
            WeakReference weakReference = new WeakReference(bottomAppBar2);
            this.f = weakReference;
            View view = BottomAppBar.e0(bottomAppBar2);
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.d = 49;
            this.g = layoutParams.bottomMargin;
            if (view != null && !u.R(view) && view instanceof FloatingActionButton && (FloatingActionButton)view.getShowMotionSpec() == null) {
                if (!u.R(view)) {
                    layoutParams = view.getLayoutParams();
                    layoutParams.d = 49;
                    this.g = layoutParams.bottomMargin;
                    if (view instanceof FloatingActionButton) {
                        if ((FloatingActionButton)view.getShowMotionSpec() == null) {
                            view.setShowMotionSpecResource(a.b);
                        }
                        if (view.getHideMotionSpec() == null) {
                            view.setHideMotionSpecResource(a.a);
                        }
                        view.addOnLayoutChangeListener(this.h);
                        BottomAppBar.f0(bottomAppBar2, view);
                    }
                    BottomAppBar.Q(bottomAppBar2);
                }
            }
            coordinatorLayout.onLayoutChild(bottomAppBar2, i3);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar2, i3);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public boolean n(CoordinatorLayout coordinatorLayout, com.google.android.material.bottomappbar.BottomAppBar bottomAppBar2, View view3, View view4, int i5, int i6) {
            CoordinatorLayout obj2;
            if (bottomAppBar2.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar2, view3, view4, i5, i6)) {
                obj2 = super.onStartNestedScroll(coordinatorLayout, bottomAppBar2, view3, view4, i5, i6) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view2, int i3) {
            return m(coordinatorLayout, (BottomAppBar)view2, i3);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view2, View view3, View view4, int i5, int i6) {
            return n(coordinatorLayout, (BottomAppBar)view2, view3, view4, i5, i6);
        }
    }
    static {
    }

    private void A0(ActionMenuView actionMenuView, int i2, boolean z3) {
        B0(actionMenuView, i2, z3, false);
    }

    private void B0(ActionMenuView actionMenuView, int i2, boolean z3, boolean z4) {
        BottomAppBar.e eVar = new BottomAppBar.e(this, actionMenuView, i2, z3);
        if (z4) {
            actionMenuView.post(eVar);
        } else {
            eVar.run();
        }
    }

    static boolean P(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, boolean z2) {
        bottomAppBar.v0 = z2;
        return z2;
    }

    static void Q(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        bottomAppBar.x0();
    }

    static void R(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        bottomAppBar.m0();
    }

    static void S(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        bottomAppBar.l0();
    }

    static Animator T(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, Animator animator2) {
        bottomAppBar.n0 = animator2;
        return animator2;
    }

    static float U(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, int i2) {
        return bottomAppBar.q0(i2);
    }

    static Animator V(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, Animator animator2) {
        bottomAppBar.o0 = animator2;
        return animator2;
    }

    static int W(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        return bottomAppBar.u0;
    }

    static void X(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, ActionMenuView actionMenuView2, int i3, boolean z4, boolean z5) {
        bottomAppBar.B0(actionMenuView2, i3, z4, z5);
    }

    static FloatingActionButton Y(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        return bottomAppBar.n0();
    }

    static float Z(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        return bottomAppBar.getFabTranslationX();
    }

    static int a0(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        return bottomAppBar.getBottomInset();
    }

    static int b0(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        return bottomAppBar.getLeftInset();
    }

    static int c0(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        return bottomAppBar.getRightInset();
    }

    static int d0(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        return bottomAppBar.l0;
    }

    static View e0(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar) {
        return bottomAppBar.o0();
    }

    static void f0(com.google.android.material.bottomappbar.BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton2) {
        bottomAppBar.g0(floatingActionButton2);
    }

    private void g0(FloatingActionButton floatingActionButton) {
        floatingActionButton.e(this.B0);
        BottomAppBar.f fVar = new BottomAppBar.f(this);
        floatingActionButton.f(fVar);
        floatingActionButton.g(this.C0);
    }

    private ActionMenuView getActionMenuView() {
        int i;
        View childAt;
        boolean z;
        i = 0;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            i++;
        }
        return null;
    }

    private int getBottomInset() {
        return this.y0;
    }

    private float getFabTranslationX() {
        return q0(this.p0);
    }

    private float getFabTranslationY() {
        return -f;
    }

    private int getLeftInset() {
        return this.A0;
    }

    private int getRightInset() {
        return this.z0;
    }

    private com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (a)this.m0.E().p();
    }

    private void h0() {
        Animator animator = this.o0;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.n0;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void j0(int i, List<Animator> list2) {
        float[] fArr = new float[1];
        ObjectAnimator obj4 = ObjectAnimator.ofFloat(n0(), "translationX", q0(i));
        obj4.setDuration(300);
        list2.add(obj4);
    }

    private void k0(int i, boolean z2, List<Animator> list3) {
        ObjectAnimator float;
        int str;
        int cmp;
        AnimatorSet obj9;
        Animator[] obj10;
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
        }
        final int i2 = 1;
        float[] fArr = new float[i2];
        final int i3 = 0;
        float = 1065353216;
        fArr[i3] = float;
        str = "alpha";
        ObjectAnimator float2 = ObjectAnimator.ofFloat(actionMenuView, str, fArr);
        if (Float.compare(f, float) > 0) {
            float[] fArr2 = new float[i2];
            cmp = 0;
            fArr2[i3] = cmp;
            float = ObjectAnimator.ofFloat(actionMenuView, str, fArr2);
            BottomAppBar.d dVar = new BottomAppBar.d(this, actionMenuView, i, z2);
            float.addListener(dVar);
            obj9 = new AnimatorSet();
            obj9.setDuration(150);
            obj10 = new Animator[2];
            obj10[i3] = float;
            obj10[i2] = float2;
            obj9.playSequentially(obj10);
            list3.add(obj9);
        } else {
            if (Float.compare(obj9, float) < 0) {
                list3.add(float2);
            }
        }
    }

    private void l0() {
        int iterator;
        Object next;
        i--;
        this.s0 = iterator;
        iterator = this.t0;
        if (iterator == null && iterator != null) {
            iterator = this.t0;
            if (iterator != null) {
                iterator = iterator.iterator();
                for (BottomAppBar.g next : iterator) {
                    next.b(this);
                }
            }
        }
    }

    private void m0() {
        int iterator;
        int next;
        iterator = this.s0;
        this.s0 = iterator + 1;
        iterator = this.t0;
        if (iterator == null && iterator != null) {
            iterator = this.t0;
            if (iterator != null) {
                iterator = iterator.iterator();
                for (BottomAppBar.g next : iterator) {
                    next.a(this);
                }
            }
        }
    }

    private FloatingActionButton n0() {
        View view;
        if (view instanceof FloatingActionButton) {
        } else {
            view = 0;
        }
        return view;
    }

    private View o0() {
        Object next;
        boolean z;
        final int i = 0;
        if (!parent instanceof CoordinatorLayout) {
            return i;
        }
        Iterator iterator = (CoordinatorLayout)getParent().getDependents(this).iterator();
        for (View next : iterator) {
        }
        return i;
    }

    private float q0(int i) {
        int i2;
        int obj4;
        final boolean z = n.e(this);
        if (i == 1) {
            obj4 = z ? this.A0 : this.z0;
            if (z) {
                i2 = -1;
            }
            return (float)obj4;
        }
        return 0;
    }

    private boolean r0() {
        FloatingActionButton num;
        int i;
        num = n0();
        if (num != null && num.p()) {
            i = num.p() ? 1 : 0;
        } else {
        }
        return i;
    }

    private void s0(int i, boolean z2) {
        int obj4;
        int obj5;
        if (!u.R(this)) {
            v0(this.u0);
        }
        Animator animator = this.o0;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!r0()) {
            obj5 = obj4;
        }
        k0(obj4, obj5, arrayList);
        obj4 = new AnimatorSet();
        obj4.playTogether(arrayList);
        this.o0 = obj4;
        obj5 = new BottomAppBar.c(this);
        obj4.addListener(obj5);
        this.o0.start();
    }

    private void t0(int i) {
        int aVar;
        int i3;
        int i2;
        int obj4;
        if (this.p0 != i) {
            if (!u.R(this)) {
            } else {
                Animator animator = this.n0;
                if (animator != null) {
                    animator.cancel();
                }
                ArrayList arrayList = new ArrayList();
                if (this.q0 == 1) {
                    j0(i, arrayList);
                } else {
                    i0(i, arrayList);
                }
                obj4 = new AnimatorSet();
                obj4.playTogether(arrayList);
                this.n0 = obj4;
                aVar = new BottomAppBar.a(this);
                obj4.addListener(aVar);
                this.n0.start();
            }
        }
    }

    private Drawable u0(Drawable drawable) {
        Integer intValue;
        Drawable obj2;
        if (drawable != null && this.k0 != null) {
            if (this.k0 != null) {
                a.n(a.r(drawable.mutate()), this.k0.intValue());
            }
        }
        return obj2;
    }

    private void w0() {
        Animator animator;
        boolean z;
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.o0 == null) {
            if (this.o0 == null) {
                actionMenuView.setAlpha(1065353216);
                if (!r0()) {
                    animator = 0;
                    A0(actionMenuView, animator, animator);
                } else {
                    A0(actionMenuView, this.p0, this.w0);
                }
            }
        }
    }

    private void x0() {
        g fabTranslationX;
        boolean z;
        int i;
        getTopEdgeTreatment().n(getFabTranslationX());
        View view = o0();
        if (this.w0 && r0()) {
            i = r0() ? 1065353216 : 0;
        } else {
        }
        this.m0.a0(i);
        if (view != null) {
            view.setTranslationY(getFabTranslationY());
            view.setTranslationX(getFabTranslationX());
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public ColorStateList getBackgroundTint() {
        return this.m0.G();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CoordinatorLayout.c getBehavior() {
        return getBehavior();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public com.google.android.material.bottomappbar.BottomAppBar.Behavior getBehavior() {
        com.google.android.material.bottomappbar.BottomAppBar.Behavior behavior;
        if (this.x0 == null) {
            behavior = new BottomAppBar.Behavior();
            this.x0 = behavior;
        }
        return this.x0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getFabAlignmentMode() {
        return this.p0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getFabAnimationMode() {
        return this.q0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public boolean getHideOnScroll() {
        return this.r0;
    }

    protected void i0(int i, List<Animator> list2) {
        com.google.android.material.bottomappbar.BottomAppBar.b bVar;
        final FloatingActionButton obj3 = n0();
        if (obj3 != null) {
            if (obj3.o()) {
            } else {
                m0();
                bVar = new BottomAppBar.b(this, i);
                obj3.m(bVar);
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    protected void onAttachedToWindow() {
        boolean parent;
        int i;
        super.onAttachedToWindow();
        h.f(this, this.m0);
        if (parent2 instanceof ViewGroup) {
            (ViewGroup)getParent().setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            h0();
            x0();
        }
        w0();
    }

    @Override // androidx.appcompat.widget.Toolbar
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable instanceof BottomAppBar.h) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((BottomAppBar.h)parcelable.a());
        this.p0 = parcelable.c;
        this.w0 = parcelable.v;
    }

    @Override // androidx.appcompat.widget.Toolbar
    protected Parcelable onSaveInstanceState() {
        BottomAppBar.h hVar = new BottomAppBar.h(super.onSaveInstanceState());
        hVar.c = this.p0;
        hVar.v = this.w0;
        return hVar;
    }

    @Override // androidx.appcompat.widget.Toolbar
    protected int p0(ActionMenuView actionMenuView, int i2, boolean z3) {
        int i;
        View childAt;
        int i4;
        boolean z;
        int i3;
        int obj7;
        int obj8;
        int obj9;
        final int i5 = 1;
        final int i6 = 0;
        if (i2 == i5) {
            if (!z3) {
            } else {
                obj8 = n.e(this);
                if (obj8 != null) {
                    obj9 = getMeasuredWidth();
                } else {
                    obj9 = i6;
                }
                i = i6;
                while (i < getChildCount()) {
                    childAt = getChildAt(i);
                    if (layoutParams instanceof Toolbar.e && i7 &= i8 == 8388611) {
                    } else {
                    }
                    i4 = i6;
                    if (i4 != 0) {
                    }
                    i++;
                    if (obj8 != null) {
                    } else {
                    }
                    obj9 = Math.max(obj9, childAt.getRight());
                    obj9 = Math.min(obj9, childAt.getLeft());
                    if (i7 &= i8 == 8388611) {
                    } else {
                    }
                    i4 = i5;
                }
                if (obj8 != null) {
                    obj7 = actionMenuView.getRight();
                } else {
                    obj7 = actionMenuView.getLeft();
                }
                obj8 = obj8 != null ? this.z0 : -obj8;
            }
            return obj9 -= obj7;
        }
        return i6;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setBackgroundTint(ColorStateList colorStateList) {
        a.o(this.m0, colorStateList);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setCradleVerticalOffset(float f) {
        int topEdgeTreatment;
        float obj2;
        if (Float.compare(f, cradleVerticalOffset) != 0) {
            getTopEdgeTreatment().h(f);
            this.m0.invalidateSelf();
            x0();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setElevation(float f) {
        this.m0.Y(f);
        getBehavior().e(this, obj2 -= i);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setFabAlignmentMode(int i) {
        y0(i, 0);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setFabAnimationMode(int i) {
        this.q0 = i;
    }

    @Override // androidx.appcompat.widget.Toolbar
    void setFabCornerSize(float f) {
        int topEdgeTreatment;
        float obj2;
        if (Float.compare(f, f2) != 0) {
            getTopEdgeTreatment().j(f);
            this.m0.invalidateSelf();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setFabCradleMargin(float f) {
        int topEdgeTreatment;
        float obj2;
        if (Float.compare(f, fabCradleMargin) != 0) {
            getTopEdgeTreatment().k(f);
            this.m0.invalidateSelf();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setFabCradleRoundedCornerRadius(float f) {
        int topEdgeTreatment;
        float obj2;
        if (Float.compare(f, fabCradleRoundedCornerRadius) != 0) {
            getTopEdgeTreatment().l(f);
            this.m0.invalidateSelf();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setHideOnScroll(boolean z) {
        this.r0 = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(u0(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIconTint(int i) {
        this.k0 = Integer.valueOf(i);
        Drawable obj1 = getNavigationIcon();
        if (obj1 != null) {
            setNavigationIcon(obj1);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(java.lang.CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(java.lang.CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void v0(int i) {
        Menu menu;
        if (i != 0) {
            this.u0 = 0;
            getMenu().clear();
            x(i);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void y0(int i, int i2) {
        this.u0 = i2;
        s0(i, this.w0);
        t0(i);
        this.p0 = i;
    }

    @Override // androidx.appcompat.widget.Toolbar
    boolean z0(int i) {
        float obj2 = (float)i;
        if (Float.compare(obj2, f) != 0) {
            getTopEdgeTreatment().m(obj2);
            this.m0.invalidateSelf();
            return 1;
        }
        return 0;
    }
}
