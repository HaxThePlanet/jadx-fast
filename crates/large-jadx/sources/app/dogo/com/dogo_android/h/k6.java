package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* loaded from: classes.dex */
public abstract class k6 extends ViewDataBinding {

    public final AppCompatImageView O;
    public final ImageView P;
    public final TextView Q;
    public final AppCompatImageView R;
    protected TrickItem S;
    protected k6(Object object, View view2, int i3, View view4, AppCompatImageView appCompatImageView5, ImageView imageView6, TextView textView7, AppCompatImageView appCompatImageView8) {
        super(object, view2, i3);
        this.O = appCompatImageView5;
        this.P = imageView6;
        this.Q = textView7;
        this.R = appCompatImageView8;
    }

    public static app.dogo.com.dogo_android.h.k6 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return k6.V(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.k6 V(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (k6)ViewDataBinding.z(layoutInflater, 2131558542, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public TrickItem T() {
        return this.S;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrickItem trickItem);
}
