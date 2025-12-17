package app.dogo.com.dogo_android.util.f0;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.MediaController;
import android.widget.VideoView;

/* loaded from: classes.dex */
public final class f implements MediaPlayer.OnPreparedListener {

    public final VideoView a;
    public final MediaController b;
    public f(VideoView videoView, MediaController mediaController2) {
        super();
        this.a = videoView;
        this.b = mediaController2;
    }

    @Override // android.media.MediaPlayer$OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        n.p(this.a, this.b, mediaPlayer);
    }
}
