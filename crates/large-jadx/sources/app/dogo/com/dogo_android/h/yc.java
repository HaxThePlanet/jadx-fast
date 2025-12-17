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
import app.dogo.com.dogo_android.exam.i;
import app.dogo.com.dogo_android.exam.j.i;
import com.google.android.material.button.MaterialButton;

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
    protected i Y;
    protected i Z;
    protected yc(Object object, View view2, int i3, ImageButton imageButton4, FrameLayout frameLayout5, MaterialButton materialButton6, FrameLayout frameLayout7, Button button8, ImageView imageView9, ProgressBar progressBar10, LinearLayout linearLayout11, AppCompatTextView appCompatTextView12, TextureView textureView13) {
        super(object, view2, i3);
        this.O = imageButton4;
        this.P = frameLayout5;
        this.Q = materialButton6;
        this.R = frameLayout7;
        this.S = button8;
        this.T = imageView9;
        this.U = progressBar10;
        this.V = linearLayout11;
        this.W = appCompatTextView12;
        this.X = textureView13;
    }

    public static app.dogo.com.dogo_android.h.yc T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return yc.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.yc U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (yc)ViewDataBinding.z(layoutInflater, 2131558666, viewGroup2, z3, object4);
    }
}
