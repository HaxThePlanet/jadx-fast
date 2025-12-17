package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* loaded from: classes.dex */
public abstract class a8 extends ViewDataBinding {

    public final CardView O;
    public final TextView P;
    public final TextView Q;
    public final ImageView R;
    protected TrickItem S;
    protected a8(Object object, View view2, int i3, CardView cardView4, TextView textView5, TextView textView6, ImageView imageView7) {
        super(object, view2, i3);
        this.O = cardView4;
        this.P = textView5;
        this.Q = textView6;
        this.R = imageView7;
    }

    public static app.dogo.com.dogo_android.h.a8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return a8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.a8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (a8)ViewDataBinding.z(layoutInflater, 2131558564, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
