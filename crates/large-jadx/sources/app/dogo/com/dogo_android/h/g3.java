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
public abstract class g3 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    protected TrickItem R;
    protected g3(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, TextView textView6) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = imageView5;
        this.Q = textView6;
    }

    public static app.dogo.com.dogo_android.h.g3 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return g3.V(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.g3 V(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (g3)ViewDataBinding.z(layoutInflater, 2131558501, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public TrickItem T() {
        return this.R;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrickItem trickItem);
}
