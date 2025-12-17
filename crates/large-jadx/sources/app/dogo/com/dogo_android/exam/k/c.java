package app.dogo.com.dogo_android.exam.k;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;

/* loaded from: classes.dex */
public final class c implements MediaRecorder.OnErrorListener {

    public final app.dogo.com.dogo_android.exam.k.i a;
    public c(app.dogo.com.dogo_android.exam.k.i i) {
        super();
        this.a = i;
    }

    @Override // android.media.MediaRecorder$OnErrorListener
    public final void onError(MediaRecorder mediaRecorder, int i2, int i3) {
        i.g2(this.a, mediaRecorder, i2, i3);
    }
}
