package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* loaded from: classes5.dex */
@Deprecated
public final class GestureDetectorCompat {

    private final GestureDetector mDetector;
    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener listener) {
        super(context, listener, 0);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener listener, Handler handler) {
        super();
        GestureDetector gestureDetector = new GestureDetector(context, listener, handler);
        this.mDetector = gestureDetector;
    }

    public boolean isLongpressEnabled() {
        return this.mDetector.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent event) {
        return this.mDetector.onTouchEvent(event);
    }

    public void setIsLongpressEnabled(boolean enabled) {
        this.mDetector.setIsLongpressEnabled(enabled);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener listener) {
        this.mDetector.setOnDoubleTapListener(listener);
    }
}
