package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* loaded from: classes.dex */
public abstract class u6 extends ViewDataBinding {

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
    protected Boolean Y;
    protected u6(Object object, View view2, int i3, View view4, TextView textView5, ImageView imageView6, TextView textView7, ImageView imageView8, TextView textView9, TextView textView10, LinearLayout linearLayout11, ImageView imageView12, CardView cardView13, ImageView imageView14, TextView textView15, Button button16, ImageView imageView17, TextView textView18, ImageView imageView19, View view20, View view21, TextView textView22, Guideline guideline23) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = textView5;
        obj.P = textView7;
        obj.Q = textView9;
        obj.R = linearLayout11;
        obj.S = cardView13;
        obj.T = imageView14;
        obj.U = textView15;
        obj.V = button16;
        obj.W = textView18;
    }
}
