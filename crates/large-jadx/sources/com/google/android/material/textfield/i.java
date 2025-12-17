package com.google.android.material.textfield;

import android.content.res.Resources;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.k;
import f.c.a.e.e;
import f.c.a.e.j;

/* loaded from: classes2.dex */
class i extends com.google.android.material.textfield.e {

    private final TextWatcher e;
    private final com.google.android.material.textfield.TextInputLayout.f f;
    private final com.google.android.material.textfield.TextInputLayout.g g;

    class d implements View.OnClickListener {

        final com.google.android.material.textfield.i a;
        d(com.google.android.material.textfield.i i) {
            this.a = i;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            int instance;
            EditText obj3 = obj3.a.getEditText();
            if (obj3 == null) {
            }
            final int selectionEnd = obj3.getSelectionEnd();
            if (i.e(this.a)) {
                obj3.setTransformationMethod(0);
            } else {
                obj3.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                obj3.setSelection(selectionEnd);
            }
            obj3.a.X();
        }
    }

    class a extends k {

        final com.google.android.material.textfield.i a;
        a(com.google.android.material.textfield.i i) {
            this.a = i;
            super();
        }

        @Override // com.google.android.material.internal.k
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
            com.google.android.material.textfield.i obj1 = this.a;
            obj1.c.setChecked(obj1 ^= 1);
        }
    }

    class b implements com.google.android.material.textfield.TextInputLayout.f {

        final com.google.android.material.textfield.i a;
        b(com.google.android.material.textfield.i i) {
            this.a = i;
            super();
        }

        @Override // com.google.android.material.textfield.TextInputLayout$f
        public void a(com.google.android.material.textfield.TextInputLayout textInputLayout) {
            final EditText editText = textInputLayout.getEditText();
            final int i = 1;
            textInputLayout.setEndIconVisible(i);
            textInputLayout.setEndIconCheckable(i);
            com.google.android.material.textfield.i obj4 = this.a;
            obj4.c.setChecked(obj4 ^= i);
            editText.removeTextChangedListener(i.f(this.a));
            editText.addTextChangedListener(i.f(this.a));
        }
    }

    class c implements com.google.android.material.textfield.TextInputLayout.g {

        final com.google.android.material.textfield.i a;
        c(com.google.android.material.textfield.i i) {
            this.a = i;
            super();
        }

        @Override // com.google.android.material.textfield.TextInputLayout$g
        public void a(com.google.android.material.textfield.TextInputLayout textInputLayout, int i2) {
            int i;
            int obj3;
            final EditText obj2 = textInputLayout.getEditText();
            if (obj2 != null && i2 == 1) {
                if (i2 == 1) {
                    obj2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    obj3 = new i.c.a(this, obj2);
                    obj2.post(obj3);
                }
            }
        }
    }
    i(com.google.android.material.textfield.TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
        i.a obj1 = new i.a(this);
        this.e = obj1;
        obj1 = new i.b(this);
        this.f = obj1;
        obj1 = new i.c(this);
        this.g = obj1;
    }

    static boolean e(com.google.android.material.textfield.i i) {
        return i.g();
    }

    static TextWatcher f(com.google.android.material.textfield.i i) {
        return i.e;
    }

    private boolean g() {
        EditText editText;
        int i;
        editText = this.a.getEditText();
        if (editText != null && transformationMethod instanceof PasswordTransformationMethod) {
            i = transformationMethod instanceof PasswordTransformationMethod ? 1 : 0;
        } else {
        }
        return i;
    }

    private static boolean h(EditText editText) {
        int inputType;
        int i;
        int obj2;
        if (editText != 0) {
            if (editText.getInputType() != 16 && editText.getInputType() != 128 && editText.getInputType() != 144) {
                if (editText.getInputType() != 128) {
                    if (editText.getInputType() != 144) {
                        obj2 = editText.getInputType() == 224 ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        int i;
        boolean instance;
        if (this.d == 0) {
            i = e.a;
        }
        this.a.setEndIconDrawable(i);
        com.google.android.material.textfield.TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(j.L));
        i.d dVar = new i.d(this);
        this.a.setEndIconOnClickListener(dVar);
        this.a.e(this.f);
        this.a.f(this.g);
        EditText editText = this.a.getEditText();
        if (i.h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
