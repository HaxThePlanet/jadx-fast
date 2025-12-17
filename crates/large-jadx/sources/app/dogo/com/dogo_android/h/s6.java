package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* loaded from: classes.dex */
public abstract class s6 extends ViewDataBinding {

    public final CardView O;
    public final ImageView P;
    public final TextView Q;
    public final Button R;
    public final TextView S;
    public final TextView T;
    protected ProgramDescriptionItem U;
    protected s6(Object object, View view2, int i3, TextView textView4, ImageView imageView5, ImageView imageView6, CardView cardView7, CardView cardView8, ImageView imageView9, TextView textView10, TextView textView11, Button button12, ImageView imageView13, TextView textView14, TextView textView15, TextView textView16) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = cardView7;
        obj.P = imageView9;
        obj.Q = textView10;
        obj.R = button12;
        obj.S = textView14;
        obj.T = textView16;
    }

    public static app.dogo.com.dogo_android.h.s6 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return s6.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.s6 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (s6)ViewDataBinding.z(layoutInflater, 2131558546, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramDescriptionItem programDescriptionItem);
}
