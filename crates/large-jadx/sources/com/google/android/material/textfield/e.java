package com.google.android.material.textfield;

import android.content.Context;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes2.dex */
abstract class e {

    com.google.android.material.textfield.TextInputLayout a;
    Context b;
    CheckableImageButton c;
    final int d;
    e(com.google.android.material.textfield.TextInputLayout textInputLayout, int i2) {
        super();
        this.a = textInputLayout;
        this.b = textInputLayout.getContext();
        this.c = textInputLayout.getEndIconView();
        this.d = i2;
    }

    abstract void a();

    boolean b(int i) {
        return 1;
    }

    void c(boolean z) {
    }

    boolean d() {
        return 0;
    }
}
