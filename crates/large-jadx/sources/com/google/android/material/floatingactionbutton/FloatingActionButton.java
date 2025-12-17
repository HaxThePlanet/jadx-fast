package com.google.android.material.floatingactionbutton;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.l;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.n;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.b;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.internal.o;
import com.google.android.material.theme.a.a;
import d.e.g;
import d.h.k.i;
import d.h.l.t;
import d.h.l.u;
import d.j.a.a;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.c0.b;
import f.c.a.e.d;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.d0.n;
import f.c.a.e.e0.a;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.m.h;
import f.c.a.e.m.k;
import f.c.a.e.v.a;
import f.c.a.e.v.b;
import java.util.List;

/* loaded from: classes2.dex */
public class FloatingActionButton extends o implements t, n, a, n, CoordinatorLayout.b {

    private static final int J;
    private int A;
    private int B;
    private int C;
    boolean D;
    final Rect E;
    private final Rect F;
    private final l G;
    private final b H;
    private com.google.android.material.floatingactionbutton.b I;
    private ColorStateList b;
    private PorterDuff.Mode c;
    private ColorStateList v;
    private PorterDuff.Mode w;
    private ColorStateList x;
    private int y;
    private int z;

    public static abstract class b {
        public void a(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
        }

        public void b(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
        }
    }

    protected static class BaseBehavior extends CoordinatorLayout.c<T> {

        private Rect a;
        private com.google.android.material.floatingactionbutton.FloatingActionButton.b b;
        private boolean c;
        public BaseBehavior() {
            super();
            this.c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
            final TypedArray obj2 = context.obtainStyledAttributes(attributeSet2, l.J1);
            this.c = obj2.getBoolean(l.K1, true);
            obj2.recycle();
        }

        private static boolean b(View view) {
            android.view.ViewGroup.LayoutParams obj1 = view.getLayoutParams();
            if (obj1 instanceof CoordinatorLayout.f) {
                return obj1 instanceof BottomSheetBehavior;
            }
            return 0;
        }

        private void c(CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton2) {
            android.view.ViewGroup.LayoutParams layoutParams;
            int right;
            int leftMargin;
            int bottom;
            int bottom2;
            int bottomMargin;
            int obj7;
            final Rect rect = floatingActionButton2.E;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                if (rect.centerX() > 0) {
                    if (rect.centerY() > 0) {
                        layoutParams = floatingActionButton2.getLayoutParams();
                        right = floatingActionButton2.getRight() >= width -= rightMargin ? rect.right : left <= leftMargin ? -left2 : bottom2;
                        if (floatingActionButton2.getBottom() >= obj7 -= bottomMargin) {
                            bottom2 = rect.bottom;
                        } else {
                            if (floatingActionButton2.getTop() <= layoutParams.topMargin) {
                                bottom2 = -obj7;
                            }
                        }
                        if (bottom2 != 0) {
                            u.X(floatingActionButton2, bottom2);
                        }
                        if (right != 0) {
                            u.W(floatingActionButton2, right);
                        }
                    }
                }
            }
        }

        private boolean f(View view, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton2) {
            final int i2 = 0;
            if (!this.c) {
                return i2;
            }
            if ((CoordinatorLayout.f)floatingActionButton2.getLayoutParams().e() != view.getId()) {
                return i2;
            }
            if (floatingActionButton2.getUserSetVisibility() != 0) {
                return i2;
            }
            return 1;
        }

        private boolean g(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout2, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton3) {
            Rect rect;
            com.google.android.material.floatingactionbutton.FloatingActionButton.b obj3;
            final int i = 0;
            if (!f(appBarLayout2, floatingActionButton3)) {
                return i;
            }
            if (this.a == null) {
                rect = new Rect();
                this.a = rect;
            }
            Rect rect2 = this.a;
            b.a(coordinatorLayout, appBarLayout2, rect2);
            if (rect2.bottom <= appBarLayout2.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton3.n(this.b, i);
            } else {
                floatingActionButton3.v(this.b, i);
            }
            return 1;
        }

        private boolean h(View view, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton2) {
            com.google.android.material.floatingactionbutton.FloatingActionButton.b obj4;
            final int i = 0;
            if (!f(view, floatingActionButton2)) {
                return i;
            }
            if (view.getTop() < i2 += topMargin) {
                floatingActionButton2.n(this.b, i);
            } else {
                floatingActionButton2.v(this.b, i);
            }
            return 1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean a(CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton2, Rect rect3) {
            Rect obj5 = floatingActionButton2.E;
            rect3.set(left += left2, top += top2, right -= right2, obj6 -= obj5);
            return 1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean d(CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton2, View view3) {
            CoordinatorLayout obj2;
            if (view3 instanceof AppBarLayout) {
                g(coordinatorLayout, (AppBarLayout)view3, floatingActionButton2);
            } else {
                if (FloatingActionButton.BaseBehavior.b(view3)) {
                    h(view3, floatingActionButton2);
                }
            }
            return 0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean e(CoordinatorLayout coordinatorLayout, com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton2, int i3) {
            int i;
            boolean z;
            boolean z2;
            final List dependencies = coordinatorLayout.getDependencies(floatingActionButton2);
            i = 0;
            while (i < dependencies.size()) {
                z = dependencies.get(i);
                i++;
            }
            coordinatorLayout.onLayoutChild(floatingActionButton2, i3);
            c(coordinatorLayout, floatingActionButton2);
            return 1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view2, Rect rect3) {
            return a(coordinatorLayout, (FloatingActionButton)view2, rect3);
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
            return d(coordinatorLayout, (FloatingActionButton)view2, view3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$c
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view2, int i3) {
            return e(coordinatorLayout, (FloatingActionButton)view2, i3);
        }
    }

    class a implements com.google.android.material.floatingactionbutton.b.k {

        final com.google.android.material.floatingactionbutton.FloatingActionButton.b a;
        final com.google.android.material.floatingactionbutton.FloatingActionButton b;
        a(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, com.google.android.material.floatingactionbutton.FloatingActionButton.b floatingActionButton$b2) {
            this.b = floatingActionButton;
            this.a = b2;
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.b$k
        public void a() {
            this.a.b(this.b);
        }

        @Override // com.google.android.material.floatingactionbutton.b$k
        public void b() {
            this.a.a(this.b);
        }
    }

    private class c implements b {

        final com.google.android.material.floatingactionbutton.FloatingActionButton a;
        c(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
            this.a = floatingActionButton;
            super();
        }

        @Override // f.c.a.e.c0.b
        public void a(int i, int i2, int i3, int i4) {
            num.E.set(i, i2, i3, i4);
            com.google.android.material.floatingactionbutton.FloatingActionButton num2 = this.a;
            num2.setPadding(i += i5, i2 += i6, i3 += i7, i4 += i8);
        }

        @Override // f.c.a.e.c0.b
        public boolean b() {
            return num.D;
        }

        @Override // f.c.a.e.c0.b
        public void c(Drawable drawable) {
            com.google.android.material.floatingactionbutton.FloatingActionButton num;
            if (drawable != null) {
                FloatingActionButton.d(this.a, drawable);
            }
        }
    }

    class d implements com.google.android.material.floatingactionbutton.b.j {

        private final k<T> a;
        final com.google.android.material.floatingactionbutton.FloatingActionButton b;
        d(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, k k2) {
            this.b = floatingActionButton;
            super();
            this.a = k2;
        }

        @Override // com.google.android.material.floatingactionbutton.b$j
        public void a() {
            this.a.b(this.b);
        }

        @Override // com.google.android.material.floatingactionbutton.b$j
        public void b() {
            this.a.a(this.b);
        }

        @Override // com.google.android.material.floatingactionbutton.b$j
        public boolean equals(Object object) {
            boolean z;
            Object obj2;
            if (object instanceof FloatingActionButton.d && object.a.equals(this.a)) {
                obj2 = object.a.equals(this.a) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // com.google.android.material.floatingactionbutton.b$j
        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static class Behavior extends com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior<com.google.android.material.floatingactionbutton.FloatingActionButton> {
        public Behavior(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
        }
    }
    static {
        FloatingActionButton.J = k.k;
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.w);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet2, int i3) {
        int i12 = FloatingActionButton.J;
        super(a.c(context, attributeSet2, i3, i12), attributeSet2, i3);
        Rect obj11 = new Rect();
        this.E = obj11;
        obj11 = new Rect();
        this.F = obj11;
        obj11 = getContext();
        int i14 = 0;
        TypedArray typedArray = l.h(obj11, attributeSet2, l.t1, i3, i12, new int[i14]);
        this.b = c.a(obj11, typedArray, l.v1);
        int i6 = -1;
        this.c = n.f(typedArray.getInt(l.w1, i6), 0);
        this.x = c.a(obj11, typedArray, l.G1);
        this.z = typedArray.getInt(l.B1, i6);
        this.A = typedArray.getDimensionPixelSize(l.A1, i14);
        this.y = typedArray.getDimensionPixelSize(l.x1, i14);
        int i7 = 0;
        this.D = typedArray.getBoolean(l.I1, i14);
        setMaxImageSize(typedArray.getDimensionPixelSize(l.E1, i14));
        setEnabled(typedArray.getBoolean(l.u1, true));
        typedArray.recycle();
        l lVar = new l(this);
        this.G = lVar;
        lVar.f(attributeSet2, i3);
        b obj12 = new b(this);
        this.H = obj12;
        getImpl().X(k.g(obj11, attributeSet2, i3, i12, k.m).m());
        getImpl().x(this.b, this.c, this.x, this.y);
        getImpl().T(getResources().getDimensionPixelSize(d.e0));
        getImpl().N(typedArray.getDimension(l.y1, i7));
        getImpl().Q(typedArray.getDimension(l.D1, i7));
        getImpl().U(typedArray.getDimension(l.F1, i7));
        getImpl().Y(h.b(obj11, typedArray, l.H1));
        getImpl().P(h.b(obj11, typedArray, l.C1));
        getImpl().O(typedArray.getBoolean(l.z1, i14));
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    static int c(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton) {
        return floatingActionButton.B;
    }

    static void d(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
    }

    private com.google.android.material.floatingactionbutton.b getImpl() {
        com.google.android.material.floatingactionbutton.b bVar;
        if (this.I == null) {
            this.I = h();
        }
        return this.I;
    }

    private com.google.android.material.floatingactionbutton.b h() {
        if (Build.VERSION.SDK_INT >= 21) {
            FloatingActionButton.c cVar2 = new FloatingActionButton.c(this);
            c cVar = new c(this, cVar2);
            return cVar;
        }
        FloatingActionButton.c cVar3 = new FloatingActionButton.c(this);
        b bVar = new b(this, cVar3);
        return bVar;
    }

    private int k(int i) {
        int obj4;
        int i2 = this.A;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        final int i5 = 1;
        if (i != -1 && i != i5) {
            if (i != i5) {
                return resources.getDimensionPixelSize(d.j);
            }
            return resources.getDimensionPixelSize(d.i);
        }
        if (Math.max(obj4.screenWidthDp, configuration.screenHeightDp) < 470) {
            obj4 = k(i5);
        } else {
            obj4 = k(0);
        }
        return obj4;
    }

    private void q(Rect rect) {
        Rect rect2 = this.E;
        rect.left = left += left2;
        rect.top = top += top2;
        rect.right = right -= right2;
        rect.bottom = bottom -= bottom2;
    }

    private void r() {
        PorterDuff.Mode sRC_IN;
        Drawable drawable = getDrawable();
        if (drawable == null) {
        }
        ColorStateList list = this.v;
        if (list == null) {
            a.c(drawable);
        }
        if (this.w == null) {
            sRC_IN = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(i.e(list.getColorForState(getDrawableState(), 0), sRC_IN));
    }

    private static int s(int i, int i2) {
        int obj2;
        final int mode = View.MeasureSpec.getMode(i2);
        final int obj3 = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                } else {
                    obj2 = obj3;
                }
                obj2 = new IllegalArgumentException();
                throw obj2;
            }
        } else {
            obj2 = Math.min(i, obj3);
        }
        return obj2;
    }

    private com.google.android.material.floatingactionbutton.b.k w(com.google.android.material.floatingactionbutton.FloatingActionButton.b floatingActionButton$b) {
        if (b == null) {
            return null;
        }
        FloatingActionButton.a aVar = new FloatingActionButton.a(this, b);
        return aVar;
    }

    @Override // com.google.android.material.internal.o
    public boolean a() {
        return this.H.c();
    }

    @Override // com.google.android.material.internal.o
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    @Override // com.google.android.material.internal.o
    public void e(Animator.AnimatorListener animator$AnimatorListener) {
        getImpl().e(animatorListener);
    }

    @Override // com.google.android.material.internal.o
    public void f(Animator.AnimatorListener animator$AnimatorListener) {
        getImpl().f(animatorListener);
    }

    public void g(k<? extends com.google.android.material.floatingactionbutton.FloatingActionButton> k) {
        FloatingActionButton.d dVar = new FloatingActionButton.d(this, k);
        getImpl().g(dVar);
    }

    @Override // com.google.android.material.internal.o
    public ColorStateList getBackgroundTintList() {
        return this.b;
    }

    @Override // com.google.android.material.internal.o
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.c;
    }

    public CoordinatorLayout.c<com.google.android.material.floatingactionbutton.FloatingActionButton> getBehavior() {
        FloatingActionButton.Behavior behavior = new FloatingActionButton.Behavior();
        return behavior;
    }

    @Override // com.google.android.material.internal.o
    public float getCompatElevation() {
        return getImpl().n();
    }

    @Override // com.google.android.material.internal.o
    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    @Override // com.google.android.material.internal.o
    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    @Override // com.google.android.material.internal.o
    public Drawable getContentBackground() {
        return getImpl().m();
    }

    @Override // com.google.android.material.internal.o
    public int getCustomSize() {
        return this.A;
    }

    @Override // com.google.android.material.internal.o
    public int getExpandedComponentIdHint() {
        return this.H.b();
    }

    @Override // com.google.android.material.internal.o
    public h getHideMotionSpec() {
        return getImpl().p();
    }

    @Deprecated
    public int getRippleColor() {
        int defaultColor;
        ColorStateList list = this.x;
        if (list != null) {
            defaultColor = list.getDefaultColor();
        } else {
            defaultColor = 0;
        }
        return defaultColor;
    }

    @Override // com.google.android.material.internal.o
    public ColorStateList getRippleColorStateList() {
        return this.x;
    }

    @Override // com.google.android.material.internal.o
    public k getShapeAppearanceModel() {
        k kVar = getImpl().u();
        i.c(kVar);
        return (k)kVar;
    }

    @Override // com.google.android.material.internal.o
    public h getShowMotionSpec() {
        return getImpl().v();
    }

    @Override // com.google.android.material.internal.o
    public int getSize() {
        return this.z;
    }

    @Override // com.google.android.material.internal.o
    int getSizeDimension() {
        return k(this.z);
    }

    @Override // com.google.android.material.internal.o
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // com.google.android.material.internal.o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // com.google.android.material.internal.o
    public ColorStateList getSupportImageTintList() {
        return this.v;
    }

    @Override // com.google.android.material.internal.o
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.w;
    }

    @Override // com.google.android.material.internal.o
    public boolean getUseCompatPadding() {
        return this.D;
    }

    @Deprecated
    public boolean i(Rect rect) {
        final int i = 0;
        if (u.R(this)) {
            rect.set(i, i, getWidth(), getHeight());
            q(rect);
            return 1;
        }
        return i;
    }

    @Override // com.google.android.material.internal.o
    public void j(Rect rect) {
        final int i = 0;
        rect.set(i, i, getMeasuredWidth(), getMeasuredHeight());
        q(rect);
    }

    @Override // com.google.android.material.internal.o
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    @Override // com.google.android.material.internal.o
    public void l() {
        m(0);
    }

    @Override // com.google.android.material.internal.o
    public void m(com.google.android.material.floatingactionbutton.FloatingActionButton.b floatingActionButton$b) {
        n(b, true);
    }

    @Override // com.google.android.material.internal.o
    void n(com.google.android.material.floatingactionbutton.FloatingActionButton.b floatingActionButton$b, boolean z2) {
        getImpl().w(w(b), z2);
    }

    @Override // com.google.android.material.internal.o
    public boolean o() {
        return getImpl().y();
    }

    @Override // com.google.android.material.internal.o
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    @Override // com.google.android.material.internal.o
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    @Override // com.google.android.material.internal.o
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.B = i6 /= 2;
        getImpl().f0();
        int obj3 = Math.min(FloatingActionButton.s(sizeDimension, i), FloatingActionButton.s(sizeDimension, i2));
        Rect obj4 = this.E;
        setMeasuredDimension(i3 += right, obj3 += obj4);
    }

    @Override // com.google.android.material.internal.o
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable instanceof a) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((a)parcelable.a());
        Object obj3 = parcelable.c.get("expandableWidgetHelper");
        i.c(obj3);
        this.H.d((Bundle)obj3);
    }

    @Override // com.google.android.material.internal.o
    protected Parcelable onSaveInstanceState() {
        Object onSaveInstanceState;
        if (super.onSaveInstanceState() == null) {
            onSaveInstanceState = new Bundle();
        }
        a aVar = new a(onSaveInstanceState);
        aVar.c.put("expandableWidgetHelper", this.H.e());
        return aVar;
    }

    @Override // com.google.android.material.internal.o
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int contains;
        int i;
        int i2;
        if (motionEvent.getAction() == 0 && i(this.F) && !this.F.contains((int)f, (int)f2)) {
            if (i(this.F)) {
                if (!this.F.contains((int)f, (int)f2)) {
                    return 0;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.google.android.material.internal.o
    public boolean p() {
        return getImpl().z();
    }

    @Override // com.google.android.material.internal.o
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // com.google.android.material.internal.o
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // com.google.android.material.internal.o
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // com.google.android.material.internal.o
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Object impl;
        if (this.b != colorStateList) {
            this.b = colorStateList;
            getImpl().L(colorStateList);
        }
    }

    @Override // com.google.android.material.internal.o
    public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        Object impl;
        if (this.c != mode) {
            this.c = mode;
            getImpl().M(mode);
        }
    }

    @Override // com.google.android.material.internal.o
    public void setCompatElevation(float f) {
        getImpl().N(f);
    }

    @Override // com.google.android.material.internal.o
    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    @Override // com.google.android.material.internal.o
    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().Q(f);
    }

    @Override // com.google.android.material.internal.o
    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    @Override // com.google.android.material.internal.o
    public void setCompatPressedTranslationZ(float f) {
        getImpl().U(f);
    }

    @Override // com.google.android.material.internal.o
    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    @Override // com.google.android.material.internal.o
    public void setCustomSize(int i) {
        if (i < 0) {
        } else {
            if (i != this.A) {
                this.A = i;
                requestLayout();
            }
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Custom size must be non-negative");
        throw obj2;
    }

    @Override // com.google.android.material.internal.o
    public void setElevation(float f) {
        super.setElevation(f);
        getImpl().g0(f);
    }

    @Override // com.google.android.material.internal.o
    public void setEnsureMinTouchTargetSize(boolean z) {
        boolean impl;
        if (z != getImpl().o()) {
            getImpl().O(z);
            requestLayout();
        }
    }

    @Override // com.google.android.material.internal.o
    public void setExpandedComponentIdHint(int i) {
        this.H.f(i);
    }

    @Override // com.google.android.material.internal.o
    public void setHideMotionSpec(h h) {
        getImpl().P(h);
    }

    @Override // com.google.android.material.internal.o
    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(h.c(getContext(), i));
    }

    @Override // com.google.android.material.internal.o
    public void setImageDrawable(Drawable drawable) {
        Object obj2;
        super.setImageDrawable(drawable);
        getImpl().e0();
        if (getDrawable() != drawable && this.v != null) {
            super.setImageDrawable(drawable);
            getImpl().e0();
            if (this.v != null) {
                r();
            }
        }
    }

    @Override // com.google.android.material.internal.o
    public void setImageResource(int i) {
        this.G.g(i);
        r();
    }

    @Override // com.google.android.material.internal.o
    public void setMaxImageSize(int i) {
        this.C = i;
        getImpl().S(i);
    }

    @Override // com.google.android.material.internal.o
    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    @Override // com.google.android.material.internal.o
    public void setRippleColor(ColorStateList colorStateList) {
        ColorStateList list;
        Object obj2;
        if (this.x != colorStateList) {
            this.x = colorStateList;
            getImpl().V(this.x);
        }
    }

    @Override // com.google.android.material.internal.o
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().I();
    }

    @Override // com.google.android.material.internal.o
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().I();
    }

    @Override // com.google.android.material.internal.o
    public void setShadowPaddingEnabled(boolean z) {
        getImpl().W(z);
    }

    @Override // com.google.android.material.internal.o
    public void setShapeAppearanceModel(k k) {
        getImpl().X(k);
    }

    @Override // com.google.android.material.internal.o
    public void setShowMotionSpec(h h) {
        getImpl().Y(h);
    }

    @Override // com.google.android.material.internal.o
    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(h.c(getContext(), i));
    }

    @Override // com.google.android.material.internal.o
    public void setSize(int i) {
        this.A = 0;
        if (i != this.z) {
            this.z = i;
            requestLayout();
        }
    }

    @Override // com.google.android.material.internal.o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // com.google.android.material.internal.o
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        setBackgroundTintMode(mode);
    }

    @Override // com.google.android.material.internal.o
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            r();
        }
    }

    @Override // com.google.android.material.internal.o
    public void setSupportImageTintMode(PorterDuff.Mode porterDuff$Mode) {
        if (this.w != mode) {
            this.w = mode;
            r();
        }
    }

    @Override // com.google.android.material.internal.o
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().J();
    }

    @Override // com.google.android.material.internal.o
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().J();
    }

    @Override // com.google.android.material.internal.o
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().J();
    }

    @Override // com.google.android.material.internal.o
    public void setUseCompatPadding(boolean z) {
        boolean obj2;
        if (this.D != z) {
            this.D = z;
            getImpl().C();
        }
    }

    @Override // com.google.android.material.internal.o
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // com.google.android.material.internal.o
    public void t() {
        u(0);
    }

    @Override // com.google.android.material.internal.o
    public void u(com.google.android.material.floatingactionbutton.FloatingActionButton.b floatingActionButton$b) {
        v(b, true);
    }

    @Override // com.google.android.material.internal.o
    void v(com.google.android.material.floatingactionbutton.FloatingActionButton.b floatingActionButton$b, boolean z2) {
        getImpl().c0(w(b), z2);
    }
}
