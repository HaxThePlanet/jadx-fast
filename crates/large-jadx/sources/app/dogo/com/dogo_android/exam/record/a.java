package app.dogo.com.dogo_android.exam.k;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements MediaRecorder.OnInfoListener {

    public final /* synthetic */ i a;
    public /* synthetic */ a(i iVar) {
        super();
        this.a = iVar;
    }

    public final void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        ExamRecordFragment.b2(this.a, mediaRecorder, i, i2);
    }
}
