package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.theme.a.a;
import f.c.a.e.a0.b;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 16842884);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet2, int i3, int i4) {
        boolean theme;
        Context obj2;
        AttributeSet obj3;
        super(a.c(context, attributeSet2, i3, i4), attributeSet2, i3);
        obj2 = getContext();
        theme = obj2.getTheme();
        obj2 = MaterialTextView.k(theme, attributeSet2, i3, i4);
        if (MaterialTextView.j(obj2) && !MaterialTextView.m(obj2, theme, attributeSet2, i3, i4) && obj2 != -1) {
            theme = obj2.getTheme();
            if (!MaterialTextView.m(obj2, theme, attributeSet2, i3, i4)) {
                obj2 = MaterialTextView.k(theme, attributeSet2, i3, i4);
                if (obj2 != -1) {
                    i(theme, obj2);
                }
            }
        }
    }

    private void i(Resources.Theme resources$Theme, int i2) {
        final TypedArray obj4 = theme.obtainStyledAttributes(i2, l.k3);
        int[] iArr2 = new int[2];
        int obj5 = MaterialTextView.l(getContext(), obj4, l.m3, l.n3);
        obj4.recycle();
        if (obj5 >= 0) {
            setLineHeight(obj5);
        }
    }

    private static boolean j(Context context) {
        return b.b(context, b.W, true);
    }

    private static int k(Resources.Theme resources$Theme, AttributeSet attributeSet2, int i3, int i4) {
        final TypedArray obj1 = theme.obtainStyledAttributes(attributeSet2, l.o3, i3, i4);
        obj1.recycle();
        return obj1.getResourceId(l.p3, -1);
    }

    private static int l(Context context, TypedArray typedArray2, int... i3Arr3) {
        int i;
        int i2;
        int length;
        final int i3 = -1;
        i = 0;
        i2 = i3;
        for (int i4 : i3Arr3) {
            if (i2 < 0) {
            }
            i2 = c.c(context, typedArray2, i4, i3);
        }
        return i2;
    }

    private static boolean m(Context context, Resources.Theme resources$Theme2, AttributeSet attributeSet3, int i4, int i5) {
        int obj5;
        TypedArray obj2 = theme2.obtainStyledAttributes(attributeSet3, l.o3, i4, i5);
        int[] obj3 = new int[2];
        int i = 1;
        obj3[i] = l.r3;
        obj2.recycle();
        if (MaterialTextView.l(context, obj2, obj3) != -1) {
            obj5 = i;
        }
        return obj5;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void setTextAppearance(Context context, int i2) {
        Object obj2;
        super.setTextAppearance(context, i2);
        if (MaterialTextView.j(context)) {
            i(context.getTheme(), i2);
        }
    }
}
