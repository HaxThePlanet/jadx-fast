package app.dogo.com.dogo_android.exam;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnTouchListener {

    public final /* synthetic */ VideoRecordingButton a;
    public /* synthetic */ b(VideoRecordingButton videoRecordingButton) {
        super();
        this.a = videoRecordingButton;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return VideoRecordingButton.e(this.a, view, motionEvent);
    }
}
