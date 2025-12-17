package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.k;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.d;
import f.c.a.e.f;
import f.c.a.e.m.a;
import f.c.a.e.m.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class f {

    private final Context a;
    private final com.google.android.material.textfield.TextInputLayout b;
    private LinearLayout c;
    private int d;
    private FrameLayout e;
    private Animator f;
    private final float g;
    private int h;
    private int i;
    private java.lang.CharSequence j;
    private boolean k;
    private TextView l;
    private java.lang.CharSequence m;
    private int n;
    private ColorStateList o;
    private java.lang.CharSequence p;
    private boolean q;
    private TextView r;
    private int s;
    private ColorStateList t;
    private Typeface u;

    class a extends AnimatorListenerAdapter {

        final int a;
        final TextView b;
        final int c;
        final TextView d;
        final com.google.android.material.textfield.f e;
        a(com.google.android.material.textfield.f f, int i2, TextView textView3, int i4, TextView textView5) {
            this.e = f;
            this.a = i2;
            this.b = textView3;
            this.c = i4;
            this.d = textView5;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            int i;
            int i2;
            TextView obj3;
            f.a(this.e, this.a);
            i = 0;
            f.b(this.e, i);
            obj3 = this.b;
            obj3.setVisibility(4);
            if (obj3 != null && this.c == 1 && f.c(this.e) != null) {
                obj3.setVisibility(4);
                if (this.c == 1) {
                    if (f.c(this.e) != null) {
                        f.c(this.e).setText(i);
                    }
                }
            }
            obj3 = this.d;
            if (obj3 != null) {
                obj3.setTranslationY(0);
                this.d.setAlpha(1065353216);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            int i;
            final TextView obj2 = this.d;
            if (obj2 != null) {
                obj2.setVisibility(0);
            }
        }
    }
    public f(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        super();
        Context context = textInputLayout.getContext();
        this.a = context;
        this.b = textInputLayout;
        this.g = (float)obj2;
    }

    private void A(int i, int i2) {
        TextView view;
        int i3;
        int obj3;
        if (i == i2) {
        }
        view = l(i2);
        if (i2 != 0 && view != null) {
            view = l(i2);
            if (view != null) {
                view.setVisibility(0);
                view.setAlpha(1065353216);
            }
        }
        view = l(i);
        view.setVisibility(4);
        if (i != 0 && view != null && i == 1) {
            view = l(i);
            if (view != null) {
                view.setVisibility(4);
                if (i == 1) {
                    view.setText(0);
                }
            }
        }
        this.h = i2;
    }

    private void I(TextView textView, Typeface typeface2) {
        if (textView != null) {
            textView.setTypeface(typeface2);
        }
    }

    private void K(ViewGroup viewGroup, int i2) {
        int obj2;
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean L(TextView textView, java.lang.CharSequence charSequence2) {
        boolean enabled;
        int i;
        int obj3;
        if (u.R(this.b) && this.b.isEnabled()) {
            if (this.b.isEnabled()) {
                if (this.i == this.h && textView != null) {
                    if (textView != null) {
                        obj3 = !TextUtils.equals(textView.getText(), charSequence2) ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private void O(int i, int i2, boolean z3) {
        com.google.android.material.textfield.f.a aVar;
        com.google.android.material.textfield.f fVar;
        int i3;
        TextView view2;
        int i4;
        TextView view;
        com.google.android.material.textfield.f.a aVar2;
        AnimatorSet animatorSet;
        ArrayList arrayList;
        final Object obj2 = this;
        final boolean z4 = z3;
        if (i == i2) {
        }
        if (z4) {
            animatorSet = new AnimatorSet();
            obj2.f = animatorSet;
            arrayList = new ArrayList();
            Object obj = this;
            ArrayList list = arrayList;
            int i7 = i;
            int i8 = i2;
            obj.h(list, obj2.q, obj2.r, 2, i7, i8);
            obj.h(list, obj2.k, obj2.l, 1, i7, i8);
            b.a(animatorSet, arrayList);
            super(this, i2, l(i), i, l(i2));
            animatorSet.addListener(aVar2);
            animatorSet.start();
        } else {
            A(i, i2);
        }
        obj2.b.t0();
        obj2.b.w0(z4);
        obj2.b.G0();
    }

    static int a(com.google.android.material.textfield.f f, int i2) {
        f.h = i2;
        return i2;
    }

    static Animator b(com.google.android.material.textfield.f f, Animator animator2) {
        f.f = animator2;
        return animator2;
    }

    static TextView c(com.google.android.material.textfield.f f) {
        return f.l;
    }

    private boolean f() {
        Object editText;
        int i;
        if (this.c != null && this.b.getEditText() != null) {
            i = this.b.getEditText() != null ? 1 : 0;
        } else {
        }
        return i;
    }

    private void h(List<Animator> list, boolean z2, TextView textView3, int i4, int i5, int i6) {
        ObjectAnimator obj2;
        if (textView3 != null) {
            if (z2 == null) {
            } else {
                if (i4 != i6) {
                    if (i4 == i5) {
                        obj2 = i6 == i4 ? 1 : 0;
                        list.add(i(textView3, obj2));
                        if (i6 == i4) {
                            list.add(j(textView3));
                        }
                    }
                } else {
                }
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z2) {
        int obj5;
        obj5 = z2 ? 1065353216 : 0;
        float[] fArr = new float[1];
        final ObjectAnimator obj4 = ObjectAnimator.ofFloat(textView, View.ALPHA, obj5);
        obj4.setDuration(167);
        obj4.setInterpolator(a.a);
        return obj4;
    }

    private ObjectAnimator j(TextView textView) {
        float[] fArr = new float[2];
        final ObjectAnimator obj5 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -f, 0);
        obj5.setDuration(217);
        obj5.setInterpolator(a.d);
        return obj5;
    }

    private TextView l(int i) {
        if (i != 1 && i != 2) {
            if (i != 2) {
                return null;
            }
            return this.r;
        }
        return this.l;
    }

    private int s(boolean z, int i2, int i3) {
        Resources obj1;
        int obj3;
        if (z != null) {
            obj3 = this.a.getResources().getDimensionPixelSize(i2);
        }
        return obj3;
    }

    private boolean v(int i) {
        int i2;
        boolean obj2;
        if (i == 1 && this.l != null && !TextUtils.isEmpty(this.j)) {
            if (this.l != null) {
                if (!TextUtils.isEmpty(this.j)) {
                } else {
                    i2 = 0;
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    void B(java.lang.CharSequence charSequence) {
        this.m = charSequence;
        final TextView view = this.l;
        if (view != null) {
            view.setContentDescription(charSequence);
        }
    }

    void C(boolean z) {
        int i3;
        int sDK_INT;
        TextView view;
        int i2;
        int i;
        if (this.k == z) {
        }
        g();
        i3 = 0;
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
            this.l = appCompatTextView;
            appCompatTextView.setId(f.e0);
            if (Build.VERSION.SDK_INT >= 17) {
                this.l.setTextAlignment(5);
            }
            Typeface typeface = this.u;
            if (typeface != null) {
                this.l.setTypeface(typeface);
            }
            D(this.n);
            E(this.o);
            B(this.m);
            this.l.setVisibility(4);
            u.n0(this.l, 1);
            d(this.l, i3);
        } else {
            t();
            z(this.l, i3);
            this.l = 0;
            this.b.t0();
            this.b.G0();
        }
        this.k = z;
    }

    void D(int i) {
        com.google.android.material.textfield.TextInputLayout textInputLayout;
        this.n = i;
        final TextView view = this.l;
        if (view != null) {
            this.b.g0(view, i);
        }
    }

    void E(ColorStateList colorStateList) {
        this.o = colorStateList;
        final TextView view = this.l;
        if (view != null && colorStateList != null) {
            if (colorStateList != null) {
                view.setTextColor(colorStateList);
            }
        }
    }

    void F(int i) {
        this.s = i;
        final TextView view = this.r;
        if (view != null) {
            k.q(view, i);
        }
    }

    void G(boolean z) {
        int i3;
        int sDK_INT;
        TextView view;
        int i;
        int i2;
        if (this.q == z) {
        }
        g();
        i3 = 1;
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
            this.r = appCompatTextView;
            appCompatTextView.setId(f.f0);
            if (Build.VERSION.SDK_INT >= 17) {
                this.r.setTextAlignment(5);
            }
            Typeface typeface = this.u;
            if (typeface != null) {
                this.r.setTypeface(typeface);
            }
            this.r.setVisibility(4);
            u.n0(this.r, i3);
            F(this.s);
            H(this.t);
            d(this.r, i3);
        } else {
            u();
            z(this.r, i3);
            this.r = 0;
            this.b.t0();
            this.b.G0();
        }
        this.q = z;
    }

    void H(ColorStateList colorStateList) {
        this.t = colorStateList;
        final TextView view = this.r;
        if (view != null && colorStateList != null) {
            if (colorStateList != null) {
                view.setTextColor(colorStateList);
            }
        }
    }

    void J(Typeface typeface) {
        Object typeface2;
        if (typeface != this.u) {
            this.u = typeface;
            I(this.l, typeface);
            I(this.r, typeface);
        }
    }

    void M(java.lang.CharSequence charSequence) {
        g();
        this.j = charSequence;
        this.l.setText(charSequence);
        int i = this.h;
        int i2 = 1;
        if (i != i2) {
            this.i = i2;
        }
        O(i, this.i, L(this.l, charSequence));
    }

    void N(java.lang.CharSequence charSequence) {
        g();
        this.p = charSequence;
        this.r.setText(charSequence);
        int i = this.h;
        int i2 = 2;
        if (i != i2) {
            this.i = i2;
        }
        O(i, this.i, L(this.r, charSequence));
    }

    void d(TextView textView, int i2) {
        Object editText;
        LinearLayout linearLayout;
        FrameLayout frameLayout;
        Object obj7;
        final int i = 0;
        final int i3 = -2;
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        this.c = linearLayout2;
        linearLayout2.setOrientation(i);
        this.b.addView(this.c, -1, i3);
        FrameLayout frameLayout2 = new FrameLayout(this.a);
        this.e = frameLayout2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i3, 1065353216);
        this.c.addView(this.e, layoutParams);
        if (this.c == null && this.e == null && this.b.getEditText() != null) {
            if (this.e == null) {
                linearLayout2 = new LinearLayout(this.a);
                this.c = linearLayout2;
                linearLayout2.setOrientation(i);
                this.b.addView(this.c, -1, i3);
                frameLayout2 = new FrameLayout(this.a);
                this.e = frameLayout2;
                layoutParams = new LinearLayout.LayoutParams(i, i3, 1065353216);
                this.c.addView(this.e, layoutParams);
                if (this.b.getEditText() != null) {
                    e();
                }
            }
        }
        if (w(i2)) {
            this.e.setVisibility(i);
            this.e.addView(textView);
        } else {
            obj7 = new LinearLayout.LayoutParams(i3, i3);
            this.c.addView(textView, obj7);
        }
        this.c.setVisibility(i);
        this.d = obj6++;
    }

    void e() {
        boolean z;
        int i5;
        LinearLayout linearLayout;
        int i;
        int i3;
        int i2;
        int dimensionPixelSize;
        int i4;
        if (f()) {
            android.widget.EditText editText = this.b.getEditText();
            boolean z2 = c.g(this.a);
            i = d.B;
            u.y0(this.c, s(z2, i, u.G(editText)), s(z2, d.C, this.a.getResources().getDimensionPixelSize(d.A)), s(z2, i, u.F(editText)), 0);
        }
    }

    void g() {
        final Animator animator = this.f;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean k() {
        return v(this.i);
    }

    java.lang.CharSequence m() {
        return this.m;
    }

    java.lang.CharSequence n() {
        return this.j;
    }

    int o() {
        int currentTextColor;
        TextView view = this.l;
        if (view != null) {
            currentTextColor = view.getCurrentTextColor();
        } else {
            currentTextColor = -1;
        }
        return currentTextColor;
    }

    ColorStateList p() {
        ColorStateList textColors;
        TextView view = this.l;
        if (view != null) {
            textColors = view.getTextColors();
        } else {
            textColors = 0;
        }
        return textColors;
    }

    java.lang.CharSequence q() {
        return this.p;
    }

    int r() {
        int currentTextColor;
        TextView view = this.r;
        if (view != null) {
            currentTextColor = view.getCurrentTextColor();
        } else {
            currentTextColor = -1;
        }
        return currentTextColor;
    }

    void t() {
        boolean empty;
        int i;
        int i2 = 0;
        this.j = i2;
        g();
        if (this.h == 1) {
            if (this.q && !TextUtils.isEmpty(this.p)) {
                if (!TextUtils.isEmpty(this.p)) {
                    this.i = 2;
                } else {
                    this.i = 0;
                }
            } else {
            }
        }
        O(this.h, this.i, L(this.l, i2));
    }

    void u() {
        int i;
        g();
        final int i2 = this.h;
        if (i2 == 2) {
            this.i = 0;
        }
        O(i2, this.i, L(this.r, 0));
    }

    boolean w(int i) {
        int i2;
        if (i != 0) {
            if (i == 1) {
            } else {
                i2 = 0;
            }
        }
        return i2;
    }

    boolean x() {
        return this.k;
    }

    boolean y() {
        return this.q;
    }

    void z(TextView textView, int i2) {
        boolean obj3;
        if (this.c == null) {
        }
        obj3 = this.e;
        if (w(i2) && obj3 != null) {
            obj3 = this.e;
            if (obj3 != null) {
                obj3.removeView(textView);
            } else {
                this.c.removeView(textView);
            }
        } else {
        }
        obj2--;
        this.d = obj2;
        K(this.c, obj2);
    }
}
