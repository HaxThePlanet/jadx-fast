package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.internal.l;
import f.c.a.e.b;
import f.c.a.e.g;

/* loaded from: classes2.dex */
class e {

    private static final int[] a;
    static {
        int[] iArr = new int[1];
        e.a = iArr;
    }

    static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void b(View view, float f2) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        int[] iArr2 = new int[3];
        final int i4 = 0;
        final int i5 = 16842910;
        iArr2[i4] = i5;
        final int i9 = 1;
        iArr2[i9] = b.S;
        iArr2[2] = -i7;
        float[] fArr3 = new float[i9];
        int i11 = 0;
        fArr3[i4] = i11;
        final String str = "elevation";
        final long l = (long)integer;
        stateListAnimator.addState(iArr2, ObjectAnimator.ofFloat(view, str, fArr3).setDuration(l));
        int[] iArr = new int[i9];
        iArr[i4] = i5;
        float[] fArr2 = new float[i9];
        fArr2[i4] = f2;
        stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(view, str, fArr2).setDuration(l));
        float[] fArr = new float[i9];
        fArr[i4] = i11;
        stateListAnimator.addState(new int[i4], ObjectAnimator.ofFloat(view, str, fArr).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }

    static void c(View view, AttributeSet attributeSet2, int i3, int i4) {
        boolean obj10;
        final android.content.Context context2 = view.getContext();
        final int i5 = 0;
        final TypedArray obj9 = l.h(context2, attributeSet2, e.a, i3, i4, new int[i5]);
        if (obj9.hasValue(i5)) {
            view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context2, obj9.getResourceId(i5, i5)));
        }
        obj9.recycle();
    }
}
