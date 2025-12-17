package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.WelcomeSlide;

/* loaded from: classes.dex */
public abstract class y7 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final TextView Q;
    protected WelcomeSlide R;
    protected y7(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, TextView textView5, TextView textView6, TextView textView7, AppCompatImageView appCompatImageView8) {
        super(object, view2, i3);
        this.O = textView5;
        this.P = textView6;
        this.Q = textView7;
    }

    public static app.dogo.com.dogo_android.h.y7 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return y7.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.y7 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (y7)ViewDataBinding.z(layoutInflater, 2131558563, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(WelcomeSlide welcomeSlide);
}
