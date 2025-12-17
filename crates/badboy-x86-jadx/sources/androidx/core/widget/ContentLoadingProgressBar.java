package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes5.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;
    public static void $r8$lambda$-QLbnDmeB_t0R62xLMJCkjyagZI(androidx.core.widget.ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.showOnUiThread();
    }

    public static void $r8$lambda$LzWHroRwziRn4m5pH-wlpZWokBw(androidx.core.widget.ContentLoadingProgressBar contentLoadingProgressBar) {
        contentLoadingProgressBar.hideOnUiThread();
    }

    public ContentLoadingProgressBar(Context context) {
        super(context, 0);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attrs) {
        int i = 0;
        super(context, attrs, i);
        this.mStartTime = -1;
        this.mPostedHide = i;
        this.mPostedShow = i;
        this.mDismissed = i;
        ContentLoadingProgressBar$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ContentLoadingProgressBar$$ExternalSyntheticLambda0(this);
        this.mDelayedHide = externalSyntheticLambda0;
        ContentLoadingProgressBar$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ContentLoadingProgressBar$$ExternalSyntheticLambda1(this);
        this.mDelayedShow = externalSyntheticLambda1;
    }

    private void hideOnUiThread() {
        int i;
        int i3;
        int mDelayedHide;
        int i2;
        i = 1;
        this.mDismissed = i;
        removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        currentTimeMillis -= mStartTime;
        i3 = 500;
        if (Long.compare(i5, i3) < 0) {
            if (Long.compare(mStartTime2, i2) == 0) {
                setVisibility(8);
            } else {
                if (!this.mPostedHide) {
                    postDelayed(this.mDelayedHide, i3 -= i5);
                    this.mPostedHide = i;
                }
            }
        } else {
        }
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    private void showOnUiThread() {
        boolean mPostedShow;
        Runnable mDelayedHide;
        this.mStartTime = -1;
        int i2 = 0;
        this.mDismissed = i2;
        removeCallbacks(this.mDelayedHide);
        this.mPostedHide = i2;
        if (!this.mPostedShow) {
            postDelayed(this.mDelayedShow, 500);
            this.mPostedShow = true;
        }
    }

    @Override // android.widget.ProgressBar
    public void hide() {
        ContentLoadingProgressBar$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new ContentLoadingProgressBar$$ExternalSyntheticLambda3(this);
        post(externalSyntheticLambda3);
    }

    @Override // android.widget.ProgressBar
    void lambda$new$0$androidx-core-widget-ContentLoadingProgressBar() {
        this.mPostedHide = false;
        this.mStartTime = -1;
        setVisibility(8);
    }

    @Override // android.widget.ProgressBar
    void lambda$new$1$androidx-core-widget-ContentLoadingProgressBar() {
        boolean currentTimeMillis;
        final int i = 0;
        this.mPostedShow = i;
        if (!this.mDismissed) {
            this.mStartTime = System.currentTimeMillis();
            setVisibility(i);
        }
    }

    @Override // android.widget.ProgressBar
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar
    public void show() {
        ContentLoadingProgressBar$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new ContentLoadingProgressBar$$ExternalSyntheticLambda2(this);
        post(externalSyntheticLambda2);
    }
}
