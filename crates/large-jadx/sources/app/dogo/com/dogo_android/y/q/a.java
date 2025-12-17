package app.dogo.com.dogo_android.y.q;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;

/* loaded from: classes.dex */
public final class a implements MediaPlayer.OnInfoListener {

    public final app.dogo.com.dogo_android.y.q.d a;
    public a(app.dogo.com.dogo_android.y.q.d d) {
        super();
        this.a = d;
    }

    @Override // android.media.MediaPlayer$OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        return this.a.g2(mediaPlayer, i2, i3);
    }
}
