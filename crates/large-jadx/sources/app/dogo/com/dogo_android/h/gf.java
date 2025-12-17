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

/* loaded from: classes.dex */
public abstract class gf extends ViewDataBinding {

    public final KonfettiView O;
    public final TextView P;
    public final Button Q;
    public final ImageView R;
    protected gf(Object object, View view2, int i3, ImageView imageView4, KonfettiView konfettiView5, TextView textView6, Button button7, ImageView imageView8, TextView textView9) {
        super(object, view2, i3);
        this.O = konfettiView5;
        this.P = textView6;
        this.Q = button7;
        this.R = imageView8;
    }

    public static app.dogo.com.dogo_android.h.gf T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return gf.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.gf U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (gf)ViewDataBinding.z(layoutInflater, 2131558697, viewGroup2, z3, object4);
    }
}
