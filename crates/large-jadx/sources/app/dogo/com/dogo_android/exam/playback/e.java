package app.dogo.com.dogo_android.exam.j;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class e implements MediaPlayer.OnErrorListener {

    public final /* synthetic */ g a;
    public /* synthetic */ e(g gVar) {
        super();
        this.a = gVar;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return ExamPlaybackFragment.M1(this.a, mediaPlayer, i, i2);
    }
}
