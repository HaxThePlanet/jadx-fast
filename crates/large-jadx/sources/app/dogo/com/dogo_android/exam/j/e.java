package app.dogo.com.dogo_android.exam.j;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* loaded from: classes.dex */
public final class e implements MediaPlayer.OnErrorListener {

    public final app.dogo.com.dogo_android.exam.j.g a;
    public e(app.dogo.com.dogo_android.exam.j.g g) {
        super();
        this.a = g;
    }

    @Override // android.media.MediaPlayer$OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return g.S1(this.a, mediaPlayer, i2, i3);
    }
}
