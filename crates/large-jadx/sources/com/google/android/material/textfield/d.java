package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.AutoCompleteTextView.OnDismissListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.k;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.e;
import f.c.a.e.j;
import f.c.a.e.m.a;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
class d extends com.google.android.material.textfield.e {

    private static final boolean r = false;
    private final TextWatcher e;
    private final View.OnFocusChangeListener f;
    private final com.google.android.material.textfield.TextInputLayout.e g;
    private final com.google.android.material.textfield.TextInputLayout.f h;
    private final com.google.android.material.textfield.TextInputLayout.g i;
    private boolean j = false;
    private boolean k = false;
    private long l = Long.MAX_VALUE;
    private StateListDrawable m;
    private g n;
    private AccessibilityManager o;
    private ValueAnimator p;
    private ValueAnimator q;

    class b implements ValueAnimator.AnimatorUpdateListener {

        final com.google.android.material.textfield.d a;
        b(com.google.android.material.textfield.d d) {
            this.a = d;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            dVar.c.setAlpha((Float)valueAnimator.getAnimatedValue().floatValue());
        }
    }

    class c implements View.OnFocusChangeListener {

        final com.google.android.material.textfield.d a;
        c(com.google.android.material.textfield.d d) {
            this.a = d;
            super();
        }

        @Override // android.view.View$OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            Object obj1;
            boolean obj2;
            obj1.a.setEndIconActivated(z2);
            if (!z2) {
                obj2 = 0;
                d.o(this.a, obj2);
                d.p(this.a, obj2);
            }
        }
    }

    class g implements View.OnClickListener {

        final com.google.android.material.textfield.d a;
        g(com.google.android.material.textfield.d d) {
            this.a = d;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            d.q(this.a, (AutoCompleteTextView)obj2.a.getEditText());
        }
    }

    class h implements View.OnTouchListener {

        final AutoCompleteTextView a;
        final com.google.android.material.textfield.d b;
        h(com.google.android.material.textfield.d d, AutoCompleteTextView autoCompleteTextView2) {
            this.b = d;
            this.a = autoCompleteTextView2;
            super();
        }

        @Override // android.view.View$OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent2) {
            int i;
            boolean obj2;
            final int obj3 = 0;
            if (motionEvent2.getAction() == 1 && d.j(this.b)) {
                if (d.j(this.b)) {
                    d.p(this.b, obj3);
                }
                d.q(this.b, this.a);
            }
            return obj3;
        }
    }

    class i implements AutoCompleteTextView.OnDismissListener {

        final com.google.android.material.textfield.d a;
        i(com.google.android.material.textfield.d d) {
            this.a = d;
            super();
        }

        @Override // android.widget.AutoCompleteTextView$OnDismissListener
        public void onDismiss() {
            d.p(this.a, true);
            d.k(this.a, System.currentTimeMillis());
            d.o(this.a, false);
        }
    }

    class j extends AnimatorListenerAdapter {

        final com.google.android.material.textfield.d a;
        j(com.google.android.material.textfield.d d) {
            this.a = d;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            com.google.android.material.textfield.d obj2 = this.a;
            obj2.c.setChecked(d.l(obj2));
            d.m(this.a).start();
        }
    }

    class a extends k {

        final com.google.android.material.textfield.d a;
        a(com.google.android.material.textfield.d d) {
            this.a = d;
            super();
        }

        @Override // com.google.android.material.internal.k
        public void afterTextChanged(Editable editable) {
            boolean touchExplorationEnabled;
            AutoCompleteTextView obj2 = d.e(obj2.a.getEditText());
            if (d.f(this.a).isTouchExplorationEnabled() && d.n(obj2) && !dVar2.c.hasFocus()) {
                if (d.n(obj2)) {
                    if (!dVar2.c.hasFocus()) {
                        obj2.dismissDropDown();
                    }
                }
            }
            d.a.a aVar = new d.a.a(this, obj2);
            obj2.post(aVar);
        }
    }

    class e implements com.google.android.material.textfield.TextInputLayout.f {

        final com.google.android.material.textfield.d a;
        e(com.google.android.material.textfield.d d) {
            this.a = d;
            super();
        }

        @Override // com.google.android.material.textfield.TextInputLayout$f
        public void a(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            boolean z;
            int i;
            AutoCompleteTextView view = d.e(textInputLayout.getEditText());
            d.r(this.a, view);
            d.s(this.a, view);
            d.t(this.a, view);
            view.setThreshold(0);
            view.removeTextChangedListener(d.u(this.a));
            view.addTextChangedListener(d.u(this.a));
            int i3 = 1;
            textInputLayout.setEndIconCheckable(i3);
            textInputLayout.setErrorIconDrawable(0);
            if (!d.n(view)) {
                u.v0(dVar2.c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.g(this.a));
            textInputLayout.setEndIconVisible(i3);
        }
    }

    class f implements com.google.android.material.textfield.TextInputLayout.g {

        final com.google.android.material.textfield.d a;
        f(com.google.android.material.textfield.d d) {
            this.a = d;
            super();
        }

        @Override // com.google.android.material.textfield.TextInputLayout$g
        public void a(com.google.android.material.textfield.TextInputLayout textInputLayout, int i2) {
            int i;
            int i3;
            int obj4;
            final EditText obj3 = textInputLayout.getEditText();
            obj4 = new d.f.a(this, (AutoCompleteTextView)obj3);
            obj3.post(obj4);
            i3 = 0;
            if (obj3 != null && i2 == 3 && obj3.getOnFocusChangeListener() == d.h(this.a)) {
                if (i2 == 3) {
                    obj4 = new d.f.a(this, obj3);
                    obj3.post(obj4);
                    i3 = 0;
                    if (obj3.getOnFocusChangeListener() == d.h(this.a)) {
                        obj3.setOnFocusChangeListener(i3);
                    }
                    obj3.setOnTouchListener(i3);
                    if (d.i()) {
                        obj3.setOnDismissListener(i3);
                    }
                }
            }
        }
    }

    class d extends com.google.android.material.textfield.TextInputLayout.e {

        final com.google.android.material.textfield.d e;
        d(com.google.android.material.textfield.d d, com.google.android.material.textfield.TextInputLayout textInputLayout2) {
            this.e = d;
            super(textInputLayout2);
        }

        @Override // com.google.android.material.textfield.TextInputLayout$e
        public void g(View view, c c2) {
            boolean obj1;
            super.g(view, c2);
            if (!d.n(obj1.a.getEditText())) {
                c2.X(Spinner.class.getName());
            }
            if (c2.J()) {
                c2.i0(0);
            }
        }

        @Override // com.google.android.material.textfield.TextInputLayout$e
        public void h(View view, AccessibilityEvent accessibilityEvent2) {
            int obj3;
            super.h(view, accessibilityEvent2);
            if (accessibilityEvent2.getEventType() == 1 && d.f(this.e).isTouchExplorationEnabled() && !d.n(obj3.a.getEditText())) {
                if (d.f(this.e).isTouchExplorationEnabled()) {
                    if (!d.n(obj3.a.getEditText())) {
                        d.q(this.e, d.e(obj2.a.getEditText()));
                    }
                }
            }
        }
    }
    static {
        if (Build.VERSION.SDK_INT >= 21) {
            int i = 1;
        }
        int i2 = 0;
    }

    d(com.google.android.material.textfield.TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
        d.a obj1 = new d.a(this);
        this.e = obj1;
        obj1 = new d.c(this);
        this.f = obj1;
        obj1 = new d.d(this, this.a);
        this.g = obj1;
        obj1 = new d.e(this);
        this.h = obj1;
        obj1 = new d.f(this);
        this.i = obj1;
        obj1 = 0;
        obj1 = Long.MAX_VALUE;
    }

    private g A(float f, float f2, float f3, int i4) {
        final k.b bVar = k.a();
        bVar.C(f);
        bVar.G(f);
        bVar.u(f2);
        bVar.y(f2);
        g obj3 = g.m(this.b, f3);
        obj3.setShapeAppearanceModel(bVar.m());
        int obj2 = 0;
        obj3.b0(obj2, i4, obj2, i4);
        return obj3;
    }

    private void B() {
        int i = 2;
        float[] fArr2 = new float[i];
        fArr2 = new int[]{0, 1065353216};
        this.q = z(67, fArr2);
        float[] fArr = new float[i];
        fArr = new int[]{1065353216, 0};
        ValueAnimator valueAnimator = z(50, fArr);
        this.p = valueAnimator;
        d.j jVar = new d.j(this);
        valueAnimator.addListener(jVar);
    }

    private boolean C() {
        int i;
        int cmp;
        int cmp2;
        currentTimeMillis -= l;
        if (Long.compare(cmp, i2) >= 0) {
            if (Long.compare(cmp, cmp2) > 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static boolean D(EditText editText) {
        int obj0;
        obj0 = editText.getKeyListener() != null ? 1 : 0;
        return obj0;
    }

    private void E(boolean z) {
        boolean obj2;
        if (this.k != z) {
            this.k = z;
            this.q.cancel();
            this.p.start();
        }
    }

    private void F(AutoCompleteTextView autoCompleteTextView) {
        boolean boxBackgroundMode;
        int i;
        if (d.r) {
            boxBackgroundMode = this.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.n);
            } else {
                if (boxBackgroundMode == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(this.m);
                }
            }
        }
    }

    private void G(AutoCompleteTextView autoCompleteTextView) {
        boolean iVar;
        d.h hVar = new d.h(this, autoCompleteTextView);
        autoCompleteTextView.setOnTouchListener(hVar);
        autoCompleteTextView.setOnFocusChangeListener(this.f);
        if (d.r) {
            iVar = new d.i(this);
            autoCompleteTextView.setOnDismissListener(iVar);
        }
    }

    private void H(AutoCompleteTextView autoCompleteTextView) {
        CheckableImageButton checkableImageButton;
        boolean z;
        if (autoCompleteTextView == null) {
        }
        final int i2 = 0;
        if (C()) {
            this.j = i2;
        }
        if (!this.j) {
            if (d.r) {
                E(z5 ^= 1);
            } else {
                this.k = z4 ^= 1;
                this.c.toggle();
            }
            if (this.k) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
            } else {
                autoCompleteTextView.dismissDropDown();
            }
        } else {
            this.j = i2;
        }
    }

    static AutoCompleteTextView e(EditText editText) {
        return d.y(editText);
    }

    static AccessibilityManager f(com.google.android.material.textfield.d d) {
        return d.o;
    }

    static com.google.android.material.textfield.TextInputLayout.e g(com.google.android.material.textfield.d d) {
        return d.g;
    }

    static View.OnFocusChangeListener h(com.google.android.material.textfield.d d) {
        return d.f;
    }

    static boolean i() {
        return d.r;
    }

    static boolean j(com.google.android.material.textfield.d d) {
        return d.C();
    }

    static long k(com.google.android.material.textfield.d d, long l2) {
        d.l = l2;
        return l2;
    }

    static boolean l(com.google.android.material.textfield.d d) {
        return d.k;
    }

    static ValueAnimator m(com.google.android.material.textfield.d d) {
        return d.q;
    }

    static boolean n(EditText editText) {
        return d.D(editText);
    }

    static void o(com.google.android.material.textfield.d d, boolean z2) {
        d.E(z2);
    }

    static boolean p(com.google.android.material.textfield.d d, boolean z2) {
        d.j = z2;
        return z2;
    }

    static void q(com.google.android.material.textfield.d d, AutoCompleteTextView autoCompleteTextView2) {
        d.H(autoCompleteTextView2);
    }

    static void r(com.google.android.material.textfield.d d, AutoCompleteTextView autoCompleteTextView2) {
        d.F(autoCompleteTextView2);
    }

    static void s(com.google.android.material.textfield.d d, AutoCompleteTextView autoCompleteTextView2) {
        d.v(autoCompleteTextView2);
    }

    static void t(com.google.android.material.textfield.d d, AutoCompleteTextView autoCompleteTextView2) {
        d.G(autoCompleteTextView2);
    }

    static TextWatcher u(com.google.android.material.textfield.d d) {
        return d.e;
    }

    private void v(AutoCompleteTextView autoCompleteTextView) {
        if (d.D(autoCompleteTextView)) {
        }
        int boxBackgroundMode = this.a.getBoxBackgroundMode();
        g boxBackground = this.a.getBoxBackground();
        int i2 = a.d(autoCompleteTextView, b.m);
        final int i3 = 2;
        final int[][] iArr = new int[i3];
        final int i4 = 1;
        int[] iArr2 = new int[i4];
        final int i6 = 0;
        iArr2[i6] = 16842919;
        iArr[i6] = iArr2;
        iArr[i4] = new int[i6];
        if (boxBackgroundMode == i3) {
            x(autoCompleteTextView, i2, iArr, boxBackground);
        } else {
            if (boxBackgroundMode == i4) {
                w(autoCompleteTextView, i2, iArr, boxBackground);
            }
        }
    }

    private void w(AutoCompleteTextView autoCompleteTextView, int i2, int[][] i3Arr3Arr3, g g4) {
        boolean z;
        int paddingBottom;
        ColorStateList colorStateList;
        Object obj7;
        RippleDrawable obj8;
        android.graphics.drawable.Drawable obj9;
        int boxBackgroundColor = this.a.getBoxBackgroundColor();
        paddingBottom = 2;
        final int[] iArr = new int[paddingBottom];
        final int i3 = 0;
        iArr[i3] = a.h(i2, boxBackgroundColor, 1036831949);
        obj7 = 1;
        iArr[obj7] = boxBackgroundColor;
        if (d.r) {
            obj7 = new ColorStateList(i3Arr3Arr3, iArr);
            obj8 = new RippleDrawable(obj7, g4, g4);
            u.o0(autoCompleteTextView, obj8);
        } else {
            g gVar = new g(g4.E());
            colorStateList = new ColorStateList(i3Arr3Arr3, iArr);
            gVar.Z(colorStateList);
            obj8 = new Drawable[paddingBottom];
            obj8[i3] = g4;
            obj8[obj7] = gVar;
            obj7 = new LayerDrawable(obj8);
            u.o0(autoCompleteTextView, obj7);
            u.y0(autoCompleteTextView, u.G(autoCompleteTextView), autoCompleteTextView.getPaddingTop(), u.F(autoCompleteTextView), autoCompleteTextView.getPaddingBottom());
        }
    }

    private void x(AutoCompleteTextView autoCompleteTextView, int i2, int[][] i3Arr3Arr3, g g4) {
        RippleDrawable rippleDrawable;
        int[] iArr;
        android.graphics.drawable.Drawable[] obj9;
        LayerDrawable obj10;
        rippleDrawable = a.d(autoCompleteTextView, b.q);
        g gVar = new g(g4.E());
        obj9 = a.h(i2, rippleDrawable, 1036831949);
        int i5 = 2;
        int[] iArr2 = new int[i5];
        final int i6 = 0;
        iArr2[i6] = obj9;
        final int i7 = 1;
        iArr2[i7] = i6;
        ColorStateList colorStateList = new ColorStateList(i3Arr3Arr3, iArr2);
        gVar.Z(colorStateList);
        if (d.r) {
            gVar.setTint(rippleDrawable);
            iArr = new int[i5];
            iArr[i6] = obj9;
            iArr[i7] = rippleDrawable;
            obj9 = new ColorStateList(i3Arr3Arr3, iArr);
            obj10 = new g(g4.E());
            obj10.setTint(-1);
            rippleDrawable = new RippleDrawable(obj9, gVar, obj10);
            obj9 = new Drawable[i5];
            obj9[i6] = rippleDrawable;
            obj9[i7] = g4;
            obj10 = new LayerDrawable(obj9);
        } else {
            obj9 = new Drawable[i5];
            obj9[i6] = gVar;
            obj9[i7] = g4;
            obj10 = new LayerDrawable(obj9);
        }
        u.o0(autoCompleteTextView, obj10);
    }

    private static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView == null) {
        } else {
            return (AutoCompleteTextView)editText;
        }
        RuntimeException obj1 = new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        throw obj1;
    }

    private ValueAnimator z(int i, float... f2Arr2) {
        final ValueAnimator obj4 = ValueAnimator.ofFloat(f2Arr2);
        obj4.setInterpolator(a.a);
        obj4.setDuration((long)i);
        d.b obj3 = new d.b(this);
        obj4.addUpdateListener(obj3);
        return obj4;
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        int i;
        float f = (float)dimensionPixelOffset;
        float f2 = (float)dimensionPixelOffset2;
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(d.d0);
        g gVar4 = A(f, f, f2, dimensionPixelOffset3);
        this.n = gVar4;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.m = stateListDrawable;
        int[] iArr = new int[1];
        final int i9 = 0;
        iArr[i9] = 16842922;
        stateListDrawable.addState(iArr, gVar4);
        this.m.addState(new int[i9], A(0, f, f2, dimensionPixelOffset3));
        if (this.d == 0) {
            i = d.r ? e.d : e.e;
        }
        this.a.setEndIconDrawable(i);
        com.google.android.material.textfield.TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(j.g));
        d.g gVar2 = new d.g(this);
        this.a.setEndIconOnClickListener(gVar2);
        this.a.e(this.h);
        this.a.f(this.i);
        B();
        this.o = (AccessibilityManager)this.b.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.e
    boolean b(int i) {
        int obj1;
        obj1 = i != 0 ? 1 : 0;
        return obj1;
    }

    @Override // com.google.android.material.textfield.e
    boolean d() {
        return 1;
    }
}
