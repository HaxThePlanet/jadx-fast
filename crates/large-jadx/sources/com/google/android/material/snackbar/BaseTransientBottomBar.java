package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import androidx.core.graphics.drawable.a;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.behavior.SwipeDismissBehavior.c;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.theme.a.a;
import d.h.l.a;
import d.h.l.d0;
import d.h.l.e0.c;
import d.h.l.q;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.h;
import f.c.a.e.l;
import f.c.a.e.m.a;
import f.c.a.e.r.a;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends com.google.android.material.snackbar.BaseTransientBottomBar<B>>  {

    static final Handler t;
    private static final boolean u = false;
    private static final int[] v;
    private static final String w;
    private final ViewGroup a;
    private final Context b;
    protected final com.google.android.material.snackbar.BaseTransientBottomBar.w c;
    private final com.google.android.material.snackbar.a d;
    private int e;
    private boolean f;
    private com.google.android.material.snackbar.BaseTransientBottomBar.r g;
    private boolean h = false;
    private final Runnable i;
    private Rect j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private List<com.google.android.material.snackbar.BaseTransientBottomBar.s<B>> p;
    private com.google.android.material.snackbar.BaseTransientBottomBar.Behavior q;
    private final AccessibilityManager r;
    com.google.android.material.snackbar.b.b s;

    class a extends AnimatorListenerAdapter {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        a(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.a.M();
        }
    }

    class b extends AnimatorListenerAdapter {

        final int a;
        final com.google.android.material.snackbar.BaseTransientBottomBar b;
        b(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar, int i2) {
            this.b = baseTransientBottomBar;
            this.a = i2;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.b.L(this.a);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        c(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            baseTransientBottomBar.c.setAlpha((Float)valueAnimator.getAnimatedValue().floatValue());
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        d(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float obj2 = (Float)valueAnimator.getAnimatedValue().floatValue();
            baseTransientBottomBar.c.setScaleX(obj2);
            baseTransientBottomBar2.c.setScaleY(obj2);
        }
    }

    class e extends AnimatorListenerAdapter {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        e(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.a.M();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.e(this.a).a(70, 180);
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {

        private int a;
        final int b;
        final com.google.android.material.snackbar.BaseTransientBottomBar c;
        f(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar, int i2) {
            this.c = baseTransientBottomBar;
            this.b = i2;
            super();
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.google.android.material.snackbar.BaseTransientBottomBar.w wVar;
            int i;
            int obj3 = (Integer)valueAnimator.getAnimatedValue().intValue();
            if (BaseTransientBottomBar.f()) {
                u.X(baseTransientBottomBar.c, obj3 - i2);
            } else {
                baseTransientBottomBar2.c.setTranslationY((float)obj3);
            }
            this.a = obj3;
        }
    }

    class g extends AnimatorListenerAdapter {

        final int a;
        final com.google.android.material.snackbar.BaseTransientBottomBar b;
        g(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar, int i2) {
            this.b = baseTransientBottomBar;
            this.a = i2;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.b.L(this.a);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.e(this.b).b(0, 180);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {

        private int a = 0;
        final com.google.android.material.snackbar.BaseTransientBottomBar b;
        h(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.b = baseTransientBottomBar;
            super();
            final int obj1 = 0;
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            com.google.android.material.snackbar.BaseTransientBottomBar.w wVar;
            int i;
            int obj3 = (Integer)valueAnimator.getAnimatedValue().intValue();
            if (BaseTransientBottomBar.f()) {
                u.X(baseTransientBottomBar.c, obj3 - i2);
            } else {
                baseTransientBottomBar2.c.setTranslationY((float)obj3);
            }
            this.a = obj3;
        }
    }

    static class i implements Handler.Callback {
        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            int what = message.what;
            final int i = 1;
            if (what != 0 && what != i) {
                if (what != i) {
                    return 0;
                }
                (BaseTransientBottomBar)message.obj.I(message.arg1);
                return i;
            }
            (BaseTransientBottomBar)message.obj.U();
            return i;
        }
    }

    class j implements Runnable {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        j(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object baseTransientBottomBar;
            Object layoutParams;
            int i;
            int i2;
            baseTransientBottomBar = this.a;
            if (baseTransientBottomBar.c != null) {
                if (BaseTransientBottomBar.a(baseTransientBottomBar) == null) {
                } else {
                    i4 += i7;
                    if (i5 >= BaseTransientBottomBar.j(this.a)) {
                    }
                    layoutParams = baseTransientBottomBar7.c.getLayoutParams();
                    if (!layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        Log.w(BaseTransientBottomBar.l(), "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                    }
                    layoutParams.bottomMargin = bottomMargin += i2;
                    baseTransientBottomBar3.c.requestLayout();
                }
            }
        }
    }

    class q implements Runnable {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        q(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object parent;
            com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar;
            int i;
            com.google.android.material.snackbar.BaseTransientBottomBar.w wVar = baseTransientBottomBar2.c;
            if (wVar == null) {
            }
            if (wVar.getParent() != null) {
                baseTransientBottomBar3.c.setVisibility(0);
            }
            if (baseTransientBottomBar4.c.getAnimationMode() == 1) {
                BaseTransientBottomBar.c(this.a);
            } else {
                BaseTransientBottomBar.d(this.a);
            }
        }
    }

    static class r implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        private final WeakReference<com.google.android.material.snackbar.BaseTransientBottomBar> a;
        private final WeakReference<View> b;
        private r(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar, View view2) {
            super();
            WeakReference weakReference = new WeakReference(baseTransientBottomBar);
            this.a = weakReference;
            WeakReference obj2 = new WeakReference(view2);
            this.b = obj2;
        }

        static com.google.android.material.snackbar.BaseTransientBottomBar.r a(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar, View view2) {
            BaseTransientBottomBar.r rVar = new BaseTransientBottomBar.r(baseTransientBottomBar, view2);
            if (u.Q(view2)) {
                n.a(view2, rVar);
            }
            view2.addOnAttachStateChangeListener(rVar);
            return rVar;
        }

        private boolean d() {
            if (this.a.get() == null) {
                c();
                return 1;
            }
            return 0;
        }

        @Override // android.view.View$OnAttachStateChangeListener
        View b() {
            return (View)this.b.get();
        }

        @Override // android.view.View$OnAttachStateChangeListener
        void c() {
            Object obj;
            if (this.b.get() != null) {
                (View)this.b.get().removeOnAttachStateChangeListener(this);
                n.g((View)this.b.get(), this);
            }
            this.b.clear();
            this.a.clear();
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onGlobalLayout() {
            boolean z;
            if (!d()) {
                if (!BaseTransientBottomBar.g((BaseTransientBottomBar)this.a.get())) {
                } else {
                    BaseTransientBottomBar.h((BaseTransientBottomBar)this.a.get());
                }
            }
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (d()) {
            }
            n.a(view, this);
        }

        @Override // android.view.View$OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (d()) {
            }
            n.g(view, this);
        }
    }

    public static abstract class s {
        public void a(B b, int i2) {
        }

        public void b(B b) {
        }
    }

    public static class t {

        private com.google.android.material.snackbar.b.b a;
        public t(SwipeDismissBehavior<?> swipeDismissBehavior) {
            super();
            swipeDismissBehavior.h(1036831949);
            swipeDismissBehavior.f(1058642330);
            swipeDismissBehavior.i(0);
        }

        public boolean a(View view) {
            return view instanceof BaseTransientBottomBar.w;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view2, MotionEvent motionEvent3) {
            int actionMasked;
            boolean obj2;
            Object obj3;
            int obj4;
            actionMasked = motionEvent3.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1 && actionMasked != 3) {
                    if (actionMasked != 3) {
                    } else {
                        b.c().k(this.a);
                    }
                } else {
                }
            } else {
                if (coordinatorLayout.isPointInChildBounds(view2, (int)f, (int)obj4)) {
                    b.c().j(this.a);
                }
            }
        }

        public void c(com.google.android.material.snackbar.BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.s;
        }
    }

    protected interface u {
        public abstract void onViewAttachedToWindow(View view);

        public abstract void onViewDetachedFromWindow(View view);
    }

    protected interface v {
        public abstract void a(View view, int i2, int i3, int i4, int i5);
    }

    protected static class w extends FrameLayout {

        private static final View.OnTouchListener B;
        private PorterDuff.Mode A;
        private com.google.android.material.snackbar.BaseTransientBottomBar.v a;
        private com.google.android.material.snackbar.BaseTransientBottomBar.u b;
        private int c;
        private final float v;
        private final float w;
        private final int x;
        private final int y;
        private ColorStateList z;
        static {
            BaseTransientBottomBar.w.a aVar = new BaseTransientBottomBar.w.a();
            BaseTransientBottomBar.w.B = aVar;
        }

        protected w(Context context, AttributeSet attributeSet2) {
            int i;
            Drawable obj4;
            int i2 = 0;
            super(a.c(context, attributeSet2, i2, i2), attributeSet2);
            obj4 = getContext();
            final TypedArray obj5 = obj4.obtainStyledAttributes(attributeSet2, l.j4);
            i = l.q4;
            if (obj5.hasValue(i)) {
                u.s0(this, (float)dimensionPixelSize);
            }
            this.c = obj5.getInt(l.m4, i2);
            int i7 = 1065353216;
            this.v = obj5.getFloat(l.n4, i7);
            setBackgroundTintList(c.a(obj4, obj5, l.o4));
            int i5 = -1;
            setBackgroundTintMode(n.f(obj5.getInt(l.p4, i5), PorterDuff.Mode.SRC_IN));
            this.w = obj5.getFloat(l.l4, i7);
            this.x = obj5.getDimensionPixelSize(l.k4, i5);
            this.y = obj5.getDimensionPixelSize(l.r4, i5);
            obj5.recycle();
            setOnTouchListener(BaseTransientBottomBar.w.B);
            setFocusable(true);
            if (getBackground() == null) {
                u.o0(this, a());
            }
        }

        private Drawable a() {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(getResources().getDimension(d.m0));
            gradientDrawable.setColor(a.i(this, b.q, b.n, getBackgroundOverlayColorAlpha()));
            if (this.z != null) {
                Drawable drawable = a.r(gradientDrawable);
                a.o(drawable, this.z);
                return drawable;
            }
            return a.r(gradientDrawable);
        }

        @Override // android.widget.FrameLayout
        float getActionTextColorAlpha() {
            return this.w;
        }

        @Override // android.widget.FrameLayout
        int getAnimationMode() {
            return this.c;
        }

        @Override // android.widget.FrameLayout
        float getBackgroundOverlayColorAlpha() {
            return this.v;
        }

        @Override // android.widget.FrameLayout
        int getMaxInlineActionWidth() {
            return this.y;
        }

        @Override // android.widget.FrameLayout
        int getMaxWidth() {
            return this.x;
        }

        @Override // android.widget.FrameLayout
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            final com.google.android.material.snackbar.BaseTransientBottomBar.u uVar = this.b;
            if (uVar != null) {
                uVar.onViewAttachedToWindow(this);
            }
            u.i0(this);
        }

        @Override // android.widget.FrameLayout
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            final com.google.android.material.snackbar.BaseTransientBottomBar.u uVar = this.b;
            if (uVar != null) {
                uVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            Object obj;
            int i7;
            int i6;
            int i8;
            int i;
            super.onLayout(z, i2, i3, i4, i5);
            final com.google.android.material.snackbar.BaseTransientBottomBar.v vVar = this.a;
            if (vVar != null) {
                vVar.a(this, i2, i3, i4, i5);
            }
        }

        @Override // android.widget.FrameLayout
        protected void onMeasure(int i, int i2) {
            int i3;
            int obj2;
            super.onMeasure(i, i2);
            i3 = this.x;
            if (this.x > 0 && getMeasuredWidth() > i3) {
                i3 = this.x;
                if (getMeasuredWidth() > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.widget.FrameLayout
        void setAnimationMode(int i) {
            this.c = i;
        }

        @Override // android.widget.FrameLayout
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.widget.FrameLayout
        public void setBackgroundDrawable(Drawable drawable) {
            Object obj;
            Drawable obj2;
            if (drawable != null && this.z != null) {
                if (this.z != null) {
                    obj2 = a.r(drawable.mutate());
                    a.o(obj2, this.z);
                    a.p(obj2, this.A);
                }
            }
            super.setBackgroundDrawable(obj2);
        }

        @Override // android.widget.FrameLayout
        public void setBackgroundTintList(ColorStateList colorStateList) {
            Drawable background;
            Object obj2;
            this.z = colorStateList;
            background = a.r(getBackground().mutate());
            a.o(background, colorStateList);
            a.p(background, this.A);
            if (getBackground() != null && background != getBackground()) {
                background = a.r(getBackground().mutate());
                a.o(background, colorStateList);
                a.p(background, this.A);
                if (background != getBackground()) {
                    super.setBackgroundDrawable(background);
                }
            }
        }

        @Override // android.widget.FrameLayout
        public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
            Drawable background;
            Object obj2;
            this.A = mode;
            background = a.r(getBackground().mutate());
            a.p(background, mode);
            if (getBackground() != null && background != getBackground()) {
                background = a.r(getBackground().mutate());
                a.p(background, mode);
                if (background != getBackground()) {
                    super.setBackgroundDrawable(background);
                }
            }
        }

        @Override // android.widget.FrameLayout
        void setOnAttachStateChangeListener(com.google.android.material.snackbar.BaseTransientBottomBar.u baseTransientBottomBar$u) {
            this.b = u;
        }

        @Override // android.widget.FrameLayout
        public void setOnClickListener(View.OnClickListener view$OnClickListener) {
            int i;
            i = onClickListener != null ? 0 : BaseTransientBottomBar.w.B;
            setOnTouchListener(i);
            super.setOnClickListener(onClickListener);
        }

        @Override // android.widget.FrameLayout
        void setOnLayoutChangeListener(com.google.android.material.snackbar.BaseTransientBottomBar.v baseTransientBottomBar$v) {
            this.a = v;
        }
    }

    class k implements q {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        k(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // d.h.l.q
        public d0 a(View view, d0 d02) {
            BaseTransientBottomBar.m(this.a, d02.i());
            BaseTransientBottomBar.n(this.a, d02.j());
            BaseTransientBottomBar.o(this.a, d02.k());
            BaseTransientBottomBar.p(this.a);
            return d02;
        }
    }

    class l extends a {

        final com.google.android.material.snackbar.BaseTransientBottomBar d;
        l(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.d = baseTransientBottomBar;
            super();
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            super.g(view, c2);
            c2.a(1048576);
            c2.c0(true);
        }

        @Override // d.h.l.a
        public boolean j(View view, int i2, Bundle bundle3) {
            if (i2 == 1048576) {
                this.d.u();
                return 1;
            }
            return super.j(view, i2, bundle3);
        }
    }

    class m implements com.google.android.material.snackbar.b.b {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        m(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // com.google.android.material.snackbar.b$b
        public void a() {
            final Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(0, this.a));
        }

        @Override // com.google.android.material.snackbar.b$b
        public void b(int i) {
            final Handler handler = BaseTransientBottomBar.t;
            handler.sendMessage(handler.obtainMessage(1, i, 0, this.a));
        }
    }

    class n implements com.google.android.material.snackbar.BaseTransientBottomBar.u {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        n(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar$u
        public void onViewAttachedToWindow(View view) {
            int i;
            int obj2;
            obj2 = obj2.c.getRootWindowInsets();
            if (Build.VERSION.SDK_INT >= 29 && obj2 != null) {
                obj2 = obj2.c.getRootWindowInsets();
                if (obj2 != null) {
                    BaseTransientBottomBar.k(this.a, obj2.bottom);
                    BaseTransientBottomBar.p(this.a);
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar$u
        public void onViewDetachedFromWindow(View view) {
            com.google.android.material.snackbar.BaseTransientBottomBar.n.a aVar;
            boolean obj2;
            if (this.a.J()) {
                aVar = new BaseTransientBottomBar.n.a(this);
                BaseTransientBottomBar.t.post(aVar);
            }
        }
    }

    class o implements com.google.android.material.snackbar.BaseTransientBottomBar.v {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        o(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar$v
        public void a(View view, int i2, int i3, int i4, int i5) {
            obj1.c.setOnLayoutChangeListener(0);
            BaseTransientBottomBar.q(this.a);
        }
    }

    class p implements SwipeDismissBehavior.c {

        final com.google.android.material.snackbar.BaseTransientBottomBar a;
        p(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
            this.a = baseTransientBottomBar;
            super();
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior$c
        public void a(View view) {
            android.view.ViewParent parent;
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            this.a.v(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior$c
        public void b(int i) {
            int bVar;
            com.google.android.material.snackbar.b obj2;
            if (i != 0) {
                if (i != 1 && i != 2) {
                    if (i != 2) {
                    } else {
                        b.c().j(baseTransientBottomBar2.s);
                    }
                } else {
                }
            } else {
                b.c().k(baseTransientBottomBar.s);
            }
        }
    }

    public static class Behavior extends SwipeDismissBehavior<View> {

        private final com.google.android.material.snackbar.BaseTransientBottomBar.t k;
        public Behavior() {
            super();
            BaseTransientBottomBar.t tVar = new BaseTransientBottomBar.t(this);
            this.k = tVar;
        }

        static void k(com.google.android.material.snackbar.BaseTransientBottomBar.Behavior baseTransientBottomBar$Behavior, com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar2) {
            behavior.l(baseTransientBottomBar2);
        }

        private void l(com.google.android.material.snackbar.BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return this.k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view2, MotionEvent motionEvent3) {
            this.k.b(coordinatorLayout, view2, motionEvent3);
            return super.onInterceptTouchEvent(coordinatorLayout, view2, motionEvent3);
        }
    }
    static {
        int i;
        int sDK_INT = Build.VERSION.SDK_INT;
        int i4 = 1;
        int i6 = 0;
        if (sDK_INT >= 16 && sDK_INT <= 19) {
            if (sDK_INT <= 19) {
                int i3 = i4;
            }
        }
        int i2 = i6;
        int[] iArr = new int[i4];
        iArr[i6] = b.N;
        BaseTransientBottomBar.v = iArr;
        BaseTransientBottomBar.w = BaseTransientBottomBar.class.getSimpleName();
        BaseTransientBottomBar.i iVar = new BaseTransientBottomBar.i();
        Handler handler = new Handler(Looper.getMainLooper(), iVar);
        BaseTransientBottomBar.t = handler;
    }

    protected BaseTransientBottomBar(Context context, ViewGroup viewGroup2, View view3, com.google.android.material.snackbar.a a4) {
        int maxInlineActionWidth;
        int topMargin;
        int rightMargin;
        android.view.ViewGroup.LayoutParams obj6;
        boolean obj7;
        super();
        BaseTransientBottomBar.j jVar = new BaseTransientBottomBar.j(this);
        this.i = jVar;
        BaseTransientBottomBar.m mVar = new BaseTransientBottomBar.m(this);
        this.s = mVar;
        if (viewGroup2 == null) {
        } else {
            if (view3 == null) {
            } else {
                if (a4 == null) {
                } else {
                    this.a = viewGroup2;
                    this.d = a4;
                    this.b = context;
                    l.a(context);
                    View obj5 = LayoutInflater.from(context).inflate(D(), viewGroup2, false);
                    this.c = (BaseTransientBottomBar.w)obj5;
                    if (view3 instanceof SnackbarContentLayout) {
                        obj7 = view3;
                        (SnackbarContentLayout)obj7.c(obj5.getActionTextColorAlpha());
                        obj7.setMaxInlineActionWidth(obj5.getMaxInlineActionWidth());
                    }
                    obj5.addView(view3);
                    obj6 = obj5.getLayoutParams();
                    if (obj6 instanceof ViewGroup.MarginLayoutParams) {
                        obj7 = new Rect(obj6.leftMargin, obj6.topMargin, obj6.rightMargin, obj6.bottomMargin);
                        this.j = obj7;
                    }
                    obj6 = 1;
                    u.n0(obj5, obj6);
                    u.v0(obj5, obj6);
                    u.t0(obj5, obj6);
                    obj6 = new BaseTransientBottomBar.k(this);
                    u.x0(obj5, obj6);
                    obj6 = new BaseTransientBottomBar.l(this);
                    u.l0(obj5, obj6);
                    this.r = (AccessibilityManager)context.getSystemService("accessibility");
                }
                IllegalArgumentException obj4 = new IllegalArgumentException("Transient bottom bar must have non-null callback");
                throw obj4;
            }
            obj4 = new IllegalArgumentException("Transient bottom bar must have non-null content");
            throw obj4;
        }
        obj4 = new IllegalArgumentException("Transient bottom bar must have non-null parent");
        throw obj4;
    }

    private ValueAnimator B(float... fArr) {
        final ValueAnimator obj2 = ValueAnimator.ofFloat(fArr);
        obj2.setInterpolator(a.d);
        BaseTransientBottomBar.d dVar = new BaseTransientBottomBar.d(this);
        obj2.addUpdateListener(dVar);
        return obj2;
    }

    private int C() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        (WindowManager)this.b.getSystemService("window").getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int E() {
        int height;
        android.view.ViewGroup.LayoutParams layoutParams;
        layoutParams = this.c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            height += layoutParams;
        }
        return height;
    }

    private int G() {
        int[] iArr = new int[2];
        this.c.getLocationOnScreen(iArr);
        return i2 += height;
    }

    private boolean K() {
        android.view.ViewGroup.LayoutParams layoutParams;
        int i;
        layoutParams = this.c.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f && cVar instanceof SwipeDismissBehavior) {
            i = cVar instanceof SwipeDismissBehavior ? 1 : 0;
        } else {
        }
        return i;
    }

    private void N() {
        this.o = t();
        a0();
    }

    private void Q(CoordinatorLayout.f coordinatorLayout$f) {
        SwipeDismissBehavior behavior;
        View view;
        boolean behavior2;
        if (this.q == null) {
            behavior = A();
        }
        if (behavior instanceof BaseTransientBottomBar.Behavior) {
            BaseTransientBottomBar.Behavior.k((BaseTransientBottomBar.Behavior)behavior, this);
        }
        BaseTransientBottomBar.p pVar = new BaseTransientBottomBar.p(this);
        behavior.g(pVar);
        f.o(behavior);
        if (x() == null) {
            f.g = 80;
        }
    }

    private boolean S() {
        int i2;
        int i;
        if (this.n > 0 && !this.f && K()) {
            if (!this.f) {
                i2 = K() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i2;
    }

    private void V() {
        boolean parent;
        int i;
        if (R()) {
            r();
        } else {
            if (this.c.getParent() != null) {
                this.c.setVisibility(0);
            }
            M();
        }
    }

    private void W() {
        int i2 = 2;
        float[] fArr = new float[i2];
        fArr = new int[]{0, 1065353216};
        float[] fArr2 = new float[i2];
        fArr2 = new int[]{1061997773, 1065353216};
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] arr = new Animator[i2];
        arr[0] = w(fArr);
        int i4 = 1;
        arr[i4] = B(fArr2);
        animatorSet.playTogether(arr);
        animatorSet.setDuration(150);
        BaseTransientBottomBar.a aVar = new BaseTransientBottomBar.a(this);
        animatorSet.addListener(aVar);
        animatorSet.start();
    }

    private void X(int i) {
        float[] fArr = new float[2];
        fArr = new int[]{1065353216, 0};
        ValueAnimator valueAnimator = w(fArr);
        valueAnimator.setDuration(75);
        BaseTransientBottomBar.b bVar = new BaseTransientBottomBar.b(this, i);
        valueAnimator.addListener(bVar);
        valueAnimator.start();
    }

    private void Y() {
        com.google.android.material.snackbar.BaseTransientBottomBar.w wVar;
        float f;
        final int i = E();
        if (BaseTransientBottomBar.u) {
            u.X(this.c, i);
        } else {
            this.c.setTranslationY((float)i);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        int[] iArr = new int[2];
        final int i4 = 0;
        iArr[i4] = i;
        iArr[1] = i4;
        valueAnimator.setIntValues(iArr);
        valueAnimator.setInterpolator(a.b);
        valueAnimator.setDuration(250);
        BaseTransientBottomBar.e eVar = new BaseTransientBottomBar.e(this);
        valueAnimator.addListener(eVar);
        BaseTransientBottomBar.f fVar = new BaseTransientBottomBar.f(this, i);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.start();
    }

    private void Z(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        int[] iArr = new int[2];
        int i4 = 0;
        iArr[i4] = i4;
        int i5 = E();
        iArr[1] = i5;
        valueAnimator.setIntValues(iArr);
        valueAnimator.setInterpolator(a.b);
        valueAnimator.setDuration(250);
        BaseTransientBottomBar.g gVar = new BaseTransientBottomBar.g(this, i);
        valueAnimator.addListener(gVar);
        BaseTransientBottomBar.h obj5 = new BaseTransientBottomBar.h(this);
        valueAnimator.addUpdateListener(obj5);
        valueAnimator.start();
    }

    static Context a(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.b;
    }

    private void a0() {
        int sDK_INT;
        boolean z;
        int i;
        int i2;
        android.view.ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (this.j == null) {
            } else {
                i = x() != null ? this.o : this.k;
                Rect rect = this.j;
                layoutParams.bottomMargin = bottom += i;
                layoutParams.leftMargin = left += i7;
                layoutParams.rightMargin = right += i5;
                this.c.requestLayout();
                if (Build.VERSION.SDK_INT >= 29 && S()) {
                    if (S()) {
                        this.c.removeCallbacks(this.i);
                        this.c.post(this.i);
                    }
                }
            }
        }
        Log.w(BaseTransientBottomBar.w, "Unable to update margins because layout params are not MarginLayoutParams");
    }

    static int b(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.C();
    }

    static void c(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar.W();
    }

    static void d(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar.Y();
    }

    static com.google.android.material.snackbar.a e(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.d;
    }

    static boolean f() {
        return BaseTransientBottomBar.u;
    }

    static boolean g(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.h;
    }

    static void h(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar.N();
    }

    static int i(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.G();
    }

    static int j(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        return baseTransientBottomBar.n;
    }

    static int k(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar, int i2) {
        baseTransientBottomBar.n = i2;
        return i2;
    }

    static String l() {
        return BaseTransientBottomBar.w;
    }

    static int m(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar, int i2) {
        baseTransientBottomBar.k = i2;
        return i2;
    }

    static int n(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar, int i2) {
        baseTransientBottomBar.l = i2;
        return i2;
    }

    static int o(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar, int i2) {
        baseTransientBottomBar.m = i2;
        return i2;
    }

    static void p(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar.a0();
    }

    static void q(com.google.android.material.snackbar.BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar.V();
    }

    private void s(int i) {
        if (this.c.getAnimationMode() == 1) {
            X(i);
        } else {
            Z(i);
        }
    }

    private int t() {
        if (x() == null) {
            return 0;
        }
        int i2 = 2;
        int[] iArr2 = new int[i2];
        x().getLocationOnScreen(iArr2);
        int i7 = 1;
        int[] iArr = new int[i2];
        this.a.getLocationOnScreen(iArr);
        return i4 -= i6;
    }

    private ValueAnimator w(float... fArr) {
        final ValueAnimator obj2 = ValueAnimator.ofFloat(fArr);
        obj2.setInterpolator(a.a);
        BaseTransientBottomBar.c cVar = new BaseTransientBottomBar.c(this);
        obj2.addUpdateListener(cVar);
        return obj2;
    }

    protected SwipeDismissBehavior<? extends View> A() {
        BaseTransientBottomBar.Behavior behavior = new BaseTransientBottomBar.Behavior();
        return behavior;
    }

    protected int D() {
        int i;
        i = H() ? h.w : h.c;
        return i;
    }

    public View F() {
        return this.c;
    }

    protected boolean H() {
        int i;
        TypedArray styledAttributes = this.b.obtainStyledAttributes(BaseTransientBottomBar.v);
        final int i2 = -1;
        styledAttributes.recycle();
        if (styledAttributes.getResourceId(0, i2) != i2) {
            i = 1;
        }
        return i;
    }

    final void I(int i) {
        boolean visibility;
        if (R() && this.c.getVisibility() == 0) {
            if (this.c.getVisibility() == 0) {
                s(i);
            } else {
                L(i);
            }
        } else {
        }
    }

    public boolean J() {
        return b.c().e(this.s);
    }

    void L(int i) {
        int list;
        boolean wVar;
        com.google.android.material.snackbar.b.b bVar;
        b.c().h(this.s);
        list = this.p;
        if (list != null) {
            size--;
            while (list >= 0) {
                (BaseTransientBottomBar.s)this.p.get(list).a(this, i);
                list--;
            }
        }
        android.view.ViewParent obj3 = this.c.getParent();
        if (obj3 instanceof ViewGroup) {
            (ViewGroup)obj3.removeView(this.c);
        }
    }

    void M() {
        int list;
        com.google.android.material.snackbar.b.b bVar;
        b.c().i(this.s);
        list = this.p;
        if (list != null) {
            size--;
            while (list >= 0) {
                (BaseTransientBottomBar.s)this.p.get(list).b(this);
                list--;
            }
        }
    }

    public B O(View view) {
        int obj2;
        final com.google.android.material.snackbar.BaseTransientBottomBar.r rVar = this.g;
        if (rVar != null) {
            rVar.c();
        }
        if (view == null) {
            obj2 = 0;
        } else {
            obj2 = BaseTransientBottomBar.r.a(this, view);
        }
        this.g = obj2;
        return this;
    }

    public B P(int i) {
        this.e = i;
        return this;
    }

    boolean R() {
        List enabledAccessibilityServiceList;
        int i;
        AccessibilityManager accessibilityManager = this.r;
        i = 1;
        if (accessibilityManager == null) {
            return i;
        }
        enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(i);
        if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty()) {
            if (enabledAccessibilityServiceList.isEmpty()) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public void T() {
        b.c().m(z(), this.s);
    }

    final void U() {
        Object parent;
        Object nVar;
        nVar = new BaseTransientBottomBar.n(this);
        this.c.setOnAttachStateChangeListener(nVar);
        android.view.ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if (this.c.getParent() == null && layoutParams instanceof CoordinatorLayout.f) {
            layoutParams = this.c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                Q((CoordinatorLayout.f)layoutParams);
            }
            N();
            this.c.setVisibility(4);
            this.a.addView(this.c);
        }
        if (u.R(this.c)) {
            V();
        }
        BaseTransientBottomBar.o oVar = new BaseTransientBottomBar.o(this);
        this.c.setOnLayoutChangeListener(oVar);
    }

    void r() {
        BaseTransientBottomBar.q qVar = new BaseTransientBottomBar.q(this);
        this.c.post(qVar);
    }

    public void u() {
        v(3);
    }

    protected void v(int i) {
        b.c().b(this.s, i);
    }

    public View x() {
        int i;
        com.google.android.material.snackbar.BaseTransientBottomBar.r rVar = this.g;
        if (rVar == null) {
            i = 0;
        } else {
            i = rVar.b();
        }
        return i;
    }

    public Context y() {
        return this.b;
    }

    public int z() {
        return this.e;
    }
}
