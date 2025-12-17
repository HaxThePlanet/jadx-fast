package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes5.dex */
public final class ViewPropertyAnimatorCompat {

    private final WeakReference<View> mView;

    static class Api21Impl {
        static ViewPropertyAnimator translationZ(ViewPropertyAnimator viewPropertyAnimator, float value) {
            return viewPropertyAnimator.translationZ(value);
        }

        static ViewPropertyAnimator translationZBy(ViewPropertyAnimator viewPropertyAnimator, float value) {
            return viewPropertyAnimator.translationZBy(value);
        }

        static ViewPropertyAnimator z(ViewPropertyAnimator viewPropertyAnimator, float value) {
            return viewPropertyAnimator.z(value);
        }

        static ViewPropertyAnimator zBy(ViewPropertyAnimator viewPropertyAnimator, float value) {
            return viewPropertyAnimator.zBy(value);
        }
    }
    ViewPropertyAnimatorCompat(View view) {
        super();
        WeakReference weakReference = new WeakReference(view);
        this.mView = weakReference;
    }

    static void lambda$setUpdateListener$0(androidx.core.view.ViewPropertyAnimatorUpdateListener listener, View view, ValueAnimator valueAnimator) {
        listener.onAnimationUpdate(view);
    }

    private void setListenerInternal(View view, androidx.core.view.ViewPropertyAnimatorListener listener) {
        ViewPropertyAnimator animate;
        androidx.core.view.ViewPropertyAnimatorCompat.1 anon;
        if (listener != null) {
            anon = new ViewPropertyAnimatorCompat.1(this, listener, view);
            view.animate().setListener(anon);
        } else {
            view.animate().setListener(0);
        }
    }

    public androidx.core.view.ViewPropertyAnimatorCompat alpha(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().alpha(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat alphaBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().alphaBy(value);
        }
        return this;
    }

    public void cancel() {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().cancel();
        }
    }

    public long getDuration() {
        Object obj = this.mView.get();
        if (obj != null) {
            return (View)obj.animate().getDuration();
        }
        return 0;
    }

    public Interpolator getInterpolator() {
        Object obj = this.mView.get();
        if (obj != null) {
            return (Interpolator)(View)obj.animate().getInterpolator();
        }
        return null;
    }

    public long getStartDelay() {
        Object obj = this.mView.get();
        if (obj != null) {
            return (View)obj.animate().getStartDelay();
        }
        return 0;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotation(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().rotation(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().rotationBy(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationX(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().rotationX(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationXBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().rotationXBy(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationY(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().rotationY(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat rotationYBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().rotationYBy(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat scaleX(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().scaleX(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat scaleXBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().scaleXBy(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat scaleY(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().scaleY(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat scaleYBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().scaleYBy(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setDuration(long value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().setDuration(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setInterpolator(Interpolator value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().setInterpolator(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setListener(androidx.core.view.ViewPropertyAnimatorListener listener) {
        Object obj = this.mView.get();
        if (obj != null) {
            setListenerInternal((View)obj, listener);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setStartDelay(long value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().setStartDelay(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat setUpdateListener(androidx.core.view.ViewPropertyAnimatorUpdateListener listener) {
        int wrapped;
        androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0 animate;
        wrapped = this.mView.get();
        final Object obj = wrapped;
        wrapped = 0;
        if ((View)wrapped != null && listener != null) {
            wrapped = 0;
            if (listener != null) {
                animate = new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(listener, obj);
                wrapped = animate;
            }
            obj.animate().setUpdateListener(wrapped);
        }
        return this;
    }

    public void start() {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().start();
        }
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationX(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().translationX(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationXBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().translationXBy(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationY(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().translationY(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationYBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().translationYBy(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationZ(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            ViewPropertyAnimatorCompat.Api21Impl.translationZ((View)animate.animate(), value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat translationZBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            ViewPropertyAnimatorCompat.Api21Impl.translationZBy((View)animate.animate(), value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().withEndAction(runnable);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat withLayer() {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().withLayer();
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().withStartAction(runnable);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat x(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().x(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat xBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().xBy(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat y(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().y(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat yBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            (View)animate.animate().yBy(value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat z(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            ViewPropertyAnimatorCompat.Api21Impl.z((View)animate.animate(), value);
        }
        return this;
    }

    public androidx.core.view.ViewPropertyAnimatorCompat zBy(float value) {
        Object animate;
        animate = this.mView.get();
        if (animate != null) {
            ViewPropertyAnimatorCompat.Api21Impl.zBy((View)animate.animate(), value);
        }
        return this;
    }
}
