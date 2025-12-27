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

/* compiled from: FragmentExamVideoRecordingBinding.java */
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
    protected ad(Object object, View view, int i, TextureView textureView, ImageButton imageButton, AppCompatTextView appCompatTextView, VideoRecordingButton videoRecordingButton, ProgressBar progressBar, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageButton imageButton2) {
        super(object, view, i);
        this.O = textureView;
        this.P = imageButton;
        this.Q = appCompatTextView;
        this.R = videoRecordingButton;
        this.S = constraintLayout;
        this.T = frameLayout;
        this.U = imageButton2;
    }

    public static ad T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ad.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ad U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ad)ViewDataBinding.z(layoutInflater, 2131558667, viewGroup, z, object);
    }
}
