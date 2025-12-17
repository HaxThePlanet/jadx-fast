package app.dogo.com.dogo_android.exam.j;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

/* loaded from: classes.dex */
public final class a implements MediaPlayer.OnPreparedListener {

    public final app.dogo.com.dogo_android.exam.j.g a;
    public a(app.dogo.com.dogo_android.exam.j.g g) {
        super();
        this.a = g;
    }

    @Override // android.media.MediaPlayer$OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        g.O1(this.a, mediaPlayer);
    }
}
