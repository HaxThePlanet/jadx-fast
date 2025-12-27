package app.dogo.com.dogo_android.exam.j;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements MediaPlayer.OnPreparedListener {

    public final /* synthetic */ g a;
    public /* synthetic */ a(g gVar) {
        super();
        this.a = gVar;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        ExamPlaybackFragment.N1(this.a, mediaPlayer);
    }
}
