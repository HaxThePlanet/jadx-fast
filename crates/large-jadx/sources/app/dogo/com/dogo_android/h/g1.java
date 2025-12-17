package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.CustomerExperience;

/* loaded from: classes.dex */
public abstract class g1 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final TextView P;
    public final TextView Q;
    protected CustomerExperience R;
    protected g1(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, TextView textView5, AppCompatImageView appCompatImageView6, AppCompatImageView appCompatImageView7, AppCompatImageView appCompatImageView8, AppCompatImageView appCompatImageView9, AppCompatImageView appCompatImageView10, TextView textView11) {
        super(object, view2, i3);
        this.O = appCompatImageView4;
        this.P = textView5;
        this.Q = textView11;
    }

    public static app.dogo.com.dogo_android.h.g1 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return g1.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.g1 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (g1)ViewDataBinding.z(layoutInflater, 2131558474, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(CustomerExperience customerExperience);
}
