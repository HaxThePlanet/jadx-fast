package app.dogo.com.dogo_android.y.q;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.w9;
import app.dogo.com.dogo_android.k.j;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.util.e0.x;
import app.dogo.com.dogo_android.w.k3;

/* compiled from: VideoPlaybackDialog.java */
/* loaded from: classes.dex */
public class d extends x {

    private e y;
    private w9 z;
    private /* synthetic */ void d2(View view) {
        if (G1() != null) {
            G1().onBackPressed();
        }
    }

    private /* synthetic */ boolean f2(MediaPlayer mediaPlayer, int i, int i2) {
        boolean z = true;
        if (i == 3) {
            c2();
            return true;
        }
        if (i == 702) {
            c2();
            return true;
        }
        return false;
    }

    private /* synthetic */ void h2(MediaController mediaController, MediaPlayer mediaPlayer) {
        final boolean z = true;
        mediaPlayer.setLooping(z);
        this.z.Q.setMediaController(mediaController);
        mediaController.setAnchorView(this.z.Q);
        this.z.Q.start();
        mediaController.setEnabled(z);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public q D1() {
        return FullScreenTag.VIDEO_EXAM_PLAYBACK;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public String I1() {
        return super.I1();
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public Class<? extends r> K1() {
        return e.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void c2() {
        this.z.P.setVisibility(8);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void j2() {
        this.z.P.setVisibility(0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.y = (e)J1();
        w9 w9Var = w9.T(layoutInflater, viewGroup, false);
        this.z = w9Var;
        w9Var.W(this.y);
        this.z.V(G1());
        this.z.O.setOnClickListener(new b(this));
        this.y.y(getArguments());
        j2();
        if (!this.y.x()) {
            G1().u();
        }
        this.z.Q.setVideoURI(Uri.parse(this.y.w()));
        this.z.Q.requestFocus();
        this.z.Q.setOnInfoListener(new a(this));
        this.z.Q.setOnPreparedListener(new c(this, new MediaController(getContext())));
        return this.z.w();
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public k3 H1() {
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public cn b2() {
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public /* synthetic */ void e2(View view) {
        d2(view);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public /* synthetic */ boolean g2(MediaPlayer mediaPlayer, int i, int i2) {
        return f2(mediaPlayer, i, i2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public /* synthetic */ void i2(MediaController mediaController, MediaPlayer mediaPlayer) {
        h2(mediaController, mediaPlayer);
    }
}
