package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import nl.dionsegijn.konfetti.KonfettiView;

/* compiled from: FragmentProgramExamsCompletedBinding.java */
/* loaded from: classes.dex */
public abstract class gf extends ViewDataBinding {

    public final KonfettiView O;
    public final TextView P;
    public final Button Q;
    public final ImageView R;
    protected gf(Object object, View view, int i, ImageView imageView, KonfettiView konfettiView, TextView textView, Button button, ImageView imageView2, TextView textView2) {
        super(object, view, i);
        this.O = konfettiView;
        this.P = textView;
        this.Q = button;
        this.R = imageView2;
    }

    public static gf T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return gf.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static gf U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (gf)ViewDataBinding.z(layoutInflater, 2131558697, viewGroup, z, object);
    }
}
