package androidx.core.view.insets;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat.Callback;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes5.dex */
class SystemBarStateMonitor {

    private final ArrayList<androidx.core.view.insets.SystemBarStateMonitor.Callback> mCallbacks;
    private int mColorHint = 0;
    private final View mDetector;
    private Insets mInsets;
    private Insets mInsetsIgnoringVisibility;

    interface Callback {
        public abstract void onAnimationEnd();

        public abstract void onAnimationProgress(int i, Insets insets2, RectF rectF3);

        public abstract void onAnimationStart();

        public abstract void onColorHintChanged(int i);

        public abstract void onInsetsChanged(Insets insets, Insets insets2);
    }
    SystemBarStateMonitor(ViewGroup rootView) {
        super();
        ArrayList arrayList = new ArrayList();
        this.mCallbacks = arrayList;
        this.mInsets = Insets.NONE;
        this.mInsetsIgnoringVisibility = Insets.NONE;
        android.graphics.drawable.Drawable background = rootView.getBackground();
        final int i2 = 0;
        if (background instanceof ColorDrawable) {
            int color = (ColorDrawable)background.getColor();
        }
        int i = i2;
        SystemBarStateMonitor.1 anon = new SystemBarStateMonitor.1(this, rootView.getContext(), rootView);
        this.mDetector = anon;
        this.mDetector.setWillNotDraw(true);
        SystemBarStateMonitor$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SystemBarStateMonitor$$ExternalSyntheticLambda0(this);
        ViewCompat.setOnApplyWindowInsetsListener(this.mDetector, externalSyntheticLambda0);
        SystemBarStateMonitor.2 anon2 = new SystemBarStateMonitor.2(this, i2);
        ViewCompat.setWindowInsetsAnimationCallback(this.mDetector, anon2);
        rootView.addView(this.mDetector, i2);
    }

    static int access$000(androidx.core.view.insets.SystemBarStateMonitor x0) {
        return x0.mColorHint;
    }

    static int access$002(androidx.core.view.insets.SystemBarStateMonitor x0, int x1) {
        x0.mColorHint = x1;
        return x1;
    }

    static ArrayList access$100(androidx.core.view.insets.SystemBarStateMonitor x0) {
        return x0.mCallbacks;
    }

    static Insets access$200(androidx.core.view.insets.SystemBarStateMonitor x0, WindowInsetsCompat x1) {
        return x0.getInsets(x1);
    }

    private Insets getInsets(WindowInsetsCompat w) {
        return Insets.min(w.getInsets(WindowInsetsCompat.Type.systemBars()), w.getInsets(WindowInsetsCompat.Type.tappableElement()));
    }

    private Insets getInsetsIgnoringVisibility(WindowInsetsCompat w) {
        return Insets.min(w.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars()), w.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement()));
    }

    void addCallback(androidx.core.view.insets.SystemBarStateMonitor.Callback callback) {
        if (this.mCallbacks.contains(callback)) {
        }
        this.mCallbacks.add(callback);
        callback.onInsetsChanged(this.mInsets, this.mInsetsIgnoringVisibility);
        callback.onColorHintChanged(this.mColorHint);
    }

    void detachFromWindow() {
        SystemBarStateMonitor$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new SystemBarStateMonitor$$ExternalSyntheticLambda1(this);
        this.mDetector.post(externalSyntheticLambda1);
    }

    boolean hasCallback() {
        return empty ^= 1;
    }

    void lambda$detachFromWindow$1$androidx-core-view-insets-SystemBarStateMonitor() {
        boolean z;
        View mDetector;
        android.view.ViewParent parent = this.mDetector.getParent();
        if (parent instanceof ViewGroup) {
            (ViewGroup)parent.removeView(this.mDetector);
        }
    }

    WindowInsetsCompat lambda$new$0$androidx-core-view-insets-SystemBarStateMonitor(View view, WindowInsetsCompat windowInsets) {
        boolean i;
        Object obj;
        final Insets insets = getInsets(windowInsets);
        final Insets insetsIgnoringVisibility = getInsetsIgnoringVisibility(windowInsets);
        if (insets.equals(this.mInsets)) {
            if (!insetsIgnoringVisibility.equals(this.mInsetsIgnoringVisibility)) {
                this.mInsets = insets;
                this.mInsetsIgnoringVisibility = insetsIgnoringVisibility;
                size--;
                while (i >= 0) {
                    (SystemBarStateMonitor.Callback)this.mCallbacks.get(i).onInsetsChanged(insets, insetsIgnoringVisibility);
                    i--;
                }
            }
        } else {
        }
        return windowInsets;
    }

    void removeCallback(androidx.core.view.insets.SystemBarStateMonitor.Callback callback) {
        this.mCallbacks.remove(callback);
    }
}
