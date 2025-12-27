package app.dogo.com.dogo_android.exam.k;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements MediaRecorder.OnErrorListener {

    public final /* synthetic */ i a;
    public /* synthetic */ c(i iVar) {
        super();
        this.a = iVar;
    }

    public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
        ExamRecordFragment.a2(this.a, mediaRecorder, i, i2);
    }
}
