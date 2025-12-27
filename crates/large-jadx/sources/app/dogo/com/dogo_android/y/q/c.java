package app.dogo.com.dogo_android.y.q;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.MediaController;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements MediaPlayer.OnPreparedListener {

    public final /* synthetic */ d a;
    public final /* synthetic */ MediaController b;
    public /* synthetic */ c(d dVar, MediaController mediaController) {
        super();
        this.a = dVar;
        this.b = mediaController;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.a.i2(this.b, mediaPlayer);
    }
}
