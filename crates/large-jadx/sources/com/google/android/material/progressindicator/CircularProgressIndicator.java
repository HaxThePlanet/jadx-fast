package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import f.c.a.e.b;
import f.c.a.e.k;

/* loaded from: classes2.dex */
public final class CircularProgressIndicator extends com.google.android.material.progressindicator.b<com.google.android.material.progressindicator.f> {

    public static final int G;
    static {
        CircularProgressIndicator.G = k.t;
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.k);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, CircularProgressIndicator.G);
        s();
    }

    private void s() {
        setIndeterminateDrawable(k.s(getContext(), (f)this.a));
        setProgressDrawable(g.u(getContext(), (f)this.a));
    }

    @Override // com.google.android.material.progressindicator.b
    public int getIndicatorDirection() {
        return cVar.i;
    }

    @Override // com.google.android.material.progressindicator.b
    public int getIndicatorInset() {
        return cVar.h;
    }

    @Override // com.google.android.material.progressindicator.b
    public int getIndicatorSize() {
        return cVar.g;
    }

    @Override // com.google.android.material.progressindicator.b
    com.google.android.material.progressindicator.c i(Context context, AttributeSet attributeSet2) {
        return r(context, attributeSet2);
    }

    @Override // com.google.android.material.progressindicator.b
    com.google.android.material.progressindicator.f r(Context context, AttributeSet attributeSet2) {
        f fVar = new f(context, attributeSet2);
        return fVar;
    }

    @Override // com.google.android.material.progressindicator.b
    public void setIndicatorDirection(int i) {
        cVar.i = i;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.b
    public void setIndicatorInset(int i) {
        final com.google.android.material.progressindicator.c cVar = this.a;
        if (cVar2.h != i) {
            cVar.h = i;
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.b
    public void setIndicatorSize(int i) {
        int i2;
        final int obj3 = Math.max(i, trackThickness *= 2);
        com.google.android.material.progressindicator.c cVar = this.a;
        if (cVar2.g != obj3) {
            i2.g = obj3;
            (f)cVar.e();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.b
    public void setTrackThickness(int i) {
        super.setTrackThickness(i);
        (f)this.a.e();
    }
}
