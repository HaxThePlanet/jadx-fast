package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.f.n.e;
import com.airbnb.lottie.LottieAnimationView;

/* loaded from: classes.dex */
public abstract class sa extends ViewDataBinding {

    public final Button O;
    public final Button P;
    protected e Q;
    protected sa(Object object, View view2, int i3, TextView textView4, LottieAnimationView lottieAnimationView5, Button button6, TextView textView7, Button button8) {
        super(object, view2, i3);
        this.O = button6;
        this.P = button8;
    }

    public static app.dogo.com.dogo_android.h.sa T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return sa.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.sa U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (sa)ViewDataBinding.z(layoutInflater, 2131558637, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}
