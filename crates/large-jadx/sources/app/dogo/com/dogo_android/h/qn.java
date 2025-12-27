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

/* compiled from: PageEntryChallengeItemBinding.java */
/* loaded from: classes.dex */
public abstract class qn extends ViewDataBinding {

    public final CardView O;
    public final TextView P;
    public final ImageView Q;
    public final TextView R;
    public final TextView S;
    protected ChallengePagerCardItem T;
    protected qn(Object object, View view, int i, CardView cardView, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = cardView;
        this.P = textView;
        this.Q = imageView;
        this.R = textView2;
        this.S = textView3;
    }

    public static qn T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return qn.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static qn U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (qn)ViewDataBinding.z(layoutInflater, 2131558891, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ChallengePagerCardItem challengePagerCardItem);
}
