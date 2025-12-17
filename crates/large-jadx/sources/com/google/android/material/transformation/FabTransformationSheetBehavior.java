package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import d.h.l.u;
import f.c.a.e.a;
import f.c.a.e.m.h;
import f.c.a.e.m.j;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
@Deprecated
public class FabTransformationSheetBehavior extends com.google.android.material.transformation.FabTransformationBehavior {

    private Map<View, Integer> i;
    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    private void C(View view, boolean z2) {
        int sDK_INT2;
        int i;
        View childAt;
        int intValue;
        int sDK_INT;
        boolean z;
        Integer valueOf;
        View obj9;
        final android.view.ViewParent parent = view.getParent();
        if (!parent instanceof CoordinatorLayout) {
        }
        int childCount = (CoordinatorLayout)parent.getChildCount();
        final int i3 = 16;
        if (Build.VERSION.SDK_INT >= i3 && z2) {
            if (z2) {
                sDK_INT2 = new HashMap(childCount);
                this.i = sDK_INT2;
            }
        }
        int i2 = 0;
        i = i2;
        while (i < childCount) {
            childAt = parent.getChildAt(i);
            if (layoutParams instanceof CoordinatorLayout.f && cVar instanceof FabTransformationScrimBehavior) {
            } else {
            }
            intValue = i2;
            if (childAt != view) {
            }
            i++;
            if (intValue != 0) {
            } else {
            }
            if (!z2) {
            } else {
            }
            if (Build.VERSION.SDK_INT >= i3) {
            }
            u.v0(childAt, 4);
            this.i.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
            intValue = this.i;
            if (intValue != null && intValue.containsKey(childAt)) {
            }
            if (intValue.containsKey(childAt)) {
            }
            u.v0(childAt, (Integer)this.i.get(childAt).intValue());
            if (cVar instanceof FabTransformationScrimBehavior) {
            } else {
            }
            intValue = 1;
        }
        if (!z2) {
            this.i = 0;
        }
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected com.google.android.material.transformation.FabTransformationBehavior.e A(Context context, boolean z2) {
        int obj4;
        obj4 = z2 ? a.d : a.c;
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.a = h.c(context, obj4);
        final int i = 0;
        j obj3 = new j(17, i, i);
        eVar.b = obj3;
        return eVar;
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected boolean d(View view, View view2, boolean z3, boolean z4) {
        C(view2, z3);
        return super.d(view, view2, z3, z4);
    }
}
