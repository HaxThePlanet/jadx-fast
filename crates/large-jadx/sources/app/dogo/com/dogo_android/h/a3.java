package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.view.compat.ChipGroupWithState;

/* loaded from: classes.dex */
public abstract class a3 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    public final TextView Q;
    public final ChipGroupWithState R;
    public final TextView S;
    protected Article T;
    protected a3(Object object, View view2, int i3, ImageView imageView4, TextView textView5, TextView textView6, ImageView imageView7, Barrier barrier8, CardView cardView9, ChipGroupWithState chipGroupWithState10, TextView textView11, HorizontalScrollView horizontalScrollView12) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = textView5;
        this.Q = textView6;
        this.R = chipGroupWithState10;
        this.S = textView11;
    }

    public static app.dogo.com.dogo_android.h.a3 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return a3.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.a3 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (a3)ViewDataBinding.z(layoutInflater, 2131558498, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Article article);
}
