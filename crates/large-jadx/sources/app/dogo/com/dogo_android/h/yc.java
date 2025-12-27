package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentExamVideoPlaybackBinding.java */
/* loaded from: classes.dex */
public abstract class yc extends ViewDataBinding {

    public final ImageButton O;
    public final FrameLayout P;
    public final MaterialButton Q;
    public final FrameLayout R;
    public final Button S;
    public final ImageView T;
    public final ProgressBar U;
    public final LinearLayout V;
    public final AppCompatTextView W;
    public final TextureView X;
    protected app.dogo.com.dogo_android.exam.j.i Y;
    protected app.dogo.com.dogo_android.exam.i Z;
    protected yc(Object object, View view, int i, ImageButton imageButton, FrameLayout frameLayout, MaterialButton materialButton, FrameLayout frameLayout2, Button button, ImageView imageView, ProgressBar progressBar, LinearLayout linearLayout, AppCompatTextView appCompatTextView, TextureView textureView) {
        super(object, view, i);
        this.O = imageButton;
        this.P = frameLayout;
        this.Q = materialButton;
        this.R = frameLayout2;
        this.S = button;
        this.T = imageView;
        this.U = progressBar;
        this.V = linearLayout;
        this.W = appCompatTextView;
        this.X = textureView;
    }

    public static yc T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return yc.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static yc U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (yc)ViewDataBinding.z(layoutInflater, 2131558666, viewGroup, z, object);
    }
}
