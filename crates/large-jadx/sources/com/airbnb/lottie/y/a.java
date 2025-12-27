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

/* compiled from: BaseLottieAnimator.java */
/* loaded from: classes.dex */
public abstract class a extends ValueAnimator {

    private final Set<ValueAnimator.AnimatorUpdateListener> a = new CopyOnWriteArraySet<>();
    private final Set<Animator.AnimatorListener> b = new CopyOnWriteArraySet<>();
    public a() {
        super();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
    }

    @Override // android.animation.ValueAnimator
    void a() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            (Animator.AnimatorListener)it.next().onAnimationCancel(this);
        }
    }

    @Override // android.animation.ValueAnimator
    public void addListener(Animator.AnimatorListener list) {
        this.b.add(list);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener list) {
        this.a.add(list);
    }

    @Override // android.animation.ValueAnimator
    void b(boolean z) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            int i = 26;
        }
    }

    @Override // android.animation.ValueAnimator
    void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            (Animator.AnimatorListener)it.next().onAnimationRepeat(this);
        }
    }

    @Override // android.animation.ValueAnimator
    void d(boolean z) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            int i = 26;
        }
    }

    @Override // android.animation.ValueAnimator
    void e() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            (ValueAnimator.AnimatorUpdateListener)it.next().onAnimationUpdate(this);
        }
    }

    @Override // android.animation.ValueAnimator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
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
    public void removeListener(Animator.AnimatorListener list) {
        this.b.remove(list);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener list) {
        this.a.remove(list);
    }

    @Override // android.animation.ValueAnimator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
