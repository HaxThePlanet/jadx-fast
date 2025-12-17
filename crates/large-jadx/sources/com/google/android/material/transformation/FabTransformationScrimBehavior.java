package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.c;
import f.c.a.e.m.b;
import f.c.a.e.m.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
@Deprecated
public class FabTransformationScrimBehavior extends com.google.android.material.transformation.ExpandableTransformationBehavior {

    private final i c;
    private final i d;

    class a extends AnimatorListenerAdapter {

        final boolean a;
        final View b;
        a(com.google.android.material.transformation.FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z2, View view3) {
            this.a = z2;
            this.b = view3;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            int i;
            boolean obj2;
            if (!this.a) {
                this.b.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            int i;
            boolean obj2;
            if (this.a) {
                this.b.setVisibility(0);
            }
        }
    }
    public FabTransformationScrimBehavior() {
        super();
        final int i3 = 150;
        i iVar = new i(75, obj2, i3, obj4);
        this.c = iVar;
        i iVar2 = new i(0, obj2, i3, obj4);
        this.d = iVar2;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        final int i3 = 150;
        i obj5 = new i(75, obj1, i3, obj3);
        this.c = obj5;
        obj5 = new i(0, obj1, i3, obj3);
        this.d = obj5;
    }

    private void g(View view, boolean z2, boolean z3, List<Animator> list4, List<Animator.AnimatorListener> list5) {
        int i;
        ObjectAnimator obj4;
        android.util.Property obj5;
        float[] obj6;
        i obj8;
        obj8 = z2 ? this.c : this.d;
        i = 0;
        final int i2 = 0;
        final int i3 = 1;
        if (z2) {
            if (!z3) {
                view.setAlpha(i);
            }
            obj6 = new float[i3];
            obj6[i2] = 1065353216;
            obj4 = ObjectAnimator.ofFloat(view, View.ALPHA, obj6);
        } else {
            obj6 = new float[i3];
            obj6[i2] = i;
            obj4 = ObjectAnimator.ofFloat(view, View.ALPHA, obj6);
        }
        obj8.a(obj4);
        list4.add(obj4);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet f(View view, View view2, boolean z3, boolean z4) {
        ArrayList obj7 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.g(view2, z3, z4, obj7, arrayList);
        AnimatorSet obj10 = new AnimatorSet();
        b.a(obj10, obj7);
        obj7 = new FabTransformationScrimBehavior.a(this, z3, view2);
        obj10.addListener(obj7);
        return obj10;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view2, View view3) {
        return view3 instanceof FloatingActionButton;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view2, MotionEvent motionEvent3) {
        return super.onTouchEvent(coordinatorLayout, view2, motionEvent3);
    }
}
