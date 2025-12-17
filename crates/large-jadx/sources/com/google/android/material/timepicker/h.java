package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes2.dex */
class h implements TextView.OnEditorActionListener, View.OnKeyListener {

    private final com.google.android.material.timepicker.ChipTextInputComboView a;
    private final com.google.android.material.timepicker.ChipTextInputComboView b;
    private final com.google.android.material.timepicker.e c;
    private boolean v = false;
    h(com.google.android.material.timepicker.ChipTextInputComboView chipTextInputComboView, com.google.android.material.timepicker.ChipTextInputComboView chipTextInputComboView2, com.google.android.material.timepicker.e e3) {
        super();
        final int i = 0;
        this.a = chipTextInputComboView;
        this.b = chipTextInputComboView2;
        this.c = e3;
    }

    private void b(int i) {
        int i2;
        int i3;
        final int i4 = 0;
        i3 = i == 12 ? i2 : i4;
        this.b.setChecked(i3);
        if (i == 10) {
        } else {
            i2 = i4;
        }
        this.a.setChecked(i2);
        eVar.x = i;
    }

    private boolean c(int i, KeyEvent keyEvent2, EditText editText3) {
        int i2;
        int obj5;
        int obj6;
        final Editable text = editText3.getText();
        final int i3 = 0;
        if (text == null) {
            return i3;
        }
        final int i4 = 1;
        obj6 = 2;
        if (i >= 7 && i <= 16 && keyEvent2.getAction() == i4 && editText3.getSelectionStart() == obj6 && text.length() == obj6) {
            if (i <= 16) {
                if (keyEvent2.getAction() == i4) {
                    obj6 = 2;
                    if (editText3.getSelectionStart() == obj6) {
                        obj5 = text.length() == obj6 ? i4 : i3;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (obj5 != null) {
            b(12);
            return i4;
        }
        return i3;
    }

    private boolean d(int i, KeyEvent keyEvent2, EditText editText3) {
        int obj4;
        final int i2 = 1;
        final int i3 = 0;
        if (i == 67 && keyEvent2.getAction() == 0 && TextUtils.isEmpty(editText3.getText())) {
            if (keyEvent2.getAction() == 0) {
                obj4 = TextUtils.isEmpty(editText3.getText()) ? i2 : i3;
            } else {
            }
        } else {
        }
        if (obj4 != null) {
            b(10);
            return i2;
        }
        return i3;
    }

    @Override // android.widget.TextView$OnEditorActionListener
    public void a() {
        EditText editText = this.a.e().getEditText();
        EditText editText2 = this.b.e().getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    @Override // android.widget.TextView$OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent3) {
        int obj1;
        int obj2;
        obj1 = i2 == 5 ? 1 : 0;
        if (obj1 != null) {
            b(12);
        }
        return obj1;
    }

    @Override // android.widget.TextView$OnEditorActionListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent3) {
        boolean obj4;
        final int i4 = 0;
        if (this.v) {
            return i4;
        }
        this.v = true;
        if (eVar.x == 12) {
            obj4 = d(i2, keyEvent3, (EditText)view);
        } else {
            obj4 = c(i2, keyEvent3, view);
        }
        this.v = i4;
        return obj4;
    }
}
