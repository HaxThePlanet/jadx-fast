package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.b;
import d.h.l.u;
import f.c.a.e.l;
import f.c.a.e.m.h;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    private int K;
    private final com.google.android.material.floatingactionbutton.d L;
    private final com.google.android.material.floatingactionbutton.d M;
    private final com.google.android.material.floatingactionbutton.d N;
    private final com.google.android.material.floatingactionbutton.d O;
    private final int P;
    private final CoordinatorLayout.c<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton> Q;
    private boolean R;
    private boolean S;
    private boolean T;

    class a extends AnimatorListenerAdapter {

        private boolean a;
        final com.google.android.material.floatingactionbutton.d b;
        final com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f c;
        a(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.d d2, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f extendedFloatingActionButton$f3) {
            this.b = d2;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.a = true;
            this.b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f num;
            boolean obj2;
            this.b.e();
            if (!this.a) {
                this.b.i(this.c);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.b.onAnimationStart(animator);
            this.a = false;
        }
    }

    static class b extends Property<View, Float> {
        b(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Float a(View view) {
            return Float.valueOf((float)obj1);
        }

        @Override // android.util.Property
        public void b(View view, Float float2) {
            layoutParams.width = float2.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((View)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((View)object, (Float)object2);
        }
    }

    static class c extends Property<View, Float> {
        c(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Float a(View view) {
            return Float.valueOf((float)obj1);
        }

        @Override // android.util.Property
        public void b(View view, Float float2) {
            layoutParams.height = float2.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((View)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((View)object, (Float)object2);
        }
    }

    static class d extends Property<View, Float> {
        d(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Float a(View view) {
            return Float.valueOf((float)obj1);
        }

        @Override // android.util.Property
        public void b(View view, Float float2) {
            u.y0(view, float2.intValue(), view.getPaddingTop(), u.F(view), view.getPaddingBottom());
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((View)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((View)object, (Float)object2);
        }
    }

    static class e extends Property<View, Float> {
        e(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Float a(View view) {
            return Float.valueOf((float)obj1);
        }

        @Override // android.util.Property
        public void b(View view, Float float2) {
            u.y0(view, u.G(view), view.getPaddingTop(), float2.intValue(), view.getPaddingBottom());
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((View)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((View)object, (Float)object2);
        }
    }

    public static abstract class f {
    }

    protected static class ExtendedFloatingActionButtonBehavior extends CoordinatorLayout.c<T> {

        private Rect a;
        private com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f b;
        private com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f c;
        private boolean d;
        private boolean e;
        public ExtendedFloatingActionButtonBehavior() {
            super();
            this.d = false;
            this.e = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, l.q1);
            this.d = obj2.getBoolean(l.r1, false);
            this.e = obj2.getBoolean(l.s1, true);
            obj2.recycle();
        }

        private static boolean c(View view) {
            android.view.ViewGroup.LayoutParams obj1 = view.getLayoutParams();
            if (obj1 instanceof CoordinatorLayout.f) {
                return obj1 instanceof BottomSheetBehavior;
            }
            return 0;
        }

        private boolean f(View view, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton2) {
            boolean z;
            final int i = 0;
            if (!this.d && !this.e) {
                if (!this.e) {
                    return i;
                }
            }
            if ((CoordinatorLayout.f)extendedFloatingActionButton2.getLayoutParams().e() != view.getId()) {
                return i;
            }
            return 1;
        }

        private boolean h(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout2, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton3) {
            Rect rect;
            if (!f(appBarLayout2, extendedFloatingActionButton3)) {
                return 0;
            }
            if (this.a == null) {
                rect = new Rect();
                this.a = rect;
            }
            Rect rect2 = this.a;
            b.a(coordinatorLayout, appBarLayout2, rect2);
            if (rect2.bottom <= appBarLayout2.getMinimumHeightForVisibleOverlappingContent()) {
                g(extendedFloatingActionButton3);
            } else {
                a(extendedFloatingActionButton3);
            }
            return 1;
        }

        private boolean i(View view, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton2) {
            if (!f(view, extendedFloatingActionButton2)) {
                return 0;
            }
            if (view.getTop() < i += topMargin) {
                g(extendedFloatingActionButton2);
            } else {
                a(extendedFloatingActionButton2);
            }
            return 1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        protected void a(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            com.google.android.material.floatingactionbutton.d dVar;
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f num;
            boolean z = this.e;
            num = z ? this.c : this.b;
            if (z) {
                dVar = ExtendedFloatingActionButton.p(extendedFloatingActionButton);
            } else {
                dVar = ExtendedFloatingActionButton.q(extendedFloatingActionButton);
            }
            ExtendedFloatingActionButton.o(extendedFloatingActionButton, dVar, num);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean b(CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton2, Rect rect3) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton2, rect3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean d(CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton2, View view3) {
            CoordinatorLayout obj2;
            if (view3 instanceof AppBarLayout) {
                h(coordinatorLayout, (AppBarLayout)view3, extendedFloatingActionButton2);
            } else {
                if (ExtendedFloatingActionButton.ExtendedFloatingActionButtonBehavior.c(view3)) {
                    i(view3, extendedFloatingActionButton2);
                }
            }
            return 0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean e(CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton2, int i3) {
            int i;
            boolean z;
            boolean z2;
            final List dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton2);
            i = 0;
            while (i < dependencies.size()) {
                z = dependencies.get(i);
                i++;
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton2, i3);
            return 1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        protected void g(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
            com.google.android.material.floatingactionbutton.d dVar;
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f num;
            boolean z = this.e;
            num = z ? this.c : this.b;
            if (z) {
                dVar = ExtendedFloatingActionButton.m(extendedFloatingActionButton);
            } else {
                dVar = ExtendedFloatingActionButton.n(extendedFloatingActionButton);
            }
            ExtendedFloatingActionButton.o(extendedFloatingActionButton, dVar, num);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view2, Rect rect3) {
            return b(coordinatorLayout, (ExtendedFloatingActionButton)view2, rect3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public void onAttachedToLayoutParams(CoordinatorLayout.f coordinatorLayout$f) {
            int i;
            if (f.h == 0) {
                f.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            return d(coordinatorLayout, (ExtendedFloatingActionButton)view2, view3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view2, int i3) {
            return e(coordinatorLayout, (ExtendedFloatingActionButton)view2, i3);
        }
    }
    static {
        final Class<Float> obj = Float.class;
        ExtendedFloatingActionButton.b bVar = new ExtendedFloatingActionButton.b(obj, "width");
        ExtendedFloatingActionButton.c cVar = new ExtendedFloatingActionButton.c(obj, "height");
        ExtendedFloatingActionButton.d dVar = new ExtendedFloatingActionButton.d(obj, "paddingStart");
        ExtendedFloatingActionButton.e eVar = new ExtendedFloatingActionButton.e(obj, "paddingEnd");
    }

    static com.google.android.material.floatingactionbutton.d m(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.L;
    }

    static com.google.android.material.floatingactionbutton.d n(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.O;
    }

    static void o(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.d d2, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f extendedFloatingActionButton$f3) {
        extendedFloatingActionButton.s(d2, f3);
    }

    static com.google.android.material.floatingactionbutton.d p(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.M;
    }

    static com.google.android.material.floatingactionbutton.d q(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.N;
    }

    private boolean r() {
        int i;
        i = 0;
        final int i4 = 1;
        if (getVisibility() != 0 && this.K == 2) {
            if (this.K == 2) {
                i = i4;
            }
            return i;
        }
        if (this.K != i4) {
            i = i4;
        }
        return i;
    }

    private void s(com.google.android.material.floatingactionbutton.d d, com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f extendedFloatingActionButton$f2) {
        com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f obj4;
        if (d.d()) {
        }
        if (!u()) {
            d.b();
            d.i(f2);
        }
        int i = 0;
        measure(i, i);
        android.animation.AnimatorSet set = d.g();
        ExtendedFloatingActionButton.a aVar = new ExtendedFloatingActionButton.a(this, d, f2);
        set.addListener(aVar);
        Iterator obj3 = d.h().iterator();
        for (Animator.AnimatorListener obj4 : obj3) {
            set.addListener(obj4);
        }
        set.start();
    }

    private void t() {
        getTextColors();
    }

    private boolean u() {
        boolean inEditMode;
        int i;
        if (!u.R(this)) {
            if (!r() && this.T && !isInEditMode()) {
                if (this.T) {
                    i = !isInEditMode() ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public CoordinatorLayout.c<com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton> getBehavior() {
        return this.Q;
    }

    @Override // com.google.android.material.button.MaterialButton
    int getCollapsedPadding() {
        return i /= 2;
    }

    @Override // com.google.android.material.button.MaterialButton
    int getCollapsedSize() {
        int i;
        int iconSize;
        if (this.P < 0) {
            i4 += iconSize;
        }
        return i;
    }

    @Override // com.google.android.material.button.MaterialButton
    public h getExtendMotionSpec() {
        return this.M.c();
    }

    @Override // com.google.android.material.button.MaterialButton
    public h getHideMotionSpec() {
        return this.O.c();
    }

    @Override // com.google.android.material.button.MaterialButton
    public h getShowMotionSpec() {
        return this.N.c();
    }

    @Override // com.google.android.material.button.MaterialButton
    public h getShrinkMotionSpec() {
        return this.L.c();
    }

    @Override // com.google.android.material.button.MaterialButton
    protected void onAttachedToWindow() {
        boolean empty;
        super.onAttachedToWindow();
        if (this.R && TextUtils.isEmpty(getText()) && getIcon() != null) {
            if (TextUtils.isEmpty(getText())) {
                if (getIcon() != null) {
                    this.R = false;
                    this.L.b();
                }
            }
        }
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setAnimateShowBeforeLayout(boolean z) {
        this.T = z;
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setExtendMotionSpec(h h) {
        this.M.f(h);
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(h.c(getContext(), i));
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setExtended(boolean z) {
        com.google.android.material.floatingactionbutton.d obj2;
        if (this.R == z) {
        }
        obj2 = z ? this.M : this.L;
        if (obj2.d()) {
        }
        obj2.b();
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setHideMotionSpec(h h) {
        this.O.f(h);
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(h.c(getContext(), i));
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setPadding(int i, int i2, int i3, int i4) {
        boolean obj1;
        super.setPadding(i, i2, i3, i4);
        if (this.R && !this.S) {
            if (!this.S) {
                u.G(this);
                u.F(this);
            }
        }
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        boolean obj1;
        super.setPaddingRelative(i, i2, i3, i4);
        if (this.R) {
            obj1 = this.S;
        }
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setShowMotionSpec(h h) {
        this.N.f(h);
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(h.c(getContext(), i));
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setShrinkMotionSpec(h h) {
        this.L.f(h);
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(h.c(getContext(), i));
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setTextColor(int i) {
        super.setTextColor(i);
        t();
    }

    @Override // com.google.android.material.button.MaterialButton
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        t();
    }
}
