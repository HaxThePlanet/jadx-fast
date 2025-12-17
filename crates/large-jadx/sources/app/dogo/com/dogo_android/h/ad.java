package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.exam.VideoRecordingButton;
import app.dogo.com.dogo_android.exam.k.h;
import app.dogo.com.dogo_android.exam.k.k;

/* loaded from: classes.dex */
public abstract class ad extends ViewDataBinding {

    public final TextureView O;
    public final ImageButton P;
    public final AppCompatTextView Q;
    public final VideoRecordingButton R;
    public final ConstraintLayout S;
    public final FrameLayout T;
    public final ImageButton U;
    protected k V;
    protected h W;
    protected ad(Object object, View view2, int i3, TextureView textureView4, ImageButton imageButton5, AppCompatTextView appCompatTextView6, VideoRecordingButton videoRecordingButton7, ProgressBar progressBar8, ConstraintLayout constraintLayout9, FrameLayout frameLayout10, ImageButton imageButton11) {
        super(object, view2, i3);
        this.O = textureView4;
        this.P = imageButton5;
        this.Q = appCompatTextView6;
        this.R = videoRecordingButton7;
        this.S = constraintLayout9;
        this.T = frameLayout10;
        this.U = imageButton11;
    }

    public static app.dogo.com.dogo_android.h.ad T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ad.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ad U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ad)ViewDataBinding.z(layoutInflater, 2131558667, viewGroup2, z3, object4);
    }
}
