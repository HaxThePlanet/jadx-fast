package androidx.core.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* loaded from: classes5.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    private final Runnable mRunnable;
    private final View mView;
    private ViewTreeObserver mViewTreeObserver;
    private OneShotPreDrawListener(View view, Runnable runnable) {
        super();
        this.mView = view;
        this.mViewTreeObserver = view.getViewTreeObserver();
        this.mRunnable = runnable;
    }

    public static androidx.core.view.OneShotPreDrawListener add(View view, Runnable runnable) {
        if (view == null) {
        } else {
            if (runnable == null) {
            } else {
                OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
                view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
                view.addOnAttachStateChangeListener(oneShotPreDrawListener);
                return oneShotPreDrawListener;
            }
            NullPointerException listener = new NullPointerException("runnable == null");
            throw listener;
        }
        NullPointerException nullPointerException = new NullPointerException("view == null");
        throw nullPointerException;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.mRunnable.run();
        return 1;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public void onViewAttachedToWindow(View v) {
        this.mViewTreeObserver = v.getViewTreeObserver();
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public void onViewDetachedFromWindow(View v) {
        removeListener();
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public void removeListener() {
        ViewTreeObserver mViewTreeObserver;
        if (this.mViewTreeObserver.isAlive()) {
            this.mViewTreeObserver.removeOnPreDrawListener(this);
        } else {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.mView.removeOnAttachStateChangeListener(this);
    }
}
