package com.airbnb.lottie.y;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public abstract class a extends ValueAnimator {

    private final Set<ValueAnimator.AnimatorUpdateListener> a;
    private final Set<Animator.AnimatorListener> b;
    public a() {
        super();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.a = copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        this.b = copyOnWriteArraySet2;
    }

    @Override // android.animation.ValueAnimator
    void a() {
        Object next;
        Iterator iterator = this.b.iterator();
        for (Animator.AnimatorListener next : iterator) {
            next.onAnimationCancel(this);
        }
    }

    @Override // android.animation.ValueAnimator
    public void addListener(Animator.AnimatorListener animator$AnimatorListener) {
        this.b.add(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener) {
        this.a.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    void b(boolean z) {
        Object next;
        int sDK_INT;
        int i;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (Build.VERSION.SDK_INT >= 26) {
            } else {
            }
            (Animator.AnimatorListener)next.onAnimationEnd(this);
            next.onAnimationEnd(this, z);
        }
    }

    @Override // android.animation.ValueAnimator
    void c() {
        Object next;
        Iterator iterator = this.b.iterator();
        for (Animator.AnimatorListener next : iterator) {
            next.onAnimationRepeat(this);
        }
    }

    @Override // android.animation.ValueAnimator
    void d(boolean z) {
        Object next;
        int sDK_INT;
        int i;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (Build.VERSION.SDK_INT >= 26) {
            } else {
            }
            (Animator.AnimatorListener)next.onAnimationStart(this);
            next.onAnimationStart(this, z);
        }
    }

    @Override // android.animation.ValueAnimator
    void e() {
        Object next;
        Iterator iterator = this.a.iterator();
        for (ValueAnimator.AnimatorUpdateListener next : iterator) {
            next.onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator
    public long getStartDelay() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
        throw unsupportedOperationException;
    }

    @Override // android.animation.ValueAnimator
    public void removeAllListeners() {
        this.b.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.a.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeListener(Animator.AnimatorListener animator$AnimatorListener) {
        this.b.remove(animatorListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener) {
        this.a.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public Animator setDuration(long l) {
        setDuration(l);
        throw 0;
    }

    @Override // android.animation.ValueAnimator
    public ValueAnimator setDuration(long l) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("LottieAnimator does not support setDuration.");
        throw obj1;
    }

    @Override // android.animation.ValueAnimator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
        throw obj2;
    }

    @Override // android.animation.ValueAnimator
    public void setStartDelay(long l) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
        throw obj1;
    }
}
