package com.google.android.material.tabs;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.v0;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.k;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.e;
import androidx.viewpager.widget.ViewPager.i;
import androidx.viewpager.widget.ViewPager.j;
import androidx.viewpager.widget.a;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.theme.a.a;
import d.a.j;
import d.a.k.a.a;
import d.h.k.f;
import d.h.k.g;
import d.h.k.h;
import d.h.l.e0.c;
import d.h.l.e0.c.a;
import d.h.l.e0.c.b;
import d.h.l.e0.c.c;
import d.h.l.h;
import d.h.l.s;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.b0.b;
import f.c.a.e.d;
import f.c.a.e.d0.g;
import f.c.a.e.d0.h;
import f.c.a.e.h;
import f.c.a.e.j;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.m.a;
import f.c.a.e.n.a;
import f.c.a.e.n.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
@ViewPager$e
public class TabLayout extends HorizontalScrollView {

    private static final int m0;
    private static final f<com.google.android.material.tabs.TabLayout.g> n0;
    ColorStateList A;
    ColorStateList B;
    ColorStateList C;
    Drawable D;
    private int E;
    PorterDuff.Mode F;
    float G;
    float H;
    final int I;
    int J;
    private final int K;
    private final int L;
    private final int M;
    private int N;
    int O;
    int P;
    int Q;
    int R;
    boolean S;
    boolean T;
    int U;
    int V;
    boolean W;
    private final ArrayList<com.google.android.material.tabs.TabLayout.g> a;
    private com.google.android.material.tabs.b a0;
    private com.google.android.material.tabs.TabLayout.g b;
    private com.google.android.material.tabs.TabLayout.c b0;
    final com.google.android.material.tabs.TabLayout.f c;
    private final ArrayList<com.google.android.material.tabs.TabLayout.c> c0;
    private com.google.android.material.tabs.TabLayout.c d0;
    private ValueAnimator e0;
    ViewPager f0;
    private a g0;
    private DataSetObserver h0;
    private com.google.android.material.tabs.TabLayout.h i0;
    private com.google.android.material.tabs.TabLayout.b j0;
    private boolean k0;
    private final f<com.google.android.material.tabs.TabLayout.i> l0;
    int v;
    int w;
    int x;
    int y;
    int z;

    class a implements ValueAnimator.AnimatorUpdateListener {

        final com.google.android.material.tabs.TabLayout a;
        a(com.google.android.material.tabs.TabLayout tabLayout) {
            this.a = tabLayout;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.scrollTo((Integer)valueAnimator.getAnimatedValue().intValue(), 0);
        }
    }

    @Deprecated
    public interface c {
        public abstract void a(T t);

        public abstract void b(T t);

        public abstract void c(T t);
    }

    private class e extends DataSetObserver {

        final com.google.android.material.tabs.TabLayout a;
        e(com.google.android.material.tabs.TabLayout tabLayout) {
            this.a = tabLayout;
            super();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.a.A();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.a.A();
        }
    }

    class f extends LinearLayout {

        ValueAnimator a;
        int b = -1;
        float c;
        private int v = -1;
        final com.google.android.material.tabs.TabLayout w;
        f(com.google.android.material.tabs.TabLayout tabLayout, Context context2) {
            this.w = tabLayout;
            super(context2);
            int obj1 = -1;
            setWillNotDraw(false);
        }

        static void a(com.google.android.material.tabs.TabLayout.f tabLayout$f) {
            f.e();
        }

        static void b(com.google.android.material.tabs.TabLayout.f tabLayout$f, View view2, View view3, float f4) {
            f.h(view2, view3, f4);
        }

        private void e() {
            final com.google.android.material.tabs.TabLayout tabLayout2 = this.w;
            TabLayout.a(this.w).d(tabLayout2, getChildAt(this.b), tabLayout2.D);
        }

        private void h(View view, View view2, float f3) {
            int width;
            int i;
            int i2;
            com.google.android.material.tabs.b bVar;
            com.google.android.material.tabs.TabLayout tabLayout;
            View view3;
            View view4;
            float f;
            Drawable drawable;
            Drawable obj8;
            int obj9;
            int obj10;
            if (view != null && view.getWidth() > 0) {
                i = view.getWidth() > 0 ? 1 : 0;
            } else {
            }
            if (i != 0) {
                tabLayout = this.w;
                TabLayout.a(this.w).c(tabLayout, view, view2, f3, tabLayout.D);
            } else {
                obj8 = obj8.D;
                i2 = -1;
                obj8.setBounds(i2, obj9.top, i2, obj10.bottom);
            }
            u.c0(this);
        }

        private void i(boolean z, int i2, int i3) {
            long childAt;
            ValueAnimator obj4;
            com.google.android.material.tabs.TabLayout.f.b obj6;
            final View childAt2 = getChildAt(i2);
            if (childAt2 == null) {
                e();
            }
            TabLayout.f.a aVar = new TabLayout.f.a(this, getChildAt(this.b), childAt2);
            if (z) {
                obj4 = new ValueAnimator();
                this.a = obj4;
                obj4.setInterpolator(a.b);
                obj4.setDuration((long)i3);
                obj6 = new float[2];
                obj6 = new int[]{0, 1065353216};
                obj4.setFloatValues(obj6);
                obj4.addUpdateListener(aVar);
                obj6 = new TabLayout.f.b(this, i2);
                obj4.addListener(obj6);
                obj4.start();
            } else {
                this.a.removeAllUpdateListeners();
                this.a.addUpdateListener(aVar);
            }
        }

        @Override // android.widget.LinearLayout
        void c(int i, int i2) {
            ValueAnimator running;
            running = this.a;
            if (running != null && running.isRunning()) {
                if (running.isRunning()) {
                    this.a.cancel();
                }
            }
            i(true, i, i2);
        }

        @Override // android.widget.LinearLayout
        boolean d() {
            int i;
            int width;
            final int i3 = 0;
            i = i3;
            while (i < getChildCount()) {
                i++;
            }
            return i3;
        }

        @Override // android.widget.LinearLayout
        public void draw(Canvas canvas) {
            int intrinsicHeight;
            int height;
            Drawable width;
            int sRC_IN;
            int i;
            int left;
            if (tabLayout.D.getBounds().height() < 0) {
                intrinsicHeight = tabLayout2.D.getIntrinsicHeight();
            }
            height = tabLayout6.Q;
            if (height != 0) {
                if (height != 1) {
                    if (height != 2) {
                        if (height != 3) {
                            intrinsicHeight = sRC_IN;
                        } else {
                            intrinsicHeight = getHeight();
                        }
                    }
                } else {
                    sRC_IN = i4 / 2;
                    intrinsicHeight = height / 2;
                }
            } else {
                sRC_IN = height - intrinsicHeight;
                intrinsicHeight = getHeight();
            }
            if (tabLayout7.D.getBounds().width() > 0) {
                Rect bounds3 = tabLayout8.D.getBounds();
                tabLayout9.D.setBounds(bounds3.left, sRC_IN, bounds3.right, intrinsicHeight);
                com.google.android.material.tabs.TabLayout tabLayout3 = this.w;
                width = tabLayout3.D;
                sRC_IN = 21;
                if (TabLayout.b(tabLayout3) != 0) {
                    width = a.r(width);
                    if (Build.VERSION.SDK_INT == sRC_IN) {
                        width.setColorFilter(TabLayout.b(this.w), PorterDuff.Mode.SRC_IN);
                    } else {
                        a.n(width, TabLayout.b(this.w));
                    }
                } else {
                    i = 0;
                    if (Build.VERSION.SDK_INT == sRC_IN) {
                        width.setColorFilter(i);
                    } else {
                        a.o(width, i);
                    }
                }
                width.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout
        void f(int i, float f2) {
            ValueAnimator running;
            running = this.a;
            if (running != null && running.isRunning()) {
                if (running.isRunning()) {
                    this.a.cancel();
                }
            }
            this.b = i;
            this.c = f2;
            h(getChildAt(i), getChildAt(obj3++), this.c);
        }

        @Override // android.widget.LinearLayout
        void g(int i) {
            Rect bounds = tabLayout.D.getBounds();
            tabLayout2.D.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        @Override // android.widget.LinearLayout
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            ValueAnimator obj1;
            int obj2;
            int obj3;
            super.onLayout(z, i2, i3, i4, i5);
            obj1 = this.a;
            if (obj1 != null && obj1.isRunning()) {
                if (obj1.isRunning()) {
                    i(false, this.b, -1);
                } else {
                    e();
                }
            } else {
            }
        }

        @Override // android.widget.LinearLayout
        protected void onMeasure(int i, int i2) {
            int childCount;
            int i3;
            int i4;
            int i5;
            int layoutParams;
            int i6;
            int i7;
            int measuredWidth;
            int visibility;
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
            }
            childCount = this.w;
            i4 = 2;
            i5 = 1;
            if (childCount.O != i5) {
                if (childCount.R == i4) {
                    childCount = getChildCount();
                    i3 = 0;
                    i7 = i6;
                    while (i6 < childCount) {
                        measuredWidth = getChildAt(i6);
                        if (measuredWidth.getVisibility() == 0) {
                        }
                        i6++;
                        i7 = Math.max(i7, measuredWidth.getMeasuredWidth());
                    }
                    if (i7 <= 0) {
                    }
                    if (i7 * childCount <= measuredWidth2 -= layoutParams) {
                        i4 = i3;
                        while (i3 < childCount) {
                            layoutParams = getChildAt(i3).getLayoutParams();
                            visibility = 0;
                            if (layoutParams.width == i7) {
                            } else {
                            }
                            layoutParams.width = i7;
                            layoutParams.weight = visibility;
                            i4 = i5;
                            i3++;
                            if (Float.compare(weight, visibility) != 0) {
                            }
                        }
                        i5 = i4;
                    } else {
                        childCount = this.w;
                        childCount.O = i3;
                        childCount.O(i3);
                    }
                    if (i5 != 0) {
                        super.onMeasure(i, i2);
                    }
                }
            } else {
            }
        }

        @Override // android.widget.LinearLayout
        public void onRtlPropertiesChanged(int i) {
            int sDK_INT;
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT < 23 && this.v != i) {
                if (this.v != i) {
                    requestLayout();
                    this.v = i;
                }
            }
        }
    }

    public static class g {

        private Drawable a;
        private java.lang.CharSequence b;
        private java.lang.CharSequence c;
        private int d = -1;
        private View e;
        private int f = 1;
        public com.google.android.material.tabs.TabLayout g;
        public com.google.android.material.tabs.TabLayout.i h;
        private int i = -1;
        public g() {
            super();
            final int i = -1;
            final int i2 = 1;
        }

        static int a(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
            return g.i;
        }

        static int b(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
            return g.f;
        }

        static java.lang.CharSequence c(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
            return g.c;
        }

        static java.lang.CharSequence d(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
            return g.b;
        }

        public View e() {
            return this.e;
        }

        public Drawable f() {
            return this.a;
        }

        public int g() {
            return this.d;
        }

        public int h() {
            return this.f;
        }

        public java.lang.CharSequence i() {
            return this.b;
        }

        public boolean j() {
            int i;
            int i2;
            com.google.android.material.tabs.TabLayout tabLayout = this.g;
            if (tabLayout == null) {
            } else {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                if (selectedTabPosition != -1 && selectedTabPosition == this.d) {
                    i = selectedTabPosition == this.d ? 1 : 0;
                } else {
                }
                return i;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Tab not attached to a TabLayout");
            throw illegalArgumentException;
        }

        void k() {
            final int i = 0;
            this.g = i;
            this.h = i;
            this.a = i;
            final int i2 = -1;
            this.i = i2;
            this.b = i;
            this.c = i;
            this.d = i2;
            this.e = i;
        }

        public void l() {
            com.google.android.material.tabs.TabLayout tabLayout = this.g;
            if (tabLayout == null) {
            } else {
                tabLayout.F(this);
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Tab not attached to a TabLayout");
            throw illegalArgumentException;
        }

        public com.google.android.material.tabs.TabLayout.g m(java.lang.CharSequence charSequence) {
            this.c = charSequence;
            s();
            return this;
        }

        public com.google.android.material.tabs.TabLayout.g n(int i) {
            o(LayoutInflater.from(this.h.getContext()).inflate(i, this.h, false));
            return this;
        }

        public com.google.android.material.tabs.TabLayout.g o(View view) {
            this.e = view;
            s();
            return this;
        }

        public com.google.android.material.tabs.TabLayout.g p(Drawable drawable) {
            int i2;
            int i;
            boolean obj4;
            this.a = drawable;
            obj4 = this.g;
            final int i3 = 1;
            if (obj4.O != i3) {
                if (obj4.R == 2) {
                    obj4.O(i3);
                }
            } else {
            }
            s();
            if (b.a && TabLayout.i.d(this.h) && TabLayout.i.e(this.h).isVisible()) {
                if (TabLayout.i.d(this.h)) {
                    if (TabLayout.i.e(this.h).isVisible()) {
                        this.h.invalidate();
                    }
                }
            }
            return this;
        }

        void q(int i) {
            this.d = i;
        }

        public com.google.android.material.tabs.TabLayout.g r(java.lang.CharSequence charSequence) {
            boolean empty;
            if (TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(charSequence)) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.h.setContentDescription(charSequence);
                }
            }
            this.b = charSequence;
            s();
            return this;
        }

        void s() {
            final com.google.android.material.tabs.TabLayout.i iVar = this.h;
            if (iVar != null) {
                iVar.t();
            }
        }
    }

    public final class i extends LinearLayout {

        private Drawable A;
        private int B = 2;
        final com.google.android.material.tabs.TabLayout C;
        private com.google.android.material.tabs.TabLayout.g a;
        private TextView b;
        private ImageView c;
        private View v;
        private a w;
        private View x;
        private TextView y;
        private ImageView z;
        public i(com.google.android.material.tabs.TabLayout tabLayout, Context context2) {
            this.C = tabLayout;
            super(context2);
            int i = 2;
            u(context2);
            u.y0(this, tabLayout.v, tabLayout.w, tabLayout.x, tabLayout.y);
            setGravity(17);
            int obj5 = 1;
            setOrientation(obj4 ^= obj5);
            setClickable(obj5);
            u.z0(this, s.b(getContext(), 1002));
        }

        static void a(com.google.android.material.tabs.TabLayout.i tabLayout$i, View view2) {
            i.s(view2);
        }

        static void b(com.google.android.material.tabs.TabLayout.i tabLayout$i, Context context2) {
            i.u(context2);
        }

        static void c(com.google.android.material.tabs.TabLayout.i tabLayout$i, Canvas canvas2) {
            i.j(canvas2);
        }

        static boolean d(com.google.android.material.tabs.TabLayout.i tabLayout$i) {
            return i.l();
        }

        static a e(com.google.android.material.tabs.TabLayout.i tabLayout$i) {
            return i.w;
        }

        private void f(View view) {
            if (view == null) {
            }
            TabLayout.i.a aVar = new TabLayout.i.a(this, view);
            view.addOnLayoutChangeListener(aVar);
        }

        private float g(Layout layout, int i2, float f3) {
            return obj2 *= obj3;
        }

        private a getBadge() {
            return this.w;
        }

        private a getOrCreateBadge() {
            a aVar;
            if (this.w == null) {
                this.w = a.c(getContext());
            }
            r();
            a aVar2 = this.w;
            if (aVar2 == null) {
            } else {
                return aVar2;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Unable to create badge");
            throw illegalStateException;
        }

        private void h(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            final android.view.ViewParent parent = getParent();
            if ((ViewGroup)parent != null) {
                (ViewGroup)parent.setClipChildren(z);
                parent.setClipToPadding(z);
            }
        }

        private FrameLayout i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            final int i = -2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            frameLayout.setLayoutParams(layoutParams);
            return frameLayout;
        }

        private void j(Canvas canvas) {
            Drawable drawable;
            int left;
            int top;
            int right;
            int bottom;
            drawable = this.A;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.A.draw(canvas);
            }
        }

        private FrameLayout k(View view) {
            Object view2;
            int i;
            Object obj3;
            if (view != this.c && view != this.b) {
                if (view != this.b) {
                    return null;
                }
            }
            if (b.a) {
                i = obj3;
            }
            return i;
        }

        private boolean l() {
            int i;
            i = this.w != null ? 1 : 0;
            return i;
        }

        private void m() {
            FrameLayout frameLayout;
            final int i = 0;
            if (b.a) {
                addView(i(), i);
            } else {
                frameLayout = this;
            }
            View inflate = LayoutInflater.from(getContext()).inflate(h.e, frameLayout, i);
            this.c = (ImageView)inflate;
            frameLayout.addView(inflate, i);
        }

        private void n() {
            FrameLayout frameLayout;
            if (b.a) {
                addView(i());
            } else {
                frameLayout = this;
            }
            View inflate = LayoutInflater.from(getContext()).inflate(h.f, frameLayout, false);
            this.b = (TextView)inflate;
            frameLayout.addView(inflate);
        }

        private void p(View view) {
            boolean z;
            FrameLayout frameLayout;
            if (!l()) {
            }
            if (view != null) {
                h(false);
                b.a(this.w, view, k(view));
                this.v = view;
            }
        }

        private void q() {
            View view;
            a aVar;
            if (!l()) {
            }
            h(true);
            view = this.v;
            if (view != null) {
                b.d(this.w, view);
                this.v = 0;
            }
        }

        private void r() {
            Object view3;
            Object view2;
            TextView view;
            if (!l()) {
            }
            if (this.x != null) {
                q();
            } else {
                view2 = this.a;
                if (this.c != null && view2 != null && view2.f() != null) {
                    view2 = this.a;
                    if (view2 != null) {
                        if (view2.f() != null) {
                            view = this.c;
                            if (this.v != view) {
                                q();
                                p(this.c);
                            } else {
                                s(view);
                            }
                        } else {
                            view3 = this.a;
                            if (this.b != null && view3 != null && view3.h() == 1) {
                                view3 = this.a;
                                if (view3 != null) {
                                    if (view3.h() == 1) {
                                        view = this.b;
                                        if (this.v != view) {
                                            q();
                                            p(this.b);
                                        } else {
                                            s(view);
                                        }
                                    } else {
                                        q();
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
        }

        private void s(View view) {
            boolean z;
            FrameLayout frameLayout;
            if (l() && view == this.v) {
                if (view == this.v) {
                    b.e(this.w, view, k(view));
                }
            }
        }

        private void u(Context context) {
            int drawableState;
            int rippleDrawable;
            int i;
            Object gradientDrawable;
            ColorStateList arr;
            boolean sDK_INT;
            int i2;
            Drawable obj7;
            drawableState = tabLayout.I;
            i = 0;
            if (drawableState != 0) {
                obj7 = a.d(context, drawableState);
                this.A = obj7;
                if (obj7 != null && obj7.isStateful()) {
                    if (obj7.isStateful()) {
                        this.A.setState(getDrawableState());
                    }
                }
            } else {
                this.A = i;
            }
            obj7 = new GradientDrawable();
            rippleDrawable = 0;
            obj7.setColor(rippleDrawable);
            if (tabLayout2.C != null) {
                gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(925353388);
                gradientDrawable.setColor(-1);
                arr = b.a(tabLayout3.C);
                if (Build.VERSION.SDK_INT >= 21) {
                    sDK_INT = tabLayout4.W;
                    if (sDK_INT) {
                        obj7 = i;
                    }
                    if (sDK_INT) {
                    } else {
                        i = gradientDrawable;
                    }
                    rippleDrawable = new RippleDrawable(arr, obj7, i);
                    obj7 = rippleDrawable;
                } else {
                    i = a.r(gradientDrawable);
                    a.o(i, arr);
                    arr = new Drawable[2];
                    arr[rippleDrawable] = obj7;
                    arr[1] = i;
                    gradientDrawable = new LayerDrawable(arr);
                    obj7 = gradientDrawable;
                }
            }
            u.o0(this, obj7);
            this.C.invalidate();
        }

        private void w(TextView textView, ImageView imageView2) {
            Object gVar;
            int mutate;
            int i4;
            PorterDuff.Mode mode;
            int i;
            int i3;
            int bottomMargin;
            int i2;
            ViewGroup.LayoutParams obj8;
            int obj9;
            gVar = this.a;
            i4 = 0;
            if (gVar != null && gVar.f() != null) {
                if (gVar.f() != null) {
                    mutate = a.r(this.a.f()).mutate();
                } else {
                    mutate = i4;
                }
            } else {
            }
            a.o(mutate, tabLayout.B);
            mode = tabLayout2.F;
            if (mutate != 0 && mode != null) {
                a.o(mutate, tabLayout.B);
                mode = tabLayout2.F;
                if (mode != null) {
                    a.p(mutate, mode);
                }
            }
            com.google.android.material.tabs.TabLayout.g gVar3 = this.a;
            if (gVar3 != null) {
                i = gVar3.i();
            } else {
                i = i4;
            }
            i3 = 8;
            final int i6 = 0;
            if (imageView2 != null) {
                if (mutate != 0) {
                    imageView2.setImageDrawable(mutate);
                    imageView2.setVisibility(i6);
                    setVisibility(i6);
                } else {
                    imageView2.setVisibility(i3);
                    imageView2.setImageDrawable(i4);
                }
            }
            bottomMargin = 1;
            empty ^= bottomMargin;
            if (textView != null) {
                if (i5 != 0) {
                    textView.setText(i);
                    if (TabLayout.g.b(this.a) == bottomMargin) {
                        textView.setVisibility(i6);
                    } else {
                        textView.setVisibility(i3);
                    }
                    setVisibility(i6);
                } else {
                    textView.setVisibility(i3);
                    textView.setText(i4);
                }
            }
            if (imageView2 != null) {
                obj8 = imageView2.getLayoutParams();
                if (i5 != 0 && imageView2.getVisibility() == 0) {
                    if (imageView2.getVisibility() == 0) {
                        i3 = (int)f;
                    } else {
                        i3 = i6;
                    }
                } else {
                }
                if (tabLayout3.S) {
                    if (i3 != h.a((ViewGroup.MarginLayoutParams)obj8)) {
                        h.c(obj8, i3);
                        obj8.bottomMargin = i6;
                        imageView2.setLayoutParams(obj8);
                        imageView2.requestLayout();
                    }
                } else {
                    if (i3 != obj8.bottomMargin) {
                        obj8.bottomMargin = i3;
                        h.c(obj8, i6);
                        imageView2.setLayoutParams(obj8);
                        imageView2.requestLayout();
                    }
                }
            }
            obj8 = this.a;
            if (obj8 != null) {
                i4 = TabLayout.g.c(obj8);
            }
            obj8 = Build.VERSION.SDK_INT;
            if (obj8 >= 21) {
                if (obj8 > 23) {
                    if (i5 != 0) {
                    } else {
                        i = i4;
                    }
                    v0.a(this, i);
                }
            } else {
            }
        }

        @Override // android.widget.LinearLayout
        protected void drawableStateChanged() {
            int[] drawableState;
            Drawable stateful;
            int i;
            super.drawableStateChanged();
            stateful = this.A;
            if (stateful != null && stateful.isStateful()) {
                if (stateful.isStateful()) {
                    i |= drawableState;
                }
            }
            if (i != 0) {
                invalidate();
                this.C.invalidate();
            }
        }

        @Override // android.widget.LinearLayout
        int getContentHeight() {
            int bottom2;
            int i;
            int top;
            int bottom;
            View view;
            int visibility;
            final int i2 = 3;
            final View[] arr = new View[i2];
            i = 0;
            arr[i] = this.b;
            final int i4 = 1;
            arr[i4] = this.c;
            arr[2] = this.x;
            bottom = top;
            while (i < i2) {
                view = arr[i];
                if (view != null && view.getVisibility() == 0) {
                }
                i++;
                if (view.getVisibility() == 0) {
                }
                if (bottom != 0) {
                } else {
                }
                top = view.getTop();
                if (bottom != 0) {
                } else {
                }
                bottom2 = view.getBottom();
                bottom = i4;
                bottom2 = Math.max(bottom2, view.getBottom());
                top = Math.min(top, view.getTop());
            }
            return bottom2 -= top;
        }

        @Override // android.widget.LinearLayout
        int getContentWidth() {
            int right;
            int i;
            int left;
            int right2;
            View view;
            int visibility;
            final int i2 = 3;
            final View[] arr = new View[i2];
            i = 0;
            arr[i] = this.b;
            final int i4 = 1;
            arr[i4] = this.c;
            arr[2] = this.x;
            right2 = left;
            while (i < i2) {
                view = arr[i];
                if (view != null && view.getVisibility() == 0) {
                }
                i++;
                if (view.getVisibility() == 0) {
                }
                if (right2 != 0) {
                } else {
                }
                left = view.getLeft();
                if (right2 != 0) {
                } else {
                }
                right = view.getRight();
                right2 = i4;
                right = Math.max(right, view.getRight());
                left = Math.min(left, view.getLeft());
            }
            return right -= left;
        }

        @Override // android.widget.LinearLayout
        public com.google.android.material.tabs.TabLayout.g getTab() {
            return this.a;
        }

        @Override // android.widget.LinearLayout
        void o() {
            setTab(0);
            setSelected(false);
        }

        @Override // android.widget.LinearLayout
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            a visible;
            boolean selected;
            StringBuilder stringBuilder;
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            visible = this.w;
            if (visible != null && visible.isVisible()) {
                if (visible.isVisible()) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(getContentDescription());
                    stringBuilder.append(", ");
                    stringBuilder.append(this.w.h());
                    accessibilityNodeInfo.setContentDescription(stringBuilder.toString());
                }
            }
            final c obj7 = c.y0(accessibilityNodeInfo);
            obj7.a0(c.c.a(0, 1, this.a.g(), 1, false, isSelected()));
            if (isSelected()) {
                obj7.Y(false);
                obj7.P(c.a.e);
            }
            obj7.o0(getResources().getString(j.h));
        }

        @Override // android.widget.LinearLayout
        public void onMeasure(int i, int i2) {
            int size;
            TextView view;
            int mode;
            int tabMaxWidth;
            int lineCount;
            int i4;
            int lineCount2;
            int paddingRight;
            int i3;
            int obj8;
            tabMaxWidth = this.C.getTabMaxWidth();
            if (tabMaxWidth > 0) {
                if (View.MeasureSpec.getMode(i) != 0) {
                    if (View.MeasureSpec.getSize(i) > tabMaxWidth) {
                        obj8 = View.MeasureSpec.makeMeasureSpec(obj8.J, Integer.MIN_VALUE);
                    }
                } else {
                }
            }
            super.onMeasure(obj8, i2);
            if (this.b != null) {
                view = tabLayout.G;
                mode = this.B;
                lineCount = this.c;
                i4 = 1;
                if (lineCount != null && lineCount.getVisibility() == 0) {
                    if (lineCount.getVisibility() == 0) {
                        mode = i4;
                    } else {
                        lineCount = this.b;
                        if (lineCount != null && lineCount.getLineCount() > i4) {
                            if (lineCount.getLineCount() > i4) {
                                view = tabLayout2.H;
                            }
                        }
                    }
                } else {
                }
                paddingRight = k.d(this.b);
                tabMaxWidth = Float.compare(view, textSize);
                if (tabMaxWidth == 0) {
                    i3 = 0;
                    if (paddingRight >= 0 && mode != paddingRight && tabLayout4.R == i4 && tabMaxWidth > 0 && this.b.getLineCount() == i4) {
                        if (mode != paddingRight) {
                            i3 = 0;
                            if (tabLayout4.R == i4) {
                                if (tabMaxWidth > 0) {
                                    if (this.b.getLineCount() == i4) {
                                        tabMaxWidth = this.b.getLayout();
                                        if (tabMaxWidth != null) {
                                            if (Float.compare(f, lineCount2) > 0) {
                                                i4 = i3;
                                            }
                                        } else {
                                        }
                                    }
                                }
                            }
                            if (i4 != 0) {
                                this.b.setTextSize(i3, view);
                                this.b.setMaxLines(mode);
                                super.onMeasure(obj8, i2);
                            }
                        }
                    }
                } else {
                }
            }
        }

        @Override // android.widget.LinearLayout
        public boolean performClick() {
            boolean click;
            if (this.a != null && !super.performClick()) {
                if (!super.performClick()) {
                    playSoundEffect(0);
                }
                this.a.l();
                click = 1;
            }
            return click;
        }

        @Override // android.widget.LinearLayout
        public void setSelected(boolean z) {
            int sDK_INT;
            int i;
            sDK_INT = isSelected() != z ? 1 : 0;
            super.setSelected(z);
            if (sDK_INT != 0 && z && Build.VERSION.SDK_INT < 16) {
                if (z) {
                    if (Build.VERSION.SDK_INT < 16) {
                        sendAccessibilityEvent(4);
                    }
                }
            }
            TextView view = this.b;
            if (view != null) {
                view.setSelected(z);
            }
            ImageView view2 = this.c;
            if (view2 != null) {
                view2.setSelected(z);
            }
            View view3 = this.x;
            if (view3 != null) {
                view3.setSelected(z);
            }
        }

        @Override // android.widget.LinearLayout
        void setTab(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
            if (g != this.a) {
                this.a = g;
                t();
            }
        }

        @Override // android.widget.LinearLayout
        final void t() {
            int i2;
            com.google.android.material.tabs.TabLayout.g gVar;
            int viewById;
            TextView empty;
            TextView view2;
            View viewById2;
            int i3;
            int i4;
            ImageView view;
            int i;
            gVar = this.a;
            viewById = 0;
            if (gVar != null) {
                i3 = gVar.e();
            } else {
                i3 = viewById;
            }
            if (i3 != 0) {
                android.view.ViewParent parent = i3.getParent();
                if (parent != this && parent != null) {
                    if (parent != null) {
                        (ViewGroup)parent.removeView(i3);
                    }
                    addView(i3);
                }
                this.x = i3;
                TextView view9 = this.b;
                i = 8;
                if (view9 != null) {
                    view9.setVisibility(i);
                }
                view = this.c;
                if (view != null) {
                    view.setVisibility(i);
                    this.c.setImageDrawable(viewById);
                }
                viewById2 = i3.findViewById(16908308);
                this.y = (TextView)viewById2;
                if (viewById2 != null) {
                    this.B = k.d(viewById2);
                }
                this.z = (ImageView)i3.findViewById(16908294);
            } else {
                i3 = this.x;
                if (i3 != null) {
                    removeView(i3);
                    this.x = viewById;
                }
                this.y = viewById;
                this.z = viewById;
            }
            if (this.x == null) {
                if (this.c == null) {
                    m();
                }
                if (this.b == null) {
                    n();
                    this.B = k.d(this.b);
                }
                k.q(this.b, tabLayout2.z);
                ColorStateList list = tabLayout.A;
                if (list != null) {
                    this.b.setTextColor(list);
                }
                w(this.b, this.c);
                r();
                f(this.c);
                f(this.b);
            } else {
                empty = this.y;
                if (empty == null) {
                    if (this.z != null) {
                        w(empty, this.z);
                    }
                } else {
                }
            }
            if (gVar != null && !TextUtils.isEmpty(TabLayout.g.c(gVar))) {
                if (!TextUtils.isEmpty(TabLayout.g.c(gVar))) {
                    setContentDescription(TabLayout.g.c(gVar));
                }
            }
            if (gVar != null && gVar.j()) {
                i2 = gVar.j() ? 1 : 0;
            } else {
            }
            setSelected(i2);
        }

        @Override // android.widget.LinearLayout
        final void v() {
            TextView view;
            ImageView view3;
            ImageView view2;
            setOrientation(z ^= 1);
            view = this.y;
            if (view == null) {
                if (this.z != null) {
                    w(view, this.z);
                } else {
                    w(this.b, this.c);
                }
            } else {
            }
        }
    }

    private class b implements ViewPager.i {

        private boolean a;
        final com.google.android.material.tabs.TabLayout b;
        b(com.google.android.material.tabs.TabLayout tabLayout) {
            this.b = tabLayout;
            super();
        }

        @Override // androidx.viewpager.widget.ViewPager$i
        public void a(ViewPager viewPager, a a2, a a3) {
            ViewPager obj2;
            final com.google.android.material.tabs.TabLayout obj3 = this.b;
            if (obj3.f0 == viewPager) {
                obj3.H(a3, this.a);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager$i
        void b(boolean z) {
            this.a = z;
        }
    }

    public interface d extends com.google.android.material.tabs.TabLayout.c<com.google.android.material.tabs.TabLayout.g> {
    }

    public static class h implements ViewPager.j {

        private final WeakReference<com.google.android.material.tabs.TabLayout> a;
        private int b;
        private int c;
        public h(com.google.android.material.tabs.TabLayout tabLayout) {
            super();
            WeakReference weakReference = new WeakReference(tabLayout);
            this.a = weakReference;
        }

        @Override // androidx.viewpager.widget.ViewPager$j
        void a() {
            final int i = 0;
            this.c = i;
            this.b = i;
        }

        @Override // androidx.viewpager.widget.ViewPager$j
        public void onPageScrollStateChanged(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager$j
        public void onPageScrolled(int i, float f2, int i3) {
            int i5;
            int i2;
            int i4;
            int i7;
            int i6;
            Object obj8 = this.a.get();
            if ((TabLayout)obj8 != null) {
                i5 = this.c;
                i4 = 2;
                i7 = 1;
                if (i5 == i4) {
                    if (this.b == i7) {
                        i6 = i7;
                    } else {
                        i6 = i2;
                    }
                } else {
                }
                if (i5 == i4) {
                    if (this.b != 0) {
                        i2 = i7;
                    }
                } else {
                }
                (TabLayout)obj8.J(i, f2, i6, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager$j
        public void onPageSelected(int i) {
            int selectedTabPosition;
            int i3;
            int i2;
            int obj4;
            Object obj = this.a.get();
            if (obj != null && (TabLayout)obj.getSelectedTabPosition() != i && i < obj.getTabCount()) {
                if (obj.getSelectedTabPosition() != i) {
                    if (i < obj.getTabCount()) {
                        i3 = this.c;
                        if (i3 != 0) {
                            if (i3 == 2 && this.b == 0) {
                                if (this.b == 0) {
                                    selectedTabPosition = 1;
                                } else {
                                    selectedTabPosition = 0;
                                }
                            } else {
                            }
                        } else {
                        }
                        obj.G(obj.x(i), selectedTabPosition);
                    }
                }
            }
        }
    }

    public static class j implements com.google.android.material.tabs.TabLayout.d {

        private final ViewPager a;
        public j(ViewPager viewPager) {
            super();
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout$d
        public void a(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        }

        @Override // com.google.android.material.tabs.TabLayout$d
        public void b(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
            this.a.setCurrentItem(g.g());
        }

        @Override // com.google.android.material.tabs.TabLayout$d
        public void c(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        }
    }
    static {
        TabLayout.m0 = k.l;
        h hVar = new h(16);
        TabLayout.n0 = hVar;
    }

    public TabLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.V);
    }

    public TabLayout(Context context, AttributeSet attributeSet2, int i3) {
        Object gVar;
        boolean defaultColor;
        boolean obj14;
        final int i11 = TabLayout.m0;
        super(a.c(context, attributeSet2, i3, i11), attributeSet2, i3);
        ArrayList obj12 = new ArrayList();
        this.a = obj12;
        obj12 = new GradientDrawable();
        this.D = obj12;
        obj12 = 0;
        this.E = obj12;
        this.J = Integer.MAX_VALUE;
        final int i12 = -1;
        this.U = i12;
        ArrayList arrayList = new ArrayList();
        this.c0 = arrayList;
        g gVar2 = new g(12);
        this.l0 = gVar2;
        final Context context2 = getContext();
        setHorizontalScrollBarEnabled(obj12);
        TabLayout.f fVar = new TabLayout.f(this, context2);
        this.c = fVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, i12);
        super.addView(fVar, obj12, layoutParams);
        final int i13 = 1;
        final int[] iArr2 = new int[i13];
        final int s4 = l.S4;
        iArr2[obj12] = s4;
        TypedArray obj13 = l.h(context2, attributeSet2, l.u4, i3, i11, iArr2);
        if (obj14 instanceof ColorDrawable) {
            gVar = new g();
            gVar.Z(ColorStateList.valueOf((ColorDrawable)getBackground().getColor()));
            gVar.O(context2);
            gVar.Y(u.w(this));
            u.o0(this, gVar);
        }
        setSelectedTabIndicator(c.d(context2, obj13, l.A4));
        setSelectedTabIndicatorColor(obj13.getColor(l.D4, obj12));
        fVar.g(obj13.getDimensionPixelSize(l.G4, i12));
        setSelectedTabIndicatorGravity(obj13.getInt(l.F4, obj12));
        setTabIndicatorAnimationMode(obj13.getInt(l.C4, obj12));
        setTabIndicatorFullWidth(obj13.getBoolean(l.E4, i13));
        obj14 = obj13.getDimensionPixelSize(l.L4, obj12);
        this.y = obj14;
        this.x = obj14;
        this.w = obj14;
        this.v = obj14;
        this.v = obj13.getDimensionPixelSize(l.O4, obj14);
        this.w = obj13.getDimensionPixelSize(l.P4, this.w);
        this.x = obj13.getDimensionPixelSize(l.N4, this.x);
        this.y = obj13.getDimensionPixelSize(l.M4, this.y);
        obj14 = obj13.getResourceId(s4, k.d);
        this.z = obj14;
        obj14 = context2.obtainStyledAttributes(obj14, j.J2);
        this.G = (float)dimensionPixelSize;
        this.A = c.a(context2, obj14, j.N2);
        obj14.recycle();
        obj14 = l.T4;
        if (obj13.hasValue(obj14)) {
            this.A = c.a(context2, obj13, obj14);
        }
        obj14 = l.R4;
        if (obj13.hasValue(obj14)) {
            this.A = TabLayout.p(this.A.getDefaultColor(), obj13.getColor(obj14, obj12));
        }
        this.B = c.a(context2, obj13, l.y4);
        this.F = n.f(obj13.getInt(l.z4, i12), 0);
        this.C = c.a(context2, obj13, l.Q4);
        this.P = obj13.getInt(l.B4, 300);
        this.K = obj13.getDimensionPixelSize(l.J4, i12);
        this.L = obj13.getDimensionPixelSize(l.I4, i12);
        this.I = obj13.getResourceId(l.v4, obj12);
        this.N = obj13.getDimensionPixelSize(l.w4, obj12);
        this.R = obj13.getInt(l.K4, i13);
        this.O = obj13.getInt(l.x4, obj12);
        this.S = obj13.getBoolean(l.H4, obj12);
        this.W = obj13.getBoolean(l.U4, obj12);
        obj13.recycle();
        obj12 = getResources();
        this.H = (float)obj13;
        this.M = obj12.getDimensionPixelSize(d.n);
        m();
    }

    private void E(int i) {
        int obj3;
        View childAt = this.c.getChildAt(i);
        this.c.removeViewAt(i);
        if ((TabLayout.i)childAt != null) {
            (TabLayout.i)childAt.o();
            this.l0.a(childAt);
        }
        requestLayout();
    }

    private void L(ViewPager viewPager, boolean z2, boolean z3) {
        Object view;
        com.google.android.material.tabs.TabLayout.c cVar;
        com.google.android.material.tabs.TabLayout.h hVar;
        com.google.android.material.tabs.TabLayout.b bVar;
        Object hVar2;
        int obj3;
        boolean obj4;
        view = this.f0;
        hVar2 = this.i0;
        if (view != null && hVar2 != null) {
            hVar2 = this.i0;
            if (hVar2 != null) {
                view.J(hVar2);
            }
            view = this.j0;
            if (view != null) {
                this.f0.I(view);
            }
        }
        cVar = this.d0;
        int i = 0;
        if (cVar != null) {
            D(cVar);
            this.d0 = i;
        }
        if (viewPager != null) {
            this.f0 = viewPager;
            if (this.i0 == null) {
                hVar = new TabLayout.h(this);
                this.i0 = hVar;
            }
            this.i0.a();
            viewPager.c(this.i0);
            TabLayout.j jVar = new TabLayout.j(viewPager);
            this.d0 = jVar;
            c(jVar);
            a adapter = viewPager.getAdapter();
            if (adapter != null) {
                H(adapter, z2);
            }
            if (this.j0 == null) {
                bVar = new TabLayout.b(this);
                this.j0 = bVar;
            }
            this.j0.b(z2);
            viewPager.b(this.j0);
            I(viewPager.getCurrentItem(), 0, true);
        } else {
            this.f0 = i;
            H(i, false);
        }
        this.k0 = z3;
    }

    private void M() {
        int i;
        Object obj;
        i = 0;
        while (i < this.a.size()) {
            (TabLayout.g)this.a.get(i).s();
            i++;
        }
    }

    private void N(LinearLayout.LayoutParams linearLayout$LayoutParams) {
        int i2;
        int i;
        if (this.R == 1 && this.O == 0) {
            if (this.O == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1065353216;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0;
            }
        } else {
        }
    }

    static com.google.android.material.tabs.b a(com.google.android.material.tabs.TabLayout tabLayout) {
        return tabLayout.a0;
    }

    static int b(com.google.android.material.tabs.TabLayout tabLayout) {
        return tabLayout.E;
    }

    private int getDefaultHeight() {
        int i;
        int size;
        int i3;
        int i2;
        Object empty;
        Drawable drawable;
        i2 = i3;
        while (i2 < this.a.size()) {
            empty = this.a.get(i2);
            if ((TabLayout.g)empty != null) {
                break;
            } else {
            }
            i2++;
            if ((TabLayout.g)empty.f() != null) {
                break;
            } else {
            }
            if (!TextUtils.isEmpty(empty.i())) {
                break;
            } else {
            }
        }
        if (i3 != 0 && !this.S) {
            i = !this.S ? 72 : 48;
        } else {
        }
        return i;
    }

    private int getTabMinWidth() {
        int i2;
        int i;
        int i3 = this.K;
        if (i3 != -1) {
            return i3;
        }
        int i4 = this.R;
        if (i4 != 0) {
            if (i4 == 2) {
                i2 = this.M;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    private int getTabScrollRange() {
        return Math.max(0, i2 -= paddingRight);
    }

    private void h(com.google.android.material.tabs.c c) {
        Object obj3;
        final com.google.android.material.tabs.TabLayout.g gVar = z();
        java.lang.CharSequence charSequence = c.a;
        if (charSequence != null) {
            gVar.r(charSequence);
        }
        Drawable drawable = c.b;
        if (drawable != null) {
            gVar.p(drawable);
        }
        int i = c.c;
        if (i != 0) {
            gVar.n(i);
        }
        if (!TextUtils.isEmpty(c.getContentDescription())) {
            gVar.m(c.getContentDescription());
        }
        e(gVar);
    }

    private void i(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        final com.google.android.material.tabs.TabLayout.i iVar = g.h;
        int i = 0;
        iVar.setSelected(i);
        iVar.setActivated(i);
        this.c.addView(iVar, g.g(), q());
    }

    private void j(View view) {
        if (!view instanceof c) {
        } else {
            h((c)view);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        throw obj2;
    }

    private void k(int i) {
        int scrollX;
        android.os.IBinder windowToken;
        ValueAnimator valueAnimator;
        int[] iArr;
        int i2;
        if (i == -1) {
        }
        int i4 = 1;
        int i6 = 0;
        if (getWindowToken() != null && u.R(this)) {
            if (u.R(this)) {
                if (this.c.d()) {
                } else {
                    scrollX = getScrollX();
                    int i7 = n(i, i6);
                    if (scrollX != i7) {
                        w();
                        iArr = new int[2];
                        iArr[i4] = i7;
                        this.e0.setIntValues(iArr);
                        this.e0.start();
                    }
                }
                this.c.c(i, this.P);
            }
        }
        I(i, i6, i4);
    }

    private void l(int i) {
        int str;
        com.google.android.material.tabs.TabLayout.f obj2;
        if (i != 0) {
            str = 1;
            if (i != str) {
                if (i != 2) {
                } else {
                    this.c.setGravity(8388611);
                }
            } else {
                this.c.setGravity(str);
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
    }

    private void m() {
        int i;
        int str;
        int i2;
        int str2;
        int i3;
        int i4 = this.R;
        str2 = 2;
        int i7 = 0;
        if (i4 != 0) {
            if (i4 == str2) {
                i = Math.max(i7, i5 -= i3);
            } else {
                i = i7;
            }
        } else {
        }
        u.y0(this.c, i, i7, i7, i7);
        i2 = this.R;
        int i8 = 1;
        if (i2 != 0) {
            if (i2 != i8 && i2 != str2) {
                if (i2 != str2) {
                } else {
                    if (this.O == str2) {
                        Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                    }
                    this.c.setGravity(i8);
                }
            } else {
            }
        } else {
            l(this.O);
        }
        O(i8);
    }

    private int n(int i, float f2) {
        int width;
        com.google.android.material.tabs.TabLayout.f childCount;
        View obj5;
        int i2 = this.R;
        width = 0;
        final int i9 = 2;
        if (i2 != 0 && i2 == i9) {
            if (i2 == i9) {
            }
            return width;
        }
        View childAt = this.c.getChildAt(i);
        if (childAt == null) {
            return width;
        }
        i++;
        if (obj5 < this.c.getChildCount()) {
            obj5 = this.c.getChildAt(obj5);
        } else {
            obj5 = 0;
        }
        int width3 = childAt.getWidth();
        if (obj5 != null) {
            width = obj5.getWidth();
        }
        obj5 -= i4;
        final int obj6 = (int)i6;
        obj5 = u.B(this) == 0 ? obj5 + obj6 : obj5 - obj6;
        return obj5;
    }

    private void o(com.google.android.material.tabs.TabLayout.g tabLayout$g, int i2) {
        ArrayList list;
        int obj3;
        g.q(i2);
        this.a.add(i2, g);
        obj3++;
        while (obj3 < this.a.size()) {
            (TabLayout.g)this.a.get(obj3).q(obj3);
            obj3++;
        }
    }

    private static ColorStateList p(int i, int i2) {
        int i3 = 2;
        final int[][] iArr2 = new int[i3];
        int[] iArr = new int[i3];
        final int i5 = 0;
        iArr2[i5] = HorizontalScrollView.SELECTED_STATE_SET;
        iArr[i5] = i2;
        int i4 = 1;
        iArr2[i4] = HorizontalScrollView.EMPTY_STATE_SET;
        iArr[i4] = i;
        ColorStateList obj4 = new ColorStateList(iArr2, iArr);
        return obj4;
    }

    private LinearLayout.LayoutParams q() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        N(layoutParams);
        return layoutParams;
    }

    private com.google.android.material.tabs.TabLayout.i s(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        int iVar;
        Context context;
        java.lang.CharSequence obj3;
        f fVar = this.l0;
        if (fVar != null) {
            iVar = fVar.b();
        } else {
            iVar = 0;
        }
        if (iVar == 0) {
            iVar = new TabLayout.i(this, getContext());
        }
        iVar.setTab(g);
        iVar.setFocusable(true);
        iVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(TabLayout.g.c(g))) {
            iVar.setContentDescription(TabLayout.g.d(g));
        } else {
            iVar.setContentDescription(TabLayout.g.c(g));
        }
        return iVar;
    }

    private void setSelectedTabView(int i) {
        int i4;
        int i2;
        View childAt;
        int i5;
        int i3;
        int childCount = this.c.getChildCount();
        if (i < childCount) {
            i4 = 0;
            i2 = i4;
            while (i2 < childCount) {
                childAt = this.c.getChildAt(i2);
                if (i2 == i) {
                } else {
                }
                i3 = i4;
                childAt.setSelected(i3);
                if (i2 == i) {
                } else {
                }
                i5 = i4;
                childAt.setActivated(i5);
                i2++;
                i3 = i5;
            }
        }
    }

    private void t(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        int i;
        Object obj;
        size--;
        while (i >= 0) {
            (TabLayout.c)this.c0.get(i).a(g);
            i--;
        }
    }

    private void u(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        int i;
        Object obj;
        size--;
        while (i >= 0) {
            (TabLayout.c)this.c0.get(i).b(g);
            i--;
        }
    }

    private void v(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        int i;
        Object obj;
        size--;
        while (i >= 0) {
            (TabLayout.c)this.c0.get(i).c(g);
            i--;
        }
    }

    private void w() {
        ValueAnimator valueAnimator;
        com.google.android.material.tabs.TabLayout.a aVar;
        if (this.e0 == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.e0 = valueAnimator2;
            valueAnimator2.setInterpolator(a.b);
            this.e0.setDuration((long)i);
            aVar = new TabLayout.a(this);
            this.e0.addUpdateListener(aVar);
        }
    }

    @Override // android.widget.HorizontalScrollView
    void A() {
        a currentItem;
        ViewPager selectedTabPosition;
        int i;
        com.google.android.material.tabs.TabLayout.g gVar;
        java.lang.CharSequence charSequence;
        C();
        currentItem = this.g0;
        if (currentItem != null) {
            currentItem = currentItem.d();
            int i2 = 0;
            i = i2;
            while (i < currentItem) {
                gVar = z();
                gVar.r(this.g0.f(i));
                g(gVar, i2);
                i++;
            }
            selectedTabPosition = this.f0;
            currentItem = selectedTabPosition.getCurrentItem();
            if (selectedTabPosition != null && currentItem > 0 && currentItem != getSelectedTabPosition() && currentItem < getTabCount()) {
                if (currentItem > 0) {
                    currentItem = selectedTabPosition.getCurrentItem();
                    if (currentItem != getSelectedTabPosition()) {
                        if (currentItem < getTabCount()) {
                            F(x(currentItem));
                        }
                    }
                }
            }
        }
    }

    @Override // android.widget.HorizontalScrollView
    protected boolean B(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        return TabLayout.n0.a(g);
    }

    @Override // android.widget.HorizontalScrollView
    public void C() {
        int i;
        Object next;
        childCount--;
        while (i >= 0) {
            E(i);
            i--;
        }
        Iterator iterator = this.a.iterator();
        for (TabLayout.g next : iterator) {
            iterator.remove();
            next.k();
            B(next);
        }
        this.b = 0;
    }

    @Deprecated
    public void D(com.google.android.material.tabs.TabLayout.c tabLayout$c) {
        this.c0.remove(c);
    }

    @Override // android.widget.HorizontalScrollView
    public void F(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        G(g, true);
    }

    @Override // android.widget.HorizontalScrollView
    public void G(com.google.android.material.tabs.TabLayout.g tabLayout$g, boolean z2) {
        int i;
        int i2;
        int i3;
        com.google.android.material.tabs.TabLayout.g obj5;
        int obj6;
        final com.google.android.material.tabs.TabLayout.g gVar = this.b;
        if (gVar == g) {
            if (gVar != null) {
                t(g);
                k(g.g());
            }
        } else {
            i = -1;
            if (g != null) {
                i2 = g.g();
            } else {
                i2 = i;
            }
            if (z2 != 0) {
                if (gVar != null) {
                    if (gVar.g() == i && i2 != i) {
                        if (i2 != i) {
                            I(i2, 0, true);
                        } else {
                            k(i2);
                        }
                    } else {
                    }
                } else {
                }
                if (i2 != i) {
                    setSelectedTabView(i2);
                }
            }
            this.b = g;
            if (gVar != null) {
                v(gVar);
            }
            if (g != null) {
                u(g);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView
    void H(a a, boolean z2) {
        DataSetObserver set;
        DataSetObserver obj4;
        final a aVar = this.g0;
        set = this.h0;
        if (aVar != null && set != null) {
            set = this.h0;
            if (set != null) {
                aVar.s(set);
            }
        }
        this.g0 = a;
        if (z2 != null && a != null && this.h0 == null) {
            if (a != null) {
                if (this.h0 == null) {
                    obj4 = new TabLayout.e(this);
                    this.h0 = obj4;
                }
                a.k(this.h0);
            }
        }
        A();
    }

    @Override // android.widget.HorizontalScrollView
    public void I(int i, float f2, boolean z3) {
        J(i, f2, z3, true);
    }

    @Override // android.widget.HorizontalScrollView
    public void J(int i, float f2, boolean z3, boolean z4) {
        int childCount;
        int obj3;
        int obj6;
        int round = Math.round(f += f2);
        if (round >= 0) {
            if (round >= this.c.getChildCount()) {
            } else {
                if (z4 != 0) {
                    this.c.f(i, f2);
                }
                obj6 = this.e0;
                if (obj6 != null && obj6.isRunning()) {
                    if (obj6.isRunning()) {
                        this.e0.cancel();
                    }
                }
                obj6 = 0;
                if (i < 0) {
                    obj3 = obj6;
                } else {
                    obj3 = n(i, f2);
                }
                scrollTo(obj3, obj6);
                if (z3) {
                    setSelectedTabView(round);
                }
            }
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void K(ViewPager viewPager, boolean z2) {
        L(viewPager, z2, false);
    }

    @Override // android.widget.HorizontalScrollView
    void O(boolean z) {
        int i;
        View childAt;
        ViewGroup.LayoutParams layoutParams;
        i = 0;
        while (i < this.c.getChildCount()) {
            childAt = this.c.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            N((LinearLayout.LayoutParams)childAt.getLayoutParams());
            if (z) {
            }
            i++;
            childAt.requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void addView(View view) {
        j(view);
    }

    @Override // android.widget.HorizontalScrollView
    public void addView(View view, int i2) {
        j(view);
    }

    @Override // android.widget.HorizontalScrollView
    public void addView(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
        j(view);
    }

    @Override // android.widget.HorizontalScrollView
    public void addView(View view, ViewGroup.LayoutParams viewGroup$LayoutParams2) {
        j(view);
    }

    @Deprecated
    public void c(com.google.android.material.tabs.TabLayout.c tabLayout$c) {
        boolean contains;
        if (!this.c0.contains(c)) {
            this.c0.add(c);
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void d(com.google.android.material.tabs.TabLayout.d tabLayout$d) {
        c(d);
    }

    @Override // android.widget.HorizontalScrollView
    public void e(com.google.android.material.tabs.TabLayout.g tabLayout$g) {
        g(g, this.a.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView
    public void f(com.google.android.material.tabs.TabLayout.g tabLayout$g, int i2, boolean z3) {
        if (g.g != this) {
        } else {
            o(g, i2);
            i(g);
            if (z3) {
                g.l();
            }
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Tab belongs to a different TabLayout.");
        throw obj2;
    }

    @Override // android.widget.HorizontalScrollView
    public void g(com.google.android.material.tabs.TabLayout.g tabLayout$g, boolean z2) {
        f(g, this.a.size(), z2);
    }

    @Override // android.widget.HorizontalScrollView
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    @Override // android.widget.HorizontalScrollView
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.HorizontalScrollView
    public int getSelectedTabPosition() {
        int i;
        com.google.android.material.tabs.TabLayout.g gVar = this.b;
        if (gVar != null) {
            i = gVar.g();
        } else {
            i = -1;
        }
        return i;
    }

    @Override // android.widget.HorizontalScrollView
    public int getTabCount() {
        return this.a.size();
    }

    @Override // android.widget.HorizontalScrollView
    public int getTabGravity() {
        return this.O;
    }

    @Override // android.widget.HorizontalScrollView
    public ColorStateList getTabIconTint() {
        return this.B;
    }

    @Override // android.widget.HorizontalScrollView
    public int getTabIndicatorAnimationMode() {
        return this.V;
    }

    @Override // android.widget.HorizontalScrollView
    public int getTabIndicatorGravity() {
        return this.Q;
    }

    @Override // android.widget.HorizontalScrollView
    int getTabMaxWidth() {
        return this.J;
    }

    @Override // android.widget.HorizontalScrollView
    public int getTabMode() {
        return this.R;
    }

    @Override // android.widget.HorizontalScrollView
    public ColorStateList getTabRippleColor() {
        return this.C;
    }

    @Override // android.widget.HorizontalScrollView
    public Drawable getTabSelectedIndicator() {
        return this.D;
    }

    @Override // android.widget.HorizontalScrollView
    public ColorStateList getTabTextColors() {
        return this.A;
    }

    @Override // android.widget.HorizontalScrollView
    protected void onAttachedToWindow() {
        Object parent;
        boolean z;
        super.onAttachedToWindow();
        h.e(this);
        parent = getParent();
        if (this.f0 == null && parent instanceof ViewPager) {
            parent = getParent();
            if (parent instanceof ViewPager) {
                z = 1;
                L((ViewPager)parent, z, z);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView
    protected void onDetachedFromWindow() {
        boolean z;
        super.onDetachedFromWindow();
        if (this.k0) {
            setupWithViewPager(0);
            this.k0 = false;
        }
    }

    @Override // android.widget.HorizontalScrollView
    protected void onDraw(Canvas canvas) {
        int i;
        View childAt;
        boolean z;
        i = 0;
        while (i < this.c.getChildCount()) {
            childAt = this.c.getChildAt(i);
            if (childAt instanceof TabLayout.i) {
            }
            i++;
            TabLayout.i.c((TabLayout.i)childAt, canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.HorizontalScrollView
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        final int i = 1;
        c.y0(accessibilityNodeInfo).Z(c.b.a(i, getTabCount(), false, i));
    }

    @Override // android.widget.HorizontalScrollView
    protected void onMeasure(int i, int i2) {
        int round;
        int measuredWidth2;
        int childCount;
        int measuredWidth;
        int i3;
        int i4;
        int obj7;
        int obj8;
        round = Math.round(n.c(getContext(), getDefaultHeight()));
        childCount = View.MeasureSpec.getMode(i2);
        final int i7 = 1073741824;
        i4 = 0;
        final int i8 = 1;
        if (childCount != Integer.MIN_VALUE) {
            if (childCount != 0) {
            } else {
                obj8 = View.MeasureSpec.makeMeasureSpec(i5 += obj8, i7);
            }
        } else {
            if (getChildCount() == i8 && View.MeasureSpec.getSize(i2) >= round) {
                if (View.MeasureSpec.getSize(i2) >= round) {
                    getChildAt(i4).setMinimumHeight(round);
                }
            }
        }
        if (View.MeasureSpec.getMode(i) != 0) {
            if (this.L > 0) {
            } else {
                measuredWidth = (int)measuredWidth2;
            }
            this.J = measuredWidth;
        }
        super.onMeasure(i, obj8);
        if (getChildCount() == i8) {
            obj7 = getChildAt(i4);
            measuredWidth2 = this.R;
            if (measuredWidth2 != 0) {
                if (measuredWidth2 != i8) {
                    if (measuredWidth2 != 2) {
                    } else {
                        i4 = i8;
                    }
                } else {
                    if (obj7.getMeasuredWidth() != getMeasuredWidth()) {
                    }
                }
            } else {
            }
            if (i4 != 0) {
                obj7.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), i7), HorizontalScrollView.getChildMeasureSpec(obj8, paddingTop += paddingBottom, layoutParams.height));
            }
        }
    }

    @Override // android.widget.HorizontalScrollView
    protected com.google.android.material.tabs.TabLayout.g r() {
        Object gVar;
        if ((TabLayout.g)TabLayout.n0.b() == null) {
            gVar = new TabLayout.g();
        }
        return gVar;
    }

    @Override // android.widget.HorizontalScrollView
    public void setElevation(float f) {
        super.setElevation(f);
        h.d(this, f);
    }

    @Override // android.widget.HorizontalScrollView
    public void setInlineLabel(boolean z) {
        boolean childCount;
        boolean z2;
        boolean obj3;
        if (this.S != z) {
            this.S = z;
            obj3 = 0;
            while (obj3 < this.c.getChildCount()) {
                childCount = this.c.getChildAt(obj3);
                if (childCount instanceof TabLayout.i) {
                }
                obj3++;
                (TabLayout.i)childCount.v();
            }
            m();
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(com.google.android.material.tabs.TabLayout.c tabLayout$c) {
        final com.google.android.material.tabs.TabLayout.c cVar = this.b0;
        if (cVar != null) {
            D(cVar);
        }
        this.b0 = c;
        if (c != null) {
            c(c);
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(com.google.android.material.tabs.TabLayout.d tabLayout$d) {
        setOnTabSelectedListener(d);
    }

    @Override // android.widget.HorizontalScrollView
    void setScrollAnimatorListener(Animator.AnimatorListener animator$AnimatorListener) {
        w();
        this.e0.addListener(animatorListener);
    }

    @Override // android.widget.HorizontalScrollView
    public void setSelectedTabIndicator(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            setSelectedTabIndicator(a.d(getContext(), i));
        } else {
            setSelectedTabIndicator(0);
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void setSelectedTabIndicator(Drawable drawable) {
        int intrinsicHeight;
        int i;
        Object obj3;
        if (this.D != drawable) {
            if (drawable != null) {
            } else {
                obj3 = new GradientDrawable();
            }
            this.D = obj3;
            if (this.U != -1) {
            } else {
                intrinsicHeight = obj3.getIntrinsicHeight();
            }
            this.c.g(intrinsicHeight);
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void setSelectedTabIndicatorColor(int i) {
        this.E = i;
        O(false);
    }

    @Override // android.widget.HorizontalScrollView
    public void setSelectedTabIndicatorGravity(int i) {
        int obj2;
        if (this.Q != i) {
            this.Q = i;
            u.c0(this.c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.U = i;
        this.c.g(i);
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabGravity(int i) {
        if (this.O != i) {
            this.O = i;
            m();
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            M();
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabIconTintResource(int i) {
        setTabIconTint(a.c(getContext(), i));
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabIndicatorAnimationMode(int i) {
        int i2;
        com.google.android.material.tabs.b obj3;
        this.V = i;
        if (i != 0) {
            if (i != 1) {
            } else {
                obj3 = new a();
                this.a0 = obj3;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(" is not a valid TabIndicatorAnimationMode");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        obj3 = new b();
        this.a0 = obj3;
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabIndicatorFullWidth(boolean z) {
        this.T = z;
        TabLayout.f.a(this.c);
        u.c0(this.c);
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabMode(int i) {
        if (i != this.R) {
            this.R = i;
            m();
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabRippleColor(ColorStateList colorStateList) {
        ColorStateList childCount;
        boolean context;
        int obj3;
        if (this.C != colorStateList) {
            this.C = colorStateList;
            obj3 = 0;
            while (obj3 < this.c.getChildCount()) {
                childCount = this.c.getChildAt(obj3);
                if (childCount instanceof TabLayout.i) {
                }
                obj3++;
                TabLayout.i.b((TabLayout.i)childCount, getContext());
            }
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabRippleColorResource(int i) {
        setTabRippleColor(a.c(getContext(), i));
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            M();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(a a) {
        H(a, false);
    }

    @Override // android.widget.HorizontalScrollView
    public void setUnboundedRipple(boolean z) {
        boolean childCount;
        boolean context;
        int obj3;
        if (this.W != z) {
            this.W = z;
            obj3 = 0;
            while (obj3 < this.c.getChildCount()) {
                childCount = this.c.getChildAt(obj3);
                if (childCount instanceof TabLayout.i) {
                }
                obj3++;
                TabLayout.i.b((TabLayout.i)childCount, getContext());
            }
        }
    }

    @Override // android.widget.HorizontalScrollView
    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    @Override // android.widget.HorizontalScrollView
    public void setupWithViewPager(ViewPager viewPager) {
        K(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView
    public boolean shouldDelayChildPressedState() {
        int i;
        i = getTabScrollRange() > 0 ? 1 : 0;
        return i;
    }

    @Override // android.widget.HorizontalScrollView
    public com.google.android.material.tabs.TabLayout.g x(int i) {
        ArrayList tabCount;
        Object obj2;
        if (i >= 0) {
            if (i >= getTabCount()) {
                obj2 = 0;
            } else {
                obj2 = this.a.get(i);
            }
        } else {
        }
        return obj2;
    }

    @Override // android.widget.HorizontalScrollView
    public boolean y() {
        return this.T;
    }

    @Override // android.widget.HorizontalScrollView
    public com.google.android.material.tabs.TabLayout.g z() {
        int i2;
        int i;
        final com.google.android.material.tabs.TabLayout.g gVar = r();
        gVar.g = this;
        gVar.h = s(gVar);
        if (TabLayout.g.a(gVar) != -1) {
            gVar.h.setId(TabLayout.g.a(gVar));
        }
        return gVar;
    }
}
