package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.y.b0.e;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import nl.dionsegijn.konfetti.KonfettiView;

/* loaded from: classes.dex */
public abstract class yf extends ViewDataBinding {

    public final TextView O;
    public final MaterialButton P;
    public final KonfettiView Q;
    public final ConstraintLayout R;
    public final WebView S;
    public final TextView T;
    public final MaterialToolbar U;
    protected e V;
    protected yf(Object object, View view2, int i3, TextView textView4, CardView cardView5, ImageView imageView6, MaterialButton materialButton7, KonfettiView konfettiView8, ConstraintLayout constraintLayout9, WebView webView10, TextView textView11, TextView textView12, MaterialToolbar materialToolbar13) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = materialButton7;
        this.Q = konfettiView8;
        this.R = constraintLayout9;
        this.S = webView10;
        this.T = textView11;
        this.U = materialToolbar13;
    }

    public static app.dogo.com.dogo_android.h.yf T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return yf.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.yf U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (yf)ViewDataBinding.z(layoutInflater, 2131558706, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}
