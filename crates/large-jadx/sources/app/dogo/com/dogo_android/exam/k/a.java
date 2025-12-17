package app.dogo.com.dogo_android.exam.k;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;

/* loaded from: classes.dex */
public final class a implements MediaRecorder.OnInfoListener {

    public final app.dogo.com.dogo_android.exam.k.i a;
    public a(app.dogo.com.dogo_android.exam.k.i i) {
        super();
        this.a = i;
    }

    @Override // android.media.MediaRecorder$OnInfoListener
    public final void onInfo(MediaRecorder mediaRecorder, int i2, int i3) {
        i.e2(this.a, mediaRecorder, i2, i3);
    }
}
