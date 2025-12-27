package app.dogo.com.dogo_android.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements MediaPlayer.OnCompletionListener {

    public final /* synthetic */ MediaPlayer.OnCompletionListener a;
    public final /* synthetic */ i b;
    public /* synthetic */ a(MediaPlayer.OnCompletionListener list, i iVar) {
        super();
        this.a = list;
        this.b = iVar;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        ClickerSoundPlayer.n(this.a, this.b, mediaPlayer);
    }
}
