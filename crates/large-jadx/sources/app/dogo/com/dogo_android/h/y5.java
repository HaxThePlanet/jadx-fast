package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* loaded from: classes.dex */
public abstract class y5 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected TrickItem Q;
    protected y5(Object object, View view2, int i3, ImageView imageView4, TextView textView5) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.y5 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return y5.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.y5 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (y5)ViewDataBinding.z(layoutInflater, 2131558536, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
