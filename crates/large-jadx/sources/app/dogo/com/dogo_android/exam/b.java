package app.dogo.com.dogo_android.exam;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* loaded from: classes.dex */
public final class b implements View.OnTouchListener {

    public final app.dogo.com.dogo_android.exam.VideoRecordingButton a;
    public b(app.dogo.com.dogo_android.exam.VideoRecordingButton videoRecordingButton) {
        super();
        this.a = videoRecordingButton;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent2) {
        return VideoRecordingButton.f(this.a, view, motionEvent2);
    }
}
