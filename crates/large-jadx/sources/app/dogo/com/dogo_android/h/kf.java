package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.t.d;
import nl.dionsegijn.konfetti.KonfettiView;

/* loaded from: classes.dex */
public abstract class kf extends ViewDataBinding {

    public final Button O;
    public final ImageView P;
    public final TextView Q;
    public final KonfettiView R;
    protected d S;
    protected kf(Object object, View view2, int i3, ImageView imageView4, Button button5, ImageView imageView6, TextView textView7, TextView textView8, KonfettiView konfettiView9) {
        super(object, view2, i3);
        this.O = button5;
        this.P = imageView6;
        this.Q = textView8;
        this.R = konfettiView9;
    }

    public static app.dogo.com.dogo_android.h.kf T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return kf.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.kf U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (kf)ViewDataBinding.z(layoutInflater, 2131558699, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d d);
}
