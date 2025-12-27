package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.x;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* compiled from: LayoutDashboardRecommendedProgramCardV2Binding.java */
/* loaded from: classes.dex */
public abstract class mj extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final LinearLayout R;
    public final CardView S;
    public final ImageView T;
    public final TextView U;
    public final Button V;
    public final TextView W;
    protected ProgramDescriptionItem X;
    protected x Y;
    protected mj(Object object, View view, int i, View view2, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, LinearLayout linearLayout, ImageView imageView3, CardView cardView, ImageView imageView4, TextView textView5, Button button, ImageView imageView5, TextView textView6, ImageView imageView6, View view3, View view4, TextView textView7, Guideline guideline) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = textView;
        object2.P = textView2;
        object2.Q = textView3;
        object2.R = linearLayout;
        object2.S = cardView;
        object2.T = imageView4;
        object2.U = textView5;
        object2.V = button;
        object2.W = textView6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(x xVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramDescriptionItem programDescriptionItem);
}
