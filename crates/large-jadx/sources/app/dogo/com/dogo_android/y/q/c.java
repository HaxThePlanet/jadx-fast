package app.dogo.com.dogo_android.y.q;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.MediaController;

/* loaded from: classes.dex */
public final class c implements MediaPlayer.OnPreparedListener {

    public final app.dogo.com.dogo_android.y.q.d a;
    public final MediaController b;
    public c(app.dogo.com.dogo_android.y.q.d d, MediaController mediaController2) {
        super();
        this.a = d;
        this.b = mediaController2;
    }

    @Override // android.media.MediaPlayer$OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.a.i2(this.b, mediaPlayer);
    }
}
