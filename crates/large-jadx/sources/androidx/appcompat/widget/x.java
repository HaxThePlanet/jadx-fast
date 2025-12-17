package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class x extends ToggleButton {

    private final androidx.appcompat.widget.v a;
    public x(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 16842827);
    }

    public x(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        o0.a(this, getContext());
        v obj1 = new v(this);
        this.a = obj1;
        obj1.m(attributeSet2, i3);
    }
}
