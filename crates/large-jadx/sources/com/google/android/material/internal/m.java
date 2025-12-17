package com.google.android.material.internal;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes2.dex */
public class m {
    public static TextView a(Toolbar toolbar) {
        return m.b(toolbar, toolbar.getSubtitle());
    }

    private static TextView b(Toolbar toolbar, java.lang.CharSequence charSequence2) {
        int i;
        android.view.View childAt;
        boolean equals;
        i = 0;
        while (i < toolbar.getChildCount()) {
            childAt = toolbar.getChildAt(i);
            i++;
        }
        return null;
    }

    public static TextView c(Toolbar toolbar) {
        return m.b(toolbar, toolbar.getTitle());
    }
}
