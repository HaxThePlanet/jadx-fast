package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* loaded from: classes.dex */
public abstract class c4 extends ViewDataBinding {

    public final CardView O;
    public final ImageView P;
    public final TextView Q;
    protected ProgramDescriptionItem R;
    protected c4(Object object, View view2, int i3, TextView textView4, CardView cardView5, ImageView imageView6, TextView textView7, Guideline guideline8) {
        super(object, view2, i3);
        this.O = cardView5;
        this.P = imageView6;
        this.Q = textView7;
    }

    public static app.dogo.com.dogo_android.h.c4 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return c4.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.c4 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (c4)ViewDataBinding.z(layoutInflater, 2131558512, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramDescriptionItem programDescriptionItem);
}
