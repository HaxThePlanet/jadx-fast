package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* loaded from: classes2.dex */
public class o extends ImageButton {

    private int a;
    public o(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public o(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        this.a = getVisibility();
    }

    @Override // android.widget.ImageButton
    public final void b(int i, boolean z2) {
        super.setVisibility(i);
        if (z2) {
            this.a = i;
        }
    }

    @Override // android.widget.ImageButton
    public final int getUserSetVisibility() {
        return this.a;
    }

    @Override // android.widget.ImageButton
    public void setVisibility(int i) {
        b(i, true);
    }
}
