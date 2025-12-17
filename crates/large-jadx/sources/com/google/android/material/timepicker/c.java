package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes2.dex */
class c implements InputFilter {

    private int a;
    public c(int i) {
        super();
        this.a = i;
    }

    @Override // android.text.InputFilter
    public java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i2, int i3, Spanned spanned4, int i5, int i6) {
        try {
            StringBuilder stringBuilder = new StringBuilder(spanned4);
            stringBuilder.replace(i5, i6, charSequence.subSequence(i2, i3).toString());
            if (Integer.parseInt(stringBuilder.toString()) <= this.a) {
            }
            return null;
            return "";
        }
    }
}
