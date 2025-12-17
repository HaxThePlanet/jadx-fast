package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* loaded from: classes2.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    public final com.google.android.exoplayer2.ui.l a;
    public c(com.google.android.exoplayer2.ui.l l) {
        super();
        this.a = l;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.j(valueAnimator);
    }
}
