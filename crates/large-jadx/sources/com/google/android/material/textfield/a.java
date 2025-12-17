package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import f.c.a.e.e;
import f.c.a.e.j;
import f.c.a.e.m.a;

/* loaded from: classes2.dex */
class a extends com.google.android.material.textfield.e {

    private final TextWatcher e;
    private final View.OnFocusChangeListener f;
    private final com.google.android.material.textfield.TextInputLayout.f g;
    private final com.google.android.material.textfield.TextInputLayout.g h;
    private AnimatorSet i;
    private ValueAnimator j;

    class a implements TextWatcher {

        final com.google.android.material.textfield.a a;
        a(com.google.android.material.textfield.a a) {
            this.a = a;
            super();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (obj2.a.getSuffixText() != null) {
            }
            com.google.android.material.textfield.a obj2 = this.a;
            a.f(obj2, a.e(obj2));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    class b implements View.OnFocusChangeListener {

        final com.google.android.material.textfield.a a;
        b(com.google.android.material.textfield.a a) {
            this.a = a;
            super();
        }

        @Override // android.view.View$OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            final com.google.android.material.textfield.a obj1 = this.a;
            a.f(obj1, a.e(obj1));
        }
    }

    class e implements View.OnClickListener {

        final com.google.android.material.textfield.a a;
        e(com.google.android.material.textfield.a a) {
            this.a = a;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            Editable obj1 = obj1.a.getEditText().getText();
            if (obj1 != null) {
                obj1.clear();
            }
            obj1.a.X();
        }
    }

    class f extends AnimatorListenerAdapter {

        final com.google.android.material.textfield.a a;
        f(com.google.android.material.textfield.a a) {
            this.a = a;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            obj2.a.setEndIconVisible(true);
        }
    }

    class g extends AnimatorListenerAdapter {

        final com.google.android.material.textfield.a a;
        g(com.google.android.material.textfield.a a) {
            this.a = a;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            obj2.a.setEndIconVisible(false);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {

        final com.google.android.material.textfield.a a;
        h(com.google.android.material.textfield.a a) {
            this.a = a;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            aVar.c.setAlpha((Float)valueAnimator.getAnimatedValue().floatValue());
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {

        final com.google.android.material.textfield.a a;
        i(com.google.android.material.textfield.a a) {
            this.a = a;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float obj2 = (Float)valueAnimator.getAnimatedValue().floatValue();
            aVar.c.setScaleX(obj2);
            aVar2.c.setScaleY(obj2);
        }
    }

    class c implements com.google.android.material.textfield.TextInputLayout.f {

        final com.google.android.material.textfield.a a;
        c(com.google.android.material.textfield.a a) {
            this.a = a;
            super();
        }

        @Override // com.google.android.material.textfield.TextInputLayout$f
        public void a(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            final EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.e(this.a));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.g(this.a));
            com.google.android.material.textfield.a obj3 = this.a;
            obj3.c.setOnFocusChangeListener(a.g(obj3));
            editText.removeTextChangedListener(a.h(this.a));
            editText.addTextChangedListener(a.h(this.a));
        }
    }

    class d implements com.google.android.material.textfield.TextInputLayout.g {

        final com.google.android.material.textfield.a a;
        d(com.google.android.material.textfield.a a) {
            this.a = a;
            super();
        }

        @Override // com.google.android.material.textfield.TextInputLayout$g
        public void a(com.google.android.material.textfield.TextInputLayout textInputLayout, int i2) {
            int i;
            int i3;
            Object obj3;
            int obj4;
            obj3 = textInputLayout.getEditText();
            obj4 = new a.d.a(this, obj3);
            obj3.post(obj4);
            i3 = 0;
            if (obj3 != null && i2 == 2 && obj3.getOnFocusChangeListener() == a.g(this.a)) {
                if (i2 == 2) {
                    obj4 = new a.d.a(this, obj3);
                    obj3.post(obj4);
                    i3 = 0;
                    if (obj3.getOnFocusChangeListener() == a.g(this.a)) {
                        obj3.setOnFocusChangeListener(i3);
                    }
                    if (obj3.c.getOnFocusChangeListener() == a.g(this.a)) {
                        obj3.c.setOnFocusChangeListener(i3);
                    }
                }
            }
        }
    }
    a(com.google.android.material.textfield.TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
        a.a obj1 = new a.a(this);
        this.e = obj1;
        obj1 = new a.b(this);
        this.f = obj1;
        obj1 = new a.c(this);
        this.g = obj1;
        obj1 = new a.d(this);
        this.h = obj1;
    }

    static boolean e(com.google.android.material.textfield.a a) {
        return a.m();
    }

    static void f(com.google.android.material.textfield.a a, boolean z2) {
        a.i(z2);
    }

    static View.OnFocusChangeListener g(com.google.android.material.textfield.a a) {
        return a.f;
    }

    static TextWatcher h(com.google.android.material.textfield.a a) {
        return a.e;
    }

    private void i(boolean z) {
        int i;
        boolean running;
        boolean obj3;
        i = this.a.L() == z ? 1 : 0;
        if (z && !this.i.isRunning()) {
            if (!this.i.isRunning()) {
                this.j.cancel();
                this.i.start();
                if (i != 0) {
                    this.i.end();
                }
            } else {
                this.i.cancel();
                this.j.start();
                if (!z && i != 0) {
                    this.i.cancel();
                    this.j.start();
                    if (i != 0) {
                        this.j.end();
                    }
                }
            }
        } else {
        }
    }

    private ValueAnimator j(float... fArr) {
        final ValueAnimator obj3 = ValueAnimator.ofFloat(fArr);
        obj3.setInterpolator(a.a);
        obj3.setDuration(100);
        a.h hVar = new a.h(this);
        obj3.addUpdateListener(hVar);
        return obj3;
    }

    private ValueAnimator k() {
        float[] fArr = new float[2];
        fArr = new int[]{1061997773, 1065353216};
        ValueAnimator float = ValueAnimator.ofFloat(fArr);
        float.setInterpolator(a.d);
        float.setDuration(150);
        a.i iVar = new a.i(this);
        float.addUpdateListener(iVar);
        return float;
    }

    private void l() {
        int i2 = 2;
        float[] fArr2 = new float[i2];
        fArr2 = new int[]{0, 1065353216};
        AnimatorSet animatorSet = new AnimatorSet();
        this.i = animatorSet;
        final Animator[] arr = new Animator[i2];
        arr[0] = k();
        arr[1] = j(fArr2);
        animatorSet.playTogether(arr);
        a.f fVar = new a.f(this);
        this.i.addListener(fVar);
        float[] fArr = new float[i2];
        fArr = new int[]{1065353216, 0};
        ValueAnimator valueAnimator2 = j(fArr);
        this.j = valueAnimator2;
        a.g gVar = new a.g(this);
        valueAnimator2.addListener(gVar);
    }

    private boolean m() {
        EditText editText;
        int i;
        boolean focus;
        editText = this.a.getEditText();
        if (editText != null) {
            if (!editText.hasFocus()) {
                if (this.c.hasFocus() && editText.getText().length() > 0) {
                    i = editText.getText().length() > 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        int i;
        if (this.d == 0) {
            i = e.f;
        }
        this.a.setEndIconDrawable(i);
        com.google.android.material.textfield.TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(j.e));
        a.e eVar = new a.e(this);
        this.a.setEndIconOnClickListener(eVar);
        this.a.e(this.g);
        this.a.f(this.h);
        l();
    }

    @Override // com.google.android.material.textfield.e
    void c(boolean z) {
        if (this.a.getSuffixText() == null) {
        }
        i(z);
    }
}
