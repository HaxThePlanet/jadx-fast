package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.k;
import com.google.android.material.internal.n;
import com.google.android.material.textfield.TextInputLayout;
import d.h.l.a;
import d.h.l.u;
import f.c.a.e.f;
import f.c.a.e.h;
import java.util.Arrays;

/* loaded from: classes2.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    private final Chip a;
    private final TextInputLayout b;
    private final EditText c;
    private TextWatcher v;

    static class a {
    }

    private class b extends k {

        final com.google.android.material.timepicker.ChipTextInputComboView a;
        private b(com.google.android.material.timepicker.ChipTextInputComboView chipTextInputComboView) {
            this.a = chipTextInputComboView;
            super();
        }

        b(com.google.android.material.timepicker.ChipTextInputComboView chipTextInputComboView, com.google.android.material.timepicker.ChipTextInputComboView.a chipTextInputComboView$a2) {
            super(chipTextInputComboView);
        }

        @Override // com.google.android.material.internal.k
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.b(this.a).setText(ChipTextInputComboView.a(this.a, "00"));
            }
            ChipTextInputComboView.b(this.a).setText(ChipTextInputComboView.a(this.a, editable));
        }
    }
    public ChipTextInputComboView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        LayoutInflater obj4 = LayoutInflater.from(context);
        final int obj6 = 0;
        android.view.View obj5 = obj4.inflate(h.m, this, obj6);
        this.a = (Chip)obj5;
        obj4 = obj4.inflate(h.n, this, obj6);
        this.b = (TextInputLayout)obj4;
        EditText editText = obj4.getEditText();
        this.c = editText;
        editText.setVisibility(4);
        ChipTextInputComboView.b bVar = new ChipTextInputComboView.b(this, 0);
        this.v = bVar;
        editText.addTextChangedListener(bVar);
        h();
        addView(obj5);
        addView(obj4);
        obj4 = findViewById(f.q);
        editText.setSaveEnabled(obj6);
    }

    static String a(com.google.android.material.timepicker.ChipTextInputComboView chipTextInputComboView, java.lang.CharSequence charSequence2) {
        return chipTextInputComboView.d(charSequence2);
    }

    static Chip b(com.google.android.material.timepicker.ChipTextInputComboView chipTextInputComboView) {
        return chipTextInputComboView.a;
    }

    private String d(java.lang.CharSequence charSequence) {
        return e.a(getResources(), charSequence);
    }

    private void h() {
        int sDK_INT;
        int i;
        if (Build.VERSION.SDK_INT >= 24) {
            this.c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.widget.FrameLayout
    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.c.getFilters();
        Object[] copyOf = Arrays.copyOf(filters, length2++);
        (InputFilter[])copyOf[filters.length] = inputFilter;
        this.c.setFilters(copyOf);
    }

    @Override // android.widget.FrameLayout
    public TextInputLayout e() {
        return this.b;
    }

    @Override // android.widget.FrameLayout
    public void f(a a) {
        u.l0(this.a, a);
    }

    @Override // android.widget.FrameLayout
    public void g(java.lang.CharSequence charSequence) {
        Object chip;
        boolean obj2;
        this.a.setText(d(charSequence));
        if (!TextUtils.isEmpty(this.c.getText())) {
            this.c.removeTextChangedListener(this.v);
            this.c.setText(0);
            this.c.addTextChangedListener(this.v);
        }
    }

    @Override // android.widget.FrameLayout
    public boolean isChecked() {
        return this.a.isChecked();
    }

    @Override // android.widget.FrameLayout
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        h();
    }

    @Override // android.widget.FrameLayout
    public void setChecked(boolean z) {
        Chip length;
        int i2;
        int i;
        boolean obj4;
        this.a.setChecked(z);
        i = z ? i2 : 4;
        this.c.setVisibility(i);
        if (z) {
            i2 = 8;
        }
        this.a.setVisibility(i2);
        n.j(this.c);
        if (isChecked() && !TextUtils.isEmpty(this.c.getText())) {
            n.j(this.c);
            if (!TextUtils.isEmpty(this.c.getText())) {
                obj4 = this.c;
                obj4.setSelection(obj4.getText().length());
            }
        }
    }

    @Override // android.widget.FrameLayout
    public void setOnClickListener(View.OnClickListener view$OnClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    @Override // android.widget.FrameLayout
    public void setTag(int i, Object object2) {
        this.a.setTag(i, object2);
    }

    @Override // android.widget.FrameLayout
    public void toggle() {
        this.a.toggle();
    }
}
