package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* loaded from: classes.dex */
public abstract class y extends ViewDataBinding {

    public final TextView O;
    protected TrickItem P;
    protected y(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, TextView textView6) {
        super(object, view2, i3);
        this.O = textView6;
    }

    public static app.dogo.com.dogo_android.h.y T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return y.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.y U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (y)ViewDataBinding.z(layoutInflater, 2131558456, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
