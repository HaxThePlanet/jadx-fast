package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.util.customview.ArcProgressBar;
import app.dogo.com.dogo_android.x.b.d;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class wg extends ViewDataBinding {

    public final ArcProgressBar O;
    public final TextView P;
    public final MaterialButton Q;
    public final ImageView R;
    public final TextView S;
    public final TextView T;
    protected d U;
    protected wg(Object object, View view2, int i3, ArcProgressBar arcProgressBar4, TextView textView5, TextView textView6, MaterialButton materialButton7, ImageView imageView8, TextView textView9, TextView textView10, ImageView imageView11) {
        super(object, view2, i3);
        this.O = arcProgressBar4;
        this.P = textView6;
        this.Q = materialButton7;
        this.R = imageView8;
        this.S = textView9;
        this.T = textView10;
    }

    public static app.dogo.com.dogo_android.h.wg T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return wg.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.wg U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (wg)ViewDataBinding.z(layoutInflater, 2131558718, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d d);
}
