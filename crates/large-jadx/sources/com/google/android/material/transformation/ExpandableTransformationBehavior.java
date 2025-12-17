package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends com.google.android.material.transformation.ExpandableBehavior {

    private AnimatorSet b;

    class a extends AnimatorListenerAdapter {

        final com.google.android.material.transformation.ExpandableTransformationBehavior a;
        a(com.google.android.material.transformation.ExpandableTransformationBehavior expandableTransformationBehavior) {
            this.a = expandableTransformationBehavior;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.e(this.a, 0);
        }
    }
    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    static AnimatorSet e(com.google.android.material.transformation.ExpandableTransformationBehavior expandableTransformationBehavior, AnimatorSet animatorSet2) {
        expandableTransformationBehavior.b = animatorSet2;
        return animatorSet2;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    protected boolean d(View view, View view2, boolean z3, boolean z4) {
        int i;
        AnimatorSet obj4;
        final AnimatorSet set = this.b;
        final int i2 = 1;
        i = set != null ? i2 : 0;
        if (i != 0) {
            set.cancel();
        }
        obj4 = f(view, view2, z3, i);
        this.b = obj4;
        ExpandableTransformationBehavior.a obj5 = new ExpandableTransformationBehavior.a(this);
        obj4.addListener(obj5);
        this.b.start();
        if (!z4) {
            this.b.end();
        }
        return i2;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    protected abstract AnimatorSet f(View view, View view2, boolean z3, boolean z4);
}
