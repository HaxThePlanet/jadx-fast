package app.dogo.com.dogo_android.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* loaded from: classes.dex */
public final class a implements MediaPlayer.OnCompletionListener {

    public final MediaPlayer.OnCompletionListener a;
    public final app.dogo.com.dogo_android.util.i b;
    public a(MediaPlayer.OnCompletionListener mediaPlayer$OnCompletionListener, app.dogo.com.dogo_android.util.i i2) {
        super();
        this.a = onCompletionListener;
        this.b = i2;
    }

    @Override // android.media.MediaPlayer$OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        i.e(this.a, this.b, mediaPlayer);
    }
}
