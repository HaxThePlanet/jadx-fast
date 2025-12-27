package app.dogo.com.dogo_android.util.f0;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.MediaController;
import android.widget.VideoView;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f implements MediaPlayer.OnPreparedListener {

    public final /* synthetic */ VideoView a;
    public final /* synthetic */ MediaController b;
    public /* synthetic */ f(VideoView videoView, MediaController mediaController) {
        super();
        this.a = videoView;
        this.b = mediaController;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        BindingAdapters.q0(this.a, this.b, mediaPlayer);
    }
}
