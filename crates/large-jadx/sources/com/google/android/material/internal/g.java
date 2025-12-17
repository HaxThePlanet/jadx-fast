package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class g {

    private final ArrayList<com.google.android.material.internal.g.b> a;
    private com.google.android.material.internal.g.b b = null;
    ValueAnimator c = null;
    private final Animator.AnimatorListener d;

    class a extends AnimatorListenerAdapter {

        final com.google.android.material.internal.g a;
        a(com.google.android.material.internal.g g) {
            this.a = g;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            ValueAnimator obj3;
            final com.google.android.material.internal.g gVar = this.a;
            if (gVar.c == animator) {
                gVar.c = 0;
            }
        }
    }

    static class b {

        final int[] a;
        final ValueAnimator b;
        b(int[] iArr, ValueAnimator valueAnimator2) {
            super();
            this.a = iArr;
            this.b = valueAnimator2;
        }
    }
    public g() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        int i = 0;
        g.a aVar = new g.a(this);
        this.d = aVar;
    }

    private void b() {
        ValueAnimator valueAnimator;
        valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.c = 0;
        }
    }

    private void e(com.google.android.material.internal.g.b g$b) {
        final ValueAnimator obj1 = b.b;
        this.c = obj1;
        obj1.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator2) {
        g.b bVar = new g.b(iArr, valueAnimator2);
        valueAnimator2.addListener(this.d);
        this.a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator;
        valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.c = 0;
        }
    }

    public void d(int[] iArr) {
        int i;
        Object obj;
        boolean stateSetMatches;
        i = 0;
        while (i < this.a.size()) {
            i++;
        }
        obj = 0;
        final com.google.android.material.internal.g.b obj5 = this.b;
        if (obj == obj5) {
        }
        if (obj5 != null) {
            b();
        }
        this.b = obj;
        if (obj != null) {
            e(obj);
        }
    }
}
