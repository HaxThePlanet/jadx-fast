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

/* loaded from: classes.dex */
public class d extends x {

    private app.dogo.com.dogo_android.y.q.e y;
    private w9 z;
    private void d2(View view) {
        a0 obj1;
        if (G1() != null) {
            G1().onBackPressed();
        }
    }

    private boolean f2(MediaPlayer mediaPlayer, int i2, int i3) {
        int obj1 = 1;
        if (i2 == 3) {
            c2();
            return obj1;
        }
        if (i2 == 702) {
            c2();
            return obj1;
        }
        return 0;
    }

    private void h2(MediaController mediaController, MediaPlayer mediaPlayer2) {
        final int i = 1;
        mediaPlayer2.setLooping(i);
        obj3.Q.setMediaController(mediaController);
        mediaController.setAnchorView(obj3.Q);
        obj3.Q.start();
        mediaController.setEnabled(i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public q D1() {
        return j.VIDEO_EXAM_PLAYBACK;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public k3 H1() {
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public String I1() {
        return super.I1();
    }

    public Class<? extends r> K1() {
        return e.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public cn b2() {
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void c2() {
        w9Var.P.setVisibility(8);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void e2(View view) {
        d2(view);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public boolean g2(MediaPlayer mediaPlayer, int i2, int i3) {
        return f2(mediaPlayer, i2, i3);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void i2(MediaController mediaController, MediaPlayer mediaPlayer2) {
        h2(mediaController, mediaPlayer2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void j2() {
        w9Var.P.setVisibility(0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        boolean obj1;
        this.y = (e)J1();
        obj1 = w9.T(layoutInflater, viewGroup2, false);
        this.z = obj1;
        obj1.W(this.y);
        this.z.V(G1());
        b obj2 = new b(this);
        obj1.O.setOnClickListener(obj2);
        this.y.y(getArguments());
        j2();
        if (!this.y.x()) {
            G1().u();
        }
        obj2.Q.setVideoURI(Uri.parse(this.y.w()));
        obj1 = new MediaController(getContext());
        obj2.Q.requestFocus();
        a obj3 = new a(this);
        obj2.Q.setOnInfoListener(obj3);
        obj3 = new c(this, obj1);
        obj2.Q.setOnPreparedListener(obj3);
        return this.z.w();
    }
}
