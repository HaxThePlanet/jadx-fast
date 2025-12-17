package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengePagerCardItem;

/* loaded from: classes.dex */
public abstract class qn extends ViewDataBinding {

    public final CardView O;
    public final TextView P;
    public final ImageView Q;
    public final TextView R;
    public final TextView S;
    protected ChallengePagerCardItem T;
    protected qn(Object object, View view2, int i3, CardView cardView4, TextView textView5, ImageView imageView6, TextView textView7, TextView textView8) {
        super(object, view2, i3);
        this.O = cardView4;
        this.P = textView5;
        this.Q = imageView6;
        this.R = textView7;
        this.S = textView8;
    }

    public static app.dogo.com.dogo_android.h.qn T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return qn.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.qn U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (qn)ViewDataBinding.z(layoutInflater, 2131558891, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ChallengePagerCardItem challengePagerCardItem);
}
